package qe;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f9031a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f9032b;

    public j(boolean z2, String macAddress) {
        Intrinsics.checkNotNullParameter(macAddress, "macAddress");
        this.f9031a = z2;
        this.f9032b = macAddress;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof j)) {
            return false;
        }
        j jVar = (j) obj;
        return this.f9031a == jVar.f9031a && Intrinsics.areEqual(this.f9032b, jVar.f9032b);
    }

    public final int hashCode() {
        return this.f9032b.hashCode() + (Boolean.hashCode(this.f9031a) * 31);
    }

    public final String toString() {
        return "Support5GAndMac(isSupport5G=" + this.f9031a + ", macAddress=" + this.f9032b + ")";
    }
}
