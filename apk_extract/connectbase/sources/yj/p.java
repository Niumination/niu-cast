package yj;

import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelPromise;
import io.netty.handler.codec.http2.DecoratingHttp2ConnectionEncoder;
import io.netty.handler.codec.http2.Http2ConnectionEncoder;
import io.netty.handler.codec.http2.Http2Error;
import io.netty.handler.codec.http2.Http2Exception;
import io.netty.handler.codec.http2.Http2LifecycleManager;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GenericFutureListener;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;

/* JADX INFO: loaded from: classes2.dex */
public final class p extends DecoratingHttp2ConnectionEncoder {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final InternalLogger f21233f = InternalLoggerFactory.getInstance((Class<?>) p.class);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f21234a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ChannelFutureListener f21235b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Http2LifecycleManager f21236c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f21237d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f21238e;

    public class a implements ChannelFutureListener {
        public a() {
        }

        @Override // io.netty.util.concurrent.GenericFutureListener
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void operationComplete(ChannelFuture channelFuture) {
            p.c(p.this);
        }
    }

    public p(Http2ConnectionEncoder http2ConnectionEncoder, int i10) {
        super(http2ConnectionEncoder);
        this.f21235b = new a();
        this.f21234a = ObjectUtil.checkPositive(i10, "maxOutstandingControlFrames");
    }

    public static /* synthetic */ int c(p pVar) {
        int i10 = pVar.f21237d;
        pVar.f21237d = i10 - 1;
        return i10;
    }

    /* JADX WARN: Type inference failed for: r5v2, types: [io.netty.channel.ChannelPromise] */
    public final ChannelPromise handleOutstandingControlFrames(ChannelHandlerContext channelHandlerContext, ChannelPromise channelPromise) {
        if (this.f21238e) {
            return channelPromise;
        }
        if (this.f21237d == this.f21234a) {
            channelHandlerContext.flush();
        }
        int i10 = this.f21237d;
        int i11 = this.f21234a;
        if (i10 == i11) {
            this.f21238e = true;
            Http2Exception http2ExceptionConnectionError = Http2Exception.connectionError(Http2Error.ENHANCE_YOUR_CALM, "Maximum number %d of outstanding control frames reached", Integer.valueOf(i11));
            f21233f.info("Maximum number {} of outstanding control frames reached. Closing channel {}", Integer.valueOf(this.f21234a), channelHandlerContext.channel(), http2ExceptionConnectionError);
            this.f21236c.onError(channelHandlerContext, true, http2ExceptionConnectionError);
            channelHandlerContext.close();
        }
        this.f21237d++;
        return channelPromise.unvoid().addListener((GenericFutureListener<? extends Future<? super Void>>) this.f21235b);
    }

    @Override // io.netty.handler.codec.http2.DecoratingHttp2ConnectionEncoder, io.netty.handler.codec.http2.Http2ConnectionEncoder
    public void lifecycleManager(Http2LifecycleManager http2LifecycleManager) {
        this.f21236c = http2LifecycleManager;
        super.lifecycleManager(http2LifecycleManager);
    }

    @Override // io.netty.handler.codec.http2.DecoratingHttp2FrameWriter, io.netty.handler.codec.http2.Http2FrameWriter
    public ChannelFuture writePing(ChannelHandlerContext channelHandlerContext, boolean z10, long j10, ChannelPromise channelPromise) {
        if (!z10) {
            return super.writePing(channelHandlerContext, z10, j10, channelPromise);
        }
        ChannelPromise channelPromiseHandleOutstandingControlFrames = handleOutstandingControlFrames(channelHandlerContext, channelPromise);
        return channelPromiseHandleOutstandingControlFrames == null ? channelPromise : super.writePing(channelHandlerContext, z10, j10, channelPromiseHandleOutstandingControlFrames);
    }

    @Override // io.netty.handler.codec.http2.DecoratingHttp2FrameWriter, io.netty.handler.codec.http2.Http2FrameWriter
    public ChannelFuture writeRstStream(ChannelHandlerContext channelHandlerContext, int i10, long j10, ChannelPromise channelPromise) {
        ChannelPromise channelPromiseHandleOutstandingControlFrames = handleOutstandingControlFrames(channelHandlerContext, channelPromise);
        return channelPromiseHandleOutstandingControlFrames == null ? channelPromise : super.writeRstStream(channelHandlerContext, i10, j10, channelPromiseHandleOutstandingControlFrames);
    }

    @Override // io.netty.handler.codec.http2.DecoratingHttp2FrameWriter, io.netty.handler.codec.http2.Http2FrameWriter
    public ChannelFuture writeSettingsAck(ChannelHandlerContext channelHandlerContext, ChannelPromise channelPromise) {
        ChannelPromise channelPromiseHandleOutstandingControlFrames = handleOutstandingControlFrames(channelHandlerContext, channelPromise);
        return channelPromiseHandleOutstandingControlFrames == null ? channelPromise : super.writeSettingsAck(channelHandlerContext, channelPromiseHandleOutstandingControlFrames);
    }
}
