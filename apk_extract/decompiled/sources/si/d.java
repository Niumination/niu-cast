package si;

import androidx.work.WorkRequest;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.concurrent.locks.LockSupport;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import li.l0;
import qi.p;
import qi.u;

/* JADX INFO: loaded from: classes3.dex */
public final class d implements Executor, Closeable {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final /* synthetic */ AtomicLongFieldUpdater f10108j = AtomicLongFieldUpdater.newUpdater(d.class, "parkedWorkersStack$volatile");

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final /* synthetic */ AtomicLongFieldUpdater f10109k = AtomicLongFieldUpdater.newUpdater(d.class, "controlState$volatile");

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f10110l = AtomicIntegerFieldUpdater.newUpdater(d.class, "_isTerminated$volatile");

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final a8.a f10111m = new a8.a("NOT_IN_STACK", 15);
    private volatile /* synthetic */ int _isTerminated$volatile;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f10112a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f10113b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f10114c;
    private volatile /* synthetic */ long controlState$volatile;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f10115d;
    public final g e;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final g f10116h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final u f10117i;
    private volatile /* synthetic */ long parkedWorkersStack$volatile;

    public d(int i8, int i9, long j8, String str) {
        this.f10112a = i8;
        this.f10113b = i9;
        this.f10114c = j8;
        this.f10115d = str;
        if (i8 < 1) {
            throw new IllegalArgumentException(h0.a.h(i8, "Core pool size ", " should be at least 1").toString());
        }
        if (i9 < i8) {
            throw new IllegalArgumentException(o.d.f(i9, i8, "Max pool size ", " should be greater than or equals to core pool size ").toString());
        }
        if (i9 > 2097150) {
            throw new IllegalArgumentException(h0.a.h(i9, "Max pool size ", " should not exceed maximal supported number of threads 2097150").toString());
        }
        if (j8 <= 0) {
            throw new IllegalArgumentException(("Idle worker keep alive time " + j8 + " must be positive").toString());
        }
        this.e = new g();
        this.f10116h = new g();
        this.f10117i = new u((i8 + 1) * 2);
        this.controlState$volatile = ((long) i8) << 42;
        this._isTerminated$volatile = 0;
    }

    public static /* synthetic */ void g(d dVar, Runnable runnable, boolean z2, int i8) {
        if ((i8 & 4) != 0) {
            z2 = false;
        }
        dVar.c(runnable, false, z2);
    }

