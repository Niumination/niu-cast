package af;

import java.util.LinkedHashSet;

/* JADX INFO: loaded from: classes3.dex */
public final class n0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f459a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ e3 f460b;

    public /* synthetic */ n0(e3 e3Var, int i8) {
        this.f459a = i8;
        this.f460b = e3Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f459a) {
            case 0:
                this.f460b.f.b();
                break;
            default:
                e3 e3Var = this.f460b;
                LinkedHashSet linkedHashSet = e3Var.f242n.f281d.A;
                if (linkedHashSet != null) {
                    linkedHashSet.remove(e3Var);
                    f3 f3Var = e3Var.f242n;
                    if (f3Var.f281d.A.isEmpty()) {
                        j3 j3Var = f3Var.f281d;
                        j3Var.Z.l(j3Var.B, false);
                        j3 j3Var2 = f3Var.f281d;
                        j3Var2.A = null;
                        if (j3Var2.F.get()) {
                            f3Var.f281d.E.a(j3.f0);
                        }
                    }
                }
                break;
        }
    }
}
