package nq;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* JADX INFO: loaded from: classes3.dex */
@kn.r1({"SMAP\nEventLoop.common.kt\nKotlin\n*S Kotlin\n*F\n+ 1 EventLoop.common.kt\nkotlinx/coroutines/EventLoopImplBase\n+ 2 ThreadSafeHeap.kt\nkotlinx/coroutines/internal/ThreadSafeHeap\n+ 3 Synchronized.common.kt\nkotlinx/coroutines/internal/Synchronized_commonKt\n+ 4 Synchronized.kt\nkotlinx/coroutines/internal/SynchronizedKt\n+ 5 EventLoop.kt\nkotlinx/coroutines/EventLoopKt\n+ 6 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,543:1\n60#2:544\n61#2,7:550\n28#3,4:545\n20#4:549\n56#5:557\n1#6:558\n*S KotlinDebug\n*F\n+ 1 EventLoop.common.kt\nkotlinx/coroutines/EventLoopImplBase\n*L\n269#1:544\n269#1:550,7\n269#1:545,4\n269#1:549\n280#1:557\n*E\n"})
public abstract class s1 extends t1 implements c1 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @os.l
    public static final AtomicReferenceFieldUpdater f11915d = AtomicReferenceFieldUpdater.newUpdater(s1.class, Object.class, "_queue");

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @os.l
    public static final AtomicReferenceFieldUpdater f11916e = AtomicReferenceFieldUpdater.newUpdater(s1.class, Object.class, "_delayed");

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @os.l
    public static final AtomicIntegerFieldUpdater f11917f = AtomicIntegerFieldUpdater.newUpdater(s1.class, "_isCompleted");

    @os.m
    @in.x
    private volatile Object _delayed;

    @in.x
    private volatile int _isCompleted = 0;

    @os.m
    @in.x
    private volatile Object _queue;

    @kn.r1({"SMAP\nEventLoop.common.kt\nKotlin\n*S Kotlin\n*F\n+ 1 EventLoop.common.kt\nkotlinx/coroutines/EventLoopImplBase$DelayedResumeTask\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,543:1\n1#2:544\n*E\n"})
    public final class a extends c {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @os.l
        public final p<lm.l2> f11918c;

        /* JADX WARN: Multi-variable type inference failed */
        public a(@os.l long j10, p<? super lm.l2> pVar) {
            super(j10);
            this.f11918c = pVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f11918c.G(s1.this, lm.l2.f10208a);
        }

        @Override // nq.s1.c
        @os.l
        public String toString() {
            return super.toString() + this.f11918c;
        }
    }

    public static final class b extends c {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @os.l
        public final Runnable f11920c;

        public b(long j10, @os.l Runnable runnable) {
            super(j10);
            this.f11920c = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f11920c.run();
        }

        @Override // nq.s1.c
        @os.l
        public String toString() {
            return super.toString() + this.f11920c;
        }
    }

    @kn.r1({"SMAP\nEventLoop.common.kt\nKotlin\n*S Kotlin\n*F\n+ 1 EventLoop.common.kt\nkotlinx/coroutines/EventLoopImplBase$DelayedTask\n+ 2 Synchronized.common.kt\nkotlinx/coroutines/internal/Synchronized_commonKt\n+ 3 Synchronized.kt\nkotlinx/coroutines/internal/SynchronizedKt\n+ 4 ThreadSafeHeap.kt\nkotlinx/coroutines/internal/ThreadSafeHeap\n*L\n1#1,543:1\n28#2,4:544\n28#2,4:550\n28#2,4:562\n20#3:548\n20#3:554\n20#3:566\n72#4:549\n73#4,7:555\n*S KotlinDebug\n*F\n+ 1 EventLoop.common.kt\nkotlinx/coroutines/EventLoopImplBase$DelayedTask\n*L\n437#1:544,4\n439#1:550,4\n479#1:562,4\n437#1:548\n439#1:554\n479#1:566\n439#1:549\n439#1:555,7\n*E\n"})
    public static abstract class c implements Runnable, Comparable<c>, n1, vq.f1 {

        @os.m
        private volatile Object _heap;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @in.f
        public long f11921a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f11922b = -1;

        public c(long j10) {
            this.f11921a = j10;
        }

        @Override // vq.f1
        @os.m
        public vq.e1<?> b() {
            Object obj = this._heap;
            if (obj instanceof vq.e1) {
                return (vq.e1) obj;
            }
            return null;
        }

        @Override // vq.f1
        public void d(@os.m vq.e1<?> e1Var) {
            if (this._heap == v1.f11963a) {
                throw new IllegalArgumentException("Failed requirement.");
            }
            this._heap = e1Var;
        }

        @Override // nq.n1
        public final void dispose() {
            synchronized (this) {
                try {
                    Object obj = this._heap;
                    if (obj == v1.f11963a) {
                        return;
                    }
                    d dVar = obj instanceof d ? (d) obj : null;
                    if (dVar != null) {
                        dVar.k(this);
                    }
                    this._heap = v1.f11963a;
                    lm.l2 l2Var = lm.l2.f10208a;
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }

        @Override // vq.f1
        public int f() {
            return this.f11922b;
        }

        @Override // vq.f1
        public void h(int i10) {
            this.f11922b = i10;
        }

        @Override // java.lang.Comparable
        /* JADX INFO: renamed from: l, reason: merged with bridge method [inline-methods] */
        public int compareTo(@os.l c cVar) {
            long j10 = this.f11921a - cVar.f11921a;
            if (j10 > 0) {
                return 1;
            }
            return j10 < 0 ? -1 : 0;
        }

        public final int m(long j10, @os.l d dVar, @os.l s1 s1Var) {
            synchronized (this) {
                if (this._heap == v1.f11963a) {
                    return 2;
                }
                synchronized (dVar) {
                    try {
                        c cVarF = dVar.f();
                        if (s1Var.isCompleted()) {
                            return 1;
                        }
                        if (cVarF == null) {
                            dVar.f11923c = j10;
                        } else {
                            long j11 = cVarF.f11921a;
                            if (j11 - j10 < 0) {
                                j10 = j11;
                            }
                            if (j10 - dVar.f11923c > 0) {
                                dVar.f11923c = j10;
                            }
                        }
                        long j12 = this.f11921a;
                        long j13 = dVar.f11923c;
                        if (j12 - j13 < 0) {
                            this.f11921a = j13;
                        }
                        dVar.a(this);
                        return 0;
                    } catch (Throwable th2) {
                        throw th2;
                    }
                }
            }
        }

        public final boolean n(long j10) {
            return j10 - this.f11921a >= 0;
        }

        @os.l
        public String toString() {
            return n2.k0.a(new StringBuilder("Delayed[nanos="), this.f11921a, ']');
        }
    }

    public static final class d extends vq.e1<c> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @in.f
        public long f11923c;

        public d(long j10) {
            this.f11923c = j10;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean isCompleted() {
        return f11917f.get(this) != 0;
    }

    private final void m2(AtomicReferenceFieldUpdater atomicReferenceFieldUpdater, jn.l<Object, lm.l2> lVar, Object obj) {
        while (true) {
            lVar.invoke(atomicReferenceFieldUpdater.get(obj));
        }
    }

    @Override // nq.c1
    @os.l
    public n1 E(long j10, @os.l Runnable runnable, @os.l um.g gVar) {
        return c1.a.b(this, j10, runnable, gVar);
    }

    @Override // nq.r1
    public boolean Q0() {
        if (!U0()) {
            return false;
        }
        d dVar = (d) f11916e.get(this);
        if (dVar != null && !dVar.h()) {
            return false;
        }
        Object obj = f11915d.get(this);
        if (obj != null) {
            if (obj instanceof vq.c0) {
                return ((vq.c0) obj).h();
            }
            if (obj != v1.f11970h) {
                return false;
            }
        }
        return true;
    }

    @Override // nq.c1
    public void b0(long j10, @os.l p<? super lm.l2> pVar) {
        long jD = v1.d(j10);
        if (jD < 4611686018427387903L) {
            nq.b bVarB = nq.c.b();
            long jB = bVarB != null ? bVarB.b() : System.nanoTime();
            a aVar = new a(jD + jB, pVar);
            p2(jB, aVar);
            s.a(pVar, aVar);
        }
    }

    @Override // nq.r1
    public long c1() {
        c cVarL;
        if (B1()) {
            return 0L;
        }
        d dVar = (d) f11916e.get(this);
        if (dVar != null && !dVar.h()) {
            nq.b bVarB = nq.c.b();
            long jB = bVarB != null ? bVarB.b() : System.nanoTime();
            do {
                synchronized (dVar) {
                    try {
                        c cVarF = dVar.f();
                        cVarL = null;
                        if (cVarF != null) {
                            c cVar = cVarF;
                            cVarL = cVar.n(jB) ? l2(cVar) : false ? dVar.l(0) : null;
                        }
                    } catch (Throwable th2) {
                        throw th2;
                    }
                }
            } while (cVarL != null);
        }
        Runnable runnableJ2 = j2();
        if (runnableJ2 == null) {
            return w0();
        }
        runnableJ2.run();
        return 0L;
    }

    @Override // nq.n0
    public final void dispatch(@os.l um.g gVar, @os.l Runnable runnable) {
        k2(runnable);
    }

    public final void i2() {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f11915d;
        while (true) {
            Object obj = atomicReferenceFieldUpdater.get(this);
            if (obj == null) {
                if (j.d.a(f11915d, this, null, v1.f11970h)) {
                    return;
                }
            } else if (obj instanceof vq.c0) {
                ((vq.c0) obj).d();
                return;
            } else {
                if (obj == v1.f11970h) {
                    return;
                }
                vq.c0 c0Var = new vq.c0(8, true);
                kn.l0.n(obj, "null cannot be cast to non-null type java.lang.Runnable{ kotlinx.coroutines.RunnableKt.Runnable }");
                c0Var.a((Runnable) obj);
                if (j.d.a(f11915d, this, obj, c0Var)) {
                    return;
                }
            }
        }
    }

    public final Runnable j2() {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f11915d;
        while (true) {
            Object obj = atomicReferenceFieldUpdater.get(this);
            if (obj == null) {
                return null;
            }
            if (obj instanceof vq.c0) {
                kn.l0.n(obj, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeTaskQueueCore<java.lang.Runnable{ kotlinx.coroutines.RunnableKt.Runnable }>{ kotlinx.coroutines.EventLoop_commonKt.Queue<java.lang.Runnable{ kotlinx.coroutines.RunnableKt.Runnable }> }");
                vq.c0 c0Var = (vq.c0) obj;
                Object objN = c0Var.n();
                if (objN != vq.c0.f17820t) {
                    return (Runnable) objN;
                }
                j.d.a(f11915d, this, obj, c0Var.m());
            } else {
                if (obj == v1.f11970h) {
                    return null;
                }
                if (j.d.a(f11915d, this, obj, null)) {
                    kn.l0.n(obj, "null cannot be cast to non-null type java.lang.Runnable{ kotlinx.coroutines.RunnableKt.Runnable }");
                    return (Runnable) obj;
                }
            }
        }
    }

    public void k2(@os.l Runnable runnable) {
        if (l2(runnable)) {
            g2();
        } else {
            y0.f11985g.k2(runnable);
        }
    }

    public final boolean l2(Runnable runnable) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f11915d;
        while (true) {
            Object obj = atomicReferenceFieldUpdater.get(this);
            if (isCompleted()) {
                return false;
            }
            if (obj == null) {
                if (j.d.a(f11915d, this, null, runnable)) {
                    return true;
                }
            } else if (obj instanceof vq.c0) {
                kn.l0.n(obj, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeTaskQueueCore<java.lang.Runnable{ kotlinx.coroutines.RunnableKt.Runnable }>{ kotlinx.coroutines.EventLoop_commonKt.Queue<java.lang.Runnable{ kotlinx.coroutines.RunnableKt.Runnable }> }");
                vq.c0 c0Var = (vq.c0) obj;
                int iA = c0Var.a(runnable);
                if (iA == 0) {
                    return true;
                }
                if (iA == 1) {
                    j.d.a(f11915d, this, obj, c0Var.m());
                } else if (iA == 2) {
                    return false;
                }
            } else {
                if (obj == v1.f11970h) {
                    return false;
                }
                vq.c0 c0Var2 = new vq.c0(8, true);
                kn.l0.n(obj, "null cannot be cast to non-null type java.lang.Runnable{ kotlinx.coroutines.RunnableKt.Runnable }");
                c0Var2.a((Runnable) obj);
                c0Var2.a(runnable);
                if (j.d.a(f11915d, this, obj, c0Var2)) {
                    return true;
                }
            }
        }
    }

    @Override // nq.c1
    @os.m
    @lm.k(level = lm.m.ERROR, message = "Deprecated without replacement as an internal method never intended for public use")
    public Object n(long j10, @os.l um.d<? super lm.l2> dVar) {
        return c1.a.a(this, j10, dVar);
    }

    public final void n2() {
        c cVarN;
        nq.b bVarB = nq.c.b();
        long jB = bVarB != null ? bVarB.b() : System.nanoTime();
        while (true) {
            d dVar = (d) f11916e.get(this);
            if (dVar == null || (cVarN = dVar.n()) == null) {
                return;
            } else {
                f2(jB, cVarN);
            }
        }
    }

    public final void o2() {
        f11915d.set(this, null);
        f11916e.set(this, null);
    }

    public final void p2(long j10, @os.l c cVar) {
        int iQ2 = q2(j10, cVar);
        if (iQ2 == 0) {
            if (t2(cVar)) {
                g2();
            }
        } else if (iQ2 == 1) {
            f2(j10, cVar);
        } else if (iQ2 != 2) {
            throw new IllegalStateException("unexpected result");
        }
    }

    public final int q2(long j10, c cVar) {
        if (isCompleted()) {
            return 1;
        }
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f11916e;
        d dVar = (d) atomicReferenceFieldUpdater.get(this);
        if (dVar == null) {
            j.d.a(atomicReferenceFieldUpdater, this, null, new d(j10));
            Object obj = atomicReferenceFieldUpdater.get(this);
            kn.l0.m(obj);
            dVar = (d) obj;
        }
        return cVar.m(j10, dVar, this);
    }

    @os.l
    public final n1 r2(long j10, @os.l Runnable runnable) {
        long jD = v1.d(j10);
        if (jD >= 4611686018427387903L) {
            return a3.f11823a;
        }
        nq.b bVarB = nq.c.b();
        long jB = bVarB != null ? bVarB.b() : System.nanoTime();
        b bVar = new b(jD + jB, runnable);
        p2(jB, bVar);
        return bVar;
    }

    public final void s2(boolean z10) {
        f11917f.set(this, z10 ? 1 : 0);
    }

    @Override // nq.r1
    public void shutdown() {
        p3.f11893a.c();
        s2(true);
        i2();
        while (c1() <= 0) {
        }
        n2();
    }

    public final boolean t2(c cVar) {
        d dVar = (d) f11916e.get(this);
        return (dVar != null ? dVar.i() : null) == cVar;
    }

    @Override // nq.r1
    public long w0() {
        c cVarI;
        if (super.w0() == 0) {
            return 0L;
        }
        Object obj = f11915d.get(this);
        if (obj != null) {
            if (!(obj instanceof vq.c0)) {
                return obj == v1.f11970h ? Long.MAX_VALUE : 0L;
            }
            if (!((vq.c0) obj).h()) {
                return 0L;
            }
        }
        d dVar = (d) f11916e.get(this);
        if (dVar == null || (cVarI = dVar.i()) == null) {
            return Long.MAX_VALUE;
        }
        long j10 = cVarI.f11921a;
        nq.b bVarB = nq.c.b();
        return tn.u.v(j10 - (bVarB != null ? bVarB.b() : System.nanoTime()), 0L);
    }
}
