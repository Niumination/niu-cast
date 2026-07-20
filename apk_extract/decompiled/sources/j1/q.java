package j1;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class q implements v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5996a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ x f5997b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f5998c;

    public /* synthetic */ q(x xVar, int i8, int i9) {
        this.f5996a = i9;
        this.f5997b = xVar;
        this.f5998c = i8;
    }

    @Override // j1.v
    public final void run() {
        switch (this.f5996a) {
            case 0:
                this.f5997b.p(this.f5998c);
                break;
            case 1:
                this.f5997b.s(this.f5998c);
                break;
            default:
                this.f5997b.o(this.f5998c);
                break;
        }
    }
}
