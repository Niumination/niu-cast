package af;

/* JADX INFO: loaded from: classes3.dex */
public final class u4 implements x4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f615a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f616b;

    public /* synthetic */ u4(int i8, int i9) {
        this.f615a = i9;
        this.f616b = i8;
    }

    @Override // af.x4
    public final void a(e5 e5Var) {
        switch (this.f615a) {
            case 0:
                e5Var.f245a.f(this.f616b);
                break;
            case 1:
                e5Var.f245a.b(this.f616b);
                break;
            default:
                e5Var.f245a.e(this.f616b);
                break;
        }
    }
}
