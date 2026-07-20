package io.netty.channel;

import io.netty.util.concurrent.EventExecutorGroup;

/* JADX INFO: loaded from: classes2.dex */
public interface EventLoopGroup extends EventExecutorGroup {
    @Override // io.netty.util.concurrent.EventExecutorGroup
    EventLoop next();

    ChannelFuture register(Channel channel);

    @Deprecated
    ChannelFuture register(Channel channel, ChannelPromise channelPromise);

    ChannelFuture register(ChannelPromise channelPromise);
}
