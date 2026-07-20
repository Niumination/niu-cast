package k3;

import android.content.Context;
import android.content.pm.PackageManager;

/* JADX INFO: loaded from: classes.dex */
public abstract class f1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Boolean f6435a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Boolean f6436b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static Boolean f6437c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static Boolean f6438d;

    public static boolean a(Context context) {
        PackageManager packageManager = context.getPackageManager();
        if (f6435a == null) {
            f6435a = Boolean.valueOf(packageManager.hasSystemFeature("android.hardware.type.watch"));
        }
        return f6435a.booleanValue();
    }

    public static boolean b(Context context) {
        a(context);
        if (f6436b == null) {
            f6436b = Boolean.valueOf(context.getPackageManager().hasSystemFeature("cn.google"));
        }
        return f6436b.booleanValue();
    }
}
