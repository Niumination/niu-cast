package af;

import k3.v8;

/* JADX INFO: loaded from: classes3.dex */
public final class g implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f289a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f290b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f291c;

    public /* synthetic */ g(int i8, int i9, Object obj) {
        this.f289a = i9;
        this.f291c = obj;
        this.f290b = i8;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f289a) {
            case 0:
                h hVar = (h) this.f291c;
                try {
                    ph.b.d();
                    try {
                        ph.a aVar = ph.b.f8887a;
                        aVar.getClass();
                        w3 w3Var = hVar.f301a;
                        int i8 = this.f290b;
                        w3Var.getClass();
                        v8.c("numMessages must be > 0", i8 > 0);
                        if (!w3Var.isClosed()) {
                            w3Var.f657o += (long) i8;
                            w3Var.c();
                            break;
                        }
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
                    hVar.j(th4);
                    return;
                }
            case 1:
                ((e3) this.f291c).f.d(this.f290b);
                return;
            default:
                ((r2.l) this.f291c).h(this.f290b);
                return;
        }
    }
}
