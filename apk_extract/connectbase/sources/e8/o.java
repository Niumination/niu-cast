package e8;

import android.os.IBinder;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes2.dex */
public class o implements pg.k {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f4126b = "o";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static Class<?> f4127c = cc.a.a("android.os.ServiceManager");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Method f4128a = null;

    @Override // pg.k
    public IBinder a(String str) {
        return (IBinder) cc.a.j(cc.a.g(f4127c, "checkService", String.class), null, str);
    }

    @Override // pg.k
    public String[] b() {
        if (this.f4128a == null) {
            this.f4128a = cc.a.g(f4127c, "listServices", new Class[0]);
        }
        String[] strArr = null;
        try {
            this.f4128a.setAccessible(true);
            Object objInvoke = this.f4128a.invoke(f4127c, null);
            if (objInvoke != null && (objInvoke instanceof String[])) {
                strArr = (String[]) objInvoke;
            }
            dc.e.f(f4126b, "listServices: " + strArr);
        } catch (Throwable th2) {
            m7.a.a("listServices: ", th2, f4126b);
        }
        return strArr;
    }
}
