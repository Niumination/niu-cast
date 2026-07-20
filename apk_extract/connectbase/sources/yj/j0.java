package yj;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFactory;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoop;
import io.netty.channel.EventLoopGroup;
import io.netty.handler.codec.http2.StreamBufferingEncoder;
import io.netty.util.AsciiString;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GenericFutureListener;
import java.net.SocketAddress;
import java.nio.channels.ClosedChannelException;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import q1.l2;
import q1.s1;
import vj.v1;
import vj.w1;
import vj.y2;
import vj.z2;
import wj.i3;
import wj.q3;
import wj.r1;

/* JADX INFO: loaded from: classes2.dex */
public class j0 implements wj.x {
    public static final /* synthetic */ boolean D = false;
    public final vj.h A;
    public final boolean B;
    public final c1.u0 C;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final vj.c1 f21018a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<ChannelOption<?>, ?> f21019b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final SocketAddress f21020c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ChannelFactory<? extends Channel> f21021d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final EventLoopGroup f21022e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final y0 f21023f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f21024g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final AsciiString f21025h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final AsciiString f21026i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final boolean f21027j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final int f21028k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final int f21029l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final int f21030m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public wj.j1 f21031n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final long f21032o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final long f21033p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final boolean f21034q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final AsciiString f21035r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final Runnable f21036s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public h0 f21037t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public Channel f21038u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public y2 f21039v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public yj.e f21040w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final q3 f21041x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final vj.a f21042y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final e0.c f21043z;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ wj.u.a f21044a;

