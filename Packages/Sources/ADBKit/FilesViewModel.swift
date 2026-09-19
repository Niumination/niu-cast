import Foundation

/// File item on Android device
public struct FileItem: Identifiable, Codable, Sendable {
    public let id: String  // full path
    public let name: String
    public let path: String
    public let isDirectory: Bool
    public let size: Int64
    public let modificationTime: Date?
    
    public init(
        id: String,
        name: String,
        path: String,
        isDirectory: Bool,
        size: Int64 = 0,
        modificationTime: Date? = nil
    ) {
        self.id = id
        self.name = name
        self.path = path
        self.isDirectory = isDirectory
        self.size = size
        self.modificationTime = modificationTime
    }
}

/// File manager for Android device
public actor FilesViewModel: ObservableObject {
    private let adb: ADBKit
    @Published public var files: [FileItem] = []
    @Published public var currentPath: String = "/sdcard"
    @Published public var isLoading = false
    @Published public var error: String?
    
    public init(adb: ADBKit = ADBKit()) {
        self.adb = adb
    }
    
    /// List files in directory
    public func listFiles(path: String, serial: String) async {
        isLoading = true
        defer { isLoading = false }
        
        do {
            let output = try await adb.shell("ls -la '\(path)'", serial: serial)
            files = parseFileList(output, basePath: path)
            currentPath = path
        } catch {
            self.error = error.localizedDescription
        }
    }
    
    /// Push file from Mac to Android
    public func pushFile(localPath: String, remotePath: String, serial: String) async throws {
        let args = [adb.adbPath, "-s", serial, "push", localPath, remotePath]
        try await runCommand(args)
    }
    
    /// Pull file from Android to Mac
    public func pullFile(remotePath: String, localPath: String, serial: String) async throws {
        let args = [adb.adbPath, "-s", serial, "pull", remotePath, localPath]
        try await runCommand(args)
    }
    
    /// Delete file on Android
    public func deleteFile(path: String, serial: String) async throws {
        _ = try await adb.shell("rm -rf '\(path)'", serial: serial)
    }
    
    /// Create directory on Android
    public func createDirectory(path: String, serial: String) async throws {
        _ = try await adb.shell("mkdir -p '\(path)'", serial: serial)
    }
    
    /// Navigate to parent directory
    public func navigateUp() -> String {
        let components = currentPath.split(separator: "/", omittingEmptySubsequences: true)
        if components.count > 1 {
            return "/" + components.dropLast().joined(separator: "/")
        }
        return "/"
    }
    
    /// Navigate into directory
    public func navigateInto(_ dir: String) -> String {
        if currentPath.hasSuffix("/") {
            return currentPath + dir
        }
        return currentPath + "/" + dir
    }
    
    // MARK: - Private
    
    private func parseFileList(_ output: String, basePath: String) -> [FileItem] {
        var items: [FileItem] = []
        
        for line in output.split(separator: "\n") {
            let parts = line.split(separator: " ", omittingEmptySubsequences: true)
            guard parts.count >= 9 else { continue }
            
            let permissions = String(parts[0])
            let isDirectory = permissions.hasPrefix("d")
            
            // Parse size (column 4)
            let size = Int64(parts[4]) ?? 0
            
            // Parse date (columns 5-7)
            let dateStr = "\(parts[5]) \(parts[6]) \(parts[7])"
            
            // Parse name (column 8+)
            let name = parts[8...].joined(separator: " ")
            guard name != "." && name != ".." else { continue }
            
            let fullPath = basePath.hasSuffix("/") ? "\(basePath)\(name)" : "\(basePath)/\(name)"
            
            items.append(FileItem(
                id: fullPath,
                name: name,
                path: fullPath,
                isDirectory: isDirectory,
                size: size,
                modificationTime: parseDate(dateStr)
            ))
        }
        
        return items.sorted { $0.isDirectory && !$1.isDirectory }
    }
    
    private func parseDate(_ str: String) -> Date? {
        let formatter = DateFormatter()
        formatter.dateFormat = "MMM dd HH:mm"
        return formatter.date(from: str)
    }
    
    private func runCommand(_ args: [String]) async throws {
        // TODO: Implement async process execution
    }
}
