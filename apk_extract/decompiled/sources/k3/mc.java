package k3;

import android.os.Looper;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public abstract class mc {
    public static Object a(q3.k kVar) throws InterruptedException {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            throw new IllegalStateException("Must not be called on the main application thread");
        }
        if (kVar.c()) {
            return b(kVar);
        }
        a8.a aVar = new a8.a(14);
        q3.j jVar = q3.h.f8952b;
        q3.i iVar = new q3.i((Executor) jVar, (q3.d) aVar);
        af.d2 d2Var = kVar.f8958b;
        d2Var.k(iVar);
        kVar.j();
        kVar.e(jVar, aVar);
        d2Var.k(new q3.i(jVar, aVar));
        kVar.j();
        ((CountDownLatch) aVar.f44b).await();
        return b(kVar);
    }

    public static Object b(q3.k kVar) throws ExecutionException {
        if (kVar.d()) {
            return kVar.b();
        }
        if (kVar.f8960d) {
            throw new CancellationException("Task is already canceled");
        }
        throw new ExecutionException(kVar.a());
    }
}
