package nq;

/* JADX INFO: loaded from: classes3.dex */
public final class z<T> extends t2 implements y<T> {
    public z(@os.m l2 l2Var) {
        super(true);
        Y0(l2Var);
    }

    @Override // nq.t2
    public boolean L0() {
        return true;
    }

    @Override // nq.a1
    @os.m
    public Object O0(@os.l um.d<? super T> dVar) throws Throwable {
        Object objY = Y(dVar);
        wm.a aVar = wm.a.COROUTINE_SUSPENDED;
        return objY;
    }

    @Override // nq.a1
    @os.l
    public yq.g<T> S0() {
        yq.g<T> gVar = (yq.g<T>) I0();
        kn.l0.n(gVar, "null cannot be cast to non-null type kotlinx.coroutines.selects.SelectClause1<T of kotlinx.coroutines.CompletableDeferredImpl>");
        return gVar;
    }

    @Override // nq.y
    public boolean k(@os.l Throwable th2) {
        return i1(new d0(th2, false, 2, null));
    }

    @Override // nq.y
    public boolean l0(T t10) {
        return i1(t10);
    }

    @Override // nq.a1
    public T p() {
        return (T) B0();
    }
}
