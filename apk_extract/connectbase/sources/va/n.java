package va;

import android.os.RemoteException;
import vd.c0;

/* JADX INFO: loaded from: classes2.dex */
public class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f16800a = "n";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static c0 f16801b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static e8.p f16802c;

    @yb.a(level = 0)
    public static String a(String str) {
        try {
            return f(fc.b.a.f5989i).e(str, "");
        } catch (RemoteException e10) {
            j7.b.a("getMethod:", e10, f16800a);
            return "";
        }
    }

    @yb.a(level = 0)
    public static String b(String str, String str2) {
        try {
            return f(fc.b.a.f5989i).e(str, str2);
        } catch (RemoteException e10) {
            j7.b.a("getWithDefaultMethod:", e10, f16800a);
            return str2;
        }
    }

    @yb.a(level = 0)
    public static boolean c(String str, boolean z10) {
        try {
            return f(fc.b.a.f5989i).a(str, z10);
        } catch (RemoteException e10) {
            j7.b.a("getBooleanMethod:", e10, f16800a);
            return z10;
        }
    }

    @yb.a(level = 0)
    public static int d(String str, int i10) {
        try {
            return f(fc.b.a.f5989i).d(str, i10);
        } catch (RemoteException e10) {
            j7.b.a("getIntMethod:", e10, f16800a);
            return i10;
        }
    }

    @yb.a(level = 0)
    public static long e(String str, long j10) {
        try {
            return f(fc.b.a.f5989i).b(str, j10);
        } catch (RemoteException e10) {
            j7.b.a("getLongMethod:", e10, f16800a);
            return j10;
        }
    }

    public static pg.l f(String str) {
        if (fc.b.b(str)) {
            dc.e.f(f16800a, "TranThubSystemProperties");
            c0 c0Var = f16801b;
            if (c0Var != null) {
                return c0Var;
            }
            c0 c0Var2 = new c0();
            f16801b = c0Var2;
            return c0Var2;
        }
        dc.e.f(f16800a, "TranAospSystemProperties");
        e8.p pVar = f16802c;
        if (pVar != null) {
            return pVar;
        }
        e8.p pVar2 = new e8.p();
        f16802c = pVar2;
        return pVar2;
    }

    @yb.a(level = 1)
    public static void g(String str, String str2) {
        try {
            f(fc.b.a.f5989i).c(str, str2);
        } catch (RemoteException e10) {
            j7.b.a("setMethod:", e10, f16800a);
        }
    }
}
