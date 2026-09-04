import Foundation
import SharedModels

/// Manages scrcpy-server lifecycle and communication
public actor ScrcpyClient {
    private let adbPath: String
    private let serverJarPath: String
    private var serverProcess: Process?
    private var videoSocket: FileHandle?
    private var controlSocket: FileHandle?
    
    public init(adbPath: String = "/usr/local/bin/adb") {
        self.adbPath = adbPath
        self.serverJarPath = Bundle.main.path(forResource: "scrcpy-server", ofType: "jar") ?? ""
    }
    
    /// Push scrcpy-server.jar to device and start it
    public func startServer(serial: String) async throws {
        guard !serverJarPath.isEmpty else {
            throw ScrcpyError.serverNotFound
        }
        
        // Push server jar to device
        let remotePath = "/data/local/tmp/scrcpy-server.jar"
        try await pushFile(local: serverJarPath, remote: remotePath, serial: serial)
        
        // Start server on device
        let command = "CLASSPATH=\(remotePath) app_process / com.genymobile.scrcpy.Server 4.1 tunnel_forward=true audio=false control=true"
        try await runShell(command, serial: serial)
    }
    
    /// Forward local port to device server
    public func forwardPort(localPort: Int, devicePort: Int, serial: String) async throws {
        let args = [adbPath, "-s", serial, "forward", "tcp:\(localPort)", "tcp:\(devicePort)"]
        try await runCommand(args)
    }
    
    /// Connect to video socket
    public func connectVideoSocket(port: Int) async throws {
        // TODO: Connect to localhost:port via TCP socket
    }
    
    /// Connect to control socket
    public func connectControlSocket(port: Int) async throws {
        // TODO: Connect to localhost:port via TCP socket
    }
    
    /// Stop server and cleanup
    public func stopServer() async throws {
        videoSocket?.closeFile()
        controlSocket?.closeFile()
        videoSocket = nil
        controlSocket = nil
    }
    
    // MARK: - Private
    
    private func pushFile(local: String, remote: String, serial: String) async throws {
        let args = [adbPath, "-s", serial, "push", local, remote]
        try await runCommand(args)
    }
    
    private func runShell(_ command: String, serial: String) async throws {
        let args = [adbPath, "-s", serial, "shell", command]
        try await runCommand(args)
    }
    
    private func runCommand(_ args: [String]) async throws {
        // TODO: Implement async process execution
    }
}

public enum ScrcpyError: Error {
    case serverNotFound
    case connectionFailed
    case serverStartFailed
}
