package sq;

import java.util.List;
import java.util.Set;
import java.util.concurrent.CancellationException;
import kn.r1;
import lm.d1;
import lm.l2;

/* JADX INFO: loaded from: classes3.dex */
public final class d0 {

    @r1({"SMAP\nLint.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Lint.kt\nkotlinx/coroutines/flow/LintKt$retry$1\n*L\n1#1,193:1\n*E\n"})
    @xm.f(c = "kotlinx.coroutines.flow.LintKt$retry$1", f = "Lint.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class a extends xm.o implements jn.p<Throwable, um.d<? super Boolean>, Object> {
        int label;

        public a(um.d<? super a> dVar) {
            super(2, dVar);
        }

        @Override // xm.a
        @os.l
        public final um.d<l2> create(@os.m Object obj, @os.l um.d<?> dVar) {
            return new a(dVar);
        }

        @Override // xm.a
        @os.m
        public final Object invokeSuspend(@os.l Object obj) {
            wm.a aVar = wm.a.COROUTINE_SUSPENDED;
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            d1.n(obj);
            return Boolean.TRUE;
        }

        @Override // jn.p
        @os.m
        public final Object invoke(@os.l Throwable th2, @os.m um.d<? super Boolean> dVar) {
            return ((a) create(th2, dVar)).invokeSuspend(l2.f10208a);
        }
    }

    @lm.k(level = lm.m.ERROR, message = "cancel() is resolved into the extension of outer CoroutineScope which is likely to be an error.Use currentCoroutineContext().cancel() instead or specify the receiver of cancel() explicitly", replaceWith = @lm.a1(expression = "currentCoroutineContext().cancel(cause)", imports = {}))
    public static final void a(@os.l j<?> jVar, @os.m CancellationException cancellationException) {
        throw x.a();
    }

