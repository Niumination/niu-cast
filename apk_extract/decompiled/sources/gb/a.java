package gb;

import android.os.Bundle;
import android.util.Log;
import com.transsion.atomiccore.hostsdk.utils.AtomicCoreUtils;
import com.transsion.atomiccore.support.host.AtomicBusinessData;
import k3.f2;
import k3.gc;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import y6.g;

/* JADX INFO: loaded from: classes2.dex */
public final class a {
    public static void a(g builder) {
        Intrinsics.checkNotNullParameter(builder, "builder");
        ad.b bVar = new ad.b(builder);
        o5.c cVar = new o5.c();
        cVar.f8405a = bVar;
        k7.c cVar2 = new k7.c(cVar);
        k7.b bVar2 = new k7.b();
        bVar2.f6784a = cVar2;
        String string = new AtomicBusinessData(bVar2, 0).toJSONObject().toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        AtomicCoreUtils.sendAtomicCoreData(new f7.a("transsion.intent.dynamic.PCConnectTransfer", "transsion.intent.dynamic.PC_CONNECT_TRANSFER", string, null, null, null, 1L, f2.a(true).toString()), new Bundle());
    }

    public static void b(g builder, JSONObject jSONObject) {
        Intrinsics.checkNotNullParameter(builder, "builder");
        c.f5123b.getClass();
        e7.a aVar = c.f5124c;
        if (aVar == null) {
            a(builder);
            return;
        }
        if (aVar != null) {
            String log = "update, customOption: " + jSONObject;
            Intrinsics.checkNotNullParameter("Atomic-AtomicBusiness", "tag");
            Intrinsics.checkNotNullParameter(log, "log");
            if (gc.f6462a <= 4) {
                Log.i(gc.f6463b.concat("Atomic-AtomicBusiness"), log);
            }
            AtomicCoreUtils atomicCoreUtils = AtomicCoreUtils.INSTANCE;
            ad.b bVar = new ad.b(builder);
            o5.c cVar = new o5.c();
            cVar.f8405a = bVar;
            k7.c cVar2 = new k7.c(cVar);
            k7.b bVar2 = new k7.b();
            bVar2.f6784a = cVar2;
            AtomicCoreUtils.updateAllCardData$default(aVar, "transsion.intent.dynamic.PCConnectTransfer", new AtomicBusinessData(bVar2, 0).toJSONObject(), null, jSONObject, 8, null);
        }
    }
}
