package io.netty.handler.timeout;

import io.netty.util.internal.PlatformDependent;

/* JADX INFO: loaded from: classes3.dex */
public final class WriteTimeoutException extends TimeoutException {
    public static final WriteTimeoutException INSTANCE;
    private static final long serialVersionUID = -144786655770296065L;

    static {
        INSTANCE = PlatformDependent.javaVersion() >= 7 ? new WriteTimeoutException(true) : new WriteTimeoutException();
    }

    public WriteTimeoutException() {
    }

    public WriteTimeoutException(String str) {
        super(str, false);
    }

    private WriteTimeoutException(boolean z10) {
        super(null, z10);
    }
}
