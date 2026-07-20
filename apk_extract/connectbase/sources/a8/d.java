package a8;

import android.content.Context;
import android.net.MacAddress;
import android.net.wifi.SoftApConfiguration;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes2.dex */
public class d implements lg.a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f151d = "d";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static Class<?> f152e = cc.a.a("android.net.wifi.SoftApConfiguration");

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f153f = 4;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f154a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public WifiManager f155b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public k f156c;

    public class a implements k.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public ra.c.a f157a;

        public a(ra.c.a aVar) {
            this.f157a = aVar;
        }

        @Override // a8.k.b
        public void onFailure(int i10) {
            ra.c.a aVar = this.f157a;
            if (aVar != null) {
                aVar.onFailure(i10);
            }
        }

        @Override // a8.k.b
        public void onSuccess() {
            ra.c.a aVar = this.f157a;
            if (aVar != null) {
                aVar.onSuccess();
            }
        }
    }

    public class b extends WifiManager.LocalOnlyHotspotCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ra.c.b f159a;

        public b(ra.c.b bVar) {
            this.f159a = bVar;
        }

        @Override // android.net.wifi.WifiManager.LocalOnlyHotspotCallback
        public void onFailed(int i10) {
            super.onFailed(i10);
            ra.c.b bVar = this.f159a;
            if (bVar != null) {
                bVar.a(i10);
            }
        }

        @Override // android.net.wifi.WifiManager.LocalOnlyHotspotCallback
        public void onStarted(WifiManager.LocalOnlyHotspotReservation localOnlyHotspotReservation) {
            super.onStarted(localOnlyHotspotReservation);
            ra.c.b bVar = this.f159a;
            if (bVar != null) {
                bVar.b(localOnlyHotspotReservation);
            }
        }

        @Override // android.net.wifi.WifiManager.LocalOnlyHotspotCallback
        public void onStopped() {
            super.onStopped();
            ra.c.b bVar = this.f159a;
            if (bVar != null) {
                bVar.c();
            }
        }
    }

    public class c implements k.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public ra.c.InterfaceC0346c f161a;

        public c(ra.c.InterfaceC0346c interfaceC0346c) {
            this.f161a = interfaceC0346c;
        }

        @Override // a8.k.e
        public void a(int i10, int i11) {
            ra.c.InterfaceC0346c interfaceC0346c = this.f161a;
            if (interfaceC0346c != null) {
                interfaceC0346c.a(i10, i11);
            }
        }
    }

    public d() {
        Context contextA = bc.a.a();
        this.f154a = contextA;
        this.f155b = (WifiManager) contextA.getSystemService("wifi");
        this.f156c = new k(this.f154a);
    }

    public static /* synthetic */ Class[] b(int i10) {
        return new Class[i10];
    }

    public static /* synthetic */ Class g(Object obj) {
        if (obj != null) {
            return obj.getClass();
        }
        return null;
    }

    public static /* synthetic */ Class[] h(int i10) {
        return new Class[i10];
    }

    @Override // lg.a
    public void A(ra.c.InterfaceC0346c interfaceC0346c) {
        if (this.f156c != null) {
            this.f156c.f(interfaceC0346c != null ? new c(interfaceC0346c) : null);
        }
    }

    @Override // lg.a
    public void B(ra.a aVar, ra.c.b bVar) {
        b bVar2 = new b(bVar);
        try {
            Class clsA = cc.a.a("android.net.wifi.SoftApConfiguration$Builder");
            Object objNewInstance = clsA.newInstance();
            if (Build.VERSION.SDK_INT < 33) {
                Field declaredField = clsA.getDeclaredField("mSsid");
                declaredField.setAccessible(true);
                declaredField.set(objNewInstance, aVar.f14317a);
            } else {
                Method declaredMethod = Class.forName("android.net.wifi.WifiSsid").getDeclaredMethod("fromBytes", byte[].class);
                declaredMethod.setAccessible(true);
                Object objInvoke = declaredMethod.invoke(null, aVar.f14317a.getBytes());
                Field declaredField2 = clsA.getDeclaredField("mWifiSsid");
                declaredField2.setAccessible(true);
                declaredField2.set(objNewInstance, objInvoke);
            }
            Field declaredField3 = clsA.getDeclaredField("mPassphrase");
            declaredField3.setAccessible(true);
            declaredField3.set(objNewInstance, aVar.f14319c);
            Field declaredField4 = clsA.getDeclaredField("mSecurityType");
            declaredField4.setAccessible(true);
            declaredField4.set(objNewInstance, Integer.valueOf(aVar.f14324h));
            clsA.getDeclaredMethod("setBand", Integer.TYPE).invoke(objNewInstance, Integer.valueOf(aVar.f14321e));
            Field declaredField5 = clsA.getDeclaredField("mAutoShutdownEnabled");
            declaredField5.setAccessible(true);
            declaredField5.set(objNewInstance, Boolean.valueOf(aVar.f14328l));
            SoftApConfiguration softApConfiguration = (SoftApConfiguration) clsA.getDeclaredMethod("build", null).invoke(objNewInstance, null);
            Method methodG = cc.a.g(this.f155b.getClass(), "startLocalOnlyHotspot", SoftApConfiguration.class, Executor.class, WifiManager.LocalOnlyHotspotCallback.class);
            methodG.setAccessible(true);
            methodG.invoke(this.f155b, softApConfiguration, null, bVar2);
        } catch (Throwable th2) {
            dc.e.i(th2);
            dc.e.c(f151d, "startLocalOnlyHotspot fail: " + th2);
            bVar2.onFailed(2);
        }
    }

    @Override // lg.a
    public void C(ra.b bVar, ra.c.a aVar) {
        a8.a aVarE = e(bVar);
        if (this.f156c != null) {
            this.f156c.a(aVarE, aVar != null ? new a(aVar) : null);
        }
    }

    @Override // lg.a
    public boolean D() {
        return ((Boolean) d("stopSoftAp", new Object[0])).booleanValue();
    }

    @Override // lg.a
    public Bundle E() {
        try {
            Method methodG = cc.a.g(this.f155b.getClass(), "getPrivilegedConfiguredNetworks", new Class[0]);
            methodG.setAccessible(true);
            ArrayList<? extends Parcelable> arrayList = (ArrayList) methodG.invoke(this.f155b, null);
            Bundle bundle = new Bundle();
            bundle.putParcelableArrayList(ra.c.f14357f, arrayList);
            return bundle;
        } catch (Throwable th2) {
            m7.a.a("getPrivilegedConfiguredNetworksToJsonString fail ", th2, f151d);
            return null;
        }
    }

    @Override // lg.a
    public ra.a a() {
        try {
            Method methodG = cc.a.g(f152e, "getSsid", new Class[0]);
            methodG.setAccessible(true);
            Method methodG2 = cc.a.g(f152e, "getBssid", new Class[0]);
            methodG2.setAccessible(true);
            Method methodG3 = cc.a.g(f152e, "getPassphrase", new Class[0]);
            methodG3.setAccessible(true);
            Method methodG4 = cc.a.g(f152e, "isHiddenSsid", new Class[0]);
            methodG4.setAccessible(true);
            Method methodG5 = cc.a.g(f152e, "getBand", new Class[0]);
            methodG5.setAccessible(true);
            Method methodG6 = cc.a.g(f152e, "getChannel", new Class[0]);
            methodG6.setAccessible(true);
            Method methodG7 = cc.a.g(f152e, "getSecurityType", new Class[0]);
            methodG7.setAccessible(true);
            Method methodG8 = cc.a.g(f152e, "getMaxNumberOfClients", new Class[0]);
            methodG8.setAccessible(true);
            Method methodG9 = cc.a.g(f152e, "isAutoShutdownEnabled", new Class[0]);
            methodG9.setAccessible(true);
            Method methodG10 = cc.a.g(f152e, "getShutdownTimeoutMillis", new Class[0]);
            methodG10.setAccessible(true);
            Method methodG11 = cc.a.g(f152e, "isClientControlByUserEnabled", new Class[0]);
            methodG11.setAccessible(true);
            Method methodG12 = cc.a.g(f152e, "getBlockedClientList", new Class[0]);
            methodG12.setAccessible(true);
            Method methodG13 = cc.a.g(f152e, "getAllowedClientList", new Class[0]);
            methodG13.setAccessible(true);
            Method methodG14 = cc.a.g(this.f155b.getClass(), "getSoftApConfiguration", new Class[0]);
            methodG14.setAccessible(true);
            Object objInvoke = methodG14.invoke(this.f155b, null);
            if (objInvoke == null || !(objInvoke instanceof SoftApConfiguration)) {
                return null;
            }
            SoftApConfiguration softApConfiguration = (SoftApConfiguration) objInvoke;
            return new ra.a((String) methodG.invoke(softApConfiguration, null), (MacAddress) methodG2.invoke(softApConfiguration, null), (String) methodG3.invoke(softApConfiguration, null), ((Boolean) methodG4.invoke(softApConfiguration, null)).booleanValue(), ((Integer) methodG5.invoke(softApConfiguration, null)).intValue(), ((Integer) methodG6.invoke(softApConfiguration, null)).intValue(), ((Integer) methodG7.invoke(softApConfiguration, null)).intValue(), ((Integer) methodG8.invoke(softApConfiguration, null)).intValue(), ((Boolean) methodG9.invoke(softApConfiguration, null)).booleanValue(), ((Long) methodG10.invoke(softApConfiguration, null)).longValue(), ((Boolean) methodG11.invoke(softApConfiguration, null)).booleanValue(), (List) methodG12.invoke(softApConfiguration, null), (List) methodG13.invoke(softApConfiguration, null));
        } catch (Throwable th2) {
            m7.a.a("getWifiApConfiguration fail ", th2, f151d);
            return null;
        }
    }

    public final <T> T d(String str, Object... objArr) {
        try {
            Method methodG = cc.a.g(this.f155b.getClass(), str, objArr == null ? null : f(objArr));
            methodG.setAccessible(true);
            return (T) methodG.invoke(this.f155b, objArr);
        } catch (Exception e10) {
            dc.e.d(f151d, "methodName:" + str, e10);
            return null;
        }
    }

    public final a8.a e(ra.b bVar) {
        if (bVar == null) {
            return null;
        }
        a8.a aVar = new a8.a();
        aVar.f144a = bVar.f14347a;
        aVar.f145b = bVar.f14348b;
        aVar.f146c = bVar.f14349c;
        aVar.f147d = bVar.f14350d;
        aVar.f148e.set(4);
        return aVar;
    }

    public final Class<?>[] f(Object... objArr) {
        return (Class[]) Arrays.stream(objArr).map(new a8.b()).toArray(new a8.c());
    }

    @Override // lg.a
    public boolean l() {
        try {
            Method methodG = cc.a.g(this.f155b.getClass(), "isWifiApEnabled", new Class[0]);
            methodG.setAccessible(true);
            Object objInvoke = methodG.invoke(this.f155b, null);
            if (objInvoke != null && (objInvoke instanceof Boolean)) {
                return ((Boolean) objInvoke).booleanValue();
            }
        } catch (Throwable th2) {
            m7.a.a("isWifiApEnabled fail ", th2, f151d);
        }
        return false;
    }

    @Override // lg.a
    public boolean m(ra.b bVar, String str, String str2, String str3) {
        a8.a aVarE = e(bVar);
        k kVar = this.f156c;
        if (kVar != null) {
            return kVar.h(aVarE, str, str2, str3);
        }
        return false;
    }

    @Override // lg.a
    public ra.b n() {
        try {
            WifiConfiguration wifiConfiguration = (WifiConfiguration) d("getWifiApConfiguration", new Object[0]);
            if (wifiConfiguration == null) {
                return null;
            }
            ra.b bVar = new ra.b();
            bVar.f14347a = wifiConfiguration.SSID;
            bVar.f14348b = wifiConfiguration.hiddenSSID;
            bVar.f14349c = wifiConfiguration.networkId;
            bVar.f14350d = wifiConfiguration.preSharedKey;
            return bVar;
        } catch (Throwable th2) {
            m7.a.a("getWifiApConfiguration fail ", th2, f151d);
            return null;
        }
    }

    @Override // lg.a
    public void o(String str) {
        try {
            Method methodG = cc.a.g(this.f155b.getClass(), "setDefaultCountryCode", String.class);
            methodG.setAccessible(true);
            methodG.invoke(this.f155b, str);
        } catch (Throwable th2) {
            m7.a.a("setDefaultCountryCode fail ", th2, f151d);
        }
    }

    @Override // lg.a
    public void p(WifiConfiguration wifiConfiguration, int i10) {
        try {
            cc.a.d(cc.a.a("android.net.wifi.WifiConfiguration"), "numAssociation").setInt(wifiConfiguration, i10);
        } catch (Exception e10) {
            dc.e.c(f151d, "Exception when setNumAssociation:" + e10.getMessage());
        }
    }

    @Override // lg.a
    public Bundle q() {
        try {
            Method methodG = cc.a.g(this.f155b.getClass(), "getPrivilegedConfiguredNetworks", new Class[0]);
            methodG.setAccessible(true);
            ArrayList<? extends Parcelable> arrayList = (ArrayList) methodG.invoke(this.f155b, null);
            Bundle bundle = new Bundle();
            bundle.putParcelableArrayList(ra.c.f14357f, arrayList);
            return bundle;
        } catch (Throwable th2) {
            m7.a.a("getPrivilegedConfiguredNetworksToJsonString fail ", th2, f151d);
            return null;
        }
    }

    @Override // lg.a
    public boolean r(ra.b bVar) {
        WifiConfiguration wifiConfiguration = new WifiConfiguration();
        wifiConfiguration.SSID = bVar.f14347a;
        wifiConfiguration.hiddenSSID = bVar.f14348b;
        wifiConfiguration.networkId = bVar.f14349c;
        wifiConfiguration.preSharedKey = bVar.f14350d;
        wifiConfiguration.allowedKeyManagement.set(4);
        try {
            return ((Boolean) d("setWifiApConfiguration", wifiConfiguration)).booleanValue();
        } catch (Throwable th2) {
            m7.a.a("setWifiApConfiguration fail ", th2, f151d);
            return false;
        }
    }

    @Override // lg.a
    public int s() {
        return ((Integer) d("getWifiApState", new Object[0])).intValue();
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
            dc.e.o(f151d, "getWifiConfiguration: ", e10);
            return null;
        }
    }

    @Override // lg.a
    public void u(ra.b bVar, ra.c.a aVar) {
        a8.a aVarE = e(bVar);
        if (this.f156c != null) {
            this.f156c.g(aVarE, aVar != null ? new a(aVar) : null);
        }
    }

    @Override // lg.a
    public void v(String str, ra.c.a aVar) {
        if (this.f156c != null) {
            this.f156c.b(str, aVar != null ? new a(aVar) : null);
        }
    }

    @Override // lg.a
    public int w(WifiConfiguration wifiConfiguration) {
        try {
            return cc.a.d(cc.a.a("android.net.wifi.WifiConfiguration"), "numAssociation").getInt(wifiConfiguration);
        } catch (Exception e10) {
            dc.e.c(f151d, "Exception when getNumAssociation:" + e10.getMessage());
            return 0;
        }
    }

    @Override // lg.a
    public boolean x(ra.b bVar) {
        WifiConfiguration wifiConfiguration = new WifiConfiguration();
        wifiConfiguration.SSID = bVar.f14347a;
        wifiConfiguration.hiddenSSID = bVar.f14348b;
        wifiConfiguration.networkId = bVar.f14349c;
        wifiConfiguration.preSharedKey = bVar.f14350d;
        wifiConfiguration.allowedKeyManagement.set(4);
        try {
            return ((Boolean) d("startSoftAp", wifiConfiguration)).booleanValue();
        } catch (Throwable th2) {
            m7.a.a("startSoftAp fail ", th2, f151d);
            return false;
        }
    }

    @Override // lg.a
    public void y(int i10, ra.c.a aVar) {
        if (this.f156c != null) {
            this.f156c.c(i10, aVar != null ? new a(aVar) : null);
        }
    }

    @Override // lg.a
    public String[] z() {
        return (String[]) d("getFactoryMacAddresses", new Object[0]);
    }
}
