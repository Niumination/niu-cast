package sd;

import android.os.RemoteException;
import com.android.internal.annotations.VisibleForTesting;
import com.transsion.hubsdk.TranServiceManager;
import com.transsion.hubsdk.nfc.ITranNfcManager;
import dc.e;
import zb.f;

/* JADX INFO: loaded from: classes2.dex */
public class c implements mg.b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f15052b = "c";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ITranNfcManager f15053a = ITranNfcManager.Stub.asInterface(TranServiceManager.getServiceIBinder("nfc"));

    @Override // mg.b
    public boolean a() {
        boolean zBooleanValue = ((Boolean) new f().c(new f.b() { // from class: sd.b
            @Override // zb.f.b
            public final Object run() {
                return this.f15051a.e();
            }
        }, "nfc")).booleanValue();
        e.a(f15052b, "disable result:" + zBooleanValue);
        return zBooleanValue;
    }

    @Override // mg.b
    public boolean b() {
        boolean zBooleanValue = ((Boolean) new f().c(new f.b() { // from class: sd.a
            @Override // zb.f.b
            public final Object run() {
                return this.f15050a.f();
            }
        }, "nfc")).booleanValue();
        e.a(f15052b, "enable result:" + zBooleanValue);
        return zBooleanValue;
    }

    public final /* synthetic */ Object e() throws RemoteException {
        ITranNfcManager iTranNfcManager = this.f15053a;
        return iTranNfcManager != null ? Boolean.valueOf(iTranNfcManager.disable()) : Boolean.FALSE;
    }

    public final /* synthetic */ Object f() throws RemoteException {
        ITranNfcManager iTranNfcManager = this.f15053a;
        return iTranNfcManager != null ? Boolean.valueOf(iTranNfcManager.enable()) : Boolean.FALSE;
    }

    @VisibleForTesting
    public void g(ITranNfcManager iTranNfcManager) {
        this.f15053a = iTranNfcManager;
    }
}
