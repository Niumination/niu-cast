package wj;

import java.util.Arrays;
import java.util.Collection;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
@hm.b
public final class n2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f19098a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f19099b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f19100c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final double f19101d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @gm.j
    public final Long f19102e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Set<vj.y2.b> f19103f;

    public n2(int i10, long j10, long j11, double d10, @gm.j Long l10, @gm.i Set<vj.y2.b> set) {
        this.f19098a = i10;
        this.f19099b = j10;
        this.f19100c = j11;
        this.f19101d = d10;
        this.f19102e = l10;
        this.f19103f = f1.t3.copyOf((Collection) set);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof n2)) {
            return false;
        }
        n2 n2Var = (n2) obj;
        return this.f19098a == n2Var.f19098a && this.f19099b == n2Var.f19099b && this.f19100c == n2Var.f19100c && Double.compare(this.f19101d, n2Var.f19101d) == 0 && c1.b0.a(this.f19102e, n2Var.f19102e) && c1.b0.a(this.f19103f, n2Var.f19103f);
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.f19098a), Long.valueOf(this.f19099b), Long.valueOf(this.f19100c), Double.valueOf(this.f19101d), this.f19102e, this.f19103f});
    }

    public String toString() {
        return c1.z.c(this).d("maxAttempts", this.f19098a).e("initialBackoffNanos", this.f19099b).e("maxBackoffNanos", this.f19100c).b("backoffMultiplier", this.f19101d).j("perAttemptRecvTimeoutNanos", this.f19102e).j("retryableStatusCodes", this.f19103f).toString();
    }
}
