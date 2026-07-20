package nq;

/* JADX INFO: loaded from: classes3.dex */
public interface b0 extends l2 {

    public static final class a {
        public static <R> R b(@os.l b0 b0Var, R r10, @os.l jn.p<? super R, ? super um.g.b, ? extends R> pVar) {
            return (R) um.g.b.a.a(b0Var, r10, pVar);
        }

        @os.m
        public static <E extends um.g.b> E c(@os.l b0 b0Var, @os.l um.g.c<E> cVar) {
            return (E) um.g.b.a.b(b0Var, cVar);
        }

        @os.l
        public static um.g d(@os.l b0 b0Var, @os.l um.g.c<?> cVar) {
            return um.g.b.a.c(b0Var, cVar);
        }

        @lm.k(level = lm.m.ERROR, message = "Operator '+' on two Job objects is meaningless. Job is a coroutine context element and `+` is a set-sum operator for coroutine contexts. The job to the right of `+` just replaces the job the left of `+`.")
        @os.l
        public static l2 e(@os.l b0 b0Var, @os.l l2 l2Var) {
            return l2Var;
        }

        @os.l
        public static um.g f(@os.l b0 b0Var, @os.l um.g gVar) {
            return um.g.b.a.d(b0Var, gVar);
        }
    }

    boolean complete();

    boolean k(@os.l Throwable th2);
}
