package yj;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.ByteBufAllocator;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFactory;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.ChannelPromise;
import io.netty.channel.EventLoop;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.ServerChannel;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.ChannelGroupFuture;
import io.netty.channel.group.ChannelGroupFutureListener;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.util.AbstractReferenceCounted;
import io.netty.util.ReferenceCounted;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GenericFutureListener;
import java.io.IOException;
import java.net.SocketAddress;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.logging.Level;
import java.util.logging.Logger;
import q1.l2;
import q1.s1;
import vj.m1;
import vj.u2;
import wj.q3;
import wj.y2;
import wj.z1;

/* JADX INFO: loaded from: classes2.dex */
public class l0 implements wj.d1, m1 {
    public static final Logger J = Logger.getLogger(wj.d1.class.getName());
    public final long A;
    public final vj.a B;
    public final List<? extends u2.a> D;
    public final q3.b E;
    public final vj.v0 F;
    public volatile boolean H;
    public final EventLoop I;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final vj.c1 f21087a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<? extends SocketAddress> f21088b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ChannelFactory<? extends ServerChannel> f21089c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map<ChannelOption<?>, ?> f21090d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Map<ChannelOption<?>, ?> f21091e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final y0 f21092f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f21093g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final z1<? extends EventLoopGroup> f21094h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final z1<? extends EventLoopGroup> f21095i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final boolean f21096j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public EventLoopGroup f21097k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public EventLoopGroup f21098l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public y2 f21099m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final ChannelGroup f21100n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final boolean f21101o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final int f21102p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final int f21103q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final int f21104r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final long f21105s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final long f21106t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final long f21107u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final long f21108v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final long f21109w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final boolean f21110x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final long f21111y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final int f21112z;
    public final ReferenceCounted C = new f();
    public volatile List<vj.a1<vj.v0.l>> G = Collections.emptyList();

    public class a extends ChannelInitializer<Channel> {

        /* JADX INFO: renamed from: yj.l0$a$a, reason: collision with other inner class name */
        public final class C0541a implements ChannelFutureListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public boolean f21114a;

            public C0541a() {
            }

            @Override // io.netty.util.concurrent.GenericFutureListener
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void operationComplete(ChannelFuture channelFuture) throws Exception {
                if (this.f21114a) {
                    return;
                }
                this.f21114a = true;
                l0.this.C.release();
            }
        }

        public a() {
        }

        @Override // io.netty.channel.ChannelInitializer
        public void initChannel(Channel channel) {
            ChannelPromise channelPromiseNewPromise = channel.newPromise();
            long jRandom = l0.this.f21108v;
            if (jRandom != Long.MAX_VALUE) {
                jRandom = (long) (((Math.random() * 0.2d) + 0.9d) * jRandom);
            }
            long j10 = jRandom;
            l0 l0Var = l0.this;
            y0 y0Var = l0Var.f21092f;
            List<? extends u2.a> list = l0Var.D;
            q3 q3VarA = l0Var.E.a();
            l0 l0Var2 = l0.this;
            r0 r0Var = new r0(channel, channelPromiseNewPromise, y0Var, list, q3VarA, l0Var2.f21093g, l0Var2.f21101o, l0Var2.f21102p, l0Var2.f21103q, l0Var2.f21104r, l0Var2.f21105s, l0Var2.f21106t, l0Var2.f21107u, j10, l0Var2.f21109w, l0Var2.f21110x, l0Var2.f21111y, l0Var2.f21112z, l0Var2.A, l0Var2.B);
            synchronized (l0.this) {
                try {
                    if (l0.this.H) {
                        channel.close();
                        return;
                    }
                    l0.this.C.retain();
                    r0Var.s(l0.this.f21099m.b(r0Var));
                    C0541a c0541a = new C0541a();
                    channelPromiseNewPromise.addListener((GenericFutureListener<? extends Future<? super Void>>) c0541a);
                    channel.closeFuture().addListener((GenericFutureListener<? extends Future<? super Void>>) c0541a);
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
    }

    public class b implements Callable<Map<ChannelFuture, SocketAddress>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ServerBootstrap f21116a;

        public b(ServerBootstrap serverBootstrap) {
            this.f21116a = serverBootstrap;
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Map<ChannelFuture, SocketAddress> call() {
            HashMap map = new HashMap();
            for (SocketAddress socketAddress : l0.this.f21088b) {
                ChannelFuture channelFutureBind = this.f21116a.bind(socketAddress);
                l0.this.f21100n.add(channelFutureBind.channel());
                map.put(channelFutureBind, socketAddress);
            }
            return map;
        }
    }

    public class c implements ChannelFutureListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ vj.a1 f21118a;

        public c(vj.a1 a1Var) {
            this.f21118a = a1Var;
        }

        @Override // io.netty.util.concurrent.GenericFutureListener
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void operationComplete(ChannelFuture channelFuture) throws Exception {
            l0.this.F.z(this.f21118a);
        }
    }

    public class d implements ChannelGroupFutureListener {
        public d() {
        }

        @Override // io.netty.util.concurrent.GenericFutureListener
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void operationComplete(ChannelGroupFuture channelGroupFuture) throws Exception {
            if (!channelGroupFuture.isSuccess()) {
                l0.J.log(Level.WARNING, "Error closing server channel group", (Throwable) channelGroupFuture.cause());
            }
            l0.this.C.release();
            l0.this.f21092f.close();
            l0.this.G = Collections.emptyList();
            synchronized (l0.this) {
                l0.this.f21099m.a();
                l0.this.H = true;
            }
        }
    }

    public static final class e implements vj.a1<vj.v0.l> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final vj.c1 f21121a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Channel f21122b;

        public class a implements GenericFutureListener<Future<Object>> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ l2 f21123a;

            public a(l2 l2Var) {
                this.f21123a = l2Var;
            }

            @Override // io.netty.util.concurrent.GenericFutureListener
            public void operationComplete(Future<Object> future) throws Exception {
                if (future.isSuccess()) {
                    return;
                }
                this.f21123a.C(future.cause());
            }
        }

