package al;

import fl.j0;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.util.concurrent.Future;
import java.net.BindException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kn.h0;
import kn.l0;
import kn.n0;
import lm.d0;
import lm.d1;
import lm.f0;
import lm.l2;
import lm.t0;
import nm.k0;
import nm.z;
import nq.b0;
import nq.y1;
import yk.a0;
import yk.x;

/* JADX INFO: loaded from: classes2.dex */
public final class l extends yk.i {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @os.l
    public final c f348c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @os.l
    public final d0 f349d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @os.l
    public final d0 f350e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @os.l
    public final d0 f351f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @os.l
    public final d0 f352g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @os.l
    public final d0 f353h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @os.l
    public final d0 f354i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @os.m
    public b0 f355j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @os.m
    public List<? extends Channel> f356k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @os.l
    public final d0 f357l;

    public static final class a extends n0 implements jn.l<c, l2> {
        public static final a INSTANCE = new a();

        public a() {
            super(1);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@os.l c cVar) {
            l0.p(cVar, "$this$null");
        }

        @Override // jn.l
        public /* bridge */ /* synthetic */ l2 invoke(c cVar) {
            invoke2(cVar);
            return l2.f10208a;
        }
    }

    @xm.f(c = "io.ktor.server.netty.NettyApplicationEngine$2", f = "NettyApplicationEngine.kt", i = {}, l = {169}, m = "invokeSuspend", n = {}, s = {})
    public static final class b extends xm.o implements jn.q<nl.f<l2, dk.b>, l2, um.d<? super l2>, Object> {
        private /* synthetic */ Object L$0;
        int label;

        public b(um.d<? super b> dVar) {
            super(3, dVar);
        }

        @Override // xm.a
        @os.m
        public final Object invokeSuspend(@os.l Object obj) {
            wm.a aVar = wm.a.COROUTINE_SUSPENDED;
            int i10 = this.label;
            if (i10 == 0) {
                d1.n(obj);
                dk.b bVar = (dk.b) ((nl.f) this.L$0).getContext();
                al.i iVar = bVar instanceof al.i ? (al.i) bVar : null;
                if (iVar != null) {
                    this.label = 1;
                    if (iVar.k(this) == aVar) {
                        return aVar;
                    }
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                d1.n(obj);
            }
            return l2.f10208a;
        }

        @Override // jn.q
        @os.m
        public final Object invoke(@os.l nl.f<l2, dk.b> fVar, @os.l l2 l2Var, @os.m um.d<? super l2> dVar) {
            b bVar = new b(dVar);
            bVar.L$0 = fVar;
            return bVar.invokeSuspend(l2.f10208a);
        }
    }

    public static final class c extends yk.i.c {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public boolean f360g;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f363j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public boolean f364k;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f358e = 16;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f359f = 10;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        @os.l
        public jn.l<? super ServerBootstrap, l2> f361h = a.INSTANCE;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public int f362i = 10;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        @os.l
        public jn.a<HttpServerCodec> f365l = b.INSTANCE;

        public static final class a extends n0 implements jn.l<ServerBootstrap, l2> {
            public static final a INSTANCE = new a();

            public a() {
                super(1);
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@os.l ServerBootstrap serverBootstrap) {
                l0.p(serverBootstrap, "$this$null");
            }

            @Override // jn.l
            public /* bridge */ /* synthetic */ l2 invoke(ServerBootstrap serverBootstrap) {
                invoke2(serverBootstrap);
                return l2.f10208a;
            }
        }

