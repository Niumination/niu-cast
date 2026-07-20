package le;

import af.w5;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f7420a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final w5 f7421b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Exception f7422c;

    public a(boolean z2, w5 w5Var, Exception exc) {
        this.f7420a = z2;
        this.f7421b = w5Var;
        this.f7422c = exc;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return this.f7420a == aVar.f7420a && Intrinsics.areEqual(this.f7421b, aVar.f7421b) && Intrinsics.areEqual(this.f7422c, aVar.f7422c);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    public final int hashCode() {
        boolean z2 = this.f7420a;
        ?? r7 = z2;
        if (z2) {
            r7 = 1;
        }
        int i8 = r7 * 31;
        w5 w5Var = this.f7421b;
        int iHashCode = (i8 + (w5Var == null ? 0 : w5Var.hashCode())) * 31;
        Exception exc = this.f7422c;
        return iHashCode + (exc != null ? exc.hashCode() : 0);
    }

    public final String toString() {
        return "ServerResult(isSuccess=" + this.f7420a + ", server=" + this.f7421b + ", exception=" + this.f7422c + ')';
    }
}
