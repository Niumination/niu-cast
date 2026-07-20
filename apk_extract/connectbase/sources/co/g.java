package co;

import com.transsion.hubsdk.api.provider.TranSearchIndexablesProvider;
import eo.e0;
import eo.h0;
import eo.j0;
import eo.m;
import eo.s;
import eo.x;
import eo.y0;
import eo.z0;
import ho.z;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kn.g1;
import kn.k1;
import kn.l0;
import kn.l1;
import kn.m1;
import kn.n0;
import nm.k0;
import nm.m0;
import nm.y;
import un.o;
import up.n;
import vp.f0;
import vp.h1;
import vp.i0;
import wo.t;
import wo.u;
import wo.w;

/* JADX INFO: loaded from: classes3.dex */
public final class g implements go.a, go.c {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ o<Object>[] f1720h;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public final h0 f1721a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.l
    public final co.d f1722b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @os.l
    public final up.i f1723c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @os.l
    public final f0 f1724d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @os.l
    public final up.i f1725e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @os.l
    public final up.a<dp.c, eo.e> f1726f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @os.l
    public final up.i f1727g;

    public enum a {
        HIDDEN,
        VISIBLE,
        NOT_CONSIDERED,
        DROP
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f1729a;

        static {
            int[] iArr = new int[a.values().length];
            iArr[a.HIDDEN.ordinal()] = 1;
            iArr[a.NOT_CONSIDERED.ordinal()] = 2;
            iArr[a.DROP.ordinal()] = 3;
            iArr[a.VISIBLE.ordinal()] = 4;
            f1729a = iArr;
        }
    }

    public static final class c extends n0 implements jn.a<vp.n0> {
        final /* synthetic */ n $storageManager;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(n nVar) {
            super(0);
            this.$storageManager = nVar;
        }

        @Override // jn.a
        @os.l
        public final vp.n0 invoke() {
            h0 h0Var = g.this.s().f1717a;
            co.e.f1704d.getClass();
            return x.c(h0Var, co.e.f1708h, new j0(this.$storageManager, g.this.s().f1717a)).q();
        }
    }

    public static final class d extends z {
        public d(h0 h0Var, dp.c cVar) {
            super(h0Var, cVar);
        }

        @os.l
        public op.h.c B0() {
            return op.h.c.f12406b;
        }

        @Override // eo.k0
        public op.h o() {
            return op.h.c.f12406b;
        }
    }

    public static final class e extends n0 implements jn.a<f0> {
        public e() {
            super(0);
        }

        @Override // jn.a
        @os.l
        public final f0 invoke() {
            vp.n0 n0VarI = g.this.f1721a.n().i();
            l0.o(n0VarI, "moduleDescriptor.builtIns.anyType");
            return n0VarI;
        }
    }

    public static final class f extends n0 implements jn.a<eo.e> {
        final /* synthetic */ ro.f $javaAnalogueDescriptor;
        final /* synthetic */ eo.e $kotlinMutableClassIfContainer;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(ro.f fVar, eo.e eVar) {
            super(0);
            this.$javaAnalogueDescriptor = fVar;
            this.$kotlinMutableClassIfContainer = eVar;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // jn.a
        @os.l
        public final eo.e invoke() {
            ro.f fVar = this.$javaAnalogueDescriptor;
            oo.g gVar = oo.g.f12349a;
            l0.o(gVar, "EMPTY");
            return fVar.H0(gVar, this.$kotlinMutableClassIfContainer);
        }
    }

    /* JADX INFO: renamed from: co.g$g, reason: collision with other inner class name */
    public static final class C0073g extends n0 implements jn.l<op.h, Collection<? extends y0>> {
        final /* synthetic */ dp.f $name;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0073g(dp.f fVar) {
            super(1);
            this.$name = fVar;
        }

        @Override // jn.l
        @os.l
        public final Collection<y0> invoke(@os.l op.h hVar) {
            l0.p(hVar, "it");
            return hVar.a(this.$name, mo.d.FROM_BUILTINS);
        }
    }

    public static final class h<N> implements eq.b.d {
        public h() {
        }

