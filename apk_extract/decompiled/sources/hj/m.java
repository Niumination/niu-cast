package hj;

import af.r5;
import com.transsion.message.bank.MessageBank;
import dj.b0;
import dj.c0;
import dj.d0;
import dj.i0;
import dj.j0;
import dj.l0;
import dj.n0;
import dj.u;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.ConnectException;
import java.net.InetSocketAddress;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.Socket;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownServiceException;
import java.security.Principal;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import k3.s1;
import k3.sc;
import k3.u1;
import k3.v1;
import kj.a0;
import kj.e0;
import kj.s;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__IndentKt;
import qj.t;

/* JADX INFO: loaded from: classes3.dex */
public final class m extends kj.j {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Socket f5455b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Socket f5456c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public dj.q f5457d;
    public d0 e;
    public s f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public t f5458g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public qj.s f5459h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f5460i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f5461j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f5462k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f5463l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f5464m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f5465n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final ArrayList f5466o;
    public long p;
    public final n0 q;

    public m(n connectionPool, n0 route) {
        Intrinsics.checkNotNullParameter(connectionPool, "connectionPool");
        Intrinsics.checkNotNullParameter(route, "route");
        this.q = route;
        this.f5465n = 1;
        this.f5466o = new ArrayList();
        this.p = Long.MAX_VALUE;
    }

    public static void d(b0 client, n0 failedRoute, IOException failure) {
        Intrinsics.checkNotNullParameter(client, "client");
        Intrinsics.checkNotNullParameter(failedRoute, "failedRoute");
        Intrinsics.checkNotNullParameter(failure, "failure");
        if (failedRoute.f4618b.type() != Proxy.Type.DIRECT) {
            dj.a aVar = failedRoute.f4617a;
            aVar.f4477j.connectFailed(aVar.f4470a.h(), failedRoute.f4618b.address(), failure);
        }
        a8.a aVar2 = client.B;
        synchronized (aVar2) {
            Intrinsics.checkNotNullParameter(failedRoute, "failedRoute");
            ((LinkedHashSet) aVar2.f44b).add(failedRoute);
        }
    }

    @Override // kj.j
    public final synchronized void a(s connection, e0 settings) {
        Intrinsics.checkNotNullParameter(connection, "connection");
        Intrinsics.checkNotNullParameter(settings, "settings");
        this.f5465n = (settings.f6908a & 16) != 0 ? settings.f6909b[4] : Integer.MAX_VALUE;
    }

    @Override // kj.j
    public final void b(a0 stream) {
        Intrinsics.checkNotNullParameter(stream, "stream");
        stream.c(kj.c.REFUSED_STREAM, null);
    }

