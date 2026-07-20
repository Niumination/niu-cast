package na;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.util.Log;
import j3.z;
import k3.gc;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import tj.x;

/* JADX INFO: loaded from: classes2.dex */
public abstract class n {
    public static boolean a(Context context, boolean z2) {
        Intrinsics.checkNotNullParameter(context, "context");
        gc.c("UsbTetheringUtils", "setIpForward:" + z2);
        String strD = pa.a.f8703a.d("sys.usb.config", "");
        String strN = o.d.n("usbConfig:", strD, "UsbTetheringUtils", "tag", "log");
        if (gc.f6462a <= 3) {
            Log.d(gc.f6463b.concat("UsbTetheringUtils"), strN);
        }
        if (!StringsKt__StringsKt.contains$default(strD, "rndis", false, 2, (Object) null) && !Build.HARDWARE.equals("qcom")) {
            gc.c("UsbTetheringUtils", "UsbTethering not open");
            return false;
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Object systemService = context.getSystemService("connectivity");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.net.ConnectivityManager");
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) systemService).getActiveNetworkInfo();
        if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
            gc.c("UsbTetheringUtils", "netWork not connect");
            return true;
        }
        if (m.b() == null && !m.f8145b) {
            return false;
        }
        gc.a("UsbTetheringUtils", "support ITranNet");
        String strConcat = "network ipfwdEnableForwarding Tethering ".concat(z2 ? "1" : "0");
        gc.a("UsbTetheringUtils", "startCmd:" + strConcat);
        Integer numA = m.a(strConcat);
        if (numA != null && numA.intValue() == 0) {
            return true;
        }
        gc.a("UsbTetheringUtils", "Set Ipforward failed");
        return false;
    }

    public static void b(boolean z2) {
        ba.a aVar;
        String strO = o.d.o("TranConnectivityManager setUsbTethering:enable:", z2, "UsbTetheringUtils", "tag", "log");
        if (gc.f6462a <= 3) {
            Log.d(gc.f6463b.concat("UsbTetheringUtils"), strO);
        }
        if (l9.b.a(l9.a.f7345d)) {
            aVar = new q9.a();
        } else {
            x xVar = new x();
            Context context = z.f6093b;
            if (((ConnectivityManager) xVar.f10264a) == null) {
                xVar.f10264a = (ConnectivityManager) context.getSystemService("connectivity");
            }
            aVar = xVar;
        }
        aVar.k(z2);
    }
}
