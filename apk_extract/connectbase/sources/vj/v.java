package vj;

/* JADX INFO: loaded from: classes2.dex */
@e0("https://github.com/grpc/grpc-java/issues/1771")
public final class v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final u f17279a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final y2 f17280b;

    public v(u uVar, y2 y2Var) {
        this.f17279a = (u) c1.h0.F(uVar, "state is null");
        this.f17280b = (y2) c1.h0.F(y2Var, "status is null");
    }

    public static v a(u uVar) {
        c1.h0.e(uVar != u.TRANSIENT_FAILURE, "state is TRANSIENT_ERROR. Use forError() instead");
        return new v(uVar, y2.f17548e);
    }

    public static v b(y2 y2Var) {
        c1.h0.e(!y2Var.r(), "The error status must not be OK");
        return new v(u.TRANSIENT_FAILURE, y2Var);
    }

    public u c() {
        return this.f17279a;
    }

    public y2 d() {
        return this.f17280b;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof v)) {
            return false;
        }
        v vVar = (v) obj;
        return this.f17279a.equals(vVar.f17279a) && this.f17280b.equals(vVar.f17280b);
    }

    public int hashCode() {
        return this.f17280b.hashCode() ^ this.f17279a.hashCode();
    }

    public String toString() {
        if (this.f17280b.r()) {
            return this.f17279a.toString();
        }
        return this.f17279a + "(" + this.f17280b + ")";
    }
}
