package no;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import eo.k0;
import eo.m1;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public static final eo.u f11771a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.l
    public static final eo.u f11772b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @os.l
    public static final eo.u f11773c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @os.l
    public static final Map<m1, eo.u> f11774d;

    public static class a extends eo.r {
        public a(m1 m1Var) {
            super(m1Var);
        }

        private static /* synthetic */ void g(int i10) {
            Object[] objArr = new Object[3];
            if (i10 != 1) {
                objArr[0] = "what";
            } else {
                objArr[0] = TypedValues.TransitionType.S_FROM;
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/load/java/JavaDescriptorVisibilities$1";
            objArr[2] = "isVisible";
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        @Override // eo.u
        public boolean e(@os.m pp.e eVar, @os.l eo.q qVar, @os.l eo.m mVar) {
            if (qVar == null) {
                g(0);
            }
            if (mVar == null) {
                g(1);
            }
            return r.d(qVar, mVar);
        }
    }

    public static class b extends eo.r {
        public b(m1 m1Var) {
            super(m1Var);
        }

        private static /* synthetic */ void g(int i10) {
            Object[] objArr = new Object[3];
            if (i10 != 1) {
                objArr[0] = "what";
            } else {
                objArr[0] = TypedValues.TransitionType.S_FROM;
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/load/java/JavaDescriptorVisibilities$2";
            objArr[2] = "isVisible";
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        @Override // eo.u
        public boolean e(@os.m pp.e eVar, @os.l eo.q qVar, @os.l eo.m mVar) {
            if (qVar == null) {
                g(0);
            }
            if (mVar == null) {
                g(1);
            }
            return r.e(eVar, qVar, mVar);
        }
    }

    public static class c extends eo.r {
        public c(m1 m1Var) {
            super(m1Var);
        }

        private static /* synthetic */ void g(int i10) {
            Object[] objArr = new Object[3];
            if (i10 != 1) {
                objArr[0] = "what";
            } else {
                objArr[0] = TypedValues.TransitionType.S_FROM;
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/load/java/JavaDescriptorVisibilities$3";
            objArr[2] = "isVisible";
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        @Override // eo.u
        public boolean e(@os.m pp.e eVar, @os.l eo.q qVar, @os.l eo.m mVar) {
            if (qVar == null) {
                g(0);
            }
            if (mVar == null) {
                g(1);
            }
            return r.e(eVar, qVar, mVar);
        }
    }

    static {
        a aVar = new a(io.a.C0218a.f8286c);
        f11771a = aVar;
        b bVar = new b(io.a.c.f8288c);
        f11772b = bVar;
        c cVar = new c(io.a.b.f8287c);
        f11773c = cVar;
        f11774d = new HashMap();
        f(aVar);
        f(bVar);
        f(cVar);
    }

    public static /* synthetic */ void a(int i10) {
        String str = (i10 == 5 || i10 == 6) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i10 == 5 || i10 == 6) ? 2 : 3];
        switch (i10) {
            case 1:
                objArr[0] = TypedValues.TransitionType.S_FROM;
                break;
            case 2:
                objArr[0] = "first";
                break;
            case 3:
                objArr[0] = y1.o.r.f20674f;
                break;
            case 4:
                objArr[0] = "visibility";
                break;
            case 5:
            case 6:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/load/java/JavaDescriptorVisibilities";
                break;
            default:
                objArr[0] = "what";
                break;
        }
        if (i10 == 5 || i10 == 6) {
            objArr[1] = "toDescriptorVisibility";
        } else {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/load/java/JavaDescriptorVisibilities";
        }
        if (i10 == 2 || i10 == 3) {
            objArr[2] = "areInSamePackage";
        } else if (i10 == 4) {
            objArr[2] = "toDescriptorVisibility";
        } else if (i10 != 5 && i10 != 6) {
            objArr[2] = "isVisibleForProtectedAndPackage";
        }
        String str2 = String.format(str, objArr);
        if (i10 != 5 && i10 != 6) {
            throw new IllegalArgumentException(str2);
        }
        throw new IllegalStateException(str2);
    }

    public static boolean d(@os.l eo.m mVar, @os.l eo.m mVar2) {
        if (mVar == null) {
            a(2);
        }
        if (mVar2 == null) {
            a(3);
        }
        k0 k0Var = (k0) hp.d.r(mVar, k0.class, false);
        k0 k0Var2 = (k0) hp.d.r(mVar2, k0.class, false);
        return (k0Var2 == null || k0Var == null || !k0Var.e().equals(k0Var2.e())) ? false : true;
    }

    public static boolean e(@os.m pp.e eVar, @os.l eo.q qVar, @os.l eo.m mVar) {
        if (qVar == null) {
            a(0);
        }
        if (mVar == null) {
            a(1);
        }
        if (d(hp.d.M(qVar), mVar)) {
            return true;
        }
        return eo.t.f4631c.e(eVar, qVar, mVar);
    }

    public static void f(eo.u uVar) {
        f11774d.put(uVar.b(), uVar);
    }

    @os.l
    public static eo.u g(@os.l m1 m1Var) {
        if (m1Var == null) {
            a(4);
        }
        eo.u uVar = f11774d.get(m1Var);
        if (uVar != null) {
            return uVar;
        }
        eo.u uVarJ = eo.t.j(m1Var);
        if (uVarJ == null) {
            a(5);
        }
        return uVarJ;
    }
}
