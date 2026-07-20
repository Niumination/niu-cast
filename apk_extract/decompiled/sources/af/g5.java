package af;

import java.util.Arrays;
import java.util.Collection;
import java.util.Set;
import k3.t8;
import k3.u8;

/* JADX INFO: loaded from: classes3.dex */
public final class g5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f293a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f294b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f295c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final double f296d;
    public final Long e;
    public final i4.s1 f;

    public g5(int i8, long j8, long j10, double d7, Long l4, Set set) {
        this.f293a = i8;
        this.f294b = j8;
        this.f295c = j10;
        this.f296d = d7;
        this.e = l4;
        this.f = i4.s1.copyOf((Collection) set);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof g5)) {
            return false;
        }
        g5 g5Var = (g5) obj;
        return this.f293a == g5Var.f293a && this.f294b == g5Var.f294b && this.f295c == g5Var.f295c && Double.compare(this.f296d, g5Var.f296d) == 0 && u8.a(this.e, g5Var.e) && u8.a(this.f, g5Var.f);
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.f293a), Long.valueOf(this.f294b), Long.valueOf(this.f295c), Double.valueOf(this.f296d), this.e, this.f});
    }

    public final String toString() {
        o6.a aVarA = t8.a(this);
        aVarA.c(this.f293a, "maxAttempts");
        aVarA.e("initialBackoffNanos", this.f294b);
        aVarA.e("maxBackoffNanos", this.f295c);
        aVarA.g("backoffMultiplier", String.valueOf(this.f296d));
        aVarA.d(this.e, "perAttemptRecvTimeoutNanos");
        aVarA.d(this.f, "retryableStatusCodes");
        return aVarA.toString();
    }
}
