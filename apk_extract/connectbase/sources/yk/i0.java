package yk;

import java.util.concurrent.atomic.AtomicBoolean;
import kn.l0;
import lm.l2;

/* JADX INFO: loaded from: classes2.dex */
public final class i0 extends Thread {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public final jn.a<l2> f21415a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.l
    public final AtomicBoolean f21416b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i0(@os.l jn.a<l2> aVar) {
        super("KtorShutdownHook");
        l0.p(aVar, "stopFunction");
        this.f21415a = aVar;
        this.f21416b = new AtomicBoolean(true);
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        if (this.f21416b.compareAndSet(true, false)) {
            this.f21415a.invoke();
        }
    }
}
