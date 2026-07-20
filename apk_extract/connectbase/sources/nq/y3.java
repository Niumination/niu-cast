package nq;

/* JADX INFO: loaded from: classes3.dex */
public final class y3 extends n0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public static final y3 f11995a = new y3();

    @Override // nq.n0
    public void dispatch(@os.l um.g gVar, @os.l Runnable runnable) {
        c4 c4Var = (c4) gVar.get(c4.f11832b);
        if (c4Var == null) {
            throw new UnsupportedOperationException("Dispatchers.Unconfined.dispatch function can only be used by the yield function. If you wrap Unconfined dispatcher in your code, make sure you properly delegate isDispatchNeeded and dispatch calls.");
        }
        c4Var.f11833a = true;
    }

    @Override // nq.n0
    public boolean isDispatchNeeded(@os.l um.g gVar) {
        return false;
    }

    @Override // nq.n0
    @a2
    @os.l
    public n0 limitedParallelism(int i10) {
        throw new UnsupportedOperationException("limitedParallelism is not supported for Dispatchers.Unconfined");
    }

    @Override // nq.n0
    @os.l
    public String toString() {
        return "Dispatchers.Unconfined";
    }
}
