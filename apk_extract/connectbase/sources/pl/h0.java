package pl;

import nq.l2;

/* JADX INFO: loaded from: classes2.dex */
public interface h0 extends l2 {

    public static final class a {
        @lm.k(level = lm.m.HIDDEN, message = "Since 1.2.0, binary compatibility with versions <= 1.1.x")
        public static /* synthetic */ void a(h0 h0Var) {
            kn.l0.p(h0Var, "this");
            h0Var.b(null);
        }

        public static <R> R b(@os.l h0 h0Var, R r10, @os.l jn.p<? super R, ? super um.g.b, ? extends R> pVar) {
            kn.l0.p(h0Var, "this");
            kn.l0.p(pVar, "operation");
            return (R) um.g.b.a.a(h0Var, r10, pVar);
        }

        @os.m
        public static <E extends um.g.b> E c(@os.l h0 h0Var, @os.l um.g.c<E> cVar) {
            kn.l0.p(h0Var, "this");
            kn.l0.p(cVar, cb.b.c.f1408o);
            return (E) um.g.b.a.b(h0Var, cVar);
        }

        @os.l
        public static um.g d(@os.l h0 h0Var, @os.l um.g.c<?> cVar) {
            kn.l0.p(h0Var, "this");
            kn.l0.p(cVar, cb.b.c.f1408o);
            return um.g.b.a.c(h0Var, cVar);
        }

        @lm.k(level = lm.m.ERROR, message = "Operator '+' on two Job objects is meaningless. Job is a coroutine context element and `+` is a set-sum operator for coroutine contexts. The job to the right of `+` just replaces the job the left of `+`.")
        @os.l
        public static l2 e(@os.l h0 h0Var, @os.l l2 l2Var) {
            kn.l0.p(h0Var, "this");
            kn.l0.p(l2Var, "other");
            return l2Var;
        }

        @os.l
        public static um.g f(@os.l h0 h0Var, @os.l um.g gVar) {
            kn.l0.p(h0Var, "this");
            kn.l0.p(gVar, "context");
            return um.g.b.a.d(h0Var, gVar);
        }
    }

    @os.l
    /* JADX INFO: renamed from: a */
    n mo70a();
}
