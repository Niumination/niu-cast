package af;

/* JADX INFO: loaded from: classes3.dex */
public final class w1 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f643a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ f2 f644b;

    public /* synthetic */ w1(f2 f2Var, int i8) {
        this.f643a = i8;
        this.f644b = f2Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f643a) {
            case 0:
                f2 f2Var = this.f644b;
                f2Var.f272o = null;
                f2Var.f266i.f(ze.h.INFO, "CONNECTING after backoff");
                f2.b(f2Var, ze.q.CONNECTING);
                f2.e(f2Var);
                break;
            case 1:
                if (this.f644b.f276v.f11416a == ze.q.IDLE) {
                    this.f644b.f266i.f(ze.h.INFO, "CONNECTING as requested");
                    f2.b(this.f644b, ze.q.CONNECTING);
                    f2.e(this.f644b);
                }
                break;
            default:
                f2 f2Var2 = this.f644b;
                f2Var2.f266i.f(ze.h.INFO, "Terminated");
                i3 i3Var = (i3) f2Var2.f263d.f447c;
                i3Var.f332m.f367z.remove(f2Var2);
                j3 j3Var = i3Var.f332m;
                ze.o0.b(j3Var.O.f11392c, f2Var2);
                j3.k(j3Var);
                break;
        }
    }
}
