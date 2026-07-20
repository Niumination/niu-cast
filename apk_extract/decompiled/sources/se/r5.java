package se;

import com.welink.protocol.utils.DeviceInfo;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class r5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final DeviceInfo f9964a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List f9965b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List f9966c;

    public r5(DeviceInfo deviceInfo, List services, List list) {
        Intrinsics.checkNotNullParameter(services, "services");
        this.f9964a = deviceInfo;
        this.f9965b = services;
        this.f9966c = list;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof r5)) {
            return false;
        }
        r5 r5Var = (r5) obj;
        return Intrinsics.areEqual(this.f9964a, r5Var.f9964a) && Intrinsics.areEqual(this.f9965b, r5Var.f9965b) && Intrinsics.areEqual(this.f9966c, r5Var.f9966c);
    }

    public final int hashCode() {
        DeviceInfo deviceInfo = this.f9964a;
        int iHashCode = (this.f9965b.hashCode() + ((deviceInfo == null ? 0 : deviceInfo.hashCode()) * 31)) * 31;
        List list = this.f9966c;
        return iHashCode + (list != null ? list.hashCode() : 0);
    }

    public final String toString() {
        return "DeviceLanInfo(deviceInfo=" + this.f9964a + ", services=" + this.f9965b + ", addresses=" + this.f9966c + ")";
    }
}
