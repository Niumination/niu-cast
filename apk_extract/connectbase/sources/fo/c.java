package fo;

import eo.z0;
import java.util.Map;
import kn.l0;
import vp.f0;
import vp.x;

/* JADX INFO: loaded from: classes3.dex */
public interface c {

    public static final class a {
        @os.m
        public static dp.c a(@os.l c cVar) {
            l0.p(cVar, "this");
            eo.e eVarF = lp.a.f(cVar);
            if (eVarF == null) {
                return null;
            }
            if (x.r(eVarF)) {
                eVarF = null;
            }
            if (eVarF == null) {
                return null;
            }
            return lp.a.e(eVarF);
        }
    }

    @os.l
    Map<dp.f, jp.g<?>> a();

    @os.m
    dp.c e();

    @os.l
    z0 getSource();

    @os.l
    f0 getType();
}
