package yj;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufUtil;
import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelPromise;
import io.netty.handler.codec.http2.DecoratingHttp2FrameWriter;
import io.netty.handler.codec.http2.DefaultHttp2Connection;
import io.netty.handler.codec.http2.DefaultHttp2ConnectionDecoder;
import io.netty.handler.codec.http2.DefaultHttp2ConnectionEncoder;
import io.netty.handler.codec.http2.DefaultHttp2FrameReader;
import io.netty.handler.codec.http2.DefaultHttp2FrameWriter;
import io.netty.handler.codec.http2.DefaultHttp2HeadersEncoder;
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
import io.netty.handler.codec.http2.Http2HeadersEncoder;
import io.netty.handler.codec.http2.Http2InboundFrameLogger;
import io.netty.handler.codec.http2.Http2OutboundFrameLogger;
import io.netty.handler.codec.http2.Http2Settings;
import io.netty.handler.codec.http2.Http2Stream;
import io.netty.handler.codec.http2.Http2StreamVisitor;
import io.netty.handler.codec.http2.StreamBufferingEncoder;
import io.netty.handler.codec.http2.WeightedFairQueueByteDistributor;
import io.netty.handler.logging.LogLevel;
import io.netty.util.CharsetUtil;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GenericFutureListener;
import io.netty.util.internal.ObjectUtil;
import java.nio.channels.ClosedChannelException;
import java.util.concurrent.Executor;
import java.util.logging.Level;
import java.util.logging.Logger;
import vj.a3;
import vj.v1;
import vj.y2;
import vj.z2;
import wj.q3;

/* JADX INFO: loaded from: classes2.dex */
public class h0 extends yj.b {
    public static final Logger T = Logger.getLogger(h0.class.getName());
    public static final Object U = new Object();
    public static final y2 V = y2.f17563t.u("Stream IDs have been exhausted");
    public static final long W = 1111;
    public final wj.j1 H;
    public final c1.q0<c1.o0> I;
    public final q3 J;
    public final vj.a K;
    public final String L;
    public final wj.a1<Http2Stream> M;
    public k1 N;
    public wj.z0 O;
    public vj.a P;
    public vj.v0.f Q;
    public y2 R;
    public y2 S;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final Http2Connection.PropertyKey f20950x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final yj.e f20951y;

    public class a extends wj.a1<Http2Stream> {
        public a() {
        }

        @Override // wj.a1
        public void b() {
            h0.this.f20951y.e(true);
        }

        @Override // wj.a1
        public void c() {
            h0.this.f20951y.e(false);
        }
    }

    public class b extends Http2ConnectionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Runnable f20953a;

        public b(Runnable runnable) {
            this.f20953a = runnable;
        }

        @Override // io.netty.handler.codec.http2.Http2ConnectionAdapter, io.netty.handler.codec.http2.Http2Connection.Listener
        public void onGoAwayReceived(int i10, long j10, ByteBuf byteBuf) {
            byte[] bytes = ByteBufUtil.getBytes(byteBuf);
            h0.this.t2(j10, bytes);
            if (j10 == Http2Error.ENHANCE_YOUR_CALM.code()) {
                String str = new String(bytes, CharsetUtil.UTF_8);
                h0.T.log(Level.WARNING, "Received GOAWAY with ENHANCE_YOUR_CALM. Debug data: {0}", str);
                if ("too_many_pings".equals(str)) {
                    this.f20953a.run();
                }
            }
        }

        @Override // io.netty.handler.codec.http2.Http2ConnectionAdapter, io.netty.handler.codec.http2.Http2Connection.Listener
        public void onStreamActive(Http2Stream http2Stream) {
            if (h0.this.connection().numActiveStreams() != 1 || h0.this.H == null) {
                return;
            }
            h0.this.H.o();
        }

