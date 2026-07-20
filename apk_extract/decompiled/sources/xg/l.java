package xg;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class l extends n {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final double f10963i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final zf.z f10964j;

    public l(double d7, zf.z failureStatusCode) {
        Intrinsics.checkNotNullParameter(failureStatusCode, "failureStatusCode");
        this.f10963i = d7;
        this.f10964j = failureStatusCode;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof l)) {
            return false;
        }
        l lVar = (l) obj;
        return Double.compare(this.f10963i, lVar.f10963i) == 0 && Intrinsics.areEqual(this.f10964j, lVar.f10964j);
    }

    public final int hashCode() {
        return Integer.hashCode(this.f10964j.f11581a) + (Double.hashCode(this.f10963i) * 31);
    }

    public final String toString() {
        return "Failure(quality=" + this.f10963i + ", failureStatusCode=" + this.f10964j + ')';
    }
}
