package ic;

import android.util.Log;
import com.welink.protocol.nfbd.NearDevice;
import com.welink.protocol.nfbd.NearNetworkElement;
import com.welink.protocol.nfbd.NetworkParamsInformation;
import k3.gc;
import k3.tb;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;
import kotlin.text.StringsKt__StringsKt;
import li.g2;

/* JADX INFO: loaded from: classes2.dex */
public final class i implements Function2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ g2 f5734a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ li.l f5735b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f5736c;

    public i(g2 g2Var, li.l lVar, String str) {
        this.f5734a = g2Var;
        this.f5735b = lVar;
        this.f5736c = str;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        String str;
        NearDevice nearDevice = (NearDevice) obj;
        NearNetworkElement nearNetworkElement = (NearNetworkElement) obj2;
        Intrinsics.checkNotNullParameter(nearDevice, "nearDevice");
        String log = "phone request Remote device connect success " + nearDevice;
        Intrinsics.checkNotNullParameter("P2PConnectHelper", "tag");
        Intrinsics.checkNotNullParameter(log, "log");
        if (gc.f6462a <= 4) {
            Log.i(gc.f6463b.concat("P2PConnectHelper"), log);
        }
        this.f5734a.h(null);
        if (nearNetworkElement instanceof NearNetworkElement.Wifi) {
            NetworkParamsInformation networkParamsInformation = ((NearNetworkElement.Wifi) nearNetworkElement).f3949l;
            String str2 = (networkParamsInformation == null || (str = networkParamsInformation.f3952a) == null) ? "" : str;
            if (StringsKt__StringsKt.contains$default(str2, ".", false, 2, (Object) null)) {
                String str3 = nearDevice.f3884b;
                na.a.b(this.f5735b, new hc.b(true, null, this.f5736c, str2, Integer.parseInt(tb.a(nearDevice.h()), CharsKt.checkRadix(16)), str3 == null ? "" : str3, nearDevice.e, nearDevice.f3889j, null, 258));
            }
        }
        return Unit.INSTANCE;
    }
}
