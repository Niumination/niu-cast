package p6;

import android.app.ActivityManager;
import android.app.IForegroundServiceObserver;
import android.os.IBinder;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes2.dex */
public class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f12968a = "TranAospActivityManagerExtUnofficial";

    public static class a extends IForegroundServiceObserver.Stub {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public b f12969a;

        public a(b bVar) {
            this.f12969a = bVar;
        }

        public void a(IBinder iBinder, String str, int i10, boolean z10) {
            b bVar = this.f12969a;
            if (bVar != null) {
                bVar.a(iBinder, str, i10, z10);
            }
        }
    }

    public interface b {
        void a(IBinder iBinder, String str, int i10, boolean z10);
    }

    public boolean a(b bVar) {
        try {
            return ActivityManager.getService().registerForegroundServiceObserver(new a(bVar));
        } catch (RemoteException e10) {
            dc.e.d(f12968a, "registerForegroundServiceObserver: ", e10);
            return false;
        }
    }
}
