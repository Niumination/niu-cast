package sc;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.RemoteException;
import android.os.UserHandle;
import com.android.internal.annotations.VisibleForTesting;
import com.transsion.hubsdk.TranServiceManager;
import com.transsion.hubsdk.app.admin.ITranDevicePolicyManager;
import com.transsion.hubsdk.app.devicepolicy.TranDevicePolicyManager;
import zb.f;

/* JADX INFO: loaded from: classes2.dex */
public class e implements lf.a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f15047c = "e";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ITranDevicePolicyManager f15048a = ITranDevicePolicyManager.Stub.asInterface(TranServiceManager.getServiceIBinder("devicepolicy"));

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public TranDevicePolicyManager f15049b;

    @Override // lf.a
    public boolean a() {
        boolean zBooleanValue = ((Boolean) new f().c(new f.b() { // from class: sc.a
            @Override // zb.f.b
            public final Object run() {
                return this.f15041a.r();
            }
        }, "devicepolicy")).booleanValue();
        dc.e.f(f15047c, "isFinancedRestrictDevice");
        return zBooleanValue;
    }

    @Override // lf.a
    public ComponentName b() {
        ComponentName componentName = (ComponentName) new f().c(new f.b() { // from class: sc.b
            @Override // zb.f.b
            public final Object run() {
                return this.f15042a.p();
            }
        }, "devicepolicy");
        dc.e.f(f15047c, "getDeviceOwnerComponentOnAnyUser.");
        return componentName;
    }

    @Override // lf.a
    public void c(final ComponentName componentName, final int i10) {
        new f().c(new f.b() { // from class: sc.d
            @Override // zb.f.b
            public final Object run() {
                return this.f15044a.s(componentName, i10);
            }
        }, "devicepolicy");
        dc.e.f(f15047c, "setDualProfileEnabled.");
    }

    @Override // lf.a
    public ComponentName d(UserHandle userHandle) {
        try {
            ITranDevicePolicyManager iTranDevicePolicyManager = this.f15048a;
            if (iTranDevicePolicyManager != null) {
                return iTranDevicePolicyManager.getProfileOwnerOrDeviceOwnerSupervisionComponent(userHandle);
            }
            return null;
        } catch (RemoteException e10) {
            j7.b.a("getProfileOwnerOrDeviceOwnerSupervisionComponent fail:", e10, f15047c);
            return null;
        }
    }

    @Override // lf.a
    public ComponentName e() {
        ComponentName componentName = (ComponentName) new f().c(new f.b() { // from class: sc.c
            @Override // zb.f.b
            public final Object run() {
                return this.f15043a.q();
            }
        }, "devicepolicy");
        dc.e.f(f15047c, "getProfileOwner.");
        return componentName;
    }

    @Override // lf.a
    public long f(ComponentName componentName, int i10) {
        try {
            ITranDevicePolicyManager iTranDevicePolicyManager = this.f15048a;
            if (iTranDevicePolicyManager != null) {
                return iTranDevicePolicyManager.getMaximumTimeToLock(componentName, i10);
            }
            return 0L;
        } catch (RemoteException e10) {
            j7.b.a("getMaximumTimeToLock fail:", e10, f15047c);
            return 0L;
        }
    }

    @Override // lf.a
    public ComponentName g(int i10) {
        try {
            ITranDevicePolicyManager iTranDevicePolicyManager = this.f15048a;
            if (iTranDevicePolicyManager != null) {
                return iTranDevicePolicyManager.getProfileOwnerAsUser(i10);
            }
            return null;
        } catch (RemoteException e10) {
            j7.b.a("getProfileOwnerAsUser fail:", e10, f15047c);
            return null;
        }
    }

    @Override // lf.a
    public boolean h(String str) {
        try {
            ITranDevicePolicyManager iTranDevicePolicyManager = this.f15048a;
            if (iTranDevicePolicyManager != null) {
                return iTranDevicePolicyManager.isDeviceOwnerAppOnAnyUser(str);
            }
            return false;
        } catch (RemoteException e10) {
            j7.b.a("isDeviceOwnerAppOnAnyUser fail:", e10, f15047c);
            return false;
        }
    }

    @Override // lf.a
    public Intent i(Intent intent) {
        ITranDevicePolicyManager iTranDevicePolicyManager = this.f15048a;
        if (iTranDevicePolicyManager == null) {
            return null;
        }
        try {
            return iTranDevicePolicyManager.createProvisioningIntentFromNfcIntent(intent);
        } catch (RemoteException e10) {
            j7.b.a("createProvisioningIntentFromNfcIntent fail:", e10, f15047c);
            return null;
        }
    }

    @Override // lf.a
    public ComponentName j(Context context) {
        dc.e.f(f15047c, "getProfileOwnerWithContext");
        return o().getProfileOwnerWithContext(context);
    }

    public final TranDevicePolicyManager o() {
        if (this.f15049b == null) {
            this.f15049b = new TranDevicePolicyManager();
        }
        return this.f15049b;
    }

    public final /* synthetic */ Object p() throws RemoteException {
        ITranDevicePolicyManager iTranDevicePolicyManager = this.f15048a;
        if (iTranDevicePolicyManager != null) {
            return iTranDevicePolicyManager.getDeviceOwnerComponentOnAnyUser();
        }
        return null;
    }

    public final /* synthetic */ Object q() throws RemoteException {
        ITranDevicePolicyManager iTranDevicePolicyManager = this.f15048a;
        if (iTranDevicePolicyManager != null) {
            return iTranDevicePolicyManager.getProfileOwner();
        }
        return null;
    }

    public final /* synthetic */ Object r() throws RemoteException {
        ITranDevicePolicyManager iTranDevicePolicyManager = this.f15048a;
        if (iTranDevicePolicyManager != null) {
            return Boolean.valueOf(iTranDevicePolicyManager.isFinancedRestrictDevice());
        }
        return null;
    }

    public final /* synthetic */ Object s(ComponentName componentName, int i10) throws RemoteException {
        ITranDevicePolicyManager iTranDevicePolicyManager = this.f15048a;
        if (iTranDevicePolicyManager == null) {
            return null;
        }
        iTranDevicePolicyManager.setDualProfileEnabled(componentName, i10);
        return null;
    }

    @VisibleForTesting
    public void t(ITranDevicePolicyManager iTranDevicePolicyManager) {
        this.f15048a = iTranDevicePolicyManager;
    }
}
