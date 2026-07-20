package cc;

import dc.e;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import ks.g;

/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f1439a = "a";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final boolean f1440b = true;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f1441c = " failed!";

    public static Class a(String str) {
        try {
            return Class.forName(str);
        } catch (Exception e10) {
            e.d(f1439a, "access class " + str + f1441c, e10);
            return null;
        }
    }

    public static Class b(String str, ClassLoader classLoader) {
        try {
            return Class.forName(str, false, classLoader);
        } catch (Exception e10) {
            e.d(f1439a, "access class " + str + f1441c, e10);
            return null;
        }
    }

    public static <T> Constructor<T> c(Class<T> cls, Class<?>[] clsArr) {
        try {
            Constructor<T> declaredConstructor = cls.getDeclaredConstructor(clsArr);
            declaredConstructor.setAccessible(true);
            return declaredConstructor;
        } catch (Exception e10) {
            StringBuilder sb2 = new StringBuilder();
            if (clsArr != null) {
                int length = clsArr.length;
                for (int i10 = 0; i10 < length; i10++) {
                    Class<?> cls2 = clsArr[i10];
                    sb2.append(cls2 == null ? "null," : cls2.getSimpleName());
                    sb2.append(g.f9491d);
                }
            }
            e.d(f1439a, "access constructor " + ((Object) sb2) + " of " + cls + f1441c, e10);
            return null;
        }
    }

    public static Field d(Class<?> cls, String str) {
        while (cls != Object.class && cls != null) {
            try {
                Field declaredField = cls.getDeclaredField(str);
                declaredField.setAccessible(true);
                return declaredField;
            } catch (Exception e10) {
                e.d(f1439a, "access filed " + str + " of " + cls + f1441c, e10);
                cls = cls.getSuperclass();
            }
        }
        return null;
    }

    public static String e(String str, String str2, String str3) {
        try {
            Class<?> cls = Class.forName(str);
            Field fieldD = d(cls, str2);
            return fieldD == null ? str3 : (String) fieldD.get(cls.newInstance());
        } catch (Exception e10) {
            e.d(f1439a, "Failed to get value of getFieldString", e10);
            return str3;
        }
    }

    public static <T> T f(Field field, Object obj) {
        try {
            return (T) field.get(obj);
        } catch (Exception e10) {
            e.d(f1439a, "Failed to get value of " + field, e10);
            return null;
        }
    }

    public static Method g(Class<?> cls, String str, Class<?>... clsArr) {
        Exception e10 = null;
        while (cls != Object.class && cls != null) {
            try {
                Method declaredMethod = cls.getDeclaredMethod(str, clsArr);
                declaredMethod.setAccessible(true);
                return declaredMethod;
            } catch (Exception e11) {
                e10 = e11;
                cls = cls.getSuperclass();
            }
        }
        StringBuilder sb2 = new StringBuilder();
        if (clsArr != null) {
            int length = clsArr.length;
            for (int i10 = 0; i10 < length; i10++) {
                Class<?> cls2 = clsArr[i10];
                sb2.append(cls2 == null ? "null," : cls2.getSimpleName());
                sb2.append(g.f9491d);
            }
        }
        e.d(f1439a, "access method " + str + " " + ((Object) sb2) + " of " + cls + f1441c, e10);
        return null;
    }

    public static boolean h(Class<?> cls, String str, boolean z10) {
        Field fieldD = d(cls, str);
        if (fieldD == null) {
            return z10;
        }
        try {
            return fieldD.getBoolean(null);
        } catch (Exception e10) {
            e.d(f1439a, "Failed to getBoolean value of " + fieldD, e10);
            return z10;
        }
    }

    public static int i(Class<?> cls, String str, int i10) {
        Field fieldD = d(cls, str);
        if (fieldD == null) {
            return i10;
        }
        try {
            return fieldD.getInt(null);
        } catch (Exception e10) {
            e.d(f1439a, "Failed to getInt value of " + fieldD, e10);
            return i10;
        }
    }

    public static <T> T j(Method method, Object obj, Object... objArr) {
        try {
            return (T) method.invoke(obj, objArr);
        } catch (Exception e10) {
            e.d(f1439a, "Failed to invoke " + method, e10);
            return null;
        }
    }
}
