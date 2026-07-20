package e8;

import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes2.dex */
public class k implements pg.i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f4121a = "k";

    @Override // pg.i
    public String a() {
        try {
            Method methodG = cc.a.g(cc.a.a("android.os.Process"), "getAllCpuLoading", new Class[0]);
            if (methodG == null) {
                return "";
            }
            Object objInvoke = methodG.invoke(null, null);
            if (objInvoke instanceof String) {
                return (String) objInvoke;
            }
            return null;
        } catch (Throwable th2) {
            m7.a.a("getAllCpuLoading fail:", th2, f4121a);
            return null;
        }
    }

    @Override // pg.i
    public double b() {
        try {
            Method methodG = cc.a.g(cc.a.a("android.os.Process"), "getCpuInfo", new Class[0]);
            if (methodG == null) {
                return -1.0d;
            }
            Object objInvoke = methodG.invoke(null, null);
            if (objInvoke instanceof Double) {
                return ((Double) objInvoke).doubleValue();
            }
            return -1.0d;
        } catch (Throwable th2) {
            m7.a.a("getCpuInfo fail:", th2, f4121a);
            return -1.0d;
        }
    }
}
