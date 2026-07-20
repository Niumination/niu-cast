package se;

import android.bluetooth.BluetoothDevice;
import android.net.wifi.p2p.WifiP2pDevice;
import com.welink.protocol.nfbd.NearDevice;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class h2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final BluetoothDevice f9759a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final WifiP2pDevice f9760b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final NearDevice f9761c;

    public h2(BluetoothDevice device, WifiP2pDevice p2pDevice, NearDevice nearDevice) {
        Intrinsics.checkNotNullParameter(device, "device");
        Intrinsics.checkNotNullParameter(p2pDevice, "p2pDevice");
        this.f9759a = device;
        this.f9760b = p2pDevice;
        this.f9761c = nearDevice;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof h2)) {
            return false;
        }
        h2 h2Var = (h2) obj;
        return Intrinsics.areEqual(this.f9759a, h2Var.f9759a) && Intrinsics.areEqual(this.f9760b, h2Var.f9760b) && Intrinsics.areEqual(this.f9761c, h2Var.f9761c);
    }

    public final int hashCode() {
        int iHashCode = (this.f9760b.hashCode() + (this.f9759a.hashCode() * 31)) * 31;
        NearDevice nearDevice = this.f9761c;
        return iHashCode + (nearDevice == null ? 0 : nearDevice.hashCode());
    }

    public final String toString() {
        return "ConnectP2pInfo(device=" + this.f9759a + ", p2pDevice=" + this.f9760b + ", nearDevice=" + this.f9761c + ")";
    }
}
