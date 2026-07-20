package io.netty.handler.codec.socksx.v5;

import androidx.core.app.NotificationCompat;
import io.netty.handler.codec.DecoderResult;
import io.netty.util.NetUtil;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.StringUtil;
import java.net.IDN;
import k.b;
import n.a;

/* JADX INFO: loaded from: classes3.dex */
public final class DefaultSocks5CommandResponse extends AbstractSocks5Message implements Socks5CommandResponse {
    private final String bndAddr;
    private final Socks5AddressType bndAddrType;
    private final int bndPort;
    private final Socks5CommandStatus status;

    public DefaultSocks5CommandResponse(Socks5CommandStatus socks5CommandStatus, Socks5AddressType socks5AddressType) {
        this(socks5CommandStatus, socks5AddressType, null, 0);
    }

    @Override // io.netty.handler.codec.socksx.v5.Socks5CommandResponse
    public String bndAddr() {
        return this.bndAddr;
    }

    @Override // io.netty.handler.codec.socksx.v5.Socks5CommandResponse
    public Socks5AddressType bndAddrType() {
        return this.bndAddrType;
    }

    @Override // io.netty.handler.codec.socksx.v5.Socks5CommandResponse
    public int bndPort() {
        return this.bndPort;
    }

    @Override // io.netty.handler.codec.socksx.v5.Socks5CommandResponse
    public Socks5CommandStatus status() {
        return this.status;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(128);
        sb2.append(StringUtil.simpleClassName(this));
        DecoderResult decoderResult = decoderResult();
        if (decoderResult.isSuccess()) {
            sb2.append("(status: ");
        } else {
            sb2.append("(decoderResult: ");
            sb2.append(decoderResult);
            sb2.append(", status: ");
        }
        sb2.append(status());
        sb2.append(", bndAddrType: ");
        sb2.append(bndAddrType());
        sb2.append(", bndAddr: ");
        sb2.append(bndAddr());
        sb2.append(", bndPort: ");
        sb2.append(bndPort());
        sb2.append(')');
        return sb2.toString();
    }

    public DefaultSocks5CommandResponse(Socks5CommandStatus socks5CommandStatus, Socks5AddressType socks5AddressType, String str, int i10) {
        ObjectUtil.checkNotNull(socks5CommandStatus, NotificationCompat.CATEGORY_STATUS);
        ObjectUtil.checkNotNull(socks5AddressType, "bndAddrType");
        if (str != null) {
            if (socks5AddressType == Socks5AddressType.IPv4) {
                if (!NetUtil.isValidIpV4Address(str)) {
                    throw new IllegalArgumentException(a.a("bndAddr: ", str, " (expected: a valid IPv4 address)"));
                }
            } else if (socks5AddressType == Socks5AddressType.DOMAIN) {
                str = IDN.toASCII(str);
                if (str.length() > 255) {
                    throw new IllegalArgumentException(a.a("bndAddr: ", str, " (expected: less than 256 chars)"));
                }
            } else if (socks5AddressType == Socks5AddressType.IPv6 && !NetUtil.isValidIpV6Address(str)) {
                throw new IllegalArgumentException(a.a("bndAddr: ", str, " (expected: a valid IPv6 address)"));
            }
        }
        if (i10 < 0 || i10 > 65535) {
            throw new IllegalArgumentException(b.a("bndPort: ", i10, " (expected: 0~65535)"));
        }
        this.status = socks5CommandStatus;
        this.bndAddrType = socks5AddressType;
        this.bndAddr = str;
        this.bndPort = i10;
    }
}
