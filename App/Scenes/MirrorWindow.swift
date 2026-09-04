import SwiftUI
import MetalKit
import MirrorEngine

struct MirrorWindow: View {
    let device: ADBDevice
    @StateObject private var viewModel = MirrorViewModel()
    
    var body: some View {
        VStack(spacing: 0) {
            // Toolbar
            HStack {
                Text(device.model ?? "Android Device")
                    .font(.headline)
                Spacer()
                Button("Close") {
                    viewModel.stopSession()
                }
            }
            .padding()
            .background(.ultraThinMaterial)
            
            // Video surface
            VideoSurfaceView(engine: viewModel.engine)
                .frame(maxWidth: .infinity, maxHeight: .infinity)
        }
        .onAppear {
            viewModel.startSession(device: device)
        }
        .onDisappear {
            viewModel.stopSession()
        }
    }
}

struct VideoSurfaceView: NSViewRepresentable {
    let engine: MirrorEngine?
    
    func makeNSView(context: Context) -> MTKView {
        let view = MTKView()
        view.device = MTLCreateSystemDefaultDevice()
        view.colorPixelFormat = .bgra8Unorm
        view.framebufferOnly = false
        view.preferredFramesPerSecond = 60
        view.delegate = engine
        return view
    }
    
    func updateNSView(_ nsView: MTKView, context: Context) {}
}

@MainActor
class MirrorViewModel: ObservableObject {
    @Published var isConnected = false
    @Published var error: String?
    
    var engine: MirrorEngine?
    private var coordinator: FusionEngine?
    
    func startSession(device: ADBDevice) {
        Task {
            do {
                engine = MirrorEngine()
                coordinator = FusionEngine()
                try await coordinator?.startSession(serial: device.serial)
                isConnected = true
            } catch {
                self.error = error.localizedDescription
            }
        }
    }
    
    func stopSession() {
        Task {
            try? await coordinator?.stopSession()
            isConnected = false
        }
    }
}
