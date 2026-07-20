package ic;

import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.hardware.HardwareBuffer;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.view.SurfaceControl;
import com.android.internal.annotations.VisibleForTesting;
import com.transsion.hubsdk.TranServiceManager;
import com.transsion.hubsdk.api.app.TranRootTaskInfo;
import com.transsion.hubsdk.api.window.TranTaskSnapshot;
import com.transsion.hubsdk.app.ITranActivityController;
import com.transsion.hubsdk.app.ITranActivityTaskManager;
import com.transsion.hubsdk.window.ITranWindowContainerTransactionCallback;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class f1 implements bf.g {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f7798c = "f1";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public h9.a f7800b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ITranActivityTaskManager f7799a = ITranActivityTaskManager.Stub.asInterface(TranServiceManager.getServiceIBinder("activity_task"));

    public class a extends ITranActivityController.Stub {
        public a() {
        }

        public boolean a(String str) throws RemoteException {
            if (f1.this.f7800b != null) {
                return f1.this.f7800b.E(str);
            }
            return false;
        }

        public boolean b(Intent intent, String str) throws RemoteException {
            if (f1.this.f7800b != null) {
                return f1.this.f7800b.y(intent, str);
            }
            return false;
        }

        public boolean c(String str, int i10, String str2, String str3, long j10, String str4) throws RemoteException {
            if (f1.this.f7800b != null) {
                return f1.this.f7800b.F(str, i10, str2, str3, j10, str4);
            }
            return false;
        }

        public int d(String str, int i10, String str2) throws RemoteException {
            if (f1.this.f7800b != null) {
                return f1.this.f7800b.w(str, i10, str2);
            }
            return 0;
        }

        public int e(String str, int i10, String str2) throws RemoteException {
            if (f1.this.f7800b != null) {
                return f1.this.f7800b.s(str, i10, str2);
            }
            return -1;
        }

        public int f(String str) throws RemoteException {
            if (f1.this.f7800b != null) {
                return f1.this.f7800b.J(str);
            }
            return -1;
        }
    }

    public class b extends ITranWindowContainerTransactionCallback.Stub {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public h9.j.a f7802a;

        public b(h9.j.a aVar) {
            this.f7802a = aVar;
        }

        public void a(int i10, SurfaceControl.Transaction transaction) {
            h9.j.a aVar = this.f7802a;
            if (aVar != null) {
                aVar.a(i10, transaction);
            }
        }
    }

    @Override // bf.g
    public String A() {
        ITranActivityTaskManager iTranActivityTaskManager = this.f7799a;
        if (iTranActivityTaskManager == null) {
            return null;
        }
        try {
            return iTranActivityTaskManager.getMultiWindowVersion();
        } catch (RemoteException e10) {
            j7.b.a("getMultiWindowVersion fail ", e10, f7798c);
            return null;
        }
    }

    @Override // bf.g
    public void A0(Bundle bundle) {
        ITranActivityTaskManager iTranActivityTaskManager = this.f7799a;
        if (iTranActivityTaskManager == null) {
            return;
        }
        try {
            iTranActivityTaskManager.setMultiWindowParams(bundle);
        } catch (RemoteException e10) {
            j7.b.a("setMultiWindowParams fail:", e10, f7798c);
        }
    }

    @Override // bf.g
    public void B(int i10, Rect rect) {
        ITranActivityTaskManager iTranActivityTaskManager = this.f7799a;
        if (iTranActivityTaskManager == null) {
            return;
        }
        try {
            iTranActivityTaskManager.hookStartActivityResult(i10, rect);
        } catch (RemoteException e10) {
            j7.b.a("hookStartActivityResult fail ", e10, f7798c);
        }
    }

    @Override // bf.g
    public void B0(Rect rect) {
        ITranActivityTaskManager iTranActivityTaskManager = this.f7799a;
        if (iTranActivityTaskManager == null) {
            return;
        }
        try {
            iTranActivityTaskManager.hookSetMultiWindowDefaultRectResult(rect);
        } catch (RemoteException e10) {
            j7.b.a("hookSetMultiWindowDefaultRectResult fail ", e10, f7798c);
        }
    }

    @Override // bf.g
    public SurfaceControl C() {
        ITranActivityTaskManager iTranActivityTaskManager = this.f7799a;
        if (iTranActivityTaskManager == null) {
            return null;
        }
        try {
            return iTranActivityTaskManager.getDefaultRootLeash();
        } catch (RemoteException e10) {
            j7.b.a("getDefaultRootLeash fail ", e10, f7798c);
            return null;
        }
    }

    @Override // bf.g
    public void C0(final List<String> list) {
        new zb.f().c(new zb.f.b() { // from class: ic.v0
            @Override // zb.f.b
            public final Object run() {
                return this.f7906a.j1(list);
            }
        }, "activity_task");
        dc.e.f(f7798c, "setConnectBlackListToSystem");
    }

    @Override // bf.g
    public void D(int i10, int i11) {
        ITranActivityTaskManager iTranActivityTaskManager = this.f7799a;
        if (iTranActivityTaskManager == null) {
            return;
        }
        try {
            iTranActivityTaskManager.hookReparentToDefaultDisplay(i10, i11);
        } catch (RemoteException e10) {
            j7.b.a("hookReparentToDefaultDisplay fail ", e10, f7798c);
        }
    }

    @Override // bf.g
    public Bundle D0(String str) {
        ITranActivityTaskManager iTranActivityTaskManager = this.f7799a;
        if (iTranActivityTaskManager == null) {
            return null;
        }
        try {
            return iTranActivityTaskManager.getMultiWindowParams(str);
        } catch (RemoteException e10) {
            j7.b.a("getMultiWindowParams:", e10, f7798c);
            return null;
        }
    }

    @Override // bf.g
    public int E(String str) {
        ITranActivityTaskManager iTranActivityTaskManager = this.f7799a;
        if (iTranActivityTaskManager == null) {
            return 0;
        }
        try {
            return iTranActivityTaskManager.getTaskIdByPkg(str);
        } catch (RemoteException e10) {
            e10.printStackTrace();
            return 0;
        }
    }

    @Override // bf.g
    public void E0(SurfaceControl surfaceControl) {
        ITranActivityTaskManager iTranActivityTaskManager = this.f7799a;
        if (iTranActivityTaskManager == null) {
            return;
        }
        try {
            iTranActivityTaskManager.addAnimationIconLayer(surfaceControl);
        } catch (RemoteException e10) {
            j7.b.a("addAnimationIconLayer fail ", e10, f7798c);
        }
    }

    @Override // bf.g
    public void F(int i10) {
        ITranActivityTaskManager iTranActivityTaskManager = this.f7799a;
        if (iTranActivityTaskManager == null) {
            return;
        }
        try {
            iTranActivityTaskManager.boostSceneEnd(i10);
        } catch (RemoteException e10) {
            j7.b.a("boostSceneEnd fail ", e10, f7798c);
        }
    }

    @Override // bf.g
    public void F0(final boolean z10) {
        new zb.f().c(new zb.f.b() { // from class: ic.w0
            @Override // zb.f.b
            public final Object run() {
                return this.f7910a.g1(z10);
            }
        }, "activity_task");
    }

    @Override // bf.g
    public void G(boolean z10) {
        try {
            ITranActivityTaskManager iTranActivityTaskManager = this.f7799a;
            if (iTranActivityTaskManager != null) {
                iTranActivityTaskManager.setThunderbackAnimating(z10);
            }
        } catch (RemoteException e10) {
            j7.b.a("setThunderbackAnimating RemoteException: ", e10, f7798c);
        }
    }

    @Override // bf.g
    public void G0(int i10, Rect rect, h9.j.a aVar) {
        if (this.f7799a == null) {
            return;
        }
        try {
            this.f7799a.hookStartMultiWindow(i10, rect, aVar != null ? new b(aVar) : null);
        } catch (RemoteException e10) {
            j7.b.a("hookStartMultiWindow fail ", e10, f7798c);
        }
    }

    @Override // bf.g
    public void H(int i10, String str, boolean z10) {
        try {
            ITranActivityTaskManager iTranActivityTaskManager = this.f7799a;
            if (iTranActivityTaskManager != null) {
                iTranActivityTaskManager.setJankScenarioState(i10, str, z10);
            }
        } catch (RemoteException unused) {
            dc.e.c(f7798c, "setJankScenarioState RemoteException");
        }
    }

    @Override // bf.g
    public void H0(List<String> list) {
        ITranActivityTaskManager iTranActivityTaskManager = this.f7799a;
        if (iTranActivityTaskManager == null) {
            return;
        }
        try {
            iTranActivityTaskManager.setMultiWindowWhiteListToSystem(list);
        } catch (RemoteException e10) {
            j7.b.a("setMultiWindowWhiteListToSystem fail ", e10, f7798c);
        }
    }

    @Override // bf.g
    public Rect I(int i10) {
        ITranActivityTaskManager iTranActivityTaskManager = this.f7799a;
        if (iTranActivityTaskManager == null) {
            return null;
        }
        try {
            return iTranActivityTaskManager.getTaskBounds(i10);
        } catch (RemoteException e10) {
            j7.b.a("getTaskBounds fail ", e10, f7798c);
            return null;
        }
    }

    @Override // bf.g
    public List<String> I0() {
        try {
            ITranActivityTaskManager iTranActivityTaskManager = this.f7799a;
            if (iTranActivityTaskManager != null) {
                return iTranActivityTaskManager.getNotifyMultiWindowBlackList();
            }
        } catch (RemoteException e10) {
            j7.b.a("getNotifyMultiWindowBlackList RemoteException: ", e10, f7798c);
        }
        return new ArrayList();
    }

    @Override // bf.g
    public void J(boolean z10) {
        try {
            ITranActivityTaskManager iTranActivityTaskManager = this.f7799a;
            if (iTranActivityTaskManager != null) {
                iTranActivityTaskManager.notifyKeyguardGoingAwayQuickly(z10);
            }
        } catch (RemoteException e10) {
            j7.b.a("notifyKeyguardGoingAwayQuickly RemoteException: ", e10, f7798c);
        }
    }

    @Override // bf.g
    public String J0(int i10, int i11) {
        ITranActivityTaskManager iTranActivityTaskManager = this.f7799a;
        if (iTranActivityTaskManager == null) {
            return null;
        }
        try {
            return iTranActivityTaskManager.getMultiDisplayAreaTopPackageV4(i10, i11);
        } catch (RemoteException e10) {
            j7.b.a("getMultiDisplayAreaTopPackageV4 fail ", e10, f7798c);
            return null;
        }
    }

    @Override // bf.g
    public void K(SurfaceControl surfaceControl) {
        ITranActivityTaskManager iTranActivityTaskManager = this.f7799a;
        if (iTranActivityTaskManager == null) {
            return;
        }
        try {
            iTranActivityTaskManager.removeAnimationIconLayer(surfaceControl);
        } catch (RemoteException e10) {
            j7.b.a("removeAnimationIconLayer fail ", e10, f7798c);
        }
    }

    @Override // bf.g
    public int K0(int i10) {
        ITranActivityTaskManager iTranActivityTaskManager = this.f7799a;
        if (iTranActivityTaskManager == null) {
            return 0;
        }
        try {
            return iTranActivityTaskManager.getTaskOrientation(i10);
        } catch (RemoteException e10) {
            j7.b.a("getTaskOrientation fail ", e10, f7798c);
            return 0;
        }
    }

    @Override // bf.g
    public void L(int i10) {
        try {
            ITranActivityTaskManager iTranActivityTaskManager = this.f7799a;
            if (iTranActivityTaskManager != null) {
                iTranActivityTaskManager.boostStartInLauncher(i10);
            }
        } catch (RemoteException e10) {
            j7.b.a("boostStartInLauncher RemoteException: ", e10, f7798c);
        }
    }

    @Override // bf.g
    public List<ActivityManager.RecentTaskInfo> L0(int i10, int i11, int i12) {
        ITranActivityTaskManager iTranActivityTaskManager = this.f7799a;
        if (iTranActivityTaskManager == null) {
            return null;
        }
        try {
            return iTranActivityTaskManager.getRecentTasks(i10, i11, i12);
        } catch (RemoteException e10) {
            j7.b.a("getRecentTasks fail:", e10, f7798c);
            return null;
        }
    }

    @Override // bf.g
    public void M(h9.a aVar, boolean z10) {
        ITranActivityTaskManager iTranActivityTaskManager = this.f7799a;
        if (iTranActivityTaskManager == null) {
            return;
        }
        try {
            this.f7800b = aVar;
            if (aVar == null) {
                iTranActivityTaskManager.setActivityController((ITranActivityController) null, z10);
            } else {
                this.f7799a.setActivityController(new a(), z10);
            }
        } catch (RemoteException e10) {
            j7.b.a("setActivityController fail ", e10, f7798c);
        }
    }

    @Override // bf.g
    public TranRootTaskInfo M0(int i10, int i11, int i12) {
        com.transsion.hubsdk.app.TranRootTaskInfo rootTaskInfoOnDisplay;
        ITranActivityTaskManager iTranActivityTaskManager = this.f7799a;
        if (iTranActivityTaskManager == null) {
            return null;
        }
        try {
            rootTaskInfoOnDisplay = iTranActivityTaskManager.getRootTaskInfoOnDisplay(i10, i11, i12);
        } catch (RemoteException e10) {
            e10.printStackTrace();
            rootTaskInfoOnDisplay = null;
        }
        if (rootTaskInfoOnDisplay == null) {
            return null;
        }
        TranRootTaskInfo tranRootTaskInfo = new TranRootTaskInfo();
        tranRootTaskInfo.u(rootTaskInfoOnDisplay.getTopActivityString());
        return tranRootTaskInfo;
    }

    @Override // bf.g
    public void N(String str, int i10, int i11, int i12) {
        ITranActivityTaskManager iTranActivityTaskManager = this.f7799a;
        if (iTranActivityTaskManager == null) {
            return;
        }
        try {
            iTranActivityTaskManager.setStartInMultiWindow(str, i10, i11, i12);
        } catch (RemoteException e10) {
            j7.b.a("setStartInMultiWindow fail ", e10, f7798c);
        }
    }

    @Override // bf.g
    public Bundle N0(String str, Bundle bundle) {
        try {
            ITranActivityTaskManager iTranActivityTaskManager = this.f7799a;
            if (iTranActivityTaskManager != null) {
                return iTranActivityTaskManager.hookToMultiWindow(str, bundle);
            }
            return null;
        } catch (RemoteException e10) {
            j7.b.a("hookToMultiWindow RemoteException: ", e10, f7798c);
            return null;
        }
    }

    @Override // bf.g
    public void O() {
        try {
            ITranActivityTaskManager iTranActivityTaskManager = this.f7799a;
            if (iTranActivityTaskManager != null) {
                iTranActivityTaskManager.hookMultiWindowVisible();
            }
        } catch (RemoteException e10) {
            j7.b.a("hookMultiWindowVisible RemoteException: ", e10, f7798c);
        }
    }

    @Override // bf.g
    public int O0() {
        int iIntValue = ((Integer) new zb.f().c(new zb.f.b() { // from class: ic.a1
            @Override // zb.f.b
            public final Object run() {
                return this.f7772a.e1();
            }
        }, "activity_task")).intValue();
        dc.e.f(f7798c, "getMaxRecentTasksStatic count :" + iIntValue);
        return iIntValue;
    }

    @Override // bf.g
    public boolean P(final Configuration configuration) {
        return ((Boolean) new zb.f().c(new zb.f.b() { // from class: ic.c1
            @Override // zb.f.b
            public final Object run() {
                return this.f7780a.l1(configuration);
            }
        }, "activity_task")).booleanValue();
    }

    @Override // bf.g
    public void P0(boolean z10, int i10) {
        ITranActivityTaskManager iTranActivityTaskManager = this.f7799a;
        if (iTranActivityTaskManager == null) {
            return;
        }
        try {
            iTranActivityTaskManager.setTbSpecialLayerState(z10, i10);
        } catch (RemoteException e10) {
            j7.b.a("setTbSpecialLayerState fail ", e10, f7798c);
        }
    }

    @Override // bf.g
    public void Q(boolean z10, Bundle bundle) {
        try {
            ITranActivityTaskManager iTranActivityTaskManager = this.f7799a;
            if (iTranActivityTaskManager != null) {
                iTranActivityTaskManager.setMultiEnableStateForOOBE(z10, bundle);
            }
        } catch (RemoteException e10) {
            j7.b.a("setMultiEnableStateForOOBE RemoteException: ", e10, f7798c);
        }
    }

    @Override // bf.g
    public TranTaskSnapshot Q0(final int i10, final boolean z10) {
        TranTaskSnapshot tranTaskSnapshot = new TranTaskSnapshot();
        com.transsion.hubsdk.window.TranTaskSnapshot tranTaskSnapshot2 = (com.transsion.hubsdk.window.TranTaskSnapshot) new zb.f().c(new zb.f.b() { // from class: ic.x0
            @Override // zb.f.b
            public final Object run() {
                return this.f7914a.k1(i10, z10);
            }
        }, "activity_task");
        if (tranTaskSnapshot2 == null) {
            dc.e.n(f7798c, "TranTaskSnapshot is null");
            return null;
        }
        tranTaskSnapshot.f2273a = tranTaskSnapshot2.getHardwareBuffer();
        tranTaskSnapshot.f2274b = tranTaskSnapshot2.getColorSpace();
        dc.e.f(f7798c, "takeTaskSnapshot mTranTaskSnapshot:" + tranTaskSnapshot);
        return tranTaskSnapshot;
    }

    @Override // bf.g
    public List<ActivityManager.RunningTaskInfo> R() {
        return (List) new zb.f().c(new zb.f.b() { // from class: ic.b1
            @Override // zb.f.b
            public final Object run() {
                return this.f7776a.c1();
            }
        }, "activity_task");
    }

    @Override // bf.g
    public boolean R0() {
        ITranActivityTaskManager iTranActivityTaskManager = this.f7799a;
        if (iTranActivityTaskManager == null) {
            return false;
        }
        try {
            return iTranActivityTaskManager.isPinnedMode();
        } catch (RemoteException e10) {
            j7.b.a("isPinnedMode fail ", e10, f7798c);
            return false;
        }
    }

    @Override // bf.g
    public boolean S() {
        ITranActivityTaskManager iTranActivityTaskManager = this.f7799a;
        if (iTranActivityTaskManager == null) {
            return false;
        }
        try {
            return iTranActivityTaskManager.inMultiWindowMode();
        } catch (RemoteException e10) {
            j7.b.a("inMultiWindowMode fail:", e10, f7798c);
            return false;
        }
    }

    @Override // bf.g
    public void S0(int i10) {
        ITranActivityTaskManager iTranActivityTaskManager = this.f7799a;
        if (iTranActivityTaskManager == null) {
            return;
        }
        try {
            iTranActivityTaskManager.updateZBoostTaskIdWhenToSplit(i10);
        } catch (RemoteException e10) {
            j7.b.a("updateZBoostTaskIdWhenToSplit fail ", e10, f7798c);
        }
    }

    @Override // bf.g
    public void T(int i10) {
        try {
            ITranActivityTaskManager iTranActivityTaskManager = this.f7799a;
            if (iTranActivityTaskManager != null) {
                iTranActivityTaskManager.boostEndInLauncher(i10);
            }
        } catch (RemoteException e10) {
            j7.b.a("boostEndInLauncher RemoteException: ", e10, f7798c);
        }
    }

    @Override // bf.g
    public int T0(String str) {
        ITranActivityTaskManager iTranActivityTaskManager = this.f7799a;
        if (iTranActivityTaskManager == null) {
            return 0;
        }
        try {
            return iTranActivityTaskManager.getPackageUserId(str);
        } catch (RemoteException e10) {
            e10.printStackTrace();
            return 0;
        }
    }

    @Override // bf.g
    public boolean U() {
        ITranActivityTaskManager iTranActivityTaskManager = this.f7799a;
        if (iTranActivityTaskManager == null) {
            return false;
        }
        try {
            return iTranActivityTaskManager.isSupportMultiWindow();
        } catch (RemoteException e10) {
            j7.b.a("isSupportMultiWindow fail ", e10, f7798c);
            return false;
        }
    }

    @Override // bf.g
    public void U0(String str, int i10, int i11, int i12, int i13) {
        ITranActivityTaskManager iTranActivityTaskManager = this.f7799a;
        if (iTranActivityTaskManager == null) {
            return;
        }
        try {
            iTranActivityTaskManager.setStartInMultiWindowAsUser(str, i10, i11, i12, i13);
        } catch (RemoteException e10) {
            j7.b.a("setStartInMultiWindowAsUser fail ", e10, f7798c);
        }
    }

    @Override // bf.g
    public void V(List<String> list) {
        ITranActivityTaskManager iTranActivityTaskManager = this.f7799a;
        if (iTranActivityTaskManager == null) {
            return;
        }
        try {
            iTranActivityTaskManager.setMultiWindowBlackListToSystem(list);
        } catch (RemoteException e10) {
            j7.b.a("setMultiWindowBlackListToSystem fail ", e10, f7798c);
        }
    }

    @Override // bf.g
    public boolean V0() {
        ITranActivityTaskManager iTranActivityTaskManager = this.f7799a;
        if (iTranActivityTaskManager == null) {
            return false;
        }
        try {
            return iTranActivityTaskManager.isSecureWindow();
        } catch (RemoteException e10) {
            j7.b.a("isSecureWindow fail ", e10, f7798c);
            return false;
        }
    }

    @Override // bf.g
    public void W(String str, List<String> list) {
        ITranActivityTaskManager iTranActivityTaskManager = this.f7799a;
        if (iTranActivityTaskManager == null) {
            return;
        }
        try {
            iTranActivityTaskManager.setMultiWindowConfigToSystem(str, list);
        } catch (RemoteException e10) {
            j7.b.a("setMultiWindowConfigToSystem fail ", e10, f7798c);
        }
    }

    @Override // bf.g
    public void W0() {
        ITranActivityTaskManager iTranActivityTaskManager = this.f7799a;
        if (iTranActivityTaskManager == null) {
            return;
        }
        try {
            iTranActivityTaskManager.hookShowBlurLayerFinish();
        } catch (RemoteException e10) {
            j7.b.a("hookShowBlurLayerFinish fail ", e10, f7798c);
        }
    }

    @Override // bf.g
    public void X(int i10, String str, boolean z10) {
        try {
            ITranActivityTaskManager iTranActivityTaskManager = this.f7799a;
            if (iTranActivityTaskManager != null) {
                iTranActivityTaskManager.setBoostSceneState(i10, str, z10);
            }
        } catch (RemoteException unused) {
            dc.e.c(f7798c, "setBoostSceneState RemoteException");
        }
    }

    @Override // bf.g
    public ActivityManager.RunningTaskInfo Y(int i10, int i11) {
        ITranActivityTaskManager iTranActivityTaskManager = this.f7799a;
        if (iTranActivityTaskManager == null) {
            return null;
        }
        try {
            return iTranActivityTaskManager.getMultiWinTopTask(i10, i11);
        } catch (RemoteException e10) {
            j7.b.a("getMultiWinTopTask fail ", e10, f7798c);
            return null;
        }
    }

    @Override // bf.g
    public int Z(String str) {
        ITranActivityTaskManager iTranActivityTaskManager = this.f7799a;
        if (iTranActivityTaskManager == null) {
            return 0;
        }
        try {
            return iTranActivityTaskManager.getGivenPkgWindowMode(str);
        } catch (RemoteException e10) {
            e10.printStackTrace();
            return 0;
        }
    }

    @Override // bf.g
    public boolean a0() {
        ITranActivityTaskManager iTranActivityTaskManager = this.f7799a;
        if (iTranActivityTaskManager == null) {
            return false;
        }
        try {
            return iTranActivityTaskManager.isKeyguardLocking();
        } catch (RemoteException e10) {
            j7.b.a("isKeyguardLocking fail ", e10, f7798c);
            return false;
        }
    }

    @Override // bf.g
    public void b0(boolean z10) {
        try {
            ITranActivityTaskManager iTranActivityTaskManager = this.f7799a;
            if (iTranActivityTaskManager != null) {
                iTranActivityTaskManager.notifyLauncherPageTurning(z10);
            }
        } catch (RemoteException unused) {
            dc.e.c(f7798c, "notifyLauncherPageTurning RemoteException");
        }
    }

    public final /* synthetic */ Object b1(String str, boolean z10, boolean z11, long j10) throws RemoteException {
        ITranActivityTaskManager iTranActivityTaskManager = this.f7799a;
        return iTranActivityTaskManager != null ? Boolean.valueOf(iTranActivityTaskManager.checkAndUpdateEventStateForMulti(str, z10, z11, j10)) : Boolean.TRUE;
    }

    @Override // bf.g
    public void c0(int i10, int i11, int i12, Rect rect, h9.j.a aVar) {
        if (this.f7799a == null) {
            return;
        }
        try {
            this.f7799a.hookStartMultiWindowAndMakeOwnAnimation(i10, i11, i12, rect, aVar != null ? new b(aVar) : null);
        } catch (RemoteException e10) {
            j7.b.a("hookStartMultiWindowAndMakeOwnAnimation fail ", e10, f7798c);
        }
    }

    public final /* synthetic */ Object c1() throws RemoteException {
        ITranActivityTaskManager iTranActivityTaskManager = this.f7799a;
        if (iTranActivityTaskManager != null) {
            return iTranActivityTaskManager.getAllMultiWindowTaskInfo().getList();
        }
        return null;
    }

    @Override // bf.g
    public boolean d() {
        boolean zBooleanValue = ((Boolean) new zb.f().c(new zb.f.b() { // from class: ic.d1
            @Override // zb.f.b
            public final Object run() {
                return this.f7786a.f1();
            }
        }, "activity_task")).booleanValue();
        n0.a("isSplitScreen :", zBooleanValue, f7798c);
        return zBooleanValue;
    }

    @Override // bf.g
    public Bundle d0() {
        try {
            ITranActivityTaskManager iTranActivityTaskManager = this.f7799a;
            if (iTranActivityTaskManager != null) {
                return iTranActivityTaskManager.getTopAppWindowInfo();
            }
            return null;
        } catch (RemoteException e10) {
            j7.b.a("getTopAppWindowInfo fail:", e10, f7798c);
            return null;
        }
    }

    public final /* synthetic */ Object d1(int i10) throws RemoteException {
        ITranActivityTaskManager iTranActivityTaskManager = this.f7799a;
        if (iTranActivityTaskManager != null) {
            return iTranActivityTaskManager.getAllRootTaskInfosOnDisplay(i10);
        }
        return null;
    }

    @Override // bf.g
    public boolean e0(String str, String str2) {
        ITranActivityTaskManager iTranActivityTaskManager = this.f7799a;
        if (iTranActivityTaskManager == null) {
            return false;
        }
        try {
            return iTranActivityTaskManager.isTheMainScreen(str, str2);
        } catch (RemoteException e10) {
            e10.printStackTrace();
            return false;
        }
    }

    public final /* synthetic */ Object e1() throws RemoteException {
        ITranActivityTaskManager iTranActivityTaskManager = this.f7799a;
        if (iTranActivityTaskManager != null) {
            return Integer.valueOf(iTranActivityTaskManager.getMaxRecentTasksStatic());
        }
        return 0;
    }

    @Override // bf.g
    public void f0(int i10) {
        ITranActivityTaskManager iTranActivityTaskManager = this.f7799a;
        if (iTranActivityTaskManager == null) {
            return;
        }
        try {
            iTranActivityTaskManager.boostSceneStart(i10);
        } catch (RemoteException e10) {
            j7.b.a("boostSceneStart fail ", e10, f7798c);
        }
    }

    public final /* synthetic */ Object f1() throws RemoteException {
        ITranActivityTaskManager iTranActivityTaskManager = this.f7799a;
        return iTranActivityTaskManager != null ? Boolean.valueOf(iTranActivityTaskManager.isSplitScreen()) : Boolean.FALSE;
    }

    @Override // bf.g
    public void g0() {
        ITranActivityTaskManager iTranActivityTaskManager = this.f7799a;
        if (iTranActivityTaskManager == null) {
            return;
        }
        try {
            iTranActivityTaskManager.clearFinishFixedRotationWithTransaction();
        } catch (RemoteException e10) {
            j7.b.a("clearFinishFixedRotationWithTransaction fail ", e10, f7798c);
        }
    }

    public final /* synthetic */ Object g1(boolean z10) throws RemoteException {
        ITranActivityTaskManager iTranActivityTaskManager = this.f7799a;
        if (iTranActivityTaskManager == null) {
            return null;
        }
        iTranActivityTaskManager.notAllowKeyguardGoingAwayQuickly(z10);
        return null;
    }

    @Override // bf.g
    public void h(boolean z10, int i10) {
        ITranActivityTaskManager iTranActivityTaskManager = this.f7799a;
        if (iTranActivityTaskManager == null) {
            return;
        }
        try {
            iTranActivityTaskManager.startCurrentAppInMultiWindow(z10, i10);
        } catch (RemoteException e10) {
            j7.b.a("startCurrentAppInMultiWindow fail ", e10, f7798c);
        }
    }

    @Override // bf.g
    public ComponentName h0() {
        ITranActivityTaskManager iTranActivityTaskManager = this.f7799a;
        if (iTranActivityTaskManager == null) {
            return null;
        }
        try {
            return iTranActivityTaskManager.getTopActivityComponent();
        } catch (RemoteException e10) {
            j7.b.a("getTopActivityComponent fail:", e10, f7798c);
            return null;
        }
    }

    public final /* synthetic */ Object h1(int[] iArr) throws RemoteException {
        ITranActivityTaskManager iTranActivityTaskManager = this.f7799a;
        if (iTranActivityTaskManager == null) {
            return null;
        }
        iTranActivityTaskManager.removeRootTasksInWindowingModes(iArr);
        return null;
    }

    @Override // bf.g
    public HardwareBuffer i0(int i10, boolean z10) {
        ITranActivityTaskManager iTranActivityTaskManager = this.f7799a;
        if (iTranActivityTaskManager == null) {
            return null;
        }
        try {
            return iTranActivityTaskManager.getHardwareBuffer(i10, z10);
        } catch (RemoteException e10) {
            e10.printStackTrace();
            return null;
        }
    }

    public final /* synthetic */ Object i1(int i10, int i11, boolean z10) throws RemoteException {
        ITranActivityTaskManager iTranActivityTaskManager = this.f7799a;
        if (iTranActivityTaskManager == null) {
            return null;
        }
        iTranActivityTaskManager.reparentActivity(i10, i11, z10);
        return null;
    }

    @Override // bf.g
    public boolean j0(int i10) {
        ITranActivityTaskManager iTranActivityTaskManager = this.f7799a;
        if (iTranActivityTaskManager == null) {
            return false;
        }
        try {
            return iTranActivityTaskManager.taskInMultiWindowById(i10);
        } catch (RemoteException e10) {
            j7.b.a("taskInMultiWindowById fail ", e10, f7798c);
            return false;
        }
    }

    public final /* synthetic */ Object j1(List list) throws RemoteException {
        ITranActivityTaskManager iTranActivityTaskManager = this.f7799a;
        if (iTranActivityTaskManager == null) {
            return null;
        }
        iTranActivityTaskManager.setConnectBlackListToSystem(list);
        return null;
    }

    @Override // bf.g
    public void k(final int i10, final int i11, final boolean z10) {
        new zb.f().c(new zb.f.b() { // from class: ic.e1
            @Override // zb.f.b
            public final Object run() {
                return this.f7791a.i1(i10, i11, z10);
            }
        }, "activity_task");
        dc.e.f(f7798c, "reparentActivity");
    }

    @Override // bf.g
    public void k0(IBinder iBinder) {
        try {
            ITranActivityTaskManager iTranActivityTaskManager = this.f7799a;
            if (iTranActivityTaskManager != null) {
                iTranActivityTaskManager.registerMultiWindowWmShellListener(iBinder);
            }
        } catch (RemoteException e10) {
            j7.b.a("registerMultiWindowWmShellListener RemoteException: ", e10, f7798c);
        }
    }

    public final /* synthetic */ Object k1(int i10, boolean z10) throws RemoteException {
        ITranActivityTaskManager iTranActivityTaskManager = this.f7799a;
        if (iTranActivityTaskManager != null) {
            return iTranActivityTaskManager.takeTaskSnapshot(i10, z10);
        }
        return null;
    }

    @Override // bf.g
    public void l(int i10, boolean z10) {
        ITranActivityTaskManager iTranActivityTaskManager = this.f7799a;
        if (iTranActivityTaskManager == null) {
            return;
        }
        try {
            iTranActivityTaskManager.setMultiWindowAcquireFocus(i10, z10);
        } catch (RemoteException e10) {
            j7.b.a("setMultiWindowAcquireFocus fail ", e10, f7798c);
        }
    }

    @Override // bf.g
    public void l0(final int[] iArr) {
        new zb.f().c(new zb.f.b() { // from class: ic.y0
            @Override // zb.f.b
            public final Object run() {
                return this.f7922a.h1(iArr);
            }
        }, "activity_task");
        dc.e.f(f7798c, "removeRootTasksInWindowingModes!");
    }

    public final /* synthetic */ Object l1(Configuration configuration) throws RemoteException {
        ITranActivityTaskManager iTranActivityTaskManager = this.f7799a;
        return iTranActivityTaskManager != null ? Boolean.valueOf(iTranActivityTaskManager.updateConfiguration(configuration)) : Boolean.FALSE;
    }

    @Override // bf.g
    public void m(int i10, int i11) {
        try {
            ITranActivityTaskManager iTranActivityTaskManager = this.f7799a;
            if (iTranActivityTaskManager != null) {
                iTranActivityTaskManager.setMultiWindowExtendSize(i10, i11);
            }
        } catch (RemoteException e10) {
            j7.b.a("setMultiWindowExtendSize RemoteException: ", e10, f7798c);
        }
    }

    @Override // bf.g
    public List<TranRootTaskInfo> m0(final int i10) {
        List<com.transsion.hubsdk.app.TranRootTaskInfo> list = (List) new zb.f().c(new zb.f.b() { // from class: ic.z0
            @Override // zb.f.b
            public final Object run() {
                return this.f7926a.d1(i10);
            }
        }, "activity_task");
        ArrayList arrayList = new ArrayList();
        if (list != null && !list.isEmpty()) {
            for (com.transsion.hubsdk.app.TranRootTaskInfo tranRootTaskInfo : list) {
                TranRootTaskInfo tranRootTaskInfo2 = new TranRootTaskInfo();
                tranRootTaskInfo2.t(tranRootTaskInfo.mTopActivity);
                tranRootTaskInfo2.m(tranRootTaskInfo.mBounds);
                tranRootTaskInfo2.o(tranRootTaskInfo.mChildTaskIds);
                tranRootTaskInfo2.p(tranRootTaskInfo.mChildTaskNames);
                tranRootTaskInfo2.n(tranRootTaskInfo.mChildTaskBounds);
                tranRootTaskInfo2.q(tranRootTaskInfo.mChildTaskUserIds);
                tranRootTaskInfo2.v(tranRootTaskInfo.mVisible);
                tranRootTaskInfo2.r(tranRootTaskInfo.mPosition);
                tranRootTaskInfo2.w(tranRootTaskInfo.mWindowingMode);
                tranRootTaskInfo2.s(tranRootTaskInfo.mTaskId);
                arrayList.add(tranRootTaskInfo2);
            }
        }
        return arrayList;
    }

    @VisibleForTesting
    public void m1(ITranActivityTaskManager iTranActivityTaskManager) {
        this.f7799a = iTranActivityTaskManager;
    }

    @Override // bf.g
    public boolean n(String str) {
        ITranActivityTaskManager iTranActivityTaskManager = this.f7799a;
        if (iTranActivityTaskManager == null) {
            return false;
        }
        try {
            return iTranActivityTaskManager.activityInMultiWindow(str);
        } catch (RemoteException e10) {
            j7.b.a("activityInMultiWindow fail ", e10, f7798c);
            return false;
        }
    }

    @Override // bf.g
    public int n0(String str, String str2) {
        ITranActivityTaskManager iTranActivityTaskManager = this.f7799a;
        if (iTranActivityTaskManager == null) {
            return 0;
        }
        try {
            return iTranActivityTaskManager.getGivenPkgWindowModeForCls(str, str2);
        } catch (RemoteException e10) {
            e10.printStackTrace();
            return 0;
        }
    }

    @Override // bf.g
    public boolean o() {
        ITranActivityTaskManager iTranActivityTaskManager = this.f7799a;
        if (iTranActivityTaskManager == null) {
            return false;
        }
        try {
            return iTranActivityTaskManager.isIMEShowing();
        } catch (RemoteException e10) {
            j7.b.a("isIMEShowing fail:", e10, f7798c);
            return false;
        }
    }

    @Override // bf.g
    public boolean o0(String str) {
        ITranActivityTaskManager iTranActivityTaskManager = this.f7799a;
        if (iTranActivityTaskManager == null) {
            return false;
        }
        try {
            return iTranActivityTaskManager.getVideoNotFullscreen(str);
        } catch (RemoteException e10) {
            e10.printStackTrace();
            return false;
        }
    }

    @Override // bf.g
    public SurfaceControl p(int i10, int i11, int i12, int i13, boolean z10) {
        ITranActivityTaskManager iTranActivityTaskManager = this.f7799a;
        if (iTranActivityTaskManager == null) {
            return null;
        }
        try {
            return iTranActivityTaskManager.getDragAndZoomBgLeash(i10, i11, i12, i13, z10);
        } catch (RemoteException e10) {
            j7.b.a("getDragAndZoomBgLeash fail ", e10, f7798c);
            return null;
        }
    }

    @Override // bf.g
    public void p0(boolean z10) {
        try {
            ITranActivityTaskManager iTranActivityTaskManager = this.f7799a;
            if (iTranActivityTaskManager != null) {
                iTranActivityTaskManager.notifyAuthenticateSucceed(z10);
            }
        } catch (RemoteException e10) {
            j7.b.a("notifyAuthenticateSucceed RemoteException: ", e10, f7798c);
        }
    }

    @Override // bf.g
    public List<ActivityManager.RunningTaskInfo> q(int i10, boolean z10, boolean z11) {
        ITranActivityTaskManager iTranActivityTaskManager = this.f7799a;
        if (iTranActivityTaskManager == null) {
            return null;
        }
        try {
            return iTranActivityTaskManager.getTasks(i10, z10, z11);
        } catch (RemoteException e10) {
            j7.b.a("getTasks fail ", e10, f7798c);
            return null;
        }
    }

    @Override // bf.g
    public boolean q0(String str) {
        ITranActivityTaskManager iTranActivityTaskManager = this.f7799a;
        if (iTranActivityTaskManager == null) {
            return false;
        }
        try {
            return iTranActivityTaskManager.getNeedExit(str);
        } catch (RemoteException e10) {
            e10.printStackTrace();
            return false;
        }
    }

    @Override // bf.g
    public void r(int i10) {
        try {
            ITranActivityTaskManager iTranActivityTaskManager = this.f7799a;
            if (iTranActivityTaskManager != null) {
                iTranActivityTaskManager.clearMultiWindowExtendSize(i10);
            }
        } catch (RemoteException e10) {
            j7.b.a("clearMultiWindowExtendSize RemoteException: ", e10, f7798c);
        }
    }

    @Override // bf.g
    public Rect r0(int i10) {
        ITranActivityTaskManager iTranActivityTaskManager = this.f7799a;
        if (iTranActivityTaskManager == null) {
            return null;
        }
        try {
            return iTranActivityTaskManager.hookGetMultiWindowDefaultRect(i10);
        } catch (RemoteException e10) {
            j7.b.a("hookGetMultiWindowDefaultRect fail ", e10, f7798c);
            return null;
        }
    }

    @Override // bf.g
    public Rect s() {
        try {
            ITranActivityTaskManager iTranActivityTaskManager = this.f7799a;
            if (iTranActivityTaskManager != null) {
                return iTranActivityTaskManager.getMultiWindowDefaultRect();
            }
            return null;
        } catch (RemoteException e10) {
            j7.b.a("getMultiWindowDefaultRect RemoteException: ", e10, f7798c);
            return null;
        }
    }

    @Override // bf.g
    public void s0(SurfaceControl surfaceControl, String str) {
        try {
            ITranActivityTaskManager iTranActivityTaskManager = this.f7799a;
            if (iTranActivityTaskManager != null) {
                iTranActivityTaskManager.hookShowBlurLayer(surfaceControl, str);
            }
        } catch (RemoteException e10) {
            j7.b.a("hookShowBlurLayer RemoteException: ", e10, f7798c);
        }
    }

    @Override // bf.g
    public boolean t(int i10) {
        ITranActivityTaskManager iTranActivityTaskManager = this.f7799a;
        if (iTranActivityTaskManager == null) {
            return false;
        }
        try {
            return iTranActivityTaskManager.getMuteStateV4(i10);
        } catch (RemoteException e10) {
            j7.b.a("getMuteStateV4 fail ", e10, f7798c);
            return false;
        }
    }

    @Override // bf.g
    public void t0(int i10, int i11) {
        try {
            ITranActivityTaskManager iTranActivityTaskManager = this.f7799a;
            if (iTranActivityTaskManager != null) {
                iTranActivityTaskManager.hookMultiWindowToExchange(i10, i11);
            }
        } catch (RemoteException e10) {
            j7.b.a("hookMultiWindowToExchange RemoteException: ", e10, f7798c);
        }
    }

    @Override // bf.g
    public List<String> u() {
        ITranActivityTaskManager iTranActivityTaskManager = this.f7799a;
        if (iTranActivityTaskManager == null) {
            return null;
        }
        try {
            return iTranActivityTaskManager.getMultiWindowBlackList();
        } catch (RemoteException e10) {
            j7.b.a("getMultiWindowBlackList fail ", e10, f7798c);
            return null;
        }
    }

    @Override // bf.g
    public boolean u0() {
        ITranActivityTaskManager iTranActivityTaskManager = this.f7799a;
        if (iTranActivityTaskManager == null) {
            return false;
        }
        try {
            return iTranActivityTaskManager.hasMultiWindow();
        } catch (RemoteException e10) {
            e10.printStackTrace();
            return false;
        }
    }

    @Override // bf.g
    public String v() {
        ITranActivityTaskManager iTranActivityTaskManager = this.f7799a;
        if (iTranActivityTaskManager == null) {
            return null;
        }
        try {
            return iTranActivityTaskManager.getFocusedWinPkgName();
        } catch (RemoteException e10) {
            j7.b.a("getFocusedWinPkgName fail:", e10, f7798c);
            return null;
        }
    }

    @Override // bf.g
    public void v0() {
        try {
            ITranActivityTaskManager iTranActivityTaskManager = this.f7799a;
            if (iTranActivityTaskManager != null) {
                iTranActivityTaskManager.reparentTaskToDefaultTDA();
            }
        } catch (RemoteException e10) {
            j7.b.a("reparentTaskToDefaultTDA RemoteException: ", e10, f7798c);
        }
    }

    @Override // bf.g
    public boolean w(final String str, final boolean z10, final boolean z11, final long j10) {
        return ((Boolean) new zb.f().c(new zb.f.b() { // from class: ic.u0
            @Override // zb.f.b
            public final Object run() {
                return this.f7900a.b1(str, z10, z11, j10);
            }
        }, "activity_task")).booleanValue();
    }

    @Override // bf.g
    public void w0(boolean z10, int i10) {
        ITranActivityTaskManager iTranActivityTaskManager = this.f7799a;
        if (iTranActivityTaskManager == null) {
            return;
        }
        try {
            iTranActivityTaskManager.setMuteStateV4(z10, i10);
        } catch (RemoteException e10) {
            j7.b.a("setMuteStateV4 fail ", e10, f7798c);
        }
    }

    @Override // bf.g
    public boolean x(int i10) {
        ITranActivityTaskManager iTranActivityTaskManager = this.f7799a;
        if (iTranActivityTaskManager == null) {
            return false;
        }
        try {
            return iTranActivityTaskManager.removeTask(i10);
        } catch (RemoteException e10) {
            j7.b.a("removeTask fail:", e10, f7798c);
            return false;
        }
    }

    @Override // bf.g
    public void x0(SurfaceControl surfaceControl, float[] fArr, float[] fArr2, int i10) {
        ITranActivityTaskManager iTranActivityTaskManager = this.f7799a;
        if (iTranActivityTaskManager == null) {
            return;
        }
        try {
            iTranActivityTaskManager.setFinishFixedRotationWithTransaction(surfaceControl, fArr, fArr2, i10);
        } catch (RemoteException e10) {
            j7.b.a("setFinishFixedRotationWithTransaction fail ", e10, f7798c);
        }
    }

    @Override // bf.g
    public int y(String str, int i10) {
        try {
            ITranActivityTaskManager iTranActivityTaskManager = this.f7799a;
            if (iTranActivityTaskManager != null) {
                return iTranActivityTaskManager.getTaskIdByPkgName(str, i10);
            }
            return -1;
        } catch (RemoteException e10) {
            j7.b.a("getTaskIdByPkgName RemoteException: ", e10, f7798c);
            return -1;
        }
    }

    @Override // bf.g
    public ActivityManager.RunningTaskInfo y0(int i10) {
        ITranActivityTaskManager iTranActivityTaskManager = this.f7799a;
        if (iTranActivityTaskManager == null) {
            return null;
        }
        try {
            return iTranActivityTaskManager.getTopTask(i10);
        } catch (RemoteException e10) {
            j7.b.a("getTopTask fail ", e10, f7798c);
            return null;
        }
    }

    @Override // bf.g
    public int z(String str) {
        ITranActivityTaskManager iTranActivityTaskManager = this.f7799a;
        if (iTranActivityTaskManager == null) {
            return 0;
        }
        try {
            return iTranActivityTaskManager.getStackInfoTaskId(str);
        } catch (RemoteException e10) {
            e10.printStackTrace();
            return 0;
        }
    }

    @Override // bf.g
    public void z0(String str, boolean z10) {
        try {
            ITranActivityTaskManager iTranActivityTaskManager = this.f7799a;
            if (iTranActivityTaskManager != null) {
                iTranActivityTaskManager.updateMediaMapForDynamicIsland(str, z10);
            }
        } catch (RemoteException e10) {
            j7.b.a("updateMediaMapForDynamicIsland fail:", e10, f7798c);
        }
    }
}
