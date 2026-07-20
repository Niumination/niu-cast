package k3;

import android.content.Context;
import android.net.wifi.WifiManager;
import android.util.Log;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public abstract class ub {
    public static final boolean a(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Object systemService = context.getApplicationContext().getSystemService("wifi");
        WifiManager wifiManager = systemService instanceof WifiManager ? (WifiManager) systemService : null;
        return wifiManager != null && wifiManager.isWifiEnabled();
    }

    public static final boolean b() {
        try {
            return new ka.d().e() == 13;
        } catch (Exception e) {
            Intrinsics.checkNotNullParameter("SettingUtils", "tag");
            Intrinsics.checkNotNullParameter(e, "e");
            Log.e(gc.f6463b.concat("SettingUtils"), e.getMessage(), e);
            return false;
        }
    }

    public static final void c(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (a(context)) {
            return;
        }
        Object systemService = context.getApplicationContext().getSystemService("wifi");
        WifiManager wifiManager = systemService instanceof WifiManager ? (WifiManager) systemService : null;
        if (wifiManager != null) {
            wifiManager.setWifiEnabled(true);
        }
        if (wifiManager != null) {
            wifiManager.isWifiEnabled();
        }
    }
}
