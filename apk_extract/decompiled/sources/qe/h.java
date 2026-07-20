package qe;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f9021a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f9022b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f9023c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f9024d;
    public final String e;
    public final String f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f9025g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f9026h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f9027i;

    public h(int i8, boolean z2, int i9, int i10, String str, String str2, String str3, String str4, String str5) {
        this.f9021a = i8;
        this.f9022b = z2;
        this.f9023c = i9;
        this.f9024d = i10;
        this.e = str;
        this.f = str2;
        this.f9025g = str3;
        this.f9026h = str4;
        this.f9027i = str5;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof h)) {
            return false;
        }
        h hVar = (h) obj;
        return this.f9021a == hVar.f9021a && this.f9022b == hVar.f9022b && this.f9023c == hVar.f9023c && this.f9024d == hVar.f9024d && Intrinsics.areEqual(this.e, hVar.e) && Intrinsics.areEqual(this.f, hVar.f) && Intrinsics.areEqual(this.f9025g, hVar.f9025g) && Intrinsics.areEqual(this.f9026h, hVar.f9026h) && Intrinsics.areEqual(this.f9027i, hVar.f9027i);
    }

    public final int hashCode() {
        int iC = a1.a.c(this.f9024d, a1.a.c(this.f9023c, a1.a.g(this.f9022b, Integer.hashCode(this.f9021a) * 31, 31), 31), 31);
        String str = this.e;
        int iHashCode = (iC + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.f;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.f9025g;
        int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.f9026h;
        int iHashCode4 = (iHashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.f9027i;
        return Integer.hashCode(0) + a1.a.g(true, a1.a.c(0, (iHashCode4 + (str5 == null ? 0 : str5.hashCode())) * 31, 31), 31);
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("PhoneCloneInfo(protocolVersion=");
        sb2.append(this.f9021a);
        sb2.append(", isSupport5G=");
        sb2.append(this.f9022b);
        sb2.append(", androidVersion=");
        sb2.append(this.f9023c);
        sb2.append(", brandCode=");
        sb2.append(this.f9024d);
        sb2.append(", phoneName=");
        sb2.append(this.e);
        sb2.append(", softwareVersion=");
        sb2.append(this.f);
        sb2.append(", phoneUID=");
        sb2.append(this.f9025g);
        sb2.append(", ssid=");
        sb2.append(this.f9026h);
        sb2.append(", password=");
        return h0.a.n(sb2, this.f9027i, ", rssi=0, success=true, reasonCode=0)");
    }
}
