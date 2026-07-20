package cr;

import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes3.dex */
public final class t extends b0 {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public b0 f3472e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f3473f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f3474g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f3475h;

    public void l() {
        this.f3472e.i(this.f3475h, TimeUnit.NANOSECONDS);
        if (this.f3473f) {
            this.f3472e.e(this.f3474g);
        } else {
            this.f3472e.a();
        }
    }

    public void m(b0 b0Var) {
        this.f3472e = b0Var;
        boolean zF = b0Var.f();
        this.f3473f = zF;
        this.f3474g = zF ? b0Var.d() : -1L;
        long j10 = b0Var.j();
        this.f3475h = j10;
        b0Var.i(b0.g(j10, this.f3400c), TimeUnit.NANOSECONDS);
        if (this.f3473f && this.f3398a) {
            b0Var.e(Math.min(d(), this.f3474g));
        } else if (this.f3398a) {
            b0Var.e(d());
        }
    }
}
