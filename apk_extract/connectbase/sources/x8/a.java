package x8;

import android.app.ActivityManager;
import android.content.Context;
import dc.e;
import java.lang.reflect.InvocationTargetException;

/* JADX INFO: loaded from: classes2.dex */
public class a implements ih.a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f20120c = "TranAospUsfManager";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f20121d = "android.app.ActivityManager";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ActivityManager f20122a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Class<?> f20123b;

    public a() {
        this.f20122a = null;
        this.f20123b = null;
        Context contextA = bc.a.a();
        if (contextA == null) {
            e.n(f20120c, "THUB SDK NOT INIT, context is null");
            return;
        }
        this.f20122a = (ActivityManager) contextA.getSystemService("activity");
        try {
            this.f20123b = Class.forName(f20121d);
        } catch (ClassNotFoundException unused) {
            e.n(f20120c, "Class not found: android.app.ActivityManager");
        }
    }

    @Override // ih.a
    public boolean a(boolean z10) {
        Class<?> cls;
        if (this.f20122a == null || (cls = this.f20123b) == null) {
            return false;
        }
        try {
            Object objInvoke = cls.getDeclaredMethod("enableFastFreezer", Boolean.TYPE).invoke(this.f20122a, Boolean.valueOf(z10));
            if (objInvoke != null) {
                return ((Boolean) objInvoke).booleanValue();
            }
            return false;
        } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
            e.n(f20120c, "Method not found: enableFastFreezer");
            return false;
        }
    }

    @Override // ih.a
    public boolean b(String str) {
        Class<?> cls;
        if (this.f20122a == null || (cls = this.f20123b) == null) {
            return false;
        }
        try {
            Object objInvoke = cls.getDeclaredMethod("isWhiteApp", String.class).invoke(this.f20122a, str);
            if (objInvoke != null) {
                return ((Boolean) objInvoke).booleanValue();
            }
            return false;
        } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
            e.n(f20120c, "Method not found: isWhiteApp");
            return false;
        }
    }

    @Override // ih.a
    public void c(int i10, int i11) {
        Class<?> cls;
        if (this.f20122a == null || (cls = this.f20123b) == null) {
            return;
        }
        try {
            Class cls2 = Integer.TYPE;
            cls.getDeclaredMethod("setAppMode", cls2, cls2).invoke(this.f20122a, Integer.valueOf(i10), Integer.valueOf(i11));
        } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
            e.n(f20120c, "Method not found: setAppMode");
        }
    }

    @Override // ih.a
    public int[] d(int i10) {
        Class<?> cls;
        if (this.f20122a != null && (cls = this.f20123b) != null) {
            try {
                Object objInvoke = cls.getDeclaredMethod("getAppListMode", Integer.TYPE).invoke(this.f20122a, Integer.valueOf(i10));
                if (objInvoke != null) {
                    return (int[]) objInvoke;
                }
            } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
                e.n(f20120c, "Method not found: getAppListMode");
            }
        }
        return new int[0];
    }

    @Override // ih.a
    public void e(boolean z10) {
        Class<?> cls;
        if (this.f20122a == null || (cls = this.f20123b) == null) {
            return;
        }
        try {
            cls.getDeclaredMethod("enableHiber", Boolean.TYPE).invoke(this.f20122a, Boolean.valueOf(z10));
        } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
            e.n(f20120c, "Method not found: enableHiber");
        }
    }

    @Override // ih.a
    public boolean f() {
        Class<?> cls;
        if (this.f20122a == null || (cls = this.f20123b) == null) {
            return false;
        }
        try {
            Object objInvoke = cls.getDeclaredMethod("isEnabledHiber", null).invoke(this.f20122a, null);
            if (objInvoke != null) {
                return ((Boolean) objInvoke).booleanValue();
            }
            return false;
        } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
            e.n(f20120c, "Method not found: isEnabledHiber");
            return false;
        }
    }

    @Override // ih.a
    public String g(int i10, String str) {
        Class<?> cls;
        if (this.f20122a == null || (cls = this.f20123b) == null) {
            return "";
        }
        try {
            Object objInvoke = cls.getDeclaredMethod("getUnfreezeReason", Integer.TYPE, String.class).invoke(this.f20122a, Integer.valueOf(i10), str);
            return objInvoke != null ? (String) objInvoke : "";
        } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
            e.n(f20120c, "Method not found: getUnfreezeReason");
            return "";
        }
    }

    @Override // ih.a
    public int h(int i10) {
        Class<?> cls;
        if (this.f20122a == null || (cls = this.f20123b) == null) {
            return -1;
        }
        try {
            Object objInvoke = cls.getDeclaredMethod("getAppMode", Integer.TYPE).invoke(this.f20122a, Integer.valueOf(i10));
            if (objInvoke != null) {
                return ((Integer) objInvoke).intValue();
            }
            return -1;
        } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
            e.n(f20120c, "Method not found: getAppMode");
            return -1;
        }
    }

    @Override // ih.a
    public boolean i(int i10) {
        Class<?> cls;
        if (this.f20122a == null || (cls = this.f20123b) == null) {
            return false;
        }
        try {
            Object objInvoke = cls.getDeclaredMethod("isRuntimeWhiteApp", Integer.TYPE).invoke(this.f20122a, Integer.valueOf(i10));
            if (objInvoke != null) {
                return ((Boolean) objInvoke).booleanValue();
            }
            return false;
        } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
            e.n(f20120c, "Method not found: isRuntimeWhiteApp");
            return false;
        }
    }

    @Override // ih.a
    public boolean j() {
        Class<?> cls;
        if (this.f20122a == null || (cls = this.f20123b) == null) {
            return false;
        }
        try {
            Object objInvoke = cls.getDeclaredMethod("isEnableNightNetwork", null).invoke(this.f20122a, null);
            if (objInvoke != null) {
                return ((Boolean) objInvoke).booleanValue();
            }
            return false;
        } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
            e.n(f20120c, "Method not found: isEnableNightNetwork");
            return false;
        }
    }

    @Override // ih.a
    public void k(boolean z10) {
        Class<?> cls;
        if (this.f20122a == null || (cls = this.f20123b) == null) {
            return;
        }
        try {
            cls.getDeclaredMethod("enableNightNetwork", Boolean.TYPE).invoke(this.f20122a, Boolean.valueOf(z10));
        } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
            e.n(f20120c, "Method not found: enableNightNetwork");
        }
    }

    @Override // ih.a
    public int l(int i10, String str) {
        Class<?> cls;
        if (this.f20122a == null || (cls = this.f20123b) == null) {
            return 0;
        }
        try {
            Object objInvoke = cls.getDeclaredMethod("freeze", Integer.TYPE, String.class).invoke(this.f20122a, Integer.valueOf(i10), str);
            if (objInvoke != null) {
                return ((Integer) objInvoke).intValue();
            }
            return 0;
        } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
            e.n(f20120c, "Method not found: freeze");
            return 0;
        }
    }

    @Override // ih.a
    public void m(String str, long j10) {
        Class<?> cls;
        if (this.f20122a == null || (cls = this.f20123b) == null) {
            return;
        }
        try {
            cls.getDeclaredMethod("fastFreezeTemporarily", String.class, Long.TYPE).invoke(this.f20122a, str, Long.valueOf(j10));
        } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
            e.n(f20120c, "Method not found: fastFreezeTemporarily");
        }
    }

    @Override // ih.a
    public boolean n(int i10, boolean z10) {
        Class<?> cls;
        if (this.f20122a == null || (cls = this.f20123b) == null) {
            return false;
        }
        try {
            if (!z10) {
                cls.getDeclaredMethod("removeWhiteApp", Integer.TYPE).invoke(this.f20122a, Integer.valueOf(i10));
                return true;
            }
            Object objInvoke = cls.getDeclaredMethod("addWhiteApp", Integer.TYPE).invoke(this.f20122a, Integer.valueOf(i10));
            if (objInvoke != null) {
                return ((Boolean) objInvoke).booleanValue();
            }
            return false;
        } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
            e.n(f20120c, "Method not found: addRuntimeWhiteApp");
            return false;
        }
    }

    @Override // ih.a
    public void o(String str) {
        Class<?> cls;
        if (this.f20122a == null || (cls = this.f20123b) == null) {
            return;
        }
        try {
            cls.getDeclaredMethod("fastFreeze", String.class).invoke(this.f20122a, str);
        } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
            e.n(f20120c, "Method not found: fastFreeze");
        }
    }

    @Override // ih.a
    public void p(int i10, String str, String str2) {
        Class<?> cls;
        if (this.f20122a == null || (cls = this.f20123b) == null) {
            return;
        }
        try {
            cls.getDeclaredMethod("unfreeze", Integer.TYPE, String.class, String.class).invoke(this.f20122a, Integer.valueOf(i10), str, str2);
        } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
            e.n(f20120c, "Method not found: unfreeze");
        }
    }

    @Override // ih.a
    public boolean q() {
        Class<?> cls;
        if (this.f20122a == null || (cls = this.f20123b) == null) {
            return false;
        }
        try {
            Object objInvoke = cls.getDeclaredMethod("isFastFreezerEnable", null).invoke(this.f20122a, null);
            if (objInvoke != null) {
                return ((Boolean) objInvoke).booleanValue();
            }
            return false;
        } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
            e.n(f20120c, "Method not found: isFastFreezerEnable");
            return false;
        }
    }

    @Override // ih.a
    public void r(String str) {
        Class<?> cls;
        if (this.f20122a == null || (cls = this.f20123b) == null) {
            return;
        }
        try {
            cls.getDeclaredMethod("fastUnfreeze", String.class).invoke(this.f20122a, str);
        } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
            e.n(f20120c, "Method not found: fastUnfreeze");
        }
    }
}
