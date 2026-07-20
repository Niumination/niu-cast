package vp;

/* JADX INFO: loaded from: classes3.dex */
public final class u0 extends f implements yp.l {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @os.l
    public final a1 f17744f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @os.l
    public final op.h f17745g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public u0(@os.l a1 a1Var, boolean z10, @os.l a1 a1Var2) {
        super(a1Var, z10);
        kn.l0.p(a1Var, "originalTypeVariable");
        kn.l0.p(a1Var2, "constructor");
        this.f17744f = a1Var2;
        this.f17745g = a1Var.n().i().o();
    }

    @Override // vp.f0
    @os.l
    public a1 G0() {
        return this.f17744f;
    }

    @Override // vp.f
    @os.l
    public f Q0(boolean z10) {
        return new u0(this.f17681b, z10, this.f17744f);
    }

    @Override // vp.f, vp.f0
    @os.l
    public op.h o() {
        return this.f17745g;
    }

    @Override // vp.n0
    @os.l
    public String toString() {
        StringBuilder sb2 = new StringBuilder("Stub (BI): ");
        sb2.append(this.f17681b);
        sb2.append(this.f17682c ? "?" : "");
        return sb2.toString();
    }
}
