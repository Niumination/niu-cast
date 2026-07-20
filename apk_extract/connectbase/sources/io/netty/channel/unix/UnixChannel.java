package io.netty.channel.unix;

import io.netty.channel.Channel;

/* JADX INFO: loaded from: classes2.dex */
public interface UnixChannel extends Channel {
    FileDescriptor fd();
}
