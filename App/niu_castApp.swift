import SwiftUI

@main
struct niu_castApp: App {
    var body: some Scene {
        WindowGroup {
            MainView()
        }
        .windowStyle(.titleBar)
        .windowResizability(.contentSize)
        
        Settings {
            SettingsView()
        }
    }
}
