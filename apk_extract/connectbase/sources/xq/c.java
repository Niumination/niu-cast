package xq;

import java.util.concurrent.Executor;
import nq.a2;
import nq.g2;
import nq.l1;
import nq.n0;
import nq.x1;
import vq.y0;
import vq.z0;

/* JADX INFO: loaded from: classes3.dex */
public final class c extends x1 implements Executor {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.l
    public static final c f20496b = new c();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @os.l
    public static final n0 f20497c;

    static {
        p pVar = p.f20530a;
        int iA = y0.a();
        f20497c = pVar.limitedParallelism(z0.e(l1.f11881a, 64 < iA ? iA : 64, 0, 0, 12, null));
    }

    @Override // nq.x1, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        throw new IllegalStateException("Cannot be invoked on Dispatchers.IO");
    }

    @Override // nq.n0
    public void dispatch(@os.l um.g gVar, @os.l Runnable runnable) {
        f20497c.dispatch(gVar, runnable);
    }

    @Override // nq.n0
    @g2
    public void dispatchYield(@os.l um.g gVar, @os.l Runnable runnable) {
        f20497c.dispatchYield(gVar, runnable);
    }

    @Override // java.util.concurrent.Executor
    public void execute(@os.l Runnable runnable) {
        dispatch(um.i.INSTANCE, runnable);
    }

    @Override // nq.x1
    @os.l
    public Executor f0() {
        return this;
    }

    @Override // nq.n0
    @a2
    @os.l
    public n0 limitedParallelism(int i10) {
        return p.f20530a.limitedParallelism(i10);
    }

    @Override // nq.n0
    @os.l
    public String toString() {
        return "Dispatchers.IO";
    }
}
