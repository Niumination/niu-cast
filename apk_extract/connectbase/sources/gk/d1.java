package gk;

import ik.t1;
import java.util.ArrayList;
import java.util.Iterator;
import lm.l2;
import wj.h2;

/* JADX INFO: loaded from: classes2.dex */
public final class d1 implements dk.h<dk.c, a, a> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public static final d1 f6579a = new d1();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.l
    public static final fl.b<a> f6580b = new fl.b<>("XForwardedHeaderSupport");

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @os.l
        public final ArrayList<String> f6581a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @os.l
        public final ArrayList<String> f6582b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @os.l
        public final ArrayList<String> f6583c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @os.l
        public final ArrayList<String> f6584d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        @os.l
        public final ArrayList<String> f6585e;

        public a() {
            ik.j0 j0Var = ik.j0.f8048a;
            j0Var.getClass();
            String str = ik.j0.N0;
            j0Var.getClass();
            this.f6581a = nm.y.s(str, ik.j0.O0);
            j0Var.getClass();
            this.f6582b = nm.y.s(ik.j0.P0, "X-Forwarded-Protocol");
            j0Var.getClass();
            this.f6583c = nm.y.s(ik.j0.Q0);
            this.f6584d = nm.y.s("X-Forwarded-SSL", "Front-End-Https");
            this.f6585e = nm.y.s(n1.d.Z0);
        }

        public static /* synthetic */ void e() {
        }

        @os.l
        public final ArrayList<String> a() {
            return this.f6583c;
        }

        @os.l
        public final ArrayList<String> b() {
            return this.f6581a;
        }

        @os.l
        public final ArrayList<String> c() {
            return this.f6584d;
        }

        @os.l
        public final ArrayList<String> d() {
            return this.f6585e;
        }

        @os.l
        public final ArrayList<String> f() {
            return this.f6582b;
        }
    }

    @xm.f(c = "io.ktor.features.XForwardedHeaderSupport$install$1", f = "OriginConnectionPoint.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class b extends xm.o implements jn.q<nl.f<l2, dk.b>, l2, um.d<? super l2>, Object> {
        final /* synthetic */ a $config;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(a aVar, um.d<? super b> dVar) {
            super(3, dVar);
            this.$config = aVar;
        }

        @Override // xm.a
        @os.m
        public final Object invokeSuspend(@os.l Object obj) {
            wm.a aVar = wm.a.COROUTINE_SUSPENDED;
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            lm.d1.n(obj);
            nl.f fVar = (nl.f) this.L$0;
            dk.b bVar = (dk.b) fVar.getContext();
            Iterator<String> it = this.$config.f6582b.iterator();
            while (it.hasNext()) {
                String strQ = uk.e.q(bVar.d(), it.next());
                if (strQ != null) {
                    q0 q0VarB = u0.b((dk.b) fVar.getContext());
                    q0VarB.i(strQ);
                    t1.f8189c.getClass();
                    t1 t1Var = (t1) t1.f8195i.get(strQ);
                    if (t1Var != null) {
                        q0VarB.g(t1Var.f8197b);
                    }
                }
            }
            dk.b bVar2 = (dk.b) fVar.getContext();
            Iterator<String> it2 = this.$config.f6584d.iterator();
            while (it2.hasNext()) {
                String strQ2 = uk.e.q(bVar2.d(), it2.next());
                if (strQ2 != null && d1.f6579a.d(strQ2)) {
                    q0 q0VarB2 = u0.b((dk.b) fVar.getContext());
                    q0VarB2.i(h2.f18719h);
                    t1.f8189c.getClass();
                    t1 t1Var2 = (t1) t1.f8195i.get(q0VarB2.d());
                    if (t1Var2 != null) {
                        q0VarB2.g(t1Var2.f8197b);
                    }
                }
            }
            dk.b bVar3 = (dk.b) fVar.getContext();
            Iterator<String> it3 = this.$config.f6581a.iterator();
            while (it3.hasNext()) {
                String strQ3 = uk.e.q(bVar3.d(), it3.next());
                if (strQ3 != null) {
                    l2 l2Var = null;
                    String strU5 = jq.h0.u5(strQ3, n1.e.f11184d, null, 2, null);
                    String strK5 = jq.h0.k5(strQ3, n1.e.f11184d, "");
                    q0 q0VarB3 = u0.b((dk.b) fVar.getContext());
                    q0VarB3.e(strU5);
                    Integer numX0 = jq.d0.X0(strK5);
                    if (numX0 != null) {
                        q0VarB3.g(numX0.intValue());
                        l2Var = l2.f10208a;
                    }
                    if (l2Var == null) {
                        t1.f8189c.getClass();
                        t1 t1Var3 = (t1) t1.f8195i.get(q0VarB3.d());
                        if (t1Var3 != null) {
                            q0VarB3.g(t1Var3.f8197b);
                        }
                    }
                }
            }
            dk.b bVar4 = (dk.b) fVar.getContext();
            Iterator<String> it4 = this.$config.f6585e.iterator();
            while (it4.hasNext()) {
                String strQ4 = uk.e.q(bVar4.d(), it4.next());
                if (strQ4 != null) {
                    u0.b((dk.b) fVar.getContext()).g(Integer.parseInt(jq.h0.C5((String) nm.h0.B2(jq.h0.R4(strQ4, new String[]{ks.g.f9491d}, false, 0, 6, null))).toString()));
                }
            }
            dk.b bVar5 = (dk.b) fVar.getContext();
            Iterator<String> it5 = this.$config.f6583c.iterator();
            while (it5.hasNext()) {
                String strQ5 = uk.e.q(bVar5.d(), it5.next());
                if (strQ5 != null) {
                    String string = jq.h0.C5((String) nm.h0.B2(jq.h0.R4(strQ5, new String[]{ks.g.f9491d}, false, 0, 6, null))).toString();
                    if (!jq.e0.S1(string)) {
                        u0.b((dk.b) fVar.getContext()).h(string);
                    }
                }
            }
            return l2.f10208a;
        }

        @Override // jn.q
        @os.m
        public final Object invoke(@os.l nl.f<l2, dk.b> fVar, @os.l l2 l2Var, @os.m um.d<? super l2> dVar) {
            b bVar = new b(this.$config, dVar);
            bVar.L$0 = fVar;
            return bVar.invokeSuspend(l2.f10208a);
        }
    }

    @Override // dk.h
    @os.l
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public a a(@os.l dk.c cVar, @os.l jn.l<? super a, l2> lVar) throws nl.c {
        kn.l0.p(cVar, "pipeline");
        kn.l0.p(lVar, "configure");
        a aVar = new a();
        lVar.invoke(aVar);
        dk.c.f3706v.getClass();
        cVar.x(dk.c.f3709y, new b(aVar, null));
        return aVar;
    }

    public final boolean d(String str) {
        return kn.l0.g(str, "yes") || kn.l0.g(str, "true") || kn.l0.g(str, nq.w0.f11976d);
    }

    @Override // dk.h
    @os.l
    public fl.b<a> getKey() {
        return f6580b;
    }
}
