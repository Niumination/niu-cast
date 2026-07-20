package io.netty.channel.nio;

import java.nio.channels.SelectableChannel;
import java.nio.channels.SelectionKey;

/* JADX INFO: loaded from: classes2.dex */
public interface NioTask<C extends SelectableChannel> {
    void channelReady(C c10, SelectionKey selectionKey) throws Exception;

    void channelUnregistered(C c10, Throwable th2) throws Exception;
}
