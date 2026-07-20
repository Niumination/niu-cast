package gk;

/* JADX INFO: loaded from: classes2.dex */
public final class o0 extends c implements nq.l0<o0> {

    @os.l
    private final String parameterName;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o0(@os.l String str) {
        super("Request parameter " + str + " is missing", null, 2, null);
        kn.l0.p(str, "parameterName");
        this.parameterName = str;
    }

    @os.l
    public final String getParameterName() {
        return this.parameterName;
    }

    @Override // nq.l0
    @os.l
    public o0 createCopy() {
        o0 o0Var = new o0(this.parameterName);
        o0Var.initCause(this);
        return o0Var;
    }
}
