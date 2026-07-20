package dk;

/* JADX INFO: loaded from: classes3.dex */
public final class g extends RuntimeException {
    private static final long serialVersionUID = -6298857009889503852L;

    public g(String str, Throwable th2) {
        super(str, th2 == null ? new NullPointerException() : th2);
    }

    public g(Throwable th2) {
        super(th2 != null ? th2.getMessage() : null, th2 == null ? new NullPointerException() : th2);
    }
}
