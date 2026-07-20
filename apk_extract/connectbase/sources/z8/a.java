package z8;

import android.os.IBinder;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes2.dex */
public class a implements jh.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Class<?> f21871b = cc.a.a("com.transsion.hubsdk.TranServiceManager");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Object f21872a = g();

    @Override // jh.a
    public int a() {
        Object obj = this.f21872a;
        if (obj != null) {
            return ((Integer) cc.a.j(cc.a.g(obj.getClass(), "getTranSchedScene", new Class[0]), this.f21872a, new Object[0])).intValue();
        }
        return 0;
    }

    @Override // jh.a
    public boolean b(int i10) {
        Object obj = this.f21872a;
        if (obj != null) {
            return ((Boolean) cc.a.j(cc.a.g(obj.getClass(), "setTranSchedScene", Integer.TYPE), this.f21872a, Integer.valueOf(i10))).booleanValue();
        }
        return false;
    }

    @Override // jh.a
    public boolean c(int i10) {
        Object obj = this.f21872a;
        if (obj != null) {
            return ((Boolean) cc.a.j(cc.a.g(obj.getClass(), "cancelTranSchedUxTags", Integer.TYPE), this.f21872a, Integer.valueOf(i10))).booleanValue();
        }
        return false;
    }

    @Override // jh.a
    public long d(int i10) {
        Object obj = this.f21872a;
        if (obj != null) {
            return ((Long) cc.a.j(cc.a.g(obj.getClass(), "getTranSchedUxTags", Integer.TYPE), this.f21872a, Integer.valueOf(i10))).longValue();
        }
        return 0L;
    }

    @Override // jh.a
    public int e() {
        Object obj = this.f21872a;
        if (obj != null) {
            return ((Integer) cc.a.j(cc.a.g(obj.getClass(), "getTranSchedState", new Class[0]), this.f21872a, new Object[0])).intValue();
        }
        return 0;
    }

    @Override // jh.a
    public boolean f(int i10, String str) {
        Object obj = this.f21872a;
        if (obj != null) {
            return ((Boolean) cc.a.j(cc.a.g(obj.getClass(), "setTranSchedUxTagsByName", Integer.TYPE, String.class), this.f21872a, Integer.valueOf(i10), str)).booleanValue();
        }
        return false;
    }

    public final Object g() {
        Method methodG;
        Class<?> cls = f21871b;
        if (cls != null && (methodG = cc.a.g(cls, "getServiceIBinder", String.class)) != null) {
            IBinder iBinder = (IBinder) cc.a.j(methodG, null, "TranSchedService");
            Class clsA = cc.a.a("com.transsion.hubsdk.uiawarescheduling.ITranSchedManager$Stub");
            if (iBinder != null && clsA != null) {
                return cc.a.j(cc.a.g(clsA, "asInterface", IBinder.class), clsA, iBinder);
            }
        }
        return null;
    }
}
