package nq;

/* JADX INFO: loaded from: classes3.dex */
@kn.r1({"SMAP\nCoroutineContext.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CoroutineContext.kt\nkotlinx/coroutines/UndispatchedCoroutine\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 CoroutineContext.kt\nkotlinx/coroutines/CoroutineContextKt\n*L\n1#1,314:1\n1#2:315\n107#3,13:316\n*S KotlinDebug\n*F\n+ 1 CoroutineContext.kt\nkotlinx/coroutines/UndispatchedCoroutine\n*L\n269#1:316,13\n*E\n"})
public final class z3<T> extends vq.q0<T> {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @os.l
    public final ThreadLocal<lm.t0<um.g, Object>> f12000e;
    private volatile boolean threadLocalIsSet;

    /* JADX WARN: Illegal instructions before constructor call */
    public z3(@os.l um.g gVar, @os.l um.d<? super T> dVar) {
        a4 a4Var = a4.f11824a;
        super(gVar.get(a4Var) == null ? gVar.plus(a4Var) : gVar, dVar);
        this.f12000e = new ThreadLocal<>();
        if (dVar.getContext().get(um.e.G) instanceof n0) {
            return;
        }
        Object objC = vq.a1.c(gVar, null);
        vq.a1.a(gVar, objC);
        W1(gVar, objC);
    }

    @Override // vq.q0, nq.a
    public void O1(@os.m Object obj) {
        if (this.threadLocalIsSet) {
            lm.t0<um.g, Object> t0Var = this.f12000e.get();
            if (t0Var != null) {
                vq.a1.a(t0Var.component1(), t0Var.component2());
            }
            this.f12000e.remove();
        }
        Object objA = j0.a(obj, this.f17874d);
        um.d<T> dVar = this.f17874d;
        um.g context = dVar.getContext();
        Object objC = vq.a1.c(context, null);
        z3<?> z3VarG = objC != vq.a1.f17796a ? m0.g(dVar, context, objC) : null;
        try {
            this.f17874d.resumeWith(objA);
            lm.l2 l2Var = lm.l2.f10208a;
        } finally {
            if (z3VarG == null || z3VarG.V1()) {
                vq.a1.a(context, objC);
            }
        }
    }

    public final boolean V1() {
        boolean z10 = this.threadLocalIsSet && this.f12000e.get() == null;
        this.f12000e.remove();
        return !z10;
    }

    public final void W1(@os.l um.g gVar, @os.m Object obj) {
        this.threadLocalIsSet = true;
        this.f12000e.set(new lm.t0<>(gVar, obj));
    }
}
