package ta;

import android.util.Log;
import com.transsion.connectx.sdk.CapabilityListener;
import com.transsion.pcconnect.invoke.bridge.Device;
import eb.g0;
import java.util.concurrent.ConcurrentHashMap;
import k3.gc;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import o.d;

/* JADX INFO: loaded from: classes2.dex */
public final class a extends CapabilityListener {
    @Override // com.transsion.connectx.sdk.ICapabilityListener
    public final boolean isSupportCapability(String str) {
        String strN = d.n("isSupportCapability: ", str, "CapabilitySdkController", "tag", "log");
        if (gc.f6462a <= 4) {
            Log.i(gc.f6463b.concat("CapabilitySdkController"), strN);
        }
        ConcurrentHashMap concurrentHashMap = o7.a.f8410a;
        if (str == null) {
            str = "";
        }
        return o7.a.c(str);
    }

    @Override // com.transsion.connectx.sdk.ICapabilityListener
    public final String onAction(String str, String str2) {
        String log = h0.a.k("onAction: ", str, ", ", str2);
        Intrinsics.checkNotNullParameter("CapabilitySdkController", "tag");
        Intrinsics.checkNotNullParameter(log, "log");
        if (gc.f6462a <= 4) {
            Log.i(gc.f6463b.concat("CapabilitySdkController"), log);
        }
        if (Intrinsics.areEqual(str, "SERIVCE_CAPABILITY_ALBUM_BACKUP")) {
            String strN = d.n("changeAutoBackupState params: ", str2, "InvokeBridgeProvider", "tag", "log");
            if (gc.f6462a <= 4) {
                Log.i(gc.f6463b.concat("InvokeBridgeProvider"), strN);
            }
            if (str2 != null) {
                boolean zContains$default = StringsKt__StringsKt.contains$default(str2, "true", false, 2, (Object) null);
                Device device = g0.f;
                if (device != null) {
                    cb.b.c(device, "SERIVCE_CAPABILITY_ALBUM_BACKUP", zContains$default, "");
                }
            }
        }
        return "";
    }
}
