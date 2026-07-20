package li;

/* JADX INFO: loaded from: classes3.dex */
public final class z0 implements l1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f7513a;

    public z0(boolean z2) {
        this.f7513a = z2;
    }

    @Override // li.l1
    public final boolean a() {
        return this.f7513a;
    }

    @Override // li.l1
    public final b2 b() {
        return null;
    }

    public final String toString() {
        return a1.a.s(new StringBuilder("Empty{"), this.f7513a ? "Active" : "New", '}');
    }
}
