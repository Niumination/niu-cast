package b9;

import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes2.dex */
public class f implements lh.g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f763a = "f";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Class<?> f764b = cc.a.a("android.view.ScrollCaptureResponse");

    @Override // lh.g
    public Object a(Object obj) {
        try {
            Method methodG = cc.a.g(f764b, "getConnection", new Class[0]);
            methodG.setAccessible(true);
            return methodG.invoke(obj, null);
        } catch (Throwable th2) {
            m7.a.a("getConnection fail ", th2, f763a);
            return null;
        }
    }
}
