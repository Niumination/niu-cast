package io.netty.handler.ssl;

import io.netty.util.internal.ThrowableUtil;
import javax.net.ssl.SSLHandshakeException;

/* JADX INFO: loaded from: classes3.dex */
final class StacklessSSLHandshakeException extends SSLHandshakeException {
    private static final long serialVersionUID = -1244781947804415549L;

    private StacklessSSLHandshakeException(String str) {
        super(str);
    }

    public static StacklessSSLHandshakeException newInstance(String str, Class<?> cls, String str2) {
        return (StacklessSSLHandshakeException) ThrowableUtil.unknownStackTrace(new StacklessSSLHandshakeException(str), cls, str2);
    }

    @Override // java.lang.Throwable
    public Throwable fillInStackTrace() {
        return this;
    }
}
