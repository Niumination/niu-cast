package af;

/* JADX INFO: loaded from: classes3.dex */
public final class u0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f604a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f605b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ s0 f606c;

    public /* synthetic */ u0(s0 s0Var, int i8, int i9) {
        this.f604a = i9;
        this.f606c = s0Var;
        this.f605b = i8;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f604a) {
            case 0:
                this.f606c.f564c.e(this.f605b);
                break;
            case 1:
                this.f606c.f564c.f(this.f605b);
                break;
            default:
                this.f606c.f564c.b(this.f605b);
                break;
        }
    }
}
