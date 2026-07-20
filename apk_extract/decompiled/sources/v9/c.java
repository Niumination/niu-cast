package v9;

import android.os.RemoteException;
import com.transsion.hubsdk.TranServiceManager;
import com.transsion.hubsdk.view.ITranWindowManager;

/* JADX INFO: loaded from: classes2.dex */
public final class c implements ga.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ITranWindowManager f10529a = ITranWindowManager.Stub.asInterface(TranServiceManager.getServiceIBinder("window"));

    @Override // ga.c
    public final int a() {
        ITranWindowManager iTranWindowManager = this.f10529a;
        if (iTranWindowManager == null) {
            return 0;
        }
        try {
            return iTranWindowManager.getSwitchMode();
        } catch (RemoteException e) {
            j9.a.b("c", "getSwitchMode fail: " + e);
            return 0;
        }
    }
}
