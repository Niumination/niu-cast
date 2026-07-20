package androidx.lifecycle;

import in.f;
import kn.l0;
import nq.k1;
import nq.n0;
import os.l;
import um.g;

/* JADX INFO: loaded from: classes.dex */
public final class PausingDispatcher extends n0 {

    @f
    @l
    public final DispatchQueue dispatchQueue = new DispatchQueue();

    @Override // nq.n0
    public void dispatch(@l g gVar, @l Runnable runnable) {
        l0.p(gVar, "context");
        l0.p(runnable, "block");
        this.dispatchQueue.dispatchAndEnqueue(gVar, runnable);
    }

    @Override // nq.n0
    public boolean isDispatchNeeded(@l g gVar) {
        l0.p(gVar, "context");
        if (k1.e().f0().isDispatchNeeded(gVar)) {
            return true;
        }
        return !this.dispatchQueue.canRun();
    }
}
