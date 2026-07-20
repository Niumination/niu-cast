package t8;

import android.content.Context;
import android.telephony.TelephonyManager;
import com.android.internal.annotations.VisibleForTesting;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes2.dex */
public class f implements dh.f {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f15531d = "f";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static Class<?> f15532e = cc.a.a("android.telephony.TelephonyManager");

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static Class<?> f15533f = cc.a.a("android.telephony.ServiceState");

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f15534g = w();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f15535a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Object f15536b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public TelephonyManager f15537c;

    public f() {
        Context contextA = bc.a.a();
        this.f15535a = contextA;
        if (this.f15537c == null) {
            this.f15537c = (TelephonyManager) contextA.getSystemService("phone");
        }
    }

    public static int w() {
        Field fieldD;
        Class<?> cls = f15532e;
        if (cls == null || (fieldD = cc.a.d(cls, "DEFAULT_PREFERRED_NETWORK_MODE")) == null) {
            return 0;
        }
        return ((Integer) cc.a.f(fieldD, null)).intValue();
    }

    @Override // dh.f
    public String a(int i10) {
        Method methodG = cc.a.g(f15532e, "getSimOperatorName", Integer.TYPE);
        return methodG != null ? (String) cc.a.j(methodG, this.f15537c, Integer.valueOf(i10)) : "";
    }

    @Override // dh.f
    public int b(int i10) {
        Method methodG = cc.a.g(f15532e, "getSimStateForSlotIndex", Integer.TYPE);
        if (methodG != null) {
            return ((Integer) cc.a.j(methodG, this.f15537c, Integer.valueOf(i10))).intValue();
        }
        return 0;
    }

    @Override // dh.f
    public void c(boolean z10) {
        TelephonyManager telephonyManager = (TelephonyManager) this.f15535a.getSystemService("phone");
        cc.a.j(cc.a.g(telephonyManager.getClass(), "setDataEnabled", Boolean.TYPE), telephonyManager, Boolean.valueOf(z10));
    }

    @Override // dh.f
    public int d(int i10) {
        try {
            Method methodG = cc.a.g(f15532e, "getNetworkType", Integer.TYPE);
            methodG.setAccessible(true);
            Object objJ = cc.a.j(methodG, this.f15537c, Integer.valueOf(i10));
            if (objJ == null || !(objJ instanceof Integer)) {
                return 0;
            }
            return ((Integer) objJ).intValue();
        } catch (Throwable th2) {
            m7.a.a("getNetworkType fail ", th2, f15531d);
            return 0;
        }
    }

    @Override // dh.f
    public boolean e(int i10, String str) {
        TelephonyManager telephonyManager = (TelephonyManager) this.f15535a.getSystemService("phone");
        Object objJ = cc.a.j(cc.a.g(telephonyManager.getClass(), "getITelephony", new Class[0]), telephonyManager, new Object[0]);
        return ((Boolean) cc.a.j(cc.a.g(objJ.getClass(), "isRadioOnForSubscriber", Integer.TYPE, String.class), objJ, Integer.valueOf(i10), str)).booleanValue();
    }

    @Override // dh.f
    public int f() {
        Method methodG = cc.a.g(f15532e, "getSlotIndex", new Class[0]);
        if (methodG != null) {
            return ((Integer) cc.a.j(methodG, this.f15537c, new Object[0])).intValue();
        }
        return -1;
    }

    @Override // dh.f
    public boolean g(String str) {
        try {
            if (this.f15537c == null) {
                this.f15537c = (TelephonyManager) this.f15535a.getSystemService("phone");
            }
            Method methodG = cc.a.g(f15532e, "isPotentialEmergencyNumber", String.class);
            methodG.setAccessible(true);
            Object objInvoke = methodG.invoke(this.f15537c, str);
            if (objInvoke == null || !(objInvoke instanceof Boolean)) {
                return false;
            }
            return ((Boolean) objInvoke).booleanValue();
        } catch (Throwable th2) {
            m7.a.a("isPotentialEmergencyNumber fail ", th2, f15531d);
            return false;
        }
    }

    @Override // dh.f
    public String h() {
        return (String) cc.a.j(cc.a.g(f15532e, "getSimOperator", new Class[0]), this.f15537c, new Object[0]);
    }

    @Override // dh.f
    public String i() {
        return (String) cc.a.j(cc.a.g(f15532e, "getNai", new Class[0]), this.f15537c, new Object[0]);
    }

    @Override // dh.f
    public String j(int i10) {
        return (String) cc.a.j(cc.a.g(f15532e, "getNai", Integer.TYPE), this.f15537c, Integer.valueOf(i10));
    }

    @Override // dh.f
    public String k() {
        try {
            Method methodG = cc.a.g(f15532e, "getLine1Number", new Class[0]);
            methodG.setAccessible(true);
            Object objJ = cc.a.j(methodG, this.f15537c, new Object[0]);
            if (objJ == null || !(objJ instanceof String)) {
                return null;
            }
            return (String) objJ;
        } catch (Throwable th2) {
            m7.a.a("getLine1Number fail ", th2, f15531d);
            return null;
        }
    }

    @Override // dh.f
    public String l(int i10) {
        try {
            Method methodG = cc.a.g(f15532e, "getLine1Number", Integer.TYPE);
            methodG.setAccessible(true);
            Object objJ = cc.a.j(methodG, this.f15537c, Integer.valueOf(i10));
            if (objJ == null || !(objJ instanceof String)) {
                return null;
            }
            return (String) objJ;
        } catch (Throwable th2) {
            m7.a.a("getLine1NumberBySubId fail ", th2, f15531d);
            return null;
        }
    }

