package af;

import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes3.dex */
public final class u5 extends l0 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ ze.s f617c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ String f618d;
    public final /* synthetic */ cf.b0 e;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final /* synthetic */ r5 f619h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final /* synthetic */ m4.m f620i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final /* synthetic */ h6 f621j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final /* synthetic */ ze.p1 f622k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final /* synthetic */ Executor f623l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final /* synthetic */ qf.c f624m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public u5(qf.c cVar, ze.s sVar, String str, cf.b0 b0Var, r5 r5Var, m4.m mVar, h6 h6Var, ze.p1 p1Var, Executor executor) {
        super(sVar, 0);
        this.f624m = cVar;
        this.f617c = sVar;
        this.f618d = str;
        this.e = b0Var;
        this.f619h = r5Var;
        this.f620i = mVar;
        this.f621j = h6Var;
        this.f622k = p1Var;
        this.f623l = executor;
    }

    @Override // af.l0
    public final void b() {
        ph.b.d();
        try {
            ph.b.a();
            ph.a aVar = ph.b.f8887a;
            aVar.getClass();
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
        ze.s sVar = this.f617c;
        r5 r5Var = this.f619h;
        String str = this.f618d;
        m4.m mVar = this.f620i;
        qf.c cVar = this.f624m;
        cf.b0 b0Var = this.e;
        try {
            ze.g2 g2Var = (ze.g2) ((w5) cVar.f9049d).e.f608b.get(str);
            if (g2Var == null) {
                ((w5) cVar.f9049d).f.getClass();
                g2Var = null;
            }
            if (g2Var == null) {
                ze.q2 q2VarH = ze.q2.f11409l.h("Method not found: " + str);
                r5Var.y(w5.u);
                b0Var.x(q2VarH, new ze.p1());
                sVar.t(null);
                mVar.cancel(false);
                return;
            }
            ze.g2 g2VarT = qf.c.t(cVar, b0Var, g2Var, this.f621j);
            ze.p1 p1Var = this.f622k;
            w5 w5Var = (w5) cVar.f9049d;
            p5 p5Var = new p5(b0Var, g2VarT.f11353a, p1Var, sVar, w5Var.p, w5Var.f675r);
            ((w5) cVar.f9049d).getClass();
            v5 v5Var = new v5();
            v5Var.f636a = p5Var;
            v5Var.f637b = g2VarT.f11354b;
            if (m4.j.f7929h.b(mVar, null, v5Var)) {
                m4.j.c(mVar, false);
            }
        } catch (Throwable th2) {
            r5Var.y(w5.u);
            b0Var.x(ze.q2.d(th2), new ze.p1());
            sVar.t(null);
            mVar.cancel(false);
            throw th2;
        }
    }
}
