package p6;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.ComponentName;
import android.content.pm.ParceledListSlice;
import android.net.Uri;
import android.os.IBinder;
import android.os.ServiceManager;
import java.lang.reflect.Method;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class r implements bf.n {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f13012b = "r";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static Method f13013c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static Object f13014d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public NotificationManager f13015a;

    static {
        Method methodG = cc.a.g(NotificationManager.class, "getService", new Class[0]);
        f13013c = methodG;
        f13014d = cc.a.j(methodG, null, new Object[0]);
    }

    public r() {
        if (this.f13015a == null) {
            this.f13015a = (NotificationManager) bc.a.a().getSystemService("notification");
        }
    }

    @Override // bf.n
    public void A(String str, int i10, boolean z10) {
        cc.a.j(cc.a.g(f13014d.getClass(), "setPlaySound", String.class, Integer.TYPE, Boolean.TYPE), f13014d, str, Integer.valueOf(i10), Boolean.valueOf(z10));
    }

    @Override // bf.n
    public int B(String str, int i10) {
        dc.e.c(f13012b, "shouldShowTranAppGroupTipForPackage not supported in aosp version.");
        return -1;
    }

    @Override // bf.n
    public NotificationChannel C(String str, int i10, String str2, String str3, boolean z10) {
        Object objJ = cc.a.j(cc.a.g(f13014d.getClass(), "getNotificationChannelForPackage", String.class, Integer.TYPE, String.class, String.class, Boolean.TYPE), f13014d, str, Integer.valueOf(i10), str2, str3, Boolean.valueOf(z10));
        if (objJ instanceof NotificationChannel) {
            return (NotificationChannel) objJ;
        }
        return null;
    }

    @Override // bf.n
    public int a(String str, int i10, boolean z10) {
        Object objJ = cc.a.j(cc.a.g(f13014d.getClass(), "getNumNotificationChannelsForPackage", String.class, Integer.TYPE, Boolean.TYPE), f13014d, str, Integer.valueOf(i10), Boolean.valueOf(z10));
        if (objJ instanceof Integer) {
            return ((Integer) objJ).intValue();
        }
        return -1;
    }

    @Override // bf.n
    public void b(String str, int i10, NotificationChannel notificationChannel) {
        Object objJ = cc.a.j(cc.a.g(NotificationManager.class, "getService", new Class[0]), null, new Object[0]);
        if (objJ != null) {
            cc.a.j(cc.a.g(objJ.getClass(), "updateNotificationChannelForPackage", String.class, Integer.TYPE, NotificationChannel.class), objJ, str, Integer.valueOf(i10), notificationChannel);
        }
    }

    @Override // bf.n
    public void c(String str, int i10, boolean z10) {
        cc.a.j(cc.a.g(f13014d.getClass(), "setNotificationsEnabledForPackage", String.class, Integer.TYPE, Boolean.TYPE), f13014d, str, Integer.valueOf(i10), Boolean.valueOf(z10));
    }

    @Override // bf.n
    public int d() {
        Object objJ = cc.a.j(cc.a.g(this.f13015a.getClass(), "getZenMode", new Class[0]), this.f13015a, new Object[0]);
        if (objJ instanceof Integer) {
            return ((Integer) objJ).intValue();
        }
        return 0;
    }

    @Override // bf.n
    public void e(String str, int i10, int i11) {
        Method methodG;
        Object objJ;
        Class clsA = cc.a.a("com.transsion.app.NotificationManager");
        if (clsA == null || (methodG = cc.a.g(clsA, "instance", new Class[0])) == null || (objJ = cc.a.j(methodG, null, new Object[0])) == null) {
            return;
        }
        Class<?> cls = objJ.getClass();
        Class cls2 = Integer.TYPE;
        Method methodG2 = cc.a.g(cls, "setNotificationImportanceForPackage", String.class, cls2, cls2);
        if (methodG2 != null) {
            cc.a.j(methodG2, objJ, str, Integer.valueOf(i10), Integer.valueOf(i11));
        }
    }

    @Override // bf.n
    public p9.h f(String str, String str2, int i10) {
        Object objJ = cc.a.j(cc.a.g(f13014d.getClass(), "getNotificationChannels", String.class, String.class, Integer.TYPE), f13014d, str, str2, Integer.valueOf(i10));
        if (objJ == null) {
            return null;
        }
        List list = (List) cc.a.j(cc.a.g(objJ.getClass(), "getList", new Class[0]), objJ, new Object[0]);
        String str3 = f13012b;
        dc.e.a(str3, "getNotificationChannels: channelList = " + list);
        p9.h hVar = new p9.h(list);
        dc.e.a(str3, "getNotificationChannels: tranParceledListSlice = " + hVar);
        return hVar;
    }

    @Override // bf.n
    public boolean g(String str, int i10) {
        Object objJ = cc.a.j(cc.a.g(f13014d.getClass(), "canShowBadge", String.class, Integer.TYPE), f13014d, str, Integer.valueOf(i10));
        if (objJ instanceof Boolean) {
            return ((Boolean) objJ).booleanValue();
        }
        return false;
    }

    @Override // bf.n
    public boolean h(String str, int i10) {
        Object objJ = cc.a.j(cc.a.g(f13014d.getClass(), "areNotificationsEnabledForPackage", String.class, Integer.TYPE), f13014d, str, Integer.valueOf(i10));
        if (objJ instanceof Boolean) {
            return ((Boolean) objJ).booleanValue();
        }
        return false;
    }

    @Override // bf.n
    public int i(String str, int i10) {
        Method methodG;
        Object objJ;
        Method methodG2;
        Class clsA = cc.a.a("com.transsion.app.NotificationManager");
        if (clsA == null || (methodG = cc.a.g(clsA, "instance", new Class[0])) == null || (objJ = cc.a.j(methodG, null, new Object[0])) == null || (methodG2 = cc.a.g(objJ.getClass(), "getNotificationImportanceForPackage", String.class, Integer.TYPE)) == null) {
            return -1;
        }
        return ((Integer) cc.a.j(methodG2, objJ, str, Integer.valueOf(i10))).intValue();
    }

    @Override // bf.n
    public boolean j(String str, int i10) {
        if (fc.a.d()) {
            dc.e.c(f13012b, "isImportanceLocked not supported in low version.");
        } else {
            Object objJ = cc.a.j(cc.a.g(f13014d.getClass(), "isImportanceLocked", String.class, Integer.TYPE), f13014d, str, Integer.valueOf(i10));
            if (objJ instanceof Boolean) {
                return ((Boolean) objJ).booleanValue();
            }
        }
        return false;
    }

    @Override // bf.n
    public p9.h k(String str, int i10, boolean z10) {
        Object objJ = cc.a.j(cc.a.g(f13014d.getClass(), "getNotificationChannelGroupsForPackage", String.class, Integer.TYPE, Boolean.TYPE), f13014d, str, Integer.valueOf(i10), Boolean.valueOf(z10));
        if (objJ != null) {
            return new p9.h((List) cc.a.j(cc.a.g(objJ.getClass(), "getList", new Class[0]), objJ, new Object[0]));
        }
        return null;
    }

    @Override // bf.n
    public void l() {
        dc.e.c(f13012b, "unRegisterTranNotificationStatsCallback not supported in aosp version.");
    }

    @Override // bf.n
    public void m(h9.b bVar) {
        dc.e.c(f13012b, "registerTranNotificationStatsCallback not supported in aosp version.");
    }

    @Override // bf.n
    public boolean n(String str, int i10) {
        Object objJ = cc.a.j(cc.a.g(f13014d.getClass(), "canPlayVibration", String.class, Integer.TYPE), f13014d, str, Integer.valueOf(i10));
        if (objJ instanceof Boolean) {
            return ((Boolean) objJ).booleanValue();
        }
        return false;
    }

    @Override // bf.n
    public void o(String str, int i10, List list) {
        try {
            IBinder service = ServiceManager.getService("notification");
            Class clsA = cc.a.a("android.app.INotificationManager");
            Object objJ = cc.a.j(cc.a.g(cc.a.a("android.app.INotificationManager$Stub"), "asInterface", IBinder.class), null, service);
            cc.a.j(cc.a.g(clsA, "createNotificationChannelsForPackage", String.class, Integer.TYPE, ParceledListSlice.class), objJ, str, Integer.valueOf(i10), new ParceledListSlice(list));
        } catch (Exception unused) {
            dc.e.c("TranAospNotificationManager", "createNotificationChannelsForPackage fail");
        }
    }

    @Override // bf.n
    public void p(String str, int i10, boolean z10) {
        cc.a.j(cc.a.g(f13014d.getClass(), "setShowBadge", String.class, Integer.TYPE, Boolean.TYPE), f13014d, str, Integer.valueOf(i10), Boolean.valueOf(z10));
    }

    @Override // bf.n
    public int q(String str, int i10) {
        dc.e.c(f13012b, "getTranNotificationAppGroupForPackage not supported in aosp version.");
        return -1;
    }

    @Override // bf.n
    public void r(String str, int i10) {
        dc.e.c(f13012b, "notifyTranAppGroupIgnoreForPackage not supported in aosp version.");
    }

    @Override // bf.n
    public boolean s(String str, int i10) {
        Object objJ = cc.a.j(cc.a.g(f13014d.getClass(), "canPlaySound", String.class, Integer.TYPE), f13014d, str, Integer.valueOf(i10));
        if (objJ instanceof Boolean) {
            return ((Boolean) objJ).booleanValue();
        }
        return false;
    }

    @Override // bf.n
    public boolean t(String str, int i10) {
        Object objJ = cc.a.j(cc.a.g(f13014d.getClass(), "onlyHasDefaultChannel", String.class, Integer.TYPE), f13014d, str, Integer.valueOf(i10));
        if (objJ instanceof Boolean) {
            return ((Boolean) objJ).booleanValue();
        }
        return false;
    }

    @Override // bf.n
    public void u(String str, int i10) {
        dc.e.c(f13012b, "notifyTranAppGroupTipShowForPackage not supported in aosp version.");
    }

    @Override // bf.n
    public p9.h<NotificationChannel> v(String str, int i10, boolean z10) {
        Object objJ;
        Method methodG = cc.a.g(f13014d.getClass(), "getNotificationChannelsForPackage", String.class, Integer.TYPE, Boolean.TYPE);
        if (methodG == null || (objJ = cc.a.j(methodG, f13014d, str, Integer.valueOf(i10), Boolean.valueOf(z10))) == null) {
            return null;
        }
        List list = (List) cc.a.j(cc.a.g(objJ.getClass(), "getList", new Class[0]), objJ, new Object[0]);
        String str2 = f13012b;
        dc.e.a(str2, "getNotificationChannelsForPackage: channelList = " + list);
        p9.h<NotificationChannel> hVar = new p9.h<>(list);
        dc.e.a(str2, "getNotificationChannels: tranParceledListSlice = " + hVar);
        return hVar;
    }

    @Override // bf.n
    public void w(String str, int i10, boolean z10) {
        cc.a.j(cc.a.g(f13014d.getClass(), "setPlayVibration", String.class, Integer.TYPE, Boolean.TYPE), f13014d, str, Integer.valueOf(i10), Boolean.valueOf(z10));
    }

    @Override // bf.n
    public void x(String str, int i10, int i11) {
        dc.e.c(f13012b, "setTranNotificationAppGroupForPackage not supported in aosp version.");
    }

    @Override // bf.n
    public void y(int i10, Uri uri, String str) {
        if (fc.a.g()) {
            cc.a.j(cc.a.g(this.f13015a.getClass(), "setZenMode", Integer.TYPE, Uri.class, String.class, Boolean.TYPE), this.f13015a, Integer.valueOf(i10), uri, str, Boolean.FALSE);
        } else {
            cc.a.j(cc.a.g(this.f13015a.getClass(), "setZenMode", Integer.TYPE, Uri.class, String.class), this.f13015a, Integer.valueOf(i10), uri, str);
        }
    }

    @Override // bf.n
    public void z(ComponentName componentName, boolean z10) {
        Class<?> cls = this.f13015a.getClass();
        Class cls2 = Boolean.TYPE;
        cc.a.j(cc.a.g(cls, "setNotificationListenerAccessGranted", ComponentName.class, cls2, cls2), this.f13015a, componentName, Boolean.valueOf(z10), Boolean.TRUE);
    }
}
