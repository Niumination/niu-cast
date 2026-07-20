package af;

/* JADX INFO: loaded from: classes3.dex */
public final class x extends l0 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f677c = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Object f678d;
    public final /* synthetic */ Object e;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final /* synthetic */ Object f679h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public x(a0 a0Var, ze.f0 f0Var, String str) {
        super(a0Var.f, 0);
        this.f679h = a0Var;
        this.f678d = f0Var;
        this.e = str;
    }

    @Override // af.l0
    public final void b() {
        switch (this.f677c) {
            case 0:
                ze.q2 q2VarH = ze.q2.f11410m.h("Unable to find compressor by name " + ((String) this.e));
                ze.p1 p1Var = new ze.p1();
                ((a0) this.f679h).getClass();
                ((ze.f0) this.f678d).f(q2VarH, p1Var);
                return;
            default:
                ph.b.d();
                try {
                    ph.c cVar = ((a0) ((qf.c) this.f679h).f9049d).f125b;
                    ph.b.a();
                    ph.a aVar = ph.b.f8887a;
                    aVar.getClass();
                    c();
                    aVar.getClass();
                    return;
                } catch (Throwable th2) {
                    try {
                        ph.b.f8887a.getClass();
                        break;
                    } catch (Throwable th3) {
                        th2.addSuppressed(th3);
                    }
                    throw th2;
                }
        }
    }

    public void c() {
        ze.q2 q2Var = (ze.q2) this.f678d;
        ze.p1 p1Var = (ze.p1) this.e;
        ze.q2 q2Var2 = (ze.q2) ((qf.c) this.f679h).f9048c;
        if (q2Var2 != null) {
            p1Var = new ze.p1();
            q2Var = q2Var2;
        }
        ((a0) ((qf.c) this.f679h).f9049d).f132k = true;
        try {
            qf.c cVar = (qf.c) this.f679h;
            a0 a0Var = (a0) cVar.f9049d;
            ze.f0 f0Var = (ze.f0) cVar.f9047b;
            a0Var.getClass();
            f0Var.f(q2Var, p1Var);
        } finally {
            ((a0) ((qf.c) this.f679h).f9049d).h();
            ((a0) ((qf.c) this.f679h).f9049d).e.b(q2Var.e());
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public x(qf.c cVar, ze.q2 q2Var, ze.p1 p1Var) {
        super(((a0) cVar.f9049d).f, 0);
        this.f679h = cVar;
        this.f678d = q2Var;
        this.e = p1Var;
    }
}
