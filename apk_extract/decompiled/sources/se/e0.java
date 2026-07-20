package se;

import android.bluetooth.BluetoothDevice;
import com.welink.protocol.nfbd.NearDevice;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class e0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final BluetoothDevice f9721a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final pe.d f9722b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final NearDevice f9723c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f9724d;

    public e0(BluetoothDevice device, pe.d dVar, NearDevice nearDevice) {
        Intrinsics.checkNotNullParameter(device, "device");
        Intrinsics.checkNotNullParameter(nearDevice, "nearDevice");
        this.f9721a = device;
        this.f9722b = dVar;
        this.f9723c = nearDevice;
        this.f9724d = null;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof e0)) {
            return false;
        }
        e0 e0Var = (e0) obj;
        return Intrinsics.areEqual(this.f9721a, e0Var.f9721a) && Intrinsics.areEqual(this.f9722b, e0Var.f9722b) && Intrinsics.areEqual(this.f9723c, e0Var.f9723c) && Intrinsics.areEqual(this.f9724d, e0Var.f9724d);
    }

    public final int hashCode() {
        int iHashCode = this.f9721a.hashCode() * 31;
        pe.d dVar = this.f9722b;
        int iHashCode2 = (this.f9723c.hashCode() + ((iHashCode + (dVar == null ? 0 : dVar.hashCode())) * 31)) * 31;
        String str = this.f9724d;
        return iHashCode2 + (str != null ? str.hashCode() : 0);
    }

    public final String toString() {
        return "BluetoothClient(device=" + this.f9721a + ", connection=" + this.f9722b + ", nearDevice=" + this.f9723c + ", version=" + this.f9724d + ")";
    }
}
