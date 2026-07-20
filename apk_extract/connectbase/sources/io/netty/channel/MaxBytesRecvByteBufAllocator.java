package io.netty.channel;

import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public interface MaxBytesRecvByteBufAllocator extends RecvByteBufAllocator {
    int maxBytesPerIndividualRead();

    MaxBytesRecvByteBufAllocator maxBytesPerIndividualRead(int i10);

    int maxBytesPerRead();

    MaxBytesRecvByteBufAllocator maxBytesPerRead(int i10);

    MaxBytesRecvByteBufAllocator maxBytesPerReadPair(int i10, int i11);

    Map.Entry<Integer, Integer> maxBytesPerReadPair();
}
