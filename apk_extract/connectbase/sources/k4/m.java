package k4;

import android.text.TextUtils;
import android.util.Log;

/* JADX INFO: loaded from: classes2.dex */
public class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f8964a = "ConnectX-";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f8965b = "LogUtils";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f8966c = "tr_connectx.log_level.model.config";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static int f8967d = 3;

    public static void a(String str, String str2) {
        if (f8967d <= 7) {
            Log.v(f8964a + str, str2);
        }
    }

    public static void b(String str, String str2) {
        if (f8967d <= 3) {
            Log.d(f8964a + str, str2);
        }
    }

    public static void c(String str, String str2) {
        if (f8967d <= 6) {
            Log.e(f8964a + str, str2);
        }
    }

    public static void d(String str, Throwable th2) {
        for (StackTraceElement stackTraceElement : th2.getStackTrace()) {
            Log.e(m.a.a(f8964a, str), stackTraceElement.toString());
        }
    }

    public static void e(String str, String str2) {
        if (f8967d <= 4) {
            Log.i(f8964a + str, str2);
        }
    }

    public static void f() {
        String strF = m4.a.C0275a.f10375a.F(f8966c, "connectx.log.level", String.valueOf(f8967d));
        e(f8965b, "init:systemLogLevel:" + strF);
        if (TextUtils.isEmpty(strF)) {
            c(f8965b, "init:get property result is empty");
            return;
        }
        int[] iArr = {2, 3, 4, 5, 6, 7};
        for (int i10 = 0; i10 < 6; i10++) {
            int i11 = iArr[i10];
            if (strF.equals(String.valueOf(i11))) {
                m2.b.a("init:set log level:", i11, f8965b);
                f8967d = i11;
                return;
            }
        }
    }

    public static void g(String str, String str2) {
        if (f8967d <= 2) {
            Log.v(f8964a + str, str2);
        }
    }

    public static void h(String str, String str2) {
        if (f8967d <= 5) {
            Log.w(f8964a + str, str2);
        }
    }
}
