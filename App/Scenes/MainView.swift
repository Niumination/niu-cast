import SwiftUI

struct MainView: View {
    var body: some View {
        NavigationSplitView {
            List {
                Text("No devices connected")
                    .foregroundStyle(.secondary)
            }
            .navigationTitle("NIU CAST")
            .toolbar {
                ToolbarItem {
                    Button("Refresh") {
                        // TODO: Refresh device list
                    }
                }
            }
        } detail: {
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
        .frame(minWidth: 700, minHeight: 400)
    }
}

#Preview {
    MainView()
}
