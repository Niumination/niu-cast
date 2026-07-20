package io.netty.handler.ssl;

import j.c;

/* JADX INFO: loaded from: classes3.dex */
public final class SniCompletionEvent extends SslCompletionEvent {
    private final String hostname;

    public SniCompletionEvent(String str) {
        this.hostname = str;
    }

    public String hostname() {
        return this.hostname;
    }

    @Override // io.netty.handler.ssl.SslCompletionEvent
    public String toString() {
        Throwable thCause = cause();
        if (thCause == null) {
            return c.a(new StringBuilder("SniCompletionEvent(SUCCESS='"), this.hostname, "'\")");
        }
        return "SniCompletionEvent(" + thCause + ')';
    }

    public SniCompletionEvent(String str, Throwable th2) {
        super(th2);
        this.hostname = str;
    }

    public SniCompletionEvent(Throwable th2) {
        this(null, th2);
    }
}
