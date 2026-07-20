package k3;

import android.app.Application;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.util.Log;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.text.StringsKt__StringsJVMKt;

/* JADX INFO: loaded from: classes.dex */
public abstract class sb {
    public static String a(Application context) {
        String str;
        Intrinsics.checkNotNullParameter(context, "context");
        pa.a aVar = pa.a.f8703a;
        if (pa.a.j("ro.tr_project.foldable_screen.support")) {
            str = "0F";
        } else if (pa.a.j("ro.tr_project.flip_screen.support")) {
            str = "13";
        } else {
            str = !b() ? "12" : "0D";
        }
        String log = "PhoneUtil,getPhoneSubtype:".concat(str);
        Intrinsics.checkNotNullParameter("PhoneUtil", "tag");
        Intrinsics.checkNotNullParameter(log, "log");
        if (gc.f6462a <= 3) {
            Log.d(gc.f6463b.concat("PhoneUtil"), log);
        }
        return str;
    }

    public static final boolean b() {
        pa.a aVar = pa.a.f8703a;
        return (StringsKt__StringsJVMKt.equals(aVar.d("ro.build.characteristics", "default"), "tablet", true) || StringsKt__StringsJVMKt.equals(aVar.d("ro.tr_device.type", "default"), "tablet", true)) ? false : true;
    }

    public static boolean c(Application context) {
        Intrinsics.checkNotNullParameter(context, "context");
        try {
            Object systemService = context.getSystemService("wifi");
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.net.wifi.WifiManager");
            WifiInfo connectionInfo = ((WifiManager) systemService).getConnectionInfo();
            String log = "isWifi24GHz frequency: " + (connectionInfo != null ? Integer.valueOf(connectionInfo.getFrequency()) : null);
            Intrinsics.checkNotNullParameter("PhoneUtil", "tag");
            Intrinsics.checkNotNullParameter(log, "log");
            if (gc.f6462a <= 6) {
                Log.e(gc.f6463b.concat("PhoneUtil"), log);
            }
            IntRange intRange = new IntRange(2400, 2500);
            Integer numValueOf = connectionInfo != null ? Integer.valueOf(connectionInfo.getFrequency()) : null;
            return numValueOf != null && intRange.contains(numValueOf.intValue());
        } catch (Exception e) {
            String log2 = "isWifi24GHz: " + e;
            Intrinsics.checkNotNullParameter("PhoneUtil", "tag");
            Intrinsics.checkNotNullParameter(log2, "log");
            if (gc.f6462a <= 6) {
                Log.e(gc.f6463b.concat("PhoneUtil"), log2);
            }
            return false;
        }
    }
}
