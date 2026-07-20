package kotlin;

import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.internal.InlineOnly;
import kotlin.internal.IntrinsicConstEvaluation;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0010\b\n\u0002\u0010\u0005\n\u0002\b\u0002\n\u0002\u0010\n\n\u0002\u0010\t\n\u0002\u0010\u0007\n\u0002\u0010\u0006\n\u0000\u001a\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0087\b\u001a\u0015\u0010\u0004\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0087\b\u001a\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0005H\u0087\b\u001a\u0015\u0010\u0004\u001a\u00020\u0005*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0005H\u0087\b\u001a\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0001H\u0087\b\u001a\u0015\u0010\u0004\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0001H\u0087\b\u001a\u0015\u0010\u0000\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0006H\u0087\b\u001a\u0015\u0010\u0004\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0006H\u0087\b\u001a\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u0002H\u0087\b\u001a\u0015\u0010\u0004\u001a\u00020\u0002*\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u0002H\u0087\b\u001a\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u0005H\u0087\b\u001a\u0015\u0010\u0004\u001a\u00020\u0005*\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u0005H\u0087\b\u001a\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u0001H\u0087\b\u001a\u0015\u0010\u0004\u001a\u00020\u0001*\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u0001H\u0087\b\u001a\u0015\u0010\u0000\u001a\u00020\u0006*\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u0006H\u0087\b\u001a\u0015\u0010\u0004\u001a\u00020\u0006*\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u0006H\u0087\b\u001a\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0002H\u0087\b\u001a\u0015\u0010\u0004\u001a\u00020\u0002*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0002H\u0087\b\u001a\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0005H\u0087\b\u001a\u0015\u0010\u0004\u001a\u00020\u0005*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0005H\u0087\b\u001a\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0001H\u0087\b\u001a\u0015\u0010\u0004\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0001H\u0087\b\u001a\u0015\u0010\u0000\u001a\u00020\u0006*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0006H\u0087\b\u001a\u0015\u0010\u0004\u001a\u00020\u0006*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0006H\u0087\b\u001a\u0015\u0010\u0000\u001a\u00020\u0006*\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0087\b\u001a\u0015\u0010\u0004\u001a\u00020\u0002*\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0087\b\u001a\u0015\u0010\u0000\u001a\u00020\u0006*\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0005H\u0087\b\u001a\u0015\u0010\u0004\u001a\u00020\u0005*\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0005H\u0087\b\u001a\u0015\u0010\u0000\u001a\u00020\u0006*\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0001H\u0087\b\u001a\u0015\u0010\u0004\u001a\u00020\u0001*\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0001H\u0087\b\u001a\u0015\u0010\u0000\u001a\u00020\u0006*\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0006H\u0087\b\u001a\u0015\u0010\u0004\u001a\u00020\u0006*\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0006H\u0087\b\u001a\u0015\u0010\u0004\u001a\u00020\u0007*\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0007H\u0087\b\u001a\u0015\u0010\u0004\u001a\u00020\b*\u00020\u00072\u0006\u0010\u0003\u001a\u00020\bH\u0087\b\u001a\u0015\u0010\u0004\u001a\u00020\b*\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0007H\u0087\b\u001a\u0015\u0010\u0004\u001a\u00020\b*\u00020\b2\u0006\u0010\u0003\u001a\u00020\bH\u0087\b¨\u0006\t"}, d2 = {"floorDiv", "", "", "other", "mod", "", "", "", "", "kotlin-stdlib"}, k = 5, mv = {2, 1, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_EDITOR_ABSOLUTEX, xs = "kotlin/NumbersKt")
class NumbersKt__FloorDivModKt extends NumbersKt__BigIntegersKt {
    @SinceKotlin(version = "1.5")
    @IntrinsicConstEvaluation
    @InlineOnly
    private static final int floorDiv(byte b9, byte b10) {
        int i8 = b9 / b10;
        return ((b9 ^ b10) >= 0 || b10 * i8 == b9) ? i8 : i8 - 1;
    }

    @SinceKotlin(version = "1.5")
    @IntrinsicConstEvaluation
    @InlineOnly
    private static final byte mod(byte b9, byte b10) {
        int i8 = b9 % b10;
        return (byte) (i8 + (b10 & (((i8 ^ b10) & ((-i8) | i8)) >> 31)));
    }

    @SinceKotlin(version = "1.5")
    @IntrinsicConstEvaluation
    @InlineOnly
    private static final int floorDiv(byte b9, short s2) {
        int i8 = b9 / s2;
        return ((b9 ^ s2) >= 0 || s2 * i8 == b9) ? i8 : i8 - 1;
    }

    @SinceKotlin(version = "1.5")
    @IntrinsicConstEvaluation
    @InlineOnly
    private static final short mod(byte b9, short s2) {
        int i8 = b9 % s2;
        return (short) (i8 + (s2 & (((i8 ^ s2) & ((-i8) | i8)) >> 31)));
    }

