package io.netty.channel;

import io.netty.util.concurrent.PromiseNotifier;

/* JADX INFO: loaded from: classes2.dex */
@Deprecated
public final class ChannelPromiseNotifier extends PromiseNotifier<Void, ChannelFuture> implements ChannelFutureListener {
    public ChannelPromiseNotifier(ChannelPromise... channelPromiseArr) {
        super(channelPromiseArr);
    }

    public ChannelPromiseNotifier(boolean z10, ChannelPromise... channelPromiseArr) {
        super(z10, channelPromiseArr);
    }
}
