package io.netty.buffer;

/* JADX INFO: loaded from: classes2.dex */
public interface PoolChunkListMetric extends Iterable<PoolChunkMetric> {
    int maxUsage();

    int minUsage();
}
