package yl;

import kn.l0;
import nq.n0;
import os.l;

/* JADX INFO: loaded from: classes2.dex */
public final class j extends n0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @l
    public static final j f21461a = new j();

    @Override // nq.n0
    public void dispatch(@l um.g gVar, @l Runnable runnable) {
        l0.p(gVar, "context");
        l0.p(runnable, "block");
        runnable.run();
    }

    @Override // nq.n0
    public boolean isDispatchNeeded(@l um.g gVar) {
        l0.p(gVar, "context");
        return true;
    }
}
