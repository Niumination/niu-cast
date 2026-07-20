package af;

import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
public final class u2 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f609a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ j3 f610b;

    public /* synthetic */ u2(j3 j3Var, int i8) {
        this.f609a = i8;
        this.f610b = j3Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f609a) {
            case 0:
                this.f610b.l(true);
                break;
            case 1:
                j3 j3Var = this.f610b;
                j3Var.N.f(ze.h.INFO, "Entering SHUTDOWN state");
                j3Var.f360r.b(ze.q.SHUTDOWN);
                break;
            case 2:
                j3 j3Var2 = this.f610b;
                if (!j3Var2.G) {
                    j3Var2.G = true;
                    j3.j(j3Var2);
                    break;
                }
                break;
            default:
                j3 j3Var3 = this.f610b;
                if (j3Var3.f364w != null) {
                    j3Var3.p(true);
                    t0 t0Var = j3Var3.D;
                    t0Var.h(null);
                    j3Var3.N.f(ze.h.INFO, "Entering IDLE state");
                    j3Var3.f360r.b(ze.q.IDLE);
                    Object[] objArr = {j3Var3.B, t0Var};
                    v1 v1Var = j3Var3.Z;
                    v1Var.getClass();
                    for (int i8 = 0; i8 < 2; i8++) {
                        if (((Set) v1Var.f574b).contains(objArr[i8])) {
                            j3Var3.m();
                        }
                        break;
                    }
                    break;
                }
                break;
        }
    }
}
