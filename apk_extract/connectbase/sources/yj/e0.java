package yj;

import io.netty.channel.Channel;
import io.netty.channel.ChannelFactory;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.ReflectiveChannelFactory;
import io.netty.handler.ssl.SslContext;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.SSLException;
import vj.s1;
import wj.g3;
import wj.o1;
import wj.q3;
import wj.z1;

/* JADX INFO: loaded from: classes2.dex */
@t1.b
@vj.e0("https://github.com/grpc/grpc-java/issues/1784")
public final class e0 extends vj.f0<e0> {

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final int f20895r = 1048576;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final boolean f20896s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final long f20897t = TimeUnit.DAYS.toNanos(1000);

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final ChannelFactory<? extends Channel> f20898u = new ReflectiveChannelFactory(i1.f21004q);

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final z1<? extends EventLoopGroup> f20899v = new g3(i1.f21002o);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final o1 f20900a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public q3.b f20901b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<ChannelOption<?>, Object> f20902c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ChannelFactory<? extends Channel> f20903d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public z1<? extends EventLoopGroup> f20904e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f20905f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f20906g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f20907h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f20908i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public long f20909j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public long f20910k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f20911l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public y0.a f20912m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final boolean f20913n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public c f20914o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final boolean f20915p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public Class<? extends SocketAddress> f20916q;

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f20917a;

