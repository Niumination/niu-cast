package i4;

/* JADX INFO: loaded from: classes.dex */
public final class d0 extends a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final h0 f5574c;

    public d0(h0 h0Var, int i8) {
        super(h0Var.size(), i8);
        this.f5574c = h0Var;
    }

    @Override // i4.a
    public final Object a(int i8) {
        return this.f5574c.get(i8);
    }
}
