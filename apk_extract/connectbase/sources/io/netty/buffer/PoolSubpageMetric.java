package io.netty.buffer;

/* JADX INFO: loaded from: classes2.dex */
public interface PoolSubpageMetric {
    int elementSize();

    int maxNumElements();

    int numAvailable();

    int pageSize();
}
