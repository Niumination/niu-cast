package io.netty.buffer;

/* JADX INFO: loaded from: classes2.dex */
public interface SizeClassesMetric {
    int normalizeSize(int i10);

    long pageIdx2size(int i10);

    long pageIdx2sizeCompute(int i10);

    int pages2pageIdx(int i10);

    int pages2pageIdxFloor(int i10);

    int size2SizeIdx(int i10);

    int sizeIdx2size(int i10);

    int sizeIdx2sizeCompute(int i10);
}
