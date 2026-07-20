package yj;

import io.netty.channel.ChannelFactory;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.ReflectiveChannelFactory;
import io.netty.channel.ServerChannel;
import io.netty.handler.ssl.SslContext;
import java.io.File;
import java.io.InputStream;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.SSLException;
import vj.j2;
import vj.n2;
import vj.u2;
import wj.g3;
import wj.q3;
import wj.x2;
import wj.z1;

/* JADX INFO: loaded from: classes2.dex */
@t1.b
@vj.e0("https://github.com/grpc/grpc-java/issues/1784")
public final class m0 extends vj.j0<m0> {
    public static final int A = 1048576;
    public static final long B = Long.MAX_VALUE;
    public static final long C = Long.MAX_VALUE;
    public static final long D = Long.MAX_VALUE;
    public static final int E = 0;
    public static final long F;
    public static final long G;
    public static final long H;
    public static final z1<? extends EventLoopGroup> I;
    public static final z1<? extends EventLoopGroup> J;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final x2 f21141a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<SocketAddress> f21142b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public q3.b f21143c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ChannelFactory<? extends ServerChannel> f21144d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Map<ChannelOption<?>, Object> f21145e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Map<ChannelOption<?>, Object> f21146f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public z1<? extends EventLoopGroup> f21147g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public z1<? extends EventLoopGroup> f21148h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f21149i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public y0.b f21150j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final boolean f21151k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f21152l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f21153m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f21154n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f21155o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f21156p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public long f21157q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public long f21158r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public long f21159s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public long f21160t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public long f21161u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f21162v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public long f21163w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f21164x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public long f21165y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public vj.a f21166z;

    public final class b implements x2.b {
        public b() {
        }

        @Override // wj.x2.b
        public wj.d1 a(List<? extends u2.a> list) {
            return m0.this.H(list);
        }
    }

    static {
        TimeUnit timeUnit = TimeUnit.SECONDS;
        F = timeUnit.toNanos(1L);
        G = timeUnit.toNanos(1L);
        H = TimeUnit.DAYS.toNanos(1000L);
        I = new g3(i1.f21001n);
        J = new g3(i1.f21002o);
    }

    public m0(SocketAddress socketAddress) {
        ArrayList arrayList = new ArrayList();
        this.f21142b = arrayList;
        this.f21143c = q3.a();
        this.f21144d = i1.f21003p;
        this.f21145e = new HashMap();
        this.f21146f = new HashMap();
        this.f21147g = I;
        this.f21148h = J;
        this.f21152l = Integer.MAX_VALUE;
        this.f21153m = true;
        this.f21154n = 1048576;
        this.f21155o = 4194304;
        this.f21156p = 8192;
        this.f21157q = wj.v0.C;
        this.f21158r = wj.v0.D;
        this.f21159s = Long.MAX_VALUE;
        this.f21160t = Long.MAX_VALUE;
        this.f21161u = Long.MAX_VALUE;
        this.f21163w = TimeUnit.MINUTES.toNanos(5L);
        this.f21166z = vj.a.f17046c;
        this.f21141a = new x2(new b());
        arrayList.add(socketAddress);
        this.f21150j = z0.m();
        this.f21151k = false;
    }

    public static m0 M(SocketAddress socketAddress) {
        return new m0(socketAddress);
    }

    public static m0 N(SocketAddress socketAddress, n2 n2Var) {
        z0.h hVarD = z0.d(n2Var);
        if (hVarD.f21333b == null) {
            return new m0(socketAddress, hVarD.f21332a);
        }
        throw new IllegalArgumentException(hVarD.f21333b);
    }

    public static m0 O(int i10) {
        return new m0(new InetSocketAddress(i10));
    }

    public static m0 P(int i10, n2 n2Var) {
        return N(new InetSocketAddress(i10), n2Var);
    }

    @Override // vj.j0
    @vj.t0
    public j2<?> C() {
        return this.f21141a;
    }

