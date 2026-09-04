import Foundation

/// VideoToolbox decode + Metal rendering
public struct MirrorEngine {
    public init() {}
    
    /// Decode H.265 video frame
    public func decodeFrame(_ data: Data) async throws {
        // TODO: VideoToolbox decode
    }
    
    /// Render frame to Metal view
    public func render() async throws {
        // TODO: Metal rendering
    }
}
