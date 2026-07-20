package io.netty.channel;

import io.netty.util.internal.ObjectUtil;

/* JADX INFO: loaded from: classes2.dex */
public final class ChannelMetadata {
    private final int defaultMaxMessagesPerRead;
    private final boolean hasDisconnect;

    public ChannelMetadata(boolean z10) {
        this(z10, 1);
    }

    public int defaultMaxMessagesPerRead() {
        return this.defaultMaxMessagesPerRead;
    }

    public boolean hasDisconnect() {
        return this.hasDisconnect;
    }

    public ChannelMetadata(boolean z10, int i10) {
        ObjectUtil.checkPositive(i10, "defaultMaxMessagesPerRead");
        this.hasDisconnect = z10;
        this.defaultMaxMessagesPerRead = i10;
    }
}