    @Override // dh.f
    public jb.d m() {
        try {
            if (this.f15536b == null) {
                this.f15536b = cc.a.c(f15532e, new Class[]{Context.class}).newInstance(this.f15535a);
            }
            int iIntValue = 0;
            Method methodG = cc.a.g(f15532e, "getServiceState", new Class[0]);
            methodG.setAccessible(true);
            Object objInvoke = methodG.invoke(this.f15536b, null);
            Method methodG2 = cc.a.g(f15533f, "getState", new Class[0]);
            Method methodG3 = cc.a.g(f15533f, "getOperatorNumeric", new Class[0]);
            Method methodG4 = cc.a.g(f15533f, "getDataRoamingType", new Class[0]);
            if (objInvoke != null) {
                methodG2.setAccessible(true);
                Object objInvoke2 = methodG2.invoke(objInvoke, null);
                int iIntValue2 = (objInvoke2 == null || !(objInvoke2 instanceof Integer)) ? 0 : ((Integer) objInvoke2).intValue();
                methodG3.setAccessible(true);
                Object objInvoke3 = methodG3.invoke(objInvoke, null);
                String str = (objInvoke3 == null || !(objInvoke3 instanceof String)) ? null : (String) objInvoke3;
                methodG4.setAccessible(true);
                Object objInvoke4 = methodG4.invoke(objInvoke, null);
                if (objInvoke4 != null && (objInvoke4 instanceof Integer)) {
                    iIntValue = ((Integer) objInvoke4).intValue();
                }
                return new jb.d(iIntValue2, str, iIntValue);
            }
        } catch (Throwable th2) {
            m7.a.a("getServiceState fail ", th2, f15531d);
        }
        return null;
    }

    @Override // dh.f
    public int n() {
        try {
            if (this.f15536b == null) {
                this.f15536b = cc.a.c(f15532e, new Class[]{Context.class}).newInstance(this.f15535a);
            }
            Method methodG = cc.a.g(f15532e, "getRadioPowerState", new Class[0]);
            methodG.setAccessible(true);
            Object objInvoke = methodG.invoke(this.f15536b, null);
            if (objInvoke == null || !(objInvoke instanceof Integer)) {
                return 0;
            }
            return ((Integer) objInvoke).intValue();
        } catch (Throwable th2) {
            m7.a.a("getRadioPowerState fail ", th2, f15531d);
            return 0;
        }
    }

    @Override // dh.f
    public String o(int i10) {
        Method methodG = cc.a.g(f15532e, "getSimOperatorNumeric", Integer.TYPE);
        if (methodG != null) {
            return (String) cc.a.j(methodG, this.f15537c, Integer.valueOf(i10));
        }
        return null;
    }

    @Override // dh.f
    public boolean p() {
        try {
            if (this.f15536b == null) {
                this.f15536b = cc.a.c(f15532e, new Class[]{Context.class}).newInstance(this.f15535a);
            }
            Method methodG = cc.a.g(f15532e, "getDataEnabled", new Class[0]);
            methodG.setAccessible(true);
            Object objInvoke = methodG.invoke(this.f15536b, null);
            if (objInvoke == null || !(objInvoke instanceof Boolean)) {
                return false;
            }
            return ((Boolean) objInvoke).booleanValue();
        } catch (Throwable th2) {
            m7.a.a("getDataEnabled fail ", th2, f15531d);
            return false;
        }
    }

    @Override // dh.f
    public void q(int i10, boolean z10) {
        TelephonyManager telephonyManager = (TelephonyManager) this.f15535a.getSystemService("phone");
        cc.a.j(cc.a.g(telephonyManager.getClass(), "setDataEnabled", Integer.TYPE, Boolean.TYPE), telephonyManager, Integer.valueOf(i10), Boolean.valueOf(z10));
    }

    @Override // dh.f
    public boolean r(int i10) {
        Method methodG = cc.a.g(f15532e, "isNetworkRoaming", Integer.TYPE);
        if (methodG != null) {
            return ((Boolean) cc.a.j(methodG, this.f15537c, Integer.valueOf(i10))).booleanValue();
        }
        return false;
    }

    @Override // dh.f
    public int s() {
        Object objJ = cc.a.j(cc.a.g(this.f15537c.getClass(), "getSimState", new Class[0]), this.f15537c, new Object[0]);
        if (objJ instanceof Integer) {
            return ((Integer) objJ).intValue();
        }
        return 0;
    }

    @Override // dh.f
    public String t() {
        return (String) cc.a.j(cc.a.g(this.f15537c.getClass(), "getSubscriberId", new Class[0]), this.f15537c, new Object[0]);
    }

    @Override // dh.f
    public String u() {
        try {
            Method methodG = cc.a.g(f15532e, "getSimOperatorName", new Class[0]);
            methodG.setAccessible(true);
            Object objJ = cc.a.j(methodG, this.f15537c, new Object[0]);
            if (objJ == null || !(objJ instanceof String)) {
                return null;
            }
            return (String) objJ;
        } catch (Throwable th2) {
            m7.a.a("getSimOperatorName fail ", th2, f15531d);
            return null;
        }
    }

    @Override // dh.f
    public String v() {
        return (String) cc.a.j(cc.a.g(this.f15537c.getClass(), "getImei", new Class[0]), this.f15537c, new Object[0]);
    }

    @VisibleForTesting
    public void x(Object obj) {
        this.f15536b = obj;
    }
}
