package y3;

import android.content.Context;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Log;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes2.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f20702a = "";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static String f20703b = "";

    @b.a({"PrivateApi"})
    public static String a() {
        if (TextUtils.isEmpty(f20702a)) {
            try {
                Method method = Class.forName("android.os.SystemProperties").getMethod("get", String.class, String.class);
                String str = (String) method.invoke(null, "ro.tranos.version", "");
                f20702a = str;
                if (TextUtils.isEmpty(str)) {
                    f20702a = (String) method.invoke(null, "ro.os_product.version", "");
                }
            } catch (Exception e10) {
                b.d(e10.getMessage());
            }
        }
        return f20702a;
    }

    public static String b(Context context) {
        if (!TextUtils.isEmpty(f20703b)) {
            return f20703b;
        }
        try {
            String string = Settings.Global.getString(context.getContentResolver(), "os_small_version");
            f20703b = string;
            return string;
        } catch (Exception e10) {
            b.d(Log.getStackTraceString(e10));
            return "";
        }
    }
}
