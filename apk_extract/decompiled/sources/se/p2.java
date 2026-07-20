package se;

import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.os.Message;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class p2 extends ConnectivityManager.NetworkCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Set f9935a = SetsKt.setOf((Object[]) new Integer[]{1, 3, 8, 9, 6, 5, 2});

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Set f9936b = SetsKt.setOf((Object[]) new Integer[]{0, 4});

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ com.welink.protocol.nfbd.m f9937c;

    public p2(com.welink.protocol.nfbd.m mVar) {
        this.f9937c = mVar;
    }

    public final boolean a(NetworkCapabilities networkCapabilities) {
        Set set = this.f9935a;
        if (set == null || !set.isEmpty()) {
            Iterator it = set.iterator();
            while (it.hasNext()) {
                if (networkCapabilities.hasTransport(((Number) it.next()).intValue())) {
                    Set set2 = this.f9936b;
                    if (set2 == null || !set2.isEmpty()) {
                        Iterator it2 = set2.iterator();
                        while (it2.hasNext()) {
                            if (networkCapabilities.hasTransport(((Number) it2.next()).intValue())) {
                                break;
                            }
                        }
                    }
                    return true;
                }
            }
        }
        return false;
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public final void onAvailable(Network network) {
        Intrinsics.checkNotNullParameter(network, "network");
        super.onAvailable(network);
        com.welink.protocol.nfbd.m mVar = this.f9937c;
        ConnectivityManager connectivityManager = mVar.e;
        NetworkCapabilities networkCapabilities = connectivityManager != null ? connectivityManager.getNetworkCapabilities(network) : null;
        we.h.b("NearLanManager", "onAvailable: network=" + network + ", networkCapabilities=" + networkCapabilities);
        if (networkCapabilities != null && a(networkCapabilities)) {
            ArrayList arrayList = mVar.f4175i;
            if (!arrayList.contains(network)) {
                we.h.b("NearLanManager", "onAvailable notify: network=" + network);
                arrayList.clear();
                arrayList.add(network);
                Message messageObtain = Message.obtain();
                messageObtain.what = 20486;
                Intrinsics.checkNotNull(messageObtain);
                mVar.i(messageObtain);
                return;
            }
        }
        we.h.b("NearLanManager", "onAvailable ignore: network=" + network + ", networkCapabilities=" + networkCapabilities);
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public final void onCapabilitiesChanged(Network network, NetworkCapabilities networkCapabilities) {
        Intrinsics.checkNotNullParameter(network, "network");
        Intrinsics.checkNotNullParameter(networkCapabilities, "networkCapabilities");
        super.onCapabilitiesChanged(network, networkCapabilities);
        we.h.b("NearLanManager", "onCapabilitiesChanged: network=" + network + ", networkCapabilities=" + networkCapabilities);
        if (a(networkCapabilities)) {
            com.welink.protocol.nfbd.m mVar = this.f9937c;
            if (mVar.f4175i.contains(network)) {
                return;
            }
            we.h.b("NearLanManager", "onCapabilitiesChanged nofity: available network");
            ArrayList arrayList = mVar.f4175i;
            arrayList.clear();
            arrayList.add(network);
            Message messageObtain = Message.obtain();
            messageObtain.what = 20484;
            Intrinsics.checkNotNull(messageObtain);
            mVar.i(messageObtain);
        }
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public final void onLost(Network network) {
        Intrinsics.checkNotNullParameter(network, "network");
        super.onLost(network);
        com.welink.protocol.nfbd.m mVar = this.f9937c;
        ConnectivityManager connectivityManager = mVar.e;
        NetworkCapabilities networkCapabilities = connectivityManager != null ? connectivityManager.getNetworkCapabilities(network) : null;
        if (networkCapabilities == null || !a(networkCapabilities)) {
            return;
        }
        we.h.b("NearLanManager", "onLost notify: network=" + network);
        mVar.f4175i.remove(network);
        Message messageObtain = Message.obtain();
        messageObtain.what = 20485;
        Intrinsics.checkNotNull(messageObtain);
        mVar.i(messageObtain);
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public final void onUnavailable() {
        super.onUnavailable();
        we.h.b("NearLanManager", "onUnavailable");
        com.welink.protocol.nfbd.m mVar = this.f9937c;
        mVar.f4175i.clear();
        Message messageObtain = Message.obtain();
        messageObtain.what = 20485;
        Intrinsics.checkNotNull(messageObtain);
        mVar.i(messageObtain);
    }
}
