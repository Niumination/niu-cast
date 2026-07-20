package x6;

import android.content.pm.ApplicationInfo;
import java.lang.reflect.Field;

/* JADX INFO: loaded from: classes2.dex */
public class b implements jf.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f20076a = "b";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Class<?> f20077b = cc.a.a("android.content.pm.ApplicationInfo");

    @Override // jf.b
    public boolean a(ApplicationInfo applicationInfo) {
        return Boolean.TRUE.equals(cc.a.j(cc.a.g(applicationInfo.getClass(), "isDirectBootAware", new Class[0]), applicationInfo, new Object[0]));
    }

    @Override // jf.b
    public boolean b(ApplicationInfo applicationInfo) {
        Object objJ = cc.a.j(cc.a.g(f20077b, "isSystemApp", new Class[0]), applicationInfo, new Object[0]);
        if (objJ instanceof Boolean) {
            return ((Boolean) objJ).booleanValue();
        }
        return false;
    }

    @Override // jf.b
    public boolean c(ApplicationInfo applicationInfo) {
        Object objJ = cc.a.j(cc.a.g(f20077b, "isProduct", new Class[0]), applicationInfo, new Object[0]);
        if (objJ instanceof Boolean) {
            return ((Boolean) objJ).booleanValue();
        }
        return false;
    }

    @Override // jf.b
    public boolean d(ApplicationInfo applicationInfo) {
        Object objJ = cc.a.j(cc.a.g(f20077b, "isSignedWithPlatformKey", new Class[0]), applicationInfo, new Object[0]);
        if (objJ instanceof Boolean) {
            return ((Boolean) objJ).booleanValue();
        }
        return false;
    }

    @Override // jf.b
    public boolean e(ApplicationInfo applicationInfo) {
        Object objJ = cc.a.j(cc.a.g(f20077b, "isSystemExt", new Class[0]), applicationInfo, new Object[0]);
        if (objJ instanceof Boolean) {
            return ((Boolean) objJ).booleanValue();
        }
        return false;
    }

    @Override // jf.b
    public boolean f(ApplicationInfo applicationInfo) {
        return Boolean.TRUE.equals(cc.a.j(cc.a.g(applicationInfo.getClass(), "isPrivilegedApp", new Class[0]), applicationInfo, new Object[0]));
    }

    @Override // jf.b
    public boolean g(ApplicationInfo applicationInfo) {
        Object objJ = cc.a.j(cc.a.g(applicationInfo.getClass(), "isInstantApp", new Class[0]), applicationInfo, new Object[0]);
        if (objJ instanceof Boolean) {
            return ((Boolean) objJ).booleanValue();
        }
        return false;
    }

    @Override // jf.b
    public int h(ApplicationInfo applicationInfo) {
        Field fieldD = cc.a.d(applicationInfo.getClass(), "iconRes");
        if (fieldD != null) {
            return ((Integer) cc.a.f(fieldD, applicationInfo)).intValue();
        }
        return -1;
    }

    @Override // jf.b
    public boolean i(ApplicationInfo applicationInfo) {
        return Boolean.TRUE.equals(cc.a.j(cc.a.g(applicationInfo.getClass(), "isPartiallyDirectBootAware", new Class[0]), applicationInfo, new Object[0]));
    }
}
