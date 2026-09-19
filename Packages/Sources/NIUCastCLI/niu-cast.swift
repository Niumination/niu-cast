import Foundation
import ArgumentParser
import Logging

@main
struct NIUCastCommand: AsyncParsableCommand {
    static var configuration = CommandConfiguration(
        commandName: "niu-cast",
        abstract: "NIU CAST — Android Device Manager for macOS",
        version: "4.0.0",
        subcommands: [Device.self, Mirror.self, File.self, QR.self, Server.self],
        defaultSubcommand: Device.self
    )
}
