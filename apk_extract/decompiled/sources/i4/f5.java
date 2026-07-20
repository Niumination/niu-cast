package i4;

import k3.v8;

/* JADX INFO: loaded from: classes.dex */
public final class f5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f5592a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final o4 f5593b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object[] f5594c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f5595d;
    public Object e;

    public f5(o4 o4Var, int i8) {
        this.f5593b = o4Var;
        this.f5592a = i8;
        v8.b(i8, "k (%s) must be >= 0", i8 >= 0);
        v8.b(i8, "k (%s) must be <= Integer.MAX_VALUE / 2", i8 <= 1073741823);
        long j8 = ((long) i8) * ((long) 2);
        int i9 = (int) j8;
        if (j8 != i9) {
            throw new ArithmeticException(h0.a.h(i8, "overflow: checkedMultiply(", ", 2)"));
        }
        this.f5594c = new Object[i9];
        this.f5595d = 0;
        this.e = null;
    }
}
