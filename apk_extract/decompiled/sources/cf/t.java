package cf;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLSocket;

/* JADX INFO: loaded from: classes3.dex */
public final class t extends u {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final qf.c f1632d;
    public static final qf.c e;
    public static final qf.c f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final qf.c f1633g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final qf.c f1634h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final qf.c f1635i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final Method f1636j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final Method f1637k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final Method f1638l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final Method f1639m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final Method f1640n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final Method f1641o;
    public static final Constructor p;

    static {
        Method method;
        Method method2;
        Method method3;
        Method method4;
        Method method5;
        Method method6;
        Logger logger = u.f1642b;
        Class cls = Boolean.TYPE;
        Constructor<?> constructor = null;
        int i8 = 5;
        f1632d = new qf.c(constructor, i8, "setUseSessionTickets", new Class[]{cls});
        e = new qf.c(constructor, i8, "setHostname", new Class[]{String.class});
        Class<byte[]> cls2 = byte[].class;
        f = new qf.c(cls2, i8, "getAlpnSelectedProtocol", new Class[0]);
        f1633g = new qf.c(constructor, i8, "setAlpnProtocols", new Class[]{byte[].class});
        f1634h = new qf.c(cls2, i8, "getNpnSelectedProtocol", new Class[0]);
        f1635i = new qf.c(constructor, i8, "setNpnProtocols", new Class[]{byte[].class});
        try {
            method = SSLParameters.class.getMethod("setApplicationProtocols", String[].class);
            try {
                method2 = SSLParameters.class.getMethod("getApplicationProtocols", null);
                try {
                    method3 = SSLSocket.class.getMethod("getApplicationProtocol", null);
                    try {
                        Class<?> cls3 = Class.forName("android.net.ssl.SSLSockets");
                        method4 = cls3.getMethod("isSupportedSocket", SSLSocket.class);
                        try {
                            method5 = cls3.getMethod("setUseSessionTickets", SSLSocket.class, cls);
                        } catch (ClassNotFoundException e4) {
                            e = e4;
                            logger.log(Level.FINER, "Failed to find Android 10.0+ APIs", (Throwable) e);
                            method5 = null;
                        } catch (NoSuchMethodException e10) {
                            e = e10;
                            logger.log(Level.FINER, "Failed to find Android 10.0+ APIs", (Throwable) e);
                            method5 = null;
                        }
                    } catch (ClassNotFoundException e11) {
                        e = e11;
                        method4 = null;
                    } catch (NoSuchMethodException e12) {
                        e = e12;
                        method4 = null;
                    }
                } catch (ClassNotFoundException e13) {
                    e = e13;
                    method3 = null;
                    method4 = method3;
                    logger.log(Level.FINER, "Failed to find Android 10.0+ APIs", (Throwable) e);
                    method5 = null;
                    f1638l = method;
                    f1639m = method2;
                    f1640n = method3;
                    f1636j = method4;
                    f1637k = method5;
                    method6 = SSLParameters.class.getMethod("setServerNames", List.class);
                    constructor = Class.forName("javax.net.ssl.SNIHostName").getConstructor(String.class);
                    f1641o = method6;
                    p = constructor;
                } catch (NoSuchMethodException e14) {
                    e = e14;
                    method3 = null;
                    method4 = method3;
                    logger.log(Level.FINER, "Failed to find Android 10.0+ APIs", (Throwable) e);
                    method5 = null;
                    f1638l = method;
                    f1639m = method2;
                    f1640n = method3;
                    f1636j = method4;
                    f1637k = method5;
                    method6 = SSLParameters.class.getMethod("setServerNames", List.class);
                    constructor = Class.forName("javax.net.ssl.SNIHostName").getConstructor(String.class);
                    f1641o = method6;
                    p = constructor;
                }
            } catch (ClassNotFoundException e15) {
                e = e15;
                method2 = null;
                method3 = method2;
                method4 = method3;
                logger.log(Level.FINER, "Failed to find Android 10.0+ APIs", (Throwable) e);
                method5 = null;
                f1638l = method;
                f1639m = method2;
                f1640n = method3;
                f1636j = method4;
                f1637k = method5;
                method6 = SSLParameters.class.getMethod("setServerNames", List.class);
                constructor = Class.forName("javax.net.ssl.SNIHostName").getConstructor(String.class);
                f1641o = method6;
                p = constructor;
            } catch (NoSuchMethodException e16) {
                e = e16;
                method2 = null;
                method3 = method2;
                method4 = method3;
                logger.log(Level.FINER, "Failed to find Android 10.0+ APIs", (Throwable) e);
                method5 = null;
                f1638l = method;
                f1639m = method2;
                f1640n = method3;
                f1636j = method4;
                f1637k = method5;
                method6 = SSLParameters.class.getMethod("setServerNames", List.class);
                constructor = Class.forName("javax.net.ssl.SNIHostName").getConstructor(String.class);
                f1641o = method6;
                p = constructor;
            }
        } catch (ClassNotFoundException e17) {
            e = e17;
            method = null;
            method2 = null;
        } catch (NoSuchMethodException e18) {
            e = e18;
            method = null;
            method2 = null;
        }
        f1638l = method;
        f1639m = method2;
        f1640n = method3;
        f1636j = method4;
        f1637k = method5;
        try {
            method6 = SSLParameters.class.getMethod("setServerNames", List.class);
            try {
                constructor = Class.forName("javax.net.ssl.SNIHostName").getConstructor(String.class);
            } catch (ClassNotFoundException e19) {
                e = e19;
                logger.log(Level.FINER, "Failed to find Android 7.0+ APIs", (Throwable) e);
            } catch (NoSuchMethodException e20) {
                e = e20;
                logger.log(Level.FINER, "Failed to find Android 7.0+ APIs", (Throwable) e);
            }
        } catch (ClassNotFoundException e21) {
            e = e21;
            method6 = null;
        } catch (NoSuchMethodException e22) {
            e = e22;
            method6 = null;
        }
        f1641o = method6;
        p = constructor;
    }

