package vd;

import android.os.IBinder;
import android.os.RemoteException;
import com.transsion.hubsdk.TranServiceManager;
import com.transsion.hubsdk.os.ITranAospServiceManager;

/* JADX INFO: loaded from: classes2.dex */
public class b0 implements pg.k {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f16907b = "b0";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ITranAospServiceManager f16908a = ITranAospServiceManager.Stub.asInterface(TranServiceManager.getServiceIBinder("aosp_service"));

    @Override // pg.k
    public IBinder a(String str) {
        return com.transsion.hubsdk.os.TranServiceManager.checkService(str);
    }

    @Override // pg.k
    public String[] b() {
        ITranAospServiceManager iTranAospServiceManager = this.f16908a;
        if (iTranAospServiceManager == null) {
            return null;
        }
        try {
            return iTranAospServiceManager.listServices();
        } catch (RemoteException e10) {
            j7.b.a("listServices: ", e10, f16907b);
            return null;
        }
    }
}
