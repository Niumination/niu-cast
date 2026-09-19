import Foundation
import ArgumentParser
import SharedModels
import ADBKit
import Logging

extension NIUCastCommand {
    struct Device: AsyncParsableCommand {
        static var configuration = CommandConfiguration(
            commandName: "device",
            abstract: "Manage Android devices"
        )
        
        @Flag(name: .shortAndLong, help: "List all devices")
        var list = false
        
        @Option(name: .shortAndLong, help: "Device serial number")
        var serial: String?
        
        @Option(name: .shortAndLong, help: "Connect via TCP/IP (host:port)")
        var connect: String?
        
        @Option(name: .shortAndLong, help: "Pair with device (host:port code)")
        var pair: String?
        
        @Flag(name: .shortAndLong, help: "Put device in TCP/IP mode (USB required)")
        var tcpip = false
        
        @Option(name: .long, help: "TCPIP port (default: 5555)")
        var port = 5555
        
        mutating func run() async throws {
            let logger = Logger(label: "niu-cast.device")
            let adb = ADBKit()
            
            if list || (!tcpip && connect == nil && pair == nil) {
                logger.info("Listing devices...")
                // TODO: implement devices listing
                print("No devices connected")
            } else if tcpip {
                logger.info("Enabling TCP/IP mode on port \(port)...")
                // TODO: implement tcpip mode
            } else if let connect = connect {
                logger.info("Connecting to \(connect)...")
                // TODO: implement connect
            } else if let pair = pair {
                logger.info("Pairing with \(pair)...")
                // TODO: implement pair
            }
        }
    }
}
