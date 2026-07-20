package io.netty.buffer;

/* JADX INFO: loaded from: classes2.dex */
final class LongLongHashMap {
    private static final int MASK_TEMPLATE = -2;
    private final long emptyVal;
    private int maxProbe;
    private long zeroVal;
    private long[] array = new long[32];
    private int mask = 31;

    public LongLongHashMap(long j10) {
        this.emptyVal = j10;
        this.zeroVal = j10;
        computeMaskAndProbe();
    }

    private void computeMaskAndProbe() {
        int length = this.array.length;
        this.mask = (length - 1) & (-2);
        this.maxProbe = (int) Math.log(length);
    }

    private void expand() {
        long[] jArr = this.array;
        this.array = new long[jArr.length * 2];
        computeMaskAndProbe();
        for (int i10 = 0; i10 < jArr.length; i10 += 2) {
            long j10 = jArr[i10];
            if (j10 != 0) {
                put(j10, jArr[i10 + 1]);
            }
        }
    }

    private int index(long j10) {
        long j11 = (j10 ^ (j10 >>> 33)) * (-49064778989728563L);
        long j12 = (j11 ^ (j11 >>> 33)) * (-4265267296055464877L);
        return this.mask & ((int) (j12 ^ (j12 >>> 33)));
    }

    public long get(long j10) {
        if (j10 == 0) {
            return this.zeroVal;
        }
        int iIndex = index(j10);
        for (int i10 = 0; i10 < this.maxProbe; i10++) {
            long[] jArr = this.array;
            if (jArr[iIndex] == j10) {
                return jArr[iIndex + 1];
            }
            iIndex = (iIndex + 2) & this.mask;
        }
        return this.emptyVal;
    }

    public long put(long j10, long j11) {
        int iIndex;
        int i10;
        long[] jArr;
        long j12;
        if (j10 == 0) {
            long j13 = this.zeroVal;
            this.zeroVal = j11;
            return j13;
        }
        loop0: while (true) {
            iIndex = index(j10);
            i10 = 0;
            while (i10 < this.maxProbe) {
                jArr = this.array;
                j12 = jArr[iIndex];
                if (j12 == j10 || j12 == 0) {
                    break loop0;
                }
                iIndex = (iIndex + 2) & this.mask;
                i10++;
            }
            expand();
        }
        long j14 = j12 == 0 ? this.emptyVal : jArr[iIndex + 1];
        jArr[iIndex] = j10;
        jArr[iIndex + 1] = j11;
        while (i10 < this.maxProbe) {
            iIndex = (iIndex + 2) & this.mask;
            long[] jArr2 = this.array;
            if (jArr2[iIndex] == j10) {
                jArr2[iIndex] = 0;
                return jArr2[iIndex + 1];
            }
            i10++;
        }
        return j14;
    }

    public void remove(long j10) {
        if (j10 == 0) {
            this.zeroVal = this.emptyVal;
            return;
        }
        int iIndex = index(j10);
        for (int i10 = 0; i10 < this.maxProbe; i10++) {
            long[] jArr = this.array;
            if (jArr[iIndex] == j10) {
                jArr[iIndex] = 0;
                return;
            }
            iIndex = (iIndex + 2) & this.mask;
        }
    }
}
