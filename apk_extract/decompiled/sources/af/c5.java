package af;

/* JADX INFO: loaded from: classes3.dex */
public final class c5 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f204a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ e5 f205b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ l6 f206c;

    public /* synthetic */ c5(l6 l6Var, e5 e5Var, int i8) {
        this.f204a = i8;
        this.f206c = l6Var;
        this.f205b = e5Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        l6 l6Var = this.f206c;
        switch (this.f204a) {
            case 0:
                ((x2) l6Var.f447c).f684b.execute(new f(this, 9));
                break;
            default:
                x2 x2Var = (x2) l6Var.f447c;
                ze.k1 k1Var = x2.E;
                x2Var.q(this.f205b);
                break;
        }
    }
}