    @SinceKotlin(version = "1.5")
    @IntrinsicConstEvaluation
    @InlineOnly
    private static final int floorDiv(byte b9, int i8) {
        int i9 = b9 / i8;
        return ((b9 ^ i8) >= 0 || i8 * i9 == b9) ? i9 : i9 - 1;
    }

    @SinceKotlin(version = "1.5")
    @IntrinsicConstEvaluation
    @InlineOnly
    private static final int mod(byte b9, int i8) {
        int i9 = b9 % i8;
        return i9 + (i8 & (((i9 ^ i8) & ((-i9) | i9)) >> 31));
    }

    @SinceKotlin(version = "1.5")
    @IntrinsicConstEvaluation
    @InlineOnly
    private static final long floorDiv(byte b9, long j8) {
        long j10 = b9;
        long j11 = j10 / j8;
        return ((j10 ^ j8) >= 0 || j8 * j11 == j10) ? j11 : j11 - 1;
    }

    @SinceKotlin(version = "1.5")
    @IntrinsicConstEvaluation
    @InlineOnly
    private static final long mod(byte b9, long j8) {
        long j10 = ((long) b9) % j8;
        return j10 + (j8 & (((j10 ^ j8) & ((-j10) | j10)) >> 63));
    }

    @SinceKotlin(version = "1.5")
    @IntrinsicConstEvaluation
    @InlineOnly
    private static final int floorDiv(short s2, byte b9) {
        int i8 = s2 / b9;
        return ((s2 ^ b9) >= 0 || b9 * i8 == s2) ? i8 : i8 - 1;
    }

    @SinceKotlin(version = "1.5")
    @IntrinsicConstEvaluation
    @InlineOnly
    private static final byte mod(short s2, byte b9) {
        int i8 = s2 % b9;
        return (byte) (i8 + (b9 & (((i8 ^ b9) & ((-i8) | i8)) >> 31)));
    }

    @SinceKotlin(version = "1.5")
    @IntrinsicConstEvaluation
    @InlineOnly
    private static final int floorDiv(short s2, short s3) {
        int i8 = s2 / s3;
        return ((s2 ^ s3) >= 0 || s3 * i8 == s2) ? i8 : i8 - 1;
    }

    @SinceKotlin(version = "1.5")
    @IntrinsicConstEvaluation
    @InlineOnly
    private static final short mod(short s2, short s3) {
        int i8 = s2 % s3;
        return (short) (i8 + (s3 & (((i8 ^ s3) & ((-i8) | i8)) >> 31)));
    }

    @SinceKotlin(version = "1.5")
    @IntrinsicConstEvaluation
    @InlineOnly
    private static final int floorDiv(short s2, int i8) {
        int i9 = s2 / i8;
        return ((s2 ^ i8) >= 0 || i8 * i9 == s2) ? i9 : i9 - 1;
    }

    @SinceKotlin(version = "1.5")
    @IntrinsicConstEvaluation
    @InlineOnly
    private static final int mod(short s2, int i8) {
        int i9 = s2 % i8;
        return i9 + (i8 & (((i9 ^ i8) & ((-i9) | i9)) >> 31));
    }

    @SinceKotlin(version = "1.5")
    @IntrinsicConstEvaluation
    @InlineOnly
    private static final long floorDiv(short s2, long j8) {
        long j10 = s2;
        long j11 = j10 / j8;
        return ((j10 ^ j8) >= 0 || j8 * j11 == j10) ? j11 : j11 - 1;
    }

    @SinceKotlin(version = "1.5")
    @IntrinsicConstEvaluation
    @InlineOnly
    private static final long mod(short s2, long j8) {
        long j10 = ((long) s2) % j8;
        return j10 + (j8 & (((j10 ^ j8) & ((-j10) | j10)) >> 63));
    }

    @SinceKotlin(version = "1.5")
    @IntrinsicConstEvaluation
    @InlineOnly
    private static final int floorDiv(int i8, byte b9) {
        int i9 = i8 / b9;
        return ((i8 ^ b9) >= 0 || b9 * i9 == i8) ? i9 : i9 - 1;
    }

    @SinceKotlin(version = "1.5")
    @IntrinsicConstEvaluation
    @InlineOnly
    private static final byte mod(int i8, byte b9) {
        int i9 = i8 % b9;
        return (byte) (i9 + (b9 & (((i9 ^ b9) & ((-i9) | i9)) >> 31)));
    }

    @SinceKotlin(version = "1.5")
    @IntrinsicConstEvaluation
    @InlineOnly
    private static final int floorDiv(int i8, short s2) {
        int i9 = i8 / s2;
        return ((i8 ^ s2) >= 0 || s2 * i9 == i8) ? i9 : i9 - 1;
    }

    @SinceKotlin(version = "1.5")
    @IntrinsicConstEvaluation
    @InlineOnly
    private static final short mod(int i8, short s2) {
        int i9 = i8 % s2;
        return (short) (i9 + (s2 & (((i9 ^ s2) & ((-i9) | i9)) >> 31)));
    }

