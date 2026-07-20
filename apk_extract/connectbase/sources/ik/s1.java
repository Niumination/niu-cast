package ik;

/* JADX INFO: loaded from: classes2.dex */
public final class s1 {
    public static final int a(String str, int i10, int i11, char c10) {
        int i12 = 0;
        while (true) {
            int i13 = i10 + i12;
            if (i13 >= i11 || str.charAt(i13) != c10) {
                break;
            }
            i12++;
        }
        return i12;
    }

    public static final void b(n1 n1Var, String str, int i10, int i11) {
        Integer numValueOf = Integer.valueOf(d(str, i10, i11));
        if (numValueOf.intValue() <= 0) {
            numValueOf = null;
        }
        int iIntValue = numValueOf == null ? i11 : numValueOf.intValue();
        String strSubstring = str.substring(i10, iIntValue);
        kn.l0.o(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
        n1Var.q(strSubstring);
        int i12 = iIntValue + 1;
        if (i12 >= i11) {
            n1Var.f8123c = 0;
            return;
        }
        String strSubstring2 = str.substring(i12, i11);
        kn.l0.o(strSubstring2, "this as java.lang.String…ing(startIndex, endIndex)");
        n1Var.f8123c = Integer.parseInt(strSubstring2);
    }

    public static final int c(String str, int i10, int i11) {
        int i12;
        int i13;
        char cCharAt = str.charAt(i10);
        if (('a' > cCharAt || cCharAt >= '{') && ('A' > cCharAt || cCharAt >= '[')) {
            i12 = i10;
            i13 = i12;
        } else {
            i12 = i10;
            i13 = -1;
        }
        while (i12 < i11) {
            char cCharAt2 = str.charAt(i12);
            if (cCharAt2 == ':') {
                if (i13 == -1) {
                    return i12 - i10;
                }
                throw new IllegalArgumentException(kn.l0.C("Illegal character in scheme at position ", Integer.valueOf(i13)));
            }
            if (cCharAt2 == '/' || cCharAt2 == '?' || cCharAt2 == '#') {
                break;
            }
            if (i13 == -1 && (('a' > cCharAt2 || cCharAt2 >= '{') && (('A' > cCharAt2 || cCharAt2 >= '[') && (('0' > cCharAt2 || cCharAt2 >= ':') && cCharAt2 != '.' && cCharAt2 != '+' && cCharAt2 != '-')))) {
                i13 = i12;
            }
            i12++;
        }
        return -1;
    }

    public static final int d(String str, int i10, int i11) {
        boolean z10 = false;
        while (i10 < i11) {
            int i12 = i10 + 1;
            char cCharAt = str.charAt(i10);
            if (cCharAt == '[') {
                z10 = true;
            } else if (cCharAt == ']') {
                z10 = false;
            } else if (cCharAt == ':' && !z10) {
                return i10;
            }
            i10 = i12;
        }
        return -1;
    }

    public static final boolean e(char c10) {
        char lowerCase = Character.toLowerCase(c10);
        return 'a' <= lowerCase && lowerCase < '{';
    }

    public static final void f(n1 n1Var, String str, int i10, int i11, int i12) {
        if (i12 != 2) {
            if (i12 != 3) {
                throw new IllegalArgumentException(kn.l0.C("Invalid file url: ", str));
            }
            n1Var.q("");
            String strSubstring = str.substring(i10, i11);
            kn.l0.o(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
            n1Var.o(kn.l0.C("/", strSubstring));
            return;
        }
        int iO3 = jq.h0.o3(str, el.b0.f4502a, i10, false, 4, null);
        if (iO3 == -1 || iO3 == i11) {
            String strSubstring2 = str.substring(i10, i11);
            kn.l0.o(strSubstring2, "this as java.lang.String…ing(startIndex, endIndex)");
            n1Var.q(strSubstring2);
        } else {
            String strSubstring3 = str.substring(i10, iO3);
            kn.l0.o(strSubstring3, "this as java.lang.String…ing(startIndex, endIndex)");
            n1Var.q(strSubstring3);
            String strSubstring4 = str.substring(iO3, i11);
            kn.l0.o(strSubstring4, "this as java.lang.String…ing(startIndex, endIndex)");
            n1Var.o(strSubstring4);
        }
    }

    public static final void g(n1 n1Var, String str, int i10, int i11) {
        if (i10 >= i11 || str.charAt(i10) != '#') {
            return;
        }
        String strSubstring = str.substring(i10 + 1, i11);
        kn.l0.o(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
        n1Var.p(strSubstring);
    }

    public static final void h(n1 n1Var, String str, int i10, int i11) {
        int iP3 = jq.h0.p3(str, "@", i10, false, 4, null);
        if (iP3 == -1) {
            throw new IllegalArgumentException(n.a.a("Invalid mailto url: ", str, ", it should contain '@'."));
        }
        String strSubstring = str.substring(i10, iP3);
        kn.l0.o(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
        n1Var.f8124d = e.i(strSubstring, 0, 0, null, 7, null);
        String strSubstring2 = str.substring(iP3 + 1, i11);
        kn.l0.o(strSubstring2, "this as java.lang.String…ing(startIndex, endIndex)");
        n1Var.q(strSubstring2);
    }

    public static final int i(n1 n1Var, String str, int i10, int i11) {
        int i12 = i10 + 1;
        if (i12 == i11) {
            n1Var.f8129i = true;
            return i11;
        }
        Integer numValueOf = Integer.valueOf(jq.h0.o3(str, '#', i12, false, 4, null));
        if (numValueOf.intValue() <= 0) {
            numValueOf = null;
        }
        if (numValueOf != null) {
            i11 = numValueOf.intValue();
        }
        c1 c1Var = n1Var.f8127g;
        String strSubstring = str.substring(i12, i11);
        kn.l0.o(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
        h1.f(c1Var, strSubstring, 0, 0, 12, null);
        return i11;
    }

    @os.l
    public static final n1 j(@os.l n1 n1Var, @os.l String str) {
        kn.l0.p(n1Var, "<this>");
        kn.l0.p(str, "urlString");
        try {
            return k(n1Var, str);
        } catch (Throwable th2) {
            throw new r1(str, th2);
        }
    }

    @os.l
    public static final n1 k(@os.l n1 n1Var, @os.l String str) {
        int i10;
        int i11;
        kn.l0.p(n1Var, "<this>");
        kn.l0.p(str, "urlString");
        int length = str.length();
        int i12 = 0;
        while (true) {
            if (i12 >= length) {
                i12 = -1;
                break;
            }
            int i13 = i12 + 1;
            if (!jq.d.r(str.charAt(i12))) {
                break;
            }
            i12 = i13;
        }
        int length2 = str.length() - 1;
        if (length2 < 0) {
            i10 = -1;
            break;
        }
        while (true) {
            int i14 = length2 - 1;
            if (!jq.d.r(str.charAt(length2))) {
                i10 = length2;
                break;
            }
            if (i14 < 0) {
                i10 = -1;
                break;
            }
            length2 = i14;
        }
        int i15 = i10 + 1;
        int iC = c(str, i12, i15);
        if (iC > 0) {
            String strSubstring = str.substring(i12, i12 + iC);
            kn.l0.o(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
            n1Var.t(t1.f8189c.a(strSubstring));
            i12 += iC + 1;
        }
        int iA = a(str, i12, i15, el.b0.f4502a);
        int iIntValue = i12 + iA;
        if (kn.l0.g(n1Var.f8121a.f8196a, "file")) {
            f(n1Var, str, iIntValue, i15, iA);
            return n1Var;
        }
        if (kn.l0.g(n1Var.f8121a.f8196a, "mailto")) {
            if (iA != 0) {
                throw new IllegalArgumentException("Failed requirement.");
            }
            h(n1Var, str, iIntValue, i15);
            return n1Var;
        }
        if (iA >= 2) {
            int i16 = iIntValue;
            while (true) {
                i11 = i16;
                Integer numValueOf = Integer.valueOf(jq.h0.t3(str, fl.r.b("@/\\?#"), i16, false, 4, null));
                if (numValueOf.intValue() <= 0) {
                    numValueOf = null;
                }
                iIntValue = numValueOf == null ? i15 : numValueOf.intValue();
                if (iIntValue >= i15 || str.charAt(iIntValue) != '@') {
                    break;
                }
                int iD = d(str, i11, iIntValue);
                if (iD != -1) {
                    String strSubstring2 = str.substring(i11, iD);
                    kn.l0.o(strSubstring2, "this as java.lang.String…ing(startIndex, endIndex)");
                    n1Var.f8124d = e.i(strSubstring2, 0, 0, null, 7, null);
                    String strSubstring3 = str.substring(iD + 1, iIntValue);
                    kn.l0.o(strSubstring3, "this as java.lang.String…ing(startIndex, endIndex)");
                    n1Var.f8125e = e.i(strSubstring3, 0, 0, null, 7, null);
                } else {
                    String strSubstring4 = str.substring(i11, iIntValue);
                    kn.l0.o(strSubstring4, "this as java.lang.String…ing(startIndex, endIndex)");
                    n1Var.f8124d = e.i(strSubstring4, 0, 0, null, 7, null);
                }
                i16 = iIntValue + 1;
            }
            b(n1Var, str, i11, iIntValue);
        }
        int i17 = iIntValue;
        String strSubstring5 = "";
        if (i17 >= i15) {
            n1Var.o(str.charAt(i10) == '/' ? "/" : "");
            return n1Var;
        }
        if (iA == 0) {
            int iC3 = jq.h0.C3(n1Var.f8126f, el.b0.f4502a, 0, false, 6, null);
            if (iC3 == n1Var.f8126f.length() - 1) {
                strSubstring5 = n1Var.f8126f;
            } else if (iC3 != -1) {
                strSubstring5 = n1Var.f8126f.substring(0, iC3 + 1);
                kn.l0.o(strSubstring5, "this as java.lang.String…ing(startIndex, endIndex)");
            } else {
                strSubstring5 = "/";
            }
        }
        n1Var.o(strSubstring5);
        Integer numValueOf2 = Integer.valueOf(jq.h0.t3(str, fl.r.b("?#"), i17, false, 4, null));
        if (numValueOf2.intValue() <= 0) {
            numValueOf2 = null;
        }
        int iIntValue2 = numValueOf2 == null ? i15 : numValueOf2.intValue();
        String strSubstring6 = str.substring(i17, iIntValue2);
        kn.l0.o(strSubstring6, "this as java.lang.String…ing(startIndex, endIndex)");
        n1Var.o(kn.l0.C(n1Var.f8126f, e.p(strSubstring6)));
        if (iIntValue2 < i15 && str.charAt(iIntValue2) == '?') {
            iIntValue2 = i(n1Var, str, iIntValue2, i15);
        }
        g(n1Var, str, iIntValue2, i15);
        return n1Var;
    }
}
