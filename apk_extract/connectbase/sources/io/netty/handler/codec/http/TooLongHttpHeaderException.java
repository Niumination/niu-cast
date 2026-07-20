package io.netty.handler.codec.http;

import io.netty.handler.codec.TooLongFrameException;

/* JADX INFO: loaded from: classes3.dex */
public final class TooLongHttpHeaderException extends TooLongFrameException {
    private static final long serialVersionUID = -8295159138628369730L;

    public TooLongHttpHeaderException() {
    }

    public TooLongHttpHeaderException(String str, Throwable th2) {
        super(str, th2);
    }

    public TooLongHttpHeaderException(String str) {
        super(str);
    }

    public TooLongHttpHeaderException(Throwable th2) {
        super(th2);
    }
}
