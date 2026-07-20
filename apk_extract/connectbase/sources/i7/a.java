package i7;

import android.hardware.fingerprint.FingerprintManager;
import android.os.IBinder;
import com.transsion.hubsdk.api.hardware.fingerprint.TranFingerprintInfo;
import dc.e;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class a implements tf.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f7743b = "a";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static Class<?> f7744c = cc.a.a("android.hardware.fingerprint.IFingerprintService$Stub");

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static Class<?> f7745d = cc.a.a("android.os.ServiceManager");

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static Class<?> f7746e = cc.a.a("android.hardware.fingerprint.Fingerprint");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final FingerprintManager f7747a = (FingerprintManager) bc.a.a().getSystemService("fingerprint");

    @Override // tf.a
    public boolean a() {
        Object objJ = cc.a.j(cc.a.g(this.f7747a.getClass(), "isAuthenticating", new Class[0]), this.f7747a, new Object[0]);
        if (objJ instanceof Boolean) {
            return ((Boolean) objJ).booleanValue();
        }
        return false;
    }

    @Override // tf.a
    public void b(boolean z10) throws ac.a {
        Method methodG;
        Object objJ;
        Class clsA = cc.a.a("com.transsion.hubsdk.TranServiceManager");
        if (clsA == null || (methodG = cc.a.g(clsA, "getServiceIBinder", String.class)) == null) {
            return;
        }
        IBinder iBinder = (IBinder) cc.a.j(methodG, null, "fingerprint");
        Class clsA2 = cc.a.a("com.transsion.hubsdk.hardware.fingerprint.ITranFingerprintService$Stub");
        if (iBinder == null || clsA2 == null || (objJ = cc.a.j(cc.a.g(clsA2, "asInterface", IBinder.class), clsA2, iBinder)) == null) {
            return;
        }
        cc.a.j(cc.a.g(objJ.getClass(), "enterFingerNavigationMode", Boolean.TYPE), objJ, Boolean.valueOf(z10));
    }

    @Override // tf.a
    public List<TranFingerprintInfo> c(int i10) {
        Object objJ = cc.a.j(cc.a.g(this.f7747a.getClass(), "getEnrolledFingerprints", Integer.TYPE), this.f7747a, Integer.valueOf(i10));
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        if (objJ instanceof List) {
            for (Object obj : (List) objJ) {
                if (obj.getClass().equals(f7746e)) {
                    arrayList.add(f7746e.cast(obj));
                }
            }
        }
        if (arrayList.isEmpty()) {
            return arrayList2;
        }
        int i11 = 0;
        Method methodG = cc.a.g(f7746e, "getGroupId", new Class[0]);
        Method methodG2 = cc.a.g(f7746e, "getSubUserId", new Class[0]);
        Method methodG3 = cc.a.g(f7746e, "getName", new Class[0]);
        Method methodG4 = cc.a.g(f7746e, "getBiometricId", new Class[0]);
        Method methodG5 = cc.a.g(f7746e, "getDeviceId", new Class[0]);
        Method methodG6 = cc.a.g(f7746e, "getAppPkgName", new Class[0]);
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            Object next = it.next();
            if (f7746e.isInstance(next)) {
                e.f(f7743b, "fingerprint fingerprint :" + next);
            }
            Object objJ2 = cc.a.j(methodG, next, new Object[i11]);
            int iIntValue = objJ2 instanceof Integer ? ((Integer) objJ2).intValue() : i11;
            Object objJ3 = cc.a.j(methodG2, next, new Object[i11]);
            int iIntValue2 = objJ3 instanceof Integer ? ((Integer) objJ3).intValue() : i11;
            Object objJ4 = cc.a.j(methodG3, next, new Object[i11]);
            CharSequence charSequence = "";
            CharSequence charSequence2 = objJ4 instanceof CharSequence ? (CharSequence) objJ4 : "";
            Object objJ5 = cc.a.j(methodG4, next, new Object[i11]);
            int iIntValue3 = objJ5 instanceof Integer ? ((Integer) objJ5).intValue() : i11;
            Object objJ6 = cc.a.j(methodG5, next, new Object[i11]);
            Method method = methodG;
            Iterator it2 = it;
            Method method2 = methodG2;
            long jLongValue = objJ6 instanceof Long ? ((Long) objJ6).longValue() : 0L;
            Object objJ7 = cc.a.j(methodG6, next, new Object[0]);
            if (objJ7 instanceof CharSequence) {
                charSequence = (CharSequence) objJ7;
            }
            TranFingerprintInfo tranFingerprintInfo = new TranFingerprintInfo();
            tranFingerprintInfo.f2216c = iIntValue2;
            tranFingerprintInfo.f2217d = charSequence2;
            tranFingerprintInfo.f2215b = charSequence;
            tranFingerprintInfo.f2219f = jLongValue;
            tranFingerprintInfo.f2214a = iIntValue;
            tranFingerprintInfo.f2218e = iIntValue3;
            arrayList2.add(tranFingerprintInfo);
            methodG2 = method2;
            methodG = method;
            it = it2;
            i11 = 0;
        }
        return arrayList2;
    }

    @Override // tf.a
    public void d(int i10, String str) {
        cc.a.j(cc.a.g(this.f7747a.getClass(), "setAppBiometrics", Integer.TYPE, String.class), this.f7747a, Integer.valueOf(i10), str);
    }

    @Override // tf.a
    public void e(int i10) {
        Method methodG = cc.a.g(this.f7747a.getClass(), "startAppForFp", Integer.TYPE);
        if (methodG != null) {
            cc.a.j(methodG, this.f7747a, Integer.valueOf(i10));
        }
    }

    @Override // tf.a
    public void f(int i10) {
        e.f(f7743b, "AOSP FingerprintManager has no setUdfpColor method.");
    }

    @Override // tf.a
    public void g(boolean z10) {
        cc.a.j(cc.a.g(this.f7747a.getClass(), "notifyActivateFingerprint", Boolean.TYPE), this.f7747a, Boolean.valueOf(z10));
    }

    @Override // tf.a
    public String h(int i10) {
        Object objJ = cc.a.j(cc.a.g(this.f7747a.getClass(), "getAppPackagename", Integer.TYPE), this.f7747a, Integer.valueOf(i10));
        if (objJ instanceof String) {
            return (String) objJ;
        }
        return null;
    }

    @Override // tf.a
    public void i(String str, boolean z10) {
        Object objJ = cc.a.j(cc.a.g(f7744c, "asInterface", IBinder.class), null, (IBinder) cc.a.j(cc.a.g(f7745d, "getService", String.class), null, "fingerprint"));
        if (objJ != null) {
            cc.a.j(cc.a.g(objJ.getClass(), "setMyClientVisible", String.class, Boolean.TYPE), objJ, str, Boolean.valueOf(z10));
        }
    }

    @Override // tf.a
    public int j(FingerprintManager.AuthenticationResult authenticationResult) {
        Object objJ = cc.a.j(cc.a.g(authenticationResult.getClass(), "getFingerprint", new Class[0]), authenticationResult, new Object[0]);
        if (objJ == null) {
            return 0;
        }
        Object objJ2 = cc.a.j(cc.a.g(objJ.getClass(), "getBiometricId", new Class[0]), objJ, new Object[0]);
        if (objJ2 instanceof Integer) {
            return ((Integer) objJ2).intValue();
        }
        return 0;
    }

    @Override // tf.a
    public void k(boolean z10) {
        Method methodG = cc.a.g(this.f7747a.getClass(), "setKeyguardClientVisible", Boolean.TYPE);
        if (methodG != null) {
            cc.a.j(methodG, this.f7747a, Boolean.valueOf(z10));
        }
    }

    @Override // tf.a
    public TranFingerprintInfo l(int i10) {
        Object objJ = cc.a.j(cc.a.g(this.f7747a.getClass(), "getAddFingerprint", Integer.TYPE), this.f7747a, Integer.valueOf(i10));
        if (objJ == null) {
            return null;
        }
        Method methodG = cc.a.g(f7746e, "getGroupId", new Class[0]);
        Method methodG2 = cc.a.g(f7746e, "getSubUserId", new Class[0]);
        Method methodG3 = cc.a.g(f7746e, "getName", new Class[0]);
        Method methodG4 = cc.a.g(f7746e, "getBiometricId", new Class[0]);
        Method methodG5 = cc.a.g(f7746e, "getDeviceId", new Class[0]);
        Method methodG6 = cc.a.g(f7746e, "getAppPkgName", new Class[0]);
        if (f7746e.isInstance(objJ)) {
            e.f(f7743b, "fingerprint fingerprint :" + objJ);
        }
        Object objJ2 = cc.a.j(methodG, objJ, new Object[0]);
        int iIntValue = objJ2 instanceof Integer ? ((Integer) objJ2).intValue() : 0;
        Object objJ3 = cc.a.j(methodG2, objJ, new Object[0]);
        int iIntValue2 = objJ3 instanceof Integer ? ((Integer) objJ3).intValue() : 0;
        Object objJ4 = cc.a.j(methodG3, objJ, new Object[0]);
        CharSequence charSequence = objJ4 instanceof CharSequence ? (CharSequence) objJ4 : "";
        Object objJ5 = cc.a.j(methodG4, objJ, new Object[0]);
        int iIntValue3 = objJ5 instanceof Integer ? ((Integer) objJ5).intValue() : 0;
        Object objJ6 = cc.a.j(methodG5, objJ, new Object[0]);
        long jLongValue = objJ6 instanceof Long ? ((Long) objJ6).longValue() : 0L;
        Object objJ7 = cc.a.j(methodG6, objJ, new Object[0]);
        CharSequence charSequence2 = objJ7 instanceof CharSequence ? (CharSequence) objJ7 : "";
        TranFingerprintInfo tranFingerprintInfo = new TranFingerprintInfo();
        tranFingerprintInfo.f2216c = iIntValue2;
        tranFingerprintInfo.f2217d = charSequence;
        tranFingerprintInfo.f2215b = charSequence2;
        tranFingerprintInfo.f2219f = jLongValue;
        tranFingerprintInfo.f2214a = iIntValue;
        tranFingerprintInfo.f2218e = iIntValue3;
        return tranFingerprintInfo;
    }

    @Override // tf.a
    public void m(int i10, String str, int i11) {
        Class<?> cls = this.f7747a.getClass();
        Class cls2 = Integer.TYPE;
        cc.a.j(cc.a.g(cls, "setAppAndUserIdForBiometrics", cls2, String.class, cls2), this.f7747a, Integer.valueOf(i10), str, Integer.valueOf(i11));
    }

    @Override // tf.a
    public boolean n() {
        Method methodG = cc.a.g(this.f7747a.getClass(), "isClientActive", new Class[0]);
        if (methodG != null) {
            return ((Boolean) cc.a.j(methodG, this.f7747a, new Object[0])).booleanValue();
        }
        return false;
    }

    @Override // tf.a
    public int o(int i10) {
        Object objJ = cc.a.j(cc.a.g(this.f7747a.getClass(), "getAppUserId", Integer.TYPE), this.f7747a, Integer.valueOf(i10));
        if (objJ instanceof Integer) {
            return ((Integer) objJ).intValue();
        }
        return 0;
    }
}
