package io.netty.handler.codec.http;

import io.netty.handler.codec.DecoderResult;

/* JADX INFO: loaded from: classes3.dex */
public final class HttpMessageDecoderResult extends DecoderResult {
    private final int headerSize;
    private final int initialLineLength;

    public HttpMessageDecoderResult(int i10, int i11) {
        super(DecoderResult.SIGNAL_SUCCESS);
        this.initialLineLength = i10;
        this.headerSize = i11;
    }

    public int headerSize() {
        return this.headerSize;
    }

    public int initialLineLength() {
        return this.initialLineLength;
    }

    public int totalSize() {
        return this.initialLineLength + this.headerSize;
    }
}
