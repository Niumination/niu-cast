package e8;

import android.os.UserHandle;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes2.dex */
public class w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f4152a = "w";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Class<?> f4153b = cc.a.a("android.os.UserHandle");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f4154c = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f4155d = 100000;

    public static UserHandle a() {
        Object obj;
        try {
            Field fieldD = cc.a.d(f4153b, "ALL");
            if (fieldD == null || (obj = fieldD.get(null)) == null || !(obj instanceof UserHandle)) {
                return null;
            }
            return (UserHandle) obj;
        } catch (IllegalAccessException e10) {
            dc.e.c(f4152a, "getAll fail:" + e10);
            return null;
        }
    }

    public static int b(int i10) {
        Object objJ = cc.a.j(cc.a.g(f4153b, "getAppId", Integer.TYPE), null, Integer.valueOf(i10));
        return objJ == null ? i10 % f4155d : ((Integer) objJ).intValue();
    }

    public static UserHandle c() {
        Object obj;
        try {
            Field fieldD = cc.a.d(f4153b, "CURRENT");
            if (fieldD == null || (obj = fieldD.get(null)) == null || !(obj instanceof UserHandle)) {
                return null;
            }
            return (UserHandle) obj;
        } catch (IllegalAccessException e10) {
            dc.e.c(f4152a, "getCurrent fail:" + e10);
            return null;
        }
    }

    public static int d(int i10) {
        try {
            Method methodG = cc.a.g(f4153b, "getUserId", Integer.TYPE);
            methodG.setAccessible(true);
            Object objInvoke = methodG.invoke(null, Integer.valueOf(i10));
            if (objInvoke == null || !(objInvoke instanceof Integer)) {
                return 0;
            }
            return ((Integer) objInvoke).intValue();
        } catch (Throwable th2) {
            m7.a.a("getUserId fail:", th2, f4152a);
            return 0;
        }
    }

    public static boolean e() {
        Object objJ = cc.a.j(cc.a.g(f4153b, "isSystem", new Class[0]), null, new Object[0]);
        boolean zBooleanValue = objJ instanceof Boolean ? ((Boolean) objJ).booleanValue() : false;
        if (zBooleanValue || f() != 0) {
            return zBooleanValue;
        }
        return true;
    }

    public static int f() {
        try {
            Method methodG = cc.a.g(f4153b, "myUserId", new Class[0]);
            methodG.setAccessible(true);
            Object objInvoke = methodG.invoke(null, null);
            if (objInvoke == null || !(objInvoke instanceof Integer)) {
                return 0;
            }
            return ((Integer) objInvoke).intValue();
        } catch (Throwable th2) {
            m7.a.a("myUserId fail:", th2, f4152a);
            return 0;
        }
    }

    public static UserHandle g(int i10) {
        try {
            Method methodG = cc.a.g(f4153b, "of", Integer.TYPE);
            methodG.setAccessible(true);
            Object objInvoke = methodG.invoke(null, Integer.valueOf(i10));
            if (objInvoke == null || !(objInvoke instanceof UserHandle)) {
                return null;
            }
            return (UserHandle) objInvoke;
        } catch (Throwable th2) {
            m7.a.a("of fail:", th2, f4152a);
            return null;
        }
    }
}
