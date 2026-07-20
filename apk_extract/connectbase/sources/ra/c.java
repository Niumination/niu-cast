package ra;

import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.os.Parcel;
import dc.e;

/* JADX INFO: loaded from: classes2.dex */
public class c {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f14354c = "c";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f14355d = "android.net.wifi.WIFI_AP_STATE_CHANGED";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f14356e = "wifi_state";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final String f14357f = "wifi_bundle_key";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f14358g = 13;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public rd.a f14359a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public a8.d f14360b;

    public interface a {
        void onFailure(int i10);

        void onSuccess();
    }

    public interface b {
        void a(int i10);

        void b(WifiManager.LocalOnlyHotspotReservation localOnlyHotspotReservation);

        void c();
    }

    /* JADX INFO: renamed from: ra.c$c, reason: collision with other inner class name */
    public interface InterfaceC0346c {
        void a(int i10, int i11);
    }

    public void a(ra.b bVar, a aVar) {
        h(fc.b.a.f5984d).C(bVar, aVar);
    }

    public void b(String str, a aVar) {
        h(fc.b.a.f5984d).v(str, aVar);
    }

    public void c(int i10, a aVar) {
        h(fc.b.a.f5984d).y(i10, aVar);
    }

    public String[] d() {
        return h(fc.b.a.f5984d).z();
    }

    public int e(WifiConfiguration wifiConfiguration) {
        if (wifiConfiguration != null) {
            return h(fc.b.a.f5991k).w(wifiConfiguration);
        }
        throw new IllegalArgumentException("wifiConfig is null.");
    }

    public Bundle f() {
        return h(fc.b.a.f5991k).q();
    }

    @Deprecated
    public Bundle g() {
        return h(fc.b.a.f5988h).E();
    }

    public lg.a h(String str) {
        if (fc.b.b(str)) {
            e.a(f14354c, "TranThubWifiManager start");
            rd.a aVar = this.f14359a;
            if (aVar != null) {
                return aVar;
            }
            rd.a aVar2 = new rd.a();
            this.f14359a = aVar2;
            return aVar2;
        }
        e.a(f14354c, "TranAospWifiManager start");
        a8.d dVar = this.f14360b;
        if (dVar != null) {
            return dVar;
        }
        a8.d dVar2 = new a8.d();
        this.f14360b = dVar2;
        return dVar2;
    }

    public ra.a i() {
        return h(fc.b.a.f5984d).a();
    }

    public ra.b j() {
        return h(fc.b.a.f5984d).n();
    }

    public int k() {
        return h(fc.b.a.f5984d).s();
    }

    public WifiConfiguration l(Parcel parcel) {
        return h(fc.b.a.f5987g).t(parcel);
    }

    public boolean m() {
        return h(fc.b.a.f5988h).l();
    }

    public void n(InterfaceC0346c interfaceC0346c) {
        if (interfaceC0346c == null) {
            throw new IllegalArgumentException("callback cannot be null");
        }
        h(fc.b.a.f5984d).A(interfaceC0346c);
    }

    public void o(ra.b bVar, a aVar) {
        h(fc.b.a.f5984d).u(bVar, aVar);
    }

    @yb.a(level = 1)
    public void p(String str) {
        h(fc.b.a.f5988h).o(str);
    }

    public void q(WifiConfiguration wifiConfiguration, int i10) {
        if (wifiConfiguration == null) {
            throw new IllegalArgumentException("wifiConfig is null.");
        }
        h(fc.b.a.f5991k).p(wifiConfiguration, i10);
    }

    public boolean r(ra.b bVar, String str, String str2, String str3) {
        return h(fc.b.a.f5984d).m(bVar, str, str2, str3);
    }

    public boolean s(ra.b bVar) {
        return h(fc.b.a.f5984d).r(bVar);
    }

    public void t(ra.a aVar, b bVar) {
        h(fc.b.a.f5988h).B(aVar, bVar);
    }

    public boolean u(ra.b bVar) {
        return h(fc.b.a.f5984d).x(bVar);
    }

    public boolean v() {
        return h(fc.b.a.f5984d).D();
    }
}
