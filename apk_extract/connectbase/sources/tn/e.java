package tn;

/* JADX INFO: loaded from: classes3.dex */
public final class e implements f<Float> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f15904a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f15905b;

    public e(float f10, float f11) {
        this.f15904a = f10;
        this.f15905b = f11;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // tn.f
    public /* bridge */ /* synthetic */ boolean a(Comparable comparable, Comparable comparable2) {
        return e(((Number) comparable).floatValue(), ((Number) comparable2).floatValue());
    }

    public boolean b(float f10) {
        return f10 >= this.f15904a && f10 <= this.f15905b;
    }

    @os.l
    public Float c() {
        return Float.valueOf(this.f15905b);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // tn.f, tn.g
    public /* bridge */ /* synthetic */ boolean contains(Comparable comparable) {
        return b(((Number) comparable).floatValue());
    }

    @os.l
    public Float d() {
        return Float.valueOf(this.f15904a);
    }

    public boolean e(float f10, float f11) {
        return f10 <= f11;
    }

    public boolean equals(@os.m Object obj) {
        if (obj instanceof e) {
            if (!isEmpty() || !((e) obj).isEmpty()) {
                e eVar = (e) obj;
                if (this.f15904a != eVar.f15904a || this.f15905b != eVar.f15905b) {
                }
            }
            return true;
        }
        return false;
    }

    @Override // tn.g
    public Comparable getEndInclusive() {
        return Float.valueOf(this.f15905b);
    }

    @Override // tn.g
    public Comparable getStart() {
        return Float.valueOf(this.f15904a);
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return Float.hashCode(this.f15905b) + (Float.hashCode(this.f15904a) * 31);
    }

    @Override // tn.f, tn.g
    public boolean isEmpty() {
        return this.f15904a > this.f15905b;
    }

    @os.l
    public String toString() {
        return this.f15904a + ".." + this.f15905b;
    }
}
