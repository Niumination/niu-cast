import Foundation
import CoreImage

/// QR Code generator for Joy Connect
public struct TCCPQRGenerator {
    private let deviceName: String
    private let port: Int
    private let ssid: String
    private let password: String
    private let channel: String
    
    public init(
        deviceName: String = "NIU-CAST-Mac",
        port: Int = 9452,
        ssid: String = "",
        password: String = "",
        channel: String = "0"
    ) {
        self.deviceName = deviceName
        self.port = port
        self.ssid = ssid
        self.password = password
        self.channel = channel
    }
    
    /// Build QR string format Transsion
    public func buildQRString() -> String {
        // PID harus 12 hex chars: TTBBXXXXXXXX
        let uniqueId = String(deviceName.hash, radix: 16).prefix(8)
        let pid = "0000\(uniqueId)"
        
        // DID = 16 hex chars
        let did = String(deviceName.hash, radix: 16).uppercased().prefix(16)
        
        // Build params — ALL 7 fields WAJIB
        var params = "PID=\(pid)"
        params += "&DeviceName=\(deviceName.addingPercentEncoding(withAllowedCharacters: .urlQueryAllowed) ?? deviceName)"
        params += "&DPORT=\(port)"
        params += "&DID=\(did)"
        params += "&SSID=\(ssid)"
        params += "&PWD=\(password.addingPercentEncoding(withAllowedCharacters: .urlQueryAllowed) ?? password)"
        params += "&Chan=\(channel)"
        
        // Format Transsion: tqr://a=ACTION&c=KEY=VALUE&...
        let prefix = "tqr://a=com.transsion.intent.wls.MULTISCREEN_SCAN_CONNECT&c="
        return prefix + params
    }
    
    /// Generate QR code image
    public func generateQRImage() -> CGImage? {
    let qrString = buildQRString()
    
    guard let data = qrString.data(using: .utf8) else { return nil }
    
    guard let filter = CIFilter(name: "CIQRCodeGenerator") else { return nil }
    filter.setValue(data, forKey: "inputMessage")
    filter.setValue("M", forKey: "inputCorrectionLevel")
    
    guard let output = filter.outputImage else { return nil }
    
    // Scale up the image
    let scaleX = 200 / output.extent.width
    let scaleY = 200 / output.extent.height
    let scaled = output.transformed(by: CGAffineTransform(scaleX: scaleX, y: scaleY))
    
    let context = CIContext()
    return context.createCGImage(scaled, from: scaled.extent)
}

/// Parse QR string
public func parseQRString(_ qrFull: String) -> [String: String] {
    var result: [String: String] = [:]
    
    // Extract params after "c=" if present
    var paramsStr = qrFull
    if let range = qrFull.range(of: "&c=") {
        paramsStr = String(qrFull[range.upperBound...])
    } else if let range = qrFull.range(of: "c=") {
        paramsStr = String(qrFull[range.upperBound...])
    }
    
    // Parse key=value pairs
    let pairs = paramsStr.split(separator: "&")
    for pair in pairs {
        let kv = pair.split(separator: "=", maxSplits: 1)
        if kv.count == 2 {
            let key = String(kv[0])
            let value = String(kv[1]).removingPercentEncoding ?? String(kv[1])
            result[key] = value
        }
    }
    
    return result
}
}
