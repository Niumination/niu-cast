package io.netty.util.internal.shaded.org.jctools.util;

import h.a;
import k.b;

/* JADX INFO: loaded from: classes3.dex */
public final class Pow2 {
    public static final int MAX_POW2 = 1073741824;

    public static long align(long j10, int i10) {
        if (!isPowerOfTwo(i10)) {
            throw new IllegalArgumentException(a.a("alignment must be a power of 2:", i10));
        }
        int i11 = i10 - 1;
        return (j10 + ((long) i11)) & ((long) (~i11));
    }

    public static boolean isPowerOfTwo(int i10) {
        return (i10 & (i10 + (-1))) == 0;
    }

    public static int roundToPowerOfTwo(int i10) {
        if (i10 > 1073741824) {
            throw new IllegalArgumentException(b.a("There is no larger power of 2 int for value:", i10, " since it exceeds 2^31."));
        }
        if (i10 >= 0) {
            return 1 << (32 - Integer.numberOfLeadingZeros(i10 - 1));
        }
        throw new IllegalArgumentException(b.a("Given value:", i10, ". Expecting value >= 0."));
    }
}
