package af;

/* JADX INFO: loaded from: classes3.dex */
public final class q1 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f525a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ n2 f526b;

    public q1(n2 n2Var, long j8) {
        this.f526b = n2Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f525a) {
            case 0:
                this.f526b.getClass();
                break;
            default:
                ((cf.q) this.f526b.f464a.f10262b).a(ze.q2.f11411n.h("Keepalive failed. The connection is likely gone"));
                break;
        }
    }

    public q1(n2 n2Var, ze.r2 r2Var) {
        this.f526b = n2Var;
    }
}
