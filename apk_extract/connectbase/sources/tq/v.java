package tq;

import kn.l0;
import kn.n0;
import kn.r1;
import lm.c1;
import lm.l2;
import nq.r2;

/* JADX INFO: loaded from: classes3.dex */
@r1({"SMAP\nSafeCollector.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SafeCollector.kt\nkotlinx/coroutines/flow/internal/SafeCollector\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,156:1\n1#2:157\n*E\n"})
public final class v<T> extends xm.d implements sq.j<T>, xm.e {

    @in.f
    @os.l
    public final um.g collectContext;

    @in.f
    public final int collectContextSize;

    @in.f
    @os.l
    public final sq.j<T> collector;

    @os.m
    private um.d<? super l2> completion;

    @os.m
    private um.g lastEmissionContext;

    public static final class a extends n0 implements jn.p<Integer, um.g.b, Integer> {
        public static final a INSTANCE = new a();

        public a() {
            super(2);
        }

        @os.l
        public final Integer invoke(int i10, @os.l um.g.b bVar) {
            return Integer.valueOf(i10 + 1);
        }

        @Override // jn.p
        public /* bridge */ /* synthetic */ Integer invoke(Integer num, um.g.b bVar) {
            return invoke(num.intValue(), bVar);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public v(@os.l sq.j<? super T> jVar, @os.l um.g gVar) {
        super(s.f16059a, um.i.INSTANCE);
        this.collector = jVar;
        this.collectContext = gVar;
        this.collectContextSize = ((Number) gVar.fold(0, a.INSTANCE)).intValue();
    }

    public final void a(um.g gVar, um.g gVar2, T t10) {
        if (gVar2 instanceof n) {
            i((n) gVar2, t10);
        }
        x.a(this, gVar);
    }

    @Override // sq.j
    @os.m
    public Object emit(T t10, @os.l um.d<? super l2> dVar) {
        try {
            Object objH = h(dVar, t10);
            wm.a aVar = wm.a.COROUTINE_SUSPENDED;
            if (objH == aVar) {
                xm.h.c(dVar);
            }
            return objH == aVar ? objH : l2.f10208a;
        } catch (Throwable th2) {
            this.lastEmissionContext = new n(th2, dVar.getContext());
            throw th2;
        }
    }

    @Override // xm.a, xm.e
    @os.m
    public xm.e getCallerFrame() {
        um.d<? super l2> dVar = this.completion;
        if (dVar instanceof xm.e) {
            return (xm.e) dVar;
        }
        return null;
    }

    @Override // xm.d, um.d
    @os.l
    public um.g getContext() {
        um.g gVar = this.lastEmissionContext;
        return gVar == null ? um.i.INSTANCE : gVar;
    }

    @Override // xm.a, xm.e
    @os.m
    public StackTraceElement getStackTraceElement() {
        return null;
    }

    public final Object h(um.d<? super l2> dVar, T t10) {
        um.g context = dVar.getContext();
        r2.y(context);
        um.g gVar = this.lastEmissionContext;
        if (gVar != context) {
            a(context, gVar, t10);
            this.lastEmissionContext = context;
        }
        this.completion = dVar;
        jn.q qVar = w.f16065a;
        sq.j<T> jVar = this.collector;
        l0.n(jVar, "null cannot be cast to non-null type kotlinx.coroutines.flow.FlowCollector<kotlin.Any?>");
        l0.n(this, "null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Unit>");
        Object objInvoke = qVar.invoke(jVar, t10, this);
        if (!l0.g(objInvoke, wm.a.COROUTINE_SUSPENDED)) {
            this.completion = null;
        }
        return objInvoke;
    }

    public final void i(n nVar, Object obj) {
        throw new IllegalStateException(jq.x.p("\n            Flow exception transparency is violated:\n                Previous 'emit' call has thrown exception " + nVar.f16056a + ", but then emission attempt of value '" + obj + "' has been detected.\n                Emissions from 'catch' blocks are prohibited in order to avoid unspecified behaviour, 'Flow.catch' operator can be used instead.\n                For a more detailed explanation, please refer to Flow documentation.\n            ").toString());
    }

    @Override // xm.a
    @os.l
    public Object invokeSuspend(@os.l Object obj) {
        Throwable thM62exceptionOrNullimpl = c1.m62exceptionOrNullimpl(obj);
        if (thM62exceptionOrNullimpl != null) {
            this.lastEmissionContext = new n(thM62exceptionOrNullimpl, getContext());
        }
        um.d<? super l2> dVar = this.completion;
        if (dVar != null) {
            dVar.resumeWith(obj);
        }
        return wm.a.COROUTINE_SUSPENDED;
    }

    @Override // xm.d, xm.a
    public void releaseIntercepted() {
        super.releaseIntercepted();
    }
}
