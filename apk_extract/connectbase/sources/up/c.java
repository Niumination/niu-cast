package up;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import kn.l0;
import lm.l2;

/* JADX INFO: loaded from: classes3.dex */
public final class c extends d {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @os.l
    public final Runnable f16359c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @os.l
    public final jn.l<InterruptedException, l2> f16360d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public c(@os.l Lock lock, @os.l Runnable runnable, @os.l jn.l<? super InterruptedException, l2> lVar) {
        super(lock);
        l0.p(lock, "lock");
        l0.p(runnable, "checkCancelled");
        l0.p(lVar, "interruptedExceptionHandler");
        this.f16359c = runnable;
        this.f16360d = lVar;
    }

    @Override // up.d, up.k
    public void lock() {
        while (!this.f16361b.tryLock(50L, TimeUnit.MILLISECONDS)) {
            try {
                this.f16359c.run();
            } catch (InterruptedException e10) {
                this.f16360d.invoke(e10);
                return;
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public c(@os.l Runnable runnable, @os.l jn.l<? super InterruptedException, l2> lVar) {
        this(new ReentrantLock(), runnable, lVar);
        l0.p(runnable, "checkCancelled");
        l0.p(lVar, "interruptedExceptionHandler");
    }
}
