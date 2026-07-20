package af;

import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes3.dex */
public final class w2 implements Thread.UncaughtExceptionHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ j3 f645a;

    public w2(j3 j3Var) {
        this.f645a = j3Var;
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public final void uncaughtException(Thread thread, Throwable th2) {
        Logger logger = j3.c0;
        Level level = Level.SEVERE;
        StringBuilder sb2 = new StringBuilder("[");
        j3 j3Var = this.f645a;
        sb2.append(j3Var.f345a);
        sb2.append("] Uncaught exception in the SynchronizationContext. Panic!");
        logger.log(level, sb2.toString(), th2);
        if (j3Var.f366y) {
            return;
        }
        j3Var.f366y = true;
        j3Var.l(true);
        j3Var.p(false);
        v2 v2Var = new v2(th2);
        j3Var.f365x = v2Var;
        j3Var.D.h(v2Var);
        j3Var.P.i(null);
        j3Var.N.f(ze.h.ERROR, "PANIC! Entering TRANSIENT_FAILURE");
        j3Var.f360r.b(ze.q.TRANSIENT_FAILURE);
    }
}
