package y3;

import android.util.Log;

/* JADX INFO: loaded from: classes2.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d6.b f20688a = new d6.b.C0083b().t("Athena").v(true).n(false).m();

    public static void a(Exception exc) {
        d(Log.getStackTraceString(exc));
    }

    public static void b(String str) {
        String str2 = "%s";
        if (str != null && str.length() != 0) {
            str2 = String.format("%s", str);
        }
        d6.b bVar = f20688a;
        bVar.f3601n = 1;
        bVar.k(str2);
    }

    public static void c(String str, Object... objArr) {
        if (objArr.length != 0) {
            str = String.format(str, objArr);
        }
        d6.b bVar = f20688a;
        bVar.f3601n = 1;
        bVar.k(str);
    }

    public static void d(String str) {
        String str2 = "%s";
        if (str != null && str.length() != 0) {
            str2 = String.format("%s", str);
        }
        d6.b bVar = f20688a;
        bVar.f3601n = 1;
        bVar.m(str2);
    }

    public static void e(String str, Object... objArr) {
        if (objArr.length != 0) {
            str = String.format(str, objArr);
        }
        d6.b bVar = f20688a;
        bVar.f3601n = 1;
        bVar.m(str);
    }

    public static void f(String str) {
        String str2 = "%s";
        if (str != null && str.length() != 0) {
            str2 = String.format("%s", str);
        }
        d6.b bVar = f20688a;
        bVar.f3601n = 1;
        bVar.v(str2);
    }

    public static void g(String str, Object... objArr) {
        if (objArr.length != 0) {
            str = String.format(str, objArr);
        }
        d6.b bVar = f20688a;
        bVar.f3601n = 1;
        bVar.v(str);
    }
}
