package io.netty.util.internal.shaded.org.jctools.util;

import n2.k0;

/* JADX INFO: loaded from: classes3.dex */
public final class RangeUtil {
    public static int checkGreaterThanOrEqual(int i10, int i11, String str) {
        if (i10 >= i11) {
            return i10;
        }
        throw new IllegalArgumentException(str + ": " + i10 + " (expected: >= " + i11 + ')');
    }

    public static int checkLessThan(int i10, int i11, String str) {
        if (i10 < i11) {
            return i10;
        }
        throw new IllegalArgumentException(str + ": " + i10 + " (expected: < " + i11 + ')');
    }

    public static int checkLessThanOrEqual(int i10, long j10, String str) {
        if (i10 <= j10) {
            return i10;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(str);
        sb2.append(": ");
        sb2.append(i10);
        sb2.append(" (expected: <= ");
        throw new IllegalArgumentException(k0.a(sb2, j10, ')'));
    }

    public static long checkPositive(long j10, String str) {
        if (j10 > 0) {
            return j10;
        }
        throw new IllegalArgumentException(str + ": " + j10 + " (expected: > 0)");
    }

    public static int checkPositiveOrZero(int i10, String str) {
        if (i10 >= 0) {
            return i10;
        }
        throw new IllegalArgumentException(str + ": " + i10 + " (expected: >= 0)");
    }
}
