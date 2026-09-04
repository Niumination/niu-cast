import SwiftUI
import SharedModels
import ADBKit
import FusionEngine

struct MainView: View {
    @StateObject private var viewModel = DeviceListViewModel()
    @State private var selectedDevice: ADBDevice?
    @State private var showingMirror = false
    
    var body: some View {
        NavigationSplitView {
            List(selection: $selectedDevice) {
                if viewModel.devices.isEmpty {
                    Text("No devices connected")
                        .foregroundStyle(.secondary)
                } else {
                    ForEach(viewModel.devices) { device in
                        DeviceRow(device: device)
                            .tag(device)
                    }
                }
            }
            .navigationTitle("NIU CAST")
            .toolbar {
                ToolbarItem {
                    Button(action: { viewModel.refresh() }) {
                        Image(systemName: "arrow.clockwise")
                    }
                }
                ToolbarItem {
                    Button("Pair Wi-Fi") {
                        // TODO: Show pairing sheet
                    }
                }
            }
        } detail: {
            if let device = selectedDevice {
                DeviceDetail(device: device) {
                    selectedDevice = nil
                }
            } else {
                EmptyStateView()
            }
        }
        .onAppear {
            viewModel.start()
        }
    }
}

struct DeviceRow: View {
    let device: ADBDevice
    
    var body: some View {
        HStack {
            Image(systemName: "smartphone")
                .font(.title2)
            VStack(alignment: .leading) {
                Text(device.model ?? "Unknown Device")
                    .font(.headline)
                Text(device.serial)
                    .font(.caption)
                    .foregroundStyle(.secondary)
            }
            Spacer()
            StatusDot(state: device.state)
        }
        .padding(.vertical, 4)
    }
}

struct StatusDot: View {
    let state: ADBDevice.ConnectionState
    
    var body: some View {
        Circle()
            .fill(color)
            .frame(width: 10, height: 10)
    }
    
    var color: Color {
        switch state {
        case .device: return .green
        case .offline: return .red
        case .unauthorized: return .orange
        }
    }
}

struct DeviceDetail: View {
    let device: ADBDevice
    let onDismiss: () -> Void
    @StateObject private var coordinator = SessionCoordinator()
    
    var body: some View {
        VStack(spacing: 20) {
            Image(systemName: "smartphone")
                .font(.system(size: 80))
                .foregroundStyle(.secondary)
            
            Text(device.model ?? "Android Device")
                .font(.title)
            
            Text(device.serial)
                .font(.caption)
                .foregroundStyle(.secondary)
            
            if coordinator.isMirroring {
                Button("Stop Mirroring") {
                    coordinator.stop()
                }
                .buttonStyle(.borderedProminent)
            } else {
                Button("Start Mirroring") {
                    coordinator.start(device: device)
                }
                .buttonStyle(.borderedProminent)
            }
            
            if let error = coordinator.error {
                Text(error)
                    .foregroundStyle(.red)
                    .font(.caption)
            }
            
            Spacer()
        }
        .padding()
        .frame(maxWidth: .infinity, maxHeight: .infinity)
    }
}

struct EmptyStateView: View {
    var body: some View {
        VStack {
            Image(systemName: "iphone.and.arrow.forward")
                .font(.system(size: 60))
                .foregroundStyle(.secondary)
            Text("Connect a device to get started")
                .font(.title2)
                .foregroundStyle(.secondary)
            Text("Enable USB debugging on your Android device and connect via USB")
                .font(.caption)
                .foregroundStyle(.tertiary)
        }
    }
}

@MainActor
class DeviceListViewModel: ObservableObject {
    @Published var devices: [ADBDevice] = []
    @Published var error: String?
    
    private let adb = ADBKit()
    private var timer: Timer?
    
    func start() {
        refresh()
        timer = Timer.scheduledTimer(withTimeInterval: 3.0, repeats: true) { _ in
            Task { @MainActor in
                self.refresh()
            }
        }
    }
    
    func refresh() {
        Task {
            do {
                devices = try await adb.devices()
            } catch {
                self.error = error.localizedDescription
            }
        }
    }
}

@MainActor
class SessionCoordinator: ObservableObject {
    @Published var isMirroring = false
    @Published var error: String?
    
    private let fusion = FusionEngine()
    
    func start(device: ADBDevice) {
        Task {
            do {
                try await fusion.startSession(serial: device.serial)
                isMirroring = true
            } catch {
                self.error = error.localizedDescription
            }
        }
    }
    
    func stop() {
        Task {
            try? await fusion.stopSession()
            isMirroring = false
        }
    }
}
