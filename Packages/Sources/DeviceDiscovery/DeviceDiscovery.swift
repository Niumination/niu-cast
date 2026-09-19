import Foundation
import Network

/// mDNS/Bonjour device discovery
public class DeviceDiscovery: ObservableObject, @unchecked Sendable {
    @Published public var discoveredDevices: [DiscoveredDevice] = []
    
    private var browser: NWBrowser?
    private var listener: NWListener?
    private let queue = DispatchQueue(label: "device-discovery")
    
    /// Discovered device info
    public struct DiscoveredDevice: Identifiable, Sendable {
        public let id: String
        public let name: String
        public let ipAddress: String
        public let port: Int
        public let type: DeviceType
        
        public enum DeviceType: String, Sendable {
            case adb = "adb"
            case scrcpy = "scrcpy"
            case unknown = "unknown"
        }
    }
    
    public init() {}
    
    /// Start browsing for devices on local network
    public func startBrowsing() {
        // Browse for _adb._tcp services
        let adbParameters = NWParameters()
        adbParameters.includePeerToPeer = true
        
        browser = NWBrowser(for: .bonjour(type: "_adb._tcp", domain: nil), using: adbParameters)
        
        browser?.browseResultsChangedHandler = { [weak self] results, changes in
            self?.handleBrowseResults(results, changes: changes)
        }
        
        browser?.start(queue: queue)
        
        // Also browse for _scrcpy._tcp
        // TODO: Add scrcpy service type
    }
    
    /// Stop browsing
    public func stopBrowsing() {
        browser?.cancel()
        browser = nil
    }
    
    /// Start advertising local ADB service (for debugging)
    public func startAdvertising(name: String = "NIU-CAST-Mac") {
        do {
            let parameters = NWParameters()
            parameters.includePeerToPeer = true
            
            listener = try NWListener(using: parameters, on: 5555)
            listener?.service = NWListener.Service(name: name, type: "_adb._tcp")
            
            listener?.stateUpdateHandler = { state in
                print("Listener state: \(state)")
            }
            
            listener?.start(queue: queue)
        } catch {
            print("Failed to start listener: \(error)")
        }
    }
    
    /// Stop advertising
    public func stopAdvertising() {
        listener?.cancel()
        listener = nil
    }
    
    // MARK: - Private
    
    private func handleBrowseResults(_ results: Set<NWBrowser.Result>, changes: Set<NWBrowser.Result.Change>) {
        Task { @MainActor in
            for result in results {
                switch result.endpoint {
                case .service(let name, let type, let domain, _):
                    if type == "_adb._tcp" {
                        self.resolveService(name: name, domain: domain)
                    }
                default:
                    break
                }
            }
        }
    }
    
    private func resolveService(name: String, domain: String) {
        let endpoint = NWEndpoint.service(name: name, type: "_adb._tcp", domain: domain, interface: nil)
        
        let connection = NWConnection(to: endpoint, using: .tcp)
        connection.stateUpdateHandler = { [weak self] state in
            switch state {
            case .ready:
                if let endpoint = connection.currentPath?.remoteEndpoint,
                   case .hostPort(let host, let port) = endpoint {
                    let ipAddress = host.debugDescription
                    Task { @MainActor in
                        self?.addDiscoveredDevice(
                            name: name,
                            ipAddress: ipAddress,
                            port: Int(port.rawValue)
                        )
                    }
                }
                connection.cancel()
            case .failed(_):
                connection.cancel()
            default:
                break
            }
        }
        connection.start(queue: queue)
    }
    
    private func addDiscoveredDevice(name: String, ipAddress: String, port: Int) {
        let device = DiscoveredDevice(
            id: "\(name)-\(ipAddress)",
            name: name,
            ipAddress: ipAddress,
            port: port,
            type: .adb
        )
        
        // Remove duplicates
        discoveredDevices.removeAll { $0.id == device.id }
        discoveredDevices.append(device)
    }
}
