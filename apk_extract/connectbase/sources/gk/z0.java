package gk;

/* JADX INFO: loaded from: classes2.dex */
public final class z0 extends Exception {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public z0(@os.l Throwable th2) {
        super("Request body consumption was failed", th2, false, true);
        kn.l0.p(th2, "cause");
    }
}
