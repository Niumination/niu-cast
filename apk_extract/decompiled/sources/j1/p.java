package j1;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class p implements v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5993a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ x f5994b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f5995c;

    public /* synthetic */ p(x xVar, String str, int i8) {
        this.f5993a = i8;
        this.f5994b = xVar;
        this.f5995c = str;
    }

    @Override // j1.v
    public final void run() {
        switch (this.f5993a) {
            case 0:
                this.f5994b.r(this.f5995c);
                break;
            case 1:
                this.f5994b.q(this.f5995c);
                break;
            default:
                this.f5994b.t(this.f5995c);
                break;
        }
    }
}
