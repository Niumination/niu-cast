package l6;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile h f9710a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Context f9711b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static String f9712c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static boolean f9713d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static String f9714e;

    public interface a {
        void a(String str);

        void b(String str);
    }

    public interface b {
        void a(Map<String, String> map);

        void b(String str);
    }

    /* JADX INFO: renamed from: l6.c$c, reason: collision with other inner class name */
    public interface InterfaceC0255c {
        void a(Map<String, String> map);

        void b();
    }

    public interface d {
        void a(String str);

        void b();
    }

    public static Context a() {
        return f9711b;
    }

    public static String b() {
        return l6.b.h().f();
    }

    public static String c() {
        return f9714e;
    }

    public static String d(String str, boolean z10) {
        if (f9710a == null) {
            g.f9730a.m("GslbSdk is not initialized");
            return str;
        }
        if (TextUtils.isEmpty(str)) {
            g.f9730a.m("url is empty");
            return str;
        }
        String strE = g.e(str);
        String strG = l6.b.h().g(strE);
        if (strG != null && !strG.equals(l6.b.f9697n)) {
            return str.replace(strE, strG);
        }
        if (strG == null) {
            g.f9730a.M(strE + " is not in init list ");
        }
        if (z10) {
            return str;
        }
        return null;
    }

    public static void e(String str, a aVar) {
        if (f9710a == null) {
            g.f9730a.m("GslbSdk is not initialized");
            if (aVar != null) {
                aVar.b("GslbSdk is not initialized");
                return;
            }
            return;
        }
        if (TextUtils.isEmpty(str)) {
            g.f9730a.m("url is empty");
            if (aVar != null) {
                aVar.b("input url is empty");
                return;
            }
            return;
        }
        String strE = g.e(str);
        String strG = l6.b.h().g(strE);
        if (strG != null) {
            if (strG.equals(l6.b.f9697n)) {
                f9710a.a(new l6.d(true, str, aVar));
                return;
            } else {
                if (aVar != null) {
                    aVar.a(str.replace(strE, strG));
                    return;
                }
                return;
            }
        }
        g.f9730a.M(strE + " this domain is not in init list ");
        if (aVar != null) {
            aVar.b("this domain is not in init list");
        }
    }

    public static void f(String str, d dVar) {
        if (f9710a == null) {
            g.f9730a.m("GslbSdk is not initialized");
            if (dVar != null) {
                dVar.b();
                return;
            }
            return;
        }
        if (TextUtils.isEmpty(str)) {
            g.f9730a.m("url is empty");
            if (dVar != null) {
                dVar.b();
                return;
            }
            return;
        }
        String strE = g.e(str);
        String strG = l6.b.h().g(strE);
        if (strG != null) {
            if (strG.equals(l6.b.f9697n)) {
                f9710a.a(new l6.d(str, dVar));
                return;
            } else {
                if (dVar != null) {
                    dVar.a(str.replace(strE, strG));
                    return;
                }
                return;
            }
        }
        g.f9730a.M(strE + " this domain is not in init list ");
        if (dVar != null) {
            dVar.b();
        }
    }

    public static String g() {
        return f9712c;
    }

    public static h h() {
        return f9710a;
    }

    public static void i(Context context, String str, String str2, String[] strArr, b bVar) {
        f9712c = str;
        f9714e = str2;
        k(context, strArr, bVar);
    }

    public static void j(Context context, String str, String str2, String[] strArr, InterfaceC0255c interfaceC0255c) {
        f9712c = str;
        f9714e = str2;
        l(context, strArr, interfaceC0255c);
    }

    public static void k(Context context, String[] strArr, b bVar) {
        f9711b = context.getApplicationContext();
        if (f9710a == null) {
            f9710a = h.d();
        }
        if (strArr == null || strArr.length <= 0) {
            Log.e("GslbSdk", "Init with invalid domains");
        } else {
            f9710a.a(new l6.d(true, strArr, bVar));
        }
    }

    public static void l(Context context, String[] strArr, InterfaceC0255c interfaceC0255c) {
        f9711b = context.getApplicationContext();
        if (f9710a == null) {
            f9710a = h.d();
        }
        if (strArr == null || strArr.length <= 0) {
            Log.e("GslbSdk", "Init with invalid domains");
        } else {
            f9710a.a(new l6.d(strArr, interfaceC0255c));
        }
    }

    public static boolean m(String str) {
        if (f9710a == null) {
            g.f9730a.m("GslbSdk is not initialized");
            return false;
        }
        if (str != null) {
            return !TextUtils.isEmpty(d(str, false));
        }
        return false;
    }

    public static boolean n() {
        return f9713d;
    }

    public static void o() {
        if (f9711b != null) {
            l6.b.h().o();
        }
    }

    public static boolean p(String str) {
        if (f9711b != null) {
            return l6.b.h().p(str);
        }
        return false;
    }

    public static void q(boolean z10) {
        g.f9730a.f3600m.w(z10);
        f9713d = z10;
    }
}