    public final int a() {
        synchronized (this.f10117i) {
            try {
                if (f10110l.get(this) != 0) {
                    return -1;
                }
                AtomicLongFieldUpdater atomicLongFieldUpdater = f10109k;
                long j8 = atomicLongFieldUpdater.get(this);
                int i8 = (int) (j8 & 2097151);
                int iCoerceAtLeast = RangesKt.coerceAtLeast(i8 - ((int) ((j8 & 4398044413952L) >> 21)), 0);
                if (iCoerceAtLeast >= this.f10112a) {
                    return 0;
                }
                if (i8 >= this.f10113b) {
                    return 0;
                }
                int i9 = ((int) (atomicLongFieldUpdater.get(this) & 2097151)) + 1;
                if (i9 <= 0 || this.f10117i.b(i9) != null) {
                    throw new IllegalArgumentException("Failed requirement.");
                }
                b bVar = new b(this, i9);
                this.f10117i.c(i9, bVar);
                if (i9 != ((int) (2097151 & atomicLongFieldUpdater.incrementAndGet(this)))) {
                    throw new IllegalArgumentException("Failed requirement.");
                }
                int i10 = iCoerceAtLeast + 1;
                bVar.start();
                return i10;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public final void c(Runnable runnable, boolean z2, boolean z3) {
        j kVar;
        c cVar;
        l.f.getClass();
        long jNanoTime = System.nanoTime();
        if (runnable instanceof j) {
            kVar = (j) runnable;
            kVar.f10123a = jNanoTime;
            kVar.f10124b = z2;
        } else {
            kVar = new k(runnable, jNanoTime, z2);
        }
        boolean z5 = kVar.f10124b;
        AtomicLongFieldUpdater atomicLongFieldUpdater = f10109k;
        long jAddAndGet = z5 ? atomicLongFieldUpdater.addAndGet(this, 2097152L) : 0L;
        Thread threadCurrentThread = Thread.currentThread();
        b bVar = threadCurrentThread instanceof b ? (b) threadCurrentThread : null;
        if (bVar == null || !Intrinsics.areEqual(bVar.f10107j, this)) {
            bVar = null;
        }
        if (bVar != null && (cVar = bVar.f10103c) != c.TERMINATED && (kVar.f10124b || cVar != c.BLOCKING)) {
            bVar.f10106i = true;
            n nVar = bVar.f10101a;
            if (z3) {
                kVar = nVar.a(kVar);
            } else {
                nVar.getClass();
                j jVar = (j) n.f10131b.getAndSet(nVar, kVar);
                kVar = jVar == null ? null : nVar.a(jVar);
            }
        }
        if (kVar != null) {
            if (!(kVar.f10124b ? this.f10116h.a(kVar) : this.e.a(kVar))) {
                throw new RejectedExecutionException(h0.a.n(new StringBuilder(), this.f10115d, " was terminated"));
            }
        }
        boolean z10 = z3 && bVar != null;
        if (z5) {
            if (z10 || k() || i(jAddAndGet)) {
                return;
            }
            k();
            return;
        }
        if (z10 || k() || i(atomicLongFieldUpdater.get(this))) {
            return;
        }
        k();
    }

    /* JADX WARN: Code duplicated, block: B:44:0x00a7  */
    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws InterruptedException {
        int i8;
        j jVarA;
        if (f10110l.compareAndSet(this, 0, 1)) {
            Thread threadCurrentThread = Thread.currentThread();
            b bVar = threadCurrentThread instanceof b ? (b) threadCurrentThread : null;
            if (bVar == null || !Intrinsics.areEqual(bVar.f10107j, this)) {
                bVar = null;
            }
            synchronized (this.f10117i) {
                i8 = (int) (f10109k.get(this) & 2097151);
            }
            if (1 <= i8) {
                int i9 = 1;
                while (true) {
                    Object objB = this.f10117i.b(i9);
                    Intrinsics.checkNotNull(objB);
                    b bVar2 = (b) objB;
                    if (bVar2 != bVar) {
                        while (bVar2.getState() != Thread.State.TERMINATED) {
                            LockSupport.unpark(bVar2);
                            bVar2.join(WorkRequest.MIN_BACKOFF_MILLIS);
                        }
                        n nVar = bVar2.f10101a;
                        g gVar = this.f10116h;
                        nVar.getClass();
                        j jVar = (j) n.f10131b.getAndSet(nVar, null);
                        if (jVar != null) {
                            gVar.a(jVar);
                        }
                        while (true) {
                            j jVarB = nVar.b();
                            if (jVarB == null) {
                                break;
                            } else {
                                gVar.a(jVarB);
                            }
                        }
                    }
                    if (i9 == i8) {
                        break;
                    } else {
                        i9++;
                    }
                }
            }
            g gVar2 = this.f10116h;
            gVar2.getClass();
            while (true) {
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = qi.n.f9156a;
                p pVar = (p) atomicReferenceFieldUpdater.get(gVar2);
                if (pVar.b()) {
                    break;
                } else {
                    atomicReferenceFieldUpdater.compareAndSet(gVar2, pVar, pVar.c());
                }
            }
            g gVar3 = this.e;
            gVar3.getClass();
            while (true) {
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = qi.n.f9156a;
                p pVar2 = (p) atomicReferenceFieldUpdater2.get(gVar3);
                if (pVar2.b()) {
                    break;
                } else {
                    atomicReferenceFieldUpdater2.compareAndSet(gVar3, pVar2, pVar2.c());
                }
            }
            while (true) {
                if (bVar != null) {
                    jVarA = bVar.a(true);
                    if (jVarA == null) {
                        jVarA = (j) this.e.c();
                        if (jVarA == null) {
                            break;
                            break;
                        }
                    }
                } else {
                    jVarA = (j) this.e.c();
                    if (jVarA == null && (jVarA = (j) this.f10116h.c()) == null) {
                        break;
                    }
                }
                try {
                    jVarA.run();
                } catch (Throwable th2) {
                    Thread threadCurrentThread2 = Thread.currentThread();
                    threadCurrentThread2.getUncaughtExceptionHandler().uncaughtException(threadCurrentThread2, th2);
                }
            }
            if (bVar != null) {
                bVar.h(c.TERMINATED);
            }
            f10108j.set(this, 0L);
            f10109k.set(this, 0L);
        }
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        g(this, runnable, false, 6);
    }

    public final void h(b bVar, int i8, int i9) {
        while (true) {
            long j8 = f10108j.get(this);
            int i10 = (int) (2097151 & j8);
            long j10 = (2097152 + j8) & (-2097152);
            if (i10 == i8) {
                if (i9 == 0) {
                    Object objC = bVar.c();
                    while (true) {
                        if (objC == f10111m) {
                            i10 = -1;
                            break;
                        }
                        if (objC == null) {
                            i10 = 0;
                            break;
                        }
                        b bVar2 = (b) objC;
                        int iB = bVar2.b();
                        if (iB != 0) {
                            i10 = iB;
                            break;
                        }
                        objC = bVar2.c();
                    }
                } else {
                    i10 = i9;
                }
            }
            if (i10 >= 0) {
                if (f10108j.compareAndSet(this, j8, ((long) i10) | j10)) {
                    return;
                }
            }
        }
    }

    public final boolean i(long j8) {
        int iCoerceAtLeast = RangesKt.coerceAtLeast(((int) (2097151 & j8)) - ((int) ((j8 & 4398044413952L) >> 21)), 0);
        int i8 = this.f10112a;
        if (iCoerceAtLeast < i8) {
            int iA = a();
            if (iA == 1 && i8 > 1) {
                a();
            }
            if (iA > 0) {
                return true;
            }
        }
        return false;
    }

    public final boolean k() {
        a8.a aVar;
        int iB;
        while (true) {
            AtomicLongFieldUpdater atomicLongFieldUpdater = f10108j;
            long j8 = atomicLongFieldUpdater.get(this);
            b bVar = (b) this.f10117i.b((int) (2097151 & j8));
            if (bVar == null) {
                bVar = null;
            } else {
                long j10 = (2097152 + j8) & (-2097152);
                Object objC = bVar.c();
                while (true) {
                    aVar = f10111m;
                    if (objC == aVar) {
                        iB = -1;
                        break;
                    }
                    if (objC == null) {
                        iB = 0;
                        break;
                    }
                    b bVar2 = (b) objC;
                    iB = bVar2.b();
                    if (iB != 0) {
                        break;
                    }
                    objC = bVar2.c();
                }
                if (iB >= 0 && atomicLongFieldUpdater.compareAndSet(this, j8, j10 | ((long) iB))) {
                    bVar.g(aVar);
                }
            }
            if (bVar == null) {
                return false;
            }
            if (b.f10100k.compareAndSet(bVar, -1, 0)) {
                LockSupport.unpark(bVar);
                return true;
            }
        }
    }

    public final String toString() {
        ArrayList arrayList = new ArrayList();
        u uVar = this.f10117i;
        int iA = uVar.a();
        int i8 = 0;
        int i9 = 0;
        int i10 = 0;
        int i11 = 0;
        int i12 = 0;
        for (int i13 = 1; i13 < iA; i13++) {
            b bVar = (b) uVar.b(i13);
            if (bVar != null) {
                n nVar = bVar.f10101a;
                nVar.getClass();
                int i14 = n.f10131b.get(nVar) != null ? (n.f10132c.get(nVar) - n.f10133d.get(nVar)) + 1 : n.f10132c.get(nVar) - n.f10133d.get(nVar);
                int i15 = a.$EnumSwitchMapping$0[bVar.f10103c.ordinal()];
                if (i15 == 1) {
                    i10++;
                } else if (i15 == 2) {
                    i9++;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(i14);
                    sb2.append('b');
                    arrayList.add(sb2.toString());
                } else if (i15 == 3) {
                    i8++;
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append(i14);
                    sb3.append('c');
                    arrayList.add(sb3.toString());
                } else if (i15 == 4) {
                    i11++;
                    if (i14 > 0) {
                        StringBuilder sb4 = new StringBuilder();
                        sb4.append(i14);
                        sb4.append('d');
                        arrayList.add(sb4.toString());
                    }
                } else {
                    if (i15 != 5) {
                        throw new NoWhenBranchMatchedException();
                    }
                    i12++;
                }
            }
        }
        long j8 = f10109k.get(this);
        StringBuilder sb5 = new StringBuilder();
        sb5.append(this.f10115d);
        sb5.append('@');
        sb5.append(l0.j(this));
        sb5.append("[Pool Size {core = ");
        int i16 = this.f10112a;
        sb5.append(i16);
        sb5.append(", max = ");
        sb5.append(this.f10113b);
        sb5.append("}, Worker States {CPU = ");
        sb5.append(i8);
        sb5.append(", blocking = ");
        sb5.append(i9);
        sb5.append(", parked = ");
        sb5.append(i10);
        sb5.append(", dormant = ");
        sb5.append(i11);
        sb5.append(", terminated = ");
        sb5.append(i12);
        sb5.append("}, running workers queues = ");
        sb5.append(arrayList);
        sb5.append(", global CPU queue size = ");
        sb5.append(this.e.b());
        sb5.append(", global blocking queue size = ");
        sb5.append(this.f10116h.b());
        sb5.append(", Control State {created workers= ");
        sb5.append((int) (2097151 & j8));
        sb5.append(", blocking tasks = ");
        sb5.append((int) ((4398044413952L & j8) >> 21));
        sb5.append(", CPUs acquired = ");
        sb5.append(i16 - ((int) ((j8 & 9223367638808264704L) >> 42)));
        sb5.append("}]");
        return sb5.toString();
    }
}
