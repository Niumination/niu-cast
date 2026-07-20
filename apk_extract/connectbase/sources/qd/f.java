package qd;

import android.os.RemoteException;
import com.android.internal.annotations.VisibleForTesting;
import com.transsion.hubsdk.TranServiceManager;
import com.transsion.hubsdk.net.ITranConnectivityManager;
import com.transsion.hubsdk.net.ITranOnStartTetheringCallback;
import ic.n0;
import java.util.Arrays;

/* JADX INFO: loaded from: classes2.dex */
public class f implements kg.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f13974b = "f";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ITranConnectivityManager f13975a = ITranConnectivityManager.Stub.asInterface(TranServiceManager.getServiceIBinder("connectivity"));

    public class a extends ITranOnStartTetheringCallback.Stub {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public qa.a.InterfaceC0341a f13976a;

        public a(qa.a.InterfaceC0341a interfaceC0341a) {
            this.f13976a = interfaceC0341a;
        }

        public void a() throws RemoteException {
            qa.a.InterfaceC0341a interfaceC0341a = this.f13976a;
            if (interfaceC0341a != null) {
                interfaceC0341a.b();
            }
        }

        public void b() throws RemoteException {
            qa.a.InterfaceC0341a interfaceC0341a = this.f13976a;
            if (interfaceC0341a != null) {
                interfaceC0341a.a();
            }
        }
    }

    @Override // kg.a
    public void f(final int i10) {
        new zb.f().c(new zb.f.b() { // from class: qd.a
            @Override // zb.f.b
            public final Object run() {
                return this.f13965a.t(i10);
            }
        }, "connectivity");
    }

    @Override // kg.a
    public String[] g() {
        String[] strArr = (String[]) new zb.f().c(new zb.f.b() { // from class: qd.c
            @Override // zb.f.b
            public final Object run() {
                return this.f13968a.q();
            }
        }, "connectivity");
        dc.e.f(f13974b, "getTetherableWifiRegexs result:" + strArr);
        return strArr;
    }

    @Override // kg.a
    public void h(final int i10, final boolean z10, final qa.a.InterfaceC0341a interfaceC0341a) {
        new zb.f().c(new zb.f.b() { // from class: qd.e
            @Override // zb.f.b
            public final Object run() {
                return this.f13970a.s(i10, z10, interfaceC0341a);
            }
        }, "connectivity");
    }

    @Override // kg.a
    public void i(boolean z10) {
        try {
            this.f13975a.setAirplaneMode(z10);
        } catch (RemoteException e10) {
            e10.printStackTrace();
        }
    }

    @Override // kg.a
    public void j(boolean z10) {
        try {
            this.f13975a.setUsbTethering(z10);
        } catch (RemoteException e10) {
            j7.b.a("setUsbTethering fail ", e10, f13974b);
        }
    }

    @Override // kg.a
    public void k(int i10, boolean z10, qa.a.InterfaceC0341a interfaceC0341a) {
        h(i10, z10, interfaceC0341a);
    }

    @Override // kg.a
    public boolean l(int i10, int i11) {
        try {
            return this.f13975a.requestRouteToHost(i10, i11);
        } catch (RemoteException e10) {
            j7.b.a("requestRouteToHost fail ", e10, f13974b);
            return false;
        }
    }

    @Override // kg.a
    public boolean m() {
        boolean zBooleanValue = ((Boolean) new zb.f().c(new zb.f.b() { // from class: qd.d
            @Override // zb.f.b
            public final Object run() {
                return this.f13969a.r();
            }
        }, "connectivity")).booleanValue();
        n0.a("isTetheringSupported result:", zBooleanValue, f13974b);
        return zBooleanValue;
    }

    @Override // kg.a
    public String[] n() {
        String[] strArr = (String[]) new zb.f().c(new zb.f.b() { // from class: qd.b
            @Override // zb.f.b
            public final Object run() {
                return this.f13967a.p();
            }
        }, "connectivity");
        dc.e.f(f13974b, "getTetherableUsbRegexs result:" + Arrays.toString(strArr));
        return strArr;
    }

    @Override // kg.a
    public boolean o(int i10) {
        try {
            return this.f13975a.isNetworkSupported(i10);
        } catch (RemoteException e10) {
            e10.printStackTrace();
            return false;
        }
    }

    public final /* synthetic */ Object p() throws RemoteException {
        ITranConnectivityManager iTranConnectivityManager = this.f13975a;
        if (iTranConnectivityManager != null) {
            return iTranConnectivityManager.getTetherableUsbRegexs();
        }
        return null;
    }

    public final /* synthetic */ Object q() throws RemoteException {
        ITranConnectivityManager iTranConnectivityManager = this.f13975a;
        if (iTranConnectivityManager != null) {
            return iTranConnectivityManager.getTetherableWifiRegexs();
        }
        return null;
    }

    public final /* synthetic */ Object r() throws RemoteException {
        ITranConnectivityManager iTranConnectivityManager = this.f13975a;
        return iTranConnectivityManager != null ? Boolean.valueOf(iTranConnectivityManager.isTetheringSupported()) : Boolean.FALSE;
    }

    public final /* synthetic */ Object s(int i10, boolean z10, qa.a.InterfaceC0341a interfaceC0341a) throws RemoteException {
        ITranConnectivityManager iTranConnectivityManager = this.f13975a;
        if (iTranConnectivityManager != null) {
            iTranConnectivityManager.startTethering(i10, z10, new a(interfaceC0341a));
        }
        return 0;
    }

    public final /* synthetic */ Object t(int i10) throws RemoteException {
        ITranConnectivityManager iTranConnectivityManager = this.f13975a;
        if (iTranConnectivityManager != null) {
            iTranConnectivityManager.stopTethering(i10);
        }
        return 0;
    }

    @VisibleForTesting
    public void u(ITranConnectivityManager iTranConnectivityManager) {
        this.f13975a = iTranConnectivityManager;
    }
}
