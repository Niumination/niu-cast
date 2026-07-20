package t7;

/* JADX INFO: loaded from: classes2.dex */
public class b implements eg.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public c f15519a;

    public static /* synthetic */ void e(ka.a.InterfaceC0239a interfaceC0239a) {
        if (interfaceC0239a != null) {
            interfaceC0239a.onContentChanged();
        }
    }

    @Override // eg.a
    public void a(final ka.a.InterfaceC0239a interfaceC0239a) {
        d().a(new c.b() { // from class: t7.a
            @Override // t7.c.b
            public final void onContentChanged() {
                b.e(interfaceC0239a);
            }
        });
    }

    @Override // eg.a
    public void b(int i10) {
        d().b(i10);
    }

    public final c d() {
        if (this.f15519a == null) {
            this.f15519a = new c();
        }
        return this.f15519a;
    }
}
