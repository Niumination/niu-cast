package yk;

import androidx.constraintlayout.widget.ConstraintLayout;
import ik.r0;
import io.netty.handler.codec.rtsp.RtspHeaders;
import kn.l0;
import kn.l1;
import kn.n0;
import lm.d1;
import lm.l2;
import nq.s0;

/* JADX INFO: loaded from: classes2.dex */
public final class h0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public final String f21405a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.l
    public final jn.l<dk.b, Integer> f21406b;

    public static final class a implements dk.h<dk.c, b, h0> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @os.l
        public static final a f21407a = new a();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @os.l
        public static final fl.b<h0> f21408b = new fl.b<>("shutdown.url");

        /* JADX INFO: renamed from: yk.h0$a$a, reason: collision with other inner class name */
        @xm.f(c = "io.ktor.server.engine.ShutDownUrl$ApplicationCallFeature$install$1", f = "ShutDownUrl.kt", i = {}, l = {86}, m = "invokeSuspend", n = {}, s = {})
        public static final class C0544a extends xm.o implements jn.q<nl.f<l2, dk.b>, l2, um.d<? super l2>, Object> {
            final /* synthetic */ h0 $feature;
            private /* synthetic */ Object L$0;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C0544a(h0 h0Var, um.d<? super C0544a> dVar) {
                super(3, dVar);
                this.$feature = h0Var;
            }

            @Override // xm.a
            @os.m
            public final Object invokeSuspend(@os.l Object obj) {
                wm.a aVar = wm.a.COROUTINE_SUSPENDED;
                int i10 = this.label;
                if (i10 == 0) {
                    d1.n(obj);
                    nl.f fVar = (nl.f) this.L$0;
                    if (l0.g(uk.e.p(((dk.b) fVar.getContext()).d()), this.$feature.f21405a)) {
                        h0 h0Var = this.$feature;
                        dk.b bVar = (dk.b) fVar.getContext();
                        this.label = 1;
                        if (h0Var.a(bVar, this) == aVar) {
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
                C0544a c0544a = new C0544a(this.$feature, dVar);
                c0544a.L$0 = fVar;
                return c0544a.invokeSuspend(l2.f10208a);
            }
        }

        @Override // dk.h
        @os.l
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public h0 a(@os.l dk.c cVar, @os.l jn.l<? super b, l2> lVar) throws nl.c {
            l0.p(cVar, "pipeline");
            l0.p(lVar, "configure");
            b bVar = new b();
            lVar.invoke(bVar);
            h0 h0Var = new h0(bVar.f21409a, bVar.f21410b);
            dk.c.f3706v.getClass();
            cVar.x(dk.c.f3709y, new C0544a(h0Var, null));
            return h0Var;
        }

        @Override // dk.h
        @os.l
        public fl.b<h0> getKey() {
            return f21408b;
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @os.l
        public String f21409a = "/ktor/application/shutdown";

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @os.l
        public jn.l<? super dk.b, Integer> f21410b = a.INSTANCE;

        public static final class a extends n0 implements jn.l<dk.b, Integer> {
            public static final a INSTANCE = new a();

            public a() {
                super(1);
            }

            @Override // jn.l
            @os.l
            public final Integer invoke(@os.l dk.b bVar) {
                l0.p(bVar, "$this$null");
                return 0;
            }
        }

        @os.l
        public final jn.l<dk.b, Integer> a() {
            return this.f21410b;
        }

        @os.l
        public final String b() {
            return this.f21409a;
        }

        public final void c(@os.l jn.l<? super dk.b, Integer> lVar) {
            l0.p(lVar, "<set-?>");
            this.f21410b = lVar;
        }

        public final void d(@os.l String str) {
            l0.p(str, "<set-?>");
            this.f21409a = str;
        }
    }

    public static final class c implements dk.h<a0, b, h0> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @os.l
        public static final c f21411a = new c();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @os.l
        public static final fl.b<h0> f21412b = new fl.b<>("shutdown.url");

        @xm.f(c = "io.ktor.server.engine.ShutDownUrl$EngineFeature$install$1", f = "ShutDownUrl.kt", i = {}, l = {ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_HEIGHT}, m = "invokeSuspend", n = {}, s = {})
        public static final class a extends xm.o implements jn.q<nl.f<l2, dk.b>, l2, um.d<? super l2>, Object> {
            final /* synthetic */ h0 $feature;
            private /* synthetic */ Object L$0;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(h0 h0Var, um.d<? super a> dVar) {
                super(3, dVar);
                this.$feature = h0Var;
            }

            @Override // xm.a
            @os.m
            public final Object invokeSuspend(@os.l Object obj) {
                wm.a aVar = wm.a.COROUTINE_SUSPENDED;
                int i10 = this.label;
                if (i10 == 0) {
                    d1.n(obj);
                    nl.f fVar = (nl.f) this.L$0;
                    if (l0.g(uk.e.p(((dk.b) fVar.getContext()).d()), this.$feature.f21405a)) {
                        h0 h0Var = this.$feature;
                        dk.b bVar = (dk.b) fVar.getContext();
                        this.label = 1;
                        if (h0Var.a(bVar, this) == aVar) {
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
                a aVar = new a(this.$feature, dVar);
                aVar.L$0 = fVar;
                return aVar.invokeSuspend(l2.f10208a);
            }
        }

        @Override // dk.h
        @os.l
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public h0 a(@os.l a0 a0Var, @os.l jn.l<? super b, l2> lVar) throws nl.c {
            l0.p(a0Var, "pipeline");
            l0.p(lVar, "configure");
            b bVar = new b();
            lVar.invoke(bVar);
            h0 h0Var = new h0(bVar.f21409a, bVar.f21410b);
            a0.f21359v.getClass();
            a0Var.x(a0.f21360w, new a(h0Var, null));
            return h0Var;
        }

        @Override // dk.h
        @os.l
        public fl.b<h0> getKey() {
            return f21412b;
        }
    }

    @xm.f(c = "io.ktor.server.engine.ShutDownUrl", f = "ShutDownUrl.kt", i = {0}, l = {y5.a.f20726j0}, m = "doShutdown", n = {"latch"}, s = {"L$0"})
    public static final class d extends xm.d {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public d(um.d<? super d> dVar) {
            super(dVar);
        }

        @Override // xm.a
        @os.m
        public final Object invokeSuspend(@os.l Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return h0.this.a(null, this);
        }
    }

    @xm.f(c = "io.ktor.server.engine.ShutDownUrl$doShutdown$2", f = "ShutDownUrl.kt", i = {}, l = {33}, m = "invokeSuspend", n = {}, s = {})
    public static final class e extends xm.o implements jn.p<s0, um.d<? super l2>, Object> {
        final /* synthetic */ dk.a $application;
        final /* synthetic */ dk.e $environment;
        final /* synthetic */ int $exitCode;
        final /* synthetic */ nq.y $latch;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(nq.y yVar, dk.e eVar, dk.a aVar, int i10, um.d<? super e> dVar) {
            super(2, dVar);
            this.$latch = yVar;
            this.$environment = eVar;
            this.$application = aVar;
            this.$exitCode = i10;
        }

        @Override // xm.a
        @os.l
        public final um.d<l2> create(@os.m Object obj, @os.l um.d<?> dVar) {
            return new e(this.$latch, this.$environment, this.$application, this.$exitCode, dVar);
        }

        @Override // xm.a
        @os.m
        public final Object invokeSuspend(@os.l Object obj) throws Throwable {
            wm.a aVar = wm.a.COROUTINE_SUSPENDED;
            int i10 = this.label;
            if (i10 == 0) {
                d1.n(obj);
                nq.y yVar = this.$latch;
                this.label = 1;
                if (yVar.t(this) == aVar) {
                    return aVar;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                d1.n(obj);
            }
            this.$environment.c().a(dk.k.c(), this.$environment);
            dk.e eVar = this.$environment;
            if (eVar instanceof yk.b) {
                ((yk.b) eVar).stop();
            } else {
                this.$application.X();
            }
            System.exit(this.$exitCode);
            throw new RuntimeException("System.exit returned normally, while it was supposed to halt JVM.");
        }

        @Override // jn.p
        @os.m
        public final Object invoke(@os.l s0 s0Var, @os.m um.d<? super l2> dVar) {
            return ((e) create(s0Var, dVar)).invokeSuspend(l2.f10208a);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public h0(@os.l String str, @os.l jn.l<? super dk.b, Integer> lVar) {
        l0.p(str, RtspHeaders.Values.URL);
        l0.p(lVar, "exitCode");
        this.f21405a = str;
        this.f21406b = lVar;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0019  */
    @os.m
    public final Object a(@os.l dk.b bVar, @os.l um.d<? super l2> dVar) throws Throwable {
        d dVar2;
        nq.y yVar;
        if (dVar instanceof d) {
            dVar2 = (d) dVar;
            int i10 = dVar2.label;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                dVar2.label = i10 - Integer.MIN_VALUE;
            } else {
                dVar2 = new d(dVar);
            }
        } else {
            dVar2 = new d(dVar);
        }
        Object obj = dVar2.result;
        wm.a aVar = wm.a.COROUTINE_SUSPENDED;
        int i11 = dVar2.label;
        if (i11 != 0) {
            if (i11 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            yVar = (nq.y) dVar2.L$0;
            try {
                d1.n(obj);
                nq.l2.a.b(yVar, null, 1, null);
                return l2.f10208a;
            } catch (Throwable th2) {
                th = th2;
                nq.l2.a.b(yVar, null, 1, null);
                throw th;
            }
        }
        d1.n(obj);
        dk.j.a(bVar.a()).warn("Shutdown URL was called: server is going down");
        dk.a aVarA = bVar.a();
        dk.e eVar = aVarA.I;
        int iIntValue = this.f21406b.invoke(bVar).intValue();
        nq.y yVarC = nq.a0.c(null, 1, null);
        nq.k.f(bVar.a(), null, null, new e(yVarC, eVar, aVarA, iIntValue, null), 3, null);
        try {
            r0.f8158c.getClass();
            r0 r0Var = r0.H;
            if (!(r0Var instanceof byte[])) {
                try {
                    vk.i.b(bVar.e(), l1.A(r0.class));
                } catch (Throwable unused) {
                }
            }
            vk.d dVarC = bVar.e().c();
            dVar2.L$0 = yVarC;
            dVar2.label = 1;
            if (dVarC.g(bVar, r0Var, dVar2) == aVar) {
                return aVar;
            }
            yVar = yVarC;
            nq.l2.a.b(yVar, null, 1, null);
            return l2.f10208a;
        } catch (Throwable th3) {
            th = th3;
            yVar = yVarC;
            nq.l2.a.b(yVar, null, 1, null);
            throw th;
        }
    }

    @os.l
    public final jn.l<dk.b, Integer> b() {
        return this.f21406b;
    }

    @os.l
    public final String c() {
        return this.f21405a;
    }
}
