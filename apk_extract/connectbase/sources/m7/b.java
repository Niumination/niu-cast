package m7;

import android.app.AppOpsManager;
import android.os.Binder;
import android.os.IBinder;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class b implements xf.a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f10571c = "b";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static Class<?> f10572d = cc.a.a("android.app.AppOpsManager$PackageOps");

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static Class<?> f10573e = cc.a.a("android.os.ServiceManager");

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static Class<?> f10574f = cc.a.a("com.android.internal.app.IAppOpsService$Stub");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public AppOpsManager f10575a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Method f10576b = null;

    public b() {
        if (this.f10575a == null) {
            this.f10575a = (AppOpsManager) bc.a.a().getSystemService("appops");
        }
    }

    @Override // xf.a
    public List<da.h> a(da.i iVar) {
        return iVar.a();
    }

    @Override // xf.a
    public void b(int[] iArr, c.a aVar) {
        Method methodG = cc.a.g(f10573e, "getServiceOrThrow", String.class);
        Object binder = new Binder();
        Object objJ = cc.a.j(methodG, f10573e, "appops");
        if (objJ instanceof IBinder) {
            binder = (IBinder) objJ;
        }
        String str = f10571c;
        dc.e.a(str, "startWatchingActive iBinder :" + binder);
        Object objJ2 = cc.a.j(cc.a.g(f10574f, "asInterface", IBinder.class), f10574f, binder);
        dc.e.a(str, "startWatchingActive object :" + objJ2);
        if (objJ2 != null) {
            cc.a.j(cc.a.g(objJ2.getClass(), "startWatchingActive", int[].class, cc.a.a("com.android.internal.app.IAppOpsActiveCallback")), objJ2, iArr, new c.b(aVar));
        }
    }

    @Override // xf.a
    public void c(int i10, int i11, String str, int i12) {
        Class<?> cls = this.f10575a.getClass();
        Class cls2 = Integer.TYPE;
        cc.a.j(cc.a.g(cls, "setMode", cls2, cls2, String.class, cls2), this.f10575a, Integer.valueOf(i10), Integer.valueOf(i11), str, Integer.valueOf(i12));
    }

    @Override // xf.a
    public List<da.i> d(int i10, String str, int[] iArr) {
        this.f10576b = cc.a.g(this.f10575a.getClass(), "getOpsForPackage", Integer.TYPE, String.class, int[].class);
        ArrayList arrayList = new ArrayList();
        try {
            boolean z10 = true;
            this.f10576b.setAccessible(true);
            List list = (List) j(this.f10576b.invoke(this.f10575a, Integer.valueOf(i10), str, iArr));
            Field fieldD = cc.a.d(f10572d, "mPackageName");
            Field fieldD2 = cc.a.d(f10572d, "mUid");
            Method methodG = cc.a.g(f10572d, "getOps", new Class[0]);
            Object[] objArr = null;
            da.i iVar = null;
            for (Object obj : list) {
                if (f10572d.isInstance(obj)) {
                    dc.e.f("TranAospAppOpsService", "tranPackageOps object :" + obj);
                }
                fieldD.setAccessible(z10);
                String str2 = (String) k(fieldD.get(obj));
                fieldD2.setAccessible(z10);
                int iIntValue = ((Integer) i(fieldD2.get(obj))).intValue();
                ArrayList arrayList2 = new ArrayList();
                methodG.setAccessible(z10);
                List list2 = (List) methodG.invoke(obj, objArr);
                Method methodG2 = cc.a.g(cc.a.a("android.app.AppOpsManager$OpEntry"), "getMode", new Class[0]);
                methodG2.setAccessible(z10);
                Iterator it = list2.iterator();
                while (it.hasNext()) {
                    arrayList2.add(new da.h(((Integer) methodG2.invoke(it.next(), null)).intValue()));
                }
                iVar = new da.i(str2, iIntValue, arrayList2);
                objArr = null;
                z10 = true;
            }
            arrayList.add(iVar);
        } catch (Throwable th2) {
            a.a("getOpsForPackage: ", th2, "TranAospAppOpsService");
        }
        return arrayList;
    }

    @Override // xf.a
    public int e(da.h hVar) {
        return 0;
    }

    @Override // xf.a
    public int f(int i10, int i11, String str) {
        Class<?> cls = this.f10575a.getClass();
        Class cls2 = Integer.TYPE;
        return ((Integer) cc.a.j(cc.a.g(cls, "checkOp", cls2, cls2, String.class), this.f10575a, Integer.valueOf(i10), Integer.valueOf(i11), str)).intValue();
    }

    @Override // xf.a
    public void g(int i10, int i11, String str, int i12) {
        dc.e.c(f10571c, "setPackageMode is not supported in aosp version.");
    }

    @Override // xf.a
    public int h(int i10, int i11, String str) {
        dc.e.c(f10571c, "getPackageMode is not supported in aosp version.");
        return -1;
    }

    public final Object i(Object obj) {
        if (obj == null || !(obj instanceof Integer)) {
            return null;
        }
        return obj;
    }

    public final Object j(Object obj) {
        if (obj == null || !(obj instanceof List)) {
            return null;
        }
        return obj;
    }

    public final Object k(Object obj) {
        if (obj == null || !(obj instanceof String)) {
            return null;
        }
        return obj;
    }
}
