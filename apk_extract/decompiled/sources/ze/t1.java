package ze;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import k3.t8;
import k3.u8;
import k3.v8;

/* JADX INFO: loaded from: classes3.dex */
public final class t1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List f11437a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b f11438b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final s1 f11439c;

    public t1(List list, b bVar, s1 s1Var) {
        this.f11437a = Collections.unmodifiableList(new ArrayList(list));
        v8.i(bVar, "attributes");
        this.f11438b = bVar;
        this.f11439c = s1Var;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof t1)) {
            return false;
        }
        t1 t1Var = (t1) obj;
        return u8.a(this.f11437a, t1Var.f11437a) && u8.a(this.f11438b, t1Var.f11438b) && u8.a(this.f11439c, t1Var.f11439c);
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f11437a, this.f11438b, this.f11439c});
    }

    public final String toString() {
        o6.a aVarA = t8.a(this);
        aVarA.d(this.f11437a, "addresses");
        aVarA.d(this.f11438b, "attributes");
        aVarA.d(this.f11439c, "serviceConfig");
        return aVarA.toString();
    }
}
