package pq;

import lm.l2;

/* JADX INFO: loaded from: classes3.dex */
public final class a0<E> extends g<E> {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @os.l
    public final um.d<l2> f13236e;

    public a0(@os.l um.g gVar, @os.l d<E> dVar, @os.l jn.p<? super d0<? super E>, ? super um.d<? super l2>, ? extends Object> pVar) {
        super(gVar, dVar, false);
        this.f13236e = wm.c.c(pVar, this, this);
    }

    @Override // nq.t2
    public void u1() throws Throwable {
        wq.a.e(this.f13236e, this);
    }

    @Override // pq.g, pq.d
    @os.l
    public f0<E> v() {
        f0<E> f0VarV = this.f13244d.v();
        start();
        return f0VarV;
    }
}
