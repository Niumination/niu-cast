package e8;

import java.io.File;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes2.dex */
public class e implements pg.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f4104a = "e";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Class<?> f4105b = cc.a.a("android.os.Environment");

    @Override // pg.e
    public File a() {
        try {
            Method methodG = cc.a.g(f4105b, "getProductDirectory", new Class[0]);
            methodG.setAccessible(true);
            Object objInvoke = methodG.invoke(null, null);
            if (objInvoke == null || !(objInvoke instanceof File)) {
                return null;
            }
            return (File) objInvoke;
        } catch (Throwable th2) {
            m7.a.a("getProductDirectory fail ", th2, f4104a);
            return null;
        }
    }

    @Override // pg.e
    public File b(int i10) {
        try {
            Object objJ = cc.a.j(cc.a.g(f4105b, "getDataVendorDeDirectory", Integer.TYPE), null, Integer.valueOf(i10));
            if (objJ == null || !(objJ instanceof File)) {
                return null;
            }
            return (File) objJ;
        } catch (Throwable th2) {
            m7.a.a("getDataVendorDeDirectory fail ", th2, f4104a);
            return null;
        }
    }

    @Override // pg.e
    public File[] c(String str) {
        try {
            Method methodG = cc.a.g(f4105b, "buildExternalStorageAppDataDirs", String.class);
            methodG.setAccessible(true);
            Object objInvoke = methodG.invoke(null, str);
            if (objInvoke == null || !(objInvoke instanceof File[])) {
                return null;
            }
            return (File[]) objInvoke;
        } catch (Throwable th2) {
            m7.a.a("buildExternalStorageAppDataDirs fail ", th2, f4104a);
            return null;
        }
    }
}
