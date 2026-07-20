package ic;

import android.os.RemoteException;
import com.android.internal.annotations.VisibleForTesting;
import com.transsion.hubsdk.TranServiceManager;
import com.transsion.hubsdk.app.ITranUiModeManager;

/* JADX INFO: loaded from: classes2.dex */
public class q1 implements bf.q {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f7883b = "q1";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ITranUiModeManager f7884a = ITranUiModeManager.Stub.asInterface(TranServiceManager.getServiceIBinder("uimode"));

    @Override // bf.q
    public boolean a(final boolean z10) {
        boolean zBooleanValue = ((Boolean) new zb.f().c(new zb.f.b() { // from class: ic.p1
            @Override // zb.f.b
            public final Object run() {
                return this.f7875a.c(z10);
            }
        }, "uimode")).booleanValue();
        n0.a("setNightModeActivated result:", zBooleanValue, f7883b);
        return zBooleanValue;
    }

    public final /* synthetic */ Object c(boolean z10) throws RemoteException {
        ITranUiModeManager iTranUiModeManager = this.f7884a;
        return iTranUiModeManager != null ? Boolean.valueOf(iTranUiModeManager.setNightModeActivated(z10)) : Boolean.FALSE;
    }

    @VisibleForTesting
    public void d(ITranUiModeManager iTranUiModeManager) {
        this.f7884a = iTranUiModeManager;
    }
}
