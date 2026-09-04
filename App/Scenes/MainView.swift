import SwiftUI
import SharedModels
import ADBKit
import FusionEngine
import DeviceDiscovery

struct MainView: View {
    @StateObject private var viewModel = DeviceListViewModel()
    @StateObject private var discovery = DeviceDiscovery()
    @State private var selectedDevice: ADBDevice?
    @State private var showingPairing = false
    @State private var showingFiles = false
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
                
                // Discovered devices section
                if !discovery.discoveredDevices.isEmpty {
                    Section("Discovered") {
                        ForEach(discovery.discoveredDevices) { device in
                            DiscoveredDeviceRow(device: device) {
                                // Connect to discovered device
                                connectToDiscovered(device)
                            }
                        }
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
                        showingPairing = true
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
            discovery.startBrowsing()
        }
        .onDisappear {
            discovery.stopBrowsing()
        }
        .sheet(isPresented: $showingPairing) {
            PairingSheet()
        }
    }
    
    private func connectToDiscovered(_ device: DeviceDiscovery.DiscoveredDevice) {
        Task {
            let adb = ADBKit()
            _ = try? await adb.connect(host: device.ipAddress, port: device.port)
            viewModel.refresh()
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

struct DiscoveredDeviceRow: View {
    let device: DeviceDiscovery.DiscoveredDevice
    let onConnect: () -> Void
    
    var body: some View {
        HStack {
            Image(systemName: "wifi")
                .font(.title2)
            VStack(alignment: .leading) {
                Text(device.name)
                    .font(.headline)
                Text("\(device.ipAddress):\(device.port)")
                    .font(.caption)
                    .foregroundStyle(.secondary)
            }
            Spacer()
            Button("Connect") {
                onConnect()
            }
            .buttonStyle(.bordered)
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
    @State private var showingFiles = false
    
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
            
            HStack(spacing: 16) {
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
                
                Button("Files") {
                    showingFiles = true
                }
                .buttonStyle(.bordered)
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
        .sheet(isPresented: $showingFiles) {
            FilesWindow(device: device)
        }
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
