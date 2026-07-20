package lm;

/* JADX INFO: loaded from: classes3.dex */
public final class j<T, R> extends i<T, R> implements um.d<R> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public jn.q<? super i<?, ?>, Object, ? super um.d<Object>, ? extends Object> f10200a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.m
    public Object f10201b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @os.m
    public um.d<Object> f10202c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @os.l
    public Object f10203d;

    @kn.r1({"SMAP\nContinuation.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Continuation.kt\nkotlin/coroutines/ContinuationKt$Continuation$1\n+ 2 DeepRecursive.kt\nkotlin/DeepRecursiveScopeImpl\n*L\n1#1,161:1\n182#2,6:162\n*E\n"})
    public static final class a implements um.d<Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ um.g f10204a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ j f10205b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ jn.q f10206c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ um.d f10207d;

        public a(um.g gVar, j jVar, jn.q qVar, um.d dVar) {
            this.f10204a = gVar;
            this.f10205b = jVar;
            this.f10206c = qVar;
            this.f10207d = dVar;
        }

        @Override // um.d
        @os.l
        public um.g getContext() {
            return this.f10204a;
        }

        @Override // um.d
        public void resumeWith(@os.l Object obj) {
            j jVar = this.f10205b;
            jVar.f10200a = this.f10206c;
            jVar.f10202c = this.f10207d;
            jVar.f10203d = obj;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public j(@os.l jn.q<? super i<T, R>, ? super T, ? super um.d<? super R>, ? extends Object> qVar, T t10) {
        kn.l0.p(qVar, "block");
        this.f10200a = qVar;
        this.f10201b = t10;
        kn.l0.n(this, "null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>");
        this.f10202c = this;
        this.f10203d = h.f10194a;
    }

    @Override // lm.i
    @os.m
    public Object a(T t10, @os.l um.d<? super R> dVar) {
        kn.l0.n(dVar, "null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>");
        this.f10202c = dVar;
        this.f10201b = t10;
        wm.a aVar = wm.a.COROUTINE_SUSPENDED;
        xm.h.c(dVar);
        return aVar;
    }

    @Override // lm.i
    @os.m
    public <U, S> Object b(@os.l g<U, S> gVar, U u10, @os.l um.d<? super S> dVar) {
        jn.q<i<U, S>, U, um.d<? super S>, Object> qVar = gVar.f10187a;
        kn.l0.n(qVar, "null cannot be cast to non-null type @[ExtensionFunctionType] kotlin.coroutines.SuspendFunction2<kotlin.DeepRecursiveScope<*, *>, kotlin.Any?, kotlin.Any?>{ kotlin.DeepRecursiveKt.DeepRecursiveFunctionBlock }");
        jn.q<? super i<?, ?>, Object, ? super um.d<Object>, ? extends Object> qVar2 = this.f10200a;
        if (qVar != qVar2) {
            this.f10200a = qVar;
            kn.l0.n(dVar, "null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>");
            this.f10202c = k(qVar2, dVar);
        } else {
            kn.l0.n(dVar, "null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>");
            this.f10202c = dVar;
        }
        this.f10201b = u10;
        wm.a aVar = wm.a.COROUTINE_SUSPENDED;
        xm.h.c(dVar);
        return aVar;
    }

    @Override // um.d
    @os.l
    public um.g getContext() {
        return um.i.INSTANCE;
    }

    public final um.d<Object> k(jn.q<? super i<?, ?>, Object, ? super um.d<Object>, ? extends Object> qVar, um.d<Object> dVar) {
        return new a(um.i.INSTANCE, this, qVar, dVar);
    }

    public final R m() {
        while (true) {
            R r10 = (R) this.f10203d;
            um.d<Object> dVar = this.f10202c;
            if (dVar == null) {
                d1.n(r10);
                return r10;
            }
            if (c1.m61equalsimpl0(h.f10194a, r10)) {
                try {
                    jn.q<? super i<?, ?>, Object, ? super um.d<Object>, ? extends Object> qVar = this.f10200a;
                    Object obj = this.f10201b;
                    Object objK = !(qVar instanceof xm.a) ? wm.c.k(qVar, this, obj, dVar) : ((jn.q) kn.u1.q(qVar, 3)).invoke(this, obj, dVar);
                    if (objK != wm.a.COROUTINE_SUSPENDED) {
                        c1.a aVar = c1.Companion;
                        dVar.resumeWith(c1.m59constructorimpl(objK));
                    }
                } catch (Throwable th2) {
                    c1.a aVar2 = c1.Companion;
                    w.a.a(th2, dVar);
                }
            } else {
                this.f10203d = h.f10194a;
                dVar.resumeWith(r10);
            }
        }
    }

    @Override // um.d
    public void resumeWith(@os.l Object obj) {
        this.f10202c = null;
        this.f10203d = obj;
    }
}
