package dk;

/* JADX INFO: loaded from: classes3.dex */
public final class k extends RuntimeException {
    private static final long serialVersionUID = 4594672310593167598L;

    public k(Throwable th2) {
        super(th2 == null ? new NullPointerException() : th2);
    }

    public k(String str, Throwable th2) {
        super(str, th2 == null ? new NullPointerException() : th2);
    }
}
