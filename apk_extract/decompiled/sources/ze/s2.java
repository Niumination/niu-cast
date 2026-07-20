package ze;

/* JADX INFO: loaded from: classes3.dex */
public final class s2 extends RuntimeException {
    private static final long serialVersionUID = 1950934672280720624L;
    private final boolean fillInStackTrace;
    private final q2 status;
    private final p1 trailers;

    public s2(q2 q2Var) {
        this(q2Var, null);
    }

    @Override // java.lang.Throwable
    public synchronized Throwable fillInStackTrace() {
        return this.fillInStackTrace ? super.fillInStackTrace() : this;
    }

    public final q2 getStatus() {
        return this.status;
    }

    public final p1 getTrailers() {
        return this.trailers;
    }

    public s2(q2 q2Var, p1 p1Var) {
        this(q2Var, p1Var, true);
    }

    public s2(q2 q2Var, p1 p1Var, boolean z2) {
        super(q2.b(q2Var), q2Var.f11415c);
        this.status = q2Var;
        this.trailers = p1Var;
        this.fillInStackTrace = z2;
        fillInStackTrace();
    }
}
