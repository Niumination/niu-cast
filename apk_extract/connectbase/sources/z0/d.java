package z0;

import n0.m;

/* JADX INFO: loaded from: classes.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static m f21749a = new c();

    public static void a(String str) {
        f21749a.debug(str);
    }

    public static void b(String str, Throwable th2) {
        f21749a.debug(str, th2);
    }

    public static void c(String str, Throwable th2) {
        f21749a.error(str, th2);
    }

    public static void d(m mVar) {
        f21749a = mVar;
    }

    public static void e(String str) {
        f21749a.a(str);
    }

    public static void f(String str, Throwable th2) {
        f21749a.b(str, th2);
    }
}
