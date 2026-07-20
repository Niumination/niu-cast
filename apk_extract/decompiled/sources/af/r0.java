package af;

import k3.v8;

/* JADX INFO: loaded from: classes3.dex */
public final class r0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f542a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ tj.x f543b;

    public /* synthetic */ r0(tj.x xVar, int i8) {
        this.f542a = i8;
        this.f543b = xVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f542a) {
            case 0:
                this.f543b.q(true);
                break;
            case 1:
                this.f543b.q(false);
                break;
            default:
                j3 j3Var = (j3) this.f543b.f10264a;
                v8.n(j3Var.F.get(), "Channel must have been shut down");
                j3Var.H = true;
                j3Var.p(false);
                j3.j(j3Var);
                j3.k(j3Var);
                break;
        }
    }
}
