package io.netty.channel;

/* JADX INFO: loaded from: classes2.dex */
public class EventLoopException extends ChannelException {
    private static final long serialVersionUID = -8969100344583703616L;

    public EventLoopException() {
    }

    public EventLoopException(String str, Throwable th2) {
        super(str, th2);
    }

    public EventLoopException(String str) {
        super(str);
    }

    public EventLoopException(Throwable th2) {
        super(th2);
    }
}
