package l3;

import sun.misc.Unsafe;

/* JADX INFO: loaded from: classes.dex */
public final class v2 extends w2 {
    public v2(Unsafe unsafe) {
        super(unsafe);
    }

    @Override // l3.w2
    public final double a(long j8, Object obj) {
        return Double.longBitsToDouble(this.f7319a.getLong(obj, j8));
    }

    @Override // l3.w2
    public final float b(long j8, Object obj) {
        return Float.intBitsToFloat(this.f7319a.getInt(obj, j8));
    }

    @Override // l3.w2
    public final void c(Object obj, long j8, boolean z2) {
        if (x2.f7324g) {
            x2.b(obj, j8, z2 ? (byte) 1 : (byte) 0);
        } else {
            x2.c(obj, j8, z2 ? (byte) 1 : (byte) 0);
        }
    }

    @Override // l3.w2
    public final void d(Object obj, long j8, byte b9) {
        if (x2.f7324g) {
            x2.b(obj, j8, b9);
        } else {
            x2.c(obj, j8, b9);
        }
    }

    @Override // l3.w2
    public final void e(Object obj, long j8, double d7) {
        this.f7319a.putLong(obj, j8, Double.doubleToLongBits(d7));
    }

    @Override // l3.w2
    public final void f(Object obj, long j8, float f) {
        this.f7319a.putInt(obj, j8, Float.floatToIntBits(f));
    }

    @Override // l3.w2
    public final boolean g(long j8, Object obj) {
        return x2.f7324g ? x2.q(j8, obj) : x2.r(j8, obj);
    }
}
