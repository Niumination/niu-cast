package ve;

import android.os.RemoteException;
import com.transsion.hubsdk.TranServiceManager;
import com.transsion.hubsdk.window.ITranDisplayRotationManager;

/* JADX INFO: loaded from: classes2.dex */
public class b implements ph.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ITranDisplayRotationManager f17018a = ITranDisplayRotationManager.Stub.asInterface(TranServiceManager.getServiceIBinder("display_rotation"));

    @Override // ph.a
    public void a(final int i10) {
        if (fc.a.f()) {
            new zb.f().c(new zb.f.b() { // from class: ve.a
                @Override // zb.f.b
                public final Object run() {
                    return this.f17016a.c(i10);
                }
            }, "display_rotation");
        }
    }

    public final /* synthetic */ Object c(int i10) throws RemoteException {
        ITranDisplayRotationManager iTranDisplayRotationManager = this.f17018a;
        if (iTranDisplayRotationManager == null) {
            return null;
        }
        iTranDisplayRotationManager.onNotifySaveRotation(i10);
        return null;
    }
}
