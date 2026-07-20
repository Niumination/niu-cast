package tn;

import lm.f1;
import lm.p2;
import lm.w1;

/* JADX INFO: loaded from: classes3.dex */
@f1(version = "1.5")
@p2(markerClass = {lm.t.class})
public final class x extends v implements g<w1>, r<w1> {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @os.l
    public static final a f15942e = new a();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @os.l
    public static final x f15943f = new x(-1, 0, 1);

    public static final class a {
        public a() {
        }

        @os.l
        public final x a() {
            return x.f15943f;
        }

        public a(kn.w wVar) {
        }
    }

    public x(int i10, int i11) {
        super(i10, i11, 1);
    }

    @f1(version = "1.9")
    @lm.k(message = "Can throw an exception when it's impossible to represent the value with UInt type, for example, when the range includes MAX_VALUE. It's recommended to use 'endInclusive' property that doesn't throw.")
    @p2(markerClass = {lm.r.class})
    public static /* synthetic */ void m() {
    }

    @Override // tn.r
    public /* bridge */ /* synthetic */ Comparable c() {
        return w1.b(l());
    }

    @Override // tn.g
    public /* synthetic */ boolean contains(Comparable comparable) {
        return j(((w1) comparable).f10227a);
    }

    @Override // tn.v
    public boolean equals(@os.m Object obj) {
        if (obj instanceof x) {
            if (!isEmpty() || !((x) obj).isEmpty()) {
                x xVar = (x) obj;
                if (this.f15935a != xVar.f15935a || this.f15936b != xVar.f15936b) {
                }
            }
            return true;
        }
        return false;
    }

    @Override // tn.g
    public Comparable getEndInclusive() {
        return w1.b(this.f15936b);
    }

    @Override // tn.g
    public Comparable getStart() {
        return w1.b(this.f15935a);
    }

    @Override // tn.v
    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return this.f15936b + (this.f15935a * 31);
    }

    @Override // tn.v, tn.g
    public boolean isEmpty() {
        return Integer.compareUnsigned(this.f15935a, this.f15936b) > 0;
    }

    public boolean j(int i10) {
        return Integer.compareUnsigned(this.f15935a, i10) <= 0 && Integer.compareUnsigned(i10, this.f15936b) <= 0;
    }

    public int l() {
        int i10 = this.f15936b;
        if (i10 != -1) {
            return w1.m(i10 + 1);
        }
        throw new IllegalStateException("Cannot return the exclusive upper bound of a range that includes MAX_VALUE.");
    }

    public int n() {
        return this.f15936b;
    }

    public int o() {
        return this.f15935a;
    }

    @Override // tn.v
    @os.l
    public String toString() {
        return ((Object) w1.h0(this.f15935a)) + ".." + ((Object) w1.h0(this.f15936b));
    }

    public x(int i10, int i11, kn.w wVar) {
        super(i10, i11, 1);
    }
}
