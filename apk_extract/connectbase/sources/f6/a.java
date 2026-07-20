package f6;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

/* JADX INFO: loaded from: classes2.dex */
public class a {
    public static String a() {
        try {
            PackageManager packageManager = b6.b.a().getPackageManager();
            return packageManager != null ? packageManager.getPackageInfo(b6.b.a().getPackageName(), 0).applicationInfo.loadLabel(packageManager).toString() : "";
        } catch (Exception e10) {
            e10.printStackTrace();
            return "";
        }
    }

    public static String b() {
        try {
            return b6.b.a().getPackageManager().getInstallerPackageName(c());
        } catch (Exception e10) {
            e10.printStackTrace();
            return "";
        }
    }

    public static String c() {
        return b6.b.a().getPackageName();
    }

    public static int d() {
        Context contextA = b6.b.a();
        try {
            PackageInfo packageInfo = contextA.getPackageManager().getPackageInfo(contextA.getPackageName(), 0);
            if (packageInfo != null) {
                return packageInfo.versionCode;
            }
            return -1;
        } catch (Exception e10) {
            e10.printStackTrace();
            return -1;
        }
    }

    public static String e() {
        Context contextA = b6.b.a();
        try {
            PackageInfo packageInfo = contextA.getPackageManager().getPackageInfo(contextA.getPackageName(), 0);
            return packageInfo != null ? packageInfo.versionName : "";
        } catch (Exception e10) {
            e10.printStackTrace();
            return "";
        }
    }
}
