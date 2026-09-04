import Foundation
import VideoToolbox
import Metal
import MetalKit

/// VideoToolbox H.265 decoder + Metal renderer
public class MirrorEngine: NSObject, MTKViewDelegate {
    private var device: MTLDevice
    private var commandQueue: MTLCommandQueue
    private var pipelineState: MTLRenderPipelineState?
    private var textureCache: CVMetalTextureCache?
    
    private var decompressionSession: VTDecompressionSession?
    private var formatDescription: CMVideoFormatDescription?
    
    public init?() {
        guard let device = MTLCreateSystemDefaultDevice() else { return nil }
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
    
    /// Decode H.265 NAL unit and render to Metal view
    public func decodeAndRender(_ data: Data, to view: MTKView) {
        guard data.count > 0 else { return }
        
        // Create format description if needed
        if formatDescription == nil {
            createFormatDescription()
        }
        
        // Create decompression session if needed
        if decompressionSession == nil {
            createDecompressionSession()
        }
        
        // Decode frame
        decodeFrame(data)
    }
    
    private func createFormatDescription() {
        // H.265 format description from SPS/PPS
        // TODO: Parse from scrcpy server init
    }
    
    private func createDecompressionSession() {
        guard let formatDescription = formatDescription else { return }
        
        let decoderSpecification = [
            kVTVideoDecoderSpecification_EnableHardwareAcceleratedVideoDecoder: true
        ] as CFDictionary
        
        var session: VTDecompressionSession?
        let status = VTDecompressionSessionCreate(
            allocator: nil,
            formatDescription: formatDescription,
            decoderSpecification: decoderSpecification,
            imageBufferAttributes: nil,
            outputCallback: nil,
            decompressionSessionOut: &session
        )
        
        if status == noErr {
            decompressionSession = session
        }
    }
    
    private func decodeFrame(_ data: Data) {
        guard let session = decompressionSession else { return }
        
        // Create block buffer from data
        var blockBuffer: CMBlockBuffer?
        data.withUnsafeBytes { ptr in
            CMBlockBufferCreateWithMemoryBlock(
                allocator: nil,
                memoryBlock: UnsafeMutableRawPointer(mutating: ptr.baseAddress!),
                blockLength: data.count,
                blockAllocator: nil,
                customBlockSource: nil,
                offsetToData: 0,
                dataLength: data.count,
                flags: 0,
                blockBufferOut: &blockBuffer
            )
        }
        
        guard let buffer = blockBuffer else { return }
        
        // Create sample buffer
        var sampleBuffer: CMSampleBuffer?
        var timing = CMSampleTimingInfo(duration: .invalid, presentationTimeStamp: .invalid, decodeTimeStamp: .invalid)
        
        CMSampleBufferCreate(
            allocator: nil,
            dataBuffer: buffer,
            dataReady: true,
            makeDataReadyCallback: nil,
            refcon: nil,
            formatDescription: formatDescription,
            sampleCount: 1,
            sampleTimingEntryCount: 1,
            sampleTimingArray: &timing,
            sampleSizeEntryCount: 0,
            sampleSizeArray: nil,
            sampleBufferOut: &sampleBuffer
        )
        
        guard let sample = sampleBuffer else { return }
        
        // Decode
        VTDecompressionSessionDecodeFrame(
            session,
            sampleBuffer: sample,
            flags: [._EnableAsynchronousDecompression],
            frameRefcon: nil,
            infoFlagsOut: nil
        )
    }
    
    // MARK: - MTKViewDelegate
    
    public func mtkView(_ view: MTKView, drawableSizeWillChange size: CGSize) {
        // Handle resize
    }
    
    public func draw(in view: MTKView) {
        guard let drawable = view.currentDrawable,
              let commandBuffer = commandQueue.makeCommandBuffer(),
              let renderPassDescriptor = view.currentRenderPassDescriptor,
              let pipelineState = pipelineState else { return }
        
        let renderEncoder = commandBuffer.makeRenderCommandEncoder(descriptor: renderPassDescriptor)!
        renderEncoder.setRenderPipelineState(pipelineState)
        // TODO: Set vertex buffer, texture
        renderEncoder.endEncoding()
        
    commandBuffer.present(drawable)
        commandBuffer.commit()
    }
}

// MARK: - Decompression Output Callback

extension MirrorEngine {
    private func decompressionOutputCallback(
        _ decompressionOutput: VTDecompressionOutputRef,
        _ frameRefcon: UnsafeMutableRawPointer?,
        _ status: OSStatus,
        _ infoFlags: VTDecodeInfoFlags,
        _ imageBuffer: CVImageBuffer?,
        _ presentationTimeStamp: CMTime,
        _ presentationDuration: CMTime
    ) {
        guard status == noErr, let imageBuffer = imageBuffer else { return }
        
        // Convert CVImageBuffer to Metal texture and render
        // TODO: Implement texture creation and rendering
    }
}
