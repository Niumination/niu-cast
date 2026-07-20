package io.netty.util.concurrent;

/* JADX INFO: loaded from: classes3.dex */
public class BlockingOperationException extends IllegalStateException {
    private static final long serialVersionUID = 2462223247762460301L;

    public BlockingOperationException() {
    }

    public BlockingOperationException(String str) {
        super(str);
    }

    public BlockingOperationException(Throwable th2) {
        super(th2);
    }

    public BlockingOperationException(String str, Throwable th2) {
        super(str, th2);
    }
}
