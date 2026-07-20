package yj;

import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLEngine;

/* JADX INFO: loaded from: classes2.dex */
public final class b0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Throwable f20874a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Throwable f20875b;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final Throwable f20876a = a();

        public static Throwable a() {
            try {
                SSLContext sSLContext = SSLContext.getInstance("TLS");
                sSLContext.init(null, null, null);
                SSLEngine.class.getMethod("getApplicationProtocol", null).invoke(sSLContext.createSSLEngine(), null);
                return null;
            } catch (Throwable th2) {
                return th2;
            }
        }
    }

    public static Throwable a() {
        return a.f20876a;
    }

    public static synchronized Throwable b() {
        try {
            if (f20874a == null) {
                e();
            }
        } catch (Throwable th2) {
            throw th2;
        }
        return f20874a;
    }

    public static synchronized Throwable c() {
        try {
            if (f20875b == null) {
                f();
            }
        } catch (Throwable th2) {
            throw th2;
        }
        return f20875b;
    }

    public static boolean d() {
        return a.f20876a == null;
    }

    public static synchronized boolean e() {
        try {
            Class.forName("js.a", true, null);
        } catch (ClassNotFoundException e10) {
            f20874a = e10;
            return false;
        }
        return true;
    }

    public static synchronized boolean f() {
        try {
            Class.forName("org.eclipse.jetty.npn.NextProtoNego", true, null);
        } catch (ClassNotFoundException e10) {
            f20875b = e10;
            return false;
        }
        return true;
    }
}