    @Override // cf.u
    public final void a(SSLSocket sSLSocket, String str, List list) {
        Constructor constructor;
        Method method;
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(((df.l) it.next()).toString());
        }
        boolean z2 = false;
        String[] strArr = (String[]) arrayList.toArray(new String[0]);
        SSLParameters sSLParameters = sSLSocket.getSSLParameters();
        if (str != null) {
            try {
                try {
                    if (u.c(str)) {
                        Method method2 = f1636j;
                        if (method2 == null || !((Boolean) method2.invoke(null, sSLSocket)).booleanValue()) {
                            f1632d.z(sSLSocket, Boolean.TRUE);
                        } else {
                            f1637k.invoke(null, sSLSocket, Boolean.TRUE);
                        }
                        Method method3 = f1641o;
                        if (method3 == null || (constructor = p) == null) {
                            e.z(sSLSocket, str);
                        } else {
                            method3.invoke(sSLParameters, Collections.singletonList(constructor.newInstance(str)));
                        }
                    }
                } catch (InvocationTargetException e4) {
                    throw new RuntimeException(e4);
                }
            } catch (IllegalAccessException e10) {
                throw new RuntimeException(e10);
            } catch (InstantiationException e11) {
                throw new RuntimeException(e11);
            }
        }
        Method method4 = f1640n;
        if (method4 != null) {
            try {
                method4.invoke(sSLSocket, null);
                f1638l.invoke(sSLParameters, strArr);
                z2 = true;
            } catch (InvocationTargetException e12) {
                if (!(e12.getTargetException() instanceof UnsupportedOperationException)) {
                    throw e12;
                }
                u.f1642b.log(Level.FINER, "setApplicationProtocol unsupported, will try old methods");
            }
        }
        sSLSocket.setSSLParameters(sSLParameters);
        if (z2 && (method = f1639m) != null && Arrays.equals(strArr, (String[]) method.invoke(sSLSocket.getSSLParameters(), null))) {
            return;
        }
        Object[] objArr = {df.k.b(list)};
        df.k kVar = this.f1644a;
        if (kVar.e() == df.j.ALPN_AND_NPN) {
            f1633g.A(sSLSocket, objArr);
        }
        if (kVar.e() == df.j.NONE) {
            throw new RuntimeException("We can not do TLS handshake on this Android version, please install the Google Play Services Dynamic Security Provider to use TLS");
        }
        f1635i.A(sSLSocket, objArr);
    }

    @Override // cf.u
    public final String b(SSLSocket sSLSocket) {
        Logger logger = u.f1642b;
        Method method = f1640n;
        if (method != null) {
            try {
                return (String) method.invoke(sSLSocket, null);
            } catch (IllegalAccessException e4) {
                throw new RuntimeException(e4);
            } catch (InvocationTargetException e10) {
                if (!(e10.getTargetException() instanceof UnsupportedOperationException)) {
                    throw new RuntimeException(e10);
                }
                logger.log(Level.FINER, "Socket unsupported for getApplicationProtocol, will try old methods");
            }
        }
        df.k kVar = this.f1644a;
        if (kVar.e() == df.j.ALPN_AND_NPN) {
            try {
                byte[] bArr = (byte[]) f.A(sSLSocket, new Object[0]);
                if (bArr != null) {
                    return new String(bArr, df.o.f4462b);
                }
            } catch (Exception e11) {
                logger.log(Level.FINE, "Failed calling getAlpnSelectedProtocol()", (Throwable) e11);
            }
        }
        if (kVar.e() != df.j.NONE) {
            try {
                byte[] bArr2 = (byte[]) f1634h.A(sSLSocket, new Object[0]);
                if (bArr2 != null) {
                    return new String(bArr2, df.o.f4462b);
                }
            } catch (Exception e12) {
                logger.log(Level.FINE, "Failed calling getNpnSelectedProtocol()", (Throwable) e12);
            }
        }
        return null;
    }

    @Override // cf.u
    public final String d(SSLSocket sSLSocket, String str, List list) {
        String strB = b(sSLSocket);
        return strB == null ? super.d(sSLSocket, str, list) : strB;
    }
}
