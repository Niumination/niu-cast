package se;

import com.welink.protocol.nfbd.NearDevice;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class m4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList f9872a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final NearDevice f9873b;

    public m4(ArrayList p2pDevices, NearDevice nearDevice) {
        Intrinsics.checkNotNullParameter(p2pDevices, "p2pDevices");
        this.f9872a = p2pDevices;
        this.f9873b = nearDevice;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof m4)) {
            return false;
        }
        m4 m4Var = (m4) obj;
        return Intrinsics.areEqual(this.f9872a, m4Var.f9872a) && Intrinsics.areEqual(this.f9873b, m4Var.f9873b);
    }

    public final int hashCode() {
        int iHashCode = this.f9872a.hashCode() * 31;
        NearDevice nearDevice = this.f9873b;
        return iHashCode + (nearDevice == null ? 0 : nearDevice.hashCode());
    }

    public final String toString() {
        return "MiscDeviceInfo(p2pDevices=" + this.f9872a + ", nearDevice=" + this.f9873b + ")";
    }
}
