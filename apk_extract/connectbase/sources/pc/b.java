package pc;

import android.os.RemoteException;
import com.android.internal.annotations.VisibleForTesting;
import com.transsion.hubsdk.TranServiceManager;
import com.transsion.hubsdk.content.om.ITranOverlayManager;
import dc.e;
import zb.f;

/* JADX INFO: loaded from: classes2.dex */
public class b implements p000if.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f13082b = "b";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ITranOverlayManager f13083a = ITranOverlayManager.Stub.asInterface(TranServiceManager.getServiceIBinder("overlay"));

    @Override // p000if.a
    public void a(final String str, final int i10) {
        new f().c(new f.b() { // from class: pc.a
            @Override // zb.f.b
            public final Object run() {
                return this.f13079a.c(str, i10);
            }
        }, "overlay");
        e.f(f13082b, "setEnabledExclusiveInCategory packageName:" + str);
    }

    public final /* synthetic */ Object c(String str, int i10) throws RemoteException {
        ITranOverlayManager iTranOverlayManager = this.f13083a;
        if (iTranOverlayManager == null) {
            return null;
        }
        iTranOverlayManager.setEnabledExclusiveInCategory(str, i10);
        return null;
    }

    @VisibleForTesting
    public void d(ITranOverlayManager iTranOverlayManager) {
        this.f13083a = iTranOverlayManager;
    }
}
