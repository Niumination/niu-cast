package io.netty.handler.codec.spdy;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;

/* JADX INFO: loaded from: classes3.dex */
public abstract class SpdyHeaderBlockDecoder {
    public static SpdyHeaderBlockDecoder newInstance(SpdyVersion spdyVersion, int i10) {
        return new SpdyHeaderBlockZlibDecoder(spdyVersion, i10);
    }

    public abstract void decode(ByteBufAllocator byteBufAllocator, ByteBuf byteBuf, SpdyHeadersFrame spdyHeadersFrame) throws Exception;

    public abstract void end();

    public abstract void endHeaderBlock(SpdyHeadersFrame spdyHeadersFrame) throws Exception;
}
