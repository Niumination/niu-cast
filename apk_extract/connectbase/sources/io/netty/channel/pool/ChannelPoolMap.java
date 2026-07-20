package io.netty.channel.pool;

import io.netty.channel.pool.ChannelPool;

/* JADX INFO: loaded from: classes2.dex */
public interface ChannelPoolMap<K, P extends ChannelPool> {
    boolean contains(K k10);

    P get(K k10);
}
