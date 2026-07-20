package af;

/* JADX INFO: loaded from: classes3.dex */
public final class q4 implements Thread.UncaughtExceptionHandler {
    @Override // java.lang.Thread.UncaughtExceptionHandler
    public final void uncaughtException(Thread thread, Throwable th2) {
        throw new ze.s2(ze.q2.d(th2).h("Uncaught exception in the SynchronizationContext. Re-thrown."));
    }
}
