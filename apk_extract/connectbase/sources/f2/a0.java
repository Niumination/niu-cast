package f2;

/* JADX INFO: loaded from: classes.dex */
public final class a0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f5666a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f5667b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f5668c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f5669d;

    public a0(int i10, int i11, int i12, int i13) {
        this.f5666a = i10;
        this.f5667b = i11;
        this.f5668c = i12;
        this.f5669d = i13;
    }

    public static a0 f(a0 a0Var, int i10, int i11, int i12, int i13, int i14, Object obj) {
        if ((i14 & 1) != 0) {
            i10 = a0Var.f5666a;
        }
        if ((i14 & 2) != 0) {
            i11 = a0Var.f5667b;
        }
        if ((i14 & 4) != 0) {
            i12 = a0Var.f5668c;
        }
        if ((i14 & 8) != 0) {
            i13 = a0Var.f5669d;
        }
        a0Var.getClass();
        return new a0(i10, i11, i12, i13);
    }

    public final int a() {
        return this.f5666a;
    }

    public final int b() {
        return this.f5667b;
    }

    public final int c() {
        return this.f5668c;
    }

    public final int d() {
        return this.f5669d;
    }

    @os.l
    public final a0 e(int i10, int i11, int i12, int i13) {
        return new a0(i10, i11, i12, i13);
    }

    public boolean equals(@os.m Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a0)) {
            return false;
        }
        a0 a0Var = (a0) obj;
        return this.f5666a == a0Var.f5666a && this.f5667b == a0Var.f5667b && this.f5668c == a0Var.f5668c && this.f5669d == a0Var.f5669d;
    }

    public final int g() {
        return this.f5669d;
    }

    public final int h() {
        return this.f5668c;
    }

    public int hashCode() {
        return Integer.hashCode(this.f5669d) + k0.d.a(this.f5668c, k0.d.a(this.f5667b, Integer.hashCode(this.f5666a) * 31, 31), 31);
    }

    public final int i() {
        return this.f5666a;
    }

    public final int j() {
        return this.f5667b;
    }

    @os.l
    public String toString() {
        StringBuilder sb2 = new StringBuilder("PointRect(x=");
        sb2.append(this.f5666a);
        sb2.append(", y=");
        sb2.append(this.f5667b);
        sb2.append(", w=");
        sb2.append(this.f5668c);
        sb2.append(", h=");
        return u.a.a(sb2, this.f5669d, ')');
    }
}
