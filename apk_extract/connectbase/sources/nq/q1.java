package nq;

/* JADX INFO: loaded from: classes3.dex */
public final class q1 implements e2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f11902a;

    public q1(boolean z10) {
        this.f11902a = z10;
    }

    @Override // nq.e2
    @os.m
    public y2 b() {
        return null;
    }

    @Override // nq.e2
    public boolean isActive() {
        return this.f11902a;
    }

    @os.l
    public String toString() {
        return l.a.a(new StringBuilder("Empty{"), this.f11902a ? "Active" : "New", rs.f.f14860b);
    }
}
