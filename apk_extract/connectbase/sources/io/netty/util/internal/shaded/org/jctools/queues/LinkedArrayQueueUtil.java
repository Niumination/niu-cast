package io.netty.util.internal.shaded.org.jctools.queues;

import io.netty.util.internal.shaded.org.jctools.util.UnsafeRefArrayAccess;

/* JADX INFO: loaded from: classes3.dex */
final class LinkedArrayQueueUtil {
    public static int length(Object[] objArr) {
        return objArr.length;
    }

    public static long modifiedCalcCircularRefElementOffset(long j10, long j11) {
        return UnsafeRefArrayAccess.REF_ARRAY_BASE + ((j10 & j11) << (UnsafeRefArrayAccess.REF_ELEMENT_SHIFT - 1));
    }

    public static long nextArrayOffset(Object[] objArr) {
        return UnsafeRefArrayAccess.REF_ARRAY_BASE + (((long) (length(objArr) - 1)) << UnsafeRefArrayAccess.REF_ELEMENT_SHIFT);
    }
}
