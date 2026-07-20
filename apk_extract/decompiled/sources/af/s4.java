package af;

/* JADX INFO: loaded from: classes3.dex */
public final class s4 implements x4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f580a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f581b;

    public /* synthetic */ s4(Object obj, int i8) {
        this.f580a = i8;
        this.f581b = obj;
    }

    @Override // af.x4
    public final void a(e5 e5Var) {
        switch (this.f580a) {
            case 0:
                e5Var.f245a.a((ze.o) this.f581b);
                break;
            case 1:
                e5Var.f245a.m((ze.z) this.f581b);
                break;
            default:
                e5Var.f245a.d((ze.b0) this.f581b);
                break;
        }
    }
}
