package kn;

import java.lang.annotation.Annotation;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
@lm.f1(version = "1.4")
public final class w1 implements un.s {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @os.l
    public static final a f9374e = new a();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f9375f = 1;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f9376g = 2;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f9377i = 4;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public final un.g f9378a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.l
    public final List<un.u> f9379b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @os.m
    public final un.s f9380c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f9381d;

    public static final class a {
        public a() {
        }

        public a(w wVar) {
        }
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f9382a;

        static {
            int[] iArr = new int[un.v.values().length];
            try {
                iArr[un.v.INVARIANT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[un.v.IN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[un.v.OUT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f9382a = iArr;
        }
    }

    public static final class c extends n0 implements jn.l<un.u, CharSequence> {
        public c() {
            super(1);
        }

        @Override // jn.l
        @os.l
        public final CharSequence invoke(@os.l un.u uVar) {
            l0.p(uVar, "it");
            return w1.this.m(uVar);
        }
    }

    @lm.f1(version = "1.6")
    public w1(@os.l un.g gVar, @os.l List<un.u> list, @os.m un.s sVar, int i10) {
        l0.p(gVar, "classifier");
        l0.p(list, "arguments");
        this.f9378a = gVar;
        this.f9379b = list;
        this.f9380c = sVar;
        this.f9381d = i10;
    }

    @lm.f1(version = "1.6")
    public static /* synthetic */ void B() {
    }

    @lm.f1(version = "1.6")
    public static /* synthetic */ void D() {
    }

    public final int A() {
        return this.f9381d;
    }

    @os.m
    public final un.s C() {
        return this.f9380c;
    }

    public boolean equals(@os.m Object obj) {
        if (obj instanceof w1) {
            w1 w1Var = (w1) obj;
            if (l0.g(this.f9378a, w1Var.f9378a) && l0.g(this.f9379b, w1Var.f9379b) && l0.g(this.f9380c, w1Var.f9380c) && this.f9381d == w1Var.f9381d) {
                return true;
            }
        }
        return false;
    }

    @Override // un.b
    @os.l
    public List<Annotation> getAnnotations() {
        return nm.k0.INSTANCE;
    }

    public int hashCode() {
        return Integer.hashCode(this.f9381d) + ((this.f9379b.hashCode() + (this.f9378a.hashCode() * 31)) * 31);
    }

    @Override // un.s
    @os.l
    public un.g i() {
        return this.f9378a;
    }

    public final String m(un.u uVar) {
        String strValueOf;
        if (uVar.f16348a == null) {
            return "*";
        }
        un.s sVar = uVar.f16349b;
        w1 w1Var = sVar instanceof w1 ? (w1) sVar : null;
        if (w1Var == null || (strValueOf = w1Var.s(true)) == null) {
            strValueOf = String.valueOf(uVar.f16349b);
        }
        int i10 = b.f9382a[uVar.f16348a.ordinal()];
        if (i10 == 1) {
            return strValueOf;
        }
        if (i10 == 2) {
            return "in ".concat(strValueOf);
        }
        if (i10 == 3) {
            return "out ".concat(strValueOf);
        }
        throw new lm.i0();
    }

    @Override // un.s
    @os.l
    public List<un.u> n() {
        return this.f9379b;
    }

    @Override // un.s
    public boolean o() {
        return (this.f9381d & 1) != 0;
    }

    public final String s(boolean z10) {
        String name;
        un.g gVar = this.f9378a;
        un.d dVar = gVar instanceof un.d ? (un.d) gVar : null;
        Class<?> clsE = dVar != null ? in.b.e(dVar) : null;
        if (clsE == null) {
            name = this.f9378a.toString();
        } else if ((this.f9381d & 4) != 0) {
            name = "kotlin.Nothing";
        } else if (clsE.isArray()) {
            name = y(clsE);
        } else if (z10 && clsE.isPrimitive()) {
            un.g gVar2 = this.f9378a;
            l0.n(gVar2, "null cannot be cast to non-null type kotlin.reflect.KClass<*>");
            name = in.b.g((un.d) gVar2).getName();
        } else {
            name = clsE.getName();
        }
        String str = name + (this.f9379b.isEmpty() ? "" : nm.h0.m3(this.f9379b, ", ", "<", ">", 0, null, new c(), 24, null)) + (o() ? "?" : "");
        un.s sVar = this.f9380c;
        if (!(sVar instanceof w1)) {
            return str;
        }
        String strS = ((w1) sVar).s(true);
        if (l0.g(strS, str)) {
            return str;
        }
        if (l0.g(strS, str + '?')) {
            return str + '!';
        }
        return "(" + str + ".." + strS + ')';
    }

    @os.l
    public String toString() {
        return s(false) + l1.f9320b;
    }

    public final String y(Class<?> cls) {
        if (l0.g(cls, boolean[].class)) {
            return "kotlin.BooleanArray";
        }
        if (l0.g(cls, char[].class)) {
            return "kotlin.CharArray";
        }
        if (l0.g(cls, byte[].class)) {
            return "kotlin.ByteArray";
        }
        if (l0.g(cls, short[].class)) {
            return "kotlin.ShortArray";
        }
        if (l0.g(cls, int[].class)) {
            return "kotlin.IntArray";
        }
        if (l0.g(cls, float[].class)) {
            return "kotlin.FloatArray";
        }
        if (l0.g(cls, long[].class)) {
            return "kotlin.LongArray";
        }
        return l0.g(cls, double[].class) ? "kotlin.DoubleArray" : "kotlin.Array";
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public w1(@os.l un.g gVar, @os.l List<un.u> list, boolean z10) {
        this(gVar, list, null, z10 ? 1 : 0);
        l0.p(gVar, "classifier");
        l0.p(list, "arguments");
    }
}
