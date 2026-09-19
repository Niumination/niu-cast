import Foundation
import ArgumentParser
import TCCPKit
import Logging

extension NIUCastCommand {
    struct Server: AsyncParsableCommand {
        static var configuration = CommandConfiguration(
            commandName: "server",
            abstract: "Start TCCP server for Joy Connect"
        )
        
        @Option(name: .shortAndLong, help: "TCCP port")
        var port: Int = 9452
        
        @Option(name: .shortAndLong, help: "mDNS service name")
        var name: String = "NIU-CAST-Mac"
        
        @Flag(name: .shortAndLong, help: "Register mDNS service")
        var mdns = false
        
        mutating func run() async throws {
            let logger = Logger(label: "niu-cast.server")
            
            let tccpPort = TCCPPort(rawValue: port) ?? .tccp
            let server = TCCPServer(port: tccpPort)
            
            logger.info("Starting TCCP server on port \(port)...")
            logger.info("Service name: \(name)")
            
            if mdns {
                logger.info("mDNS registration not yet implemented in Swift version")
            }
            
            print("TCCP Server starting on port \(port)")
            print("Press Ctrl+C to stop")
            
            try await server.start()
            
            // Keep running until cancelled
            try await Task.sleep(nanoseconds: .max)
        }
    }
}
