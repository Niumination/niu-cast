package ql;

/* JADX INFO: loaded from: classes2.dex */
@in.i(name = "ByteOrderJVMKt")
public final class b {
    public static final double a(double d10) {
        return Double.longBitsToDouble(Long.reverseBytes(Double.doubleToRawLongBits(d10)));
    }

    public static final float b(float f10) {
        return Float.intBitsToFloat(Integer.reverseBytes(Float.floatToRawIntBits(f10)));
    }

    public static final int c(int i10) {
        return Integer.reverseBytes(i10);
    }

    public static final long d(long j10) {
        return Long.reverseBytes(j10);
    }

    public static final short e(short s10) {
        return Short.reverseBytes(s10);
    }
}
