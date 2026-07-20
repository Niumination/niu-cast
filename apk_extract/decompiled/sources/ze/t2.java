package ze;

/* JADX INFO: loaded from: classes3.dex */
public final class t2 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ u2 f11440a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ af.m0 f11441b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ long f11442c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ v2 f11443d;

    public t2(v2 v2Var, u2 u2Var, af.m0 m0Var, long j8) {
        this.f11443d = v2Var;
        this.f11440a = u2Var;
        this.f11441b = m0Var;
        this.f11442c = j8;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f11443d.execute(this.f11440a);
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(this.f11441b.toString());
        sb2.append("(scheduled in SynchronizationContext with delay of ");
        return o.d.p(sb2, this.f11442c, ")");
    }
}
