package io.netty.util.internal.shaded.org.jctools.queues.atomic;

import java.util.concurrent.atomic.AtomicLongArray;
import java.util.concurrent.atomic.AtomicReferenceArray;

/* JADX INFO: loaded from: classes3.dex */
final class AtomicQueueUtil {
    public static AtomicLongArray allocateLongArray(int i10) {
        return new AtomicLongArray(i10);
    }

    public static <E> AtomicReferenceArray<E> allocateRefArray(int i10) {
        return new AtomicReferenceArray<>(i10);
    }

    public static int calcCircularLongElementOffset(long j10, int i10) {
        return (int) (j10 & ((long) i10));
    }

    public static int calcCircularRefElementOffset(long j10, long j11) {
        return (int) (j10 & j11);
    }

    public static int calcLongElementOffset(long j10) {
        return (int) j10;
    }

    public static int calcRefElementOffset(long j10) {
        return (int) j10;
    }

    public static int length(AtomicReferenceArray<?> atomicReferenceArray) {
        return atomicReferenceArray.length();
    }

    public static long lpLongElement(AtomicLongArray atomicLongArray, int i10) {
        return atomicLongArray.get(i10);
    }

    public static <E> E lpRefElement(AtomicReferenceArray<E> atomicReferenceArray, int i10) {
        return atomicReferenceArray.get(i10);
    }

    public static long lvLongElement(AtomicLongArray atomicLongArray, int i10) {
        return atomicLongArray.get(i10);
    }

    public static <E> E lvRefElement(AtomicReferenceArray<E> atomicReferenceArray, int i10) {
        return atomicReferenceArray.get(i10);
    }

    public static int modifiedCalcCircularRefElementOffset(long j10, long j11) {
        return ((int) (j10 & j11)) >> 1;
    }

    public static int nextArrayOffset(AtomicReferenceArray<?> atomicReferenceArray) {
        return length(atomicReferenceArray) - 1;
    }

    public static void soLongElement(AtomicLongArray atomicLongArray, int i10, long j10) {
        atomicLongArray.lazySet(i10, j10);
    }

    public static void soRefElement(AtomicReferenceArray atomicReferenceArray, int i10, Object obj) {
        atomicReferenceArray.lazySet(i10, obj);
    }

    public static void spLongElement(AtomicLongArray atomicLongArray, int i10, long j10) {
        atomicLongArray.lazySet(i10, j10);
    }

    public static <E> void spRefElement(AtomicReferenceArray<E> atomicReferenceArray, int i10, E e10) {
        atomicReferenceArray.lazySet(i10, e10);
    }

    public static <E> void svRefElement(AtomicReferenceArray<E> atomicReferenceArray, int i10, E e10) {
        atomicReferenceArray.set(i10, e10);
    }
}
