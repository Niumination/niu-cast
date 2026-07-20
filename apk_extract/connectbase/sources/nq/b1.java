package nq;

/* JADX INFO: loaded from: classes3.dex */
public class b1<T> extends a<T> implements a1<T> {
    public b1(@os.l um.g gVar, boolean z10) {
        super(gVar, true, z10);
    }

    public static <T> Object V1(b1<T> b1Var, um.d<? super T> dVar) throws Throwable {
        Object objY = b1Var.Y(dVar);
        wm.a aVar = wm.a.COROUTINE_SUSPENDED;
        return objY;
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
        kn.l0.n(gVar, "null cannot be cast to non-null type kotlinx.coroutines.selects.SelectClause1<T of kotlinx.coroutines.DeferredCoroutine>");
        return gVar;
    }

    @Override // nq.a1
    public T p() {
        return (T) B0();
    }
}