    @t1.a
    public m0 D(SocketAddress socketAddress) {
        this.f21142b.add((SocketAddress) c1.h0.F(socketAddress, "listenAddress"));
        return this;
    }

    @b1.e
    public void E() {
        ChannelFactory<? extends ServerChannel> channelFactory = this.f21144d;
        ChannelFactory<? extends ServerChannel> channelFactory2 = i1.f21003p;
        c1.h0.h0((channelFactory != channelFactory2 && this.f21147g != I && this.f21148h != J) || (channelFactory == channelFactory2 && this.f21147g == I && this.f21148h == J), "All of BossEventLoopGroup, WorkerEventLoopGroup and ChannelType should be provided or neither should be");
    }

    @t1.a
    public m0 F(EventLoopGroup eventLoopGroup) {
        return eventLoopGroup != null ? G(new wj.k0(eventLoopGroup)) : G(I);
    }

    @t1.a
    public m0 G(z1<? extends EventLoopGroup> z1Var) {
        this.f21147g = (z1) c1.h0.F(z1Var, "bossEventLoopGroupPool");
        return this;
    }

    public l0 H(List<? extends u2.a> list) {
        E();
        return new l0(this.f21142b, this.f21144d, this.f21145e, this.f21146f, this.f21147g, this.f21148h, this.f21149i, this.f21150j.a(this.f21141a.f19548g), list, this.f21143c, this.f21152l, this.f21153m, this.f21154n, this.f21155o, this.f21156p, this.f21157q, this.f21158r, this.f21159s, this.f21160t, this.f21161u, this.f21162v, this.f21163w, this.f21164x, this.f21165y, this.f21166z, this.f21141a.f19559r);
    }

    @t1.a
    public m0 I(ChannelFactory<? extends ServerChannel> channelFactory) {
        this.f21144d = (ChannelFactory) c1.h0.F(channelFactory, "channelFactory");
        return this;
    }

    @t1.a
    public m0 J(Class<? extends ServerChannel> cls) {
        c1.h0.F(cls, "channelType");
        return I(new ReflectiveChannelFactory(cls));
    }

    public void K(vj.a aVar) {
        this.f21166z = (vj.a) c1.h0.F(aVar, "eagAttributes");
    }

    @t1.a
    public m0 L(int i10) {
        c1.h0.k(i10 > 0, "flowControlWindow must be positive: %s", i10);
        this.f21154n = i10;
        this.f21153m = false;
        return this;
    }

    @t1.a
    public m0 Q(int i10) {
        c1.h0.e(i10 > 0, "initialFlowControlWindow must be positive");
        this.f21154n = i10;
        this.f21153m = true;
        return this;
    }

    @Override // vj.j0, vj.j2
    @t1.a
    /* JADX INFO: renamed from: R, reason: merged with bridge method [inline-methods] */
    public m0 p(long j10, TimeUnit timeUnit) {
        c1.h0.p(j10 > 0, "keepalive time must be positive：%s", j10);
        long nanos = timeUnit.toNanos(j10);
        this.f21157q = nanos;
        long jL = wj.j1.l(nanos);
        this.f21157q = jL;
        if (jL >= H) {
            this.f21157q = Long.MAX_VALUE;
        }
        return this;
    }

    @Override // vj.j0, vj.j2
    @t1.a
    /* JADX INFO: renamed from: S, reason: merged with bridge method [inline-methods] */
    public m0 q(long j10, TimeUnit timeUnit) {
        c1.h0.p(j10 > 0, "keepalive timeout must be positive: %s", j10);
        long nanos = timeUnit.toNanos(j10);
        this.f21158r = nanos;
        this.f21158r = wj.j1.m(nanos);
        return this;
    }

    @t1.a
    public m0 T(int i10) {
        c1.h0.k(i10 > 0, "max must be positive: %s", i10);
        this.f21152l = i10;
        return this;
    }

