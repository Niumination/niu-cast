package io.netty.handler.pcap;

import io.netty.buffer.ByteBuf;

/* JADX INFO: loaded from: classes3.dex */
final class UDPPacket {
    private static final short UDP_HEADER_SIZE = 8;

    private UDPPacket() {
    }

    public static void writePacket(ByteBuf byteBuf, ByteBuf byteBuf2, int i10, int i11) {
        byteBuf.writeShort(i10);
        byteBuf.writeShort(i11);
        byteBuf.writeShort(byteBuf2.readableBytes() + 8);
        byteBuf.writeShort(1);
        byteBuf.writeBytes(byteBuf2);
    }
}
