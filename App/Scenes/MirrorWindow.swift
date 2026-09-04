import SwiftUI
import MetalKit
import MirrorEngine
import SharedModels

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
            
            // Video surface with event capture
            ZStack {
                VideoSurfaceView(engine: viewModel.engine)
                    .frame(maxWidth: .infinity, maxHeight: .infinity)
                
                // Transparent event capture overlay
                MirrorEventView(
                    onMouseEvent: { event in
                        viewModel.handleMouseEvent(event)
                    },
                    onKeyboardEvent: { event in
                        viewModel.handleKeyboardEvent(event)
                    }
                )
                .frame(maxWidth: .infinity, maxHeight: .infinity)
            }
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
    private var keyboard = UHIDKeyboard()
    private var clipboard = ClipboardBridge()
    
    func startSession(device: ADBDevice) {
        Task {
            do {
                engine = MirrorEngine()
                coordinator = FusionEngine()
                try await coordinator?.startSession(serial: device.serial)
                isConnected = true
                
                // Start clipboard sync
                clipboard.startMonitoring { [weak self] text in
                    self?.clipboard.pushToAndroid(text, serial: device.serial)
                }
            } catch {
                self.error = error.localizedDescription
            }
        }
    }
    
    func stopSession() {
        Task {
            clipboard.stopMonitoring()
            try? await coordinator?.stopSession()
            isConnected = false
        }
    }
    
    func handleMouseEvent(_ event: MouseEvent) {
        // TODO: Send to Android via scrcpy control socket
    }
    
    func handleKeyboardEvent(_ event: KeyboardEvent) {
        // TODO: Send to Android via UHID
    }
}
