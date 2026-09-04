import Foundation

/// Scrcpy-server management and communication
public struct ScrcpyClient {
    public init() {}
    
    /// Launch scrcpy-server on device
    public func launchServer(serial: String) async throws {
        // TODO: Push scrcpy-server.jar and start via app_process
    }
    
    /// Connect to scrcpy video socket
    public func connectVideoSocket(serial: String) async throws {
        // TODO: Connect to local forwarded socket
    }
}
