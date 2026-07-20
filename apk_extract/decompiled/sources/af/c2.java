package af;

import k3.v8;

/* JADX INFO: loaded from: classes3.dex */
public final class c2 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f200a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ d2 f201b;

    public /* synthetic */ c2(d2 d2Var, int i8) {
        this.f200a = i8;
        this.f201b = d2Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f200a) {
            case 0:
                d2 d2Var = this.f201b;
                f2 f2Var = (f2) d2Var.f215c;
                f2Var.f270m = null;
                if (f2Var.f277w == null) {
                    a2 a2Var = f2Var.f275t;
                    a2 a2Var2 = (a2) d2Var.f214b;
                    if (a2Var == a2Var2) {
                        f2Var.u = a2Var2;
                        f2 f2Var2 = (f2) this.f201b.f215c;
                        f2Var2.f275t = null;
                        f2.b(f2Var2, ze.q.READY);
                    }
                } else {
                    v8.n(f2Var.u == null, "Unexpected non-null activeTransport");
                    d2 d2Var2 = this.f201b;
                    ((a2) d2Var2.f214b).c(((f2) d2Var2.f215c).f277w);
                }
                break;
            default:
                d2 d2Var3 = this.f201b;
                ((f2) d2Var3.f215c).f273r.remove((a2) d2Var3.f214b);
                if (((f2) this.f201b.f215c).f276v.f11416a == ze.q.SHUTDOWN && ((f2) this.f201b.f215c).f273r.isEmpty()) {
                    f2 f2Var3 = (f2) this.f201b.f215c;
                    f2Var3.getClass();
                    f2Var3.f267j.execute(new w1(f2Var3, 2));
                    break;
                }
                break;
        }
    }
}
