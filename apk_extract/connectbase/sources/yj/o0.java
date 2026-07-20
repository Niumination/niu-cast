package yj;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufUtil;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelPromise;
import io.netty.handler.codec.http.HttpHeaderNames;
import io.netty.handler.codec.http2.DecoratingHttp2FrameWriter;
import io.netty.handler.codec.http2.DefaultHttp2Connection;
import io.netty.handler.codec.http2.DefaultHttp2ConnectionDecoder;
import io.netty.handler.codec.http2.DefaultHttp2ConnectionEncoder;
import io.netty.handler.codec.http2.DefaultHttp2FrameReader;
import io.netty.handler.codec.http2.DefaultHttp2FrameWriter;
import io.netty.handler.codec.http2.DefaultHttp2Headers;
import io.netty.handler.codec.http2.DefaultHttp2LocalFlowController;
import io.netty.handler.codec.http2.DefaultHttp2RemoteFlowController;
import io.netty.handler.codec.http2.Http2Connection;
import io.netty.handler.codec.http2.Http2ConnectionAdapter;
import io.netty.handler.codec.http2.Http2ConnectionDecoder;
import io.netty.handler.codec.http2.Http2ConnectionEncoder;
import io.netty.handler.codec.http2.Http2Error;
import io.netty.handler.codec.http2.Http2Exception;
import io.netty.handler.codec.http2.Http2FrameAdapter;
import io.netty.handler.codec.http2.Http2FrameLogger;
import io.netty.handler.codec.http2.Http2FrameReader;
import io.netty.handler.codec.http2.Http2FrameWriter;
import io.netty.handler.codec.http2.Http2Headers;
import io.netty.handler.codec.http2.Http2InboundFrameLogger;
import io.netty.handler.codec.http2.Http2OutboundFrameLogger;
import io.netty.handler.codec.http2.Http2Settings;
import io.netty.handler.codec.http2.Http2Stream;
import io.netty.handler.codec.http2.Http2StreamVisitor;
import io.netty.handler.codec.http2.WeightedFairQueueByteDistributor;
import io.netty.handler.logging.LogLevel;
import io.netty.util.AsciiString;
import io.netty.util.ReferenceCountUtil;
import io.netty.util.concurrent.GenericFutureListener;
import java.text.MessageFormat;
import java.util.List;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import vj.u2;
import vj.v1;
import vj.y2;
import wj.c3;
import wj.i3;
import wj.q3;
import wj.s1;

/* JADX INFO: loaded from: classes2.dex */
public class o0 extends yj.b {

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    public static final long f21190h0 = 57005;

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    @b1.e
    public static final long f21191i0 = 40715087873L;

    /* JADX INFO: renamed from: l0, reason: collision with root package name */
    public static final /* synthetic */ boolean f21194l0 = false;
    public final int H;
    public final long I;
    public final long J;
    public final long K;
    public final long L;
    public final int M;
    public final long N;
    public final List<? extends u2.a> O;
    public final q3 P;
    public final wj.i1 Q;
    public final vj.a R;
    public final c1.u0 S;
    public vj.a T;
    public vj.v0.f U;
    public vj.a V;
    public Throwable W;
    public boolean X;
    public k1 Y;
    public AsciiString Z;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    @gm.a
    public wj.j1 f21195a0;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    @gm.a
    public s1 f21196b0;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    @gm.a
    public ScheduledFuture<?> f21197c0;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    @gm.a
    public k f21198d0;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    public int f21199e0;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    public long f21200f0;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final Http2Connection.PropertyKey f21201x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final c3 f21202y;

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    public static final Logger f21189g0 = Logger.getLogger(o0.class.getName());

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    public static final long f21192j0 = TimeUnit.SECONDS.toNanos(10);

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public static final boolean f21193k0 = Boolean.parseBoolean(System.getProperty("io.grpc.netty.disableConnectionHeaderCheck", "false"));

    public class a extends Http2ConnectionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Http2Connection f21203a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ wj.i1 f21204b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ s1 f21205c;

        public a(Http2Connection http2Connection, wj.i1 i1Var, s1 s1Var) {
            this.f21203a = http2Connection;
            this.f21204b = i1Var;
            this.f21205c = s1Var;
        }

        @Override // io.netty.handler.codec.http2.Http2ConnectionAdapter, io.netty.handler.codec.http2.Http2Connection.Listener
        public void onStreamActive(Http2Stream http2Stream) {
            if (this.f21203a.numActiveStreams() == 1) {
                this.f21204b.f18737f = true;
                s1 s1Var = this.f21205c;
                if (s1Var != null) {
                    s1Var.h();
                }
            }
        }