        @Override // eq.b.d
        @os.l
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Iterable<eo.e> a(eo.e eVar) {
            Collection<f0> collectionA = eVar.i().a();
            l0.o(collectionA, "it.typeConstructor.supertypes");
            g gVar = g.this;
            ArrayList arrayList = new ArrayList();
            Iterator<T> it = collectionA.iterator();
            while (it.hasNext()) {
                eo.h hVarD = ((f0) it.next()).G0().d();
                eo.h hVarA = hVarD == null ? null : hVarD.a();
                eo.e eVar2 = hVarA instanceof eo.e ? (eo.e) hVarA : null;
                ro.f fVarP = eVar2 != null ? gVar.p(eVar2) : null;
                if (fVarP != null) {
                    arrayList.add(fVarP);
                }
            }
            return arrayList;
        }
    }

    public static final class i extends eq.b.AbstractC0107b<eo.e, a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f1731a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ k1.h<a> f1732b;

        public i(String str, k1.h<a> hVar) {
            this.f1731a = str;
            this.f1732b = hVar;
        }

        /* JADX WARN: Type inference failed for: r0v4, types: [T, co.g$a] */
        /* JADX WARN: Type inference failed for: r0v5, types: [T, co.g$a] */
        /* JADX WARN: Type inference failed for: r0v6, types: [T, co.g$a] */
        @Override // eq.b.AbstractC0107b, eq.b.e
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public boolean b(@os.l eo.e eVar) {
            l0.p(eVar, "javaClassDescriptor");
            String strA = t.a(w.f19826a, eVar, this.f1731a);
            co.i iVar = co.i.f1735a;
            iVar.getClass();
            if (co.i.f1737c.contains(strA)) {
                this.f1732b.element = a.HIDDEN;
            } else {
                iVar.getClass();
                if (co.i.f1738d.contains(strA)) {
                    this.f1732b.element = a.VISIBLE;
                } else {
                    iVar.getClass();
                    if (co.i.f1736b.contains(strA)) {
                        this.f1732b.element = a.DROP;
                    }
                }
            }
            return this.f1732b.element == null;
        }

        @Override // eq.b.e
        @os.l
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public a result() {
            a aVar = this.f1732b.element;
            return aVar == null ? a.NOT_CONSIDERED : aVar;
        }
    }

    public static final class j<N> implements eq.b.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final j<N> f1733a = new j<>();

