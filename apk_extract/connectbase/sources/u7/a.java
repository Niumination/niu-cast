package u7;

import android.content.Context;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes2.dex */
public class a implements fg.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f16210a = "a";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Class<?> f16211b = cc.a.a("com.android.internal.view.RotationPolicy");

    @Override // fg.a
    public boolean a(Context context) {
        try {
            Method methodG = cc.a.g(f16211b, "isRotationLocked", Context.class);
            methodG.setAccessible(true);
            Object objInvoke = methodG.invoke(null, context);
            if (objInvoke == null || !(objInvoke instanceof Boolean)) {
                return false;
            }
            return ((Boolean) objInvoke).booleanValue();
        } catch (Throwable th2) {
            m7.a.a("isRotationLocked fail", th2, f16210a);
            return false;
        }
    }
}
