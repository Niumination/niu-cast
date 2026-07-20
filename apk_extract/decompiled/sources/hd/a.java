package hd;

import android.content.Context;
import android.util.Log;
import android.util.TypedValue;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String[] f5293a = {"hios", "xos", "itel"};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static int f5294b = -1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static int f5295c = -1;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final boolean f5296d;
    public static final boolean e;

    static {
        boolean z2 = true;
        f5296d = "1".equals(b("ro.tran_vibrate_ontouch.support")) || "true".equals(b("ro.tr_vibrate.vibrate10.feature.support"));
        if (!"true".equals(b("ro.vendor.tran_vib3_support")) && !"true".equals(b("ro.tr_vibrate.vibrate30.feature.support"))) {
            z2 = false;
        }
        e = z2;
        if ("true".equals(b("ro.vendor.tran_0012ir"))) {
            return;
        }
        "true".equals(b("ro.tr_vibrate.realvib05.feature.support"));
    }

    public static int a(Context context, int i8) {
        return (int) TypedValue.applyDimension(1, i8, context.getResources().getDisplayMetrics());
    }

    public static String b(String str) {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            return (String) cls.getMethod("get", String.class).invoke(cls, str);
        } catch (Exception e4) {
            e4.printStackTrace();
            Log.e("widgetslib.Utils", "getSystemProperties Exception " + e4.getMessage());
            return "";
        }
    }

    public static boolean c(Context context) {
        return (context.getResources().getConfiguration().uiMode & 48) == 32;
    }
}
