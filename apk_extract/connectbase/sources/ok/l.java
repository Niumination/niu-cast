package ok;

import kn.l0;
import kn.w;

/* JADX INFO: loaded from: classes2.dex */
public final class l extends IllegalArgumentException {

    @os.m
    private final Throwable cause;

    @os.l
    private final String message;

    public /* synthetic */ l(String str, Throwable th2, int i10, w wVar) {
        this(str, (i10 & 2) != 0 ? null : th2);
    }

    @Override // java.lang.Throwable
    @os.m
    public Throwable getCause() {
        return this.cause;
    }

    @Override // java.lang.Throwable
    @os.l
    public String getMessage() {
        return this.message;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l(@os.l String str, @os.m Throwable th2) {
        super(str, th2);
        l0.p(str, "message");
        this.message = str;
        this.cause = th2;
    }
}
