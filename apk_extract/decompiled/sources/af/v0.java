package af;

/* JADX INFO: loaded from: classes3.dex */
public final class v0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f628a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ s0 f629b;

    public /* synthetic */ v0(s0 s0Var, int i8) {
        this.f628a = i8;
        this.f629b = s0Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f628a) {
            case 0:
                this.f629b.f564c.g();
                break;
            case 1:
                this.f629b.n();
                break;
            case 2:
                this.f629b.f564c.flush();
                break;
            default:
                this.f629b.f564c.k();
                break;
        }
    }
}
