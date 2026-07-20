package wk;

import ik.b1;
import java.util.ArrayList;
import java.util.List;
import lm.d1;
import lm.l2;

/* JADX INFO: loaded from: classes2.dex */
public final class z extends v {

    @os.l
    public static final a O = new a();

    @os.l
    public static final dk.m<a0> P = new dk.m<>();

    @os.l
    public static final dk.m<a0> Q = new dk.m<>();

    @os.l
    public static final fl.b<z> R = new fl.b<>("Routing");

    @os.l
    public final dk.a M;

    @os.l
    public final List<jn.l<l0, l2>> N;

    public static final class a implements dk.h<dk.a, z, z> {

        /* JADX INFO: renamed from: wk.z$a$a, reason: collision with other inner class name */
        @xm.f(c = "io.ktor.routing.Routing$Feature$install$1", f = "Routing.kt", i = {}, l = {y5.a.Z}, m = "invokeSuspend", n = {}, s = {})
        public static final class C0483a extends xm.o implements jn.q<nl.f<l2, dk.b>, l2, um.d<? super l2>, Object> {
            final /* synthetic */ z $routing;
            private /* synthetic */ Object L$0;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C0483a(z zVar, um.d<? super C0483a> dVar) {
                super(3, dVar);
                this.$routing = zVar;
            }

            @Override // xm.a
            @os.m
            public final Object invokeSuspend(@os.l Object obj) {
                wm.a aVar = wm.a.COROUTINE_SUSPENDED;
                int i10 = this.label;
                if (i10 == 0) {
                    d1.n(obj);
                    nl.f<l2, dk.b> fVar = (nl.f) this.L$0;
                    z zVar = this.$routing;
                    this.label = 1;
                    if (zVar.q0(fVar, this) == aVar) {
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
                C0483a c0483a = new C0483a(this.$routing, dVar);
                c0483a.L$0 = fVar;
                return c0483a.invokeSuspend(l2.f10208a);
            }
        }

        public a() {
        }

        @os.l
        public final dk.m<a0> b() {
            return z.Q;
        }

        @os.l
        public final dk.m<a0> c() {
            return z.P;
        }

        @Override // dk.h
        @os.l
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public z a(@os.l dk.a aVar, @os.l jn.l<? super z, l2> lVar) throws nl.c {
            kn.l0.p(aVar, "pipeline");
            kn.l0.p(lVar, "configure");
            z zVar = new z(aVar);
            lVar.invoke(zVar);
            dk.c.f3706v.getClass();
            aVar.x(dk.c.f3710z, new C0483a(zVar, null));
            return zVar;
        }

        @Override // dk.h
        @os.l
        public fl.b<z> getKey() {
            return z.R;
        }

        public a(kn.w wVar) {
        }
    }

    @xm.f(c = "io.ktor.routing.Routing", f = "Routing.kt", i = {0, 0}, l = {154}, m = "executeResult", n = {"this", "routingCall"}, s = {"L$0", "L$1"})
    public static final class b extends xm.d {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public b(um.d<? super b> dVar) {
            super(dVar);
        }

        @Override // xm.a
        @os.m
        public final Object invokeSuspend(@os.l Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return z.this.n0(null, null, null, this);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public z(@os.l dk.a aVar) {
        super(null, new u(aVar.I.e()), aVar.I.h());
        kn.l0.p(aVar, n1.i.f11236l);
        this.M = aVar;
        this.N = new ArrayList();
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0016  */
    public final Object n0(nl.f<l2, dk.b> fVar, v vVar, b1 b1Var, um.d<? super l2> dVar) throws Throwable {
        b bVar;
        uk.b bVar2;
        vk.d dVar2;
        a0 a0Var;
        z zVar = this;
        if (dVar instanceof b) {
            bVar = (b) dVar;
            int i10 = bVar.label;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                bVar.label = i10 - Integer.MIN_VALUE;
            } else {
                bVar = new b(dVar);
            }
        } else {
            bVar = new b(dVar);
        }
        Object obj = bVar.result;
        wm.a aVar = wm.a.COROUTINE_SUSPENDED;
        int i11 = bVar.label;
        if (i11 != 0) {
            if (i11 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            a0 a0Var2 = (a0) bVar.L$1;
            z zVar2 = (z) bVar.L$0;
            try {
                d1.n(obj);
                a0Var = a0Var2;
                zVar = zVar2;
                zVar.M.I.c().a(Q, a0Var);
                return l2.f10208a;
            } catch (Throwable th2) {
                th = th2;
                a0Var = a0Var2;
                zVar = zVar2;
                zVar.M.I.c().a(Q, a0Var);
                throw th;
            }
        }
        d1.n(obj);
        dk.c cVarX = vVar.X();
        uk.b bVarC = fVar.getContext().d().c();
        uk.b bVar3 = cVarX.f3712n;
        if (bVarC.A()) {
            bVar2 = bVar3;
        } else if (bVar3.A()) {
            bVar2 = bVarC;
        } else {
            uk.b bVar4 = new uk.b(zVar.f3711i);
            bVar4.C(bVarC);
            bVar4.C(bVar3);
            bVar2 = bVar4;
        }
        vk.d dVarC = fVar.getContext().e().c();
        vk.d dVar3 = cVarX.f3713p;
        if (dVarC.A()) {
            dVar2 = dVar3;
        } else if (dVar3.A()) {
            dVar2 = dVarC;
        } else {
            vk.d dVar4 = new vk.d(zVar.f3711i);
            dVar4.C(dVarC);
            dVar4.C(dVar3);
            dVar2 = dVar4;
        }
        a0Var = new a0(fVar.getContext(), vVar, bVar2, dVar2, b1Var);
        zVar.M.I.c().a(P, a0Var);
        try {
            l2 l2Var = l2.f10208a;
            bVar.L$0 = zVar;
            bVar.L$1 = a0Var;
            bVar.label = 1;
            if (cVarX.g(a0Var, l2Var, bVar) == aVar) {
                return aVar;
            }
            zVar.M.I.c().a(Q, a0Var);
            return l2.f10208a;
        } catch (Throwable th3) {
            th = th3;
            zVar.M.I.c().a(Q, a0Var);
            throw th;
        }
    }

    @os.l
    public final dk.a o0() {
        return this.M;
    }

    @os.m
    public final Object q0(@os.l nl.f<l2, dk.b> fVar, @os.l um.d<? super l2> dVar) {
        Object objN0;
        k0 k0VarI = new j0(this, fVar.getContext(), this.N).i();
        return ((k0VarI instanceof k0.b) && (objN0 = n0(fVar, k0VarI.f19630a, ((k0.b) k0VarI).f19632b, dVar)) == wm.a.COROUTINE_SUSPENDED) ? objN0 : l2.f10208a;
    }

    public final <Subject, Context, P extends nl.e<Subject, Context>> P r0(P p10, P p11, jn.a<? extends P> aVar) {
        if (p10.A()) {
            return p11;
        }
        if (p11.A()) {
            return p10;
        }
        P pInvoke = aVar.invoke();
        pInvoke.C(p10);
        pInvoke.C(p11);
        return pInvoke;
    }

    public final void s0(@os.l jn.l<? super l0, l2> lVar) {
        kn.l0.p(lVar, "block");
        this.N.add(lVar);
    }
}