        public a(wj.u.a aVar) {
            this.f21044a = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            wj.u.a aVar = this.f21044a;
            y2 y2Var = j0.this.f21039v;
            y2Var.getClass();
            aVar.a(new z2(y2Var));
        }
    }

    public class b implements ChannelFutureListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ wj.u.a f21046a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Executor f21047b;

        public b(wj.u.a aVar, Executor executor) {
            this.f21046a = aVar;
            this.f21047b = executor;
        }

        @Override // io.netty.util.concurrent.GenericFutureListener
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void operationComplete(ChannelFuture channelFuture) throws Exception {
            if (channelFuture.isSuccess()) {
                return;
            }
            y2 y2VarR = j0.this.r(channelFuture);
            wj.u.a aVar = this.f21046a;
            Executor executor = this.f21047b;
            y2VarR.getClass();
            wj.z0.g(aVar, executor, new z2(y2VarR));
        }
    }

    public class c extends i0.c {
        public c(h0 h0Var, EventLoop eventLoop, int i10, i3 i3Var, q3 q3Var, String str, vj.e eVar) {
            super(h0Var, eventLoop, i10, i3Var, q3Var, str, eVar);
        }

        @Override // yj.i0.c
        public y2 g0(ChannelFuture channelFuture) {
            return j0.this.r(channelFuture);
        }
    }

    public class d implements Runnable {
        public d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            j0.this.f21040w.h(j0.this.f21039v);
        }
    }

    public class e implements ChannelFutureListener {
        public e() {
        }

        @Override // io.netty.util.concurrent.GenericFutureListener
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void operationComplete(ChannelFuture channelFuture) throws Exception {
            if (channelFuture.isSuccess()) {
                return;
            }
            j0.this.f21040w.h(i1.w(channelFuture.cause()));
        }
    }

    public class f implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ y2 f21051a;

        public f(y2 y2Var) {
            this.f21051a = y2Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            j0.this.f21040w.g(this.f21051a);
            j0.this.f21038u.write(new i(this.f21051a));
        }
    }

    public class g implements GenericFutureListener<Future<Object>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ l2 f21053a;

        public g(l2 l2Var) {
            this.f21053a = l2Var;
        }

        @Override // io.netty.util.concurrent.GenericFutureListener
        public void operationComplete(Future<Object> future) throws Exception {
            if (future.isSuccess()) {
                return;
            }
            this.f21053a.C(future.cause());
        }
    }

    public class h implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ l2 f21055a;

        public h(l2 l2Var) {
            this.f21055a = l2Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            l2 l2Var = this.f21055a;
            j0 j0Var = j0.this;
            l2Var.B(j0Var.p(j0Var.f21038u));
        }
    }

    public j0(SocketAddress socketAddress, ChannelFactory<? extends Channel> channelFactory, Map<ChannelOption<?>, ?> map, EventLoopGroup eventLoopGroup, y0 y0Var, boolean z10, int i10, int i11, int i12, long j10, long j11, boolean z11, String str, @gm.j String str2, Runnable runnable, q3 q3Var, vj.a aVar, e0.c cVar, vj.h hVar, boolean z12, c1.u0 u0Var) {
        y0 y0Var2 = (y0) c1.h0.F(y0Var, "negotiator");
        this.f21023f = y0Var2;
        this.f21035r = y0Var2.scheme();
        SocketAddress socketAddress2 = (SocketAddress) c1.h0.F(socketAddress, "address");
        this.f21020c = socketAddress2;
        this.f21022e = (EventLoopGroup) c1.h0.F(eventLoopGroup, "group");
        this.f21021d = channelFactory;
        this.f21019b = (Map) c1.h0.F(map, "channelOptions");
        this.f21027j = z10;
        this.f21028k = i10;
        this.f21029l = i11;
        this.f21030m = i12;
        this.f21032o = j10;
        this.f21033p = j11;
        this.f21034q = z11;
        this.f21024g = str;
        this.f21025h = new AsciiString(str);
        this.f21026i = new AsciiString(wj.v0.k("netty", str2));
        this.f21036s = (Runnable) c1.h0.F(runnable, "tooManyPingsRunnable");
        this.f21041x = (q3) c1.h0.F(q3Var, "transportTracer");
        this.f21042y = (vj.a) c1.h0.F(aVar, "eagAttributes");
        this.f21043z = (e0.c) c1.h0.F(cVar, "localSocketPicker");
        this.f21018a = vj.c1.a(getClass(), socketAddress2.toString());
        this.A = (vj.h) c1.h0.F(hVar, "channelLogger");
        this.B = z12;
        this.C = (c1.u0) c1.h0.F(u0Var, "ticker");
    }

    @Override // wj.r1
    public void a(y2 y2Var) {
        Channel channel = this.f21038u;
        if (channel == null || !channel.isOpen()) {
            return;
        }
        this.f21037t.s2().d(new f(y2Var), true);
    }

    @Override // wj.x
    public vj.a c() {
        return this.f21037t.p2();
    }

    @Override // wj.u
    public void d(wj.u.a aVar, Executor executor) {
        if (this.f21038u == null) {
            executor.execute(new a(aVar));
        } else {
            this.f21037t.s2().c(new b1(aVar, executor), true).addListener((GenericFutureListener<? extends Future<? super Void>>) new b(aVar, executor));
        }
    }

    @Override // vj.m1
    public vj.c1 e() {
        return this.f21018a;
    }

    @Override // wj.r1
    public Runnable f(r1.a aVar) {
        ChannelOption channelOptionQ;
        this.f21040w = new yj.e((r1.a) c1.h0.F(aVar, "listener"));
        EventLoop next = this.f21022e.next();
        if (this.f21032o != Long.MAX_VALUE) {
            this.f21031n = new wj.j1(new wj.j1.c(this), next, this.f21032o, this.f21033p, this.f21034q);
        }
        h0 h0VarX2 = h0.x2(this.f21040w, this.f21031n, this.f21027j, this.f21028k, this.f21030m, wj.v0.M, this.f21036s, this.f21041x, this.f21042y, this.f21024g, this.A, this.C);
        this.f21037t = h0VarX2;
        ChannelHandler channelHandlerA = this.f21023f.a(h0VarX2);
        Bootstrap bootstrap = new Bootstrap();
        bootstrap.option(ChannelOption.ALLOCATOR, i1.p(false));
        bootstrap.group(next);
        bootstrap.channelFactory((ChannelFactory) this.f21021d);
        bootstrap.option(ChannelOption.SO_KEEPALIVE, Boolean.TRUE);
        if (this.f21032o != Long.MAX_VALUE && (channelOptionQ = i1.q("TCP_USER_TIMEOUT")) != null) {
            bootstrap.option(channelOptionQ, Integer.valueOf((int) TimeUnit.NANOSECONDS.toMillis(this.f21033p)));
        }
        for (Map.Entry<ChannelOption<?>, ?> entry : this.f21019b.entrySet()) {
            bootstrap.option(entry.getKey(), entry.getValue());
        }
        bootstrap.handler(new j1(channelHandlerA));
        ChannelFuture channelFutureRegister = bootstrap.register();
        if (channelFutureRegister.isDone() && !channelFutureRegister.isSuccess()) {
            this.f21038u = null;
            Throwable thCause = channelFutureRegister.cause();
            if (thCause == null) {
                thCause = new IllegalStateException("Channel is null, but future doesn't have a cause");
            }
            this.f21039v = i1.w(thCause);
            return new d();
        }
        Channel channel = channelFutureRegister.channel();
        this.f21038u = channel;
        this.f21037t.G2(channel);
        this.f21038u.writeAndFlush(h0.U).addListener((GenericFutureListener<? extends Future<? super Void>>) new e());
        SocketAddress socketAddressA = this.f21043z.a(this.f21020c, this.f21042y);
        if (socketAddressA != null) {
            this.f21038u.connect(this.f21020c, socketAddressA);
        } else {
            this.f21038u.connect(this.f21020c);
        }
        wj.j1 j1Var = this.f21031n;
        if (j1Var != null) {
            j1Var.q();
        }
        return null;
    }

    @Override // vj.a1
    public s1<vj.v0.l> j() {
        l2 l2VarF = l2.F();
        if (this.f21038u.eventLoop().inEventLoop()) {
            l2VarF.B(p(this.f21038u));
            return l2VarF;
        }
        this.f21038u.eventLoop().submit((Runnable) new h(l2VarF)).addListener(new g(l2VarF));
        return l2VarF;
    }

    @Override // wj.u
    public wj.s k(w1<?, ?> w1Var, v1 v1Var, vj.e eVar, vj.n[] nVarArr) {
        c1.h0.F(w1Var, "method");
        c1.h0.F(v1Var, "headers");
        if (this.f21038u == null) {
            return new wj.i0(this.f21039v, nVarArr);
        }
        i3 i3VarI = i3.i(nVarArr, c(), v1Var);
        return new i0(new c(this.f21037t, this.f21038u.eventLoop(), this.f21029l, i3VarI, this.f21041x, w1Var.f17481b, eVar), w1Var, v1Var, this.f21038u, this.f21025h, this.f21035r, this.f21026i, i3VarI, this.f21041x, eVar, this.B);
    }

    @Override // wj.r1
    public void n(y2 y2Var) {
        Channel channel = this.f21038u;
        if (channel != null && channel.isOpen()) {
            this.f21037t.s2().c(new j(y2Var), true);
        }
    }

    @b1.e
    public Channel o() {
        return this.f21038u;
    }

    public final vj.v0.l p(Channel channel) {
        vj.v0.o oVarB = this.f21041x.b();
        SocketAddress socketAddressLocalAddress = this.f21038u.localAddress();
        SocketAddress socketAddressRemoteAddress = this.f21038u.remoteAddress();
        vj.v0.k kVarS = i1.s(channel);
        h0 h0Var = this.f21037t;
        return new vj.v0.l(oVarB, socketAddressLocalAddress, socketAddressRemoteAddress, kVarS, h0Var == null ? null : h0Var.r2());
    }

    @b1.e
    public wj.j1 q() {
        return this.f21031n;
    }

    public final y2 r(ChannelFuture channelFuture) {
        Throwable thCause = channelFuture.cause();
        if (!(thCause instanceof ClosedChannelException) && !(thCause instanceof StreamBufferingEncoder.Http2ChannelClosedException)) {
            return i1.w(thCause);
        }
        y2 y2Var = this.f21040w.f20892e;
        return y2Var == null ? y2.f17550g.u("Channel closed but for unknown reason").t(new ClosedChannelException().initCause(thCause)) : y2Var;
    }

    public String toString() {
        return c1.z.c(this).e("logId", this.f21018a.f17063c).j("remoteAddress", this.f21020c).j("channel", this.f21038u).toString();
    }
}
