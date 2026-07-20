package xq;

import nq.a2;
import nq.g2;
import nq.n0;
import vq.v;

/* JADX INFO: loaded from: classes3.dex */
public final class p extends n0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public static final p f20530a = new p();

    @Override // nq.n0
    public void dispatch(@os.l um.g gVar, @os.l Runnable runnable) {
        d.f20498g.p0(runnable, o.f20529j, false);
    }

    @Override // nq.n0
    @g2
    public void dispatchYield(@os.l um.g gVar, @os.l Runnable runnable) {
        d.f20498g.p0(runnable, o.f20529j, true);
    }

    @Override // nq.n0
    @a2
    @os.l
    public n0 limitedParallelism(int i10) {
        v.a(i10);
        return i10 >= o.f20523d ? this : super.limitedParallelism(i10);
    }
}
