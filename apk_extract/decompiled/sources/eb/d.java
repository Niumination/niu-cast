package eb;

import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.os.RemoteException;
import android.util.Log;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;
import k3.gc;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class d extends ConnectivityManager.NetworkCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4749a;

    public /* synthetic */ d(int i8) {
        this.f4749a = i8;
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public void onAvailable(Network network) {
        switch (this.f4749a) {
            case 1:
                Intrinsics.checkNotNullParameter(network, "network");
                super.onAvailable(network);
                Iterator it = u7.a.f10399b.iterator();
                while (it.hasNext()) {
                    ((ConnectivityManager.NetworkCallback) it.next()).onAvailable(network);
                }
                break;
            case 2:
            default:
                super.onAvailable(network);
                break;
            case 3:
                super.onAvailable(network);
                m3.f0.f7669a = -1;
                break;
        }
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public final void onCapabilitiesChanged(Network network, NetworkCapabilities capabilities) {
        switch (this.f4749a) {
            case 0:
                Intrinsics.checkNotNullParameter(network, "network");
                Intrinsics.checkNotNullParameter(capabilities, "capabilities");
                Intrinsics.checkNotNullParameter("ConnectionManager", "tag");
                Intrinsics.checkNotNullParameter("onCapabilitiesChanged", "log");
                if (gc.f6462a <= 4) {
                    Log.i(gc.f6463b.concat("ConnectionManager"), "onCapabilitiesChanged");
                }
                y yVar = y.f4799a;
                y.b();
                break;
            case 1:
                Intrinsics.checkNotNullParameter(network, "network");
                Intrinsics.checkNotNullParameter(capabilities, "networkCapabilities");
                String log = "onCapabilitiesChanged: " + capabilities;
                Intrinsics.checkNotNullParameter("NetWorkUtils", "tag");
                Intrinsics.checkNotNullParameter(log, "log");
                if (gc.f6462a <= 3) {
                    Log.d(gc.f6463b.concat("NetWorkUtils"), log);
                }
                super.onCapabilitiesChanged(network, capabilities);
                Iterator it = u7.a.f10399b.iterator();
                while (it.hasNext()) {
                    ((ConnectivityManager.NetworkCallback) it.next()).onCapabilitiesChanged(network, capabilities);
                }
                break;
            case 2:
                Intrinsics.checkNotNullParameter(network, "network");
                Intrinsics.checkNotNullParameter(capabilities, "networkCapabilities");
                if (!u7.e.f.get()) {
                    if (u7.e.f10409g.get()) {
                        u7.e.f10405a.b();
                    }
                    break;
                } else {
                    AtomicBoolean atomicBoolean = u7.e.f10409g;
                    if (!atomicBoolean.get()) {
                        u7.e.f10405a.c();
                        break;
                    } else if (!Intrinsics.areEqual(u7.e.f10406b, "usb")) {
                        u7.e eVar = u7.e.f10405a;
                        u7.b bVarD = u7.e.d();
                        if (bVarD != null) {
                            if (!Intrinsics.areEqual(u7.e.f10408d, bVarD.getName()) || !Intrinsics.areEqual(u7.e.f10407c, bVarD.getIp())) {
                                try {
                                    if (u7.e.e(false, false)) {
                                        atomicBoolean.compareAndSet(true, false);
                                    }
                                } catch (RemoteException e) {
                                    String log2 = "clear last uplink setting fail:" + e.getMessage() + " ";
                                    Intrinsics.checkNotNullParameter("NetworkSharingManager", "tag");
                                    Intrinsics.checkNotNullParameter(log2, "log");
                                    if (gc.f6462a <= 3) {
                                        Log.d(gc.f6463b.concat("NetworkSharingManager"), log2);
                                    }
                                }
                                u7.e eVar2 = u7.e.f10405a;
                                String ip = bVarD.getIp();
                                Intrinsics.checkNotNullParameter(ip, "<set-?>");
                                u7.e.f10407c = ip;
                                u7.e.f10408d = bVarD.getName();
                                try {
                                    if (u7.e.e(true, true)) {
                                        u7.e.f10409g.compareAndSet(false, true);
                                    }
                                } catch (RemoteException e4) {
                                    String log3 = "set uplink setting fail:" + e4.getMessage() + " ";
                                    Intrinsics.checkNotNullParameter("NetworkSharingManager", "tag");
                                    Intrinsics.checkNotNullParameter(log3, "log");
                                    if (gc.f6462a <= 3) {
                                        Log.d(gc.f6463b.concat("NetworkSharingManager"), log3);
                                        return;
                                    }
                                    return;
                                }
                            }
                            break;
                        }
                    }
                }
                break;
            default:
                super.onCapabilitiesChanged(network, capabilities);
                m3.f0.f7669a = -1;
                break;
        }
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public void onLost(Network network) {
        switch (this.f4749a) {
            case 3:
                super.onLost(network);
                m3.f0.f7669a = -1;
                break;
            default:
                super.onLost(network);
                break;
        }
    }
}
