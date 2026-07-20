package io.netty.handler.pcap;

import io.netty.buffer.ByteBuf;

/* JADX INFO: loaded from: classes3.dex */
final class IPPacket {
    private static final int IPV6_VERSION_TRAFFIC_FLOW = 60000000;
    private static final byte MAX_TTL = -1;
    private static final byte TCP = 6;
    private static final byte UDP = 17;
    private static final short V4_HEADER_SIZE = 20;

    private IPPacket() {
    }

    private static void writePacketv4(ByteBuf byteBuf, ByteBuf byteBuf2, int i10, int i11, int i12) {
        byteBuf.writeByte(69);
        byteBuf.writeByte(0);
        byteBuf.writeShort(byteBuf2.readableBytes() + 20);
        byteBuf.writeShort(0);
        byteBuf.writeShort(0);
        byteBuf.writeByte(-1);
        byteBuf.writeByte(i10);
        byteBuf.writeShort(0);
        byteBuf.writeInt(i11);
        byteBuf.writeInt(i12);
        byteBuf.writeBytes(byteBuf2);
    }

    private static void writePacketv6(ByteBuf byteBuf, ByteBuf byteBuf2, int i10, byte[] bArr, byte[] bArr2) {
        byteBuf.writeInt(IPV6_VERSION_TRAFFIC_FLOW);
        byteBuf.writeShort(byteBuf2.readableBytes());
        byteBuf.writeByte(i10 & 255);
        byteBuf.writeByte(-1);
        byteBuf.writeBytes(bArr);
        byteBuf.writeBytes(bArr2);
        byteBuf.writeBytes(byteBuf2);
    }

    public static void writeTCPv4(ByteBuf byteBuf, ByteBuf byteBuf2, int i10, int i11) {
        writePacketv4(byteBuf, byteBuf2, 6, i10, i11);
    }

    public static void writeTCPv6(ByteBuf byteBuf, ByteBuf byteBuf2, byte[] bArr, byte[] bArr2) {
        writePacketv6(byteBuf, byteBuf2, 6, bArr, bArr2);
    }

    public static void writeUDPv4(ByteBuf byteBuf, ByteBuf byteBuf2, int i10, int i11) {
        writePacketv4(byteBuf, byteBuf2, 17, i10, i11);
    }

    public static void writeUDPv6(ByteBuf byteBuf, ByteBuf byteBuf2, byte[] bArr, byte[] bArr2) {
        writePacketv6(byteBuf, byteBuf2, 17, bArr, bArr2);
    }
}
