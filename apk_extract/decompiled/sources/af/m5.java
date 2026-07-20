package af;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/* JADX INFO: loaded from: classes3.dex */
public final class m5 extends d6 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AtomicIntegerFieldUpdater f458c;

    public m5(AtomicIntegerFieldUpdater atomicIntegerFieldUpdater) {
        this.f458c = atomicIntegerFieldUpdater;
    }

    @Override // af.d6
    public final boolean s(o5 o5Var) {
        return this.f458c.compareAndSet(o5Var, 0, -1);
    }

    @Override // af.d6
    public final void t(o5 o5Var) {
        this.f458c.set(o5Var, 0);
    }
}
