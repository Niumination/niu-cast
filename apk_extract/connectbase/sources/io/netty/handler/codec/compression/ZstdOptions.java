package io.netty.handler.codec.compression;

import io.netty.util.internal.ObjectUtil;

/* JADX INFO: loaded from: classes3.dex */
public class ZstdOptions implements CompressionOptions {
    static final ZstdOptions DEFAULT = new ZstdOptions(3, 65536, 33554432);
    private final int blockSize;
    private final int compressionLevel;
    private final int maxEncodeSize;

    public ZstdOptions(int i10, int i11, int i12) {
        if (!Zstd.isAvailable()) {
            throw new IllegalStateException("zstd-jni is not available", Zstd.cause());
        }
        this.compressionLevel = ObjectUtil.checkInRange(i10, 0, 22, "compressionLevel");
        this.blockSize = ObjectUtil.checkPositive(i11, "blockSize");
        this.maxEncodeSize = ObjectUtil.checkPositive(i12, "maxEncodeSize");
    }

    public int blockSize() {
        return this.blockSize;
    }

    public int compressionLevel() {
        return this.compressionLevel;
    }

    public int maxEncodeSize() {
        return this.maxEncodeSize;
    }
}
