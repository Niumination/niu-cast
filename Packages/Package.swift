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
    ],
    dependencies: packages,
    targets: [
        .target(name: "ADBKit"),
        .target(name: "ScrcpyClient", dependencies: ["SharedModels"]),
        .target(name: "MirrorEngine", dependencies: ["SharedModels"]),
        .target(name: "FusionEngine", dependencies: ["SharedModels"]),
        .target(name: "DeviceDiscovery"),
        .target(name: "TCCPKit"),
        .target(name: "SharedModels"),
    ]
)
