package mb;

import dc.e;

/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f10625c = "a";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f10626d = "aod_is_show";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f10627e = "select_aod_livewallpaper_key";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public me.a f10628a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public w8.a f10629b;

    /* JADX INFO: renamed from: mb.a$a, reason: collision with other inner class name */
    public interface InterfaceC0277a {
        void a(int i10);
    }

    public interface b {
        void a(int i10);
    }

    public gh.a a(String str) {
        if (fc.b.b(str)) {
            e.f(f10625c, "TranThubDreamAnimationManager");
            me.a aVar = this.f10628a;
            if (aVar != null) {
                return aVar;
            }
            me.a aVar2 = new me.a();
            this.f10628a = aVar2;
            return aVar2;
        }
        e.f(f10625c, "TranAospDreamAnimationManager");
        w8.a aVar3 = this.f10629b;
        if (aVar3 != null) {
            return aVar3;
        }
        w8.a aVar4 = new w8.a();
        this.f10629b = aVar4;
        return aVar4;
    }

    public boolean b() {
        return a(fc.b.a.f5989i).j();
    }

    public void c(int i10) throws ac.a {
        a(fc.b.a.f6001u).a(i10);
    }

    public void d(InterfaceC0277a interfaceC0277a) throws ac.a {
        a(fc.b.a.f6001u).c(interfaceC0277a);
    }

    public void e(InterfaceC0277a interfaceC0277a, int i10) throws ac.a {
        a(fc.b.a.f6001u).h(interfaceC0277a, i10);
    }

    public void f(b bVar) throws ac.a {
        a(fc.b.a.f5982b).d(bVar);
    }

    public void g(b bVar, int i10) throws ac.a {
        a(fc.b.a.f5982b).f(bVar, i10);
    }

    public void h(InterfaceC0277a interfaceC0277a) throws ac.a {
        a(fc.b.a.f6001u).b(interfaceC0277a);
    }

    public void i(InterfaceC0277a interfaceC0277a, int i10) throws ac.a {
        a(fc.b.a.f6001u).i(interfaceC0277a, i10);
    }

    @yb.a(level = 1)
    public void j(b bVar) throws ac.a {
        a(fc.b.a.f5982b).g(bVar);
    }

    @yb.a(level = 1)
    public void k(b bVar, int i10) throws ac.a {
        a(fc.b.a.f5982b).e(bVar, i10);
    }
}
