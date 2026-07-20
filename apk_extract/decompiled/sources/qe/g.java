package qe;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f9017a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f9018b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f9019c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f9020d;

    public g(String macAddress, int i8, String staticIP, boolean z2) {
        Intrinsics.checkNotNullParameter(macAddress, "macAddress");
        Intrinsics.checkNotNullParameter(staticIP, "staticIP");
        this.f9017a = z2;
        this.f9018b = macAddress;
        this.f9019c = staticIP;
        this.f9020d = i8;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof g)) {
            return false;
        }
        g gVar = (g) obj;
        return this.f9017a == gVar.f9017a && Intrinsics.areEqual(this.f9018b, gVar.f9018b) && Intrinsics.areEqual(this.f9019c, gVar.f9019c) && this.f9020d == gVar.f9020d;
    }

    public final int hashCode() {
        return Integer.hashCode(this.f9020d) + a1.a.e(a1.a.e(Boolean.hashCode(this.f9017a) * 31, 31, this.f9018b), 31, this.f9019c);
    }

    public final String toString() {
        return "P2pInfo(isSupport5G=" + this.f9017a + ", macAddress=" + this.f9018b + ", staticIP=" + this.f9019c + ", frequency=" + this.f9020d + ")";
    }
}
