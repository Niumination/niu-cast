package f6;

import android.content.Context;
import android.os.Environment;
import java.io.File;
import java.lang.reflect.Field;

/* JADX INFO: loaded from: classes2.dex */
public class b {
    public static File a(Context context) {
        boolean z10 = true;
        try {
            Field declaredField = Environment.class.getDeclaredField("sUserRequired");
            declaredField.setAccessible(true);
            z10 = declaredField.getBoolean(new Environment());
        } catch (Exception unused) {
        }
        if (z10) {
            return null;
        }
        try {
            return context.getExternalCacheDir();
        } catch (Exception e10) {
            e10.printStackTrace();
            return null;
        }
    }
}