    @SinceKotlin(version = "1.5")
    @IntrinsicConstEvaluation
    @InlineOnly
    private static final int floorDiv(int i8, int i9) {
        int i10 = i8 / i9;
        return ((i8 ^ i9) >= 0 || i9 * i10 == i8) ? i10 : i10 - 1;
    }

    @SinceKotlin(version = "1.5")
    @IntrinsicConstEvaluation
    @InlineOnly
    private static final int mod(int i8, int i9) {
        int i10 = i8 % i9;
        return i10 + (i9 & (((i10 ^ i9) & ((-i10) | i10)) >> 31));
    }

    @SinceKotlin(version = "1.5")
    @IntrinsicConstEvaluation
    @InlineOnly
    private static final long floorDiv(int i8, long j8) {
        long j10 = i8;
        long j11 = j10 / j8;
        return ((j10 ^ j8) >= 0 || j8 * j11 == j10) ? j11 : j11 - 1;
    }

    @SinceKotlin(version = "1.5")
    @IntrinsicConstEvaluation
    @InlineOnly
    private static final long mod(int i8, long j8) {
        long j10 = ((long) i8) % j8;
        return j10 + (j8 & (((j10 ^ j8) & ((-j10) | j10)) >> 63));
    }

    @SinceKotlin(version = "1.5")
    @IntrinsicConstEvaluation
    @InlineOnly
    private static final long floorDiv(long j8, byte b9) {
        long j10 = b9;
        long j11 = j8 / j10;
        return ((j8 ^ j10) >= 0 || j10 * j11 == j8) ? j11 : j11 - 1;
    }

    @SinceKotlin(version = "1.5")
    @IntrinsicConstEvaluation
    @InlineOnly
    private static final byte mod(long j8, byte b9) {
        long j10 = b9;
        long j11 = j8 % j10;
        return (byte) (j11 + (j10 & (((j11 ^ j10) & ((-j11) | j11)) >> 63)));
    }

    @SinceKotlin(version = "1.5")
    @IntrinsicConstEvaluation
    @InlineOnly
    private static final long floorDiv(long j8, short s2) {
        long j10 = s2;
        long j11 = j8 / j10;
        return ((j8 ^ j10) >= 0 || j10 * j11 == j8) ? j11 : j11 - 1;
    }

    @SinceKotlin(version = "1.5")
    @IntrinsicConstEvaluation
    @InlineOnly
    private static final short mod(long j8, short s2) {
        long j10 = s2;
        long j11 = j8 % j10;
        return (short) (j11 + (j10 & (((j11 ^ j10) & ((-j11) | j11)) >> 63)));
    }

    @SinceKotlin(version = "1.5")
    @IntrinsicConstEvaluation
    @InlineOnly
    private static final long floorDiv(long j8, int i8) {
        long j10 = i8;
        long j11 = j8 / j10;
        return ((j8 ^ j10) >= 0 || j10 * j11 == j8) ? j11 : j11 - 1;
    }

    @SinceKotlin(version = "1.5")
    @IntrinsicConstEvaluation
    @InlineOnly
    private static final int mod(long j8, int i8) {
        long j10 = i8;
        long j11 = j8 % j10;
        return (int) (j11 + (j10 & (((j11 ^ j10) & ((-j11) | j11)) >> 63)));
    }

    @SinceKotlin(version = "1.5")
    @IntrinsicConstEvaluation
    @InlineOnly
    private static final long floorDiv(long j8, long j10) {
        long j11 = j8 / j10;
        return ((j8 ^ j10) >= 0 || j10 * j11 == j8) ? j11 : j11 - 1;
    }

    @SinceKotlin(version = "1.5")
    @IntrinsicConstEvaluation
    @InlineOnly
    private static final long mod(long j8, long j10) {
        long j11 = j8 % j10;
        return j11 + (j10 & (((j11 ^ j10) & ((-j11) | j11)) >> 63));
    }

    @SinceKotlin(version = "1.5")
    @IntrinsicConstEvaluation
    @InlineOnly
    private static final float mod(float f, float f4) {
        float f10 = f % f4;
        return (f10 == 0.0f || Math.signum(f10) == Math.signum(f4)) ? f10 : f10 + f4;
    }

    @SinceKotlin(version = "1.5")
    @IntrinsicConstEvaluation
    @InlineOnly
    private static final double mod(float f, double d7) {
        double d10 = ((double) f) % d7;
        return (d10 == 0.0d || Math.signum(d10) == Math.signum(d7)) ? d10 : d10 + d7;
    }

    @SinceKotlin(version = "1.5")
    @IntrinsicConstEvaluation
    @InlineOnly
    private static final double mod(double d7, float f) {
        double d10 = f;
        double d11 = d7 % d10;
        return (d11 == 0.0d || Math.signum(d11) == Math.signum(d10)) ? d11 : d11 + d10;
    }

    @SinceKotlin(version = "1.5")
    @IntrinsicConstEvaluation
    @InlineOnly
    private static final double mod(double d7, double d10) {
        double d11 = d7 % d10;
        return (d11 == 0.0d || Math.signum(d11) == Math.signum(d10)) ? d11 : d11 + d10;
    }
}
