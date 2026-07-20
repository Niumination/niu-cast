package kotlin.comparisons;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.internal.InlineOnly;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000J\n\u0002\b\u0002\n\u0002\u0010\u000f\n\u0002\b\u0003\n\u0002\u0010\u0005\n\u0002\u0010\n\n\u0002\u0010\b\n\u0002\u0010\t\n\u0002\u0010\u0007\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0012\n\u0002\u0010\u0017\n\u0002\u0010\u0015\n\u0002\u0010\u0016\n\u0002\u0010\u0014\n\u0002\u0010\u0013\n\u0002\b\u0002\u001a-\u0010\u0000\u001a\u0002H\u0001\"\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u00022\u0006\u0010\u0003\u001a\u0002H\u00012\u0006\u0010\u0004\u001a\u0002H\u0001H\u0007¢\u0006\u0002\u0010\u0005\u001a\u0019\u0010\u0000\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u0006H\u0087\b\u001a\u0019\u0010\u0000\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0007H\u0087\b\u001a\u0019\u0010\u0000\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\bH\u0087\b\u001a\u0019\u0010\u0000\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\tH\u0087\b\u001a\u0019\u0010\u0000\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\nH\u0087\b\u001a\u0019\u0010\u0000\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u000bH\u0087\b\u001a5\u0010\u0000\u001a\u0002H\u0001\"\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u00022\u0006\u0010\u0003\u001a\u0002H\u00012\u0006\u0010\u0004\u001a\u0002H\u00012\u0006\u0010\f\u001a\u0002H\u0001H\u0007¢\u0006\u0002\u0010\r\u001a!\u0010\u0000\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u0006H\u0087\b\u001a!\u0010\u0000\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u0007H\u0087\b\u001a!\u0010\u0000\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\bH\u0087\b\u001a!\u0010\u0000\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\tH\u0087\b\u001a!\u0010\u0000\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\nH\u0087\b\u001a!\u0010\u0000\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH\u0087\b\u001a9\u0010\u0000\u001a\u0002H\u0001\"\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u00022\u0006\u0010\u0003\u001a\u0002H\u00012\u0012\u0010\u000e\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\u00010\u000f\"\u0002H\u0001H\u0007¢\u0006\u0002\u0010\u0010\u001a\u001c\u0010\u0000\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00062\n\u0010\u000e\u001a\u00020\u0011\"\u00020\u0006H\u0007\u001a\u001c\u0010\u0000\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00072\n\u0010\u000e\u001a\u00020\u0012\"\u00020\u0007H\u0007\u001a\u001c\u0010\u0000\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\b2\n\u0010\u000e\u001a\u00020\u0013\"\u00020\bH\u0007\u001a\u001c\u0010\u0000\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\t2\n\u0010\u000e\u001a\u00020\u0014\"\u00020\tH\u0007\u001a\u001c\u0010\u0000\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\n2\n\u0010\u000e\u001a\u00020\u0015\"\u00020\nH\u0007\u001a\u001c\u0010\u0000\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u000b2\n\u0010\u000e\u001a\u00020\u0016\"\u00020\u000bH\u0007\u001a-\u0010\u0017\u001a\u0002H\u0001\"\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u00022\u0006\u0010\u0003\u001a\u0002H\u00012\u0006\u0010\u0004\u001a\u0002H\u0001H\u0007¢\u0006\u0002\u0010\u0005\u001a\u0019\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u0006H\u0087\b\u001a\u0019\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0007H\u0087\b\u001a\u0019\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\bH\u0087\b\u001a\u0019\u0010\u0017\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\tH\u0087\b\u001a\u0019\u0010\u0017\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\nH\u0087\b\u001a\u0019\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u000bH\u0087\b\u001a5\u0010\u0017\u001a\u0002H\u0001\"\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u00022\u0006\u0010\u0003\u001a\u0002H\u00012\u0006\u0010\u0004\u001a\u0002H\u00012\u0006\u0010\f\u001a\u0002H\u0001H\u0007¢\u0006\u0002\u0010\r\u001a!\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u0006H\u0087\b\u001a!\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u0007H\u0087\b\u001a!\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\bH\u0087\b\u001a!\u0010\u0017\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\tH\u0087\b\u001a!\u0010\u0017\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\nH\u0087\b\u001a!\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH\u0087\b\u001a9\u0010\u0017\u001a\u0002H\u0001\"\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u00022\u0006\u0010\u0003\u001a\u0002H\u00012\u0012\u0010\u000e\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\u00010\u000f\"\u0002H\u0001H\u0007¢\u0006\u0002\u0010\u0010\u001a\u001c\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00062\n\u0010\u000e\u001a\u00020\u0011\"\u00020\u0006H\u0007\u001a\u001c\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00072\n\u0010\u000e\u001a\u00020\u0012\"\u00020\u0007H\u0007\u001a\u001c\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\b2\n\u0010\u000e\u001a\u00020\u0013\"\u00020\bH\u0007\u001a\u001c\u0010\u0017\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\t2\n\u0010\u000e\u001a\u00020\u0014\"\u00020\tH\u0007\u001a\u001c\u0010\u0017\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\n2\n\u0010\u000e\u001a\u00020\u0015\"\u00020\nH\u0007\u001a\u001c\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u000b2\n\u0010\u000e\u001a\u00020\u0016\"\u00020\u000bH\u0007¨\u0006\u0018"}, d2 = {"maxOf", ExifInterface.GPS_DIRECTION_TRUE, "", "a", "b", "(Ljava/lang/Comparable;Ljava/lang/Comparable;)Ljava/lang/Comparable;", "", "", "", "", "", "", "c", "(Ljava/lang/Comparable;Ljava/lang/Comparable;Ljava/lang/Comparable;)Ljava/lang/Comparable;", "other", "", "(Ljava/lang/Comparable;[Ljava/lang/Comparable;)Ljava/lang/Comparable;", "", "", "", "", "", "", "minOf", "kotlin-stdlib"}, k = 5, mv = {2, 1, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_EDITOR_ABSOLUTEX, xs = "kotlin/comparisons/ComparisonsKt")
public class ComparisonsKt___ComparisonsJvmKt extends ComparisonsKt__ComparisonsKt {
    @SinceKotlin(version = "1.1")
    public static <T extends Comparable<? super T>> T maxOf(T a6, T b9) {
        Intrinsics.checkNotNullParameter(a6, "a");
        Intrinsics.checkNotNullParameter(b9, "b");
        return a6.compareTo(b9) >= 0 ? a6 : b9;
    }

