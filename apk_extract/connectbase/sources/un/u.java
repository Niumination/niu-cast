package un;

import ik.y0;
import kn.l0;
import lm.f1;
import lm.i0;
import lm.z0;

/* JADX INFO: loaded from: classes3.dex */
@f1(version = "1.1")
public final class u {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @os.l
    public static final a f16346c = new a();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @in.f
    @os.l
    public static final u f16347d = new u(null, null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.m
    public final v f16348a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.m
    public final s f16349b;

    public static final class a {
        public a() {
        }

        @z0
        public static /* synthetic */ void d() {
        }

        @in.n
        @os.l
        public final u a(@os.l s sVar) {
            l0.p(sVar, y0.a.f8215h);
            return new u(v.IN, sVar);
        }

        @in.n
        @os.l
        public final u b(@os.l s sVar) {
            l0.p(sVar, y0.a.f8215h);
            return new u(v.OUT, sVar);
        }

        @os.l
        public final u c() {
            return u.f16347d;
        }

        @in.n
        @os.l
        public final u e(@os.l s sVar) {
            l0.p(sVar, y0.a.f8215h);
            return new u(v.INVARIANT, sVar);
        }

        public a(kn.w wVar) {
        }
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f16350a;

        static {
            int[] iArr = new int[v.values().length];
            try {
                iArr[v.INVARIANT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[v.IN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[v.OUT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f16350a = iArr;
        }
    }

    public u(@os.m v vVar, @os.m s sVar) {
        String str;
        this.f16348a = vVar;
        this.f16349b = sVar;
        if ((vVar == null) == (sVar == null)) {
            return;
        }
        if (vVar == null) {
            str = "Star projection must have no type specified.";
        } else {
            str = "The projection variance " + vVar + " requires type to be specified.";
        }
        throw new IllegalArgumentException(str.toString());
    }

    @in.n
    @os.l
    public static final u c(@os.l s sVar) {
        return f16346c.a(sVar);
    }

    public static u e(u uVar, v vVar, s sVar, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            vVar = uVar.f16348a;
        }
        if ((i10 & 2) != 0) {
            sVar = uVar.f16349b;
        }
        uVar.getClass();
        return new u(vVar, sVar);
    }

    @in.n
    @os.l
    public static final u f(@os.l s sVar) {
        return f16346c.b(sVar);
    }

    @in.n
    @os.l
    public static final u i(@os.l s sVar) {
        return f16346c.e(sVar);
    }

    @os.m
    public final v a() {
        return this.f16348a;
    }

    @os.m
    public final s b() {
        return this.f16349b;
    }

    @os.l
    public final u d(@os.m v vVar, @os.m s sVar) {
        return new u(vVar, sVar);
    }

    public boolean equals(@os.m Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof u)) {
            return false;
        }
        u uVar = (u) obj;
        return this.f16348a == uVar.f16348a && l0.g(this.f16349b, uVar.f16349b);
    }

    @os.m
    public final s g() {
        return this.f16349b;
    }

    @os.m
    public final v h() {
        return this.f16348a;
    }

    public int hashCode() {
        v vVar = this.f16348a;
        int iHashCode = (vVar == null ? 0 : vVar.hashCode()) * 31;
        s sVar = this.f16349b;
        return iHashCode + (sVar != null ? sVar.hashCode() : 0);
    }

    @os.l
    public String toString() {
        v vVar = this.f16348a;
        int i10 = vVar == null ? -1 : b.f16350a[vVar.ordinal()];
        if (i10 == -1) {
            return "*";
        }
        if (i10 == 1) {
            return String.valueOf(this.f16349b);
        }
        if (i10 == 2) {
            return "in " + this.f16349b;
        }
        if (i10 != 3) {
            throw new i0();
        }
        return "out " + this.f16349b;
    }
}
