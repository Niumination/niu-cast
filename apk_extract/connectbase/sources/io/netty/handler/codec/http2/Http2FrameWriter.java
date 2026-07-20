package io.netty.handler.codec.http2;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelPromise;
import java.io.Closeable;

/* JADX INFO: loaded from: classes3.dex */
public interface Http2FrameWriter extends Http2DataWriter, Closeable {

    public interface Configuration {
        Http2FrameSizePolicy frameSizePolicy();

        Http2HeadersEncoder.Configuration headersConfiguration();
    }

    void close();

    Configuration configuration();

    ChannelFuture writeFrame(ChannelHandlerContext channelHandlerContext, byte b10, int i10, Http2Flags http2Flags, ByteBuf byteBuf, ChannelPromise channelPromise);

    ChannelFuture writeGoAway(ChannelHandlerContext channelHandlerContext, int i10, long j10, ByteBuf byteBuf, ChannelPromise channelPromise);

    ChannelFuture writeHeaders(ChannelHandlerContext channelHandlerContext, int i10, Http2Headers http2Headers, int i11, short s10, boolean z10, int i12, boolean z11, ChannelPromise channelPromise);

    ChannelFuture writeHeaders(ChannelHandlerContext channelHandlerContext, int i10, Http2Headers http2Headers, int i11, boolean z10, ChannelPromise channelPromise);

    ChannelFuture writePing(ChannelHandlerContext channelHandlerContext, boolean z10, long j10, ChannelPromise channelPromise);

    ChannelFuture writePriority(ChannelHandlerContext channelHandlerContext, int i10, int i11, short s10, boolean z10, ChannelPromise channelPromise);

    ChannelFuture writePushPromise(ChannelHandlerContext channelHandlerContext, int i10, int i11, Http2Headers http2Headers, int i12, ChannelPromise channelPromise);

    ChannelFuture writeRstStream(ChannelHandlerContext channelHandlerContext, int i10, long j10, ChannelPromise channelPromise);

    ChannelFuture writeSettings(ChannelHandlerContext channelHandlerContext, Http2Settings http2Settings, ChannelPromise channelPromise);

    ChannelFuture writeSettingsAck(ChannelHandlerContext channelHandlerContext, ChannelPromise channelPromise);

    ChannelFuture writeWindowUpdate(ChannelHandlerContext channelHandlerContext, int i10, int i11, ChannelPromise channelPromise);
}
