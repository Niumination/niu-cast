package vd;

import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.transsion.hubsdk.TranServiceManager;
import com.transsion.hubsdk.os.ITranPocketModeCallback;
import com.transsion.hubsdk.os.ITranPowerManager;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
public class y implements pg.h {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f17007c = "y";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static Handler f17008d;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Map<String, a> f17010b = new ConcurrentHashMap();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ITranPowerManager f17009a = ITranPowerManager.Stub.asInterface(TranServiceManager.getServiceIBinder("power"));

    public class a extends ITranPocketModeCallback.Stub {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public va.i.a f17011a;

        public a(va.i.a aVar) {
            this.f17011a = aVar;
        }

        public void a(boolean z10) throws RemoteException {
            va.i.a aVar = this.f17011a;
            if (aVar != null) {
                aVar.a(z10);
            }
        }
    }

    public y() {
        f17008d = new Handler(Looper.getMainLooper());
    }

    public static /* synthetic */ a C(y yVar, va.i.a aVar, String str) {
        yVar.getClass();
        return yVar.new a(aVar);
    }

    public static /* synthetic */ a G(y yVar, va.i.a aVar, String str) {
        yVar.getClass();
        return yVar.new a(aVar);
    }

    public final /* synthetic */ Object L() throws RemoteException {
        ITranPowerManager iTranPowerManager = this.f17009a;
        if (iTranPowerManager != null) {
            return iTranPowerManager.getAcquireableWakeLockApp();
        }
        return null;
    }

    public final /* synthetic */ Object M() throws RemoteException {
        ITranPowerManager iTranPowerManager = this.f17009a;
        if (iTranPowerManager != null) {
            return Integer.valueOf(iTranPowerManager.getMaximumScreenBrightnessSetting());
        }
        return 0;
    }

    public final /* synthetic */ Object N() throws RemoteException {
        ITranPowerManager iTranPowerManager = this.f17009a;
        if (iTranPowerManager != null) {
            return Integer.valueOf(iTranPowerManager.getMinimumScreenBrightnessSetting());
        }
        return 0;
    }

    public final /* synthetic */ Object O() throws RemoteException {
        ITranPowerManager iTranPowerManager = this.f17009a;
        return iTranPowerManager != null ? Boolean.valueOf(iTranPowerManager.getScreenOnManagerEnable()) : Boolean.FALSE;
    }

    public final /* synthetic */ Object P() throws RemoteException {
        ITranPowerManager iTranPowerManager = this.f17009a;
        if (iTranPowerManager != null) {
            return iTranPowerManager.getUnacquireableWakeLockApp();
        }
        return null;
    }

    public final /* synthetic */ Object Q(String str) throws RemoteException {
        ITranPowerManager iTranPowerManager = this.f17009a;
        return iTranPowerManager != null ? Boolean.valueOf(iTranPowerManager.isTranPocketMode(str)) : Boolean.FALSE;
    }

    public final /* synthetic */ Object R(int i10, String str) throws RemoteException {
        ITranPowerManager iTranPowerManager = this.f17009a;
        return iTranPowerManager != null ? Boolean.valueOf(iTranPowerManager.isTranPocketModeByGivenSensor(i10, str)) : Boolean.FALSE;
    }

    public final /* synthetic */ Object S(boolean z10) throws RemoteException {
        ITranPowerManager iTranPowerManager = this.f17009a;
        if (iTranPowerManager == null) {
            return null;
        }
        iTranPowerManager.notifyChangeConnectState(z10);
        return null;
    }

    public final /* synthetic */ a T(va.i.a aVar, String str) {
        return new a(aVar);
    }

    public final /* synthetic */ a U(va.i.a aVar, String str) {
        return new a(aVar);
    }

    public final /* synthetic */ Object V(boolean z10) throws RemoteException {
        ITranPowerManager iTranPowerManager = this.f17009a;
        if (iTranPowerManager == null) {
            return null;
        }
        iTranPowerManager.setScreenOnManagerEnable(z10);
        return null;
    }

    public final /* synthetic */ Object W(String str, boolean z10) throws RemoteException {
        ITranPowerManager iTranPowerManager = this.f17009a;
        if (iTranPowerManager == null) {
            return null;
        }
        iTranPowerManager.setWakeLockAppMap(str, z10);
        return null;
    }

    @VisibleForTesting
    public void X(ITranPowerManager iTranPowerManager) {
        this.f17009a = iTranPowerManager;
    }

