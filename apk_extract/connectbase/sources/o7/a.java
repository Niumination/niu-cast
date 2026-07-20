package o7;

/* JADX INFO: loaded from: classes2.dex */
public class a implements zf.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public b f12106a;

    @Override // zf.a
    public void a(Object obj, float f10) {
        b().a(obj, f10);
    }

    public final b b() {
        if (this.f12106a == null) {
            this.f12106a = new b();
        }
        return this.f12106a;
    }
}
