package io.netty.handler.codec;

/* JADX INFO: loaded from: classes3.dex */
public class DecoderException extends CodecException {
    private static final long serialVersionUID = 6926716840699621852L;

    public DecoderException() {
    }

    public DecoderException(String str, Throwable th2) {
        super(str, th2);
    }

    public DecoderException(String str) {
        super(str);
    }

    public DecoderException(Throwable th2) {
        super(th2);
    }
}
