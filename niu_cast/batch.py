#!/usr/bin/env python3
"""
╔══════════════════════════════════════════════════════════════════════════════╗
║                        NIU CAST - BATCH EXECUTOR                            ║
║                    Automation & Scripting Tool                              ║
╚══════════════════════════════════════════════════════════════════════════════╝
"""

import os
import sys
import subprocess
import json
import yaml

class BatchExecutor:
    """Execute batch commands from files or text"""
    
    def __init__(self):
        self.adb_path = 'adb'
        self.device = None
        self.results = []
    
    def run(self, command):
        """Execute single command"""
        if isinstance(command, str):
            return self._run_shell(command)
        elif isinstance(command, dict):
            action = command.get('action', 'shell')
            
            if action == 'shell':
                return self._run_shell(command.get('command', ''))
            elif action == 'wait':
                return self._wait(command.get('seconds', 1))
            elif action == 'repeat':
                return self._repeat(command)
            elif action == 'screenshot':
                return self._screenshot(command.get('path'))
            elif action == 'record':
                return self._record_screen(command)
            elif action == 'install':
                return self._install(command.get('apk'))
            elif action == 'keyevent':
                return self._run_shell(f"input keyevent {command.get('key')}")
            elif action == 'tap':
                x, y = command.get('x', 0), command.get('y', 0)
                return self._run_shell(f"input tap {x} {y}")
            elif action == 'swipe':
                x1, y1 = command.get('x1', 0), command.get('y1', 0)
                x2, y2 = command.get('x2', 0), command.get('y2', 0)
                dur = command.get('duration', 300)
                return self._run_shell(f"input swipe {x1} {y1} {x2} {y2} {dur}")
        
        return False
    
    def _run_shell(self, cmd):
        """Run shell command via ADB"""
        if self.device:
            full_cmd = [self.adb_path, '-s', self.device, 'shell', cmd]
        else:
            full_cmd = [self.adb_path, 'shell', cmd]
        
        try:
            result = subprocess.run(full_cmd, capture_output=True, text=True, timeout=30)
            success = result.returncode == 0
            self.results.append({
                'command': cmd,
                'success': success,
                'output': result.stdout[:200] if result.stdout else '',
                'error': result.stderr[:200] if result.stderr else ''
            })
            return success
        except Exception as e:
            self.results.append({'command': cmd, 'success': False, 'error': str(e)})
            return False
    
    def _wait(self, seconds):
        """Wait for specified seconds"""
        import time
        time.sleep(seconds)
        self.results.append({'action': 'wait', 'seconds': seconds, 'success': True})
        return True
    
    def _repeat(self, command):
        """Repeat command multiple times"""
        times = command.get('times', 1)
        interval = command.get('interval', 0)
        cmd = command.get('command')
        
        for i in range(times):
            self._run_shell(cmd)
            if interval > 0 and i < times - 1:
                self._wait(interval)
        
        return True
    
    def _screenshot(self, path=None):
        """Take screenshot"""
        import datetime
        timestamp = datetime.datetime.now().strftime("%Y%m%d_%H%M%S")
        path = path or f'/tmp/niu_screenshot_{timestamp}.png'
        
        self._run_shell('screencap -p /sdcard/.niu_batch_screenshot.png')
        
        if self.device:
            pull_cmd = [self.adb_path, '-s', self.device, 'pull', '/sdcard/.niu_batch_screenshot.png', path]
        else:
            pull_cmd = [self.adb_path, 'pull', '/sdcard/.niu_batch_screenshot.png', path]
        
        result = subprocess.run(pull_cmd, capture_output=True, text=True)
        
        self.results.append({
            'action': 'screenshot',
            'path': path,
            'success': result.returncode == 0
        })
        
        return result.returncode == 0
    
    def _record_screen(self, command):
        """Record screen"""
        import datetime
        duration = command.get('duration', 30)
        path = command.get('path', f'/tmp/niu_recording_{datetime.datetime.now().strftime("%Y%m%d_%H%M%S")}.mp4')
        
        self._run_shell(f'screenrecord --time-limit {duration} /sdcard/.niu_batch_recording.mp4')
        
        if self.device:
            pull_cmd = [self.adb_path, '-s', self.device, 'pull', '/sdcard/.niu_batch_recording.mp4', path]
        else:
            pull_cmd = [self.adb_path, 'pull', '/sdcard/.niu_batch_recording.mp4', path]
        
        result = subprocess.run(pull_cmd, capture_output=True, text=True)
        
        self.results.append({
            'action': 'record',
            'path': path,
            'success': result.returncode == 0
        })
        
        return result.returncode == 0
    
    def _install(self, apk_path):
        """Install APK"""
        if not apk_path or not os.path.exists(apk_path):
            self.results.append({'action': 'install', 'success': False, 'error': 'APK not found'})
            return False
        
        if self.device:
            cmd = [self.adb_path, '-s', self.device, 'install', '-r', apk_path]
        else:
            cmd = [self.adb_path, 'install', '-r', apk_path]
        
        result = subprocess.run(cmd, capture_output=True, text=True, timeout=300)
        
        self.results.append({
            'action': 'install',
            'apk': apk_path,
            'success': result.returncode == 0,
            'output': result.stdout[:200]
        })
        
        return result.returncode == 0
    
    def execute_file(self, file_path):
        """Execute commands from file"""
        with open(file_path, 'r') as f:
            if file_path.endswith(('.yaml', '.yml')):
                commands = yaml.safe_load(f)
            elif file_path.endswith('.json'):
                commands = json.load(f)
            else:
                return self.execute_text(f.read())
        
        if isinstance(commands, list):
            for cmd in commands:
                self.run(cmd)
        elif isinstance(commands, dict):
            if 'commands' in commands:
                for cmd in commands['commands']:
                    self.run(cmd)
    
    def execute_text(self, text):
        """Execute commands from text (one per line)"""
        for line in text.splitlines():
            line = line.strip()
            if line and not line.startswith('#'):
                self.run(line)
    
    def report(self):
        """Print execution report"""
        print("\n" + "="*60)
        print("BATCH EXECUTION REPORT")
        print("="*60)
        
        success = sum(1 for r in self.results if r.get('success'))
        failed = sum(1 for r in self.results if not r.get('success'))
        
        for i, result in enumerate(self.results, 1):
            status = "✓" if result.get('success') else "✗"
            
            if 'command' in result:
                print(f"\n[{i}] {status} {result['command']}")
            elif 'action' in result:
                print(f"\n[{i}] {status} {result['action']}")
            
            if result.get('output'):
                print(f"    Output: {result['output'][:100]}")
            if result.get('error'):
                print(f"    Error: {result['error']}")
        
        print("\n" + "-"*60)
        print(f"Total: {len(self.results)} | Success: {success} | Failed: {failed}")
        print("="*60)