        @Override // io.netty.handler.codec.http2.Http2ConnectionAdapter, io.netty.handler.codec.http2.Http2Connection.Listener
        public void onStreamClosed(Http2Stream http2Stream) {
            if (this.f21203a.numActiveStreams() == 0) {
                this.f21204b.f18737f = false;
                s1 s1Var = this.f21205c;
                if (s1Var != null) {
                    s1Var.i();
                }
            }
        }
    }

    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ChannelHandlerContext f21207a;

        public b(ChannelHandlerContext channelHandlerContext) {
            this.f21207a = channelHandlerContext;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (o0.this.f21198d0 == null) {
                o0 o0Var = o0.this;
                o0Var.f21198d0 = o0Var.new k("max_age", Long.valueOf(o0Var.L));
                o0.this.f21198d0.c(this.f21207a);
                this.f21207a.flush();
            }
        }
    }

    public class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ChannelHandlerContext f21209a;

        public c(ChannelHandlerContext channelHandlerContext) {
            this.f21209a = channelHandlerContext;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (o0.this.f21198d0 == null) {
                o0 o0Var = o0.this;
                o0Var.f21198d0 = o0Var.new k("max_idle", null);
                o0.this.f21198d0.c(this.f21209a);
                this.f21209a.flush();
            }
        }
    }

    public class d extends Http2Exception {
        public d(Http2Error http2Error, String str) {
            super(http2Error, str);
        }

        @Override // java.lang.Throwable
        public Throwable fillInStackTrace() {
            return this;
        }
    }

    public class e implements Http2StreamVisitor {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ y2 f21211a;

        public e(y2 y2Var) {
            this.f21211a = y2Var;
        }

        @Override // io.netty.handler.codec.http2.Http2StreamVisitor
        public boolean visit(Http2Stream http2Stream) throws Http2Exception {
            q0.c cVarF2 = o0.this.F2(http2Stream);
            if (cVarF2 == null) {
                return true;
            }
            cVarF2.K(this.f21211a);
            return true;
        }
    }

    public class f implements ChannelFutureListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Http2Stream f21213a;

        public f(Http2Stream http2Stream) {
            this.f21213a = http2Stream;
        }

        @Override // io.netty.util.concurrent.GenericFutureListener
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void operationComplete(ChannelFuture channelFuture) {
            o0.this.F2(this.f21213a).F();
        }
    }

    public class g extends IllegalStateException {
        public g(String str) {
            super(str);
        }

        @Override // java.lang.Throwable
        public synchronized Throwable fillInStackTrace() {
            return this;
        }
    }

    public class h implements Http2StreamVisitor {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ yj.i f21215a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ChannelHandlerContext f21216b;

        public h(yj.i iVar, ChannelHandlerContext channelHandlerContext) {
            this.f21215a = iVar;
            this.f21216b = channelHandlerContext;
        }

        @Override // io.netty.handler.codec.http2.Http2StreamVisitor
        public boolean visit(Http2Stream http2Stream) throws Http2Exception {
            q0.c cVarF2 = o0.this.F2(http2Stream);
            if (cVarF2 != null) {
                fm.f fVarZ = fm.c.z("NettyServerHandler.forcefulClose");
                try {
                    fm.c.a(cVarF2.d());
                    fm.c.n(this.f21215a.b());
                    cVarF2.K(this.f21215a.d());
                    o0.this.resetStream(this.f21216b, http2Stream.id(), Http2Error.CANCEL.code(), this.f21216b.newPromise());
                    if (fVarZ != null) {
                        fm.c.u();
                    }
                } catch (Throwable th2) {
                    if (fVarZ != null) {
                        try {
                            fm.c.u();
                        } catch (Throwable th3) {
                            th2.addSuppressed(th3);
                        }
                    }
                    throw th2;
                }
            }
            http2Stream.close();
            return true;
        }
    }

    public static /* synthetic */ class i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f21218a;

        static {
            int[] iArr = new int[vj.h.a.values().length];
            f21218a = iArr;
            try {
                iArr[vj.h.a.ERROR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f21218a[vj.h.a.WARNING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public final class k {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f21221a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @gm.a
        public Long f21222b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f21223c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Future<?> f21224d;

        public class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ ChannelHandlerContext f21226a;

            public a(ChannelHandlerContext channelHandlerContext) {
                this.f21226a = channelHandlerContext;
            }

            @Override // java.lang.Runnable
            public void run() {
                k.this.b(this.f21226a);
            }
        }

        public k(@gm.j String str, Long l10) {
            this.f21221a = str;
            this.f21222b = l10;
        }

        public final long a(long j10) {
            Long l10 = this.f21222b;
            if (l10 == null) {
                return j10;
            }
            if (l10.longValue() == Long.MAX_VALUE) {
                return -1L;
            }
            return TimeUnit.NANOSECONDS.toMillis(this.f21222b.longValue());
        }

        public void b(ChannelHandlerContext channelHandlerContext) {
            if (this.f21223c) {
                return;
            }
            this.f21223c = true;
            c1.h0.F(this.f21224d, "pingFuture");
            this.f21224d.cancel(false);
            o0 o0Var = o0.this;
            o0Var.goAway(channelHandlerContext, o0Var.connection().remote().lastStreamCreated(), Http2Error.NO_ERROR.code(), ByteBufUtil.writeAscii(channelHandlerContext.alloc(), this.f21221a), channelHandlerContext.newPromise());
            long jGracefulShutdownTimeoutMillis = o0.this.gracefulShutdownTimeoutMillis();
            try {
                try {
                    o0.this.gracefulShutdownTimeoutMillis(a(jGracefulShutdownTimeoutMillis));
                    o0.super.close(channelHandlerContext, channelHandlerContext.newPromise());
                } catch (Exception e10) {
                    o0.this.onError(channelHandlerContext, true, e10);
                }
            } finally {
                o0.this.gracefulShutdownTimeoutMillis(jGracefulShutdownTimeoutMillis);
            }
        }

        public void c(ChannelHandlerContext channelHandlerContext) {
            o0.this.goAway(channelHandlerContext, Integer.MAX_VALUE, Http2Error.NO_ERROR.code(), ByteBufUtil.writeAscii(channelHandlerContext.alloc(), this.f21221a), channelHandlerContext.newPromise());
            this.f21224d = channelHandlerContext.executor().schedule((Runnable) new a(channelHandlerContext), o0.f21192j0, TimeUnit.NANOSECONDS);
            o0.this.encoder().writePing(channelHandlerContext, false, o0.f21191i0, channelHandlerContext.newPromise());
        }
    }

    public final class l implements wj.j1.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ChannelHandlerContext f21228a;

        public class a implements ChannelFutureListener {
            public a() {
            }

            @Override // io.netty.util.concurrent.GenericFutureListener
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void operationComplete(ChannelFuture channelFuture) throws Exception {
                if (channelFuture.isSuccess()) {
                    o0.this.P.c();
                }
            }
        }

        public l(ChannelHandlerContext channelHandlerContext) {
            this.f21228a = channelHandlerContext;
        }

        @Override // wj.j1.d
        public void a() {
            Http2ConnectionEncoder http2ConnectionEncoderEncoder = o0.this.encoder();
            ChannelHandlerContext channelHandlerContext = this.f21228a;
            ChannelFuture channelFutureWritePing = http2ConnectionEncoderEncoder.writePing(channelHandlerContext, false, o0.f21190h0, channelHandlerContext.newPromise());
            this.f21228a.flush();
            channelFutureWritePing.addListener((GenericFutureListener<? extends io.netty.util.concurrent.Future<? super Void>>) new a());
        }

        @Override // wj.j1.d
        public void b() {
            try {
                o0.this.o2(this.f21228a, new yj.i(y2.f17563t.u("Keepalive failed. The connection is likely gone")), this.f21228a.newPromise());
            } catch (Exception e10) {
                try {
                    o0.this.exceptionCaught(this.f21228a, e10);
                } catch (Exception e11) {
                    Logger logger = o0.f21189g0;
                    Level level = Level.WARNING;
                    logger.log(level, "Exception while propagating exception", (Throwable) e11);
                    o0.f21189g0.log(level, "Original failure", (Throwable) e10);
                }
            }
        }
    }

    public static class m extends vj.h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final Logger f21231a = Logger.getLogger(vj.h.class.getName());

        public m() {
        }

        @Override // vj.h
        public void a(vj.h.a aVar, String str) {
            f21231a.log(o0.I2(aVar), str);
        }

        @Override // vj.h
        public void b(vj.h.a aVar, String str, Object... objArr) {
            a(aVar, MessageFormat.format(str, objArr));
        }

        public m(a aVar) {
        }
    }

    public o0(ChannelPromise channelPromise, Http2Connection http2Connection, c3 c3Var, List<? extends u2.a> list, q3 q3Var, Http2ConnectionDecoder http2ConnectionDecoder, Http2ConnectionEncoder http2ConnectionEncoder, Http2Settings http2Settings, int i10, long j10, long j11, long j12, long j13, long j14, wj.i1 i1Var, boolean z10, int i11, long j15, vj.a aVar, c1.u0 u0Var) {
        super(channelPromise, http2ConnectionDecoder, http2ConnectionEncoder, http2Settings, new m(), z10, null, u0Var);
        s1 s1Var = j12 == Long.MAX_VALUE ? null : new s1(j12);
        http2Connection.addListener(new a(http2Connection, i1Var, s1Var));
        c1.h0.k(i10 >= 0, "maxMessageSize must be non-negative: %s", i10);
        this.H = i10;
        this.I = j10;
        this.J = j11;
        this.f21196b0 = s1Var;
        this.K = j13;
        this.L = j14;
        this.Q = (wj.i1) c1.h0.F(i1Var, "keepAliveEnforcer");
        this.M = i11;
        this.N = j15;
        this.R = (vj.a) c1.h0.F(aVar, "eagAttributes");
        this.S = (c1.u0) c1.h0.F(u0Var, "ticker");
        this.f21200f0 = u0Var.a();
        this.f21201x = http2ConnectionEncoder.connection().newKey();
        this.f21202y = (c3) c1.h0.F(c3Var, "transportListener");
        this.O = (List) c1.h0.F(list, "streamTracerFactories");
        this.P = (q3) c1.h0.F(q3Var, "transportTracer");
        decoder().frameListener(new j());
    }

    private Http2Stream A2(int i10) {
        Http2Stream http2StreamStream = connection().stream(i10);
        if (http2StreamStream != null) {
            return http2StreamStream;
        }
        throw new AssertionError(h.a.a("Stream does not exist: ", i10));
    }

    private void D2(ChannelHandlerContext channelHandlerContext, a1 a1Var, ChannelPromise channelPromise) throws Http2Exception {
        fm.f fVarZ = fm.c.z("NettyServerHandler.sendGrpcFrame");
        try {
            fm.c.a(a1Var.f20850a.d());
            fm.c.n(a1Var.f20852c);
            int iId = a1Var.f20850a.id();
            Http2Stream http2StreamStream = connection().stream(iId);
            if (http2StreamStream == null) {
                H2(iId, channelPromise);
                if (fVarZ != null) {
                    fm.c.u();
                    return;
                }
                return;
            }
            if (a1Var.f20851b) {
                m2(channelPromise, http2StreamStream);
            }
            encoder().writeData(channelHandlerContext, iId, a1Var.content(), 0, a1Var.f20851b, channelPromise);
            if (fVarZ != null) {
                fm.c.u();
            }
        } catch (Throwable th2) {
            if (fVarZ != null) {
                try {
                    fm.c.u();
                } catch (Throwable th3) {
                    th2.addSuppressed(th3);
                }
            }
            throw th2;
        }
    }

    public static void H2(int i10, ChannelPromise channelPromise) {
        channelPromise.setFailure((Throwable) new g(k.b.a("attempting to write to stream ", i10, " that no longer exists")));
    }

    public static Level I2(vj.h.a aVar) {
        int i10 = i.f21218a[aVar.ordinal()];
        if (i10 != 1) {
            return i10 != 2 ? Level.FINEST : Level.FINER;
        }
        return Level.FINE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o2(ChannelHandlerContext channelHandlerContext, yj.i iVar, ChannelPromise channelPromise) throws Exception {
        super.close(channelHandlerContext, channelPromise);
        connection().forEachActiveStream(new h(iVar, channelHandlerContext));
    }

    public static o0 u2(ChannelPromise channelPromise, Http2FrameReader http2FrameReader, Http2FrameWriter http2FrameWriter, c3 c3Var, List<? extends u2.a> list, q3 q3Var, int i10, boolean z10, int i11, int i12, int i13, long j10, long j11, long j12, long j13, long j14, boolean z11, long j15, int i14, long j16, vj.a aVar, c1.u0 u0Var) {
        c1.h0.k(i10 > 0, "maxStreams must be positive: %s", i10);
        c1.h0.k(i11 > 0, "flowControlWindow must be positive: %s", i11);
        c1.h0.k(i12 > 0, "maxHeaderListSize must be positive: %s", i12);
        c1.h0.k(i13 > 0, "maxMessageSize must be positive: %s", i13);
        DefaultHttp2Connection defaultHttp2Connection = new DefaultHttp2Connection(true);
        WeightedFairQueueByteDistributor weightedFairQueueByteDistributor = new WeightedFairQueueByteDistributor(defaultHttp2Connection);
        weightedFairQueueByteDistributor.allocationQuantum(16384);
        defaultHttp2Connection.remote().flowController(new DefaultHttp2RemoteFlowController(defaultHttp2Connection, weightedFairQueueByteDistributor));
        wj.i1 i1Var = new wj.i1(z11, j15, TimeUnit.NANOSECONDS);
        defaultHttp2Connection.local().flowController(new DefaultHttp2LocalFlowController(defaultHttp2Connection, 0.5f, true));
        p pVar = new p(new DefaultHttp2ConnectionEncoder(defaultHttp2Connection, new n(http2FrameWriter, i1Var)), 10000);
        DefaultHttp2ConnectionDecoder defaultHttp2ConnectionDecoder = new DefaultHttp2ConnectionDecoder(defaultHttp2Connection, pVar, http2FrameReader);
        Http2Settings http2Settings = new Http2Settings();
        http2Settings.initialWindowSize(i11);
        http2Settings.maxConcurrentStreams(i10);
        http2Settings.maxHeaderListSize(i12);
        return new o0(channelPromise, defaultHttp2Connection, c3Var, list, q3Var, defaultHttp2ConnectionDecoder, pVar, http2Settings, i13, j10, j11, j12, j13, j14, i1Var, z10, i14, j16, aVar, u0Var == null ? c1.u0.b() : u0Var);
    }

    public static o0 v2(c3 c3Var, ChannelPromise channelPromise, List<? extends u2.a> list, q3 q3Var, int i10, boolean z10, int i11, int i12, int i13, long j10, long j11, long j12, long j13, long j14, boolean z11, long j15, int i14, long j16, vj.a aVar) {
        c1.h0.k(i12 > 0, "maxHeaderListSize must be positive: %s", i12);
        Http2FrameLogger http2FrameLogger = new Http2FrameLogger(LogLevel.DEBUG, (Class<?>) o0.class);
        return u2(channelPromise, new Http2InboundFrameLogger(new DefaultHttp2FrameReader(new yj.m.e(true, i12)), http2FrameLogger), new Http2OutboundFrameLogger(new DefaultHttp2FrameWriter(), http2FrameLogger), c3Var, list, q3Var, i10, z10, i11, i12, i13, j10, j11, j12, j13, j14, z11, j15, i14, j16, aVar, c1.u0.b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x2(int i10, ByteBuf byteBuf, int i11, boolean z10) throws Http2Exception {
        O().g(byteBuf.readableBytes(), i11);
        try {
            q0.c cVarF2 = F2(A2(i10));
            if (cVarF2 == null) {
                return;
            }
            fm.f fVarZ = fm.c.z("NettyServerHandler.onDataRead");
            try {
                fm.c.a(cVarF2.d());
                cVarF2.N(byteBuf, z10);
                if (fVarZ != null) {
                    fm.c.u();
                }
            } catch (Throwable th2) {
                if (fVarZ != null) {
                    try {
                        fm.c.u();
                    } catch (Throwable th3) {
                        th2.addSuppressed(th3);
                    }
                }
                throw th2;
            }
        } catch (Throwable th4) {
            f21189g0.log(Level.WARNING, "Exception in onDataRead()", th4);
            throw w2(i10, th4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z2(int i10, long j10) throws Http2Exception {
        if (this.M > 0) {
            long jA = this.S.a();
            if (jA - this.f21200f0 > this.N) {
                this.f21200f0 = jA;
                this.f21199e0 = 1;
            } else {
                int i11 = this.f21199e0 + 1;
                this.f21199e0 = i11;
                if (i11 > this.M) {
                    throw new d(Http2Error.ENHANCE_YOUR_CALM, "too_many_rststreams");
                }
            }
        }
        try {
            q0.c cVarF2 = F2(connection().stream(i10));
            if (cVarF2 != null) {
                fm.f fVarZ = fm.c.z("NettyServerHandler.onRstStreamRead");
                try {
                    fm.c.a(cVarF2.d());
                    cVarF2.K(y2.f17549f.u("RST_STREAM received for code " + j10));
                    if (fVarZ != null) {
                        fm.c.u();
                    }
                } catch (Throwable th2) {
                    if (fVarZ != null) {
                        try {
                            fm.c.u();
                        } catch (Throwable th3) {
                            th2.addSuppressed(th3);
                        }
                    }
                    throw th2;
                }
            }
        } catch (Throwable th4) {
            f21189g0.log(Level.WARNING, "Exception in onRstStreamRead()", th4);
            throw w2(i10, th4);
        }
    }

    public final void B2(ChannelHandlerContext channelHandlerContext, int i10, int i11, y2.b bVar, String str) {
        v1 v1Var = new v1();
        v1Var.w(vj.l1.f17168b, bVar.toStatus());
        v1Var.w(vj.l1.f17167a, str);
        byte[][] bArrH = vj.f1.h(v1Var);
        Http2Headers http2Headers = new DefaultHttp2Headers(true, bArrH.length / 2).status("" + i11).set(i1.f20994g, "text/plain; charset=utf-8");
        for (int i12 = 0; i12 < bArrH.length; i12 += 2) {
            http2Headers.add(new AsciiString(bArrH[i12], false), new AsciiString(bArrH[i12 + 1], false));
        }
        encoder().writeHeaders(channelHandlerContext, i10, http2Headers, 0, false, channelHandlerContext.newPromise());
        encoder().writeData(channelHandlerContext, i10, ByteBufUtil.writeUtf8(channelHandlerContext.alloc(), str), 0, true, channelHandlerContext.newPromise());
    }

    public void C2(Http2Stream http2Stream, int i10) {
        try {
            decoder().flowController().consumeBytes(http2Stream, i10);
        } catch (Http2Exception e10) {
            throw new RuntimeException(e10);
        }
    }

    public final void E2(ChannelHandlerContext channelHandlerContext, c1 c1Var, ChannelPromise channelPromise) throws Http2Exception {
        fm.f fVarZ = fm.c.z("NettyServerHandler.sendResponseHeaders");
        try {
            fm.c.a(c1Var.f20882c.d());
            fm.c.n(c1Var.f21080b);
            int iId = c1Var.f20882c.id();
            Http2Stream http2StreamStream = connection().stream(iId);
            if (http2StreamStream == null) {
                H2(iId, channelPromise);
                if (fVarZ != null) {
                    fm.c.u();
                    return;
                }
                return;
            }
            if (c1Var.f()) {
                m2(channelPromise, http2StreamStream);
            }
            encoder().writeHeaders(channelHandlerContext, iId, c1Var.f20883d, 0, c1Var.f(), channelPromise);
            if (fVarZ != null) {
                fm.c.u();
            }
        } catch (Throwable th2) {
            if (fVarZ != null) {
                try {
                    fm.c.u();
                } catch (Throwable th3) {
                    th2.addSuppressed(th3);
                }
            }
            throw th2;
        }
    }

    public final q0.c F2(Http2Stream http2Stream) {
        if (http2Stream == null) {
            return null;
        }
        return (q0.c) http2Stream.getProperty(this.f21201x);
    }

    @b1.e
    public void G2(wj.j1 j1Var) {
        this.f21195a0 = j1Var;
    }

    @Override // yj.l
    public vj.a c() {
        return this.R;
    }

    @Override // io.netty.handler.codec.http2.Http2ConnectionHandler, io.netty.handler.codec.ByteToMessageDecoder, io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelInboundHandler
    public void channelInactive(ChannelHandlerContext channelHandlerContext) throws Exception {
        try {
            wj.j1 j1Var = this.f21195a0;
            if (j1Var != null) {
                j1Var.r();
            }
            s1 s1Var = this.f21196b0;
            if (s1Var != null) {
                s1Var.j();
            }
            ScheduledFuture<?> scheduledFuture = this.f21197c0;
            if (scheduledFuture != null) {
                scheduledFuture.cancel(false);
            }
            connection().forEachActiveStream(new e(y2.f17563t.u("connection terminated for unknown reason")));
        } finally {
            super.channelInactive(channelHandlerContext);
        }
    }

    @Override // io.netty.handler.codec.http2.Http2ConnectionHandler, io.netty.channel.ChannelOutboundHandler
    public void close(ChannelHandlerContext channelHandlerContext, ChannelPromise channelPromise) throws Exception {
        t2(channelHandlerContext, new yj.k("app_requested"), channelPromise);
        channelHandlerContext.flush();
    }

    @Override // yj.b, io.netty.handler.codec.http2.Http2ConnectionHandler, io.netty.channel.ChannelHandlerAdapter, io.netty.channel.ChannelHandler
    public void handlerAdded(ChannelHandlerContext channelHandlerContext) throws Exception {
        this.Y = new k1(channelHandlerContext.channel());
        if (this.K != Long.MAX_VALUE) {
            this.f21197c0 = channelHandlerContext.executor().schedule((Runnable) new wj.k1(new b(channelHandlerContext)), this.K, TimeUnit.NANOSECONDS);
        }
        s1 s1Var = this.f21196b0;
        if (s1Var != null) {
            s1Var.k(new c(channelHandlerContext), channelHandlerContext.executor());
        }
        if (this.I != Long.MAX_VALUE) {
            wj.j1 j1Var = new wj.j1(new l(channelHandlerContext), channelHandlerContext.executor(), this.I, this.J, true);
            this.f21195a0 = j1Var;
            j1Var.q();
        }
        this.P.i(new i1.g(encoder().connection()));
        super.handlerAdded(channelHandlerContext);
    }

    public final void l2(ChannelHandlerContext channelHandlerContext, yj.d dVar, ChannelPromise channelPromise) {
        fm.f fVarZ = fm.c.z("NettyServerHandler.cancelStream");
        try {
            fm.c.a(dVar.f20885c.d());
            fm.c.n(dVar.f21080b);
            dVar.f20885c.K(dVar.f20886d);
            encoder().writeRstStream(channelHandlerContext, dVar.f20885c.id(), Http2Error.CANCEL.code(), channelPromise);
            if (fVarZ != null) {
                fm.c.u();
            }
        } catch (Throwable th2) {
            if (fVarZ != null) {
                try {
                    fm.c.u();
                } catch (Throwable th3) {
                    th2.addSuppressed(th3);
                }
            }
            throw th2;
        }
    }

    public final void m2(ChannelPromise channelPromise, Http2Stream http2Stream) {
        channelPromise.addListener((GenericFutureListener<? extends io.netty.util.concurrent.Future<? super Void>>) new f(http2Stream));
    }

    @gm.j
    public Throwable n2() {
        return this.W;
    }

    @Override // yj.l
    public void o(vj.a aVar, vj.v0.f fVar) {
        this.T = aVar;
        this.U = fVar;
        h0.I2(this.f20859i.channel());
    }

    @Override // io.netty.handler.codec.http2.Http2ConnectionHandler
    public void onConnectionError(ChannelHandlerContext channelHandlerContext, boolean z10, Throwable th2, Http2Exception http2Exception) {
        f21189g0.log(Level.FINE, "Connection Error", th2);
        this.W = th2;
        super.onConnectionError(channelHandlerContext, z10, th2, http2Exception);
    }

    @Override // io.netty.handler.codec.http2.Http2ConnectionHandler
    public void onStreamError(ChannelHandlerContext channelHandlerContext, boolean z10, Throwable th2, Http2Exception.StreamException streamException) {
        q0.c cVarF2 = F2(connection().stream(Http2Exception.streamId(streamException)));
        Level level = Level.WARNING;
        if (cVarF2 == null && streamException.error() == Http2Error.STREAM_CLOSED) {
            level = Level.FINE;
        }
        f21189g0.log(level, "Stream Error", th2);
        fm.e eVarD = cVarF2 != null ? cVarF2.d() : fm.c.f();
        fm.f fVarZ = fm.c.z("NettyServerHandler.onStreamError");
        try {
            fm.c.a(eVarD);
            if (cVarF2 != null) {
                cVarF2.K(i1.w(th2));
            }
            super.onStreamError(channelHandlerContext, z10, th2, streamException);
            if (fVarZ != null) {
                fm.c.u();
            }
        } catch (Throwable th3) {
            if (fVarZ != null) {
                try {
                    fm.c.u();
                } catch (Throwable th4) {
                    th3.addSuppressed(th4);
                }
            }
            throw th3;
        }
    }

    @b1.e
    public wj.j1 p2() {
        return this.f21195a0;
    }

    public final String q2(AsciiString asciiString) {
        if (asciiString == null) {
            return null;
        }
        if (!asciiString.equals(this.Z)) {
            this.Z = asciiString;
        }
        return this.Z.toString();
    }

    public vj.v0.f r2() {
        return this.U;
    }

    public k1 s2() {
        return this.Y;
    }

    public final void t2(ChannelHandlerContext channelHandlerContext, yj.k kVar, ChannelPromise channelPromise) throws Exception {
        if (this.f21198d0 == null) {
            k kVar2 = new k(kVar.d(), kVar.f() != null ? Long.valueOf(kVar.f().toNanos(kVar.e())) : null);
            this.f21198d0 = kVar2;
            kVar2.c(channelHandlerContext);
        }
        channelPromise.setSuccess();
    }

    public final Http2Exception w2(int i10, Throwable th2) {
        return Http2Exception.streamError(i10, Http2Error.INTERNAL_ERROR, th2, c1.g0.g(th2.getMessage()), new Object[0]);
    }

    @Override // io.netty.handler.codec.http2.Http2ConnectionHandler, io.netty.channel.ChannelOutboundHandler
    public void write(ChannelHandlerContext channelHandlerContext, Object obj, ChannelPromise channelPromise) throws Exception {
        if (obj instanceof a1) {
            D2(channelHandlerContext, (a1) obj, channelPromise);
            return;
        }
        if (obj instanceof c1) {
            E2(channelHandlerContext, (c1) obj, channelPromise);
            return;
        }
        if (obj instanceof yj.d) {
            l2(channelHandlerContext, (yj.d) obj, channelPromise);
            return;
        }
        if (obj instanceof yj.k) {
            t2(channelHandlerContext, (yj.k) obj, channelPromise);
        } else {
            if (obj instanceof yj.i) {
                o2(channelHandlerContext, (yj.i) obj, channelPromise);
                return;
            }
            AssertionError assertionError = new AssertionError("Write called for unexpected type: ".concat(obj.getClass().getName()));
            ReferenceCountUtil.release(obj);
            channelPromise.setFailure((Throwable) assertionError);
            throw assertionError;
        }
    }

    public final void y2(ChannelHandlerContext channelHandlerContext, int i10, Http2Headers http2Headers) throws Http2Exception {
        try {
            if (!f21193k0 && http2Headers.contains(HttpHeaderNames.CONNECTION)) {
                resetStream(channelHandlerContext, i10, Http2Error.PROTOCOL_ERROR.code(), channelHandlerContext.newPromise());
                return;
            }
            if (http2Headers.authority() == null) {
                List<CharSequence> all = http2Headers.getAll(HttpHeaderNames.HOST);
                if (all.size() > 1) {
                    B2(channelHandlerContext, i10, 400, y2.b.INTERNAL, "Multiple host headers");
                    return;
                } else if (!all.isEmpty()) {
                    http2Headers.add(Http2Headers.PseudoHeaderName.AUTHORITY.value(), all.get(0));
                }
            }
            http2Headers.remove(HttpHeaderNames.HOST);
            CharSequence charSequencePath = http2Headers.path();
            if (charSequencePath == null) {
                B2(channelHandlerContext, i10, 404, y2.b.UNIMPLEMENTED, "Expected path but is missing");
                return;
            }
            if (charSequencePath.charAt(0) != '/') {
                B2(channelHandlerContext, i10, 404, y2.b.UNIMPLEMENTED, String.format("Expected path to start with /: %s", charSequencePath));
                return;
            }
            String string = charSequencePath.subSequence(1, charSequencePath.length()).toString();
            CharSequence charSequence = http2Headers.get(i1.f20994g);
            if (charSequence == null) {
                B2(channelHandlerContext, i10, 415, y2.b.INTERNAL, "Content-Type is missing from the request");
                return;
            }
            String string2 = charSequence.toString();
            if (!wj.v0.q(string2)) {
                B2(channelHandlerContext, i10, 415, y2.b.INTERNAL, String.format("Content-Type '%s' is not supported", string2));
                return;
            }
            if (!i1.f20990c.contentEquals(http2Headers.method())) {
                B2(channelHandlerContext, i10, 405, y2.b.INTERNAL, String.format("Method '%s' is not supported", http2Headers.method()));
                return;
            }
            if (!this.X) {
                AsciiString asciiString = i1.f20997j;
                AsciiString asciiString2 = i1.f20996i;
                if (!asciiString.contentEquals(http2Headers.get(asciiString2))) {
                    f21189g0.warning(String.format("Expected header TE: %s, but %s is received. This means some intermediate proxy may not support trailers", asciiString, http2Headers.get(asciiString2)));
                    this.X = true;
                }
            }
            Http2Stream http2StreamA2 = A2(i10);
            v1 v1VarE = i1.e(http2Headers);
            i3 i3VarJ = i3.j(this.O, string, v1VarE);
            q0.c cVar = new q0.c(this, channelHandlerContext.channel().eventLoop(), http2StreamA2, this.H, i3VarJ, this.P, string);
            fm.f fVarZ = fm.c.z("NettyServerHandler.onHeadersRead");
            try {
                fm.c.a(cVar.f21255v);
                this.f21202y.b(new q0(channelHandlerContext.channel(), cVar, this.V, q2((AsciiString) http2Headers.authority()), i3VarJ, this.P), string, v1VarE);
                cVar.t();
                http2StreamA2.setProperty(this.f21201x, cVar);
                if (fVarZ != null) {
                    fm.c.u();
                }
            } catch (Throwable th2) {
                if (fVarZ == null) {
                    throw th2;
                }
                try {
                    fm.c.u();
                    throw th2;
                } catch (Throwable th3) {
                    th2.addSuppressed(th3);
                    throw th2;
                }
            }
        } catch (Exception e10) {
            f21189g0.log(Level.WARNING, "Exception in onHeadersRead()", (Throwable) e10);
            throw w2(i10, e10);
        }
    }

    public class j extends Http2FrameAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f21219a;

        public j() {
            this.f21219a = true;
        }

        @Override // io.netty.handler.codec.http2.Http2FrameAdapter, io.netty.handler.codec.http2.Http2FrameListener
        public int onDataRead(ChannelHandlerContext channelHandlerContext, int i10, ByteBuf byteBuf, int i11, boolean z10) throws Http2Exception {
            if (o0.this.f21195a0 != null) {
                o0.this.f21195a0.n();
            }
            o0.this.x2(i10, byteBuf, i11, z10);
            return i11;
        }

        @Override // io.netty.handler.codec.http2.Http2FrameAdapter, io.netty.handler.codec.http2.Http2FrameListener
        public void onHeadersRead(ChannelHandlerContext channelHandlerContext, int i10, Http2Headers http2Headers, int i11, short s10, boolean z10, int i12, boolean z11) throws Http2Exception {
            if (o0.this.f21195a0 != null) {
                o0.this.f21195a0.n();
            }
            o0.this.y2(channelHandlerContext, i10, http2Headers);
            if (z11) {
                o0.this.x2(i10, Unpooled.EMPTY_BUFFER, 0, z11);
            }
        }

        @Override // io.netty.handler.codec.http2.Http2FrameAdapter, io.netty.handler.codec.http2.Http2FrameListener
        public void onPingAckRead(ChannelHandlerContext channelHandlerContext, long j10) throws Http2Exception {
            if (o0.this.f21195a0 != null) {
                o0.this.f21195a0.n();
            }
            o0.this.O().getClass();
            if (j10 == yj.b.f20855w) {
                o0.this.O().m();
                o0.f21189g0.log(Level.FINE, "Window: {0}", Integer.valueOf(o0.this.decoder().flowController().initialWindowSize(o0.this.connection().connectionStream())));
            } else if (j10 != o0.f21191i0) {
                if (j10 != o0.f21190h0) {
                    o0.f21189g0.warning("Received unexpected ping ack. No ping outstanding");
                }
            } else {
                k kVar = o0.this.f21198d0;
                if (kVar == null) {
                    o0.f21189g0.warning("Received GRACEFUL_SHUTDOWN_PING Ack but gracefulShutdown is null");
                } else {
                    kVar.b(channelHandlerContext);
                }
            }
        }

        @Override // io.netty.handler.codec.http2.Http2FrameAdapter, io.netty.handler.codec.http2.Http2FrameListener
        public void onPingRead(ChannelHandlerContext channelHandlerContext, long j10) throws Http2Exception {
            if (o0.this.f21195a0 != null) {
                o0.this.f21195a0.n();
            }
            if (o0.this.Q.d()) {
                return;
            }
            ByteBuf byteBufWriteAscii = ByteBufUtil.writeAscii(channelHandlerContext.alloc(), "too_many_pings");
            o0 o0Var = o0.this;
            o0Var.goAway(channelHandlerContext, o0Var.connection().remote().lastStreamCreated(), Http2Error.ENHANCE_YOUR_CALM.code(), byteBufWriteAscii, channelHandlerContext.newPromise());
            try {
                o0.this.o2(channelHandlerContext, new yj.i(y2.f17557n.u("Too many pings from client")), channelHandlerContext.newPromise());
            } catch (Exception e10) {
                o0.this.onError(channelHandlerContext, true, e10);
            }
        }

        @Override // io.netty.handler.codec.http2.Http2FrameAdapter, io.netty.handler.codec.http2.Http2FrameListener
        public void onRstStreamRead(ChannelHandlerContext channelHandlerContext, int i10, long j10) throws Http2Exception {
            if (o0.this.f21195a0 != null) {
                o0.this.f21195a0.n();
            }
            o0.this.z2(i10, j10);
        }

        @Override // io.netty.handler.codec.http2.Http2FrameAdapter, io.netty.handler.codec.http2.Http2FrameListener
        public void onSettingsRead(ChannelHandlerContext channelHandlerContext, Http2Settings http2Settings) {
            if (this.f21219a) {
                this.f21219a = false;
                o0 o0Var = o0.this;
                o0Var.V = o0Var.f21202y.c(o0.this.T);
            }
        }

        public /* synthetic */ j(o0 o0Var, a aVar) {
            this();
        }
    }

    public static class n extends DecoratingHttp2FrameWriter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final wj.i1 f21232a;

        public n(Http2FrameWriter http2FrameWriter, wj.i1 i1Var) {
            super(http2FrameWriter);
            this.f21232a = i1Var;
        }

        @Override // io.netty.handler.codec.http2.DecoratingHttp2FrameWriter, io.netty.handler.codec.http2.Http2DataWriter
        public ChannelFuture writeData(ChannelHandlerContext channelHandlerContext, int i10, ByteBuf byteBuf, int i11, boolean z10, ChannelPromise channelPromise) {
            this.f21232a.e();
            return super.writeData(channelHandlerContext, i10, byteBuf, i11, z10, channelPromise);
        }

        @Override // io.netty.handler.codec.http2.DecoratingHttp2FrameWriter, io.netty.handler.codec.http2.Http2FrameWriter
        public ChannelFuture writeHeaders(ChannelHandlerContext channelHandlerContext, int i10, Http2Headers http2Headers, int i11, boolean z10, ChannelPromise channelPromise) {
            this.f21232a.e();
            return super.writeHeaders(channelHandlerContext, i10, http2Headers, i11, z10, channelPromise);
        }

        @Override // io.netty.handler.codec.http2.DecoratingHttp2FrameWriter, io.netty.handler.codec.http2.Http2FrameWriter
        public ChannelFuture writeHeaders(ChannelHandlerContext channelHandlerContext, int i10, Http2Headers http2Headers, int i11, short s10, boolean z10, int i12, boolean z11, ChannelPromise channelPromise) {
            this.f21232a.e();
            return super.writeHeaders(channelHandlerContext, i10, http2Headers, i11, s10, z10, i12, z11, channelPromise);
        }
    }
}
