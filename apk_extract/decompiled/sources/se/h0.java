package se;

import android.bluetooth.BluetoothDevice;
import com.welink.protocol.nfbd.NearDevice;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class h0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final BluetoothDevice f9754a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ArrayList f9755b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final NearDevice f9756c;

    public h0(BluetoothDevice device, ArrayList p2pDevices, NearDevice nearDevice) {
        Intrinsics.checkNotNullParameter(device, "device");
        Intrinsics.checkNotNullParameter(p2pDevices, "p2pDevices");
        this.f9754a = device;
        this.f9755b = p2pDevices;
        this.f9756c = nearDevice;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof h0)) {
            return false;
        }
        h0 h0Var = (h0) obj;
        return Intrinsics.areEqual(this.f9754a, h0Var.f9754a) && Intrinsics.areEqual(this.f9755b, h0Var.f9755b) && Intrinsics.areEqual(this.f9756c, h0Var.f9756c);
    }

    public final int hashCode() {
        int iHashCode = (this.f9755b.hashCode() + (this.f9754a.hashCode() * 31)) * 31;
        NearDevice nearDevice = this.f9756c;
        return iHashCode + (nearDevice == null ? 0 : nearDevice.hashCode());
    }

    public final String toString() {
        return "MiscDeviceInfo(device=" + this.f9754a + ", p2pDevices=" + this.f9755b + ", nearDevice=" + this.f9756c + ")";
    }
}
