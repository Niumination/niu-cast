package p6;

import android.app.Activity;
import android.os.IBinder;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes2.dex */
public class d implements bf.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f12938a = "TranAospActivityClient";

    @Override // bf.c
    public void a(Activity activity, boolean z10) {
        Method methodG = cc.a.g(activity.getClass(), "getActivityToken", new Class[0]);
        Object objJ = null;
        IBinder iBinder = methodG != null ? (IBinder) cc.a.j(methodG, activity, new Object[0]) : null;
        Class clsA = cc.a.a("android.app.ActivityClient");
        Method methodG2 = cc.a.g(clsA, "getInstance", new Class[0]);
        if (methodG2 != null && clsA != null) {
            objJ = cc.a.j(methodG2, null, new Object[0]);
        }
        if (objJ != null) {
            Method methodG3 = cc.a.g(objJ.getClass(), "setBackToDynamicIsland", IBinder.class, Boolean.TYPE);
            if (methodG3 != null) {
                cc.a.j(methodG3, objJ, iBinder, Boolean.valueOf(z10));
            } else {
                dc.e.f(f12938a, "TranAospActivity setBackToDynamicIsland method is null!");
            }
        }
    }

    @Override // bf.c
    public void b(Activity activity, boolean z10) {
        Method methodG;
        Method methodG2 = cc.a.g(activity.getClass(), "getActivityToken", new Class[0]);
        Object objJ = null;
        IBinder iBinder = methodG2 != null ? (IBinder) cc.a.j(methodG2, activity, new Object[0]) : null;
        Class clsA = cc.a.a("android.app.ActivityClient");
        Method methodG3 = cc.a.g(clsA, "getInstance", new Class[0]);
        if (methodG3 != null && clsA != null) {
            objJ = cc.a.j(methodG3, null, new Object[0]);
        }
        if (objJ == null || (methodG = cc.a.g(objJ.getClass(), "setRecoveryWhenError", IBinder.class, Boolean.TYPE)) == null) {
            return;
        }
        cc.a.j(methodG, objJ, iBinder, Boolean.valueOf(z10));
    }
}
