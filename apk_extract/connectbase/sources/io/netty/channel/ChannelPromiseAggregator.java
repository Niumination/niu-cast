package io.netty.channel;

import io.netty.util.concurrent.PromiseAggregator;

/* JADX INFO: loaded from: classes2.dex */
@Deprecated
public final class ChannelPromiseAggregator extends PromiseAggregator<Void, ChannelFuture> implements ChannelFutureListener {
    public ChannelPromiseAggregator(ChannelPromise channelPromise) {
        super(channelPromise);
    }
}
