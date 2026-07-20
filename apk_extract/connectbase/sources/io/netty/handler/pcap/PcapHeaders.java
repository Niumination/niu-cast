package io.netty.handler.pcap;

import io.netty.buffer.ByteBuf;
import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes3.dex */
final class PcapHeaders {
    private static final byte[] GLOBAL_HEADER = {-95, -78, -61, -44, 0, 2, 0, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, -1, 0, 0, 0, 1};

    private PcapHeaders() {
    }

    public static void writeGlobalHeader(OutputStream outputStream) throws IOException {
        outputStream.write(GLOBAL_HEADER);
    }

    public static void writePacketHeader(ByteBuf byteBuf, int i10, int i11, int i12, int i13) {
        byteBuf.writeInt(i10);
        byteBuf.writeInt(i11);
        byteBuf.writeInt(i12);
        byteBuf.writeInt(i13);
    }
}
