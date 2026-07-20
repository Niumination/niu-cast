package io.netty.channel;

/* JADX INFO: loaded from: classes2.dex */
public class ChannelPipelineException extends ChannelException {
    private static final long serialVersionUID = 3379174210419885980L;

    public ChannelPipelineException() {
    }

    public ChannelPipelineException(String str, Throwable th2) {
        super(str, th2);
    }

    public ChannelPipelineException(String str) {
        super(str);
    }

    public ChannelPipelineException(Throwable th2) {
        super(th2);
    }
}
