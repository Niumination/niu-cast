// swift-tools-version:6.0
import PackageDescription

let packages: [PackageDescription.Package.Dependency] = [
    .package(url: "https://github.com/apple/swift-argument-parser.git", from: "1.5.0"),
    .package(url: "https://github.com/apple/swift-log.git", from: "1.6.0"),
]

let package = Package(
    name: "niu-cast-packages",
    platforms: [.macOS(.v15)],
    products: [
        .library(name: "ADBKit", targets: ["ADBKit"]),
        .library(name: "ScrcpyClient", targets: ["ScrcpyClient"]),
        .library(name: "MirrorEngine", targets: ["MirrorEngine"]),
        .library(name: "FusionEngine", targets: ["FusionEngine"]),
        .library(name: "DeviceDiscovery", targets: ["DeviceDiscovery"]),
        .library(name: "TCCPKit", targets: ["TCCPKit"]),
        .library(name: "SharedModels", targets: ["SharedModels"]),
        .library(name: "NIUCastCLI", targets: ["NIUCastCLI"]),
        .executable(name: "niu-cast", targets: ["niu-cast-cli"]),
    ],
    dependencies: packages,
    targets: [
        .target(name: "ADBKit", dependencies: []),
        .target(name: "ScrcpyClient", dependencies: []),
        .target(name: "MirrorEngine", dependencies: []),
        .target(name: "FusionEngine", dependencies: ["ADBKit", "MirrorEngine", "ScrcpyClient"]),
        .target(name: "DeviceDiscovery", dependencies: []),
        .target(name: "TCCPKit", dependencies: []),
        .target(name: "SharedModels", dependencies: ["ADBKit"]),
        .target(name: "NIUCastCLI", dependencies: [
            "ADBKit", "TCCPKit", "ScrcpyClient", "SharedModels",
            .product(name: "ArgumentParser", package: "swift-argument-parser"),
            .product(name: "Logging", package: "swift-log"),
        ]),
        .executableTarget(name: "niu-cast-cli", dependencies: ["NIUCastCLI"]),
    ]
)
