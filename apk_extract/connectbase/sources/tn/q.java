package tn;

/* JADX INFO: loaded from: classes3.dex */
public final class q implements r<Float> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f15932a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f15933b;

    public q(float f10, float f11) {
        this.f15932a = f10;
        this.f15933b = f11;
    }

    private final boolean e(float f10, float f11) {
        return f10 <= f11;
    }

    public boolean a(float f10) {
        return f10 >= this.f15932a && f10 < this.f15933b;
    }

    @os.l
    public Float b() {
        return Float.valueOf(this.f15933b);
    }

    @Override // tn.r
    public Comparable c() {
        return Float.valueOf(this.f15933b);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // tn.r
    public /* bridge */ /* synthetic */ boolean contains(Comparable comparable) {
        return a(((Number) comparable).floatValue());
    }

    @os.l
    public Float d() {
        return Float.valueOf(this.f15932a);
    }

    public boolean equals(@os.m Object obj) {
        if (obj instanceof q) {
            if (!isEmpty() || !((q) obj).isEmpty()) {
                q qVar = (q) obj;
                if (this.f15932a != qVar.f15932a || this.f15933b != qVar.f15933b) {
                }
            }
            return true;
        }
        return false;
    }

    @Override // tn.r
    public Comparable getStart() {
        return Float.valueOf(this.f15932a);
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return Float.hashCode(this.f15933b) + (Float.hashCode(this.f15932a) * 31);
    }

    @Override // tn.r
    public boolean isEmpty() {
        return this.f15932a >= this.f15933b;
    }

    @os.l
    public String toString() {
        return this.f15932a + "..<" + this.f15933b;
    }
}
