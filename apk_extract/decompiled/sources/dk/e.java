package dk;

/* JADX INFO: loaded from: classes3.dex */
public final class e extends RuntimeException {
    private static final long serialVersionUID = 8622579378868820554L;

    public e(Throwable th2) {
        super(th2 == null ? new NullPointerException() : th2);
    }

    public e(String str, Throwable th2) {
        super(str, th2 == null ? new NullPointerException() : th2);
    }
}
