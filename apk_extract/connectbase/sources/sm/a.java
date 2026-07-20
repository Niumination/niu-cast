package sm;

import an.f;
import in.i;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import kn.l0;
import kn.r1;

/* JADX INFO: loaded from: classes3.dex */
@r1({"SMAP\nLocks.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Locks.kt\nkotlin/concurrent/LocksKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,74:1\n1#2:75\n*E\n"})
@i(name = "LocksKt")
public final class a {
    @f
    public static final <T> T a(ReentrantReadWriteLock reentrantReadWriteLock, jn.a<? extends T> aVar) {
        l0.p(reentrantReadWriteLock, "<this>");
        l0.p(aVar, k4.f.f8937e);
        ReentrantReadWriteLock.ReadLock lock = reentrantReadWriteLock.readLock();
        lock.lock();
        try {
            return aVar.invoke();
        } finally {
            lock.unlock();
        }
    }

    @f
    public static final <T> T b(Lock lock, jn.a<? extends T> aVar) {
        l0.p(lock, "<this>");
        l0.p(aVar, k4.f.f8937e);
        lock.lock();
        try {
            return aVar.invoke();
        } finally {
            lock.unlock();
        }
    }

    @f
    public static final <T> T c(ReentrantReadWriteLock reentrantReadWriteLock, jn.a<? extends T> aVar) {
        l0.p(reentrantReadWriteLock, "<this>");
        l0.p(aVar, k4.f.f8937e);
        ReentrantReadWriteLock.ReadLock lock = reentrantReadWriteLock.readLock();
        int i10 = 0;
        int readHoldCount = reentrantReadWriteLock.getWriteHoldCount() == 0 ? reentrantReadWriteLock.getReadHoldCount() : 0;
        for (int i11 = 0; i11 < readHoldCount; i11++) {
            lock.unlock();
        }
        ReentrantReadWriteLock.WriteLock writeLock = reentrantReadWriteLock.writeLock();
        writeLock.lock();
        try {
            T tInvoke = aVar.invoke();
            while (i10 < readHoldCount) {
                lock.lock();
                i10++;
            }
            return tInvoke;
        } finally {
            while (i10 < readHoldCount) {
                lock.lock();
                i10++;
            }
            writeLock.unlock();
        }
    }
}
