package io.netty.handler.proxy;

import java.net.ConnectException;

/* JADX INFO: loaded from: classes3.dex */
public class ProxyConnectException extends ConnectException {
    private static final long serialVersionUID = 5211364632246265538L;

    public ProxyConnectException() {
    }

    public ProxyConnectException(String str) {
        super(str);
    }

    public ProxyConnectException(Throwable th2) {
        initCause(th2);
    }

    public ProxyConnectException(String str, Throwable th2) {
        super(str);
        initCause(th2);
    }
}
