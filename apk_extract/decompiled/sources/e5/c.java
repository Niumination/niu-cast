package e5;

/* JADX INFO: loaded from: classes2.dex */
public final class c extends Exception {
    private b errorType;
    private String message;

    public c(b bVar, String str) {
        super(str);
        this.message = str;
        this.errorType = bVar;
    }

    public b getErrorType() {
        return this.errorType;
    }

    @Override // java.lang.Throwable
    public String toString() {
        return "Error type: " + this.errorType + ". " + this.message;
    }
}
