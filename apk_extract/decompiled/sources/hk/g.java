package hk;

import ik.v;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes3.dex */
public final class g extends ck.g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final v f5494a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final qk.b f5495b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final v f5496c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final i f5497d;

    public g(i iVar) {
        v vVar = new v();
        this.f5494a = vVar;
        qk.b bVar = new qk.b();
        this.f5495b = bVar;
        v vVar2 = new v();
        vVar2.f5908a = new LinkedList(Arrays.asList(vVar, bVar));
        this.f5496c = vVar2;
        this.f5497d = iVar;
    }

    @Override // ck.g
    public final ck.j a(ek.a aVar, long j8, TimeUnit timeUnit) {
        if (this.f5496c.f5909b) {
            return qk.e.f9242a;
        }
        i iVar = this.f5497d;
        c cVar = new c(2, this, (ck.f) aVar);
        qk.b bVar = this.f5495b;
        iVar.f5510b.getClass();
        q qVar = new q(cVar, bVar);
        bVar.a(qVar);
        ScheduledExecutorService scheduledExecutorService = iVar.f5509a;
        qVar.add(j8 <= 0 ? scheduledExecutorService.submit(qVar) : scheduledExecutorService.schedule(qVar, j8, timeUnit));
        return qVar;
    }

    @Override // ck.g
    public final ck.j b(fk.h hVar) {
        if (this.f5496c.f5909b) {
            return qk.e.f9242a;
        }
        i iVar = this.f5497d;
        c cVar = new c(1, this, hVar);
        v vVar = this.f5494a;
        iVar.f5510b.getClass();
        q qVar = new q(cVar, vVar);
        vVar.a(qVar);
        qVar.add(iVar.f5509a.submit(qVar));
        return qVar;
    }

    @Override // ck.j
    public final boolean isUnsubscribed() {
        return this.f5496c.f5909b;
    }

    @Override // ck.j
    public final void unsubscribe() {
        this.f5496c.unsubscribe();
    }
}
