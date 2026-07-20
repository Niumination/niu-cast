package ze;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import k3.t8;
import k3.u8;
import k3.v8;

/* JADX INFO: loaded from: classes3.dex */
public final class y0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List f11477a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b f11478b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f11479c;

    public y0(List list, b bVar, Object obj) {
        v8.i(list, "addresses");
        this.f11477a = Collections.unmodifiableList(new ArrayList(list));
        v8.i(bVar, "attributes");
        this.f11478b = bVar;
        this.f11479c = obj;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof y0)) {
            return false;
        }
        y0 y0Var = (y0) obj;
        return u8.a(this.f11477a, y0Var.f11477a) && u8.a(this.f11478b, y0Var.f11478b) && u8.a(this.f11479c, y0Var.f11479c);
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f11477a, this.f11478b, this.f11479c});
    }

    public final String toString() {
        o6.a aVarA = t8.a(this);
        aVarA.d(this.f11477a, "addresses");
        aVarA.d(this.f11478b, "attributes");
        aVarA.d(this.f11479c, "loadBalancingPolicyConfig");
        return aVarA.toString();
    }
}
