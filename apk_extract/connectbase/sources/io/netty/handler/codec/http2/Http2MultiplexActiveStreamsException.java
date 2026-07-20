package io.netty.handler.codec.http2;

/* JADX INFO: loaded from: classes3.dex */
public final class Http2MultiplexActiveStreamsException extends Exception {
    public Http2MultiplexActiveStreamsException(Throwable th2) {
        super(th2);
    }

    @Override // java.lang.Throwable
    public Throwable fillInStackTrace() {
        return this;
    }
}
