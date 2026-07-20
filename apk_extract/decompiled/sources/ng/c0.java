package ng;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class c0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f8254a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f8255b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f8256c;

    public c0(String host, int i8, long j8) {
        Intrinsics.checkNotNullParameter(host, "host");
        this.f8254a = host;
        this.f8255b = i8;
        this.f8256c = j8;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c0)) {
            return false;
        }
        c0 c0Var = (c0) obj;
        return Intrinsics.areEqual(this.f8254a, c0Var.f8254a) && this.f8255b == c0Var.f8255b && this.f8256c == c0Var.f8256c;
    }

    public final int hashCode() {
        return Boolean.hashCode(false) + a1.a.f(this.f8256c, a1.a.c(this.f8255b, this.f8254a.hashCode() * 31, 31), 31);
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("HttpServerSettings(host=");
        sb2.append(this.f8254a);
        sb2.append(", port=");
        sb2.append(this.f8255b);
        sb2.append(", connectionIdleTimeoutSeconds=");
        return o.d.p(sb2, this.f8256c, ", reuseAddress=false)");
    }
}
