package vk;

import android.os.IBinder;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes3.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Class f10611a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Method f10612b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Method f10613c;

    static {
        Class<?> cls;
        Class<?> cls2;
        Method method;
        String str = b.f10614a;
        Method method2 = null;
        try {
            cls = Class.forName("com.transsion.hubsdk.TranServiceManager");
        } catch (Exception e) {
            e.printStackTrace();
            cls = null;
        }
        try {
            cls2 = Class.forName("com.transsion.hubsdk.view.ITranWindowManager$Stub");
        } catch (Exception e4) {
            e4.printStackTrace();
            cls2 = null;
        }
        f10611a = cls2;
        try {
            method = cls.getMethod("getServiceIBinder", String.class);
        } catch (Exception e10) {
            e10.printStackTrace();
            method = null;
        }
        f10612b = method;
        try {
            method2 = cls2.getMethod("asInterface", IBinder.class);
        } catch (Exception e11) {
            e11.printStackTrace();
        }
        f10613c = method2;
    }

    public static void a(int i8) {
        Object objInvoke;
        try {
            IBinder iBinder = (IBinder) f10612b.invoke(null, "window");
            if (iBinder == null || (objInvoke = f10613c.invoke(f10611a, iBinder)) == null) {
                return;
            }
            Class<?> cls = objInvoke.getClass();
            Class cls2 = Integer.TYPE;
            cls.getMethod("hookWindowScene", cls2, cls2, cls2).invoke(objInvoke, 0, 3, Integer.valueOf(i8));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
