package si;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.concurrent.locks.LockSupport;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes3.dex */
public final class b extends Thread {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f10100k = AtomicIntegerFieldUpdater.newUpdater(b.class, "workerCtl$volatile");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final n f10101a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Ref.ObjectRef f10102b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public c f10103c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f10104d;
    public long e;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f10105h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f10106i;
    private volatile int indexInArray;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final /* synthetic */ d f10107j;
    private volatile Object nextParkedWorker;
    private volatile /* synthetic */ int workerCtl$volatile;

    public b(d dVar, int i8) {
        this.f10107j = dVar;
        setDaemon(true);
        setContextClassLoader(dVar.getClass().getClassLoader());
        this.f10101a = new n();
        this.f10102b = new Ref.ObjectRef();
        this.f10103c = c.DORMANT;
        this.nextParkedWorker = d.f10111m;
        int iNanoTime = (int) System.nanoTime();
        this.f10105h = iNanoTime == 0 ? 42 : iNanoTime;
        f(i8);
    }

    public final j a(boolean z2) {
        j jVarE;
        j jVarE2;
        d dVar;
        long j8;
        c cVar = this.f10103c;
        c cVar2 = c.CPU_ACQUIRED;
        j jVar = null;
        n nVar = this.f10101a;
        d dVar2 = this.f10107j;
        if (cVar != cVar2) {
            AtomicLongFieldUpdater atomicLongFieldUpdater = d.f10109k;
            do {
                dVar = this.f10107j;
                j8 = atomicLongFieldUpdater.get(dVar);
                if (((int) ((9223367638808264704L & j8) >> 42)) == 0) {
                    nVar.getClass();
                    while (true) {
                        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = n.f10131b;
                        j jVar2 = (j) atomicReferenceFieldUpdater.get(nVar);
                        if (jVar2 == null || !jVar2.f10124b) {
                            int i8 = n.f10133d.get(nVar);
                            int i9 = n.f10132c.get(nVar);
                            while (i8 != i9 && n.e.get(nVar) != 0) {
                                i9--;
                                j jVarC = nVar.c(i9, true);
                                if (jVarC != null) {
                                    jVar = jVarC;
                                    break;
                                }
                            }
                            break;
                        }
                        if (atomicReferenceFieldUpdater.compareAndSet(nVar, jVar2, null)) {
                            jVar = jVar2;
                            break;
                        }
                    }
                    if (jVar != null) {
                        return jVar;
                    }
                    j jVar3 = (j) dVar2.f10116h.c();
                    return jVar3 == null ? i(1) : jVar3;
                }
            } while (!d.f10109k.compareAndSet(dVar, j8, j8 - 4398046511104L));
            this.f10103c = c.CPU_ACQUIRED;
        }
        if (z2) {
            boolean z3 = d(dVar2.f10112a * 2) == 0;
            if (z3 && (jVarE2 = e()) != null) {
                return jVarE2;
            }
            nVar.getClass();
            j jVarB = (j) n.f10131b.getAndSet(nVar, null);
            if (jVarB == null) {
                jVarB = nVar.b();
            }
            if (jVarB != null) {
                return jVarB;
            }
            if (!z3 && (jVarE = e()) != null) {
                return jVarE;
            }
        } else {
            j jVarE3 = e();
            if (jVarE3 != null) {
                return jVarE3;
            }
        }
        return i(3);
    }

    public final int b() {
        return this.indexInArray;
    }

    public final Object c() {
        return this.nextParkedWorker;
    }

    public final int d(int i8) {
        int i9 = this.f10105h;
        int i10 = i9 ^ (i9 << 13);
        int i11 = i10 ^ (i10 >> 17);
        int i12 = i11 ^ (i11 << 5);
        this.f10105h = i12;
        int i13 = i8 - 1;
        return (i13 & i8) == 0 ? i13 & i12 : (Integer.MAX_VALUE & i12) % i8;
    }

    public final j e() {
        int iD = d(2);
        d dVar = this.f10107j;
        if (iD == 0) {
            j jVar = (j) dVar.e.c();
            return jVar != null ? jVar : (j) dVar.f10116h.c();
        }
        j jVar2 = (j) dVar.f10116h.c();
        return jVar2 != null ? jVar2 : (j) dVar.e.c();
    }

