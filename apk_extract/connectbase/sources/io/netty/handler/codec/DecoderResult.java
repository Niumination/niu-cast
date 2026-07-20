package io.netty.handler.codec;

import io.netty.util.Signal;
import io.netty.util.internal.ObjectUtil;

/* JADX INFO: loaded from: classes3.dex */
public class DecoderResult {
    protected static final Signal SIGNAL_SUCCESS;
    protected static final Signal SIGNAL_UNFINISHED;
    public static final DecoderResult SUCCESS;
    public static final DecoderResult UNFINISHED;
    private final Throwable cause;

    static {
        Signal signalValueOf = Signal.valueOf(DecoderResult.class, "UNFINISHED");
        SIGNAL_UNFINISHED = signalValueOf;
        Signal signalValueOf2 = Signal.valueOf(DecoderResult.class, "SUCCESS");
        SIGNAL_SUCCESS = signalValueOf2;
        UNFINISHED = new DecoderResult(signalValueOf);
        SUCCESS = new DecoderResult(signalValueOf2);
    }

    public DecoderResult(Throwable th2) {
        this.cause = (Throwable) ObjectUtil.checkNotNull(th2, "cause");
    }

    public static DecoderResult failure(Throwable th2) {
        return new DecoderResult((Throwable) ObjectUtil.checkNotNull(th2, "cause"));
    }

    public Throwable cause() {
        if (isFailure()) {
            return this.cause;
        }
        return null;
    }

    public boolean isFailure() {
        Throwable th2 = this.cause;
        return (th2 == SIGNAL_SUCCESS || th2 == SIGNAL_UNFINISHED) ? false : true;
    }

    public boolean isFinished() {
        return this.cause != SIGNAL_UNFINISHED;
    }

    public boolean isSuccess() {
        return this.cause == SIGNAL_SUCCESS;
    }

    public String toString() {
        if (!isFinished()) {
            return "unfinished";
        }
        if (isSuccess()) {
            return "success";
        }
        String string = cause().toString();
        StringBuilder sb2 = new StringBuilder(string.length() + 17);
        sb2.append("failure(");
        sb2.append(string);
        sb2.append(')');
        return sb2.toString();
    }
}
