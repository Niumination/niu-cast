package e8;

import android.content.Context;
import android.os.IBinder;
import android.os.PowerManager;
import android.os.RemoteException;
import com.transsion.hubsdk.os.ITranPocketModeCallback;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
public class j implements pg.h {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f4113d = "j";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static Class<?> f4114e = cc.a.a("android.os.ServiceManager");

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static Class<?> f4115f = cc.a.a("android.os.IPowerManager$Stub");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public PowerManager f4116a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Context f4117b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Map<String, a> f4118c = new ConcurrentHashMap();

    public class a extends ITranPocketModeCallback.Stub {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public va.i.a f4119a;

        public a(va.i.a aVar) {
            this.f4119a = aVar;
        }

        public void a(boolean z10) throws RemoteException {
            va.i.a aVar = this.f4119a;
            if (aVar != null) {
                aVar.a(z10);
            }
        }
    }

    public j() {
        if (this.f4116a == null) {
            Context contextA = bc.a.a();
            this.f4117b = contextA;
            this.f4116a = (PowerManager) contextA.getSystemService("power");
        }
    }

    public static /* synthetic */ a x(j jVar, va.i.a aVar, String str) {
        jVar.getClass();
        return jVar.new a(aVar);
    }

    public static /* synthetic */ a y(j jVar, va.i.a aVar, String str) {
        jVar.getClass();
        return jVar.new a(aVar);
    }

    public static Object z(String str) {
        Field fieldD;
        try {
            Class clsA = cc.a.a("android.os.PowerManager");
            if (clsA != null && (fieldD = cc.a.d(clsA, str)) != null) {
                return cc.a.f(fieldD, null);
            }
        } catch (Exception e10) {
            p6.b.a("getFeild error: ", e10, f4113d);
        }
        return null;
    }

    public final Object A() {
        Object objJ = cc.a.j(cc.a.g(f4114e, "getService", String.class), f4114e, "power");
        IBinder iBinder = objJ instanceof IBinder ? (IBinder) objJ : null;
        String str = f4113d;
        dc.e.a(str, "iBinder is ".concat(iBinder == null ? d6.a.E : "not null"));
        Object objJ2 = cc.a.j(cc.a.g(f4115f, "asInterface", IBinder.class), f4115f, iBinder);
        dc.e.a(str, "objIPowerManager is ".concat(objJ2 == null ? d6.a.E : "not null"));
        return objJ2;
    }

    public final Object B() {
        Method methodG;
        Class clsA = cc.a.a("com.transsion.hubsdk.TranServiceManager");
        if (clsA != null && (methodG = cc.a.g(clsA, "getServiceIBinder", String.class)) != null) {
            IBinder iBinder = (IBinder) cc.a.j(methodG, null, "power");
            Class clsA2 = cc.a.a("com.transsion.hubsdk.os.ITranPowerManager$Stub");
            if (iBinder != null && clsA2 != null) {
                return cc.a.j(cc.a.g(clsA2, "asInterface", IBinder.class), clsA2, iBinder);
            }
        }
        return null;
    }

    public final /* synthetic */ a C(va.i.a aVar, String str) {
        return new a(aVar);
    }

    public final /* synthetic */ a D(va.i.a aVar, String str) {
        return new a(aVar);
    }

    @Override // pg.h
    public List<String> a() {
        ArrayList arrayList = new ArrayList();
        Object objA = A();
        if (objA != null) {
            Object objJ = cc.a.j(cc.a.g(objA.getClass(), "getAcquireableWakeLockApp", new Class[0]), objA, new Object[0]);
            if (objJ instanceof List) {
                Iterator it = ((List) objJ).iterator();
                while (it.hasNext()) {
                    arrayList.add((String) String.class.cast(it.next()));
                }
            }
        }
        return arrayList;
    }

