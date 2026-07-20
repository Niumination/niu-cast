package r7;

import android.content.Context;
import android.os.IBinder;
import android.view.View;
import android.view.WindowManager;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes2.dex */
public class a implements cg.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f14295b = "a";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static Class<?> f14296c = cc.a.a("com.android.internal.policy.PhoneWindow");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Object f14297a;

    public a(Context context) {
        try {
            Constructor constructorC = cc.a.c(f14296c, new Class[]{Context.class});
            constructorC.setAccessible(true);
            this.f14297a = constructorC.newInstance(context);
        } catch (Throwable th2) {
            m7.a.a("TranAospPhoneWindow fail", th2, f14295b);
        }
    }

    @Override // cg.a
    public View a() {
        try {
            if (this.f14297a != null) {
                Method methodG = cc.a.g(f14296c, "getDecorView", new Class[0]);
                methodG.setAccessible(true);
                Object objInvoke = methodG.invoke(this.f14297a, null);
                if (objInvoke == null || !(objInvoke instanceof View)) {
                    return null;
                }
                return (View) objInvoke;
            }
        } catch (Throwable th2) {
            m7.a.a("getDecorView fail", th2, f14295b);
        }
        return null;
    }

    @Override // cg.a
    public boolean b(int i10) {
        try {
            if (this.f14297a != null) {
                Method methodG = cc.a.g(f14296c, "requestFeature", Integer.TYPE);
                methodG.setAccessible(true);
                Object objInvoke = methodG.invoke(this.f14297a, Integer.valueOf(i10));
                if (objInvoke == null || !(objInvoke instanceof Boolean)) {
                    return false;
                }
                return ((Boolean) objInvoke).booleanValue();
            }
        } catch (Throwable th2) {
            m7.a.a("requestFeature fail", th2, f14295b);
        }
        return false;
    }

    @Override // cg.a
    public void c(int i10) {
        Class clsA = cc.a.a("android.view.Window");
        try {
            if (this.f14297a != null) {
                Method methodG = cc.a.g(clsA, "setBackgroundDrawableResource", Integer.TYPE);
                methodG.setAccessible(true);
                methodG.invoke(this.f14297a, Integer.valueOf(i10));
            }
        } catch (Throwable th2) {
            m7.a.a("setBackgroundDrawableResource fail:", th2, f14295b);
        }
    }

    @Override // cg.a
    public void d(WindowManager windowManager, IBinder iBinder, String str) {
        try {
            if (this.f14297a != null) {
                Method methodG = cc.a.g(f14296c, "setWindowManager", WindowManager.class, IBinder.class, String.class);
                methodG.setAccessible(true);
                methodG.invoke(this.f14297a, windowManager, iBinder, str);
            }
        } catch (Throwable th2) {
            m7.a.a("setWindowManager fail", th2, f14295b);
        }
    }
}
