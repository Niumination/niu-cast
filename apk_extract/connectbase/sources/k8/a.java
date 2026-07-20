package k8;

import dc.e;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes2.dex */
public class a implements ug.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f9155a = "a";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Class<?> f9156b = cc.a.a("com.mediatek.pq.PictureQuality");

    @Override // ug.a
    public void a(int i10) {
        Method methodG = cc.a.g(f9156b, "setAALFunction", Integer.TYPE);
        if (methodG != null) {
            cc.a.j(methodG, null, Integer.valueOf(i10));
        }
    }

    @Override // ug.a
    public void b(int i10) {
        Method methodG = cc.a.g(f9156b, "setSmartBacklightStrength", Integer.TYPE);
        if (methodG != null) {
            cc.a.j(methodG, null, Integer.valueOf(i10));
        }
    }

    @Override // ug.a
    public void c(boolean z10) {
        Method methodG = cc.a.g(f9156b, "setAALFunction", Boolean.TYPE);
        if (methodG != null) {
            cc.a.j(methodG, null, Boolean.valueOf(z10));
        }
    }

    @Override // ug.a
    public int d() {
        try {
            return ((Integer) cc.a.g(f9156b, "getPictureMode", new Class[0]).invoke(null, null)).intValue();
        } catch (Exception e10) {
            e.c(f9155a, "getPictureMode " + e10.toString());
            return 0;
        }
    }

    @Override // ug.a
    public void e(int i10) {
        try {
            cc.a.g(f9156b, "setGammaIndex", Integer.TYPE).invoke(null, Integer.valueOf(i10));
        } catch (Exception e10) {
            e.c(f9155a, "setGammaIndex " + e10.toString());
        }
    }

    @Override // ug.a
    public void f(int i10) {
        try {
            cc.a.g(f9156b, "setPictureMode", Integer.TYPE).invoke(null, Integer.valueOf(i10));
        } catch (Exception e10) {
            e.c(f9155a, "setPictureMode " + e10.toString());
        }
    }

    @Override // ug.a
    public int g() {
        try {
            return ((Integer) cc.a.g(f9156b, "getGammaIndex", new Class[0]).invoke(null, null)).intValue();
        } catch (Exception e10) {
            e.c(f9155a, "getGammaIndex " + e10.toString());
            return 0;
        }
    }

    @Override // ug.a
    public int h() {
        Method methodG = cc.a.g(f9156b, "getAALFunction", new Class[0]);
        if (methodG != null) {
            return ((Integer) cc.a.j(methodG, null, new Object[0])).intValue();
        }
        return -1;
    }
}
