package g7;

import android.content.Context;
import android.os.Bundle;
import com.android.internal.annotations.VisibleForTesting;

/* JADX INFO: loaded from: classes2.dex */
public class a implements rf.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f6427b = "a";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static Class<?> f6428c = cc.a.a("android.hardware.display.ColorDisplayManager");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Object f6429a = i();

    @Override // rf.a
    public void a(String str, int i10, boolean z10, int i11, int i12, Bundle bundle) {
        Class<?> cls = f6428c;
        Class cls2 = Integer.TYPE;
        cc.a.j(cc.a.g(cls, "setEyeCareEnabled", String.class, cls2, Boolean.TYPE, cls2, cls2, Bundle.class), this.f6429a, str, Integer.valueOf(i10), Boolean.valueOf(z10), Integer.valueOf(i11), Integer.valueOf(i12), bundle);
    }

    @Override // rf.a
    public int b(Context context) {
        Object objJ = cc.a.j(cc.a.g(f6428c, "getMaximumColorTemperature", Context.class), this.f6429a, context);
        if (objJ instanceof Integer) {
            return ((Integer) objJ).intValue();
        }
        return 0;
    }

    @Override // rf.a
    public boolean c(Context context) {
        Object objJ = cc.a.j(cc.a.g(f6428c, "isNightDisplayAvailable", Context.class), this.f6429a, context);
        if (objJ instanceof Boolean) {
            return ((Boolean) objJ).booleanValue();
        }
        return false;
    }

    @Override // rf.a
    public boolean d(boolean z10) {
        Object objJ = cc.a.j(cc.a.g(f6428c, "setNightDisplayActivated", Boolean.TYPE), this.f6429a, Boolean.valueOf(z10));
        if (objJ instanceof Boolean) {
            return ((Boolean) objJ).booleanValue();
        }
        return false;
    }

    @Override // rf.a
    public boolean e() {
        Object objJ = cc.a.j(cc.a.g(f6428c, "isNightDisplayActivated", new Class[0]), this.f6429a, new Object[0]);
        if (objJ instanceof Boolean) {
            return ((Boolean) objJ).booleanValue();
        }
        return false;
    }

    @Override // rf.a
    public int f(Context context) {
        Object objJ = cc.a.j(cc.a.g(f6428c, "getMinimumColorTemperature", Context.class), this.f6429a, context);
        if (objJ instanceof Integer) {
            return ((Integer) objJ).intValue();
        }
        return 0;
    }

    @Override // rf.a
    public int g() {
        Object objJ = cc.a.j(cc.a.g(f6428c, "getNightDisplayColorTemperature", new Class[0]), this.f6429a, new Object[0]);
        if (objJ instanceof Integer) {
            return ((Integer) objJ).intValue();
        }
        return 0;
    }

    @Override // rf.a
    public boolean h(int i10) {
        Object objJ = cc.a.j(cc.a.g(f6428c, "setNightDisplayColorTemperature", Integer.TYPE), this.f6429a, Integer.valueOf(i10));
        if (objJ instanceof Boolean) {
            return ((Boolean) objJ).booleanValue();
        }
        return false;
    }

    public final Object i() {
        if (this.f6429a == null) {
            try {
                this.f6429a = cc.a.c(f6428c, new Class[0]).newInstance(null);
            } catch (Exception e10) {
                p6.b.a("newInstance fail :", e10, f6427b);
            }
        }
        return this.f6429a;
    }

    @VisibleForTesting
    public void j(Object obj) {
        this.f6429a = obj;
    }
}
