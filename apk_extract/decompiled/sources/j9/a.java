package j9;

import android.os.Build;
import android.util.Log;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final boolean f6132a = !"user".equals(Build.TYPE);

    public static void a(String str, String str2) {
        if (f6132a) {
            Log.d(str, str2);
        }
    }

    public static void b(String str, String str2) {
        Log.e(str, str2);
    }

    public static void c(String str, String str2) {
        if (f6132a) {
            Log.i(str, str2);
        }
    }

    public static void d(String str) {
        Log.w("a", str);
    }
}
