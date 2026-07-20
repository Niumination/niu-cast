package io.netty.bootstrap;

import io.netty.channel.Channel;

/* JADX INFO: loaded from: classes2.dex */
@Deprecated
public interface ChannelFactory<T extends Channel> {
    T newChannel();
}
