package nq;

import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes3.dex */
public final class j1 implements Executor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @in.f
    @os.l
    public final n0 f11869a;

    public j1(@os.l n0 n0Var) {
        this.f11869a = n0Var;
    }

    @Override // java.util.concurrent.Executor
    public void execute(@os.l Runnable runnable) {
        n0 n0Var = this.f11869a;
        um.i iVar = um.i.INSTANCE;
        if (n0Var.isDispatchNeeded(iVar)) {
            this.f11869a.dispatch(iVar, runnable);
        } else {
            runnable.run();
        }
    }

    @os.l
    public String toString() {
        return this.f11869a.toString();
    }
}
