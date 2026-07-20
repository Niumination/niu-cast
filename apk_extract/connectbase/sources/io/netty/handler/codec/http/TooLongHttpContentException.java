package io.netty.handler.codec.http;

import io.netty.handler.codec.TooLongFrameException;

/* JADX INFO: loaded from: classes3.dex */
public final class TooLongHttpContentException extends TooLongFrameException {
    private static final long serialVersionUID = 3238341182129476117L;

    public TooLongHttpContentException() {
    }

    public TooLongHttpContentException(String str, Throwable th2) {
        super(str, th2);
    }

    public TooLongHttpContentException(String str) {
        super(str);
    }

    public TooLongHttpContentException(Throwable th2) {
        super(th2);
    }
}
