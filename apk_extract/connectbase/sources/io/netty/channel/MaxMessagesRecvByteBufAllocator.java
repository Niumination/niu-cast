package io.netty.channel;

/* JADX INFO: loaded from: classes2.dex */
public interface MaxMessagesRecvByteBufAllocator extends RecvByteBufAllocator {
    int maxMessagesPerRead();

    MaxMessagesRecvByteBufAllocator maxMessagesPerRead(int i10);
}
