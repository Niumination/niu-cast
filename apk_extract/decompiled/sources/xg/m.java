package xg;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class m extends n {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final double f10965i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final zf.d0 f10966j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final int f10967k;

    public m(double d7, zf.d0 parameters, int i8) {
        Intrinsics.checkNotNullParameter(parameters, "parameters");
        this.f10965i = d7;
        this.f10966j = parameters;
        this.f10967k = i8;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof m)) {
            return false;
        }
        m mVar = (m) obj;
        return Double.compare(this.f10965i, mVar.f10965i) == 0 && Intrinsics.areEqual(this.f10966j, mVar.f10966j) && this.f10967k == mVar.f10967k;
    }

    public final int hashCode() {
        return Integer.hashCode(this.f10967k) + ((this.f10966j.hashCode() + (Double.hashCode(this.f10965i) * 31)) * 31);
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("Success(quality=");
        sb2.append(this.f10965i);
        sb2.append(", parameters=");
        sb2.append(this.f10966j);
        sb2.append(", segmentIncrement=");
        return a1.a.r(sb2, this.f10967k, ')');
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ m(int i8, int i9, double d7) {
        this(d7, zf.m.f11519c, (i9 & 4) != 0 ? 0 : i8);
        zf.d0.f11496b.getClass();
    }
}
