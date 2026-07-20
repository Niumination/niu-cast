package io.netty.handler.codec.http2;

import io.netty.buffer.ByteBuf;

/* JADX INFO: loaded from: classes3.dex */
public interface Http2HeadersDecoder {

    public interface Configuration {
        long maxHeaderListSize();

        void maxHeaderListSize(long j10, long j11) throws Http2Exception;

        long maxHeaderListSizeGoAway();

        long maxHeaderTableSize();

        void maxHeaderTableSize(long j10) throws Http2Exception;
    }

    Configuration configuration();

    Http2Headers decodeHeaders(int i10, ByteBuf byteBuf) throws Http2Exception;
}
