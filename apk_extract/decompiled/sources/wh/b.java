package wh;

/* JADX INFO: loaded from: classes3.dex */
public final class b extends Throwable {
    private static final long serialVersionUID = -4649703670690200604L;

    public b() {
        super("No further exceptions");
    }

    @Override // java.lang.Throwable
    public Throwable fillInStackTrace() {
        return this;
    }
}
