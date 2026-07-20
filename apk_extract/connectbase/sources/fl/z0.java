package fl;

/* JADX INFO: loaded from: classes2.dex */
public final class z0 {
    public static final void a(@os.l ps.a aVar, @os.l Throwable th2) {
        kn.l0.p(aVar, "<this>");
        kn.l0.p(th2, "exception");
        String message = th2.getMessage();
        if (message == null) {
            message = kn.l0.C("Exception of type ", th2.getClass());
        }
        aVar.error(message, th2);
    }
}
