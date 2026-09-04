import Foundation
import SharedModels
import ADBKit
import ScrcpyClient
import MirrorEngine

/// Orchestrates ADB + scrcpy + mirror session
public actor FusionEngine {
    private let adb: ADBKit
    private let scrcpy: ScrcpyClient
    private var engine: MirrorEngine?
    private var isRunning = false
    
    public init() {
        self.adb = ADBKit()
        self.scrcpy = ScrcpyClient()
    }
    
    /// Start mirror session for device
    public func startSession(serial: String) async throws {
        guard !isRunning else { return }
        
        // Start scrcpy server on device
        try await scrcpy.startServer(serial: serial)
        
        // Forward video port (default 27183)
        try await scrcpy.forwardPort(localPort: 27183, devicePort: 27183, serial: serial)
        
        // Forward control port (default 27184)
        try await scrcpy.forwardPort(localPort: 27184, devicePort: 27184, serial: serial)
        
        // Connect to video socket
        try await scrcpy.connectVideoSocket(port: 27183)
        
        // Connect to control socket
        try await scrcpy.connectControlSocket(port: 27184)
        
        // Initialize mirror engine
        if let mirrorEngine = MirrorEngine() {
            engine = mirrorEngine
        }
        
        isRunning = true
    }
    
    /// Stop mirror session
    public func stopSession() async throws {
        guard isRunning else { return }
        
        try await scrcpy.stopServer()
        engine = nil
        isRunning = false
    }
    
    /// Get mirror engine for rendering
    public func getEngine() -> MirrorEngine? {
        return engine
    }
    
    /// Check if session is running
    public func isSessionRunning() -> Bool {
        return isRunning
    }
}
