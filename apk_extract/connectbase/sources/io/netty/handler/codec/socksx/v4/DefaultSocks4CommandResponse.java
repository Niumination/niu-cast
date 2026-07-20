package io.netty.handler.codec.socksx.v4;

import io.netty.handler.codec.DecoderResult;
import io.netty.util.NetUtil;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.StringUtil;
import k.b;
import n.a;

/* JADX INFO: loaded from: classes3.dex */
public class DefaultSocks4CommandResponse extends AbstractSocks4Message implements Socks4CommandResponse {
    private final String dstAddr;
    private final int dstPort;
    private final Socks4CommandStatus status;

    public DefaultSocks4CommandResponse(Socks4CommandStatus socks4CommandStatus) {
        this(socks4CommandStatus, null, 0);
    }

    @Override // io.netty.handler.codec.socksx.v4.Socks4CommandResponse
    public String dstAddr() {
        return this.dstAddr;
    }

    @Override // io.netty.handler.codec.socksx.v4.Socks4CommandResponse
    public int dstPort() {
        return this.dstPort;
    }

    @Override // io.netty.handler.codec.socksx.v4.Socks4CommandResponse
    public Socks4CommandStatus status() {
        return this.status;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(96);
        sb2.append(StringUtil.simpleClassName(this));
        DecoderResult decoderResult = decoderResult();
        if (decoderResult.isSuccess()) {
            sb2.append("(dstAddr: ");
        } else {
            sb2.append("(decoderResult: ");
            sb2.append(decoderResult);
            sb2.append(", dstAddr: ");
        }
        sb2.append(dstAddr());
        sb2.append(", dstPort: ");
        sb2.append(dstPort());
        sb2.append(')');
        return sb2.toString();
    }

    public DefaultSocks4CommandResponse(Socks4CommandStatus socks4CommandStatus, String str, int i10) {
        if (str != null && !NetUtil.isValidIpV4Address(str)) {
            throw new IllegalArgumentException(a.a("dstAddr: ", str, " (expected: a valid IPv4 address)"));
        }
        if (i10 < 0 || i10 > 65535) {
            throw new IllegalArgumentException(b.a("dstPort: ", i10, " (expected: 0~65535)"));
        }
        this.status = (Socks4CommandStatus) ObjectUtil.checkNotNull(socks4CommandStatus, "cmdStatus");
        this.dstAddr = str;
        this.dstPort = i10;
    }
}
