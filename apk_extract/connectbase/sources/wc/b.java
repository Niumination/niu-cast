package wc;

import android.os.RemoteException;
import com.android.internal.annotations.VisibleForTesting;
import com.transsion.hubsdk.TranServiceManager;
import com.transsion.hubsdk.hardware.camera2.ITranCameraManager;
import dc.e;
import zb.f;

/* JADX INFO: loaded from: classes2.dex */
public class b implements pf.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f18262b = "b";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ITranCameraManager f18263a = ITranCameraManager.Stub.asInterface(TranServiceManager.getServiceIBinder("camera"));

    @Override // pf.a
    public void a(final String str, final String str2) {
        new f().c(new f.b() { // from class: wc.a
            @Override // zb.f.b
            public final Object run() {
                return this.f18259a.c(str, str2);
            }
        }, "camera");
        e.f(f18262b, "setCustomTorchMode mService: " + this.f18263a);
    }

    public final /* synthetic */ Object c(String str, String str2) throws RemoteException {
        ITranCameraManager iTranCameraManager = this.f18263a;
        if (iTranCameraManager == null) {
            return null;
        }
        iTranCameraManager.setCustomTorchMode(str, str2);
        return null;
    }

    @VisibleForTesting
    public void d(ITranCameraManager iTranCameraManager) {
        this.f18263a = iTranCameraManager;
    }
}
