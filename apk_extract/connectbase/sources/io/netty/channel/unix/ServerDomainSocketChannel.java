package io.netty.channel.unix;

import io.netty.channel.ServerChannel;

/* JADX INFO: loaded from: classes2.dex */
public interface ServerDomainSocketChannel extends ServerChannel, UnixChannel {
    @Override // io.netty.channel.Channel
    DomainSocketAddress localAddress();

    @Override // io.netty.channel.Channel
    DomainSocketAddress remoteAddress();
}
