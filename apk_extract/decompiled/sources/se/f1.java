package se;

import android.content.Intent;
import com.welink.protocol.nfbd.ConnectRequest;
import com.welink.protocol.nfbd.NearDevice;
import com.welink.protocol.utils.DeviceData;
import com.welink.protocol.utils.LanNetworkInfo;
import java.util.concurrent.Executor;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class f1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f9738a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f9739b;

    public /* synthetic */ f1(Object obj, int i8) {
        this.f9738a = i8;
        this.f9739b = obj;
    }

    private final void f(int i8) {
    }

    private final void g() {
    }

    public final void a(LanNetworkInfo lanNetwork, ConnectRequest connectRequest) {
        switch (this.f9738a) {
            case 0:
                Intrinsics.checkNotNullParameter(lanNetwork, "lanNetwork");
                Intrinsics.checkNotNullParameter(connectRequest, "connectRequest");
                com.welink.protocol.nfbd.g.a((com.welink.protocol.nfbd.g) this.f9739b, new DeviceData(we.c.ETHERNET_LAN, connectRequest.f3874r, lanNetwork, null, 248), connectRequest, 1031, null);
                break;
            default:
                Intrinsics.checkNotNullParameter(lanNetwork, "lanNetwork");
                Intrinsics.checkNotNullParameter(connectRequest, "connectRequest");
                we.h.b("NearLanManager", "onClientConnectRequest");
                for (Pair pair : ((com.welink.protocol.nfbd.m) this.f9739b).f4179m) {
                    ((Executor) pair.getFirst()).execute(new a0.g(pair, 14, lanNetwork, connectRequest));
                }
                break;
        }
    }

    public final void b(LanNetworkInfo lanNetworkInfo, NearDevice nearDevice) {
        switch (this.f9738a) {
            case 0:
                ((com.welink.protocol.nfbd.g) this.f9739b).p(new DeviceData(we.c.ETHERNET_LAN, null, lanNetworkInfo, null, 248), nearDevice, 1031, -255);
                break;
            default:
                we.h.b("NearLanManager", "onClientDeviceConnected");
                for (Pair pair : ((com.welink.protocol.nfbd.m) this.f9739b).f4179m) {
                    ((Executor) pair.getFirst()).execute(new a0.g(pair, 13, lanNetworkInfo, nearDevice));
                }
                break;
        }
    }

    public final void c(LanNetworkInfo lanNetworkInfo, NearDevice nearDevice, int i8) {
        switch (this.f9738a) {
            case 0:
                ((com.welink.protocol.nfbd.g) this.f9739b).p(new DeviceData(we.c.ETHERNET_LAN, nearDevice != null ? nearDevice.f3884b : null, lanNetworkInfo, null, 248), nearDevice, 1032, i8);
                break;
            default:
                for (Pair pair : ((com.welink.protocol.nfbd.m) this.f9739b).f4179m) {
                    ((Executor) pair.getFirst()).execute(new a0.b(pair, lanNetworkInfo, nearDevice, i8, 2));
                }
                break;
        }
    }

    public final void d(NearDevice device) {
        switch (this.f9738a) {
            case 0:
                Intrinsics.checkNotNullParameter(device, "device");
                com.welink.protocol.nfbd.g gVar = (com.welink.protocol.nfbd.g) this.f9739b;
                gVar.getClass();
                Intent intent = new Intent("com.welink.service.ACTION_NEAR_DEVICE_REJECT");
                intent.putExtra("com.welink.service.EXTRA_NEAR_DEVICE", device);
                gVar.f4112b.j(intent);
                break;
            default:
                Intrinsics.checkNotNullParameter(device, "device");
                for (Pair pair : ((com.welink.protocol.nfbd.m) this.f9739b).f4179m) {
                    ((Executor) pair.getFirst()).execute(new o(pair, device, 6));
                }
                break;
        }
    }

    public final void e(NearDevice device) {
        switch (this.f9738a) {
            case 0:
                Intrinsics.checkNotNullParameter(device, "device");
                com.welink.protocol.nfbd.g gVar = (com.welink.protocol.nfbd.g) this.f9739b;
                gVar.getClass();
                Intent intent = new Intent("com.welink.service.ACTION_NEAR_DEVICE_TRUSTED");
                intent.putExtra("com.welink.service.EXTRA_NEAR_DEVICE", device);
                intent.putExtra("com.welink.service.EXTRA_NEAR_DEVICE_TRUSTED", true);
                gVar.f4112b.j(intent);
                break;
            default:
                Intrinsics.checkNotNullParameter(device, "device");
                for (Pair pair : ((com.welink.protocol.nfbd.m) this.f9739b).f4179m) {
                    ((Executor) pair.getFirst()).execute(new o(pair, device, 5));
                }
                break;
        }
    }
}
