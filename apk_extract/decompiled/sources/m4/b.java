package m4;

/* JADX INFO: loaded from: classes.dex */
public final class b extends Throwable {
    public b(String str) {
        super(str);
    }

    @Override // java.lang.Throwable
    public synchronized Throwable fillInStackTrace() {
        return this;
    }
}
