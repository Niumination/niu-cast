package e8;

import java.io.File;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes2.dex */
public class n implements pg.j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f4124a = "n";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Class<?> f4125b = cc.a.a("android.os.SELinux");

    @Override // pg.j
    public boolean a(File file) {
        Method methodG = cc.a.g(f4125b, "restorecon", File.class);
        try {
            methodG.setAccessible(true);
            Object objInvoke = methodG.invoke(null, file);
            if (objInvoke == null || !(objInvoke instanceof Boolean)) {
                return false;
            }
            return ((Boolean) objInvoke).booleanValue();
        } catch (Throwable th2) {
            m7.a.a("restorecon fail ", th2, f4124a);
            return false;
        }
    }
}