        public class b implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ l2 f21125a;

            public b(l2 l2Var) {
                this.f21125a = l2Var;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.f21125a.B(new vj.v0.l(null, e.this.f21122b.localAddress(), null, i1.s(e.this.f21122b), null));
            }
        }

        public e(Channel channel) {
            this.f21122b = channel;
            this.f21121a = vj.c1.a(e.class, String.valueOf(channel.localAddress()));
        }

        @Override // vj.m1
        public vj.c1 e() {
            return this.f21121a;
        }

        @Override // vj.a1
        public s1<vj.v0.l> j() {
            l2 l2VarF = l2.F();
            if (this.f21122b.eventLoop().inEventLoop()) {
                l2VarF.B(new vj.v0.l(null, this.f21122b.localAddress(), null, i1.s(this.f21122b), null));
                return l2VarF;
            }
            this.f21122b.eventLoop().submit((Runnable) new b(l2VarF)).addListener(new a(l2VarF));
            return l2VarF;
        }

        public String toString() {
            return c1.z.c(this).e("logId", this.f21121a.f17063c).j("channel", this.f21122b).toString();
        }
    }

    public class f extends AbstractReferenceCounted {
        public f() {
        }

        @Override // io.netty.util.AbstractReferenceCounted
        public void deallocate() {
            try {
                if (l0.this.f21097k != null) {
                    l0 l0Var = l0.this;
                    l0Var.f21094h.b(l0Var.f21097k);
                }
                l0 l0Var2 = l0.this;
                l0Var2.f21097k = null;
                try {
                    EventLoopGroup eventLoopGroup = l0Var2.f21098l;
                    if (eventLoopGroup != null) {
                        l0Var2.f21095i.b(eventLoopGroup);
                    }
                } finally {
                    l0.this.f21098l = null;
                }
            } catch (Throwable th2) {
                l0.this.f21097k = null;
                try {
                    l0 l0Var3 = l0.this;
                    EventLoopGroup eventLoopGroup2 = l0Var3.f21098l;
                    if (eventLoopGroup2 != null) {
                        l0Var3.f21095i.b(eventLoopGroup2);
                    }
                    throw th2;
                } finally {
                    l0.this.f21098l = null;
                }
            }
        }

        @Override // io.netty.util.ReferenceCounted
        public ReferenceCounted touch(Object obj) {
            return this;
        }
    }

    public l0(List<? extends SocketAddress> list, ChannelFactory<? extends ServerChannel> channelFactory, Map<ChannelOption<?>, ?> map, Map<ChannelOption<?>, ?> map2, z1<? extends EventLoopGroup> z1Var, z1<? extends EventLoopGroup> z1Var2, boolean z10, y0 y0Var, List<? extends u2.a> list2, q3.b bVar, int i10, boolean z11, int i11, int i12, int i13, long j10, long j11, long j12, long j13, long j14, boolean z12, long j15, int i14, long j16, vj.a aVar, vj.v0 v0Var) {
        this.f21088b = (List) c1.h0.F(list, "addresses");
        this.f21089c = (ChannelFactory) c1.h0.F(channelFactory, "channelFactory");
        c1.h0.F(map, "channelOptions");
        this.f21090d = new HashMap(map);
        c1.h0.F(map2, "childChannelOptions");
        this.f21091e = new HashMap(map2);
        this.f21094h = (z1) c1.h0.F(z1Var, "bossGroupPool");
        this.f21095i = (z1) c1.h0.F(z1Var2, "workerGroupPool");
        this.f21096j = z10;
        EventLoopGroup eventLoopGroupA = z1Var.a();
        this.f21097k = eventLoopGroupA;
        EventLoop next = eventLoopGroupA.next();
        this.I = next;
        this.f21100n = new DefaultChannelGroup(next);
        this.f21098l = z1Var2.a();
        this.f21092f = (y0) c1.h0.F(y0Var, "protocolNegotiator");
        this.D = (List) c1.h0.F(list2, "streamTracerFactories");
        this.E = bVar;
        this.f21093g = i10;
        this.f21101o = z11;
        this.f21102p = i11;
        this.f21103q = i12;
        this.f21104r = i13;
        this.f21105s = j10;
        this.f21106t = j11;
        this.f21107u = j12;
        this.f21108v = j13;
        this.f21109w = j14;
        this.f21110x = z12;
        this.f21111y = j15;
        this.f21112z = i14;
        this.A = j16;
        this.B = (vj.a) c1.h0.F(aVar, "eagAttributes");
        v0Var.getClass();
        this.F = v0Var;
        this.f21087a = vj.c1.a(getClass(), list.isEmpty() ? "No address" : String.valueOf(list));
    }

    @Override // wj.d1
    public vj.a1<vj.v0.l> b() {
        List<vj.a1<vj.v0.l>> list = this.G;
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override // vj.m1
    public vj.c1 e() {
        return this.f21087a;
    }

    @Override // wj.d1
    public SocketAddress g() {
        Iterator<Channel> it = this.f21100n.iterator();
        if (it.hasNext()) {
            return it.next().localAddress();
        }
        if (this.f21088b.isEmpty()) {
            return null;
        }
        return this.f21088b.get(0);
    }

    @Override // wj.d1
    public List<vj.a1<vj.v0.l>> h() {
        return this.G;
    }

    @Override // wj.d1
    public void i(y2 y2Var) throws IOException {
        this.f21099m = (y2) c1.h0.F(y2Var, "serverListener");
        ServerBootstrap serverBootstrap = new ServerBootstrap();
        ChannelOption<ByteBufAllocator> channelOption = ChannelOption.ALLOCATOR;
        serverBootstrap.option(channelOption, i1.p(this.f21096j));
        serverBootstrap.childOption(channelOption, i1.p(this.f21096j));
        serverBootstrap.group(this.I, this.f21098l);
        serverBootstrap.channelFactory((ChannelFactory) this.f21089c);
        serverBootstrap.childOption(ChannelOption.SO_KEEPALIVE, Boolean.TRUE);
        Map<ChannelOption<?>, ?> map = this.f21090d;
        if (map != null) {
            for (Map.Entry<ChannelOption<?>, ?> entry : map.entrySet()) {
                serverBootstrap.option(entry.getKey(), entry.getValue());
            }
        }
        Map<ChannelOption<?>, ?> map2 = this.f21091e;
        if (map2 != null) {
            for (Map.Entry<ChannelOption<?>, ?> entry2 : map2.entrySet()) {
                serverBootstrap.childOption(entry2.getKey(), entry2.getValue());
            }
        }
        serverBootstrap.childHandler(new a());
        Future futureSubmit = this.I.submit((Callable) new b(serverBootstrap));
        Map map3 = (Map) futureSubmit.awaitUninterruptibly().getNow();
        if (!futureSubmit.isSuccess()) {
            this.f21100n.close().awaitUninterruptibly();
            throw new IOException(String.format("Failed to bind to addresses %s", this.f21088b), futureSubmit.cause());
        }
        ArrayList arrayList = new ArrayList();
        for (Map.Entry entry3 : map3.entrySet()) {
            ChannelFuture channelFuture = (ChannelFuture) entry3.getKey();
            if (!channelFuture.awaitUninterruptibly().isSuccess()) {
                this.f21100n.close().awaitUninterruptibly();
                throw new IOException(String.format("Failed to bind to address %s", entry3.getValue()), channelFuture.cause());
            }
            e eVar = new e(channelFuture.channel());
            this.F.d(eVar);
            arrayList.add(eVar);
            channelFuture.channel().closeFuture().addListener((GenericFutureListener<? extends Future<? super Void>>) new c(eVar));
        }
        this.G = Collections.unmodifiableList(arrayList);
    }

    @Override // wj.d1
    public List<SocketAddress> l() {
        ArrayList arrayList = new ArrayList();
        Iterator<Channel> it = this.f21100n.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().localAddress());
        }
        if (arrayList.isEmpty()) {
            arrayList.addAll(this.f21088b);
        }
        return arrayList;
    }

    @Override // wj.d1
    public void shutdown() {
        if (this.H) {
            return;
        }
        try {
            this.f21100n.close().addListener((GenericFutureListener<? extends Future<? super Void>>) new d()).await();
        } catch (InterruptedException e10) {
            J.log(Level.FINE, "Interrupted while shutting down", (Throwable) e10);
            Thread.currentThread().interrupt();
        }
    }

    public String toString() {
        return c1.z.c(this).e("logId", this.f21087a.f17063c).j("addresses", this.f21088b).toString();
    }
}
