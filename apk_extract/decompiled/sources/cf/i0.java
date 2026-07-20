package cf;

import java.net.Socket;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import k3.v8;

/* JADX INFO: loaded from: classes3.dex */
public abstract class i0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final List f1556a = Collections.unmodifiableList(Arrays.asList(df.l.HTTP_2));

    public static SSLSocket a(SSLSocketFactory sSLSocketFactory, Socket socket, String str, int i8, df.c cVar) throws SSLPeerUnverifiedException {
        v8.i(sSLSocketFactory, "sslSocketFactory");
        v8.i(socket, "socket");
        v8.i(cVar, "spec");
        SSLSocket sSLSocket = (SSLSocket) sSLSocketFactory.createSocket(socket, str, i8, true);
        String[] strArr = cVar.f4435b;
        String[] strArr2 = strArr != null ? (String[]) df.o.a(strArr, sSLSocket.getEnabledCipherSuites()) : null;
        String[] strArr3 = (String[]) df.o.a(cVar.f4436c, sSLSocket.getEnabledProtocols());
        df.b bVar = new df.b(cVar);
        if (!bVar.f4430a) {
            throw new IllegalStateException("no cipher suites for cleartext connections");
        }
        if (strArr2 == null) {
            bVar.f4431b = null;
        } else {
            bVar.f4431b = (String[]) strArr2.clone();
        }
        if (!bVar.f4430a) {
            throw new IllegalStateException("no TLS versions for cleartext connections");
        }
        if (strArr3 == null) {
            bVar.f4432c = null;
        } else {
            bVar.f4432c = (String[]) strArr3.clone();
        }
        df.c cVar2 = new df.c(bVar);
        sSLSocket.setEnabledProtocols(cVar2.f4436c);
        String[] strArr4 = cVar2.f4435b;
        if (strArr4 != null) {
            sSLSocket.setEnabledCipherSuites(strArr4);
        }
        u uVar = u.f1643c;
        boolean z2 = cVar.f4437d;
        List list = f1556a;
        String strD = uVar.d(sSLSocket, str, z2 ? list : null);
        v8.l("Only " + list + " are supported, but negotiated protocol is %s", list.contains(df.l.get(strD)), strD);
        if (df.e.f4443a.verify((str.startsWith("[") && str.endsWith("]")) ? str.substring(1, str.length() - 1) : str, sSLSocket.getSession())) {
            return sSLSocket;
        }
        throw new SSLPeerUnverifiedException("Cannot verify hostname: ".concat(str));
    }
}
