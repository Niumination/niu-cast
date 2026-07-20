package nq;

/* JADX INFO: loaded from: classes3.dex */
@kn.r1({"SMAP\nCompletableDeferred.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CompletableDeferred.kt\nkotlinx/coroutines/CompletableDeferredKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,94:1\n1#2:95\n*E\n"})
public final class a0 {
    @os.l
    public static final <T> y<T> a(T t10) {
        z zVar = new z(null);
        zVar.i1(t10);
        return zVar;
    }

    @os.l
    public static final <T> y<T> b(@os.m l2 l2Var) {
        return new z(l2Var);
    }

    public static y c(l2 l2Var, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            l2Var = null;
        }
        return new z(l2Var);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> boolean d(@os.l y<T> yVar, @os.l Object obj) {
        Throwable thM62exceptionOrNullimpl = lm.c1.m62exceptionOrNullimpl(obj);
        return thM62exceptionOrNullimpl == null ? yVar.l0(obj) : yVar.k(thM62exceptionOrNullimpl);
    }
}
