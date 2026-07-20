package io.netty.handler.codec.http2;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.util.internal.ObjectUtil;

/* JADX INFO: loaded from: classes3.dex */
final class Http2EmptyDataFrameListener extends Http2FrameListenerDecorator {
    private int emptyDataFrames;
    private final int maxConsecutiveEmptyFrames;
    private boolean violationDetected;

    public Http2EmptyDataFrameListener(Http2FrameListener http2FrameListener, int i10) {
        super(http2FrameListener);
        this.maxConsecutiveEmptyFrames = ObjectUtil.checkPositive(i10, "maxConsecutiveEmptyFrames");
    }

    @Override // io.netty.handler.codec.http2.Http2FrameListenerDecorator, io.netty.handler.codec.http2.Http2FrameListener
    public int onDataRead(ChannelHandlerContext channelHandlerContext, int i10, ByteBuf byteBuf, int i11, boolean z10) throws Http2Exception {
        if (z10 || byteBuf.isReadable()) {
            this.emptyDataFrames = 0;
        } else {
            int i12 = this.emptyDataFrames;
            this.emptyDataFrames = i12 + 1;
            int i13 = this.maxConsecutiveEmptyFrames;
            if (i12 == i13 && !this.violationDetected) {
                this.violationDetected = true;
                throw Http2Exception.connectionError(Http2Error.ENHANCE_YOUR_CALM, "Maximum number %d of empty data frames without end_of_stream flag received", Integer.valueOf(i13));
            }
        }
        return super.onDataRead(channelHandlerContext, i10, byteBuf, i11, z10);
    }

    @Override // io.netty.handler.codec.http2.Http2FrameListenerDecorator, io.netty.handler.codec.http2.Http2FrameListener
    public void onHeadersRead(ChannelHandlerContext channelHandlerContext, int i10, Http2Headers http2Headers, int i11, boolean z10) throws Http2Exception {
        this.emptyDataFrames = 0;
        super.onHeadersRead(channelHandlerContext, i10, http2Headers, i11, z10);
    }

    @Override // io.netty.handler.codec.http2.Http2FrameListenerDecorator, io.netty.handler.codec.http2.Http2FrameListener
    public void onHeadersRead(ChannelHandlerContext channelHandlerContext, int i10, Http2Headers http2Headers, int i11, short s10, boolean z10, int i12, boolean z11) throws Http2Exception {
        this.emptyDataFrames = 0;
        super.onHeadersRead(channelHandlerContext, i10, http2Headers, i11, s10, z10, i12, z11);
    }
}
