package af;

import java.util.Collections;

/* JADX INFO: loaded from: classes3.dex */
public final class i5 extends ze.f0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ze.f0 f336a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ j5 f337b;

    public i5(j5 j5Var, ze.f0 f0Var) {
        this.f337b = j5Var;
        this.f336a = f0Var;
    }

    @Override // ze.f0
    public final void g(ze.q2 q2Var) {
        this.f336a.g(q2Var);
        this.f337b.f.execute(new a4.c(this, 3));
    }

    @Override // ze.f0
    public final void k(ze.t1 t1Var) {
        ze.a aVar = j5.f372g;
        ze.b bVar = t1Var.f11438b;
        if (bVar.f11322a.get(aVar) != null) {
            throw new IllegalStateException("RetryingNameResolver can only be used once to wrap a NameResolver");
        }
        Collections.emptyList();
        ze.b bVar2 = ze.b.f11321b;
        n6.a aVarA = bVar.a();
        aVarA.j(aVar, new h5(this.f337b));
        this.f336a.k(new ze.t1(t1Var.f11437a, aVarA.g(), t1Var.f11439c));
    }
}
