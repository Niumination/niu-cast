package eo;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.ServiceLoader;
import java.util.Set;
import nm.o1;

/* JADX INFO: loaded from: classes3.dex */
public class t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public static final u f4629a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.l
    public static final u f4630b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @os.l
    public static final u f4631c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @os.l
    public static final u f4632d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @os.l
    public static final u f4633e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @os.l
    public static final u f4634f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @os.l
    public static final u f4635g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @os.l
    public static final u f4636h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @os.l
    public static final u f4637i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final Set<u> f4638j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final Map<u, Integer> f4639k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final u f4640l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final pp.e f4641m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final pp.e f4642n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    @Deprecated
    public static final pp.e f4643o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    @os.l
    public static final bq.g f4644p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    @os.l
    public static final Map<m1, u> f4645q;

    public static class a implements pp.e {
        @Override // pp.e
        @os.l
        public vp.f0 getType() {
            throw new IllegalStateException("This method should not be called");
        }
    }

    public static class b implements pp.e {
        @Override // pp.e
        @os.l
        public vp.f0 getType() {
            throw new IllegalStateException("This method should not be called");
        }
    }

    public static class c implements pp.e {
        @Override // pp.e
        @os.l
        public vp.f0 getType() {
            throw new IllegalStateException("This method should not be called");
        }
    }

    public static class d extends r {
        public d(m1 m1Var) {
            super(m1Var);
        }

        public static /* synthetic */ void g(int i10) {
            Object[] objArr = new Object[3];
            if (i10 == 1) {
                objArr[0] = "what";
            } else if (i10 != 2) {
                objArr[0] = "descriptor";
            } else {
                objArr[0] = TypedValues.TransitionType.S_FROM;
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/DescriptorVisibilities$1";
            if (i10 == 1 || i10 == 2) {
                objArr[2] = "isVisible";
            } else {
                objArr[2] = "hasContainingSourceFile";
            }
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // eo.u
        public boolean e(@os.m pp.e eVar, @os.l q qVar, @os.l m mVar) {
            if (qVar == 0) {
                g(1);
            }
            if (mVar == null) {
                g(2);
            }
            if (hp.d.J(qVar) && h(mVar)) {
                return t.f(qVar, mVar);
            }
            if (qVar instanceof eo.l) {
                eo.i iVarB = ((eo.l) qVar).b();
                if (hp.d.G(iVarB) && hp.d.J(iVarB) && (mVar instanceof eo.l) && hp.d.J(mVar.b()) && t.f(qVar, mVar)) {
                    return true;
                }
            }
            while (qVar != 0) {
                qVar = qVar.b();
                if (((qVar instanceof eo.e) && !hp.d.x(qVar)) || (qVar instanceof k0)) {
                    break;
                }
            }
            if (qVar == 0) {
                return false;
            }
            while (mVar != null) {
                if (qVar == mVar) {
                    return true;
                }
                if (mVar instanceof k0) {
                    return (qVar instanceof k0) && ((k0) qVar).e().equals(((k0) mVar).e()) && hp.d.b(mVar, qVar);
                }
                mVar = mVar.b();
            }
            return false;
        }

        public final boolean h(@os.l m mVar) {
            if (mVar == null) {
                g(0);
            }
            return hp.d.j(mVar) != a1.f4590a;
        }
    }

    public static class e extends r {
        public e(m1 m1Var) {
            super(m1Var);
        }

        private static /* synthetic */ void g(int i10) {
            Object[] objArr = new Object[3];
            if (i10 != 1) {
                objArr[0] = "what";
            } else {
                objArr[0] = TypedValues.TransitionType.S_FROM;
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/DescriptorVisibilities$2";
            objArr[2] = "isVisible";
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        @Override // eo.u
        public boolean e(@os.m pp.e eVar, @os.l q qVar, @os.l m mVar) {
            m mVarQ;
            if (qVar == null) {
                g(0);
            }
            if (mVar == null) {
                g(1);
            }
            if (!t.f4629a.e(eVar, qVar, mVar)) {
                return false;
            }
            if (eVar == t.f4642n) {
                return true;
            }
            if (eVar == t.f4641m || (mVarQ = hp.d.q(qVar, eo.e.class)) == null || !(eVar instanceof pp.g)) {
                return false;
            }
            return ((pp.g) eVar).v().a().equals(mVarQ.a());
        }
    }

    public static class f extends r {
        public f(m1 m1Var) {
            super(m1Var);
        }

        private static /* synthetic */ void g(int i10) {
            Object[] objArr = new Object[3];
            if (i10 == 1) {
                objArr[0] = TypedValues.TransitionType.S_FROM;
            } else if (i10 == 2) {
                objArr[0] = "whatDeclaration";
            } else if (i10 != 3) {
                objArr[0] = "what";
            } else {
                objArr[0] = "fromClass";
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/DescriptorVisibilities$3";
            if (i10 == 2 || i10 == 3) {
                objArr[2] = "doesReceiverFitForProtectedVisibility";
            } else {
                objArr[2] = "isVisible";
            }
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        @Override // eo.u
        public boolean e(@os.m pp.e eVar, @os.l q qVar, @os.l m mVar) {
            eo.e eVar2;
            if (qVar == null) {
                g(0);
            }
            if (mVar == null) {
                g(1);
            }
            eo.e eVar3 = (eo.e) hp.d.q(qVar, eo.e.class);
            eo.e eVar4 = (eo.e) hp.d.r(mVar, eo.e.class, false);
            if (eVar4 == null) {
                return false;
            }
            if (eVar3 != null && hp.d.x(eVar3) && (eVar2 = (eo.e) hp.d.q(eVar3, eo.e.class)) != null && hp.d.H(eVar4, eVar2)) {
                return true;
            }
            q qVarM = hp.d.M(qVar);
            eo.e eVar5 = (eo.e) hp.d.q(qVarM, eo.e.class);
            if (eVar5 == null) {
                return false;
            }
            if (hp.d.H(eVar4, eVar5) && h(eVar, qVarM, eVar4)) {
                return true;
            }
            return e(eVar, qVar, eVar4.b());
        }

        public final boolean h(@os.m pp.e eVar, @os.l q qVar, @os.l eo.e eVar2) {
            if (qVar == null) {
                g(2);
            }
            if (eVar2 == null) {
                g(3);
            }
            if (eVar == t.f4643o) {
                return false;
            }
            if (!(qVar instanceof eo.b) || (qVar instanceof eo.l) || eVar == t.f4642n) {
                return true;
            }
            if (eVar == t.f4641m || eVar == null) {
                return false;
            }
            vp.f0 f0VarA = eVar instanceof pp.f ? ((pp.f) eVar).a() : eVar.getType();
            return hp.d.I(f0VarA, eVar2) || vp.v.a(f0VarA);
        }
    }

    public static class g extends r {
        public g(m1 m1Var) {
            super(m1Var);
        }

        private static /* synthetic */ void g(int i10) {
            Object[] objArr = new Object[3];
            if (i10 != 1) {
                objArr[0] = "what";
            } else {
                objArr[0] = TypedValues.TransitionType.S_FROM;
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/DescriptorVisibilities$4";
            objArr[2] = "isVisible";
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        @Override // eo.u
        public boolean e(@os.m pp.e eVar, @os.l q qVar, @os.l m mVar) {
            if (qVar == null) {
                g(0);
            }
            if (mVar == null) {
                g(1);
            }
            if (hp.d.g(mVar).E(hp.d.g(qVar))) {
                return t.f4644p.a(qVar, mVar);
            }
            return false;
        }
    }

    public static class h extends r {
        public h(m1 m1Var) {
            super(m1Var);
        }

        private static /* synthetic */ void g(int i10) {
            Object[] objArr = new Object[3];
            if (i10 != 1) {
                objArr[0] = "what";
            } else {
                objArr[0] = TypedValues.TransitionType.S_FROM;
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/DescriptorVisibilities$5";
            objArr[2] = "isVisible";
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        @Override // eo.u
        public boolean e(@os.m pp.e eVar, @os.l q qVar, @os.l m mVar) {
            if (qVar == null) {
                g(0);
            }
            if (mVar == null) {
                g(1);
            }
            return true;
        }
    }

    public static class i extends r {
        public i(m1 m1Var) {
            super(m1Var);
        }

        private static /* synthetic */ void g(int i10) {
            Object[] objArr = new Object[3];
            if (i10 != 1) {
                objArr[0] = "what";
            } else {
                objArr[0] = TypedValues.TransitionType.S_FROM;
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/DescriptorVisibilities$6";
            objArr[2] = "isVisible";
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        @Override // eo.u
        public boolean e(@os.m pp.e eVar, @os.l q qVar, @os.l m mVar) {
            if (qVar == null) {
                g(0);
            }
            if (mVar == null) {
                g(1);
            }
            throw new IllegalStateException("This method shouldn't be invoked for LOCAL visibility");
        }
    }

    public static class j extends r {
        public j(m1 m1Var) {
            super(m1Var);
        }

        private static /* synthetic */ void g(int i10) {
            Object[] objArr = new Object[3];
            if (i10 != 1) {
                objArr[0] = "what";
            } else {
                objArr[0] = TypedValues.TransitionType.S_FROM;
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/DescriptorVisibilities$7";
            objArr[2] = "isVisible";
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        @Override // eo.u
        public boolean e(@os.m pp.e eVar, @os.l q qVar, @os.l m mVar) {
            if (qVar == null) {
                g(0);
            }
            if (mVar == null) {
                g(1);
            }
            throw new IllegalStateException("Visibility is unknown yet");
        }
    }

    public static class k extends r {
        public k(m1 m1Var) {
            super(m1Var);
        }

        private static /* synthetic */ void g(int i10) {
            Object[] objArr = new Object[3];
            if (i10 != 1) {
                objArr[0] = "what";
            } else {
                objArr[0] = TypedValues.TransitionType.S_FROM;
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/DescriptorVisibilities$8";
            objArr[2] = "isVisible";
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        @Override // eo.u
        public boolean e(@os.m pp.e eVar, @os.l q qVar, @os.l m mVar) {
            if (qVar == null) {
                g(0);
            }
            if (mVar == null) {
                g(1);
            }
            return false;
        }
    }

    public static class l extends r {
        public l(m1 m1Var) {
            super(m1Var);
        }

        private static /* synthetic */ void g(int i10) {
            Object[] objArr = new Object[3];
            if (i10 != 1) {
                objArr[0] = "what";
            } else {
                objArr[0] = TypedValues.TransitionType.S_FROM;
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/DescriptorVisibilities$9";
            objArr[2] = "isVisible";
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        @Override // eo.u
        public boolean e(@os.m pp.e eVar, @os.l q qVar, @os.l m mVar) {
            if (qVar == null) {
                g(0);
            }
            if (mVar == null) {
                g(1);
            }
            return false;
        }
    }

    static {
        d dVar = new d(l1.e.f4617c);
        f4629a = dVar;
        e eVar = new e(l1.f.f4618c);
        f4630b = eVar;
        f fVar = new f(l1.g.f4619c);
        f4631c = fVar;
        g gVar = new g(l1.b.f4614c);
        f4632d = gVar;
        h hVar = new h(l1.h.f4620c);
        f4633e = hVar;
        i iVar = new i(l1.d.f4616c);
        f4634f = iVar;
        j jVar = new j(l1.a.f4613c);
        f4635g = jVar;
        k kVar = new k(l1.c.f4615c);
        f4636h = kVar;
        l lVar = new l(l1.i.f4621c);
        f4637i = lVar;
        f4638j = Collections.unmodifiableSet(o1.u(dVar, eVar, gVar, iVar));
        HashMap mapE = eq.a.e(4);
        mapE.put(eVar, 0);
        mapE.put(dVar, 0);
        mapE.put(gVar, 1);
        mapE.put(fVar, 1);
        mapE.put(hVar, 2);
        f4639k = Collections.unmodifiableMap(mapE);
        f4640l = hVar;
        f4641m = new a();
        f4642n = new b();
        f4643o = new c();
        Iterator it = ServiceLoader.load(bq.g.class, bq.g.class.getClassLoader()).iterator();
        f4644p = it.hasNext() ? (bq.g) it.next() : bq.g.a.f1060a;
        f4645q = new HashMap();
        i(dVar);
        i(eVar);
        i(fVar);
        i(gVar);
        i(hVar);
        i(iVar);
        i(jVar);
        i(kVar);
        i(lVar);
    }

    /* JADX WARN: Code duplicated, block: B:23:0x003a  */
    public static /* synthetic */ void a(int i10) {
        String str = i10 != 16 ? "Argument for @NotNull parameter '%s' of %s.%s must not be null" : "@NotNull method %s.%s must not return null";
        Object[] objArr = new Object[i10 != 16 ? 3 : 2];
        if (i10 != 1 && i10 != 3 && i10 != 5 && i10 != 7) {
            switch (i10) {
                case 9:
                    objArr[0] = TypedValues.TransitionType.S_FROM;
                    break;
                case 10:
                case 12:
                    objArr[0] = "first";
                    break;
                case 11:
                case 13:
                    objArr[0] = y1.o.r.f20674f;
                    break;
                case 14:
                case 15:
                    objArr[0] = "visibility";
                    break;
                case 16:
                    objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/DescriptorVisibilities";
                    break;
                default:
                    objArr[0] = "what";
                    break;
            }
        } else {
            objArr[0] = TypedValues.TransitionType.S_FROM;
        }
        if (i10 != 16) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/DescriptorVisibilities";
        } else {
            objArr[1] = "toDescriptorVisibility";
        }
        switch (i10) {
            case 2:
            case 3:
                objArr[2] = "isVisibleIgnoringReceiver";
                break;
            case 4:
            case 5:
                objArr[2] = "isVisibleWithAnyReceiver";
                break;
            case 6:
            case 7:
                objArr[2] = "inSameFile";
                break;
            case 8:
            case 9:
                objArr[2] = "findInvisibleMember";
                break;
            case 10:
            case 11:
                objArr[2] = "compareLocal";
                break;
            case 12:
            case 13:
                objArr[2] = "compare";
                break;
            case 14:
                objArr[2] = "isPrivate";
                break;
            case 15:
                objArr[2] = "toDescriptorVisibility";
                break;
            case 16:
                break;
            default:
                objArr[2] = "isVisible";
                break;
        }
        String str2 = String.format(str, objArr);
        if (i10 == 16) {
            throw new IllegalStateException(str2);
        }
    }

    @os.m
    public static Integer d(@os.l u uVar, @os.l u uVar2) {
        if (uVar == null) {
            a(12);
        }
        if (uVar2 == null) {
            a(13);
        }
        Integer numA = uVar.a(uVar2);
        if (numA != null) {
            return numA;
        }
        Integer numA2 = uVar2.a(uVar);
        if (numA2 != null) {
            return Integer.valueOf(-numA2.intValue());
        }
        return null;
    }

    @os.m
    public static q e(@os.m pp.e eVar, @os.l q qVar, @os.l m mVar) {
        q qVarE;
        if (qVar == null) {
            a(8);
        }
        if (mVar == null) {
            a(9);
        }
        for (q qVar2 = (q) qVar.a(); qVar2 != null && qVar2.getVisibility() != f4634f; qVar2 = (q) hp.d.q(qVar2, q.class)) {
            if (!qVar2.getVisibility().e(eVar, qVar2, mVar)) {
                return qVar2;
            }
        }
        if (!(qVar instanceof ho.i0) || (qVarE = e(eVar, ((ho.i0) qVar).U(), mVar)) == null) {
            return null;
        }
        return qVarE;
    }

    public static boolean f(@os.l m mVar, @os.l m mVar2) {
        if (mVar == null) {
            a(6);
        }
        if (mVar2 == null) {
            a(7);
        }
        a1 a1VarJ = hp.d.j(mVar2);
        if (a1VarJ != a1.f4590a) {
            return a1VarJ.equals(hp.d.j(mVar));
        }
        return false;
    }

    public static boolean g(@os.l u uVar) {
        if (uVar == null) {
            a(14);
        }
        return uVar == f4629a || uVar == f4630b;
    }

    public static boolean h(@os.l q qVar, @os.l m mVar) {
        if (qVar == null) {
            a(2);
        }
        if (mVar == null) {
            a(3);
        }
        return e(f4642n, qVar, mVar) == null;
    }

    public static void i(u uVar) {
        f4645q.put(uVar.b(), uVar);
    }

    @os.l
    public static u j(@os.l m1 m1Var) {
        if (m1Var == null) {
            a(15);
        }
        u uVar = f4645q.get(m1Var);
        if (uVar != null) {
            return uVar;
        }
        throw new IllegalArgumentException("Inapplicable visibility: " + m1Var);
    }
}
