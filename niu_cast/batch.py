#!/usr/bin/env python3
"""
╔══════════════════════════════════════════════════════════════════════════════╗
║                   NIU CAST - BATCH EXECUTOR                              ║
║                                                                            ║
║  Execute multiple ADB commands automatically                               ║
║  Perfect for automation dan testing                                        ║
╚══════════════════════════════════════════════════════════════════════════════╝
"""

import os
import sys
import subprocess
import json
import yaml

class BatchExecutor:
    def __init__(self):
        self.adb_path = 'adb'
        self.device = None
        self.results = []
        
    def run(self, command):
        """Execute single command"""
        if isinstance(command, str):
            # Direct shell command
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
            elif action == 'install':
                return self._install(command.get('apk'))
        return False
    
    def _run_shell(self, cmd):
        """Run shell command"""
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
                'output': result.stdout,
                'error': result.stderr
            })
            return success
        except Exception as e:
            self.results.append({
                'command': cmd,
                'success': False,
                'error': str(e)
            })
            return False
    
    def _wait(self, seconds):
        """Wait for specified seconds"""
        import time
        time.sleep(seconds)
        self.results.append({'action': 'wait', 'seconds': seconds})
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
        path = path or f'/tmp/screenshot_{timestamp}.png'
        
        self._run_shell('screencap -p /sdcard/screen.png')
        
        if self.device:
            pull_cmd = [self.adb_path, '-s', self.device, 'pull', '/sdcard/screen.png', path]
        else:
            pull_cmd = [self.adb_path, 'pull', '/sdcard/screen.png', path]
        
        result = subprocess.run(pull_cmd, capture_output=True, text=True)
        
        self.results.append({
            'action': 'screenshot',
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
            'output': result.stdout
        })
        
        return result.returncode == 0
    
    def execute_file(self, file_path):
        """Execute commands from file"""
        with open(file_path, 'r') as f:
            if file_path.endswith('.yaml') or file_path.endswith('.yml'):
                commands = yaml.safe_load(f)
            elif file_path.endswith('.json'):
                commands = json.load(f)
            else:
                # Plain text, one command per line
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
        print("EXECUTION REPORT")
        print("="*60)
        
        success_count = 0
        fail_count = 0
        
        for i, result in enumerate(self.results, 1):
            status = "✓" if result.get('success') else "✗"
            
            if result.get('success'):
                success_count += 1
            else:
                fail_count += 1
            
            if 'command' in result:
                print(f"\n[{i}] {status} {result['command']}")
            elif 'action' in result:
                print(f"\n[{i}] {status} {result['action']}")
            
            if result.get('output'):
                print(f"    Output: {result['output'][:100]}")
            if result.get('error'):
                print(f"    Error: {result['error']}")
        
        print("\n" + "-"*60)
        print(f"Total: {len(self.results)} | Success: {success_count} | Failed: {fail_count}")
        print("="*60)


# ═══════════════════════════════════════════════════════════════════════════════
#                              EXAMPLE SCRIPTS
# ═══════════════════════════════════════════════════════════════════════════════

EXAMPLE_SCRIPT = """# NiuCast Batch Script Example
# Save as .txt, .yaml, or .json

# Unlock device and go to home
input keyevent 82
input keyevent KEYCODE_HOME

# Wait for animations
wait: 1

# Open settings
am start -a android.settings.SETTINGS

# Wait
wait: 2

# Take screenshot
screenshot: ~/Pictures/settings.png

# Navigate
input keyevent KEYCODE_BACK
input keyevent KEYCODE_HOME
"""

EXAMPLE_YAML = """---
name: "Test Automation"
description: "Automated testing script for NiuCast"

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
    path: "/tmp/test_screen.png"
  
  - action: shell
    command: "input keyevent KEYCODE_BACK"
"""

EXAMPLE_JSON = """{
  "name": "App Installation Test",
  "commands": [
    {"action": "shell", "command": "input keyevent KEYCODE_HOME"},
    {"action": "wait", "seconds": 1},
    {"action": "install", "apk": "/path/to/app.apk"},
    {"action": "wait", "seconds": 5},
    {"action": "screenshot", "path": "/tmp/install_result.png"}
  ]
}
"""


def main():
    import argparse
    
    parser = argparse.ArgumentParser(description='NiuCast Batch Executor')
    parser.add_argument('script', nargs='?', help='Script file to execute')
    parser.add_argument('--text', help='Execute commands from text')
    parser.add_argument('--device', help='Target device serial')
    parser.add_argument('--report', action='store_true', help='Show report after execution')
    parser.add_argument('--create-example', help='Create example script file')
    
    args = parser.parse_args()
    
    executor = BatchExecutor()
    executor.device = args.device
    
    # Find device if not specified
    if not executor.device:
        result = subprocess.run(['adb', 'devices'], capture_output=True, text=True)
        lines = result.stdout.splitlines()
        if len(lines) > 1 and 'device' in lines[1]:
            executor.device = lines[1].split()[0]
    
    if args.create_example:
        ext = args.create_example.split('.')[-1]
        if ext == 'yaml' or ext == 'yml':
            content = EXAMPLE_YAML
        elif ext == 'json':
            content = EXAMPLE_JSON
        else:
            content = EXAMPLE_SCRIPT
        
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
        print("Enter commands (one per line, # for comment, empty line to execute)")
        print("Commands: shell <cmd>, wait <sec>, screenshot <path>, install <apk>")
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
                # Execute collected commands
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