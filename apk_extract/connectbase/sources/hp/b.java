package hp;

import eo.d0;
import eo.e1;
import eo.k0;
import eo.z0;
import java.util.Collection;
import kn.l0;
import kn.n0;
import nm.h0;
import od.c1;
import vp.a1;

/* JADX INFO: loaded from: classes3.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public static final b f7476a = new b();

    public static final class a extends n0 implements jn.p<eo.m, eo.m, Boolean> {
        public static final a INSTANCE = new a();

        public a() {
            super(2);
        }

        @Override // jn.p
        @os.l
        public final Boolean invoke(@os.m eo.m mVar, @os.m eo.m mVar2) {
            return Boolean.FALSE;
        }
    }

    /* JADX INFO: renamed from: hp.b$b, reason: collision with other inner class name */
    public static final class C0204b implements wp.e.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f7477a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ eo.a f7478b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ eo.a f7479c;

        /* JADX INFO: renamed from: hp.b$b$a */
        public static final class a extends n0 implements jn.p<eo.m, eo.m, Boolean> {
            final /* synthetic */ eo.a $a;
            final /* synthetic */ eo.a $b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(eo.a aVar, eo.a aVar2) {
                super(2);
                this.$a = aVar;
                this.$b = aVar2;
            }

            @Override // jn.p
            @os.l
            public final Boolean invoke(@os.m eo.m mVar, @os.m eo.m mVar2) {
                return Boolean.valueOf(l0.g(mVar, this.$a) && l0.g(mVar2, this.$b));
            }
        }

        public C0204b(boolean z10, eo.a aVar, eo.a aVar2) {
            this.f7477a = z10;
            this.f7478b = aVar;
            this.f7479c = aVar2;
        }

        @Override // wp.e.a
        public final boolean a(@os.l a1 a1Var, @os.l a1 a1Var2) {
            l0.p(a1Var, c1.f12184a);
            l0.p(a1Var2, "c2");
            if (l0.g(a1Var, a1Var2)) {
                return true;
            }
            eo.h hVarD = a1Var.d();
            eo.h hVarD2 = a1Var2.d();
            if ((hVarD instanceof e1) && (hVarD2 instanceof e1)) {
                return b.f7476a.g((e1) hVarD, (e1) hVarD2, this.f7477a, new a(this.f7478b, this.f7479c));
            }
            return false;
        }
    }

    public static final class c extends n0 implements jn.p<eo.m, eo.m, Boolean> {
        public static final c INSTANCE = new c();

        public c() {
            super(2);
        }

        @Override // jn.p
        @os.l
        public final Boolean invoke(@os.m eo.m mVar, @os.m eo.m mVar2) {
            return Boolean.FALSE;
        }
    }

    public static /* synthetic */ boolean b(b bVar, eo.a aVar, eo.a aVar2, boolean z10, boolean z11, boolean z12, wp.g gVar, int i10, Object obj) {
        if ((i10 & 8) != 0) {
            z11 = true;
        }
        boolean z13 = z11;
        if ((i10 & 16) != 0) {
            z12 = false;
        }
        return bVar.a(aVar, aVar2, z10, z13, z12, gVar);
    }

    public static /* synthetic */ boolean e(b bVar, eo.m mVar, eo.m mVar2, boolean z10, boolean z11, int i10, Object obj) {
        if ((i10 & 8) != 0) {
            z11 = true;
        }
        return bVar.d(mVar, mVar2, z10, z11);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ boolean h(b bVar, e1 e1Var, e1 e1Var2, boolean z10, jn.p pVar, int i10, Object obj) {
        if ((i10 & 8) != 0) {
            pVar = c.INSTANCE;
        }
        return bVar.g(e1Var, e1Var2, z10, pVar);
    }

    public final boolean a(@os.l eo.a aVar, @os.l eo.a aVar2, boolean z10, boolean z11, boolean z12, @os.l wp.g gVar) {
        l0.p(aVar, "a");
        l0.p(aVar2, "b");
        l0.p(gVar, "kotlinTypeRefiner");
        if (l0.g(aVar, aVar2)) {
            return true;
        }
        if (!l0.g(aVar.getName(), aVar2.getName())) {
            return false;
        }
        if (z11 && (aVar instanceof d0) && (aVar2 instanceof d0) && ((d0) aVar).i0() != ((d0) aVar2).i0()) {
            return false;
        }
        if ((l0.g(aVar.b(), aVar2.b()) && (!z10 || !l0.g(j(aVar), j(aVar2)))) || d.E(aVar) || d.E(aVar2) || !i(aVar, aVar2, a.INSTANCE, z10)) {
            return false;
        }
        j jVarI = j.i(gVar, new C0204b(z10, aVar, aVar2));
        l0.o(jVarI, "a: CallableDescriptor,\n …= a && y == b }\n        }");
        j.i.a aVarC = jVarI.F(aVar, aVar2, null, !z12).c();
        j.i.a aVar3 = j.i.a.OVERRIDABLE;
        return aVarC == aVar3 && jVarI.F(aVar2, aVar, null, z12 ^ true).c() == aVar3;
    }

    public final boolean c(eo.e eVar, eo.e eVar2) {
        return l0.g(eVar.i(), eVar2.i());
    }

    public final boolean d(@os.m eo.m mVar, @os.m eo.m mVar2, boolean z10, boolean z11) {
        if ((mVar instanceof eo.e) && (mVar2 instanceof eo.e)) {
            return c((eo.e) mVar, (eo.e) mVar2);
        }
        if ((mVar instanceof e1) && (mVar2 instanceof e1)) {
            return h(this, (e1) mVar, (e1) mVar2, z10, null, 8, null);
        }
        if ((mVar instanceof eo.a) && (mVar2 instanceof eo.a)) {
            return b(this, (eo.a) mVar, (eo.a) mVar2, z10, z11, false, wp.g.a.f19853a, 16, null);
        }
        return ((mVar instanceof k0) && (mVar2 instanceof k0)) ? l0.g(((k0) mVar).e(), ((k0) mVar2).e()) : l0.g(mVar, mVar2);
    }

    @in.j
    public final boolean f(@os.l e1 e1Var, @os.l e1 e1Var2, boolean z10) {
        l0.p(e1Var, "a");
        l0.p(e1Var2, "b");
        return h(this, e1Var, e1Var2, z10, null, 8, null);
    }

    @in.j
    public final boolean g(@os.l e1 e1Var, @os.l e1 e1Var2, boolean z10, @os.l jn.p<? super eo.m, ? super eo.m, Boolean> pVar) {
        l0.p(e1Var, "a");
        l0.p(e1Var2, "b");
        l0.p(pVar, "equivalentCallables");
        if (l0.g(e1Var, e1Var2)) {
            return true;
        }
        return !l0.g(e1Var.b(), e1Var2.b()) && i(e1Var, e1Var2, pVar, z10) && e1Var.f() == e1Var2.f();
    }

    public final boolean i(eo.m mVar, eo.m mVar2, jn.p<? super eo.m, ? super eo.m, Boolean> pVar, boolean z10) {
        eo.m mVarB = mVar.b();
        eo.m mVarB2 = mVar2.b();
        return ((mVarB instanceof eo.b) || (mVarB2 instanceof eo.b)) ? pVar.invoke(mVarB, mVarB2).booleanValue() : e(this, mVarB, mVarB2, z10, false, 8, null);
    }

    public final z0 j(eo.a aVar) {
        while (aVar instanceof eo.b) {
            eo.b bVar = (eo.b) aVar;
            if (bVar.getKind() != eo.b.a.FAKE_OVERRIDE) {
                break;
            }
            Collection<? extends eo.b> collectionD = bVar.d();
            l0.o(collectionD, "overriddenDescriptors");
            aVar = (eo.b) h0.i5(collectionD);
            if (aVar == null) {
                return null;
            }
        }
        return aVar.getSource();
    }
}
