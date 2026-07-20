package m8;

import android.content.ContentResolver;
import android.content.Context;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes2.dex */
public class b implements wg.b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f10604b = "b";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static Class<?> f10605c = cc.a.a("android.provider.Settings$Secure");

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static Class<?> f10606d = cc.a.a("android.provider.Settings$System");

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static Class<?> f10607e = cc.a.a("android.provider.Settings$Global");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f10608a = bc.a.a();

    @Override // wg.b
    public String a(ContentResolver contentResolver, String str, int i10) {
        Method methodG = cc.a.g(f10605c, "getStringForUser", ContentResolver.class, String.class, Integer.TYPE);
        try {
            methodG.setAccessible(true);
            Object objInvoke = methodG.invoke(null, contentResolver, str, Integer.valueOf(i10));
            if (objInvoke == null || !(objInvoke instanceof String)) {
                return null;
            }
            return (String) objInvoke;
        } catch (Throwable th2) {
            m7.a.a("getSecureStringForUser fail ", th2, f10604b);
            return null;
        }
    }

    @Override // wg.b
    public int b(ContentResolver contentResolver, String str, int i10, int i11) {
        Class<?> cls = f10605c;
        Class cls2 = Integer.TYPE;
        Method methodG = cc.a.g(cls, "getIntForUser", ContentResolver.class, String.class, cls2, cls2);
        try {
            methodG.setAccessible(true);
            Object objInvoke = methodG.invoke(null, contentResolver, str, Integer.valueOf(i10), Integer.valueOf(i11));
            return (objInvoke == null || !(objInvoke instanceof Integer)) ? i10 : ((Integer) objInvoke).intValue();
        } catch (Throwable th2) {
            m7.a.a("getSecureIntForUser fail ", th2, f10604b);
            return i10;
        }
    }

    @Override // wg.b
    public boolean c(String str, int i10, int i11) {
        Class<?> cls = f10605c;
        Class cls2 = Integer.TYPE;
        Method methodG = cc.a.g(cls, "putIntForUser", ContentResolver.class, String.class, cls2, cls2);
        try {
            methodG.setAccessible(true);
            Object objInvoke = methodG.invoke(null, this.f10608a.getContentResolver(), str, Integer.valueOf(i10), Integer.valueOf(i11));
            if (objInvoke == null || !(objInvoke instanceof Boolean)) {
                return false;
            }
            return ((Boolean) objInvoke).booleanValue();
        } catch (Throwable th2) {
            m7.a.a("putSecureIntForUser fail ", th2, f10604b);
            return false;
        }
    }

    @Override // wg.b
    public float d(ContentResolver contentResolver, String str, float f10, int i10) {
        Method methodG = cc.a.g(f10606d, "getFloatForUser", ContentResolver.class, String.class, Float.TYPE, Integer.TYPE);
        try {
            methodG.setAccessible(true);
            Object objInvoke = methodG.invoke(null, contentResolver, str, Float.valueOf(f10), Integer.valueOf(i10));
            return (objInvoke == null || !(objInvoke instanceof Float)) ? f10 : ((Float) objInvoke).floatValue();
        } catch (Throwable th2) {
            m7.a.a("getSystemFloatForUser fail ", th2, f10604b);
            return f10;
        }
    }

    @Override // wg.b
    public boolean e(String str, float f10, int i10) {
        Method methodG = cc.a.g(f10606d, "putFloatForUser", ContentResolver.class, String.class, Float.TYPE, Integer.TYPE);
        try {
            methodG.setAccessible(true);
            Object objInvoke = methodG.invoke(null, this.f10608a.getContentResolver(), str, Float.valueOf(f10), Integer.valueOf(i10));
            if (objInvoke == null || !(objInvoke instanceof Boolean)) {
                return false;
            }
            return ((Boolean) objInvoke).booleanValue();
        } catch (Throwable th2) {
            m7.a.a("putSystemFloatForUser fail ", th2, f10604b);
            return false;
        }
    }

    @Override // wg.b
    public boolean f(String str, String str2, int i10) {
        Method methodG = cc.a.g(f10605c, "putStringForUser", ContentResolver.class, String.class, String.class, Integer.TYPE);
        try {
            methodG.setAccessible(true);
            Object objInvoke = methodG.invoke(null, this.f10608a.getContentResolver(), str, str2, Integer.valueOf(i10));
            if (objInvoke == null || !(objInvoke instanceof Boolean)) {
                return false;
            }
            return ((Boolean) objInvoke).booleanValue();
        } catch (Throwable th2) {
            m7.a.a("putSecureStringForUser fail ", th2, f10604b);
            return false;
        }
    }

    @Override // wg.b
    public boolean g(Context context, String str, int i10) {
        Object objJ = cc.a.j(cc.a.g(f10605c, "putInt", ContentResolver.class, String.class, Integer.TYPE), null, context.getContentResolver(), str, Integer.valueOf(i10));
        if (objJ instanceof Boolean) {
            return ((Boolean) objJ).booleanValue();
        }
        return false;
    }

    @Override // wg.b
    public boolean h(ContentResolver contentResolver, String str, String str2, int i10) {
        Method methodG = cc.a.g(f10605c, "putStringForUser", ContentResolver.class, String.class, String.class, Integer.TYPE);
        try {
            methodG.setAccessible(true);
            Object objInvoke = methodG.invoke(null, contentResolver, str, str2, Integer.valueOf(i10));
            if (objInvoke == null || !(objInvoke instanceof Boolean)) {
                return false;
            }
            return ((Boolean) objInvoke).booleanValue();
        } catch (Throwable th2) {
            m7.a.a("putSecureStringForUser fail ", th2, f10604b);
            return false;
        }
    }

    @Override // wg.b
    public int i(String str, int i10, int i11) {
        Class<?> cls = f10605c;
        Class cls2 = Integer.TYPE;
        Method methodG = cc.a.g(cls, "getIntForUser", ContentResolver.class, String.class, cls2, cls2);
        try {
            methodG.setAccessible(true);
            Object objInvoke = methodG.invoke(null, this.f10608a.getContentResolver(), str, Integer.valueOf(i10), Integer.valueOf(i11));
            return (objInvoke == null || !(objInvoke instanceof Integer)) ? i10 : ((Integer) objInvoke).intValue();
        } catch (Throwable th2) {
            m7.a.a("getSecureIntForUser fail ", th2, f10604b);
            return i10;
        }
    }

    @Override // wg.b
    public String j(String str, int i10) {
        Method methodG = cc.a.g(f10605c, "getStringForUser", ContentResolver.class, String.class, Integer.TYPE);
        try {
            methodG.setAccessible(true);
            Object objInvoke = methodG.invoke(null, this.f10608a.getContentResolver(), str, Integer.valueOf(i10));
            if (objInvoke == null || !(objInvoke instanceof String)) {
                return null;
            }
            return (String) objInvoke;
        } catch (Throwable th2) {
            m7.a.a("getSecureStringForUser fail ", th2, f10604b);
            return null;
        }
    }

    @Override // wg.b
    public boolean k(ContentResolver contentResolver, String str, int i10, int i11) {
        Class<?> cls = f10605c;
        Class cls2 = Integer.TYPE;
        Method methodG = cc.a.g(cls, "putIntForUser", ContentResolver.class, String.class, cls2, cls2);
        try {
            methodG.setAccessible(true);
            Object objInvoke = methodG.invoke(null, contentResolver, str, Integer.valueOf(i10), Integer.valueOf(i11));
            if (objInvoke == null || !(objInvoke instanceof Boolean)) {
                return false;
            }
            return ((Boolean) objInvoke).booleanValue();
        } catch (Throwable th2) {
            m7.a.a("putSecureIntForUser fail ", th2, f10604b);
            return false;
        }
    }

    @Override // wg.b
    public boolean l(Context context, String str, int i10) {
        Object objJ = cc.a.j(cc.a.g(f10607e, "putInt", ContentResolver.class, String.class, Integer.TYPE), null, context.getContentResolver(), str, Integer.valueOf(i10));
        if (objJ instanceof Boolean) {
            return ((Boolean) objJ).booleanValue();
        }
        return false;
    }

    @Override // wg.b
    public boolean m(ContentResolver contentResolver, String str, float f10, int i10) {
        Method methodG = cc.a.g(f10606d, "putFloatForUser", ContentResolver.class, String.class, Float.TYPE, Integer.TYPE);
        try {
            methodG.setAccessible(true);
            Object objInvoke = methodG.invoke(null, contentResolver, str, Float.valueOf(f10), Integer.valueOf(i10));
            if (objInvoke == null || !(objInvoke instanceof Boolean)) {
                return false;
            }
            return ((Boolean) objInvoke).booleanValue();
        } catch (Throwable th2) {
            m7.a.a("putSystemFloatForUser fail ", th2, f10604b);
            return false;
        }
    }

    @Override // wg.b
    public long n(ContentResolver contentResolver, String str, long j10, int i10) {
        Method methodG = cc.a.g(f10606d, "getLongForUser", ContentResolver.class, String.class, Long.TYPE, Integer.TYPE);
        return methodG != null ? ((Long) cc.a.j(methodG, null, contentResolver, str, Long.valueOf(j10), Integer.valueOf(i10))).longValue() : j10;
    }

    @Override // wg.b
    public float o(String str, float f10, int i10) {
        Method methodG = cc.a.g(f10606d, "getFloatForUser", ContentResolver.class, String.class, Float.TYPE, Integer.TYPE);
        try {
            methodG.setAccessible(true);
            Object objInvoke = methodG.invoke(null, this.f10608a.getContentResolver(), str, Float.valueOf(f10), Integer.valueOf(i10));
            return (objInvoke == null || !(objInvoke instanceof Float)) ? f10 : ((Float) objInvoke).floatValue();
        } catch (Throwable th2) {
            m7.a.a("getSystemFloatForUser fail ", th2, f10604b);
            return f10;
        }
    }
}
