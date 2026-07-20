package u8;

/* JADX INFO: loaded from: classes2.dex */
public class a implements eh.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public b f16212a;

    @Override // eh.a
    public boolean a(Object obj, int i10) {
        return b().a(obj, i10);
    }

    public final b b() {
        if (this.f16212a == null) {
            this.f16212a = new b();
        }
        return this.f16212a;
    }
}
