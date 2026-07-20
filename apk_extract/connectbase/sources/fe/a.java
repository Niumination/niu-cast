package fe;

import android.os.IBinder;
import android.os.RemoteException;
import com.android.internal.annotations.VisibleForTesting;
import com.transsion.hubsdk.TranServiceManager;
import com.transsion.hubsdk.dreams.ITranDreamManager;
import j7.b;

/* JADX INFO: loaded from: classes2.dex */
public class a implements zg.a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f6007c = "a";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ITranDreamManager f6008a = ITranDreamManager.Stub.asInterface(TranServiceManager.getServiceIBinder("dream"));

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public a7.a f6009b;

    private a7.a e() {
        if (this.f6009b == null) {
            this.f6009b = new a7.a();
        }
        return this.f6009b;
    }

    @Override // zg.a
    public void a(IBinder iBinder, boolean z10) {
        ITranDreamManager iTranDreamManager = this.f6008a;
        if (iTranDreamManager != null) {
            try {
                iTranDreamManager.finishSelf(iBinder, z10);
            } catch (RemoteException e10) {
                b.a("finishSelf fail ", e10, f6007c);
            }
        }
    }

    @Override // zg.a
    public void b(IBinder iBinder) {
        ITranDreamManager iTranDreamManager = this.f6008a;
        if (iTranDreamManager != null) {
            try {
                iTranDreamManager.stopDozing(iBinder);
            } catch (RemoteException e10) {
                b.a("stopDozing fail ", e10, f6007c);
            }
        }
    }

    @Override // zg.a
    public void c(IBinder iBinder, int i10, int i11) {
        ITranDreamManager iTranDreamManager = this.f6008a;
        if (iTranDreamManager != null) {
            try {
                iTranDreamManager.startDozing(iBinder, i10, i11);
            } catch (RemoteException e10) {
                b.a("startDozing fail ", e10, f6007c);
            }
        }
    }

    @Override // zg.a
    public IBinder d(a7.a.InterfaceC0003a interfaceC0003a) {
        return e().a(interfaceC0003a);
    }

    @VisibleForTesting
    public void f(ITranDreamManager iTranDreamManager) {
        this.f6008a = iTranDreamManager;
    }
}
