import SwiftUI

struct SettingsView: View {
    var body: some View {
        TabView {
            GeneralSettings()
                .tabItem {
                    Label("General", systemImage: "gear")
                }
            ConnectionSettings()
                .tabItem {
                    Label("Connection", systemImage: "wifi")
                }
        }
        .frame(width: 400, height: 300)
    }
}

struct GeneralSettings: View {
    var body: some View {
        Form {
            Section("Performance") {
                Picker("Max FPS", selection: .constant(60)) {
                    Text("30 FPS").tag(30)
                    Text("60 FPS").tag(60)
                    Text("120 FPS").tag(120)
                }
            }
        }
        .padding()
    }
}

struct ConnectionSettings: View {
    var body: some View {
        Form {
            Section("ADB") {
                HStack {
                    Text("ADB Path")
                    Spacer()
                    Text("/usr/local/bin/adb")
                        .foregroundStyle(.secondary)
                }
            }
        }
        .padding()
    }
}

#Preview {
    SettingsView()
}
