package wk;

import ik.e1;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class y {
    @os.l
    public static final x a(@os.l List<String> list, int i10, @os.l String str, @os.m String str2, @os.m String str3, boolean z10) {
        String strY6;
        kn.l0.p(list, "segments");
        kn.l0.p(str, "name");
        if (i10 >= list.size()) {
            return c(z10, null);
        }
        String str4 = list.get(i10);
        if (str4.length() == 0) {
            return c(z10, str4);
        }
        if (str2 == null) {
            strY6 = str4;
        } else {
            if (!jq.e0.s2(str4, str2, false, 2, null)) {
                return c(z10, str4);
            }
            strY6 = jq.j0.y6(str4, str2.length());
        }
        if (str3 != null) {
            if (!jq.e0.J1(strY6, str3, false, 2, null)) {
                return c(z10, str4);
            }
            strY6 = jq.j0.A6(strY6, str3.length());
        }
        return new x(true, ((str2 == null || str2.length() == 0) && (str3 == null || str3.length() == 0)) ? 0.8d : 0.9d, e1.b(str, strY6), 1);
    }

    public static final x c(boolean z10, String str) {
        if (!z10) {
            x.f19664e.getClass();
            return x.f19675p;
        }
        if (str == null) {
            x.f19664e.getClass();
            return x.f19676q;
        }
        if (str.length() == 0) {
            x.f19664e.getClass();
            return x.l(x.f19676q, false, 0.0d, null, 1, 7, null);
        }
        x.f19664e.getClass();
        return x.f19676q;
    }
}
