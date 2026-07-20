package wl;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kn.l0;
import lm.l2;
import nq.b0;
import nq.r2;

/* JADX INFO: loaded from: classes2.dex */
public final class e {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f19695c = AtomicReferenceFieldUpdater.newUpdater(e.class, Object.class, "_closeWaitJob");

    @os.l
    private volatile /* synthetic */ Object _closeWaitJob;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public final pl.a f19696a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f19697b;

    @os.l
    private volatile /* synthetic */ int closed;

    public e(@os.l pl.a aVar, boolean z10) {
        l0.p(aVar, "delegatedTo");
        this.f19696a = aVar;
        this.f19697b = z10;
        this._closeWaitJob = null;
        this.closed = 0;
    }

    @os.m
    public final Object a(@os.l um.d<? super l2> dVar) {
        Object objT;
        return (this.closed != 1 && (objT = c().t(dVar)) == wm.a.COROUTINE_SUSPENDED) ? objT : l2.f10208a;
    }

    public final void b() {
        this.closed = 1;
        nq.l2 l2Var = (nq.l2) f19695c.getAndSet(this, null);
        if (l2Var == null) {
            return;
        }
        nq.l2.a.b(l2Var, null, 1, null);
    }

    public final nq.l2 c() {
        b0 b0VarC;
        do {
            nq.l2 l2Var = (nq.l2) this._closeWaitJob;
            if (l2Var != null) {
                return l2Var;
            }
            b0VarC = r2.c(null, 1, null);
        } while (!j.d.a(f19695c, this, null, b0VarC));
        if (this.closed == 1) {
            nq.l2.a.b(b0VarC, null, 1, null);
        }
        return b0VarC;
    }

    public final boolean d() {
        return this.f19697b;
    }

    @os.l
    public final pl.a e() {
        return this.f19696a;
    }
}
