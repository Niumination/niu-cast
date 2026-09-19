import Foundation
import VideoToolbox
import Metal
import MetalKit

/// VideoToolbox H.265 decoder + Metal renderer
public class MirrorEngine: NSObject {
    private var device: MTLDevice
    private var commandQueue: MTLCommandQueue
    private var pipelineState: MTLRenderPipelineState?
    private var textureCache: CVMetalTextureCache?
    
    private var decompressionSession: VTDecompressionSession?
    private var formatDescription: CMVideoFormatDescription?
    
    public override init() {
        guard let device = MTLCreateSystemDefaultDevice() else {
            fatalError("Metal not supported")
        }
        self.device = device
        self.commandQueue = device.makeCommandQueue()!
        super.init()
        
        setupMetal()
        createTextureCache()
    }
    
    private func setupMetal() {
        let library = device.makeDefaultLibrary()
        let vertexFunction = library?.makeFunction(name: "vertex_main")
        let fragmentFunction = library?.makeFunction(name: "fragment_main")
        
        let pipelineDescriptor = MTLRenderPipelineDescriptor()
        pipelineDescriptor.vertexFunction = vertexFunction
        pipelineDescriptor.fragmentFunction = fragmentFunction
        pipelineDescriptor.colorAttachments[0].pixelFormat = .bgra8Unorm
        
        do {
            pipelineState = try device.makeRenderPipelineState(descriptor: pipelineDescriptor)
        } catch {
            print("Failed to create pipeline state: \(error)")
        }
    }
    
    private func createTextureCache() {
        CVMetalTextureCacheCreate(nil, nil, device, nil, &textureCache)
    }
    
    /// Decode H.265 NAL unit
    public func decodeFrame(_ data: Data) {
        guard data.count > 0 else { return }
        // TODO: Implement VideoToolbox decode
    }
}

// MARK: - Decompression Output Callback

extension MirrorEngine {
    private func decompressionOutputCallback(
        status: OSStatus,
        infoFlags: VTDecodeInfoFlags,
        imageBuffer: CVImageBuffer?,
        presentationTimeStamp: CMTime,
        presentationDuration: CMTime
    ) {
        guard status == noErr, let imageBuffer = imageBuffer else { return }
        // TODO: Convert CVImageBuffer to Metal texture and render
    }
}
