package io.netty.handler.ssl;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.util.CharsetUtil;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.ScheduledFuture;
import io.netty.util.internal.ObjectUtil;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import k.d;

/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractSniHandler<T> extends SslClientHelloHandler<T> {
    protected final long handshakeTimeoutMillis;
    private String hostname;
    private ScheduledFuture<?> timeoutFuture;

    public AbstractSniHandler(long j10) {
        this(0, j10);
    }

    private void checkStartTimeout(final ChannelHandlerContext channelHandlerContext) {
        if (this.handshakeTimeoutMillis <= 0 || this.timeoutFuture != null) {
            return;
        }
        this.timeoutFuture = channelHandlerContext.executor().schedule(new Runnable() { // from class: io.netty.handler.ssl.AbstractSniHandler.1
            @Override // java.lang.Runnable
            public void run() {
                if (channelHandlerContext.channel().isActive()) {
                    channelHandlerContext.fireUserEventTriggered((Object) new SniCompletionEvent(new SslHandshakeTimeoutException(d.a(new StringBuilder("handshake timed out after "), AbstractSniHandler.this.handshakeTimeoutMillis, "ms"))));
                    channelHandlerContext.close();
                }
            }
        }, this.handshakeTimeoutMillis, TimeUnit.MILLISECONDS);
    }

    private static String extractSniHostname(ByteBuf byteBuf) {
        int i10 = byteBuf.readerIndex();
        int iWriterIndex = byteBuf.writerIndex();
        int i11 = i10 + 34;
        if (iWriterIndex - i11 < 6) {
            return null;
        }
        int unsignedByte = byteBuf.getUnsignedByte(i11) + 1 + i11;
        int unsignedShort = byteBuf.getUnsignedShort(unsignedByte) + 2 + unsignedByte;
        int unsignedByte2 = byteBuf.getUnsignedByte(unsignedShort) + 1 + unsignedShort;
        int unsignedShort2 = byteBuf.getUnsignedShort(unsignedByte2);
        int i12 = unsignedByte2 + 2;
        int i13 = unsignedShort2 + i12;
        if (i13 > iWriterIndex) {
            return null;
        }
        while (i13 - i12 >= 4) {
            int unsignedShort3 = byteBuf.getUnsignedShort(i12);
            int unsignedShort4 = byteBuf.getUnsignedShort(i12 + 2);
            int i14 = i12 + 4;
            if (i13 - i14 < unsignedShort4) {
                return null;
            }
            if (unsignedShort3 == 0) {
                int i15 = i12 + 6;
                if (i13 - i15 < 3) {
                    return null;
                }
                int i16 = i12 + 7;
                if (byteBuf.getUnsignedByte(i15) != 0) {
                    return null;
                }
                int unsignedShort5 = byteBuf.getUnsignedShort(i16);
                int i17 = i12 + 9;
                if (i13 - i17 < unsignedShort5) {
                    return null;
                }
                return byteBuf.toString(i17, unsignedShort5, CharsetUtil.US_ASCII).toLowerCase(Locale.US);
            }
            i12 = i14 + unsignedShort4;
        }
        return null;
    }

    private static void fireSniCompletionEvent(ChannelHandlerContext channelHandlerContext, String str, Future<?> future) {
        Throwable thCause = future.cause();
        if (thCause == null) {
            channelHandlerContext.fireUserEventTriggered((Object) new SniCompletionEvent(str));
        } else {
            channelHandlerContext.fireUserEventTriggered((Object) new SniCompletionEvent(str, thCause));
        }
    }

    @Override // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelInboundHandler
    public void channelActive(ChannelHandlerContext channelHandlerContext) throws Exception {
        channelHandlerContext.fireChannelActive();
        checkStartTimeout(channelHandlerContext);
    }

    @Override // io.netty.channel.ChannelHandlerAdapter, io.netty.channel.ChannelHandler
    public void handlerAdded(ChannelHandlerContext channelHandlerContext) throws Exception {
        if (channelHandlerContext.channel().isActive()) {
            checkStartTimeout(channelHandlerContext);
        }
    }

    @Override // io.netty.handler.ssl.SslClientHelloHandler
    public Future<T> lookup(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf) throws Exception {
        String strExtractSniHostname = byteBuf == null ? null : extractSniHostname(byteBuf);
        this.hostname = strExtractSniHostname;
        return lookup(channelHandlerContext, strExtractSniHostname);
    }

    public abstract Future<T> lookup(ChannelHandlerContext channelHandlerContext, String str) throws Exception;

    @Override // io.netty.handler.ssl.SslClientHelloHandler
    public void onLookupComplete(ChannelHandlerContext channelHandlerContext, Future<T> future) throws Exception {
        ScheduledFuture<?> scheduledFuture = this.timeoutFuture;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(false);
        }
        try {
            onLookupComplete(channelHandlerContext, this.hostname, future);
        } finally {
            fireSniCompletionEvent(channelHandlerContext, this.hostname, future);
        }
    }

    public abstract void onLookupComplete(ChannelHandlerContext channelHandlerContext, String str, Future<T> future) throws Exception;

    public AbstractSniHandler(int i10, long j10) {
        super(i10);
        this.handshakeTimeoutMillis = ObjectUtil.checkPositiveOrZero(j10, "handshakeTimeoutMillis");
    }

    public AbstractSniHandler() {
        this(0, 0L);
    }
}
