package io.netty.handler.codec.socks;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufUtil;
import io.netty.util.CharsetUtil;
import io.netty.util.NetUtil;
import io.netty.util.internal.ObjectUtil;
import j.a;
import java.net.IDN;

/* JADX INFO: loaded from: classes3.dex */
public final class SocksCmdRequest extends SocksRequest {
    private final SocksAddressType addressType;
    private final SocksCmdType cmdType;
    private final String host;
    private final int port;

    /* JADX INFO: renamed from: io.netty.handler.codec.socks.SocksCmdRequest$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$io$netty$handler$codec$socks$SocksAddressType;

        static {
            int[] iArr = new int[SocksAddressType.values().length];
            $SwitchMap$io$netty$handler$codec$socks$SocksAddressType = iArr;
            try {
                iArr[SocksAddressType.IPv4.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$socks$SocksAddressType[SocksAddressType.DOMAIN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$socks$SocksAddressType[SocksAddressType.IPv6.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$socks$SocksAddressType[SocksAddressType.UNKNOWN.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public SocksCmdRequest(SocksCmdType socksCmdType, SocksAddressType socksAddressType, String str, int i10) {
        super(SocksRequestType.CMD);
        ObjectUtil.checkNotNull(socksCmdType, "cmdType");
        ObjectUtil.checkNotNull(socksAddressType, "addressType");
        ObjectUtil.checkNotNull(str, "host");
        int i11 = AnonymousClass1.$SwitchMap$io$netty$handler$codec$socks$SocksAddressType[socksAddressType.ordinal()];
        if (i11 != 1) {
            if (i11 == 2) {
                String ascii = IDN.toASCII(str);
                if (ascii.length() > 255) {
                    throw new IllegalArgumentException(str + " IDN: " + ascii + " exceeds 255 char limit");
                }
                str = ascii;
            } else if (i11 == 3 && !NetUtil.isValidIpV6Address(str)) {
                throw new IllegalArgumentException(a.a(str, " is not a valid IPv6 address"));
            }
        } else if (!NetUtil.isValidIpV4Address(str)) {
            throw new IllegalArgumentException(a.a(str, " is not a valid IPv4 address"));
        }
        if (i10 <= 0 || i10 >= 65536) {
            throw new IllegalArgumentException(i10 + " is not in bounds 0 < x < 65536");
        }
        this.cmdType = socksCmdType;
        this.addressType = socksAddressType;
        this.host = str;
        this.port = i10;
    }

    public SocksAddressType addressType() {
        return this.addressType;
    }

    public SocksCmdType cmdType() {
        return this.cmdType;
    }

    @Override // io.netty.handler.codec.socks.SocksMessage
    public void encodeAsByteBuf(ByteBuf byteBuf) {
        byteBuf.writeByte(protocolVersion().byteValue());
        byteBuf.writeByte(this.cmdType.byteValue());
        byteBuf.writeByte(0);
        byteBuf.writeByte(this.addressType.byteValue());
        int i10 = AnonymousClass1.$SwitchMap$io$netty$handler$codec$socks$SocksAddressType[this.addressType.ordinal()];
        if (i10 == 1) {
            byteBuf.writeBytes(NetUtil.createByteArrayFromIpAddressString(this.host));
            ByteBufUtil.writeShortBE(byteBuf, this.port);
        } else if (i10 == 2) {
            byteBuf.writeByte(this.host.length());
            byteBuf.writeCharSequence(this.host, CharsetUtil.US_ASCII);
            ByteBufUtil.writeShortBE(byteBuf, this.port);
        } else {
            if (i10 != 3) {
                return;
            }
            byteBuf.writeBytes(NetUtil.createByteArrayFromIpAddressString(this.host));
            ByteBufUtil.writeShortBE(byteBuf, this.port);
        }
    }

    public String host() {
        SocksAddressType socksAddressType = this.addressType;
        SocksAddressType socksAddressType2 = SocksAddressType.DOMAIN;
        String str = this.host;
        return socksAddressType == socksAddressType2 ? IDN.toUnicode(str) : str;
    }

    public int port() {
        return this.port;
    }
}
