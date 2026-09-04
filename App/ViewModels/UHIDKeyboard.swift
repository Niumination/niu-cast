import Foundation
import IOKit
import IOKit.usb

/// UHID (User-space HID) keyboard implementation
/// Creates virtual USB HID device for low-latency keyboard input
public class UHIDKeyboard {
    private var device: IOHIDDevice?
    private var report: [UInt8] = Array(repeating: 0, count: 8)
    
    /// USB HID Keyboard Report (8 bytes)
    /// [0] = modifier flags (Ctrl/Shift/Alt/Meta)
    /// [1] = reserved
    /// [2-7] = up to 6 simultaneous keycodes
    public struct Report {
        public var modifier: UInt8 = 0
        public var keycodes: [UInt8] = []
        
        public init() {}
        
        public func encode() -> [UInt8] {
            var data = Array(repeating: UInt8(0), count: 8)
            data[0] = modifier
            for (i, key) in keycodes.prefix(6).enumerated() {
                data[2 + i] = key
            }
            return data
        }
    }
    
    /// Modifier key flags
    public enum Modifier: UInt8 {
        case leftControl  = 0x01
        case leftShift    = 0x02
        case leftAlt      = 0x04
        case leftMeta     = 0x08
        case rightControl = 0x10
        case rightShift   = 0x20
        case rightAlt     = 0x40
        case rightMeta    = 0x80
    }
    
    /// USB HID Keycodes (partial list)
    public enum KeyCode: UInt8 {
        case a = 0x04, b, c, d, e, f, g, h, i, j, k, l, m
        case n = 0x11, o, p, q, r, s, t, u, v, w, x, y, z
        case num1 = 0x1e, num2, num3, num4, num5, num6, num7, num8, num9, num0
        case enter = 0x28, escape = 0x29, backspace = 0x2a, tab = 0x2b
        case space = 0x2c, minus = 0x2d, equal = 0x2e
        case leftBracket = 0x2f, rightBracket = 0x30, backslash = 0x31
        case semicolon = 0x33, quote = 0x34, grave = 0x35
        case comma = 0x36, period = 0x37, slash = 0x38
        case capsLock = 0x39
        case f1 = 0x3a, f2, f3, f4, f5, f6, f7, f8, f9, f10, f11, f12
        case printScreen = 0x46, scrollLock = 0x47, pause = 0x48
        case insert = 0x49, home = 0x4a, pageUp = 0x4b
        case delete = 0x4c, end = 0x4d, pageDown = 0x4e
        case right = 0x4f, left = 0x50, down = 0x51, up = 0x52
        case numLock = 0x53
        case keypadSlash = 0x54, keypadAsterisk = 0x55, keypadMinus = 0x56
        case keypadPlus = 0x57, keypadEnter = 0x58
        case keypad1 = 0x59, keypad2, keypad3, keypad4, keypad5
        case keypad6 = 0x5e, keypad7, keypad8, keypad9, keypad0
        case keypadPeriod = 0x63
        case f13 = 0x68, f14, f15, f16, f17, f18, f19, f20, f21, f22, f23, f24
        case leftGUI = 0xe3  // Windows/Command key
    }
    
    public init() {}
    
    /// Send keyboard report
    public func sendReport(_ report: Report) {
        let data = report.encode()
        send(data)
    }
    
    /// Press key with optional modifiers
    public func pressKey(_ key: KeyCode, modifiers: [Modifier] = []) {
        var report = Report()
        report.modifier = modifiers.reduce(0) { $0 | $1.rawValue }
        report.keycodes = [key.rawValue]
        sendReport(report)
    }
    
    /// Release all keys
    public func releaseAll() {
        sendReport(Report())
    }
    
    /// Type a string (basic ASCII)
    public func typeString(_ text: String) {
        for char in text.unicodeScalars {
            if let key = keyForCharacter(char) {
                pressKey(key)
                releaseAll()
            }
        }
    }
    
    private func send(_ data: [UInt8]) {
        // TODO: Send via scrcpy control socket
    }
    
    private func keyForCharacter(_ char: Unicode.Scalar) -> KeyCode? {
        switch char.value {
        case 0x61...0x7a: return KeyCode(rawValue: UInt8(char.value - 0x61) + KeyCode.a.rawValue)  // a-z
        case 0x41...0x5a: return KeyCode(rawValue: UInt8(char.value - 0x41) + KeyCode.a.rawValue)  // A-Z
        case 0x30: return .num0
        case 0x31...0x39: return KeyCode.rawValue(UInt8(char.value - 0x31) + KeyCode.num1.rawValue)
        case 0x20: return .space
        case 0x0a, 0x0d: return .enter
        case 0x09: return .tab
        default: return nil
        }
    }
}