    @Override // pg.h
    public void b(boolean z10, String str, boolean z11) {
        Class<?> cls = this.f4116a.getClass();
        Class cls2 = Boolean.TYPE;
        cc.a.j(cc.a.g(cls, "shutdown", cls2, String.class, cls2), this.f4116a, Boolean.valueOf(z10), str, Boolean.valueOf(z11));
    }

    @Override // pg.h
    public boolean c(boolean z10) {
        return ((Boolean) cc.a.j(cc.a.g(this.f4116a.getClass(), "setPowerSaveModeEnabled", Boolean.TYPE), this.f4116a, Boolean.valueOf(z10))).booleanValue();
    }

    @Override // pg.h
    public int d() {
        Object objJ = cc.a.j(cc.a.g(this.f4116a.getClass(), "getMaximumScreenBrightnessSetting", new Class[0]), this.f4116a, new Object[0]);
        if (objJ instanceof Integer) {
            return ((Integer) objJ).intValue();
        }
        return 0;
    }

    @Override // pg.h
    public void e(String str, boolean z10) {
        Object objA = A();
        if (objA != null) {
            cc.a.j(cc.a.g(objA.getClass(), "setWakeLockAppMap", String.class, Boolean.TYPE), objA, str, Boolean.valueOf(z10));
        }
    }

    @Override // pg.h
    public void f(long j10) {
        cc.a.j(cc.a.g(this.f4116a.getClass(), "goToSleep", Long.TYPE), this.f4116a, Long.valueOf(j10));
    }

    @Override // pg.h
    public void g(boolean z10) {
        Object objA = A();
        if (objA != null) {
            cc.a.j(cc.a.g(objA.getClass(), "notifyChangeConnectState", Boolean.TYPE), objA, Boolean.valueOf(z10));
        }
    }

    @Override // pg.h
    public boolean h() {
        Object objA = A();
        if (objA == null) {
            return false;
        }
        Object objJ = cc.a.j(cc.a.g(objA.getClass(), "getScreenOnManagerEnable", new Class[0]), objA, new Object[0]);
        if (objJ instanceof Boolean) {
            return ((Boolean) objJ).booleanValue();
        }
        return false;
    }

    @Override // pg.h
    public float i(int i10) {
        return ((Float) cc.a.j(cc.a.g(this.f4116a.getClass(), "getBrightnessConstraint", Integer.TYPE), this.f4116a, Integer.valueOf(i10))).floatValue();
    }

    @Override // pg.h
    public void j(String str) {
        cc.a.j(cc.a.g(this.f4116a.getClass(), "reboot", String.class), this.f4116a, str);
    }