    @Override // vj.j0, vj.j2
    @t1.a
    /* JADX INFO: renamed from: U, reason: merged with bridge method [inline-methods] */
    public m0 r(long j10, TimeUnit timeUnit) {
        c1.h0.p(j10 > 0, "max connection age must be positive: %s", j10);
        long nanos = timeUnit.toNanos(j10);
        this.f21160t = nanos;
        if (nanos >= H) {
            this.f21160t = Long.MAX_VALUE;
        }
        long j11 = this.f21160t;
        long j12 = G;
        if (j11 < j12) {
            this.f21160t = j12;
        }
        return this;
    }

    @Override // vj.j0, vj.j2
    @t1.a
    /* JADX INFO: renamed from: V, reason: merged with bridge method [inline-methods] */
    public m0 s(long j10, TimeUnit timeUnit) {
        c1.h0.p(j10 >= 0, "max connection age grace must be non-negative: %s", j10);
        long nanos = timeUnit.toNanos(j10);
        this.f21161u = nanos;
        if (nanos >= H) {
            this.f21161u = Long.MAX_VALUE;
        }
        return this;
    }

    @Override // vj.j0, vj.j2
    @t1.a
    /* JADX INFO: renamed from: W, reason: merged with bridge method [inline-methods] */
    public m0 t(long j10, TimeUnit timeUnit) {
        c1.h0.p(j10 > 0, "max connection idle must be positive: %s", j10);
        long nanos = timeUnit.toNanos(j10);
        this.f21159s = nanos;
        if (nanos >= H) {
            this.f21159s = Long.MAX_VALUE;
        }
        long j11 = this.f21159s;
        long j12 = F;
        if (j11 < j12) {
            this.f21159s = j12;
        }
        return this;
    }

    @t1.l(replacement = "this.maxInboundMetadataSize(maxHeaderListSize)")
    @t1.a
    @Deprecated
    public m0 X(int i10) {
        return v(i10);
    }

    @Override // vj.j0, vj.j2
    @t1.a
    /* JADX INFO: renamed from: Y, reason: merged with bridge method [inline-methods] */
    public m0 u(int i10) {
        c1.h0.k(i10 >= 0, "bytes must be non-negative: %s", i10);
        this.f21155o = i10;
        return this;
    }

    @Override // vj.j0, vj.j2
    @t1.a
    /* JADX INFO: renamed from: Z, reason: merged with bridge method [inline-methods] */
    public m0 v(int i10) {
        c1.h0.k(i10 > 0, "maxInboundMetadataSize must be positive: %s", i10);
        this.f21156p = i10;
        return this;
    }

    @t1.l(replacement = "this.maxInboundMessageSize(maxMessageSize)")
    @t1.a
    @Deprecated
    public m0 a0(int i10) {
        return u(i10);
    }

    @t1.a
    public m0 b0(int i10, int i11) {
        c1.h0.e(i10 > 0, "maxRstStream must be positive");
        c1.h0.e(i11 > 0, "secondsPerWindow must be positive");
        if (i10 == Integer.MAX_VALUE) {
            i10 = 0;
        }
        this.f21164x = i10;
        this.f21165y = TimeUnit.SECONDS.toNanos(i11);
        return this;
    }

    @Override // vj.j0, vj.j2
    @t1.a
    /* JADX INFO: renamed from: c0, reason: merged with bridge method [inline-methods] */
    public m0 w(long j10, TimeUnit timeUnit) {
        c1.h0.p(j10 >= 0, "permit keepalive time must be non-negative: %s", j10);
        this.f21163w = timeUnit.toNanos(j10);
        return this;
    }

    @t1.a
    public m0 d0(boolean z10) {
        this.f21162v = z10;
        return this;
    }

    @t1.a
    @vj.t0
    public final m0 e0(y0 y0Var) {
        c1.h0.h0(!this.f21151k, "Cannot change security when using ServerCredentials");
        this.f21150j = z0.b(y0Var);
        return this;
    }

