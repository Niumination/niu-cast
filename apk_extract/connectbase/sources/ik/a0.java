package ik;

import io.netty.util.internal.StringUtil;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public final class a0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public static final Set<Character> f7937a = nm.o1.u('(', ')', Character.valueOf(jq.m0.f8867e), Character.valueOf(jq.m0.f8868f), '@', Character.valueOf(StringUtil.COMMA), ';', Character.valueOf(n1.e.f11184d), Character.valueOf(rs.f.f14862d), '\"', Character.valueOf(el.b0.f4502a), Character.valueOf(ks.a.f9445d), ']', '?', Character.valueOf(fl.h.f6043c), Character.valueOf(rs.f.f14859a), Character.valueOf(rs.f.f14860b), ' ', '\t', '\n', Character.valueOf(StringUtil.CARRIAGE_RETURN));

    public static final void b(@os.l fl.p1 p1Var, @os.l String str, @os.l z zVar) {
        kn.l0.p(p1Var, "<this>");
        kn.l0.p(str, "name");
        kn.l0.p(zVar, "value");
        p1Var.a(str, zVar.toString());
    }

    public static final boolean c(String str) {
        if (str.length() == 0) {
            return true;
        }
        if (g(str)) {
            return false;
        }
        int length = str.length();
        int i10 = 0;
        while (i10 < length) {
            int i11 = i10 + 1;
            if (f7937a.contains(Character.valueOf(str.charAt(i10)))) {
                return true;
            }
            i10 = i11;
        }
        return false;
    }

    @fl.t0
    @os.l
    public static final String d(@os.l String str) {
        kn.l0.p(str, "<this>");
        return c(str) ? h(str) : str;
    }

    public static final void e(String str, StringBuilder sb2) {
        if (c(str)) {
            sb2.append(h(str));
        } else {
            sb2.append(str);
        }
    }

    public static /* synthetic */ void f() {
    }

    public static final boolean g(String str) {
        if (str.length() < 2 || jq.j0.S6(str) != '\"' || jq.j0.r7(str) != '\"') {
            return false;
        }
        int i10 = 1;
        do {
            int iO3 = jq.h0.o3(str, '\"', i10, false, 4, null);
            if (iO3 == jq.h0.g3(str)) {
                break;
            }
            int i11 = 0;
            for (int i12 = iO3 - 1; str.charAt(i12) == '\\'; i12--) {
                i11++;
            }
            if (i11 % 2 == 0) {
                return false;
            }
            i10 = iO3 + 1;
        } while (i10 < str.length());
        return true;
    }

    @fl.t0
    @os.l
    public static final String h(@os.l String str) {
        kn.l0.p(str, "<this>");
        StringBuilder sb2 = new StringBuilder();
        i(str, sb2);
        String string = sb2.toString();
        kn.l0.o(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    public static final void i(String str, StringBuilder sb2) {
        sb2.append("\"");
        int length = str.length();
        int i10 = 0;
        while (i10 < length) {
            int i11 = i10 + 1;
            char cCharAt = str.charAt(i10);
            if (cCharAt == '\\') {
                sb2.append("\\\\");
            } else if (cCharAt == '\n') {
                sb2.append("\\n");
            } else if (cCharAt == '\r') {
                sb2.append("\\r");
            } else if (cCharAt == '\t') {
                sb2.append("\\t");
            } else if (cCharAt == '\"') {
                sb2.append("\\\"");
            } else {
                sb2.append(cCharAt);
            }
            i10 = i11;
        }
        sb2.append("\"");
    }
}
