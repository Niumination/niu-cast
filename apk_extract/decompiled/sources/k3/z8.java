package k3;

import android.os.Build;
import android.util.Log;

/* JADX INFO: loaded from: classes.dex */
public abstract class z8 {
    public static String a(String str, String str2) {
        StringBuilder sb2 = new StringBuilder(80);
        sb2.append("16.3.0.3 ");
        if (str != null) {
            sb2.append(str);
        }
        if (str != null && str2 != null) {
            sb2.append("_");
            sb2.append(str2);
        } else if (str2 != null) {
            sb2.append(str2);
        }
        return sb2.toString();
    }

    public static void b(String str, String str2) {
        if (e(3)) {
            Log.d("os_widgets", a(str, str2), null);
        }
    }

    public static void c(String str, String str2, Throwable th2) {
        if (e(6)) {
            Log.e("os_widgets", a(str, str2), th2);
        }
    }

    public static void d(String str, String str2) {
        if (e(4)) {
            Log.i("os_widgets", a(str, str2), null);
        }
    }

    public static boolean e(int i8) {
        String str = Build.TYPE;
        return "userdebug".equals(str) || "eng".equals(str) || Log.isLoggable("os_widgets", i8);
    }

    public static void f(String str, String str2) {
        if (e(2)) {
            Log.v("os_widgets", a(str, str2), null);
        }
    }

    public static void g(String str) {
        if (e(5)) {
            Log.w("os_widgets", a("d", str), null);
        }
    }
}
