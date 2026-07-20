package ul;

import lm.g2;

/* JADX INFO: loaded from: classes2.dex */
@in.g
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f16321a;

    public /* synthetic */ e(int i10) {
        this.f16321a = i10;
    }

    public static final /* synthetic */ e a(int i10) {
        return new e(i10);
    }

    public static final short b(int i10) {
        return g2.m((short) (i10 >>> 16));
    }

    public static final short c(int i10) {
        return g2.m((short) (i10 & 65535));
    }

    public static int d(int i10) {
        return i10;
    }

    public static int e(short s10, short s11) {
        return ((s10 & g2.f10190d) << 16) | (s11 & g2.f10190d);
    }

    public static boolean f(int i10, Object obj) {
        return (obj instanceof e) && i10 == ((e) obj).f16321a;
    }

    public static final boolean g(int i10, int i11) {
        return i10 == i11;
    }

    public static final short h(int i10) {
        return g2.m((short) (i10 & 65535));
    }

    public static final short i(int i10) {
        return g2.m((short) (i10 >>> 16));
    }

    public static int k(int i10) {
        return Integer.hashCode(i10);
    }

    public static String l(int i10) {
        return "EncodeResult(value=" + i10 + ')';
    }

    public boolean equals(Object obj) {
        return f(this.f16321a, obj);
    }

    public int hashCode() {
        return Integer.hashCode(this.f16321a);
    }

    public final int j() {
        return this.f16321a;
    }

    public final /* synthetic */ int m() {
        return this.f16321a;
    }

    public String toString() {
        return l(this.f16321a);
    }
}
