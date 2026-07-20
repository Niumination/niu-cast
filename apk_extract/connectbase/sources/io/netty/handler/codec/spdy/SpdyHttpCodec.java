package io.netty.handler.codec.spdy;

import io.netty.channel.CombinedChannelDuplexHandler;

/* JADX INFO: loaded from: classes3.dex */
public final class SpdyHttpCodec extends CombinedChannelDuplexHandler<SpdyHttpDecoder, SpdyHttpEncoder> {
    public SpdyHttpCodec(SpdyVersion spdyVersion, int i10) {
        super(new SpdyHttpDecoder(spdyVersion, i10), new SpdyHttpEncoder(spdyVersion));
    }

    public SpdyHttpCodec(SpdyVersion spdyVersion, int i10, boolean z10) {
        super(new SpdyHttpDecoder(spdyVersion, i10, z10), new SpdyHttpEncoder(spdyVersion));
    }
}
