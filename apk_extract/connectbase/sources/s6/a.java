package s6;

import android.os.IBinder;
import android.os.RemoteException;
import dc.e;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class a implements ef.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f15011b = "TranAospAppmCallbackWrapper";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f15012c = "tran_appm";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final List<b> f15013d = new ArrayList();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static Class<?> f15014e = cc.a.a("android.os.ServiceManager");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public k3.b f15015a;

    /* JADX INFO: renamed from: s6.a$a, reason: collision with other inner class name */
    public class BinderC0369a extends k3.a.b {
        public BinderC0369a() {
        }

        @Override // k3.a
        public void i(String str, String str2) {
            for (b bVar : a.f15013d) {
                if (bVar.f15018b.equals(this)) {
                    try {
                        bVar.f15017a.i(str, str2);
                        return;
                    } catch (RemoteException e10) {
                        e.c(a.f15011b, e10.toString());
                        return;
                    }
                }
            }
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public k9.a f15017a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public k3.a f15018b;

        public b() {
        }

        public k3.a a() {
            return this.f15018b;
        }

        public k9.a b() {
            return this.f15017a;
        }

        public void c(k3.a aVar) {
            this.f15018b = aVar;
        }

        public void d(k9.a aVar) {
            this.f15017a = aVar;
        }

        public b(BinderC0369a binderC0369a) {
        }
    }

    public a() {
        try {
            IBinder iBinder = (IBinder) cc.a.j(cc.a.g(f15014e, "getService", String.class), f15014e.newInstance(), f15012c);
            if (iBinder == null) {
                e.n(f15011b, "get TranAppmService failed !!");
                return;
            }
            k3.b bVarO = k3.b.AbstractBinderC0236b.O(iBinder);
            this.f15015a = bVarO;
            if (bVarO == null) {
                e.n(f15011b, "can not get TranAppmService !!");
            }
        } catch (Exception e10) {
            p6.b.a("get TranAppmService fail: ", e10, f15011b);
        }
    }

    @Override // ef.a
    public void b(String str, String str2) {
        k3.b bVar = this.f15015a;
        if (bVar == null) {
            e.n(f15011b, "sendEvent failed(get AppmService failed)!!");
            return;
        }
        try {
            bVar.b(str, str2);
        } catch (RemoteException e10) {
            e.c(f15011b, e10.toString());
        }
    }

    public final Object c() {
        Method methodG;
        Class clsA = cc.a.a("com.transsion.hubsdk.TranServiceManager");
        if (clsA != null && (methodG = cc.a.g(clsA, "getServiceIBinder", String.class)) != null) {
            IBinder iBinder = (IBinder) cc.a.j(methodG, null, "appm_service");
            Class clsA2 = cc.a.a("com.transsion.hubsdk.appm.ITranAppmManager$Stub");
            if (iBinder != null && clsA2 != null) {
                return cc.a.j(cc.a.g(clsA2, "asInterface", IBinder.class), clsA2, iBinder);
            }
        }
        return null;
    }

    @Override // ef.a
    public void e(String str, String str2) {
        k3.b bVar = this.f15015a;
        if (bVar == null) {
            e.c(f15011b, "notifyClient failed(get AppmService failed)!!");
            return;
        }
        try {
            bVar.e(str, str2);
        } catch (RemoteException e10) {
            e.c(f15011b, e10.toString());
        }
    }

    @Override // ef.a
    public String g(String str) {
        k3.b bVar = this.f15015a;
        if (bVar == null) {
            e.c(f15011b, "getPolicyVersion failed(get AppmService failed)!!");
            return "unkown";
        }
        try {
            return bVar.g(str);
        } catch (RemoteException e10) {
            e.c(f15011b, e10.toString());
            return "unkown";
        }
    }

    @Override // ef.a
    public void h(k9.a aVar) {
        if (this.f15015a == null) {
            e.n(f15011b, "unregisterAppmCallback failed, can not get TranAppmService !!");
            return;
        }
        for (b bVar : f15013d) {
            if (bVar.f15017a.equals(aVar)) {
                try {
                    this.f15015a.B(bVar.f15018b);
                } catch (RemoteException e10) {
                    e.c(f15011b, e10.toString());
                }
                f15013d.remove(bVar);
                return;
            }
        }
    }

    @Override // ef.a
    public boolean i(int i10, boolean z10, String str) {
        Method methodG;
        Object objC = c();
        if (objC == null || (methodG = cc.a.g(objC.getClass(), "setFpsMonitorSwitch", Integer.TYPE, Boolean.TYPE, String.class)) == null) {
            return false;
        }
        return Boolean.TRUE.equals(cc.a.j(methodG, objC, Integer.valueOf(i10), Boolean.valueOf(z10), str));
    }

    @Override // ef.a
    public void j(k9.a aVar) {
        if (this.f15015a == null) {
            e.c(f15011b, "registerAppmCallback failed(get AppmService failed)!!");
            return;
        }
        b bVar = new b();
        bVar.f15017a = aVar;
        BinderC0369a binderC0369a = new BinderC0369a();
        bVar.f15018b = binderC0369a;
        f15013d.add(bVar);
        try {
            this.f15015a.M(binderC0369a);
        } catch (RemoteException e10) {
            e.c(f15011b, e10.toString());
        }
    }

    @Override // ef.a
    public float k(int i10) {
        Method methodG;
        Object objC = c();
        if (objC == null || (methodG = cc.a.g(objC.getClass(), "getRecentFpsAvg", Integer.TYPE)) == null) {
            return -1.0f;
        }
        return ((Float) cc.a.j(methodG, objC, Integer.valueOf(i10))).floatValue();
    }
}
