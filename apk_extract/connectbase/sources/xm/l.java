package xm;

import kn.l0;
import lm.c1;
import lm.d1;
import lm.l2;

/* JADX INFO: loaded from: classes3.dex */
public final class l implements um.d<l2> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.m
    public c1<l2> f20300a;

    public final void a() {
        synchronized (this) {
            while (true) {
                try {
                    c1<l2> c1Var = this.f20300a;
                    if (c1Var == null) {
                        l0.n(this, "null cannot be cast to non-null type java.lang.Object");
                        wait();
                    } else {
                        d1.n(c1Var.m67unboximpl());
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
    }

    @os.m
    public final c1<l2> b() {
        return this.f20300a;
    }

    public final void d(@os.m c1<l2> c1Var) {
        this.f20300a = c1Var;
    }

    @Override // um.d
    @os.l
    public um.g getContext() {
        return um.i.INSTANCE;
    }

    @Override // um.d
    public void resumeWith(@os.l Object obj) {
        synchronized (this) {
            this.f20300a = c1.m58boximpl(obj);
            l0.n(this, "null cannot be cast to non-null type java.lang.Object");
            notifyAll();
            l2 l2Var = l2.f10208a;
        }
    }
}
