import Foundation

// MARK: - Protocol Constants

public enum TCCPPort: Int {
    case tccp = 9452
    case tccpFallback = 8613
    case control = 9542
    case file = 10001
    case screencast = 8008
}

public enum TCCPOperatorCode: UInt16 {
    case base = 0x0001
    
    // File operations
    case fileBase = 0x0200
    case fileAuth = 0x0300
    case fileAuthAck = 0x0301
    case fileCancel = 0x0302
    
    // Screen cast
    case castStart = 0x0400
    case castStop = 0x0401
    case castConfig = 0x0402
    case castRotate = 0x0403
    case castClose = 0x0404
    case castExtend = 0x0500
    case castExtendStop = 0x0501
    case castExtendClose = 0x0502
    
    // File transfer
    case fileSend = 0x0600
    case fileReceive = 0x0601
    case fileProgress = 0x0602
    case fileComplete = 0x0603
    case fileError = 0x0604
    case fileList = 0x0605
    case fileDelete = 0x0606
    case fileRename = 0x0607
    case fileMkdir = 0x0608
    case fileInfo = 0x0609
    
    // Device operations
    case deviceInfo = 0x0610
    case deviceBattery = 0x0611
    case deviceScreenshot = 0x0612
    case deviceLock = 0x0613
    case deviceUnlock = 0x0614
    case deviceVolume = 0x0615
    case deviceBrightness = 0x0616
    case deviceRing = 0x0617
    case deviceLocation = 0x0618
    case deviceCamera = 0x0619
    
    // App operations
    case appList = 0x0620
    case appOpen = 0x0621
    case appClose = 0x0622
    case appInstall = 0x0623
    case appUninstall = 0x0624
    case appUpdate = 0x0625
    case appLaunch = 0x0626
    case appForceStop = 0x0627
    
    // Initial handshake frames
    case initControl = 0x0606
    case initDeviceInfo = 0x0404
    case initAuth = 0x0607
    case initData = 0x062a
    case initStatus = 0x0615
    case initScene = 0x0403
    case heartbeat = 0x0900
    
    // Auth
    case connAuth = 0x0700
    case authOk = 0x0701
}

public enum TCCPServiceType: String {
    case tranCast = "_tranCast._tcp"
    case tranFile = "_tranFile._tcp"
    case tran = "_tran._tcp"
    case tccp = "_tccp._tcp"
    
    public static let all: [TCCPServiceType] = [.tranCast, .tranFile, .tran, .tccp]
}

// MARK: - Frame

public struct TCCPFrame {
    public let operatorCode: TCCPOperatorCode
    public let messageId: UInt32
    public let timestamp: UInt64
    public let payload: Data
    
    public init(
        operatorCode: TCCPOperatorCode,
        messageId: UInt32 = 0,
        timestamp: UInt64 = 0,
        payload: Data = Data()
    ) {
        self.operatorCode = operatorCode
        self.messageId = messageId
        self.timestamp = timestamp
        self.payload = payload
    }
    
    /// Encode frame to wire format
    public func encode() -> Data {
        var data = Data()
        
        // Magic "TCCP" (4 bytes)
        data.append(contentsOf: [0x54, 0x43, 0x43, 0x50])
        
        // Version (1 byte, 0xFF = server)
        data.append(0xFF)
        
        // Body length (4 bytes, big-endian) = 15 + payload.count + 1
        let bodyLength = UInt32(15 + payload.count + 1)
        data.append(contentsOf: withUnsafeBytes(of: bodyLength.bigEndian) { Array($0) })
        
        // Operator code (2 bytes, big-endian)
        data.append(contentsOf: withUnsafeBytes(of: operatorCode.rawValue.bigEndian) { Array($0) })
        
        // Message ID (4 bytes, big-endian)
        data.append(contentsOf: withUnsafeBytes(of: messageId.bigEndian) { Array($0) })
        
        // Timestamp (8 bytes, big-endian)
        data.append(contentsOf: withUnsafeBytes(of: timestamp.bigEndian) { Array($0) })
        
        // Payload
        data.append(payload)
        
        // Payload type (1 byte, 0x00 = JSON)
        data.append(0x00)
        
        return data
    }
    
