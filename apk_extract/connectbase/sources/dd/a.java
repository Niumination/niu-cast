package dd;

import android.os.RemoteException;
import android.util.ArrayMap;
import com.transsion.hubsdk.TranServiceManager;
import com.transsion.hubsdk.hardware.tp.ITranTpCallback;
import com.transsion.hubsdk.hardware.tp.ITranTpManager;
import dc.e;
import j7.b;

/* JADX INFO: loaded from: classes2.dex */
public class a implements wf.a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f3695c = "TranThubTpManager";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ArrayMap<ca.a.InterfaceC0061a, C0085a> f3697b = new ArrayMap<>();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ITranTpManager f3696a = ITranTpManager.Stub.asInterface(TranServiceManager.getServiceIBinder("trantp"));

    /* JADX INFO: renamed from: dd.a$a, reason: collision with other inner class name */
    public class C0085a extends ITranTpCallback.Stub {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public ca.a.InterfaceC0061a f3698a;

        public C0085a(ca.a.InterfaceC0061a interfaceC0061a) {
            this.f3698a = interfaceC0061a;
        }

        public void a(int i10, String str) throws RemoteException {
            ca.a.InterfaceC0061a interfaceC0061a = this.f3698a;
            if (interfaceC0061a != null) {
                interfaceC0061a.f(i10, str);
            }
        }
    }

    @Override // wf.a
    public void a(ca.a.InterfaceC0061a interfaceC0061a) {
        C0085a c0085a = this.f3697b.get(interfaceC0061a);
        try {
            try {
                ITranTpManager iTranTpManager = this.f3696a;
                if (iTranTpManager != null && c0085a != null) {
                    iTranTpManager.unregisterCallback(c0085a);
                }
                e.f(f3695c, "unregisterCallback success");
            } catch (RemoteException e10) {
                e.c(f3695c, "unregisterCallback exception: " + e10);
            }
        } finally {
            this.f3697b.remove(interfaceC0061a);
        }
    }

    @Override // wf.a
    public void b(int i10, ca.a.InterfaceC0061a interfaceC0061a) {
        C0085a c0085a = new C0085a(interfaceC0061a);
        this.f3697b.put(interfaceC0061a, c0085a);
        try {
            ITranTpManager iTranTpManager = this.f3696a;
            if (iTranTpManager != null) {
                iTranTpManager.registerCallback(i10, c0085a);
            }
            e.f(f3695c, "registerCallback success");
        } catch (RemoteException e10) {
            b.a("registerCallback exception: ", e10, f3695c);
        }
    }

    @Override // wf.a
    public String getValue(int i10) {
        try {
            ITranTpManager iTranTpManager = this.f3696a;
            if (iTranTpManager != null) {
                return iTranTpManager.getValue(i10);
            }
            return null;
        } catch (RemoteException e10) {
            b.a("getValue exception: ", e10, f3695c);
            return null;
        }
    }

    @Override // wf.a
    public boolean setValue(int i10, String str) {
        try {
            ITranTpManager iTranTpManager = this.f3696a;
            if (iTranTpManager != null) {
                return iTranTpManager.setValue(i10, str);
            }
            return false;
        } catch (RemoteException e10) {
            b.a("setValue exception: ", e10, f3695c);
            return false;
        }
    }
}
