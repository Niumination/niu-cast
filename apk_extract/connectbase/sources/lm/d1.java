package lm;

/* JADX INFO: loaded from: classes3.dex */
@kn.r1({"SMAP\nResult.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Result.kt\nkotlin/ResultKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,340:1\n1#2:341\n*E\n"})
public final class d1 {
    @f1(version = "1.3")
    @z0
    @os.l
    public static final Object a(@os.l Throwable th2) {
        kn.l0.p(th2, "exception");
        return new c1.b(th2);
    }

    @f1(version = "1.3")
    @an.f
    public static final <R, T> R b(Object obj, jn.l<? super T, ? extends R> lVar, jn.l<? super Throwable, ? extends R> lVar2) {
        kn.l0.p(lVar, "onSuccess");
        kn.l0.p(lVar2, "onFailure");
        Throwable thM62exceptionOrNullimpl = c1.m62exceptionOrNullimpl(obj);
        return thM62exceptionOrNullimpl == null ? lVar.invoke(obj) : lVar2.invoke(thM62exceptionOrNullimpl);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @f1(version = "1.3")
    @an.f
    public static final <R, T extends R> R c(Object obj, R r10) {
        return c1.m64isFailureimpl(obj) ? r10 : obj;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @f1(version = "1.3")
    @an.f
    public static final <R, T extends R> R d(Object obj, jn.l<? super Throwable, ? extends R> lVar) {
        kn.l0.p(lVar, "onFailure");
        Throwable thM62exceptionOrNullimpl = c1.m62exceptionOrNullimpl(obj);
        return thM62exceptionOrNullimpl == null ? obj : lVar.invoke(thM62exceptionOrNullimpl);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @f1(version = "1.3")
    @an.f
    public static final <T> T e(Object obj) {
        n(obj);
        return obj;
    }

    @f1(version = "1.3")
    @an.f
    public static final <R, T> Object f(Object obj, jn.l<? super T, ? extends R> lVar) {
        kn.l0.p(lVar, "transform");
        if (!c1.m65isSuccessimpl(obj)) {
            return c1.m59constructorimpl(obj);
        }
        c1.a aVar = c1.Companion;
        return c1.m59constructorimpl(lVar.invoke(obj));
    }

    @f1(version = "1.3")
    @an.f
    public static final <R, T> Object g(Object obj, jn.l<? super T, ? extends R> lVar) {
        kn.l0.p(lVar, "transform");
        if (!c1.m65isSuccessimpl(obj)) {
            return c1.m59constructorimpl(obj);
        }
        try {
            c1.a aVar = c1.Companion;
            return c1.m59constructorimpl(lVar.invoke(obj));
        } catch (Throwable th2) {
            c1.a aVar2 = c1.Companion;
            return c1.m59constructorimpl(a(th2));
        }
    }

    @f1(version = "1.3")
    @an.f
    public static final <T> Object h(Object obj, jn.l<? super Throwable, l2> lVar) {
        kn.l0.p(lVar, k4.f.f8937e);
        Throwable thM62exceptionOrNullimpl = c1.m62exceptionOrNullimpl(obj);
        if (thM62exceptionOrNullimpl != null) {
            lVar.invoke(thM62exceptionOrNullimpl);
        }
        return obj;
    }

    @f1(version = "1.3")
    @an.f
    public static final <T> Object i(Object obj, jn.l<? super T, l2> lVar) {
        kn.l0.p(lVar, k4.f.f8937e);
        if (c1.m65isSuccessimpl(obj)) {
            lVar.invoke(obj);
        }
        return obj;
    }

    @f1(version = "1.3")
    @an.f
    public static final <R, T extends R> Object j(Object obj, jn.l<? super Throwable, ? extends R> lVar) {
        kn.l0.p(lVar, "transform");
        Throwable thM62exceptionOrNullimpl = c1.m62exceptionOrNullimpl(obj);
        if (thM62exceptionOrNullimpl == null) {
            return obj;
        }
        c1.a aVar = c1.Companion;
        return c1.m59constructorimpl(lVar.invoke(thM62exceptionOrNullimpl));
    }

    @f1(version = "1.3")
    @an.f
    public static final <R, T extends R> Object k(Object obj, jn.l<? super Throwable, ? extends R> lVar) {
        kn.l0.p(lVar, "transform");
        Throwable thM62exceptionOrNullimpl = c1.m62exceptionOrNullimpl(obj);
        if (thM62exceptionOrNullimpl == null) {
            return obj;
        }
        try {
            c1.a aVar = c1.Companion;
            return c1.m59constructorimpl(lVar.invoke(thM62exceptionOrNullimpl));
        } catch (Throwable th2) {
            c1.a aVar2 = c1.Companion;
            return c1.m59constructorimpl(a(th2));
        }
    }

    @f1(version = "1.3")
    @an.f
    public static final <T, R> Object l(T t10, jn.l<? super T, ? extends R> lVar) {
        kn.l0.p(lVar, "block");
        try {
            c1.a aVar = c1.Companion;
            return c1.m59constructorimpl(lVar.invoke(t10));
        } catch (Throwable th2) {
            c1.a aVar2 = c1.Companion;
            return c1.m59constructorimpl(a(th2));
        }
    }

    @f1(version = "1.3")
    @an.f
    public static final <R> Object m(jn.a<? extends R> aVar) {
        kn.l0.p(aVar, "block");
        try {
            c1.a aVar2 = c1.Companion;
            return c1.m59constructorimpl(aVar.invoke());
        } catch (Throwable th2) {
            c1.a aVar3 = c1.Companion;
            return c1.m59constructorimpl(a(th2));
        }
    }

    @f1(version = "1.3")
    @z0
    public static final void n(@os.l Object obj) {
        if (obj instanceof c1.b) {
            throw ((c1.b) obj).exception;
        }
    }
}
