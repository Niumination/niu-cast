package nq;

/* JADX INFO: loaded from: classes3.dex */
public abstract class s2 extends f0 implements n1, e2 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public t2 f11924d;

    @os.l
    public final t2 C() {
        t2 t2Var = this.f11924d;
        if (t2Var != null) {
            return t2Var;
        }
        kn.l0.S("job");
        return null;
    }

    public final void D(@os.l t2 t2Var) {
        this.f11924d = t2Var;
    }

    @Override // nq.e2
    @os.m
    public y2 b() {
        return null;
    }

    @Override // nq.n1
    public void dispose() {
        C().y1(this);
    }

    @Override // nq.e2
    public boolean isActive() {
        return true;
    }

    @Override // vq.a0
    @os.l
    public String toString() {
        return x0.a(this) + '@' + x0.b(this) + "[job@" + x0.b(C()) + ']';
    }
}
