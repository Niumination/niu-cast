package qc;

import android.content.ComponentName;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.ResolveInfo;
import android.os.RemoteException;
import androidx.core.app.NotificationManagerCompat;
import com.android.internal.annotations.VisibleForTesting;
import com.transsion.hubsdk.TranServiceManager;
import com.transsion.hubsdk.content.pm.ITranPackageDeleteObserver;
import com.transsion.hubsdk.content.pm.ITranPackageManager;
import com.transsion.hubsdk.content.pm.TranParceledListSlice;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class w implements jf.e {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f13954b = "w";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ITranPackageManager f13955a = ITranPackageManager.Stub.asInterface(TranServiceManager.getServiceIBinder("package"));

    public class a extends ITranPackageDeleteObserver.Stub {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public x6.f.a f13956a;

        public a(x6.f.a aVar) {
            this.f13956a = aVar;
        }

        public void a(String str, int i10) throws RemoteException {
            x6.f.a aVar = this.f13956a;
            if (aVar != null) {
                aVar.a(str, i10);
            }
        }
    }

    @Override // jf.e
    public int A(String str, String str2) {
        try {
            ITranPackageManager iTranPackageManager = this.f13955a;
            return iTranPackageManager != null ? iTranPackageManager.reinstall(str, str2) : NotificationManagerCompat.IMPORTANCE_UNSPECIFIED;
        } catch (RemoteException e10) {
            dc.e.d(f13954b, " reinstall exception: ", e10);
            return NotificationManagerCompat.IMPORTANCE_UNSPECIFIED;
        }
    }

    @Override // jf.e
    public void B(final ComponentName componentName, final int i10, final int i11, final int i12) {
        new zb.f().c(new zb.f.b() { // from class: qc.o
            @Override // zb.f.b
            public final Object run() {
                return this.f13933a.r0(componentName, i10, i11, i12);
            }
        }, "package");
    }

    @Override // jf.e
    public boolean C(String str, int i10) {
        try {
            return this.f13955a.setDefaultMusicPackageNameAsUser(str, i10);
        } catch (RemoteException e10) {
            dc.e.o(f13954b, " setDefaultMusicPackageNameAsUser exception: ", e10);
            return false;
        }
    }

    @Override // jf.e
    public void D() {
        new zb.f().c(new zb.f.b() { // from class: qc.h
            @Override // zb.f.b
            public final Object run() {
                return this.f13913a.d0();
            }
        }, "package");
    }

    @Override // jf.e
    public List<ResolveInfo> E(Intent intent, int i10, int i11) {
        ITranPackageManager iTranPackageManager = this.f13955a;
        if (iTranPackageManager == null) {
            return null;
        }
        try {
            return iTranPackageManager.queryIntentServicesAsUserExt(intent, i10, i11).getList();
        } catch (RemoteException e10) {
            e10.printStackTrace();
            j7.b.a("queryIntentServicesAsUser fail:", e10, f13954b);
            return null;
        }
    }

    @Override // jf.e
    public void F(String str, x6.f.a aVar, int i10) {
        try {
            this.f13955a.deletePackageAsOOBE(str, new a(aVar), i10);
        } catch (RemoteException e10) {
            dc.e.n(f13954b, "deletePackageAsOOBE " + e10);
        }
    }

    @Override // jf.e
    public void G() {
        new zb.f().c(new zb.f.b() { // from class: qc.u
            @Override // zb.f.b
            public final Object run() {
                return this.f13950a.c0();
            }
        }, "package");
    }

    @Override // jf.e
    public boolean H(String str) {
        try {
            ITranPackageManager iTranPackageManager = this.f13955a;
            if (iTranPackageManager != null) {
                return iTranPackageManager.isRemovableSysApp(str);
            }
            return false;
        } catch (RemoteException e10) {
            dc.e.d(f13954b, " isRemovableSysApp exception: ", e10);
            return false;
        }
    }

    @Override // jf.e
    public void I(String str, int i10, int i11) {
        try {
            this.f13955a.setApplicationEnabledSettingForPM(str, i10, i11);
        } catch (RemoteException e10) {
            e10.printStackTrace();
        }
    }

    @Override // jf.e
    public void J() {
        new zb.f().c(new zb.f.b() { // from class: qc.f
            @Override // zb.f.b
            public final Object run() {
                return this.f13909a.e0();
            }
        }, "package");
    }

    @Override // jf.e
    public List<ApplicationInfo> a(final int i10, final int i11) {
        List<ApplicationInfo> list = (List) new zb.f().c(new zb.f.b() { // from class: qc.v
            @Override // zb.f.b
            public final Object run() {
                return this.f13951a.k0(i10, i11);
            }
        }, "package");
        dc.e.f(f13954b, "getInstalledApplicationsAsUser applicationInfos:" + list);
        return list;
    }

    @Override // jf.e
    public String b(int i10) {
        try {
            return this.f13955a.getDefaultMusicPackageNameAsUser(i10);
        } catch (RemoteException e10) {
            dc.e.o(f13954b, " getDefaultMusicPackageNameAsUser exception: ", e10);
            return "";
        }
    }

    @Override // jf.e
    public String c(final int i10) {
        return (String) new zb.f().c(new zb.f.b() { // from class: qc.l
            @Override // zb.f.b
            public final Object run() {
                return this.f13922a.i0(i10);
            }
        }, "package");
    }

    public final /* synthetic */ Object c0() throws RemoteException {
        try {
            this.f13955a.checkDefaultCalendar();
            return null;
        } catch (RemoteException e10) {
            dc.e.d(f13954b, " checkDefaultCalendar exception: ", e10);
            return null;
        }
    }

    @Override // jf.e
    public boolean d(final String str, final int i10) {
        return ((Boolean) new zb.f().c(new zb.f.b() { // from class: qc.g
            @Override // zb.f.b
            public final Object run() {
                return this.f13910a.s0(str, i10);
            }
        }, "package")).booleanValue();
    }

    public final /* synthetic */ Object d0() throws RemoteException {
        try {
            this.f13955a.checkDefaultGaller();
            return null;
        } catch (RemoteException e10) {
            dc.e.d(f13954b, " checkDefaultGaller exception: ", e10);
            return null;
        }
    }

    @Override // jf.e
    public String e(int i10) {
        try {
            return this.f13955a.getDefaultGallerPackageNameAsUser(i10);
        } catch (RemoteException e10) {
            dc.e.o(f13954b, " getDefaultGallerPackageNameAsUser exception: ", e10);
            return "";
        }
    }

    public final /* synthetic */ Object e0() throws RemoteException {
        try {
            this.f13955a.checkDefaultMusic();
            return null;
        } catch (RemoteException e10) {
            dc.e.d(f13954b, " checkDefaultMusic exception: ", e10);
            return null;
        }
    }

    @Override // jf.e
    public PackageInfo f(final String str, final int i10, final int i11) {
        PackageInfo packageInfo = (PackageInfo) new zb.f().c(new zb.f.b() { // from class: qc.n
            @Override // zb.f.b
            public final Object run() {
                return this.f13929a.m0(str, i10, i11);
            }
        }, "package");
        dc.e.f(f13954b, "getPackageInfo mPackageInfo:" + packageInfo);
        return packageInfo;
    }

    public final /* synthetic */ Object f0(String str, x6.f.a aVar, int i10, int i11) throws RemoteException {
        ITranPackageManager iTranPackageManager = this.f13955a;
        if (iTranPackageManager == null) {
            return null;
        }
        iTranPackageManager.deletePackageAsUser(str, new a(aVar), i10, i11);
        return null;
    }

    @Override // jf.e
    public void g(final ComponentName componentName, final int i10) {
        new zb.f().c(new zb.f.b() { // from class: qc.e
            @Override // zb.f.b
            public final Object run() {
                return this.f13906a.t0(componentName, i10);
            }
        }, "package");
        dc.e.f(f13954b, "setHomeActivity");
    }

    public final /* synthetic */ Object g0() throws RemoteException {
        ITranPackageManager iTranPackageManager = this.f13955a;
        if (iTranPackageManager != null) {
            return iTranPackageManager.getAllHiddenApps();
        }
        return null;
    }

    @Override // jf.e
    public void h(IntentFilter intentFilter, int i10, ComponentName[] componentNameArr, ComponentName componentName, int i11) {
        ITranPackageManager iTranPackageManager = this.f13955a;
        if (iTranPackageManager != null) {
            try {
                iTranPackageManager.replacePreferredActivity(intentFilter, i10, componentNameArr, componentName, i11);
            } catch (RemoteException e10) {
                j7.b.a("replacePreferredActivity fail:", e10, f13954b);
            }
        }
    }

    public final /* synthetic */ Object h0(String str, int i10) throws RemoteException {
        try {
            return Integer.valueOf(this.f13955a.getApplicationNotifyScreenOn(str, i10));
        } catch (RemoteException e10) {
            dc.e.d(f13954b, " getApplicationNotifyScreenOn exception: ", e10);
            return -1;
        }
    }

    @Override // jf.e
    public void i(final String str, final x6.f.a aVar, final int i10, final int i11) {
        new zb.f().c(new zb.f.b() { // from class: qc.m
            @Override // zb.f.b
            public final Object run() {
                return this.f13924a.f0(str, aVar, i10, i11);
            }
        }, "package");
    }

    public final /* synthetic */ Object i0(int i10) throws RemoteException {
        try {
            return this.f13955a.getDefaulCalendarPackageNameAsUser(i10);
        } catch (RemoteException e10) {
            dc.e.d(f13954b, " getDefaulCalendarPackageNameAsUser exception: ", e10);
            return "";
        }
    }

    @Override // jf.e
    public int j(final String str, final int i10) {
        int iIntValue = ((Integer) new zb.f().c(new zb.f.b() { // from class: qc.p
            @Override // zb.f.b
            public final Object run() {
                return this.f13938a.o0(str, i10);
            }
        }, "package")).intValue();
        dc.e.f(f13954b, "installExistingPackageAsUser result:" + iIntValue);
        return iIntValue;
    }

    public final /* synthetic */ Object j0(List list) throws RemoteException {
        ITranPackageManager iTranPackageManager = this.f13955a;
        if (iTranPackageManager != null) {
            return iTranPackageManager.getHomeActivities(list);
        }
        return null;
    }

    @Override // jf.e
    public List<PackageInfo> k(int i10, int i11) {
        ITranPackageManager iTranPackageManager = this.f13955a;
        if (iTranPackageManager == null) {
            return null;
        }
        try {
            return iTranPackageManager.getInstalledPackagesAsUserExt(i10, i11).getList();
        } catch (RemoteException e10) {
            j7.b.a("getInstalledPackagesAsUser fail:", e10, f13954b);
            return null;
        }
    }

    public final /* synthetic */ Object k0(int i10, int i11) throws RemoteException {
        ITranPackageManager iTranPackageManager = this.f13955a;
        if (iTranPackageManager != null) {
            return iTranPackageManager.getInstalledApplicationsAsUserExt(i10, i11).getList();
        }
        return null;
    }

    @Override // jf.e
    public List<ApplicationInfo> l(final int i10) {
        List<ApplicationInfo> list = (List) new zb.f().c(new zb.f.b() { // from class: qc.k
            @Override // zb.f.b
            public final Object run() {
                return this.f13920a.l0(i10);
            }
        }, "package");
        dc.e.f(f13954b, "getInstalledApplicationsInDualSpace applicationInfos: " + list);
        return list;
    }

    public final /* synthetic */ Object l0(int i10) throws RemoteException {
        TranParceledListSlice installedApplicationsInDualSpace;
        ITranPackageManager iTranPackageManager = this.f13955a;
        if (iTranPackageManager == null || (installedApplicationsInDualSpace = iTranPackageManager.getInstalledApplicationsInDualSpace(i10)) == null) {
            return null;
        }
        return installedApplicationsInDualSpace.getList();
    }

    @Override // jf.e
    public String m() {
        String str = (String) new zb.f().c(new zb.f.b() { // from class: qc.t
            @Override // zb.f.b
            public final Object run() {
                return this.f13949a.n0();
            }
        }, "package");
        dc.e.f(f13954b, "getPermissionControllerPackageName packageName:" + str);
        return str;
    }

    public final /* synthetic */ Object m0(String str, int i10, int i11) throws RemoteException {
        ITranPackageManager iTranPackageManager = this.f13955a;
        if (iTranPackageManager != null) {
            return iTranPackageManager.getPackageInfo(str, i10, i11);
        }
        return null;
    }

    @Override // jf.e
    public PackageInfo n(String str, int i10, int i11) {
        try {
            return this.f13955a.getPackageInfoAsUser(str, i10, i11);
        } catch (RemoteException e10) {
            dc.e.d(f13954b, " getPackageInfoAsUser exception: ", e10);
            return null;
        }
    }

    public final /* synthetic */ Object n0() throws RemoteException {
        ITranPackageManager iTranPackageManager = this.f13955a;
        if (iTranPackageManager != null) {
            return iTranPackageManager.getPermissionControllerPackageName();
        }
        return null;
    }

    @Override // jf.e
    public void o(String str, boolean z10) {
        try {
            ITranPackageManager iTranPackageManager = this.f13955a;
            if (iTranPackageManager != null) {
                iTranPackageManager.markAsUnremovableSystemAppTemp(str, z10);
            }
        } catch (RemoteException e10) {
            dc.e.d(f13954b, " markAsUnremovableSystemAppTemp exception: ", e10);
        }
    }

    public final /* synthetic */ Object o0(String str, int i10) throws RemoteException {
        ITranPackageManager iTranPackageManager = this.f13955a;
        if (iTranPackageManager != null) {
            return Integer.valueOf(iTranPackageManager.installExistingPackageAsUser(str, i10));
        }
        return 0;
    }

    @Override // jf.e
    public String p(int i10) {
        try {
            ITranPackageManager iTranPackageManager = this.f13955a;
            if (iTranPackageManager != null) {
                return iTranPackageManager.getCurrentShapeDataOrRadius(i10);
            }
            return null;
        } catch (RemoteException e10) {
            dc.e.d(f13954b, " reinstall exception: ", e10);
            return null;
        }
    }

    public final /* synthetic */ Object p0(Intent intent, int i10, int i11) throws RemoteException {
        ITranPackageManager iTranPackageManager = this.f13955a;
        if (iTranPackageManager != null) {
            return iTranPackageManager.queryIntentActivitiesAsUserExt(intent, i10, i11).getList();
        }
        return null;
    }

    @Override // jf.e
    public boolean q(String str, int i10) {
        try {
            return this.f13955a.setDefaultBrowserPackageNameAsUser(str, i10);
        } catch (RemoteException e10) {
            dc.e.n(f13954b, "setDefaultBrowserPackageNameAsUser " + e10);
            return false;
        }
    }

    public final /* synthetic */ Object q0(String str, int i10, int i11) throws RemoteException {
        try {
            this.f13955a.setApplicationNotifyScreenOn(str, i10, i11);
            return null;
        } catch (RemoteException e10) {
            dc.e.d(f13954b, " setApplicationNotifyScreenOn exception: ", e10);
            return null;
        }
    }

    @Override // jf.e
    public void r(String str, int i10, int i11, int i12, String str2) {
        try {
            this.f13955a.setApplicationEnabledSetting(str, i10, i11, i12, str2);
        } catch (RemoteException e10) {
            dc.e.o(f13954b, "setApplicationEnabledSetting exception: ", e10);
        }
    }

    public final /* synthetic */ Object r0(ComponentName componentName, int i10, int i11, int i12) throws RemoteException {
        ITranPackageManager iTranPackageManager = this.f13955a;
        if (iTranPackageManager == null) {
            return null;
        }
        iTranPackageManager.setComponentEnabledSetting(componentName, i10, i11, i12);
        return null;
    }

    @Override // jf.e
    public void s(final String str, final int i10, final int i11) {
        new zb.f().c(new zb.f.b() { // from class: qc.r
            @Override // zb.f.b
            public final Object run() {
                return this.f13944a.q0(str, i10, i11);
            }
        }, "package");
    }

    public final /* synthetic */ Object s0(String str, int i10) throws RemoteException {
        try {
            return Boolean.valueOf(this.f13955a.setDefaulCalendarPackageNameAsUser(str, i10));
        } catch (RemoteException e10) {
            dc.e.d(f13954b, " setDefaulCalendarPackageNameAsUser exception: ", e10);
            return Boolean.FALSE;
        }
    }

    @Override // jf.e
    public String[] t() {
        String[] strArr = (String[]) new zb.f().c(new zb.f.b() { // from class: qc.s
            @Override // zb.f.b
            public final Object run() {
                return this.f13948a.g0();
            }
        }, "package");
        dc.e.f(f13954b, "getAllHiddenApps result:" + strArr);
        return strArr;
    }

    public final /* synthetic */ Object t0(ComponentName componentName, int i10) throws RemoteException {
        ITranPackageManager iTranPackageManager = this.f13955a;
        if (iTranPackageManager == null) {
            return null;
        }
        iTranPackageManager.setHomeActivity(componentName, i10);
        return null;
    }

    @Override // jf.e
    public boolean u(String str, int i10) {
        try {
            return this.f13955a.setDefaultGallerPackageNameAsUser(str, i10);
        } catch (RemoteException e10) {
            dc.e.o(f13954b, " setDefaultGallerPackageNameAsUser exception: ", e10);
            return false;
        }
    }

    @VisibleForTesting
    public void u0(ITranPackageManager iTranPackageManager) {
        this.f13955a = iTranPackageManager;
    }

    @Override // jf.e
    public int v(final String str, final int i10) {
        return ((Integer) new zb.f().c(new zb.f.b() { // from class: qc.q
            @Override // zb.f.b
            public final Object run() {
                return this.f13941a.h0(str, i10);
            }
        }, "package")).intValue();
    }

    @Override // jf.e
    public ComponentName w(final List<ResolveInfo> list) {
        ComponentName componentName = (ComponentName) new zb.f().c(new zb.f.b() { // from class: qc.j
            @Override // zb.f.b
            public final Object run() {
                return this.f13918a.j0(list);
            }
        }, "package");
        dc.e.f(f13954b, "getHomeActivities mComponentName:" + componentName);
        return componentName;
    }

    @Override // jf.e
    public int x(String str) {
        try {
            return this.f13955a.getApplicationEnabledSetting(str);
        } catch (RemoteException e10) {
            e10.printStackTrace();
            return 0;
        }
    }

    @Override // jf.e
    public ApplicationInfo y(String str, int i10, int i11) {
        ITranPackageManager iTranPackageManager = this.f13955a;
        if (iTranPackageManager == null) {
            return null;
        }
        try {
            return iTranPackageManager.getApplicationInfoAsUser(str, i10, i11);
        } catch (RemoteException e10) {
            j7.b.a("getApplicationInfoAsUser fail:", e10, f13954b);
            return null;
        }
    }

    @Override // jf.e
    public List<ResolveInfo> z(final Intent intent, final int i10, final int i11) {
        List<ResolveInfo> list = (List) new zb.f().c(new zb.f.b() { // from class: qc.i
            @Override // zb.f.b
            public final Object run() {
                return this.f13914a.p0(intent, i10, i11);
            }
        }, "package");
        dc.e.f(f13954b, "queryIntentActivitiesAsUser mResolveInfos:" + list);
        return list;
    }
}
