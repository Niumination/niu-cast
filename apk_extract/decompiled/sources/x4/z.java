package x4;

import java.lang.reflect.AccessibleObject;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class z {
    private z() {
    }

    public static boolean canAccess(AccessibleObject accessibleObject, Object obj) {
        return y.f10860a.a(accessibleObject, obj);
    }

    public static v4.f0 getFilterResult(List<v4.g0> list, Class<?> cls) {
        Iterator<v4.g0> it = list.iterator();
        while (it.hasNext()) {
            v4.f0 f0VarCheck = it.next().check(cls);
            if (f0VarCheck != v4.f0.INDECISIVE) {
                return f0VarCheck;
            }
        }
        return v4.f0.ALLOW;
    }

    public static boolean isAndroidType(Class<?> cls) {
        return isAndroidType(cls.getName());
    }

    public static boolean isAnyPlatformType(Class<?> cls) {
        String name = cls.getName();
        return isAndroidType(name) || name.startsWith("kotlin.") || name.startsWith("kotlinx.") || name.startsWith("scala.");
    }

    public static boolean isJavaType(Class<?> cls) {
        return isJavaType(cls.getName());
    }

    private static boolean isAndroidType(String str) {
        return str.startsWith("android.") || str.startsWith("androidx.") || isJavaType(str);
    }

    private static boolean isJavaType(String str) {
        return str.startsWith("java.") || str.startsWith("javax.");
    }
}
