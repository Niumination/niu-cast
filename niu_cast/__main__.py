"""
NIU CAST — CLI entry point for `python3 -m niu_cast`

Routes to either the GUI (default) or CLI based on arguments.
"""
import sys

if __name__ == "__main__":
    if len(sys.argv) > 1:
        cmd = sys.argv[1]
        
        if cmd in ('auto-connect', 'connect', 'scan', 'discover', 'monitor'):
            from .auto_connect import main as auto_main
            # Hapus subcommand dari argv
            sys.argv = [sys.argv[0]] + sys.argv[2:]
            # Map niu-cast connect → auto_connect --monitor
            if cmd == 'monitor' and '--monitor' not in sys.argv:
                sys.argv.insert(2, '--monitor')
            if cmd in ('connect', 'auto-connect') and '--monitor' not in sys.argv:
                # Default behavior: auto-connect once
                pass
            if cmd == 'discover':
                if '--list-mdns' not in sys.argv:
                    sys.argv.insert(2, '--list-mdns')
            if cmd == 'scan' and '--scan-subnet' not in sys.argv and '--list-mdns' not in sys.argv:
                sys.argv.insert(2, '--scan-subnet')
            sys.exit(auto_main())
        
        elif cmd in ('wifi-direct', 'wfd', 'p2p'):
            from .wfd_bridge import main as wfd_main
            sys.argv = [sys.argv[0]] + sys.argv[2:]
            sys.exit(wfd_main())
        
        elif cmd == 'tetherd':
            from .tetherd import main as tetherd_main
            sys.argv = [sys.argv[0]] + sys.argv[2:]
            sys.exit(tetherd_main())
        
        elif cmd in ('video-stream', 'stream'):
            from .video_stream import main as video_main
            sys.argv = [sys.argv[0]] + sys.argv[2:]
            sys.exit(video_main())
        
        elif cmd in ('port-explore', 'probe'):
            from .port_explorer import main as port_main
            sys.argv = [sys.argv[0]] + sys.argv[2:]
            sys.exit(port_main())
        
        elif cmd == 'test':
            # Run all integration tests
            from .video_stream import run_all_tests
            run_all_tests()
            sys.exit(0)
        
        elif cmd == 'server':
            from .tccp_server import main as server_main
            # Hapus 'server' dari argv biar argparse gak bingung
            sys.argv = [sys.argv[0]] + sys.argv[2:]
            sys.exit(server_main())
        
        elif cmd in ('server-8613', 'server8613', 'joyconnect'):
            from .server_8613 import main as server_8613_main
            sys.argv = [sys.argv[0]] + sys.argv[2:]
            sys.exit(server_8613_main())
        
        elif cmd == 'qr':
            from .tccp_qr import main as qr_main
            sys.argv = [sys.argv[0]] + sys.argv[2:]
            sys.exit(qr_main())
        
        else:
            from .mini import main as cli_main
            sys.exit(cli_main())
    else:
        # No args → try GUI, fall back to CLI help
        try:
            from .core import main as gui_main
            gui_main()
        except ImportError:
            from .mini import main as cli_main
            sys.exit(cli_main())