        public /* synthetic */ class b extends h0 implements jn.a<HttpServerCodec> {
            public static final b INSTANCE = new b();

            public b() {
                super(0, HttpServerCodec.class, "<init>", "<init>()V", 0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // jn.a
            @os.l
            public final HttpServerCodec invoke() {
                return new HttpServerCodec();
            }
        }

        @os.l
        public final jn.l<ServerBootstrap, l2> h() {
            return this.f361h;
        }

        @os.l
        public final jn.a<HttpServerCodec> i() {
            return this.f365l;
        }

        public final int j() {
            return this.f358e;
        }

        public final int k() {
            return this.f363j;
        }

        public final int l() {
            return this.f362i;
        }

        public final int m() {
            return this.f359f;
        }

        public final boolean n() {
            return this.f360g;
        }

        public final boolean o() {
            return this.f364k;
        }

        public final void p(@os.l jn.l<? super ServerBootstrap, l2> lVar) {
            l0.p(lVar, "<set-?>");
            this.f361h = lVar;
        }

        public final void q(@os.l jn.a<HttpServerCodec> aVar) {
            l0.p(aVar, "<set-?>");
            this.f365l = aVar;
        }

        public final void r(int i10) {
            this.f358e = i10;
        }

        public final void s(int i10) {
            this.f363j = i10;
        }

        public final void t(int i10) {
            this.f362i = i10;
        }

        public final void u(int i10) {
            this.f359f = i10;
        }

        public final void v(boolean z10) {
            this.f360g = z10;
        }

        public final void w(boolean z10) {
            this.f364k = z10;
        }
    }

    public static final class d extends n0 implements jn.a<List<? extends ServerBootstrap>> {
        final /* synthetic */ yk.b $environment;
        final /* synthetic */ l this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(yk.b bVar, l lVar) {
            super(0);
            this.$environment = bVar;
            this.this$0 = lVar;
        }

        @Override // jn.a
        @os.l
        public final List<? extends ServerBootstrap> invoke() {
            List<x> listD = this.$environment.d();
            l lVar = this.this$0;
            ArrayList arrayList = new ArrayList(z.b0(listD, 10));
            Iterator<T> it = listD.iterator();
            while (it.hasNext()) {
                arrayList.add(lVar.m((x) it.next()));
            }
            return arrayList;
        }
    }

    public static final class e extends n0 implements jn.a<EventLoopGroup> {
        public e() {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // jn.a
        @os.l
        public final EventLoopGroup invoke() {
            l lVar = l.this;
            c cVar = lVar.f348c;
            return cVar.f360g ? lVar.t() : al.g.f334c.c(cVar.f21358d);
        }
    }

    public static final class f extends n0 implements jn.a<EventLoopGroup> {
        public f() {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // jn.a
        @os.l
        public final EventLoopGroup invoke() {
            EventLoopGroup eventLoopGroupGroup = l.this.q().config().group();
            return eventLoopGroupGroup == null ? al.g.f334c.c(l.this.f348c.f21356b) : eventLoopGroupGroup;
        }
    }

    public static final class g extends n0 implements jn.a<ServerBootstrap> {
        public g() {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // jn.a
        @os.l
        public final ServerBootstrap invoke() {
            ServerBootstrap serverBootstrap = new ServerBootstrap();
            l.this.f348c.f361h.invoke(serverBootstrap);
            return serverBootstrap;
        }
    }

    public static final class h extends n0 implements jn.a<j0> {
        public static final h INSTANCE = new h();

        public h() {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // jn.a
        @os.l
        public final j0 invoke() {
            return new j0(v.f403a);
        }
    }

    public static final class i extends n0 implements jn.a<j0> {
        public i() {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // jn.a
        @os.l
        public final j0 invoke() {
            return new j0(new y1(l.this.t()));
        }
    }

    public static final class j extends n0 implements jn.a<EventLoopGroup> {
        public j() {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // jn.a
        @os.l
        public final EventLoopGroup invoke() {
            c cVar = l.this.f348c;
            al.g gVarC = cVar.f360g ? al.g.f334c.c(cVar.f21357c + cVar.f21358d) : al.g.f334c.c(cVar.f21357c);
            EventLoopGroup eventLoopGroupChildGroup = l.this.q().config().childGroup();
            return eventLoopGroupChildGroup == null ? gVarC : eventLoopGroupChildGroup;
        }
    }

    public /* synthetic */ l(yk.b bVar, jn.l lVar, int i10, kn.w wVar) {
        this(bVar, (i10 & 2) != 0 ? a.INSTANCE : lVar);
    }

    @Override // yk.a
    public void d(long j10, long j11) throws Throwable {
        b0 b0Var = this.f355j;
        if (b0Var != null) {
            b0Var.complete();
        }
        this.f21413a.c().a(dk.k.c(), this.f21413a);
        List<? extends Channel> list = this.f356k;
        Object obj = null;
        if (list != null) {
            ArrayList arrayList = new ArrayList();
            for (Channel channel : list) {
                ChannelFuture channelFutureClose = channel.isOpen() ? channel.close() : null;
                if (channelFutureClose != null) {
                    arrayList.add(channelFutureClose);
                }
            }
            obj = arrayList;
        }
        if (obj == null) {
            obj = k0.INSTANCE;
        }
        r().j0();
        s().j0();
        try {
            EventLoopGroup eventLoopGroupP = p();
            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
            eventLoopGroupP.shutdownGracefully(j10, j11, timeUnit).await();
            Future<?> futureShutdownGracefully = t().shutdownGracefully(j10, j11, timeUnit);
            if (this.f348c.f360g) {
                futureShutdownGracefully.await();
            } else {
                Future<?> futureShutdownGracefully2 = o().shutdownGracefully(j10, j11, timeUnit);
                futureShutdownGracefully.await();
                futureShutdownGracefully2.await();
            }
            this.f21413a.stop();
        } finally {
            r().f0();
            s().f0();
            Iterator it = ((Iterable) obj).iterator();
            while (it.hasNext()) {
                ((ChannelFuture) it.next()).sync();
            }
        }
    }

    public final ServerBootstrap m(x xVar) {
        ServerBootstrap serverBootstrapClone = q().mo57clone();
        if (serverBootstrapClone.config().group() == null && serverBootstrapClone.config().childGroup() == null) {
            serverBootstrapClone.group(p(), t());
        }
        if (serverBootstrapClone.config().channelFactory() == null) {
            serverBootstrapClone.channel(in.b.e(m.b()));
        }
        a0 a0Var = this.f21414b;
        yk.b bVar = this.f21413a;
        EventLoopGroup eventLoopGroupO = o();
        j0 j0VarS = s();
        um.g gVarPlus = this.f21413a.g().plus(r());
        c cVar = this.f348c;
        serverBootstrapClone.childHandler(new s(a0Var, bVar, eventLoopGroupO, j0VarS, gVarPlus, xVar, cVar.f358e, cVar.f359f, cVar.f362i, cVar.f363j, cVar.f365l));
        if (this.f348c.f364k) {
            serverBootstrapClone.option(ChannelOption.SO_KEEPALIVE, Boolean.TRUE);
        }
        l0.o(serverBootstrapClone, "customBootstrap.clone().…)\n            }\n        }");
        return serverBootstrapClone;
    }

    @os.l
    public final List<ServerBootstrap> n() {
        return (List) this.f357l.getValue();
    }

    public final EventLoopGroup o() {
        return (EventLoopGroup) this.f352g.getValue();
    }

    public final EventLoopGroup p() {
        return (EventLoopGroup) this.f349d.getValue();
    }

    public final ServerBootstrap q() {
        return (ServerBootstrap) this.f351f.getValue();
    }

    public final j0 r() {
        return (j0) this.f353h.getValue();
    }

    public final j0 s() {
        return (j0) this.f354i.getValue();
    }

    public final EventLoopGroup t() {
        return (EventLoopGroup) this.f350e.getValue();
    }

    @os.l
    public String toString() {
        return "Netty(" + this.f21413a + ')';
    }

    /* JADX WARN: Type inference failed for: r3v6, types: [io.netty.channel.ChannelFuture] */
    @Override // yk.a
    @os.l
    /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
    public l b(boolean z10) throws InterruptedException, BindException {
        this.f21413a.start();
        try {
            List<t0> listI6 = nm.h0.i6(n(), this.f21413a.d());
            ArrayList arrayList = new ArrayList(z.b0(listI6, 10));
            for (t0 t0Var : listI6) {
                arrayList.add(((ServerBootstrap) t0Var.getFirst()).bind(((x) t0Var.getSecond()).b(), ((x) t0Var.getSecond()).a()));
            }
            ArrayList arrayList2 = new ArrayList(z.b0(arrayList, 10));
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                arrayList2.add(((ChannelFuture) it.next()).sync().channel());
            }
            this.f356k = arrayList2;
            this.f355j = yk.z.b(this);
            if (z10) {
                List<? extends Channel> list = this.f356k;
                if (list != null) {
                    List<? extends Channel> list2 = list;
                    ArrayList arrayList3 = new ArrayList(z.b0(list2, 10));
                    Iterator<T> it2 = list2.iterator();
                    while (it2.hasNext()) {
                        arrayList3.add(((Channel) it2.next()).closeFuture());
                    }
                    Iterator it3 = arrayList3.iterator();
                    while (it3.hasNext()) {
                        ((ChannelFuture) it3.next()).sync();
                    }
                }
                yk.g.a(this, 1L, 5L, TimeUnit.SECONDS);
            }
            return this;
        } catch (BindException e10) {
            v();
            throw e10;
        }
    }

    public final void v() throws InterruptedException {
        p().shutdownGracefully().sync();
        t().shutdownGracefully().sync();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public l(@os.l yk.b bVar, @os.l jn.l<? super c, l2> lVar) throws nl.c {
        super(bVar, null, 2, 0 == true ? 1 : 0);
        l0.p(bVar, "environment");
        l0.p(lVar, "configure");
        c cVar = new c();
        lVar.invoke(cVar);
        this.f348c = cVar;
        this.f349d = f0.b(new f());
        this.f350e = f0.b(new j());
        this.f351f = f0.b(new g());
        this.f352g = f0.b(new e());
        this.f353h = f0.b(h.INSTANCE);
        this.f354i = f0.b(new i());
        this.f357l = f0.b(new d(bVar, this));
        nl.j jVar = new nl.j("After");
        a0 a0Var = this.f21414b;
        a0.f21359v.getClass();
        a0Var.u(a0.f21361x, jVar);
        this.f21414b.x(jVar, new b(null));
    }
}
