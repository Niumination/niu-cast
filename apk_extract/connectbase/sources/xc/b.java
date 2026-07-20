package xc;

import android.os.RemoteException;
import com.android.internal.annotations.VisibleForTesting;
import com.transsion.hubsdk.TranServiceManager;
import com.transsion.hubsdk.hardware.devicestate.ITranDeviceStateManager;
import java.util.concurrent.Executor;
import zb.f;

/* JADX INFO: loaded from: classes2.dex */
public class b implements qf.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f20141b = "b";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ITranDeviceStateManager f20142a = ITranDeviceStateManager.Stub.asInterface(TranServiceManager.getServiceIBinder("device_state"));

    @Override // qf.a
    public void a(f7.b.InterfaceC0139b interfaceC0139b) {
    }

    @Override // qf.a
    public void b(Executor executor, f7.b.InterfaceC0139b interfaceC0139b) {
    }

    @Override // qf.a
    public int c() {
        return ((Integer) new f().c(new f.b() { // from class: xc.a
            @Override // zb.f.b
            public final Object run() {
                return this.f20140a.e();
            }
        }, "device_state")).intValue();
    }

    public final /* synthetic */ Object e() throws RemoteException {
        ITranDeviceStateManager iTranDeviceStateManager = this.f20142a;
        if (iTranDeviceStateManager != null) {
            return Integer.valueOf(iTranDeviceStateManager.getCurrentState());
        }
        return 0;
    }

    @VisibleForTesting
    public void f(ITranDeviceStateManager iTranDeviceStateManager) {
        this.f20142a = iTranDeviceStateManager;
    }
}
