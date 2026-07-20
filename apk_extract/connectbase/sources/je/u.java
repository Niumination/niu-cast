package je;

import android.os.RemoteException;
import com.transsion.hubsdk.TranServiceManager;
import com.transsion.hubsdk.telephony.ITranTelephonyManagerExt;

/* JADX INFO: loaded from: classes2.dex */
public class u implements dh.g {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f8707b = "u";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ITranTelephonyManagerExt f8708a = ITranTelephonyManagerExt.Stub.asInterface(TranServiceManager.getServiceIBinder("telephony_ext"));

    @Override // dh.g
    public void a() {
        try {
            this.f8708a.enterDeviceLock();
        } catch (RemoteException e10) {
            j7.b.a("enterDeviceLock fail ", e10, f8707b);
        }
    }

    @Override // dh.g
    public int b(int i10, String str) {
        try {
            ITranTelephonyManagerExt iTranTelephonyManagerExt = this.f8708a;
            if (iTranTelephonyManagerExt != null) {
                return iTranTelephonyManagerExt.supplyNetworkDepersonalization(i10, str);
            }
            return 1;
        } catch (RemoteException e10) {
            j7.b.a("supplyNetworkDepersonalization fail ", e10, f8707b);
            return 1;
        }
    }

    @Override // dh.g
    public int c() {
        try {
            return this.f8708a.queryDeviceLockedStatus();
        } catch (RemoteException e10) {
            j7.b.a("queryDeviceLockedStatus fail ", e10, f8707b);
            return -1;
        }
    }

    @Override // dh.g
    public void d(int i10) {
        try {
            this.f8708a.exitDeviceLock(i10);
        } catch (RemoteException e10) {
            j7.b.a("exitDeviceLock fail ", e10, f8707b);
        }
    }

    @Override // dh.g
    public String e(String str) {
        try {
            ITranTelephonyManagerExt iTranTelephonyManagerExt = this.f8708a;
            if (iTranTelephonyManagerExt != null) {
                return iTranTelephonyManagerExt.getOperatorCoverageUrl(str);
            }
            return null;
        } catch (RemoteException e10) {
            j7.b.a("getOperatorCoverageUrl fail ", e10, f8707b);
            return null;
        }
    }
}
