import Foundation
import ArgumentParser
import SharedModels
import ScrcpyClient
import MirrorEngine
import FusionEngine
import Logging

@MainActor
extension NIUCastCommand {
    struct Mirror: AsyncParsableCommand {
        static var configuration = CommandConfiguration(
            commandName: "mirror",
            abstract: "Screen mirroring via scrcpy"
        )
        
        @Option(name: .shortAndLong, help: "Device serial number")
        var serial: String?
        
        @Flag(name: .shortAndLong, help: "Stop mirroring")
        var stop = false
        
        @Flag(name: .shortAndLong, help: "Show status")
        var status = false
        
        @Option(name: .long, help: "Max FPS (30/60/120)")
        var fps = 60
        
        @Option(name: .long, help: "Video bitrate (Mbps)")
        var bitrate = 8
        
        mutating func run() async throws {
            let logger = Logger(label: "niu-cast.mirror")
            let fusion = FusionEngine()
            
            if stop {
                logger.info("Stopping mirror session...")
                try await fusion.stopSession()
            } else if status {
                print("Session running: \(fusion.isSessionRunning())")
            } else {
                guard let serial = serial else {
                    logger.error("Please provide --serial")
                    return
                }
                logger.info("Starting mirror for \(serial)...")
                try await fusion.startSession(serial: serial)
            }
        }
    }
}