def main():
    import argparse
    
    parser = argparse.ArgumentParser(description='NiuCast Batch Executor')
    parser.add_argument('script', nargs='?', help='Script file to execute')
    parser.add_argument('--text', help='Execute commands from text')
    parser.add_argument('--device', help='Target device serial')
    parser.add_argument('--report', action='store_true', help='Show report')
    parser.add_argument('--create-example', help='Create example script')
    
    args = parser.parse_args()
    
    executor = BatchExecutor()
    executor.device = args.device
    
    # Auto-detect device
    if not executor.device:
        result = subprocess.run(['adb', 'devices'], capture_output=True, text=True)
        lines = result.stdout.splitlines()
        if len(lines) > 1 and 'device' in lines[1]:
            executor.device = lines[1].split()[0]
    
    if args.create_example:
        ext = args.create_example.split('.')[-1]
        
        if ext in ('yaml', 'yml'):
            content = """# NiuCast Batch Script Example
name: "Example Automation"
description: "Sample batch script"

commands:
  - action: shell
    command: "input keyevent KEYCODE_HOME"
  
  - action: wait
    seconds: 1
  
  - action: shell
    command: "am start -a android.settings.SETTINGS"
  
  - action: wait
    seconds: 2
  
  - action: screenshot
    path: "/tmp/example_screen.png"
  
  - action: tap
    x: 540
    y: 960
  
  - action: swipe
    x1: 540
    y1: 1800
    x2: 540
    y2: 200
    duration: 500
"""
        elif ext == 'json':
            content = """{
  "name": "Example Automation",
  "commands": [
    {"action": "shell", "command": "input keyevent KEYCODE_HOME"},
    {"action": "wait", "seconds": 1},
    {"action": "shell", "command": "am start -a android.settings.SETTINGS"},
    {"action": "wait", "seconds": 2},
    {"action": "screenshot", "path": "/tmp/example_screen.png"},
    {"action": "tap", "x": 540, "y": 960},
    {"action": "swipe", "x1": 540, "y1": 1800, "x2": 540, "y2": 200, "duration": 500}
  ]
}"""
        else:
            content = """# NiuCast Batch Script (Plain Text)
# One command per line, # for comments

input keyevent KEYCODE_HOME
wait 1
am start -a android.settings.SETTINGS
wait 2
screenshot /tmp/example_screen.png
input tap 540 960
input swipe 540 1800 540 200 500
"""
        
        with open(args.create_example, 'w') as f:
            f.write(content)
        print(f"Created example script: {args.create_example}")
        return
    
    if args.text:
        executor.execute_text(args.text)
    elif args.script:
        executor.execute_file(args.script)
    else:
        # Interactive mode
        print("NiuCast Batch Executor")
        print("Enter commands (one per line)")
        print("Actions: shell, wait, screenshot, tap, swipe, install, record")
        print("Type 'quit' to exit, 'report' to show results")
        print()
        
        commands = []
        while True:
            line = input("> ").strip()
            
            if line == 'quit':
                break
            elif line == 'report':
                executor.report()
            elif line == '':
                break
            elif line.startswith('#'):
                continue
            else:
                commands.append(line)
        
        for cmd in commands:
            executor.run(cmd)
    
    if args.report or not args.script:
        executor.report()


if __name__ == '__main__':
    main()