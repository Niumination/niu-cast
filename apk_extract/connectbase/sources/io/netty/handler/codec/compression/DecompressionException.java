package io.netty.handler.codec.compression;

import io.netty.handler.codec.DecoderException;

/* JADX INFO: loaded from: classes3.dex */
public class DecompressionException extends DecoderException {
    private static final long serialVersionUID = 3546272712208105199L;

    public DecompressionException() {
    }

    public DecompressionException(String str, Throwable th2) {
        super(str, th2);
    }

    public DecompressionException(String str) {
        super(str);
    }

    public DecompressionException(Throwable th2) {
        super(th2);
    }
}
