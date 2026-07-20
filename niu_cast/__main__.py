"""
NIU CAST — CLI entry point for `python3 -m niu_cast`

Routes to either the GUI (default) or CLI based on arguments.
"""
import sys
from .mini import main as cli_main

if __name__ == "__main__":
    # Check if any CLI args were passed
    if len(sys.argv) > 1:
        sys.exit(cli_main())
    else:
        # No args → try GUI, fall back to CLI help
        try:
            from .core import main as gui_main
            gui_main()
        except ImportError:
            sys.exit(cli_main())
