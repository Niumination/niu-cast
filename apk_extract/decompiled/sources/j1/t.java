package j1;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class t implements v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ x f6006a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f6007b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f6008c;

    public /* synthetic */ t(x xVar, int i8, int i9) {
        this.f6006a = xVar;
        this.f6007b = i8;
        this.f6008c = i9;
    }

    @Override // j1.v
    public final void run() {
        x xVar = this.f6006a;
        j jVar = xVar.f6011a;
        int i8 = this.f6007b;
        int i9 = this.f6008c;
        if (jVar == null) {
            xVar.f6016i.add(new t(xVar, i8, i9));
        } else {
            xVar.f6012b.j(i8, i9 + 0.99f);
        }
    }
}