    public final void c(int i8, int i9, int i10, boolean z2, i call) throws Throwable {
        dj.l eventListener = dj.l.f4605d;
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(eventListener, "eventListener");
        if (this.e != null) {
            throw new IllegalStateException("already connected");
        }
        List list = this.q.f4617a.f4472c;
        b bVar = new b(list);
        dj.a aVar = this.q.f4617a;
        if (aVar.f == null) {
            if (!list.contains(dj.j.f)) {
                throw new o(new UnknownServiceException("CLEARTEXT communication not enabled for client"));
            }
            String str = this.q.f4617a.f4470a.e;
            lj.m mVar = lj.m.f7532a;
            if (!lj.m.f7532a.e(str)) {
                throw new o(new UnknownServiceException(h0.a.j("CLEARTEXT communication to ", str, " not permitted by network security policy")));
            }
        } else if (aVar.f4471b.contains(d0.H2_PRIOR_KNOWLEDGE)) {
            throw new o(new UnknownServiceException("H2_PRIOR_KNOWLEDGE cannot be used with HTTPS"));
        }
        o oVar = null;
        while (true) {
            try {
                n0 n0Var = this.q;
                if (n0Var.f4617a.f != null && n0Var.f4618b.type() == Proxy.Type.HTTP) {
                    f(i8, i9, i10, call);
                    if (this.f5455b != null) {
                        break;
                    } else {
                        break;
                    }
                }
                e(i8, i9, call);
                g(bVar, call);
                n0 n0Var2 = this.q;
                InetSocketAddress inetSocketAddress = n0Var2.f4619c;
                Proxy proxy = n0Var2.f4618b;
                Intrinsics.checkNotNullParameter(call, "call");
                Intrinsics.checkNotNullParameter(inetSocketAddress, "inetSocketAddress");
                Intrinsics.checkNotNullParameter(proxy, "proxy");
                break;
            } catch (IOException e) {
                Socket socket = this.f5456c;
                if (socket != null) {
                    ej.b.e(socket);
                }
                Socket socket2 = this.f5455b;
                if (socket2 != null) {
                    ej.b.e(socket2);
                }
                this.f5456c = null;
                this.f5455b = null;
                this.f5458g = null;
                this.f5459h = null;
                this.f5457d = null;
                this.e = null;
                this.f = null;
                this.f5465n = 1;
                n0 n0Var3 = this.q;
                InetSocketAddress inetSocketAddress2 = n0Var3.f4619c;
                Proxy proxy2 = n0Var3.f4618b;
                Intrinsics.checkNotNullParameter(call, "call");
                Intrinsics.checkNotNullParameter(inetSocketAddress2, "inetSocketAddress");
                Intrinsics.checkNotNullParameter(proxy2, "proxy");
                Intrinsics.checkNotNullParameter(e, "ioe");
                if (oVar == null) {
                    oVar = new o(e);
                } else {
                    oVar.addConnectException(e);
                }
                if (!z2) {
                    throw oVar;
                }
                Intrinsics.checkNotNullParameter(e, "e");
                bVar.f5419c = true;
                if (!bVar.f5418b) {
                    throw oVar;
                }
                if (e instanceof ProtocolException) {
                    throw oVar;
                }
                if (e instanceof InterruptedIOException) {
                    throw oVar;
                }
                if ((e instanceof SSLHandshakeException) && (e.getCause() instanceof CertificateException)) {
                    throw oVar;
                }
                if (e instanceof SSLPeerUnverifiedException) {
                    throw oVar;
                }
                if (!(e instanceof SSLException)) {
                    throw oVar;
                }
            }
        }
        n0 n0Var4 = this.q;
        if (n0Var4.f4617a.f != null && n0Var4.f4618b.type() == Proxy.Type.HTTP && this.f5455b == null) {
            throw new o(new ProtocolException("Too many tunnel connections attempted: 21"));
        }
        this.p = System.nanoTime();
    }

    public final void e(int i8, int i9, i call) throws IOException {
        Socket socket;
        int i10;
        n0 n0Var = this.q;
        Proxy proxy = n0Var.f4618b;
        dj.a aVar = n0Var.f4617a;
        Proxy.Type type = proxy.type();
        if (type != null && ((i10 = j.$EnumSwitchMapping$0[type.ordinal()]) == 1 || i10 == 2)) {
            socket = aVar.e.createSocket();
            Intrinsics.checkNotNull(socket);
        } else {
            socket = new Socket(proxy);
        }
        this.f5455b = socket;
        InetSocketAddress inetSocketAddress = this.q.f4619c;
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(inetSocketAddress, "inetSocketAddress");
        Intrinsics.checkNotNullParameter(proxy, "proxy");
        socket.setSoTimeout(i9);
        try {
            lj.m mVar = lj.m.f7532a;
            lj.m mVar2 = lj.m.f7532a;
            InetSocketAddress address = this.q.f4619c;
            mVar2.getClass();
            Intrinsics.checkNotNullParameter(socket, "socket");
            Intrinsics.checkNotNullParameter(address, "address");
            socket.connect(address, i8);
            try {
                this.f5458g = sc.b(sc.f(socket));
                this.f5459h = sc.a(sc.d(socket));
            } catch (NullPointerException e) {
                if (Intrinsics.areEqual(e.getMessage(), "throw with null exception")) {
                    throw new IOException(e);
                }
            }
        } catch (ConnectException e4) {
            ConnectException connectException = new ConnectException("Failed to connect to " + this.q.f4619c);
            connectException.initCause(e4);
            throw connectException;
        }
    }

