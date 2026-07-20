package pd;

import android.content.Intent;
import android.os.RemoteException;
import com.transsion.hubsdk.TranServiceManager;
import com.transsion.hubsdk.media.projection.ITranMediaProjectionManager;

/* JADX INFO: loaded from: classes2.dex */
public class a implements jg.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ITranMediaProjectionManager f13084a = ITranMediaProjectionManager.Stub.asInterface(TranServiceManager.getServiceIBinder("media_projection"));

    @Override // jg.a
    public Intent a(int i10, String str, int i11, boolean z10) {
        try {
            return this.f13084a.getPutIBindIntent(i10, str, i11, z10);
        } catch (RemoteException e10) {
            e10.printStackTrace();
            return new Intent();
        }
    }
}
