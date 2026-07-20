package t8;

import android.content.Context;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes2.dex */
public class g implements dh.g {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f15538b = "g";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static Class<?> f15539c = cc.a.a("com.transsion.telephony.TranTelephonyManagerEx");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f15540a = bc.a.a();

    @Override // dh.g
    public void a() {
        try {
            Method method = f15539c.getMethod("getDefault", null);
            Object objInvoke = method != null ? method.invoke(null, null) : null;
            Method method2 = f15539c.getMethod("enterDeviceLock", null);
            if (method2 != null) {
                method2.invoke(objInvoke, null);
            }
        } catch (Throwable th2) {
            m7.a.a("enterDeviceLock fail ", th2, f15538b);
        }
    }

    @Override // dh.g
    public int b(int i10, String str) {
        Class clsA = cc.a.a("com.transsion.telephony.TranTelephonyManagerEx");
        Method methodG = cc.a.g(clsA, "getDefault", new Class[0]);
        Object objJ = methodG != null ? cc.a.j(methodG, null, new Object[0]) : null;
        Method methodG2 = cc.a.g(clsA, "supplyNetworkDepersonalization", Integer.TYPE, String.class);
        if (methodG2 == null || objJ == null) {
            return 1;
        }
        return ((Integer) cc.a.j(methodG2, objJ, Integer.valueOf(i10), str)).intValue();
    }

    @Override // dh.g
    public int c() {
        try {
            Method method = f15539c.getMethod("getDefault", null);
            Object objInvoke = method != null ? method.invoke(null, null) : null;
            Method method2 = f15539c.getMethod("queryDeviceLockedStatus", null);
            if (method2 != null) {
                return ((Integer) method2.invoke(objInvoke, null)).intValue();
            }
            return -1;
        } catch (Exception e10) {
            p6.b.a("queryDeviceLockedStatus fail ", e10, f15538b);
            return -1;
        }
    }

    @Override // dh.g
    public void d(int i10) {
        try {
            Method method = f15539c.getMethod("getDefault", null);
            Object objInvoke = method != null ? method.invoke(null, null) : null;
            Method method2 = f15539c.getMethod("exitDeviceLock", Integer.TYPE);
            if (method2 != null) {
                method2.invoke(objInvoke, Integer.valueOf(i10));
            }
        } catch (Throwable th2) {
            m7.a.a("exitDeviceLock fail ", th2, f15538b);
        }
    }

    @Override // dh.g
    public String e(String str) {
        try {
            Method method = f15539c.getMethod("getDefault", null);
            Object objInvoke = method != null ? method.invoke(null, null) : null;
            Method method2 = f15539c.getMethod("getOperatorCoverageUrl", String.class);
            if (method2 != null) {
                return (String) method2.invoke(objInvoke, str);
            }
        } catch (Exception e10) {
            p6.b.a("getOperatorCoverageUrl fail ", e10, f15538b);
        }
        return null;
    }
}
