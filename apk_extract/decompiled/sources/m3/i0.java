package m3;

import android.text.TextUtils;
import com.transsion.widgetsliquid.utils.Utils;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
public abstract class i0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f7707a = "";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static String f7708b = "";

    public static String a() {
        if (TextUtils.isEmpty(f7707a)) {
            try {
                Method method = Class.forName("android.os.SystemProperties").getMethod("get", String.class, String.class);
                String str = (String) method.invoke(null, Utils.OS_TRANS_VERSION, "");
                f7707a = str;
                if (TextUtils.isEmpty(str)) {
                    f7707a = (String) method.invoke(null, "ro.os_product.version", "");
                }
            } catch (Exception e) {
                z6.a.c(e.getMessage());
            }
        }
        return f7707a;
    }
}
