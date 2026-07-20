package gb;

import dc.e;
import fc.b;
import ge.c;

/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f6452c = "a";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f6453d = "hideNotificationInMode";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f6454e = "notificationEventEnable";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final String f6455f = "multiUserEnable";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final String f6456g = "gestureSpEnable";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final String f6457h = "fingerprintStartAppEnable";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final String f6458i = "notificationSummaryEnable";

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final String f6459j = "magazineEnable";

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final String f6460k = "showUltraPower";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public c f6461a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public q8.a f6462b;

    public void a(String str, boolean z10, String str2) {
        if (fc.a.g()) {
            l(b.a.f6004x).a(str, z10, str2);
        }
    }

    public void b() {
        l(b.a.f5986f).s();
    }

    public void c(String str, boolean z10) {
        if (fc.a.g()) {
            l(b.a.f6004x).j(str, z10);
        }
    }

    public void d(String str, boolean z10, String str2) {
        if (fc.a.g()) {
            l(b.a.f6004x).l(str, z10, str2);
        }
    }

    public void e(String str, boolean z10) {
        if (fc.a.g()) {
            l(b.a.f6004x).d(str, z10);
        }
    }

    public void f(String str, boolean z10) {
        if (fc.a.g()) {
            l(b.a.f6004x).h(str, z10);
        }
    }

    public void g(int i10) {
        l(b.a.f5982b).v(i10);
    }

    public void h(String str, String str2, boolean z10) {
        if (fc.a.h()) {
            l(b.a.C).q(str, str2, z10);
        }
    }

    public void i(String str, String str2, boolean z10, String str3) {
        if (fc.a.h()) {
            l(b.a.C).k(str, str2, z10, str3);
        }
    }

    public void j() {
        l(b.a.f5993m).e();
    }

    public void k() {
        l(b.a.f5993m).m();
    }

    public ah.a l(String str) {
        if (b.b(str)) {
            c cVar = this.f6461a;
            if (cVar != null) {
                return cVar;
            }
            c cVar2 = new c();
            this.f6461a = cVar2;
            return cVar2;
        }
        e.f(f6452c, "TranAospStatusBarManager");
        q8.a aVar = this.f6462b;
        if (aVar != null) {
            return aVar;
        }
        q8.a aVar2 = new q8.a();
        this.f6462b = aVar2;
        return aVar2;
    }

    public void m(String str) {
        if (fc.a.g()) {
            l(b.a.f6004x).n(str);
        }
    }

    public void n(h9.c cVar) {
        if (fc.a.h()) {
            l(b.a.F).w(cVar);
        }
    }

    public void o(String str, int i10, int i11, String str2) {
        l(b.a.f5987g).r(str, i10, i11, str2);
    }

    public void p(String str, boolean z10) {
        l(b.a.f5987g).u(str, z10);
    }

    public void q() {
        l(b.a.f5988h).t();
    }

    public void r(String str, boolean z10, String str2) {
        if (fc.a.g()) {
            l(b.a.f6004x).p(str, z10, str2);
        }
    }
}
