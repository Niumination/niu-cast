package io.netty.handler.codec.spdy;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.buffer.ByteBufUtil;
import io.netty.buffer.Unpooled;
import io.netty.util.internal.ObjectUtil;
import java.util.Set;
import lb.f;

/* JADX INFO: loaded from: classes3.dex */
public class SpdyHeaderBlockRawEncoder extends SpdyHeaderBlockEncoder {
    private final int version;

    public SpdyHeaderBlockRawEncoder(SpdyVersion spdyVersion) {
        this.version = ((SpdyVersion) ObjectUtil.checkNotNull(spdyVersion, f.f9782f)).getVersion();
    }

    private static void setLengthField(ByteBuf byteBuf, int i10, int i11) {
        byteBuf.setInt(i10, i11);
    }

    private static void writeLengthField(ByteBuf byteBuf, int i10) {
        byteBuf.writeInt(i10);
    }

    @Override // io.netty.handler.codec.spdy.SpdyHeaderBlockEncoder
    public ByteBuf encode(ByteBufAllocator byteBufAllocator, SpdyHeadersFrame spdyHeadersFrame) throws Exception {
        Set<CharSequence> setNames = spdyHeadersFrame.headers().names();
        int size = setNames.size();
        if (size == 0) {
            return Unpooled.EMPTY_BUFFER;
        }
        if (size > 65535) {
            throw new IllegalArgumentException("header block contains too many headers");
        }
        ByteBuf byteBufHeapBuffer = byteBufAllocator.heapBuffer();
        writeLengthField(byteBufHeapBuffer, size);
        for (CharSequence charSequence : setNames) {
            writeLengthField(byteBufHeapBuffer, charSequence.length());
            ByteBufUtil.writeAscii(byteBufHeapBuffer, charSequence);
            int iWriterIndex = byteBufHeapBuffer.writerIndex();
            writeLengthField(byteBufHeapBuffer, 0);
            int i10 = 0;
            for (CharSequence charSequence2 : spdyHeadersFrame.headers().getAll(charSequence)) {
                int length = charSequence2.length();
                if (length > 0) {
                    ByteBufUtil.writeAscii(byteBufHeapBuffer, charSequence2);
                    byteBufHeapBuffer.writeByte(0);
                    i10 += length + 1;
                }
            }
            if (i10 != 0) {
                i10--;
            }
            if (i10 > 65535) {
                throw new IllegalArgumentException("header exceeds allowable length: " + ((Object) charSequence));
            }
            if (i10 > 0) {
                setLengthField(byteBufHeapBuffer, iWriterIndex, i10);
                byteBufHeapBuffer.writerIndex(byteBufHeapBuffer.writerIndex() - 1);
            }
        }
        return byteBufHeapBuffer;
    }

    @Override // io.netty.handler.codec.spdy.SpdyHeaderBlockEncoder
    public void end() {
    }
}
