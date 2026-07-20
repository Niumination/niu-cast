package w9;

import android.os.RemoteException;
import com.transsion.hubsdk.TranServiceManager;
import com.transsion.hubsdk.view.ITranWindowManager;
import j3.z;

/* JADX INFO: loaded from: classes2.dex */
public final class b implements ha.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public a f10684b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ITranWindowManager f10683a = ITranWindowManager.Stub.asInterface(TranServiceManager.getServiceIBinder("window"));

    @Override // ha.a
    public final void a(z zVar) {
        if (this.f10683a != null) {
            a aVar = new a();
            this.f10684b = aVar;
            try {
                this.f10683a.registerDisplayFoldListener(aVar);
            } catch (RemoteException e) {
                j9.a.b("b", "registerDisplayFoldListener fail" + e);
            }
        }
    }

    @Override // ha.a
    public final void b() {
        a aVar;
        ITranWindowManager iTranWindowManager = this.f10683a;
        if (iTranWindowManager == null || (aVar = this.f10684b) == null) {
            return;
        }
        try {
            iTranWindowManager.unregisterDisplayFoldListener(aVar);
        } catch (RemoteException e) {
            j9.a.b("b", "unregisterDisplayFoldListener fail" + e);
        }
    }
}