        static {
            int[] iArr = new int[c0.values().length];
            f20917a = iArr;
            try {
                iArr[c0.PLAINTEXT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f20917a[c0.PLAINTEXT_UPGRADE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f20917a[c0.TLS.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    @vj.e0("https://github.com/grpc/grpc-java/issues/4917")
    public static class c {
        @gm.j
        public SocketAddress a(SocketAddress socketAddress, vj.a aVar) {
            return null;
        }
    }

    public final class d implements o1.b {
        public d() {
        }

        @Override // wj.o1.b
        public int b() {
            return e0.this.f20912m.b();
        }

        public /* synthetic */ d(e0 e0Var, a aVar) {
            this();
        }
    }

    public final class e implements o1.c {
        public e() {
        }

        @Override // wj.o1.c
        public wj.v a() {
            return e0.this.N();
        }

        public /* synthetic */ e(e0 e0Var, a aVar) {
            this();
        }
    }

    public static final class f implements wj.v {
        public final boolean H;
        public boolean I;
        public final Class<? extends SocketAddress> J;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final y0 f20923a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final ChannelFactory<? extends Channel> f20924b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Map<ChannelOption<?>, ?> f20925c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final z1<? extends EventLoopGroup> f20926d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final EventLoopGroup f20927e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final boolean f20928f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final int f20929g;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final int f20930i;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public final int f20931n;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public final long f20932p;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        public final wj.h f20933v;

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        public final long f20934w;

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        public final boolean f20935x;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        public final q3.b f20936y;

        /* JADX INFO: renamed from: z, reason: collision with root package name */
        public final c f20937z;

        public class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ wj.h.b f20938a;

            public a(wj.h.b bVar) {
                this.f20938a = bVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.f20938a.a();
            }
        }

        public f(y0 y0Var, ChannelFactory<? extends Channel> channelFactory, Map<ChannelOption<?>, ?> map, z1<? extends EventLoopGroup> z1Var, boolean z10, int i10, int i11, int i12, long j10, long j11, boolean z11, q3.b bVar, c cVar, boolean z12, Class<? extends SocketAddress> cls) {
            this.f20923a = (y0) c1.h0.F(y0Var, "protocolNegotiator");
            this.f20924b = channelFactory;
            this.f20925c = new HashMap(map);
            this.f20926d = z1Var;
            this.f20927e = z1Var.a();
            this.f20928f = z10;
            this.f20929g = i10;
            this.f20930i = i11;
            this.f20931n = i12;
            this.f20932p = j10;
            this.f20933v = new wj.h("keepalive time nanos", j10);
            this.f20934w = j11;
            this.f20935x = z11;
            this.f20936y = bVar;
            this.f20937z = cVar != null ? cVar : new c();
            this.H = z12;
            this.J = cls;
        }

        @Override // wj.v
        public wj.x D(SocketAddress socketAddress, wj.v.a aVar, vj.h hVar) {
            SocketAddress targetAddress;
            y0 y0VarE;
            c1.h0.h0(!this.I, "The transport factory is closed.");
            y0 y0Var = this.f20923a;
            vj.q0 q0Var = aVar.f19352e;
            if (q0Var != null) {
                targetAddress = q0Var.getTargetAddress();
                y0VarE = z0.e(q0Var.getProxyAddress(), q0Var.getUsername(), q0Var.getPassword(), this.f20923a);
            } else {
                targetAddress = socketAddress;
                y0VarE = y0Var;
            }
            wj.h.b bVarD = this.f20933v.d();
            return new j0(targetAddress, this.f20924b, this.f20925c, this.f20927e, y0VarE, this.f20928f, this.f20929g, this.f20930i, this.f20931n, bVarD.f18703a, this.f20934w, this.f20935x, aVar.f19349b, aVar.f19351d, new a(bVarD), this.f20936y.a(), aVar.f19350c, this.f20937z, hVar, this.H, c1.u0.b());
        }

        @Override // wj.v
        public wj.v.b E1(vj.g gVar) {
            c1.h0.F(gVar, "channelCreds");
            z0.g gVarC = z0.c(gVar);
            if (gVarC.f21331c != null) {
                return null;
            }
            return new wj.v.b(new f(gVarC.f21329a.a(), this.f20924b, this.f20925c, this.f20926d, this.f20928f, this.f20929g, this.f20930i, this.f20931n, this.f20932p, this.f20934w, this.f20935x, this.f20936y, this.f20937z, this.H, this.J), gVarC.f21330b);
        }

        @Override // wj.v
        public Collection<Class<? extends SocketAddress>> a2() {
            Class<? extends SocketAddress> cls = this.J;
            if (cls == null) {
                return null;
            }
            return Collections.singleton(cls);
        }

        @Override // wj.v, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (this.I) {
                return;
            }
            this.I = true;
            this.f20923a.close();
            this.f20926d.b(this.f20927e);
        }

        @Override // wj.v
        public ScheduledExecutorService m() {
            return this.f20927e;
        }
    }

    static {
        String str = System.getenv("GRPC_EXPERIMENTAL_AUTOFLOWCONTROL");
        if (str == null) {
            str = "true";
        }
        f20896s = Boolean.parseBoolean(str);
    }

    public e0(String str) {
        this.f20901b = q3.a();
        this.f20902c = new HashMap();
        this.f20903d = f20898u;
        this.f20904e = f20899v;
        this.f20905f = f20896s;
        this.f20906g = 1048576;
        this.f20907h = 8192;
        this.f20908i = 4194304;
        this.f20909j = Long.MAX_VALUE;
        this.f20910k = wj.v0.A;
        this.f20912m = new b();
        this.f20915p = false;
        this.f20916q = InetSocketAddress.class;
        this.f20900a = new o1(str, new e(), new d());
        this.f20913n = false;
    }

    @b1.e
    public static y0 S(c0 c0Var, SslContext sslContext, z1<? extends Executor> z1Var) {
        int i10 = a.f20917a[c0Var.ordinal()];
        if (i10 == 1) {
            return z0.h();
        }
        if (i10 == 2) {
            return z0.j();
        }
        if (i10 == 3) {
            return z0.r(sslContext, z1Var);
        }
        throw new IllegalArgumentException("Unsupported negotiationType: " + c0Var);
    }

    public static e0 Y(String str, int i10) {
        return new e0(wj.v0.b(str, i10));
    }

    public static e0 Z(String str, int i10, vj.g gVar) {
        return d0(wj.v0.b(str, i10), gVar);
    }

    public static e0 a0(SocketAddress socketAddress) {
        return new e0(socketAddress);
    }

    public static e0 b0(SocketAddress socketAddress, vj.g gVar) {
        z0.g gVarC = z0.c(gVar);
        if (gVarC.f21331c == null) {
            return new e0(socketAddress, gVar, gVarC.f21330b, gVarC.f21329a);
        }
        throw new IllegalArgumentException(gVarC.f21331c);
    }

    public static e0 c0(String str) {
        return new e0(str);
    }

    public static e0 d0(String str, vj.g gVar) {
        z0.g gVarC = z0.c(gVar);
        if (gVarC.f21331c == null) {
            return new e0(str, gVar, gVarC.f21330b, gVarC.f21329a);
        }
        throw new IllegalArgumentException(gVarC.f21331c);
    }

    public static String e0(SocketAddress socketAddress) {
        if (!(socketAddress instanceof InetSocketAddress)) {
            return socketAddress.toString();
        }
        InetSocketAddress inetSocketAddress = (InetSocketAddress) socketAddress;
        return wj.v0.b(inetSocketAddress.getHostString(), inetSocketAddress.getPort());
    }

    public static Collection<Class<? extends SocketAddress>> g0() {
        return Collections.singleton(InetSocketAddress.class);
    }

    @t1.a
    public e0 A0() {
        p0(c0.TLS);
        return this;
    }

    @t1.a
    public <T> e0 B0(ChannelOption<T> channelOption, T t10) {
        this.f20902c.put(channelOption, t10);
        return this;
    }

    @Override // vj.f0, vj.s1
    @t1.a
    public s1 G() {
        p0(c0.PLAINTEXT);
        return this;
    }

    @Override // vj.f0, vj.s1
    @t1.a
    public s1 H() {
        p0(c0.TLS);
        return this;
    }

    @Override // vj.f0
    @vj.t0
    public s1<?> J() {
        return this.f20900a;
    }

    @b1.e
    public void M() {
        ChannelFactory<? extends Channel> channelFactory = this.f20903d;
        ChannelFactory<? extends Channel> channelFactory2 = f20898u;
        c1.h0.h0((channelFactory != channelFactory2 && this.f20904e != f20899v) || (channelFactory == channelFactory2 && this.f20904e == f20899v), "Both EventLoopGroup and ChannelType should be provided or neither should be");
    }

    public wj.v N() {
        M();
        return new f(this.f20912m.a(), this.f20903d, this.f20902c, this.f20904e, this.f20905f, this.f20906g, this.f20908i, this.f20907h, this.f20909j, this.f20910k, this.f20911l, this.f20901b, this.f20914o, false, this.f20916q);
    }

    @t1.a
    public e0 O(ChannelFactory<? extends Channel> channelFactory) {
        return P(channelFactory, null);
    }

    @t1.a
    public e0 P(ChannelFactory<? extends Channel> channelFactory, @gm.j Class<? extends SocketAddress> cls) {
        this.f20903d = (ChannelFactory) c1.h0.F(channelFactory, "channelFactory");
        this.f20916q = cls;
        return this;
    }

    @t1.a
    public e0 Q(Class<? extends Channel> cls) {
        return R(cls, null);
    }

    @t1.a
    public e0 R(Class<? extends Channel> cls, @gm.j Class<? extends SocketAddress> cls2) {
        c1.h0.F(cls, "channelType");
        return P(new ReflectiveChannelFactory(cls), cls2);
    }

    @t1.a
    public e0 T() {
        this.f20900a.B = true;
        return this;
    }

    @t1.a
    public e0 U() {
        this.f20900a.B = false;
        return this;
    }

    @t1.a
    public e0 V(@gm.j EventLoopGroup eventLoopGroup) {
        return eventLoopGroup != null ? W(new wj.k0(eventLoopGroup)) : W(f20899v);
    }

    @t1.a
    public e0 W(z1<? extends EventLoopGroup> z1Var) {
        this.f20904e = (z1) c1.h0.F(z1Var, "eventLoopGroupPool");
        return this;
    }

    @t1.a
    public e0 X(int i10) {
        c1.h0.e(i10 > 0, "flowControlWindow must be positive");
        this.f20906g = i10;
        this.f20905f = false;
        return this;
    }

    public int f0() {
        return this.f20912m.b();
    }

    @t1.a
    public e0 h0(int i10) {
        c1.h0.e(i10 > 0, "initialFlowControlWindow must be positive");
        this.f20906g = i10;
        this.f20905f = true;
        return this;
    }

    @Override // vj.f0, vj.s1
    @t1.a
    /* JADX INFO: renamed from: i0, reason: merged with bridge method [inline-methods] */
    public e0 q(long j10, TimeUnit timeUnit) {
        c1.h0.e(j10 > 0, "keepalive time must be positive");
        long nanos = timeUnit.toNanos(j10);
        this.f20909j = nanos;
        long jL = wj.j1.l(nanos);
        this.f20909j = jL;
        if (jL >= f20897t) {
            this.f20909j = Long.MAX_VALUE;
        }
        return this;
    }

    @Override // vj.f0, vj.s1
    @t1.a
    /* JADX INFO: renamed from: j0, reason: merged with bridge method [inline-methods] */
    public e0 r(long j10, TimeUnit timeUnit) {
        c1.h0.e(j10 > 0, "keepalive timeout must be positive");
        long nanos = timeUnit.toNanos(j10);
        this.f20910k = nanos;
        this.f20910k = wj.j1.m(nanos);
        return this;
    }

    @t1.a
    public e0 k0(boolean z10) {
        this.f20911l = z10;
        return this;
    }

    @t1.a
    public e0 l0(@gm.j c cVar) {
        this.f20914o = cVar;
        return this;
    }

    @t1.l(replacement = "this.maxInboundMetadataSize(maxHeaderListSize)")
    @t1.a
    @Deprecated
    public e0 m0(int i10) {
        return v(i10);
    }

    @Override // vj.f0, vj.s1
    @t1.a
    /* JADX INFO: renamed from: n0, reason: merged with bridge method [inline-methods] */
    public e0 u(int i10) {
        c1.h0.e(i10 >= 0, "negative max");
        this.f20908i = i10;
        return this;
    }

    @Override // vj.f0, vj.s1
    @t1.a
    /* JADX INFO: renamed from: o0, reason: merged with bridge method [inline-methods] */
    public e0 v(int i10) {
        c1.h0.e(i10 > 0, "maxInboundMetadataSize must be > 0");
        this.f20907h = i10;
        return this;
    }

    @t1.a
    public e0 p0(c0 c0Var) {
        c1.h0.h0(!this.f20913n, "Cannot change security when using ChannelCredentials");
        y0.a aVar = this.f20912m;
        if (!(aVar instanceof b)) {
            return this;
        }
        ((b) aVar).f20918a = c0Var;
        return this;
    }

    public void q0(y0.a aVar) {
        c1.h0.h0(!this.f20913n, "Cannot change security when using ChannelCredentials");
        this.f20912m = (y0.a) c1.h0.F(aVar, "protocolNegotiatorFactory");
    }

    public void r0(boolean z10) {
        this.f20900a.C = z10;
    }

    @Override // vj.f0, vj.s1
    @t1.a
    public s1 s(boolean z10) {
        this.f20911l = z10;
        return this;
    }

    public void s0(boolean z10) {
        this.f20900a.E = z10;
    }

    public void t0(boolean z10) {
        this.f20900a.F = z10;
    }

    public void u0(boolean z10) {
        this.f20900a.G = z10;
    }

    public void v0(boolean z10) {
        this.f20900a.D = z10;
    }

    public void w0(boolean z10) {
        this.f20900a.H = z10;
    }

    @t1.a
    @b1.e
    public e0 x0(q3.b bVar) {
        this.f20901b = bVar;
        return this;
    }

    @t1.a
    public e0 y0(SslContext sslContext) {
        c1.h0.h0(!this.f20913n, "Cannot change security when using ChannelCredentials");
        if (sslContext != null) {
            c1.h0.e(sslContext.isClient(), "Server SSL context can not be used for client channel");
            o.e(sslContext.applicationProtocolNegotiator());
        }
        y0.a aVar = this.f20912m;
        if (!(aVar instanceof b)) {
            return this;
        }
        ((b) aVar).f20919b = sslContext;
        return this;
    }

    @t1.a
    public e0 z0() {
        p0(c0.PLAINTEXT);
        return this;
    }

    public final class b implements y0.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public c0 f20918a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public SslContext f20919b;

        public b() {
            this.f20918a = c0.TLS;
        }

        @Override // yj.y0.a
        public y0 a() {
            SslContext sslContextBuild = this.f20919b;
            if (this.f20918a == c0.TLS && sslContextBuild == null) {
                try {
                    sslContextBuild = o.g().build();
                } catch (SSLException e10) {
                    throw new RuntimeException(e10);
                }
            }
            return e0.S(this.f20918a, sslContextBuild, e0.this.f20900a.f19112b);
        }

        @Override // yj.y0.a
        public int b() {
            int i10 = a.f20917a[this.f20918a.ordinal()];
            if (i10 == 1 || i10 == 2) {
                return 80;
            }
            if (i10 == 3) {
                return wj.v0.f19368n;
            }
            throw new AssertionError(this.f20918a + " not handled");
        }

        public /* synthetic */ b(e0 e0Var, a aVar) {
            this();
        }
    }

    public e0(String str, vj.g gVar, vj.d dVar, y0.a aVar) {
        this.f20901b = q3.a();
        this.f20902c = new HashMap();
        this.f20903d = f20898u;
        this.f20904e = f20899v;
        this.f20905f = f20896s;
        this.f20906g = 1048576;
        this.f20907h = 8192;
        this.f20908i = 4194304;
        this.f20909j = Long.MAX_VALUE;
        this.f20910k = wj.v0.A;
        this.f20912m = new b();
        this.f20915p = false;
        this.f20916q = InetSocketAddress.class;
        this.f20900a = new o1(str, gVar, dVar, new e(), new d());
        this.f20912m = (y0.a) c1.h0.F(aVar, "negotiator");
        this.f20913n = true;
    }

    public e0(SocketAddress socketAddress) {
        this.f20901b = q3.a();
        this.f20902c = new HashMap();
        this.f20903d = f20898u;
        this.f20904e = f20899v;
        this.f20905f = f20896s;
        this.f20906g = 1048576;
        this.f20907h = 8192;
        this.f20908i = 4194304;
        this.f20909j = Long.MAX_VALUE;
        this.f20910k = wj.v0.A;
        this.f20912m = new b();
        this.f20915p = false;
        this.f20916q = InetSocketAddress.class;
        this.f20900a = new o1(socketAddress, e0(socketAddress), new e(), new d());
        this.f20913n = false;
    }

    public e0(SocketAddress socketAddress, vj.g gVar, vj.d dVar, y0.a aVar) {
        this.f20901b = q3.a();
        this.f20902c = new HashMap();
        this.f20903d = f20898u;
        this.f20904e = f20899v;
        this.f20905f = f20896s;
        this.f20906g = 1048576;
        this.f20907h = 8192;
        this.f20908i = 4194304;
        this.f20909j = Long.MAX_VALUE;
        this.f20910k = wj.v0.A;
        this.f20912m = new b();
        this.f20915p = false;
        this.f20916q = InetSocketAddress.class;
        this.f20900a = new o1(socketAddress, e0(socketAddress), gVar, dVar, new e(), new d());
        this.f20912m = (y0.a) c1.h0.F(aVar, "negotiator");
        this.f20913n = true;
    }
}