    @Override // pg.h
    public List<String> a() {
        List<String> list = (List) new zb.f().c(new zb.f.b() { // from class: vd.q
            @Override // zb.f.b
            public final Object run() {
                return this.f16973a.L();
            }
        }, "power");
        dc.e.f(f17007c, "getAcquireableWakeLockApp mLists:" + list);
        return list;
    }

    @Override // pg.h
    public void b(boolean z10, String str, boolean z11) {
        try {
            this.f17009a.shutdown(z10, str, z11);
        } catch (RemoteException e10) {
            dc.e.n(f17007c, "shutdown: e = " + e10);
        }
    }

    @Override // pg.h
    public boolean c(boolean z10) {
        try {
            return this.f17009a.setPowerSaveModeEnabled(z10);
        } catch (RemoteException e10) {
            dc.e.n(f17007c, "setPowerSaveModeEnabled: e = " + e10);
            return false;
        }
    }

    @Override // pg.h
    public int d() {
        int iIntValue = ((Integer) new zb.f().c(new zb.f.b() { // from class: vd.v
            @Override // zb.f.b
            public final Object run() {
                return this.f16995a.M();
            }
        }, "power")).intValue();
        dc.e.f(f17007c, "getMaximumScreenBrightnessSetting result:" + iIntValue);
        return iIntValue;
    }

    @Override // pg.h
    public void e(final String str, final boolean z10) {
        new zb.f().c(new zb.f.b() { // from class: vd.s
            @Override // zb.f.b
            public final Object run() {
                return this.f16981a.W(str, z10);
            }
        }, "power");
        dc.e.f(f17007c, "setWakeLockAppMap");
    }

    @Override // pg.h
    public void f(long j10) {
        try {
            this.f17009a.goToSleep(j10);
        } catch (RemoteException e10) {
            dc.e.n(f17007c, "goToSleep: e = " + e10);
        }
    }

    @Override // pg.h
    public void g(final boolean z10) {
        new zb.f().c(new zb.f.b() { // from class: vd.m
            @Override // zb.f.b
            public final Object run() {
                return this.f16956a.S(z10);
            }
        }, "power");
        dc.e.f(f17007c, "notifyChangeConnectState");
    }

    @Override // pg.h
    public boolean h() {
        boolean zBooleanValue = ((Boolean) new zb.f().c(new zb.f.b() { // from class: vd.t
            @Override // zb.f.b
            public final Object run() {
                return this.f16988a.O();
            }
        }, "power")).booleanValue();
        ic.n0.a("getScreenOnManagerEnable result:", zBooleanValue, f17007c);
        return zBooleanValue;
    }

    @Override // pg.h
    public float i(int i10) {
        try {
            return this.f17009a.getBrightnessConstraint(i10);
        } catch (RemoteException e10) {
            dc.e.n(f17007c, "getBrightnessConstraint: e = " + e10);
            return 0.0f;
        }
    }

    @Override // pg.h
    public void j(@Nullable String str) {
        try {
            this.f17009a.reboot(str);
        } catch (RemoteException e10) {
            dc.e.n(f17007c, "reboot: e = " + e10);
        }
    }

