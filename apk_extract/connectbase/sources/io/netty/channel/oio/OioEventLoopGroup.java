package io.netty.channel.oio;

import io.netty.channel.ThreadPerChannelEventLoopGroup;
import java.util.concurrent.Executor;
import java.util.concurrent.ThreadFactory;

/* JADX INFO: loaded from: classes2.dex */
@Deprecated
public class OioEventLoopGroup extends ThreadPerChannelEventLoopGroup {
    public OioEventLoopGroup() {
        this(0);
    }

    public OioEventLoopGroup(int i10) {
        this(i10, (ThreadFactory) null);
    }

    public OioEventLoopGroup(int i10, Executor executor) {
        super(i10, executor, new Object[0]);
    }

    public OioEventLoopGroup(int i10, ThreadFactory threadFactory) {
        super(i10, threadFactory, new Object[0]);
    }
}
