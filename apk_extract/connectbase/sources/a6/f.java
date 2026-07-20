package a6;

import android.content.pm.PackageManager;
import com.transsion.connectx.mirror.source.SourceApplication;

/* JADX INFO: loaded from: classes2.dex */
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Boolean f61a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f62b = "CompatibilityUtils";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f63c = "com.transsion.iotservice";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f64d = "com.transsion.pcconnect";

    public static String a() {
        return b() ? "com.transsion.pcconnect" : f63c;
    }

    public static boolean b() {
        Boolean bool = f61a;
        if (bool != null) {
            return bool.booleanValue();
        }
        PackageManager packageManager = SourceApplication.b().getPackageManager();
        if (packageManager == null) {
            k4.m.c(f62b, "pkms is null");
            Boolean bool2 = Boolean.FALSE;
            f61a = bool2;
            return bool2.booleanValue();
        }
        try {
            packageManager.getPackageInfo("com.transsion.pcconnect", 1);
            f61a = Boolean.TRUE;
            k4.m.e(f62b, "new pc connect exist");
        } catch (PackageManager.NameNotFoundException unused) {
            f61a = Boolean.FALSE;
            k4.m.e(f62b, "new pc connect not exist");
        }
        return f61a.booleanValue();
    }
}
