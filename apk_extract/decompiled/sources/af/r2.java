package af;

import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes3.dex */
public final class r2 implements Runnable {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Logger f549b = Logger.getLogger(r2.class.getName());

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Runnable f550a;

    public r2(Runnable runnable) {
        this.f550a = runnable;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Runnable runnable = this.f550a;
        try {
            runnable.run();
        } catch (Throwable th2) {
            f549b.log(Level.SEVERE, "Exception while executing runnable " + runnable, th2);
            h4.v.a(th2);
            throw new AssertionError(th2);
        }
    }

    public final String toString() {
        return "LogExceptionRunnable(" + this.f550a + ")";
    }
}
