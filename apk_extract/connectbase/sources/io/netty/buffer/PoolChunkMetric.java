package io.netty.buffer;

/* JADX INFO: loaded from: classes2.dex */
public interface PoolChunkMetric {
    int chunkSize();

    int freeBytes();

    int usage();
}