    /// Decode frame from wire format
    public static func decode(from data: Data) -> TCCPFrame? {
        guard data.count >= 24 else { return nil }
        
        // Check magic
        guard data[0] == 0x54, data[1] == 0x43, data[2] == 0x43, data[3] == 0x50 else {
            return nil
        }
        
        // Body length (bytes 4-8)
        let bodyLength = UInt32(bigEndian: data.subdata(in: 4..<8).withUnsafeBytes { $0.load(as: UInt32.self) })
        
        // Operator code (bytes 9-10)
        let opCode = UInt16(bigEndian: data.subdata(in: 9..<11).withUnsafeBytes { $0.load(as: UInt16.self) })
        
        // Message ID (bytes 11-14)
        let msgId = UInt32(bigEndian: data.subdata(in: 11..<15).withUnsafeBytes { $0.load(as: UInt32.self) })
        
        // Timestamp (bytes 15-22)
        let timestamp = UInt64(bigEndian: data.subdata(in: 15..<23).withUnsafeBytes { $0.load(as: UInt64.self) })
        
        // Payload (bytes 23..<bodyLength-1)
        let payloadEnd = min(Int(bodyLength) - 1, data.count - 1)
        let payload = data.subdata(in: 23..<payloadEnd)
        
        return TCCPFrame(
            operatorCode: TCCPOperatorCode(rawValue: opCode) ?? .base,
            messageId: msgId,
            timestamp: timestamp,
            payload: payload
        )
    }
}

// MARK: - Handshake Frames

public extension TCCPFrame {
    /// Initial handshake frame 1: Control channel info
    static func initControl(messageId: UInt32 = 1) -> TCCPFrame {
        let json = #"{"port":12000}"#
        return TCCPFrame(
            operatorCode: .initControl,
            messageId: messageId,
            timestamp: UInt64(Date().timeIntervalSince1970 * 1000),
            payload: json.data(using: .utf8) ?? Data()
        )
    }
    
    /// Initial handshake frame 2: Device info
    static func initDeviceInfo(messageId: UInt32 = 2) -> TCCPFrame {
        let json = #"{"a":"xos"}"#
        return TCCPFrame(
            operatorCode: .initDeviceInfo,
            messageId: messageId,
            timestamp: UInt64(Date().timeIntervalSince1970 * 1000),
            payload: json.data(using: .utf8) ?? Data()
        )
    }
    
    /// Initial handshake frame 3: Auth response with ports
    static func initAuth(messageId: UInt32 = 3) -> TCCPFrame {
        let json = #"{"controlPort":9542,"filePort":10001,"port":8008,"supportVersions":[1,2,3]}"#
        return TCCPFrame(
            operatorCode: .initAuth,
            messageId: messageId,
            timestamp: UInt64(Date().timeIntervalSince1970 * 1000),
            payload: json.data(using: .utf8) ?? Data()
        )
    }
    
    /// Initial handshake frame 4: Device data
    static func initData(messageId: UInt32 = 4) -> TCCPFrame {
        let json = #"{"data":50314,"type":0}"#
        return TCCPFrame(
            operatorCode: .initData,
            messageId: messageId,
            timestamp: UInt64(Date().timeIntervalSince1970 * 1000),
            payload: json.data(using: .utf8) ?? Data()
        )
    }
    
    /// Initial handshake frame 5: Status
    static func initStatus(messageId: UInt32 = 5) -> TCCPFrame {
        let json = #"{"count":3}"#
        return TCCPFrame(
            operatorCode: .initStatus,
            messageId: messageId,
            timestamp: UInt64(Date().timeIntervalSince1970 * 1000),
            payload: json.data(using: .utf8) ?? Data()
        )
    }
    
    /// Initial handshake frame 6: Scene info
    static func initScene(messageId: UInt32 = 6) -> TCCPFrame {
        let json = #"{"scene":0,"videoPort":0}"#
        return TCCPFrame(
            operatorCode: .initScene,
            messageId: messageId,
            timestamp: UInt64(Date().timeIntervalSince1970 * 1000),
            payload: json.data(using: .utf8) ?? Data()
        )
    }
    
    /// Initial handshake frame 7: Heartbeat
    static func heartbeat(messageId: UInt32 = 7) -> TCCPFrame {
        let json = #"{"count":0}"#
        return TCCPFrame(
            operatorCode: .heartbeat,
            messageId: messageId,
            timestamp: UInt64(Date().timeIntervalSince1970 * 1000),
            payload: json.data(using: .utf8) ?? Data()
        )
    }
    
    /// Auth OK response
    static func authOk(messageId: UInt32) -> TCCPFrame {
        let json = #"{"status":"ok"}"#
        return TCCPFrame(
            operatorCode: .authOk,
            messageId: messageId,
            timestamp: UInt64(Date().timeIntervalSince1970 * 1000),
            payload: json.data(using: .utf8) ?? Data()
        )
    }
    
    /// All 7 initial handshake frames
    static func handshakeSequence() -> [TCCPFrame] {
        return [
            initControl(),
            initDeviceInfo(),
            initAuth(),
            initData(),
            initStatus(),
            initScene(),
            heartbeat()
        ]
    }
}
