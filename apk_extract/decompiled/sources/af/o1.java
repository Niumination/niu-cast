package af;

import java.util.Arrays;
import java.util.Collection;
import java.util.Set;
import k3.t8;
import k3.u8;

/* JADX INFO: loaded from: classes3.dex */
public final class o1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f480a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f481b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final i4.s1 f482c;

    public o1(int i8, long j8, Set set) {
        this.f480a = i8;
        this.f481b = j8;
        this.f482c = i4.s1.copyOf((Collection) set);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || o1.class != obj.getClass()) {
            return false;
        }
        o1 o1Var = (o1) obj;
        return this.f480a == o1Var.f480a && this.f481b == o1Var.f481b && u8.a(this.f482c, o1Var.f482c);
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.f480a), Long.valueOf(this.f481b), this.f482c});
    }

    public final String toString() {
        o6.a aVarA = t8.a(this);
        aVarA.c(this.f480a, "maxAttempts");
        aVarA.e("hedgingDelayNanos", this.f481b);
        aVarA.d(this.f482c, "nonFatalStatusCodes");
        return aVarA.toString();
    }
}
