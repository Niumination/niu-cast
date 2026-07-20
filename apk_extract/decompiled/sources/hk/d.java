package hk;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/* JADX INFO: loaded from: classes3.dex */
public final class d extends ck.g {
    public static final AtomicIntegerFieldUpdater e = AtomicIntegerFieldUpdater.newUpdater(d.class, "d");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final qk.b f5486a = new qk.b();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b f5487b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final e f5488c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public volatile int f5489d;

    public d(b bVar) {
        e eVar;
        e eVar2;
        this.f5487b = bVar;
        if (bVar.f5482d.f9239b) {
            eVar2 = f.f5492d;
        } else {
            do {
                if (bVar.f5481c.isEmpty()) {
                    eVar = new e(bVar.f5479a);
                    bVar.f5482d.a(eVar);
                    break;
                }
                eVar = (e) bVar.f5481c.poll();
            } while (eVar == null);
            eVar2 = eVar;
        }
        this.f5488c = eVar2;
    }

    @Override // ck.g
    public final ck.j a(ek.a aVar, long j8, TimeUnit timeUnit) {
        if (this.f5486a.f9239b) {
            return qk.e.f9242a;
        }
        q qVarD = this.f5488c.d(new c(0, this, aVar), j8, timeUnit);
        this.f5486a.a(qVarD);
        qVarD.addParent(this.f5486a);
        return qVarD;
    }

    @Override // ck.g
    public final ck.j b(fk.h hVar) {
        return a(hVar, 0L, null);
    }

    @Override // ck.j
    public final boolean isUnsubscribed() {
        return this.f5486a.f9239b;
    }

    @Override // ck.j
    public final void unsubscribe() {
        if (e.compareAndSet(this, 0, 1)) {
            b bVar = this.f5487b;
            bVar.getClass();
            long jNanoTime = System.nanoTime() + bVar.f5480b;
            e eVar = this.f5488c;
            eVar.f5490l = jNanoTime;
            bVar.f5481c.offer(eVar);
        }
        this.f5486a.unsubscribe();
    }
}
