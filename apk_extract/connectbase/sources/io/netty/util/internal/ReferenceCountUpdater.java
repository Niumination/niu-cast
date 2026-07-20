package io.netty.util.internal;

import io.netty.util.IllegalReferenceCountException;
import io.netty.util.ReferenceCounted;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/* JADX INFO: loaded from: classes3.dex */
public abstract class ReferenceCountUpdater<T extends ReferenceCounted> {
    public static long getUnsafeOffset(Class<? extends ReferenceCounted> cls, String str) {
        try {
            if (PlatformDependent.hasUnsafe()) {
                return PlatformDependent.objectFieldOffset(cls.getDeclaredField(str));
            }
            return -1L;
        } catch (Throwable unused) {
            return -1L;
        }
    }

    private boolean nonFinalRelease0(T t10, int i10, int i11, int i12) {
        if (i10 >= i12 || !updater().compareAndSet(t10, i11, i11 - (i10 << 1))) {
            return retryRelease0(t10, i10);
        }
        return false;
    }

    private int nonVolatileRawCnt(T t10) {
        long jUnsafeOffset = unsafeOffset();
        return jUnsafeOffset != -1 ? PlatformDependent.getInt(t10, jUnsafeOffset) : updater().get(t10);
    }

    private static int realRefCnt(int i10) {
        if (i10 == 2 || i10 == 4 || (i10 & 1) == 0) {
            return i10 >>> 1;
        }
        return 0;
    }

    private T retain0(T t10, int i10, int i11) {
        int andAdd = updater().getAndAdd(t10, i11);
        if (andAdd != 2 && andAdd != 4 && (andAdd & 1) != 0) {
            throw new IllegalReferenceCountException(0, i10);
        }
        if ((andAdd > 0 || andAdd + i11 < 0) && (andAdd < 0 || andAdd + i11 >= andAdd)) {
            return t10;
        }
        updater().getAndAdd(t10, -i11);
        throw new IllegalReferenceCountException(realRefCnt(andAdd), i10);
    }

    private boolean retryRelease0(T t10, int i10) {
        while (true) {
            int i11 = updater().get(t10);
            int liveRealRefCnt = toLiveRealRefCnt(i11, i10);
            if (i10 == liveRealRefCnt) {
                if (tryFinalRelease0(t10, i11)) {
                    return true;
                }
            } else {
                if (i10 >= liveRealRefCnt) {
                    throw new IllegalReferenceCountException(liveRealRefCnt, -i10);
                }
                if (updater().compareAndSet(t10, i11, i11 - (i10 << 1))) {
                    return false;
                }
            }
            Thread.yield();
        }
    }

    private static int toLiveRealRefCnt(int i10, int i11) {
        if (i10 == 2 || i10 == 4 || (i10 & 1) == 0) {
            return i10 >>> 1;
        }
        throw new IllegalReferenceCountException(0, -i11);
    }

    private boolean tryFinalRelease0(T t10, int i10) {
        return updater().compareAndSet(t10, i10, 1);
    }

    public final int initialValue() {
        return 2;
    }

    public final boolean isLiveNonVolatile(T t10) {
        long jUnsafeOffset = unsafeOffset();
        int i10 = jUnsafeOffset != -1 ? PlatformDependent.getInt(t10, jUnsafeOffset) : updater().get(t10);
        return i10 == 2 || i10 == 4 || i10 == 6 || i10 == 8 || (i10 & 1) == 0;
    }

    public final int refCnt(T t10) {
        return realRefCnt(updater().get(t10));
    }

    public final boolean release(T t10) {
        int iNonVolatileRawCnt = nonVolatileRawCnt(t10);
        if (iNonVolatileRawCnt == 2) {
            return tryFinalRelease0(t10, 2) || retryRelease0(t10, 1);
        }
        return nonFinalRelease0(t10, 1, iNonVolatileRawCnt, toLiveRealRefCnt(iNonVolatileRawCnt, 1));
    }

    public final void resetRefCnt(T t10) {
        updater().lazySet(t10, initialValue());
    }

    public final T retain(T t10) {
        return (T) retain0(t10, 1, 2);
    }

    public void setInitialValue(T t10) {
        long jUnsafeOffset = unsafeOffset();
        if (jUnsafeOffset == -1) {
            updater().set(t10, initialValue());
        } else {
            PlatformDependent.safeConstructPutInt(t10, jUnsafeOffset, initialValue());
        }
    }

    public final void setRefCnt(T t10, int i10) {
        updater().set(t10, i10 > 0 ? i10 << 1 : 1);
    }

    public abstract long unsafeOffset();

    public abstract AtomicIntegerFieldUpdater<T> updater();

    public final T retain(T t10, int i10) {
        return (T) retain0(t10, i10, ObjectUtil.checkPositive(i10, "increment") << 1);
    }

    public final boolean release(T t10, int i10) {
        int iNonVolatileRawCnt = nonVolatileRawCnt(t10);
        int liveRealRefCnt = toLiveRealRefCnt(iNonVolatileRawCnt, ObjectUtil.checkPositive(i10, "decrement"));
        if (i10 == liveRealRefCnt) {
            return tryFinalRelease0(t10, iNonVolatileRawCnt) || retryRelease0(t10, i10);
        }
        return nonFinalRelease0(t10, i10, iNonVolatileRawCnt, liveRealRefCnt);
    }
}
