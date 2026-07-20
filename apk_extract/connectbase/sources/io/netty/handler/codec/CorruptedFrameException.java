package io.netty.handler.codec;

/* JADX INFO: loaded from: classes3.dex */
public class CorruptedFrameException extends DecoderException {
    private static final long serialVersionUID = 3918052232492988408L;

    public CorruptedFrameException() {
    }

    public CorruptedFrameException(String str, Throwable th2) {
        super(str, th2);
    }

    public CorruptedFrameException(String str) {
        super(str);
    }

    public CorruptedFrameException(Throwable th2) {
        super(th2);
    }
}
