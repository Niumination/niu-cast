package rp;

import eo.e1;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kn.g0;
import kn.l0;
import kn.l1;
import kn.n0;
import nm.d1;
import nm.h0;
import nm.k0;
import vp.a1;
import vp.c1;
import vp.f0;
import vp.o1;
import vp.q0;
import vp.r0;
import vp.s0;

/* JADX INFO: loaded from: classes3.dex */
public final class d0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public final l f14703a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.m
    public final d0 f14704b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @os.l
    public final String f14705c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @os.l
    public final String f14706d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @os.l
    public final jn.l<Integer, eo.h> f14707e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @os.l
    public final jn.l<Integer, eo.h> f14708f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @os.l
    public final Map<Integer, e1> f14709g;

    public static final class a extends n0 implements jn.l<Integer, eo.h> {
        public a() {
            super(1);
        }

        @Override // jn.l
        public /* bridge */ /* synthetic */ eo.h invoke(Integer num) {
            return invoke(num.intValue());
        }

        @os.m
        public final eo.h invoke(int i10) {
            return d0.this.d(i10);
        }
    }

    public static final class b extends n0 implements jn.a<List<? extends fo.c>> {
        final /* synthetic */ yo.a.q $proto;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(yo.a.q qVar) {
            super(0);
            this.$proto = qVar;
        }

        @Override // jn.a
        @os.l
        public final List<? extends fo.c> invoke() {
            l lVar = d0.this.f14703a;
            return lVar.f14748a.f14731e.e(this.$proto, lVar.f14749b);
        }
    }

    public static final class c extends n0 implements jn.l<Integer, eo.h> {
        public c() {
            super(1);
        }

        @Override // jn.l
        public /* bridge */ /* synthetic */ eo.h invoke(Integer num) {
            return invoke(num.intValue());
        }

        @os.m
        public final eo.h invoke(int i10) {
            return d0.this.f(i10);
        }
    }

    public /* synthetic */ class d extends g0 implements jn.l<dp.b, dp.b> {
        public static final d INSTANCE = new d();

        public d() {
            super(1);
        }

        @Override // kn.q, un.c
        @os.l
        public final String getName() {
            return "getOuterClassId";
        }

        @Override // kn.q
        @os.l
        public final un.h getOwner() {
            return l1.d(dp.b.class);
        }

        @Override // kn.q
        @os.l
        public final String getSignature() {
            return "getOuterClassId()Lorg/jetbrains/kotlin/name/ClassId;";
        }

        @Override // jn.l
        @os.m
        public final dp.b invoke(@os.l dp.b bVar) {
            l0.p(bVar, "p0");
            return bVar.g();
        }
    }

    public static final class e extends n0 implements jn.l<yo.a.q, yo.a.q> {
        public e() {
            super(1);
        }

        @Override // jn.l
        @os.m
        public final yo.a.q invoke(@os.l yo.a.q qVar) {
            l0.p(qVar, "it");
            return ap.f.g(qVar, d0.this.f14703a.f14751d);
        }
    }

    public static final class f extends n0 implements jn.l<yo.a.q, Integer> {
        public static final f INSTANCE = new f();

        public f() {
            super(1);
        }

        @Override // jn.l
        @os.l
        public final Integer invoke(@os.l yo.a.q qVar) {
            l0.p(qVar, "it");
            return Integer.valueOf(qVar.getArgumentCount());
        }
    }

    public d0(@os.l l lVar, @os.m d0 d0Var, @os.l List<yo.a.s> list, @os.l String str, @os.l String str2) {
        Map<Integer, e1> linkedHashMap;
        l0.p(lVar, "c");
        l0.p(list, "typeParameterProtos");
        l0.p(str, "debugName");
        l0.p(str2, "containerPresentableName");
        this.f14703a = lVar;
        this.f14704b = d0Var;
        this.f14705c = str;
        this.f14706d = str2;
        this.f14707e = lVar.f14748a.f14727a.f(new a());
        this.f14708f = lVar.f14748a.f14727a.f(new c());
        if (list.isEmpty()) {
            linkedHashMap = d1.z();
        } else {
            linkedHashMap = new LinkedHashMap<>();
            int i10 = 0;
            for (yo.a.s sVar : list) {
                linkedHashMap.put(Integer.valueOf(sVar.getId()), new tp.n(this.f14703a, sVar, i10));
                i10++;
            }
        }
        this.f14709g = linkedHashMap;
    }

    public static final List<yo.a.q.b> m(yo.a.q qVar, d0 d0Var) {
        List<yo.a.q.b> argumentList = qVar.getArgumentList();
        l0.o(argumentList, "argumentList");
        List<yo.a.q.b> list = argumentList;
        yo.a.q qVarG = ap.f.g(qVar, d0Var.f14703a.f14751d);
        List<yo.a.q.b> listM = qVarG == null ? null : m(qVarG, d0Var);
        if (listM == null) {
            listM = k0.INSTANCE;
        }
        return h0.E4(list, listM);
    }

    public static /* synthetic */ vp.n0 n(d0 d0Var, yo.a.q qVar, boolean z10, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            z10 = true;
        }
        return d0Var.l(qVar, z10);
    }

    public static final eo.e s(d0 d0Var, yo.a.q qVar, int i10) {
        dp.b bVarA = x.a(d0Var.f14703a.f14749b, i10);
        List<Integer> listD3 = gq.v.d3(gq.v.k1(gq.s.l(qVar, d0Var.new e()), f.INSTANCE));
        int iG0 = gq.v.g0(gq.s.l(bVarA, d.INSTANCE));
        while (listD3.size() < iG0) {
            listD3.add(0);
        }
        return d0Var.f14703a.f14748a.f14738l.d(bVarA, listD3);
    }

    public final eo.h d(int i10) {
        dp.b bVarA = x.a(this.f14703a.f14749b, i10);
        return bVarA.f3808c ? this.f14703a.f14748a.b(bVarA) : eo.x.b(this.f14703a.f14748a.f14728b, bVarA);
    }

    public final vp.n0 e(int i10) {
        if (x.a(this.f14703a.f14749b, i10).f3808c) {
            return this.f14703a.f14748a.f14733g.a();
        }
        return null;
    }

    public final eo.h f(int i10) {
        dp.b bVarA = x.a(this.f14703a.f14749b, i10);
        if (bVarA.f3808c) {
            return null;
        }
        return eo.x.d(this.f14703a.f14748a.f14728b, bVarA);
    }

    public final vp.n0 g(f0 f0Var, f0 f0Var2) {
        ao.h hVarH = zp.a.h(f0Var);
        fo.g annotations = f0Var.getAnnotations();
        f0 f0VarH = ao.g.h(f0Var);
        List listD2 = h0.d2(ao.g.j(f0Var), 1);
        ArrayList arrayList = new ArrayList(nm.z.b0(listD2, 10));
        Iterator it = listD2.iterator();
        while (it.hasNext()) {
            arrayList.add(((c1) it.next()).getType());
        }
        return ao.g.a(hVarH, annotations, f0VarH, arrayList, null, f0Var2, true).N0(f0Var.H0());
    }

    public final vp.n0 h(fo.g gVar, a1 a1Var, List<? extends c1> list, boolean z10) {
        vp.n0 n0VarI;
        int size;
        int size2 = a1Var.getParameters().size() - list.size();
        if (size2 != 0) {
            n0VarI = null;
            if (size2 == 1 && (size = list.size() - 1) >= 0) {
                a1 a1VarI = a1Var.n().X(size).i();
                l0.o(a1VarI, "functionTypeConstructor.…on(arity).typeConstructor");
                n0VarI = vp.g0.j(gVar, a1VarI, list, z10, null, 16, null);
            }
        } else {
            n0VarI = i(gVar, a1Var, list, z10);
        }
        if (n0VarI != null) {
            return n0VarI;
        }
        vp.n0 n0VarN = vp.x.n(l0.C("Bad suspend function in metadata with constructor: ", a1Var), list);
        l0.o(n0VarN, "createErrorTypeWithArgum…      arguments\n        )");
        return n0VarN;
    }

    public final vp.n0 i(fo.g gVar, a1 a1Var, List<? extends c1> list, boolean z10) {
        vp.n0 n0VarJ = vp.g0.j(gVar, a1Var, list, z10, null, 16, null);
        if (ao.g.n(n0VarJ)) {
            return o(n0VarJ);
        }
        return null;
    }

    @os.l
    public final List<e1> j() {
        return h0.V5(this.f14709g.values());
    }

    public final e1 k(int i10) {
        e1 e1Var = this.f14709g.get(Integer.valueOf(i10));
        if (e1Var != null) {
            return e1Var;
        }
        d0 d0Var = this.f14704b;
        if (d0Var == null) {
            return null;
        }
        return d0Var.k(i10);
    }

    @os.l
    public final vp.n0 l(@os.l yo.a.q qVar, boolean z10) {
        vp.n0 n0VarJ;
        l0.p(qVar, "proto");
        vp.n0 n0VarE = qVar.hasClassName() ? e(qVar.getClassName()) : qVar.hasTypeAliasName() ? e(qVar.getTypeAliasName()) : null;
        if (n0VarE != null) {
            return n0VarE;
        }
        a1 a1VarR = r(qVar);
        if (vp.x.r(a1VarR.d())) {
            vp.n0 n0VarO = vp.x.o(a1VarR.toString(), a1VarR);
            l0.o(n0VarO, "createErrorTypeWithCusto….toString(), constructor)");
            return n0VarO;
        }
        tp.b bVar = new tp.b(this.f14703a.f14748a.f14727a, new b(qVar));
        List<yo.a.q.b> listM = m(qVar, this);
        ArrayList arrayList = new ArrayList(nm.z.b0(listM, 10));
        int i10 = 0;
        for (Object obj : listM) {
            int i11 = i10 + 1;
            if (i10 < 0) {
                nm.y.Z();
            }
            List<e1> parameters = a1VarR.getParameters();
            l0.o(parameters, "constructor.parameters");
            arrayList.add(q((e1) h0.W2(parameters, i10), (yo.a.q.b) obj));
            i10 = i11;
        }
        List<? extends c1> listV5 = h0.V5(arrayList);
        eo.h hVarD = a1VarR.d();
        if (z10 && (hVarD instanceof eo.d1)) {
            vp.g0 g0Var = vp.g0.f17692a;
            vp.n0 n0VarB = vp.g0.b((eo.d1) hVarD, listV5);
            n0VarJ = n0VarB.N0(vp.h0.b(n0VarB) || qVar.getNullable()).O0(fo.g.f6167h.a(h0.A4(bVar, n0VarB.getAnnotations())));
        } else {
            Boolean boolD = ap.b.f639a.d(qVar.getFlags());
            l0.o(boolD, "SUSPEND_TYPE.get(proto.flags)");
            if (boolD.booleanValue()) {
                n0VarJ = h(bVar, a1VarR, listV5, qVar.getNullable());
            } else {
                n0VarJ = vp.g0.j(bVar, a1VarR, listV5, qVar.getNullable(), null, 16, null);
                Boolean boolD2 = ap.b.f640b.d(qVar.getFlags());
                l0.o(boolD2, "DEFINITELY_NOT_NULL_TYPE.get(proto.flags)");
                if (boolD2.booleanValue()) {
                    vp.o oVarC = vp.o.a.c(vp.o.f17723d, n0VarJ, false, 2, null);
                    if (oVarC == null) {
                        throw new IllegalStateException(("null DefinitelyNotNullType for '" + n0VarJ + '\'').toString());
                    }
                    n0VarJ = oVarC;
                }
            }
        }
        yo.a.q qVarA = ap.f.a(qVar, this.f14703a.f14751d);
        if (qVarA != null) {
            n0VarJ = q0.j(n0VarJ, l(qVarA, false));
        }
        if (qVar.hasClassName()) {
            return this.f14703a.f14748a.f14745s.a(x.a(this.f14703a.f14749b, qVar.getClassName()), n0VarJ);
        }
        return n0VarJ;
    }

    public final vp.n0 o(f0 f0Var) {
        c1 c1Var = (c1) h0.v3(ao.g.j(f0Var));
        if (c1Var == null) {
            return null;
        }
        f0 type = c1Var.getType();
        l0.o(type, "funType.getValueParamete…ll()?.type ?: return null");
        eo.h hVarD = type.G0().d();
        dp.c cVarI = hVarD == null ? null : lp.a.i(hVarD);
        if (type.F0().size() != 1 || (!l0.g(cVarI, ao.k.f560h) && !l0.g(cVarI, e0.f14713a))) {
            return (vp.n0) f0Var;
        }
        f0 type2 = ((c1) h0.h5(type.F0())).getType();
        l0.o(type2, "continuationArgumentType.arguments.single().type");
        eo.m mVar = this.f14703a.f14750c;
        if (!(mVar instanceof eo.a)) {
            mVar = null;
        }
        eo.a aVar = (eo.a) mVar;
        return l0.g(aVar != null ? lp.a.e(aVar) : null, c0.f14698a) ? g(f0Var, type2) : g(f0Var, type2);
    }

    @os.l
    public final f0 p(@os.l yo.a.q qVar) {
        l0.p(qVar, "proto");
        if (!qVar.hasFlexibleTypeCapabilitiesId()) {
            return l(qVar, true);
        }
        String strC = this.f14703a.f14749b.c(qVar.getFlexibleTypeCapabilitiesId());
        vp.n0 n0VarN = n(this, qVar, false, 2, null);
        yo.a.q qVarC = ap.f.c(qVar, this.f14703a.f14751d);
        l0.m(qVarC);
        return this.f14703a.f14748a.f14736j.a(qVar, strC, n0VarN, n(this, qVarC, false, 2, null));
    }

    public final c1 q(e1 e1Var, yo.a.q.b bVar) {
        if (bVar.getProjection() == yo.a.q.b.c.STAR) {
            return e1Var == null ? new r0(this.f14703a.f14748a.f14728b.n()) : new s0(e1Var);
        }
        a0 a0Var = a0.f14685a;
        yo.a.q.b.c projection = bVar.getProjection();
        l0.o(projection, "typeArgumentProto.projection");
        o1 o1VarC = a0Var.c(projection);
        yo.a.q qVarM = ap.f.m(bVar, this.f14703a.f14751d);
        return qVarM == null ? new vp.e1(vp.x.j("No type recorded")) : new vp.e1(o1VarC, p(qVarM));
    }

    public final a1 r(yo.a.q qVar) {
        eo.h hVarInvoke;
        Object next;
        if (qVar.hasClassName()) {
            hVarInvoke = this.f14707e.invoke(Integer.valueOf(qVar.getClassName()));
            if (hVarInvoke == null) {
                hVarInvoke = s(this, qVar, qVar.getClassName());
            }
        } else if (qVar.hasTypeParameter()) {
            hVarInvoke = k(qVar.getTypeParameter());
            if (hVarInvoke == null) {
                a1 a1VarK = vp.x.k("Unknown type parameter " + qVar.getTypeParameter() + ". Please try recompiling module containing \"" + this.f14706d + '\"');
                l0.o(a1VarK, "createErrorTypeConstruct…\\\"\"\n                    )");
                return a1VarK;
            }
        } else if (qVar.hasTypeParameterName()) {
            String strC = this.f14703a.f14749b.c(qVar.getTypeParameterName());
            Iterator<T> it = j().iterator();
            do {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
            } while (!l0.g(((e1) next).getName().b(), strC));
            hVarInvoke = (e1) next;
            if (hVarInvoke == null) {
                StringBuilder sbA = e.a.a("Deserialized type parameter ", strC, " in ");
                sbA.append(this.f14703a.f14750c);
                a1 a1VarK2 = vp.x.k(sbA.toString());
                l0.o(a1VarK2, "createErrorTypeConstruct….containingDeclaration}\")");
                return a1VarK2;
            }
        } else {
            if (!qVar.hasTypeAliasName()) {
                a1 a1VarK3 = vp.x.k("Unknown type");
                l0.o(a1VarK3, "createErrorTypeConstructor(\"Unknown type\")");
                return a1VarK3;
            }
            hVarInvoke = this.f14708f.invoke(Integer.valueOf(qVar.getTypeAliasName()));
            if (hVarInvoke == null) {
                hVarInvoke = s(this, qVar, qVar.getTypeAliasName());
            }
        }
        a1 a1VarI = hVarInvoke.i();
        l0.o(a1VarI, "classifier.typeConstructor");
        return a1VarI;
    }

    @os.l
    public String toString() {
        String str = this.f14705c;
        d0 d0Var = this.f14704b;
        return l0.C(str, d0Var == null ? "" : l0.C(". Child of ", d0Var.f14705c));
    }
}
