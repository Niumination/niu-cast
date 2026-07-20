package io.netty.handler.pcap;

import io.netty.buffer.ByteBuf;

/* JADX INFO: loaded from: classes3.dex */
final class TCPPacket {
    private static final short OFFSET = 20480;

    public enum TCPFlag {
        FIN(1),
        SYN(2),
        RST(4),
        PSH(8),
        ACK(16),
        URG(32),
        ECE(64),
        CWR(128);

        private final int value;

        TCPFlag(int i10) {
            this.value = i10;
        }

        public static int getFlag(TCPFlag... tCPFlagArr) {
            int i10 = 0;
            for (TCPFlag tCPFlag : tCPFlagArr) {
                i10 |= tCPFlag.value;
            }
            return i10;
        }
    }

    private TCPPacket() {
    }

    public static void writePacket(ByteBuf byteBuf, ByteBuf byteBuf2, int i10, int i11, int i12, int i13, TCPFlag... tCPFlagArr) {
        byteBuf.writeShort(i12);
        byteBuf.writeShort(i13);
        byteBuf.writeInt(i10);
        byteBuf.writeInt(i11);
        byteBuf.writeShort(TCPFlag.getFlag(tCPFlagArr) | 20480);
        byteBuf.writeShort(65535);
        byteBuf.writeShort(1);
        byteBuf.writeShort(0);
        if (byteBuf2 != null) {
            byteBuf.writeBytes(byteBuf2);
        }
    }
}
