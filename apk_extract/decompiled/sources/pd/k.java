package pd;

import android.content.Context;
import android.os.Bundle;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import k3.z8;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public abstract class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Method f8783a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Bundle f8784b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Object f8785c;

    /* JADX WARN: Code duplicated, block: B:24:0x003f  */
    static {
        Class<?> cls;
        Method declaredMethod;
        Object objNewInstance;
        try {
            cls = Class.forName("com.transsion.hubsdk.os.TranVibrator");
        } catch (Exception e) {
            e.printStackTrace();
            cls = null;
        }
        try {
            declaredMethod = cls.getDeclaredMethod("vibrate", String.class, Bundle.class);
            try {
                declaredMethod.setAccessible(true);
            } catch (Exception e4) {
                e = e4;
                e.printStackTrace();
            }
        } catch (Exception e10) {
            e = e10;
            declaredMethod = null;
        }
        f8783a = declaredMethod;
        f8784b = new Bundle();
        if (cls != null) {
            try {
                Constructor<?> constructor = cls.getConstructor(null);
                if (constructor != null) {
                    objNewInstance = constructor.newInstance(null);
                } else {
                    objNewInstance = null;
                }
            } catch (Exception e11) {
                z8.c("VibrateUtils", "Failed to get VIBRATOR instance. " + e11, null);
                return;
            }
        } else {
            objNewInstance = null;
        }
        f8785c = objNewInstance;
    }

    public static final void a(Context context, String vibratorName) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(vibratorName, "vibratorName");
        try {
            Object obj = f8785c;
            if (obj != null) {
                Bundle bundle = f8784b;
                bundle.clear();
                bundle.putString("tran_vibrate_package", context.getPackageName());
                Method method = f8783a;
                if (method != null) {
                    method.invoke(obj, vibratorName, bundle);
                }
            }
        } catch (Exception e) {
            z8.c("VibrateUtils", "Failed to invoke vibrate " + e, null);
        }
    }
}
