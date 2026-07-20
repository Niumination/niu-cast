package ro;

import eo.c1;
import eo.e0;
import eo.e1;
import eo.f1;
import eo.j0;
import eo.m1;
import eo.t;
import eo.u;
import eo.x0;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import jp.v;
import kn.l0;
import kn.n0;
import kn.w;
import lm.d0;
import nm.h0;
import nm.k0;
import nm.o1;
import nm.v0;
import nm.z;
import no.r;
import rp.q;
import uo.x;
import uo.y;
import vp.a1;
import vp.f0;
import vp.g0;

/* JADX INFO: loaded from: classes3.dex */
public final class f extends ho.g implements po.c {

    @os.l
    public static final a R = new a();

    @os.l
    public static final Set<String> S = o1.u("equals", "hashCode", "getClass", "wait", "notify", "notifyAll", "toString");

    @os.l
    public final e0 H;

    @os.l
    public final m1 I;
    public final boolean J;

    @os.l
    public final b K;

    @os.l
    public final g L;

    @os.l
    public final x0<g> M;

    @os.l
    public final op.f N;

    @os.l
    public final k O;

    @os.l
    public final fo.g P;

    @os.l
    public final up.i<List<e1>> Q;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    @os.l
    public final qo.h f14619p;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    @os.l
    public final uo.g f14620v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    @os.m
    public final eo.e f14621w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    @os.l
    public final qo.h f14622x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    @os.l
    public final d0 f14623y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    @os.l
    public final eo.f f14624z;

    public static final class a {
        public a() {
        }

        public a(w wVar) {
        }
    }

    public final class b extends vp.b {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @os.l
        public final up.i<List<e1>> f14625d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ f f14626e;

        public static final class a extends n0 implements jn.a<List<? extends e1>> {
            final /* synthetic */ f this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(f fVar) {
                super(0);
                this.this$0 = fVar;
            }

            @Override // jn.a
            @os.l
            public final List<? extends e1> invoke() {
                return f1.d(this.this$0);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(f fVar) {
            super(fVar.f14622x.f14088a.f14055a);
            l0.p(fVar, "this$0");
            this.f14626e = fVar;
            this.f14625d = fVar.f14622x.f14088a.f14055a.h(new a(fVar));
        }

        @Override // vp.b, vp.m, vp.a1
        public eo.h d() {
            return this.f14626e;
        }

        @Override // vp.a1
        public boolean e() {
            return true;
        }

        @Override // vp.a1
        @os.l
        public List<e1> getParameters() {
            return this.f14625d.invoke();
        }

        @Override // vp.h
        @os.l
        public Collection<f0> k() {
            Collection<uo.j> collectionA = this.f14626e.f14620v.a();
            ArrayList arrayList = new ArrayList(collectionA.size());
            ArrayList arrayList2 = new ArrayList(0);
            f0 f0VarW = w();
            Iterator<uo.j> it = collectionA.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                uo.j next = it.next();
                f0 f0VarO = this.f14626e.f14622x.f14092e.o(next, so.d.d(oo.k.SUPERTYPE, false, null, 3, null));
                qo.h hVar = this.f14626e.f14622x;
                f0 f0VarF = hVar.f14088a.f14072r.f(f0VarO, hVar);
                if (f0VarF.G0().d() instanceof j0.b) {
                    arrayList2.add(next);
                }
                if (!l0.g(f0VarF.G0(), f0VarW != null ? f0VarW.G0() : null) && !ao.h.b0(f0VarF)) {
                    arrayList.add(f0VarF);
                }
            }
            f fVar = this.f14626e;
            eo.e eVar = fVar.f14621w;
            eq.a.a(arrayList, eVar != null ? co.j.a(eVar, fVar).c().p(eVar.q(), vp.o1.INVARIANT) : null);
            eq.a.a(arrayList, f0VarW);
            if (!arrayList2.isEmpty()) {
                f fVar2 = this.f14626e;
                q qVar = fVar2.f14622x.f14088a.f14060f;
                ArrayList arrayList3 = new ArrayList(z.b0(arrayList2, 10));
                Iterator it2 = arrayList2.iterator();
                while (it2.hasNext()) {
                    arrayList3.add(((uo.j) ((x) it2.next())).D());
                }
                qVar.a(fVar2, arrayList3);
            }
            return !arrayList.isEmpty() ? h0.V5(arrayList) : nm.x.k(this.f14626e.f14622x.f14088a.f14069o.n().i());
        }

        @Override // vp.h
        @os.l
        public c1 p() {
            return this.f14626e.f14622x.f14088a.f14067m;
        }

        @os.l
        public String toString() {
            String strB = this.f14626e.getName().b();
            l0.o(strB, "name.asString()");
            return strB;
        }

        @Override // vp.b
        @os.l
        /* JADX INFO: renamed from: v */
        public eo.e d() {
            return this.f14626e;
        }

