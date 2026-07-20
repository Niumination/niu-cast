package lp;

import dp.f;
import eo.h1;
import eo.i;
import eo.s0;
import eo.t0;
import gq.s;
import gq.v;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import jp.g;
import kn.g0;
import kn.k1;
import kn.l0;
import kn.l1;
import kn.n0;
import nm.h0;
import nm.k0;
import nm.x;
import nm.z;
import os.l;
import os.m;
import un.h;
import vp.f0;
import wp.p;

/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @l
    public static final f f10231a;

    /* JADX INFO: renamed from: lp.a$a, reason: collision with other inner class name */
    public static final class C0268a<N> implements eq.b.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final C0268a<N> f10232a = new C0268a<>();

        @Override // eq.b.d
        @l
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Iterable<h1> a(h1 h1Var) {
            Collection<h1> collectionD = h1Var.d();
            ArrayList arrayList = new ArrayList(z.b0(collectionD, 10));
            Iterator<T> it = collectionD.iterator();
            while (it.hasNext()) {
                arrayList.add(((h1) it.next()).a());
            }
            return arrayList;
        }
    }

    public /* synthetic */ class b extends g0 implements jn.l<h1, Boolean> {
        public static final b INSTANCE = new b();

        public b() {
            super(1);
        }

        @Override // kn.q, un.c
        @l
        public final String getName() {
            return "declaresDefaultValue";
        }

        @Override // kn.q
        @l
        public final h getOwner() {
            return l1.d(h1.class);
        }

        @Override // kn.q
        @l
        public final String getSignature() {
            return "declaresDefaultValue()Z";
        }

        @Override // jn.l
        @l
        public final Boolean invoke(@l h1 h1Var) {
            l0.p(h1Var, "p0");
            return Boolean.valueOf(h1Var.w0());
        }
    }

    public static final class c<N> implements eq.b.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f10233a;

        public c(boolean z10) {
            this.f10233a = z10;
        }

        @Override // eq.b.d
        @l
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Iterable<eo.b> a(eo.b bVar) {
            if (this.f10233a) {
                bVar = bVar == null ? null : bVar.a();
            }
            if (bVar == null) {
                return k0.INSTANCE;
            }
            Collection<? extends eo.b> collectionD = bVar.d();
            l0.o(collectionD, "descriptor?.overriddenDescriptors ?: emptyList()");
            return collectionD;
        }
    }

    public static final class d extends eq.b.AbstractC0107b<eo.b, eo.b> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ k1.h<eo.b> f10234a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ jn.l<eo.b, Boolean> f10235b;

        /* JADX WARN: Multi-variable type inference failed */
        public d(k1.h<eo.b> hVar, jn.l<? super eo.b, Boolean> lVar) {
            this.f10234a = hVar;
            this.f10235b = lVar;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // eq.b.AbstractC0107b, eq.b.e
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public void a(@l eo.b bVar) {
            l0.p(bVar, "current");
            if (this.f10234a.element == null && this.f10235b.invoke(bVar).booleanValue()) {
                this.f10234a.element = bVar;
            }
        }

        @Override // eq.b.AbstractC0107b, eq.b.e
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public boolean b(@l eo.b bVar) {
            l0.p(bVar, "current");
            return this.f10234a.element == null;
        }

        @Override // eq.b.e
        @m
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public eo.b result() {
            return this.f10234a.element;
        }
    }

    public static final class e extends n0 implements jn.l<eo.m, eo.m> {
        public static final e INSTANCE = new e();

        public e() {
            super(1);
        }

        @Override // jn.l
        @m
        public final eo.m invoke(@l eo.m mVar) {
            l0.p(mVar, "it");
            return mVar.b();
        }
    }

    static {
        f fVarK = f.k("value");
        l0.o(fVarK, "identifier(\"value\")");
        f10231a = fVarK;
    }

    public static final boolean a(@l h1 h1Var) {
        l0.p(h1Var, "<this>");
        Boolean boolE = eq.b.e(x.k(h1Var), C0268a.f10232a, b.INSTANCE);
        l0.o(boolE, "ifAny(\n        listOf(th…eclaresDefaultValue\n    )");
        return boolE.booleanValue();
    }

    @m
    public static final g<?> b(@l fo.c cVar) {
        l0.p(cVar, "<this>");
        return (g) h0.E2(cVar.a().values());
    }

    @m
    public static final eo.b c(@l eo.b bVar, boolean z10, @l jn.l<? super eo.b, Boolean> lVar) {
        l0.p(bVar, "<this>");
        l0.p(lVar, "predicate");
        return (eo.b) eq.b.b(x.k(bVar), new c(z10), new d(new k1.h(), lVar));
    }

    public static /* synthetic */ eo.b d(eo.b bVar, boolean z10, jn.l lVar, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = false;
        }
        return c(bVar, z10, lVar);
    }

    @m
    public static final dp.c e(@l eo.m mVar) {
        l0.p(mVar, "<this>");
        dp.d dVarJ = j(mVar);
        if (!dVarJ.f()) {
            dVarJ = null;
        }
        if (dVarJ == null) {
            return null;
        }
        return dVarJ.l();
    }

    @m
    public static final eo.e f(@l fo.c cVar) {
        l0.p(cVar, "<this>");
        eo.h hVarD = cVar.getType().G0().d();
        if (hVarD instanceof eo.e) {
            return (eo.e) hVarD;
        }
        return null;
    }

    @l
    public static final ao.h g(@l eo.m mVar) {
        l0.p(mVar, "<this>");
        return l(mVar).n();
    }

    @m
    public static final dp.b h(@m eo.h hVar) {
        if (hVar == null) {
            return null;
        }
        eo.m mVarB = hVar.b();
        if (mVarB instanceof eo.k0) {
            return new dp.b(((eo.k0) mVarB).e(), hVar.getName());
        }
        if (!(mVarB instanceof i)) {
            return null;
        }
        l0.o(mVarB, "owner");
        dp.b bVarH = h((eo.h) mVarB);
        if (bVarH == null) {
            return null;
        }
        return bVarH.d(hVar.getName());
    }

    @l
    public static final dp.c i(@l eo.m mVar) {
        l0.p(mVar, "<this>");
        dp.c cVarN = hp.d.n(mVar);
        l0.o(cVarN, "getFqNameSafe(this)");
        return cVarN;
    }

    @l
    public static final dp.d j(@l eo.m mVar) {
        l0.p(mVar, "<this>");
        dp.d dVarM = hp.d.m(mVar);
        l0.o(dVarM, "getFqName(this)");
        return dVarM;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @l
    public static final wp.g k(@l eo.h0 h0Var) {
        l0.p(h0Var, "<this>");
        p pVar = (p) h0Var.M(wp.h.a());
        wp.x xVar = pVar == null ? null : (wp.x) pVar.f19873a;
        return xVar instanceof wp.x.a ? ((wp.x.a) xVar).f19882b : wp.g.a.f19853a;
    }

    @l
    public static final eo.h0 l(@l eo.m mVar) {
        l0.p(mVar, "<this>");
        eo.h0 h0VarG = hp.d.g(mVar);
        l0.o(h0VarG, "getContainingModule(this)");
        return h0VarG;
    }

    @l
    public static final gq.m<eo.m> m(@l eo.m mVar) {
        l0.p(mVar, "<this>");
        return v.k0(n(mVar), 1);
    }

    @l
    public static final gq.m<eo.m> n(@l eo.m mVar) {
        l0.p(mVar, "<this>");
        return s.l(mVar, e.INSTANCE);
    }

    @l
    public static final eo.b o(@l eo.b bVar) {
        l0.p(bVar, "<this>");
        if (!(bVar instanceof s0)) {
            return bVar;
        }
        t0 t0VarW = ((s0) bVar).W();
        l0.o(t0VarW, "correspondingProperty");
        return t0VarW;
    }

    @m
    public static final eo.e p(@l eo.e eVar) {
        l0.p(eVar, "<this>");
        for (f0 f0Var : eVar.q().G0().a()) {
            if (!ao.h.b0(f0Var)) {
                eo.h hVarD = f0Var.G0().d();
                if (hp.d.w(hVarD)) {
                    if (hVarD != null) {
                        return (eo.e) hVarD;
                    }
                    throw new NullPointerException("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
                }
            }
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final boolean q(@l eo.h0 h0Var) {
        l0.p(h0Var, "<this>");
        p pVar = (p) h0Var.M(wp.h.a());
        return pVar != null && ((wp.x) pVar.f19873a).f19881a;
    }

    @m
    public static final eo.e r(@l eo.h0 h0Var, @l dp.c cVar, @l mo.b bVar) {
        l0.p(h0Var, "<this>");
        l0.p(cVar, "topLevelClassFqName");
        l0.p(bVar, "location");
        cVar.d();
        dp.c cVarE = cVar.e();
        l0.o(cVarE, "topLevelClassFqName.parent()");
        op.h hVarO = h0Var.o0(cVarE).o();
        f fVarG = cVar.g();
        l0.o(fVarG, "topLevelClassFqName.shortName()");
        eo.h hVarF = hVarO.f(fVarG, bVar);
        if (hVarF instanceof eo.e) {
            return (eo.e) hVarF;
        }
        return null;
    }
}
