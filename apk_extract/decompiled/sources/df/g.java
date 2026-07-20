package df;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.security.Provider;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import javax.net.ssl.SSLSocket;

/* JADX INFO: loaded from: classes3.dex */
public final class g extends k {
    public final /* synthetic */ int e = 1;
    public final Object f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Object f4446g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Object f4447h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Object f4448i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Serializable f4449j;

    public g(qf.c cVar, qf.c cVar2, qf.c cVar3, qf.c cVar4, Provider provider, j jVar) {
        super(provider);
        this.f = cVar;
        this.f4446g = cVar2;
        this.f4447h = cVar3;
        this.f4448i = cVar4;
        this.f4449j = jVar;
    }

    @Override // df.k
    public void a(SSLSocket sSLSocket) {
        switch (this.e) {
            case 1:
                try {
                    ((Method) this.f4447h).invoke(null, sSLSocket);
                    return;
                } catch (IllegalAccessException unused) {
                    throw new AssertionError();
                } catch (InvocationTargetException e) {
                    k.f4453b.log(Level.FINE, "Failed to remove SSLSocket from Jetty ALPN", (Throwable) e);
                    return;
                }
            default:
                return;
        }
    }

    @Override // df.k
    public final void c(SSLSocket sSLSocket, String str, List list) {
        switch (this.e) {
            case 0:
                if (str != null) {
                    ((qf.c) this.f).z(sSLSocket, Boolean.TRUE);
                    ((qf.c) this.f4446g).z(sSLSocket, str);
                }
                qf.c cVar = (qf.c) this.f4448i;
                if (cVar.v(sSLSocket.getClass()) != null) {
                    cVar.A(sSLSocket, k.b(list));
                    return;
                }
                return;
            default:
                ArrayList arrayList = new ArrayList(list.size());
                int size = list.size();
                for (int i8 = 0; i8 < size; i8++) {
                    l lVar = (l) list.get(i8);
                    if (lVar != l.HTTP_1_0) {
                        arrayList.add(lVar.toString());
                    }
                }
                try {
                    ((Method) this.f).invoke(null, sSLSocket, Proxy.newProxyInstance(k.class.getClassLoader(), new Class[]{(Class) this.f4448i, (Class) this.f4449j}, new i(arrayList)));
                    return;
                } catch (IllegalAccessException e) {
                    throw new AssertionError(e);
                } catch (InvocationTargetException e4) {
                    throw new AssertionError(e4);
                }
        }
    }

    @Override // df.k
    public final String d(SSLSocket sSLSocket) {
        byte[] bArr;
        switch (this.e) {
            case 0:
                qf.c cVar = (qf.c) this.f4447h;
                if ((cVar.v(sSLSocket.getClass()) != null) && (bArr = (byte[]) cVar.A(sSLSocket, new Object[0])) != null) {
                    return new String(bArr, o.f4462b);
                }
                return null;
            default:
                try {
                    i iVar = (i) Proxy.getInvocationHandler(((Method) this.f4446g).invoke(null, sSLSocket));
                    boolean z2 = iVar.f4451b;
                    if (!z2 && iVar.f4452c == null) {
                        k.f4453b.log(Level.INFO, "ALPN callback dropped: SPDY and HTTP/2 are disabled. Is alpn-boot on the boot class path?");
                        return null;
                    }
                    if (z2) {
                        return null;
                    }
                    return iVar.f4452c;
                } catch (IllegalAccessException unused) {
                    throw new AssertionError();
                } catch (InvocationTargetException unused2) {
                    throw new AssertionError();
                }
        }
    }

    @Override // df.k
    public final j e() {
        switch (this.e) {
            case 0:
                return (j) this.f4449j;
            default:
                return j.ALPN_AND_NPN;
        }
    }

    public g(Method method, Method method2, Method method3, Class cls, Class cls2, Provider provider) {
        super(provider);
        this.f = method;
        this.f4446g = method2;
        this.f4447h = method3;
        this.f4448i = cls;
        this.f4449j = cls2;
    }
}
