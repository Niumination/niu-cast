package v7;

/* JADX INFO: loaded from: classes2.dex */
public class b implements gg.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public c f16671a;

    @Override // gg.a
    public void a(Object obj, int i10) {
        d().c(obj, i10);
    }

    @Override // gg.a
    public void b(Object obj, int i10) {
        d().b(obj, i10);
    }

    @Override // gg.a
    public void c(Object obj, int i10, int i11, int i12) {
        d().a(obj, i10, i11, i12);
    }

    public final c d() {
        if (this.f16671a == null) {
            this.f16671a = new c();
        }
        return this.f16671a;
    }
}
