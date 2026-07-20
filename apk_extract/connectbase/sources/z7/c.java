package z7;

import android.net.LinkAddress;
import android.os.IBinder;
import dc.e;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes2.dex */
public class c implements kg.b {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f21861c = "c";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final String f21864f = "network_management";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Method f21866a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Method f21867b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static Class<?> f21862d = cc.a.a("android.os.INetworkManagementService$Stub");

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static Class<?> f21863e = cc.a.a("android.os.ServiceManager");

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static Class<?> f21865g = cc.a.a("android.net.InterfaceConfiguration");

    public c() {
        this.f21866a = null;
        this.f21867b = null;
        this.f21866a = cc.a.g(f21863e, "getService", String.class);
        this.f21867b = cc.a.g(f21862d, "asInterface", IBinder.class);
    }

    @Override // kg.b
    public qa.b a(String str) {
        try {
            Object objInvoke = this.f21867b.invoke(null, this.f21866a.invoke(null, f21864f));
            Method methodG = cc.a.g(objInvoke.getClass(), "getInterfaceConfig", String.class);
            methodG.setAccessible(true);
            Object objInvoke2 = methodG.invoke(objInvoke, str);
            Method methodG2 = cc.a.g(f21865g, "getLinkAddress", new Class[0]);
            methodG2.setAccessible(true);
            Object objInvoke3 = methodG2.invoke(objInvoke2, null);
            return new qa.b((objInvoke3 == null || !(objInvoke3 instanceof LinkAddress)) ? null : (LinkAddress) objInvoke3);
        } catch (IllegalAccessException e10) {
            e.c(f21861c, "getInterfaceConfig fail: " + e10);
            return null;
        } catch (InvocationTargetException e11) {
            e.c(f21861c, "getInterfaceConfig fail: " + e11);
            return null;
        }
    }

    @Override // kg.b
    public boolean b() {
        try {
            Object objInvoke = this.f21867b.invoke(null, this.f21866a.invoke(null, f21864f));
            Method methodG = cc.a.g(objInvoke.getClass(), "isTetheringStarted", new Class[0]);
            methodG.setAccessible(true);
            Object objInvoke2 = methodG.invoke(objInvoke, null);
            if (objInvoke2 == null || !(objInvoke2 instanceof Boolean)) {
                return false;
            }
            return ((Boolean) objInvoke2).booleanValue();
        } catch (IllegalAccessException e10) {
            e.c(f21861c, "isTetheringStarted fail: " + e10);
            return false;
        } catch (InvocationTargetException e11) {
            e.c(f21861c, "isTetheringStarted fail: " + e11);
            return false;
        }
    }

    @Override // kg.b
    public String[] c() {
        try {
            Object objInvoke = this.f21867b.invoke(null, this.f21866a.invoke(null, f21864f));
            Method methodG = cc.a.g(objInvoke.getClass(), "listInterfaces", new Class[0]);
            methodG.setAccessible(true);
            Object objInvoke2 = methodG.invoke(objInvoke, null);
            if (objInvoke2 == null || !(objInvoke2 instanceof String[])) {
                return null;
            }
            return (String[]) objInvoke2;
        } catch (IllegalAccessException e10) {
            e.c(f21861c, "listInterfaces fail: " + e10);
            return new String[0];
        } catch (InvocationTargetException e11) {
            e.c(f21861c, "listInterfaces fail: " + e11);
            return new String[0];
        }
    }

    @Override // kg.b
    public boolean d(String str) {
        try {
            Object objInvoke = this.f21867b.invoke(null, this.f21866a.invoke(null, f21864f));
            Method methodG = cc.a.g(objInvoke.getClass(), "getInterfaceConfig", String.class);
            methodG.setAccessible(true);
            Object objInvoke2 = methodG.invoke(objInvoke, str);
            Method methodG2 = cc.a.g(f21865g, "isActive", new Class[0]);
            methodG2.setAccessible(true);
            Object objInvoke3 = methodG2.invoke(objInvoke2, null);
            if (objInvoke3 == null || !(objInvoke3 instanceof Boolean)) {
                return false;
            }
            return ((Boolean) objInvoke3).booleanValue();
        } catch (IllegalAccessException e10) {
            e.c(f21861c, "isActive fail: " + e10);
            return false;
        } catch (InvocationTargetException e11) {
            e.c(f21861c, "isActive fail: " + e11);
            return false;
        }
    }

    @Override // kg.b
    public void e(String str, String str2) {
        if (fc.a.g()) {
            return;
        }
        try {
            Object objInvoke = this.f21867b.invoke(null, this.f21866a.invoke(null, f21864f));
            Method methodG = cc.a.g(objInvoke.getClass(), "stopInterfaceForwarding", String.class, String.class);
            methodG.setAccessible(true);
            methodG.invoke(objInvoke, str, str2);
        } catch (IllegalAccessException e10) {
            e.c(f21861c, "stopInterfaceForwarding fail: " + e10);
        } catch (InvocationTargetException e11) {
            e.c(f21861c, "stopInterfaceForwarding fail: " + e11);
        }
    }

    @Override // kg.b
    public boolean f() {
        try {
            Object objInvoke = this.f21867b.invoke(null, this.f21866a.invoke(null, f21864f));
            Method methodG = cc.a.g(objInvoke.getClass(), "isBandwidthControlEnabled", new Class[0]);
            methodG.setAccessible(true);
            Object objInvoke2 = methodG.invoke(objInvoke, null);
            if (objInvoke2 == null || !(objInvoke2 instanceof Boolean)) {
                return false;
            }
            return ((Boolean) objInvoke2).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException e10) {
            e.c(f21861c, "isBandwidthControlEnabled fail: " + e10);
            return false;
        }
    }

    @Override // kg.b
    public void g(String str, String str2) {
        if (fc.a.g()) {
            return;
        }
        try {
            Object objInvoke = this.f21867b.invoke(null, this.f21866a.invoke(null, f21864f));
            Method methodG = cc.a.g(objInvoke.getClass(), "startInterfaceForwarding", String.class, String.class);
            methodG.setAccessible(true);
            methodG.invoke(objInvoke, str, str2);
        } catch (IllegalAccessException e10) {
            e.c(f21861c, "startInterfaceForwarding fail: " + e10);
        } catch (InvocationTargetException e11) {
            e.c(f21861c, "startInterfaceForwarding fail: " + e11);
        }
    }

    @Override // kg.b
    public String[] h() {
        try {
            Object objInvoke = this.f21867b.invoke(null, this.f21866a.invoke(null, f21864f));
            Method methodG = cc.a.g(objInvoke.getClass(), "listTetheredInterfaces", new Class[0]);
            methodG.setAccessible(true);
            Object objInvoke2 = methodG.invoke(objInvoke, null);
            if (objInvoke2 == null || !(objInvoke2 instanceof String[])) {
                return null;
            }
            return (String[]) objInvoke2;
        } catch (IllegalAccessException e10) {
            e.c(f21861c, "listTetheredInterfaces fail: " + e10);
            return new String[0];
        } catch (InvocationTargetException e11) {
            e.c(f21861c, "listTetheredInterfaces fail: " + e11);
            return new String[0];
        }
    }
}
