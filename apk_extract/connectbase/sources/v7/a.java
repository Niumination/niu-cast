package v7;

import android.app.admin.DevicePolicyManager;
import android.content.Context;
import com.android.internal.annotations.VisibleForTesting;
import dc.e;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes2.dex */
public class a implements gg.c {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f16667c = "a";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static Class<?> f16668d = cc.a.a("com.android.internal.widget.LockPatternUtils");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Object f16669a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Context f16670b = bc.a.a();

    @Override // gg.c
    public void a(boolean z10, int i10) {
        try {
            if (this.f16669a == null) {
                Constructor constructorC = cc.a.c(f16668d, new Class[]{Context.class});
                constructorC.setAccessible(true);
                this.f16669a = constructorC.newInstance(this.f16670b);
            }
            Method methodG = cc.a.g(this.f16669a.getClass(), "setAutoPinConfirm", Boolean.TYPE, Integer.TYPE);
            if (methodG != null) {
                cc.a.j(methodG, this.f16669a, Boolean.valueOf(z10), Integer.valueOf(i10));
            }
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException e10) {
            e.c(f16667c, "setAutoPinConfirm fail: " + e10);
        }
    }

    @Override // gg.c
    public String b(String str, int i10) {
        try {
            if (this.f16669a == null) {
                Constructor constructorC = cc.a.c(f16668d, new Class[]{Context.class});
                constructorC.setAccessible(true);
                this.f16669a = constructorC.newInstance(this.f16670b);
            }
            Method methodG = cc.a.g(this.f16669a.getClass(), "getString", String.class, Integer.TYPE);
            methodG.setAccessible(true);
            Object objInvoke = methodG.invoke(this.f16669a, str, Integer.valueOf(i10));
            if (objInvoke == null || !(objInvoke instanceof String)) {
                return null;
            }
            return (String) objInvoke;
        } catch (Throwable th2) {
            m7.a.a("getString fail ", th2, f16667c);
            return null;
        }
    }

    @Override // gg.c
    public DevicePolicyManager c() {
        try {
            if (this.f16669a == null) {
                Constructor constructorC = cc.a.c(f16668d, new Class[]{Context.class});
                constructorC.setAccessible(true);
                this.f16669a = constructorC.newInstance(this.f16670b);
            }
            Method methodG = cc.a.g(this.f16669a.getClass(), "getDevicePolicyManager", new Class[0]);
            methodG.setAccessible(true);
            Object objInvoke = methodG.invoke(this.f16669a, null);
            if (objInvoke == null || !(objInvoke instanceof DevicePolicyManager)) {
                return null;
            }
            return (DevicePolicyManager) objInvoke;
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException e10) {
            e.c(f16667c, "getDevicePolicyManager fail " + e10);
            return null;
        }
    }

    @Override // gg.c
    public void d(String str, String str2, int i10) {
        try {
            if (this.f16669a == null) {
                Constructor constructorC = cc.a.c(f16668d, new Class[]{Context.class});
                constructorC.setAccessible(true);
                this.f16669a = constructorC.newInstance(this.f16670b);
            }
            Method methodG = cc.a.g(this.f16669a.getClass(), "setString", String.class, String.class, Integer.TYPE);
            methodG.setAccessible(true);
            methodG.invoke(this.f16669a, str, str2, Integer.valueOf(i10));
        } catch (Throwable th2) {
            m7.a.a("setString fail ", th2, f16667c);
        }
    }

    @Override // gg.c
    public boolean e(int i10) {
        try {
            if (this.f16669a == null) {
                Constructor constructorC = cc.a.c(f16668d, new Class[]{Context.class});
                constructorC.setAccessible(true);
                this.f16669a = constructorC.newInstance(this.f16670b);
            }
            Method methodG = cc.a.g(this.f16669a.getClass(), "isSecure", Integer.TYPE);
            methodG.setAccessible(true);
            Object objInvoke = methodG.invoke(this.f16669a, Integer.valueOf(i10));
            if (objInvoke == null || !(objInvoke instanceof Boolean)) {
                return false;
            }
            return ((Boolean) objInvoke).booleanValue();
        } catch (Throwable th2) {
            m7.a.a("isSecure fail ", th2, f16667c);
            return false;
        }
    }

    @Override // gg.c
    public long f(long j10, int i10) {
        try {
            if (this.f16669a == null) {
                Constructor constructorC = cc.a.c(f16668d, new Class[]{Context.class});
                constructorC.setAccessible(true);
                this.f16669a = constructorC.newInstance(this.f16670b);
            }
            Method methodG = cc.a.g(this.f16669a.getClass(), "getPasswordLength", Long.TYPE, Integer.TYPE);
            if (methodG != null) {
                return ((Long) cc.a.j(methodG, this.f16669a, Long.valueOf(j10), Integer.valueOf(i10))).longValue();
            }
            return 0L;
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException e10) {
            e.c(f16667c, "getPasswordLength fail: " + e10);
            return 0L;
        }
    }

    @Override // gg.c
    public int g(int i10) {
        try {
            if (this.f16669a == null) {
                Constructor constructorC = cc.a.c(f16668d, new Class[]{Context.class});
                constructorC.setAccessible(true);
                this.f16669a = constructorC.newInstance(this.f16670b);
            }
            Method methodG = cc.a.g(this.f16669a.getClass(), "getActivePasswordQuality", Integer.TYPE);
            methodG.setAccessible(true);
            Object objInvoke = methodG.invoke(this.f16669a, Integer.valueOf(i10));
            if (objInvoke == null || !(objInvoke instanceof Integer)) {
                return 0;
            }
            return ((Integer) objInvoke).intValue();
        } catch (Throwable th2) {
            m7.a.a("getActivePasswordQuality fail ", th2, f16667c);
            return 0;
        }
    }

    @Override // gg.c
    public boolean h(int i10) {
        try {
            if (this.f16669a == null) {
                Constructor constructorC = cc.a.c(f16668d, new Class[]{Context.class});
                constructorC.setAccessible(true);
                this.f16669a = constructorC.newInstance(this.f16670b);
            }
            Method methodG = cc.a.g(this.f16669a.getClass(), "getPowerButtonInstantlyLocks", Integer.TYPE);
            methodG.setAccessible(true);
            Object objInvoke = methodG.invoke(this.f16669a, Integer.valueOf(i10));
            if (objInvoke == null || !(objInvoke instanceof Boolean)) {
                return false;
            }
            return ((Boolean) objInvoke).booleanValue();
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException e10) {
            e.c(f16667c, "getPowerButtonInstantlyLocks fail " + e10);
            return false;
        }
    }

    @Override // gg.c
    public long i(int i10) {
        try {
            if (this.f16669a == null) {
                Constructor constructorC = cc.a.c(f16668d, new Class[]{Context.class});
                constructorC.setAccessible(true);
                this.f16669a = constructorC.newInstance(this.f16670b);
            }
            Method methodG = cc.a.g(this.f16669a.getClass(), "getLockoutAttemptDeadline", Integer.TYPE);
            methodG.setAccessible(true);
            Object objInvoke = methodG.invoke(this.f16669a, Integer.valueOf(i10));
            if (objInvoke == null || !(objInvoke instanceof Long)) {
                return 0L;
            }
            return ((Long) objInvoke).longValue();
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException e10) {
            e.c(f16667c, "getLockoutAttemptDeadline fail " + e10);
            return 0L;
        }
    }

    @VisibleForTesting
    public void j(Object obj) {
        this.f16669a = obj;
    }
}
