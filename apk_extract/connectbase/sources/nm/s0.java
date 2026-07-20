package nm;

/* JADX INFO: loaded from: classes3.dex */
public final class s0<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f11691a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final T f11692b;

    public s0(int i10, T t10) {
        this.f11691a = i10;
        this.f11692b = t10;
    }

    public static s0 d(s0 s0Var, int i10, Object obj, int i11, Object obj2) {
        if ((i11 & 1) != 0) {
            i10 = s0Var.f11691a;
        }
        if ((i11 & 2) != 0) {
            obj = s0Var.f11692b;
        }
        s0Var.getClass();
        return new s0(i10, obj);
    }

    public final int a() {
        return this.f11691a;
    }

    public final T b() {
        return this.f11692b;
    }

    @os.l
    public final s0<T> c(int i10, T t10) {
        return new s0<>(i10, t10);
    }

    public final int e() {
        return this.f11691a;
    }

    public boolean equals(@os.m Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof s0)) {
            return false;
        }
        s0 s0Var = (s0) obj;
        return this.f11691a == s0Var.f11691a && kn.l0.g(this.f11692b, s0Var.f11692b);
    }

    public final T f() {
        return this.f11692b;
    }

    public int hashCode() {
        int iHashCode = Integer.hashCode(this.f11691a) * 31;
        T t10 = this.f11692b;
        return iHashCode + (t10 == null ? 0 : t10.hashCode());
    }

    @os.l
    public String toString() {
        return "IndexedValue(index=" + this.f11691a + ", value=" + this.f11692b + ')';
    }
}
