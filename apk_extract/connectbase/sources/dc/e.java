package dc;

import android.os.Build;
import android.util.Log;

/* JADX INFO: loaded from: classes2.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static dc.a f3693a = new a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f3694b = !"user".equals(Build.TYPE);

    public static class a implements dc.a {
        @Override // dc.a
        public int a(String str, String str2) {
            return Log.e(str, str2);
        }

        @Override // dc.a
        public int b(String str, String str2) {
            return Log.d(str, str2);
        }

        @Override // dc.a
        public int c(String str, String str2, Throwable th2) {
            return Log.e(str, str2, th2);
        }

        @Override // dc.a
        public int d(String str, String str2) {
            return Log.i(str, str2);
        }

        @Override // dc.a
        public int e(String str, String str2) {
            return Log.w(str, str2);
        }

        @Override // dc.a
        public void f(Throwable th2) {
            th2.printStackTrace();
        }

        @Override // dc.a
        public int g(String str, String str2) {
            return Log.v(str, str2);
        }

        @Override // dc.a
        public int h() {
            return 0;
        }

        @Override // dc.a
        public boolean i(String str, int i10) {
            return Log.isLoggable(str, i10);
        }

        @Override // dc.a
        public int j(String str, String str2, Throwable th2) {
            return Log.d(str, str2, th2);
        }

        @Override // dc.a
        public int k(String str, String str2, Throwable th2) {
            return Log.w(str, str2, th2);
        }

        @Override // dc.a
        public int l(String str, String str2, Throwable th2) {
            return Log.v(str, str2, th2);
        }

        @Override // dc.a
        public int m(int i10) {
            return 0;
        }

        @Override // dc.a
        public int n(String str, String str2, Throwable th2) {
            return Log.i(str, str2, th2);
        }
    }

    public static int a(String str, String str2) {
        if (f3694b) {
            return f3693a.b(str, str2);
        }
        return 0;
    }

    public static int b(String str, String str2, Throwable th2) {
        if (f3694b) {
            return f3693a.j(str, str2, th2);
        }
        return 0;
    }

    public static int c(String str, String str2) {
        return f3693a.a(str, str2);
    }

    public static int d(String str, String str2, Throwable th2) {
        return f3693a.c(str, str2, th2);
    }

    public static int e() {
        return f3693a.h();
    }

    public static int f(String str, String str2) {
        if (f3694b) {
            return f3693a.d(str, str2);
        }
        return 0;
    }

    public static int g(String str, String str2, Throwable th2) {
        if (f3694b) {
            return f3693a.n(str, str2, th2);
        }
        return 0;
    }

    public static boolean h(String str, int i10) {
        return f3693a.i(str, i10);
    }

    public static void i(Throwable th2) {
        f3693a.f(th2);
    }

    public static void j(dc.a aVar) {
        if (aVar == null) {
            throw new IllegalArgumentException("logger must not be null");
        }
        f3693a = aVar;
    }

    public static int k(int i10) {
        return f3693a.m(i10);
    }

    public static int l(String str, String str2) {
        if (f3694b) {
            return f3693a.g(str, str2);
        }
        return 0;
    }

    public static int m(String str, String str2, Throwable th2) {
        if (f3694b) {
            return f3693a.l(str, str2, th2);
        }
        return 0;
    }

    public static int n(String str, String str2) {
        return f3693a.e(str, str2);
    }

    public static int o(String str, String str2, Throwable th2) {
        return f3693a.k(str, str2, th2);
    }
}
