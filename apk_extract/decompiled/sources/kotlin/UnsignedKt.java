package kotlin;

import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.internal.InlineOnly;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00008\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0003\u001a\u001f\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0001H\u0001¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u001f\u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0001H\u0001¢\u0006\u0004\b\u0007\u0010\u0005\u001a\u001f\u0010\b\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\tH\u0001¢\u0006\u0004\b\n\u0010\u000b\u001a\u001f\u0010\f\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\tH\u0001¢\u0006\u0004\b\r\u0010\u000b\u001a\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0002\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u000fH\u0001\u001a\u0018\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0002\u001a\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u0011H\u0001\u001a\u0016\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u000fH\u0081\b¢\u0006\u0002\u0010\u0014\u001a\u0011\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u000fH\u0081\b\u001a\u0011\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0013\u001a\u00020\u000fH\u0081\b\u001a\u0016\u0010\u0018\u001a\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u0017H\u0081\b¢\u0006\u0002\u0010\u0019\u001a\u0010\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0013\u001a\u00020\u000fH\u0001\u001a\u0015\u0010\u001c\u001a\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u001bH\u0001¢\u0006\u0002\u0010\u001d\u001a\u0011\u0010\u001e\u001a\u00020\u00172\u0006\u0010\u0013\u001a\u00020\u0011H\u0081\b\u001a\u0016\u0010\u001f\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u0017H\u0081\b¢\u0006\u0002\u0010 \u001a\u0010\u0010!\u001a\u00020\u001b2\u0006\u0010\u0013\u001a\u00020\u0011H\u0001\u001a\u0015\u0010\"\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u001bH\u0001¢\u0006\u0002\u0010#\u001a\u0011\u0010$\u001a\u00020%2\u0006\u0010\u0013\u001a\u00020\u000fH\u0081\b\u001a\u0019\u0010$\u001a\u00020%2\u0006\u0010\u0013\u001a\u00020\u000f2\u0006\u0010&\u001a\u00020\u000fH\u0081\b\u001a\u0011\u0010'\u001a\u00020%2\u0006\u0010\u0013\u001a\u00020\u0011H\u0081\b\u001a\u0018\u0010'\u001a\u00020%2\u0006\u0010\u0013\u001a\u00020\u00112\u0006\u0010&\u001a\u00020\u000fH\u0000¨\u0006("}, d2 = {"uintRemainder", "Lkotlin/UInt;", "v1", "v2", "uintRemainder-J1ME1BU", "(II)I", "uintDivide", "uintDivide-J1ME1BU", "ulongDivide", "Lkotlin/ULong;", "ulongDivide-eb3DHEI", "(JJ)J", "ulongRemainder", "ulongRemainder-eb3DHEI", "uintCompare", "", "ulongCompare", "", "uintToULong", "value", "(I)J", "uintToLong", "uintToFloat", "", "floatToUInt", "(F)I", "uintToDouble", "", "doubleToUInt", "(D)I", "ulongToFloat", "floatToULong", "(F)J", "ulongToDouble", "doubleToULong", "(D)J", "uintToString", "", "base", "ulongToString", "kotlin-stdlib"}, k = 2, mv = {2, 1, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@JvmName(name = "UnsignedKt")
public final class UnsignedKt {
    @PublishedApi
    public static final int doubleToUInt(double d7) {
        if (Double.isNaN(d7) || d7 <= uintToDouble(0)) {
            return 0;
        }
        if (d7 >= uintToDouble(-1)) {
            return -1;
        }
        if (d7 <= 2.147483647E9d) {
            return UInt.m254constructorimpl((int) d7);
        }
        return UInt.m254constructorimpl(UInt.m254constructorimpl(Integer.MAX_VALUE) + UInt.m254constructorimpl((int) (d7 - ((double) Integer.MAX_VALUE))));
    }

    @PublishedApi
    public static final long doubleToULong(double d7) {
        if (Double.isNaN(d7) || d7 <= ulongToDouble(0L)) {
            return 0L;
        }
        if (d7 >= ulongToDouble(-1L)) {
            return -1L;
        }
        return d7 < 9.223372036854776E18d ? ULong.m333constructorimpl((long) d7) : ULong.m333constructorimpl(ULong.m333constructorimpl((long) (d7 - 9.223372036854776E18d)) - Long.MIN_VALUE);
    }

    @PublishedApi
    @InlineOnly
    private static final int floatToUInt(float f) {
        return doubleToUInt(f);
    }

    @PublishedApi
    @InlineOnly
    private static final long floatToULong(float f) {
        return doubleToULong(f);
    }

    @PublishedApi
    public static final int uintCompare(int i8, int i9) {
        return Intrinsics.compare(i8 ^ Integer.MIN_VALUE, i9 ^ Integer.MIN_VALUE);
    }

    @PublishedApi
    /* JADX INFO: renamed from: uintDivide-J1ME1BU, reason: not valid java name */
    public static final int m510uintDivideJ1ME1BU(int i8, int i9) {
        return UInt.m254constructorimpl((int) ((((long) i8) & 4294967295L) / (((long) i9) & 4294967295L)));
    }

    @PublishedApi
    /* JADX INFO: renamed from: uintRemainder-J1ME1BU, reason: not valid java name */
    public static final int m511uintRemainderJ1ME1BU(int i8, int i9) {
        return UInt.m254constructorimpl((int) ((((long) i8) & 4294967295L) % (((long) i9) & 4294967295L)));
    }

    @PublishedApi
    public static final double uintToDouble(int i8) {
        return (((double) ((i8 >>> 31) << 30)) * ((double) 2)) + ((double) (Integer.MAX_VALUE & i8));
    }

    @PublishedApi
    @InlineOnly
    private static final float uintToFloat(int i8) {
        return (float) uintToDouble(i8);
    }

    @PublishedApi
    @InlineOnly
    private static final long uintToLong(int i8) {
        return ((long) i8) & 4294967295L;
    }

    @InlineOnly
    private static final String uintToString(int i8) {
        return String.valueOf(((long) i8) & 4294967295L);
    }

    @PublishedApi
    @InlineOnly
    private static final long uintToULong(int i8) {
        return ULong.m333constructorimpl(((long) i8) & 4294967295L);
    }

    @PublishedApi
    public static final int ulongCompare(long j8, long j10) {
        return Intrinsics.compare(j8 ^ Long.MIN_VALUE, j10 ^ Long.MIN_VALUE);
    }

    @PublishedApi
    /* JADX INFO: renamed from: ulongDivide-eb3DHEI, reason: not valid java name */
    public static final long m512ulongDivideeb3DHEI(long j8, long j10) {
        if (j10 < 0) {
            return Long.compareUnsigned(j8, j10) < 0 ? ULong.m333constructorimpl(0L) : ULong.m333constructorimpl(1L);
        }
        if (j8 >= 0) {
            return ULong.m333constructorimpl(j8 / j10);
        }
        long j11 = ((j8 >>> 1) / j10) << 1;
        return ULong.m333constructorimpl(j11 + ((long) (Long.compareUnsigned(ULong.m333constructorimpl(j8 - (j11 * j10)), ULong.m333constructorimpl(j10)) < 0 ? 0 : 1)));
    }

    @PublishedApi
    /* JADX INFO: renamed from: ulongRemainder-eb3DHEI, reason: not valid java name */
    public static final long m513ulongRemaindereb3DHEI(long j8, long j10) {
        if (j10 < 0) {
            return Long.compareUnsigned(j8, j10) < 0 ? j8 : ULong.m333constructorimpl(j8 - j10);
        }
        if (j8 >= 0) {
            return ULong.m333constructorimpl(j8 % j10);
        }
        long j11 = j8 - ((((j8 >>> 1) / j10) << 1) * j10);
        if (Long.compareUnsigned(ULong.m333constructorimpl(j11), ULong.m333constructorimpl(j10)) < 0) {
            j10 = 0;
        }
        return ULong.m333constructorimpl(j11 - j10);
    }

    @PublishedApi
    public static final double ulongToDouble(long j8) {
        return ((j8 >>> 11) * ((double) 2048)) + (j8 & 2047);
    }

    @PublishedApi
    @InlineOnly
    private static final float ulongToFloat(long j8) {
        return (float) ulongToDouble(j8);
    }

    @InlineOnly
    private static final String ulongToString(long j8) {
        return ulongToString(j8, 10);
    }

    @InlineOnly
    private static final String uintToString(int i8, int i9) {
        return ulongToString(((long) i8) & 4294967295L, i9);
    }

    public static final String ulongToString(long j8, int i8) {
        if (j8 >= 0) {
            String string = Long.toString(j8, CharsKt.checkRadix(i8));
            Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
            return string;
        }
        long j10 = i8;
        long j11 = ((j8 >>> 1) / j10) << 1;
        long j12 = j8 - (j11 * j10);
        if (j12 >= j10) {
            j12 -= j10;
            j11++;
        }
        StringBuilder sb2 = new StringBuilder();
        String string2 = Long.toString(j11, CharsKt.checkRadix(i8));
        Intrinsics.checkNotNullExpressionValue(string2, "toString(...)");
        sb2.append(string2);
        String string3 = Long.toString(j12, CharsKt.checkRadix(i8));
        Intrinsics.checkNotNullExpressionValue(string3, "toString(...)");
        sb2.append(string3);
        return sb2.toString();
    }
}
