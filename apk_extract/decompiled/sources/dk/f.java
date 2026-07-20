package dk;

/* JADX INFO: loaded from: classes3.dex */
public final class f extends RuntimeException {
    private static final long serialVersionUID = -419289748403337611L;

    public f(String str, Throwable th2) {
        super(str, th2 == null ? new NullPointerException() : th2);
    }

    public f(Throwable th2) {
        super(th2 != null ? th2.getMessage() : null, th2 == null ? new NullPointerException() : th2);
    }
}
