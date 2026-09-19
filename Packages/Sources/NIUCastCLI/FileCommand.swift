import Foundation
import ArgumentParser
import ADBKit
import SharedModels
import Logging

extension NIUCastCommand {
    struct File: AsyncParsableCommand {
        static var configuration = CommandConfiguration(
            commandName: "file",
            abstract: "File operations on Android device"
        )
        
        @Option(name: .shortAndLong, help: "Device serial number")
        var serial: String?
        
        @Option(name: .shortAndLong, help: "Remote path on device")
        var path: String?
        
        @Option(name: .shortAndLong, help: "Local file path")
        var local: String?
        
        @Flag(name: .shortAndLong, help: "List files")
        var list = false
        
        @Flag(name: .shortAndLong, help: "Push file to device")
        var push = false
        
        @Flag(name: .shortAndLong, help: "Pull file from device")
        var pull = false
        
        @Flag(name: .shortAndLong, help: "Delete file on device")
        var delete = false
        
        mutating func run() async throws {
            let logger = Logger(label: "niu-cast.file")
            
            guard let serial = serial else {
                logger.error("Please provide --serial")
                return
            }
            
            let filesVM = FilesViewModel()
            
            if list {
                let path = path ?? "/sdcard"
                await filesVM.listFiles(path: path, serial: serial)
                for file in filesVM.files {
                    let type = file.isDirectory ? "d" : "-"
                    print("\(type) \(file.name)")
                }
            } else if push {
                guard let local = local, let path = path else {
                    logger.error("Please provide --local and --path")
                    return
                }
                try await filesVM.pushFile(localPath: local, remotePath: path, serial: serial)
                print("File pushed successfully")
            } else if pull {
                guard let path = path, let local = local else {
                    logger.error("Please provide --path and --local")
                    return
                }
                try await filesVM.pullFile(remotePath: path, localPath: local, serial: serial)
                print("File pulled successfully")
            } else if delete {
                guard let path = path else {
                    logger.error("Please provide --path")
                    return
                }
                try await filesVM.deleteFile(path: path, serial: serial)
                print("File deleted successfully")
            }
        }
    }
}
