package io.netty.handler.codec.socksx.v4;

import ik.y0;
import io.netty.handler.codec.DecoderResult;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.StringUtil;
import java.net.IDN;
import k.b;

/* JADX INFO: loaded from: classes3.dex */
public class DefaultSocks4CommandRequest extends AbstractSocks4Message implements Socks4CommandRequest {
    private final String dstAddr;
    private final int dstPort;
    private final Socks4CommandType type;
    private final String userId;

    public DefaultSocks4CommandRequest(Socks4CommandType socks4CommandType, String str, int i10) {
        this(socks4CommandType, str, i10, "");
    }

    @Override // io.netty.handler.codec.socksx.v4.Socks4CommandRequest
    public String dstAddr() {
        return this.dstAddr;
    }

    @Override // io.netty.handler.codec.socksx.v4.Socks4CommandRequest
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
        sb2.append(", dstAddr: ");
        sb2.append(dstAddr());
        sb2.append(", dstPort: ");
        sb2.append(dstPort());
        sb2.append(", userId: ");
        sb2.append(userId());
        sb2.append(')');
        return sb2.toString();
    }

    @Override // io.netty.handler.codec.socksx.v4.Socks4CommandRequest
    public Socks4CommandType type() {
        return this.type;
    }

    @Override // io.netty.handler.codec.socksx.v4.Socks4CommandRequest
    public String userId() {
        return this.userId;
    }

    public DefaultSocks4CommandRequest(Socks4CommandType socks4CommandType, String str, int i10, String str2) {
        if (i10 <= 0 || i10 >= 65536) {
            throw new IllegalArgumentException(b.a("dstPort: ", i10, " (expected: 1~65535)"));
        }
        this.type = (Socks4CommandType) ObjectUtil.checkNotNull(socks4CommandType, y0.a.f8215h);
        this.dstAddr = IDN.toASCII((String) ObjectUtil.checkNotNull(str, "dstAddr"));
        this.userId = (String) ObjectUtil.checkNotNull(str2, "userId");
        this.dstPort = i10;
    }
}
