package b9;

import android.graphics.drawable.Drawable;
import android.view.View;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes2.dex */
public class m implements lh.m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f778a = "m";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Class<?> f779b = cc.a.a("android.view.View");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static Class<?> f780c = cc.a.a("android.view.ViewRootImpl");

    @Override // lh.m
    public void a(View view) {
        cc.a.j(cc.a.g(f780c, "notifyInsetsChanged", new Class[0]), view.getParent(), new Object[0]);
    }

    @Override // lh.m
    public Drawable b(View view, int i10, int i11, float f10) {
        try {
            Method methodG = cc.a.g(f779b, "getViewRootImpl", new Class[0]);
            methodG.setAccessible(true);
            Object objInvoke = methodG.invoke(view, null);
            Class clsA = cc.a.a("com.android.internal.graphics.drawable.BackgroundBlurDrawable");
            Class cls = Integer.TYPE;
            Method methodG2 = cc.a.g(clsA, "setBlurRadius", cls);
            Method declaredMethod = clsA.getDeclaredMethod("setColor", cls);
            Method methodG3 = cc.a.g(clsA, "setCornerRadius", Float.TYPE);
            Method methodG4 = cc.a.g(f780c, "createBackgroundBlurDrawable", new Class[0]);
            methodG4.setAccessible(true);
            if (view != null && objInvoke != null) {
                methodG2.setAccessible(true);
                declaredMethod.setAccessible(true);
                methodG3.setAccessible(true);
                Object objInvoke2 = methodG4.invoke(objInvoke, null);
                Drawable drawable = (objInvoke2 == null || !(objInvoke2 instanceof Drawable)) ? null : (Drawable) objInvoke2;
                if (objInvoke2 != null) {
                    methodG2.invoke(drawable, Integer.valueOf(i10));
                    declaredMethod.invoke(drawable, Integer.valueOf(i11));
                    methodG3.invoke(drawable, Float.valueOf(f10));
                }
                return drawable;
            }
        } catch (Throwable th2) {
            m7.a.a("createBackgroundBlurDrawable fail ", th2, f778a);
        }
        return null;
    }

    @Override // lh.m
    public Drawable c(View view, int i10) {
        try {
            Method methodG = cc.a.g(f779b, "getViewRootImpl", new Class[0]);
            methodG.setAccessible(true);
            Object objInvoke = methodG.invoke(view, null);
            Method declaredMethod = cc.a.a("com.android.internal.graphics.drawable.BackgroundBlurDrawable").getDeclaredMethod("setColor", Integer.TYPE);
            Method methodG2 = cc.a.g(f780c, "createBackgroundBlurDrawable", new Class[0]);
            methodG2.setAccessible(true);
            if (view != null && objInvoke != null) {
                declaredMethod.setAccessible(true);
                Object objInvoke2 = methodG2.invoke(objInvoke, null);
                Drawable drawable = (objInvoke2 == null || !(objInvoke2 instanceof Drawable)) ? null : (Drawable) objInvoke2;
                if (objInvoke2 != null) {
                    declaredMethod.invoke(drawable, Integer.valueOf(i10));
                }
                return drawable;
            }
        } catch (Throwable th2) {
            m7.a.a("createBackgroundBlurDrawable fail ", th2, f778a);
        }
        return null;
    }
}
