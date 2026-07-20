package e8;

import android.os.RemoteException;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes2.dex */
public class p implements pg.l {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final String f4129f = "p";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static Class<?> f4130g = cc.a.a("android.os.SystemProperties");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Method f4131a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Method f4132b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Method f4133c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Method f4134d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Method f4135e = null;

    @Override // pg.l
    public boolean a(String str, boolean z10) throws RemoteException {
        if (this.f4134d == null) {
            this.f4134d = cc.a.g(f4130g, "getBoolean", String.class, Boolean.TYPE);
        }
        try {
            this.f4134d.setAccessible(true);
            Object objInvoke = this.f4134d.invoke(f4130g, str, Boolean.valueOf(z10));
            return (objInvoke == null || !(objInvoke instanceof Boolean)) ? z10 : ((Boolean) objInvoke).booleanValue();
        } catch (Throwable unused) {
            return z10;
        }
    }

    @Override // pg.l
    public long b(String str, long j10) throws RemoteException {
        if (this.f4133c == null) {
            this.f4133c = cc.a.g(f4130g, "getLong", String.class, Long.TYPE);
        }
        try {
            this.f4133c.setAccessible(true);
            Object objInvoke = this.f4133c.invoke(f4130g, str, Long.valueOf(j10));
            return (objInvoke == null || !(objInvoke instanceof Long)) ? j10 : ((Long) objInvoke).longValue();
        } catch (Throwable unused) {
            return j10;
        }
    }

    @Override // pg.l
    public void c(String str, String str2) throws RemoteException {
        if (this.f4135e == null) {
            this.f4135e = cc.a.g(f4130g, "set", String.class, String.class);
        }
        try {
            this.f4135e.setAccessible(true);
            this.f4135e.invoke(f4130g, str, str2);
        } catch (Throwable th2) {
            m7.a.a("set fail ", th2, f4129f);
        }
    }

    @Override // pg.l
    public int d(String str, int i10) throws RemoteException {
        if (this.f4132b == null) {
            this.f4132b = cc.a.g(f4130g, "getInt", String.class, Integer.TYPE);
        }
        try {
            this.f4132b.setAccessible(true);
            Object objInvoke = this.f4132b.invoke(f4130g, str, Integer.valueOf(i10));
            return (objInvoke == null || !(objInvoke instanceof Integer)) ? i10 : ((Integer) objInvoke).intValue();
        } catch (Throwable unused) {
            return i10;
        }
    }

    @Override // pg.l
    public String e(String str, String str2) throws RemoteException {
        if (this.f4131a == null) {
            this.f4131a = cc.a.g(f4130g, "get", String.class, String.class);
        }
        try {
            this.f4131a.setAccessible(true);
            Object objInvoke = this.f4131a.invoke(f4130g, str, str2);
            return (objInvoke == null || !(objInvoke instanceof String)) ? str2 : (String) objInvoke;
        } catch (Throwable unused) {
            return str2;
        }
    }
}
