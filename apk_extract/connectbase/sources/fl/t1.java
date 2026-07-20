package fl;

/* JADX INFO: loaded from: classes2.dex */
public final class t1 {
    @os.l
    public static final q a(@os.l String str) {
        kn.l0.p(str, "<this>");
        return new q(str);
    }

    @os.l
    public static final lm.t0<String, String> b(@os.l String str, @os.l String str2, @os.l jn.a<lm.t0<String, String>> aVar) {
        kn.l0.p(str, "<this>");
        kn.l0.p(str2, "separator");
        kn.l0.p(aVar, "onMissingDelimiter");
        int iP3 = jq.h0.p3(str, str2, 0, false, 6, null);
        if (iP3 == -1) {
            return aVar.invoke();
        }
        String strSubstring = str.substring(0, iP3);
        kn.l0.o(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
        String strSubstring2 = str.substring(iP3 + 1);
        kn.l0.o(strSubstring2, "this as java.lang.String).substring(startIndex)");
        return new lm.t0<>(strSubstring, strSubstring2);
    }

    @os.l
    public static final String c(@os.l String str) {
        kn.l0.p(str, "<this>");
        if (str.length() == 0) {
            return str;
        }
        StringBuilder sb2 = new StringBuilder(str.length());
        int length = str.length();
        int i10 = 0;
        while (i10 < length) {
            int i11 = i10 + 1;
            char cCharAt = str.charAt(i10);
            if (cCharAt == '\'') {
                sb2.append("&#x27;");
            } else if (cCharAt == '\"') {
                sb2.append("&quot;");
            } else if (cCharAt == '&') {
                sb2.append("&amp;");
            } else if (cCharAt == '<') {
                sb2.append("&lt;");
            } else if (cCharAt == '>') {
                sb2.append("&gt;");
            } else {
                sb2.append(cCharAt);
            }
            i10 = i11;
        }
        String string = sb2.toString();
        kn.l0.o(string, "StringBuilder(capacity).…builderAction).toString()");
        return string;
    }

    public static final char d(char c10) {
        if ('A' > c10 || c10 >= '[') {
            return (c10 < 0 || c10 >= 128) ? Character.toLowerCase(c10) : c10;
        }
        return (char) (c10 + ' ');
    }

    @t0
    @os.l
    public static final String e(@os.l String str) {
        kn.l0.p(str, "<this>");
        int length = str.length();
        int i10 = 0;
        while (true) {
            if (i10 >= length) {
                i10 = -1;
                break;
            }
            int i11 = i10 + 1;
            char cCharAt = str.charAt(i10);
            if (d(cCharAt) != cCharAt) {
                break;
            }
            i10 = i11;
        }
        if (i10 == -1) {
            return str;
        }
        StringBuilder sb2 = new StringBuilder(str.length());
        sb2.append((CharSequence) str, 0, i10);
        int iG3 = jq.h0.g3(str);
        if (i10 <= iG3) {
            while (true) {
                int i12 = i10 + 1;
                sb2.append(d(str.charAt(i10)));
                if (i10 == iG3) {
                    break;
                }
                i10 = i12;
            }
        }
        String string = sb2.toString();
        kn.l0.o(string, "StringBuilder(capacity).…builderAction).toString()");
        return string;
    }

    public static final char f(char c10) {
        if ('a' > c10 || c10 >= '{') {
            return (c10 < 0 || c10 >= 128) ? Character.toLowerCase(c10) : c10;
        }
        return (char) (c10 - ' ');
    }

    @t0
    @os.l
    public static final String g(@os.l String str) {
        kn.l0.p(str, "<this>");
        int length = str.length();
        int i10 = 0;
        while (true) {
            if (i10 >= length) {
                i10 = -1;
                break;
            }
            int i11 = i10 + 1;
            char cCharAt = str.charAt(i10);
            if (f(cCharAt) != cCharAt) {
                break;
            }
            i10 = i11;
        }
        if (i10 == -1) {
            return str;
        }
        StringBuilder sb2 = new StringBuilder(str.length());
        sb2.append((CharSequence) str, 0, i10);
        int iG3 = jq.h0.g3(str);
        if (i10 <= iG3) {
            while (true) {
                int i12 = i10 + 1;
                sb2.append(f(str.charAt(i10)));
                if (i10 == iG3) {
                    break;
                }
                i10 = i12;
            }
        }
        String string = sb2.toString();
        kn.l0.o(string, "StringBuilder(capacity).…builderAction).toString()");
        return string;
    }
}
