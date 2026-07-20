package ej;

import dj.b0;
import dj.j0;
import dj.l0;
import dj.s;
import dj.u;
import dj.x;
import java.io.Closeable;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;
import k3.tc;
import k3.v1;
import kj.d;
import kotlin.ExceptionsKt;
import kotlin.UByte;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.Regex;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import qj.f;
import qj.i;
import qj.j;
import qj.p;
import qj.t;
import qj.z;

/* JADX INFO: loaded from: classes3.dex */
public abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final byte[] f4964a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final s f4965b = v1.c(new String[0]);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final l0 f4966c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final p f4967d;
    public static final TimeZone e;
    public static final Regex f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final String f4968g;

    static {
        byte[] toRequestBody = new byte[0];
        f4964a = toRequestBody;
        Intrinsics.checkNotNullParameter(toRequestBody, "$this$toResponseBody");
        f asResponseBody = new f();
        Intrinsics.checkNotNullParameter(toRequestBody, "source");
        asResponseBody.L(toRequestBody, 0, 0);
        long j8 = 0;
        Intrinsics.checkNotNullParameter(asResponseBody, "$this$asResponseBody");
        f4966c = new l0(asResponseBody, (x) null, j8);
        Intrinsics.checkNotNullParameter(toRequestBody, "$this$toRequestBody");
        c(j8, j8, j8);
        int i8 = p.f9208c;
        j.Companion.getClass();
        f4967d = tc.b(i.a("efbbbf"), i.a("feff"), i.a("fffe"), i.a("0000ffff"), i.a("ffff0000"));
        TimeZone timeZone = TimeZone.getTimeZone("GMT");
        Intrinsics.checkNotNull(timeZone);
        e = timeZone;
        f = new Regex("([0-9a-fA-F]*:[0-9a-fA-F:.]*)|([\\d.]+)");
        String name = b0.class.getName();
        Intrinsics.checkNotNullExpressionValue(name, "OkHttpClient::class.java.name");
        f4968g = StringsKt__StringsKt.removeSuffix(StringsKt__StringsKt.removePrefix(name, (CharSequence) "okhttp3."), (CharSequence) "Client");
    }

    public static final boolean a(u canReuseConnectionFor, u other) {
        Intrinsics.checkNotNullParameter(canReuseConnectionFor, "$this$canReuseConnectionFor");
        Intrinsics.checkNotNullParameter(other, "other");
        return Intrinsics.areEqual(canReuseConnectionFor.e, other.e) && canReuseConnectionFor.f == other.f && Intrinsics.areEqual(canReuseConnectionFor.f4634b, other.f4634b);
    }

    public static final int b(long j8, TimeUnit timeUnit) {
        Intrinsics.checkNotNullParameter("timeout", "name");
        if (j8 < 0) {
            throw new IllegalStateException("timeout < 0".toString());
        }
        if (timeUnit == null) {
            throw new IllegalStateException("unit == null");
        }
        long millis = timeUnit.toMillis(j8);
        if (millis > Integer.MAX_VALUE) {
            throw new IllegalArgumentException("timeout too large.".toString());
        }
        if (millis != 0 || j8 <= 0) {
            return (int) millis;
        }
        throw new IllegalArgumentException("timeout too small.".toString());
    }

    public static final void c(long j8, long j10, long j11) {
        if ((j10 | j11) < 0 || j10 > j8 || j8 - j10 < j11) {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    public static final void d(Closeable closeQuietly) {
        Intrinsics.checkNotNullParameter(closeQuietly, "$this$closeQuietly");
        try {
            closeQuietly.close();
        } catch (RuntimeException e4) {
            throw e4;
        } catch (Exception unused) {
        }
    }

    public static final void e(Socket closeQuietly) {
        Intrinsics.checkNotNullParameter(closeQuietly, "$this$closeQuietly");
        try {
            closeQuietly.close();
        } catch (AssertionError e4) {
            throw e4;
        } catch (RuntimeException e10) {
            if (!Intrinsics.areEqual(e10.getMessage(), "bio == null")) {
                throw e10;
            }
        } catch (Exception unused) {
        }
    }

    public static final int f(int i8, int i9, String delimiterOffset, String delimiters) {
        Intrinsics.checkNotNullParameter(delimiterOffset, "$this$delimiterOffset");
        Intrinsics.checkNotNullParameter(delimiters, "delimiters");
        while (i8 < i9) {
            if (StringsKt__StringsKt.contains$default(delimiters, delimiterOffset.charAt(i8), false, 2, (Object) null)) {
                return i8;
            }
            i8++;
        }
        return i9;
    }

    public static final int g(String delimiterOffset, char c9, int i8, int i9) {
        Intrinsics.checkNotNullParameter(delimiterOffset, "$this$delimiterOffset");
        while (i8 < i9) {
            if (delimiterOffset.charAt(i8) == c9) {
                return i8;
            }
            i8++;
        }
        return i9;
    }

    public static final boolean h(z discard, TimeUnit timeUnit) {
        Intrinsics.checkNotNullParameter(discard, "$this$discard");
        Intrinsics.checkNotNullParameter(timeUnit, "timeUnit");
        try {
            return t(discard, 100, timeUnit);
        } catch (IOException unused) {
            return false;
        }
    }

    public static final String i(String format, Object... args) {
        Intrinsics.checkNotNullParameter(format, "format");
        Intrinsics.checkNotNullParameter(args, "args");
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        Locale locale = Locale.US;
        Object[] objArrCopyOf = Arrays.copyOf(args, args.length);
        String str = String.format(locale, format, Arrays.copyOf(objArrCopyOf, objArrCopyOf.length));
        Intrinsics.checkNotNullExpressionValue(str, "java.lang.String.format(locale, format, *args)");
        return str;
    }

    public static final boolean j(String[] hasIntersection, String[] strArr, Comparator comparator) {
        Intrinsics.checkNotNullParameter(hasIntersection, "$this$hasIntersection");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        if (hasIntersection.length != 0 && strArr != null && strArr.length != 0) {
            for (String str : hasIntersection) {
                for (String str2 : strArr) {
                    if (comparator.compare(str, str2) == 0) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static final long k(j0 headersContentLength) {
        Intrinsics.checkNotNullParameter(headersContentLength, "$this$headersContentLength");
        String toLongOrDefault = headersContentLength.f4580h.e("Content-Length");
        if (toLongOrDefault == null) {
            return -1L;
        }
        Intrinsics.checkNotNullParameter(toLongOrDefault, "$this$toLongOrDefault");
        try {
            return Long.parseLong(toLongOrDefault);
        } catch (NumberFormatException unused) {
            return -1L;
        }
    }

    public static final List l(Object... elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        Object[] objArr = (Object[]) elements.clone();
        List listUnmodifiableList = Collections.unmodifiableList(CollectionsKt.listOf(Arrays.copyOf(objArr, objArr.length)));
        Intrinsics.checkNotNullExpressionValue(listUnmodifiableList, "Collections.unmodifiable…istOf(*elements.clone()))");
        return listUnmodifiableList;
    }

    public static final int m(String indexOfControlOrNonAscii) {
        Intrinsics.checkNotNullParameter(indexOfControlOrNonAscii, "$this$indexOfControlOrNonAscii");
        int length = indexOfControlOrNonAscii.length();
        for (int i8 = 0; i8 < length; i8++) {
            char cCharAt = indexOfControlOrNonAscii.charAt(i8);
            if (Intrinsics.compare((int) cCharAt, 31) <= 0 || Intrinsics.compare((int) cCharAt, 127) >= 0) {
                return i8;
            }
        }
        return -1;
    }

    public static final int n(int i8, int i9, String indexOfFirstNonAsciiWhitespace) {
        Intrinsics.checkNotNullParameter(indexOfFirstNonAsciiWhitespace, "$this$indexOfFirstNonAsciiWhitespace");
        while (i8 < i9) {
            char cCharAt = indexOfFirstNonAsciiWhitespace.charAt(i8);
            if (cCharAt != '\t' && cCharAt != '\n' && cCharAt != '\f' && cCharAt != '\r' && cCharAt != ' ') {
                return i8;
            }
            i8++;
        }
        return i9;
    }

    public static final int o(int i8, int i9, String indexOfLastNonAsciiWhitespace) {
        Intrinsics.checkNotNullParameter(indexOfLastNonAsciiWhitespace, "$this$indexOfLastNonAsciiWhitespace");
        int i10 = i9 - 1;
        if (i10 >= i8) {
            while (true) {
                char cCharAt = indexOfLastNonAsciiWhitespace.charAt(i10);
                if (cCharAt != '\t' && cCharAt != '\n' && cCharAt != '\f' && cCharAt != '\r' && cCharAt != ' ') {
                    return i10 + 1;
                }
                if (i10 == i8) {
                    break;
                }
                i10--;
            }
        }
        return i8;
    }

    public static final String[] p(String[] intersect, String[] other, Comparator comparator) {
        Intrinsics.checkNotNullParameter(intersect, "$this$intersect");
        Intrinsics.checkNotNullParameter(other, "other");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        ArrayList arrayList = new ArrayList();
        for (String str : intersect) {
            for (String str2 : other) {
                if (comparator.compare(str, str2) == 0) {
                    arrayList.add(str);
                    break;
                }
            }
        }
        Object[] array = arrayList.toArray(new String[0]);
        if (array != null) {
            return (String[]) array;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
    }

    public static final boolean q(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        return StringsKt__StringsJVMKt.equals(name, "Authorization", true) || StringsKt__StringsJVMKt.equals(name, "Cookie", true) || StringsKt__StringsJVMKt.equals(name, "Proxy-Authorization", true) || StringsKt__StringsJVMKt.equals(name, "Set-Cookie", true);
    }

    public static final int r(char c9) {
        if ('0' <= c9 && '9' >= c9) {
            return c9 - '0';
        }
        if ('a' <= c9 && 'f' >= c9) {
            return c9 - 'W';
        }
        if ('A' <= c9 && 'F' >= c9) {
            return c9 - '7';
        }
        return -1;
    }

    public static final int s(t readMedium) {
        Intrinsics.checkNotNullParameter(readMedium, "$this$readMedium");
        return (readMedium.readByte() & UByte.MAX_VALUE) | ((readMedium.readByte() & UByte.MAX_VALUE) << 16) | ((readMedium.readByte() & UByte.MAX_VALUE) << 8);
    }

    public static final boolean t(z skipAll, int i8, TimeUnit timeUnit) {
        Intrinsics.checkNotNullParameter(skipAll, "$this$skipAll");
        Intrinsics.checkNotNullParameter(timeUnit, "timeUnit");
        long jNanoTime = System.nanoTime();
        long jC = skipAll.b().e() ? skipAll.b().c() - jNanoTime : Long.MAX_VALUE;
        skipAll.b().d(Math.min(jC, timeUnit.toNanos(i8)) + jNanoTime);
        try {
            f fVar = new f();
            while (skipAll.W(fVar, 8192L) != -1) {
                fVar.a();
            }
            if (jC == Long.MAX_VALUE) {
                skipAll.b().a();
            } else {
                skipAll.b().d(jNanoTime + jC);
            }
            return true;
        } catch (InterruptedIOException unused) {
            if (jC == Long.MAX_VALUE) {
                skipAll.b().a();
            } else {
                skipAll.b().d(jNanoTime + jC);
            }
            return false;
        } catch (Throwable th2) {
            if (jC == Long.MAX_VALUE) {
                skipAll.b().a();
            } else {
                skipAll.b().d(jNanoTime + jC);
            }
            throw th2;
        }
    }

    public static final s u(List toHeaders) {
        Intrinsics.checkNotNullParameter(toHeaders, "$this$toHeaders");
        ArrayList arrayList = new ArrayList(20);
        Iterator it = toHeaders.iterator();
        while (it.hasNext()) {
            d dVar = (d) it.next();
            String name = dVar.f6900b.utf8();
            String value = dVar.f6901c.utf8();
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(value, "value");
            arrayList.add(name);
            arrayList.add(StringsKt__StringsKt.trim((CharSequence) value).toString());
        }
        Object[] array = arrayList.toArray(new String[0]);
        if (array != null) {
            return new s((String[]) array);
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
    }

    /* JADX WARN: Code duplicated, block: B:18:0x0054  */
    public static final String v(u toHostHeader, boolean z2) {
        int i8;
        Intrinsics.checkNotNullParameter(toHostHeader, "$this$toHostHeader");
        boolean zContains$default = StringsKt__StringsKt.contains$default(toHostHeader.e, ":", false, 2, (Object) null);
        String str = toHostHeader.e;
        if (zContains$default) {
            str = "[" + str + ']';
        }
        int i9 = toHostHeader.f;
        if (!z2) {
            String scheme = toHostHeader.f4634b;
            Intrinsics.checkNotNullParameter(scheme, "scheme");
            int iHashCode = scheme.hashCode();
            if (iHashCode != 3213448) {
                if (iHashCode == 99617003 && scheme.equals("https")) {
                    i8 = 443;
                } else {
                    i8 = -1;
                }
            } else if (scheme.equals("http")) {
                i8 = 80;
            } else {
                i8 = -1;
            }
            if (i9 == i8) {
                return str;
            }
        }
        return str + ':' + i9;
    }

    public static final List w(List toImmutableList) {
        Intrinsics.checkNotNullParameter(toImmutableList, "$this$toImmutableList");
        List listUnmodifiableList = Collections.unmodifiableList(CollectionsKt.toMutableList((Collection) toImmutableList));
        Intrinsics.checkNotNullExpressionValue(listUnmodifiableList, "Collections.unmodifiableList(toMutableList())");
        return listUnmodifiableList;
    }

    public static final int x(int i8, String str) {
        if (str != null) {
            try {
                long j8 = Long.parseLong(str);
                if (j8 > Integer.MAX_VALUE) {
                    return Integer.MAX_VALUE;
                }
                if (j8 < 0) {
                    return 0;
                }
                return (int) j8;
            } catch (NumberFormatException unused) {
            }
        }
        return i8;
    }

    public static final String y(int i8, int i9, String trimSubstring) {
        Intrinsics.checkNotNullParameter(trimSubstring, "$this$trimSubstring");
        int iN = n(i8, i9, trimSubstring);
        String strSubstring = trimSubstring.substring(iN, o(iN, i9, trimSubstring));
        Intrinsics.checkNotNullExpressionValue(strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return strSubstring;
    }

    public static final void z(IOException withSuppressed, List suppressed) {
        Intrinsics.checkNotNullParameter(withSuppressed, "$this$withSuppressed");
        Intrinsics.checkNotNullParameter(suppressed, "suppressed");
        if (suppressed.size() > 1) {
            System.out.println(suppressed);
        }
        Iterator it = suppressed.iterator();
        while (it.hasNext()) {
            ExceptionsKt.addSuppressed(withSuppressed, (Exception) it.next());
        }
    }
}
