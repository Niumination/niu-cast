package io.netty.handler.codec.http2;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.util.internal.ObjectUtil;

/* JADX INFO: loaded from: classes3.dex */
public class Http2FrameListenerDecorator implements Http2FrameListener {
    protected final Http2FrameListener listener;

    public Http2FrameListenerDecorator(Http2FrameListener http2FrameListener) {
        this.listener = (Http2FrameListener) ObjectUtil.checkNotNull(http2FrameListener, "listener");
    }

    @Override // io.netty.handler.codec.http2.Http2FrameListener
    public int onDataRead(ChannelHandlerContext channelHandlerContext, int i10, ByteBuf byteBuf, int i11, boolean z10) throws Http2Exception {
        return this.listener.onDataRead(channelHandlerContext, i10, byteBuf, i11, z10);
    }

    @Override // io.netty.handler.codec.http2.Http2FrameListener
    public void onGoAwayRead(ChannelHandlerContext channelHandlerContext, int i10, long j10, ByteBuf byteBuf) throws Http2Exception {
        this.listener.onGoAwayRead(channelHandlerContext, i10, j10, byteBuf);
    }

    @Override // io.netty.handler.codec.http2.Http2FrameListener
    public void onHeadersRead(ChannelHandlerContext channelHandlerContext, int i10, Http2Headers http2Headers, int i11, boolean z10) throws Http2Exception {
        this.listener.onHeadersRead(channelHandlerContext, i10, http2Headers, i11, z10);
    }

    @Override // io.netty.handler.codec.http2.Http2FrameListener
    public void onPingAckRead(ChannelHandlerContext channelHandlerContext, long j10) throws Http2Exception {
        this.listener.onPingAckRead(channelHandlerContext, j10);
    }

    @Override // io.netty.handler.codec.http2.Http2FrameListener
    public void onPingRead(ChannelHandlerContext channelHandlerContext, long j10) throws Http2Exception {
        this.listener.onPingRead(channelHandlerContext, j10);
    }

    @Override // io.netty.handler.codec.http2.Http2FrameListener
    public void onPriorityRead(ChannelHandlerContext channelHandlerContext, int i10, int i11, short s10, boolean z10) throws Http2Exception {
        this.listener.onPriorityRead(channelHandlerContext, i10, i11, s10, z10);
    }

    @Override // io.netty.handler.codec.http2.Http2FrameListener
    public void onPushPromiseRead(ChannelHandlerContext channelHandlerContext, int i10, int i11, Http2Headers http2Headers, int i12) throws Http2Exception {
        this.listener.onPushPromiseRead(channelHandlerContext, i10, i11, http2Headers, i12);
    }

    @Override // io.netty.handler.codec.http2.Http2FrameListener
    public void onRstStreamRead(ChannelHandlerContext channelHandlerContext, int i10, long j10) throws Http2Exception {
        this.listener.onRstStreamRead(channelHandlerContext, i10, j10);
    }

    @Override // io.netty.handler.codec.http2.Http2FrameListener
    public void onSettingsAckRead(ChannelHandlerContext channelHandlerContext) throws Http2Exception {
        this.listener.onSettingsAckRead(channelHandlerContext);
    }

    @Override // io.netty.handler.codec.http2.Http2FrameListener
    public void onSettingsRead(ChannelHandlerContext channelHandlerContext, Http2Settings http2Settings) throws Http2Exception {
        this.listener.onSettingsRead(channelHandlerContext, http2Settings);
    }

    @Override // io.netty.handler.codec.http2.Http2FrameListener
    public void onUnknownFrame(ChannelHandlerContext channelHandlerContext, byte b10, int i10, Http2Flags http2Flags, ByteBuf byteBuf) throws Http2Exception {
        this.listener.onUnknownFrame(channelHandlerContext, b10, i10, http2Flags, byteBuf);
    }

    @Override // io.netty.handler.codec.http2.Http2FrameListener
    public void onWindowUpdateRead(ChannelHandlerContext channelHandlerContext, int i10, int i11) throws Http2Exception {
        this.listener.onWindowUpdateRead(channelHandlerContext, i10, i11);
    }

    @Override // io.netty.handler.codec.http2.Http2FrameListener
    public void onHeadersRead(ChannelHandlerContext channelHandlerContext, int i10, Http2Headers http2Headers, int i11, short s10, boolean z10, int i12, boolean z11) throws Http2Exception {
        this.listener.onHeadersRead(channelHandlerContext, i10, http2Headers, i11, s10, z10, i12, z11);
    }
}
