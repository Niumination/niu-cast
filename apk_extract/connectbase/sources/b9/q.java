package b9;

import android.os.IBinder;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes2.dex */
public class q implements lh.q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f789a = q8.a.class.getSimpleName();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Class<?> f790b = cc.a.a("android.view.WindowManagerGlobal");

    @Override // lh.q
    public void a(IBinder iBinder, String str, String str2) {
        try {
            Method methodG = cc.a.g(f790b, "getInstance", new Class[0]);
            methodG.setAccessible(true);
            Object objInvoke = methodG.invoke(null, null);
            Method methodG2 = cc.a.g(f790b, "closeAll", IBinder.class, String.class, String.class);
            methodG2.setAccessible(true);
            methodG2.invoke(objInvoke, iBinder, str, str2);
        } catch (Throwable th2) {
            m7.a.a("closeAll fail ", th2, f789a);
        }
    }
}
