package li;

/* JADX INFO: loaded from: classes3.dex */
public final class v1 extends t1 {
    public final x1 e;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final w1 f7501h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final p f7502i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Object f7503j;

    public v1(x1 x1Var, w1 w1Var, p pVar, Object obj) {
        this.e = x1Var;
        this.f7501h = w1Var;
        this.f7502i = pVar;
        this.f7503j = obj;
    }

    @Override // li.t1
    public final boolean j() {
        return false;
    }

    @Override // li.t1
    public final void k(Throwable th2) {
        p pVar = this.f7502i;
        x1 x1Var = this.e;
        x1Var.getClass();
        p pVarG0 = x1.g0(pVar);
        w1 w1Var = this.f7501h;
        Object obj = this.f7503j;
        if (pVarG0 == null || !x1Var.q0(w1Var, pVarG0, obj)) {
            w1Var.f7508a.c(new qi.j(2), 2);
            p pVarG1 = x1.g0(pVar);
            if (pVarG1 == null || !x1Var.q0(w1Var, pVarG1, obj)) {
                x1Var.v(x1Var.M(w1Var, obj));
            }
        }
    }
}
