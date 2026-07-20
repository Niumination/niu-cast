package qe;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f9033a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f9034b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f9035c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f9036d;
    public final int e;
    public final int f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f9037g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f9038h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final byte f9039i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final String f9040j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final String f9041k;

    public k(boolean z2, String apBssidInString, int i8, int i9, int i10, int i11, String ipInString, String gatewayIpInString, byte b9, String ssid, String password) {
        Intrinsics.checkNotNullParameter(apBssidInString, "apBssidInString");
        Intrinsics.checkNotNullParameter(ipInString, "ipInString");
        Intrinsics.checkNotNullParameter(gatewayIpInString, "gatewayIpInString");
        Intrinsics.checkNotNullParameter(ssid, "ssid");
        Intrinsics.checkNotNullParameter(password, "password");
        this.f9033a = z2;
        this.f9034b = apBssidInString;
        this.f9035c = i8;
        this.f9036d = i9;
        this.e = i10;
        this.f = i11;
        this.f9037g = ipInString;
        this.f9038h = gatewayIpInString;
        this.f9039i = b9;
        this.f9040j = ssid;
        this.f9041k = password;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof k)) {
            return false;
        }
        k kVar = (k) obj;
        return this.f9033a == kVar.f9033a && Intrinsics.areEqual(this.f9034b, kVar.f9034b) && this.f9035c == kVar.f9035c && this.f9036d == kVar.f9036d && this.e == kVar.e && this.f == kVar.f && Intrinsics.areEqual(this.f9037g, kVar.f9037g) && Intrinsics.areEqual(this.f9038h, kVar.f9038h) && this.f9039i == kVar.f9039i && Intrinsics.areEqual(this.f9040j, kVar.f9040j) && Intrinsics.areEqual(this.f9041k, kVar.f9041k);
    }

    public final int hashCode() {
        return this.f9041k.hashCode() + a1.a.e((Byte.hashCode(this.f9039i) + a1.a.e(a1.a.e(a1.a.c(this.f, a1.a.c(this.e, a1.a.c(this.f9036d, a1.a.c(this.f9035c, a1.a.e(Boolean.hashCode(this.f9033a) * 31, 31, this.f9034b), 31), 31), 31), 31), 31, this.f9037g), 31, this.f9038h)) * 31, 31, this.f9040j);
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("WifiInfo(isWifiConnected=");
        sb2.append(this.f9033a);
        sb2.append(", apBssidInString=");
        sb2.append(this.f9034b);
        sb2.append(", apRssi=");
        sb2.append(this.f9035c);
        sb2.append(", linkSpeed=");
        sb2.append(this.f9036d);
        sb2.append(", wifiFrequency=");
        sb2.append(this.e);
        sb2.append(", score=");
        sb2.append(this.f);
        sb2.append(", ipInString=");
        sb2.append(this.f9037g);
        sb2.append(", gatewayIpInString=");
        sb2.append(this.f9038h);
        sb2.append(", encryptionType=");
        sb2.append((int) this.f9039i);
        sb2.append(", ssid=");
        sb2.append(this.f9040j);
        sb2.append(", password=");
        return h0.a.n(sb2, this.f9041k, ")");
    }
}
