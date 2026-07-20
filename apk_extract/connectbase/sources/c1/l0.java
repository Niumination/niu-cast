package c1;

import java.util.BitSet;

/* JADX INFO: loaded from: classes.dex */
@b1.c
@b1.d
@k
public final class l0 extends e.v {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f1196f = 1023;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f1197g = -862048943;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f1198i = 461845907;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final double f1199n = 0.5d;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final char[] f1200c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f1201d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f1202e;

    public l0(char[] table, long filter, boolean containsZero, String description) {
        super(description);
        this.f1200c = table;
        this.f1202e = filter;
        this.f1201d = containsZero;
    }

    @b1.e
    public static int Z(int setSize) {
        if (setSize == 1) {
            return 2;
        }
        int iHighestOneBit = Integer.highestOneBit(setSize - 1) << 1;
        while (((double) iHighestOneBit) * 0.5d < setSize) {
            iHighestOneBit <<= 1;
        }
        return iHighestOneBit;
    }

    public static e a0(BitSet chars, String description) {
        int i10;
        int iCardinality = chars.cardinality();
        boolean z10 = chars.get(0);
        int iZ = Z(iCardinality);
        char[] cArr = new char[iZ];
        int i11 = iZ - 1;
        int iNextSetBit = chars.nextSetBit(0);
        long j10 = 0;
        while (iNextSetBit != -1) {
            long j11 = (1 << iNextSetBit) | j10;
            int iB0 = b0(iNextSetBit);
            while (true) {
                i10 = iB0 & i11;
                if (cArr[i10] == 0) {
                    break;
                }
                iB0 = i10 + 1;
            }
            cArr[i10] = (char) iNextSetBit;
            iNextSetBit = chars.nextSetBit(iNextSetBit + 1);
            j10 = j11;
        }
        return new l0(cArr, j10, z10, description);
    }

    public static int b0(int hashCode) {
        return Integer.rotateLeft(hashCode * (-862048943), 15) * 461845907;
    }

    @Override // c1.e
    public boolean B(char c10) {
        if (c10 == 0) {
            return this.f1201d;
        }
        if (!Y(c10)) {
            return false;
        }
        int length = this.f1200c.length - 1;
        int iB0 = b0(c10) & length;
        int i10 = iB0;
        do {
            char c11 = this.f1200c[i10];
            if (c11 == 0) {
                return false;
            }
            if (c11 == c10) {
                return true;
            }
            i10 = (i10 + 1) & length;
        } while (i10 != iB0);
        return false;
    }

    @Override // c1.e
    public void Q(BitSet table) {
        if (this.f1201d) {
            table.set(0);
        }
        for (char c10 : this.f1200c) {
            if (c10 != 0) {
                table.set(c10);
            }
        }
    }

    public final boolean Y(int c10) {
        return 1 == ((this.f1202e >> c10) & 1);
    }
}
