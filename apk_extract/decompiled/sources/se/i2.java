package se;

import com.welink.protocol.nfbd.NearDevice;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class i2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f9793a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f9794b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f9795c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f9796d;
    public final int e;
    public final int f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final NearDevice f9797g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f9798h;

    public /* synthetic */ i2(int i8, NearDevice nearDevice, String str, String str2, String str3) {
        this(str, str2, i8, str3, 0, 0, nearDevice, 0);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!Intrinsics.areEqual(i2.class, obj != null ? obj.getClass() : null)) {
            return false;
        }
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.welink.protocol.nfbd.NearGattService.P2pInfo");
        i2 i2Var = (i2) obj;
        return Intrinsics.areEqual(this.f9793a, i2Var.f9793a) && Intrinsics.areEqual(this.f9794b, i2Var.f9794b) && this.f9795c == i2Var.f9795c && Intrinsics.areEqual(this.f9796d, i2Var.f9796d) && this.e == i2Var.e && this.f == i2Var.f && this.f9798h == i2Var.f9798h && Intrinsics.areEqual(this.f9797g, i2Var.f9797g);
    }

    public final int hashCode() {
        String str = this.f9793a;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.f9794b;
        int iHashCode2 = (((iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31) + this.f9795c) * 31;
        String str3 = this.f9796d;
        int iHashCode3 = (((((iHashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31) + this.e) * 31) + this.f) * 31;
        NearDevice nearDevice = this.f9797g;
        return ((iHashCode3 + (nearDevice != null ? nearDevice.hashCode() : 0)) * 31) + this.f9798h;
    }

    public final String toString() {
        String str = this.f9793a;
        String str2 = this.f9794b;
        int i8 = this.f9795c;
        int i9 = this.f9798h;
        StringBuilder sbP = h0.a.p("P2pInfo(ssid=", str, ", password=", str2, ", channel=");
        sbP.append(i8);
        sbP.append(", bssid=");
        sbP.append(this.f9796d);
        sbP.append(", port=");
        sbP.append(this.e);
        sbP.append(", messagePort=");
        sbP.append(this.f);
        sbP.append(", device=");
        sbP.append(this.f9797g);
        sbP.append(", frequency=");
        sbP.append(i9);
        sbP.append(")");
        return sbP.toString();
    }

    public i2(String str, String str2, int i8, String str3, int i9, int i10, NearDevice nearDevice, int i11) {
        this.f9793a = str;
        this.f9794b = str2;
        this.f9795c = i8;
        this.f9796d = str3;
        this.e = i9;
        this.f = i10;
        this.f9797g = nearDevice;
        this.f9798h = i11;
    }
}
