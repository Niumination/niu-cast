import Foundation
import Network

/// TCCP Server — handles Transsion Cast Control Protocol
public actor TCCPServer {
    private let port: TCCPPort
    private var listener: NWListener?
    private var connections: [NWConnection] = []
    private var messageIdCounter: UInt32 = 8  // After 7 handshake frames
    
    public init(port: TCCPPort = .tccp) {
        self.port = port
    }
    
    /// Start TCCP server
    public func start() async throws {
        let parameters = NWParameters.tcp
        parameters.allowLocalEndpointReuse = true
        
        listener = try NWListener(using: parameters, on: NWEndpoint.Port(integerLiteral: UInt16(port.rawValue)))
        
        listener?.stateUpdateHandler = { state in
            switch state {
            case .ready:
                print("TCCP Server listening on port \(self.port.rawValue)")
            case .failed(let error):
                print("TCCP Server failed: \(error)")
            default:
                break
            }
        }
        
        listener?.newConnectionHandler = { [weak self] connection in
            self?.handleConnection(connection)
        }
        
        listener?.start(queue: .global())
    }
    
    /// Stop server
    public func stop() async {
        listener?.cancel()
        listener = nil
        
        for connection in connections {
            connection.cancel()
        }
        connections.removeAll()
    }
    
    // MARK: - Private
    
    private func handleConnection(_ connection: NWConnection) {
        connections.append(connection)
        let connectionId = connection.endpoint
        
        print("TCCP client connected: \(connectionId)")
        
        // Send 7 initial handshake frames
        sendHandshakeSequence(to: connection)
        
        // Start receiving
        receiveFrames(from: connection)
        
        connection.start(queue: .global())
    }
    
    private func sendHandshakeSequence(to connection: NWConnection) {
        let frames = TCCPFrame.handshakeSequence()
        
        for frame in frames {
            let data = frame.encode()
            connection.send(content: data, completion: .contentProcessed { error in
                if let error = error {
                    print("Send error: \(error)")
                }
            })
        }
    }
    
    private func receiveFrames(from connection: NWConnection) {
        connection.receive(minimumIncompleteLength: 24, maximumLength: 65536) { [weak self] data, _, isComplete, error in
            if let data = data, !data.isEmpty {
                self?.handleReceivedData(data, from: connection)
            }
            
            if isComplete {
                print("TCCP client disconnected: \(connection.endpoint)")
                self?.connections.removeAll { $0 === connection }
            } else if error == nil {
                self?.receiveFrames(from: connection)
            }
        }
    }
    
    private func handleReceivedData(_ data: Data, from connection: NWConnection) {
        guard let frame = TCCPFrame.decode(from: data) else {
            print("Failed to decode TCCP frame")
            return
        }
        
        print("Received TCCP frame: op=\(String(format: "0x%04x", frame.operatorCode.rawValue))")
        
        switch frame.operatorCode {
        case .connAuth:
            // Send AUTH_OK
            let response = TCCPFrame.authOk(messageId: messageIdCounter)
            messageIdCounter += 1
            let responseData = response.encode()
            connection.send(content: responseData, completion: .contentProcessed { _ in })
            
        case .heartbeat:
            // Echo heartbeat back
            let response = TCCPFrame.heartbeat(messageId: messageIdCounter)
            messageIdCounter += 1
            let responseData = response.encode()
            connection.send(content: responseData, completion: .contentProcessed { _ in })
            
        default:
            break
        }
    }
}
