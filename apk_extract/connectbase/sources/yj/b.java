package yj;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelPromise;
import io.netty.handler.codec.http2.Http2CodecUtil;
import io.netty.handler.codec.http2.Http2ConnectionDecoder;
import io.netty.handler.codec.http2.Http2ConnectionEncoder;
import io.netty.handler.codec.http2.Http2Exception;
import io.netty.handler.codec.http2.Http2FrameWriter;
import io.netty.handler.codec.http2.Http2LocalFlowController;
import io.netty.handler.codec.http2.Http2Settings;
import io.netty.handler.codec.http2.Http2Stream;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public abstract class b extends l {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final long f20854v = -1;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final long f20855w = 1234;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f20856e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final c f20857f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f20858g;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public ChannelHandlerContext f20859i;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f20860n;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final c1.u0 f20861p;

    /* JADX INFO: renamed from: yj.b$b, reason: collision with other inner class name */
    public static final class C0539b implements d {
        public C0539b() {
        }

        @Override // yj.b.d
        public boolean b() {
            return true;
        }

        public C0539b(a aVar) {
        }
    }

    public final class c {

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public static final int f20862k = 8388608;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public static final int f20863l = 10;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final d f20864a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f20865b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f20866c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f20867d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f20868e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public long f20869f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public long f20870g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public int f20871h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public int f20872i;

        public c(d dVar) {
            c1.h0.F(dVar, "pingLimiter");
            this.f20864a = dVar;
        }

        @b1.e
        public int a() {
            return this.f20868e;
        }

        @b1.e
        public int b() {
            return this.f20865b;
        }

        @b1.e
        public int c() {
            return this.f20866c;
        }

        public final void d(int i10) {
            this.f20868e += i10;
        }

        public final boolean e() {
            return this.f20867d;
        }

        public int f() {
            return 8388608;
        }

        public void g(int i10, int i11) {
            if (b.this.f20858g) {
                int i12 = this.f20868e + i10 + i11;
                if (!this.f20867d && this.f20864a.b() && i12 * 2 >= this.f20871h * this.f20872i) {
                    this.f20867d = true;
                    i(b.this.f20859i);
                }
                if (this.f20871h == 0) {
                    this.f20871h = b.this.decoder().flowController().initialWindowSize(b.this.connection().connectionStream());
                }
                d(i10 + i11);
            }
        }

        public long h() {
            return b.f20855w;
        }

        public final void i(ChannelHandlerContext channelHandlerContext) {
            this.f20868e = 0;
            this.f20870g = b.this.f20861p.a();
            b.this.encoder().writePing(channelHandlerContext, false, b.f20855w, channelHandlerContext.newPromise());
            this.f20865b++;
        }

        @b1.e
        public void j(int i10) {
            this.f20868e = i10;
            this.f20872i = 1;
            this.f20870g = b.this.f20861p.a();
        }

        public final void k(int i10) {
            this.f20868e = i10;
        }

        public final void l(boolean z10) {
            this.f20867d = z10;
        }

        public void m() throws Http2Exception {
            if (b.this.f20858g) {
                this.f20866c++;
                this.f20867d = false;
                long jA = b.this.f20861p.a() - this.f20870g;
                if (jA == 0) {
                    jA = 1;
                }
                long nanos = (TimeUnit.SECONDS.toNanos(1L) * ((long) this.f20868e)) / jA;
                int iMin = Math.min(this.f20868e * 2, 8388608);
                Http2LocalFlowController http2LocalFlowControllerFlowController = b.this.decoder().flowController();
                int iInitialWindowSize = http2LocalFlowControllerFlowController.initialWindowSize(b.this.connection().connectionStream());
                if (nanos <= this.f20869f || iMin <= iInitialWindowSize) {
                    this.f20872i = Math.min(this.f20872i + 1, 10);
                    return;
                }
                this.f20872i = 0;
                this.f20869f = nanos;
                this.f20871h = iMin;
                http2LocalFlowControllerFlowController.incrementWindowSize(b.this.connection().connectionStream(), iMin - iInitialWindowSize);
                http2LocalFlowControllerFlowController.initialWindowSize(iMin);
                Http2Settings http2Settings = new Http2Settings();
                http2Settings.initialWindowSize(iMin);
                Http2FrameWriter http2FrameWriterFrameWriter = b.this.frameWriter();
                ChannelHandlerContext channelHandlerContext = b.this.f20859i;
                http2FrameWriterFrameWriter.writeSettings(channelHandlerContext, http2Settings, channelHandlerContext.newPromise());
            }
        }
    }

    public interface d {
        boolean b();
    }

    public b(ChannelPromise channelPromise, Http2ConnectionDecoder http2ConnectionDecoder, Http2ConnectionEncoder http2ConnectionEncoder, Http2Settings http2Settings, vj.h hVar, boolean z10, d dVar, c1.u0 u0Var) {
        super(channelPromise, http2ConnectionDecoder, http2ConnectionEncoder, http2Settings, hVar);
        this.f20860n = false;
        gracefulShutdownTimeoutMillis(-1L);
        this.f20856e = http2Settings.initialWindowSize() == null ? -1 : http2Settings.initialWindowSize().intValue();
        this.f20858g = z10;
        this.f20857f = new c(dVar == null ? new C0539b() : dVar);
        this.f20861p = (c1.u0) c1.h0.F(u0Var, "ticker");
    }

    @b1.e
    public c O() {
        return this.f20857f;
    }

    @Override // io.netty.handler.codec.http2.Http2ConnectionHandler, io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelInboundHandler
    public void channelActive(ChannelHandlerContext channelHandlerContext) throws Exception {
        super.channelActive(channelHandlerContext);
        e0();
    }

    public final ChannelHandlerContext ctx() {
        return this.f20859i;
    }

    public final void e0() throws Http2Exception {
        if (this.f20860n || !this.f20859i.channel().isActive()) {
            return;
        }
        Http2Stream http2StreamConnectionStream = connection().connectionStream();
        decoder().flowController().incrementWindowSize(http2StreamConnectionStream, this.f20856e - ((Http2LocalFlowController) connection().local().flowController()).windowSize(http2StreamConnectionStream));
        this.f20860n = true;
        this.f20859i.flush();
    }

    @Override // io.netty.handler.codec.http2.Http2ConnectionHandler, io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelHandlerAdapter, io.netty.channel.ChannelHandler, io.netty.channel.ChannelInboundHandler
    public final void exceptionCaught(ChannelHandlerContext channelHandlerContext, Throwable th2) throws Exception {
        if (Http2CodecUtil.getEmbeddedHttp2Exception(th2) == null) {
            onError(channelHandlerContext, false, th2);
        } else {
            super.exceptionCaught(channelHandlerContext, th2);
        }
    }

    @b1.e
    public void g0(boolean z10) {
        this.f20858g = z10;
    }

    @Override // io.netty.handler.codec.http2.Http2ConnectionHandler, io.netty.channel.ChannelHandlerAdapter, io.netty.channel.ChannelHandler
    public void handlerAdded(ChannelHandlerContext channelHandlerContext) throws Exception {
        this.f20859i = channelHandlerContext;
        super.handlerAdded(channelHandlerContext);
        e0();
    }
}
