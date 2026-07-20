package ik;

import androidx.core.app.FrameMetricsAggregator;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class p1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f8145a = 0;

    public static final void c(Appendable appendable, String str, String str2) throws IOException {
        appendable.append("://");
        appendable.append(str);
        appendable.append(str2);
    }

    public static final void d(Appendable appendable, String str, String str2) throws IOException {
        appendable.append(":");
        appendable.append(e.n(str, false, 1, null));
        appendable.append('@');
        appendable.append(str2);
    }

    public static final void e(StringBuilder sb2, String str, String str2) {
        if (str == null) {
            return;
        }
        sb2.append(e.n(str, false, 1, null));
        if (str2 != null) {
            sb2.append(n1.e.f11184d);
            sb2.append(e.n(str2, false, 1, null));
        }
        sb2.append("@");
    }

    @os.l
    public static final n1 f(@os.l n1 n1Var) {
        kn.l0.p(n1Var, "<this>");
        return w1.j(new n1(null, null, 0, null, null, null, null, null, false, FrameMetricsAggregator.EVERY_DURATION, null), n1Var);
    }

    @os.l
    public static final String g(@os.l n1 n1Var) {
        kn.l0.p(n1Var, "<this>");
        StringBuilder sb2 = new StringBuilder();
        sb2.append(i(n1Var));
        sb2.append(n1Var.f8122b);
        int i10 = n1Var.f8123c;
        if (i10 != 0 && i10 != n1Var.f8121a.f8197b) {
            sb2.append(":");
            sb2.append(String.valueOf(n1Var.f8123c));
        }
        String string = sb2.toString();
        kn.l0.o(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    @os.l
    public static final String h(@os.l y1 y1Var) {
        kn.l0.p(y1Var, "<this>");
        StringBuilder sb2 = new StringBuilder();
        sb2.append(j(y1Var));
        if (y1Var.f8227c == 0) {
            sb2.append(y1Var.f8226b);
        } else {
            sb2.append(w1.i(y1Var));
        }
        String string = sb2.toString();
        kn.l0.o(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    @os.l
    public static final String i(@os.l n1 n1Var) {
        kn.l0.p(n1Var, "<this>");
        StringBuilder sb2 = new StringBuilder();
        e(sb2, n1Var.f8124d, n1Var.f8125e);
        String string = sb2.toString();
        kn.l0.o(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    @os.l
    public static final String j(@os.l y1 y1Var) {
        kn.l0.p(y1Var, "<this>");
        StringBuilder sb2 = new StringBuilder();
        e(sb2, y1Var.f8231g, y1Var.f8232h);
        String string = sb2.toString();
        kn.l0.o(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    @os.l
    public static final n1 k(@os.l n1 n1Var, @os.l List<String> list) {
        String strSubstring;
        String strSubstring2;
        kn.l0.p(n1Var, "<this>");
        kn.l0.p(list, "components");
        List<String> list2 = list;
        ArrayList arrayList = new ArrayList(nm.z.b0(list2, 10));
        for (String str : list2) {
            int length = str.length();
            int i10 = 0;
            while (true) {
                strSubstring = "";
                if (i10 >= length) {
                    strSubstring2 = "";
                    break;
                }
                int i11 = i10 + 1;
                if (str.charAt(i10) != '/') {
                    strSubstring2 = str.substring(i10);
                    kn.l0.o(strSubstring2, "this as java.lang.String).substring(startIndex)");
                    break;
                }
                i10 = i11;
            }
            int iG3 = jq.h0.g3(strSubstring2);
            if (iG3 >= 0) {
                while (true) {
                    int i12 = iG3 - 1;
                    if (strSubstring2.charAt(iG3) != '/') {
                        strSubstring = strSubstring2.substring(0, iG3 + 1);
                        kn.l0.o(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
                        break;
                    }
                    if (i12 < 0) {
                        break;
                    }
                    iG3 = i12;
                }
            }
            arrayList.add(e.r(strSubstring, false, false, null, 7, null));
        }
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : arrayList) {
            if (((String) obj).length() > 0) {
                arrayList2.add(obj);
            }
        }
        String strM3 = nm.h0.m3(arrayList2, "/", null, null, 0, null, null, 62, null);
        if (!jq.h0.Y2(n1Var.f8126f, el.b0.f4502a, false, 2, null)) {
            strM3 = kn.l0.C("/", strM3);
        }
        n1Var.o(kn.l0.C(n1Var.f8126f, strM3));
        return n1Var;
    }

    @os.l
    public static final n1 l(@os.l n1 n1Var, @os.l String... strArr) {
        kn.l0.p(n1Var, "<this>");
        kn.l0.p(strArr, "components");
        return k(n1Var, nm.r.Ky(strArr));
    }
}
