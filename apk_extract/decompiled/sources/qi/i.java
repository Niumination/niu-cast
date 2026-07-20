package qi;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.coroutines.CoroutineContext;
import li.n0;
import li.q0;
import li.x0;

/* JADX INFO: loaded from: classes3.dex */
public final class i extends li.a0 implements q0 {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f9146i = AtomicIntegerFieldUpdater.newUpdater(i.class, "runningWorkers$volatile");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ q0 f9147a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final li.a0 f9148b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f9149c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f9150d;
    public final n e;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Object f9151h;
    private volatile /* synthetic */ int runningWorkers$volatile;

    /* JADX WARN: Multi-variable type inference failed */
    public i(li.a0 a0Var, int i8, String str) {
        q0 q0Var = a0Var instanceof q0 ? (q0) a0Var : null;
        this.f9147a = q0Var == null ? n0.f7481a : q0Var;
        this.f9148b = a0Var;
        this.f9149c = i8;
        this.f9150d = str;
        this.e = new n();
        this.f9151h = new Object();
    }

    @Override // li.q0
    public final void c(long j8, li.l lVar) {
        this.f9147a.c(j8, lVar);
    }

    @Override // li.a0
    public final void dispatch(CoroutineContext coroutineContext, Runnable runnable) {
        Runnable runnableI;
        this.e.a(runnable);
        if (f9146i.get(this) >= this.f9149c || !k() || (runnableI = i()) == null) {
            return;
        }
        this.f9148b.dispatch(this, new i2.e(this, 12, runnableI, false));
    }

    @Override // li.a0
    public final void dispatchYield(CoroutineContext coroutineContext, Runnable runnable) {
        Runnable runnableI;
        this.e.a(runnable);
        if (f9146i.get(this) >= this.f9149c || !k() || (runnableI = i()) == null) {
            return;
        }
        this.f9148b.dispatchYield(this, new i2.e(this, 12, runnableI, false));
    }

    @Override // li.q0
    public final x0 g(long j8, Runnable runnable, CoroutineContext coroutineContext) {
        return this.f9147a.g(j8, runnable, coroutineContext);
    }

    public final Runnable i() {
        while (true) {
            Runnable runnable = (Runnable) this.e.c();
            if (runnable != null) {
                return runnable;
            }
            synchronized (this.f9151h) {
                AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f9146i;
                atomicIntegerFieldUpdater.decrementAndGet(this);
                if (this.e.b() == 0) {
                    return null;
                }
                atomicIntegerFieldUpdater.incrementAndGet(this);
            }
        }
    }

    public final boolean k() {
        synchronized (this.f9151h) {
            AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f9146i;
            if (atomicIntegerFieldUpdater.get(this) >= this.f9149c) {
                return false;
            }
            atomicIntegerFieldUpdater.incrementAndGet(this);
            return true;
        }
    }

    @Override // li.a0
    public final li.a0 limitedParallelism(int i8, String str) {
        g.c(i8);
        if (i8 >= this.f9149c) {
            return str != null ? new s(this, str) : this;
        }
        return super.limitedParallelism(i8, str);
    }

    @Override // li.a0
    public final String toString() {
        String str = this.f9150d;
        if (str != null) {
            return str;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(this.f9148b);
        sb2.append(".limitedParallelism(");
        return a1.a.r(sb2, this.f9149c, ')');
    }
}
