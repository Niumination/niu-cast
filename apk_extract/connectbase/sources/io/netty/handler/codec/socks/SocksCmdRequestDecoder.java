package io.netty.handler.codec.socks;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufUtil;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ReplayingDecoder;
import io.netty.util.NetUtil;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class SocksCmdRequestDecoder extends ReplayingDecoder<State> {
    private SocksAddressType addressType;
    private SocksCmdType cmdType;

    /* JADX INFO: renamed from: io.netty.handler.codec.socks.SocksCmdRequestDecoder$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$io$netty$handler$codec$socks$SocksAddressType;
        static final /* synthetic */ int[] $SwitchMap$io$netty$handler$codec$socks$SocksCmdRequestDecoder$State;

        static {
            int[] iArr = new int[State.values().length];
            $SwitchMap$io$netty$handler$codec$socks$SocksCmdRequestDecoder$State = iArr;
            try {
                iArr[State.CHECK_PROTOCOL_VERSION.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$socks$SocksCmdRequestDecoder$State[State.READ_CMD_HEADER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$socks$SocksCmdRequestDecoder$State[State.READ_CMD_ADDRESS.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            int[] iArr2 = new int[SocksAddressType.values().length];
            $SwitchMap$io$netty$handler$codec$socks$SocksAddressType = iArr2;
            try {
                iArr2[SocksAddressType.IPv4.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$socks$SocksAddressType[SocksAddressType.DOMAIN.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$socks$SocksAddressType[SocksAddressType.IPv6.ordinal()] = 3;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$socks$SocksAddressType[SocksAddressType.UNKNOWN.ordinal()] = 4;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    public enum State {
        CHECK_PROTOCOL_VERSION,
        READ_CMD_HEADER,
        READ_CMD_ADDRESS
    }

    public SocksCmdRequestDecoder() {
        super(State.CHECK_PROTOCOL_VERSION);
    }

    /* JADX WARN: Code duplicated, block: B:16:0x005e A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:17:0x0060 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:18:0x0062  */
    /* JADX WARN: Code duplicated, block: B:20:0x0065  */
    /* JADX WARN: Code duplicated, block: B:21:0x006b  */
    /* JADX WARN: Code duplicated, block: B:23:0x0071  */
    /* JADX WARN: Code duplicated, block: B:24:0x008d  */
    /* JADX WARN: Code duplicated, block: B:25:0x00a6  */
    @Override // io.netty.handler.codec.ByteToMessageDecoder
    public void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) throws Exception {
        int i10;
        int i11 = AnonymousClass1.$SwitchMap$io$netty$handler$codec$socks$SocksCmdRequestDecoder$State[state().ordinal()];
        if (i11 == 1) {
            if (byteBuf.readByte() != SocksProtocolVersion.SOCKS5.byteValue()) {
                list.add(SocksCommonUtils.UNKNOWN_SOCKS_REQUEST);
            } else {
                checkpoint(State.READ_CMD_HEADER);
            }
            channelHandlerContext.pipeline().remove(this);
        }
        if (i11 != 2) {
            if (i11 != 3) {
                throw new Error();
            }
        }
        i10 = AnonymousClass1.$SwitchMap$io$netty$handler$codec$socks$SocksAddressType[this.addressType.ordinal()];
        if (i10 != 1) {
            list.add(new SocksCmdRequest(this.cmdType, this.addressType, NetUtil.intToIpAddress(ByteBufUtil.readIntBE(byteBuf)), ByteBufUtil.readUnsignedShortBE(byteBuf)));
        } else if (i10 != 2) {
            list.add(new SocksCmdRequest(this.cmdType, this.addressType, SocksCommonUtils.readUsAscii(byteBuf, byteBuf.readByte()), ByteBufUtil.readUnsignedShortBE(byteBuf)));
        } else if (i10 != 3) {
            byte[] bArr = new byte[16];
            byteBuf.readBytes(bArr);
            list.add(new SocksCmdRequest(this.cmdType, this.addressType, SocksCommonUtils.ipv6toStr(bArr), ByteBufUtil.readUnsignedShortBE(byteBuf)));
        } else {
            if (i10 == 4) {
                throw new Error();
            }
            list.add(SocksCommonUtils.UNKNOWN_SOCKS_REQUEST);
        }
        channelHandlerContext.pipeline().remove(this);
        this.cmdType = SocksCmdType.valueOf(byteBuf.readByte());
        byteBuf.skipBytes(1);
        this.addressType = SocksAddressType.valueOf(byteBuf.readByte());
        checkpoint(State.READ_CMD_ADDRESS);
        i10 = AnonymousClass1.$SwitchMap$io$netty$handler$codec$socks$SocksAddressType[this.addressType.ordinal()];
        if (i10 != 1) {
            list.add(new SocksCmdRequest(this.cmdType, this.addressType, NetUtil.intToIpAddress(ByteBufUtil.readIntBE(byteBuf)), ByteBufUtil.readUnsignedShortBE(byteBuf)));
        } else if (i10 != 2) {
            list.add(new SocksCmdRequest(this.cmdType, this.addressType, SocksCommonUtils.readUsAscii(byteBuf, byteBuf.readByte()), ByteBufUtil.readUnsignedShortBE(byteBuf)));
        } else if (i10 != 3) {
            byte[] bArr2 = new byte[16];
            byteBuf.readBytes(bArr2);
            list.add(new SocksCmdRequest(this.cmdType, this.addressType, SocksCommonUtils.ipv6toStr(bArr2), ByteBufUtil.readUnsignedShortBE(byteBuf)));
        } else {
            if (i10 == 4) {
                throw new Error();
            }
            list.add(SocksCommonUtils.UNKNOWN_SOCKS_REQUEST);
        }
        channelHandlerContext.pipeline().remove(this);
    }
}
