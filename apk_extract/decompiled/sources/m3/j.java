package m3;

import android.os.IBinder;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
public abstract class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Class f7749a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Method f7750b;

    public static IBinder a() {
        try {
            if (f7749a == null) {
                f7749a = Class.forName("android.os.ServiceManager");
            }
            if (f7750b == null) {
                Method declaredMethod = f7749a.getDeclaredMethod("getService", String.class);
                f7750b = declaredMethod;
                declaredMethod.setAccessible(true);
            }
            return (IBinder) f7750b.invoke(null, "kolun");
        } catch (ClassNotFoundException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
            vc.a.b("AndroidHiddenApi", "Warning : invoke ServiceManager.getService, " + e);
            return null;
        }
    }
}
