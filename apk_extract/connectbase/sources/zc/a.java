package zc;

import android.os.RemoteException;
import com.android.internal.annotations.VisibleForTesting;
import com.transsion.hubsdk.TranServiceManager;
import com.transsion.hubsdk.hardware.face.ITranFaceManager;

/* JADX INFO: loaded from: classes2.dex */
public class a implements sf.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f21907b = "a";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ITranFaceManager f21908a = ITranFaceManager.Stub.asInterface(TranServiceManager.getServiceIBinder("face_manager"));

    @Override // sf.a
    public void a(int i10, int i11, int i12) {
        ITranFaceManager iTranFaceManager = this.f21908a;
        if (iTranFaceManager != null) {
            try {
                iTranFaceManager.setConfig(i10, i11, i12);
            } catch (RemoteException e10) {
                e10.printStackTrace();
            }
        }
    }

    @Override // sf.a
    public boolean b() {
        ITranFaceManager iTranFaceManager = this.f21908a;
        if (iTranFaceManager == null) {
            return false;
        }
        try {
            return iTranFaceManager.isHardwareDetected();
        } catch (RemoteException e10) {
            e10.printStackTrace();
            return false;
        }
    }

    @VisibleForTesting
    public void c(ITranFaceManager iTranFaceManager) {
        this.f21908a = iTranFaceManager;
    }
}
