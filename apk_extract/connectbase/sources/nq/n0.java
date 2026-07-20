package nq;

/* JADX INFO: loaded from: classes3.dex */
public abstract class n0 extends um.a implements um.e {

    @os.l
    public static final a Key = new a();

    @lm.r
    public static final class a extends um.b<um.e, n0> {

        /* JADX INFO: renamed from: nq.n0$a$a, reason: collision with other inner class name */
        public static final class C0303a extends kn.n0 implements jn.l<um.g.b, n0> {
            public static final C0303a INSTANCE = new C0303a();

            public C0303a() {
                super(1);
            }

            @Override // jn.l
            @os.m
            public final n0 invoke(@os.l um.g.b bVar) {
                if (bVar instanceof n0) {
                    return (n0) bVar;
                }
                return null;
            }
        }

        public /* synthetic */ a(kn.w wVar) {
            this();
        }

        public a() {
            super(um.e.G, C0303a.INSTANCE);
        }
    }

    public n0() {
        super(um.e.G);
    }

    public abstract void dispatch(@os.l um.g gVar, @os.l Runnable runnable);

    @g2
    public void dispatchYield(@os.l um.g gVar, @os.l Runnable runnable) {
        dispatch(gVar, runnable);
    }

    @Override // um.a, um.g.b, um.g
    @os.m
    public <E extends um.g.b> E get(@os.l um.g.c<E> cVar) {
        return (E) um.e.a.b(this, cVar);
    }

    @Override // um.e
    @os.l
    public final <T> um.d<T> interceptContinuation(@os.l um.d<? super T> dVar) {
        return new vq.m(this, dVar);
    }

    public boolean isDispatchNeeded(@os.l um.g gVar) {
        return true;
    }

    @a2
    @os.l
    public n0 limitedParallelism(int i10) {
        vq.v.a(i10);
        return new vq.u(this, i10);
    }

    @Override // um.a, um.g.b, um.g
    @os.l
    public um.g minusKey(@os.l um.g.c<?> cVar) {
        return um.e.a.c(this, cVar);
    }

    @lm.k(level = lm.m.ERROR, message = "Operator '+' on two CoroutineDispatcher objects is meaningless. CoroutineDispatcher is a coroutine context element and `+` is a set-sum operator for coroutine contexts. The dispatcher to the right of `+` just replaces the dispatcher to the left.")
    @os.l
    public final n0 plus(@os.l n0 n0Var) {
        return n0Var;
    }

    @Override // um.e
    public final void releaseInterceptedContinuation(@os.l um.d<?> dVar) {
        kn.l0.n(dVar, "null cannot be cast to non-null type kotlinx.coroutines.internal.DispatchedContinuation<*>");
        ((vq.m) dVar).v();
    }

    @os.l
    public String toString() {
        return x0.a(this) + '@' + x0.b(this);
    }
}