    public static /* synthetic */ void b(j jVar, CancellationException cancellationException, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            cancellationException = null;
        }
        a(jVar, cancellationException);
    }

    @lm.k(level = lm.m.ERROR, message = "Applying 'cancellable' to a SharedFlow has no effect. See the SharedFlow documentation on Operator Fusion.", replaceWith = @lm.a1(expression = "this", imports = {}))
    @os.l
    public static final <T> i<T> c(@os.l j0<? extends T> j0Var) {
        throw x.a();
    }

    @an.f
    @lm.k(level = lm.m.WARNING, message = "SharedFlow never completes, so this operator typically has not effect, it can only catch exceptions from 'onSubscribe' operator", replaceWith = @lm.a1(expression = "this", imports = {}))
    public static final <T> i<T> d(j0<? extends T> j0Var, jn.q<? super j<? super T>, ? super Throwable, ? super um.d<? super l2>, ? extends Object> qVar) {
        kn.l0.n(j0Var, "null cannot be cast to non-null type kotlinx.coroutines.flow.Flow<T of kotlinx.coroutines.flow.LintKt.catch>");
        return new u.a(j0Var, qVar);
    }

    @lm.k(level = lm.m.ERROR, message = "Applying 'conflate' to StateFlow has no effect. See the StateFlow documentation on Operator Fusion.", replaceWith = @lm.a1(expression = "this", imports = {}))
    @os.l
    public static final <T> i<T> e(@os.l u0<? extends T> u0Var) {
        throw x.a();
    }

    @an.f
    @lm.k(level = lm.m.WARNING, message = "SharedFlow never completes, so this terminal operation never completes.")
    public static final <T> Object f(j0<? extends T> j0Var, um.d<? super Integer> dVar) {
        kn.l0.n(j0Var, "null cannot be cast to non-null type kotlinx.coroutines.flow.Flow<T of kotlinx.coroutines.flow.LintKt.count>");
        return q.b(j0Var, dVar);
    }

    @lm.k(level = lm.m.ERROR, message = "Applying 'distinctUntilChanged' to StateFlow has no effect. See the StateFlow documentation on Operator Fusion.", replaceWith = @lm.a1(expression = "this", imports = {}))
    @os.l
    public static final <T> i<T> g(@os.l u0<? extends T> u0Var) {
        throw x.a();
    }

    @lm.k(level = lm.m.ERROR, message = "Applying 'flowOn' to SharedFlow has no effect. See the SharedFlow documentation on Operator Fusion.", replaceWith = @lm.a1(expression = "this", imports = {}))
    @os.l
    public static final <T> i<T> h(@os.l j0<? extends T> j0Var, @os.l um.g gVar) {
        throw x.a();
    }

    @os.l
    public static final um.g i(@os.l j<?> jVar) {
        throw x.a();
    }

    @lm.k(level = lm.m.ERROR, message = "coroutineContext is resolved into the property of outer CoroutineScope which is likely to be an error.Use currentCoroutineContext() instead or specify the receiver of coroutineContext explicitly", replaceWith = @lm.a1(expression = "currentCoroutineContext()", imports = {}))
    public static /* synthetic */ void j(j jVar) {
    }

    public static final boolean k(@os.l j<?> jVar) {
        throw x.a();
    }

    @lm.k(level = lm.m.ERROR, message = "isActive is resolved into the extension of outer CoroutineScope which is likely to be an error.Use currentCoroutineContext().isActive or cancellable() operator instead or specify the receiver of isActive explicitly. Additionally, flow {} builder emissions are cancellable by default.", replaceWith = @lm.a1(expression = "currentCoroutineContext().isActive", imports = {}))
    public static /* synthetic */ void l(j jVar) {
    }

    @an.f
    @lm.k(level = lm.m.WARNING, message = "SharedFlow never completes, so this operator has no effect.", replaceWith = @lm.a1(expression = "this", imports = {}))
    public static final <T> i<T> m(j0<? extends T> j0Var, long j10, jn.p<? super Throwable, ? super um.d<? super Boolean>, ? extends Object> pVar) {
        kn.l0.n(j0Var, "null cannot be cast to non-null type kotlinx.coroutines.flow.Flow<T of kotlinx.coroutines.flow.LintKt.retry>");
        return u.e(j0Var, j10, pVar);
    }

    public static i n(j0 j0Var, long j10, jn.p pVar, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            j10 = Long.MAX_VALUE;
        }
        if ((i10 & 2) != 0) {
            pVar = new a(null);
        }
        kn.l0.n(j0Var, "null cannot be cast to non-null type kotlinx.coroutines.flow.Flow<T of kotlinx.coroutines.flow.LintKt.retry>");
        return u.e(j0Var, j10, pVar);
    }

    @an.f
    @lm.k(level = lm.m.WARNING, message = "SharedFlow never completes, so this operator has no effect.", replaceWith = @lm.a1(expression = "this", imports = {}))
    public static final <T> i<T> o(j0<? extends T> j0Var, jn.r<? super j<? super T>, ? super Throwable, ? super Long, ? super um.d<? super Boolean>, ? extends Object> rVar) {
        kn.l0.n(j0Var, "null cannot be cast to non-null type kotlinx.coroutines.flow.Flow<T of kotlinx.coroutines.flow.LintKt.retryWhen>");
        return new u.f(j0Var, rVar);
    }

    @an.f
    public static final <T> Object p(j0<? extends T> j0Var, List<T> list, um.d<?> dVar) {
        kn.l0.n(j0Var, "null cannot be cast to non-null type kotlinx.coroutines.flow.Flow<T of kotlinx.coroutines.flow.LintKt.toList>");
        o.a(j0Var, list, dVar);
        throw new IllegalStateException("this code is supposed to be unreachable");
    }

    @an.f
    @lm.k(level = lm.m.WARNING, message = "SharedFlow never completes, so this terminal operation never completes.")
    public static final <T> Object q(j0<? extends T> j0Var, um.d<? super List<? extends T>> dVar) {
        kn.l0.n(j0Var, "null cannot be cast to non-null type kotlinx.coroutines.flow.Flow<T of kotlinx.coroutines.flow.LintKt.toList>");
        return o.c(j0Var, null, dVar, 1, null);
    }

    @an.f
    public static final <T> Object r(j0<? extends T> j0Var, Set<T> set, um.d<?> dVar) {
        kn.l0.n(j0Var, "null cannot be cast to non-null type kotlinx.coroutines.flow.Flow<T of kotlinx.coroutines.flow.LintKt.toSet>");
        o.a(j0Var, set, dVar);
        throw new IllegalStateException("this code is supposed to be unreachable");
    }

    @an.f
    @lm.k(level = lm.m.WARNING, message = "SharedFlow never completes, so this terminal operation never completes.")
    public static final <T> Object s(j0<? extends T> j0Var, um.d<? super Set<? extends T>> dVar) {
        kn.l0.n(j0Var, "null cannot be cast to non-null type kotlinx.coroutines.flow.Flow<T of kotlinx.coroutines.flow.LintKt.toSet>");
        return o.e(j0Var, null, dVar, 1, null);
    }
}
