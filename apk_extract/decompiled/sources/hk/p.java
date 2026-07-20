package hk;

import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes3.dex */
public final class p extends AtomicBoolean implements ck.j {
    private static final long serialVersionUID = 247232374289553518L;
    final qk.b parent;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    final q f5515s;

    public p(q qVar, qk.b bVar) {
        this.f5515s = qVar;
        this.parent = bVar;
    }

    @Override // ck.j
    public boolean isUnsubscribed() {
        return this.f5515s.isUnsubscribed();
    }

    @Override // ck.j
    public void unsubscribe() {
        if (compareAndSet(false, true)) {
            this.parent.b(this.f5515s);
        }
    }
}
