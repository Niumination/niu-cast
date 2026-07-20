package m8;

import android.net.wifi.WifiManager;
import android.util.Log;
import java.lang.reflect.Method;
import k3.o9;

/* JADX INFO: loaded from: classes2.dex */
public final class a implements ca.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public WifiManager f7950a;

    static {
        o9.a("android.net.wifi.SoftApConfiguration");
    }

    @Override // ca.a
    public final int a() {
        WifiManager wifiManager = this.f7950a;
        Object objInvoke = null;
        try {
            Method methodD = o9.d(wifiManager.getClass(), "getWifiApState", null);
            methodD.setAccessible(true);
            objInvoke = methodD.invoke(wifiManager, null);
        } catch (Exception e) {
            boolean z2 = j9.a.f6132a;
            Log.e("a", "methodName:getWifiApState", e);
        }
        return ((Integer) objInvoke).intValue();
    }
}
