package fl;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;
import lm.l2;

/* JADX INFO: loaded from: classes2.dex */
@t0
public final class j0 extends nq.n0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.m
    public nq.n0 f6057a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.l
    public final lm.d0<ExecutorService> f6058b;

    @os.l
    private volatile a shutdownPhase;

    public enum a {
        None,
        Graceful,
        Completed
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f6060a;

        static {
            int[] iArr = new int[a.values().length];
            iArr[a.None.ordinal()] = 1;
            iArr[a.Graceful.ordinal()] = 2;
            iArr[a.Completed.ordinal()] = 3;
            f6060a = iArr;
        }
    }

    public static final class c extends kn.n0 implements jn.a<ExecutorService> {
        public static final c INSTANCE = new c();

        public c() {
            super(0);
        }

        @Override // jn.a
        public final ExecutorService invoke() {
            return Executors.newCachedThreadPool();
        }
    }

    public j0(@os.l nq.n0 n0Var) {
        kn.l0.p(n0Var, "delegate");
        this.f6057a = n0Var;
        this.shutdownPhase = a.None;
        this.f6058b = lm.f0.b(c.INSTANCE);
    }

    @Override // nq.n0
    public void dispatch(@os.l um.g gVar, @os.l Runnable runnable) {
        l2 l2Var;
        kn.l0.p(gVar, "context");
        kn.l0.p(runnable, "block");
        int i10 = b.f6060a[this.shutdownPhase.ordinal()];
        if (i10 != 1) {
            if (i10 != 2) {
                if (i10 != 3) {
                    return;
                }
                runnable.run();
                return;
            } else {
                try {
                    this.f6058b.getValue().submit(runnable);
                    return;
                } catch (RejectedExecutionException unused) {
                    this.shutdownPhase = a.Completed;
                    dispatch(gVar, runnable);
                    return;
                }
            }
        }
        try {
            nq.n0 n0Var = this.f6057a;
            if (n0Var == null) {
                l2Var = null;
            } else {
                n0Var.dispatch(gVar, runnable);
                l2Var = l2.f10208a;
            }
            if (l2Var == null) {
                dispatch(gVar, runnable);
            }
        } catch (RejectedExecutionException e10) {
            if (this.shutdownPhase == a.None) {
                throw e10;
            }
            dispatch(gVar, runnable);
        }
    }

    public final void f0() {
        this.shutdownPhase = a.Completed;
        if (this.f6058b.isInitialized()) {
            this.f6058b.getValue().shutdown();
        }
    }

    @Override // nq.n0
    public boolean isDispatchNeeded(@os.l um.g gVar) {
        nq.n0 n0Var;
        kn.l0.p(gVar, "context");
        if (b.f6060a[this.shutdownPhase.ordinal()] != 1 || (n0Var = this.f6057a) == null) {
            return true;
        }
        return n0Var.isDispatchNeeded(gVar);
    }

    public final void j0() {
        this.shutdownPhase = a.Graceful;
        this.f6057a = null;
    }
}
