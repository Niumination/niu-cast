package yj;

import f1.i3;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelPromise;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GenericFutureListener;
import java.io.IOException;
import java.net.SocketAddress;
import java.net.SocketException;
import java.util.List;
import java.util.concurrent.ScheduledExecutorService;
import java.util.logging.Level;
import java.util.logging.Logger;
import q1.l2;
import q1.s1;
import vj.u2;
import vj.y2;
import wj.b3;
import wj.c3;
import wj.q3;

/* JADX INFO: loaded from: classes2.dex */
public class r0 implements b3 {

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final Logger f21259y = Logger.getLogger(String.format("%s.connections", r0.class.getName()));

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final i3<String> f21260z = i3.of("NativeIoException");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final vj.c1 f21261a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Channel f21262b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ChannelPromise f21263c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final y0 f21264d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f21265e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public o0 f21266f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public c3 f21267g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f21268h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f21269i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f21270j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final int f21271k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final int f21272l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final long f21273m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final long f21274n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final long f21275o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final long f21276p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final long f21277q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final boolean f21278r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final long f21279s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final int f21280t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final long f21281u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final vj.a f21282v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final List<? extends u2.a> f21283w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final q3 f21284x;

    public class a implements GenericFutureListener<Future<Object>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ l2 f21285a;

        public a(l2 l2Var) {
            this.f21285a = l2Var;
        }

        @Override // io.netty.util.concurrent.GenericFutureListener
        public void operationComplete(Future<Object> future) throws Exception {
            if (future.isSuccess()) {
                return;
            }
            this.f21285a.C(future.cause());
        }
    }

    public final class b implements ChannelFutureListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f21287a;

        public b() {
        }

        @Override // io.netty.util.concurrent.GenericFutureListener
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void operationComplete(ChannelFuture channelFuture) throws Exception {
            if (this.f21287a) {
                return;
            }
            this.f21287a = true;
            r0 r0Var = r0.this;
            r0Var.r(r0Var.f21266f.n2());
        }
    }

    public class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ l2 f21289a;

        public c(l2 l2Var) {
            this.f21289a = l2Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            l2 l2Var = this.f21289a;
            r0 r0Var = r0.this;
            l2Var.B(r0Var.q(r0Var.f21262b));
        }
    }

    public r0(Channel channel, ChannelPromise channelPromise, y0 y0Var, List<? extends u2.a> list, q3 q3Var, int i10, boolean z10, int i11, int i12, int i13, long j10, long j11, long j12, long j13, long j14, boolean z11, long j15, int i14, long j16, vj.a aVar) {
        this.f21262b = (Channel) c1.h0.F(channel, "channel");
        this.f21263c = channelPromise;
        this.f21264d = (y0) c1.h0.F(y0Var, "protocolNegotiator");
        this.f21283w = (List) c1.h0.F(list, "streamTracerFactories");
        this.f21284x = (q3) c1.h0.F(q3Var, "transportTracer");
        this.f21265e = i10;
        this.f21269i = z10;
        this.f21270j = i11;
        this.f21271k = i12;
        this.f21272l = i13;
        this.f21273m = j10;
        this.f21274n = j11;
        this.f21275o = j12;
        this.f21276p = j13;
        this.f21277q = j14;
        this.f21278r = z11;
        this.f21279s = j15;
        this.f21280t = i14;
        this.f21281u = j16;
        this.f21282v = (vj.a) c1.h0.F(aVar, "eagAttributes");
        SocketAddress socketAddressRemoteAddress = channel.remoteAddress();
        this.f21261a = vj.c1.a(getClass(), socketAddressRemoteAddress != null ? socketAddressRemoteAddress.toString() : null);
    }

    @b1.e
    public static Level p(Throwable th2) {
        return (th2.getClass().equals(IOException.class) || th2.getClass().equals(SocketException.class) || f21260z.contains(th2.getClass().getSimpleName())) ? Level.FINE : Level.INFO;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public vj.v0.l q(Channel channel) {
        c1.h0.g0(channel.eventLoop().inEventLoop());
        vj.v0.o oVarB = this.f21284x.b();
        SocketAddress socketAddressLocalAddress = this.f21262b.localAddress();
        SocketAddress socketAddressRemoteAddress = this.f21262b.remoteAddress();
        vj.v0.k kVarS = i1.s(channel);
        o0 o0Var = this.f21266f;
        return new vj.v0.l(oVarB, socketAddressLocalAddress, socketAddressRemoteAddress, kVarS, o0Var == null ? null : o0Var.r2());
    }

    @Override // wj.b3
    public void a(y2 y2Var) {
        if (this.f21262b.isOpen()) {
            this.f21262b.writeAndFlush(new i(y2Var));
        }
    }

    @Override // vj.m1
    public vj.c1 e() {
        return this.f21261a;
    }

    @Override // vj.a1
    public s1<vj.v0.l> j() {
        l2 l2VarF = l2.F();
        if (this.f21262b.eventLoop().inEventLoop()) {
            l2VarF.B(q(this.f21262b));
            return l2VarF;
        }
        this.f21262b.eventLoop().submit((Runnable) new c(l2VarF)).addListener(new a(l2VarF));
        return l2VarF;
    }

    public Channel l() {
        return this.f21262b;
    }

    @Override // wj.b3
    public ScheduledExecutorService m() {
        return this.f21262b.eventLoop();
    }

    public final o0 o(c3 c3Var, ChannelPromise channelPromise) {
        return o0.v2(c3Var, channelPromise, this.f21283w, this.f21284x, this.f21265e, this.f21269i, this.f21270j, this.f21272l, this.f21271k, this.f21273m, this.f21274n, this.f21275o, this.f21276p, this.f21277q, this.f21278r, this.f21279s, this.f21280t, this.f21281u, this.f21282v);
    }

    public final void r(Throwable th2) {
        if (th2 != null) {
            f21259y.log(p(th2), "Transport failed", th2);
        }
        if (this.f21268h) {
            return;
        }
        this.f21268h = true;
        this.f21267g.a();
    }

    public void s(c3 c3Var) {
        c1.h0.h0(this.f21267g == null, "Handler already registered");
        this.f21267g = c3Var;
        o0 o0VarO = o(c3Var, this.f21263c);
        this.f21266f = o0VarO;
        j1 j1Var = new j1(this.f21264d.a(o0VarO));
        b bVar = new b();
        this.f21263c.addListener((GenericFutureListener<? extends Future<? super Void>>) bVar);
        this.f21262b.closeFuture().addListener((GenericFutureListener<? extends Future<? super Void>>) bVar);
        this.f21262b.pipeline().addLast(j1Var);
    }

    @Override // wj.b3
    public void shutdown() {
        if (this.f21262b.isOpen()) {
            this.f21262b.close();
        }
    }

    public String toString() {
        return c1.z.c(this).e("logId", this.f21261a.f17063c).j("channel", this.f21262b).toString();
    }
}
