package ic;

import android.app.NotificationChannel;
import android.content.ComponentName;
import android.net.Uri;
import android.os.RemoteException;
import com.transsion.hubsdk.TranServiceManager;
import com.transsion.hubsdk.app.ITranNotificationManager;
import com.transsion.hubsdk.app.ITranNotificationStatsCallback;
import com.transsion.hubsdk.app.TranNotificationRanking;
import com.transsion.hubsdk.content.pm.TranParceledListSlice;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class m1 implements bf.n {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f7837b = "m1";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ITranNotificationManager f7838a = ITranNotificationManager.Stub.asInterface(TranServiceManager.getServiceIBinder("notification"));

    public class a extends ITranNotificationStatsCallback.Stub {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public h9.b f7839a;

        public a(h9.b bVar) {
            this.f7839a = bVar;
        }

        public void a(List<TranNotificationRanking> list) {
            if (this.f7839a == null || list == null || list.size() <= 0) {
                return;
            }
            ArrayList arrayList = new ArrayList();
            for (TranNotificationRanking tranNotificationRanking : list) {
                arrayList.add(new com.transsion.hubsdk.api.app.TranNotificationRanking(tranNotificationRanking.getPackageName(), tranNotificationRanking.getUid(), tranNotificationRanking.isForceAppGroup()));
            }
            try {
                this.f7839a.a(arrayList);
            } catch (Exception e10) {
                p6.b.a("onTranNotiStatsNotify: ", e10, m1.f7837b);
            }
        }
    }

    @Override // bf.n
    public void A(String str, int i10, boolean z10) {
        ITranNotificationManager iTranNotificationManager = this.f7838a;
        if (iTranNotificationManager == null) {
            return;
        }
        try {
            iTranNotificationManager.setPlaySound(str, i10, z10);
        } catch (RemoteException e10) {
            dc.e.n(f7837b, "setPlaySound e = " + e10.getMessage());
        }
    }

    @Override // bf.n
    public int B(String str, int i10) {
        ITranNotificationManager iTranNotificationManager = this.f7838a;
        if (iTranNotificationManager == null) {
            return -1;
        }
        try {
            return iTranNotificationManager.shouldShowTranAppGroupTipForPackage(str, i10);
        } catch (RemoteException e10) {
            j7.b.a("shouldShowTranAppGroupTipForPackage e:", e10, f7837b);
            return -1;
        }
    }

    @Override // bf.n
    public NotificationChannel C(String str, int i10, String str2, String str3, boolean z10) {
        ITranNotificationManager iTranNotificationManager = this.f7838a;
        if (iTranNotificationManager == null) {
            return null;
        }
        try {
            return iTranNotificationManager.getNotificationChannelForPackage(str, i10, str2, str3, z10);
        } catch (RemoteException e10) {
            dc.e.n(f7837b, "getNotificationChannelForPackage e = " + e10.getMessage());
            return null;
        }
    }

    public final /* synthetic */ Object F(String str, int i10, boolean z10) throws RemoteException {
        ITranNotificationManager iTranNotificationManager = this.f7838a;
        if (iTranNotificationManager != null) {
            return new p9.h(iTranNotificationManager.getNotificationChannelsForPackage(str, i10, z10).getList());
        }
        return null;
    }

    @Override // bf.n
    public int a(String str, int i10, boolean z10) {
        ITranNotificationManager iTranNotificationManager = this.f7838a;
        if (iTranNotificationManager == null) {
            return 0;
        }
        try {
            return iTranNotificationManager.getNumNotificationChannelsForPackage(str, i10, z10);
        } catch (RemoteException e10) {
            j7.b.a("getNumNotificationChannelsForPackage e:", e10, f7837b);
            return 0;
        }
    }

    @Override // bf.n
    public void b(String str, int i10, NotificationChannel notificationChannel) {
        ITranNotificationManager iTranNotificationManager = this.f7838a;
        if (iTranNotificationManager == null) {
            return;
        }
        try {
            iTranNotificationManager.updateNotificationChannelForPackage(str, i10, notificationChannel);
        } catch (RemoteException e10) {
            j7.b.a("updateNotificationChannelForPackage e:", e10, f7837b);
        }
    }

    @Override // bf.n
    public void c(String str, int i10, boolean z10) {
        ITranNotificationManager iTranNotificationManager = this.f7838a;
        if (iTranNotificationManager == null) {
            return;
        }
        try {
            iTranNotificationManager.setNotificationsEnabledForPackage(str, i10, z10);
        } catch (RemoteException e10) {
            dc.e.n(f7837b, "setNotificationsEnabledForPackage e = " + e10.getMessage());
        }
    }

    @Override // bf.n
    public int d() {
        ITranNotificationManager iTranNotificationManager = this.f7838a;
        if (iTranNotificationManager == null) {
            return 0;
        }
        try {
            return iTranNotificationManager.getZenMode();
        } catch (RemoteException e10) {
            dc.e.n(f7837b, "getZenMode: e = " + e10.getMessage());
            return 0;
        }
    }

    @Override // bf.n
    public void e(String str, int i10, int i11) {
        ITranNotificationManager iTranNotificationManager = this.f7838a;
        if (iTranNotificationManager == null) {
            return;
        }
        try {
            iTranNotificationManager.setNotificationImportanceForPackage(str, i10, i11);
        } catch (RemoteException e10) {
            dc.e.n(f7837b, "setNotificationImportanceForPackage e = " + e10.getMessage());
        }
    }

    @Override // bf.n
    public p9.h f(String str, String str2, int i10) {
        ITranNotificationManager iTranNotificationManager = this.f7838a;
        if (iTranNotificationManager == null) {
            return null;
        }
        try {
            return new p9.h(iTranNotificationManager.getNotificationChannels(str, str2, i10).getList());
        } catch (RemoteException e10) {
            dc.e.n(f7837b, "getNotificationChannels e = " + e10.getMessage());
            return p9.h.a();
        }
    }

    @Override // bf.n
    public boolean g(String str, int i10) {
        ITranNotificationManager iTranNotificationManager = this.f7838a;
        if (iTranNotificationManager == null) {
            return false;
        }
        try {
            return iTranNotificationManager.canShowBadge(str, i10);
        } catch (RemoteException e10) {
            j7.b.a("canShowBadge e:", e10, f7837b);
            return false;
        }
    }

    @Override // bf.n
    public boolean h(String str, int i10) {
        ITranNotificationManager iTranNotificationManager = this.f7838a;
        if (iTranNotificationManager == null) {
            return false;
        }
        try {
            return iTranNotificationManager.areNotificationsEnabledForPackage(str, i10);
        } catch (RemoteException e10) {
            j7.b.a("areNotificationsEnabledForPackage e:", e10, f7837b);
            return false;
        }
    }

    @Override // bf.n
    public int i(String str, int i10) {
        ITranNotificationManager iTranNotificationManager = this.f7838a;
        if (iTranNotificationManager == null) {
            return 0;
        }
        try {
            return iTranNotificationManager.getNotificationImportanceForPackage(str, i10);
        } catch (RemoteException e10) {
            dc.e.n(f7837b, "getNotificationImportanceForPackage e = " + e10.getMessage());
            return 0;
        }
    }

    @Override // bf.n
    public boolean j(String str, int i10) {
        ITranNotificationManager iTranNotificationManager = this.f7838a;
        if (iTranNotificationManager == null) {
            return false;
        }
        try {
            return iTranNotificationManager.isImportanceLocked(str, i10);
        } catch (RemoteException e10) {
            j7.b.a("isImportanceLocked e:", e10, f7837b);
            return false;
        }
    }

    @Override // bf.n
    public p9.h k(String str, int i10, boolean z10) {
        ITranNotificationManager iTranNotificationManager = this.f7838a;
        if (iTranNotificationManager == null) {
            return null;
        }
        try {
            return new p9.h(iTranNotificationManager.getNotificationChannelGroupsForPackage(str, i10, z10).getList());
        } catch (RemoteException e10) {
            j7.b.a("getNotificationChannelGroupsForPackage e:", e10, f7837b);
            return null;
        }
    }

    @Override // bf.n
    public void l() {
        ITranNotificationManager iTranNotificationManager = this.f7838a;
        if (iTranNotificationManager != null) {
            try {
                iTranNotificationManager.unRegisterTranNotificationStatsCallback();
            } catch (RemoteException e10) {
                j7.b.a("unRegisterTranNotificationStatsCallback e:", e10, f7837b);
            }
        }
    }

    @Override // bf.n
    public void m(h9.b bVar) {
        if (this.f7838a == null || bVar == null) {
            return;
        }
        try {
            this.f7838a.registerTranNotificationStatsCallback(new a(bVar));
        } catch (RemoteException e10) {
            j7.b.a("registerTranNotificationStatsCallback e:", e10, f7837b);
        }
    }

    @Override // bf.n
    public boolean n(String str, int i10) {
        ITranNotificationManager iTranNotificationManager = this.f7838a;
        if (iTranNotificationManager == null) {
            return false;
        }
        try {
            return iTranNotificationManager.canPlayVibration(str, i10);
        } catch (RemoteException e10) {
            dc.e.n(f7837b, "canPlayVibration e = " + e10.getMessage());
            return false;
        }
    }

    @Override // bf.n
    public void o(String str, int i10, List list) {
        ITranNotificationManager iTranNotificationManager = this.f7838a;
        if (iTranNotificationManager != null) {
            try {
                iTranNotificationManager.createNotificationChannelsForPackage(str, i10, new TranParceledListSlice(list));
            } catch (RemoteException unused) {
                dc.e.c(f7837b, "createNotificationChannelsForPackage fail");
            }
        }
    }

    @Override // bf.n
    public void p(String str, int i10, boolean z10) {
        ITranNotificationManager iTranNotificationManager = this.f7838a;
        if (iTranNotificationManager == null) {
            return;
        }
        try {
            iTranNotificationManager.setShowBadge(str, i10, z10);
        } catch (RemoteException e10) {
            dc.e.n(f7837b, "setShowBadge e = " + e10.getMessage());
        }
    }

    @Override // bf.n
    public int q(String str, int i10) {
        ITranNotificationManager iTranNotificationManager = this.f7838a;
        if (iTranNotificationManager == null) {
            return -1;
        }
        try {
            return iTranNotificationManager.getTranNotificationAppGroupForPackage(str, i10);
        } catch (RemoteException e10) {
            j7.b.a("getTranNotificationAppGroupForPackage e:", e10, f7837b);
            return -1;
        }
    }

    @Override // bf.n
    public void r(String str, int i10) {
        ITranNotificationManager iTranNotificationManager = this.f7838a;
        if (iTranNotificationManager != null) {
            try {
                iTranNotificationManager.notifyTranAppGroupIgnoreForPackage(str, i10);
            } catch (RemoteException e10) {
                j7.b.a("notifyTranAppGroupIgnoreForPackage e:", e10, f7837b);
            }
        }
    }

    @Override // bf.n
    public boolean s(String str, int i10) {
        ITranNotificationManager iTranNotificationManager = this.f7838a;
        if (iTranNotificationManager == null) {
            return false;
        }
        try {
            return iTranNotificationManager.canPlaySound(str, i10);
        } catch (RemoteException e10) {
            dc.e.n(f7837b, "canPlaySound e = " + e10.getMessage());
            return false;
        }
    }

    @Override // bf.n
    public boolean t(String str, int i10) {
        ITranNotificationManager iTranNotificationManager = this.f7838a;
        if (iTranNotificationManager == null) {
            return false;
        }
        try {
            return iTranNotificationManager.onlyHasDefaultChannel(str, i10);
        } catch (RemoteException e10) {
            dc.e.n(f7837b, "onlyHasDefaultChannel e = " + e10.getMessage());
            return false;
        }
    }

    @Override // bf.n
    public void u(String str, int i10) {
        ITranNotificationManager iTranNotificationManager = this.f7838a;
        if (iTranNotificationManager != null) {
            try {
                iTranNotificationManager.notifyTranAppGroupTipShowForPackage(str, i10);
            } catch (RemoteException e10) {
                j7.b.a("notifyTranAppGroupTipShowForPackage e:", e10, f7837b);
            }
        }
    }

    @Override // bf.n
    public p9.h<NotificationChannel> v(final String str, final int i10, final boolean z10) {
        return (p9.h) new zb.f().c(new zb.f.b() { // from class: ic.l1
            @Override // zb.f.b
            public final Object run() {
                return this.f7829a.F(str, i10, z10);
            }
        }, "notification");
    }

    @Override // bf.n
    public void w(String str, int i10, boolean z10) {
        ITranNotificationManager iTranNotificationManager = this.f7838a;
        if (iTranNotificationManager == null) {
            return;
        }
        try {
            iTranNotificationManager.setPlayVibration(str, i10, z10);
        } catch (RemoteException e10) {
            dc.e.n(f7837b, "setPlayVibration e = " + e10.getMessage());
        }
    }

    @Override // bf.n
    public void x(String str, int i10, int i11) {
        ITranNotificationManager iTranNotificationManager = this.f7838a;
        if (iTranNotificationManager != null) {
            try {
                iTranNotificationManager.setTranNotificationAppGroupForPackage(str, i10, i11);
            } catch (RemoteException e10) {
                j7.b.a("setTranNotificationAppGroupForPackage e:", e10, f7837b);
            }
        }
    }

    @Override // bf.n
    public void y(int i10, Uri uri, String str) {
        ITranNotificationManager iTranNotificationManager = this.f7838a;
        if (iTranNotificationManager == null) {
            return;
        }
        try {
            iTranNotificationManager.setZenMode(i10, uri, str);
        } catch (RemoteException e10) {
            dc.e.n(f7837b, "setZenMode: e = " + e10.getMessage());
        }
    }

    @Override // bf.n
    public void z(ComponentName componentName, boolean z10) {
        ITranNotificationManager iTranNotificationManager = this.f7838a;
        if (iTranNotificationManager == null) {
            return;
        }
        try {
            iTranNotificationManager.setNotificationListenerAccessGranted(componentName, z10, true);
        } catch (RemoteException e10) {
            j7.b.a("setNotificationListenerAccessGranted e:", e10, f7837b);
        }
    }
}
