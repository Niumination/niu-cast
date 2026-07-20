package ze;

import k3.v8;

/* JADX INFO: loaded from: classes3.dex */
public final class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final q f11416a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final q2 f11417b;

    public r(q qVar, q2 q2Var) {
        v8.i(qVar, "state is null");
        this.f11416a = qVar;
        v8.i(q2Var, "status is null");
        this.f11417b = q2Var;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof r)) {
            return false;
        }
        r rVar = (r) obj;
        return this.f11416a.equals(rVar.f11416a) && this.f11417b.equals(rVar.f11417b);
    }

    public final int hashCode() {
        return this.f11417b.hashCode() ^ this.f11416a.hashCode();
    }

    public final String toString() {
        q2 q2Var = this.f11417b;
        boolean zE = q2Var.e();
        q qVar = this.f11416a;
        if (zE) {
            return qVar.toString();
        }
        return qVar + "(" + q2Var + ")";
    }
}