    @Override // pg.h
    public boolean k(final va.i.a aVar, String str) throws ac.a {
        Method methodG;
        try {
            Class.forName("com.transsion.hubsdk.os.ITranPocketModeCallback$Stub");
            a aVarComputeIfAbsent = this.f4118c.computeIfAbsent(str, new Function() { // from class: e8.i
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return j.y(this.f4111a, aVar, (String) obj);
                }
            });
            try {
                Object objB = B();
                if (objB == null || (methodG = cc.a.g(objB.getClass(), "registerPocketModeListener", ITranPocketModeCallback.class, String.class)) == null) {
                    return false;
                }
                return Boolean.TRUE.equals(cc.a.j(methodG, objB, aVarComputeIfAbsent, str));
            } catch (Exception e10) {
                dc.e.d(f4113d, "registerPocketModeListener error: ", e10);
                return false;
            }
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    @Override // pg.h
    public void l(boolean z10) {
        Object objA = A();
        if (objA != null) {
            cc.a.j(cc.a.g(objA.getClass(), "setScreenOnManagerEnable", Boolean.TYPE), objA, Boolean.valueOf(z10));
        }
    }

    @Override // pg.h
    public boolean m(final va.i.a aVar, String str) throws ac.a {
        Method methodG;
        try {
            Class.forName("com.transsion.hubsdk.os.ITranPocketModeCallback$Stub");
            a aVarComputeIfAbsent = this.f4118c.computeIfAbsent(str, new Function() { // from class: e8.h
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return j.x(this.f4109a, aVar, (String) obj);
                }
            });
            try {
                Object objB = B();
                if (objB == null || (methodG = cc.a.g(objB.getClass(), "registerPocketModeByProximityListener", ITranPocketModeCallback.class, String.class)) == null) {
                    return false;
                }
                return Boolean.TRUE.equals(cc.a.j(methodG, objB, aVarComputeIfAbsent, str));
            } catch (Exception e10) {
                dc.e.d(f4113d, "registerPocketModeListener error: ", e10);
                return false;
            }
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    @Override // pg.h
    /* JADX INFO: renamed from: n */
    public void K(IBinder iBinder) throws ac.a {
        throw new ac.a("can not find method releaseFlipWakeLock");
    }

    @Override // pg.h
    public boolean o(String str) {
        PowerManager powerManager = this.f4116a;
        if (powerManager == null) {
            return false;
        }
        return Boolean.TRUE.equals(cc.a.j(cc.a.g(powerManager.getClass(), "isTranPocketMode", String.class), this.f4116a, str));
    }

    @Override // pg.h
    public boolean p(int i10, String str) {
        PowerManager powerManager = this.f4116a;
        if (powerManager == null) {
            return false;
        }
        return Boolean.TRUE.equals(cc.a.j(cc.a.g(powerManager.getClass(), "isTranPocketModeByGivenSensor", Integer.TYPE, String.class), this.f4116a, Integer.valueOf(i10), str));
    }

    @Override // pg.h
    public boolean q() {
        return ((Boolean) cc.a.j(cc.a.g(this.f4116a.getClass(), "isPowerSaveMode", new Class[0]), this.f4116a, new Object[0])).booleanValue();
    }

    @Override // pg.h
    public void r(IBinder iBinder, String str, String str2) throws ac.a {
        throw new ac.a("can not find method acquireFlipWakeLock");
    }

    @Override // pg.h
    public List<String> s() {
        ArrayList arrayList = new ArrayList();
        Object objA = A();
        if (objA != null) {
            Object objJ = cc.a.j(cc.a.g(objA.getClass(), "getUnacquireableWakeLockApp", new Class[0]), objA, new Object[0]);
            if (objJ instanceof List) {
                Iterator it = ((List) objJ).iterator();
                while (it.hasNext()) {
                    arrayList.add((String) String.class.cast(it.next()));
                }
            }
        }
        return arrayList;
    }

    @Override // pg.h
    public void t(IBinder iBinder, String str, String str2, long j10) throws ac.a {
        throw new ac.a("can not find method acquireFlipWakeLock1");
    }

    @Override // pg.h
    public boolean u(String str) throws ac.a {
        Method methodG;
        boolean zEquals = false;
        try {
            Class.forName("com.transsion.hubsdk.os.ITranPocketModeCallback$Stub");
            try {
                Object objB = B();
                if (objB != null && (methodG = cc.a.g(objB.getClass(), "unRegisterPocketModeListener", String.class)) != null) {
                    zEquals = Boolean.TRUE.equals(cc.a.j(methodG, objB, str));
                }
                this.f4118c.remove(str);
            } catch (Exception e10) {
                dc.e.d(f4113d, "unRegisterPocketModeListener error: ", e10);
            }
        } catch (ClassNotFoundException unused) {
        }
        return zEquals;
    }

    @Override // pg.h
    public int v() {
        Object objJ = cc.a.j(cc.a.g(this.f4116a.getClass(), "getMinimumScreenBrightnessSetting", new Class[0]), this.f4116a, new Object[0]);
        if (objJ instanceof Integer) {
            return ((Integer) objJ).intValue();
        }
        return 0;
    }

    @Override // pg.h
    public void w(boolean z10) throws ac.a {
        throw new ac.a("Non-native interface, please implement it yourself");
    }
}
