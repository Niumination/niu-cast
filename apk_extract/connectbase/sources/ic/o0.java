package ic;

import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.os.UserHandle;
import android.util.ArrayMap;
import com.android.internal.annotations.VisibleForTesting;
import com.transsion.hubsdk.TranServiceManager;
import com.transsion.hubsdk.app.ITranActivityManager;
import com.transsion.hubsdk.app.ITranActivityStartObserver;
import com.transsion.hubsdk.app.ITranAppRecoveryCallback;
import com.transsion.hubsdk.app.ITranBloodOxygenLedStateCallback;
import com.transsion.hubsdk.app.ITranPackageDataObserver;
import com.transsion.hubsdk.app.ITranProcessObserver;
import com.transsion.hubsdk.app.ITranTaskStackListener;
import com.transsion.hubsdk.app.ITranUserSwitchObserver;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
public class o0 implements bf.d {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final String f7845g = "o0";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f7846h = 30;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ArrayMap<h9.g.c, e> f7848b = new ArrayMap<>();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ArrayMap<h9.s, f> f7849c = new ArrayMap<>();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ArrayMap<h9.u, g> f7850d = new ArrayMap<>();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Map<h9.g.b, d> f7851e = new ConcurrentHashMap();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ArrayMap<h9.g.d, c> f7852f = new ArrayMap<>();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ITranActivityManager f7847a = ITranActivityManager.Stub.asInterface(TranServiceManager.getServiceIBinder("activity"));

    public class a extends ITranAppRecoveryCallback.Stub {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public h9.g.a f7853a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public IBinder f7854b;

        public a(h9.g.a aVar, IBinder iBinder) {
            this.f7853a = aVar;
            this.f7854b = iBinder;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:12:0x0028 -> B:29:0x0057). Please report as a decompilation issue!!! */
        public void a(Bundle bundle) throws Throwable {
            if (this.f7853a != null) {
                Bundle bundle2 = o0.this.f7847a;
                try {
                    try {
                        if (bundle2 == null) {
                            return;
                        }
                        try {
                            try {
                                bundle2 = new Bundle();
                                this.f7853a.a(bundle2);
                                ITranActivityManager iTranActivityManager = o0.this.f7847a;
                                IBinder iBinder = this.f7854b;
                                iTranActivityManager.setActivityState(iBinder, bundle2);
                                this = iBinder;
                            } catch (Throwable th2) {
                                bundle2 = bundle;
                                th = th2;
                            }
                        } catch (Exception e10) {
                            bundle2 = null;
                            dc.e.c(o0.f7845g, "onSaveStateWhenError error: " + e10);
                            ITranActivityManager iTranActivityManager2 = o0.this.f7847a;
                            IBinder iBinder2 = this.f7854b;
                            iTranActivityManager2.setActivityState(iBinder2, (Bundle) null);
                            this = iBinder2;
                        }
                        return;
                    } catch (Throwable th3) {
                        th = th3;
                    }
                } catch (RemoteException e11) {
                    j7.b.a("setActivityState error: ", e11, o0.f7845g);
                    this = e11;
                }
                try {
                    o0.this.f7847a.setActivityState(this.f7854b, bundle2);
                } catch (RemoteException e12) {
                    j7.b.a("setActivityState error: ", e12, o0.f7845g);
                }
                throw th;
            }
        }
    }

    public class b extends ITranPackageDataObserver.Stub {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public p6.f.c f7856a;

        public b(p6.f.c cVar) {
            this.f7856a = cVar;
        }

        public void a(String str, boolean z10) {
            p6.f.c cVar = this.f7856a;
            if (cVar != null) {
                cVar.a(str, z10);
            }
        }
    }

    public class c extends ITranActivityStartObserver.Stub {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public h9.g.d f7858a;

        public c(h9.g.d dVar) {
            this.f7858a = dVar;
        }

        public void a(String str, String str2, int i10) throws RemoteException {
            h9.g.d dVar = this.f7858a;
            if (dVar != null) {
                dVar.a(str, str2, i10);
            }
        }
    }

    public class d extends ITranBloodOxygenLedStateCallback.Stub {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public h9.g.b f7860a;

        public d(h9.g.b bVar) {
            this.f7860a = bVar;
        }

        public void a(int i10) throws RemoteException {
            h9.g.b bVar = this.f7860a;
            if (bVar != null) {
                bVar.a(i10);
            }
        }
    }

    public class e extends ITranProcessObserver.Stub {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public h9.g.c f7862a;

        public e(h9.g.c cVar) {
            this.f7862a = cVar;
        }

        public void a(int i10, int i11, boolean z10) throws RemoteException {
            this.f7862a.b(i10, i11, z10);
        }

        public void b(int i10, int i11, int i12) throws RemoteException {
            this.f7862a.c(i10, i11, i12);
        }

        public void c(int i10, int i11) throws RemoteException {
            this.f7862a.a(i10, i11);
        }
    }

    public class f extends ITranTaskStackListener.Stub {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public h9.s f7864a;

        public f(h9.s sVar) {
            this.f7864a = sVar;
        }

        public void a(int i10) {
            dc.e.a(o0.f7845g, "onLockTaskModeChanged mListener" + this.f7864a);
            h9.s sVar = this.f7864a;
            if (sVar != null) {
                sVar.b(i10);
            }
        }

        public void b(int i10, ComponentName componentName) throws RemoteException {
            dc.e.a(o0.f7845g, "onTaskCreated mListener" + this.f7864a);
            h9.s sVar = this.f7864a;
            if (sVar != null) {
                sVar.c(i10, componentName);
            }
        }

        public void c(int i10, boolean z10) {
            dc.e.a(o0.f7845g, "onTaskFocusChanged mListener" + this.f7864a);
            h9.s sVar = this.f7864a;
            if (sVar != null) {
                sVar.a(i10, z10);
            }
        }
    }

    public class g extends ITranUserSwitchObserver.Stub {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public h9.u f7866a;

        public g(h9.u uVar) {
            this.f7866a = uVar;
        }

        public void a(int i10) throws RemoteException {
            this.f7866a.a(i10);
        }

        public void b(int i10) throws RemoteException {
            this.f7866a.b(i10);
        }
    }

    public static /* synthetic */ c q1(o0 o0Var, h9.g.d dVar) {
        o0Var.getClass();
        return o0Var.new c(dVar);
    }

    public static /* synthetic */ d w1(o0 o0Var, h9.g.b bVar) {
        o0Var.getClass();
        return o0Var.new d(bVar);
    }

    @Override // bf.d
    public void A(int i10, List<String> list) {
        ITranActivityManager iTranActivityManager = this.f7847a;
        if (iTranActivityManager == null) {
            return;
        }
        try {
            iTranActivityManager.doClean(i10, list);
        } catch (RemoteException e10) {
            j7.b.a("doClean:", e10, f7845g);
        }
    }

    @Override // bf.d
    public boolean A0(int i10) {
        ITranActivityManager iTranActivityManager = this.f7847a;
        if (iTranActivityManager == null) {
            return false;
        }
        try {
            return iTranActivityManager.setMemoryPresureLevel(i10);
        } catch (RemoteException e10) {
            j7.b.a("setMemoryPresureLevel error: ", e10, f7845g);
            return false;
        }
    }

