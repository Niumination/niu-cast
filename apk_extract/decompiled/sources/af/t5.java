package af;

import k3.v8;

/* JADX INFO: loaded from: classes3.dex */
public final class t5 extends l0 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ ze.s f597c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ m4.m f598d;
    public final /* synthetic */ String e;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final /* synthetic */ ze.p1 f599h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final /* synthetic */ cf.b0 f600i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final /* synthetic */ r5 f601j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final /* synthetic */ qf.c f602k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public t5(qf.c cVar, ze.s sVar, m4.m mVar, String str, ze.p1 p1Var, cf.b0 b0Var, r5 r5Var) {
        super(sVar, 0);
        this.f602k = cVar;
        this.f597c = sVar;
        this.f598d = mVar;
        this.e = str;
        this.f599h = p1Var;
        this.f600i = b0Var;
        this.f601j = r5Var;
    }

    @Override // af.l0
    public final void b() {
        ph.b.d();
        try {
            ph.a aVar = ph.b.f8887a;
            aVar.getClass();
            ph.b.a();
            c();
            aVar.getClass();
        } catch (Throwable th2) {
            try {
                ph.b.f8887a.getClass();
            } catch (Throwable th3) {
                th2.addSuppressed(th3);
            }
            throw th2;
        }
    }

    public final void c() {
        Object obj;
        k2 k2Var = w5.u;
        if (this.f598d.f7931a instanceof m4.a) {
            return;
        }
        try {
            qf.c cVar = this.f602k;
            String str = this.e;
            m4.m mVar = this.f598d;
            v8.l("Future was expected to be done: %s", mVar.isDone(), mVar);
            boolean z2 = false;
            while (true) {
                try {
                    obj = mVar.get();
                    break;
                } catch (InterruptedException unused) {
                    z2 = true;
                } catch (Throwable th2) {
                    if (z2) {
                        Thread.currentThread().interrupt();
                    }
                    throw th2;
                }
            }
            if (z2) {
                Thread.currentThread().interrupt();
            }
            v5 v5Var = (v5) obj;
            cVar.getClass();
            ze.d2 d2Var = v5Var.f637b;
            p5 p5Var = v5Var.f636a;
            ze.i iVarE = d2Var.e(p5Var);
            if (iVarE == null) {
                throw new NullPointerException(h0.a.i("startCall() returned a null listener for method ", str));
            }
            this.f601j.y(new u6.a(p5Var, iVarE, p5Var.f513d));
            this.f597c.a(new tj.x(this), m4.k.INSTANCE);
        } catch (Throwable th3) {
            try {
                this.f600i.x(ze.q2.d(th3), new ze.p1());
                this.f597c.t(null);
                throw new IllegalStateException(th3);
            } catch (Throwable th4) {
                this.f601j.y(k2Var);
                throw th4;
            }
        }
    }
}
