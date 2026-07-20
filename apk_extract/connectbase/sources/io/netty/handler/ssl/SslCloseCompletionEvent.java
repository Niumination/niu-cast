package io.netty.handler.ssl;

/* JADX INFO: loaded from: classes3.dex */
public final class SslCloseCompletionEvent extends SslCompletionEvent {
    public static final SslCloseCompletionEvent SUCCESS = new SslCloseCompletionEvent();

    private SslCloseCompletionEvent() {
    }

    public SslCloseCompletionEvent(Throwable th2) {
        super(th2);
    }
}
