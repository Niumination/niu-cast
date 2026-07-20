package wk;

import lm.a1;

/* JADX INFO: loaded from: classes2.dex */
public final class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public static final r f19657a = new r();

    @os.l
    public final w a(@os.l String str) {
        kn.l0.p(str, "value");
        return kn.l0.g(str, "*") ? t.f19660b : new o(str);
    }

    @lm.k(level = lm.m.WARNING, message = "hasTrailingSlash is not used anymore. This is going to be removed", replaceWith = @a1(expression = "parseConstant(value)", imports = {}))
    @os.l
    public final w b(@os.l String str, boolean z10) {
        kn.l0.p(str, "value");
        return a(str);
    }

    @os.l
    public final String c(@os.l String str) {
        kn.l0.p(str, "value");
        String strSubstring = str.substring(jq.h0.s5(str, rs.f.f14859a, "").length() + 1, (str.length() - jq.h0.o5(str, rs.f.f14860b, "").length()) - 1);
        kn.l0.o(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
        if (jq.e0.J1(strSubstring, "?", false, 2, null)) {
            return jq.j0.A6(strSubstring, 1);
        }
        return jq.e0.J1(strSubstring, "...", false, 2, null) ? jq.j0.A6(strSubstring, 3) : strSubstring;
    }

    @os.l
    public final w d(@os.l String str) {
        String strSubstring;
        String strSubstring2;
        kn.l0.p(str, "value");
        int iO3 = jq.h0.o3(str, rs.f.f14859a, 0, false, 6, null);
        int iC3 = jq.h0.C3(str, rs.f.f14860b, 0, false, 6, null);
        if (iO3 == 0) {
            strSubstring = null;
        } else {
            strSubstring = str.substring(0, iO3);
            kn.l0.o(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
        }
        if (iC3 == str.length() - 1) {
            strSubstring2 = null;
        } else {
            strSubstring2 = str.substring(iC3 + 1);
            kn.l0.o(strSubstring2, "this as java.lang.String).substring(startIndex)");
        }
        String strSubstring3 = str.substring(iO3 + 1, iC3);
        kn.l0.o(strSubstring3, "this as java.lang.String…ing(startIndex, endIndex)");
        if (jq.e0.J1(strSubstring3, "?", false, 2, null)) {
            return new p(jq.j0.A6(strSubstring3, 1), strSubstring, strSubstring2);
        }
        if (!jq.e0.J1(strSubstring3, "...", false, 2, null)) {
            return new q(strSubstring3, strSubstring, strSubstring2);
        }
        if (strSubstring2 != null && strSubstring2.length() > 0) {
            throw new IllegalArgumentException("Suffix after tailcard is not supported");
        }
        String strA6 = jq.j0.A6(strSubstring3, 3);
        if (strSubstring == null) {
            strSubstring = "";
        }
        return new s(strA6, strSubstring);
    }

    @lm.k(level = lm.m.WARNING, message = "hasTrailingSlash is not used anymore. This is going to be removed", replaceWith = @a1(expression = "parseParameter(value)", imports = {}))
    @os.l
    public final w e(@os.l String str, boolean z10) {
        kn.l0.p(str, "value");
        return d(str);
    }
}
