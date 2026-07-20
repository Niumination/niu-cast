package se;

import android.net.wifi.p2p.WifiP2pDevice;
import com.welink.protocol.nfbd.NearDevice;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class l4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WifiP2pDevice f9859a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final NearDevice f9860b;

    public l4(WifiP2pDevice p2pDevice, NearDevice nearDevice) {
        Intrinsics.checkNotNullParameter(p2pDevice, "p2pDevice");
        this.f9859a = p2pDevice;
        this.f9860b = nearDevice;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof l4)) {
            return false;
        }
        l4 l4Var = (l4) obj;
        return Intrinsics.areEqual(this.f9859a, l4Var.f9859a) && Intrinsics.areEqual(this.f9860b, l4Var.f9860b);
    }

    public final int hashCode() {
        int iHashCode = this.f9859a.hashCode() * 31;
        NearDevice nearDevice = this.f9860b;
        return iHashCode + (nearDevice == null ? 0 : nearDevice.hashCode());
    }

    public final String toString() {
        return "ConnectP2pInfo(p2pDevice=" + this.f9859a + ", nearDevice=" + this.f9860b + ")";
    }
}
