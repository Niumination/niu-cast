package tj;

/* JADX INFO: loaded from: classes2.dex */
public final class j1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final p0 f15632a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f15633b;

    public j1(p0 p0Var, boolean z10) {
        this.f15632a = p0Var;
        this.f15633b = z10;
    }

    public j1 a(p0 p0Var) {
        return p0Var == this.f15632a ? this : new j1(p0Var, this.f15633b);
    }

    public boolean b() {
        return this.f15633b;
    }

    public p0 c() {
        return this.f15632a;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof j1)) {
            return false;
        }
        j1 j1Var = (j1) obj;
        return j1Var.f15632a.equals(this.f15632a) && j1Var.f15633b == this.f15633b;
    }

    public int hashCode() {
        return (((this.f15632a.hashCode() + 41) * 41) + (this.f15633b ? 1 : 0)) * 41;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder("${");
        sb2.append(this.f15633b ? "?" : "");
        sb2.append(this.f15632a.k());
        sb2.append("}");
        return sb2.toString();
    }
}
