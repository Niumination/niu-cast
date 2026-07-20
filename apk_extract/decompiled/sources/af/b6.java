package af;

import java.util.Arrays;
import java.util.Map;
import k3.t8;
import k3.v8;

/* JADX INFO: loaded from: classes3.dex */
public final class b6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f192a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map f193b;

    public b6(String str, Map map) {
        v8.i(str, "policyName");
        this.f192a = str;
        v8.i(map, "rawConfigValue");
        this.f193b = map;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof b6)) {
            return false;
        }
        b6 b6Var = (b6) obj;
        return this.f192a.equals(b6Var.f192a) && this.f193b.equals(b6Var.f193b);
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f192a, this.f193b});
    }

    public final String toString() {
        o6.a aVarA = t8.a(this);
        aVarA.d(this.f192a, "policyName");
        aVarA.d(this.f193b, "rawConfigValue");
        return aVarA.toString();
    }
}
