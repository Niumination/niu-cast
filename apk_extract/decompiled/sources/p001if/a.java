package p001if;

import java.util.concurrent.ScheduledExecutorService;
import k3.t8;
import qf.c;
import ze.f0;
import ze.i;
import ze.v2;

/* JADX INFO: loaded from: classes3.dex */
public abstract class a extends f0 {
    @Override // ze.f0
    public i a(c cVar) {
        return n().a(cVar);
    }

    @Override // ze.f0
    public final i b() {
        return n().b();
    }

    @Override // ze.f0
    public final ScheduledExecutorService c() {
        return n().c();
    }

    @Override // ze.f0
    public final v2 d() {
        return n().d();
    }

    @Override // ze.f0
    public final void l() {
        n().l();
    }

    public abstract f0 n();

    public final String toString() {
        o6.a aVarA = t8.a(this);
        aVarA.d(n(), "delegate");
        return aVarA.toString();
    }
}
