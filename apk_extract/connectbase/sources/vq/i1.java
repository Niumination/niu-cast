package vq;

import java.util.WeakHashMap;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import kn.r1;

/* JADX INFO: loaded from: classes3.dex */
@r1({"SMAP\nExceptionsConstructor.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ExceptionsConstructor.kt\nkotlinx/coroutines/internal/WeakMapCtorCache\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,116:1\n1#2:117\n*E\n"})
public final class i1 extends k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public static final i1 f17853a = new i1();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.l
    public static final ReentrantReadWriteLock f17854b = new ReentrantReadWriteLock();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @os.l
    public static final WeakHashMap<Class<? extends Throwable>, jn.l<Throwable, Throwable>> f17855c = new WeakHashMap<>();

    @Override // vq.k
    @os.l
    public jn.l<Throwable, Throwable> a(@os.l Class<? extends Throwable> cls) {
        ReentrantReadWriteLock reentrantReadWriteLock = f17854b;
        ReentrantReadWriteLock.ReadLock lock = reentrantReadWriteLock.readLock();
        lock.lock();
        try {
            jn.l<Throwable, Throwable> lVar = f17855c.get(cls);
            lock.unlock();
            if (lVar != null) {
                return lVar;
            }
            ReentrantReadWriteLock.ReadLock lock2 = reentrantReadWriteLock.readLock();
            int i10 = 0;
            int readHoldCount = reentrantReadWriteLock.getWriteHoldCount() == 0 ? reentrantReadWriteLock.getReadHoldCount() : 0;
            for (int i11 = 0; i11 < readHoldCount; i11++) {
                lock2.unlock();
            }
            ReentrantReadWriteLock.WriteLock writeLock = reentrantReadWriteLock.writeLock();
            writeLock.lock();
            try {
                WeakHashMap<Class<? extends Throwable>, jn.l<Throwable, Throwable>> weakHashMap = f17855c;
                jn.l<Throwable, Throwable> lVar2 = weakHashMap.get(cls);
                if (lVar2 != null) {
                    while (i10 < readHoldCount) {
                        lock2.lock();
                        i10++;
                    }
                    writeLock.unlock();
                    return lVar2;
                }
                jn.l<Throwable, Throwable> lVarB = p.b(cls);
                weakHashMap.put(cls, lVarB);
                while (i10 < readHoldCount) {
                    lock2.lock();
                    i10++;
                }
                writeLock.unlock();
                return lVarB;
            } catch (Throwable th2) {
                while (i10 < readHoldCount) {
                    lock2.lock();
                    i10++;
                }
                writeLock.unlock();
                throw th2;
            }
        } catch (Throwable th3) {
            lock.unlock();
            throw th3;
        }
    }
}
