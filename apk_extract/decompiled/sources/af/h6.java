package af;

import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes3.dex */
public final class h6 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final h6 f311c = new h6(new ze.n[0]);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ze.n[] f312a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AtomicBoolean f313b = new AtomicBoolean(false);

    public h6(ze.n[] nVarArr) {
        this.f312a = nVarArr;
    }

    public final void a(long j8) {
        for (ze.n nVar : this.f312a) {
            nVar.g(j8);
        }
    }

    public final void b(ze.q2 q2Var) {
        if (this.f313b.compareAndSet(false, true)) {
            for (ze.n nVar : this.f312a) {
                nVar.m(q2Var);
            }
        }
    }
}
