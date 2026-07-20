package nq;

import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/* JADX INFO: loaded from: classes3.dex */
public final class t extends d0 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @os.l
    public static final AtomicIntegerFieldUpdater f11928c = AtomicIntegerFieldUpdater.newUpdater(t.class, "_resumed");

    @in.x
    private volatile int _resumed;

    public t(@os.l um.d<?> dVar, @os.m Throwable th2, boolean z10) {
        if (th2 == null) {
            th2 = new CancellationException("Continuation " + dVar + " was cancelled normally");
        }
        super(th2, z10);
        this._resumed = 0;
    }

    public final boolean c() {
        return f11928c.compareAndSet(this, 0, 1);
    }
}
