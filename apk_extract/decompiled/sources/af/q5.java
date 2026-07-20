package af;

/* JADX INFO: loaded from: classes3.dex */
public final class q5 extends l0 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f536c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ r5 f537d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q5(r5 r5Var, int i8) {
        super((ze.s) r5Var.f559d, 0);
        this.f536c = i8;
        switch (i8) {
            case 1:
                this.f537d = r5Var;
                super((ze.s) r5Var.f559d, 0);
                break;
            default:
                this.f537d = r5Var;
                break;
        }
    }

    @Override // af.l0
    public final void b() {
        switch (this.f536c) {
            case 0:
                r5 r5Var = this.f537d;
                try {
                    ph.b.d();
                    try {
                        r5Var.getClass();
                        ph.b.a();
                        ph.a aVar = ph.b.f8887a;
                        aVar.getClass();
                        z5 z5Var = (z5) r5Var.f560h;
                        if (z5Var == null) {
                            throw new IllegalStateException("listener unset");
                        }
                        z5Var.n();
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
                } catch (Throwable th4) {
                    r5.h(r5Var, th4);
                    throw th4;
                }
            default:
                r5 r5Var2 = this.f537d;
                try {
                    ph.b.d();
                    try {
                        r5Var2.getClass();
                        ph.b.a();
                        ph.a aVar2 = ph.b.f8887a;
                        aVar2.getClass();
                        z5 z5Var2 = (z5) r5Var2.f560h;
                        if (z5Var2 == null) {
                            throw new IllegalStateException("listener unset");
                        }
                        z5Var2.q();
                        aVar2.getClass();
                        return;
                    } catch (Throwable th5) {
                        try {
                            ph.b.f8887a.getClass();
                            break;
                        } catch (Throwable th6) {
                            th5.addSuppressed(th6);
                        }
                        throw th5;
                    }
                } catch (Throwable th7) {
                    r5.h(r5Var2, th7);
                    throw th7;
                }
        }
    }
}