        @Override // io.netty.handler.codec.http2.Http2ConnectionAdapter, io.netty.handler.codec.http2.Http2Connection.Listener
        public void onStreamClosed(Http2Stream http2Stream) {
            wj.j1 j1Var;
            h0.this.M.e(http2Stream, false);
            if (h0.this.connection().numActiveStreams() != 0 || (j1Var = h0.this.H) == null) {
                return;
            }
            j1Var.p();
        }
    }

    public class c implements Http2StreamVisitor {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ y2 f20955a;

        public c(y2 y2Var) {
            this.f20955a = y2Var;
        }

        @Override // io.netty.handler.codec.http2.Http2StreamVisitor
        public boolean visit(Http2Stream http2Stream) throws Http2Exception {
            i0.c cVarL2 = h0.this.l2(http2Stream);
            if (cVarL2 == null) {
                return true;
            }
            cVarL2.R(this.f20955a, false, new v1());
            return true;
        }
    }

    public class d implements ChannelFutureListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f20957a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ i0.c f20958b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ boolean f20959c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ ChannelPromise f20960d;

        public d(int i10, i0.c cVar, boolean z10, ChannelPromise channelPromise) {
            this.f20957a = i10;
            this.f20958b = cVar;
            this.f20959c = z10;
            this.f20960d = channelPromise;
        }

        @Override // io.netty.util.concurrent.GenericFutureListener
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void operationComplete(ChannelFuture channelFuture) throws Exception {
            if (channelFuture.isSuccess()) {
                Http2Stream http2StreamStream = h0.this.connection().stream(this.f20957a);
                if (http2StreamStream != null) {
                    this.f20958b.f18443c.c();
                    http2StreamStream.setProperty(h0.this.f20950x, this.f20958b);
                    if (this.f20959c) {
                        h0.this.M.e(http2StreamStream, true);
                    }
                    this.f20958b.d0(http2StreamStream);
                }
                this.f20960d.setSuccess();
                return;
            }
            Throwable thCause = channelFuture.cause();
            if (thCause instanceof StreamBufferingEncoder.Http2GoAwayException) {
                StreamBufferingEncoder.Http2GoAwayException http2GoAwayException = (StreamBufferingEncoder.Http2GoAwayException) thCause;
                y2 y2VarH2 = h0.this.H2(y2.b.UNAVAILABLE, "GOAWAY closed buffered stream", http2GoAwayException.errorCode(), http2GoAwayException.debugData());
                y2VarH2.getClass();
                a3 a3Var = new a3(y2VarH2);
                this.f20958b.Q(y2VarH2, wj.t.a.MISCARRIED, true, new v1());
                thCause = a3Var;
            } else if (thCause instanceof StreamBufferingEncoder.Http2ChannelClosedException) {
                y2 y2VarU = h0.this.f20951y.f20892e;
                if (y2VarU == null) {
                    y2VarU = y2.f17563t.t(thCause).u("Connection closed while stream is buffered");
                }
                this.f20958b.Q(y2VarU, wj.t.a.MISCARRIED, true, new v1());
            }
            this.f20960d.setFailure(thCause);
        }
    }

    public class e implements ChannelFutureListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ wj.z0 f20962a;

        public e(wj.z0 z0Var) {
            this.f20962a = z0Var;
        }

        @Override // io.netty.util.concurrent.GenericFutureListener
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void operationComplete(ChannelFuture channelFuture) throws Exception {
            if (channelFuture.isSuccess()) {
                h0.this.J.c();
                return;
            }
            Throwable thCause = channelFuture.cause();
            if ((thCause instanceof ClosedChannelException) && (thCause = h0.this.f20951y.f20893f) == null) {
                y2 y2VarT = y2.f17550g.u("Ping failed but for unknown reason.").t(channelFuture.cause());
                y2VarT.getClass();
                thCause = new z2(y2VarT);
            }
            this.f20962a.f(thCause);
            if (h0.this.O == this.f20962a) {
                h0.this.O = null;
            }
        }
    }

    public class f implements Http2StreamVisitor {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ yj.i f20964a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ChannelHandlerContext f20965b;

        public f(yj.i iVar, ChannelHandlerContext channelHandlerContext) {
            this.f20964a = iVar;
            this.f20965b = channelHandlerContext;
        }

        @Override // io.netty.handler.codec.http2.Http2StreamVisitor
        public boolean visit(Http2Stream http2Stream) throws Http2Exception {
            i0.c cVarL2 = h0.this.l2(http2Stream);
            fm.e eVarF = cVarL2 != null ? cVarL2.F : fm.c.f();
            fm.f fVarZ = fm.c.z("NettyClientHandler.forcefulClose");
            try {
                fm.c.n(this.f20964a.b());
                fm.c.a(eVarF);
                if (cVarL2 != null) {
                    cVarL2.R(this.f20964a.d(), true, new v1());
                    h0.this.resetStream(this.f20965b, http2Stream.id(), Http2Error.CANCEL.code(), this.f20965b.newPromise());
                }
                http2Stream.close();
                if (fVarZ != null) {
                    fm.c.u();
                }
                return true;
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
    }

    public class g implements Http2StreamVisitor {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f20967a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ boolean f20968b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ y2 f20969c;

        public g(int i10, boolean z10, y2 y2Var) {
            this.f20967a = i10;
            this.f20968b = z10;
            this.f20969c = y2Var;
        }

        @Override // io.netty.handler.codec.http2.Http2StreamVisitor
        public boolean visit(Http2Stream http2Stream) throws Http2Exception {
            if (http2Stream.id() <= this.f20967a) {
                return true;
            }
            i0.c cVarL2 = h0.this.l2(http2Stream);
            if (cVarL2 != null) {
                cVarL2.Q(this.f20969c, this.f20968b ? wj.t.a.PROCESSED : wj.t.a.REFUSED, false, new v1());
            }
            http2Stream.close();
            return true;
        }
    }

    public h0(Http2ConnectionDecoder http2ConnectionDecoder, Http2ConnectionEncoder http2ConnectionEncoder, Http2Settings http2Settings, vj.h hVar, yj.e eVar, wj.j1 j1Var, c1.q0<c1.o0> q0Var, Runnable runnable, q3 q3Var, vj.a aVar, String str, boolean z10, yj.b.d dVar, c1.u0 u0Var) {
        super(null, http2ConnectionDecoder, http2ConnectionEncoder, http2Settings, hVar, z10, dVar, u0Var);
        this.M = new a();
        this.f20951y = eVar;
        this.H = j1Var;
        this.I = q0Var;
        q3Var.getClass();
        this.J = q3Var;
        this.K = aVar;
        this.L = str;
        this.P = vj.a.e().d(wj.u0.f19306b, aVar).a();
        decoder().frameListener(new h());
        Http2Connection http2ConnectionConnection = http2ConnectionEncoder.connection();
        this.f20950x = http2ConnectionConnection.newKey();
        http2ConnectionConnection.addListener(new b(runnable));
    }

    public static void I2(Channel channel) {
        ObjectUtil.checkNotNull(channel, "channel");
        ChannelHandlerContext channelHandlerContextContext = channel.pipeline().context(j1.class);
        if (channelHandlerContextContext == null) {
            return;
        }
        ((j1) channelHandlerContextContext.handler()).n(channelHandlerContextContext);
    }

    @b1.e
    public static h0 w2(Http2Connection http2Connection, Http2FrameReader http2FrameReader, Http2FrameWriter http2FrameWriter, yj.e eVar, wj.j1 j1Var, boolean z10, int i10, int i11, c1.q0<c1.o0> q0Var, Runnable runnable, q3 q3Var, vj.a aVar, String str, vj.h hVar, c1.u0 u0Var) {
        c1.h0.F(http2Connection, "connection");
        c1.h0.F(http2FrameReader, "frameReader");
        c1.h0.F(eVar, "lifecycleManager");
        c1.h0.e(i10 > 0, "flowControlWindow must be positive");
        c1.h0.e(i11 > 0, "maxHeaderListSize must be positive");
        c1.h0.F(q0Var, "stopwatchFactory");
        c1.h0.F(runnable, "tooManyPingsRunnable");
        c1.h0.F(aVar, "eagAttributes");
        c1.h0.F(str, "authority");
        Http2FrameLogger http2FrameLogger = new Http2FrameLogger(LogLevel.DEBUG, (Class<?>) h0.class);
        Http2InboundFrameLogger http2InboundFrameLogger = new Http2InboundFrameLogger(http2FrameReader, http2FrameLogger);
        i iVar = new i(new Http2OutboundFrameLogger(http2FrameWriter, http2FrameLogger));
        StreamBufferingEncoder streamBufferingEncoder = new StreamBufferingEncoder(new DefaultHttp2ConnectionEncoder(http2Connection, iVar));
        http2Connection.local().flowController(new DefaultHttp2LocalFlowController(http2Connection, 0.5f, true));
        DefaultHttp2ConnectionDecoder defaultHttp2ConnectionDecoder = new DefaultHttp2ConnectionDecoder(http2Connection, streamBufferingEncoder, http2InboundFrameLogger);
        q3Var.i(new i1.g(http2Connection));
        Http2Settings http2Settings = new Http2Settings();
        http2Settings.pushEnabled(false);
        http2Settings.initialWindowSize(i10);
        http2Settings.maxConcurrentStreams(0L);
        http2Settings.maxHeaderListSize(i11);
        return new h0(defaultHttp2ConnectionDecoder, streamBufferingEncoder, http2Settings, hVar, eVar, j1Var, q0Var, runnable, q3Var, aVar, str, z10, iVar, u0Var);
    }

    public static h0 x2(yj.e eVar, @gm.j wj.j1 j1Var, boolean z10, int i10, int i11, c1.q0<c1.o0> q0Var, Runnable runnable, q3 q3Var, vj.a aVar, String str, vj.h hVar, c1.u0 u0Var) {
        c1.h0.e(i11 > 0, "maxHeaderListSize must be positive");
        DefaultHttp2FrameReader defaultHttp2FrameReader = new DefaultHttp2FrameReader(new m.a(true, i11));
        DefaultHttp2FrameWriter defaultHttp2FrameWriter = new DefaultHttp2FrameWriter(new DefaultHttp2HeadersEncoder(Http2HeadersEncoder.NEVER_SENSITIVE, false, 16, Integer.MAX_VALUE));
        DefaultHttp2Connection defaultHttp2Connection = new DefaultHttp2Connection(false);
        WeightedFairQueueByteDistributor weightedFairQueueByteDistributor = new WeightedFairQueueByteDistributor(defaultHttp2Connection);
        weightedFairQueueByteDistributor.allocationQuantum(16384);
        defaultHttp2Connection.remote().flowController(new DefaultHttp2RemoteFlowController(defaultHttp2Connection, weightedFairQueueByteDistributor));
        return w2(defaultHttp2Connection, defaultHttp2FrameReader, defaultHttp2FrameWriter, eVar, j1Var, z10, i10, i11, q0Var, runnable, q3Var, aVar, str, hVar, u0Var);
    }

    public final void A2(int i10, long j10) {
        i0.c cVarL2 = l2(connection().stream(i10));
        if (cVarL2 != null) {
            fm.c.k("NettyClientHandler.onRstStreamRead", cVarL2.F);
            cVarL2.Q(H2(null, "RST_STREAM closed stream", j10, null), j10 == Http2Error.REFUSED_STREAM.code() ? wj.t.a.REFUSED : wj.t.a.PROCESSED, false, new v1());
            wj.j1 j1Var = this.H;
            if (j1Var != null) {
                j1Var.n();
            }
        }
    }

    public final Http2Stream B2(int i10) {
        Http2Stream http2StreamStream = connection().stream(i10);
        if (http2StreamStream != null) {
            return http2StreamStream;
        }
        throw new AssertionError(h.a.a("Stream does not exist: ", i10));
    }

    public void C2(Http2Stream http2Stream, int i10) {
        try {
            decoder().flowController().consumeBytes(http2Stream, i10);
        } catch (Http2Exception e10) {
            throw new RuntimeException(e10);
        }
    }

    public final void D2(ChannelHandlerContext channelHandlerContext, a1 a1Var, ChannelPromise channelPromise) {
        fm.f fVarZ = fm.c.z("NettyClientHandler.sendGrpcFrame");
        try {
            fm.c.a(a1Var.f20850a.d());
            fm.c.n(a1Var.f20852c);
            encoder().writeData(channelHandlerContext, a1Var.f20850a.id(), a1Var.content(), 0, a1Var.f20851b, channelPromise);
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

    public final void E2(ChannelHandlerContext channelHandlerContext, b1 b1Var, ChannelPromise channelPromise) {
        fm.f fVarZ = fm.c.z("NettyClientHandler.sendPingFrame");
        try {
            fm.c.n(b1Var.b());
            F2(channelHandlerContext, b1Var, channelPromise);
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

    public final void F2(ChannelHandlerContext channelHandlerContext, b1 b1Var, ChannelPromise channelPromise) {
        wj.u.a aVarD = b1Var.d();
        Executor executorE = b1Var.e();
        if (this.O != null) {
            channelPromise.setSuccess();
            this.O.a(aVarD, executorE);
            return;
        }
        channelPromise.setSuccess();
        ChannelPromise channelPromiseNewPromise = this.f20859i.newPromise();
        c1.o0 o0Var = this.I.get();
        o0Var.k();
        wj.z0 z0Var = new wj.z0(W, o0Var);
        this.O = z0Var;
        z0Var.a(aVarD, executorE);
        encoder().writePing(channelHandlerContext, false, W, channelPromiseNewPromise);
        channelHandlerContext.flush();
        channelPromiseNewPromise.addListener((GenericFutureListener<? extends Future<? super Void>>) new e(this.O));
    }

    public void G2(Channel channel) {
        this.N = new k1(channel);
    }

    public final y2 H2(y2.b bVar, String str, long j10, byte[] bArr) {
        y2 y2VarStatusForCode = wj.v0.j.statusForCode(j10);
        if (bVar == null) {
            bVar = y2VarStatusForCode.f17568a;
        }
        String strConcat = (bArr == null || bArr.length <= 0) ? "" : ", debug data: ".concat(new String(bArr, CharsetUtil.UTF_8));
        y2 status = bVar.toStatus();
        StringBuilder sbA = k.c.a(str, ". ");
        sbA.append(y2VarStatusForCode.f17569b);
        sbA.append(strConcat);
        return status.u(sbA.toString());
    }

    @Override // yj.l
    public String b() {
        return this.L;
    }

    @Override // yj.l
    public vj.a c() {
        return this.K;
    }

    @Override // io.netty.handler.codec.http2.Http2ConnectionHandler, io.netty.handler.codec.ByteToMessageDecoder, io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelInboundHandler
    public void channelInactive(ChannelHandlerContext channelHandlerContext) throws Exception {
        try {
            T.fine("Network channel is closed");
            y2 y2VarU = y2.f17563t.u("Network closed for unknown reason");
            this.f20951y.g(y2VarU);
            y2 y2Var = this.S;
            if (y2Var == null) {
                y2Var = this.f20951y.f20892e;
            }
            try {
                j2(this.f20951y.f20893f);
                connection().forEachActiveStream(new c(y2Var));
                this.f20951y.h(y2VarU);
                super.channelInactive(channelHandlerContext);
                wj.j1 j1Var = this.H;
                if (j1Var != null) {
                    j1Var.r();
                }
            } catch (Throwable th2) {
                this.f20951y.h(y2VarU);
                throw th2;
            }
        } catch (Throwable th3) {
            super.channelInactive(channelHandlerContext);
            wj.j1 j1Var2 = this.H;
            if (j1Var2 != null) {
                j1Var2.r();
            }
            throw th3;
        }
    }

    @Override // io.netty.handler.codec.http2.Http2ConnectionHandler, io.netty.channel.ChannelOutboundHandler
    public void close(ChannelHandlerContext channelHandlerContext, ChannelPromise channelPromise) throws Exception {
        T.fine("Network channel being closed by the application.");
        if (channelHandlerContext.channel().isActive()) {
            this.f20951y.g(y2.f17563t.u("Transport closed for unknown reason"));
        }
        super.close(channelHandlerContext, channelPromise);
    }

    @Override // io.netty.handler.codec.http2.Http2ConnectionHandler
    public boolean isGracefulShutdownComplete() {
        return super.isGracefulShutdownComplete() && ((StreamBufferingEncoder) encoder()).numBufferedStreams() == 0;
    }

    public final void j2(Throwable th2) {
        wj.z0 z0Var = this.O;
        if (z0Var != null) {
            z0Var.f(th2);
            this.O = null;
        }
    }

    public final void k2(ChannelHandlerContext channelHandlerContext, yj.c cVar, ChannelPromise channelPromise) {
        i0.c cVarE = cVar.e();
        fm.f fVarZ = fm.c.z("NettyClientHandler.cancelStream");
        try {
            fm.c.a(cVarE.F);
            fm.c.n(cVar.b());
            y2 y2VarD = cVar.d();
            if (y2VarD != null) {
                cVarE.R(y2VarD, true, new v1());
            }
            if (cVar.e().c0()) {
                channelPromise.setSuccess();
            } else {
                encoder().writeRstStream(channelHandlerContext, cVarE.id(), Http2Error.CANCEL.code(), channelPromise);
            }
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

    public final i0.c l2(Http2Stream http2Stream) {
        if (http2Stream == null) {
            return null;
        }
        return (i0.c) http2Stream.getProperty(this.f20950x);
    }

    public final void m2(yj.f fVar, ChannelPromise channelPromise) throws Exception {
        if (this.f20951y.f20893f != null) {
            fVar.g().f0();
            fVar.g().Q(this.f20951y.f20892e, wj.t.a.MISCARRIED, true, new v1());
            channelPromise.setFailure(this.f20951y.f20893f);
            return;
        }
        try {
            int iV2 = v2();
            if (connection().goAwayReceived()) {
                y2 y2VarG = this.R;
                int iMaxActiveStreams = connection().local().maxActiveStreams();
                int iLastStreamKnownByPeer = connection().local().lastStreamKnownByPeer();
                if (y2VarG == null) {
                    y2VarG = y2.f17562s.u("Failed due to abrupt GOAWAY, but can't find GOAWAY details");
                } else if (iV2 > iLastStreamKnownByPeer) {
                    y2VarG = y2VarG.g("stream id: " + iV2 + ", GOAWAY Last-Stream-ID:" + iLastStreamKnownByPeer);
                } else if (connection().local().numActiveStreams() == iMaxActiveStreams) {
                    y2VarG = y2VarG.g("At MAX_CONCURRENT_STREAMS limit. limit: " + iMaxActiveStreams);
                }
                if (iV2 > iLastStreamKnownByPeer || connection().local().numActiveStreams() == iMaxActiveStreams) {
                    fVar.g().f0();
                    fVar.g().Q(y2VarG, wj.t.a.MISCARRIED, true, new v1());
                    y2VarG.getClass();
                    channelPromise.setFailure(new a3(y2VarG));
                    return;
                }
            }
            i0.c cVarG = fVar.g();
            Http2Headers http2HeadersD = fVar.d();
            cVarG.e0(iV2);
            fm.f fVarZ = fm.c.z("NettyClientHandler.createStream");
            try {
                fm.c.n(fVar.b());
                fm.c.a(cVarG.F);
                n2(iV2, cVarG, http2HeadersD, fVar.e(), fVar.f(), channelPromise);
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
        } catch (z2 e10) {
            fVar.g().f0();
            channelPromise.setFailure((Throwable) e10);
            if (connection().goAwaySent()) {
                return;
            }
            T.fine("Stream IDs have been exhausted for this connection. Initiating graceful shutdown of the connection.");
            this.f20951y.g(e10.getStatus());
            ChannelHandlerContext channelHandlerContext = this.f20859i;
            close(channelHandlerContext, channelHandlerContext.newPromise());
        }
    }

    public final void n2(int i10, i0.c cVar, Http2Headers http2Headers, boolean z10, boolean z11, ChannelPromise channelPromise) {
        encoder().writeHeaders(this.f20859i, i10, http2Headers, 0, z10, this.f20859i.newPromise()).addListener((GenericFutureListener<? extends Future<? super Void>>) new d(i10, cVar, z11, channelPromise));
    }

    @Override // yj.l
    public void o(vj.a aVar, vj.v0.f fVar) {
        vj.a aVar2 = this.P;
        aVar2.getClass();
        this.P = new vj.a.b(aVar2).e(aVar).a();
        this.Q = fVar;
        I2(this.f20859i.channel());
    }

    public final void o2(ChannelHandlerContext channelHandlerContext, yj.i iVar, ChannelPromise channelPromise) throws Exception {
        connection().forEachActiveStream(new f(iVar, channelHandlerContext));
        close(channelHandlerContext, channelPromise);
    }

    @Override // io.netty.handler.codec.http2.Http2ConnectionHandler
    public void onConnectionError(ChannelHandlerContext channelHandlerContext, boolean z10, Throwable th2, Http2Exception http2Exception) {
        T.log(Level.FINE, "Caught a connection error", th2);
        this.f20951y.g(i1.w(th2));
        super.onConnectionError(channelHandlerContext, z10, th2, http2Exception);
    }

    @Override // io.netty.handler.codec.http2.Http2ConnectionHandler
    public void onStreamError(ChannelHandlerContext channelHandlerContext, boolean z10, Throwable th2, Http2Exception.StreamException streamException) {
        i0.c cVarL2 = l2(connection().stream(streamException.streamId()));
        if (cVarL2 != null) {
            cVarL2.R(i1.w(th2), false, new v1());
        } else {
            T.log(Level.FINE, "Stream error for unknown stream " + streamException.streamId(), th2);
        }
        super.onStreamError(channelHandlerContext, z10, th2, streamException);
    }

    public vj.a p2() {
        return this.P;
    }

    public yj.e q2() {
        return this.f20951y;
    }

    public vj.v0.f r2() {
        return this.Q;
    }

    public k1 s2() {
        return this.N;
    }

    public final void t2(long j10, byte[] bArr) {
        y2.b bVar = y2.b.UNAVAILABLE;
        y2 y2VarH2 = H2(bVar, "GOAWAY shut down transport", j10, bArr);
        this.f20951y.d(y2VarH2);
        this.R = H2(bVar, "Abrupt GOAWAY closed unsent stream", j10, bArr);
        y2 y2VarH3 = H2(null, "Abrupt GOAWAY closed sent stream", j10, bArr);
        boolean z10 = j10 != Http2Error.NO_ERROR.code();
        this.N.b();
        if (this.f20951y.g(y2VarH2)) {
            this.S = H2(null, "Connection closed after GOAWAY", j10, bArr);
        }
        try {
            connection().forEachActiveStream(new g(connection().local().lastStreamKnownByPeer(), z10, y2VarH3));
        } catch (Http2Exception e10) {
            throw new RuntimeException(e10);
        }
    }

    public final void u2(ChannelHandlerContext channelHandlerContext, j jVar, ChannelPromise channelPromise) throws Exception {
        this.f20951y.g(jVar.d());
        flush(channelHandlerContext);
        close(channelHandlerContext, channelPromise);
    }

    public final int v2() throws z2 {
        int iIncrementAndGetNextStreamId = connection().local().incrementAndGetNextStreamId();
        if (iIncrementAndGetNextStreamId >= 0) {
            return iIncrementAndGetNextStreamId;
        }
        T.fine("Stream IDs have been exhausted for this connection. Initiating graceful shutdown of the connection.");
        y2 y2Var = V;
        y2Var.getClass();
        throw new z2(y2Var);
    }

    @Override // io.netty.handler.codec.http2.Http2ConnectionHandler, io.netty.channel.ChannelOutboundHandler
    public void write(ChannelHandlerContext channelHandlerContext, Object obj, ChannelPromise channelPromise) throws Exception {
        if (obj instanceof yj.f) {
            m2((yj.f) obj, channelPromise);
            return;
        }
        if (obj instanceof a1) {
            D2(channelHandlerContext, (a1) obj, channelPromise);
            return;
        }
        if (obj instanceof yj.c) {
            k2(channelHandlerContext, (yj.c) obj, channelPromise);
            return;
        }
        if (obj instanceof b1) {
            E2(channelHandlerContext, (b1) obj, channelPromise);
            return;
        }
        if (obj instanceof j) {
            u2(channelHandlerContext, (j) obj, channelPromise);
        } else if (obj instanceof yj.i) {
            o2(channelHandlerContext, (yj.i) obj, channelPromise);
        } else {
            if (obj != U) {
                throw new AssertionError("Write called for unexpected type: ".concat(obj.getClass().getName()));
            }
            channelHandlerContext.write(Unpooled.EMPTY_BUFFER, channelPromise);
        }
    }

    public final void y2(int i10, ByteBuf byteBuf, int i11, boolean z10) {
        O().g(byteBuf.readableBytes(), i11);
        i0.c cVarL2 = l2(B2(i10));
        fm.c.k("NettyClientHandler.onDataRead", cVarL2.F);
        cVarL2.h0(byteBuf, z10);
        wj.j1 j1Var = this.H;
        if (j1Var != null) {
            j1Var.n();
        }
    }

    public final void z2(int i10, Http2Headers http2Headers, boolean z10) {
        if (i10 != 1) {
            i0.c cVarL2 = l2(B2(i10));
            fm.c.k("NettyClientHandler.onHeadersRead", cVarL2.F);
            cVarL2.i0(http2Headers, z10);
        }
        wj.j1 j1Var = this.H;
        if (j1Var != null) {
            j1Var.n();
        }
    }

    public class h extends Http2FrameAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f20971a;

        public h() {
            this.f20971a = true;
        }

        @Override // io.netty.handler.codec.http2.Http2FrameAdapter, io.netty.handler.codec.http2.Http2FrameListener
        public int onDataRead(ChannelHandlerContext channelHandlerContext, int i10, ByteBuf byteBuf, int i11, boolean z10) throws Http2Exception {
            h0.this.y2(i10, byteBuf, i11, z10);
            return i11;
        }

        @Override // io.netty.handler.codec.http2.Http2FrameAdapter, io.netty.handler.codec.http2.Http2FrameListener
        public void onHeadersRead(ChannelHandlerContext channelHandlerContext, int i10, Http2Headers http2Headers, int i11, short s10, boolean z10, int i12, boolean z11) throws Http2Exception {
            h0.this.z2(i10, http2Headers, z11);
        }

        @Override // io.netty.handler.codec.http2.Http2FrameAdapter, io.netty.handler.codec.http2.Http2FrameListener
        public void onPingAckRead(ChannelHandlerContext channelHandlerContext, long j10) throws Http2Exception {
            wj.z0 z0Var = h0.this.O;
            h0.this.O().getClass();
            if (j10 == yj.b.f20855w) {
                h0.this.O().m();
                h0.T.log(Level.FINE, "Window: {0}", Integer.valueOf(h0.this.decoder().flowController().initialWindowSize(h0.this.connection().connectionStream())));
            } else if (z0Var == null) {
                h0.T.warning("Received unexpected ping ack. No ping outstanding");
            } else if (z0Var.h() == j10) {
                z0Var.d();
                h0.this.O = null;
            } else {
                h0.T.log(Level.WARNING, "Received unexpected ping ack. Expecting {0}, got {1}", new Object[]{Long.valueOf(z0Var.h()), Long.valueOf(j10)});
            }
            wj.j1 j1Var = h0.this.H;
            if (j1Var != null) {
                j1Var.n();
            }
        }

        @Override // io.netty.handler.codec.http2.Http2FrameAdapter, io.netty.handler.codec.http2.Http2FrameListener
        public void onPingRead(ChannelHandlerContext channelHandlerContext, long j10) throws Http2Exception {
            if (h0.this.H != null) {
                h0.this.H.n();
            }
        }

        @Override // io.netty.handler.codec.http2.Http2FrameAdapter, io.netty.handler.codec.http2.Http2FrameListener
        public void onRstStreamRead(ChannelHandlerContext channelHandlerContext, int i10, long j10) throws Http2Exception {
            h0.this.A2(i10, j10);
        }

        @Override // io.netty.handler.codec.http2.Http2FrameAdapter, io.netty.handler.codec.http2.Http2FrameListener
        public void onSettingsRead(ChannelHandlerContext channelHandlerContext, Http2Settings http2Settings) {
            if (this.f20971a) {
                this.f20971a = false;
                h0 h0Var = h0.this;
                h0Var.P = h0Var.f20951y.a(h0.this.P);
                h0.this.f20951y.f();
            }
        }

        public /* synthetic */ h(h0 h0Var, a aVar) {
            this();
        }
    }

    public static class i extends DecoratingHttp2FrameWriter implements yj.b.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f20973a;

        public i(Http2FrameWriter http2FrameWriter) {
            super(http2FrameWriter);
        }

        @Override // yj.b.d
        public boolean b() {
            return this.f20973a < 2;
        }

        @Override // io.netty.handler.codec.http2.DecoratingHttp2FrameWriter, io.netty.handler.codec.http2.Http2DataWriter
        public ChannelFuture writeData(ChannelHandlerContext channelHandlerContext, int i10, ByteBuf byteBuf, int i11, boolean z10, ChannelPromise channelPromise) {
            if (byteBuf.isReadable()) {
                this.f20973a = 0;
            }
            return super.writeData(channelHandlerContext, i10, byteBuf, i11, z10, channelPromise);
        }

        @Override // io.netty.handler.codec.http2.DecoratingHttp2FrameWriter, io.netty.handler.codec.http2.Http2FrameWriter
        public ChannelFuture writeHeaders(ChannelHandlerContext channelHandlerContext, int i10, Http2Headers http2Headers, int i11, boolean z10, ChannelPromise channelPromise) {
            this.f20973a = 0;
            return super.writeHeaders(channelHandlerContext, i10, http2Headers, i11, z10, channelPromise);
        }

        @Override // io.netty.handler.codec.http2.DecoratingHttp2FrameWriter, io.netty.handler.codec.http2.Http2FrameWriter
        public ChannelFuture writePing(ChannelHandlerContext channelHandlerContext, boolean z10, long j10, ChannelPromise channelPromise) {
            if (!z10) {
                this.f20973a++;
            }
            return super.writePing(channelHandlerContext, z10, j10, channelPromise);
        }

        @Override // io.netty.handler.codec.http2.DecoratingHttp2FrameWriter, io.netty.handler.codec.http2.Http2FrameWriter
        public ChannelFuture writeWindowUpdate(ChannelHandlerContext channelHandlerContext, int i10, int i11, ChannelPromise channelPromise) {
            this.f20973a = 0;
            return super.writeWindowUpdate(channelHandlerContext, i10, i11, channelPromise);
        }

        @Override // io.netty.handler.codec.http2.DecoratingHttp2FrameWriter, io.netty.handler.codec.http2.Http2FrameWriter
        public ChannelFuture writeHeaders(ChannelHandlerContext channelHandlerContext, int i10, Http2Headers http2Headers, int i11, short s10, boolean z10, int i12, boolean z11, ChannelPromise channelPromise) {
            this.f20973a = 0;
            return super.writeHeaders(channelHandlerContext, i10, http2Headers, i11, s10, z10, i12, z11, channelPromise);
        }
    }
}
