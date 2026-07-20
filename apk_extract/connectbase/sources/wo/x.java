package wo;

import java.util.Collection;
import kn.l0;
import vp.f0;

/* JADX INFO: loaded from: classes3.dex */
public interface x<T> {

    public static final class a {
        @os.m
        public static <T> String a(@os.l x<? extends T> xVar, @os.l eo.e eVar) {
            l0.p(xVar, "this");
            l0.p(eVar, "classDescriptor");
            return null;
        }

        @os.m
        public static <T> f0 b(@os.l x<? extends T> xVar, @os.l f0 f0Var) {
            l0.p(xVar, "this");
            l0.p(f0Var, "kotlinType");
            return null;
        }
    }

    @os.m
    String a(@os.l eo.e eVar);

    void b(@os.l f0 f0Var, @os.l eo.e eVar);

    @os.m
    String c(@os.l eo.e eVar);

    @os.m
    T d(@os.l eo.e eVar);

    @os.m
    f0 e(@os.l f0 f0Var);

    @os.l
    f0 f(@os.l Collection<f0> collection);
}
