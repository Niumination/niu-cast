package ze;

import java.util.Arrays;
import k3.t8;
import k3.u8;
import k3.v8;

/* JADX INFO: loaded from: classes3.dex */
public final class m0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f11375a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final l0 f11376b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f11377c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final af.f2 f11378d;

    public m0(String str, l0 l0Var, long j8, af.f2 f2Var) {
        this.f11375a = str;
        v8.i(l0Var, "severity");
        this.f11376b = l0Var;
        this.f11377c = j8;
        this.f11378d = f2Var;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof m0)) {
            return false;
        }
        m0 m0Var = (m0) obj;
        return u8.a(this.f11375a, m0Var.f11375a) && u8.a(this.f11376b, m0Var.f11376b) && this.f11377c == m0Var.f11377c && u8.a(null, null) && u8.a(this.f11378d, m0Var.f11378d);
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f11375a, this.f11376b, Long.valueOf(this.f11377c), null, this.f11378d});
    }

    public final String toString() {
        o6.a aVarA = t8.a(this);
        aVarA.d(this.f11375a, "description");
        aVarA.d(this.f11376b, "severity");
        aVarA.e("timestampNanos", this.f11377c);
        aVarA.d(null, "channelRef");
        aVarA.d(this.f11378d, "subchannelRef");
        return aVarA.toString();
    }
}
