package wj;

import java.util.Arrays;
import java.util.Collection;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
@hm.b
public final class x0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f19532a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f19533b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Set<vj.y2.b> f19534c;

    public x0(int i10, long j10, Set<vj.y2.b> set) {
        this.f19532a = i10;
        this.f19533b = j10;
        this.f19534c = f1.t3.copyOf((Collection) set);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || x0.class != obj.getClass()) {
            return false;
        }
        x0 x0Var = (x0) obj;
        return this.f19532a == x0Var.f19532a && this.f19533b == x0Var.f19533b && c1.b0.a(this.f19534c, x0Var.f19534c);
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.f19532a), Long.valueOf(this.f19533b), this.f19534c});
    }

    public String toString() {
        return c1.z.c(this).d("maxAttempts", this.f19532a).e("hedgingDelayNanos", this.f19533b).j("nonFatalStatusCodes", this.f19534c).toString();
    }
}
