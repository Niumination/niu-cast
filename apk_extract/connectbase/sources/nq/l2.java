package nq;

import java.util.concurrent.CancellationException;

/* JADX INFO: loaded from: classes3.dex */
public interface l2 extends um.g.b {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @os.l
    public static final b f11882k = b.f11883a;

    public static final class a {
        public static /* synthetic */ void b(l2 l2Var, CancellationException cancellationException, int i10, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: cancel");
            }
            if ((i10 & 1) != 0) {
                cancellationException = null;
            }
            l2Var.b(cancellationException);
        }

        public static /* synthetic */ boolean c(l2 l2Var, Throwable th2, int i10, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: cancel");
            }
            if ((i10 & 1) != 0) {
                th2 = null;
            }
            return l2Var.c(th2);
        }

        public static <R> R d(@os.l l2 l2Var, R r10, @os.l jn.p<? super R, ? super um.g.b, ? extends R> pVar) {
            return (R) um.g.b.a.a(l2Var, r10, pVar);
        }

        @os.m
        public static <E extends um.g.b> E e(@os.l l2 l2Var, @os.l um.g.c<E> cVar) {
            return (E) um.g.b.a.b(l2Var, cVar);
        }

        @a2
        public static /* synthetic */ void f() {
        }

        public static /* synthetic */ n1 g(l2 l2Var, boolean z10, boolean z11, jn.l lVar, int i10, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: invokeOnCompletion");
            }
            if ((i10 & 1) != 0) {
                z10 = false;
            }
            if ((i10 & 2) != 0) {
                z11 = true;
            }
            return l2Var.S1(z10, z11, lVar);
        }

        @os.l
        public static um.g h(@os.l l2 l2Var, @os.l um.g.c<?> cVar) {
            return um.g.b.a.c(l2Var, cVar);
        }

        @lm.k(level = lm.m.ERROR, message = "Operator '+' on two Job objects is meaningless. Job is a coroutine context element and `+` is a set-sum operator for coroutine contexts. The job to the right of `+` just replaces the job the left of `+`.")
        @os.l
        public static l2 i(@os.l l2 l2Var, @os.l l2 l2Var2) {
            return l2Var2;
        }

        @os.l
        public static um.g j(@os.l l2 l2Var, @os.l um.g gVar) {
            return um.g.b.a.d(l2Var, gVar);
        }
    }

    public static final class b implements um.g.c<l2> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ b f11883a = new b();
    }

    @os.l
    yq.e J1();

    @g2
    @os.l
    CancellationException O();

    @g2
    @os.l
    n1 S1(boolean z10, boolean z11, @os.l jn.l<? super Throwable, lm.l2> lVar);

    void b(@os.m CancellationException cancellationException);

    @lm.k(level = lm.m.HIDDEN, message = "Since 1.2.0, binary compatibility with versions <= 1.1.x")
    /* synthetic */ boolean c(Throwable th2);

    @lm.k(level = lm.m.HIDDEN, message = "Since 1.2.0, binary compatibility with versions <= 1.1.x")
    /* synthetic */ void cancel();

    @os.m
    l2 getParent();

    boolean isActive();

    boolean isCancelled();

    boolean isCompleted();

    @os.l
    n1 k0(@os.l jn.l<? super Throwable, lm.l2> lVar);

    @g2
    @os.l
    v o(@os.l x xVar);

    boolean start();

    @os.m
    Object t(@os.l um.d<? super lm.l2> dVar);

    @os.l
    gq.m<l2> y();

    @lm.k(level = lm.m.ERROR, message = "Operator '+' on two Job objects is meaningless. Job is a coroutine context element and `+` is a set-sum operator for coroutine contexts. The job to the right of `+` just replaces the job the left of `+`.")
    @os.l
    l2 y0(@os.l l2 l2Var);
}
