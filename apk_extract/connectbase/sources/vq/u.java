package vq;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kn.r1;
import lm.l2;
import nq.a2;
import nq.g2;
import nq.n1;

/* JADX INFO: loaded from: classes3.dex */
@r1({"SMAP\nLimitedDispatcher.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LimitedDispatcher.kt\nkotlinx/coroutines/internal/LimitedDispatcher\n+ 2 Synchronized.common.kt\nkotlinx/coroutines/internal/Synchronized_commonKt\n+ 3 Synchronized.kt\nkotlinx/coroutines/internal/SynchronizedKt\n*L\n1#1,134:1\n66#1,8:135\n66#1,8:143\n28#2,4:151\n28#2,4:156\n20#3:155\n20#3:160\n*S KotlinDebug\n*F\n+ 1 LimitedDispatcher.kt\nkotlinx/coroutines/internal/LimitedDispatcher\n*L\n48#1:135,8\n55#1:143,8\n79#1:151,4\n92#1:156,4\n79#1:155\n92#1:160\n*E\n"})
public final class u extends nq.n0 implements nq.c1 {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @os.l
    public static final AtomicIntegerFieldUpdater f17885f = AtomicIntegerFieldUpdater.newUpdater(u.class, "runningWorkers");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public final nq.n0 f17886a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f17887b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ nq.c1 f17888c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @os.l
    public final b0<Runnable> f17889d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @os.l
    public final Object f17890e;

    @in.x
    private volatile int runningWorkers;

    public final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @os.l
        public Runnable f17891a;

        public a(Runnable runnable) {
            this.f17891a = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            int i10 = 0;
            while (true) {
                try {
                    this.f17891a.run();
                } catch (Throwable th2) {
                    nq.p0.b(um.i.INSTANCE, th2);
                }
                Runnable runnableV0 = u.this.v0();
                if (runnableV0 == null) {
                    return;
                }
                this.f17891a = runnableV0;
                i10++;
                if (i10 >= 16) {
                    u uVar = u.this;
                    if (uVar.f17886a.isDispatchNeeded(uVar)) {
                        u uVar2 = u.this;
                        uVar2.f17886a.dispatch(uVar2, this);
                        return;
                    }
                }
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public u(@os.l nq.n0 n0Var, int i10) {
        this.f17886a = n0Var;
        this.f17887b = i10;
        nq.c1 c1Var = n0Var instanceof nq.c1 ? (nq.c1) n0Var : null;
        this.f17888c = c1Var == null ? nq.z0.a() : c1Var;
        this.f17889d = new b0<>(false);
        this.f17890e = new Object();
    }

    @Override // nq.c1
    @os.l
    public n1 E(long j10, @os.l Runnable runnable, @os.l um.g gVar) {
        return this.f17888c.E(j10, runnable, gVar);
    }

    @Override // nq.c1
    public void b0(long j10, @os.l nq.p<? super l2> pVar) {
        this.f17888c.b0(j10, pVar);
    }

    @Override // nq.n0
    public void dispatch(@os.l um.g gVar, @os.l Runnable runnable) {
        Runnable runnableV0;
        this.f17889d.a(runnable);
        if (f17885f.get(this) >= this.f17887b || !w0() || (runnableV0 = v0()) == null) {
            return;
        }
        this.f17886a.dispatch(this, new a(runnableV0));
    }

    @Override // nq.n0
    @g2
    public void dispatchYield(@os.l um.g gVar, @os.l Runnable runnable) {
        Runnable runnableV0;
        this.f17889d.a(runnable);
        if (f17885f.get(this) >= this.f17887b || !w0() || (runnableV0 = v0()) == null) {
            return;
        }
        this.f17886a.dispatchYield(this, new a(runnableV0));
    }

    @Override // nq.n0
    @a2
    @os.l
    public nq.n0 limitedParallelism(int i10) {
        v.a(i10);
        return i10 >= this.f17887b ? this : super.limitedParallelism(i10);
    }

    @Override // nq.c1
    @os.m
    @lm.k(level = lm.m.ERROR, message = "Deprecated without replacement as an internal method never intended for public use")
    public Object n(long j10, @os.l um.d<? super l2> dVar) {
        return this.f17888c.n(j10, dVar);
    }

    public final void p0(Runnable runnable, jn.l<? super a, l2> lVar) {
        Runnable runnableV0;
        this.f17889d.a(runnable);
        if (f17885f.get(this) < this.f17887b && w0() && (runnableV0 = v0()) != null) {
            lVar.invoke(new a(runnableV0));
        }
    }

    public final Runnable v0() {
        while (true) {
            Runnable runnableH = this.f17889d.h();
            if (runnableH != null) {
                return runnableH;
            }
            synchronized (this.f17890e) {
                AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f17885f;
                atomicIntegerFieldUpdater.decrementAndGet(this);
                if (this.f17889d.c() == 0) {
                    return null;
                }
                atomicIntegerFieldUpdater.incrementAndGet(this);
            }
        }
    }

    public final boolean w0() {
        synchronized (this.f17890e) {
            AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f17885f;
            if (atomicIntegerFieldUpdater.get(this) >= this.f17887b) {
                return false;
            }
            atomicIntegerFieldUpdater.incrementAndGet(this);
            return true;
        }
    }
}
