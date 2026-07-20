package kotlin.collections;

import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.ExperimentalUnsignedTypes;
import kotlin.Metadata;
import kotlin.UByte;
import kotlin.UByteArray;
import kotlin.UIntArray;
import kotlin.ULongArray;
import kotlin.UShort;
import kotlin.UShortArray;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\u001a'\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0003¢\u0006\u0004\b\u0006\u0010\u0007\u001a'\u0010\b\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0003¢\u0006\u0004\b\n\u0010\u000b\u001a'\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\f2\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0003¢\u0006\u0004\b\r\u0010\u000e\u001a'\u0010\b\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\f2\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0003¢\u0006\u0004\b\u000f\u0010\u0010\u001a'\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00112\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0003¢\u0006\u0004\b\u0012\u0010\u0013\u001a'\u0010\b\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\u00112\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0003¢\u0006\u0004\b\u0014\u0010\u0015\u001a'\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00162\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0003¢\u0006\u0004\b\u0017\u0010\u0018\u001a'\u0010\b\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\u00162\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0003¢\u0006\u0004\b\u0019\u0010\u001a\u001a'\u0010\u001b\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u001c\u001a\u00020\u00012\u0006\u0010\u001d\u001a\u00020\u0001H\u0001¢\u0006\u0004\b\u001e\u0010\u000b\u001a'\u0010\u001b\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\f2\u0006\u0010\u001c\u001a\u00020\u00012\u0006\u0010\u001d\u001a\u00020\u0001H\u0001¢\u0006\u0004\b\u001f\u0010\u0010\u001a'\u0010\u001b\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\u00112\u0006\u0010\u001c\u001a\u00020\u00012\u0006\u0010\u001d\u001a\u00020\u0001H\u0001¢\u0006\u0004\b \u0010\u0015\u001a'\u0010\u001b\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\u00162\u0006\u0010\u001c\u001a\u00020\u00012\u0006\u0010\u001d\u001a\u00020\u0001H\u0001¢\u0006\u0004\b!\u0010\u001a¨\u0006\""}, d2 = {"partition", "", "array", "Lkotlin/UByteArray;", "left", "right", "partition-4UcCI2c", "([BII)I", "quickSort", "", "quickSort-4UcCI2c", "([BII)V", "Lkotlin/UShortArray;", "partition-Aa5vz7o", "([SII)I", "quickSort-Aa5vz7o", "([SII)V", "Lkotlin/UIntArray;", "partition-oBK06Vg", "([III)I", "quickSort-oBK06Vg", "([III)V", "Lkotlin/ULongArray;", "partition--nroSd4", "([JII)I", "quickSort--nroSd4", "([JII)V", "sortArray", "fromIndex", "toIndex", "sortArray-4UcCI2c", "sortArray-Aa5vz7o", "sortArray-oBK06Vg", "sortArray--nroSd4", "kotlin-stdlib"}, k = 2, mv = {2, 1, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class UArraySortingKt {
    @ExperimentalUnsignedTypes
    /* JADX INFO: renamed from: partition--nroSd4, reason: not valid java name */
    private static final int m614partitionnroSd4(long[] jArr, int i8, int i9) {
        long jM393getsVKNKU = ULongArray.m393getsVKNKU(jArr, (i8 + i9) / 2);
        while (i8 <= i9) {
            while (Long.compareUnsigned(ULongArray.m393getsVKNKU(jArr, i8), jM393getsVKNKU) < 0) {
                i8++;
            }
            while (Long.compareUnsigned(ULongArray.m393getsVKNKU(jArr, i9), jM393getsVKNKU) > 0) {
                i9--;
            }
            if (i8 <= i9) {
                long jM393getsVKNKU2 = ULongArray.m393getsVKNKU(jArr, i8);
                ULongArray.m398setk8EXiF4(jArr, i8, ULongArray.m393getsVKNKU(jArr, i9));
                ULongArray.m398setk8EXiF4(jArr, i9, jM393getsVKNKU2);
                i8++;
                i9--;
            }
        }
        return i8;
    }

    @ExperimentalUnsignedTypes
    /* JADX INFO: renamed from: partition-4UcCI2c, reason: not valid java name */
    private static final int m615partition4UcCI2c(byte[] bArr, int i8, int i9) {
        int i10;
        byte bM235getw2LRezQ = UByteArray.m235getw2LRezQ(bArr, (i8 + i9) / 2);
        while (i8 <= i9) {
            while (true) {
                int iM235getw2LRezQ = UByteArray.m235getw2LRezQ(bArr, i8) & UByte.MAX_VALUE;
                i10 = bM235getw2LRezQ & UByte.MAX_VALUE;
                if (Intrinsics.compare(iM235getw2LRezQ, i10) >= 0) {
                    break;
                }
                i8++;
            }
            while (Intrinsics.compare(UByteArray.m235getw2LRezQ(bArr, i9) & UByte.MAX_VALUE, i10) > 0) {
                i9--;
            }
            if (i8 <= i9) {
                byte bM235getw2LRezQ2 = UByteArray.m235getw2LRezQ(bArr, i8);
                UByteArray.m240setVurrAj0(bArr, i8, UByteArray.m235getw2LRezQ(bArr, i9));
                UByteArray.m240setVurrAj0(bArr, i9, bM235getw2LRezQ2);
                i8++;
                i9--;
            }
        }
        return i8;
    }

    @ExperimentalUnsignedTypes
    /* JADX INFO: renamed from: partition-Aa5vz7o, reason: not valid java name */
    private static final int m616partitionAa5vz7o(short[] sArr, int i8, int i9) {
        int i10;
        short sM498getMh2AYeg = UShortArray.m498getMh2AYeg(sArr, (i8 + i9) / 2);
        while (i8 <= i9) {
            while (true) {
                int iM498getMh2AYeg = UShortArray.m498getMh2AYeg(sArr, i8) & UShort.MAX_VALUE;
                i10 = sM498getMh2AYeg & UShort.MAX_VALUE;
                if (Intrinsics.compare(iM498getMh2AYeg, i10) >= 0) {
                    break;
                }
                i8++;
            }
            while (Intrinsics.compare(UShortArray.m498getMh2AYeg(sArr, i9) & UShort.MAX_VALUE, i10) > 0) {
                i9--;
            }
            if (i8 <= i9) {
                short sM498getMh2AYeg2 = UShortArray.m498getMh2AYeg(sArr, i8);
                UShortArray.m503set01HTLdE(sArr, i8, UShortArray.m498getMh2AYeg(sArr, i9));
                UShortArray.m503set01HTLdE(sArr, i9, sM498getMh2AYeg2);
                i8++;
                i9--;
            }
        }
        return i8;
    }

    @ExperimentalUnsignedTypes
    /* JADX INFO: renamed from: partition-oBK06Vg, reason: not valid java name */
    private static final int m617partitionoBK06Vg(int[] iArr, int i8, int i9) {
        int iM314getpVg5ArA = UIntArray.m314getpVg5ArA(iArr, (i8 + i9) / 2);
        while (i8 <= i9) {
            while (Integer.compareUnsigned(UIntArray.m314getpVg5ArA(iArr, i8), iM314getpVg5ArA) < 0) {
                i8++;
            }
            while (Integer.compareUnsigned(UIntArray.m314getpVg5ArA(iArr, i9), iM314getpVg5ArA) > 0) {
                i9--;
            }
            if (i8 <= i9) {
                int iM314getpVg5ArA2 = UIntArray.m314getpVg5ArA(iArr, i8);
                UIntArray.m319setVXSXFK8(iArr, i8, UIntArray.m314getpVg5ArA(iArr, i9));
                UIntArray.m319setVXSXFK8(iArr, i9, iM314getpVg5ArA2);
                i8++;
                i9--;
            }
        }
        return i8;
    }

    @ExperimentalUnsignedTypes
    /* JADX INFO: renamed from: quickSort--nroSd4, reason: not valid java name */
    private static final void m618quickSortnroSd4(long[] jArr, int i8, int i9) {
        int iM614partitionnroSd4 = m614partitionnroSd4(jArr, i8, i9);
        int i10 = iM614partitionnroSd4 - 1;
        if (i8 < i10) {
            m618quickSortnroSd4(jArr, i8, i10);
        }
        if (iM614partitionnroSd4 < i9) {
            m618quickSortnroSd4(jArr, iM614partitionnroSd4, i9);
        }
    }

    @ExperimentalUnsignedTypes
    /* JADX INFO: renamed from: quickSort-4UcCI2c, reason: not valid java name */
    private static final void m619quickSort4UcCI2c(byte[] bArr, int i8, int i9) {
        int iM615partition4UcCI2c = m615partition4UcCI2c(bArr, i8, i9);
        int i10 = iM615partition4UcCI2c - 1;
        if (i8 < i10) {
            m619quickSort4UcCI2c(bArr, i8, i10);
        }
        if (iM615partition4UcCI2c < i9) {
            m619quickSort4UcCI2c(bArr, iM615partition4UcCI2c, i9);
        }
    }

    @ExperimentalUnsignedTypes
    /* JADX INFO: renamed from: quickSort-Aa5vz7o, reason: not valid java name */
    private static final void m620quickSortAa5vz7o(short[] sArr, int i8, int i9) {
        int iM616partitionAa5vz7o = m616partitionAa5vz7o(sArr, i8, i9);
        int i10 = iM616partitionAa5vz7o - 1;
        if (i8 < i10) {
            m620quickSortAa5vz7o(sArr, i8, i10);
        }
        if (iM616partitionAa5vz7o < i9) {
            m620quickSortAa5vz7o(sArr, iM616partitionAa5vz7o, i9);
        }
    }

    @ExperimentalUnsignedTypes
    /* JADX INFO: renamed from: quickSort-oBK06Vg, reason: not valid java name */
    private static final void m621quickSortoBK06Vg(int[] iArr, int i8, int i9) {
        int iM617partitionoBK06Vg = m617partitionoBK06Vg(iArr, i8, i9);
        int i10 = iM617partitionoBK06Vg - 1;
        if (i8 < i10) {
            m621quickSortoBK06Vg(iArr, i8, i10);
        }
        if (iM617partitionoBK06Vg < i9) {
            m621quickSortoBK06Vg(iArr, iM617partitionoBK06Vg, i9);
        }
    }

    @ExperimentalUnsignedTypes
    /* JADX INFO: renamed from: sortArray--nroSd4, reason: not valid java name */
    public static final void m622sortArraynroSd4(long[] array, int i8, int i9) {
        Intrinsics.checkNotNullParameter(array, "array");
        m618quickSortnroSd4(array, i8, i9 - 1);
    }

    @ExperimentalUnsignedTypes
    /* JADX INFO: renamed from: sortArray-4UcCI2c, reason: not valid java name */
    public static final void m623sortArray4UcCI2c(byte[] array, int i8, int i9) {
        Intrinsics.checkNotNullParameter(array, "array");
        m619quickSort4UcCI2c(array, i8, i9 - 1);
    }

    @ExperimentalUnsignedTypes
    /* JADX INFO: renamed from: sortArray-Aa5vz7o, reason: not valid java name */
    public static final void m624sortArrayAa5vz7o(short[] array, int i8, int i9) {
        Intrinsics.checkNotNullParameter(array, "array");
        m620quickSortAa5vz7o(array, i8, i9 - 1);
    }

    @ExperimentalUnsignedTypes
    /* JADX INFO: renamed from: sortArray-oBK06Vg, reason: not valid java name */
    public static final void m625sortArrayoBK06Vg(int[] array, int i8, int i9) {
        Intrinsics.checkNotNullParameter(array, "array");
        m621quickSortoBK06Vg(array, i8, i9 - 1);
    }
}
