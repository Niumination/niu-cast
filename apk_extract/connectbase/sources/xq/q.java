package xq;

import in.x;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kn.k1;
import kn.r1;
import q1.w2;

/* JADX INFO: loaded from: classes3.dex */
@r1({"SMAP\nWorkQueue.kt\nKotlin\n*S Kotlin\n*F\n+ 1 WorkQueue.kt\nkotlinx/coroutines/scheduling/WorkQueue\n+ 2 Tasks.kt\nkotlinx/coroutines/scheduling/TasksKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 WorkQueue.kt\nkotlinx/coroutines/scheduling/WorkQueueKt\n*L\n1#1,255:1\n93#2:256\n93#2:257\n93#2:258\n93#2:261\n93#2:262\n1#3:259\n25#4:260\n*S KotlinDebug\n*F\n+ 1 WorkQueue.kt\nkotlinx/coroutines/scheduling/WorkQueue\n*L\n95#1:256\n162#1:257\n185#1:258\n205#1:261\n249#1:262\n205#1:260\n*E\n"})
public final class q {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.l
    public static final AtomicReferenceFieldUpdater f20531b = AtomicReferenceFieldUpdater.newUpdater(q.class, Object.class, "lastScheduledTask");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @os.l
    public static final AtomicIntegerFieldUpdater f20532c = AtomicIntegerFieldUpdater.newUpdater(q.class, "producerIndex");

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @os.l
    public static final AtomicIntegerFieldUpdater f20533d = AtomicIntegerFieldUpdater.newUpdater(q.class, "consumerIndex");

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @os.l
    public static final AtomicIntegerFieldUpdater f20534e = AtomicIntegerFieldUpdater.newUpdater(q.class, "blockingTasksInBuffer");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public final AtomicReferenceArray<k> f20535a = new AtomicReferenceArray<>(128);

    @x
    private volatile int blockingTasksInBuffer;

    @x
    private volatile int consumerIndex;

    @os.m
    @x
    private volatile Object lastScheduledTask;

    @x
    private volatile int producerIndex;

    public static /* synthetic */ k b(q qVar, k kVar, boolean z10, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            z10 = false;
        }
        return qVar.a(kVar, z10);
    }

    @os.m
    public final k a(@os.l k kVar, boolean z10) {
        if (z10) {
            return c(kVar);
        }
        k kVar2 = (k) f20531b.getAndSet(this, kVar);
        if (kVar2 == null) {
            return null;
        }
        return c(kVar2);
    }

    public final k c(k kVar) {
        if (e() == 127) {
            return kVar;
        }
        if (kVar.f20517b.q() == 1) {
            f20534e.incrementAndGet(this);
        }
        int i10 = f20532c.get(this) & 127;
        while (this.f20535a.get(i10) != null) {
            Thread.yield();
        }
        this.f20535a.lazySet(i10, kVar);
        f20532c.incrementAndGet(this);
        return null;
    }

    public final void d(k kVar) {
        if (kVar == null || kVar.f20517b.q() != 1) {
            return;
        }
        f20534e.decrementAndGet(this);
    }

    public final int e() {
        return f20532c.get(this) - f20533d.get(this);
    }

    public final int f() {
        Object obj = f20531b.get(this);
        int iE = e();
        return obj != null ? iE + 1 : iE;
    }

    public final void g(@os.l f fVar) {
        k kVar = (k) f20531b.getAndSet(this, null);
        if (kVar != null) {
            fVar.a(kVar);
        }
        while (l(fVar)) {
        }
    }

    @os.m
    public final k h() {
        k kVar = (k) f20531b.getAndSet(this, null);
        return kVar == null ? j() : kVar;
    }

    @os.m
    public final k i() {
        return m(true);
    }

    public final k j() {
        k andSet;
        while (true) {
            AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f20533d;
            int i10 = atomicIntegerFieldUpdater.get(this);
            if (i10 - f20532c.get(this) == 0) {
                return null;
            }
            int i11 = i10 & 127;
            if (atomicIntegerFieldUpdater.compareAndSet(this, i10, i10 + 1) && (andSet = this.f20535a.getAndSet(i11, null)) != null) {
                d(andSet);
                return andSet;
            }
        }
    }

    @os.m
    public final k k() {
        return m(false);
    }

    public final boolean l(f fVar) {
        k kVarJ = j();
        if (kVarJ == null) {
            return false;
        }
        fVar.a(kVarJ);
        return true;
    }

    public final k m(boolean z10) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        k kVar;
        do {
            atomicReferenceFieldUpdater = f20531b;
            kVar = (k) atomicReferenceFieldUpdater.get(this);
            if (kVar != null) {
                if ((kVar.f20517b.q() == 1) == z10) {
                }
            }
            int i10 = f20533d.get(this);
            int i11 = f20532c.get(this);
            while (i10 != i11) {
                if (z10 && f20534e.get(this) == 0) {
                    return null;
                }
                i11--;
                k kVarO = o(i11, z10);
                if (kVarO != null) {
                    return kVarO;
                }
            }
            return null;
        } while (!j.d.a(atomicReferenceFieldUpdater, this, kVar, null));
        return kVar;
    }

    public final k n(int i10) {
        int i11 = f20533d.get(this);
        int i12 = f20532c.get(this);
        boolean z10 = i10 == 1;
        while (i11 != i12) {
            if (z10 && f20534e.get(this) == 0) {
                return null;
            }
            int i13 = i11 + 1;
            k kVarO = o(i11, z10);
            if (kVarO != null) {
                return kVarO;
            }
            i11 = i13;
        }
        return null;
    }

    public final k o(int i10, boolean z10) {
        int i11 = i10 & 127;
        k kVar = this.f20535a.get(i11);
        if (kVar != null) {
            if ((kVar.f20517b.q() == 1) == z10 && w2.a(this.f20535a, i11, kVar, null)) {
                if (z10) {
                    f20534e.decrementAndGet(this);
                }
                return kVar;
            }
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final long p(int i10, @os.l k1.h<k> hVar) {
        k kVarN;
        T t10;
        k kVarJ;
        if (i10 == 3) {
            kVarJ = j();
        } else {
            kVarN = n(i10);
        }
        if (t10 == 0) {
            t10 = kVarN;
            t10 = kVarJ;
            return q(i10, hVar);
        }
        t10 = kVarN;
        t10 = kVarJ;
        hVar.element = t10;
        return -1L;
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [T, java.lang.Object, xq.k] */
    public final long q(int i10, k1.h<k> hVar) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        ?? r10;
        do {
            atomicReferenceFieldUpdater = f20531b;
            r10 = (k) atomicReferenceFieldUpdater.get(this);
            if (r10 == 0) {
                return -2L;
            }
            if (((r10.f20517b.q() != 1 ? 2 : 1) & i10) == 0) {
                return -2L;
            }
            long jA = o.f20525f.a() - r10.f20516a;
            long j10 = o.f20521b;
            if (jA < j10) {
                return j10 - jA;
            }
        } while (!j.d.a(atomicReferenceFieldUpdater, this, r10, null));
        hVar.element = r10;
        return -1L;
    }
}
