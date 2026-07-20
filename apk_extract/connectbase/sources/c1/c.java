package c1;

/* JADX INFO: loaded from: classes.dex */
@b1.b
@k
public final class c {
    public static final byte A = 23;
    public static final byte B = 24;
    public static final byte C = 25;
    public static final byte D = 26;
    public static final byte E = 27;
    public static final byte F = 28;
    public static final byte G = 29;
    public static final byte H = 30;
    public static final byte I = 31;
    public static final byte J = 32;
    public static final byte K = 32;
    public static final byte L = 127;
    public static final char M = 0;
    public static final char N = 127;
    public static final char O = ' ';

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final byte f1107a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final byte f1108b = 1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final byte f1109c = 2;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final byte f1110d = 3;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final byte f1111e = 4;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final byte f1112f = 5;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final byte f1113g = 6;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final byte f1114h = 7;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final byte f1115i = 8;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final byte f1116j = 9;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final byte f1117k = 10;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final byte f1118l = 10;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final byte f1119m = 11;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final byte f1120n = 12;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final byte f1121o = 13;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final byte f1122p = 14;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final byte f1123q = 15;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final byte f1124r = 16;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final byte f1125s = 17;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final byte f1126t = 17;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final byte f1127u = 18;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final byte f1128v = 19;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final byte f1129w = 19;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final byte f1130x = 20;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final byte f1131y = 21;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final byte f1132z = 22;

    public static boolean a(CharSequence s10, CharSequence s11) {
        int iB;
        int length = s10.length();
        if (s10 == s11) {
            return true;
        }
        if (length != s11.length()) {
            return false;
        }
        for (int i10 = 0; i10 < length; i10++) {
            char cCharAt = s10.charAt(i10);
            char cCharAt2 = s11.charAt(i10);
            if (cCharAt != cCharAt2 && ((iB = b(cCharAt)) >= 26 || iB != b(cCharAt2))) {
                return false;
            }
        }
        return true;
    }

    public static int b(char c10) {
        return (char) ((c10 | ' ') - 97);
    }

    public static boolean c(char c10) {
        return c10 >= 'a' && c10 <= 'z';
    }

    public static boolean d(char c10) {
        return c10 >= 'A' && c10 <= 'Z';
    }

    public static char e(char c10) {
        return d(c10) ? (char) (c10 ^ ' ') : c10;
    }

    public static String f(CharSequence chars) {
        if (chars instanceof String) {
            return g((String) chars);
        }
        int length = chars.length();
        char[] cArr = new char[length];
        for (int i10 = 0; i10 < length; i10++) {
            cArr[i10] = e(chars.charAt(i10));
        }
        return String.valueOf(cArr);
    }

    public static String g(String string) {
        int length = string.length();
        int i10 = 0;
        while (i10 < length) {
            if (d(string.charAt(i10))) {
                char[] charArray = string.toCharArray();
                while (i10 < length) {
                    char c10 = charArray[i10];
                    if (d(c10)) {
                        charArray[i10] = (char) (c10 ^ ' ');
                    }
                    i10++;
                }
                return String.valueOf(charArray);
            }
            i10++;
        }
        return string;
    }

    public static char h(char c10) {
        return c(c10) ? (char) (c10 ^ ' ') : c10;
    }

    public static String i(CharSequence chars) {
        if (chars instanceof String) {
            return j((String) chars);
        }
        int length = chars.length();
        char[] cArr = new char[length];
        for (int i10 = 0; i10 < length; i10++) {
            cArr[i10] = h(chars.charAt(i10));
        }
        return String.valueOf(cArr);
    }

    public static String j(String string) {
        int length = string.length();
        int i10 = 0;
        while (i10 < length) {
            if (c(string.charAt(i10))) {
                char[] charArray = string.toCharArray();
                while (i10 < length) {
                    char c10 = charArray[i10];
                    if (c(c10)) {
                        charArray[i10] = (char) (c10 ^ ' ');
                    }
                    i10++;
                }
                return String.valueOf(charArray);
            }
            i10++;
        }
        return string;
    }

    public static String k(CharSequence charSequence, int i10, String str) {
        String string;
        charSequence.getClass();
        int length = i10 - str.length();
        h0.m(length >= 0, "maxLength (%s) must be >= length of the truncation indicator (%s)", i10, str.length());
        int length2 = charSequence.length();
        CharSequence charSequence2 = charSequence;
        if (length2 <= i10) {
            string = charSequence.toString();
            if (string.length() <= i10) {
                charSequence2 = string;
                return string;
            }
        }
        charSequence2 = string;
        StringBuilder sb2 = new StringBuilder(i10);
        sb2.append(charSequence2, 0, length);
        sb2.append(str);
        return sb2.toString();
    }
}
