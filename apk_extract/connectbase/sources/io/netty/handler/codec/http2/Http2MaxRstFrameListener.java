package io.netty.handler.codec.http2;

import io.netty.channel.ChannelHandlerContext;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes3.dex */
final class Http2MaxRstFrameListener extends Http2FrameListenerDecorator {
    private static final InternalLogger logger = InternalLoggerFactory.getInstance((Class<?>) Http2MaxRstFrameListener.class);
    private long lastRstFrameNano;
    private final int maxRstFramesPerWindow;
    private final long nanosPerWindow;
    private int receivedRstInWindow;

    public Http2MaxRstFrameListener(Http2FrameListener http2FrameListener, int i10, int i11) {
        super(http2FrameListener);
        this.lastRstFrameNano = System.nanoTime();
        this.maxRstFramesPerWindow = i10;
        this.nanosPerWindow = TimeUnit.SECONDS.toNanos(i11);
    }

    @Override // io.netty.handler.codec.http2.Http2FrameListenerDecorator, io.netty.handler.codec.http2.Http2FrameListener
    public void onRstStreamRead(ChannelHandlerContext channelHandlerContext, int i10, long j10) throws Http2Exception {
        long jNanoTime = System.nanoTime();
        if (jNanoTime - this.lastRstFrameNano >= this.nanosPerWindow) {
            this.lastRstFrameNano = jNanoTime;
            this.receivedRstInWindow = 1;
        } else {
            int i11 = this.receivedRstInWindow + 1;
            this.receivedRstInWindow = i11;
            if (i11 > this.maxRstFramesPerWindow) {
                Http2Exception http2ExceptionConnectionError = Http2Exception.connectionError(Http2Error.ENHANCE_YOUR_CALM, "Maximum number of RST frames reached", new Object[0]);
                logger.debug("{} Maximum number {} of RST frames reached within {} seconds, closing connection with {} error", channelHandlerContext.channel(), Integer.valueOf(this.maxRstFramesPerWindow), Long.valueOf(TimeUnit.NANOSECONDS.toSeconds(this.nanosPerWindow)), http2ExceptionConnectionError.error(), http2ExceptionConnectionError);
                throw http2ExceptionConnectionError;
            }
        }
        super.onRstStreamRead(channelHandlerContext, i10, j10);
    }
}
