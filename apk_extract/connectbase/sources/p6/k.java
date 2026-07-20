package p6;

import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.ColorSpace;
import android.graphics.Rect;
import android.hardware.HardwareBuffer;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.text.TextUtils;
import android.view.SurfaceControl;
import com.transsion.hubsdk.api.app.TranRootTaskInfo;
import com.transsion.hubsdk.api.window.TranTaskSnapshot;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class k implements bf.g {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f12973e = "k";

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final int f12980l = 5;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final int f12981m = 1;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final int f12982n = 2;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final int f12983o = 5;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final int f12984p = 6;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final int f12985q = -2;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final int f12986r = 999;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final int f12987s = 0;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final String f12988t = "com.transsion.splitscreen";

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final String f12989u = "com.transsion.applock";

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final String f12990v = "com.facebook.orca";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f12992a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final l f12993b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public h9.a f12994c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Context f12995d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static Class<?> f12974f = cc.a.a("android.app.ActivityTaskManager");

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static Class<?> f12975g = cc.a.a("android.app.IActivityTaskManager");

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static Class<?> f12976h = cc.a.a(x8.a.f20121d);

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static Class<?> f12977i = cc.a.a("android.os.ServiceManager");

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static Class<?> f12978j = cc.a.a("android.app.IActivityTaskManager$Stub");

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static Class<?> f12979k = cc.a.a("android.window.TaskSnapshot");

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static int f12991w = -1;

    public class a extends h9.a.b {
        public a() {
        }

        @Override // h9.a
        public boolean E(String str) throws RemoteException {
            if (k.this.f12994c != null) {
                return k.this.f12994c.E(str);
            }
            return false;
        }

        @Override // h9.a
        public boolean F(String str, int i10, String str2, String str3, long j10, String str4) throws RemoteException {
            if (k.this.f12994c != null) {
                return k.this.f12994c.F(str, i10, str2, str3, j10, str4);
            }
            return false;
        }

        @Override // h9.a
        public int J(String str) throws RemoteException {
            if (k.this.f12994c != null) {
                return k.this.f12994c.J(str);
            }
            return 0;
        }

        @Override // h9.a
        public int s(String str, int i10, String str2) throws RemoteException {
            if (k.this.f12994c != null) {
                return k.this.f12994c.s(str, i10, str2);
            }
            return 0;
        }

        @Override // h9.a
        public int w(String str, int i10, String str2) throws RemoteException {
            if (k.this.f12994c != null) {
                return k.this.f12994c.w(str, i10, str2);
            }
            return 0;
        }

        @Override // h9.a
        public boolean y(Intent intent, String str) throws RemoteException {
            if (k.this.f12994c != null) {
                return k.this.f12994c.y(intent, str);
            }
            return false;
        }
    }

    public k() {
        Context applicationContext = bc.a.a().getApplicationContext();
        this.f12995d = applicationContext;
        this.f12993b = new l(applicationContext);
        this.f12992a = cc.a.j(cc.a.g(f12974f, "getService", new Class[0]), null, new Object[0]);
    }

    public static Object c1(Configuration configuration) {
        try {
            return cc.a.d(Configuration.class, "windowConfiguration").get(configuration);
        } catch (Exception e10) {
            dc.e.a(f12973e, "getWindowConfiguration, Exception: " + e10);
            return null;
        }
    }

    public static int d1(Object obj) {
        Object objJ = cc.a.j(cc.a.g(cc.a.a("android.app.WindowConfiguration"), "getWindowingMode", new Class[0]), obj, new Object[0]);
        if (objJ instanceof Integer) {
            return ((Integer) objJ).intValue();
        }
        return 0;
    }

    @Override // bf.g
    public String A() {
        Object objJ = cc.a.j(cc.a.g(f12975g, "getMultiWindowVersion", new Class[0]), this.f12992a, new Object[0]);
        if (objJ instanceof String) {
            return (String) objJ;
        }
        return null;
    }

    @Override // bf.g
    public void A0(Bundle bundle) {
        cc.a.j(cc.a.g(f12975g, "setMultiWindowParams", Bundle.class), this.f12992a, bundle);
    }

    @Override // bf.g
    public void B(int i10, Rect rect) {
        cc.a.j(cc.a.g(f12975g, "hookStartActivityResult", Integer.TYPE, Rect.class), this.f12992a, Integer.valueOf(i10), rect);
    }

    @Override // bf.g
    public void B0(Rect rect) {
        cc.a.j(cc.a.g(f12975g, "hookSetMultiWindowDefaultRectResult", Rect.class), this.f12992a, rect);
    }

    @Override // bf.g
    public SurfaceControl C() {
        Object objJ = cc.a.j(cc.a.g(f12975g, "getDefaultRootLeash", new Class[0]), this.f12992a, new Object[0]);
        if (objJ instanceof SurfaceControl) {
            return (SurfaceControl) objJ;
        }
        return null;
    }

    @Override // bf.g
    public void C0(List<String> list) {
        Object obj = this.f12992a;
        if (obj != null) {
            cc.a.j(cc.a.g(obj.getClass(), "setConnectBlackListToSystem", List.class), this.f12992a, list);
        }
    }

    @Override // bf.g
    public void D(int i10, int i11) {
        Class<?> cls = f12975g;
        Class cls2 = Integer.TYPE;
        cc.a.j(cc.a.g(cls, "hookReparentToDefaultDisplay", cls2, cls2), this.f12992a, Integer.valueOf(i10), Integer.valueOf(i11));
    }

    @Override // bf.g
    public Bundle D0(String str) {
        Object objJ = cc.a.j(cc.a.g(f12975g, "getMultiWindowParams", String.class), this.f12992a, str);
        if (objJ instanceof Bundle) {
            return (Bundle) objJ;
        }
        return null;
    }

    @Override // bf.g
    public int E(String str) {
        int i10 = str.endsWith("_twin_app") ? 999 : 0;
        try {
            for (Object obj : b()) {
                if (str.equals(X0(obj)) && b1(obj) == i10) {
                    return Z0(obj);
                }
            }
            return -1;
        } catch (Exception e10) {
            b.a("getTaskIdByPkg, exception: ", e10, f12973e);
            return -1;
        }
    }

    @Override // bf.g
    public void E0(SurfaceControl surfaceControl) {
        cc.a.j(cc.a.g(f12975g, "addAnimationIconLayer", SurfaceControl.class), this.f12992a, surfaceControl);
    }

    @Override // bf.g
    public void F(int i10) {
        cc.a.j(cc.a.g(f12975g, "boostSceneEnd", Integer.TYPE), this.f12992a, Integer.valueOf(i10));
    }

    @Override // bf.g
    public void F0(boolean z10) {
        Method methodG = cc.a.g(f12975g, "notAllowKeyguardGoingAwayQuickly", Boolean.TYPE);
        if (methodG != null) {
            cc.a.j(methodG, this.f12992a, Boolean.valueOf(z10));
        }
    }

    @Override // bf.g
    public void G(boolean z10) {
        Object obj;
        Method methodG = cc.a.g(f12975g, "setThunderbackAnimating", Boolean.TYPE);
        if (methodG == null || (obj = this.f12992a) == null) {
            return;
        }
        cc.a.j(methodG, obj, Boolean.valueOf(z10));
    }

    @Override // bf.g
    public void G0(int i10, Rect rect, h9.j.a aVar) {
        if (aVar != null) {
            this.f12993b.a(i10, rect, new j(aVar));
        } else {
            this.f12993b.a(i10, rect, null);
        }
    }

    @Override // bf.g
    public void H(int i10, String str, boolean z10) {
        Method methodG;
        Object objJ;
        Class clsA = cc.a.a("com.transsion.hubsdk.TranServiceManager");
        if (clsA == null || (methodG = cc.a.g(clsA, "getServiceIBinder", String.class)) == null) {
            return;
        }
        IBinder iBinder = (IBinder) cc.a.j(methodG, null, "activity_task");
        Class clsA2 = cc.a.a("com.transsion.hubsdk.app.ITranActivityTaskManager$Stub");
        if (iBinder == null || clsA2 == null || (objJ = cc.a.j(cc.a.g(clsA2, "asInterface", IBinder.class), clsA2, iBinder)) == null) {
            return;
        }
        cc.a.j(cc.a.g(objJ.getClass(), "setJankScenarioState", Integer.TYPE, String.class, Boolean.TYPE), objJ, Integer.valueOf(i10), str, Boolean.valueOf(z10));
    }

    @Override // bf.g
    public void H0(List<String> list) {
        cc.a.j(cc.a.g(f12975g, "setMultiWindowWhiteListToSystem", List.class), this.f12992a, list);
    }

    @Override // bf.g
    public Rect I(int i10) {
        Object objJ = cc.a.j(cc.a.g(f12975g, "getTaskBounds", Integer.TYPE), this.f12992a, Integer.valueOf(i10));
        if (objJ instanceof Rect) {
            return (Rect) objJ;
        }
        return null;
    }

    @Override // bf.g
    public List<String> I0() {
        Object obj;
        Method methodG = cc.a.g(f12975g, "getNotifyMultiWindowBlackList", new Class[0]);
        if (methodG == null || (obj = this.f12992a) == null) {
            return null;
        }
        return (List) cc.a.j(methodG, obj, new Object[0]);
    }

    @Override // bf.g
    public void J(boolean z10) {
        Object obj;
        Method methodG = cc.a.g(f12975g, "notifyKeyguardGoingAwayQuickly", Boolean.TYPE);
        if (methodG == null || (obj = this.f12992a) == null) {
            return;
        }
        cc.a.j(methodG, obj, Boolean.valueOf(z10));
    }

    @Override // bf.g
    public String J0(int i10, int i11) {
        Class<?> cls = f12975g;
        Class cls2 = Integer.TYPE;
        Object objJ = cc.a.j(cc.a.g(cls, "getMultiDisplayAreaTopPackageV4", cls2, cls2), this.f12992a, Integer.valueOf(i10), Integer.valueOf(i11));
        if (objJ instanceof String) {
            return (String) objJ;
        }
        return null;
    }

    @Override // bf.g
    public void K(SurfaceControl surfaceControl) {
        cc.a.j(cc.a.g(f12975g, "removeAnimationIconLayer", SurfaceControl.class), this.f12992a, surfaceControl);
    }

    @Override // bf.g
    public int K0(int i10) {
        Object objJ = cc.a.j(cc.a.g(f12975g, "getTaskOrientation", Integer.TYPE), this.f12992a, Integer.valueOf(i10));
        if (objJ instanceof Integer) {
            return ((Integer) objJ).intValue();
        }
        return 0;
    }

    @Override // bf.g
    public void L(int i10) {
        Object obj;
        Method methodG = cc.a.g(f12975g, "boostStartInLauncher", Integer.TYPE);
        if (methodG == null || (obj = this.f12992a) == null) {
            return;
        }
        cc.a.j(methodG, obj, Integer.valueOf(i10));
    }

    @Override // bf.g
    public List<ActivityManager.RecentTaskInfo> L0(int i10, int i11, int i12) {
        Class<?> cls = f12975g;
        Class cls2 = Integer.TYPE;
        Object objJ = cc.a.j(cc.a.g(cc.a.a("android.content.pm.ParceledListSlice"), "getList", new Class[0]), cc.a.j(cc.a.g(cls, "getRecentTasks", cls2, cls2, cls2), this.f12992a, Integer.valueOf(i10), Integer.valueOf(i11), Integer.valueOf(i12)), new Object[0]);
        ArrayList arrayList = new ArrayList();
        if (objJ instanceof List) {
            Iterator it = ((List) objJ).iterator();
            while (it.hasNext()) {
                arrayList.add((ActivityManager.RecentTaskInfo) ActivityManager.RecentTaskInfo.class.cast(it.next()));
            }
        }
        return arrayList;
    }

    @Override // bf.g
    public void M(h9.a aVar, boolean z10) {
        this.f12994c = aVar;
        cc.a.j(cc.a.g(f12975g, "setActivityController", Object.class, Boolean.TYPE), this.f12992a, new a(), Boolean.valueOf(z10));
    }

    @Override // bf.g
    public TranRootTaskInfo M0(int i10, int i11, int i12) {
        try {
            Class<?> cls = f12975g;
            Class cls2 = Integer.TYPE;
            Object objJ = cc.a.j(cc.a.g(cls, "getRootTaskInfoOnDisplay", cls2, cls2, cls2), this.f12992a, Integer.valueOf(i10), Integer.valueOf(i11), Integer.valueOf(i12));
            Field fieldD = cc.a.d(cc.a.a("android.app.ActivityTaskManager$RootTaskInfo"), "topActivity");
            ComponentName componentName = fieldD != null ? (ComponentName) fieldD.get(objJ) : null;
            TranRootTaskInfo tranRootTaskInfo = new TranRootTaskInfo();
            tranRootTaskInfo.f2202a = componentName != null ? componentName.flattenToString() : null;
            return tranRootTaskInfo;
        } catch (Exception e10) {
            b.a("getRootTaskInfoOnDisplay fail: ", e10, f12973e);
            return null;
        }
    }

    @Override // bf.g
    public void N(String str, int i10, int i11, int i12) {
        Class<?> cls = f12975g;
        Class cls2 = Integer.TYPE;
        cc.a.j(cc.a.g(cls, "setStartInMultiWindow", String.class, cls2, cls2, cls2), this.f12992a, str, Integer.valueOf(i10), Integer.valueOf(i11), Integer.valueOf(i12));
    }

    @Override // bf.g
    public Bundle N0(String str, Bundle bundle) {
        Object obj;
        Method methodG = cc.a.g(f12975g, "hookToMultiWindow", String.class, Bundle.class);
        if (methodG == null || (obj = this.f12992a) == null) {
            return null;
        }
        return (Bundle) cc.a.j(methodG, obj, str, bundle);
    }

    @Override // bf.g
    public void O() {
        Object obj;
        Method methodG = cc.a.g(f12975g, "hookMultiWindowVisible", new Class[0]);
        if (methodG == null || (obj = this.f12992a) == null) {
            return;
        }
        cc.a.j(methodG, obj, new Object[0]);
    }

    @Override // bf.g
    public int O0() {
        if (f12991w < 0) {
            Object objJ = cc.a.j(cc.a.g(f12976h, "isLowRamDeviceStatic", new Class[0]), f12976h, new Object[0]);
            f12991w = objJ instanceof Boolean ? ((Boolean) objJ).booleanValue() : false ? 36 : 48;
        }
        return f12991w;
    }

    @Override // bf.g
    public boolean P(Configuration configuration) {
        Object objJ = cc.a.j(cc.a.g(f12975g, "updateConfiguration", Configuration.class), this.f12992a, configuration);
        if (objJ instanceof Boolean) {
            return ((Boolean) objJ).booleanValue();
        }
        return false;
    }

    @Override // bf.g
    public void P0(boolean z10, int i10) {
        cc.a.j(cc.a.g(f12975g, "setTbSpecialLayerState", Boolean.TYPE, Integer.TYPE), this.f12992a, Boolean.valueOf(z10), Integer.valueOf(i10));
    }

    @Override // bf.g
    public void Q(boolean z10, Bundle bundle) {
        Object obj;
        Method methodG = cc.a.g(f12975g, "setMultiEnableStateForOOBE", Boolean.TYPE, Bundle.class);
        if (methodG == null || (obj = this.f12992a) == null) {
            return;
        }
        cc.a.j(methodG, obj, Boolean.valueOf(z10), bundle);
    }

    @Override // bf.g
    public TranTaskSnapshot Q0(int i10, boolean z10) {
        Object objJ;
        if (fc.a.b()) {
            objJ = cc.a.j(cc.a.g(f12975g, "takeTaskSnapshot", Integer.TYPE), this.f12992a, Integer.valueOf(i10));
        } else {
            objJ = fc.a.f() ? cc.a.j(cc.a.g(f12975g, "takeTaskSnapshot", Integer.TYPE, Boolean.TYPE), this.f12992a, Integer.valueOf(i10), Boolean.valueOf(z10)) : null;
        }
        TranTaskSnapshot tranTaskSnapshot = new TranTaskSnapshot();
        if (objJ == null) {
            dc.e.n(f12973e, "TranTaskSnapshot is null");
            return tranTaskSnapshot;
        }
        if (objJ.getClass().equals(f12979k)) {
            Object objJ2 = cc.a.j(cc.a.g(objJ.getClass(), "getHardwareBuffer", new Class[0]), objJ, new Object[0]);
            if (objJ2 instanceof HardwareBuffer) {
                tranTaskSnapshot.f2273a = (HardwareBuffer) objJ2;
            }
            Object objJ3 = cc.a.j(cc.a.g(objJ.getClass(), "getColorSpace", new Class[0]), objJ, new Object[0]);
            if (objJ3 instanceof ColorSpace) {
                tranTaskSnapshot.f2274b = (ColorSpace) objJ3;
            }
        }
        return tranTaskSnapshot;
    }

    @Override // bf.g
    public List<ActivityManager.RunningTaskInfo> R() {
        Method methodG = cc.a.g(f12975g, "getAllMultiWindowTaskInfo", new Class[0]);
        if (methodG != null) {
            return (List) cc.a.j(methodG, this.f12992a, new Object[0]);
        }
        return null;
    }

    @Override // bf.g
    public boolean R0() {
        Object objJ = cc.a.j(cc.a.g(f12975g, "isPinnedMode", new Class[0]), this.f12992a, new Object[0]);
        if (objJ instanceof Boolean) {
            return ((Boolean) objJ).booleanValue();
        }
        return false;
    }

    @Override // bf.g
    public boolean S() {
        Object objJ = cc.a.j(cc.a.g(f12975g, "inMultiWindowMode", new Class[0]), this.f12992a, new Object[0]);
        if (objJ instanceof Boolean) {
            return ((Boolean) objJ).booleanValue();
        }
        return false;
    }

    @Override // bf.g
    public void S0(int i10) {
        cc.a.j(cc.a.g(f12975g, "updateZBoostTaskIdWhenToSplit", Integer.TYPE), this.f12992a, Integer.valueOf(i10));
    }

    @Override // bf.g
    public void T(int i10) {
        Object obj;
        Method methodG = cc.a.g(f12975g, "boostEndInLauncher", Integer.TYPE);
        if (methodG == null || (obj = this.f12992a) == null) {
            return;
        }
        cc.a.j(methodG, obj, Integer.valueOf(i10));
    }

    @Override // bf.g
    public int T0(String str) {
        try {
            for (Object obj : b()) {
                if (str.equals(X0(obj))) {
                    return b1(obj);
                }
            }
            return 0;
        } catch (Exception e10) {
            b.a("getPackageUserId, exception: ", e10, f12973e);
            return 0;
        }
    }

    @Override // bf.g
    public boolean U() {
        Object objJ = cc.a.j(cc.a.g(f12975g, "isSupportMultiWindow", new Class[0]), this.f12992a, new Object[0]);
        if (objJ instanceof Boolean) {
            return ((Boolean) objJ).booleanValue();
        }
        return false;
    }

    @Override // bf.g
    public void U0(String str, int i10, int i11, int i12, int i13) {
        Class<?> cls = f12975g;
        Class cls2 = Integer.TYPE;
        cc.a.j(cc.a.g(cls, "setStartInMultiWindowAsUser", String.class, cls2, cls2, cls2, cls2), this.f12992a, str, Integer.valueOf(i10), Integer.valueOf(i11), Integer.valueOf(i12), Integer.valueOf(i13));
    }

    @Override // bf.g
    public void V(List<String> list) {
        cc.a.j(cc.a.g(f12975g, "setMultiWindowBlackListToSystem", List.class), this.f12992a, list);
    }

    @Override // bf.g
    public boolean V0() {
        Object objJ = cc.a.j(cc.a.g(f12975g, "isSecureWindow", new Class[0]), this.f12992a, new Object[0]);
        if (objJ instanceof Boolean) {
            return ((Boolean) objJ).booleanValue();
        }
        return false;
    }

    @Override // bf.g
    public void W(String str, List<String> list) {
        cc.a.j(cc.a.g(f12975g, "setMultiWindowConfigToSystem", String.class, List.class), this.f12992a, str, list);
    }

    @Override // bf.g
    public void W0() {
        cc.a.j(cc.a.g(f12975g, "hookShowBlurLayerFinish", new Class[0]), this.f12992a, new Object[0]);
    }

    @Override // bf.g
    public void X(int i10, String str, boolean z10) {
        Method methodG;
        Object objJ;
        Class clsA = cc.a.a("com.transsion.hubsdk.TranServiceManager");
        if (clsA == null || (methodG = cc.a.g(clsA, "getServiceIBinder", String.class)) == null) {
            return;
        }
        IBinder iBinder = (IBinder) cc.a.j(methodG, null, "activity_task");
        Class clsA2 = cc.a.a("com.transsion.hubsdk.app.ITranActivityTaskManager$Stub");
        if (iBinder == null || clsA2 == null || (objJ = cc.a.j(cc.a.g(clsA2, "asInterface", IBinder.class), clsA2, iBinder)) == null) {
            return;
        }
        cc.a.j(cc.a.g(objJ.getClass(), "setBoostSceneState", Integer.TYPE, String.class, Boolean.TYPE), objJ, Integer.valueOf(i10), str, Boolean.valueOf(z10));
    }

    public final String X0(Object obj) {
        try {
            String[] strArr = (String[]) c(obj).get(obj);
            String str = strArr.length > 0 ? strArr[0].split("/")[0] : "";
            return (!f12988t.equals(str) || strArr.length <= 1) ? str : strArr[1].split("/")[0];
        } catch (Exception e10) {
            b.a("getStackInfoPackageName, exception: ", e10, f12973e);
            return null;
        }
    }

    @Override // bf.g
    public ActivityManager.RunningTaskInfo Y(int i10, int i11) {
        Class<?> cls = f12975g;
        Class cls2 = Integer.TYPE;
        Object objJ = cc.a.j(cc.a.g(cls, "getMultiWinTopTask", cls2, cls2), this.f12992a, Integer.valueOf(i10), Integer.valueOf(i11));
        if (objJ instanceof ActivityManager.RunningTaskInfo) {
            return (ActivityManager.RunningTaskInfo) objJ;
        }
        return null;
    }

    public final String Y0(Object obj) {
        ComponentName componentName = (ComponentName) cc.a.f(cc.a.d(obj.getClass(), "topActivity"), obj);
        return componentName != null ? componentName.getPackageName() : "";
    }

    @Override // bf.g
    public int Z(String str) {
        Object objC1;
        int iD1 = -2;
        try {
            for (Object obj : b()) {
                if (!e1(obj, str) && !str.equals(Y0(obj))) {
                }
                Configuration configurationE = e(obj);
                if (configurationE == null || (objC1 = c1(configurationE)) == null) {
                    return -2;
                }
                iD1 = d1(objC1);
                dc.e.a(f12973e, "mode = " + iD1);
                return iD1;
            }
            return -2;
        } catch (Exception e10) {
            b.a("getGivenPkgWindowMode, exception: ", e10, f12973e);
            return iD1;
        }
    }

    public final int Z0(Object obj) {
        return ((int[]) cc.a.f(cc.a.d(cc.a.a("android.app.ActivityTaskManager$RootTaskInfo"), "childTaskIds"), obj))[0];
    }

    @Override // bf.g
    public boolean a0() {
        Object objJ = cc.a.j(cc.a.g(f12975g, "isKeyguardLocking", new Class[0]), this.f12992a, new Object[0]);
        if (objJ instanceof Boolean) {
            return ((Boolean) objJ).booleanValue();
        }
        return false;
    }

    public final int a1(Object obj) {
        Object objF = cc.a.f(cc.a.d(cc.a.a("android.app.TaskInfo"), "displayId"), obj);
        if (objF instanceof Integer) {
            return ((Integer) objF).intValue();
        }
        return 0;
    }

    public final List<Object> b() {
        ActivityManager activityManager = (ActivityManager) this.f12995d.getSystemService("activity");
        Class clsA = cc.a.a("android.app.IActivityManager");
        Object objJ = cc.a.j(cc.a.g(clsA, "getAllRootTaskInfos", new Class[0]), cc.a.j(cc.a.g(ActivityManager.class, "getService", new Class[0]), activityManager, new Object[0]), new Object[0]);
        ArrayList arrayList = new ArrayList();
        if (objJ instanceof List) {
            arrayList.addAll((List) objJ);
        }
        return arrayList;
    }

    @Override // bf.g
    public void b0(boolean z10) {
        Object obj;
        Method methodG = cc.a.g(f12975g, "notifyLauncherPageTurning", Boolean.TYPE);
        if (methodG == null || (obj = this.f12992a) == null) {
            return;
        }
        cc.a.j(methodG, obj, Boolean.valueOf(z10));
    }

    public int b1(Object obj) {
        try {
            Object obj2 = cc.a.d(cc.a.a("android.app.TaskInfo"), "userId").get(obj);
            if (obj2 instanceof Integer) {
                return ((Integer) obj2).intValue();
            }
            return 0;
        } catch (Exception e10) {
            b.a("getUserId, exception: ", e10, f12973e);
            return 0;
        }
    }

    public final Field c(Object obj) {
        return cc.a.d(obj.getClass(), "childTaskNames");
    }

    @Override // bf.g
    public void c0(int i10, int i11, int i12, Rect rect, h9.j.a aVar) {
        if (aVar != null) {
            this.f12993b.b(i10, i11, i12, rect, new j(aVar));
        } else {
            this.f12993b.b(i10, i11, i12, rect, null);
        }
        dc.e.c(f12973e, "hookStartMultiWindowAndMakeOwnAnimation success");
    }

    @Override // bf.g
    public boolean d() {
        Object obj = this.f12992a;
        if (obj == null) {
            return false;
        }
        Object objJ = cc.a.j(cc.a.g(obj.getClass(), "isSplitScreen", new Class[0]), this.f12992a, new Object[0]);
        if (objJ instanceof Boolean) {
            return ((Boolean) objJ).booleanValue();
        }
        return false;
    }

    @Override // bf.g
    public Bundle d0() {
        Object obj;
        Method methodG = cc.a.g(f12975g, "getTopAppWindowInfo", new Class[0]);
        if (methodG != null && (obj = this.f12992a) != null) {
            return (Bundle) cc.a.j(methodG, obj, new Object[0]);
        }
        dc.e.n(f12973e, "Method getTopAppWindowInfo not found in sClass or mObject is null");
        return null;
    }

    public final Configuration e(Object obj) {
        Object objF = cc.a.f(cc.a.d(obj.getClass(), "configuration"), obj);
        if (objF instanceof Configuration) {
            return (Configuration) objF;
        }
        return null;
    }

    @Override // bf.g
    public boolean e0(String str, String str2) {
        int iA1;
        boolean z10;
        if (TextUtils.isEmpty(str)) {
            return true;
        }
        try {
            List<Object> listB = b();
            Iterator<Object> it = listB.iterator();
            while (true) {
                if (!it.hasNext()) {
                    iA1 = 0;
                    z10 = false;
                    break;
                }
                Object next = it.next();
                if (!f1(next, str) && !j(next, str)) {
                }
                iA1 = a1(next);
                z10 = true;
                break;
            }
            if (!z10) {
                try {
                    for (Object obj : listB) {
                        if (str2.equals(X0(obj)) && !f12990v.equals(str2)) {
                            iA1 = a1(obj);
                            break;
                        }
                        iA1 = a1(obj);
                    }
                } catch (Exception e10) {
                    e = e10;
                    b.a("isTheMainScreen, exception: ", e, f12973e);
                }
            }
        } catch (Exception e11) {
            e = e11;
            iA1 = 0;
        }
        return iA1 == 0;
    }

    public final boolean e1(Object obj, String str) {
        try {
            String[] strArr = (String[]) cc.a.f(c(obj), obj);
            if (strArr != null && strArr.length > 0) {
                for (String str2 : strArr) {
                    if (str.equals(str2.split("/")[0])) {
                        return true;
                    }
                }
            }
        } catch (Exception e10) {
            b.a("isGivenStackInfoPackageName, exception: ", e10, f12973e);
        }
        return false;
    }

    public final boolean f(Object obj, String str) {
        return j(obj, str) || f1(obj, str);
    }

    @Override // bf.g
    public void f0(int i10) {
        cc.a.j(cc.a.g(f12975g, "boostSceneStart", Integer.TYPE), this.f12992a, Integer.valueOf(i10));
    }

    public final boolean f1(Object obj, String str) {
        try {
            Class clsA = cc.a.a("android.app.TaskInfo");
            ComponentName componentName = (ComponentName) cc.a.d(clsA, "topActivity").get(obj);
            if (componentName != null && str.equals(componentName.getClassName())) {
                return true;
            }
            ComponentName componentName2 = (ComponentName) cc.a.d(clsA, "realActivity").get(obj);
            return componentName2 != null && str.equals(componentName2.getClassName());
        } catch (Exception e10) {
            dc.e.a(f12973e, "getStackInfoTopClassName, Exception: " + e10.toString());
            return false;
        }
    }

    public final Class<?> g() {
        return cc.a.a("android.app.TaskInfo");
    }

    @Override // bf.g
    public void g0() {
        cc.a.j(cc.a.g(f12975g, "clearFinishFixedRotationWithTransaction", new Class[0]), this.f12992a, new Object[0]);
    }

    @Override // bf.g
    public void h(boolean z10, int i10) {
        cc.a.j(cc.a.g(f12975g, "startCurrentAppInMultiWindow", Boolean.TYPE, Integer.TYPE), this.f12992a, Boolean.valueOf(z10), Integer.valueOf(i10));
    }

    @Override // bf.g
    public ComponentName h0() {
        Object objJ = cc.a.j(cc.a.g(f12975g, "getTopActivityComponent", new Class[0]), this.f12992a, new Object[0]);
        if (objJ instanceof ComponentName) {
            return (ComponentName) objJ;
        }
        return null;
    }

    public final Configuration i(Object obj) {
        try {
            return (Configuration) cc.a.d(cc.a.a("android.app.ActivityManager$RunningTaskInfo"), "configuration").get(obj);
        } catch (Exception e10) {
            b.a("getRunningTaskInfoConfiguration, exception: ", e10, f12973e);
            return null;
        }
    }

    @Override // bf.g
    public HardwareBuffer i0(int i10, boolean z10) {
        Object objJ = cc.a.j(cc.a.g(cc.a.a("android.window.TaskSnapshot"), "getHardwareBuffer", new Class[0]), cc.a.j(cc.a.g(f12975g, "getTaskSnapshot", Integer.TYPE, Boolean.TYPE), this.f12992a, Integer.valueOf(i10), Boolean.FALSE), new Object[0]);
        if (objJ instanceof HardwareBuffer) {
            return (HardwareBuffer) objJ;
        }
        return null;
    }

    public final boolean j(Object obj, String str) {
        try {
            String[] strArr = (String[]) c(obj).get(obj);
            String str2 = "";
            if (strArr != null && strArr.length > 0) {
                for (String str3 : strArr) {
                    String[] strArrSplit = str3.split("/");
                    if (strArrSplit.length > 1) {
                        str2 = strArrSplit[1];
                    }
                    if (str.equals(str2)) {
                        return true;
                    }
                }
            }
        } catch (Exception e10) {
            b.a("getStackInfoClsName, exception: ", e10, f12973e);
        }
        return false;
    }

    @Override // bf.g
    public boolean j0(int i10) {
        Object objJ = cc.a.j(cc.a.g(f12975g, "taskInMultiWindowById", Integer.TYPE), this.f12992a, Integer.valueOf(i10));
        if (objJ instanceof Boolean) {
            return ((Boolean) objJ).booleanValue();
        }
        return false;
    }

    @Override // bf.g
    public void k(int i10, int i11, boolean z10) {
        Object obj = this.f12992a;
        if (obj != null) {
            Class<?> cls = obj.getClass();
            Class cls2 = Integer.TYPE;
            cc.a.j(cc.a.g(cls, "reparentActivity", cls2, cls2, Boolean.TYPE), this.f12992a, Integer.valueOf(i10), Integer.valueOf(i11), Boolean.valueOf(z10));
        }
    }

    @Override // bf.g
    public void k0(IBinder iBinder) {
        Object obj;
        Method methodG = cc.a.g(f12975g, "registerMultiWindowWmShellListener", IBinder.class);
        if (methodG == null || (obj = this.f12992a) == null) {
            return;
        }
        cc.a.j(methodG, obj, iBinder);
    }

    @Override // bf.g
    public void l(int i10, boolean z10) {
        cc.a.j(cc.a.g(f12975g, "setMultiWindowAcquireFocus", Integer.TYPE, Boolean.TYPE), this.f12992a, Integer.valueOf(i10), Boolean.valueOf(z10));
    }

    @Override // bf.g
    public void l0(int[] iArr) {
        Object obj = this.f12992a;
        if (obj != null) {
            cc.a.j(cc.a.g(obj.getClass(), "removeRootTasksInWindowingModes", int[].class), this.f12992a, iArr);
        }
    }

    @Override // bf.g
    public void m(int i10, int i11) {
        Object obj;
        Class<?> cls = f12975g;
        Class cls2 = Integer.TYPE;
        Method methodG = cc.a.g(cls, "setMultiWindowExtendSize", cls2, cls2);
        if (methodG == null || (obj = this.f12992a) == null) {
            return;
        }
        cc.a.j(methodG, obj, Integer.valueOf(i10), Integer.valueOf(i11));
    }

    @Override // bf.g
    public List<TranRootTaskInfo> m0(int i10) {
        Class clsA = cc.a.a("android.app.ActivityTaskManager$RootTaskInfo");
        Object objJ = cc.a.j(cc.a.g(f12975g, "getAllRootTaskInfosOnDisplay", Integer.TYPE), this.f12992a, Integer.valueOf(i10));
        ArrayList arrayList = new ArrayList();
        if (objJ instanceof List) {
            for (Object obj : (List) objJ) {
                if (obj.getClass().equals(clsA)) {
                    arrayList.add(clsA.cast(obj));
                }
            }
        }
        ArrayList arrayList2 = new ArrayList();
        for (Object obj2 : arrayList) {
            if (clsA.isInstance(obj2)) {
                dc.e.f(f12973e, "RootTaskInfo");
            }
            try {
                TranRootTaskInfo tranRootTaskInfo = new TranRootTaskInfo();
                tranRootTaskInfo.f2203b = (ComponentName) cc.a.d(cc.a.a("android.app.TaskInfo"), "topActivity").get(obj2);
                tranRootTaskInfo.f2204c = (Rect) cc.a.d(clsA, "bounds").get(obj2);
                tranRootTaskInfo.f2205d = (int[]) cc.a.d(clsA, "childTaskIds").get(obj2);
                tranRootTaskInfo.f2206e = (String[]) cc.a.d(clsA, "childTaskNames").get(obj2);
                tranRootTaskInfo.f2207f = (Rect[]) cc.a.d(clsA, "childTaskBounds").get(obj2);
                tranRootTaskInfo.f2208g = (int[]) cc.a.d(clsA, "childTaskUserIds").get(obj2);
                tranRootTaskInfo.f2209i = cc.a.d(clsA, "visible").getBoolean(obj2);
                tranRootTaskInfo.f2210n = cc.a.d(clsA, "position").getInt(obj2);
                tranRootTaskInfo.f2211p = d1(c1((Configuration) cc.a.d(cc.a.a("android.app.TaskInfo"), "configuration").get(obj2)));
                tranRootTaskInfo.f2212v = cc.a.d(cc.a.a("android.app.TaskInfo"), "taskId").getInt(obj2);
                arrayList2.add(tranRootTaskInfo);
            } catch (Exception unused) {
                dc.e.c(f12973e, "RootTaskInfo fail:" + obj2);
            }
        }
        return arrayList2;
    }

    @Override // bf.g
    public boolean n(String str) {
        Object objJ = cc.a.j(cc.a.g(f12975g, "activityInMultiWindow", String.class), this.f12992a, str);
        if (objJ instanceof Boolean) {
            return ((Boolean) objJ).booleanValue();
        }
        return false;
    }

    @Override // bf.g
    public int n0(String str, String str2) {
        Object objC1;
        int iD1 = -2;
        try {
            for (Object obj : b()) {
                if (e1(obj, str) || str.equals(Y0(obj))) {
                    if (f(obj, str2)) {
                        Configuration configurationE = e(obj);
                        if (configurationE == null || (objC1 = c1(configurationE)) == null) {
                            return -2;
                        }
                        iD1 = d1(objC1);
                        dc.e.a(f12973e, "mode = " + iD1 + " clsname = " + str2);
                        return iD1;
                    }
                }
            }
            return -2;
        } catch (Exception e10) {
            b.a("getGivenPkgWindowModeForCls, exception: ", e10, f12973e);
            return iD1;
        }
    }

    @Override // bf.g
    public boolean o() {
        Object objJ = cc.a.j(cc.a.g(f12975g, "isIMEShowing", new Class[0]), this.f12992a, new Object[0]);
        if (objJ instanceof Boolean) {
            return ((Boolean) objJ).booleanValue();
        }
        return false;
    }

    @Override // bf.g
    public boolean o0(String str) {
        ComponentName componentName;
        Configuration configurationI;
        Object objC1;
        for (ActivityManager.RunningTaskInfo runningTaskInfo : ((ActivityManager) this.f12995d.getSystemService("activity")).getRunningTasks(2)) {
            if (runningTaskInfo != null && (componentName = runningTaskInfo.topActivity) != null && str.equals(componentName.getClassName()) && (configurationI = i(runningTaskInfo)) != null && (objC1 = c1(configurationI)) != null) {
                int iD1 = d1(objC1);
                dc.e.a(f12973e, "getVideoNotFullscreen  mode = " + iD1);
                return iD1 != 1;
            }
        }
        return true;
    }

    @Override // bf.g
    public SurfaceControl p(int i10, int i11, int i12, int i13, boolean z10) {
        Class<?> cls = f12975g;
        Class cls2 = Integer.TYPE;
        Object objJ = cc.a.j(cc.a.g(cls, "getDragAndZoomBgLeash", cls2, cls2, cls2, cls2, Boolean.TYPE), this.f12992a, Integer.valueOf(i10), Integer.valueOf(i11), Integer.valueOf(i12), Integer.valueOf(i13), Boolean.valueOf(z10));
        if (objJ instanceof SurfaceControl) {
            return (SurfaceControl) objJ;
        }
        return null;
    }

    @Override // bf.g
    public void p0(boolean z10) {
        Object obj;
        Method methodG = cc.a.g(f12975g, "notifyAuthenticateSucceed", Boolean.TYPE);
        if (methodG == null || (obj = this.f12992a) == null) {
            return;
        }
        cc.a.j(methodG, obj, Boolean.valueOf(z10));
    }

    @Override // bf.g
    public List<ActivityManager.RunningTaskInfo> q(int i10, boolean z10, boolean z11) {
        Object objJ;
        if (fc.a.f()) {
            Class<?> cls = f12975g;
            Class cls2 = Integer.TYPE;
            Class cls3 = Boolean.TYPE;
            objJ = cc.a.j(cc.a.g(cls, "getTasks", cls2, cls3, cls3, cls2), this.f12992a, Integer.valueOf(i10), Boolean.valueOf(z10), Boolean.valueOf(z11), -1);
        } else {
            Class<?> cls4 = f12975g;
            Class cls5 = Integer.TYPE;
            Class cls6 = Boolean.TYPE;
            objJ = cc.a.j(cc.a.g(cls4, "getTasks", cls5, cls6, cls6), this.f12992a, Integer.valueOf(i10), Boolean.valueOf(z10), Boolean.valueOf(z11));
        }
        ArrayList arrayList = new ArrayList();
        if (objJ instanceof List) {
            Iterator it = ((List) objJ).iterator();
            while (it.hasNext()) {
                arrayList.add((ActivityManager.RunningTaskInfo) ActivityManager.RunningTaskInfo.class.cast(it.next()));
            }
        }
        return arrayList;
    }

    @Override // bf.g
    public boolean q0(String str) {
        try {
            for (Object obj : b()) {
                if (str.equals(X0(obj)) && f12989u.equals(Y0(obj))) {
                    return true;
                }
            }
            return false;
        } catch (Exception e10) {
            b.a("getNeedExit, exception: ", e10, f12973e);
            return false;
        }
    }

    @Override // bf.g
    public void r(int i10) {
        Object obj;
        Method methodG = cc.a.g(f12975g, "clearMultiWindowExtendSize", Integer.TYPE);
        if (methodG == null || (obj = this.f12992a) == null) {
            return;
        }
        cc.a.j(methodG, obj, Integer.valueOf(i10));
    }

    @Override // bf.g
    public Rect r0(int i10) {
        Object objJ = cc.a.j(cc.a.g(f12975g, "hookGetMultiWindowDefaultRect", Integer.TYPE), this.f12992a, Integer.valueOf(i10));
        if (objJ instanceof Rect) {
            return (Rect) objJ;
        }
        return null;
    }

    @Override // bf.g
    public Rect s() {
        Object obj;
        Method methodG = cc.a.g(f12975g, "getMultiWindowDefaultRect", new Class[0]);
        if (methodG == null || (obj = this.f12992a) == null) {
            return null;
        }
        return (Rect) cc.a.j(methodG, obj, new Object[0]);
    }

    @Override // bf.g
    public void s0(SurfaceControl surfaceControl, String str) {
        Object obj;
        Method methodG = cc.a.g(f12975g, "hookShowBlurLayer", SurfaceControl.class, String.class);
        if (methodG == null || (obj = this.f12992a) == null) {
            return;
        }
        cc.a.j(methodG, obj, surfaceControl, str);
    }

    @Override // bf.g
    public boolean t(int i10) {
        Object objJ = cc.a.j(cc.a.g(f12975g, "getMuteStateV4", Integer.TYPE), this.f12992a, Integer.valueOf(i10));
        if (objJ instanceof Boolean) {
            return ((Boolean) objJ).booleanValue();
        }
        return false;
    }

    @Override // bf.g
    public void t0(int i10, int i11) {
        Object obj;
        Class<?> cls = f12975g;
        Class cls2 = Integer.TYPE;
        Method methodG = cc.a.g(cls, "hookMultiWindowToExchange", cls2, cls2);
        if (methodG == null || (obj = this.f12992a) == null) {
            return;
        }
        cc.a.j(methodG, obj, Integer.valueOf(i10), Integer.valueOf(i11));
    }

    @Override // bf.g
    public List<String> u() {
        Object objJ = cc.a.j(cc.a.g(f12975g, "getMultiWindowBlackList", new Class[0]), this.f12992a, new Object[0]);
        ArrayList arrayList = new ArrayList();
        if (objJ instanceof List) {
            Iterator it = ((List) objJ).iterator();
            while (it.hasNext()) {
                arrayList.add((String) String.class.cast(it.next()));
            }
        }
        return arrayList;
    }

    @Override // bf.g
    public boolean u0() {
        Object objJ = cc.a.j(cc.a.g(f12978j, "asInterface", IBinder.class), null, cc.a.j(cc.a.g(f12977i, "getService", String.class), null, "activity_task"));
        Object objJ2 = objJ != null ? cc.a.j(cc.a.g(objJ.getClass(), "hasMultiWindow", new Class[0]), objJ, new Object[0]) : null;
        if (objJ2 instanceof Boolean) {
            return ((Boolean) objJ2).booleanValue();
        }
        return false;
    }

    @Override // bf.g
    public String v() {
        Object objJ = cc.a.j(cc.a.g(f12975g, "getFocusedWinPkgName", new Class[0]), this.f12992a, new Object[0]);
        if (objJ instanceof String) {
            return (String) objJ;
        }
        return null;
    }

    @Override // bf.g
    public void v0() {
        Object obj;
        Method methodG = cc.a.g(f12975g, "reparentTaskToDefaultTDA", new Class[0]);
        if (methodG == null || (obj = this.f12992a) == null) {
            return;
        }
        cc.a.j(methodG, obj, new Object[0]);
    }

    @Override // bf.g
    public boolean w(String str, boolean z10, boolean z11, long j10) {
        Object obj;
        Class<?> cls = f12975g;
        Class cls2 = Boolean.TYPE;
        Method methodG = cc.a.g(cls, "checkAndUpdateEventStateForMulti", String.class, cls2, cls2, Long.TYPE);
        if (methodG == null || (obj = this.f12992a) == null) {
            return true;
        }
        return Boolean.TRUE.equals(cc.a.j(methodG, obj, str, Boolean.valueOf(z10), Boolean.valueOf(z11), Long.valueOf(j10)));
    }

    @Override // bf.g
    public void w0(boolean z10, int i10) {
        cc.a.j(cc.a.g(f12975g, "setMuteStateV4", Boolean.TYPE, Integer.TYPE), this.f12992a, Boolean.valueOf(z10), Integer.valueOf(i10));
    }

    @Override // bf.g
    public boolean x(int i10) {
        Object objJ = cc.a.j(cc.a.g(f12975g, "removeTask", Integer.TYPE), this.f12992a, Integer.valueOf(i10));
        if (objJ instanceof Boolean) {
            return ((Boolean) objJ).booleanValue();
        }
        return false;
    }

    @Override // bf.g
    public void x0(SurfaceControl surfaceControl, float[] fArr, float[] fArr2, int i10) {
        cc.a.j(cc.a.g(f12975g, "setFinishFixedRotationWithTransaction", SurfaceControl.class, float[].class, float[].class, Integer.TYPE), this.f12992a, surfaceControl, fArr, fArr2, Integer.valueOf(i10));
    }

    @Override // bf.g
    public int y(String str, int i10) {
        Object obj;
        Method methodG = cc.a.g(f12975g, "getTaskIdByPkgName", String.class, Integer.TYPE);
        if (methodG != null && (obj = this.f12992a) != null) {
            Object objJ = cc.a.j(methodG, obj, str, Integer.valueOf(i10));
            if (objJ instanceof Integer) {
                return ((Integer) objJ).intValue();
            }
        }
        return -1;
    }

    @Override // bf.g
    public ActivityManager.RunningTaskInfo y0(int i10) {
        Object objJ = cc.a.j(cc.a.g(f12975g, "getTopTask", Integer.TYPE), this.f12992a, Integer.valueOf(i10));
        if (objJ instanceof ActivityManager.RunningTaskInfo) {
            return (ActivityManager.RunningTaskInfo) objJ;
        }
        return null;
    }

    @Override // bf.g
    public int z(String str) {
        Object objC1;
        for (Object obj : b()) {
            if (str.equals(X0(obj))) {
                Configuration configurationE = e(obj);
                if (((configurationE == null || (objC1 = c1(configurationE)) == null) ? -1 : d1(objC1)) != 5) {
                    return -1;
                }
                int iZ0 = Z0(obj);
                dc.e.a(f12973e, "taskId = " + iZ0);
                return iZ0;
            }
        }
        return -1;
    }

    @Override // bf.g
    public void z0(String str, boolean z10) {
        Object obj;
        Method methodG = cc.a.g(f12975g, "updateMediaMapForDynamicIsland", String.class, Boolean.TYPE);
        if (methodG == null || (obj = this.f12992a) == null) {
            dc.e.n(f12973e, "Method updateMediaMapForDynamicIsland not found in sClass or mObject is null");
        } else {
            cc.a.j(methodG, obj, str, Boolean.valueOf(z10));
        }
    }
}
