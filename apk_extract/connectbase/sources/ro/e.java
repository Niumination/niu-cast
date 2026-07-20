package ro;

import eo.h0;
import eo.h1;
import eo.z0;
import ik.y0;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import jp.q;
import jp.s;
import kn.g1;
import kn.l0;
import kn.l1;
import kn.m1;
import kn.n0;
import kn.w;
import lm.t0;
import nm.d1;
import no.z;
import un.o;
import vp.f0;
import vp.o1;
import vp.x;

/* JADX INFO: loaded from: classes3.dex */
public final class e implements fo.c, po.g {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final /* synthetic */ o<Object>[] f14610i;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public final qo.h f14611a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.l
    public final uo.a f14612b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @os.l
    public final up.j f14613c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @os.l
    public final up.i f14614d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @os.l
    public final to.a f14615e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @os.l
    public final up.i f14616f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f14617g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f14618h;

    public static final class a extends n0 implements jn.a<Map<dp.f, ? extends jp.g<?>>> {
        public a() {
            super(0);
        }

        @Override // jn.a
        @os.l
        public final Map<dp.f, ? extends jp.g<?>> invoke() {
            Collection<uo.b> collectionN = e.this.f14612b.n();
            e eVar = e.this;
            ArrayList arrayList = new ArrayList();
            for (uo.b bVar : collectionN) {
                dp.f name = bVar.getName();
                if (name == null) {
                    name = z.f11802c;
                }
                jp.g<?> gVarL = eVar.l(bVar);
                t0 t0Var = gVarL == null ? null : new t0(name, gVarL);
                if (t0Var != null) {
                    arrayList.add(t0Var);
                }
            }
            return d1.D0(arrayList);
        }
    }

    public static final class b extends n0 implements jn.a<dp.c> {
        public b() {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // jn.a
        @os.m
        public final dp.c invoke() {
            dp.b bVarF = e.this.f14612b.f();
            if (bVarF == null) {
                return null;
            }
            return bVarF.b();
        }
    }

    public static final class c extends n0 implements jn.a<vp.n0> {
        public c() {
            super(0);
        }

        @Override // jn.a
        @os.l
        public final vp.n0 invoke() {
            dp.c cVarE = e.this.e();
            if (cVarE == null) {
                return x.j(l0.C("No fqName: ", e.this.f14612b));
            }
            eo.e eVarH = co.d.h(co.d.f1703a, cVarE, e.this.f14611a.f14088a.f14069o.n(), null, 4, null);
            if (eVarH == null) {
                uo.g gVarResolve = e.this.f14612b.resolve();
                eVarH = gVarResolve == null ? null : e.this.f14611a.f14088a.f14065k.a(gVarResolve);
                if (eVarH == null) {
                    eVarH = e.this.g(cVarE);
                }
            }
            return eVarH.q();
        }
    }

    static {
        g1 g1Var = new g1(l1.d(e.class), "fqName", "getFqName()Lorg/jetbrains/kotlin/name/FqName;");
        m1 m1Var = l1.f9319a;
        f14610i = new o[]{m1Var.n(g1Var), m1Var.n(new g1(m1Var.d(e.class), y0.a.f8215h, "getType()Lorg/jetbrains/kotlin/types/SimpleType;")), m1Var.n(new g1(m1Var.d(e.class), "allValueArguments", "getAllValueArguments()Ljava/util/Map;"))};
    }

    public e(@os.l qo.h hVar, @os.l uo.a aVar, boolean z10) {
        l0.p(hVar, "c");
        l0.p(aVar, "javaAnnotation");
        this.f14611a = hVar;
        this.f14612b = aVar;
        this.f14613c = hVar.f14088a.f14055a.g(new b());
        this.f14614d = hVar.f14088a.f14055a.h(new c());
        this.f14615e = hVar.f14088a.f14064j.a(aVar);
        this.f14616f = hVar.f14088a.f14055a.h(new a());
        this.f14617g = aVar.j();
        this.f14618h = aVar.E() || z10;
    }

