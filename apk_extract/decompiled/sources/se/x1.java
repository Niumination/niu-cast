package se;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import com.welink.protocol.nfbd.NearDevice;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class x1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final BluetoothDevice f10055a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final BluetoothGatt f10056b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final NearDevice f10057c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f10058d;

    public x1(BluetoothDevice device, BluetoothGatt client, NearDevice nearDevice) {
        Intrinsics.checkNotNullParameter(device, "device");
        Intrinsics.checkNotNullParameter(client, "client");
        Intrinsics.checkNotNullParameter(nearDevice, "nearDevice");
        this.f10055a = device;
        this.f10056b = client;
        this.f10057c = nearDevice;
        this.f10058d = null;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof x1)) {
            return false;
        }
        x1 x1Var = (x1) obj;
        return Intrinsics.areEqual(this.f10055a, x1Var.f10055a) && Intrinsics.areEqual(this.f10056b, x1Var.f10056b) && Intrinsics.areEqual(this.f10057c, x1Var.f10057c) && Intrinsics.areEqual(this.f10058d, x1Var.f10058d);
    }

    public final int hashCode() {
        int iHashCode = (this.f10057c.hashCode() + ((this.f10056b.hashCode() + (this.f10055a.hashCode() * 31)) * 31)) * 31;
        String str = this.f10058d;
        return iHashCode + (str == null ? 0 : str.hashCode());
    }

    public final String toString() {
        return "BluetoothClient(device=" + this.f10055a + ", client=" + this.f10056b + ", nearDevice=" + this.f10057c + ", version=" + this.f10058d + ")";
    }
}
