package r8;

import android.os.RemoteException;
import android.util.Log;
import android.view.IWindowManager;
import android.view.WindowManagerGlobal;
import j3.z;
import k3.o9;

/* JADX INFO: loaded from: classes2.dex */
public final class b implements ha.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public a f9384a;

    static {
        o9.a("android.view.IWindowManager$Stub");
        o9.a("android.os.ServiceManager");
    }

    @Override // ha.a
    public final void a(z zVar) {
        IWindowManager windowManagerService = WindowManagerGlobal.getWindowManagerService();
        try {
            a aVar = new a();
            aVar.f9383b = zVar;
            this.f9384a = aVar;
            windowManagerService.registerDisplayFoldListener(aVar);
        } catch (RemoteException e) {
            boolean z2 = j9.a.f6132a;
            Log.e("TranAospWindowManagerExt", "registerDisplayFoldListener fail " + e);
        }
    }

    @Override // ha.a
    public final void b() {
        IWindowManager windowManagerService = WindowManagerGlobal.getWindowManagerService();
        a aVar = this.f9384a;
        if (aVar != null) {
            try {
                windowManagerService.unregisterDisplayFoldListener(aVar);
            } catch (RemoteException e) {
                boolean z2 = j9.a.f6132a;
                Log.e("TranAospWindowManagerExt", "unregisterDisplayFoldListener fail " + e);
            }
        }
    }
}
