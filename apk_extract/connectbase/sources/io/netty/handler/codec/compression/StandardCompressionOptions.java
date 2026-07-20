package io.netty.handler.codec.compression;

import com.aayushatharva.brotli4j.encoder.Encoder;

/* JADX INFO: loaded from: classes3.dex */
public final class StandardCompressionOptions {
    private StandardCompressionOptions() {
    }

    public static BrotliOptions brotli() {
        return BrotliOptions.DEFAULT;
    }

    public static DeflateOptions deflate() {
        return DeflateOptions.DEFAULT;
    }

    public static GzipOptions gzip() {
        return GzipOptions.DEFAULT;
    }

    public static SnappyOptions snappy() {
        return new SnappyOptions();
    }

    public static ZstdOptions zstd() {
        return ZstdOptions.DEFAULT;
    }

    public static BrotliOptions brotli(Encoder.Parameters parameters) {
        return new BrotliOptions(parameters);
    }

    public static DeflateOptions deflate(int i10, int i11, int i12) {
        return new DeflateOptions(i10, i11, i12);
    }

    public static GzipOptions gzip(int i10, int i11, int i12) {
        return new GzipOptions(i10, i11, i12);
    }

    public static ZstdOptions zstd(int i10, int i11, int i12) {
        return new ZstdOptions(i10, i11, i12);
    }
}
