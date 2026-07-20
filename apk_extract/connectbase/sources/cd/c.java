package cd;

import android.os.RemoteException;
import com.android.internal.annotations.VisibleForTesting;
import com.transsion.hubsdk.TranServiceManager;
import com.transsion.hubsdk.hardware.sensor.ITranSensorPrivacyManager;
import dc.e;
import zb.f;

/* JADX INFO: loaded from: classes2.dex */
public class c implements vf.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f1448b = "c";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ITranSensorPrivacyManager f1449a = ITranSensorPrivacyManager.Stub.asInterface(TranServiceManager.getServiceIBinder("sensor"));

    @Override // vf.a
    public boolean a(final int i10, final int i11) {
        return ((Boolean) new f().c(new f.b() { // from class: cd.b
            @Override // zb.f.b
            public final Object run() {
                return this.f1445a.e(i10, i11);
            }
        }, "sensor")).booleanValue();
    }

    @Override // vf.a
    public void b(final int i10, final boolean z10) {
        new f().c(new f.b() { // from class: cd.a
            @Override // zb.f.b
            public final Object run() {
                return this.f1442a.f(i10, z10);
            }
        }, "sensor");
        e.a(f1448b, "setSensorPrivacy");
    }

    public final /* synthetic */ Object e(int i10, int i11) throws RemoteException {
        ITranSensorPrivacyManager iTranSensorPrivacyManager = this.f1449a;
        return iTranSensorPrivacyManager != null ? Boolean.valueOf(iTranSensorPrivacyManager.isSensorPrivacyEnabled(i10, i11)) : Boolean.FALSE;
    }

    public final /* synthetic */ Object f(int i10, boolean z10) throws RemoteException {
        ITranSensorPrivacyManager iTranSensorPrivacyManager = this.f1449a;
        if (iTranSensorPrivacyManager != null) {
            iTranSensorPrivacyManager.setSensorPrivacy(i10, z10);
        }
        return Boolean.FALSE;
    }

    @VisibleForTesting
    public void g(ITranSensorPrivacyManager iTranSensorPrivacyManager) {
        this.f1449a = iTranSensorPrivacyManager;
    }
}
