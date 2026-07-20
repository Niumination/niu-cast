package io.netty.channel;

import java.nio.channels.ClosedChannelException;

/* JADX INFO: loaded from: classes2.dex */
final class ExtendedClosedChannelException extends ClosedChannelException {
    public ExtendedClosedChannelException(Throwable th2) {
        if (th2 != null) {
            initCause(th2);
        }
    }

    @Override // java.lang.Throwable
    public Throwable fillInStackTrace() {
        return this;
    }
}