    public final void f(int i8, int i9, int i10, i iVar) throws IOException {
        r5 r5Var = new r5(1);
        n0 n0Var = this.q;
        u url = n0Var.f4617a.f4470a;
        Intrinsics.checkNotNullParameter(url, "url");
        r5Var.f557b = url;
        r5Var.w("CONNECT", null);
        dj.a aVar = n0Var.f4617a;
        r5Var.v("Host", ej.b.v(aVar.f4470a, true));
        r5Var.v("Proxy-Connection", "Keep-Alive");
        r5Var.v("User-Agent", "okhttp/4.9.2");
        dj.e0 request = r5Var.o();
        dj.r rVar = new dj.r(0);
        Intrinsics.checkNotNullParameter(request, "request");
        d0 protocol = d0.HTTP_1_1;
        Intrinsics.checkNotNullParameter(protocol, "protocol");
        Intrinsics.checkNotNullParameter("Preemptive Authenticate", MessageBank.KEY_MESSAGE);
        l0 l0Var = ej.b.f4966c;
        Intrinsics.checkNotNullParameter("Proxy-Authenticate", "name");
        Intrinsics.checkNotNullParameter("OkHttp-Preemptive", "value");
        Intrinsics.checkNotNullParameter("Proxy-Authenticate", "name");
        Intrinsics.checkNotNullParameter("OkHttp-Preemptive", "value");
        v1.a("Proxy-Authenticate");
        v1.b("OkHttp-Preemptive", "Proxy-Authenticate");
        rVar.e("Proxy-Authenticate");
        rVar.b("Proxy-Authenticate", "OkHttp-Preemptive");
        if (protocol == null) {
            throw new IllegalStateException("protocol == null");
        }
        j0 response = new j0(request, protocol, "Preemptive Authenticate", 407, null, rVar.c(), l0Var, null, null, null, -1L, -1L, null);
        aVar.f4476i.getClass();
        Intrinsics.checkNotNullParameter(response, "response");
        e(i8, i9, iVar);
        String str = "CONNECT " + ej.b.v(request.f4528b, true) + " HTTP/1.1";
        t tVar = this.f5458g;
        Intrinsics.checkNotNull(tVar);
        qj.s sVar = this.f5459h;
        Intrinsics.checkNotNull(sVar);
        jj.g gVar = new jj.g(null, this, tVar, sVar);
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        tVar.f9221a.b().g(i9, timeUnit);
        sVar.f9218a.b().g(i10, timeUnit);
        gVar.k(request.f4530d, str);
        gVar.a();
        i0 i0VarG = gVar.g(false);
        Intrinsics.checkNotNull(i0VarG);
        i0VarG.getClass();
        Intrinsics.checkNotNullParameter(request, "request");
        i0VarG.f4561a = request;
        j0 response2 = i0VarG.a();
        Intrinsics.checkNotNullParameter(response2, "response");
        long jK = ej.b.k(response2);
        if (jK != -1) {
            jj.d dVarJ = gVar.j(jK);
            ej.b.t(dVarJ, Integer.MAX_VALUE, timeUnit);
            dVarJ.close();
        }
        int i11 = response2.f4579d;
        if (i11 == 200) {
            if (!tVar.f9222b.T() || !sVar.f9219b.T()) {
                throw new IOException("TLS tunnel buffered too many bytes!");
            }
        } else {
            if (i11 != 407) {
                throw new IOException(a1.a.o(i11, "Unexpected response code for CONNECT: "));
            }
            aVar.f4476i.getClass();
            Intrinsics.checkNotNullParameter(response2, "response");
            throw new IOException("Failed to authenticate with proxy");
        }
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final void g(b bVar, i call) throws Throwable {
        d0 d0VarA;
        dj.a aVar = this.q.f4617a;
        if (aVar.f == null) {
            List list = aVar.f4471b;
            d0 d0Var = d0.H2_PRIOR_KNOWLEDGE;
            if (!list.contains(d0Var)) {
                this.f5456c = this.f5455b;
                this.e = d0.HTTP_1_1;
                return;
            } else {
                this.f5456c = this.f5455b;
                this.e = d0Var;
                l();
                return;
            }
        }
        Intrinsics.checkNotNullParameter(call, "call");
        dj.a aVar2 = this.q.f4617a;
        SSLSocketFactory sSLSocketFactory = aVar2.f;
        SSLSocket sSLSocket = null;
        String strD = null;
        try {
            Intrinsics.checkNotNull(sSLSocketFactory);
            Socket socket = this.f5455b;
            u uVar = aVar2.f4470a;
            Socket socketCreateSocket = sSLSocketFactory.createSocket(socket, uVar.e, uVar.f, true);
            if (socketCreateSocket == null) {
                throw new NullPointerException("null cannot be cast to non-null type javax.net.ssl.SSLSocket");
            }
            SSLSocket sSLSocket2 = (SSLSocket) socketCreateSocket;
            try {
                dj.j jVarA = bVar.a(sSLSocket2);
                if (jVarA.f4573b) {
                    lj.m mVar = lj.m.f7532a;
                    lj.m.f7532a.c(sSLSocket2, aVar2.f4470a.e, aVar2.f4471b);
                }
                sSLSocket2.startHandshake();
                SSLSession sslSocketSession = sSLSocket2.getSession();
                Intrinsics.checkNotNullExpressionValue(sslSocketSession, "sslSocketSession");
                dj.q qVarA = u1.a(sslSocketSession);
                HostnameVerifier hostnameVerifier = aVar2.f4474g;
                Intrinsics.checkNotNull(hostnameVerifier);
                if (hostnameVerifier.verify(aVar2.f4470a.e, sslSocketSession)) {
                    dj.f fVar = aVar2.f4475h;
                    Intrinsics.checkNotNull(fVar);
                    this.f5457d = new dj.q(qVarA.f4621b, qVarA.f4622c, qVarA.f4623d, new k(fVar, qVarA, aVar2));
                    fVar.a(aVar2.f4470a.e, new l(this));
                    if (jVarA.f4573b) {
                        lj.m mVar2 = lj.m.f7532a;
                        strD = lj.m.f7532a.d(sSLSocket2);
                    }
                    this.f5456c = sSLSocket2;
                    this.f5458g = sc.b(sc.f(sSLSocket2));
                    this.f5459h = sc.a(sc.d(sSLSocket2));
                    if (strD != null) {
                        d0.Companion.getClass();
                        d0VarA = c0.a(strD);
                    } else {
                        d0VarA = d0.HTTP_1_1;
                    }
                    this.e = d0VarA;
                    lj.m mVar3 = lj.m.f7532a;
                    lj.m.f7532a.a(sSLSocket2);
                    Intrinsics.checkNotNullParameter(call, "call");
                    if (this.e == d0.HTTP_2) {
                        l();
                        return;
                    }
                    return;
                }
                List listA = qVarA.a();
                if (listA.isEmpty()) {
                    throw new SSLPeerUnverifiedException("Hostname " + aVar2.f4470a.e + " not verified (no certificates)");
                }
                Object obj = listA.get(0);
                if (obj == null) {
                    throw new NullPointerException("null cannot be cast to non-null type java.security.cert.X509Certificate");
                }
                X509Certificate certificate = (X509Certificate) obj;
                StringBuilder sb2 = new StringBuilder("\n              |Hostname ");
                sb2.append(aVar2.f4470a.e);
                sb2.append(" not verified:\n              |    certificate: ");
                dj.f fVar2 = dj.f.f4531c;
                sb2.append(s1.a(certificate));
                sb2.append("\n              |    DN: ");
                Principal subjectDN = certificate.getSubjectDN();
                Intrinsics.checkNotNullExpressionValue(subjectDN, "cert.subjectDN");
                sb2.append(subjectDN.getName());
                sb2.append("\n              |    subjectAltNames: ");
                Intrinsics.checkNotNullParameter(certificate, "certificate");
                sb2.append(CollectionsKt.plus((Collection) pj.c.a(certificate, 7), (Iterable) pj.c.a(certificate, 2)));
                sb2.append("\n              ");
                throw new SSLPeerUnverifiedException(StringsKt__IndentKt.trimMargin$default(sb2.toString(), null, 1, null));
            } catch (Throwable th2) {
                th = th2;
                sSLSocket = sSLSocket2;
                if (sSLSocket != null) {
                    lj.m mVar4 = lj.m.f7532a;
                    lj.m.f7532a.a(sSLSocket);
                }
                if (sSLSocket != null) {
                    ej.b.e(sSLSocket);
                }
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:47:0x00b1, code lost:
    
        if (pj.c.c(r0, (java.security.cert.X509Certificate) r10) != false) goto L54;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean h(dj.a r9, java.util.ArrayList r10) {
        /*
            Method dump skipped, instruction units count: 225
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: hj.m.h(dj.a, java.util.ArrayList):boolean");
    }

    public final boolean i(boolean z2) {
        long j8;
        byte[] bArr = ej.b.f4964a;
        long jNanoTime = System.nanoTime();
        Socket socket = this.f5455b;
        Intrinsics.checkNotNull(socket);
        Socket isHealthy = this.f5456c;
        Intrinsics.checkNotNull(isHealthy);
        t source = this.f5458g;
        Intrinsics.checkNotNull(source);
        if (socket.isClosed() || isHealthy.isClosed() || isHealthy.isInputShutdown() || isHealthy.isOutputShutdown()) {
            return false;
        }
        s sVar = this.f;
        if (sVar != null) {
            synchronized (sVar) {
                if (sVar.f6940h) {
                    return false;
                }
                return sVar.p >= sVar.f6947o || jNanoTime < sVar.q;
            }
        }
        synchronized (this) {
            j8 = jNanoTime - this.p;
        }
        if (j8 < 10000000000L || !z2) {
            return true;
        }
        Intrinsics.checkNotNullParameter(isHealthy, "$this$isHealthy");
        Intrinsics.checkNotNullParameter(source, "source");
        try {
            int soTimeout = isHealthy.getSoTimeout();
            try {
                isHealthy.setSoTimeout(1);
                return !source.T();
            } finally {
                isHealthy.setSoTimeout(soTimeout);
            }
        } catch (SocketTimeoutException unused) {
            return true;
        } catch (IOException unused2) {
            return false;
        }
    }

    public final ij.d j(b0 client, ij.f chain) throws SocketException {
        Intrinsics.checkNotNullParameter(client, "client");
        Intrinsics.checkNotNullParameter(chain, "chain");
        Socket socket = this.f5456c;
        Intrinsics.checkNotNull(socket);
        t tVar = this.f5458g;
        Intrinsics.checkNotNull(tVar);
        qj.s sVar = this.f5459h;
        Intrinsics.checkNotNull(sVar);
        s sVar2 = this.f;
        if (sVar2 != null) {
            return new kj.t(client, this, chain, sVar2);
        }
        int i8 = chain.f5882h;
        socket.setSoTimeout(i8);
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        tVar.f9221a.b().g(i8, timeUnit);
        sVar.f9218a.b().g(chain.f5883i, timeUnit);
        return new jj.g(client, this, tVar, sVar);
    }

    public final synchronized void k() {
        this.f5460i = true;
    }

    public final void l() throws SocketException {
        int i8;
        Socket socket = this.f5456c;
        Intrinsics.checkNotNull(socket);
        t source = this.f5458g;
        Intrinsics.checkNotNull(source);
        qj.s sink = this.f5459h;
        Intrinsics.checkNotNull(sink);
        socket.setSoTimeout(0);
        gj.d taskRunner = gj.d.f5219h;
        Intrinsics.checkNotNullParameter(taskRunner, "taskRunner");
        d2.a aVar = new d2.a();
        aVar.f4261h = taskRunner;
        aVar.e = kj.j.f6923a;
        String peerName = this.q.f4617a.f4470a.e;
        Intrinsics.checkNotNullParameter(socket, "socket");
        Intrinsics.checkNotNullParameter(peerName, "peerName");
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(sink, "sink");
        aVar.f4258b = socket;
        aVar.f4257a = ej.b.f4968g + ' ' + peerName;
        aVar.f4259c = source;
        aVar.f4260d = sink;
        Intrinsics.checkNotNullParameter(this, "listener");
        aVar.e = this;
        s sVar = new s(aVar);
        this.f = sVar;
        e0 e0Var = s.B;
        this.f5465n = (e0Var.f6908a & 16) != 0 ? e0Var.f6909b[4] : Integer.MAX_VALUE;
        Intrinsics.checkNotNullParameter(taskRunner, "taskRunner");
        kj.b0 b0Var = sVar.f6954y;
        synchronized (b0Var) {
            try {
                if (b0Var.f6890c) {
                    throw new IOException("closed");
                }
                Logger logger = kj.b0.f6887h;
                if (logger.isLoggable(Level.FINE)) {
                    logger.fine(ej.b.i(">> CONNECTION " + kj.h.f6919a.hex(), new Object[0]));
                }
                b0Var.e.z(kj.h.f6919a);
                b0Var.e.flush();
            } catch (Throwable th2) {
                throw th2;
            }
        }
        kj.b0 b0Var2 = sVar.f6954y;
        e0 settings = sVar.f6948r;
        synchronized (b0Var2) {
            try {
                Intrinsics.checkNotNullParameter(settings, "settings");
                if (b0Var2.f6890c) {
                    throw new IOException("closed");
                }
                b0Var2.c(0, Integer.bitCount(settings.f6908a) * 6, 4, 0);
                int i9 = 0;
                while (i9 < 10) {
                    boolean z2 = true;
                    if (((1 << i9) & settings.f6908a) == 0) {
                        z2 = false;
                    }
                    if (z2) {
                        if (i9 != 4) {
                            i8 = i9 != 7 ? i9 : 4;
                        } else {
                            i8 = 3;
                        }
                        b0Var2.e.h(i8);
                        b0Var2.e.g(settings.f6909b[i9]);
                    }
                    i9++;
                }
                b0Var2.e.flush();
            } catch (Throwable th3) {
                throw th3;
            }
        }
        int iA = sVar.f6948r.a();
        if (iA != 65535) {
            sVar.f6954y.d(0, iA - 65535);
        }
        taskRunner.e().c(new gj.b(0, sVar.f6955z, sVar.f6938c), 0L);
    }

    public final String toString() {
        Object obj;
        StringBuilder sb2 = new StringBuilder("Connection{");
        n0 n0Var = this.q;
        sb2.append(n0Var.f4617a.f4470a.e);
        sb2.append(':');
        sb2.append(n0Var.f4617a.f4470a.f);
        sb2.append(", proxy=");
        sb2.append(n0Var.f4618b);
        sb2.append(" hostAddress=");
        sb2.append(n0Var.f4619c);
        sb2.append(" cipherSuite=");
        dj.q qVar = this.f5457d;
        if (qVar == null || (obj = qVar.f4622c) == null) {
            obj = "none";
        }
        sb2.append(obj);
        sb2.append(" protocol=");
        sb2.append(this.e);
        sb2.append('}');
        return sb2.toString();
    }
}
