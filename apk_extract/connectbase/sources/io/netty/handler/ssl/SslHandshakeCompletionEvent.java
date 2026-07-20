package io.netty.handler.ssl;

/* JADX INFO: loaded from: classes3.dex */
public final class SslHandshakeCompletionEvent extends SslCompletionEvent {
    public static final SslHandshakeCompletionEvent SUCCESS = new SslHandshakeCompletionEvent();

    private SslHandshakeCompletionEvent() {
    }

    public SslHandshakeCompletionEvent(Throwable th2) {
        super(th2);
    }
}
