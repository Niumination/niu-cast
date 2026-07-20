package io.netty.channel.socket;

import io.netty.buffer.ByteBufAllocator;
import io.netty.channel.MessageSizeEstimator;
import io.netty.channel.RecvByteBufAllocator;
import io.netty.channel.WriteBufferWaterMark;

/* JADX INFO: loaded from: classes2.dex */
public interface SocketChannelConfig extends DuplexChannelConfig {
    int getReceiveBufferSize();

    int getSendBufferSize();

    int getSoLinger();

    int getTrafficClass();

    boolean isKeepAlive();

    boolean isReuseAddress();

    boolean isTcpNoDelay();

    @Override // io.netty.channel.socket.DuplexChannelConfig, io.netty.channel.ChannelConfig
    SocketChannelConfig setAllocator(ByteBufAllocator byteBufAllocator);

    @Override // io.netty.channel.socket.DuplexChannelConfig
    SocketChannelConfig setAllowHalfClosure(boolean z10);

    @Override // io.netty.channel.socket.DuplexChannelConfig, io.netty.channel.ChannelConfig
    SocketChannelConfig setAutoClose(boolean z10);

    @Override // io.netty.channel.socket.DuplexChannelConfig, io.netty.channel.ChannelConfig
    SocketChannelConfig setAutoRead(boolean z10);

    @Override // io.netty.channel.ChannelConfig
    SocketChannelConfig setConnectTimeoutMillis(int i10);

    SocketChannelConfig setKeepAlive(boolean z10);

    @Override // io.netty.channel.socket.DuplexChannelConfig, io.netty.channel.ChannelConfig
    @Deprecated
    SocketChannelConfig setMaxMessagesPerRead(int i10);

    @Override // io.netty.channel.socket.DuplexChannelConfig, io.netty.channel.ChannelConfig
    SocketChannelConfig setMessageSizeEstimator(MessageSizeEstimator messageSizeEstimator);

    SocketChannelConfig setPerformancePreferences(int i10, int i11, int i12);

    SocketChannelConfig setReceiveBufferSize(int i10);

    @Override // io.netty.channel.socket.DuplexChannelConfig, io.netty.channel.ChannelConfig
    SocketChannelConfig setRecvByteBufAllocator(RecvByteBufAllocator recvByteBufAllocator);

    SocketChannelConfig setReuseAddress(boolean z10);

    SocketChannelConfig setSendBufferSize(int i10);

    SocketChannelConfig setSoLinger(int i10);

    SocketChannelConfig setTcpNoDelay(boolean z10);

    SocketChannelConfig setTrafficClass(int i10);

    @Override // io.netty.channel.socket.DuplexChannelConfig, io.netty.channel.ChannelConfig
    SocketChannelConfig setWriteBufferWaterMark(WriteBufferWaterMark writeBufferWaterMark);

    @Override // io.netty.channel.socket.DuplexChannelConfig, io.netty.channel.ChannelConfig
    SocketChannelConfig setWriteSpinCount(int i10);
}
