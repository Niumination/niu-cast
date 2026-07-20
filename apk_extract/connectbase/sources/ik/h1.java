package ik;

/* JADX INFO: loaded from: classes2.dex */
public final class h1 {
    public static final void a(c1 c1Var, String str, int i10, int i11, int i12) {
        String strSubstring;
        String strSubstring2;
        String strSubstring3;
        if (i11 == -1) {
            int iH = h(i10, i12, str);
            int iG = g(iH, i12, str);
            if (iG > iH) {
                if (c1Var.f7945d.getEncodeKey$ktor_http()) {
                    strSubstring3 = e.k(str, iH, iG, false, null, 12, null);
                } else {
                    strSubstring3 = str.substring(iH, iG);
                    kn.l0.o(strSubstring3, "this as java.lang.String…ing(startIndex, endIndex)");
                }
                c1Var.c(strSubstring3, nm.k0.INSTANCE);
                return;
            }
            return;
        }
        int iH2 = h(i10, i11, str);
        int iG2 = g(iH2, i11, str);
        if (iG2 > iH2) {
            if (c1Var.f7945d.getEncodeKey$ktor_http()) {
                strSubstring = e.k(str, iH2, iG2, false, null, 12, null);
            } else {
                strSubstring = str.substring(iH2, iG2);
                kn.l0.o(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
            }
            int iH3 = h(i11 + 1, i12, str);
            int iG3 = g(iH3, i12, str);
            if (c1Var.f7945d.getEncodeValue$ktor_http()) {
                strSubstring2 = e.k(str, iH3, iG3, true, null, 8, null);
            } else {
                strSubstring2 = str.substring(iH3, iG3);
                kn.l0.o(strSubstring2, "this as java.lang.String…ing(startIndex, endIndex)");
            }
            c1Var.a(strSubstring, strSubstring2);
        }
    }

    public static final void b(c1 c1Var, String str, int i10, int i11) {
        int iG3 = jq.h0.g3(str);
        int i12 = 0;
        int i13 = -1;
        if (i10 <= iG3) {
            int i14 = 0;
            int i15 = -1;
            int i16 = i10;
            while (true) {
                int i17 = i10 + 1;
                if (i14 == i11) {
                    return;
                }
                char cCharAt = str.charAt(i10);
                if (cCharAt == '&') {
                    a(c1Var, str, i16, i15, i10);
                    i14++;
                    i15 = -1;
                    i16 = i17;
                } else if (cCharAt == '=' && i15 == -1) {
                    i15 = i10;
                }
                if (i10 == iG3) {
                    i10 = i16;
                    i12 = i14;
                    i13 = i15;
                    break;
                }
                i10 = i17;
            }
        }
        if (i12 == i11) {
            return;
        }
        a(c1Var, str, i10, i13, str.length());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @os.l
    public static final b1 c(@os.l String str, int i10, int i11) {
        kn.l0.p(str, "query");
        if (i10 > jq.h0.g3(str)) {
            b1.f7942c.getClass();
            return b1.a.f7944b;
        }
        b1.a aVar = b1.f7942c;
        c1 c1Var = new c1(0, null, 3, 0 == true ? 1 : 0);
        b(c1Var, str, i10, i11);
        return c1Var.f();
    }

    public static /* synthetic */ b1 d(String str, int i10, int i11, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i10 = 0;
        }
        if ((i12 & 4) != 0) {
            i11 = 1000;
        }
        return c(str, i10, i11);
    }

    public static final void e(@os.l c1 c1Var, @os.l String str, int i10, int i11) {
        kn.l0.p(c1Var, "parametersBuilder");
        kn.l0.p(str, "query");
        if (i10 > jq.h0.g3(str)) {
            return;
        }
        b(c1Var, str, i10, i11);
    }

    public static /* synthetic */ void f(c1 c1Var, String str, int i10, int i11, int i12, Object obj) {
        if ((i12 & 4) != 0) {
            i10 = 0;
        }
        if ((i12 & 8) != 0) {
            i11 = 1000;
        }
        e(c1Var, str, i10, i11);
    }

    public static final int g(int i10, int i11, CharSequence charSequence) {
        while (i11 > i10 && jq.d.r(charSequence.charAt(i11 - 1))) {
            i11--;
        }
        return i11;
    }

    public static final int h(int i10, int i11, CharSequence charSequence) {
        while (i10 < i11 && jq.d.r(charSequence.charAt(i10))) {
            i10++;
        }
        return i10;
    }
}
