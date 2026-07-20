package nq;

/* JADX INFO: loaded from: classes3.dex */
public interface a1<T> extends l2 {

    public static final class a {
        public static <T, R> R b(@os.l a1<? extends T> a1Var, R r10, @os.l jn.p<? super R, ? super um.g.b, ? extends R> pVar) {
            return (R) um.g.b.a.a(a1Var, r10, pVar);
        }

        @os.m
        public static <T, E extends um.g.b> E c(@os.l a1<? extends T> a1Var, @os.l um.g.c<E> cVar) {
            return (E) um.g.b.a.b(a1Var, cVar);
        }

        @os.l
        public static <T> um.g d(@os.l a1<? extends T> a1Var, @os.l um.g.c<?> cVar) {
            return um.g.b.a.c(a1Var, cVar);
        }

        @lm.k(level = lm.m.ERROR, message = "Operator '+' on two Job objects is meaningless. Job is a coroutine context element and `+` is a set-sum operator for coroutine contexts. The job to the right of `+` just replaces the job the left of `+`.")
        @os.l
        public static <T> l2 e(@os.l a1<? extends T> a1Var, @os.l l2 l2Var) {
            return l2Var;
        }

        @os.l
        public static <T> um.g f(@os.l a1<? extends T> a1Var, @os.l um.g gVar) {
            return um.g.b.a.d(a1Var, gVar);
        }
    }

    @os.m
    @a2
    Throwable A();

    @os.m
    Object O0(@os.l um.d<? super T> dVar);

    @os.l
    yq.g<T> S0();

    @a2
    T p();
}
