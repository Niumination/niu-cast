// Shared models used across all packages
import Foundation

/// Represents an Android device discovered via ADB
public struct ADBDevice: Identifiable, Codable, Sendable {
    public let id: String  // serial number
    public let serial: String
    public let state: ConnectionState
    public let model: String?
    public let androidVersion: String?
    
    public enum ConnectionState: String, Codable, Sendable {
        case device       // connected and ready
        case offline      // offline/unauthorized
        case unauthorized // needs USB authorization
    }
    
    public init(
        id: String,
        serial: String,
        state: ConnectionState,
        model: String? = nil,
        androidVersion: String? = nil
    ) {
        self.id = id
        self.serial = serial
        self.state = state
        self.model = model
        self.androidVersion = androidVersion
    }
}

/// Connection method for ADB devices
public enum ConnectionMethod: String, Codable, Sendable {
    case usb
    case wireless
    case pairing  // Android 11+ adb pair
}
