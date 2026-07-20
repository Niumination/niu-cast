package df;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.Socket;
import java.security.AccessController;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivilegedActionException;
import java.security.Provider;
import java.security.Security;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;

/* JADX INFO: loaded from: classes3.dex */
public class k {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Logger f4453b = Logger.getLogger(k.class.getName());

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String[] f4454c = {"com.google.android.gms.org.conscrypt.OpenSSLProvider", "org.conscrypt.OpenSSLProvider", "com.android.org.conscrypt.OpenSSLProvider", "org.apache.harmony.xnet.provider.jsse.OpenSSLProvider", "com.google.android.libraries.stitch.sslguard.SslGuardProvider"};

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final k f4455d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Provider f4456a;

    static {
        Logger logger;
        Object obj;
        Provider provider;
        k kVar;
        j jVar;
        Provider[] providers = Security.getProviders();
        int length = providers.length;
        int i8 = 0;
        loop0: while (true) {
            logger = f4453b;
            obj = null;
            if (i8 >= length) {
                logger.log(Level.WARNING, "Unable to find Conscrypt");
                provider = null;
                break;
            }
            Provider provider2 = providers[i8];
            for (String str : f4454c) {
                if (str.equals(provider2.getClass().getName())) {
                    logger.log(Level.FINE, "Found registered provider {0}", str);
                    provider = provider2;
                    break loop0;
                }
            }
            i8++;
        }
        if (provider != null) {
            int i9 = 5;
            qf.c cVar = new qf.c(obj, i9, "setUseSessionTickets", new Class[]{Boolean.TYPE});
            qf.c cVar2 = new qf.c(obj, i9, "setHostname", new Class[]{String.class});
            qf.c cVar3 = new qf.c(byte[].class, i9, "getAlpnSelectedProtocol", new Class[0]);
            qf.c cVar4 = new qf.c(obj, i9, "setAlpnProtocols", new Class[]{byte[].class});
            try {
                Class<?> cls = Class.forName("android.net.TrafficStats");
                cls.getMethod("tagSocket", Socket.class);
                cls.getMethod("untagSocket", Socket.class);
            } catch (ClassNotFoundException | NoSuchMethodException unused) {
            }
            if (provider.getName().equals("GmsCore_OpenSSL") || provider.getName().equals("Conscrypt") || provider.getName().equals("Ssl_Guard")) {
                jVar = j.ALPN_AND_NPN;
            } else {
                try {
                    k.class.getClassLoader().loadClass("android.net.Network");
                    jVar = j.ALPN_AND_NPN;
                } catch (ClassNotFoundException e) {
                    logger.log(Level.FINE, "Can't find class", (Throwable) e);
                    try {
                        k.class.getClassLoader().loadClass("android.app.ActivityOptions");
                        jVar = j.NPN;
                    } catch (ClassNotFoundException e4) {
                        logger.log(Level.FINE, "Can't find class", (Throwable) e4);
                        jVar = j.NONE;
                    }
                }
            }
            kVar = new g(cVar, cVar2, cVar3, cVar4, provider, jVar);
        } else {
            try {
                Provider provider3 = SSLContext.getDefault().getProvider();
                try {
                    try {
                        SSLContext sSLContext = SSLContext.getInstance("TLS", provider3);
                        sSLContext.init(null, null, null);
                        ((Method) AccessController.doPrivileged(new f(0))).invoke(sSLContext.createSSLEngine(), null);
                        kVar = new h(provider3, (Method) AccessController.doPrivileged(new f(1)), (Method) AccessController.doPrivileged(new f(2)));
                    } catch (IllegalAccessException | InvocationTargetException | KeyManagementException | NoSuchAlgorithmException | PrivilegedActionException unused2) {
                        Class<?> cls2 = Class.forName("org.eclipse.jetty.alpn.ALPN");
                        kVar = new g(cls2.getMethod("put", SSLSocket.class, Class.forName("org.eclipse.jetty.alpn.ALPN$Provider")), cls2.getMethod("get", SSLSocket.class), cls2.getMethod("remove", SSLSocket.class), Class.forName("org.eclipse.jetty.alpn.ALPN$ClientProvider"), Class.forName("org.eclipse.jetty.alpn.ALPN$ServerProvider"), provider3);
                    }
                } catch (ClassNotFoundException | NoSuchMethodException unused3) {
                    kVar = new k(provider3);
                }
            } catch (NoSuchAlgorithmException e10) {
                throw new RuntimeException(e10);
            }
        }
        f4455d = kVar;
    }

    public k(Provider provider) {
        this.f4456a = provider;
    }

    public static byte[] b(List list) {
        qj.f fVar = new qj.f();
        int size = list.size();
        for (int i8 = 0; i8 < size; i8++) {
            l lVar = (l) list.get(i8);
            if (lVar != l.HTTP_1_0) {
                fVar.S(lVar.toString().length());
                fVar.m0(lVar.toString());
            }
        }
        return fVar.m(fVar.f9195b);
    }

    public void a(SSLSocket sSLSocket) {
    }

    public void c(SSLSocket sSLSocket, String str, List list) {
    }

    public String d(SSLSocket sSLSocket) {
        return null;
    }

    public j e() {
        return j.NONE;
    }
}
