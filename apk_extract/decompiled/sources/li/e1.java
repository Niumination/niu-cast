package li;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.concurrent.locks.LockSupport;
import kotlin.collections.ArrayDeque;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import kotlin.time.DurationKt;

/* JADX INFO: loaded from: classes3.dex */
public abstract class e1 extends f1 implements q0 {
    public static final /* synthetic */ AtomicReferenceFieldUpdater e = AtomicReferenceFieldUpdater.newUpdater(e1.class, Object.class, "_queue$volatile");

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f7446h = AtomicReferenceFieldUpdater.newUpdater(e1.class, Object.class, "_delayed$volatile");

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f7447i = AtomicIntegerFieldUpdater.newUpdater(e1.class, "_isCompleted$volatile");
    private volatile /* synthetic */ Object _delayed$volatile;
    private volatile /* synthetic */ int _isCompleted$volatile = 0;
    private volatile /* synthetic */ Object _queue$volatile;

    /* JADX WARN: Code duplicated, block: B:44:0x0099  */
    /* JADX WARN: Code duplicated, block: B:47:0x009e A[Catch: all -> 0x00b1, TRY_LEAVE, TryCatch #0 {, blocks: (B:45:0x009a, B:47:0x009e), top: B:56:0x009a }] */
    /* JADX WARN: Code duplicated, block: B:51:0x00a5  */
    /* JADX WARN: Code duplicated, block: B:56:0x009a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // li.f1
    public final long B() {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        a8.a aVar;
        Runnable runnable;
        d1 d1Var;
        c1 c1Var;
        if (E()) {
            return 0L;
        }
        b0();
        while (true) {
            atomicReferenceFieldUpdater = e;
            Object obj = atomicReferenceFieldUpdater.get(this);
            aVar = l0.f7470c;
            if (obj != null) {
                if (obj instanceof qi.p) {
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeTaskQueueCore<java.lang.Runnable>");
                    qi.p pVar = (qi.p) obj;
                    Object objD = pVar.d();
                    if (objD != qi.p.f9158g) {
                        runnable = (Runnable) objD;
                        break;
                    }
                    atomicReferenceFieldUpdater.compareAndSet(this, obj, pVar.c());
                } else if (obj != aVar) {
                    if (atomicReferenceFieldUpdater.compareAndSet(this, obj, null)) {
                        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type java.lang.Runnable");
                        runnable = (Runnable) obj;
                        break;
                    }
                }
            }
            runnable = null;
            break;
        }
        if (runnable != null) {
            runnable.run();
            return 0L;
        }
        ArrayDeque arrayDeque = this.f7454c;
        if (((arrayDeque == null || arrayDeque.isEmpty()) ? Long.MAX_VALUE : 0L) == 0) {
            return 0L;
        }
        Object obj2 = atomicReferenceFieldUpdater.get(this);
        if (obj2 == null) {
            d1Var = (d1) f7446h.get(this);
            if (d1Var != null) {
                synchronized (d1Var) {
                    c1[] c1VarArr = d1Var.f9130a;
                    c1Var = c1VarArr != null ? c1VarArr[0] : null;
                }
                if (c1Var != null) {
                    return RangesKt___RangesKt.coerceAtLeast(c1Var.f7438a - System.nanoTime(), 0L);
                }
            }
        } else if (obj2 instanceof qi.p) {
            long j8 = qi.p.f.get((qi.p) obj2);
            if (((int) (1073741823 & j8)) != ((int) ((j8 & 1152921503533105152L) >> 30))) {
                return 0L;
            }
            d1Var = (d1) f7446h.get(this);
            if (d1Var != null) {
                synchronized (d1Var) {
                    c1[] c1VarArr2 = d1Var.f9130a;
                    if (c1VarArr2 != null) {
                    }
                    if (c1Var != null) {
                        return RangesKt___RangesKt.coerceAtLeast(c1Var.f7438a - System.nanoTime(), 0L);
                    }
                }
            }
        } else if (obj2 != aVar) {
            return 0L;
        }
        return Long.MAX_VALUE;
    }

    @Override // li.f1
    public void N() {
        c1 c1VarB;
        k2.f7463a.set(null);
        f7447i.set(this, 1);
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = e;
            Object obj = atomicReferenceFieldUpdater.get(this);
            a8.a aVar = l0.f7470c;
            if (obj == null) {
                if (atomicReferenceFieldUpdater.compareAndSet(this, null, aVar)) {
                    break;
                }
            } else if (obj instanceof qi.p) {
                ((qi.p) obj).b();
                break;
            } else {
                if (obj == aVar) {
                    break;
                }
                qi.p pVar = new qi.p(8, true);
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type java.lang.Runnable");
                pVar.a((Runnable) obj);
                if (atomicReferenceFieldUpdater.compareAndSet(this, obj, pVar)) {
                    break;
                }
            }
        }
        while (B() <= 0) {
        }
        long jNanoTime = System.nanoTime();
        while (true) {
            d1 d1Var = (d1) f7446h.get(this);
            if (d1Var == null) {
                return;
            }
            synchronized (d1Var) {
                c1VarB = qi.a0.f9129b.get(d1Var) > 0 ? d1Var.b(0) : null;
            }
            if (c1VarB == null) {
                return;
            } else {
                I(jNanoTime, c1VarB);
            }
        }
    }

    public void X(Runnable runnable) {
        b0();
        if (!l0(runnable)) {
            m0.f7477j.X(runnable);
            return;
        }
        Thread threadL = l();
        if (Thread.currentThread() != threadL) {
            LockSupport.unpark(threadL);
        }
    }

    public final void b0() {
        c1 c1VarB;
        d1 d1Var = (d1) f7446h.get(this);
        if (d1Var == null || qi.a0.f9129b.get(d1Var) == 0) {
            return;
        }
        long jNanoTime = System.nanoTime();
        do {
            synchronized (d1Var) {
                try {
                    c1[] c1VarArr = d1Var.f9130a;
                    c1VarB = null;
                    c1 c1Var = c1VarArr != null ? c1VarArr[0] : null;
                    if (c1Var != null) {
                        c1VarB = ((jNanoTime - c1Var.f7438a) > 0L ? 1 : ((jNanoTime - c1Var.f7438a) == 0L ? 0 : -1)) >= 0 ? l0(c1Var) : false ? d1Var.b(0) : null;
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        } while (c1VarB != null);
    }

    @Override // li.q0
    public final void c(long j8, l lVar) {
        long j10 = 0;
        if (j8 > 0) {
            j10 = j8 >= 9223372036854L ? Long.MAX_VALUE : 1000000 * j8;
        }
        if (j10 < DurationKt.MAX_MILLIS) {
            long jNanoTime = System.nanoTime();
            a1 a1Var = new a1(this, j10 + jNanoTime, lVar);
            n0(jNanoTime, a1Var);
            lVar.w(new h(a1Var, 2));
        }
    }

    @Override // li.a0
    public final void dispatch(CoroutineContext coroutineContext, Runnable runnable) {
        X(runnable);
    }

    @Override // li.q0
    public x0 g(long j8, Runnable runnable, CoroutineContext coroutineContext) {
        return n0.f7481a.g(j8, runnable, coroutineContext);
    }

    public final boolean l0(Runnable runnable) {
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = e;
            Object obj = atomicReferenceFieldUpdater.get(this);
            if (f7447i.get(this) != 0) {
                return false;
            }
            if (obj == null) {
                if (atomicReferenceFieldUpdater.compareAndSet(this, null, runnable)) {
                    return true;
                }
            } else if (obj instanceof qi.p) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeTaskQueueCore<java.lang.Runnable>");
                qi.p pVar = (qi.p) obj;
                int iA = pVar.a(runnable);
                if (iA == 0) {
                    return true;
                }
                if (iA == 1) {
                    atomicReferenceFieldUpdater.compareAndSet(this, obj, pVar.c());
                } else if (iA == 2) {
                    return false;
                }
            } else {
                if (obj == l0.f7470c) {
                    return false;
                }
                qi.p pVar2 = new qi.p(8, true);
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type java.lang.Runnable");
                pVar2.a((Runnable) obj);
                pVar2.a(runnable);
                if (atomicReferenceFieldUpdater.compareAndSet(this, obj, pVar2)) {
                    return true;
                }
            }
        }
    }

    public final boolean m0() {
        ArrayDeque arrayDeque = this.f7454c;
        if (!(arrayDeque != null ? arrayDeque.isEmpty() : true)) {
            return false;
        }
        d1 d1Var = (d1) f7446h.get(this);
        if (d1Var != null && qi.a0.f9129b.get(d1Var) != 0) {
            return false;
        }
        Object obj = e.get(this);
        if (obj == null) {
            return true;
        }
        if (obj instanceof qi.p) {
            long j8 = qi.p.f.get((qi.p) obj);
            if (((int) (1073741823 & j8)) == ((int) ((j8 & 1152921503533105152L) >> 30))) {
                return true;
            }
        } else if (obj == l0.f7470c) {
            return true;
        }
        return false;
    }

    public final void n0(long j8, c1 c1Var) {
        int iA;
        Thread threadL;
        boolean z2 = f7447i.get(this) != 0;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f7446h;
        c1 c1Var2 = null;
        if (z2) {
            iA = 1;
        } else {
            d1 d1Var = (d1) atomicReferenceFieldUpdater.get(this);
            if (d1Var == null) {
                d1 d1Var2 = new d1();
                d1Var2.f7442c = j8;
                atomicReferenceFieldUpdater.compareAndSet(this, null, d1Var2);
                Object obj = atomicReferenceFieldUpdater.get(this);
                Intrinsics.checkNotNull(obj);
                d1Var = (d1) obj;
            }
            iA = c1Var.a(j8, d1Var, this);
        }
        if (iA != 0) {
            if (iA == 1) {
                I(j8, c1Var);
                return;
            } else {
                if (iA != 2) {
                    throw new IllegalStateException("unexpected result");
                }
                return;
            }
        }
        d1 d1Var3 = (d1) atomicReferenceFieldUpdater.get(this);
        if (d1Var3 != null) {
            synchronized (d1Var3) {
                c1[] c1VarArr = d1Var3.f9130a;
                c1Var2 = c1VarArr != null ? c1VarArr[0] : null;
            }
        }
        if (c1Var2 != c1Var || Thread.currentThread() == (threadL = l())) {
            return;
        }
        LockSupport.unpark(threadL);
    }
}