    @Override // pg.h
    public boolean k(final va.i.a aVar, String str) {
        a aVarComputeIfAbsent = this.f17010b.computeIfAbsent(str, new Function() { // from class: vd.r
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return y.C(this.f16977a, aVar, (String) obj);
            }
        });
        try {
            ITranPowerManager iTranPowerManager = this.f17009a;
            if (iTranPowerManager != null) {
                return iTranPowerManager.registerPocketModeListener(aVarComputeIfAbsent, str);
            }
            return false;
        } catch (RemoteException e10) {
            dc.e.d(f17007c, "registerPocketModeListener error: ", e10);
            return false;
        }
    }

    @Override // pg.h
    public void l(final boolean z10) {
        new zb.f().c(new zb.f.b() { // from class: vd.u
            @Override // zb.f.b
            public final Object run() {
                return this.f16991a.V(z10);
            }
        }, "power");
        dc.e.f(f17007c, "setScreenOnManagerEnable");
    }

    @Override // pg.h
    public boolean m(final va.i.a aVar, String str) {
        a aVarComputeIfAbsent = this.f17010b.computeIfAbsent(str, new Function() { // from class: vd.n
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return y.G(this.f16959a, aVar, (String) obj);
            }
        });
        try {
            ITranPowerManager iTranPowerManager = this.f17009a;
            if (iTranPowerManager != null) {
                return iTranPowerManager.registerPocketModeByProximityListener(aVarComputeIfAbsent, str);
            }
            return false;
        } catch (RemoteException e10) {
            dc.e.d(f17007c, "registerPocketModeByProximityListener error: ", e10);
            return false;
        }
    }

    @Override // pg.h
    /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
    public void K(IBinder iBinder) {
        try {
            this.f17009a.releaseFlipWakeLock(iBinder);
            dc.e.f(f17007c, "releaseFlipWakeLock success");
        } catch (RemoteException e10) {
            dc.e.n(f17007c, "releaseFlipWakeLock: e = " + e10);
        }
    }

    @Override // pg.h
    public boolean o(final String str) {
        return ((Boolean) new zb.f().c(new zb.f.b() { // from class: vd.p
            @Override // zb.f.b
            public final Object run() {
                return this.f16970a.Q(str);
            }
        }, "power")).booleanValue();
    }

    @Override // pg.h
    public boolean p(final int i10, final String str) {
        return ((Boolean) new zb.f().c(new zb.f.b() { // from class: vd.x
            @Override // zb.f.b
            public final Object run() {
                return this.f17001a.R(i10, str);
            }
        }, "power")).booleanValue();
    }

    @Override // pg.h
    public boolean q() {
        try {
            return this.f17009a.isPowerSaveMode();
        } catch (RemoteException e10) {
            dc.e.n(f17007c, "isPowerSaveMode: e = " + e10);
            return false;
        }
    }

    @Override // pg.h
    public void r(IBinder iBinder, String str, String str2) {
        if (iBinder == null) {
            throw new IllegalArgumentException(va.i.f16785j);
        }
        if (str == null) {
            throw new IllegalArgumentException("The tag must not be null.");
        }
        try {
            this.f17009a.acquireFlipWakeLock(iBinder, str, str2);
            dc.e.f(f17007c, "acquireFlipWakeLock success");
        } catch (RemoteException e10) {
            dc.e.n(f17007c, "acquireFlipWakeLock: e = " + e10);
        }
    }

    @Override // pg.h
    public List<String> s() {
        List<String> list = (List) new zb.f().c(new zb.f.b() { // from class: vd.o
            @Override // zb.f.b
            public final Object run() {
                return this.f16967a.P();
            }
        }, "power");
        dc.e.f(f17007c, "getUnacquireableWakeLockApp mLists:" + list);
        return list;
    }

    @Override // pg.h
    public void t(final IBinder iBinder, String str, String str2, long j10) {
        r(iBinder, str, str2);
        if (j10 < 100) {
            j10 = 100;
        }
        f17008d.postDelayed(new Runnable() { // from class: vd.w
            @Override // java.lang.Runnable
            public final void run() {
                this.f16997a.K(iBinder);
            }
        }, j10);
    }

    @Override // pg.h
    public boolean u(String str) {
        boolean zUnRegisterPocketModeListener = false;
        try {
            ITranPowerManager iTranPowerManager = this.f17009a;
            if (iTranPowerManager == null) {
                return false;
            }
            zUnRegisterPocketModeListener = iTranPowerManager.unRegisterPocketModeListener(str);
            this.f17010b.remove(str);
            return zUnRegisterPocketModeListener;
        } catch (RemoteException e10) {
            dc.e.d(f17007c, "unRegisterPocketModeListener error: ", e10);
            return zUnRegisterPocketModeListener;
        }
    }

    @Override // pg.h
    public int v() {
        int iIntValue = ((Integer) new zb.f().c(new zb.f.b() { // from class: vd.l
            @Override // zb.f.b
            public final Object run() {
                return this.f16955a.N();
            }
        }, "power")).intValue();
        dc.e.f(f17007c, "getMinimumScreenBrightnessSetting result:" + iIntValue);
        return iIntValue;
    }

    @Override // pg.h
    public void w(boolean z10) {
        try {
            ITranPowerManager iTranPowerManager = this.f17009a;
            if (iTranPowerManager != null) {
                iTranPowerManager.notifyAodIsShow(z10);
            }
        } catch (RemoteException e10) {
            j7.b.a("notifyAodIsShow failed: ", e10, f17007c);
        }
    }
}
