package io.netty.handler.codec.compression;

/* JADX INFO: loaded from: classes3.dex */
public final class GzipOptions extends DeflateOptions {
    static final GzipOptions DEFAULT = new GzipOptions(6, 15, 8);

    public GzipOptions(int i10, int i11, int i12) {
        super(i10, i11, i12);
    }
}
