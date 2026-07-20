package se;

import android.bluetooth.BluetoothDevice;
import com.welink.protocol.nfbd.ConnectRequest;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class g2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final BluetoothDevice f9743a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ConnectRequest f9744b;

    public g2(BluetoothDevice device, ConnectRequest request) {
        Intrinsics.checkNotNullParameter(device, "device");
        Intrinsics.checkNotNullParameter(request, "request");
        this.f9743a = device;
        this.f9744b = request;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof g2)) {
            return false;
        }
        g2 g2Var = (g2) obj;
        return Intrinsics.areEqual(this.f9743a, g2Var.f9743a) && Intrinsics.areEqual(this.f9744b, g2Var.f9744b);
    }

    public final int hashCode() {
        return this.f9744b.hashCode() + (this.f9743a.hashCode() * 31);
    }

    public final String toString() {
        return "ConnectInfo(device=" + this.f9743a + ", request=" + this.f9744b + ")";
    }
}
