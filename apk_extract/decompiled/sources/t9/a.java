package t9;

import android.content.Context;
import android.os.RemoteException;
import com.transsion.hubsdk.TranServiceManager;
import com.transsion.hubsdk.internal.statusbar.ITranStatusBarService;
import j3.z;

/* JADX INFO: loaded from: classes2.dex */
public final class a implements ea.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ITranStatusBarService f10200a = ITranStatusBarService.Stub.asInterface(TranServiceManager.getServiceIBinder("statusbar"));

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Context f10201b = z.a();

    @Override // ea.a
    public final void a() {
        ITranStatusBarService iTranStatusBarService = this.f10200a;
        if (iTranStatusBarService == null) {
            return;
        }
        try {
            iTranStatusBarService.setIconVisibility("STATUSBARICONSLOT", false);
        } catch (RemoteException e) {
            j9.a.b("a", "setIconVisibility:" + e);
        }
    }

    @Override // ea.a
    public final void setIcon(int i8) {
        ITranStatusBarService iTranStatusBarService = this.f10200a;
        if (iTranStatusBarService == null) {
            return;
        }
        try {
            iTranStatusBarService.setIcon("STATUSBARICONSLOT", this.f10201b.getPackageName(), i8, 0, "STATUSBARICONSLOT");
        } catch (RemoteException e) {
            j9.a.b("a", "setIcon:" + e);
        }
    }
}
