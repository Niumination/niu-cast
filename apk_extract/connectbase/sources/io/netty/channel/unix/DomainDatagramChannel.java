package io.netty.channel.unix;

import io.netty.channel.Channel;

/* JADX INFO: loaded from: classes2.dex */
public interface DomainDatagramChannel extends UnixChannel, Channel {
    @Override // io.netty.channel.Channel
    DomainDatagramChannelConfig config();

    boolean isConnected();

    @Override // io.netty.channel.Channel
    DomainSocketAddress localAddress();

    @Override // io.netty.channel.Channel
    DomainSocketAddress remoteAddress();
}
