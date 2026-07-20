package se;

import android.bluetooth.BluetoothDevice;
import com.welink.protocol.nfbd.NearDevice;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class z1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final BluetoothDevice f10077a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ArrayList f10078b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final NearDevice f10079c;

    public z1(BluetoothDevice device, ArrayList p2pDevices, NearDevice nearDevice) {
        Intrinsics.checkNotNullParameter(device, "device");
        Intrinsics.checkNotNullParameter(p2pDevices, "p2pDevices");
        this.f10077a = device;
        this.f10078b = p2pDevices;
        this.f10079c = nearDevice;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof z1)) {
            return false;
        }
        z1 z1Var = (z1) obj;
        return Intrinsics.areEqual(this.f10077a, z1Var.f10077a) && Intrinsics.areEqual(this.f10078b, z1Var.f10078b) && Intrinsics.areEqual(this.f10079c, z1Var.f10079c);
    }

    public final int hashCode() {
        int iHashCode = (this.f10078b.hashCode() + (this.f10077a.hashCode() * 31)) * 31;
        NearDevice nearDevice = this.f10079c;
        return iHashCode + (nearDevice == null ? 0 : nearDevice.hashCode());
    }

    public final String toString() {
        return "MiscDeviceInfo(device=" + this.f10077a + ", p2pDevices=" + this.f10078b + ", nearDevice=" + this.f10079c + ")";
    }
}
