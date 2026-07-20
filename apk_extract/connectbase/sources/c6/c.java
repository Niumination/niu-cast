package c6;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes2.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Method f1372a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Method f1373b;

    static {
        try {
            for (Method method : Class.forName("android.os.SystemProperties").getMethods()) {
                String name = method.getName();
                if (name.equals("get")) {
                    f1372a = method;
                } else if (name.equals("set")) {
                    f1373b = method;
                }
            }
        } catch (ClassNotFoundException e10) {
            e10.printStackTrace();
        }
    }

    public static String a(String str, String str2) {
        try {
            return (String) f1372a.invoke(null, str, str2);
        } catch (IllegalAccessException e10) {
            e10.printStackTrace();
            return str2;
        } catch (IllegalArgumentException e11) {
            e11.printStackTrace();
            return str2;
        } catch (InvocationTargetException e12) {
            e12.printStackTrace();
            return str2;
        }
    }

    public static void b(String str, String str2) {
        try {
            f1373b.invoke(null, str, str2);
        } catch (IllegalAccessException e10) {
            e10.printStackTrace();
        } catch (IllegalArgumentException e11) {
            e11.printStackTrace();
        } catch (InvocationTargetException e12) {
            e12.printStackTrace();
        }
    }
}
