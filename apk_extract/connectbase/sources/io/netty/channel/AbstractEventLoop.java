package io.netty.channel;

import io.netty.util.concurrent.AbstractEventExecutor;

/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractEventLoop extends AbstractEventExecutor implements EventLoop {
    public AbstractEventLoop() {
    }

    public AbstractEventLoop(EventLoopGroup eventLoopGroup) {
        super(eventLoopGroup);
    }

    @Override // io.netty.util.concurrent.AbstractEventExecutor, io.netty.util.concurrent.EventExecutor, io.netty.util.concurrent.EventExecutorGroup
    public EventLoop next() {
        return (EventLoop) super.next();
    }

    @Override // io.netty.util.concurrent.AbstractEventExecutor, io.netty.util.concurrent.EventExecutor, io.netty.channel.EventLoop
    public EventLoopGroup parent() {
        return (EventLoopGroup) super.parent();
    }
}
