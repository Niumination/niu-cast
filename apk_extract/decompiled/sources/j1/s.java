package j1;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class s implements v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6003a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ x f6004b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ float f6005c;

    public /* synthetic */ s(x xVar, float f, int i8) {
        this.f6003a = i8;
        this.f6004b = xVar;
        this.f6005c = f;
    }

    @Override // j1.v
    public final void run() {
        switch (this.f6003a) {
            case 0:
                x xVar = this.f6004b;
                j jVar = xVar.f6011a;
                float f = this.f6005c;
                if (jVar != null) {
                    float fE = w1.f.e(jVar.f5973l, jVar.f5974m, f);
                    w1.d dVar = xVar.f6012b;
                    dVar.j(dVar.f10641l, fE);
                } else {
                    xVar.f6016i.add(new s(xVar, f, 0));
                }
                break;
            case 1:
                x xVar2 = this.f6004b;
                j jVar2 = xVar2.f6011a;
                float f4 = this.f6005c;
                if (jVar2 != null) {
                    xVar2.s((int) w1.f.e(jVar2.f5973l, jVar2.f5974m, f4));
                } else {
                    xVar2.f6016i.add(new s(xVar2, f4, 1));
                }
                break;
            default:
                this.f6004b.u(this.f6005c);
                break;
        }
    }
}
