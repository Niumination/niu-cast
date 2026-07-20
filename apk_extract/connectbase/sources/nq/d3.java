package nq;

import java.util.concurrent.CancellationException;

/* JADX INFO: loaded from: classes3.dex */
@g2
@lm.k(level = lm.m.ERROR, message = "This is internal API and may be removed in the future releases")
public interface d3 extends l2 {

    public static final class a {
        public static <R> R b(@os.l d3 d3Var, R r10, @os.l jn.p<? super R, ? super um.g.b, ? extends R> pVar) {
            return (R) um.g.b.a.a(d3Var, r10, pVar);
        }

        @os.m
        public static <E extends um.g.b> E c(@os.l d3 d3Var, @os.l um.g.c<E> cVar) {
            return (E) um.g.b.a.b(d3Var, cVar);
        }

        @os.l
        public static um.g d(@os.l d3 d3Var, @os.l um.g.c<?> cVar) {
            return um.g.b.a.c(d3Var, cVar);
        }

        @lm.k(level = lm.m.ERROR, message = "Operator '+' on two Job objects is meaningless. Job is a coroutine context element and `+` is a set-sum operator for coroutine contexts. The job to the right of `+` just replaces the job the left of `+`.")
        @os.l
        public static l2 e(@os.l d3 d3Var, @os.l l2 l2Var) {
            return l2Var;
        }

        @os.l
        public static um.g f(@os.l d3 d3Var, @os.l um.g gVar) {
            return um.g.b.a.d(d3Var, gVar);
        }
    }

    @g2
    @os.l
    CancellationException q0();
}
