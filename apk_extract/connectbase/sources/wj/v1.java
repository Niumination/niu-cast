package wj;

/* JADX INFO: loaded from: classes2.dex */
public final class v1 extends vj.d.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final u f19392a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final vj.w1<?, ?> f19393b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final vj.v1 f19394c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final vj.e f19395d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final a f19397f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final vj.n[] f19398g;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @gm.j
    @hm.a("lock")
    public s f19400i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f19401j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public e0 f19402k;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Object f19399h = new Object();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final vj.w f19396e = vj.w.o();

    public interface a {
        void a();
    }

    public v1(u uVar, vj.w1<?, ?> w1Var, vj.v1 v1Var, vj.e eVar, a aVar, vj.n[] nVarArr) {
        this.f19392a = uVar;
        this.f19393b = w1Var;
        this.f19394c = v1Var;
        this.f19395d = eVar;
        this.f19397f = aVar;
        this.f19398g = nVarArr;
    }

    @Override // vj.d.a
    public void a(vj.v1 v1Var) {
        c1.h0.h0(!this.f19401j, "apply() or fail() already called");
        c1.h0.F(v1Var, "headers");
        this.f19394c.s(v1Var);
        vj.w wVarC = this.f19396e.c();
        try {
            s sVarK = this.f19392a.k(this.f19393b, this.f19394c, this.f19395d, this.f19398g);
            this.f19396e.q(wVarC);
            c(sVarK);
        } catch (Throwable th2) {
            this.f19396e.q(wVarC);
            throw th2;
        }
    }

    @Override // vj.d.a
    public void b(vj.y2 y2Var) {
        c1.h0.e(!y2Var.r(), "Cannot fail with OK status");
        c1.h0.h0(!this.f19401j, "apply() or fail() already called");
        c(new i0(v0.s(y2Var), this.f19398g));
    }

    public final void c(s sVar) {
        boolean z10;
        c1.h0.h0(!this.f19401j, "already finalized");
        this.f19401j = true;
        synchronized (this.f19399h) {
            try {
                if (this.f19400i == null) {
                    this.f19400i = sVar;
                    z10 = true;
                } else {
                    z10 = false;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        if (z10) {
            this.f19397f.a();
            return;
        }
        c1.h0.h0(this.f19402k != null, "delayedStream is null");
        Runnable runnableG = this.f19402k.G(sVar);
        if (runnableG != null) {
            runnableG.run();
        }
        this.f19397f.a();
    }

    public s d() {
        synchronized (this.f19399h) {
            try {
                s sVar = this.f19400i;
                if (sVar != null) {
                    return sVar;
                }
                e0 e0Var = new e0();
                this.f19402k = e0Var;
                this.f19400i = e0Var;
                return e0Var;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }
}
