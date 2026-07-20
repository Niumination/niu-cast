package yk;

import ik.r0;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import kn.k1;
import kn.l0;
import kn.l1;
import kn.n0;
import lm.d1;
import lm.l2;

/* JADX INFO: loaded from: classes2.dex */
@v
public abstract class i implements yk.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public final yk.b f21413a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.l
    public final a0 f21414b;

    public static final class a extends n0 implements jn.l<dk.a, l2> {
        final /* synthetic */ k1.g $initializedStartAt;
        final /* synthetic */ k1.a $isFirstLoading;
        final /* synthetic */ i this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(k1.a aVar, k1.g gVar, i iVar) {
            super(1);
            this.$isFirstLoading = aVar;
            this.$initializedStartAt = gVar;
            this.this$0 = iVar;
        }

        @Override // jn.l
        public /* bridge */ /* synthetic */ l2 invoke(dk.a aVar) throws nl.c {
            invoke2(aVar);
            return l2.f10208a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@os.l dk.a aVar) throws nl.c {
            l0.p(aVar, "it");
            if (!this.$isFirstLoading.element) {
                this.$initializedStartAt.element = System.currentTimeMillis();
            }
            aVar.f3712n.C(this.this$0.f21414b.f21363n);
            aVar.f3713p.C(this.this$0.f21414b.f21364p);
            s.f(aVar.f3712n);
            s.g(aVar.f3713p);
            this.this$0.h(aVar);
        }
    }

    public static final class b extends n0 implements jn.l<dk.a, l2> {
        final /* synthetic */ k1.g $initializedStartAt;
        final /* synthetic */ k1.a $isFirstLoading;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(k1.g gVar, k1.a aVar) {
            super(1);
            this.$initializedStartAt = gVar;
            this.$isFirstLoading = aVar;
        }

        @Override // jn.l
        public /* bridge */ /* synthetic */ l2 invoke(dk.a aVar) {
            invoke2(aVar);
            return l2.f10208a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@os.l dk.a aVar) {
            l0.p(aVar, "it");
            long jCurrentTimeMillis = System.currentTimeMillis();
            List<x> listD = i.this.f21413a.d();
            i iVar = i.this;
            for (x xVar : listD) {
                ps.a aVarI = iVar.f21413a.i();
                StringBuilder sb2 = new StringBuilder("Responding at ");
                String str = xVar.getType().f21431a;
                Locale locale = Locale.getDefault();
                l0.o(locale, "getDefault()");
                String lowerCase = str.toLowerCase(locale);
                l0.o(lowerCase, "this as java.lang.String).toLowerCase(locale)");
                sb2.append(lowerCase);
                sb2.append("://");
                sb2.append(xVar.b());
                sb2.append(n1.e.f11184d);
                sb2.append(xVar.a());
                aVarI.info(sb2.toString());
            }
            double d10 = (jCurrentTimeMillis - this.$initializedStartAt.element) / 1000.0d;
            if (!this.$isFirstLoading.element) {
                i.this.f21413a.i().info("Application auto-reloaded in " + d10 + " seconds.");
                return;
            }
            i.this.f21413a.i().info("Application started in " + d10 + " seconds.");
            this.$isFirstLoading.element = false;
        }
    }

    public static class c extends yk.a.C0542a {
    }

    @xm.f(c = "io.ktor.server.engine.BaseApplicationEngine$installDefaultInterceptors$1", f = "BaseApplicationEngine.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class d extends xm.o implements jn.q<nl.f<l2, dk.b>, l2, um.d<? super l2>, Object> {
        private /* synthetic */ Object L$0;
        int label;

        @xm.f(c = "io.ktor.server.engine.BaseApplicationEngine$installDefaultInterceptors$1$1", f = "BaseApplicationEngine.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        public static final class a extends xm.o implements jn.q<nl.f<Object, dk.b>, Object, um.d<? super l2>, Object> {
            private /* synthetic */ Object L$0;
            int label;

            public a(um.d<? super a> dVar) {
                super(3, dVar);
            }

            @Override // xm.a
            @os.m
            public final Object invokeSuspend(@os.l Object obj) {
                wm.a aVar = wm.a.COROUTINE_SUSPENDED;
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                d1.n(obj);
                fl.c cVarC = ((dk.b) ((nl.f) this.L$0).getContext()).c();
                fl.b bVar = j.f21417a;
                l2 l2Var = l2.f10208a;
                cVarC.g(bVar, l2Var);
                return l2Var;
            }

            @Override // jn.q
            @os.m
            public final Object invoke(@os.l nl.f<Object, dk.b> fVar, @os.l Object obj, @os.m um.d<? super l2> dVar) {
                a aVar = new a(dVar);
                aVar.L$0 = fVar;
                return aVar.invokeSuspend(l2.f10208a);
            }
        }

        public d(um.d<? super d> dVar) {
            super(3, dVar);
        }

        @Override // xm.a
        @os.m
        public final Object invokeSuspend(@os.l Object obj) throws nl.c {
            wm.a aVar = wm.a.COROUTINE_SUSPENDED;
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            d1.n(obj);
            vk.d dVarC = ((dk.b) ((nl.f) this.L$0).getContext()).e().c();
            vk.d.f17581n.getClass();
            dVarC.x(vk.d.f17582p, new a(null));
            return l2.f10208a;
        }

        @Override // jn.q
        @os.m
        public final Object invoke(@os.l nl.f<l2, dk.b> fVar, @os.l l2 l2Var, @os.m um.d<? super l2> dVar) {
            d dVar2 = new d(dVar);
            dVar2.L$0 = fVar;
            return dVar2.invokeSuspend(l2.f10208a);
        }
    }

    @xm.f(c = "io.ktor.server.engine.BaseApplicationEngine$installDefaultInterceptors$2", f = "BaseApplicationEngine.kt", i = {}, l = {108}, m = "invokeSuspend", n = {}, s = {})
    public static final class e extends xm.o implements jn.q<nl.f<l2, dk.b>, l2, um.d<? super l2>, Object> {
        private /* synthetic */ Object L$0;
        int label;

        public e(um.d<? super e> dVar) {
            super(3, dVar);
        }

        @Override // xm.a
        @os.m
        public final Object invokeSuspend(@os.l Object obj) {
            wm.a aVar = wm.a.COROUTINE_SUSPENDED;
            int i10 = this.label;
            if (i10 == 0) {
                d1.n(obj);
                nl.f fVar = (nl.f) this.L$0;
                if (((dk.b) fVar.getContext()).c().b(j.f21417a) != null) {
                    return l2.f10208a;
                }
                r0 r0VarStatus = ((dk.b) fVar.getContext()).e().status();
                if (r0VarStatus == null) {
                    r0.f8158c.getClass();
                    r0VarStatus = r0.B;
                }
                dk.b bVar = (dk.b) fVar.getContext();
                if (!(r0VarStatus instanceof byte[])) {
                    try {
                        vk.i.b(bVar.e(), l1.A(r0.class));
                    } catch (Throwable unused) {
                    }
                }
                vk.d dVarC = bVar.e().c();
                this.label = 1;
                if (dVarC.g(bVar, r0VarStatus, this) == aVar) {
                    return aVar;
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
            e eVar = new e(dVar);
            eVar.L$0 = fVar;
            return eVar.invokeSuspend(l2.f10208a);
        }
    }

    @xm.f(c = "io.ktor.server.engine.BaseApplicationEngine$installDefaultInterceptors$3", f = "BaseApplicationEngine.kt", i = {}, l = {83}, m = "invokeSuspend", n = {}, s = {})
    public static final class f extends xm.o implements jn.q<nl.f<l2, dk.b>, l2, um.d<? super l2>, Object> {
        private /* synthetic */ Object L$0;
        int label;

        public f(um.d<? super f> dVar) {
            super(3, dVar);
        }

        @Override // xm.a
        @os.m
        public final Object invokeSuspend(@os.l Object obj) {
            wm.a aVar = wm.a.COROUTINE_SUSPENDED;
            int i10 = this.label;
            if (i10 == 0) {
                d1.n(obj);
                nl.f fVar = (nl.f) this.L$0;
                this.label = 1;
                if (j.c(fVar, this) == aVar) {
                    return aVar;
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
            f fVar2 = new f(dVar);
            fVar2.L$0 = fVar;
            return fVar2.invokeSuspend(l2.f10208a);
        }
    }

    public i(@os.l yk.b bVar, @os.l a0 a0Var) {
        l0.p(bVar, "environment");
        l0.p(a0Var, "pipeline");
        this.f21413a = bVar;
        this.f21414b = a0Var;
        k1.a aVar = new k1.a();
        aVar.element = true;
        k1.g gVar = new k1.g();
        gVar.element = System.currentTimeMillis();
        l.f21420f.c(a0Var.f21364p);
        bVar.c().b(dk.k.b(), new a(aVar, gVar, this));
        bVar.c().b(dk.k.f3718b, new b(gVar, aVar));
    }

    @Override // yk.a
    @os.l
    public dk.a a() {
        return yk.a.b.a(this);
    }

    @Override // yk.a
    @os.l
    public final yk.b c() {
        return this.f21413a;
    }

    @Override // yk.a
    @lm.k(level = lm.m.HIDDEN, message = "Binary compatibility.")
    public /* synthetic */ void e(long j10, long j11, TimeUnit timeUnit) {
        yk.a.b.c(this, j10, j11, timeUnit);
    }

    @os.l
    public final a0 g() {
        return this.f21414b;
    }

    public final void h(dk.a aVar) throws nl.c {
        dk.c.a aVar2 = dk.c.f3706v;
        aVar2.getClass();
        aVar.x(dk.c.f3707w, new d(null));
        aVar2.getClass();
        aVar.x(dk.c.H, new e(null));
        aVar2.getClass();
        aVar.x(dk.c.f3710z, new f(null));
    }

    public /* synthetic */ i(yk.b bVar, a0 a0Var, int i10, kn.w wVar) {
        this(bVar, (i10 & 2) != 0 ? r.c(bVar) : a0Var);
    }
}
