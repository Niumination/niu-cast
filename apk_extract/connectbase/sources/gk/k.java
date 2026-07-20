package gk;

/* JADX INFO: loaded from: classes2.dex */
public final class k extends x implements nq.l0<k> {

    @os.l
    private final un.s type;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k(@os.l un.s sVar) {
        super(kn.l0.C("Cannot transform this request's content to ", sVar));
        kn.l0.p(sVar, ik.y0.a.f8215h);
        this.type = sVar;
    }

    @Override // nq.l0
    @os.m
    public k createCopy() {
        k kVar = new k(this.type);
        kVar.initCause(this);
        return kVar;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @lm.k(level = lm.m.HIDDEN, message = "Use KType instead")
    public /* synthetic */ k(un.d dVar) {
        this(vn.g.d(dVar));
        kn.l0.p(dVar, ik.y0.a.f8215h);
    }
}
