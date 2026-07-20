package jq;

import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
public class z extends y {
    @an.f
    public static final r t(String str) {
        kn.l0.p(str, "<this>");
        return new r(str);
    }

    @an.f
    public static final r u(String str, Set<? extends t> set) {
        kn.l0.p(str, "<this>");
        kn.l0.p(set, "options");
        return new r(str, set);
    }

    @an.f
    public static final r v(String str, t tVar) {
        kn.l0.p(str, "<this>");
        kn.l0.p(tVar, "option");
        return new r(str, tVar);
    }
}