    public final void f(int i8) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(this.f10107j.f10115d);
        sb2.append("-worker-");
        sb2.append(i8 == 0 ? "TERMINATED" : String.valueOf(i8));
        setName(sb2.toString());
        this.indexInArray = i8;
    }

    public final void g(Object obj) {
        this.nextParkedWorker = obj;
    }

    public final boolean h(c cVar) {
        c cVar2 = this.f10103c;
        boolean z2 = cVar2 == c.CPU_ACQUIRED;
        if (z2) {
            d.f10109k.addAndGet(this.f10107j, 4398046511104L);
        }
        if (cVar2 != cVar) {
            this.f10103c = cVar;
        }
        return z2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r13v1, types: [T, java.lang.Object, si.j] */
    /* JADX WARN: Type inference failed for: r7v10, types: [si.j] */
    /* JADX WARN: Type inference failed for: r7v4 */
    /* JADX WARN: Type inference failed for: r7v5, types: [si.j] */
    public final j i(int i8) {
        T tC;
        long j8;
        long j10;
        AtomicLongFieldUpdater atomicLongFieldUpdater = d.f10109k;
        d dVar = this.f10107j;
        int i9 = (int) (atomicLongFieldUpdater.get(dVar) & 2097151);
        if (i9 < 2) {
            return null;
        }
        int iD = d(i9);
        long jMin = Long.MAX_VALUE;
        for (int i10 = 0; i10 < i9; i10++) {
            iD++;
            if (iD > i9) {
                iD = 1;
            }
            b bVar = (b) dVar.f10117i.b(iD);
            if (bVar != null && bVar != this) {
                n nVar = bVar.f10101a;
                if (i8 != 3) {
                    nVar.getClass();
                    int i11 = n.f10133d.get(nVar);
                    int i12 = n.f10132c.get(nVar);
                    boolean z2 = i8 == 1;
                    while (true) {
                        if (i11 == i12 || (z2 && n.e.get(nVar) == 0)) {
                            tC = 0;
                            break;
                        }
                        int i13 = i11 + 1;
                        tC = nVar.c(i11, z2);
                        if (tC != 0) {
                            break;
                        }
                        i11 = i13;
                    }
                } else {
                    tC = nVar.b();
                }
                Ref.ObjectRef objectRef = this.f10102b;
                if (tC != 0) {
                    objectRef.element = tC;
                    j10 = -1;
                } else {
                    while (true) {
                        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = n.f10131b;
                        ?? r13 = (j) atomicReferenceFieldUpdater.get(nVar);
                        j8 = -2;
                        if (r13 == 0) {
                            break;
                        }
                        if (((r13.f10124b ? 1 : 2) & i8) == 0) {
                            break;
                        }
                        l.f.getClass();
                        long jNanoTime = System.nanoTime() - r13.f10123a;
                        long j11 = l.f10127b;
                        if (jNanoTime < j11) {
                            j8 = j11 - jNanoTime;
                            break;
                        }
                        if (atomicReferenceFieldUpdater.compareAndSet(nVar, r13, null)) {
                            objectRef.element = r13;
                            j8 = -1;
                            break;
                        }
                    }
                    j10 = j8;
                }
                if (j10 == -1) {
                    j jVar = (j) objectRef.element;
                    objectRef.element = null;
                    return jVar;
                }
                if (j10 > 0) {
                    jMin = Math.min(jMin, j10);
                }
            }
        }
        if (jMin == Long.MAX_VALUE) {
            jMin = 0;
        }
        this.e = jMin;
        return null;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        boolean z2;
        boolean z3 = false;
        loop0: while (true) {
            boolean z5 = z3;
            while (true) {
                d dVar = this.f10107j;
                dVar.getClass();
                if (d.f10110l.get(dVar) == 0) {
                    c cVar = this.f10103c;
                    c cVar2 = c.TERMINATED;
                    if (cVar == cVar2) {
                        break loop0;
                    }
                    j jVarA = a(this.f10106i);
                    long j8 = -2097152;
                    if (jVarA != null) {
                        this.e = 0L;
                        this.f10104d = 0L;
                        if (this.f10103c == c.PARKING) {
                            this.f10103c = c.BLOCKING;
                        }
                        boolean z10 = jVarA.f10124b;
                        d dVar2 = this.f10107j;
                        if (!z10) {
                            dVar2.getClass();
                            try {
                                jVarA.run();
                                break;
                            } catch (Throwable th2) {
                                Thread threadCurrentThread = Thread.currentThread();
                                threadCurrentThread.getUncaughtExceptionHandler().uncaughtException(threadCurrentThread, th2);
                                break;
                            }
                        }
                        if (h(c.BLOCKING) && !dVar2.k() && !dVar2.i(d.f10109k.get(dVar2))) {
                            dVar2.k();
                        }
                        dVar2.getClass();
                        try {
                            jVarA.run();
                        } catch (Throwable th3) {
                            Thread threadCurrentThread2 = Thread.currentThread();
                            threadCurrentThread2.getUncaughtExceptionHandler().uncaughtException(threadCurrentThread2, th3);
                        }
                        d.f10109k.addAndGet(dVar2, -2097152L);
                        if (this.f10103c == cVar2) {
                            break;
                        }
                        this.f10103c = c.DORMANT;
                        break;
                    }
                    this.f10106i = z3;
                    if (this.e == 0) {
                        Object obj = this.nextParkedWorker;
                        a8.a aVar = d.f10111m;
                        if (obj != aVar ? true : z3) {
                            f10100k.set(this, -1);
                            while (this.nextParkedWorker != d.f10111m) {
                                AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f10100k;
                                if (atomicIntegerFieldUpdater.get(this) != -1) {
                                    break;
                                }
                                d dVar3 = this.f10107j;
                                dVar3.getClass();
                                AtomicIntegerFieldUpdater atomicIntegerFieldUpdater2 = d.f10110l;
                                if (atomicIntegerFieldUpdater2.get(dVar3) != 0) {
                                    break;
                                }
                                c cVar3 = this.f10103c;
                                c cVar4 = c.TERMINATED;
                                if (cVar3 == cVar4) {
                                    break;
                                }
                                h(c.PARKING);
                                Thread.interrupted();
                                if (this.f10104d == 0) {
                                    this.f10104d = System.nanoTime() + this.f10107j.f10114c;
                                }
                                LockSupport.parkNanos(this.f10107j.f10114c);
                                if (System.nanoTime() - this.f10104d >= 0) {
                                    this.f10104d = 0L;
                                    d dVar4 = this.f10107j;
                                    synchronized (dVar4.f10117i) {
                                        try {
                                            if (!(atomicIntegerFieldUpdater2.get(dVar4) != 0)) {
                                                AtomicLongFieldUpdater atomicLongFieldUpdater = d.f10109k;
                                                if (((int) (atomicLongFieldUpdater.get(dVar4) & 2097151)) > dVar4.f10112a && atomicIntegerFieldUpdater.compareAndSet(this, -1, 1)) {
                                                    int i8 = this.indexInArray;
                                                    z2 = false;
                                                    f(0);
                                                    dVar4.h(this, i8, 0);
                                                    int andDecrement = (int) (atomicLongFieldUpdater.getAndDecrement(dVar4) & 2097151);
                                                    if (andDecrement != i8) {
                                                        Object objB = dVar4.f10117i.b(andDecrement);
                                                        Intrinsics.checkNotNull(objB);
                                                        b bVar = (b) objB;
                                                        dVar4.f10117i.c(i8, bVar);
                                                        bVar.f(i8);
                                                        dVar4.h(bVar, andDecrement, i8);
                                                    }
                                                    dVar4.f10117i.c(andDecrement, null);
                                                    Unit unit = Unit.INSTANCE;
                                                    this.f10103c = cVar4;
                                                }
                                            }
                                            z2 = false;
                                        } catch (Throwable th4) {
                                            throw th4;
                                        }
                                    }
                                } else {
                                    z2 = false;
                                }
                                z3 = z2;
                            }
                        } else {
                            d dVar5 = this.f10107j;
                            dVar5.getClass();
                            if (this.nextParkedWorker == aVar) {
                                while (true) {
                                    AtomicLongFieldUpdater atomicLongFieldUpdater2 = d.f10108j;
                                    long j10 = atomicLongFieldUpdater2.get(dVar5);
                                    int i9 = this.indexInArray;
                                    this.nextParkedWorker = dVar5.f10117i.b((int) (j10 & 2097151));
                                    if (atomicLongFieldUpdater2.compareAndSet(dVar5, j10, ((2097152 + j10) & j8) | ((long) i9))) {
                                        break;
                                    } else {
                                        j8 = -2097152;
                                    }
                                }
                            }
                        }
                        z3 = z3;
                    } else {
                        if (z5) {
                            h(c.PARKING);
                            Thread.interrupted();
                            LockSupport.parkNanos(this.e);
                            this.e = 0L;
                            break;
                        }
                        z5 = true;
                    }
                } else {
                    break loop0;
                }
            }
        }
        h(c.TERMINATED);
    }
}
