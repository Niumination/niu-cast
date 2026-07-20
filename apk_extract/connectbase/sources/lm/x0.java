package lm;

/* JADX INFO: loaded from: classes3.dex */
@kn.r1({"SMAP\nPreconditions.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Preconditions.kt\nkotlin/PreconditionsKt__PreconditionsKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,144:1\n1#2:145\n*E\n"})
public class x0 extends w0 {
    @an.f
    public static final void c(boolean z10) {
        if (!z10) {
            throw new IllegalStateException("Check failed.");
        }
    }

    @an.f
    public static final void d(boolean z10, jn.a<? extends Object> aVar) {
        kn.l0.p(aVar, "lazyMessage");
        if (!z10) {
            throw new IllegalStateException(aVar.invoke().toString());
        }
    }

    @an.f
    public static final <T> T e(T t10) {
        if (t10 != null) {
            return t10;
        }
        throw new IllegalStateException("Required value was null.");
    }

    @an.f
    public static final <T> T f(T t10, jn.a<? extends Object> aVar) {
        kn.l0.p(aVar, "lazyMessage");
        if (t10 != null) {
            return t10;
        }
        throw new IllegalStateException(aVar.invoke().toString());
    }

    @an.f
    public static final Void g(Object obj) {
        kn.l0.p(obj, "message");
        throw new IllegalStateException(obj.toString());
    }

    @an.f
    public static final void h(boolean z10) {
        if (!z10) {
            throw new IllegalArgumentException("Failed requirement.");
        }
    }

    @an.f
    public static final void i(boolean z10, jn.a<? extends Object> aVar) {
        kn.l0.p(aVar, "lazyMessage");
        if (!z10) {
            throw new IllegalArgumentException(aVar.invoke().toString());
        }
    }

    @an.f
    public static final <T> T j(T t10) {
        if (t10 != null) {
            return t10;
        }
        throw new IllegalArgumentException("Required value was null.");
    }

    @an.f
    public static final <T> T k(T t10, jn.a<? extends Object> aVar) {
        kn.l0.p(aVar, "lazyMessage");
        if (t10 != null) {
            return t10;
        }
        throw new IllegalArgumentException(aVar.invoke().toString());
    }
}
