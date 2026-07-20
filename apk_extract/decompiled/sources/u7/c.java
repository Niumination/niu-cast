package u7;

import android.util.Log;
import java.util.Map;
import k3.gc;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class c implements o7.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Integer f10402a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f10403b = "";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f10404c;

    @Override // o7.c
    public final void a() {
        Intrinsics.checkNotNullParameter("NetworkSharingCapabilityV0", "tag");
        Intrinsics.checkNotNullParameter("isEnableNetworkSharing unInit", "log");
        if (gc.f6462a <= 3) {
            Log.d(gc.f6463b.concat("NetworkSharingCapabilityV0"), "isEnableNetworkSharing unInit");
        }
        e eVar = e.f10405a;
        e.f.compareAndSet(true, false);
        eVar.b();
        if (Intrinsics.areEqual("usb", e.f10406b)) {
            return;
        }
        a.b();
    }

    @Override // o7.c
    public final void b(q7.a capabilityBean, Map map) {
        String str;
        Intrinsics.checkNotNullParameter(capabilityBean, "capabilityBean");
        Integer num = (Integer) (map != null ? map.get("connectType") : null);
        this.f10402a = num;
        if (num != null && num.intValue() == 16) {
            Intrinsics.checkNotNullParameter("NetworkSharingCapabilityV0", "tag");
            Intrinsics.checkNotNullParameter("usb ConnectType", "log");
            if (gc.f6462a <= 3) {
                Log.d(gc.f6463b.concat("NetworkSharingCapabilityV0"), "usb ConnectType");
            }
            str = "usb";
        } else {
            Intrinsics.checkNotNullParameter("NetworkSharingCapabilityV0", "tag");
            Intrinsics.checkNotNullParameter("p2p ConnectType", "log");
            if (gc.f6462a <= 3) {
                Log.d(gc.f6463b.concat("NetworkSharingCapabilityV0"), "p2p ConnectType");
            }
            str = (String) (map != null ? map.get("currentP2pInterface") : null);
            if (str == null) {
                str = "p2p0";
            }
        }
        this.f10403b = str;
        String log = "init connectType:" + this.f10402a + " downLinkInterface:" + str;
        Intrinsics.checkNotNullParameter("NetworkSharingCapabilityV0", "tag");
        Intrinsics.checkNotNullParameter(log, "log");
        if (gc.f6462a <= 3) {
            Log.d(gc.f6463b.concat("NetworkSharingCapabilityV0"), log);
        }
    }

    public final void c() {
        this.f10404c = false;
        Intrinsics.checkNotNullParameter("NetworkSharingCapabilityV0", "tag");
        Intrinsics.checkNotNullParameter("isEnableNetworkSharing false", "log");
        if (gc.f6462a <= 3) {
            Log.d(gc.f6463b.concat("NetworkSharingCapabilityV0"), "isEnableNetworkSharing false");
        }
        e.f10405a.b();
    }

    @Override // o7.c
    public final void start() {
    }
}
