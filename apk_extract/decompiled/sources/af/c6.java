package af;

import java.util.Arrays;
import k3.t8;
import k3.u8;

/* JADX INFO: loaded from: classes3.dex */
public final class c6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ze.c1 f207a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f208b;

    public c6(ze.c1 c1Var, Object obj) {
        this.f207a = c1Var;
        this.f208b = obj;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || c6.class != obj.getClass()) {
            return false;
        }
        c6 c6Var = (c6) obj;
        return u8.a(this.f207a, c6Var.f207a) && u8.a(this.f208b, c6Var.f208b);
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f207a, this.f208b});
    }

    public final String toString() {
        o6.a aVarA = t8.a(this);
        aVarA.d(this.f207a, "provider");
        aVarA.d(this.f208b, "config");
        return aVarA.toString();
    }
}
