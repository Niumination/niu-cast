package wo;

import el.b0;
import eo.z0;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jq.e0;
import jq.h0;
import kn.l0;
import kn.n0;
import nm.k0;
import vp.f0;

/* JADX INFO: loaded from: classes3.dex */
public abstract class a<A, C> implements rp.c<A, C> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public final n f19737a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.l
    public final up.g<p, b<A, C>> f19738b;

    /* JADX INFO: renamed from: wo.a$a, reason: collision with other inner class name */
    public enum EnumC0486a {
        PROPERTY,
        BACKING_FIELD,
        DELEGATE_FIELD
    }

    public static final class b<A, C> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @os.l
        public final Map<s, List<A>> f19740a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @os.l
        public final Map<s, C> f19741b;

        /* JADX WARN: Multi-variable type inference failed */
        public b(@os.l Map<s, ? extends List<? extends A>> map, @os.l Map<s, ? extends C> map2) {
            l0.p(map, "memberAnnotations");
            l0.p(map2, "propertyConstants");
            this.f19740a = map;
            this.f19741b = map2;
        }

        @os.l
        public final Map<s, List<A>> a() {
            return this.f19740a;
        }

        @os.l
        public final Map<s, C> b() {
            return this.f19741b;
        }
    }

    public /* synthetic */ class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f19742a;

        static {
            int[] iArr = new int[rp.b.values().length];
            iArr[rp.b.PROPERTY_GETTER.ordinal()] = 1;
            iArr[rp.b.PROPERTY_SETTER.ordinal()] = 2;
            iArr[rp.b.PROPERTY.ordinal()] = 3;
            f19742a = iArr;
        }
    }

    public static final class d implements p.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a<A, C> f19743a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ HashMap<s, List<A>> f19744b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ HashMap<s, C> f19745c;

        /* JADX INFO: renamed from: wo.a$d$a, reason: collision with other inner class name */
        public final class C0487a extends b implements p.e {

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public final /* synthetic */ d f19746d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C0487a(@os.l d dVar, s sVar) {
                super(dVar, sVar);
                l0.p(dVar, "this$0");
                l0.p(sVar, "signature");
                this.f19746d = dVar;
            }

            @Override // wo.p.e
            @os.m
            public p.a c(int i10, @os.l dp.b bVar, @os.l z0 z0Var) {
                l0.p(bVar, "classId");
                l0.p(z0Var, "source");
                s sVarE = s.f19823b.e(this.f19747a, i10);
                List<A> arrayList = this.f19746d.f19744b.get(sVarE);
                if (arrayList == null) {
                    arrayList = new ArrayList<>();
                    this.f19746d.f19744b.put(sVarE, arrayList);
                }
                return this.f19746d.f19743a.z(bVar, z0Var, arrayList);
            }
        }

        public class b implements p.c {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            @os.l
            public final s f19747a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            @os.l
            public final ArrayList<A> f19748b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ d f19749c;

            public b(@os.l d dVar, s sVar) {
                l0.p(dVar, "this$0");
                l0.p(sVar, "signature");
                this.f19749c = dVar;
                this.f19747a = sVar;
                this.f19748b = new ArrayList<>();
            }

            @Override // wo.p.c
            public void a() {
                if (this.f19748b.isEmpty()) {
                    return;
                }
                this.f19749c.f19744b.put(this.f19747a, this.f19748b);
            }

            @Override // wo.p.c
            @os.m
            public p.a b(@os.l dp.b bVar, @os.l z0 z0Var) {
                l0.p(bVar, "classId");
                l0.p(z0Var, "source");
                return this.f19749c.f19743a.z(bVar, z0Var, this.f19748b);
            }

            @os.l
            public final s d() {
                return this.f19747a;
            }
        }

        public d(a<A, C> aVar, HashMap<s, List<A>> map, HashMap<s, C> map2) {
            this.f19743a = aVar;
            this.f19744b = map;
            this.f19745c = map2;
        }

        @Override // wo.p.d
        @os.m
        public p.c a(@os.l dp.f fVar, @os.l String str, @os.m Object obj) {
            C cB;
            l0.p(fVar, "name");
            l0.p(str, "desc");
            s.a aVar = s.f19823b;
            String strB = fVar.b();
            l0.o(strB, "name.asString()");
            s sVarA = aVar.a(strB, str);
            if (obj != null && (cB = this.f19743a.B(str, obj)) != null) {
                this.f19745c.put(sVarA, cB);
            }
            return new b(this, sVarA);
        }

        @Override // wo.p.d
        @os.m
        public p.e b(@os.l dp.f fVar, @os.l String str) {
            l0.p(fVar, "name");
            l0.p(str, "desc");
            s.a aVar = s.f19823b;
            String strB = fVar.b();
            l0.o(strB, "name.asString()");
            return new C0487a(this, aVar.d(strB, str));
        }
    }

    public static final class e implements p.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a<A, C> f19750a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ArrayList<A> f19751b;

        public e(a<A, C> aVar, ArrayList<A> arrayList) {
            this.f19750a = aVar;
            this.f19751b = arrayList;
        }

        @Override // wo.p.c
        public void a() {
        }

        @Override // wo.p.c
        @os.m
        public p.a b(@os.l dp.b bVar, @os.l z0 z0Var) {
            l0.p(bVar, "classId");
            l0.p(z0Var, "source");
            return this.f19750a.z(bVar, z0Var, this.f19751b);
        }
    }

    public static final class f extends n0 implements jn.l<p, b<? extends A, ? extends C>> {
        final /* synthetic */ a<A, C> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(a<A, C> aVar) {
            super(1);
            this.this$0 = aVar;
        }

        @Override // jn.l
        @os.l
        public final b<A, C> invoke(@os.l p pVar) {
            l0.p(pVar, "kotlinClass");
            return this.this$0.A(pVar);
        }
    }

    public a(@os.l up.n nVar, @os.l n nVar2) {
        l0.p(nVar, "storageManager");
        l0.p(nVar2, "kotlinClassFinder");
        this.f19737a = nVar2;
        this.f19738b = nVar.a(new f(this));
    }

    public static /* synthetic */ List o(a aVar, rp.z zVar, s sVar, boolean z10, boolean z11, Boolean bool, boolean z12, int i10, Object obj) {
        if (obj == null) {
            return aVar.n(zVar, sVar, (i10 & 4) != 0 ? false : z10, (i10 & 8) != 0 ? false : z11, (i10 & 16) != 0 ? null : bool, (i10 & 32) != 0 ? false : z12);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: findClassAndLoadMemberAnnotations");
    }

    public static /* synthetic */ s s(a aVar, fp.q qVar, ap.c cVar, ap.g gVar, rp.b bVar, boolean z10, int i10, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getCallableSignature");
        }
        if ((i10 & 16) != 0) {
            z10 = false;
        }
        return aVar.r(qVar, cVar, gVar, bVar, z10);
    }

    public static /* synthetic */ s u(a aVar, yo.a.n nVar, ap.c cVar, ap.g gVar, boolean z10, boolean z11, boolean z12, int i10, Object obj) {
        if (obj == null) {
            return aVar.t(nVar, cVar, gVar, (i10 & 8) != 0 ? false : z10, (i10 & 16) != 0 ? false : z11, (i10 & 32) != 0 ? true : z12);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getPropertySignature");
    }

    public final b<A, C> A(p pVar) {
        HashMap map = new HashMap();
        HashMap map2 = new HashMap();
        pVar.a(new d(this, map, map2), q(pVar));
        return new b<>(map, map2);
    }

    @os.m
    public abstract C B(@os.l String str, @os.l Object obj);

    public final List<A> C(rp.z zVar, yo.a.n nVar, EnumC0486a enumC0486a) {
        Boolean boolD = ap.b.A.d(nVar.getFlags());
        l0.o(boolD, "IS_CONST.get(proto.flags)");
        boolD.booleanValue();
        boolean zF = cp.g.f(nVar);
        if (enumC0486a == EnumC0486a.PROPERTY) {
            s sVarU = u(this, nVar, zVar.f14779a, zVar.f14780b, false, true, false, 40, null);
            return sVarU == null ? k0.INSTANCE : o(this, zVar, sVarU, true, false, boolD, zF, 8, null);
        }
        s sVarU2 = u(this, nVar, zVar.f14779a, zVar.f14780b, true, false, false, 48, null);
        if (sVarU2 == null) {
            return k0.INSTANCE;
        }
        return h0.T2(sVarU2.f19824a, "$delegate", false, 2, null) != (enumC0486a == EnumC0486a.DELEGATE_FIELD) ? k0.INSTANCE : n(zVar, sVarU2, true, true, boolD, zF);
    }

    @os.l
    public abstract A D(@os.l yo.a.b bVar, @os.l ap.c cVar);

    public final p E(rp.z.a aVar) {
        z0 z0Var = aVar.f14781c;
        r rVar = z0Var instanceof r ? (r) z0Var : null;
        if (rVar == null) {
            return null;
        }
        return rVar.f19819b;
    }

    @os.m
    public abstract C F(@os.l C c10);

    @Override // rp.c
    @os.l
    public List<A> a(@os.l rp.z zVar, @os.l yo.a.g gVar) {
        l0.p(zVar, "container");
        l0.p(gVar, "proto");
        s.a aVar = s.f19823b;
        String strC = zVar.f14779a.c(gVar.getName());
        String strC2 = ((rp.z.a) zVar).f14784f.c();
        l0.o(strC2, "container as ProtoContai…Class).classId.asString()");
        return o(this, zVar, aVar.a(strC, cp.b.b(strC2)), false, false, null, false, 60, null);
    }

    @Override // rp.c
    @os.l
    public List<A> b(@os.l rp.z zVar, @os.l fp.q qVar, @os.l rp.b bVar) {
        l0.p(zVar, "container");
        l0.p(qVar, "proto");
        l0.p(bVar, "kind");
        s sVarS = s(this, qVar, zVar.f14779a, zVar.f14780b, bVar, false, 16, null);
        return sVarS != null ? o(this, zVar, s.f19823b.e(sVarS, 0), false, false, null, false, 60, null) : k0.INSTANCE;
    }

    @Override // rp.c
    @os.l
    public List<A> c(@os.l rp.z zVar, @os.l yo.a.n nVar) {
        l0.p(zVar, "container");
        l0.p(nVar, "proto");
        return C(zVar, nVar, EnumC0486a.BACKING_FIELD);
    }

    @Override // rp.c
    @os.l
    public List<A> d(@os.l rp.z zVar, @os.l fp.q qVar, @os.l rp.b bVar, int i10, @os.l yo.a.u uVar) {
        l0.p(zVar, "container");
        l0.p(qVar, "callableProto");
        l0.p(bVar, "kind");
        l0.p(uVar, "proto");
        s sVarS = s(this, qVar, zVar.f14779a, zVar.f14780b, bVar, false, 16, null);
        if (sVarS == null) {
            return k0.INSTANCE;
        }
        return o(this, zVar, s.f19823b.e(sVarS, m(zVar, qVar) + i10), false, false, null, false, 60, null);
    }

    @Override // rp.c
    @os.l
    public List<A> e(@os.l yo.a.q qVar, @os.l ap.c cVar) {
        l0.p(qVar, "proto");
        l0.p(cVar, "nameResolver");
        Object extension = qVar.getExtension(bp.a.f1008f);
        l0.o(extension, "proto.getExtension(JvmProtoBuf.typeAnnotation)");
        Iterable<yo.a.b> iterable = (Iterable) extension;
        ArrayList arrayList = new ArrayList(nm.z.b0(iterable, 10));
        for (yo.a.b bVar : iterable) {
            l0.o(bVar, "it");
            arrayList.add(D(bVar, cVar));
        }
        return arrayList;
    }

    @Override // rp.c
    @os.l
    public List<A> f(@os.l rp.z zVar, @os.l fp.q qVar, @os.l rp.b bVar) {
        l0.p(zVar, "container");
        l0.p(qVar, "proto");
        l0.p(bVar, "kind");
        if (bVar == rp.b.PROPERTY) {
            return C(zVar, (yo.a.n) qVar, EnumC0486a.PROPERTY);
        }
        s sVarS = s(this, qVar, zVar.f14779a, zVar.f14780b, bVar, false, 16, null);
        return sVarS == null ? k0.INSTANCE : o(this, zVar, sVarS, false, false, null, false, 60, null);
    }

    @Override // rp.c
    @os.l
    public List<A> g(@os.l rp.z.a aVar) {
        l0.p(aVar, "container");
        p pVarE = E(aVar);
        if (pVarE == null) {
            throw new IllegalStateException(l0.C("Class for loading annotations is not found: ", aVar.a()).toString());
        }
        ArrayList arrayList = new ArrayList(1);
        pVarE.c(new e(this, arrayList), q(pVarE));
        return arrayList;
    }

    @Override // rp.c
    @os.l
    public List<A> h(@os.l rp.z zVar, @os.l yo.a.n nVar) {
        l0.p(zVar, "container");
        l0.p(nVar, "proto");
        return C(zVar, nVar, EnumC0486a.DELEGATE_FIELD);
    }

    @Override // rp.c
    @os.m
    public C i(@os.l rp.z zVar, @os.l yo.a.n nVar, @os.l f0 f0Var) {
        C c10;
        l0.p(zVar, "container");
        l0.p(nVar, "proto");
        l0.p(f0Var, "expectedType");
        p pVarP = p(zVar, v(zVar, true, true, ap.b.A.d(nVar.getFlags()), cp.g.f(nVar)));
        if (pVarP == null) {
            return null;
        }
        cp.e eVar = pVarP.b().f20439b;
        wo.f.f19781b.getClass();
        s sVarR = r(nVar, zVar.f14779a, zVar.f14780b, rp.b.PROPERTY, eVar.d(wo.f.f19786g));
        if (sVarR == null || (c10 = this.f19738b.invoke(pVarP).f19741b.get(sVarR)) == null) {
            return null;
        }
        return ao.o.d(f0Var) ? F(c10) : c10;
    }

    @Override // rp.c
    @os.l
    public List<A> j(@os.l yo.a.s sVar, @os.l ap.c cVar) {
        l0.p(sVar, "proto");
        l0.p(cVar, "nameResolver");
        Object extension = sVar.getExtension(bp.a.f1010h);
        l0.o(extension, "proto.getExtension(JvmPr….typeParameterAnnotation)");
        Iterable<yo.a.b> iterable = (Iterable) extension;
        ArrayList arrayList = new ArrayList(nm.z.b0(iterable, 10));
        for (yo.a.b bVar : iterable) {
            l0.o(bVar, "it");
            arrayList.add(D(bVar, cVar));
        }
        return arrayList;
    }

    public final int m(rp.z zVar, fp.q qVar) {
        if (qVar instanceof yo.a.i) {
            if (!ap.f.d((yo.a.i) qVar)) {
                return 0;
            }
        } else if (qVar instanceof yo.a.n) {
            if (!ap.f.e((yo.a.n) qVar)) {
                return 0;
            }
        } else {
            if (!(qVar instanceof yo.a.d)) {
                throw new UnsupportedOperationException(l0.C("Unsupported message: ", qVar.getClass()));
            }
            rp.z.a aVar = (rp.z.a) zVar;
            if (aVar.f14785g == yo.a.c.EnumC0567c.ENUM_CLASS) {
                return 2;
            }
            if (!aVar.f14786h) {
                return 0;
            }
        }
        return 1;
    }

    public final List<A> n(rp.z zVar, s sVar, boolean z10, boolean z11, Boolean bool, boolean z12) {
        List<A> list;
        p pVarP = p(zVar, v(zVar, z10, z11, bool, z12));
        return (pVarP == null || (list = this.f19738b.invoke(pVarP).f19740a.get(sVar)) == null) ? k0.INSTANCE : list;
    }

    public final p p(rp.z zVar, p pVar) {
        if (pVar != null) {
            return pVar;
        }
        if (zVar instanceof rp.z.a) {
            return E((rp.z.a) zVar);
        }
        return null;
    }

    @os.m
    public byte[] q(@os.l p pVar) {
        l0.p(pVar, "kotlinClass");
        return null;
    }

    public final s r(fp.q qVar, ap.c cVar, ap.g gVar, rp.b bVar, boolean z10) {
        if (qVar instanceof yo.a.d) {
            s.a aVar = s.f19823b;
            cp.d.b bVarB = cp.g.f3382a.b((yo.a.d) qVar, cVar, gVar);
            if (bVarB == null) {
                return null;
            }
            return aVar.b(bVarB);
        }
        if (qVar instanceof yo.a.i) {
            s.a aVar2 = s.f19823b;
            cp.d.b bVarE = cp.g.f3382a.e((yo.a.i) qVar, cVar, gVar);
            if (bVarE == null) {
                return null;
            }
            return aVar2.b(bVarE);
        }
        if (!(qVar instanceof yo.a.n)) {
            return null;
        }
        fp.i.g<yo.a.n, bp.a.d> gVar2 = bp.a.f1006d;
        l0.o(gVar2, "propertySignature");
        bp.a.d dVar = (bp.a.d) ap.e.a((fp.i.d) qVar, gVar2);
        if (dVar == null) {
            return null;
        }
        int i10 = c.f19742a[bVar.ordinal()];
        if (i10 == 1) {
            if (!dVar.hasGetter()) {
                return null;
            }
            s.a aVar3 = s.f19823b;
            bp.a.c getter = dVar.getGetter();
            l0.o(getter, "signature.getter");
            return aVar3.c(cVar, getter);
        }
        if (i10 != 2) {
            if (i10 != 3) {
                return null;
            }
            return t((yo.a.n) qVar, cVar, gVar, true, true, z10);
        }
        if (!dVar.hasSetter()) {
            return null;
        }
        s.a aVar4 = s.f19823b;
        bp.a.c setter = dVar.getSetter();
        l0.o(setter, "signature.setter");
        return aVar4.c(cVar, setter);
    }

    public final s t(yo.a.n nVar, ap.c cVar, ap.g gVar, boolean z10, boolean z11, boolean z12) {
        fp.i.g<yo.a.n, bp.a.d> gVar2 = bp.a.f1006d;
        l0.o(gVar2, "propertySignature");
        bp.a.d dVar = (bp.a.d) ap.e.a(nVar, gVar2);
        if (dVar == null) {
            return null;
        }
        if (z10) {
            cp.d.a aVarC = cp.g.f3382a.c(nVar, cVar, gVar, z12);
            if (aVarC == null) {
                return null;
            }
            return s.f19823b.b(aVarC);
        }
        if (!z11 || !dVar.hasSyntheticMethod()) {
            return null;
        }
        s.a aVar = s.f19823b;
        bp.a.c syntheticMethod = dVar.getSyntheticMethod();
        l0.o(syntheticMethod, "signature.syntheticMethod");
        return aVar.c(cVar, syntheticMethod);
    }

    public final p v(rp.z zVar, boolean z10, boolean z11, Boolean bool, boolean z12) {
        rp.z.a aVar;
        yo.a.c.EnumC0567c enumC0567c;
        if (z10) {
            if (bool == null) {
                throw new IllegalStateException(("isConst should not be null for property (container=" + zVar + ')').toString());
            }
            if (zVar instanceof rp.z.a) {
                rp.z.a aVar2 = (rp.z.a) zVar;
                if (aVar2.f14785g == yo.a.c.EnumC0567c.INTERFACE) {
                    n nVar = this.f19737a;
                    dp.b bVarD = aVar2.f14784f.d(dp.f.k("DefaultImpls"));
                    l0.o(bVarD, "container.classId.create…EFAULT_IMPLS_CLASS_NAME))");
                    return o.a(nVar, bVarD);
                }
            }
            if (bool.booleanValue() && (zVar instanceof rp.z.b)) {
                z0 z0Var = zVar.f14781c;
                j jVar = z0Var instanceof j ? (j) z0Var : null;
                mp.d dVar = jVar == null ? null : jVar.f19795c;
                if (dVar != null) {
                    n nVar2 = this.f19737a;
                    String strF = dVar.f();
                    l0.o(strF, "facadeClassName.internalName");
                    dp.b bVarM = dp.b.m(new dp.c(e0.h2(strF, b0.f4502a, n1.e.f11183c, false, 4, null)));
                    l0.o(bVarM, "topLevel(FqName(facadeCl…lName.replace('/', '.')))");
                    return o.a(nVar2, bVarM);
                }
            }
        }
        if (z11 && (zVar instanceof rp.z.a)) {
            rp.z.a aVar3 = (rp.z.a) zVar;
            if (aVar3.f14785g == yo.a.c.EnumC0567c.COMPANION_OBJECT && (aVar = aVar3.f14783e) != null && ((enumC0567c = aVar.f14785g) == yo.a.c.EnumC0567c.CLASS || enumC0567c == yo.a.c.EnumC0567c.ENUM_CLASS || (z12 && (enumC0567c == yo.a.c.EnumC0567c.INTERFACE || enumC0567c == yo.a.c.EnumC0567c.ANNOTATION_CLASS)))) {
                return E(aVar);
            }
        }
        if (zVar instanceof rp.z.b) {
            z0 z0Var2 = zVar.f14781c;
            if (z0Var2 instanceof j) {
                if (z0Var2 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type org.jetbrains.kotlin.load.kotlin.JvmPackagePartSource");
                }
                j jVar2 = (j) z0Var2;
                p pVar = jVar2.f19799g;
                return pVar == null ? o.a(this.f19737a, jVar2.d()) : pVar;
            }
        }
        return null;
    }

    public final boolean w(@os.l dp.b bVar) {
        p pVarA;
        l0.p(bVar, "classId");
        return bVar.g() != null && l0.g(bVar.j().b(), "Container") && (pVarA = o.a(this.f19737a, bVar)) != null && zn.a.f21945a.c(pVarA);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean x(@os.l dp.b bVar, @os.l Map<dp.f, ? extends jp.g<?>> map) {
        l0.p(bVar, "annotationClassId");
        l0.p(map, "arguments");
        zn.a.f21945a.getClass();
        if (!l0.g(bVar, zn.a.f21947c)) {
            return false;
        }
        jp.g<?> gVar = map.get(dp.f.k("value"));
        jp.q qVar = gVar instanceof jp.q ? (jp.q) gVar : null;
        if (qVar == null) {
            return false;
        }
        T t10 = qVar.f8774a;
        jp.q.b.C0228b c0228b = t10 instanceof jp.q.b.C0228b ? (jp.q.b.C0228b) t10 : null;
        if (c0228b == null) {
            return false;
        }
        return w(c0228b.f8793a.f8772a);
    }

    @os.m
    public abstract p.a y(@os.l dp.b bVar, @os.l z0 z0Var, @os.l List<A> list);

    public final p.a z(dp.b bVar, z0 z0Var, List<A> list) {
        zn.a.f21945a.getClass();
        if (zn.a.f21946b.contains(bVar)) {
            return null;
        }
        return y(bVar, z0Var, list);
    }
}