    @SinceKotlin(version = "1.1")
    public static final <T extends Comparable<? super T>> T minOf(T a6, T b9) {
        Intrinsics.checkNotNullParameter(a6, "a");
        Intrinsics.checkNotNullParameter(b9, "b");
        return a6.compareTo(b9) <= 0 ? a6 : b9;
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final byte maxOf(byte b9, byte b10) {
        return (byte) Math.max((int) b9, (int) b10);
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final byte minOf(byte b9, byte b10) {
        return (byte) Math.min((int) b9, (int) b10);
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final short maxOf(short s2, short s3) {
        return (short) Math.max((int) s2, (int) s3);
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final short minOf(short s2, short s3) {
        return (short) Math.min((int) s2, (int) s3);
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final int maxOf(int i8, int i9) {
        return Math.max(i8, i9);
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final int minOf(int i8, int i9) {
        return Math.min(i8, i9);
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final long maxOf(long j8, long j10) {
        return Math.max(j8, j10);
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final long minOf(long j8, long j10) {
        return Math.min(j8, j10);
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final float maxOf(float f, float f4) {
        return Math.max(f, f4);
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final float minOf(float f, float f4) {
        return Math.min(f, f4);
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final double maxOf(double d7, double d10) {
        return Math.max(d7, d10);
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final double minOf(double d7, double d10) {
        return Math.min(d7, d10);
    }

    @SinceKotlin(version = "1.1")
    public static final <T extends Comparable<? super T>> T maxOf(T a6, T b9, T c9) {
        Intrinsics.checkNotNullParameter(a6, "a");
        Intrinsics.checkNotNullParameter(b9, "b");
        Intrinsics.checkNotNullParameter(c9, "c");
        return (T) maxOf(a6, maxOf(b9, c9));
    }

    @SinceKotlin(version = "1.1")
    public static final <T extends Comparable<? super T>> T minOf(T a6, T b9, T c9) {
        Intrinsics.checkNotNullParameter(a6, "a");
        Intrinsics.checkNotNullParameter(b9, "b");
        Intrinsics.checkNotNullParameter(c9, "c");
        return (T) minOf(a6, minOf(b9, c9));
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final byte maxOf(byte b9, byte b10, byte b11) {
        return (byte) Math.max((int) b9, Math.max((int) b10, (int) b11));
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final byte minOf(byte b9, byte b10, byte b11) {
        return (byte) Math.min((int) b9, Math.min((int) b10, (int) b11));
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final short maxOf(short s2, short s3, short s10) {
        return (short) Math.max((int) s2, Math.max((int) s3, (int) s10));
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final short minOf(short s2, short s3, short s10) {
        return (short) Math.min((int) s2, Math.min((int) s3, (int) s10));
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final int maxOf(int i8, int i9, int i10) {
        return Math.max(i8, Math.max(i9, i10));
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final int minOf(int i8, int i9, int i10) {
        return Math.min(i8, Math.min(i9, i10));
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final long maxOf(long j8, long j10, long j11) {
        return Math.max(j8, Math.max(j10, j11));
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final long minOf(long j8, long j10, long j11) {
        return Math.min(j8, Math.min(j10, j11));
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final float maxOf(float f, float f4, float f10) {
        return Math.max(f, Math.max(f4, f10));
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final float minOf(float f, float f4, float f10) {
        return Math.min(f, Math.min(f4, f10));
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final double maxOf(double d7, double d10, double d11) {
        return Math.max(d7, Math.max(d10, d11));
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final double minOf(double d7, double d10, double d11) {
        return Math.min(d7, Math.min(d10, d11));
    }

    @SinceKotlin(version = "1.4")
    public static final <T extends Comparable<? super T>> T maxOf(T a6, T... other) {
        Intrinsics.checkNotNullParameter(a6, "a");
        Intrinsics.checkNotNullParameter(other, "other");
        for (T t3 : other) {
            a6 = (T) maxOf(a6, t3);
        }
        return a6;
    }

    @SinceKotlin(version = "1.4")
    public static final <T extends Comparable<? super T>> T minOf(T a6, T... other) {
        Intrinsics.checkNotNullParameter(a6, "a");
        Intrinsics.checkNotNullParameter(other, "other");
        for (T t3 : other) {
            a6 = (T) minOf(a6, t3);
        }
        return a6;
    }

    @SinceKotlin(version = "1.4")
    public static final byte maxOf(byte b9, byte... other) {
        Intrinsics.checkNotNullParameter(other, "other");
        for (byte b10 : other) {
            b9 = (byte) Math.max((int) b9, (int) b10);
        }
        return b9;
    }

    @SinceKotlin(version = "1.4")
    public static final byte minOf(byte b9, byte... other) {
        Intrinsics.checkNotNullParameter(other, "other");
        for (byte b10 : other) {
            b9 = (byte) Math.min((int) b9, (int) b10);
        }
        return b9;
    }

    @SinceKotlin(version = "1.4")
    public static final short maxOf(short s2, short... other) {
        Intrinsics.checkNotNullParameter(other, "other");
        for (short s3 : other) {
            s2 = (short) Math.max((int) s2, (int) s3);
        }
        return s2;
    }

    @SinceKotlin(version = "1.4")
    public static final short minOf(short s2, short... other) {
        Intrinsics.checkNotNullParameter(other, "other");
        for (short s3 : other) {
            s2 = (short) Math.min((int) s2, (int) s3);
        }
        return s2;
    }

    @SinceKotlin(version = "1.4")
    public static final int maxOf(int i8, int... other) {
        Intrinsics.checkNotNullParameter(other, "other");
        for (int i9 : other) {
            i8 = Math.max(i8, i9);
        }
        return i8;
    }

    @SinceKotlin(version = "1.4")
    public static final int minOf(int i8, int... other) {
        Intrinsics.checkNotNullParameter(other, "other");
        for (int i9 : other) {
            i8 = Math.min(i8, i9);
        }
        return i8;
    }

    @SinceKotlin(version = "1.4")
    public static final long maxOf(long j8, long... other) {
        Intrinsics.checkNotNullParameter(other, "other");
        for (long j10 : other) {
            j8 = Math.max(j8, j10);
        }
        return j8;
    }

    @SinceKotlin(version = "1.4")
    public static final long minOf(long j8, long... other) {
        Intrinsics.checkNotNullParameter(other, "other");
        for (long j10 : other) {
            j8 = Math.min(j8, j10);
        }
        return j8;
    }

    @SinceKotlin(version = "1.4")
    public static final float maxOf(float f, float... other) {
        Intrinsics.checkNotNullParameter(other, "other");
        for (float f4 : other) {
            f = Math.max(f, f4);
        }
        return f;
    }

    @SinceKotlin(version = "1.4")
    public static final float minOf(float f, float... other) {
        Intrinsics.checkNotNullParameter(other, "other");
        for (float f4 : other) {
            f = Math.min(f, f4);
        }
        return f;
    }

    @SinceKotlin(version = "1.4")
    public static final double maxOf(double d7, double... other) {
        Intrinsics.checkNotNullParameter(other, "other");
        for (double d10 : other) {
            d7 = Math.max(d7, d10);
        }
        return d7;
    }

    @SinceKotlin(version = "1.4")
    public static final double minOf(double d7, double... other) {
        Intrinsics.checkNotNullParameter(other, "other");
        for (double d10 : other) {
            d7 = Math.min(d7, d10);
        }
        return d7;
    }
}
