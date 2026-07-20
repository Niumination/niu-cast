package io.netty.handler.codec.http2;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;

/* JADX INFO: loaded from: classes3.dex */
public interface Http2FrameListener {
    int onDataRead(ChannelHandlerContext channelHandlerContext, int i10, ByteBuf byteBuf, int i11, boolean z10) throws Http2Exception;

    void onGoAwayRead(ChannelHandlerContext channelHandlerContext, int i10, long j10, ByteBuf byteBuf) throws Http2Exception;

    void onHeadersRead(ChannelHandlerContext channelHandlerContext, int i10, Http2Headers http2Headers, int i11, short s10, boolean z10, int i12, boolean z11) throws Http2Exception;

    void onHeadersRead(ChannelHandlerContext channelHandlerContext, int i10, Http2Headers http2Headers, int i11, boolean z10) throws Http2Exception;

    void onPingAckRead(ChannelHandlerContext channelHandlerContext, long j10) throws Http2Exception;

    void onPingRead(ChannelHandlerContext channelHandlerContext, long j10) throws Http2Exception;

    void onPriorityRead(ChannelHandlerContext channelHandlerContext, int i10, int i11, short s10, boolean z10) throws Http2Exception;

    void onPushPromiseRead(ChannelHandlerContext channelHandlerContext, int i10, int i11, Http2Headers http2Headers, int i12) throws Http2Exception;

    void onRstStreamRead(ChannelHandlerContext channelHandlerContext, int i10, long j10) throws Http2Exception;

    void onSettingsAckRead(ChannelHandlerContext channelHandlerContext) throws Http2Exception;

    void onSettingsRead(ChannelHandlerContext channelHandlerContext, Http2Settings http2Settings) throws Http2Exception;

    void onUnknownFrame(ChannelHandlerContext channelHandlerContext, byte b10, int i10, Http2Flags http2Flags, ByteBuf byteBuf) throws Http2Exception;

    void onWindowUpdateRead(ChannelHandlerContext channelHandlerContext, int i10, int i11) throws Http2Exception;
}
