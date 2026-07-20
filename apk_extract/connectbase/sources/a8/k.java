package a8;

import android.content.Context;
import android.net.InetAddresses;
import android.net.IpConfiguration;
import android.net.LinkAddress;
import android.net.StaticIpConfiguration;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiManager;
import android.os.Handler;
import android.os.HandlerExecutor;
import android.os.HandlerThread;
import android.text.TextUtils;
import java.net.Inet4Address;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class k {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f163c = "k";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f164d = 4;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f165a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public WifiManager f166b;

    public class a implements WifiManager.ActionListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f167a;

        public a(b bVar) {
            this.f167a = bVar;
        }

        public void a(int i10) {
            b bVar = this.f167a;
            if (bVar != null) {
                bVar.onFailure(i10);
            }
        }

        public void b() {
            b bVar = this.f167a;
            if (bVar != null) {
                bVar.onSuccess();
            }
        }
    }

    public interface b {
        void onFailure(int i10);

        void onSuccess();
    }

    public class c implements WifiManager.ActionListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public b f169a;

        public c(b bVar) {
            this.f169a = bVar;
        }

        public void a(int i10) {
            b bVar = this.f169a;
            if (bVar != null) {
                bVar.onFailure(i10);
            }
        }

        public void b() {
            b bVar = this.f169a;
            if (bVar != null) {
                bVar.onSuccess();
            }
        }
    }

    public class d implements WifiManager.SoftApCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public e f171a;

        public d(e eVar) {
            this.f171a = eVar;
        }

        public void a(int i10, int i11) {
            e eVar = this.f171a;
            if (eVar != null) {
                eVar.a(i10, i11);
            }
        }
    }

    public interface e {
        void a(int i10, int i11);
    }

    public k(Context context) {
        this.f165a = context;
        this.f166b = (WifiManager) context.getSystemService("wifi");
    }

    public static Inet4Address e(String str) {
        try {
            return (Inet4Address) InetAddresses.parseNumericAddress(str);
        } catch (ClassCastException | IllegalArgumentException unused) {
            dc.e.n(f163c, "getIPv4Address error");
            return null;
        }
    }

    @b.a({"MissingPermission"})
    public void a(a8.a aVar, b bVar) {
        this.f166b.connect(d(aVar), bVar != null ? new c(bVar) : null);
    }

    @b.a({"MissingPermission"})
    public void b(String str, b bVar) {
        List<WifiConfiguration> configuredNetworks = this.f166b.getConfiguredNetworks();
        WifiConfiguration wifiConfiguration = null;
        for (int i10 = 0; i10 < configuredNetworks.size(); i10++) {
            if (TextUtils.equals(str, configuredNetworks.get(i10).SSID)) {
                wifiConfiguration = configuredNetworks.get(i10);
            }
        }
        if (wifiConfiguration == null) {
            dc.e.c(f163c, "can not get ssid " + str);
            return;
        }
        a aVar = new a(bVar);
        if (bVar != null) {
            this.f166b.connect(wifiConfiguration, aVar);
        } else {
            this.f166b.connect(wifiConfiguration, null);
        }
    }

    @b.a({"MissingPermission"})
    public void c(int i10, b bVar) {
        this.f166b.forget(i10, bVar != null ? new c(bVar) : null);
    }

    public final WifiConfiguration d(a8.a aVar) {
        if (aVar == null) {
            return null;
        }
        WifiConfiguration wifiConfiguration = new WifiConfiguration();
        wifiConfiguration.SSID = aVar.f144a;
        wifiConfiguration.hiddenSSID = aVar.f145b;
        wifiConfiguration.networkId = aVar.f146c;
        wifiConfiguration.allowedKeyManagement.set(1);
        wifiConfiguration.preSharedKey = aVar.f147d;
        return wifiConfiguration;
    }

    @b.a({"MissingPermission"})
    public void f(e eVar) {
        HandlerThread handlerThread = new HandlerThread("registerSoftApCallback");
        handlerThread.start();
        Handler handler = new Handler(handlerThread.getLooper());
        this.f166b.registerSoftApCallback(new HandlerExecutor(handler), new d(eVar));
    }

    @b.a({"MissingPermission"})
    public void g(a8.a aVar, b bVar) {
        this.f166b.save(d(aVar), bVar != null ? new c(bVar) : null);
    }

    @b.a({"NewApi"})
    public boolean h(a8.a aVar, String str, String str2, String str3) {
        WifiConfiguration wifiConfigurationD = d(aVar);
        ArrayList arrayList = new ArrayList();
        arrayList.add(e(str3));
        StaticIpConfiguration staticIpConfigurationBuild = j.a().setIpAddress(new LinkAddress(e(str), 24)).setGateway(e(str2)).setDnsServers(arrayList).build();
        IpConfiguration ipConfiguration = new IpConfiguration();
        ipConfiguration.setIpAssignment(IpConfiguration.IpAssignment.STATIC);
        ipConfiguration.setProxySettings(IpConfiguration.ProxySettings.NONE);
        ipConfiguration.setStaticIpConfiguration(staticIpConfigurationBuild);
        wifiConfigurationD.setIpConfiguration(ipConfiguration);
        return false;
    }
}
