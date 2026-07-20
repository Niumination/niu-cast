package af;

import java.util.Arrays;
import k3.u8;
import k3.v8;

/* JADX INFO: loaded from: classes3.dex */
public final class i4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ze.f f333a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ze.p1 f334b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ze.r1 f335c;

    public i4(ze.r1 r1Var, ze.p1 p1Var, ze.f fVar) {
        v8.i(r1Var, "method");
        this.f335c = r1Var;
        v8.i(p1Var, "headers");
        this.f334b = p1Var;
        v8.i(fVar, "callOptions");
        this.f333a = fVar;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || i4.class != obj.getClass()) {
            return false;
        }
        i4 i4Var = (i4) obj;
        return u8.a(this.f333a, i4Var.f333a) && u8.a(this.f334b, i4Var.f334b) && u8.a(this.f335c, i4Var.f335c);
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f333a, this.f334b, this.f335c});
    }

    public final String toString() {
        return "[method=" + this.f335c + " headers=" + this.f334b + " callOptions=" + this.f333a + "]";
    }
}
