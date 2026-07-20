package io.netty.util.internal.shaded.org.jctools.util;

import h.a;
import sun.misc.Unsafe;

/* JADX INFO: loaded from: classes3.dex */
public final class UnsafeRefArrayAccess {
    public static final long REF_ARRAY_BASE;
    public static final int REF_ELEMENT_SHIFT;

    static {
        Unsafe unsafe = UnsafeAccess.UNSAFE;
        int iArrayIndexScale = unsafe.arrayIndexScale(Object[].class);
        if (4 == iArrayIndexScale) {
            REF_ELEMENT_SHIFT = 2;
        } else {
            if (8 != iArrayIndexScale) {
                throw new IllegalStateException(a.a("Unknown pointer size: ", iArrayIndexScale));
            }
            REF_ELEMENT_SHIFT = 3;
        }
        REF_ARRAY_BASE = unsafe.arrayBaseOffset(Object[].class);
    }

    public static <E> E[] allocateRefArray(int i10) {
        return (E[]) new Object[i10];
    }

    public static long calcCircularRefElementOffset(long j10, long j11) {
        return REF_ARRAY_BASE + ((j10 & j11) << REF_ELEMENT_SHIFT);
    }

    public static long calcRefElementOffset(long j10) {
        return REF_ARRAY_BASE + (j10 << REF_ELEMENT_SHIFT);
    }

    public static <E> E lpRefElement(E[] eArr, long j10) {
        return (E) UnsafeAccess.UNSAFE.getObject(eArr, j10);
    }

    public static <E> E lvRefElement(E[] eArr, long j10) {
        return (E) UnsafeAccess.UNSAFE.getObjectVolatile(eArr, j10);
    }

    public static <E> void soRefElement(E[] eArr, long j10, E e10) {
        UnsafeAccess.UNSAFE.putOrderedObject(eArr, j10, e10);
    }

    public static <E> void spRefElement(E[] eArr, long j10, E e10) {
        UnsafeAccess.UNSAFE.putObject(eArr, j10, e10);
    }
}
