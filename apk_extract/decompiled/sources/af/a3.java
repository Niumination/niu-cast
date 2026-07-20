package af;

import java.util.concurrent.ScheduledExecutorService;
import k3.v8;

/* JADX INFO: loaded from: classes3.dex */
public final class a3 extends ze.f0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public r f140a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ j3 f141b;

    public a3(j3 j3Var) {
        this.f141b = j3Var;
    }

    @Override // ze.f0
    public final ze.i a(qf.c cVar) {
        j3 j3Var = this.f141b;
        j3Var.f357m.d();
        v8.n(!j3Var.H, "Channel is being terminated");
        return new i3(j3Var, cVar);
    }

    @Override // ze.f0
    public final ze.i b() {
        return this.f141b.N;
    }

    @Override // ze.f0
    public final ScheduledExecutorService c() {
        return this.f141b.f351g;
    }

    @Override // ze.f0
    public final ze.v2 d() {
        return this.f141b.f357m;
    }

    @Override // ze.f0
    public final void l() {
        j3 j3Var = this.f141b;
        j3Var.f357m.d();
        j3Var.f357m.execute(new f(this, 5));
    }

    @Override // ze.f0
    public final void m(ze.q qVar, ze.z0 z0Var) {
        j3 j3Var = this.f141b;
        j3Var.f357m.d();
        v8.i(qVar, "newState");
        v8.i(z0Var, "newPicker");
        j3Var.f357m.execute(new m0(this, 2, z0Var, qVar));
    }
}
