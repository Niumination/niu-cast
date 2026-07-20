package tj;

import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class n {
    public static String a(String str, String str2) throws sj.c {
        StringBuilder sb2 = new StringBuilder();
        int i10 = 0;
        for (char c10 : str.substring(str2.length(), str.length()).toCharArray()) {
            if (c10 == '_') {
                i10++;
            } else {
                if (i10 > 0 && i10 < 4) {
                    sb2.append(n(i10));
                } else if (i10 > 3) {
                    throw new sj.c.b(str, "Environment variable contains an un-mapped number of underscores.");
                }
                sb2.append(c10);
                i10 = 0;
            }
        }
        if (i10 > 0 && i10 < 4) {
            sb2.append(n(i10));
        } else if (i10 > 3) {
            throw new sj.c.b(str, "Environment variable contains an un-mapped number of underscores.");
        }
        return sb2.toString();
    }

    public static boolean b(Object obj, Object obj2) {
        if (obj == null && obj2 != null) {
            return false;
        }
        if (obj != null && obj2 == null) {
            return false;
        }
        if (obj == obj2) {
            return true;
        }
        return obj.equals(obj2);
    }

    public static sj.c c(ExceptionInInitializerError exceptionInInitializerError) {
        Throwable cause = exceptionInInitializerError.getCause();
        if (cause == null || !(cause instanceof sj.c)) {
            throw exceptionInInitializerError;
        }
        return (sj.c) cause;
    }

    public static boolean d(int i10) {
        return i10 >= 0 && i10 <= 31;
    }

    public static boolean e(int i10) {
        if (i10 == 10 || i10 == 32 || i10 == 160 || i10 == 8199 || i10 == 8239 || i10 == 65279) {
            return true;
        }
        return Character.isWhitespace(i10);
    }

    public static String f(List<String> list) {
        return g((String[]) list.toArray(new String[0]));
    }

    public static String g(String... strArr) {
        return new p0(strArr).k();
    }

    public static sj.o h(ObjectInputStream objectInputStream) throws IOException {
        return z0.readOrigin(objectInputStream, null);
    }

    public static String i(String str) {
        StringBuilder sb2 = new StringBuilder("\"");
        for (int i10 = 0; i10 < str.length(); i10++) {
            char cCharAt = str.charAt(i10);
            if (cCharAt == '\f') {
                sb2.append("\\f");
            } else if (cCharAt == '\r') {
                sb2.append("\\r");
            } else if (cCharAt == '\"') {
                sb2.append("\\\"");
            } else if (cCharAt != '\\') {
                switch (cCharAt) {
                    case '\b':
                        sb2.append("\\b");
                        break;
                    case '\t':
                        sb2.append("\\t");
                        break;
                    case '\n':
                        sb2.append("\\n");
                        break;
                    default:
                        if (d(cCharAt)) {
                            sb2.append(String.format("\\u%04x", Integer.valueOf(cCharAt)));
                        } else {
                            sb2.append(cCharAt);
                        }
                        break;
                }
            } else {
                sb2.append("\\\\");
            }
        }
        sb2.append('\"');
        return sb2.toString();
    }

    public static String j(String str) {
        if (str.length() == 0) {
            return i(str);
        }
        int iCodePointAt = str.codePointAt(0);
        if (Character.isDigit(iCodePointAt) || iCodePointAt == 45) {
            return i(str);
        }
        if (str.startsWith("include") || str.startsWith("true") || str.startsWith("false") || str.startsWith(d6.a.E) || str.contains("//")) {
            return i(str);
        }
        for (int i10 = 0; i10 < str.length(); i10++) {
            char cCharAt = str.charAt(i10);
            if (!Character.isLetter(cCharAt) && !Character.isDigit(cCharAt) && cCharAt != '-') {
                return i(str);
            }
        }
        return str;
    }

    public static List<String> k(String str) {
        ArrayList arrayList = new ArrayList();
        for (p0 p0VarD = r0.d(str); p0VarD != null; p0VarD = p0VarD.f15727b) {
            arrayList.add(p0VarD.f15726a);
        }
        return arrayList;
    }

    public static sj.v l(String str) {
        if (str == null) {
            return null;
        }
        if (str.endsWith(".json")) {
            return sj.v.JSON;
        }
        if (str.endsWith(".conf")) {
            return sj.v.CONF;
        }
        if (str.endsWith(".properties")) {
            return sj.v.PROPERTIES;
        }
        return null;
    }

    public static String m(String str) {
        String[] strArrSplit = str.split("-+");
        StringBuilder sb2 = new StringBuilder(str.length());
        for (String str2 : strArrSplit) {
            if (sb2.length() == 0) {
                sb2.append(str2);
            } else {
                sb2.append(str2.substring(0, 1).toUpperCase());
                sb2.append(str2.substring(1));
            }
        }
        return sb2.toString();
    }

    public static char n(int i10) {
        if (i10 == 1) {
            return n1.e.f11183c;
        }
        if (i10 != 2) {
            return i10 != 3 ? (char) 0 : '_';
        }
        return '-';
    }

    public static String o(String str) {
        int iCodePointAt;
        int i10;
        int length = str.length();
        if (length == 0) {
            return str;
        }
        int iCharCount = 0;
        while (iCharCount < length) {
            char cCharAt = str.charAt(iCharCount);
            if (cCharAt != ' ' && cCharAt != '\n') {
                int iCodePointAt2 = str.codePointAt(iCharCount);
                if (!e(iCodePointAt2)) {
                    break;
                }
                iCharCount = Character.charCount(iCodePointAt2) + iCharCount;
            } else {
                iCharCount++;
            }
        }
        while (length > iCharCount) {
            int i11 = length - 1;
            char cCharAt2 = str.charAt(i11);
            if (cCharAt2 != ' ' && cCharAt2 != '\n') {
                if (Character.isLowSurrogate(cCharAt2)) {
                    iCodePointAt = str.codePointAt(length - 2);
                    i10 = 2;
                } else {
                    iCodePointAt = str.codePointAt(i11);
                    i10 = 1;
                }
                if (!e(iCodePointAt)) {
                    break;
                }
                length -= i10;
            } else {
                length--;
            }
        }
        return str.substring(iCharCount, length);
    }

    public static File p(URL url) {
        try {
            return new File(url.toURI());
        } catch (IllegalArgumentException unused) {
            return new File(url.getPath());
        } catch (URISyntaxException unused2) {
            return new File(url.getPath());
        }
    }

    public static void q(ObjectOutputStream objectOutputStream, sj.o oVar) throws IOException {
        z0.writeOrigin(new DataOutputStream(objectOutputStream), (g1) oVar, null);
    }
}
