package qd;

import android.os.RemoteException;
import com.android.internal.annotations.VisibleForTesting;
import com.transsion.hubsdk.TranServiceManager;
import com.transsion.hubsdk.net.ITranNetworkPolicyManager;
import ic.n0;

/* JADX INFO: loaded from: classes2.dex */
public class j implements kg.c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f13983b = "j";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ITranNetworkPolicyManager f13984a = ITranNetworkPolicyManager.Stub.asInterface(TranServiceManager.getServiceIBinder("netpolicy"));

    @Override // kg.c
    public int a(int i10) {
        try {
            ITranNetworkPolicyManager iTranNetworkPolicyManager = this.f13984a;
            if (iTranNetworkPolicyManager != null) {
                return iTranNetworkPolicyManager.getUidPolicy(i10);
            }
            return 0;
        } catch (RemoteException e10) {
            j7.b.a("getUidPolicy failed: ", e10, f13983b);
            return 0;
        }
    }

    @Override // kg.c
    public void b(final boolean z10) {
        new zb.f().a(new zb.f.a() { // from class: qd.h
            @Override // zb.f.a
            public final Object run() {
                return this.f13980a.h(z10);
            }
        }, "netpolicy");
        dc.e.f(f13983b, "setRestrictBackground");
    }

    @Override // kg.c
    public boolean c() {
        boolean zBooleanValue = ((Boolean) new zb.f().a(new zb.f.a() { // from class: qd.i
            @Override // zb.f.a
            public final Object run() {
                return this.f13982a.g();
            }
        }, "netpolicy")).booleanValue();
        n0.a("getRestrictBackground result: ", zBooleanValue, f13983b);
        return zBooleanValue;
    }

    @Override // kg.c
    public void d(int i10, int i11) {
        try {
            ITranNetworkPolicyManager iTranNetworkPolicyManager = this.f13984a;
            if (iTranNetworkPolicyManager != null) {
                iTranNetworkPolicyManager.setUidPolicy(i10, i11);
            }
        } catch (RemoteException e10) {
            j7.b.a("setUidPolicy failed: ", e10, f13983b);
        }
    }

    public final /* synthetic */ Object g() throws RemoteException {
        ITranNetworkPolicyManager iTranNetworkPolicyManager = this.f13984a;
        return iTranNetworkPolicyManager != null ? Boolean.valueOf(iTranNetworkPolicyManager.getRestrictBackground()) : Boolean.FALSE;
    }

    public final /* synthetic */ Object h(boolean z10) throws RemoteException {
        ITranNetworkPolicyManager iTranNetworkPolicyManager = this.f13984a;
        if (iTranNetworkPolicyManager == null) {
            return null;
        }
        iTranNetworkPolicyManager.setRestrictBackground(z10);
        return null;
    }

    @VisibleForTesting
    public void i(ITranNetworkPolicyManager iTranNetworkPolicyManager) {
        this.f13984a = iTranNetworkPolicyManager;
    }
}
