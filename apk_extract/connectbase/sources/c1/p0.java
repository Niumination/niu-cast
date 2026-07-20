package c1;

import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes.dex */
@b1.b
@k
public final class p0 {
    public static String a(CharSequence a10, CharSequence b10) {
        a10.getClass();
        b10.getClass();
        int iMin = Math.min(a10.length(), b10.length());
        int i10 = 0;
        while (i10 < iMin && a10.charAt(i10) == b10.charAt(i10)) {
            i10++;
        }
        int i11 = i10 - 1;
        if (k(a10, i11) || k(b10, i11)) {
            i10--;
        }
        return a10.subSequence(0, i10).toString();
    }

    public static String b(CharSequence a10, CharSequence b10) {
        a10.getClass();
        b10.getClass();
        int iMin = Math.min(a10.length(), b10.length());
        int i10 = 0;
        while (i10 < iMin && a10.charAt((a10.length() - i10) - 1) == b10.charAt((b10.length() - i10) - 1)) {
            i10++;
        }
        if (k(a10, (a10.length() - i10) - 1) || k(b10, (b10.length() - i10) - 1)) {
            i10--;
        }
        return a10.subSequence(a10.length() - i10, a10.length()).toString();
    }

    @gm.a
    public static String c(@gm.a String string) {
        return g0.b(string);
    }

    public static boolean d(@gm.a String string) {
        return g0.j(string);
    }

    public static String e(@gm.a String template, @gm.a Object... args) {
        int iIndexOf;
        String strValueOf = String.valueOf(template);
        int i10 = 0;
        if (args == null) {
            args = new Object[]{"(Object[])null"};
        } else {
            for (int i11 = 0; i11 < args.length; i11++) {
                args[i11] = f(args[i11]);
            }
        }
        StringBuilder sb2 = new StringBuilder((args.length * 16) + strValueOf.length());
        int i12 = 0;
        while (i10 < args.length && (iIndexOf = strValueOf.indexOf("%s", i12)) != -1) {
            sb2.append((CharSequence) strValueOf, i12, iIndexOf);
            sb2.append(args[i10]);
            i12 = iIndexOf + 2;
            i10++;
        }
        sb2.append((CharSequence) strValueOf, i12, strValueOf.length());
        if (i10 < args.length) {
            sb2.append(" [");
            sb2.append(args[i10]);
            for (int i13 = i10 + 1; i13 < args.length; i13++) {
                sb2.append(", ");
                sb2.append(args[i13]);
            }
            sb2.append(']');
        }
        return sb2.toString();
    }

    public static String f(@gm.a Object o10) {
        if (o10 == null) {
            return d6.a.E;
        }
        try {
            return o10.toString();
        } catch (Exception e10) {
            String str = o10.getClass().getName() + '@' + Integer.toHexString(System.identityHashCode(o10));
            Logger.getLogger("com.google.common.base.Strings").log(Level.WARNING, "Exception during lenientFormat for " + str, (Throwable) e10);
            StringBuilder sbA = e.a.a("<", str, " threw ");
            sbA.append(e10.getClass().getName());
            sbA.append(">");
            return sbA.toString();
        }
    }

    public static String g(@gm.a String string) {
        return g0.g(string);
    }

    public static String h(String string, int minLength, char padChar) {
        string.getClass();
        if (string.length() >= minLength) {
            return string;
        }
        StringBuilder sb2 = new StringBuilder(minLength);
        sb2.append(string);
        for (int length = string.length(); length < minLength; length++) {
            sb2.append(padChar);
        }
        return sb2.toString();
    }

    public static String i(String string, int minLength, char padChar) {
        string.getClass();
        if (string.length() >= minLength) {
            return string;
        }
        StringBuilder sb2 = new StringBuilder(minLength);
        for (int length = string.length(); length < minLength; length++) {
            sb2.append(padChar);
        }
        sb2.append(string);
        return sb2.toString();
    }

    public static String j(String string, int count) {
        string.getClass();
        if (count <= 1) {
            h0.k(count >= 0, "invalid count: %s", count);
            return count == 0 ? "" : string;
        }
        int length = string.length();
        long j10 = ((long) length) * ((long) count);
        int i10 = (int) j10;
        if (i10 != j10) {
            throw new ArrayIndexOutOfBoundsException(h0.b.a("Required array size too large: ", j10));
        }
        char[] cArr = new char[i10];
        string.getChars(0, length, cArr, 0);
        while (true) {
            int i11 = i10 - length;
            if (length >= i11) {
                System.arraycopy(cArr, 0, cArr, length, i11);
                return new String(cArr);
            }
            System.arraycopy(cArr, 0, cArr, length, length);
            length <<= 1;
        }
    }

    @b1.e
    public static boolean k(CharSequence string, int index) {
        return index >= 0 && index <= string.length() + (-2) && Character.isHighSurrogate(string.charAt(index)) && Character.isLowSurrogate(string.charAt(index + 1));
    }
}
