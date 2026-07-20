package ui;

import android.os.Build;
import android.util.Log;
import java.security.InvalidParameterException;
import ks.g;

/* JADX INFO: loaded from: classes2.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f16287a = "os_widgets";

    public static String a(String str, String str2, String[] strArr, Object[] objArr) {
        StringBuilder sb2 = new StringBuilder(80);
        if (str != null) {
            sb2.append(str);
        }
        if (str != null && str2 != null) {
            sb2.append("_");
            sb2.append(str2);
        } else if (str2 != null) {
            sb2.append(str2);
        }
        if (strArr == null || objArr == null) {
            return sb2.toString();
        }
        if (strArr.length != objArr.length) {
            throw new InvalidParameterException("Length of names and values array is not equal");
        }
        sb2.append(" { ");
        int length = strArr.length;
        for (int i10 = 0; i10 < length; i10++) {
            if (i10 > 0) {
                sb2.append(g.f9491d);
            }
            sb2.append(strArr[i10]);
            sb2.append("=");
            sb2.append(objArr[i10]);
        }
        sb2.append(" }");
        return sb2.toString();
    }

    public static void b(String str) {
        e(null, str, null, null, null);
    }

    public static void c(String str, String str2) {
        e(str, str2, null, null, null);
    }

    public static void d(String str, String str2, Throwable th2) {
        e(str, str2, null, null, th2);
    }

    public static void e(String str, String str2, String[] strArr, Object[] objArr, Throwable th2) {
        if (o(3)) {
            Log.d(f16287a, a(str, str2, strArr, objArr), th2);
        }
    }

    public static void f(String str) {
        i(null, str, null, null, null);
    }

    public static void g(String str, String str2) {
        i(str, str2, null, null, null);
    }

    public static void h(String str, String str2, Throwable th2) {
        i(str, str2, null, null, th2);
    }

    public static void i(String str, String str2, String[] strArr, Object[] objArr, Throwable th2) {
        if (o(6)) {
            Log.e(f16287a, a(str, str2, strArr, objArr), th2);
        }
    }

    public static void j(String str) {
        m(null, str, null, null, null);
    }

    public static void k(String str, String str2) {
        m(str, str2, null, null, null);
    }

    public static void l(String str, String str2, Throwable th2) {
        m(str, str2, null, null, th2);
    }

    public static void m(String str, String str2, String[] strArr, Object[] objArr, Throwable th2) {
        if (o(4)) {
            Log.i(f16287a, a(str, str2, strArr, objArr), th2);
        }
    }

    public static boolean n() {
        String str = Build.TYPE;
        return "userdebug".equals(str) || "eng".equals(str);
    }

    public static boolean o(int i10) {
        return n() || Log.isLoggable(f16287a, i10);
    }

    public static void p(String str) {
        s(null, str, null, null, null);
    }

    public static void q(String str, String str2) {
        s(str, str2, null, null, null);
    }

    public static void r(String str, String str2, Throwable th2) {
        s(str, str2, null, null, th2);
    }

    public static void s(String str, String str2, String[] strArr, Object[] objArr, Throwable th2) {
        if (o(2)) {
            Log.v(f16287a, a(str, str2, strArr, objArr), th2);
        }
    }

    public static void t(String str) {
        w(null, str, null, null, null);
    }

    public static void u(String str, String str2) {
        w(str, str2, null, null, null);
    }

    public static void v(String str, String str2, Throwable th2) {
        w(str, str2, null, null, null);
    }

    public static void w(String str, String str2, String[] strArr, Object[] objArr, Throwable th2) {
        if (o(5)) {
            Log.w(f16287a, a(str, str2, strArr, objArr), th2);
        }
    }
}
