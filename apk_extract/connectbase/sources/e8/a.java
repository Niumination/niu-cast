package e8;

import android.os.IBinder;

/* JADX INFO: loaded from: classes2.dex */
public class a implements pg.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f4096a = "a";

    @Override // pg.a
    public long a() {
        Class clsA = cc.a.a("android.os.ServiceManager");
        IBinder iBinder = (IBinder) cc.a.j(cc.a.g(clsA, "getService", String.class), clsA, "batterystats");
        String str = f4096a;
        dc.e.a(str, "binder is ".concat(iBinder == null ? d6.a.E : "not null"));
        Object objJ = cc.a.j(cc.a.g(cc.a.a("com.android.internal.app.IBatteryStats$Stub"), "asInterface", IBinder.class), null, iBinder);
        if (objJ == null) {
            return 0L;
        }
        long jLongValue = ((Long) cc.a.j(cc.a.g(objJ.getClass(), "computeBatteryTimeRemaining", new Class[0]), objJ, new Object[0])).longValue();
        dc.e.a(str, objJ.getClass().getName() + " data: " + jLongValue);
        return jLongValue;
    }
}
