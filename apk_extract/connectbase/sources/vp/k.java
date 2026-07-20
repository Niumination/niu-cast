package vp;

/* JADX INFO: loaded from: classes3.dex */
public final class k extends r {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @os.l
    public final fo.g f17717c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k(@os.l n0 n0Var, @os.l fo.g gVar) {
        super(n0Var);
        kn.l0.p(n0Var, "delegate");
        kn.l0.p(gVar, "annotations");
        this.f17717c = gVar;
    }

    @Override // vp.q
    @os.l
    /* JADX INFO: renamed from: T0, reason: merged with bridge method [inline-methods] */
    public k R0(@os.l n0 n0Var) {
        kn.l0.p(n0Var, "delegate");
        return new k(n0Var, this.f17717c);
    }

    @Override // vp.q, fo.a
    @os.l
    public fo.g getAnnotations() {
        return this.f17717c;
    }
}
