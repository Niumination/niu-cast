package p6;

import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.UserHandle;
import android.util.ArrayMap;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/* JADX INFO: loaded from: classes2.dex */
public class e implements bf.d {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final String f12939g = "e";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static Class<?> f12940h = cc.a.a("android.app.IActivityManager");

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static Class<?> f12941i = cc.a.a(x8.a.f20121d);

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final String f12942j = "This interface is not implemented in versions lower than U";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayMap<h9.g.c, c> f12943a = new ArrayMap<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ArrayMap<h9.s, f.g> f12944b = new ArrayMap<>();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ArrayMap<h9.u, f.h> f12945c = new ArrayMap<>();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Context f12946d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Method f12947e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final f f12948f;

    public class a implements f.h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ h9.u f12949a;

        public a(h9.u uVar) {
            this.f12949a = uVar;
        }

        @Override // p6.f.h
        public void a(int i10) {
            this.f12949a.a(i10);
        }

        @Override // p6.f.h
        public void b(int i10) {
            this.f12949a.b(i10);
        }
    }

    public class b implements f.g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ h9.s f12951a;

        public b(h9.s sVar) {
            this.f12951a = sVar;
        }

        @Override // p6.f.g
        public void a(int i10, boolean z10) {
            dc.e.a(e.f12939g, "onTaskFocusChanged listener" + this.f12951a);
            this.f12951a.a(i10, z10);
        }

        @Override // p6.f.g
        public void b(int i10) {
            dc.e.a(e.f12939g, "onLockTaskModeChanged listener" + this.f12951a);
            this.f12951a.b(i10);
        }

        @Override // p6.f.g
        public void c(int i10, ComponentName componentName) {
            dc.e.a(e.f12939g, "onTaskCreated listener" + this.f12951a);
            this.f12951a.c(i10, componentName);
        }
    }

    public static class c implements f.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public h9.g.c f12953a;

        public c(h9.g.c cVar) {
            this.f12953a = cVar;
        }

        @Override // p6.f.d
        public void a(int i10, int i11) {
            this.f12953a.a(i10, i11);
        }

        @Override // p6.f.d
        public void b(int i10, int i11, boolean z10) {
            this.f12953a.b(i10, i11, z10);
        }

        @Override // p6.f.d
        public void c(int i10, int i11, int i12) {
            this.f12953a.c(i10, i11, i12);
        }
    }

    public e() {
        Context contextA = bc.a.a();
        this.f12946d = contextA;
        this.f12948f = new f(contextA);
        this.f12947e = cc.a.g(f12941i, "getService", new Class[0]);
    }

    @Override // bf.d
    public void A(int i10, List<String> list) {
        cc.a.j(cc.a.g(f12941i, "doClean", Integer.TYPE, List.class), cc.a.j(this.f12947e, null, new Object[0]), Integer.valueOf(i10), list);
    }

    @Override // bf.d
    public boolean A0(int i10) {
        return false;
    }

    @Override // bf.d
    public boolean B(int i10) {
        return false;
    }

    @Override // bf.d
    public void B0(h9.g.b bVar) throws ac.a {
        throw new ac.a("can not find method unRegisterAppRecoveryCallback");
    }

    @Override // bf.d
    public List<String> C() {
        ArrayList arrayList = new ArrayList();
        ActivityManager activityManager = (ActivityManager) this.f12946d.getSystemService("activity");
        Object objJ = cc.a.j(cc.a.g(activityManager.getClass(), "getCleanProtectList", new Class[0]), activityManager, new Object[0]);
        if (objJ instanceof List) {
            Iterator it = ((List) objJ).iterator();
            while (it.hasNext()) {
                arrayList.add((String) String.class.cast(it.next()));
            }
        }
        return arrayList;
    }

    @Override // bf.d
    public int C0(ActivityManager.RunningTaskInfo runningTaskInfo) {
        if (runningTaskInfo != null) {
            try {
                Object obj = cc.a.d(cc.a.a("android.app.TaskInfo"), "userId").get(runningTaskInfo);
                if (obj instanceof Integer) {
                    return ((Integer) obj).intValue();
                }
                return 0;
            } catch (Exception e10) {
                p6.b.a("getUserId fail: ", e10, f12939g);
            }
        }
        return 0;
    }

    @Override // bf.d
    public void D(String str, int i10) {
        Object objJ = cc.a.j(this.f12947e, null, new Object[0]);
        Method methodG = cc.a.g(f12940h, "stopAppForUser", String.class, Integer.TYPE);
        if (methodG != null) {
            cc.a.j(methodG, objJ, str, Integer.valueOf(i10));
        }
    }

    @Override // bf.d
    public boolean D0(long j10) {
        return false;
    }

    @Override // bf.d
    public int E(String str) {
        Object objJ = cc.a.j(this.f12947e, null, new Object[0]);
        Method methodG = cc.a.g(f12940h, "getMemoryForMF", String.class);
        if (methodG != null) {
            return ((Integer) cc.a.j(methodG, objJ, str)).intValue();
        }
        return -1;
    }

    @Override // bf.d
    public boolean E0() {
        Object objJ = cc.a.j(this.f12947e, null, new Object[0]);
        Method methodG = cc.a.g(f12940h, "isMemSettingEnterEnabled", new Class[0]);
        if (methodG != null) {
            return Boolean.TRUE.equals(cc.a.j(methodG, objJ, new Object[0]));
        }
        return false;
    }

    @Override // bf.d
    public boolean F(String str, String str2) {
        ActivityManager activityManager = (ActivityManager) this.f12946d.getSystemService("activity");
        Object objJ = cc.a.j(cc.a.g(activityManager.getClass(), "isRequestChangeParams", String.class, String.class), activityManager, str, str2);
        if (objJ instanceof Boolean) {
            return ((Boolean) objJ).booleanValue();
        }
        return false;
    }

    @Override // bf.d
    public List<String> F0(int i10) {
        Object objJ = cc.a.j(this.f12947e, null, new Object[0]);
        Method methodG = cc.a.g(f12940h, "getTranGameList", Integer.TYPE);
        return methodG != null ? (List) cc.a.j(methodG, objJ, Integer.valueOf(i10)) : new ArrayList();
    }

    @Override // bf.d
    public void G(boolean z10) {
        Object objJ = cc.a.j(this.f12947e, null, new Object[0]);
        Method methodG = cc.a.g(f12940h, "switchMemFusion", Boolean.TYPE);
        if (methodG != null) {
            cc.a.j(methodG, objJ, Boolean.valueOf(z10));
        }
    }

    @Override // bf.d
    public void G0(boolean z10) {
        Object objJ = cc.a.j(this.f12947e, null, new Object[0]);
        Method methodG = cc.a.g(f12940h, "switchUXCompaction", Boolean.TYPE);
        if (methodG != null) {
            cc.a.j(methodG, objJ, Boolean.valueOf(z10));
        }
    }

    @Override // bf.d
    public int H(String str) {
        Object objJ = cc.a.j(this.f12947e, null, new Object[0]);
        Method methodG = cc.a.g(f12940h, "isMemoryEnoughToMF", String.class);
        if (methodG != null) {
            return ((Integer) cc.a.j(methodG, objJ, str)).intValue();
        }
        return -1;
    }

    @Override // bf.d
    public List<String> H0(int i10, String str, boolean z10) {
        return Collections.emptyList();
    }

    @Override // bf.d
    public boolean I() {
        Object objJ = cc.a.j(cc.a.g(f12941i, "isLowRamDeviceStatic", new Class[0]), f12941i, new Object[0]);
        if (objJ instanceof Boolean) {
            return ((Boolean) objJ).booleanValue();
        }
        return false;
    }

    @Override // bf.d
    public int I0(IBinder iBinder) {
        Method methodG = cc.a.g(f12940h, "getLaunchedFromUid", IBinder.class);
        this.f12947e.setAccessible(true);
        Object objJ = cc.a.j(methodG, cc.a.j(this.f12947e, null, new Object[0]), iBinder);
        if (objJ instanceof Integer) {
            return ((Integer) objJ).intValue();
        }
        return 0;
    }

    @Override // bf.d
    public boolean J(int i10, String str, String str2) {
        return false;
    }

    @Override // bf.d
    public void J0(int i10) {
        Object objJ = cc.a.j(cc.a.g(cc.a.a("com.transsion.app.ActivityManager"), "instance", new Class[0]), null, new Object[0]);
        if (objJ != null) {
            cc.a.j(cc.a.g(objJ.getClass(), "toggleFreeformWindowingMode", Integer.TYPE), objJ, Integer.valueOf(i10));
        }
    }

    @Override // bf.d
    public List<String> K() {
        Object objJ = cc.a.j(this.f12947e, null, new Object[0]);
        Method methodG = cc.a.g(f12940h, "getSwapFileSizeList", new Class[0]);
        if (methodG != null) {
            return (List) cc.a.j(methodG, objJ, new Object[0]);
        }
        return null;
    }

    @Override // bf.d
    public void K0(int i10) {
        Object objJ = cc.a.j(this.f12947e, null, new Object[0]);
        if (objJ != null) {
            cc.a.j(cc.a.g(objJ.getClass(), "backgroundAllowlistUid", Integer.TYPE), objJ, Integer.valueOf(i10));
        }
    }

    @Override // bf.d
    public void L(h9.g.c cVar) {
        c cVar2 = new c(cVar);
        this.f12943a.put(cVar, cVar2);
        this.f12948f.b(cVar2);
    }

    @Override // bf.d
    public void L0(List<String> list) throws ac.a {
        throw new ac.a(f12942j);
    }

    @Override // bf.d
    public void M(String str, String str2, boolean z10, List<String> list) {
        Object objJ = cc.a.j(this.f12947e, null, new Object[0]);
        Method methodG = cc.a.g(f12940h, "gameSceneStart", String.class, String.class, Boolean.TYPE, List.class);
        if (methodG != null) {
            cc.a.j(methodG, objJ, str, str2, Boolean.valueOf(z10), list);
        }
    }

    @Override // bf.d
    public boolean M0(int i10) {
        return false;
    }

    @Override // bf.d
    public boolean N(String str, boolean z10) {
        Object objJ = cc.a.j(cc.a.g(cc.a.a("com.transsion.hubcore.server.am.ITranActivityManagerService"), "Instance", new Class[0]), null, new Object[0]);
        if (objJ == null) {
            return false;
        }
        Object objJ2 = cc.a.j(cc.a.g(objJ.getClass(), "setETControl", String.class, Boolean.TYPE), objJ, str, Boolean.valueOf(z10));
        if (objJ2 instanceof Boolean) {
            return ((Boolean) objJ2).booleanValue();
        }
        return false;
    }

    @Override // bf.d
    public String N0(IBinder iBinder) {
        return (String) cc.a.j(cc.a.g(f12940h, "getLaunchedFromPackage", IBinder.class), cc.a.j(this.f12947e, null, new Object[0]), iBinder);
    }

    @Override // bf.d
    public long[] O() {
        dc.e.n(f12939g, "can not find method getKernelMemInfo");
        return null;
    }

    @Override // bf.d
    public void O0(int i10) {
        cc.a.j(cc.a.g(f12941i, "hookDisturbStatus", Integer.TYPE), cc.a.j(this.f12947e, null, new Object[0]), Integer.valueOf(i10));
    }

    @Override // bf.d
    public Bundle P() {
        dc.e.n(f12939g, "can not find method getNativeProcessRss");
        return null;
    }

    @Override // bf.d
    public void P0(h9.u uVar) {
        if (uVar != null) {
            this.f12948f.g(this.f12945c.get(uVar));
            this.f12945c.remove(uVar);
        }
    }

    @Override // bf.d
    public boolean Q(int i10, int i11) {
        Object objJ = cc.a.j(this.f12947e, null, new Object[0]);
        Class<?> cls = f12940h;
        Class cls2 = Integer.TYPE;
        Method methodG = cc.a.g(cls, "isUserRunning", cls2, cls2);
        if (methodG != null) {
            return Boolean.TRUE.equals(cc.a.j(methodG, objJ, Integer.valueOf(i10), Integer.valueOf(i11)));
        }
        dc.e.n(f12939g, "can not find method isUserRunning");
        return false;
    }

    @Override // bf.d
    public ComponentName Q0(ActivityManager.RunningTaskInfo runningTaskInfo) {
        if (runningTaskInfo != null) {
            try {
                Object obj = cc.a.d(cc.a.a("android.app.TaskInfo"), "realActivity").get(runningTaskInfo);
                if (obj instanceof ComponentName) {
                    return (ComponentName) obj;
                }
                return null;
            } catch (Exception e10) {
                p6.b.a("getRealActivity fail: ", e10, f12939g);
            }
        }
        return null;
    }

    @Override // bf.d
    public boolean R(int i10) {
        return false;
    }

    @Override // bf.d
    public void R0() {
        Object objJ = cc.a.j(cc.a.g(cc.a.a("com.transsion.app.ActivityManager"), "instance", new Class[0]), null, new Object[0]);
        if (objJ != null) {
            cc.a.j(cc.a.g(objJ.getClass(), "setCurrentActivityKeepAwake", new Class[0]), objJ, new Object[0]);
        }
    }

    @Override // bf.d
    public boolean S() {
        Object objJ = cc.a.j(this.f12947e, null, new Object[0]);
        Method methodG = cc.a.g(f12940h, "isGameGuardSupport", new Class[0]);
        if (methodG != null) {
            return ((Boolean) cc.a.j(methodG, objJ, new Object[0])).booleanValue();
        }
        return false;
    }

    @Override // bf.d
    public boolean S0(String str, String str2, String str3) {
        Object objJ = cc.a.j(this.f12947e, null, new Object[0]);
        Method methodG = cc.a.g(f12940h, "setGameParam", String.class, String.class, String.class);
        if (methodG != null) {
            return ((Boolean) cc.a.j(methodG, objJ, str, str2, str3)).booleanValue();
        }
        return false;
    }

    @Override // bf.d
    public void T(String str) {
        dc.e.n(f12939g, "can not find method setAudioPatch");
    }

    @Override // bf.d
    public long T0() {
        dc.e.n(f12939g, "can not find method calculateReclaimableMemory");
        return 0L;
    }

    @Override // bf.d
    public void U(boolean z10) throws ac.a {
        throw new ac.a(f12942j);
    }

    @Override // bf.d
    public boolean U0(UserHandle userHandle) {
        ActivityManager activityManager = (ActivityManager) this.f12946d.getSystemService("activity");
        Object objJ = cc.a.j(cc.a.g(activityManager.getClass(), "startProfile", UserHandle.class), activityManager, userHandle);
        if (objJ instanceof Boolean) {
            return ((Boolean) objJ).booleanValue();
        }
        return false;
    }

    @Override // bf.d
    public void V(h9.g.d dVar) throws ac.a {
        throw new ac.a("can not find method registerActivityStartObserver");
    }

    @Override // bf.d
    public Configuration V0(ActivityManager.RunningTaskInfo runningTaskInfo) {
        if (runningTaskInfo != null) {
            try {
                Object obj = cc.a.d(cc.a.a("android.app.TaskInfo"), "configuration").get(runningTaskInfo);
                if (obj instanceof Configuration) {
                    return (Configuration) obj;
                }
                return null;
            } catch (Exception e10) {
                p6.b.a("getConfigurationExt fail: ", e10, f12939g);
            }
        }
        return null;
    }

    @Override // bf.d
    public int W(String str, String str2) {
        Object objJ = cc.a.j(this.f12947e, null, new Object[0]);
        Method methodG = cc.a.g(f12940h, "getTargetFps", String.class, String.class);
        if (methodG != null) {
            return ((Integer) cc.a.j(methodG, objJ, str, str2)).intValue();
        }
        return 0;
    }

    @Override // bf.d
    public boolean W0() {
        return false;
    }

    @Override // bf.d
    public boolean X(int i10) {
        Class clsA = cc.a.a("android.os.ServiceManager");
        Object objJ = cc.a.j(cc.a.g(clsA, "getService", String.class), clsA, "activity");
        IBinder iBinder = objJ instanceof IBinder ? (IBinder) objJ : null;
        String str = f12939g;
        dc.e.a(str, "binder is ".concat(iBinder == null ? d6.a.E : "not null"));
        Class clsA2 = cc.a.a("android.app.IActivityManager$Stub");
        Object objJ2 = cc.a.j(cc.a.g(clsA2, "asInterface", IBinder.class), clsA2, iBinder);
        dc.e.a(str, "object is ".concat(objJ2 == null ? d6.a.E : "not null"));
        boolean zBooleanValue = false;
        if (objJ2 != null) {
            Object objJ3 = cc.a.j(cc.a.g(objJ2.getClass(), "startUserInBackground", Integer.TYPE), objJ2, Integer.valueOf(i10));
            zBooleanValue = objJ3 instanceof Boolean ? ((Boolean) objJ3).booleanValue() : false;
            dc.e.a(str, objJ2.getClass().getName() + " result: " + zBooleanValue);
        }
        return zBooleanValue;
    }

    @Override // bf.d
    public Locale X0() {
        Object objJ = cc.a.j(cc.a.g(cc.a.a("android.app.ActivityManagerNative"), "getDefault", new Class[0]), null, new Object[0]);
        Object objJ2 = cc.a.j(cc.a.g(objJ.getClass(), "getConfiguration", new Class[0]), objJ, new Object[0]);
        return (Locale) cc.a.f(cc.a.d(objJ2.getClass(), "locale"), objJ2);
    }

    @Override // bf.d
    public void Y(int[] iArr) throws ac.a {
        throw new ac.a("can not find method setLightingEffect");
    }

    @Override // bf.d
    public void Y0(h9.s sVar) {
        b bVar = new b(sVar);
        this.f12944b.put(sVar, bVar);
        this.f12948f.c(bVar);
    }

    @Override // bf.d
    public boolean Z(int i10) {
        return false;
    }

    @Override // bf.d
    public boolean Z0(int i10) {
        return false;
    }

    @Override // bf.d
    public boolean a(int i10) {
        Class clsA = cc.a.a("android.app.WindowConfiguration");
        String str = f12939g;
        dc.e.c(str, "sWindowConfigurationClass： " + clsA);
        Method methodG = cc.a.g(clsA, "inMultiWindowMode", Integer.TYPE);
        dc.e.c(str, "inMultiWindowMode： " + methodG);
        Object objJ = cc.a.j(methodG, clsA, Integer.valueOf(i10));
        boolean zBooleanValue = objJ instanceof Boolean ? ((Boolean) objJ).booleanValue() : false;
        dc.e.c(str, "obj： " + objJ);
        return zBooleanValue;
    }

    @Override // bf.d
    public boolean a0() {
        return false;
    }

    @Override // bf.d
    public boolean b(String str) {
        ActivityManager activityManager = (ActivityManager) this.f12946d.getSystemService("activity");
        Method methodG = cc.a.g(activityManager.getClass(), "isWhiteApp", String.class);
        if (methodG != null) {
            return ((Boolean) cc.a.j(methodG, activityManager, str)).booleanValue();
        }
        return false;
    }

    @Override // bf.d
    public boolean b0() {
        Object objJ = cc.a.j(this.f12947e, null, new Object[0]);
        Method methodG = cc.a.g(f12940h, "isMatchCurMemSelection", new Class[0]);
        if (methodG != null) {
            return ((Boolean) cc.a.j(methodG, objJ, new Object[0])).booleanValue();
        }
        return false;
    }

    @gm.i
    public Context b1() {
        return this.f12946d;
    }

    @Override // bf.d
    public void c(int i10, int i11) {
        ActivityManager activityManager = (ActivityManager) this.f12946d.getSystemService("activity");
        Class<?> cls = activityManager.getClass();
        Class cls2 = Integer.TYPE;
        cc.a.j(cc.a.g(cls, "setAppMode", cls2, cls2), activityManager, Integer.valueOf(i10), Integer.valueOf(i11));
    }

    @Override // bf.d
    public int c0(ActivityManager.RunningTaskInfo runningTaskInfo) {
        if (runningTaskInfo != null) {
            try {
                Object obj = cc.a.d(cc.a.a("android.app.TaskInfo"), "topActivityType").get(runningTaskInfo);
                if (obj instanceof Integer) {
                    return ((Integer) obj).intValue();
                }
                return 0;
            } catch (Exception e10) {
                p6.b.a("getTopActivityType fail: ", e10, f12939g);
            }
        }
        return 0;
    }

    public final Class<?> c1() {
        return cc.a.a("android.app.TaskInfo");
    }

    @Override // bf.d
    public int[] d(int i10) {
        ActivityManager activityManager = (ActivityManager) this.f12946d.getSystemService("activity");
        return (int[]) cc.a.j(cc.a.g(activityManager.getClass(), "getAppListMode", Integer.TYPE), activityManager, Integer.valueOf(i10));
    }

    @Override // bf.d
    public void d0(h9.u uVar, String str) {
        if (uVar != null) {
            a aVar = new a(uVar);
            this.f12948f.d(aVar, str);
            this.f12945c.put(uVar, aVar);
        }
    }

    @Override // bf.d
    public void e(boolean z10) {
        ActivityManager activityManager = (ActivityManager) this.f12946d.getSystemService("activity");
        cc.a.j(cc.a.g(activityManager.getClass(), "enableHiber", Boolean.TYPE), activityManager, Boolean.valueOf(z10));
    }

    @Override // bf.d
    public int e0(ActivityManager.RunningTaskInfo runningTaskInfo) {
        if (runningTaskInfo != null) {
            try {
                Object obj = cc.a.d(cc.a.a("android.app.TaskInfo"), "displayId").get(runningTaskInfo);
                if (obj instanceof Integer) {
                    return ((Integer) obj).intValue();
                }
                return 0;
            } catch (Exception e10) {
                p6.b.a("getDisplayId fail: ", e10, f12939g);
            }
        }
        return 0;
    }

    @Override // bf.d
    public boolean f() {
        ActivityManager activityManager = (ActivityManager) this.f12946d.getSystemService("activity");
        Method methodG = cc.a.g(activityManager.getClass(), "isEnabledHiber", new Class[0]);
        if (methodG != null) {
            return ((Boolean) cc.a.j(methodG, activityManager, new Object[0])).booleanValue();
        }
        return false;
    }

    @Override // bf.d
    public List<String> f0(String str) {
        Object objJ = cc.a.j(this.f12947e, null, new Object[0]);
        Method methodG = cc.a.g(f12940h, "getMEMCList", String.class);
        return methodG != null ? (List) cc.a.j(methodG, objJ, str) : new ArrayList();
    }

    @Override // bf.d
    public String g(String str) {
        Method methodG;
        Object objJ;
        Method methodG2;
        Class clsA = cc.a.a("com.transsion.hubsdk.TranServiceManager");
        if (clsA == null || (methodG = cc.a.g(clsA, "getServiceIBinder", String.class)) == null) {
            return "unknown";
        }
        IBinder iBinder = (IBinder) cc.a.j(methodG, null, "activity");
        Class clsA2 = cc.a.a("com.transsion.hubsdk.app.ITranActivityManager$Stub");
        return (iBinder == null || clsA2 == null || (objJ = cc.a.j(cc.a.g(clsA2, "asInterface", IBinder.class), clsA2, iBinder)) == null || (methodG2 = cc.a.g(objJ.getClass(), "getTranAppmSystemInfo", String.class)) == null) ? "unknown" : (String) cc.a.j(methodG2, objJ, str);
    }

    @Override // bf.d
    public boolean g0() {
        Object objJ = cc.a.j(this.f12947e, null, new Object[0]);
        Method methodG = cc.a.g(f12940h, "isUxCompactionSupport", new Class[0]);
        if (methodG != null) {
            return ((Boolean) cc.a.j(methodG, objJ, new Object[0])).booleanValue();
        }
        return false;
    }

    @Override // bf.d
    public void h(int i10, int[] iArr, Bundle bundle) throws ac.a {
        throw new ac.a("can not find method setLightingScene");
    }

    @Override // bf.d
    public void h0(h9.g.a aVar, IBinder iBinder) throws ac.a {
        throw new ac.a("can not find method registerAppRecoveryCallback");
    }

    @Override // bf.d
    public boolean i(int i10) {
        return false;
    }

    @Override // bf.d
    public void i0(String str) {
        Object objJ = cc.a.j(this.f12947e, null, new Object[0]);
        Method methodG = cc.a.g(f12940h, "changeCompactionMem", String.class);
        if (methodG != null) {
            cc.a.j(methodG, objJ, str);
        }
    }

    @Override // bf.d
    public int j(ActivityManager.RunningTaskInfo runningTaskInfo) {
        if (runningTaskInfo != null) {
            try {
                Object objJ = cc.a.j(cc.a.g(cc.a.a("android.app.TaskInfo"), "getWindowingMode", new Class[0]), runningTaskInfo, new Object[0]);
                if (objJ instanceof Integer) {
                    return ((Integer) objJ).intValue();
                }
                return 0;
            } catch (Exception e10) {
                p6.b.a("getWindowingMode fail: ", e10, f12939g);
            }
        }
        return 0;
    }

    @Override // bf.d
    public boolean j0(String[] strArr, h9.g.d dVar) throws ac.a {
        throw new ac.a("can not find method registerActivityStartObserver");
    }

    @Override // bf.d
    public void k(String str) {
        try {
            cc.a.j(cc.a.g(f12941i, "forceStopPackage", String.class), (ActivityManager) cc.a.c(f12941i, new Class[]{Context.class, Handler.class}).newInstance(b1(), null), str);
        } catch (Exception e10) {
            p6.b.a("forceStopPackage fail: ", e10, f12939g);
        }
    }

    @Override // bf.d
    public void k0(String str, int i10, int i11) throws ac.a {
        throw new ac.a(f12942j);
    }

    @Override // bf.d
    public int l() {
        Object objJ = cc.a.j(cc.a.g(f12941i, "getLockTaskModeState", new Class[0]), (ActivityManager) this.f12946d.getSystemService("activity"), new Object[0]);
        if (objJ instanceof Integer) {
            return ((Integer) objJ).intValue();
        }
        return 0;
    }

    @Override // bf.d
    public int l0() {
        try {
            Object objJ = cc.a.j(cc.a.g(f12941i, "getCurrentUser", new Class[0]), (ActivityManager) cc.a.c(f12941i, new Class[]{Context.class, Handler.class}).newInstance(b1(), null), new Object[0]);
            if (objJ instanceof Integer) {
                return ((Integer) objJ).intValue();
            }
            return 0;
        } catch (Exception e10) {
            p6.b.a("getCurrentUser fail: ", e10, f12939g);
            return 0;
        }
    }

    @Override // bf.d
    public boolean m() {
        return false;
    }

    @Override // bf.d
    public int m0(int i10) {
        Object objJ = cc.a.j(this.f12947e, null, new Object[0]);
        Method methodG = cc.a.g(f12940h, "getBackgroundRestrictionExemptionReason", Integer.TYPE);
        if (methodG != null) {
            return ((Integer) cc.a.j(methodG, objJ, Integer.valueOf(i10))).intValue();
        }
        return -1;
    }

    @Override // bf.d
    public void n() {
        Object objJ = cc.a.j(this.f12947e, null, new Object[0]);
        Method methodG = cc.a.g(f12940h, "resumeAppSwitches", new Class[0]);
        if (methodG != null) {
            cc.a.j(methodG, objJ, new Object[0]);
        }
    }

    @Override // bf.d
    public int n0() {
        return 0;
    }

    @Override // bf.d
    public boolean o(ActivityManager.RunningTaskInfo runningTaskInfo) {
        if (runningTaskInfo != null) {
            try {
                Object obj = cc.a.d(cc.a.a("android.app.TaskInfo"), "isVisible").get(runningTaskInfo);
                if (obj instanceof Boolean) {
                    return ((Boolean) obj).booleanValue();
                }
                return false;
            } catch (Exception e10) {
                p6.b.a("isVisible fail: ", e10, f12939g);
            }
        }
        return false;
    }

    @Override // bf.d
    public void o0(h9.g.b bVar) throws ac.a {
        throw new ac.a("can not find method unRegisterAppRecoveryCallback");
    }

    @Override // bf.d
    public ActivityInfo p() {
        try {
            List<ActivityManager.RunningTaskInfo> runningTasks = ((ActivityManager) this.f12946d.getSystemService("activity")).getRunningTasks(1);
            if (runningTasks != null && !runningTasks.isEmpty()) {
                ActivityManager.RunningTaskInfo runningTaskInfo = runningTasks.get(0);
                Object obj = cc.a.d(runningTaskInfo.getClass(), "topActivityInfo").get(runningTaskInfo);
                if (obj instanceof ActivityInfo) {
                    return (ActivityInfo) obj;
                }
                return null;
            }
        } catch (Exception e10) {
            p6.b.a("getTopActivityInfo fail: ", e10, f12939g);
        }
        return null;
    }

    @Override // bf.d
    public boolean p0() {
        try {
            Object objJ = cc.a.j(cc.a.g(f12941i, "isInLockTaskMode", new Class[0]), (ActivityManager) cc.a.c(f12941i, new Class[]{Context.class, Handler.class}).newInstance(b1(), null), new Object[0]);
            if (objJ instanceof Boolean) {
                return ((Boolean) objJ).booleanValue();
            }
            return false;
        } catch (Exception e10) {
            p6.b.a("isInLockTaskMode fail ", e10, f12939g);
            return false;
        }
    }

    @Override // bf.d
    public void q(h9.g.c cVar) {
        c cVar2 = this.f12943a.get(cVar);
        if (cVar2 != null) {
            this.f12948f.e(cVar2);
            this.f12943a.remove(cVar2);
        }
    }

    @Override // bf.d
    public boolean q0(String str, String str2, int i10) {
        return false;
    }

    @Override // bf.d
    public boolean r(String str, int i10) {
        return false;
    }

    @Override // bf.d
    public void r0(String str, boolean z10) {
        Object objJ = cc.a.j(this.f12947e, null, new Object[0]);
        Method methodG = cc.a.g(f12940h, "gameSceneEnd", String.class, Boolean.TYPE);
        if (methodG != null) {
            cc.a.j(methodG, objJ, str, Boolean.valueOf(z10));
        }
    }

    @Override // bf.d
    public boolean s(long j10) {
        return false;
    }

    @Override // bf.d
    public boolean s0(boolean z10) {
        return false;
    }

    @Override // bf.d
    public void t(h9.s sVar) {
        this.f12948f.f(this.f12944b.get(sVar));
        this.f12944b.remove(sVar);
    }

    @Override // bf.d
    public boolean t0(@gm.i String str, f.c cVar) {
        ActivityManager activityManager = (ActivityManager) this.f12946d.getSystemService("activity");
        Object objJ = cc.a.j(cc.a.g(activityManager.getClass(), "clearApplicationUserData", String.class, cc.a.a("android.content.pm.IPackageDataObserver")), activityManager, str, new f.C0325f(cVar));
        if (objJ instanceof Boolean) {
            return ((Boolean) objJ).booleanValue();
        }
        return false;
    }

    @Override // bf.d
    public Bundle u() {
        dc.e.n(f12939g, "can not find method getJavaProcessRss");
        return null;
    }

    @Override // bf.d
    public boolean u0(String str, boolean z10) {
        ActivityManager activityManager = (ActivityManager) this.f12946d.getSystemService("activity");
        Object objJ = cc.a.j(cc.a.g(activityManager.getClass(), "setCleanProtect", String.class, Boolean.TYPE), activityManager, str, Boolean.valueOf(z10));
        if (objJ instanceof Boolean) {
            return ((Boolean) objJ).booleanValue();
        }
        return false;
    }

    @Override // bf.d
    public void v(IBinder iBinder) throws ac.a {
        throw new ac.a("can not find method unRegisterAppRecoveryCallback");
    }

    @Override // bf.d
    public boolean v0(String str, int i10) {
        return false;
    }

    @Override // bf.d
    public boolean w(String str, String str2, int i10) {
        return false;
    }

    @Override // bf.d
    public boolean w0(int i10) {
        return false;
    }

    @Override // bf.d
    public void x(boolean z10) throws ac.a {
        Method methodG;
        Object objJ;
        Class clsA = cc.a.a("com.transsion.hubsdk.TranServiceManager");
        if (clsA == null || (methodG = cc.a.g(clsA, "getServiceIBinder", String.class)) == null) {
            return;
        }
        IBinder iBinder = (IBinder) cc.a.j(methodG, null, "activity");
        Class clsA2 = cc.a.a("com.transsion.hubsdk.app.ITranActivityManager$Stub");
        if (iBinder == null || clsA2 == null || (objJ = cc.a.j(cc.a.g(clsA2, "asInterface", IBinder.class), clsA2, iBinder)) == null) {
            return;
        }
        cc.a.j(cc.a.g(objJ.getClass(), "setLedMusicPlay", Boolean.TYPE), objJ, Boolean.valueOf(z10));
    }

    @Override // bf.d
    public void x0(Bundle bundle, String str, String str2) {
    }

    @Override // bf.d
    public void y(String str, long j10, int i10, String str2) {
        cc.a.j(cc.a.g(f12940h, "startTNE", String.class, Long.TYPE, Integer.TYPE, String.class), cc.a.j(this.f12947e, null, new Object[0]), str, Long.valueOf(j10), Integer.valueOf(i10), str2);
    }

    @Override // bf.d
    public boolean y0(String str, String str2) {
        dc.e.n(f12939g, "can not find method sendMallocDebugSignal");
        return false;
    }

    @Override // bf.d
    public boolean z(String str) {
        Object objJ = cc.a.j(this.f12947e, null, new Object[0]);
        Method methodG = cc.a.g(f12940h, "isInGameGuardProtectedList", String.class);
        if (methodG != null) {
            return ((Boolean) cc.a.j(methodG, objJ, str)).booleanValue();
        }
        return false;
    }

    @Override // bf.d
    public boolean z0(long j10) {
        return false;
    }
}
