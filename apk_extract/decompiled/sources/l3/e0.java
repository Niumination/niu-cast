package l3;

/* JADX INFO: loaded from: classes.dex */
public final class e0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final q1 f7232a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f7233b;

    public e0(q1 q1Var, int i8) {
        this.f7232a = q1Var;
        this.f7233b = i8;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof e0)) {
            return false;
        }
        e0 e0Var = (e0) obj;
        return this.f7232a == e0Var.f7232a && this.f7233b == e0Var.f7233b;
    }

    public final int hashCode() {
        return (System.identityHashCode(this.f7232a) * 65535) + this.f7233b;
    }
}
