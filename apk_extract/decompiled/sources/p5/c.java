package p5;

import android.content.Context;
import android.content.pm.PackageManager;
import android.util.Log;

/* JADX INFO: loaded from: classes2.dex */
public abstract class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final tc.d f8670a = new tc.d("CommonUtils", "");

    public static String a(Context context) {
        try {
            return String.valueOf(context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode);
        } catch (PackageManager.NameNotFoundException e) {
            String strConcat = "Exception thrown when trying to get app version ".concat(e.toString());
            tc.d dVar = f8670a;
            if (Log.isLoggable((String) dVar.f10209a, 6)) {
                Log.e("CommonUtils", dVar.l(strConcat));
            }
            return "";
        }
    }
}
