import SwiftUI
import ADBKit

struct PairingSheet: View {
    @Environment(\.dismiss) private var dismiss
    @StateObject private var viewModel = PairingViewModel()
    
    var body: some View {
        NavigationStack {
            Form {
                Section("Pair with Android 11+ Device") {
                    Text("1. On your Android device, go to Developer Options → Wireless Debugging")
                    Text("2. Tap 'Pair with pairing code'")
                    Text("3. Enter the IP, port, and pairing code below")
                        .font(.caption)
                        .foregroundStyle(.secondary)
                }
                
                Section("Connection Details") {
                    HStack {
                        Text("IP Address")
                        TextField("192.168.x.x", text: $viewModel.ipAddress)
                            .textFieldStyle(.roundedBorder)
                    }
                    
                    HStack {
                        Text("Port")
                        TextField("12345", text: $viewModel.port)
                            .textFieldStyle(.roundedBorder)
                    }
                    
                    HStack {
                        Text("Pairing Code")
                        TextField("123456", text: $viewModel.pairingCode)
                            .textFieldStyle(.roundedBorder)
                    }
                }
                
                if let error = viewModel.error {
                    Section {
                        Text(error)
                            .foregroundStyle(.red)
                    }
                }
                
                Section {
                    Button("Pair") {
                        viewModel.pair()
                    }
                    .disabled(!viewModel.canPair)
                    
                    Button("Cancel") {
                        dismiss()
                    }
                }
            }
            .navigationTitle("Pair Device")
            .navigationBarTitleDisplayMode(.inline)
        }
        .frame(width: 400, height: 350)
    }
}

@MainActor
class PairingViewModel: ObservableObject {
    @Published var ipAddress = ""
    @Published var port = ""
    @Published var pairingCode = ""
    @Published var error: String?
    @Published var isPairing = false
    
    var canPair: Bool {
        !ipAddress.isEmpty && !port.isEmpty && !pairingCode.isEmpty && !isPairing
    }
    
    func pair() {
        guard canPair else { return }
        
        isPairing = true
        error = nil
        
        Task {
            do {
                let adb = ADBKit()
                let portInt = Int(port) ?? 0
                let result = try await adb.pair(host: ipAddress, port: portInt, code: pairingCode)
                
                if result.contains("Successfully") {
                    // Now connect to the new port
                    // The device will show a new port after pairing
                    // For now, show success message
                    await MainActor.run {
                        self.isPairing = false
                        // Show success and dismiss
                    }
                } else {
                    await MainActor.run {
                        self.error = "Pairing failed: \(result)"
                        self.isPairing = false
                    }
                }
            } catch {
                await MainActor.run {
                    self.error = error.localizedDescription
                    self.isPairing = false
                }
            }
        }
    }
}

#Preview {
    PairingSheet()
}
