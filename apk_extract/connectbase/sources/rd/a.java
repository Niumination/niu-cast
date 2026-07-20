package rd;

import android.net.wifi.SoftApConfiguration;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.transsion.hubsdk.TranServiceManager;
import com.transsion.hubsdk.net.wifi.ITranActionListener;
import com.transsion.hubsdk.net.wifi.ITranLocalOnlyHotspotCallback;
import com.transsion.hubsdk.net.wifi.ITranSoftApCallback;
import com.transsion.hubsdk.net.wifi.ITranWifiManager;
import com.transsion.hubsdk.net.wifi.TranSoftApConfiguration;
import com.transsion.hubsdk.net.wifi.TranWifiConfiguration;
import dc.e;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes2.dex */
public class a implements lg.a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f14447c = "a";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ITranWifiManager f14448a = ITranWifiManager.Stub.asInterface(TranServiceManager.getServiceIBinder("wifi_manager"));

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public C0350a f14449b;

    /* JADX INFO: renamed from: rd.a$a, reason: collision with other inner class name */
    public class C0350a extends ITranLocalOnlyHotspotCallback.Stub {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public ra.c.b f14450a;

        public C0350a(ra.c.b bVar) {
            this.f14450a = bVar;
        }

        public void a(int i10) {
            this.f14450a.a(i10);
        }

        public void b(TranSoftApConfiguration tranSoftApConfiguration) {
            ra.a aVar = new ra.a(tranSoftApConfiguration.getSsid(), tranSoftApConfiguration.getBssid(), tranSoftApConfiguration.getPassphrase(), tranSoftApConfiguration.isHiddenSsid(), tranSoftApConfiguration.getBand(), tranSoftApConfiguration.getChannel(), tranSoftApConfiguration.getSecurityType(), tranSoftApConfiguration.getMaxNumberOfClients(), tranSoftApConfiguration.isAutoShutdownEnabled(), tranSoftApConfiguration.getShutdownTimeoutMillis(), tranSoftApConfiguration.isClientControlByUserEnabled(), tranSoftApConfiguration.getBlockedClientList(), tranSoftApConfiguration.getAllowedClientList());
            WifiManager wifiManager = (WifiManager) bc.a.a().getSystemService("wifi");
            WifiManager.LocalOnlyHotspotReservation localOnlyHotspotReservation = null;
            try {
                Class clsA = cc.a.a("android.net.wifi.SoftApConfiguration$Builder");
                Object objNewInstance = clsA.newInstance();
                if (Build.VERSION.SDK_INT < 33) {
                    Field declaredField = clsA.getDeclaredField("mSsid");
                    declaredField.setAccessible(true);
                    declaredField.set(objNewInstance, aVar.w());
                } else {
                    Method declaredMethod = Class.forName("android.net.wifi.WifiSsid").getDeclaredMethod("fromBytes", byte[].class);
                    declaredMethod.setAccessible(true);
                    Object objInvoke = declaredMethod.invoke(null, aVar.w().getBytes());
                    Field declaredField2 = clsA.getDeclaredField("mWifiSsid");
                    declaredField2.setAccessible(true);
                    declaredField2.set(objNewInstance, objInvoke);
                }
                Field declaredField3 = clsA.getDeclaredField("mPassphrase");
                declaredField3.setAccessible(true);
                declaredField3.set(objNewInstance, aVar.t());
                Field declaredField4 = clsA.getDeclaredField("mSecurityType");
                declaredField4.setAccessible(true);
                declaredField4.set(objNewInstance, Integer.valueOf(aVar.u()));
                clsA.getDeclaredMethod("setBand", Integer.TYPE).invoke(objNewInstance, Integer.valueOf(aVar.o()));
                Field declaredField5 = clsA.getDeclaredField("mAutoShutdownEnabled");
                declaredField5.setAccessible(true);
                declaredField5.set(objNewInstance, Boolean.valueOf(aVar.x()));
                Object objNewInstance2 = Class.forName("android.net.wifi.WifiManager$LocalOnlyHotspotReservation").getDeclaredConstructors()[0].newInstance(wifiManager, (SoftApConfiguration) clsA.getDeclaredMethod("build", null).invoke(objNewInstance, null));
                if (objNewInstance2 instanceof WifiManager.LocalOnlyHotspotReservation) {
                    localOnlyHotspotReservation = (WifiManager.LocalOnlyHotspotReservation) objNewInstance2;
                }
            } catch (Throwable th2) {
                m7.a.a("get LocalOnlyHotspotReservation fail: ", th2, a.f14447c);
            }
            this.f14450a.b(localOnlyHotspotReservation);
        }

        public void c() {
            this.f14450a.c();
        }
    }

    public class b extends ITranActionListener.Stub {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public ra.c.a f14452a;

        public b(ra.c.a aVar) {
            this.f14452a = aVar;
        }

        public void a(int i10) throws RemoteException {
            ra.c.a aVar = this.f14452a;
            if (aVar != null) {
                aVar.onFailure(i10);
            }
        }

        public void b() throws RemoteException {
            ra.c.a aVar = this.f14452a;
            if (aVar != null) {
                aVar.onSuccess();
            }
        }
    }

    public class c extends ITranSoftApCallback.Stub {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public ra.c.InterfaceC0346c f14454a;

        public c(ra.c.InterfaceC0346c interfaceC0346c) {
            this.f14454a = interfaceC0346c;
        }

        public void a(int i10, int i11) throws RemoteException {
            ra.c.InterfaceC0346c interfaceC0346c = this.f14454a;
            if (interfaceC0346c != null) {
                interfaceC0346c.a(i10, i11);
            }
        }
    }

    @Override // lg.a
    public void A(ra.c.InterfaceC0346c interfaceC0346c) {
        c cVar = new c(interfaceC0346c);
        ITranWifiManager iTranWifiManager = this.f14448a;
        if (iTranWifiManager != null) {
            try {
                iTranWifiManager.registerSoftApCallback(cVar);
            } catch (RemoteException e10) {
                j7.b.a("forget fail ", e10, f14447c);
            }
        }
    }

    @Override // lg.a
    public void B(ra.a aVar, ra.c.b bVar) {
        if (this.f14448a != null) {
            try {
                this.f14449b = new C0350a(bVar);
                this.f14448a.startLocalOnlyHotspot(new TranSoftApConfiguration(aVar.w(), aVar.q(), aVar.t(), aVar.B(), aVar.o(), aVar.r(), aVar.u(), aVar.s(), aVar.x(), aVar.v(), aVar.A(), aVar.p(), aVar.n()), this.f14449b);
            } catch (RemoteException e10) {
                j7.b.a("setDefaultCountryCode fail ", e10, f14447c);
                this.f14449b.a(2);
            }
        }
    }

    @Override // lg.a
    public void C(ra.b bVar, ra.c.a aVar) {
        TranWifiConfiguration tranWifiConfiguration = new TranWifiConfiguration();
        tranWifiConfiguration.SSID = bVar.f14347a;
        tranWifiConfiguration.hiddenSSID = bVar.f14348b;
        tranWifiConfiguration.networkId = bVar.f14349c;
        tranWifiConfiguration.preSharedKey = bVar.f14350d;
        tranWifiConfiguration.apBand = bVar.f14352f;
        tranWifiConfiguration.apChannel = bVar.f14353g;
        b bVar2 = new b(aVar);
        ITranWifiManager iTranWifiManager = this.f14448a;
        if (iTranWifiManager != null) {
            try {
                iTranWifiManager.connect(tranWifiConfiguration, bVar2);
            } catch (RemoteException e10) {
                j7.b.a("connect fail ", e10, f14447c);
            }
        }
    }

    @Override // lg.a
    public boolean D() {
        ITranWifiManager iTranWifiManager = this.f14448a;
        if (iTranWifiManager == null) {
            return false;
        }
        try {
            return iTranWifiManager.stopSoftAp();
        } catch (RemoteException e10) {
            j7.b.a("stopSoftAp fail ", e10, f14447c);
            return false;
        }
    }

    @Override // lg.a
    public Bundle E() {
        return null;
    }

    @Override // lg.a
    public ra.a a() {
        TranSoftApConfiguration softApConfiguration;
        ITranWifiManager iTranWifiManager = this.f14448a;
        if (iTranWifiManager != null) {
            try {
                softApConfiguration = iTranWifiManager.getSoftApConfiguration();
            } catch (RemoteException e10) {
                j7.b.a("getWifiApConfiguration fail ", e10, f14447c);
                softApConfiguration = null;
            }
        } else {
            softApConfiguration = null;
        }
        if (softApConfiguration != null) {
            return new ra.a(softApConfiguration.getSsid(), softApConfiguration.getBssid(), softApConfiguration.getPassphrase(), softApConfiguration.isHiddenSsid(), softApConfiguration.getBand(), softApConfiguration.getChannel(), softApConfiguration.getSecurityType(), softApConfiguration.getMaxNumberOfClients(), softApConfiguration.isAutoShutdownEnabled(), softApConfiguration.getShutdownTimeoutMillis(), softApConfiguration.isClientControlByUserEnabled(), softApConfiguration.getBlockedClientList(), softApConfiguration.getAllowedClientList());
        }
        return null;
    }

    @Override // lg.a
    public boolean l() {
        ITranWifiManager iTranWifiManager = this.f14448a;
        if (iTranWifiManager == null) {
            return false;
        }
        try {
            return iTranWifiManager.isWifiApEnabled();
        } catch (RemoteException e10) {
            j7.b.a("isWifiApEnabled fail ", e10, f14447c);
            return false;
        }
    }

    @Override // lg.a
    public boolean m(ra.b bVar, String str, String str2, String str3) {
        TranWifiConfiguration tranWifiConfiguration = new TranWifiConfiguration();
        tranWifiConfiguration.hiddenSSID = bVar.f14348b;
        tranWifiConfiguration.networkId = bVar.f14349c;
        tranWifiConfiguration.preSharedKey = bVar.f14350d;
        tranWifiConfiguration.apBand = bVar.f14352f;
        tranWifiConfiguration.apChannel = bVar.f14353g;
        ITranWifiManager iTranWifiManager = this.f14448a;
        if (iTranWifiManager == null) {
            return false;
        }
        try {
            return iTranWifiManager.setStaticIpConfiguration(tranWifiConfiguration, str, str2, str3);
        } catch (RemoteException e10) {
            j7.b.a("forget fail ", e10, f14447c);
            return false;
        }
    }

    @Override // lg.a
    public ra.b n() {
        TranWifiConfiguration wifiApConfiguration;
        ITranWifiManager iTranWifiManager = this.f14448a;
        if (iTranWifiManager != null) {
            try {
                wifiApConfiguration = iTranWifiManager.getWifiApConfiguration();
            } catch (RemoteException e10) {
                j7.b.a("getWifiApConfiguration fail ", e10, f14447c);
                wifiApConfiguration = null;
            }
        } else {
            wifiApConfiguration = null;
        }
        if (wifiApConfiguration == null) {
            return null;
        }
        ra.b bVar = new ra.b();
        bVar.f14347a = wifiApConfiguration.SSID;
        bVar.f14348b = wifiApConfiguration.hiddenSSID;
        bVar.f14349c = wifiApConfiguration.networkId;
        bVar.f14350d = wifiApConfiguration.preSharedKey;
        bVar.f14352f = wifiApConfiguration.apBand;
        bVar.f14353g = wifiApConfiguration.apChannel;
        bVar.f14351e = wifiApConfiguration.allowedKeyManagement;
        return bVar;
    }

    @Override // lg.a
    public void o(String str) {
        ITranWifiManager iTranWifiManager = this.f14448a;
        if (iTranWifiManager != null) {
            try {
                iTranWifiManager.setDefaultCountryCode(str);
            } catch (RemoteException e10) {
                j7.b.a("setDefaultCountryCode fail ", e10, f14447c);
            }
        }
    }

    @Override // lg.a
    public void p(WifiConfiguration wifiConfiguration, int i10) {
        TranWifiConfiguration.setNumAssociation(wifiConfiguration, i10);
    }

    @Override // lg.a
    public Bundle q() {
        ITranWifiManager iTranWifiManager = this.f14448a;
        if (iTranWifiManager == null) {
            return null;
        }
        try {
            return iTranWifiManager.getPrivilegedConfiguredNetworksToBundle();
        } catch (RemoteException e10) {
            j7.b.a("getPrivilegedConfiguredNetworksToBundle fail ", e10, f14447c);
            return null;
        }
    }

    @Override // lg.a
    public boolean r(ra.b bVar) {
        TranWifiConfiguration tranWifiConfiguration = new TranWifiConfiguration();
        tranWifiConfiguration.SSID = bVar.f14347a;
        tranWifiConfiguration.hiddenSSID = bVar.f14348b;
        tranWifiConfiguration.networkId = bVar.f14349c;
        tranWifiConfiguration.preSharedKey = bVar.f14350d;
        tranWifiConfiguration.apBand = bVar.f14352f;
        tranWifiConfiguration.apChannel = bVar.f14353g;
        tranWifiConfiguration.allowedKeyManagement = bVar.f14351e;
        ITranWifiManager iTranWifiManager = this.f14448a;
        if (iTranWifiManager == null) {
            return false;
        }
        try {
            return iTranWifiManager.setWifiApConfiguration(tranWifiConfiguration);
        } catch (RemoteException e10) {
            j7.b.a("setWifiApConfiguration fail ", e10, f14447c);
            return false;
        }
    }

    @Override // lg.a
    public int s() {
        ITranWifiManager iTranWifiManager = this.f14448a;
        if (iTranWifiManager == null) {
            return 0;
        }
        try {
            return iTranWifiManager.getWifiApState();
        } catch (RemoteException e10) {
            j7.b.a("getWifiApState fail ", e10, f14447c);
            return 0;
        }
    }

    @Override // lg.a
    public WifiConfiguration t(Parcel parcel) {
        try {
            Field declaredField = WifiConfiguration.class.getDeclaredField("CREATOR");
            declaredField.setAccessible(true);
            Parcelable.Creator creator = (Parcelable.Creator) declaredField.get(WifiConfiguration.class);
            Method declaredMethod = Parcelable.Creator.class.getDeclaredMethod("createFromParcel", Parcel.class);
            declaredMethod.setAccessible(true);
            return (WifiConfiguration) declaredMethod.invoke(creator, parcel);
        } catch (Exception e10) {
            e.o(f14447c, "getWifiConfiguration: ", e10);
            return null;
        }
    }

    @Override // lg.a
    public void u(ra.b bVar, ra.c.a aVar) {
        TranWifiConfiguration tranWifiConfiguration = new TranWifiConfiguration();
        tranWifiConfiguration.SSID = bVar.f14347a;
        tranWifiConfiguration.hiddenSSID = bVar.f14348b;
        tranWifiConfiguration.networkId = bVar.f14349c;
        tranWifiConfiguration.preSharedKey = bVar.f14350d;
        tranWifiConfiguration.apBand = bVar.f14352f;
        tranWifiConfiguration.apChannel = bVar.f14353g;
        b bVar2 = new b(aVar);
        ITranWifiManager iTranWifiManager = this.f14448a;
        if (iTranWifiManager != null) {
            try {
                iTranWifiManager.save(tranWifiConfiguration, bVar2);
            } catch (RemoteException e10) {
                j7.b.a("save fail ", e10, f14447c);
            }
        }
    }

    @Override // lg.a
    public void v(String str, ra.c.a aVar) {
        b bVar = new b(aVar);
        ITranWifiManager iTranWifiManager = this.f14448a;
        if (iTranWifiManager != null) {
            try {
                iTranWifiManager.connectSsid(str, bVar);
            } catch (RemoteException e10) {
                j7.b.a("connect ssid fail ", e10, f14447c);
            }
        }
    }

    @Override // lg.a
    public int w(WifiConfiguration wifiConfiguration) {
        return TranWifiConfiguration.getNumAssociation(wifiConfiguration);
    }

    @Override // lg.a
    public boolean x(ra.b bVar) {
        TranWifiConfiguration tranWifiConfiguration = new TranWifiConfiguration();
        tranWifiConfiguration.SSID = bVar.f14347a;
        tranWifiConfiguration.hiddenSSID = bVar.f14348b;
        tranWifiConfiguration.networkId = bVar.f14349c;
        tranWifiConfiguration.preSharedKey = bVar.f14350d;
        tranWifiConfiguration.apBand = bVar.f14352f;
        tranWifiConfiguration.apChannel = bVar.f14353g;
        tranWifiConfiguration.allowedKeyManagement = bVar.f14351e;
        ITranWifiManager iTranWifiManager = this.f14448a;
        if (iTranWifiManager == null) {
            return false;
        }
        try {
            return iTranWifiManager.startSoftAp(tranWifiConfiguration);
        } catch (RemoteException e10) {
            j7.b.a("startSoftAp fail ", e10, f14447c);
            return false;
        }
    }

    @Override // lg.a
    public void y(int i10, ra.c.a aVar) {
        b bVar = new b(aVar);
        ITranWifiManager iTranWifiManager = this.f14448a;
        if (iTranWifiManager != null) {
            try {
                iTranWifiManager.forget(i10, bVar);
            } catch (RemoteException e10) {
                j7.b.a("forget fail ", e10, f14447c);
            }
        }
    }

    @Override // lg.a
    public String[] z() {
        ITranWifiManager iTranWifiManager = this.f14448a;
        if (iTranWifiManager == null) {
            return null;
        }
        try {
            return iTranWifiManager.getFactoryMacAddresses();
        } catch (RemoteException e10) {
            j7.b.a("getFactoryMacAddresses fail ", e10, f14447c);
            return null;
        }
    }
}
