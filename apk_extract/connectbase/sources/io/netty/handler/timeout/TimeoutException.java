package io.netty.handler.timeout;

import io.netty.channel.ChannelException;

/* JADX INFO: loaded from: classes3.dex */
public class TimeoutException extends ChannelException {
    private static final long serialVersionUID = 4673641882869672533L;

    public TimeoutException() {
    }

    @Override // java.lang.Throwable
    public Throwable fillInStackTrace() {
        return this;
    }

    public TimeoutException(String str, boolean z10) {
        super(str, null, z10);
    }
}