    @Override // bf.d
    public boolean B(int i10) {
        ITranActivityManager iTranActivityManager = this.f7847a;
        if (iTranActivityManager == null) {
            return false;
        }
        try {
            return iTranActivityManager.setCpuSystemSence(i10);
        } catch (RemoteException e10) {
            j7.b.a("setCpuSystemSence error: ", e10, f7845g);
            return false;
        }
    }

    @Override // bf.d
    public void B0(h9.g.b bVar) {
        d dVarComputeIfAbsent = this.f7851e.computeIfAbsent(bVar, new Function() { // from class: ic.h
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return o0.w1(this.f7809a, (h9.g.b) obj);
            }
        });
        ITranActivityManager iTranActivityManager = this.f7847a;
        if (iTranActivityManager != null) {
            try {
                iTranActivityManager.registerBloodOxygenLedStateListener(dVarComputeIfAbsent);
            } catch (RemoteException e10) {
                dc.e.d(f7845g, "registerBloodOxygenLedStateListener error: ", e10);
            }
        }
    }

    @Override // bf.d
    public List<String> C() {
        List<String> list = (List) new zb.f().c(new zb.f.b() { // from class: ic.k0
            @Override // zb.f.b
            public final Object run() {
                return this.f7822a.T1();
            }
        }, "activity");
        dc.e.f(f7845g, "getCleanProtectList mLists:" + list);
        return list;
    }

    @Override // bf.d
    public int C0(ActivityManager.RunningTaskInfo runningTaskInfo) {
        ITranActivityManager iTranActivityManager = this.f7847a;
        if (iTranActivityManager == null) {
            return 0;
        }
        try {
            return iTranActivityManager.getUserId(runningTaskInfo);
        } catch (RemoteException e10) {
            j7.b.a("getUserId fail :", e10, f7845g);
            return 0;
        }
    }

    @Override // bf.d
    public void D(String str, int i10) {
        ITranActivityManager iTranActivityManager = this.f7847a;
        if (iTranActivityManager != null) {
            try {
                iTranActivityManager.stopAppForUser(str, i10);
            } catch (RemoteException e10) {
                j7.b.a("stopAppForUser error: ", e10, f7845g);
            }
        }
    }

    @Override // bf.d
    public boolean D0(long j10) {
        ITranActivityManager iTranActivityManager = this.f7847a;
        if (iTranActivityManager == null) {
            return false;
        }
        try {
            return iTranActivityManager.triggerMPSKBySwapFree(j10);
        } catch (RemoteException e10) {
            j7.b.a("triggerMPSKBySwapFree error: ", e10, f7845g);
            return false;
        }
    }

    @Override // bf.d
    public int E(final String str) {
        int iIntValue = ((Integer) new zb.f().c(new zb.f.b() { // from class: ic.j0
            @Override // zb.f.b
            public final Object run() {
                return this.f7817a.W1(str);
            }
        }, "activity")).intValue();
        dc.e.a(f7845g, "getMemoryForMF");
        return iIntValue;
    }

    @Override // bf.d
    public boolean E0() {
        boolean zBooleanValue = ((Boolean) new zb.f().c(new zb.f.b() { // from class: ic.j
            @Override // zb.f.b
            public final Object run() {
                return this.f7816a.g2();
            }
        }, "activity")).booleanValue();
        dc.e.a(f7845g, "isMemSettingEnterEnabled");
        return zBooleanValue;
    }

    @Override // bf.d
    public boolean F(String str, String str2) {
        ITranActivityManager iTranActivityManager = this.f7847a;
        if (iTranActivityManager == null) {
            return false;
        }
        try {
            return iTranActivityManager.isRequestChangeParams(str, str2);
        } catch (RemoteException e10) {
            j7.b.a("isRequestChangeParams:", e10, f7845g);
            return false;
        }
    }

    @Override // bf.d
    public List<String> F0(final int i10) {
        List<String> list = (List) new zb.f().c(new zb.f.b() { // from class: ic.x
            @Override // zb.f.b
            public final Object run() {
                return this.f7912a.a2(i10);
            }
        }, "activity");
        dc.e.a(f7845g, "getTranGameList");
        return list;
    }

    @Override // bf.d
    public void G(final boolean z10) {
        new zb.f().c(new zb.f.b() { // from class: ic.f0
            @Override // zb.f.b
            public final Object run() {
                return this.f7796a.t2(z10);
            }
        }, "window");
    }

    @Override // bf.d
    public void G0(final boolean z10) {
        new zb.f().c(new zb.f.b() { // from class: ic.c0
            @Override // zb.f.b
            public final Object run() {
                return this.f7778a.u2(z10);
            }
        }, "window");
    }

    @Override // bf.d
    public int H(final String str) {
        int iIntValue = ((Integer) new zb.f().c(new zb.f.b() { // from class: ic.z
            @Override // zb.f.b
            public final Object run() {
                return this.f7924a.h2(str);
            }
        }, "activity")).intValue();
        dc.e.a(f7845g, "isMemoryEnoughToMF");
        return iIntValue;
    }

    @Override // bf.d
    public List<String> H0(int i10, String str, boolean z10) {
        ITranActivityManager iTranActivityManager = this.f7847a;
        if (iTranActivityManager != null) {
            try {
                return iTranActivityManager.setAppInCgroup(i10, str, z10).getList();
            } catch (RemoteException e10) {
                j7.b.a("setMemoryPresureLevel error: ", e10, f7845g);
            }
        }
        return Collections.emptyList();
    }

    @Override // bf.d
    public boolean I() {
        boolean zBooleanValue = ((Boolean) new zb.f().c(new zb.f.b() { // from class: ic.b0
            @Override // zb.f.b
            public final Object run() {
                return this.f7775a.e2();
            }
        }, "activity")).booleanValue();
        n0.a("isLowRamDeviceStatic result:", zBooleanValue, f7845g);
        return zBooleanValue;
    }

    @Override // bf.d
    public int I0(IBinder iBinder) {
        ITranActivityManager iTranActivityManager = this.f7847a;
        if (iTranActivityManager == null) {
            return 0;
        }
        try {
            return iTranActivityManager.getLaunchedFromUid(iBinder);
        } catch (RemoteException e10) {
            j7.b.a("getLaunchedFromUid fail :", e10, f7845g);
            return 0;
        }
    }

    @Override // bf.d
    public boolean J(int i10, String str, String str2) {
        ITranActivityManager iTranActivityManager = this.f7847a;
        if (iTranActivityManager == null) {
            return false;
        }
        try {
            return iTranActivityManager.setAppForFixAdj(i10, str, str2);
        } catch (RemoteException e10) {
            j7.b.a("setAppForFixAdj error: ", e10, f7845g);
            return false;
        }
    }

    @Override // bf.d
    public void J0(int i10) {
        ITranActivityManager iTranActivityManager = this.f7847a;
        if (iTranActivityManager == null) {
            return;
        }
        try {
            iTranActivityManager.toggleFreeformWindowingMode(i10);
        } catch (RemoteException e10) {
            j7.b.a("toggleFreeformWindowingMode:", e10, f7845g);
        }
    }

    @Override // bf.d
    public List<String> K() {
        List<String> list = (List) new zb.f().c(new zb.f.b() { // from class: ic.e0
            @Override // zb.f.b
            public final Object run() {
                return this.f7790a.X1();
            }
        }, "activity");
        dc.e.a(f7845g, "getSwapFileSizeList");
        return list;
    }

    @Override // bf.d
    public void K0(final int i10) {
        new zb.f().c(new zb.f.b() { // from class: ic.k
            @Override // zb.f.b
            public final Object run() {
                return this.f7820a.M1(i10);
            }
        }, "activity");
        dc.e.f(f7845g, "backgroundAllowlistUid uid:" + i10);
    }

    @Override // bf.d
    public void L(h9.g.c cVar) {
        if (this.f7847a == null) {
            return;
        }
        e eVar = new e(cVar);
        this.f7848b.put(cVar, eVar);
        try {
            this.f7847a.registerProcessObserver(eVar);
        } catch (RemoteException e10) {
            e10.printStackTrace();
        }
    }

    @Override // bf.d
    public void L0(final List<String> list) {
        new zb.f().c(new zb.f.b() { // from class: ic.u
            @Override // zb.f.b
            public final Object run() {
                return this.f7898a.o2(list);
            }
        }, "activity");
        dc.e.a(f7845g, "setBlackListToSystem");
    }

    @Override // bf.d
    public void M(final String str, final String str2, final boolean z10, final List<String> list) {
        new zb.f().c(new zb.f.b() { // from class: ic.y
            @Override // zb.f.b
            public final Object run() {
                return this.f7917a.R1(str, str2, z10, list);
            }
        }, "activity");
        dc.e.a(f7845g, "gameSceneStart");
    }

    @Override // bf.d
    public boolean M0(int i10) {
        ITranActivityManager iTranActivityManager = this.f7847a;
        if (iTranActivityManager == null) {
            return false;
        }
        try {
            return iTranActivityManager.setCpuUsagePercentForKill(i10);
        } catch (RemoteException e10) {
            j7.b.a("setCpuUsagePercentForKill error: ", e10, f7845g);
            return false;
        }
    }

    public final /* synthetic */ Object M1(int i10) throws RemoteException {
        ITranActivityManager iTranActivityManager = this.f7847a;
        if (iTranActivityManager == null) {
            return null;
        }
        iTranActivityManager.backgroundAllowlistUid(i10);
        return null;
    }

    @Override // bf.d
    public boolean N(String str, boolean z10) {
        ITranActivityManager iTranActivityManager = this.f7847a;
        if (iTranActivityManager == null) {
            return false;
        }
        try {
            return iTranActivityManager.setETControl(str, z10);
        } catch (RemoteException e10) {
            j7.b.a("setETControl:", e10, f7845g);
            return false;
        }
    }

    @Override // bf.d
    public String N0(IBinder iBinder) {
        ITranActivityManager iTranActivityManager = this.f7847a;
        if (iTranActivityManager == null) {
            return null;
        }
        try {
            return iTranActivityManager.getLaunchedFromPackage(iBinder);
        } catch (RemoteException e10) {
            j7.b.a("getLaunchedFromPackage fail :", e10, f7845g);
            return null;
        }
    }

    public final /* synthetic */ Object N1(String str) throws RemoteException {
        ITranActivityManager iTranActivityManager = this.f7847a;
        if (iTranActivityManager == null) {
            return null;
        }
        iTranActivityManager.changeCompactionMem(str);
        return null;
    }

    @Override // bf.d
    public long[] O() {
        ITranActivityManager iTranActivityManager = this.f7847a;
        if (iTranActivityManager == null) {
            return null;
        }
        try {
            return iTranActivityManager.getKernelMemInfo();
        } catch (RemoteException e10) {
            j7.b.a("getKernelMemInfo error: ", e10, f7845g);
            return null;
        }
    }

    @Override // bf.d
    public void O0(int i10) {
        ITranActivityManager iTranActivityManager = this.f7847a;
        if (iTranActivityManager == null) {
            return;
        }
        try {
            iTranActivityManager.hookDisturbStatus(i10);
        } catch (RemoteException e10) {
            j7.b.a("hookDisturbStatus:", e10, f7845g);
        }
    }

    public final /* synthetic */ Object O1(boolean z10) throws RemoteException {
        ITranActivityManager iTranActivityManager = this.f7847a;
        if (iTranActivityManager == null) {
            return null;
        }
        iTranActivityManager.enableHiber(z10);
        return null;
    }

    @Override // bf.d
    public Bundle P() {
        ITranActivityManager iTranActivityManager = this.f7847a;
        if (iTranActivityManager == null) {
            return null;
        }
        try {
            return iTranActivityManager.getNativeProcessRss();
        } catch (RemoteException e10) {
            j7.b.a("getNativeProcessRss error: ", e10, f7845g);
            return null;
        }
    }

    @Override // bf.d
    public void P0(h9.u uVar) {
        if (this.f7847a == null) {
            return;
        }
        try {
            this.f7847a.unregisterUserSwitchObserver(this.f7850d.get(uVar));
        } catch (RemoteException e10) {
            j7.b.a("registerUserSwitchObserver:", e10, f7845g);
        }
    }

    public final /* synthetic */ Object P1(String str, int i10, int i11) throws RemoteException {
        ITranActivityManager iTranActivityManager = this.f7847a;
        if (iTranActivityManager == null) {
            return null;
        }
        iTranActivityManager.forceStopPackageNecessity(str, i10, i11);
        return null;
    }

    @Override // bf.d
    public boolean Q(int i10, int i11) {
        ITranActivityManager iTranActivityManager = this.f7847a;
        if (iTranActivityManager == null) {
            return false;
        }
        try {
            return iTranActivityManager.isUserRunning(i10, i11);
        } catch (RemoteException e10) {
            j7.b.a("isUserRunning error: ", e10, f7845g);
            return false;
        }
    }

    @Override // bf.d
    public ComponentName Q0(ActivityManager.RunningTaskInfo runningTaskInfo) {
        ITranActivityManager iTranActivityManager = this.f7847a;
        if (iTranActivityManager == null) {
            return null;
        }
        try {
            return iTranActivityManager.getRealActivity(runningTaskInfo);
        } catch (RemoteException e10) {
            j7.b.a("getRealActivity fail :", e10, f7845g);
            return null;
        }
    }

    public final /* synthetic */ Object Q1(String str, boolean z10) throws RemoteException {
        ITranActivityManager iTranActivityManager = this.f7847a;
        if (iTranActivityManager == null) {
            return null;
        }
        iTranActivityManager.gameSceneEnd(str, z10);
        return null;
    }

    @Override // bf.d
    public boolean R(int i10) {
        ITranActivityManager iTranActivityManager = this.f7847a;
        if (iTranActivityManager == null) {
            return false;
        }
        try {
            return iTranActivityManager.triggerMPSKByMemFreeExt(i10);
        } catch (RemoteException e10) {
            j7.b.a("triggerMPSKByMemFree with int error: ", e10, f7845g);
            return false;
        }
    }

    @Override // bf.d
    public void R0() {
        ITranActivityManager iTranActivityManager = this.f7847a;
        if (iTranActivityManager == null) {
            return;
        }
        try {
            iTranActivityManager.setCurrentActivityKeepAwake();
        } catch (RemoteException e10) {
            j7.b.a("setCurrentActivityKeepAwake fail:", e10, f7845g);
        }
    }

    public final /* synthetic */ Object R1(String str, String str2, boolean z10, List list) throws RemoteException {
        ITranActivityManager iTranActivityManager = this.f7847a;
        if (iTranActivityManager == null) {
            return null;
        }
        iTranActivityManager.gameSceneStart(str, str2, z10, list);
        return null;
    }

    @Override // bf.d
    public boolean S() {
        boolean zBooleanValue = ((Boolean) new zb.f().c(new zb.f.b() { // from class: ic.m
            @Override // zb.f.b
            public final Object run() {
                return this.f7833a.c2();
            }
        }, "activity")).booleanValue();
        dc.e.a(f7845g, "isGameGuardSupport");
        return zBooleanValue;
    }

    @Override // bf.d
    public boolean S0(final String str, final String str2, final String str3) {
        boolean zBooleanValue = ((Boolean) new zb.f().c(new zb.f.b() { // from class: ic.a0
            @Override // zb.f.b
            public final Object run() {
                return this.f7768a.q2(str, str2, str3);
            }
        }, "activity")).booleanValue();
        dc.e.a(f7845g, "setGameParam");
        return zBooleanValue;
    }

    public final /* synthetic */ Object S1(int i10) throws RemoteException {
        ITranActivityManager iTranActivityManager = this.f7847a;
        if (iTranActivityManager != null) {
            return iTranActivityManager.getAppListMode(i10);
        }
        return null;
    }

    @Override // bf.d
    public void T(String str) {
        ITranActivityManager iTranActivityManager = this.f7847a;
        if (iTranActivityManager != null) {
            try {
                iTranActivityManager.setAudioPatch(str);
            } catch (RemoteException e10) {
                j7.b.a("setAudioPatch error: ", e10, f7845g);
            }
        }
    }

    @Override // bf.d
    public long T0() {
        ITranActivityManager iTranActivityManager = this.f7847a;
        if (iTranActivityManager == null) {
            return 0L;
        }
        try {
            return iTranActivityManager.calculateReclaimableMemory();
        } catch (RemoteException e10) {
            j7.b.a("calculateReclaimableMemory error: ", e10, f7845g);
            return 0L;
        }
    }

    public final /* synthetic */ Object T1() throws RemoteException {
        ITranActivityManager iTranActivityManager = this.f7847a;
        if (iTranActivityManager != null) {
            return iTranActivityManager.getCleanProtectList();
        }
        return null;
    }

    @Override // bf.d
    public void U(final boolean z10) {
        new zb.f().c(new zb.f.b() { // from class: ic.g
            @Override // zb.f.b
            public final Object run() {
                return this.f7804a.k2(z10);
            }
        }, "activity");
        dc.e.a(f7845g, "notifyInterceptUnknowSource");
    }

    @Override // bf.d
    public boolean U0(UserHandle userHandle) {
        ITranActivityManager iTranActivityManager = this.f7847a;
        if (iTranActivityManager == null) {
            return false;
        }
        try {
            return iTranActivityManager.startProfile(userHandle);
        } catch (RemoteException e10) {
            j7.b.a("startProfile fail:", e10, f7845g);
            return false;
        }
    }

    public final /* synthetic */ Object U1() throws RemoteException {
        ITranActivityManager iTranActivityManager = this.f7847a;
        if (iTranActivityManager != null) {
            return iTranActivityManager.getLocale().mLocale;
        }
        return null;
    }

    @Override // bf.d
    public void V(h9.g.d dVar) {
        c cVar;
        if (this.f7847a == null || (cVar = this.f7852f.get(dVar)) == null) {
            return;
        }
        try {
            this.f7847a.unregisterActivityStartObserver(cVar);
        } catch (RemoteException e10) {
            j7.b.a("unregisterActivityStartObserver error: ", e10, f7845g);
        }
    }

    @Override // bf.d
    public Configuration V0(ActivityManager.RunningTaskInfo runningTaskInfo) {
        ITranActivityManager iTranActivityManager = this.f7847a;
        if (iTranActivityManager == null) {
            return null;
        }
        try {
            return iTranActivityManager.getConfigurationExt(runningTaskInfo);
        } catch (RemoteException e10) {
            j7.b.a("getConfigurationExt:", e10, f7845g);
            return null;
        }
    }

    public final /* synthetic */ Object V1(String str) throws RemoteException {
        ITranActivityManager iTranActivityManager = this.f7847a;
        if (iTranActivityManager != null) {
            return iTranActivityManager.getMEMCList(str);
        }
        return null;
    }

    @Override // bf.d
    public int W(final String str, final String str2) {
        int iIntValue = ((Integer) new zb.f().c(new zb.f.b() { // from class: ic.g0
            @Override // zb.f.b
            public final Object run() {
                return this.f7806a.Y1(str, str2);
            }
        }, "activity")).intValue();
        dc.e.a(f7845g, "getTargetFps");
        return iIntValue;
    }

    @Override // bf.d
    public boolean W0() {
        ITranActivityManager iTranActivityManager = this.f7847a;
        if (iTranActivityManager == null) {
            return false;
        }
        try {
            return iTranActivityManager.ignoreCPUAndMemoryPressureForPreload();
        } catch (RemoteException e10) {
            j7.b.a("ignoreCPUAndMemoryPressureForPreload error: ", e10, f7845g);
            return false;
        }
    }

    public final /* synthetic */ Object W1(String str) throws RemoteException {
        ITranActivityManager iTranActivityManager = this.f7847a;
        if (iTranActivityManager != null) {
            return Integer.valueOf(iTranActivityManager.getMemoryForMF(str));
        }
        return null;
    }

    @Override // bf.d
    public boolean X(final int i10) {
        boolean zBooleanValue = ((Boolean) new zb.f().c(new zb.f.b() { // from class: ic.l0
            @Override // zb.f.b
            public final Object run() {
                return this.f7827a.s2(i10);
            }
        }, "activity")).booleanValue();
        n0.a("startUserInBackground result:", zBooleanValue, f7845g);
        return zBooleanValue;
    }

    @Override // bf.d
    public Locale X0() {
        Locale locale = (Locale) new zb.f().c(new zb.f.b() { // from class: ic.v
            @Override // zb.f.b
            public final Object run() {
                return this.f7905a.U1();
            }
        }, "activity");
        dc.e.c(f7845g, "getLocale");
        return locale;
    }

    public final /* synthetic */ Object X1() throws RemoteException {
        ITranActivityManager iTranActivityManager = this.f7847a;
        if (iTranActivityManager != null) {
            return iTranActivityManager.getSwapFileSizeList();
        }
        return null;
    }

    @Override // bf.d
    public void Y(int[] iArr) {
        ITranActivityManager iTranActivityManager = this.f7847a;
        if (iTranActivityManager != null) {
            try {
                iTranActivityManager.setLightingEffect(iArr);
            } catch (RemoteException e10) {
                dc.e.d(f7845g, "setLightingEffect error: ", e10);
            }
        }
    }

    @Override // bf.d
    public void Y0(h9.s sVar) {
        if (this.f7847a == null || sVar == null) {
            return;
        }
        try {
            f fVar = new f(sVar);
            this.f7849c.put(sVar, fVar);
            this.f7847a.registerTaskStackListener(fVar);
        } catch (RemoteException e10) {
            j7.b.a("registerTaskStackListener:", e10, f7845g);
        }
    }

    public final /* synthetic */ Object Y1(String str, String str2) throws RemoteException {
        ITranActivityManager iTranActivityManager = this.f7847a;
        if (iTranActivityManager != null) {
            return Integer.valueOf(iTranActivityManager.getTargetFps(str, str2));
        }
        return null;
    }

    @Override // bf.d
    public boolean Z(int i10) {
        ITranActivityManager iTranActivityManager = this.f7847a;
        if (iTranActivityManager == null) {
            return false;
        }
        try {
            return iTranActivityManager.setMemSystemSence(i10);
        } catch (RemoteException e10) {
            j7.b.a("setMemSystemSence error: ", e10, f7845g);
            return false;
        }
    }

    @Override // bf.d
    public boolean Z0(int i10) {
        ITranActivityManager iTranActivityManager = this.f7847a;
        if (iTranActivityManager == null) {
            return false;
        }
        try {
            return iTranActivityManager.setCpuPresureLevel(i10);
        } catch (RemoteException e10) {
            j7.b.a("setCpuPresureLevel error: ", e10, f7845g);
            return false;
        }
    }

    public final /* synthetic */ Object Z1() throws RemoteException {
        ITranActivityManager iTranActivityManager = this.f7847a;
        if (iTranActivityManager != null) {
            return iTranActivityManager.getTopActivityInfo();
        }
        return null;
    }

    @Override // bf.d
    public boolean a(int i10) {
        ITranActivityManager iTranActivityManager = this.f7847a;
        if (iTranActivityManager == null) {
            return false;
        }
        try {
            return iTranActivityManager.inMultiWindowMode(i10);
        } catch (RemoteException e10) {
            j7.b.a("inMultiWindowMode:", e10, f7845g);
            return false;
        }
    }

    @Override // bf.d
    public boolean a0() {
        ITranActivityManager iTranActivityManager = this.f7847a;
        if (iTranActivityManager == null) {
            return false;
        }
        try {
            return iTranActivityManager.resetAllTest();
        } catch (RemoteException e10) {
            j7.b.a("resetAllTest error: ", e10, f7845g);
            return false;
        }
    }

    public final /* synthetic */ Object a2(int i10) throws RemoteException {
        ITranActivityManager iTranActivityManager = this.f7847a;
        if (iTranActivityManager != null) {
            return iTranActivityManager.getTranGameList(i10);
        }
        return null;
    }

    @Override // bf.d
    public boolean b(final String str) {
        boolean zBooleanValue = ((Boolean) new zb.f().c(new zb.f.b() { // from class: ic.t
            @Override // zb.f.b
            public final Object run() {
                return this.f7893a.j2(str);
            }
        }, "activity")).booleanValue();
        dc.e.a(f7845g, "isWhiteApp");
        return zBooleanValue;
    }

    @Override // bf.d
    public boolean b0() {
        boolean zBooleanValue = ((Boolean) new zb.f().c(new zb.f.b() { // from class: ic.s
            @Override // zb.f.b
            public final Object run() {
                return this.f7890a.f2();
            }
        }, "activity")).booleanValue();
        dc.e.a(f7845g, "isMatchCurMemSelection");
        return zBooleanValue;
    }

    public final /* synthetic */ Object b2() throws RemoteException {
        ITranActivityManager iTranActivityManager = this.f7847a;
        if (iTranActivityManager != null) {
            return Boolean.valueOf(iTranActivityManager.isEnabledHiber());
        }
        return null;
    }

    @Override // bf.d
    public void c(final int i10, final int i11) {
        new zb.f().c(new zb.f.b() { // from class: ic.m0
            @Override // zb.f.b
            public final Object run() {
                return this.f7834a.n2(i10, i11);
            }
        }, "activity");
        dc.e.a(f7845g, "setAppMode");
    }

    @Override // bf.d
    public int c0(ActivityManager.RunningTaskInfo runningTaskInfo) {
        ITranActivityManager iTranActivityManager = this.f7847a;
        if (iTranActivityManager == null) {
            return 0;
        }
        try {
            return iTranActivityManager.getTopActivityType(runningTaskInfo);
        } catch (RemoteException e10) {
            j7.b.a("getTopActivityType fail :", e10, f7845g);
            return 0;
        }
    }

    public final /* synthetic */ Object c2() throws RemoteException {
        ITranActivityManager iTranActivityManager = this.f7847a;
        return iTranActivityManager != null ? Boolean.valueOf(iTranActivityManager.isGameGuardSupport()) : Boolean.FALSE;
    }

    @Override // bf.d
    public int[] d(final int i10) {
        int[] iArr = (int[]) new zb.f().c(new zb.f.b() { // from class: ic.p
            @Override // zb.f.b
            public final Object run() {
                return this.f7869a.S1(i10);
            }
        }, "activity");
        dc.e.a(f7845g, "getAppListMode");
        return iArr;
    }

    @Override // bf.d
    public void d0(h9.u uVar, String str) {
        if (this.f7847a == null) {
            return;
        }
        if (this.f7850d.size() > 30) {
            dc.e.c(f7845g, "registerUserSwitchObserver mUserSwitchListenerMap.size() is " + this.f7850d.size());
        }
        if (uVar != null) {
            try {
                g gVar = new g(uVar);
                this.f7850d.put(uVar, gVar);
                this.f7847a.registerUserSwitchObserver(gVar, str);
            } catch (RemoteException e10) {
                j7.b.a("registerUserSwitchObserver:", e10, f7845g);
            }
        }
    }

    public final /* synthetic */ Object d2(String str) throws RemoteException {
        ITranActivityManager iTranActivityManager = this.f7847a;
        return iTranActivityManager != null ? Boolean.valueOf(iTranActivityManager.isInGameGuardProtectedList(str)) : Boolean.FALSE;
    }

    @Override // bf.d
    public void e(final boolean z10) {
        new zb.f().c(new zb.f.b() { // from class: ic.d
            @Override // zb.f.b
            public final Object run() {
                return this.f7782a.O1(z10);
            }
        }, "activity");
        dc.e.a(f7845g, "enableHiber");
    }

    @Override // bf.d
    public int e0(ActivityManager.RunningTaskInfo runningTaskInfo) {
        ITranActivityManager iTranActivityManager = this.f7847a;
        if (iTranActivityManager == null) {
            return 0;
        }
        try {
            return iTranActivityManager.getDisplayId(runningTaskInfo);
        } catch (RemoteException e10) {
            j7.b.a("getDisplayId fail :", e10, f7845g);
            return 0;
        }
    }

    public final /* synthetic */ Object e2() throws RemoteException {
        ITranActivityManager iTranActivityManager = this.f7847a;
        return iTranActivityManager != null ? Boolean.valueOf(iTranActivityManager.isLowRamDeviceStatic()) : Boolean.FALSE;
    }

    @Override // bf.d
    public boolean f() {
        boolean zBooleanValue = ((Boolean) new zb.f().c(new zb.f.b() { // from class: ic.i
            @Override // zb.f.b
            public final Object run() {
                return this.f7813a.b2();
            }
        }, "activity")).booleanValue();
        dc.e.a(f7845g, "isEnabledHiber");
        return zBooleanValue;
    }

    @Override // bf.d
    public List<String> f0(final String str) {
        List<String> list = (List) new zb.f().c(new zb.f.b() { // from class: ic.o
            @Override // zb.f.b
            public final Object run() {
                return this.f7843a.V1(str);
            }
        }, "activity");
        dc.e.a(f7845g, "getMEMCList");
        return list;
    }

    public final /* synthetic */ Object f2() throws RemoteException {
        ITranActivityManager iTranActivityManager = this.f7847a;
        if (iTranActivityManager != null) {
            return Boolean.valueOf(iTranActivityManager.isMatchCurMemSelection());
        }
        return null;
    }

    @Override // bf.d
    public String g(String str) {
        try {
            ITranActivityManager iTranActivityManager = this.f7847a;
            return iTranActivityManager != null ? iTranActivityManager.getTranAppmSystemInfo(str) : "unknown";
        } catch (RemoteException e10) {
            j7.b.a("getTranAppmSystemInfo fail: ", e10, f7845g);
            return "unknown";
        }
    }

    @Override // bf.d
    public boolean g0() {
        boolean zBooleanValue = ((Boolean) new zb.f().c(new zb.f.b() { // from class: ic.f
            @Override // zb.f.b
            public final Object run() {
                return this.f7795a.i2();
            }
        }, "activity")).booleanValue();
        dc.e.a(f7845g, "isUxCompactionSupport");
        return zBooleanValue;
    }

    public final /* synthetic */ Object g2() throws RemoteException {
        ITranActivityManager iTranActivityManager = this.f7847a;
        if (iTranActivityManager != null) {
            return Boolean.valueOf(iTranActivityManager.isMemSettingEnterEnabled());
        }
        return null;
    }

    @Override // bf.d
    public void h(int i10, int[] iArr, Bundle bundle) {
        ITranActivityManager iTranActivityManager = this.f7847a;
        if (iTranActivityManager != null) {
            try {
                iTranActivityManager.setLightingScene(i10, iArr, bundle);
            } catch (RemoteException e10) {
                dc.e.d(f7845g, "setLightingScene error: ", e10);
            }
        }
    }

    @Override // bf.d
    public void h0(h9.g.a aVar, IBinder iBinder) {
        if (this.f7847a != null) {
            try {
                this.f7847a.registerAppRecoveryCallback(new a(aVar, iBinder), iBinder);
            } catch (RemoteException unused) {
                dc.e.c(f7845g, "registerAppRecoveryCallback error");
            }
        }
    }

    public final /* synthetic */ Object h2(String str) throws RemoteException {
        ITranActivityManager iTranActivityManager = this.f7847a;
        if (iTranActivityManager != null) {
            return Integer.valueOf(iTranActivityManager.isMemoryEnoughToMF(str));
        }
        return null;
    }

    @Override // bf.d
    public boolean i(int i10) {
        ITranActivityManager iTranActivityManager = this.f7847a;
        if (iTranActivityManager == null) {
            return false;
        }
        try {
            return iTranActivityManager.triggerMPSKByMemAvailableExt(i10);
        } catch (RemoteException e10) {
            j7.b.a("triggerMPSKByMemAvailable with int error: ", e10, f7845g);
            return false;
        }
    }

    @Override // bf.d
    public void i0(final String str) {
        new zb.f().c(new zb.f.b() { // from class: ic.n
            @Override // zb.f.b
            public final Object run() {
                return this.f7841a.N1(str);
            }
        }, "window");
    }

    public final /* synthetic */ Object i2() throws RemoteException {
        ITranActivityManager iTranActivityManager = this.f7847a;
        if (iTranActivityManager != null) {
            return Boolean.valueOf(iTranActivityManager.isUxCompactionSupport());
        }
        return null;
    }

    @Override // bf.d
    public int j(ActivityManager.RunningTaskInfo runningTaskInfo) {
        ITranActivityManager iTranActivityManager = this.f7847a;
        if (iTranActivityManager == null) {
            return 0;
        }
        try {
            return iTranActivityManager.getWindowingMode(runningTaskInfo);
        } catch (RemoteException e10) {
            j7.b.a("getWindowingMode:", e10, f7845g);
            return 0;
        }
    }

    @Override // bf.d
    public boolean j0(String[] strArr, h9.g.d dVar) {
        c cVarComputeIfAbsent;
        if (this.f7847a != null && (cVarComputeIfAbsent = this.f7852f.computeIfAbsent(dVar, new Function() { // from class: ic.i0
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return o0.q1(this.f7814a, (h9.g.d) obj);
            }
        })) != null) {
            try {
                return this.f7847a.registerActivityStartObserver(strArr, cVarComputeIfAbsent);
            } catch (RemoteException e10) {
                j7.b.a("registerActivityStartObserver error: ", e10, f7845g);
            }
        }
        return false;
    }

    public final /* synthetic */ Object j2(String str) throws RemoteException {
        ITranActivityManager iTranActivityManager = this.f7847a;
        if (iTranActivityManager != null) {
            return Boolean.valueOf(iTranActivityManager.isWhiteApp(str));
        }
        return null;
    }

    @Override // bf.d
    public void k(String str) {
        ITranActivityManager iTranActivityManager = this.f7847a;
        if (iTranActivityManager != null) {
            try {
                iTranActivityManager.forceStopPackage(str);
            } catch (RemoteException e10) {
                j7.b.a("forceStopPackage fail:", e10, f7845g);
            }
        }
    }

    @Override // bf.d
    public void k0(final String str, final int i10, final int i11) {
        new zb.f().c(new zb.f.b() { // from class: ic.q
            @Override // zb.f.b
            public final Object run() {
                return this.f7877a.P1(str, i10, i11);
            }
        }, "activity");
        dc.e.a(f7845g, "forceStopPackageNecessity");
    }

    public final /* synthetic */ Object k2(boolean z10) throws RemoteException {
        ITranActivityManager iTranActivityManager = this.f7847a;
        if (iTranActivityManager == null) {
            return null;
        }
        iTranActivityManager.notifyInterceptUnknowSource(z10);
        return null;
    }

    @Override // bf.d
    public int l() {
        ITranActivityManager iTranActivityManager = this.f7847a;
        if (iTranActivityManager == null) {
            return 0;
        }
        try {
            return iTranActivityManager.getLockTaskModeState();
        } catch (RemoteException e10) {
            j7.b.a("getLockTaskModeState fail :", e10, f7845g);
            return 0;
        }
    }

    @Override // bf.d
    public int l0() {
        ITranActivityManager iTranActivityManager = this.f7847a;
        if (iTranActivityManager == null) {
            return 0;
        }
        try {
            return iTranActivityManager.getCurrentUser();
        } catch (RemoteException e10) {
            j7.b.a("getCurrentUser fail :", e10, f7845g);
            return 0;
        }
    }

    public final /* synthetic */ c l2(h9.g.d dVar) {
        return new c(dVar);
    }

    @Override // bf.d
    public boolean m() {
        ITranActivityManager iTranActivityManager = this.f7847a;
        if (iTranActivityManager == null) {
            return false;
        }
        try {
            return iTranActivityManager.triggerMemPressureforSortKill();
        } catch (RemoteException e10) {
            j7.b.a("triggerMemPressureforSortKill error: ", e10, f7845g);
            return false;
        }
    }

    @Override // bf.d
    public int m0(int i10) {
        ITranActivityManager iTranActivityManager = this.f7847a;
        if (iTranActivityManager == null) {
            return -1;
        }
        try {
            return iTranActivityManager.getBackgroundRestrictionExemptionReason(i10);
        } catch (RemoteException e10) {
            j7.b.a("getBackgroundRestrictionExemptionReason error: ", e10, f7845g);
            return -1;
        }
    }

    public final /* synthetic */ d m2(h9.g.b bVar) {
        return new d(bVar);
    }

    @Override // bf.d
    public void n() {
        ITranActivityManager iTranActivityManager = this.f7847a;
        if (iTranActivityManager != null) {
            try {
                iTranActivityManager.resumeAppSwitches();
            } catch (RemoteException e10) {
                j7.b.a("resumeAppSwitches error: ", e10, f7845g);
            }
        }
    }

    @Override // bf.d
    public int n0() {
        ITranActivityManager iTranActivityManager = this.f7847a;
        if (iTranActivityManager == null) {
            return 0;
        }
        try {
            return iTranActivityManager.getBloodOxygenLedState();
        } catch (RemoteException e10) {
            j7.b.a("getBloodOxygenLedState error: ", e10, f7845g);
            return 0;
        }
    }

    public final /* synthetic */ Object n2(int i10, int i11) throws RemoteException {
        ITranActivityManager iTranActivityManager = this.f7847a;
        if (iTranActivityManager == null) {
            return null;
        }
        iTranActivityManager.setAppMode(i10, i11);
        return null;
    }

    @Override // bf.d
    public boolean o(ActivityManager.RunningTaskInfo runningTaskInfo) {
        ITranActivityManager iTranActivityManager = this.f7847a;
        if (iTranActivityManager == null) {
            return false;
        }
        try {
            return iTranActivityManager.isVisible(runningTaskInfo);
        } catch (RemoteException e10) {
            j7.b.a("isVisible fail :", e10, f7845g);
            return false;
        }
    }

    @Override // bf.d
    public void o0(h9.g.b bVar) {
        ITranActivityManager iTranActivityManager = this.f7847a;
        if (iTranActivityManager != null) {
            try {
                iTranActivityManager.unRegisterBloodOxygenLedStateListener(this.f7851e.getOrDefault(bVar, null));
                this.f7851e.remove(bVar);
            } catch (RemoteException e10) {
                dc.e.d(f7845g, "unRegisterBloodOxygenLedStateListener error: ", e10);
            }
        }
    }

    public final /* synthetic */ Object o2(List list) throws RemoteException {
        ITranActivityManager iTranActivityManager = this.f7847a;
        if (iTranActivityManager == null) {
            return null;
        }
        iTranActivityManager.setBlackListToSystem(list);
        return null;
    }

    @Override // bf.d
    public ActivityInfo p() {
        ActivityInfo activityInfo = (ActivityInfo) new zb.f().c(new zb.f.b() { // from class: ic.h0
            @Override // zb.f.b
            public final Object run() {
                return this.f7810a.Z1();
            }
        }, "activity");
        dc.e.f(f7845g, "getTopActivityInfo mActivityInfo:" + activityInfo);
        return activityInfo;
    }

    @Override // bf.d
    public boolean p0() {
        ITranActivityManager iTranActivityManager = this.f7847a;
        if (iTranActivityManager == null) {
            return false;
        }
        try {
            return iTranActivityManager.isInLockTaskMode();
        } catch (RemoteException e10) {
            j7.b.a("isInLockTaskMode fail:", e10, f7845g);
            return false;
        }
    }

    public final /* synthetic */ Object p2(String str, boolean z10) throws RemoteException {
        ITranActivityManager iTranActivityManager = this.f7847a;
        return iTranActivityManager != null ? Boolean.valueOf(iTranActivityManager.setCleanProtect(str, z10)) : Boolean.FALSE;
    }

    @Override // bf.d
    public void q(h9.g.c cVar) {
        if (this.f7847a == null) {
            return;
        }
        e eVar = this.f7848b.get(cVar);
        if (eVar != null) {
            try {
                this.f7847a.unRegisterProcessObserver(eVar);
            } catch (RemoteException e10) {
                e10.printStackTrace();
            }
        }
        this.f7848b.remove(cVar);
    }

    @Override // bf.d
    public boolean q0(String str, String str2, int i10) {
        ITranActivityManager iTranActivityManager = this.f7847a;
        if (iTranActivityManager == null) {
            return false;
        }
        try {
            return iTranActivityManager.triggerCpuKillAppForLimit(str, str2, i10);
        } catch (RemoteException e10) {
            j7.b.a("triggerCpuKillAppForLimit error: ", e10, f7845g);
            return false;
        }
    }

    public final /* synthetic */ Object q2(String str, String str2, String str3) throws RemoteException {
        ITranActivityManager iTranActivityManager = this.f7847a;
        if (iTranActivityManager != null) {
            return Boolean.valueOf(iTranActivityManager.setGameParam(str, str2, str3));
        }
        return null;
    }

    @Override // bf.d
    public boolean r(String str, int i10) {
        ITranActivityManager iTranActivityManager = this.f7847a;
        if (iTranActivityManager == null) {
            return false;
        }
        try {
            return iTranActivityManager.setAppIdleForLimit(str, i10);
        } catch (RemoteException e10) {
            j7.b.a("setAppIdleForLimit error: ", e10, f7845g);
            return false;
        }
    }

    @Override // bf.d
    public void r0(final String str, final boolean z10) {
        new zb.f().c(new zb.f.b() { // from class: ic.l
            @Override // zb.f.b
            public final Object run() {
                return this.f7824a.Q1(str, z10);
            }
        }, "activity");
        dc.e.a(f7845g, "gameSceneEnd");
    }

    public final /* synthetic */ Object r2(boolean z10) throws RemoteException {
        ITranActivityManager iTranActivityManager = this.f7847a;
        if (iTranActivityManager == null) {
            return null;
        }
        iTranActivityManager.setLedMusicPlay(z10);
        return null;
    }

    @Override // bf.d
    public boolean s(long j10) {
        ITranActivityManager iTranActivityManager = this.f7847a;
        if (iTranActivityManager == null) {
            return false;
        }
        try {
            return iTranActivityManager.triggerMPSKByMemAvailable(j10);
        } catch (RemoteException e10) {
            j7.b.a("triggerMPSKByMemAvailable error: ", e10, f7845g);
            return false;
        }
    }

    @Override // bf.d
    public boolean s0(boolean z10) {
        ITranActivityManager iTranActivityManager = this.f7847a;
        if (iTranActivityManager == null) {
            return false;
        }
        try {
            return iTranActivityManager.setTestMode(z10);
        } catch (RemoteException e10) {
            j7.b.a("setTestMode error: ", e10, f7845g);
            return false;
        }
    }

    public final /* synthetic */ Object s2(int i10) throws RemoteException {
        ITranActivityManager iTranActivityManager = this.f7847a;
        return iTranActivityManager != null ? Boolean.valueOf(iTranActivityManager.startUserInBackground(i10)) : Boolean.FALSE;
    }

    @Override // bf.d
    public void t(final h9.s sVar) {
        new zb.f().c(new zb.f.b() { // from class: ic.r
            @Override // zb.f.b
            public final Object run() {
                return this.f7885a.v2(sVar);
            }
        }, "activity");
        dc.e.f(f7845g, "unregisterTaskStackListener listener:" + sVar);
    }

    @Override // bf.d
    public boolean t0(@gm.i String str, p6.f.c cVar) {
        ITranActivityManager iTranActivityManager = this.f7847a;
        if (iTranActivityManager == null) {
            return false;
        }
        try {
            return iTranActivityManager.clearApplicationUserData(str, new b(cVar));
        } catch (RemoteException e10) {
            j7.b.a("clearApplicationUserData:", e10, f7845g);
            return false;
        }
    }

    public final /* synthetic */ Object t2(boolean z10) throws RemoteException {
        ITranActivityManager iTranActivityManager = this.f7847a;
        if (iTranActivityManager == null) {
            return null;
        }
        iTranActivityManager.switchMemFusion(z10);
        return null;
    }

    @Override // bf.d
    public Bundle u() {
        ITranActivityManager iTranActivityManager = this.f7847a;
        if (iTranActivityManager == null) {
            return null;
        }
        try {
            return iTranActivityManager.getJavaProcessRss();
        } catch (RemoteException e10) {
            j7.b.a("getJavaProcessRss error: ", e10, f7845g);
            return null;
        }
    }

    @Override // bf.d
    public boolean u0(final String str, final boolean z10) {
        boolean zBooleanValue = ((Boolean) new zb.f().c(new zb.f.b() { // from class: ic.e
            @Override // zb.f.b
            public final Object run() {
                return this.f7787a.p2(str, z10);
            }
        }, "activity")).booleanValue();
        n0.a("setCleanProtect result:", zBooleanValue, f7845g);
        return zBooleanValue;
    }

    public final /* synthetic */ Object u2(boolean z10) throws RemoteException {
        ITranActivityManager iTranActivityManager = this.f7847a;
        if (iTranActivityManager == null) {
            return null;
        }
        iTranActivityManager.switchUXCompaction(z10);
        return null;
    }

    @Override // bf.d
    public void v(IBinder iBinder) {
        ITranActivityManager iTranActivityManager = this.f7847a;
        if (iTranActivityManager != null) {
            try {
                iTranActivityManager.unRegisterAppRecoveryCallback(iBinder);
            } catch (RemoteException unused) {
                dc.e.c(f7845g, "unRegisterAppRecoveryCallback error");
            }
        }
    }

    @Override // bf.d
    public boolean v0(String str, int i10) {
        ITranActivityManager iTranActivityManager = this.f7847a;
        if (iTranActivityManager == null) {
            return false;
        }
        try {
            return iTranActivityManager.triggerHealthBlockAppForLimit(str, i10);
        } catch (RemoteException e10) {
            j7.b.a("triggerHealthBlockAppForLimit error: ", e10, f7845g);
            return false;
        }
    }

    public final /* synthetic */ Object v2(h9.s sVar) throws RemoteException {
        ITranActivityManager iTranActivityManager = this.f7847a;
        if (iTranActivityManager == null) {
            return null;
        }
        iTranActivityManager.unregisterTaskStackListener(this.f7849c.get(sVar));
        this.f7849c.remove(sVar);
        return null;
    }

    @Override // bf.d
    public boolean w(String str, String str2, int i10) {
        ITranActivityManager iTranActivityManager = this.f7847a;
        if (iTranActivityManager == null) {
            return false;
        }
        try {
            return iTranActivityManager.triggerMemoryLowKillAppForLimit(str, str2, i10);
        } catch (RemoteException e10) {
            j7.b.a("triggerMemoryLowKillAppForLimit error: ", e10, f7845g);
            return false;
        }
    }

    @Override // bf.d
    public boolean w0(int i10) {
        ITranActivityManager iTranActivityManager = this.f7847a;
        if (iTranActivityManager == null) {
            return false;
        }
        try {
            return iTranActivityManager.triggerMPSKBySwapFreeExt(i10);
        } catch (RemoteException e10) {
            j7.b.a("triggerMPSKBySwapFree with int error: ", e10, f7845g);
            return false;
        }
    }

    @VisibleForTesting
    public void w2(ITranActivityManager iTranActivityManager) {
        this.f7847a = iTranActivityManager;
    }

    @Override // bf.d
    public void x(final boolean z10) {
        new zb.f().c(new zb.f.b() { // from class: ic.d0
            @Override // zb.f.b
            public final Object run() {
                return this.f7784a.r2(z10);
            }
        }, "activity");
        dc.e.c(f7845g, "setLedMusicPlay");
    }

    @Override // bf.d
    public void x0(Bundle bundle, String str, String str2) {
        ITranActivityManager iTranActivityManager = this.f7847a;
        if (iTranActivityManager != null) {
            try {
                iTranActivityManager.reportAbnormalApp(bundle, str, str2);
            } catch (RemoteException e10) {
                j7.b.a("reportAbnormalApp error: ", e10, f7845g);
            }
        }
    }

    @Override // bf.d
    public void y(String str, long j10, int i10, String str2) {
        ITranActivityManager iTranActivityManager = this.f7847a;
        if (iTranActivityManager != null) {
            try {
                iTranActivityManager.startTNE(str, j10, i10, str2);
            } catch (RemoteException e10) {
                j7.b.a("startTNE fail:", e10, f7845g);
            }
        }
    }

    @Override // bf.d
    public boolean y0(String str, String str2) {
        ITranActivityManager iTranActivityManager = this.f7847a;
        if (iTranActivityManager == null) {
            return false;
        }
        try {
            return iTranActivityManager.sendMallocDebugSignal(str, str2);
        } catch (RemoteException e10) {
            j7.b.a("sendMallocDebugSignal error: ", e10, f7845g);
            return false;
        }
    }

    @Override // bf.d
    public boolean z(final String str) {
        boolean zBooleanValue = ((Boolean) new zb.f().c(new zb.f.b() { // from class: ic.w
            @Override // zb.f.b
            public final Object run() {
                return this.f7908a.d2(str);
            }
        }, "activity")).booleanValue();
        dc.e.a(f7845g, "isInGameGuardProtectedList");
        return zBooleanValue;
    }

    @Override // bf.d
    public boolean z0(long j10) {
        ITranActivityManager iTranActivityManager = this.f7847a;
        if (iTranActivityManager == null) {
            return false;
        }
        try {
            return iTranActivityManager.triggerMPSKByMemFree(j10);
        } catch (RemoteException e10) {
            j7.b.a("triggerMPSKByMemFree error: ", e10, f7845g);
            return false;
        }
    }
}
