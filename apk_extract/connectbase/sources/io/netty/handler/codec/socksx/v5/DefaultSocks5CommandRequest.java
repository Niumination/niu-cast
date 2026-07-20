package io.netty.handler.codec.socksx.v5;

import ik.y0;
import io.netty.handler.codec.DecoderResult;
import io.netty.util.NetUtil;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.StringUtil;
import java.net.IDN;
import k.b;
import n.a;

/* JADX INFO: loaded from: classes3.dex */
public final class DefaultSocks5CommandRequest extends AbstractSocks5Message implements Socks5CommandRequest {
    private final String dstAddr;
    private final Socks5AddressType dstAddrType;
    private final int dstPort;
    private final Socks5CommandType type;

    public DefaultSocks5CommandRequest(Socks5CommandType socks5CommandType, Socks5AddressType socks5AddressType, String str, int i10) {
        this.type = (Socks5CommandType) ObjectUtil.checkNotNull(socks5CommandType, y0.a.f8215h);
        ObjectUtil.checkNotNull(socks5AddressType, "dstAddrType");
        ObjectUtil.checkNotNull(str, "dstAddr");
        if (socks5AddressType == Socks5AddressType.IPv4) {
            if (!NetUtil.isValidIpV4Address(str)) {
                throw new IllegalArgumentException(a.a("dstAddr: ", str, " (expected: a valid IPv4 address)"));
            }
        } else if (socks5AddressType == Socks5AddressType.DOMAIN) {
            str = IDN.toASCII(str);
            if (str.length() > 255) {
                throw new IllegalArgumentException(a.a("dstAddr: ", str, " (expected: less than 256 chars)"));
            }
        } else if (socks5AddressType == Socks5AddressType.IPv6 && !NetUtil.isValidIpV6Address(str)) {
            throw new IllegalArgumentException(a.a("dstAddr: ", str, " (expected: a valid IPv6 address"));
        }
        if (i10 < 0 || i10 > 65535) {
            throw new IllegalArgumentException(b.a("dstPort: ", i10, " (expected: 0~65535)"));
        }
        this.dstAddrType = socks5AddressType;
        this.dstAddr = str;
        this.dstPort = i10;
    }

    @Override // io.netty.handler.codec.socksx.v5.Socks5CommandRequest
    public String dstAddr() {
        return this.dstAddr;
    }

    @Override // io.netty.handler.codec.socksx.v5.Socks5CommandRequest
    public Socks5AddressType dstAddrType() {
        return this.dstAddrType;
    }

    @Override // io.netty.handler.codec.socksx.v5.Socks5CommandRequest
    public int dstPort() {
        return this.dstPort;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(128);
        sb2.append(StringUtil.simpleClassName(this));
        DecoderResult decoderResult = decoderResult();
        if (decoderResult.isSuccess()) {
            sb2.append("(type: ");
        } else {
            sb2.append("(decoderResult: ");
            sb2.append(decoderResult);
            sb2.append(", type: ");
        }
        sb2.append(type());
        sb2.append(", dstAddrType: ");
        sb2.append(dstAddrType());
        sb2.append(", dstAddr: ");
        sb2.append(dstAddr());
        sb2.append(", dstPort: ");
        sb2.append(dstPort());
        sb2.append(')');
        return sb2.toString();
    }

    @Override // io.netty.handler.codec.socksx.v5.Socks5CommandRequest
    public Socks5CommandType type() {
        return this.type;
    }
}
