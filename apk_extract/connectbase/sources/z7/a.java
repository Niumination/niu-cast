package z7;

import android.content.Context;
import android.net.ConnectivityManager;

/* JADX INFO: loaded from: classes2.dex */
public class a implements kg.a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f21850d = "TranAospConnectivityManager";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ConnectivityManager f21851a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public b f21852b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Context f21853c;

    /* JADX INFO: renamed from: z7.a$a, reason: collision with other inner class name */
    public class C0603a implements b.InterfaceC0604b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ qa.a.InterfaceC0341a f21854a;

        public C0603a(qa.a.InterfaceC0341a interfaceC0341a) {
            this.f21854a = interfaceC0341a;
        }

        @Override // z7.b.InterfaceC0604b
        public void a() {
            qa.a.InterfaceC0341a interfaceC0341a = this.f21854a;
            if (interfaceC0341a != null) {
                interfaceC0341a.a();
            }
        }

        @Override // z7.b.InterfaceC0604b
        public void b() {
            qa.a.InterfaceC0341a interfaceC0341a = this.f21854a;
            if (interfaceC0341a != null) {
                interfaceC0341a.b();
            }
        }
    }

    public a() {
        Context contextA = bc.a.a();
        this.f21853c = contextA;
        if (this.f21851a == null) {
            this.f21851a = (ConnectivityManager) contextA.getSystemService("connectivity");
        }
        this.f21852b = new b(this.f21853c);
    }

    @Override // kg.a
    public void f(int i10) {
        cc.a.j(cc.a.g(this.f21851a.getClass(), "stopTethering", Integer.TYPE), this.f21851a, Integer.valueOf(i10));
    }

    @Override // kg.a
    public String[] g() {
        Object objJ = cc.a.j(cc.a.g(this.f21851a.getClass(), "getTetherableWifiRegexs", new Class[0]), this.f21851a, new Object[0]);
        if (objJ instanceof String[]) {
            return (String[]) objJ;
        }
        return null;
    }

    @Override // kg.a
    public void h(int i10, boolean z10, qa.a.InterfaceC0341a interfaceC0341a) {
        this.f21852b.a(i10, z10, new C0603a(interfaceC0341a));
    }

    @Override // kg.a
    public void i(boolean z10) {
        cc.a.j(cc.a.g(this.f21851a.getClass(), "setAirplaneMode", Boolean.TYPE), this.f21851a, Boolean.valueOf(z10));
    }

    @Override // kg.a
    public void j(boolean z10) {
        cc.a.j(cc.a.g(this.f21851a.getClass(), "setUsbTethering", Boolean.TYPE), this.f21851a, Boolean.valueOf(z10));
    }

    @Override // kg.a
    public void k(int i10, boolean z10, qa.a.InterfaceC0341a interfaceC0341a) {
        h(i10, z10, interfaceC0341a);
    }

    @Override // kg.a
    public boolean l(int i10, int i11) {
        Class<?> cls = this.f21851a.getClass();
        Class cls2 = Integer.TYPE;
        return ((Boolean) cc.a.j(cc.a.g(cls, "requestRouteToHost", cls2, cls2), this.f21851a, Integer.valueOf(i10), Integer.valueOf(i11))).booleanValue();
    }

    @Override // kg.a
    public boolean m() {
        Object objJ = cc.a.j(cc.a.g(this.f21851a.getClass(), "isTetheringSupported", new Class[0]), this.f21851a, new Object[0]);
        if (objJ instanceof Boolean) {
            return ((Boolean) objJ).booleanValue();
        }
        return false;
    }

    @Override // kg.a
    public String[] n() {
        Object objJ = cc.a.j(cc.a.g(this.f21851a.getClass(), "getTetherableUsbRegexs", new Class[0]), this.f21851a, new Object[0]);
        if (objJ instanceof String[]) {
            return (String[]) objJ;
        }
        return null;
    }

    @Override // kg.a
    public boolean o(int i10) {
        return ((Boolean) cc.a.j(cc.a.g(this.f21851a.getClass(), "isNetworkSupported", Integer.TYPE), this.f21851a, Integer.valueOf(i10))).booleanValue();
    }
}
