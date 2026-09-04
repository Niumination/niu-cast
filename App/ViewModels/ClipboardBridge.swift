import Foundation
import AppKit

/// Two-way clipboard sync between Mac and Android
public class ClipboardBridge {
    private var lastClipboardContent: String?
    private var timer: Timer?
    private var onClipboardChanged: ((String) -> Void)?
    
    public init() {}
    
    /// Start monitoring clipboard changes
    public func startMonitoring(callback: @escaping (String) -> Void) {
        onClipboardChanged = callback
        timer = Timer.scheduledTimer(withTimeInterval: 0.5, repeats: true) { _ in
            self.checkClipboard()
        }
    }
    
    /// Stop monitoring
    public func stopMonitoring() {
        timer?.invalidate()
        timer = nil
    }
    
    /// Set Mac clipboard content
    public func setMacClipboard(_ text: String) {
        NSPasteboard.general.clearContents()
        NSPasteboard.general.setString(text, forType: .string)
        lastClipboardContent = text
    }
    
    /// Get Mac clipboard content
    public func getMacClipboard() -> String? {
        return NSPasteboard.general.string(forType: .string)
    }
    
    /// Push clipboard to Android via ADB
    public func pushToAndroid(_ text: String, serial: String, adbPath: String = "/usr/local/bin/adb") {
        // Use adb shell to set clipboard on Android
        let escaped = text.replacingOccurrences(of: "'", with: "'\\''")
        let command = "am broadcast -a clipper.set -e text '\(escaped)'"
        // TODO: Execute via ADBKit
    }
    
    /// Pull clipboard from Android via ADB
    public func pullFromAndroid(serial: String, adbPath: String = "/usr/local/bin/adb") -> String? {
        // Use adb shell to get clipboard from Android
        let command = "am broadcast -a clipper.get"
        // TODO: Execute via ADBKit and parse response
        return nil
    }
    
    private func checkClipboard() {
        guard let current = getMacClipboard(), current != lastClipboardContent else { return }
        lastClipboardContent = current
        onClipboardChanged?(current)
    }
}
