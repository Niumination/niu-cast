package je;

import android.os.RemoteException;
import android.telephony.SubscriptionInfo;
import com.android.internal.annotations.VisibleForTesting;
import com.transsion.hubsdk.TranServiceManager;
import com.transsion.hubsdk.telephony.ITranSubscriptionManager;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class l implements dh.e {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f8692b = "l";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ITranSubscriptionManager f8693a = ITranSubscriptionManager.Stub.asInterface(TranServiceManager.getServiceIBinder("Subscription_manager"));

    @Override // dh.e
    public int a(int i10) {
        try {
            ITranSubscriptionManager iTranSubscriptionManager = this.f8693a;
            if (iTranSubscriptionManager != null) {
                return iTranSubscriptionManager.getSlotIndex(i10);
            }
            return 0;
        } catch (RemoteException e10) {
            e10.printStackTrace();
            return 0;
        }
    }

    @Override // dh.e
    public void b(int i10) {
        try {
            ITranSubscriptionManager iTranSubscriptionManager = this.f8693a;
            if (iTranSubscriptionManager != null) {
                iTranSubscriptionManager.setDefaultDataSubId(i10);
            }
        } catch (RemoteException e10) {
            e10.printStackTrace();
        }
    }

    @Override // dh.e
    public int[] c() {
        ITranSubscriptionManager iTranSubscriptionManager = this.f8693a;
        if (iTranSubscriptionManager == null) {
            return null;
        }
        try {
            return iTranSubscriptionManager.getActiveSubscriptionIdList();
        } catch (RemoteException e10) {
            j7.b.a("getActiveSubscriptionIdList fail ", e10, f8692b);
            return null;
        }
    }

    @Override // dh.e
    public void d(final int i10) {
        new zb.f().c(new zb.f.b() { // from class: je.k
            @Override // zb.f.b
            public final Object run() {
                return this.f8690a.s(i10);
            }
        }, "Subscription_manager");
        dc.e.f(f8692b, "setDefaultSmsSubId");
    }

    @Override // dh.e
    public SubscriptionInfo e() {
        SubscriptionInfo subscriptionInfo = (SubscriptionInfo) new zb.f().c(new zb.f.b() { // from class: je.h
            @Override // zb.f.b
            public final Object run() {
                return this.f8685a.p();
            }
        }, "Subscription_manager");
        dc.e.a(f8692b, "getDefaultDataSubscriptionInfo subscriptionInfo :" + subscriptionInfo);
        return subscriptionInfo;
    }

    @Override // dh.e
    public int[] f(int i10) {
        try {
            ITranSubscriptionManager iTranSubscriptionManager = this.f8693a;
            if (iTranSubscriptionManager != null) {
                return iTranSubscriptionManager.getSubId(i10);
            }
        } catch (RemoteException e10) {
            e10.printStackTrace();
        }
        return new int[]{1};
    }

    @Override // dh.e
    public boolean g(final int i10) {
        boolean zBooleanValue = ((Boolean) new zb.f().c(new zb.f.b() { // from class: je.i
            @Override // zb.f.b
            public final Object run() {
                return this.f8686a.r(i10);
            }
        }, "Subscription_manager")).booleanValue();
        dc.e.f(f8692b, "isValidPhoneId");
        return zBooleanValue;
    }

    @Override // dh.e
    public List<SubscriptionInfo> h() {
        try {
            ITranSubscriptionManager iTranSubscriptionManager = this.f8693a;
            if (iTranSubscriptionManager != null) {
                return iTranSubscriptionManager.getActiveSubscriptionInfoList();
            }
            return null;
        } catch (RemoteException e10) {
            j7.b.a("getActiveSubscriptionInfoList fail ", e10, f8692b);
            return null;
        }
    }

    @Override // dh.e
    public int i() {
        try {
            ITranSubscriptionManager iTranSubscriptionManager = this.f8693a;
            if (iTranSubscriptionManager != null) {
                return iTranSubscriptionManager.getActiveSubscriptionInfoCount();
            }
            return 0;
        } catch (RemoteException e10) {
            j7.b.a("getActiveSubscriptionInfoCount fail ", e10, f8692b);
            return 0;
        }
    }

    @Override // dh.e
    public void j(int i10, int i11) {
        try {
            ITranSubscriptionManager iTranSubscriptionManager = this.f8693a;
            if (iTranSubscriptionManager != null) {
                iTranSubscriptionManager.setDefaultDataSubIdWithReason(i10, i11);
            }
        } catch (RemoteException e10) {
            e10.printStackTrace();
        }
    }

    @Override // dh.e
    public int k(final int i10) {
        int iIntValue = ((Integer) new zb.f().c(new zb.f.b() { // from class: je.j
            @Override // zb.f.b
            public final Object run() {
                return this.f8688a.q(i10);
            }
        }, "Subscription_manager")).intValue();
        dc.e.f(f8692b, "getPhoneId");
        return iIntValue;
    }

    public final /* synthetic */ Object p() throws RemoteException {
        ITranSubscriptionManager iTranSubscriptionManager = this.f8693a;
        if (iTranSubscriptionManager != null) {
            return iTranSubscriptionManager.getDefaultDataSubscriptionInfo();
        }
        return null;
    }

    public final /* synthetic */ Object q(int i10) throws RemoteException {
        ITranSubscriptionManager iTranSubscriptionManager = this.f8693a;
        if (iTranSubscriptionManager != null) {
            return Integer.valueOf(iTranSubscriptionManager.getPhoneId(i10));
        }
        return -1;
    }

    public final /* synthetic */ Object r(int i10) throws RemoteException {
        ITranSubscriptionManager iTranSubscriptionManager = this.f8693a;
        return iTranSubscriptionManager != null ? Boolean.valueOf(iTranSubscriptionManager.isValidPhoneId(i10)) : Boolean.FALSE;
    }

    public final /* synthetic */ Object s(int i10) throws RemoteException {
        ITranSubscriptionManager iTranSubscriptionManager = this.f8693a;
        if (iTranSubscriptionManager == null) {
            return null;
        }
        iTranSubscriptionManager.setDefaultSmsSubId(i10);
        return null;
    }

    @VisibleForTesting
    public void t(ITranSubscriptionManager iTranSubscriptionManager) {
        this.f8693a = iTranSubscriptionManager;
    }
}
