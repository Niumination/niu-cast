package lj;

import android.util.Log;
import androidx.core.os.EnvironmentCompat;
import dj.b0;
import java.lang.reflect.Method;
import java.security.GeneralSecurityException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.Provider;
import java.security.Security;
import java.security.cert.X509Certificate;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;
import k3.fb;
import k3.lc;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile m f7532a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Logger f7533b;

    /* JADX WARN: Code duplicated, block: B:22:0x006a A[PHI: r0
      0x006a: PHI (r0v36 lj.m) = (r0v15 lj.m), (r0v17 lj.m), (r0v23 lj.m), (r0v27 lj.m), (r0v31 lj.m), (r0v42 lj.m) binds: [B:52:0x00ea, B:64:0x0160, B:46:0x00dc, B:38:0x00b9, B:30:0x0096, B:21:0x0068] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:32:0x0099  */
    /* JADX WARN: Code duplicated, block: B:34:0x00ae  */
    /* JADX WARN: Code duplicated, block: B:36:0x00b2  */
    /* JADX WARN: Code duplicated, block: B:37:0x00b8  */
    /* JADX WARN: Code duplicated, block: B:40:0x00bc  */
    /* JADX WARN: Code duplicated, block: B:42:0x00d1  */
    /* JADX WARN: Code duplicated, block: B:44:0x00d5  */
    /* JADX WARN: Code duplicated, block: B:45:0x00db  */
    /* JADX WARN: Code duplicated, block: B:48:0x00df  */
    /* JADX WARN: Code duplicated, block: B:50:0x00e3  */
    /* JADX WARN: Code duplicated, block: B:51:0x00e9  */
    /* JADX WARN: Code duplicated, block: B:54:0x00ee  */
    /* JADX WARN: Code duplicated, block: B:59:0x0106  */
    /* JADX WARN: Code duplicated, block: B:64:0x0160  */
    static {
        Provider provider;
        Provider provider2;
        m mVar;
        String jvmVersion;
        m iVar = null;
        if (fb.c()) {
            for (Map.Entry entry : mj.c.f8100b.entrySet()) {
                String str = (String) entry.getKey();
                String str2 = (String) entry.getValue();
                Logger logger = Logger.getLogger(str);
                if (mj.c.f8099a.add(logger)) {
                    Intrinsics.checkNotNullExpressionValue(logger, "logger");
                    logger.setUseParentHandlers(false);
                    logger.setLevel(Log.isLoggable(str2, 3) ? Level.FINE : Log.isLoggable(str2, 4) ? Level.INFO : Level.WARNING);
                    logger.addHandler(mj.d.f8101a);
                }
            }
            mVar = a.f7515d ? new a() : null;
            if (mVar != null) {
                iVar = mVar;
            } else {
                int i8 = b.f7517c;
                Intrinsics.checkNotNull(null);
            }
        } else {
            Provider provider3 = Security.getProviders()[0];
            Intrinsics.checkNotNullExpressionValue(provider3, "Security.getProviders()[0]");
            if (Intrinsics.areEqual("Conscrypt", provider3.getName())) {
                mVar = g.f7521d ? new g() : null;
                if (mVar != null) {
                    iVar = mVar;
                } else {
                    provider = Security.getProviders()[0];
                    Intrinsics.checkNotNullExpressionValue(provider, "Security.getProviders()[0]");
                    if (Intrinsics.areEqual("BC", provider.getName())) {
                        if (d.f7518d) {
                            mVar = new d();
                        } else {
                            mVar = null;
                        }
                        if (mVar != null) {
                            iVar = mVar;
                        } else {
                            provider2 = Security.getProviders()[0];
                            Intrinsics.checkNotNullExpressionValue(provider2, "Security.getProviders()[0]");
                            if (Intrinsics.areEqual("OpenJSSE", provider2.getName())) {
                                if (l.f7530d) {
                                    mVar = new l();
                                } else {
                                    mVar = null;
                                }
                                if (mVar != null) {
                                    iVar = mVar;
                                } else {
                                    if (j.f7529c) {
                                        mVar = new j();
                                    } else {
                                        mVar = null;
                                    }
                                    if (mVar != null) {
                                        iVar = mVar;
                                    } else {
                                        jvmVersion = System.getProperty("java.specification.version", EnvironmentCompat.MEDIA_UNKNOWN);
                                        Intrinsics.checkNotNullExpressionValue(jvmVersion, "jvmVersion");
                                        if (Integer.parseInt(jvmVersion) < 9) {
                                            Class<?> cls = Class.forName("org.eclipse.jetty.alpn.ALPN", true, null);
                                            Class<?> cls2 = Class.forName("org.eclipse.jetty.alpn.ALPN$Provider", true, null);
                                            Class<?> clientProviderClass = Class.forName("org.eclipse.jetty.alpn.ALPN$ClientProvider", true, null);
                                            Class<?> serverProviderClass = Class.forName("org.eclipse.jetty.alpn.ALPN$ServerProvider", true, null);
                                            Method putMethod = cls.getMethod("put", SSLSocket.class, cls2);
                                            Method getMethod = cls.getMethod("get", SSLSocket.class);
                                            Method removeMethod = cls.getMethod("remove", SSLSocket.class);
                                            Intrinsics.checkNotNullExpressionValue(putMethod, "putMethod");
                                            Intrinsics.checkNotNullExpressionValue(getMethod, "getMethod");
                                            Intrinsics.checkNotNullExpressionValue(removeMethod, "removeMethod");
                                            Intrinsics.checkNotNullExpressionValue(clientProviderClass, "clientProviderClass");
                                            Intrinsics.checkNotNullExpressionValue(serverProviderClass, "serverProviderClass");
                                            iVar = new i(putMethod, getMethod, removeMethod, clientProviderClass, serverProviderClass);
                                        }
                                        if (iVar == null) {
                                            mVar = new m();
                                            iVar = mVar;
                                        }
                                    }
                                }
                            } else {
                                if (j.f7529c) {
                                    mVar = new j();
                                } else {
                                    mVar = null;
                                }
                                if (mVar != null) {
                                    iVar = mVar;
                                } else {
                                    jvmVersion = System.getProperty("java.specification.version", EnvironmentCompat.MEDIA_UNKNOWN);
                                    Intrinsics.checkNotNullExpressionValue(jvmVersion, "jvmVersion");
                                    if (Integer.parseInt(jvmVersion) < 9) {
                                        Class<?> cls3 = Class.forName("org.eclipse.jetty.alpn.ALPN", true, null);
                                        Class<?> cls4 = Class.forName("org.eclipse.jetty.alpn.ALPN$Provider", true, null);
                                        Class<?> clientProviderClass2 = Class.forName("org.eclipse.jetty.alpn.ALPN$ClientProvider", true, null);
                                        Class<?> serverProviderClass2 = Class.forName("org.eclipse.jetty.alpn.ALPN$ServerProvider", true, null);
                                        Method putMethod2 = cls3.getMethod("put", SSLSocket.class, cls4);
                                        Method getMethod2 = cls3.getMethod("get", SSLSocket.class);
                                        Method removeMethod2 = cls3.getMethod("remove", SSLSocket.class);
                                        Intrinsics.checkNotNullExpressionValue(putMethod2, "putMethod");
                                        Intrinsics.checkNotNullExpressionValue(getMethod2, "getMethod");
                                        Intrinsics.checkNotNullExpressionValue(removeMethod2, "removeMethod");
                                        Intrinsics.checkNotNullExpressionValue(clientProviderClass2, "clientProviderClass");
                                        Intrinsics.checkNotNullExpressionValue(serverProviderClass2, "serverProviderClass");
                                        iVar = new i(putMethod2, getMethod2, removeMethod2, clientProviderClass2, serverProviderClass2);
                                    }
                                    if (iVar == null) {
                                        mVar = new m();
                                        iVar = mVar;
                                    }
                                }
                            }
                        }
                    } else {
                        provider2 = Security.getProviders()[0];
                        Intrinsics.checkNotNullExpressionValue(provider2, "Security.getProviders()[0]");
                        if (Intrinsics.areEqual("OpenJSSE", provider2.getName())) {
                            if (j.f7529c) {
                                mVar = new j();
                            } else {
                                mVar = null;
                            }
                            if (mVar != null) {
                                iVar = mVar;
                            } else {
                                jvmVersion = System.getProperty("java.specification.version", EnvironmentCompat.MEDIA_UNKNOWN);
                                Intrinsics.checkNotNullExpressionValue(jvmVersion, "jvmVersion");
                                if (Integer.parseInt(jvmVersion) < 9) {
                                    Class<?> cls5 = Class.forName("org.eclipse.jetty.alpn.ALPN", true, null);
                                    Class<?> cls6 = Class.forName("org.eclipse.jetty.alpn.ALPN$Provider", true, null);
                                    Class<?> clientProviderClass3 = Class.forName("org.eclipse.jetty.alpn.ALPN$ClientProvider", true, null);
                                    Class<?> serverProviderClass3 = Class.forName("org.eclipse.jetty.alpn.ALPN$ServerProvider", true, null);
                                    Method putMethod3 = cls5.getMethod("put", SSLSocket.class, cls6);
                                    Method getMethod3 = cls5.getMethod("get", SSLSocket.class);
                                    Method removeMethod3 = cls5.getMethod("remove", SSLSocket.class);
                                    Intrinsics.checkNotNullExpressionValue(putMethod3, "putMethod");
                                    Intrinsics.checkNotNullExpressionValue(getMethod3, "getMethod");
                                    Intrinsics.checkNotNullExpressionValue(removeMethod3, "removeMethod");
                                    Intrinsics.checkNotNullExpressionValue(clientProviderClass3, "clientProviderClass");
                                    Intrinsics.checkNotNullExpressionValue(serverProviderClass3, "serverProviderClass");
                                    iVar = new i(putMethod3, getMethod3, removeMethod3, clientProviderClass3, serverProviderClass3);
                                }
                                if (iVar == null) {
                                    mVar = new m();
                                    iVar = mVar;
                                }
                            }
                        } else {
                            if (l.f7530d) {
                                mVar = new l();
                            } else {
                                mVar = null;
                            }
                            if (mVar != null) {
                                iVar = mVar;
                            } else {
                                if (j.f7529c) {
                                    mVar = new j();
                                } else {
                                    mVar = null;
                                }
                                if (mVar != null) {
                                    iVar = mVar;
                                } else {
                                    jvmVersion = System.getProperty("java.specification.version", EnvironmentCompat.MEDIA_UNKNOWN);
                                    Intrinsics.checkNotNullExpressionValue(jvmVersion, "jvmVersion");
                                    if (Integer.parseInt(jvmVersion) < 9) {
                                        Class<?> cls7 = Class.forName("org.eclipse.jetty.alpn.ALPN", true, null);
                                        Class<?> cls8 = Class.forName("org.eclipse.jetty.alpn.ALPN$Provider", true, null);
                                        Class<?> clientProviderClass4 = Class.forName("org.eclipse.jetty.alpn.ALPN$ClientProvider", true, null);
                                        Class<?> serverProviderClass4 = Class.forName("org.eclipse.jetty.alpn.ALPN$ServerProvider", true, null);
                                        Method putMethod4 = cls7.getMethod("put", SSLSocket.class, cls8);
                                        Method getMethod4 = cls7.getMethod("get", SSLSocket.class);
                                        Method removeMethod4 = cls7.getMethod("remove", SSLSocket.class);
                                        Intrinsics.checkNotNullExpressionValue(putMethod4, "putMethod");
                                        Intrinsics.checkNotNullExpressionValue(getMethod4, "getMethod");
                                        Intrinsics.checkNotNullExpressionValue(removeMethod4, "removeMethod");
                                        Intrinsics.checkNotNullExpressionValue(clientProviderClass4, "clientProviderClass");
                                        Intrinsics.checkNotNullExpressionValue(serverProviderClass4, "serverProviderClass");
                                        iVar = new i(putMethod4, getMethod4, removeMethod4, clientProviderClass4, serverProviderClass4);
                                    }
                                    if (iVar == null) {
                                        mVar = new m();
                                        iVar = mVar;
                                    }
                                }
                            }
                        }
                    }
                }
            } else {
                provider = Security.getProviders()[0];
                Intrinsics.checkNotNullExpressionValue(provider, "Security.getProviders()[0]");
                if (Intrinsics.areEqual("BC", provider.getName())) {
                    provider2 = Security.getProviders()[0];
                    Intrinsics.checkNotNullExpressionValue(provider2, "Security.getProviders()[0]");
                    if (Intrinsics.areEqual("OpenJSSE", provider2.getName())) {
                        if (j.f7529c) {
                            mVar = new j();
                        } else {
                            mVar = null;
                        }
                        if (mVar != null) {
                            iVar = mVar;
                        } else {
                            jvmVersion = System.getProperty("java.specification.version", EnvironmentCompat.MEDIA_UNKNOWN);
                            try {
                                Intrinsics.checkNotNullExpressionValue(jvmVersion, "jvmVersion");
                                if (Integer.parseInt(jvmVersion) < 9) {
                                    try {
                                        Class<?> cls9 = Class.forName("org.eclipse.jetty.alpn.ALPN", true, null);
                                        Class<?> cls10 = Class.forName("org.eclipse.jetty.alpn.ALPN$Provider", true, null);
                                        Class<?> clientProviderClass5 = Class.forName("org.eclipse.jetty.alpn.ALPN$ClientProvider", true, null);
                                        Class<?> serverProviderClass5 = Class.forName("org.eclipse.jetty.alpn.ALPN$ServerProvider", true, null);
                                        Method putMethod5 = cls9.getMethod("put", SSLSocket.class, cls10);
                                        Method getMethod5 = cls9.getMethod("get", SSLSocket.class);
                                        Method removeMethod5 = cls9.getMethod("remove", SSLSocket.class);
                                        Intrinsics.checkNotNullExpressionValue(putMethod5, "putMethod");
                                        Intrinsics.checkNotNullExpressionValue(getMethod5, "getMethod");
                                        Intrinsics.checkNotNullExpressionValue(removeMethod5, "removeMethod");
                                        Intrinsics.checkNotNullExpressionValue(clientProviderClass5, "clientProviderClass");
                                        Intrinsics.checkNotNullExpressionValue(serverProviderClass5, "serverProviderClass");
                                        iVar = new i(putMethod5, getMethod5, removeMethod5, clientProviderClass5, serverProviderClass5);
                                    } catch (ClassNotFoundException | NoSuchMethodException unused) {
                                    }
                                }
                            } catch (NumberFormatException unused2) {
                            }
                            if (iVar == null) {
                                mVar = new m();
                                iVar = mVar;
                            }
                        }
                    } else {
                        if (l.f7530d) {
                            mVar = new l();
                        } else {
                            mVar = null;
                        }
                        if (mVar != null) {
                            iVar = mVar;
                        } else {
                            if (j.f7529c) {
                                mVar = new j();
                            } else {
                                mVar = null;
                            }
                            if (mVar != null) {
                                iVar = mVar;
                            } else {
                                jvmVersion = System.getProperty("java.specification.version", EnvironmentCompat.MEDIA_UNKNOWN);
                                Intrinsics.checkNotNullExpressionValue(jvmVersion, "jvmVersion");
                                if (Integer.parseInt(jvmVersion) < 9) {
                                    Class<?> cls11 = Class.forName("org.eclipse.jetty.alpn.ALPN", true, null);
                                    Class<?> cls12 = Class.forName("org.eclipse.jetty.alpn.ALPN$Provider", true, null);
                                    Class<?> clientProviderClass6 = Class.forName("org.eclipse.jetty.alpn.ALPN$ClientProvider", true, null);
                                    Class<?> serverProviderClass6 = Class.forName("org.eclipse.jetty.alpn.ALPN$ServerProvider", true, null);
                                    Method putMethod6 = cls11.getMethod("put", SSLSocket.class, cls12);
                                    Method getMethod6 = cls11.getMethod("get", SSLSocket.class);
                                    Method removeMethod6 = cls11.getMethod("remove", SSLSocket.class);
                                    Intrinsics.checkNotNullExpressionValue(putMethod6, "putMethod");
                                    Intrinsics.checkNotNullExpressionValue(getMethod6, "getMethod");
                                    Intrinsics.checkNotNullExpressionValue(removeMethod6, "removeMethod");
                                    Intrinsics.checkNotNullExpressionValue(clientProviderClass6, "clientProviderClass");
                                    Intrinsics.checkNotNullExpressionValue(serverProviderClass6, "serverProviderClass");
                                    iVar = new i(putMethod6, getMethod6, removeMethod6, clientProviderClass6, serverProviderClass6);
                                }
                                if (iVar == null) {
                                    mVar = new m();
                                    iVar = mVar;
                                }
                            }
                        }
                    }
                } else {
                    if (d.f7518d) {
                        mVar = new d();
                    } else {
                        mVar = null;
                    }
                    if (mVar != null) {
                        iVar = mVar;
                    } else {
                        provider2 = Security.getProviders()[0];
                        Intrinsics.checkNotNullExpressionValue(provider2, "Security.getProviders()[0]");
                        if (Intrinsics.areEqual("OpenJSSE", provider2.getName())) {
                            if (j.f7529c) {
                                mVar = new j();
                            } else {
                                mVar = null;
                            }
                            if (mVar != null) {
                                iVar = mVar;
                            } else {
                                jvmVersion = System.getProperty("java.specification.version", EnvironmentCompat.MEDIA_UNKNOWN);
                                Intrinsics.checkNotNullExpressionValue(jvmVersion, "jvmVersion");
                                if (Integer.parseInt(jvmVersion) < 9) {
                                    Class<?> cls13 = Class.forName("org.eclipse.jetty.alpn.ALPN", true, null);
                                    Class<?> cls14 = Class.forName("org.eclipse.jetty.alpn.ALPN$Provider", true, null);
                                    Class<?> clientProviderClass7 = Class.forName("org.eclipse.jetty.alpn.ALPN$ClientProvider", true, null);
                                    Class<?> serverProviderClass7 = Class.forName("org.eclipse.jetty.alpn.ALPN$ServerProvider", true, null);
                                    Method putMethod7 = cls13.getMethod("put", SSLSocket.class, cls14);
                                    Method getMethod7 = cls13.getMethod("get", SSLSocket.class);
                                    Method removeMethod7 = cls13.getMethod("remove", SSLSocket.class);
                                    Intrinsics.checkNotNullExpressionValue(putMethod7, "putMethod");
                                    Intrinsics.checkNotNullExpressionValue(getMethod7, "getMethod");
                                    Intrinsics.checkNotNullExpressionValue(removeMethod7, "removeMethod");
                                    Intrinsics.checkNotNullExpressionValue(clientProviderClass7, "clientProviderClass");
                                    Intrinsics.checkNotNullExpressionValue(serverProviderClass7, "serverProviderClass");
                                    iVar = new i(putMethod7, getMethod7, removeMethod7, clientProviderClass7, serverProviderClass7);
                                }
                                if (iVar == null) {
                                    mVar = new m();
                                    iVar = mVar;
                                }
                            }
                        } else {
                            if (l.f7530d) {
                                mVar = new l();
                            } else {
                                mVar = null;
                            }
                            if (mVar != null) {
                                iVar = mVar;
                            } else {
                                if (j.f7529c) {
                                    mVar = new j();
                                } else {
                                    mVar = null;
                                }
                                if (mVar != null) {
                                    iVar = mVar;
                                } else {
                                    jvmVersion = System.getProperty("java.specification.version", EnvironmentCompat.MEDIA_UNKNOWN);
                                    Intrinsics.checkNotNullExpressionValue(jvmVersion, "jvmVersion");
                                    if (Integer.parseInt(jvmVersion) < 9) {
                                        Class<?> cls15 = Class.forName("org.eclipse.jetty.alpn.ALPN", true, null);
                                        Class<?> cls16 = Class.forName("org.eclipse.jetty.alpn.ALPN$Provider", true, null);
                                        Class<?> clientProviderClass8 = Class.forName("org.eclipse.jetty.alpn.ALPN$ClientProvider", true, null);
                                        Class<?> serverProviderClass8 = Class.forName("org.eclipse.jetty.alpn.ALPN$ServerProvider", true, null);
                                        Method putMethod8 = cls15.getMethod("put", SSLSocket.class, cls16);
                                        Method getMethod8 = cls15.getMethod("get", SSLSocket.class);
                                        Method removeMethod8 = cls15.getMethod("remove", SSLSocket.class);
                                        Intrinsics.checkNotNullExpressionValue(putMethod8, "putMethod");
                                        Intrinsics.checkNotNullExpressionValue(getMethod8, "getMethod");
                                        Intrinsics.checkNotNullExpressionValue(removeMethod8, "removeMethod");
                                        Intrinsics.checkNotNullExpressionValue(clientProviderClass8, "clientProviderClass");
                                        Intrinsics.checkNotNullExpressionValue(serverProviderClass8, "serverProviderClass");
                                        iVar = new i(putMethod8, getMethod8, removeMethod8, clientProviderClass8, serverProviderClass8);
                                    }
                                    if (iVar == null) {
                                        mVar = new m();
                                        iVar = mVar;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        f7532a = iVar;
        f7533b = Logger.getLogger(b0.class.getName());
    }

    public static void f(String message, int i8, Throwable th2) {
        Intrinsics.checkNotNullParameter(message, "message");
        f7533b.log(i8 == 5 ? Level.WARNING : Level.INFO, message, th2);
    }

    public void a(SSLSocket sslSocket) {
        Intrinsics.checkNotNullParameter(sslSocket, "sslSocket");
    }

    public lc b(X509TrustManager trustManager) {
        Intrinsics.checkNotNullParameter(trustManager, "trustManager");
        Intrinsics.checkNotNullParameter(trustManager, "trustManager");
        X509Certificate[] acceptedIssuers = trustManager.getAcceptedIssuers();
        Intrinsics.checkNotNullExpressionValue(acceptedIssuers, "trustManager.acceptedIssuers");
        return new pj.a(new pj.b((X509Certificate[]) Arrays.copyOf(acceptedIssuers, acceptedIssuers.length)));
    }

    public void c(SSLSocket sslSocket, String str, List protocols) {
        Intrinsics.checkNotNullParameter(sslSocket, "sslSocket");
        Intrinsics.checkNotNullParameter(protocols, "protocols");
    }

    public String d(SSLSocket sslSocket) {
        Intrinsics.checkNotNullParameter(sslSocket, "sslSocket");
        return null;
    }

    public boolean e(String hostname) {
        Intrinsics.checkNotNullParameter(hostname, "hostname");
        return true;
    }

    public SSLContext g() throws NoSuchAlgorithmException {
        SSLContext sSLContext = SSLContext.getInstance("TLS");
        Intrinsics.checkNotNullExpressionValue(sSLContext, "SSLContext.getInstance(\"TLS\")");
        return sSLContext;
    }

    public SSLSocketFactory h(X509TrustManager trustManager) {
        Intrinsics.checkNotNullParameter(trustManager, "trustManager");
        try {
            SSLContext sSLContextG = g();
            sSLContextG.init(null, new TrustManager[]{trustManager}, null);
            SSLSocketFactory socketFactory = sSLContextG.getSocketFactory();
            Intrinsics.checkNotNullExpressionValue(socketFactory, "newSSLContext().apply {\n…ll)\n      }.socketFactory");
            return socketFactory;
        } catch (GeneralSecurityException e) {
            throw new AssertionError("No System TLS: " + e, e);
        }
    }

    public X509TrustManager i() throws NoSuchAlgorithmException, KeyStoreException {
        TrustManagerFactory factory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
        factory.init((KeyStore) null);
        Intrinsics.checkNotNullExpressionValue(factory, "factory");
        TrustManager[] trustManagers = factory.getTrustManagers();
        Intrinsics.checkNotNull(trustManagers);
        if (trustManagers.length == 1 && (trustManagers[0] instanceof X509TrustManager)) {
            TrustManager trustManager = trustManagers[0];
            if (trustManager != null) {
                return (X509TrustManager) trustManager;
            }
            throw new NullPointerException("null cannot be cast to non-null type javax.net.ssl.X509TrustManager");
        }
        StringBuilder sb2 = new StringBuilder("Unexpected default trust managers: ");
        String string = Arrays.toString(trustManagers);
        Intrinsics.checkNotNullExpressionValue(string, "java.util.Arrays.toString(this)");
        sb2.append(string);
        throw new IllegalStateException(sb2.toString().toString());
    }

    public final String toString() {
        String simpleName = getClass().getSimpleName();
        Intrinsics.checkNotNullExpressionValue(simpleName, "javaClass.simpleName");
        return simpleName;
    }
}
