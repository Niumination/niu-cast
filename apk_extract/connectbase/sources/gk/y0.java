package gk;

/* JADX INFO: loaded from: classes2.dex */
public final class y0 extends IllegalArgumentException implements nq.l0<y0> {

    @os.l
    private final String illegalCallId;

    public y0(@os.l String str) {
        kn.l0.p(str, "illegalCallId");
        this.illegalCallId = str;
    }

    @os.l
    public final String getIllegalCallId() {
        return this.illegalCallId;
    }

    @Override // nq.l0
    @os.m
    public y0 createCopy() {
        y0 y0Var = new y0(this.illegalCallId);
        y0Var.initCause(this);
        return y0Var;
    }
}