    @Override // fo.c
    @os.l
    public Map<dp.f, jp.g<?>> a() {
        return (Map) up.m.a(this.f14616f, this, f14610i[2]);
    }

    @Override // fo.c
    @os.m
    public dp.c e() {
        return (dp.c) up.m.b(this.f14613c, this, f14610i[0]);
    }

    public final eo.e g(dp.c cVar) {
        h0 h0Var = this.f14611a.f14088a.f14069o;
        dp.b bVarM = dp.b.m(cVar);
        l0.o(bVarM, "topLevel(fqName)");
        return eo.x.c(h0Var, bVarM, this.f14611a.f14088a.f14058d.e().f14738l);
    }

    @Override // fo.c
    public z0 getSource() {
        return this.f14615e;
    }

    @os.l
    public to.a h() {
        return this.f14615e;
    }

    @Override // fo.c
    @os.l
    /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
    public vp.n0 getType() {
        return (vp.n0) up.m.a(this.f14614d, this, f14610i[1]);
    }

    @Override // po.g
    public boolean j() {
        return this.f14617g;
    }

    public final boolean k() {
        return this.f14618h;
    }

    public final jp.g<?> l(uo.b bVar) {
        if (bVar instanceof uo.o) {
            return jp.h.f8775a.c(((uo.o) bVar).getValue());
        }
        if (bVar instanceof uo.m) {
            uo.m mVar = (uo.m) bVar;
            return o(mVar.d(), mVar.e());
        }
        if (!(bVar instanceof uo.e)) {
            if (bVar instanceof uo.c) {
                return m(((uo.c) bVar).a());
            }
            if (bVar instanceof uo.h) {
                return p(((uo.h) bVar).b());
            }
            return null;
        }
        uo.e eVar = (uo.e) bVar;
        dp.f name = eVar.getName();
        if (name == null) {
            name = z.f11802c;
        }
        l0.o(name, "argument.name ?: DEFAULT_ANNOTATION_MEMBER_NAME");
        return n(name, eVar.c());
    }

    public final jp.g<?> m(uo.a aVar) {
        return new jp.a(new e(this.f14611a, aVar, false, 4, null));
    }

    public final jp.g<?> n(dp.f fVar, List<? extends uo.b> list) {
        vp.n0 type = getType();
        l0.o(type, y0.a.f8215h);
        if (vp.h0.a(type)) {
            return null;
        }
        eo.e eVarF = lp.a.f(this);
        l0.m(eVarF);
        h1 h1VarB = oo.a.b(fVar, eVarF);
        f0 f0VarL = h1VarB == null ? this.f14611a.f14088a.f14069o.n().l(o1.INVARIANT, x.j("Unknown array element type")) : h1VarB.getType();
        l0.o(f0VarL, "DescriptorResolverUtils.… type\")\n                )");
        List<? extends uo.b> list2 = list;
        ArrayList arrayList = new ArrayList(nm.z.b0(list2, 10));
        Iterator<T> it = list2.iterator();
        while (it.hasNext()) {
            jp.g<?> gVarL = l((uo.b) it.next());
            if (gVarL == null) {
                gVarL = new s(null);
            }
            arrayList.add(gVarL);
        }
        return jp.h.f8775a.b(arrayList, f0VarL);
    }

    public final jp.g<?> o(dp.b bVar, dp.f fVar) {
        if (bVar == null || fVar == null) {
            return null;
        }
        return new jp.j(bVar, fVar);
    }

    public final jp.g<?> p(uo.x xVar) {
        return q.f8791b.a(this.f14611a.f14092e.o(xVar, so.d.d(oo.k.COMMON, false, null, 3, null)));
    }

    @os.l
    public String toString() {
        return gp.c.u(gp.c.f6767g, this, null, 2, null);
    }

    public /* synthetic */ e(qo.h hVar, uo.a aVar, boolean z10, int i10, w wVar) {
        this(hVar, aVar, (i10 & 4) != 0 ? false : z10);
    }
}
