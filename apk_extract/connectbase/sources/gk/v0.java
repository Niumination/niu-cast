package gk;

/* JADX INFO: loaded from: classes2.dex */
public final class v0 extends c implements nq.l0<v0> {

    @os.l
    private final String parameterName;

    @os.l
    private final String type;

    public /* synthetic */ v0(String str, String str2, Throwable th2, int i10, kn.w wVar) {
        this(str, str2, (i10 & 4) != 0 ? null : th2);
    }

    @os.l
    public final String getParameterName() {
        return this.parameterName;
    }

    @os.l
    public final String getType() {
        return this.type;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public v0(@os.l String str, @os.l String str2, @os.m Throwable th2) {
        super("Request parameter " + str + " couldn't be parsed/converted to " + str2, th2);
        kn.l0.p(str, "parameterName");
        kn.l0.p(str2, ik.y0.a.f8215h);
        this.parameterName = str;
        this.type = str2;
    }

    @Override // nq.l0
    @os.l
    public v0 createCopy() {
        v0 v0Var = new v0(this.parameterName, this.type, this);
        v0Var.initCause(this);
        return v0Var;
    }
}
