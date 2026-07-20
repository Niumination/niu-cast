package ie;

import android.content.Context;
import android.os.RemoteException;
import android.telecom.PhoneAccountHandle;
import com.android.internal.annotations.VisibleForTesting;
import com.transsion.hubsdk.TranServiceManager;
import com.transsion.hubsdk.telecom.ITranTelecomManager;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class b implements ch.b {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f7932c = "b";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ITranTelecomManager f7933a = ITranTelecomManager.Stub.asInterface(TranServiceManager.getServiceIBinder("telecom"));

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Context f7934b = bc.a.a();

    @Override // ch.b
    public boolean a() {
        try {
            ITranTelecomManager iTranTelecomManager = this.f7933a;
            if (iTranTelecomManager != null) {
                return iTranTelecomManager.endCall(this.f7934b.getPackageName());
            }
            return false;
        } catch (RemoteException e10) {
            j7.b.a("endCall:", e10, f7932c);
            return false;
        }
    }

    @Override // ch.b
    public boolean b(String str) {
        try {
            ITranTelecomManager iTranTelecomManager = this.f7933a;
            if (iTranTelecomManager != null) {
                return iTranTelecomManager.setDefaultDialer(str);
            }
            return false;
        } catch (RemoteException e10) {
            j7.b.a("setDefaultDialer:", e10, f7932c);
            return false;
        }
    }

    @Override // ch.b
    public List<PhoneAccountHandle> c() {
        try {
            ITranTelecomManager iTranTelecomManager = this.f7933a;
            if (iTranTelecomManager != null) {
                return iTranTelecomManager.getCallCapablePhoneAccounts();
            }
            return null;
        } catch (RemoteException e10) {
            j7.b.a("getCallCapablePhoneAccounts:", e10, f7932c);
            return null;
        }
    }

    @Override // ch.b
    public void d(PhoneAccountHandle phoneAccountHandle) {
        try {
            ITranTelecomManager iTranTelecomManager = this.f7933a;
            if (iTranTelecomManager != null) {
                iTranTelecomManager.setUserSelectedOutgoingPhoneAccount(phoneAccountHandle);
            }
        } catch (RemoteException e10) {
            j7.b.a("setUserSelectedOutgoingPhoneAccount:", e10, f7932c);
        }
    }

    @Override // ch.b
    public boolean e() {
        ITranTelecomManager iTranTelecomManager = this.f7933a;
        if (iTranTelecomManager == null) {
            return false;
        }
        try {
            return iTranTelecomManager.isRinging();
        } catch (RemoteException e10) {
            j7.b.a("isRinging:", e10, f7932c);
            return false;
        }
    }

    @Override // ch.b
    public String f(int i10) {
        try {
            return this.f7933a.getPhoneNumberByIms(i10);
        } catch (RemoteException e10) {
            e10.printStackTrace();
            return null;
        }
    }

    @VisibleForTesting
    public void g(Context context) {
        this.f7934b = context;
    }

    @VisibleForTesting
    public void h(ITranTelecomManager iTranTelecomManager) {
        this.f7933a = iTranTelecomManager;
    }
}
