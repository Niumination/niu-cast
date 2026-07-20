package x6;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.IBinder;
import androidx.core.app.NotificationManagerCompat;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class e implements jf.e {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f20082c = "e";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static Class<?> f20083d = cc.a.a("android.app.AppGlobals");

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static Class<?> f20084e = cc.a.a("android.content.pm.IPackageManager");

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static Class<?> f20085f = cc.a.a("com.transsion.content.pm.PackageManager");

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static Class<?> f20086g = cc.a.a("android.content.pm.PackageManager");

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static Class<?> f20087h = cc.a.a("android.content.pm.IPackageDeleteObserver");

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final String f20088i = "getPackageManager";

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static Method f20089j = cc.a.g(f20083d, f20088i, new Class[0]);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f20090a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public PackageManager f20091b;

    @b.a({"WrongConstant"})
    public e() {
        Context contextA = bc.a.a();
        this.f20090a = contextA;
        this.f20091b = contextA.getPackageManager();
    }

    @Override // jf.e
    public int A(String str, String str2) {
        dc.e.c(f20082c, "reinstall is not supported in aosp version.");
        return NotificationManagerCompat.IMPORTANCE_UNSPECIFIED;
    }

    @Override // jf.e
    public void B(ComponentName componentName, int i10, int i11, int i12) {
        Class clsA = cc.a.a("android.os.ServiceManager");
        Object objJ = cc.a.j(cc.a.g(clsA, "getService", String.class), clsA, "package");
        IBinder iBinder = objJ instanceof IBinder ? (IBinder) objJ : null;
        Class clsA2 = cc.a.a("android.content.pm.IPackageManager$Stub");
        Object objJ2 = cc.a.j(cc.a.g(clsA2, "asInterface", IBinder.class), clsA2, iBinder);
        if (objJ2 != null) {
            if (fc.a.a()) {
                Class<?> cls = objJ2.getClass();
                Class cls2 = Integer.TYPE;
                cc.a.j(cc.a.g(cls, "setComponentEnabledSetting", ComponentName.class, cls2, cls2, cls2), objJ2, componentName, Integer.valueOf(i10), Integer.valueOf(i11), Integer.valueOf(i12));
            } else if (fc.a.b()) {
                Class<?> cls3 = objJ2.getClass();
                Class cls4 = Integer.TYPE;
                cc.a.j(cc.a.g(cls3, "setComponentEnabledSetting", ComponentName.class, cls4, cls4, cls4), objJ2, componentName, Integer.valueOf(i10), Integer.valueOf(i11), Integer.valueOf(i12));
            } else if (fc.a.f()) {
                Class<?> cls5 = objJ2.getClass();
                Class cls6 = Integer.TYPE;
                cc.a.j(cc.a.g(cls5, "setComponentEnabledSetting", ComponentName.class, cls6, cls6, cls6, String.class), objJ2, componentName, Integer.valueOf(i10), Integer.valueOf(i11), Integer.valueOf(i12), null);
            }
        }
    }

    @Override // jf.e
    public boolean C(String str, int i10) {
        Object objJ = cc.a.j(cc.a.g(PackageManager.class, "setDefaultMusicPackageNameAsUser", String.class, Integer.TYPE), this.f20090a.getPackageManager(), str, Integer.valueOf(i10));
        if (objJ instanceof Boolean) {
            return ((Boolean) objJ).booleanValue();
        }
        return false;
    }

    @Override // jf.e
    public void D() {
        PackageManager packageManager = this.f20090a.getPackageManager();
        Method methodG = cc.a.g(PackageManager.class, "checkDefaultGaller", new Class[0]);
        if (methodG == null) {
            return;
        }
        cc.a.j(methodG, packageManager, new Object[0]);
    }

    @Override // jf.e
    public List<ResolveInfo> E(Intent intent, int i10, int i11) {
        PackageManager packageManager = this.f20090a.getPackageManager();
        Class<?> cls = f20086g;
        Class cls2 = Integer.TYPE;
        Object objJ = cc.a.j(cc.a.g(cls, "queryIntentServicesAsUser", Intent.class, cls2, cls2), packageManager, intent, Integer.valueOf(i10), Integer.valueOf(i11));
        ArrayList arrayList = new ArrayList();
        if (objJ instanceof List) {
            Iterator it = ((List) objJ).iterator();
            while (it.hasNext()) {
                arrayList.add((ResolveInfo) ResolveInfo.class.cast(it.next()));
            }
        }
        return arrayList;
    }

    @Override // jf.e
    public void F(String str, f.a aVar, int i10) {
        cc.a.j(cc.a.g(this.f20091b.getClass(), "deletePackageAsOOBE", String.class, f20087h, Integer.TYPE), this.f20091b, str, new f.b(aVar), Integer.valueOf(i10));
    }

    @Override // jf.e
    public void G() {
        PackageManager packageManager = this.f20090a.getPackageManager();
        Method methodG = cc.a.g(PackageManager.class, "checkDefaultCalendar", new Class[0]);
        if (methodG == null) {
            return;
        }
        cc.a.j(methodG, packageManager, new Object[0]);
    }

    @Override // jf.e
    public boolean H(String str) {
        PackageManager packageManager = this.f20090a.getPackageManager();
        Method methodG = cc.a.g(packageManager.getClass(), "isRemovableSysApp", String.class);
        if (methodG != null) {
            return ((Boolean) cc.a.j(methodG, packageManager, str)).booleanValue();
        }
        return false;
    }

    @Override // jf.e
    public void I(String str, int i10, int i11) {
        this.f20090a.getPackageManager().setApplicationEnabledSetting(str, i10, i11);
    }

    @Override // jf.e
    public void J() {
        PackageManager packageManager = this.f20090a.getPackageManager();
        Method methodG = cc.a.g(PackageManager.class, "checkDefaultMusic", new Class[0]);
        if (methodG == null) {
            return;
        }
        cc.a.j(methodG, packageManager, new Object[0]);
    }

    @Override // jf.e
    public List<ApplicationInfo> a(int i10, int i11) {
        Class<?> cls = this.f20091b.getClass();
        Class cls2 = Integer.TYPE;
        Method methodG = cc.a.g(cls, "getInstalledApplicationsAsUser", cls2, cls2);
        ArrayList arrayList = new ArrayList();
        Object objJ = cc.a.j(methodG, this.f20091b, Integer.valueOf(i10), Integer.valueOf(i11));
        if (objJ instanceof List) {
            Iterator it = ((List) objJ).iterator();
            while (it.hasNext()) {
                arrayList.add((ApplicationInfo) ApplicationInfo.class.cast(it.next()));
            }
        }
        return arrayList;
    }

    @Override // jf.e
    public String b(int i10) {
        return (String) cc.a.j(cc.a.g(PackageManager.class, "getDefaultMusicPackageNameAsUser", Integer.TYPE), this.f20090a.getPackageManager(), Integer.valueOf(i10));
    }

    @Override // jf.e
    public String c(int i10) {
        PackageManager packageManager = this.f20090a.getPackageManager();
        Method methodG = cc.a.g(PackageManager.class, "getDefaulCalendarPackageNameAsUser", Integer.TYPE);
        return methodG == null ? "" : (String) cc.a.j(methodG, packageManager, Integer.valueOf(i10));
    }

    @Override // jf.e
    public boolean d(String str, int i10) {
        Object objJ;
        PackageManager packageManager = this.f20090a.getPackageManager();
        Method methodG = cc.a.g(PackageManager.class, "setDefaulCalendarPackageNameAsUser", String.class, Integer.TYPE);
        return (methodG == null || (objJ = cc.a.j(methodG, packageManager, str, Integer.valueOf(i10))) == null || !((Boolean) objJ).booleanValue()) ? false : true;
    }

    @Override // jf.e
    public String e(int i10) {
        return (String) cc.a.j(cc.a.g(PackageManager.class, "getDefaultGallerPackageNameAsUser", Integer.TYPE), this.f20090a.getPackageManager(), Integer.valueOf(i10));
    }

    @Override // jf.e
    public PackageInfo f(String str, int i10, int i11) {
        Object objJ = cc.a.j(cc.a.g(f20083d, f20088i, new Class[0]), null, new Object[0]);
        Class<?> cls = f20084e;
        Class cls2 = Integer.TYPE;
        Object objJ2 = cc.a.j(cc.a.g(cls, "getPackageInfo", String.class, cls2, cls2), objJ, str, Integer.valueOf(i10), Integer.valueOf(i11));
        if (objJ2 instanceof PackageInfo) {
            return (PackageInfo) objJ2;
        }
        return null;
    }

    @Override // jf.e
    public void g(ComponentName componentName, int i10) {
        cc.a.j(cc.a.g(f20084e, "setHomeActivity", ComponentName.class, Integer.TYPE), cc.a.j(cc.a.g(f20083d, f20088i, new Class[0]), null, new Object[0]), componentName, Integer.valueOf(i10));
    }

    @Override // jf.e
    public void h(IntentFilter intentFilter, int i10, ComponentName[] componentNameArr, ComponentName componentName, int i11) {
        Object objJ = cc.a.j(cc.a.g(f20083d, f20088i, new Class[0]), null, new Object[0]);
        Class<?> cls = f20084e;
        Class cls2 = Integer.TYPE;
        cc.a.j(cc.a.g(cls, "replacePreferredActivity", IntentFilter.class, cls2, ComponentName[].class, ComponentName.class, cls2), objJ, intentFilter, Integer.valueOf(i10), componentNameArr, componentName, Integer.valueOf(i11));
    }

    @Override // jf.e
    public void i(String str, f.a aVar, int i10, int i11) {
        Class<?> cls = this.f20091b.getClass();
        Class<?> cls2 = f20087h;
        Class cls3 = Integer.TYPE;
        cc.a.j(cc.a.g(cls, "deletePackageAsUser", String.class, cls2, cls3, cls3), this.f20091b, str, new f.b(aVar), Integer.valueOf(i10), Integer.valueOf(i11));
    }

    @Override // jf.e
    public int j(String str, int i10) {
        Object objJ = cc.a.j(cc.a.g(this.f20091b.getClass(), "installExistingPackageAsUser", String.class, Integer.TYPE), this.f20091b, str, Integer.valueOf(i10));
        if (objJ instanceof Integer) {
            return ((Integer) objJ).intValue();
        }
        return 0;
    }

    @Override // jf.e
    public List<PackageInfo> k(int i10, int i11) {
        PackageManager packageManager = this.f20090a.getPackageManager();
        Class<?> cls = f20086g;
        Class cls2 = Integer.TYPE;
        Object objJ = cc.a.j(cc.a.g(cls, "getInstalledPackagesAsUser", cls2, cls2), packageManager, Integer.valueOf(i10), Integer.valueOf(i11));
        ArrayList arrayList = new ArrayList();
        if (objJ instanceof List) {
            Iterator it = ((List) objJ).iterator();
            while (it.hasNext()) {
                arrayList.add((PackageInfo) PackageInfo.class.cast(it.next()));
            }
        }
        return arrayList;
    }

    @Override // jf.e
    public List<ApplicationInfo> l(int i10) {
        dc.e.c(f20082c, "getInstalledApplicationsInDualSpace is not supported in aosp version.");
        return null;
    }

    @Override // jf.e
    public String m() {
        return (String) cc.a.j(cc.a.g(this.f20091b.getClass(), "getPermissionControllerPackageName", new Class[0]), this.f20091b, new Object[0]);
    }

    @Override // jf.e
    public PackageInfo n(String str, int i10, int i11) {
        PackageManager packageManager = this.f20090a.getPackageManager();
        Class<?> cls = packageManager.getClass();
        Class cls2 = Integer.TYPE;
        Method methodG = cc.a.g(cls, "getPackageInfoAsUser", String.class, cls2, cls2);
        if (methodG != null) {
            return (PackageInfo) cc.a.j(methodG, packageManager, str, Integer.valueOf(i10), Integer.valueOf(i11));
        }
        return null;
    }

    @Override // jf.e
    public void o(String str, boolean z10) {
        PackageManager packageManager = this.f20090a.getPackageManager();
        Method methodG = cc.a.g(packageManager.getClass(), "markAsUnremovableSystemAppTemp", String.class, Boolean.TYPE);
        if (methodG != null) {
            cc.a.j(methodG, packageManager, str, Boolean.valueOf(z10));
        }
    }

    @Override // jf.e
    public String p(int i10) {
        PackageManager packageManager = this.f20090a.getPackageManager();
        Method methodG = cc.a.g(packageManager.getClass(), "getCurrentShapeDataOrRadius", Integer.TYPE);
        if (methodG != null) {
            return (String) cc.a.j(methodG, packageManager, Integer.valueOf(i10));
        }
        return null;
    }

    @Override // jf.e
    public boolean q(String str, int i10) {
        Object objJ = cc.a.j(cc.a.g(f20086g, "setDefaultBrowserPackageNameAsUser", String.class, Integer.TYPE), this.f20091b, str, Integer.valueOf(i10));
        if (objJ instanceof Boolean) {
            return ((Boolean) objJ).booleanValue();
        }
        return false;
    }

    @Override // jf.e
    public void r(String str, int i10, int i11, int i12, String str2) {
        Object objJ = cc.a.j(f20089j, null, new Object[0]);
        Class<?> cls = f20084e;
        Class cls2 = Integer.TYPE;
        cc.a.j(cc.a.g(cls, "setApplicationEnabledSetting", String.class, cls2, cls2, cls2, String.class), objJ, str, Integer.valueOf(i10), Integer.valueOf(i11), Integer.valueOf(i12), str2);
    }

    @Override // jf.e
    public void s(String str, int i10, int i11) {
        PackageManager packageManager = this.f20090a.getPackageManager();
        Class cls = Integer.TYPE;
        Method methodG = cc.a.g(PackageManager.class, "setApplicationNotifyScreenOn", String.class, cls, cls);
        if (methodG == null) {
            return;
        }
        cc.a.j(methodG, packageManager, str, Integer.valueOf(i10), Integer.valueOf(i11));
    }

    @Override // jf.e
    public String[] t() {
        Object objJ = cc.a.j(cc.a.g(f20085f, "getAllHiddenApps", new Class[0]), cc.a.j(cc.a.g(f20085f, "instance", new Class[0]), null, new Object[0]), new Object[0]);
        if (objJ instanceof String[]) {
            return (String[]) objJ;
        }
        return null;
    }

    @Override // jf.e
    public boolean u(String str, int i10) {
        Object objJ = cc.a.j(cc.a.g(PackageManager.class, "setDefaultGallerPackageNameAsUser", String.class, Integer.TYPE), this.f20090a.getPackageManager(), str, Integer.valueOf(i10));
        if (objJ instanceof Boolean) {
            return ((Boolean) objJ).booleanValue();
        }
        return false;
    }

    @Override // jf.e
    public int v(String str, int i10) {
        PackageManager packageManager = this.f20090a.getPackageManager();
        Method methodG = cc.a.g(PackageManager.class, "getApplicationNotifyScreenOn", String.class, Integer.TYPE);
        if (methodG == null) {
            return -1;
        }
        Object objJ = cc.a.j(methodG, packageManager, str, Integer.valueOf(i10));
        if (objJ instanceof Integer) {
            return ((Integer) objJ).intValue();
        }
        return -1;
    }

    @Override // jf.e
    public ComponentName w(List<ResolveInfo> list) {
        Object objJ = cc.a.j(cc.a.g(f20084e, "getHomeActivities", List.class), cc.a.j(cc.a.g(f20083d, f20088i, new Class[0]), null, new Object[0]), list);
        if (objJ instanceof ComponentName) {
            return (ComponentName) objJ;
        }
        return null;
    }

    @Override // jf.e
    public int x(String str) {
        return this.f20090a.getPackageManager().getApplicationEnabledSetting(str);
    }

    @Override // jf.e
    public ApplicationInfo y(String str, int i10, int i11) {
        PackageManager packageManager = this.f20090a.getPackageManager();
        Class<?> cls = f20086g;
        Class cls2 = Integer.TYPE;
        Object objJ = cc.a.j(cc.a.g(cls, "getApplicationInfoAsUser", String.class, cls2, cls2), packageManager, str, Integer.valueOf(i10), Integer.valueOf(i11));
        if (objJ instanceof ApplicationInfo) {
            return (ApplicationInfo) objJ;
        }
        return null;
    }

    @Override // jf.e
    public List<ResolveInfo> z(Intent intent, int i10, int i11) {
        Class<?> cls = this.f20091b.getClass();
        Class cls2 = Integer.TYPE;
        Method methodG = cc.a.g(cls, "queryIntentActivitiesAsUser", Intent.class, cls2, cls2);
        ArrayList arrayList = new ArrayList();
        Object objJ = cc.a.j(methodG, this.f20091b, intent, Integer.valueOf(i10), Integer.valueOf(i11));
        if (objJ instanceof List) {
            Iterator it = ((List) objJ).iterator();
            while (it.hasNext()) {
                arrayList.add((ResolveInfo) ResolveInfo.class.cast(it.next()));
            }
        }
        return arrayList;
    }
}
