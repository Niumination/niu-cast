package ic;

import com.welink.protocol.nfbd.NearDevice;
import com.welink.protocol.nfbd.NearNetworkElement;
import com.welink.protocol.nfbd.NetworkParamsInformation;
import k3.gc;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import li.g2;

/* JADX INFO: loaded from: classes2.dex */
public final class c implements Function2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Ref.ObjectRef f5724a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ g2 f5725b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ li.l f5726c;

    public c(Ref.ObjectRef objectRef, g2 g2Var, li.l lVar) {
        this.f5724a = objectRef;
        this.f5725b = g2Var;
        this.f5726c = lVar;
    }

    /* JADX WARN: Type inference failed for: r13v6, types: [T, hc.b] */
    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        String str;
        String str2;
        NearNetworkElement nearNetworkElement = (NearNetworkElement) obj2;
        Intrinsics.checkNotNullParameter((NearDevice) obj, "<unused var>");
        gc.c("BLEConnectHelper", "connectCallback>:" + nearNetworkElement);
        if (nearNetworkElement instanceof NearNetworkElement.Wifi) {
            gc.c("BLEConnectHelper", "connectCallback>");
            NetworkParamsInformation networkParamsInformation = ((NearNetworkElement.Wifi) nearNetworkElement).f3949l;
            ?? bVar = new hc.b(true, null, (networkParamsInformation == null || (str2 = networkParamsInformation.f3958j) == null) ? "" : str2, (networkParamsInformation == null || (str = networkParamsInformation.f3952a) == null) ? "" : str, 0, null, 0, 0, null, 498);
            Ref.ObjectRef objectRef = this.f5724a;
            objectRef.element = bVar;
            this.f5725b.h(null);
            na.a.b(this.f5726c, objectRef.element);
        }
        return Unit.INSTANCE;
    }
}
