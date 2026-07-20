package um;

import jn.l;
import jn.p;
import kn.l0;
import kn.r1;
import lm.c1;
import lm.f1;
import lm.j0;
import lm.l2;

/* JADX INFO: loaded from: classes3.dex */
public final class f {

    /* JADX INFO: Add missing generic type declarations: [T] */
    @r1({"SMAP\nContinuation.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Continuation.kt\nkotlin/coroutines/ContinuationKt$Continuation$1\n*L\n1#1,161:1\n*E\n"})
    public static final class a<T> implements d<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ g f16332a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ l<c1<? extends T>, l2> f16333b;

        /* JADX WARN: Multi-variable type inference failed */
        public a(g gVar, l<? super c1<? extends T>, l2> lVar) {
            this.f16332a = gVar;
            this.f16333b = lVar;
        }

        @Override // um.d
        @os.l
        public g getContext() {
            return this.f16332a;
        }

        @Override // um.d
        public void resumeWith(@os.l Object obj) {
            this.f16333b.invoke(c1.m58boximpl(obj));
        }
    }

    @f1(version = "1.3")
    @an.f
    public static final <T> d<T> a(g gVar, l<? super c1<? extends T>, l2> lVar) {
        l0.p(gVar, "context");
        l0.p(lVar, "resumeWith");
        return new a(gVar, lVar);
    }

    @f1(version = "1.3")
    @os.l
    public static final <T> d<l2> b(@os.l l<? super d<? super T>, ? extends Object> lVar, @os.l d<? super T> dVar) {
        l0.p(lVar, "<this>");
        l0.p(dVar, "completion");
        return new k(wm.c.e(wm.c.b(lVar, dVar)), wm.a.COROUTINE_SUSPENDED);
    }

    @f1(version = "1.3")
    @os.l
    public static final <R, T> d<l2> c(@os.l p<? super R, ? super d<? super T>, ? extends Object> pVar, R r10, @os.l d<? super T> dVar) {
        l0.p(pVar, "<this>");
        l0.p(dVar, "completion");
        return new k(wm.c.e(wm.c.c(pVar, r10, dVar)), wm.a.COROUTINE_SUSPENDED);
    }

    public static final g d() {
        throw new j0("Implemented as intrinsic");
    }

    @f1(version = "1.3")
    @an.f
    public static /* synthetic */ void e() {
    }

    @f1(version = "1.3")
    @an.f
    public static final <T> void f(d<? super T> dVar, T t10) {
        l0.p(dVar, "<this>");
        c1.a aVar = c1.Companion;
        dVar.resumeWith(c1.m59constructorimpl(t10));
    }

    @f1(version = "1.3")
    @an.f
    public static final <T> void g(d<? super T> dVar, Throwable th2) {
        l0.p(dVar, "<this>");
        l0.p(th2, "exception");
        c1.a aVar = c1.Companion;
        w.a.a(th2, dVar);
    }

    @f1(version = "1.3")
    public static final <T> void h(@os.l l<? super d<? super T>, ? extends Object> lVar, @os.l d<? super T> dVar) {
        l0.p(lVar, "<this>");
        l0.p(dVar, "completion");
        d dVarE = wm.c.e(wm.c.b(lVar, dVar));
        c1.a aVar = c1.Companion;
        dVarE.resumeWith(c1.m59constructorimpl(l2.f10208a));
    }

    @f1(version = "1.3")
    public static final <R, T> void i(@os.l p<? super R, ? super d<? super T>, ? extends Object> pVar, R r10, @os.l d<? super T> dVar) {
        l0.p(pVar, "<this>");
        l0.p(dVar, "completion");
        d dVarE = wm.c.e(wm.c.c(pVar, r10, dVar));
        c1.a aVar = c1.Companion;
        dVarE.resumeWith(c1.m59constructorimpl(l2.f10208a));
    }

    @f1(version = "1.3")
    @an.f
    public static final <T> Object j(l<? super d<? super T>, l2> lVar, d<? super T> dVar) throws Throwable {
        k kVar = new k(wm.c.e(dVar));
        lVar.invoke(kVar);
        Object objA = kVar.a();
        if (objA == wm.a.COROUTINE_SUSPENDED) {
            xm.h.c(dVar);
        }
        return objA;
    }
}
