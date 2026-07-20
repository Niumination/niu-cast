package ic;

import android.os.IBinder;
import android.os.RemoteException;
import com.transsion.hubsdk.TranServiceManager;
import com.transsion.hubsdk.app.ITranActivityManager;
import com.transsion.hubsdk.app.ITranForegroundServiceObserver;

/* JADX INFO: loaded from: classes2.dex */
public class p0 implements bf.e {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f7871b = o0.class.getSimpleName();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ITranActivityManager f7872a = ITranActivityManager.Stub.asInterface(TranServiceManager.getServiceIBinder("activity"));

    public class a extends ITranForegroundServiceObserver.Stub {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public h9.h.a f7873a;

        public a(h9.h.a aVar) {
            this.f7873a = aVar;
        }

        public void a(IBinder iBinder, String str, int i10, boolean z10) throws RemoteException {
            h9.h.a aVar = this.f7873a;
            if (aVar != null) {
                aVar.a(iBinder, str, i10, z10);
            }
        }
    }

    @Override // bf.e
    public boolean a(h9.h.a aVar) {
        a aVar2 = new a(aVar);
        ITranActivityManager iTranActivityManager = this.f7872a;
        if (iTranActivityManager == null) {
            return false;
        }
        try {
            return iTranActivityManager.registerForegroundServiceObserver(aVar2);
        } catch (RemoteException e10) {
            j7.b.a("registerForegroundServiceObserver error: ", e10, f7871b);
            return false;
        }
    }
}
