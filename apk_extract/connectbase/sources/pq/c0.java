package pq;

import lm.l2;
import nq.p0;

/* JADX INFO: loaded from: classes3.dex */
public final class c0<E> extends m<E> implements d0<E> {
    public c0(@os.l um.g gVar, @os.l l<E> lVar) {
        super(gVar, lVar, true, true);
    }

    @Override // nq.a
    public void Q1(@os.l Throwable th2, boolean z10) {
        if (this.f13307d.f(th2) || z10) {
            return;
        }
        p0.b(this.f11822c, th2);
    }

    @Override // nq.a
    /* JADX INFO: renamed from: W1, reason: merged with bridge method [inline-methods] */
    public void T1(@os.l l2 l2Var) {
        g0.a.a(this.f13307d, null, 1, null);
    }

    @Override // pq.d0
    public g0 a() {
        return this;
    }

    @Override // nq.a, nq.t2, nq.l2
    public boolean isActive() {
        return super.isActive();
    }
}
