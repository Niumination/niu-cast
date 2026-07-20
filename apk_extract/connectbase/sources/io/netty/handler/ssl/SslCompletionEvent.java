package io.netty.handler.ssl;

import io.netty.util.internal.ObjectUtil;

/* JADX INFO: loaded from: classes3.dex */
public abstract class SslCompletionEvent {
    private final Throwable cause;

    public SslCompletionEvent() {
        this.cause = null;
    }

    public final Throwable cause() {
        return this.cause;
    }

    public final boolean isSuccess() {
        return this.cause == null;
    }

    public String toString() {
        Throwable thCause = cause();
        if (thCause == null) {
            return getClass().getSimpleName().concat("(SUCCESS)");
        }
        return getClass().getSimpleName() + '(' + thCause + ')';
    }

    public SslCompletionEvent(Throwable th2) {
        this.cause = (Throwable) ObjectUtil.checkNotNull(th2, "cause");
    }
}