        public final f0 w() {
            dp.c cVarB;
            ArrayList arrayList;
            dp.c cVarX = x();
            if (cVarX == null || cVarX.d() || !cVarX.i(ao.k.f564l)) {
                cVarX = null;
            }
            if (cVarX == null) {
                cVarB = no.m.f11762a.b(lp.a.i(this.f14626e));
                if (cVarB == null) {
                    return null;
                }
            } else {
                cVarB = cVarX;
            }
            eo.e eVarR = lp.a.r(this.f14626e.f14622x.f14088a.f14069o, cVarB, mo.d.FROM_JAVA_LOADER);
            if (eVarR == null) {
                return null;
            }
            int size = eVarR.i().getParameters().size();
            List<e1> parameters = this.f14626e.K.getParameters();
            l0.o(parameters, "getTypeConstructor().parameters");
            int size2 = parameters.size();
            if (size2 == size) {
                List<e1> list = parameters;
                arrayList = new ArrayList(z.b0(list, 10));
                Iterator<T> it = list.iterator();
                while (it.hasNext()) {
                    arrayList.add(new vp.e1(vp.o1.INVARIANT, ((e1) it.next()).q()));
                }
            } else {
                if (size2 != 1 || size <= 1 || cVarX != null) {
                    return null;
                }
                vp.e1 e1Var = new vp.e1(vp.o1.INVARIANT, ((e1) h0.h5(parameters)).q());
                tn.l lVar = new tn.l(1, size, 1);
                ArrayList arrayList2 = new ArrayList(z.b0(lVar, 10));
                Iterator<Integer> it2 = lVar.iterator();
                while (it2.hasNext()) {
                    ((v0) it2).nextInt();
                    arrayList2.add(e1Var);
                }
                arrayList = arrayList2;
            }
            fo.g.f6167h.getClass();
            return g0.g(fo.g.a.f6169b, eVarR, arrayList);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final dp.c x() {
            fo.g gVar = this.f14626e.P;
            dp.c cVar = no.z.f11816q;
            l0.o(cVar, "PURELY_IMPLEMENTS_ANNOTATION");
            fo.c cVarD = gVar.d(cVar);
            if (cVarD == null) {
                return null;
            }
            Object objI5 = h0.i5(cVarD.a().values());
            v vVar = objI5 instanceof v ? (v) objI5 : null;
            if (vVar == null) {
                return null;
            }
            String str = (String) vVar.f8774a;
            if (dp.e.e(str)) {
                return new dp.c(str);
            }
            return null;
        }
    }

    public static final class c extends n0 implements jn.a<List<? extends e1>> {
        public c() {
            super(0);
        }

        @Override // jn.a
        @os.l
        public final List<? extends e1> invoke() {
            List<y> typeParameters = f.this.f14620v.getTypeParameters();
            f fVar = f.this;
            ArrayList arrayList = new ArrayList(z.b0(typeParameters, 10));
            for (y yVar : typeParameters) {
                e1 e1VarA = fVar.f14622x.f14089b.a(yVar);
                if (e1VarA == null) {
                    throw new AssertionError("Parameter " + yVar + " surely belongs to class " + fVar.f14620v + ", so it must be resolved");
                }
                arrayList.add(e1VarA);
            }
            return arrayList;
        }
    }

    public static final class d extends n0 implements jn.a<List<? extends uo.a>> {
        public d() {
            super(0);
        }

        @Override // jn.a
        @os.m
        public final List<? extends uo.a> invoke() {
            dp.b bVarH = lp.a.h(f.this);
            if (bVarH == null) {
                return null;
            }
            return f.this.f14619p.f14088a.f14077w.a(bVarH);
        }
    }

    public static final class e extends n0 implements jn.l<wp.g, g> {
        public e() {
            super(1);
        }

        @Override // jn.l
        @os.l
        public final g invoke(@os.l wp.g gVar) {
            l0.p(gVar, "it");
            qo.h hVar = f.this.f14622x;
            f fVar = f.this;
            return new g(hVar, fVar, fVar.f14620v, fVar.f14621w != null, fVar.L);
        }
    }

    public /* synthetic */ f(qo.h hVar, eo.m mVar, uo.g gVar, eo.e eVar, int i10, w wVar) {
        this(hVar, mVar, gVar, (i10 & 8) != 0 ? null : eVar);
    }

    @Override // eo.e
    @os.m
    public eo.d G() {
        return null;
    }

    @os.l
    public final f H0(@os.l oo.g gVar, @os.m eo.e eVar) {
        l0.p(gVar, "javaResolverCache");
        qo.h hVar = this.f14622x;
        qo.h hVarJ = qo.a.j(hVar, hVar.f14088a.x(gVar));
        eo.m mVarB = b();
        l0.o(mVarB, "containingDeclaration");
        return new f(hVarJ, mVarB, this.f14620v, eVar);
    }

    @Override // eo.e
    @os.l
    /* JADX INFO: renamed from: I0, reason: merged with bridge method [inline-methods] */
    public List<eo.d> g() {
        return this.L.f14630q.invoke();
    }

    @os.l
    public final uo.g J0() {
        return this.f14620v;
    }

    @os.m
    public final List<uo.a> K0() {
        return (List) this.f14623y.getValue();
    }