    public void f0(boolean z10) {
        this.f21149i = z10;
    }

    public void g0(boolean z10) {
        this.f21141a.f19553l = z10;
    }

    public void h0(boolean z10) {
        this.f21141a.f19556o = z10;
    }

    public void i0(boolean z10) {
        this.f21141a.f19554m = z10;
    }

    public void j0(boolean z10) {
        this.f21141a.f19557p = z10;
    }

    @t1.a
    public m0 k0(q3.b bVar) {
        this.f21143c = bVar;
        return this;
    }

    @t1.a
    public m0 l0(SslContext sslContext) {
        c1.h0.h0(!this.f21151k, "Cannot change security when using ServerCredentials");
        if (sslContext != null) {
            c1.h0.e(sslContext.isServer(), "Client SSL context can not be used for server");
            o.e(sslContext.applicationProtocolNegotiator());
            this.f21150j = z0.p(sslContext);
        } else {
            this.f21150j = z0.m();
        }
        return this;
    }

    @Override // vj.j0, vj.j2
    @t1.a
    /* JADX INFO: renamed from: m0, reason: merged with bridge method [inline-methods] */
    public m0 A(File file, File file2) {
        c1.h0.h0(!this.f21151k, "Cannot change security when using ServerCredentials");
        try {
            this.f21150j = z0.p(o.h(file, file2).build());
            return this;
        } catch (SSLException e10) {
            throw new RuntimeException(e10);
        }
    }

    @Override // vj.j0, vj.j2
    @t1.a
    /* JADX INFO: renamed from: n0, reason: merged with bridge method [inline-methods] */
    public m0 B(InputStream inputStream, InputStream inputStream2) {
        c1.h0.h0(!this.f21151k, "Cannot change security when using ServerCredentials");
        try {
            this.f21150j = z0.p(o.j(inputStream, inputStream2).build());
            return this;
        } catch (SSLException e10) {
            throw new RuntimeException(e10);
        }
    }

    @t1.a
    public <T> m0 o0(ChannelOption<T> channelOption, T t10) {
        this.f21146f.put(channelOption, t10);
        return this;
    }

    @t1.a
    public <T> m0 p0(ChannelOption<T> channelOption, T t10) {
        this.f21145e.put(channelOption, t10);
        return this;
    }

    @t1.a
    public m0 q0(EventLoopGroup eventLoopGroup) {
        return eventLoopGroup != null ? r0(new wj.k0(eventLoopGroup)) : r0(J);
    }

    @t1.a
    public m0 r0(z1<? extends EventLoopGroup> z1Var) {
        this.f21148h = (z1) c1.h0.F(z1Var, "workerEventLoopGroupPool");
        return this;
    }

    @Override // vj.j0, vj.j2
    @t1.a
    public j2 x(boolean z10) {
        this.f21162v = z10;
        return this;
    }

    public m0(SocketAddress socketAddress, y0.b bVar) {
        ArrayList arrayList = new ArrayList();
        this.f21142b = arrayList;
        this.f21143c = q3.a();
        this.f21144d = i1.f21003p;
        this.f21145e = new HashMap();
        this.f21146f = new HashMap();
        this.f21147g = I;
        this.f21148h = J;
        this.f21152l = Integer.MAX_VALUE;
        this.f21153m = true;
        this.f21154n = 1048576;
        this.f21155o = 4194304;
        this.f21156p = 8192;
        this.f21157q = wj.v0.C;
        this.f21158r = wj.v0.D;
        this.f21159s = Long.MAX_VALUE;
        this.f21160t = Long.MAX_VALUE;
        this.f21161u = Long.MAX_VALUE;
        this.f21163w = TimeUnit.MINUTES.toNanos(5L);
        this.f21166z = vj.a.f17046c;
        this.f21141a = new x2(new b());
        arrayList.add(socketAddress);
        this.f21150j = (y0.b) c1.h0.F(bVar, "negotiatorFactory");
        this.f21151k = true;
    }
}
