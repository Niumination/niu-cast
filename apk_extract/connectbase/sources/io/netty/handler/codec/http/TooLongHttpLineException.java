package io.netty.handler.codec.http;

import io.netty.handler.codec.TooLongFrameException;

/* JADX INFO: loaded from: classes3.dex */
public final class TooLongHttpLineException extends TooLongFrameException {
    private static final long serialVersionUID = 1614751125592211890L;

    public TooLongHttpLineException() {
    }

    public TooLongHttpLineException(String str, Throwable th2) {
        super(str, th2);
    }

    public TooLongHttpLineException(String str) {
        super(str);
    }

    public TooLongHttpLineException(Throwable th2) {
        super(th2);
    }
}
