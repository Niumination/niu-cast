package wj;

import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes2.dex */
public final class k1 implements Runnable {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Logger f18780b = Logger.getLogger(k1.class.getName());

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Runnable f18781a;

    public k1(Runnable runnable) {
        this.f18781a = (Runnable) c1.h0.F(runnable, "task");
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            this.f18781a.run();
        } catch (Throwable th2) {
            f18780b.log(Level.SEVERE, "Exception while executing runnable " + this.f18781a, th2);
            c1.t0.w(th2);
            throw new AssertionError(th2);
        }
    }

    public String toString() {
        return "LogExceptionRunnable(" + this.f18781a + ")";
    }
}
