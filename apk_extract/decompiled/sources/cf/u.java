package cf;

import af.l1;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.SSLSocket;
import k3.v8;

/* JADX INFO: loaded from: classes3.dex */
public class u {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Logger f1642b = Logger.getLogger(u.class.getName());

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final u f1643c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final df.k f1644a;

    static {
        u uVar;
        df.k kVar = df.k.f4455d;
        ClassLoader classLoader = u.class.getClassLoader();
        try {
            classLoader.loadClass("com.android.org.conscrypt.OpenSSLSocketImpl");
        } catch (ClassNotFoundException e) {
            Level level = Level.FINE;
            Logger logger = f1642b;
            logger.log(level, "Unable to find Conscrypt. Skipping", (Throwable) e);
            try {
                classLoader.loadClass("org.apache.harmony.xnet.provider.jsse.OpenSSLSocketImpl");
            } catch (ClassNotFoundException e4) {
                logger.log(Level.FINE, "Unable to find any OpenSSLSocketImpl. Skipping", (Throwable) e4);
                uVar = new u(kVar);
            }
        }
        uVar = new t(kVar);
        f1643c = uVar;
    }

    public u(df.k kVar) {
        v8.i(kVar, "platform");
        this.f1644a = kVar;
    }

    public static boolean c(String str) {
        if (str.contains("_")) {
            return false;
        }
        try {
            v8.d("Userinfo must not be present on authority: '%s'", l1.a(str).getAuthority().indexOf(64) == -1, str);
            return true;
        } catch (IllegalArgumentException unused) {
            return false;
        }
    }

    public void a(SSLSocket sSLSocket, String str, List list) {
        this.f1644a.c(sSLSocket, str, list);
    }

    public String b(SSLSocket sSLSocket) {
        return this.f1644a.d(sSLSocket);
    }

    public String d(SSLSocket sSLSocket, String str, List list) {
        df.k kVar = this.f1644a;
        if (list != null) {
            a(sSLSocket, str, list);
        }
        try {
            sSLSocket.startHandshake();
            String strB = b(sSLSocket);
            if (strB != null) {
                kVar.a(sSLSocket);
                return strB;
            }
            throw new RuntimeException("TLS ALPN negotiation failed with protocols: " + list);
        } catch (Throwable th2) {
            kVar.a(sSLSocket);
            throw th2;
        }
    }
}