        @Override // eq.b.d
        @os.l
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Iterable<eo.b> a(eo.b bVar) {
            return bVar.a().d();
        }
    }

    public static final class k extends n0 implements jn.l<eo.b, Boolean> {
        public k() {
            super(1);
        }

        @Override // jn.l
        public final Boolean invoke(eo.b bVar) {
            return Boolean.valueOf(bVar.getKind() == eo.b.a.DECLARATION && g.this.f1722b.c((eo.e) bVar.b()));
        }
    }

    public static final class l extends n0 implements jn.a<fo.g> {
        public l() {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // jn.a
        @os.l
        public final fo.g invoke() {
            return fo.g.f6167h.a(nm.x.k(fo.f.b(g.this.f1721a.n(), "This member is not fully supported by Kotlin compiler, so it may be absent or have different signature in next major version", null, null, 6, null)));
        }
    }

    static {
        g1 g1Var = new g1(l1.d(g.class), TranSearchIndexablesProvider.f2243v, "getSettings()Lorg/jetbrains/kotlin/builtins/jvm/JvmBuiltIns$Settings;");
        m1 m1Var = l1.f9319a;
        f1720h = new o[]{m1Var.n(g1Var), m1Var.n(new g1(m1Var.d(g.class), "cloneableType", "getCloneableType()Lorg/jetbrains/kotlin/types/SimpleType;")), m1Var.n(new g1(m1Var.d(g.class), "notConsideredDeprecation", "getNotConsideredDeprecation()Lorg/jetbrains/kotlin/descriptors/annotations/Annotations;"))};
    }

    public g(@os.l h0 h0Var, @os.l n nVar, @os.l jn.a<co.f.b> aVar) {
        l0.p(h0Var, "moduleDescriptor");
        l0.p(nVar, "storageManager");
        l0.p(aVar, "settingsComputation");
        this.f1721a = h0Var;
        this.f1722b = co.d.f1703a;
        this.f1723c = nVar.h(aVar);
        this.f1724d = k(nVar);
        this.f1725e = nVar.h(new c(nVar));
        this.f1726f = nVar.b();
        this.f1727g = nVar.h(new l());
    }

    public static final boolean n(eo.l lVar, h1 h1Var, eo.l lVar2) {
        return hp.j.y(lVar, lVar2.c(h1Var)) == hp.j.i.a.OVERRIDABLE;
    }

    @Override // go.a
    @os.l
    public Collection<f0> a(@os.l eo.e eVar) {
        l0.p(eVar, "classDescriptor");
        dp.d dVarJ = lp.a.j(eVar);
        co.i iVar = co.i.f1735a;
        if (!iVar.i(dVarJ)) {
            return iVar.j(dVarJ) ? nm.x.k(this.f1724d) : k0.INSTANCE;
        }
        vp.n0 n0VarM = m();
        l0.o(n0VarM, "cloneableType");
        return y.O(n0VarM, this.f1724d);
    }

    @Override // go.a
    @os.l
    public Collection<y0> b(@os.l dp.f fVar, @os.l eo.e eVar) {
        l0.p(fVar, "name");
        l0.p(eVar, "classDescriptor");
        co.a.f1681e.getClass();
        if (l0.g(fVar, co.a.f1682f) && (eVar instanceof tp.e) && ao.h.d0(eVar)) {
            tp.e eVar2 = (tp.e) eVar;
            List<yo.a.i> functionList = eVar2.f15956g.getFunctionList();
            l0.o(functionList, "classDescriptor.classProto.functionList");
            List<yo.a.i> list = functionList;
            if (!(list instanceof Collection) || !list.isEmpty()) {
                Iterator<T> it = list.iterator();
                while (it.hasNext()) {
                    dp.f fVarB = rp.x.b(eVar2.f15963y.f14749b, ((yo.a.i) it.next()).getName());
                    co.a.f1681e.getClass();
                    if (l0.g(fVarB, co.a.f1682f)) {
                        return k0.INSTANCE;
                    }
                }
            }
            return nm.x.k(j(eVar2, (y0) nm.h0.f5(m().o().a(fVar, mo.d.FROM_BUILTINS))));
        }
        if (!s().f1718b) {
            return k0.INSTANCE;
        }
        Collection<y0> collectionL = l(eVar, new C0073g(fVar));
        ArrayList arrayList = new ArrayList();
        for (y0 y0Var : collectionL) {
            eo.y yVarC = y0Var.c(co.j.a((eo.e) y0Var.b(), eVar).c());
            if (yVarC == null) {
                throw new NullPointerException("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.SimpleFunctionDescriptor");
            }
            eo.y.a<? extends y0> aVarW = ((y0) yVarC).w();
            aVarW.n(eVar);
            aVarW.g(eVar.D0());
            aVarW.i();
            int i10 = b.f1729a[q(y0Var).ordinal()];
            y0 y0Var2 = null;
            if (i10 != 1) {
                if (i10 == 2) {
                    aVarW.k(r());
                } else if (i10 != 3) {
                }
                eo.y yVarBuild = aVarW.build();
                l0.m(yVarBuild);
                y0Var2 = (y0) yVarBuild;
            } else if (!eo.f0.a(eVar)) {
                aVarW.d();
                eo.y yVarBuild2 = aVarW.build();
                l0.m(yVarBuild2);
                y0Var2 = (y0) yVarBuild2;
            }
            if (y0Var2 != null) {
                arrayList.add(y0Var2);
            }
        }
        return arrayList;
    }

    @Override // go.c
    public boolean c(@os.l eo.e eVar, @os.l y0 y0Var) {
        l0.p(eVar, "classDescriptor");
        l0.p(y0Var, "functionDescriptor");
        ro.f fVarP = p(eVar);
        if (fVarP == null || !y0Var.getAnnotations().p(go.d.a())) {
            return true;
        }
        if (!s().f1718b) {
            return false;
        }
        String strC = u.c(y0Var, false, false, 3, null);
        ro.g gVarM0 = fVarP.M0();
        dp.f name = y0Var.getName();
        l0.o(name, "functionDescriptor.name");
        Collection<y0> collectionA = gVarM0.a(name, mo.d.FROM_BUILTINS);
        if (!(collectionA instanceof Collection) || !collectionA.isEmpty()) {
            Iterator<T> it = collectionA.iterator();
            while (it.hasNext()) {
                if (l0.g(u.c((y0) it.next(), false, false, 3, null), strC)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // go.a
    @os.l
    public Collection<eo.d> e(@os.l eo.e eVar) {
        l0.p(eVar, "classDescriptor");
        if (eVar.getKind() != eo.f.CLASS || !s().f1718b) {
            return k0.INSTANCE;
        }
        ro.f fVarP = p(eVar);
        if (fVarP == null) {
            return k0.INSTANCE;
        }
        co.d dVar = this.f1722b;
        dp.c cVarI = lp.a.i(fVarP);
        co.b.f1683i.getClass();
        eo.e eVarH = co.d.h(dVar, cVarI, co.b.f1684j, null, 4, null);
        if (eVarH == null) {
            return k0.INSTANCE;
        }
        h1 h1VarC = co.j.a(eVarH, fVarP).c();
        List<eo.d> listG = fVarP.g();
        ArrayList<eo.d> arrayList = new ArrayList();
        for (Object obj : listG) {
            eo.d dVar2 = (eo.d) obj;
            if (dVar2.getVisibility().b().f4624b) {
                Collection<eo.d> collectionG = eVarH.g();
                l0.o(collectionG, "defaultKotlinVersion.constructors");
                Collection<eo.d> collection = collectionG;
                if (!collection.isEmpty()) {
                    Iterator<T> it = collection.iterator();
                    while (true) {
                        if (it.hasNext()) {
                            eo.d dVar3 = (eo.d) it.next();
                            l0.o(dVar3, "it");
                            if (n(dVar3, h1VarC, dVar2)) {
                            }
                        }
                    }
                }
                if (!u(dVar2, eVar) && !ao.h.i0(dVar2)) {
                    co.i.f1735a.getClass();
                    if (!co.i.f1740f.contains(t.a(w.f19826a, fVarP, u.c(dVar2, false, false, 3, null)))) {
                        arrayList.add(obj);
                    }
                }
            }
        }
        ArrayList arrayList2 = new ArrayList(nm.z.b0(arrayList, 10));
        for (eo.d dVar4 : arrayList) {
            eo.y.a<? extends eo.y> aVarW = dVar4.w();
            aVarW.n(eVar);
            aVarW.q(eVar.q());
            aVarW.i();
            aVarW.s(h1VarC.j());
            co.i.f1735a.getClass();
            if (!co.i.f1741g.contains(t.a(w.f19826a, fVarP, u.c(dVar4, false, false, 3, null)))) {
                aVarW.k(r());
            }
            eo.y yVarBuild = aVarW.build();
            if (yVarBuild == null) {
                throw new NullPointerException("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassConstructorDescriptor");
            }
            arrayList2.add((eo.d) yVarBuild);
        }
        return arrayList2;
    }

    public final y0 j(tp.e eVar, y0 y0Var) {
        eo.y.a<? extends y0> aVarW = y0Var.w();
        aVarW.n(eVar);
        aVarW.l(eo.t.f4633e);
        aVarW.q(eVar.q());
        aVarW.g(eVar.D0());
        eo.y yVarBuild = aVarW.build();
        l0.m(yVarBuild);
        return (y0) yVarBuild;
    }

    public final f0 k(n nVar) {
        ho.h hVar = new ho.h(new d(this.f1721a, new dp.c("java.io")), dp.f.k("Serializable"), e0.ABSTRACT, eo.f.INTERFACE, nm.x.k(new i0(nVar, new e())), z0.f4654a, false, nVar);
        hVar.E0(op.h.c.f12406b, m0.INSTANCE, null);
        vp.n0 n0VarQ = hVar.q();
        l0.o(n0VarQ, "mockSerializableClass.defaultType");
        return n0VarQ;
    }

    public final Collection<y0> l(eo.e eVar, jn.l<? super op.h, ? extends Collection<? extends y0>> lVar) {
        ro.f fVarP = p(eVar);
        if (fVarP == null) {
            return k0.INSTANCE;
        }
        co.d dVar = this.f1722b;
        dp.c cVarI = lp.a.i(fVarP);
        co.b.f1683i.getClass();
        Collection<eo.e> collectionI = dVar.i(cVarI, co.b.f1684j);
        eo.e eVar2 = (eo.e) nm.h0.t3(collectionI);
        if (eVar2 == null) {
            return k0.INSTANCE;
        }
        eq.f.b bVar = eq.f.f4674c;
        ArrayList arrayList = new ArrayList(nm.z.b0(collectionI, 10));
        Iterator<T> it = collectionI.iterator();
        while (it.hasNext()) {
            arrayList.add(lp.a.i((eo.e) it.next()));
        }
        eq.f fVarB = bVar.b(arrayList);
        boolean zC = this.f1722b.c(eVar);
        op.h hVarX = this.f1726f.a(lp.a.i(fVarP), new f(fVarP, eVar2)).X();
        l0.o(hVarX, "fakeJavaClassDescriptor.unsubstitutedMemberScope");
        Collection<? extends y0> collectionInvoke = lVar.invoke(hVarX);
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : collectionInvoke) {
            y0 y0Var = (y0) obj;
            if (y0Var.getKind() == eo.b.a.DECLARATION && y0Var.getVisibility().b().f4624b && !ao.h.i0(y0Var)) {
                Collection<? extends eo.y> collectionD = y0Var.d();
                l0.o(collectionD, "analogueMember.overriddenDescriptors");
                Collection<? extends eo.y> collection = collectionD;
                if (!collection.isEmpty()) {
                    Iterator<T> it2 = collection.iterator();
                    while (true) {
                        if (it2.hasNext()) {
                            m mVarB = ((eo.y) it2.next()).b();
                            l0.o(mVarB, "it.containingDeclaration");
                            if (fVarB.contains(lp.a.i(mVarB))) {
                            }
                        }
                    }
                }
                if (!t(y0Var, zC)) {
                    arrayList2.add(obj);
                }
            }
        }
        return arrayList2;
    }

    public final vp.n0 m() {
        return (vp.n0) up.m.a(this.f1725e, this, f1720h[1]);
    }

    @Override // go.a
    @os.l
    /* JADX INFO: renamed from: o, reason: merged with bridge method [inline-methods] */
    public Set<dp.f> d(@os.l eo.e eVar) {
        ro.f fVarP;
        l0.p(eVar, "classDescriptor");
        if (s().f1718b && (fVarP = p(eVar)) != null) {
            return fVarP.M0().B();
        }
        return m0.INSTANCE;
    }

    public final ro.f p(eo.e eVar) {
        dp.b bVarO;
        if (ao.h.a0(eVar) || !ao.h.z0(eVar)) {
            return null;
        }
        dp.d dVarJ = lp.a.j(eVar);
        if (!dVarJ.f() || (bVarO = co.c.f1685a.o(dVarJ)) == null) {
            return null;
        }
        dp.c cVarB = bVarO.b();
        l0.o(cVarB, "JavaToKotlinClassMap.map…leFqName() ?: return null");
        eo.e eVarC = s.c(s().f1717a, cVarB, mo.d.FROM_BUILTINS);
        if (eVarC instanceof ro.f) {
            return (ro.f) eVarC;
        }
        return null;
    }

    public final a q(eo.y yVar) {
        Object objB = eq.b.b(nm.x.k((eo.e) yVar.b()), new h(), new i(u.c(yVar, false, false, 3, null), new k1.h()));
        l0.o(objB, "private fun FunctionDesc…ERED\n            })\n    }");
        return (a) objB;
    }

    public final fo.g r() {
        return (fo.g) up.m.a(this.f1727g, this, f1720h[2]);
    }

    public final co.f.b s() {
        return (co.f.b) up.m.a(this.f1723c, this, f1720h[0]);
    }

    public final boolean t(y0 y0Var, boolean z10) {
        eo.e eVar = (eo.e) y0Var.b();
        String strC = u.c(y0Var, false, false, 3, null);
        co.i.f1735a.getClass();
        if (z10 ^ co.i.f1739e.contains(t.a(w.f19826a, eVar, strC))) {
            return true;
        }
        Boolean boolE = eq.b.e(nm.x.k(y0Var), j.f1733a, new k());
        l0.o(boolE, "private fun SimpleFuncti…scriptor)\n        }\n    }");
        return boolE.booleanValue();
    }

    public final boolean u(eo.l lVar, eo.e eVar) {
        if (lVar.h().size() == 1) {
            List<eo.h1> listH = lVar.h();
            l0.o(listH, "valueParameters");
            eo.h hVarD = ((eo.h1) nm.h0.h5(listH)).getType().G0().d();
            if (l0.g(hVarD == null ? null : lp.a.j(hVarD), lp.a.j(eVar))) {
                return true;
            }
        }
        return false;
    }
}
