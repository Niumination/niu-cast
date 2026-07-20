package gk;

/* JADX INFO: loaded from: classes2.dex */
public final class c1 extends x implements nq.l0<c1> {

    @os.l
    private final ik.i contentType;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c1(@os.l ik.i iVar) {
        super("Content type " + iVar + " is not supported");
        kn.l0.p(iVar, "contentType");
        this.contentType = iVar;
    }

    @Override // nq.l0
    @os.m
    public c1 createCopy() {
        c1 c1Var = new c1(this.contentType);
        c1Var.initCause(this);
        return c1Var;
    }
}
