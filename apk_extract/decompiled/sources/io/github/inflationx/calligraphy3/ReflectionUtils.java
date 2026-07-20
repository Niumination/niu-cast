package io.github.inflationx.calligraphy3;

import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes3.dex */
class ReflectionUtils {
    private static final String TAG = "ReflectionUtils";

    public static Method getMethod(Class cls, String str) {
        for (Method method : cls.getMethods()) {
            if (method.getName().equals(str)) {
                method.setAccessible(true);
                return method;
            }
        }
        return null;
    }

    public static void invokeMethod(Object obj, Method method, Object... objArr) {
        if (method == null) {
            return;
        }
        try {
            method.invoke(obj, objArr);
        } catch (IllegalAccessException e) {
            Log.d(TAG, "Can't access method using reflection", e);
        } catch (InvocationTargetException e4) {
            Log.d(TAG, "Can't invoke method using reflection", e4);
        }
    }
}
