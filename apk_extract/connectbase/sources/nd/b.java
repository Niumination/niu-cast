package nd;

import android.os.RemoteException;
import android.os.UserHandle;
import com.android.internal.annotations.VisibleForTesting;
import com.transsion.hubsdk.TranServiceManager;
import com.transsion.hubsdk.location.ITranLocationManager;
import dc.e;
import zb.f;

/* JADX INFO: loaded from: classes2.dex */
public class b implements hg.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f11448b = "b";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ITranLocationManager f11449a = ITranLocationManager.Stub.asInterface(TranServiceManager.getServiceIBinder("location"));

    @Override // hg.a
    public void a(final boolean z10, final UserHandle userHandle) {
        new f().c(new f.b() { // from class: nd.a
            @Override // zb.f.b
            public final Object run() {
                return this.f11445a.c(z10, userHandle);
            }
        }, "location");
        e.a(f11448b, "setLocationEnabledForUser sucess");
    }

    public final /* synthetic */ Object c(boolean z10, UserHandle userHandle) throws RemoteException {
        ITranLocationManager iTranLocationManager = this.f11449a;
        if (iTranLocationManager == null) {
            return null;
        }
        iTranLocationManager.setLocationEnabledForUser(z10, userHandle);
        return null;
    }

    @VisibleForTesting
    public void d(ITranLocationManager iTranLocationManager) {
        this.f11449a = iTranLocationManager;
    }
}
