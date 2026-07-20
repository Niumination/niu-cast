package f2;

/* JADX INFO: loaded from: classes.dex */
public final class b0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f5678a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f5679b;

    public b0(int i10, int i11) {
        this.f5678a = i10;
        this.f5679b = i11;
    }

    public static b0 d(b0 b0Var, int i10, int i11, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i10 = b0Var.f5678a;
        }
        if ((i12 & 2) != 0) {
            i11 = b0Var.f5679b;
        }
        b0Var.getClass();
        return new b0(i10, i11);
    }

    public final int a() {
        return this.f5678a;
    }

    public final int b() {
        return this.f5679b;
    }

    @os.l
    public final b0 c(int i10, int i11) {
        return new b0(i10, i11);
    }

    public final int e() {
        return this.f5679b;
    }

    public boolean equals(@os.m Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b0)) {
            return false;
        }
        b0 b0Var = (b0) obj;
        return this.f5678a == b0Var.f5678a && this.f5679b == b0Var.f5679b;
    }

    public final int f() {
        return this.f5678a;
    }

    public int hashCode() {
        return Integer.hashCode(this.f5679b) + (Integer.hashCode(this.f5678a) * 31);
    }

    @os.l
    public String toString() {
        StringBuilder sb2 = new StringBuilder("RefVec2(w=");
        sb2.append(this.f5678a);
        sb2.append(", h=");
        return u.a.a(sb2, this.f5679b, ')');
    }
}
