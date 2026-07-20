package eo;

import java.util.Collection;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public interface h0 extends m {

    public static final class a {
        public static <R, D> R a(@os.l h0 h0Var, @os.l o<R, D> oVar, D d10) {
            kn.l0.p(h0Var, "this");
            kn.l0.p(oVar, "visitor");
            return oVar.f(h0Var, d10);
        }

        @os.m
        public static m b(@os.l h0 h0Var) {
            kn.l0.p(h0Var, "this");
            return null;
        }
    }

    boolean E(@os.l h0 h0Var);

    @os.m
    <T> T M(@os.l g0<T> g0Var);

    @os.l
    ao.h n();

    @os.l
    p0 o0(@os.l dp.c cVar);

    @os.l
    Collection<dp.c> p(@os.l dp.c cVar, @os.l jn.l<? super dp.f, Boolean> lVar);

    @os.l
    List<h0> v0();
}
