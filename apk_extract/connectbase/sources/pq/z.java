package pq;

import kn.l0;
import kn.u1;
import lm.a1;
import lm.l2;

/* JADX INFO: loaded from: classes3.dex */
public final class z<E> extends pq.a<E> {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @os.l
    public um.d<? super l2> f13318e;

    public /* synthetic */ class a extends kn.h0 implements jn.q<z<?>, yq.m<?>, Object, l2> {
        public static final a INSTANCE = new a();

        public a() {
            super(3, z.class, "onSendRegFunction", "onSendRegFunction(Lkotlinx/coroutines/selects/SelectInstance;Ljava/lang/Object;)V", 0);
        }

        @Override // jn.q
        public /* bridge */ /* synthetic */ l2 invoke(z<?> zVar, yq.m<?> mVar, Object obj) throws Throwable {
            invoke2(zVar, mVar, obj);
            return l2.f10208a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@os.l z<?> zVar, @os.l yq.m<?> mVar, @os.m Object obj) throws Throwable {
            zVar.Z1(mVar, obj);
        }
    }

    public z(@os.l um.g gVar, @os.l l<E> lVar, @os.l jn.p<? super c<E>, ? super um.d<? super l2>, ? extends Object> pVar) {
        super(gVar, lVar, false);
        this.f13318e = wm.c.c(pVar, this, this);
    }

    public static /* synthetic */ void X1() {
    }

    @Override // pq.m, pq.g0
    @os.m
    public Object L(E e10, @os.l um.d<? super l2> dVar) {
        start();
        Object objL = super.L(e10, dVar);
        return objL == wm.a.COROUTINE_SUSPENDED ? objL : l2.f10208a;
    }

    public final void Z1(yq.m<?> mVar, Object obj) throws Throwable {
        u1();
        this.f13307d.m().a().invoke(this, mVar, obj);
    }

    @Override // pq.m, pq.g0
    public boolean f(@os.m Throwable th2) {
        boolean zF = super.f(th2);
        start();
        return zF;
    }

    @Override // pq.m, pq.g0
    @os.l
    public yq.i<E, g0<E>> m() {
        a aVar = a.INSTANCE;
        l0.n(aVar, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = 'clauseObject')] kotlin.Any, @[ParameterName(name = 'select')] kotlinx.coroutines.selects.SelectInstance<*>, @[ParameterName(name = 'param')] kotlin.Any?, kotlin.Unit>{ kotlinx.coroutines.selects.SelectKt.RegistrationFunction }");
        return new yq.j(this, (jn.q) u1.q(aVar, 3), super.m().c(), null, 8, null);
    }

    @Override // pq.m, pq.g0
    @lm.k(level = lm.m.ERROR, message = "Deprecated in the favour of 'trySend' method", replaceWith = @a1(expression = "trySend(element).isSuccess", imports = {}))
    public boolean offer(E e10) {
        start();
        return super.offer(e10);
    }

    @Override // nq.t2
    public void u1() throws Throwable {
        wq.a.e(this.f13318e, this);
    }

    @Override // pq.m, pq.g0
    @os.l
    public Object w(E e10) {
        start();
        return super.w(e10);
    }
}
