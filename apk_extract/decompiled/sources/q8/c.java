package q8;

import java.lang.reflect.Method;
import k3.o9;

/* JADX INFO: loaded from: classes2.dex */
public final class c implements ga.c {
    static {
        o9.a("android.view.IWindowManager$Stub");
        o9.a("android.os.ServiceManager");
    }

    @Override // ga.c
    public final int a() {
        Method methodD;
        Object objE = o9.e(null, o9.d(o9.a("android.view.WindowManagerGlobal"), "getWindowManagerService", new Class[0]), new Object[0]);
        if (objE == null || (methodD = o9.d(objE.getClass(), "getSwitchMode", new Class[0])) == null) {
            return 0;
        }
        return ((Integer) o9.e(objE, methodD, new Object[0])).intValue();
    }
}
