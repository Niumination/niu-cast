package tn;

/* JADX INFO: loaded from: classes3.dex */
public final class d implements f<Double> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final double f15902a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final double f15903b;

    public d(double d10, double d11) {
        this.f15902a = d10;
        this.f15903b = d11;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // tn.f
    public /* bridge */ /* synthetic */ boolean a(Comparable comparable, Comparable comparable2) {
        return e(((Number) comparable).doubleValue(), ((Number) comparable2).doubleValue());
    }

    public boolean b(double d10) {
        return d10 >= this.f15902a && d10 <= this.f15903b;
    }

    @os.l
    public Double c() {
        return Double.valueOf(this.f15903b);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // tn.f, tn.g
    public /* bridge */ /* synthetic */ boolean contains(Comparable comparable) {
        return b(((Number) comparable).doubleValue());
    }

    @os.l
    public Double d() {
        return Double.valueOf(this.f15902a);
    }

    public boolean e(double d10, double d11) {
        return d10 <= d11;
    }

    public boolean equals(@os.m Object obj) {
        if (obj instanceof d) {
            if (!isEmpty() || !((d) obj).isEmpty()) {
                d dVar = (d) obj;
                if (this.f15902a != dVar.f15902a || this.f15903b != dVar.f15903b) {
                }
            }
            return true;
        }
        return false;
    }

    @Override // tn.g
    public Comparable getEndInclusive() {
        return Double.valueOf(this.f15903b);
    }

    @Override // tn.g
    public Comparable getStart() {
        return Double.valueOf(this.f15902a);
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return Double.hashCode(this.f15903b) + (Double.hashCode(this.f15902a) * 31);
    }

    @Override // tn.f, tn.g
    public boolean isEmpty() {
        return this.f15902a > this.f15903b;
    }

    @os.l
    public String toString() {
        return this.f15902a + ".." + this.f15903b;
    }
}
