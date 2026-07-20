package tn;

/* JADX INFO: loaded from: classes3.dex */
public final class p implements r<Double> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final double f15930a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final double f15931b;

    public p(double d10, double d11) {
        this.f15930a = d10;
        this.f15931b = d11;
    }

    private final boolean e(double d10, double d11) {
        return d10 <= d11;
    }

    public boolean a(double d10) {
        return d10 >= this.f15930a && d10 < this.f15931b;
    }

    @os.l
    public Double b() {
        return Double.valueOf(this.f15931b);
    }

    @Override // tn.r
    public Comparable c() {
        return Double.valueOf(this.f15931b);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // tn.r
    public /* bridge */ /* synthetic */ boolean contains(Comparable comparable) {
        return a(((Number) comparable).doubleValue());
    }

    @os.l
    public Double d() {
        return Double.valueOf(this.f15930a);
    }

    public boolean equals(@os.m Object obj) {
        if (obj instanceof p) {
            if (!isEmpty() || !((p) obj).isEmpty()) {
                p pVar = (p) obj;
                if (this.f15930a != pVar.f15930a || this.f15931b != pVar.f15931b) {
                }
            }
            return true;
        }
        return false;
    }

    @Override // tn.r
    public Comparable getStart() {
        return Double.valueOf(this.f15930a);
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return Double.hashCode(this.f15931b) + (Double.hashCode(this.f15930a) * 31);
    }

    @Override // tn.r
    public boolean isEmpty() {
        return this.f15930a >= this.f15931b;
    }

    @os.l
    public String toString() {
        return this.f15930a + "..<" + this.f15931b;
    }
}
