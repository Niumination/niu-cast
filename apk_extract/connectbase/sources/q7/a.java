package q7;

import android.os.Handler;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes2.dex */
public class a implements bg.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f13864a = "a";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Class<?> f13865b = cc.a.a("com.android.internal.os.BackgroundThread");

    @Override // bg.a
    public Handler getHandler() {
        try {
            Method methodG = cc.a.g(f13865b, "getHandler", new Class[0]);
            methodG.setAccessible(true);
            Object objInvoke = methodG.invoke(null, null);
            if (objInvoke == null || !(objInvoke instanceof Handler)) {
                return null;
            }
            return (Handler) objInvoke;
        } catch (Throwable th2) {
            m7.a.a("getHandler fail ", th2, f13864a);
            return null;
        }
    }
}
