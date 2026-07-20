package nq;

/* JADX INFO: loaded from: classes3.dex */
public final class e0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.m
    @in.f
    public final Object f11846a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @in.f
    @os.l
    public final jn.l<Throwable, lm.l2> f11847b;

    /* JADX WARN: Multi-variable type inference failed */
    public e0(@os.m Object obj, @os.l jn.l<? super Throwable, lm.l2> lVar) {
        this.f11846a = obj;
        this.f11847b = lVar;
    }

    public static e0 d(e0 e0Var, Object obj, jn.l lVar, int i10, Object obj2) {
        if ((i10 & 1) != 0) {
            obj = e0Var.f11846a;
        }
        if ((i10 & 2) != 0) {
            lVar = e0Var.f11847b;
        }
        e0Var.getClass();
        return new e0(obj, lVar);
    }

    @os.m
    public final Object a() {
        return this.f11846a;
    }

    @os.l
    public final jn.l<Throwable, lm.l2> b() {
        return this.f11847b;
    }

    @os.l
    public final e0 c(@os.m Object obj, @os.l jn.l<? super Throwable, lm.l2> lVar) {
        return new e0(obj, lVar);
    }

    public boolean equals(@os.m Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof e0)) {
            return false;
        }
        e0 e0Var = (e0) obj;
        return kn.l0.g(this.f11846a, e0Var.f11846a) && kn.l0.g(this.f11847b, e0Var.f11847b);
    }

    public int hashCode() {
        Object obj = this.f11846a;
        return this.f11847b.hashCode() + ((obj == null ? 0 : obj.hashCode()) * 31);
    }

    @os.l
    public String toString() {
        return "CompletedWithCancellation(result=" + this.f11846a + ", onCancellation=" + this.f11847b + ')';
    }
}
