package p6;

import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes2.dex */
public class p implements bf.k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Class<?> f13009a = cc.a.a("com.transsion.appsettings.FollowDisplayOrientationManager");

    @Override // bf.k
    public Object a(String str, int i10) {
        Method methodG;
        Object objG = g();
        if (objG == null || (methodG = cc.a.g(objG.getClass(), "setFollowDisplayOrientationType", String.class, Integer.TYPE)) == null) {
            return null;
        }
        return cc.a.j(methodG, objG, str, Integer.valueOf(i10));
    }

    @Override // bf.k
    public Object b(String str, boolean z10) {
        Method methodG;
        Object objG = g();
        if (objG == null || (methodG = cc.a.g(objG.getClass(), "setEnabledPackage", String.class, Boolean.TYPE)) == null) {
            return null;
        }
        return cc.a.j(methodG, objG, str, Boolean.valueOf(z10));
    }

    @Override // bf.k
    public int c(String str) {
        Method methodG;
        Object objJ;
        Object objG = g();
        if (objG == null || (methodG = cc.a.g(objG.getClass(), "getFollowDisplayOrientionType", String.class)) == null || (objJ = cc.a.j(methodG, objG, str)) == null) {
            return -2;
        }
        return ((Integer) objJ).intValue();
    }

    @Override // bf.k
    public void d() {
        Method methodG;
        Object objG = g();
        if (objG == null || (methodG = cc.a.g(objG.getClass(), "commit", new Class[0])) == null) {
            return;
        }
        cc.a.j(methodG, objG, new Object[0]);
    }

    @Override // bf.k
    public void e() {
        Method methodG;
        Object objG = g();
        if (objG == null || (methodG = cc.a.g(objG.getClass(), "init", new Class[0])) == null) {
            return;
        }
        cc.a.j(methodG, objG, new Object[0]);
    }

    @Override // bf.k
    public boolean f(String str) {
        Method methodG;
        Object objG = g();
        if (objG == null || (methodG = cc.a.g(objG.getClass(), "isEnabledPackage", String.class)) == null) {
            return false;
        }
        return Boolean.TRUE.equals(cc.a.j(methodG, objG, str));
    }

    public final Object g() {
        Method methodG;
        Class<?> cls = f13009a;
        if (cls == null || (methodG = cc.a.g(cls, "instance", new Class[0])) == null) {
            return null;
        }
        return cc.a.j(methodG, null, new Object[0]);
    }
}
