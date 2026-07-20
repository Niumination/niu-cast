package vj;

/* JADX INFO: loaded from: classes2.dex */
public class a3 extends RuntimeException {
    private static final long serialVersionUID = 1950934672280720624L;
    private final boolean fillInStackTrace;
    private final y2 status;
    private final v1 trailers;

    public a3(y2 y2Var) {
        this(y2Var, null);
    }

    @Override // java.lang.Throwable
    public synchronized Throwable fillInStackTrace() {
        return this.fillInStackTrace ? super.fillInStackTrace() : this;
    }

    public final y2 getStatus() {
        return this.status;
    }

    @gm.j
    public final v1 getTrailers() {
        return this.trailers;
    }

    public a3(y2 y2Var, @gm.j v1 v1Var) {
        this(y2Var, v1Var, true);
    }

    public a3(y2 y2Var, @gm.j v1 v1Var, boolean z10) {
        super(y2.i(y2Var), y2Var.f17570c);
        this.status = y2Var;
        this.trailers = v1Var;
        this.fillInStackTrace = z10;
        fillInStackTrace();
    }
}
