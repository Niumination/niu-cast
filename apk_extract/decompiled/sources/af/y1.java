package af;

/* JADX INFO: loaded from: classes3.dex */
public final class y1 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a2 f709a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ boolean f710b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ f2 f711c;

    public y1(f2 f2Var, a2 a2Var, boolean z2) {
        this.f711c = f2Var;
        this.f709a = a2Var;
        this.f710b = z2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f711c.f274s.l(this.f709a, this.f710b);
    }
}
