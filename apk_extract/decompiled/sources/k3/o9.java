package k3;

import android.util.Log;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
public abstract class o9 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f6567a = 0;

    public static Class a(String str) {
        try {
            return Class.forName(str);
        } catch (Exception e) {
            String strJ = h0.a.j("access class ", str, " failed!");
            boolean z2 = j9.a.f6132a;
            Log.e("o9", strJ, e);
            return null;
        }
    }

    public static Constructor b(Class[] clsArr) {
        Class cls = o8.a.f8412c;
        try {
            Constructor declaredConstructor = cls.getDeclaredConstructor(clsArr);
            declaredConstructor.setAccessible(true);
            return declaredConstructor;
        } catch (Exception e) {
            StringBuilder sb2 = new StringBuilder();
            int length = clsArr.length;
            for (int i8 = 0; i8 < length; i8++) {
                Class cls2 = clsArr[i8];
                sb2.append(cls2 == null ? "null," : cls2.getSimpleName());
                sb2.append(",");
            }
            boolean z2 = j9.a.f6132a;
            Log.e("o9", "access constructor " + ((Object) sb2) + " of " + cls + " failed!", e);
            return null;
        }
    }

    public static Field c(Class cls, String str) {
        while (cls != Object.class && cls != null) {
            try {
                Field declaredField = cls.getDeclaredField(str);
                declaredField.setAccessible(true);
                return declaredField;
            } catch (Exception e) {
                boolean z2 = j9.a.f6132a;
                Log.e("o9", "access filed " + str + " of " + cls + " failed!", e);
                cls = cls.getSuperclass();
            }
        }
        return null;
    }

    public static Method d(Class cls, String str, Class... clsArr) {
        Exception e = null;
        while (cls != Object.class && cls != null) {
            try {
                Method declaredMethod = cls.getDeclaredMethod(str, clsArr);
                declaredMethod.setAccessible(true);
                return declaredMethod;
            } catch (Exception e4) {
                e = e4;
                cls = cls.getSuperclass();
            }
        }
        StringBuilder sb2 = new StringBuilder();
        if (clsArr != null) {
            int length = clsArr.length;
            for (int i8 = 0; i8 < length; i8++) {
                Class cls2 = clsArr[i8];
                sb2.append(cls2 == null ? "null," : cls2.getSimpleName());
                sb2.append(",");
            }
        }
        String str2 = "access method " + str + " " + ((Object) sb2) + " of " + cls + " failed!";
        boolean z2 = j9.a.f6132a;
        Log.e("o9", str2, e);
        return null;
    }

    public static Object e(Object obj, Method method, Object... objArr) {
        try {
            return method.invoke(obj, objArr);
        } catch (Exception e) {
            boolean z2 = j9.a.f6132a;
            Log.e("o9", "Failed to invoke " + method, e);
            return null;
        }
    }
}