    @os.l
    public final qo.h L0() {
        return this.f14619p;
    }

    @os.l
    public g M0() {
        return (g) super.X();
    }

    @Override // ho.t
    @os.l
    /* JADX INFO: renamed from: N0, reason: merged with bridge method [inline-methods] */
    public g Z(@os.l wp.g gVar) {
        l0.p(gVar, "kotlinTypeRefiner");
        return (g) this.M.c(gVar);
    }

    @Override // ho.a, eo.e
    @os.l
    public op.h V() {
        return this.N;
    }

    @Override // ho.a, eo.e
    public op.h X() {
        return (g) super.X();
    }

    @Override // eo.d0
    public boolean Y() {
        return false;
    }

    @Override // eo.e
    public boolean a0() {
        return false;
    }

    @Override // fo.a
    @os.l
    public fo.g getAnnotations() {
        return this.P;
    }

    @Override // eo.e
    @os.l
    public eo.f getKind() {
        return this.f14624z;
    }

    @Override // eo.e, eo.q, eo.d0
    @os.l
    public u getVisibility() {
        if (!l0.g(this.I, t.f4629a) || this.f14620v.l() != null) {
            return no.h0.c(this.I);
        }
        u uVar = r.f11771a;
        l0.o(uVar, "{\n            JavaDescri…KAGE_VISIBILITY\n        }");
        return uVar;
    }

    @Override // eo.h
    @os.l
    public a1 i() {
        return this.K;
    }

    @Override // eo.d0
    public boolean i0() {
        return false;
    }

    @Override // eo.e
    public boolean isInline() {
        return false;
    }

    @Override // eo.e
    @os.l
    public Collection<eo.e> k() {
        if (this.H != e0.SEALED) {
            return k0.INSTANCE;
        }
        so.a aVarD = so.d.d(oo.k.COMMON, false, null, 3, null);
        Collection<uo.j> collectionB = this.f14620v.B();
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = collectionB.iterator();
        while (it.hasNext()) {
            eo.h hVarD = this.f14622x.f14092e.o((uo.j) it.next(), aVarD).G0().d();
            eo.e eVar = hVarD instanceof eo.e ? (eo.e) hVarD : null;
            if (eVar != null) {
                arrayList.add(eVar);
            }
        }
        return arrayList;
    }

    @Override // eo.e
    @os.l
    public op.h k0() {
        return this.O;
    }

    @Override // eo.i
    public boolean l() {
        return this.J;
    }

    @Override // eo.e
    @os.m
    public eo.e l0() {
        return null;
    }

    @Override // eo.e, eo.i
    @os.l
    public List<e1> r() {
        return this.Q.invoke();
    }

    @Override // eo.e, eo.d0
    @os.l
    public e0 s() {
        return this.H;
    }

    @Override // eo.e
    public boolean t() {
        return false;
    }

    @os.l
    public String toString() {
        return l0.C("Lazy Java class ", lp.a.j(this));
    }

    @Override // eo.e
    public boolean u() {
        return false;
    }

    @Override // eo.e
    public boolean x() {
        return false;
    }

    @Override // eo.e
    @os.m
    public eo.z<vp.n0> y() {
        return null;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(@os.l qo.h hVar, @os.l eo.m mVar, @os.l uo.g gVar, @os.m eo.e eVar) {
        e0 e0VarA;
        super(hVar.f14088a.f14055a, mVar, gVar.getName(), hVar.f14088a.f14064j.a(gVar), false);
        l0.p(hVar, "outerContext");
        l0.p(mVar, "containingDeclaration");
        l0.p(gVar, "jClass");
        this.f14619p = hVar;
        this.f14620v = gVar;
        this.f14621w = eVar;
        qo.h hVarD = qo.a.d(hVar, this, gVar, 0, 4, null);
        this.f14622x = hVarD;
        hVarD.f14088a.f14061g.c(gVar, this);
        gVar.I();
        this.f14623y = lm.f0.b(new d());
        this.f14624z = gVar.p() ? eo.f.ANNOTATION_CLASS : gVar.H() ? eo.f.INTERFACE : gVar.w() ? eo.f.ENUM_CLASS : eo.f.CLASS;
        if (gVar.p() || gVar.w()) {
            e0VarA = e0.FINAL;
        } else {
            e0VarA = e0.Companion.a(gVar.c(), gVar.c() || gVar.isAbstract() || gVar.H(), !gVar.isFinal());
        }
        this.H = e0VarA;
        this.I = gVar.getVisibility();
        this.J = (gVar.l() == null || gVar.k()) ? false : true;
        this.K = new b(this);
        g gVar2 = new g(hVarD, this, gVar, eVar != null, null, 16, null);
        this.L = gVar2;
        x0.a aVar = x0.f4646e;
        qo.c cVar = hVarD.f14088a;
        this.M = aVar.a(this, cVar.f14055a, cVar.f14075u.d(), new e());
        this.N = new op.f(gVar2);
        this.O = new k(hVarD, gVar, this);
        this.P = qo.f.a(hVarD, gVar);
        this.Q = hVarD.f14088a.f14055a.h(new c());
    }
}
