package io.netty.util.internal.logging;

/* JADX INFO: loaded from: classes3.dex */
public final class FormattingTuple {
    private final String message;
    private final Throwable throwable;

    public FormattingTuple(String str, Throwable th2) {
        this.message = str;
        this.throwable = th2;
    }

    public String getMessage() {
        return this.message;
    }

    public Throwable getThrowable() {
        return this.throwable;
    }
}
