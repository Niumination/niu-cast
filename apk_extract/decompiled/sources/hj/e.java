package hj;

import dj.n0;
import dj.u;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.NoSuchElementException;
import kj.f0;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public p f5431a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public r f5432b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f5433c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f5434d;
    public int e;
    public n0 f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final n f5435g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final dj.a f5436h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final i f5437i;

    public e(n connectionPool, dj.a address, i call) {
        dj.l eventListener = dj.l.f4605d;
        Intrinsics.checkNotNullParameter(connectionPool, "connectionPool");
        Intrinsics.checkNotNullParameter(address, "address");
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(eventListener, "eventListener");
        this.f5435g = connectionPool;
        this.f5436h = address;
        this.f5437i = call;
    }

    /* JADX WARN: Code duplicated, block: B:116:0x027d  */
    /* JADX WARN: Code duplicated, block: B:119:0x029b  */
    /* JADX WARN: Code duplicated, block: B:121:0x02a7  */
    /* JADX WARN: Code duplicated, block: B:122:0x02bc  */
    /* JADX WARN: Code duplicated, block: B:124:0x02c2  */
    /* JADX WARN: Code duplicated, block: B:133:0x030c  */
    /* JADX WARN: Code duplicated, block: B:134:0x032c  */
    /* JADX WARN: Code duplicated, block: B:175:0x032d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:179:0x02f3 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:189:0x00b2 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:190:0x03ab A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:191:0x0257 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:196:0x03a3 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:197:0x039d A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:32:0x006a  */
    /* JADX WARN: Code duplicated, block: B:33:0x007e  */
    /* JADX WARN: Code duplicated, block: B:35:0x0082  */
    /* JADX WARN: Code duplicated, block: B:37:0x008a  */
    /* JADX WARN: Code duplicated, block: B:39:0x008e  */
    /* JADX WARN: Code duplicated, block: B:41:0x0097  */
    /* JADX WARN: Code duplicated, block: B:43:0x00a2  */
    /* JADX WARN: Code duplicated, block: B:48:0x00bc  */
    /* JADX WARN: Code duplicated, block: B:51:0x00d1  */
    /* JADX WARN: Code duplicated, block: B:54:0x00e0  */
    /* JADX WARN: Code duplicated, block: B:56:0x00ea  */
    /* JADX WARN: Code duplicated, block: B:57:0x00ec  */
    /* JADX WARN: Code duplicated, block: B:60:0x00f3  */
    /* JADX WARN: Code duplicated, block: B:74:0x0162  */
    public final m a(int i8, int i9, int i10, boolean z2, boolean z3) throws IOException {
        n0 route;
        p pVar;
        r rVar;
        ArrayList routes;
        p pVar2;
        boolean z5;
        dj.a aVar;
        Proxy proxy;
        String hostName;
        int port;
        boolean zContains;
        p pVar3;
        a8.a aVar2;
        Socket socketJ;
        while (!this.f5437i.f5452m) {
            m connection = this.f5437i.f5447h;
            if (connection != null) {
                synchronized (connection) {
                    try {
                        socketJ = (connection.f5460i || !b(connection.q.f4617a.f4470a)) ? this.f5437i.j() : null;
                        Unit unit = Unit.INSTANCE;
                    } catch (Throwable th2) {
                        throw th2;
                    }
                }
                if (this.f5437i.f5447h == null) {
                    if (socketJ != null) {
                        ej.b.e(socketJ);
                    }
                    Intrinsics.checkNotNullParameter(this.f5437i, "call");
                    Intrinsics.checkNotNullParameter(connection, "connection");
                    this.f5433c = 0;
                    this.f5434d = 0;
                    this.e = 0;
                    if (this.f5435g.a(this.f5436h, this.f5437i, null, false)) {
                        connection = this.f5437i.f5447h;
                        Intrinsics.checkNotNull(connection);
                        Intrinsics.checkNotNullParameter(this.f5437i, "call");
                        Intrinsics.checkNotNullParameter(connection, "connection");
                    } else {
                        route = this.f;
                        try {
                            if (route != null) {
                                Intrinsics.checkNotNull(route);
                                this.f = null;
                            } else {
                                pVar = this.f5431a;
                                if (pVar != null) {
                                    Intrinsics.checkNotNull(pVar);
                                    if (pVar.a()) {
                                        pVar3 = this.f5431a;
                                        Intrinsics.checkNotNull(pVar3);
                                        if (pVar3.a()) {
                                            throw new NoSuchElementException();
                                        }
                                        int i11 = pVar3.f5472b;
                                        pVar3.f5472b = i11 + 1;
                                        route = (n0) pVar3.f5471a.get(i11);
                                    }
                                }
                                rVar = this.f5432b;
                                if (rVar == null) {
                                    dj.a aVar3 = this.f5436h;
                                    i iVar = this.f5437i;
                                    rVar = new r(aVar3, iVar.p.B, iVar);
                                    this.f5432b = rVar;
                                }
                                if (rVar.a()) {
                                    throw new NoSuchElementException();
                                }
                                routes = new ArrayList();
                                while (rVar.f5474b < rVar.f5473a.size()) {
                                    if (rVar.f5474b < rVar.f5473a.size()) {
                                        z5 = true;
                                    } else {
                                        z5 = false;
                                    }
                                    aVar = rVar.e;
                                    if (z5) {
                                        throw new SocketException("No route to " + aVar.f4470a.e + "; exhausted proxy configurations: " + rVar.f5473a);
                                    }
                                    List list = rVar.f5473a;
                                    int i12 = rVar.f5474b;
                                    rVar.f5474b = i12 + 1;
                                    proxy = (Proxy) list.get(i12);
                                    ArrayList arrayList = new ArrayList();
                                    rVar.f5475c = arrayList;
                                    if (proxy.type() != Proxy.Type.DIRECT || proxy.type() == Proxy.Type.SOCKS) {
                                        u uVar = aVar.f4470a;
                                        hostName = uVar.e;
                                        port = uVar.f;
                                    } else {
                                        SocketAddress socketAddressAddress = proxy.address();
                                        if (!(socketAddressAddress instanceof InetSocketAddress)) {
                                            throw new IllegalArgumentException(("Proxy.address() is not an InetSocketAddress: " + socketAddressAddress.getClass()).toString());
                                        }
                                        InetSocketAddress socketHost = (InetSocketAddress) socketAddressAddress;
                                        Intrinsics.checkNotNullParameter(socketHost, "$this$socketHost");
                                        InetAddress address = socketHost.getAddress();
                                        if (address != null) {
                                            hostName = address.getHostAddress();
                                            Intrinsics.checkNotNullExpressionValue(hostName, "address.hostAddress");
                                        } else {
                                            hostName = socketHost.getHostName();
                                            Intrinsics.checkNotNullExpressionValue(hostName, "hostName");
                                        }
                                        port = socketHost.getPort();
                                    }
                                    if (1 <= port || 65535 < port) {
                                        throw new SocketException("No route to " + hostName + ':' + port + "; port is out of range");
                                    }
                                    if (proxy.type() == Proxy.Type.SOCKS) {
                                        arrayList.add(InetSocketAddress.createUnresolved(hostName, port));
                                    } else {
                                        i call = rVar.f5477g;
                                        Intrinsics.checkNotNullParameter(call, "call");
                                        Intrinsics.checkNotNullParameter(hostName, "domainName");
                                        aVar.f4473d.getClass();
                                        Intrinsics.checkNotNullParameter(hostName, "hostname");
                                        try {
                                            InetAddress[] allByName = InetAddress.getAllByName(hostName);
                                            Intrinsics.checkNotNullExpressionValue(allByName, "InetAddress.getAllByName(hostname)");
                                            List inetAddressList = ArraysKt.toList(allByName);
                                            if (inetAddressList.isEmpty()) {
                                                throw new UnknownHostException(aVar.f4473d + " returned no addresses for " + hostName);
                                            }
                                            Intrinsics.checkNotNullParameter(call, "call");
                                            Intrinsics.checkNotNullParameter(hostName, "domainName");
                                            Intrinsics.checkNotNullParameter(inetAddressList, "inetAddressList");
                                            Iterator it = inetAddressList.iterator();
                                            while (it.hasNext()) {
                                                arrayList.add(new InetSocketAddress((InetAddress) it.next(), port));
                                            }
                                        } catch (NullPointerException e) {
                                            UnknownHostException unknownHostException = new UnknownHostException(h0.a.i("Broken system behaviour for dns lookup of ", hostName));
                                            unknownHostException.initCause(e);
                                            throw unknownHostException;
                                        }
                                    }
                                    Iterator it2 = rVar.f5475c.iterator();
                                    while (it2.hasNext()) {
                                        n0 route2 = new n0(rVar.e, proxy, (InetSocketAddress) it2.next());
                                        a8.a aVar4 = rVar.f;
                                        synchronized (aVar4) {
                                            Intrinsics.checkNotNullParameter(route2, "route");
                                            zContains = ((LinkedHashSet) aVar4.f44b).contains(route2);
                                        }
                                        if (zContains) {
                                            rVar.f5476d.add(route2);
                                        } else {
                                            routes.add(route2);
                                        }
                                    }
                                    if (!routes.isEmpty()) {
                                        break;
                                    }
                                }
                                if (routes.isEmpty()) {
                                    CollectionsKt__MutableCollectionsKt.addAll(routes, rVar.f5476d);
                                    rVar.f5476d.clear();
                                }
                                Intrinsics.checkNotNullParameter(routes, "routes");
                                pVar2 = new p();
                                pVar2.f5471a = routes;
                                this.f5431a = pVar2;
                                if (!this.f5437i.f5452m) {
                                    throw new IOException("Canceled");
                                }
                                if (this.f5435g.a(this.f5436h, this.f5437i, routes, false)) {
                                    connection = this.f5437i.f5447h;
                                    Intrinsics.checkNotNull(connection);
                                    Intrinsics.checkNotNullParameter(this.f5437i, "call");
                                    Intrinsics.checkNotNullParameter(connection, "connection");
                                } else {
                                    if (pVar2.a()) {
                                        throw new NoSuchElementException();
                                    }
                                    int i13 = pVar2.f5472b;
                                    pVar2.f5472b = i13 + 1;
                                    route = (n0) routes.get(i13);
                                    connection = new m(this.f5435g, route);
                                    this.f5437i.f5454o = connection;
                                    connection.c(i8, i9, i10, z2, this.f5437i);
                                    this.f5437i.f5454o = null;
                                    aVar2 = this.f5437i.p.B;
                                    synchronized (aVar2) {
                                        Intrinsics.checkNotNullParameter(route, "route");
                                        ((LinkedHashSet) aVar2.f44b).remove(route);
                                    }
                                    if (this.f5435g.a(this.f5436h, this.f5437i, routes, true)) {
                                        m connection2 = this.f5437i.f5447h;
                                        Intrinsics.checkNotNull(connection2);
                                        this.f = route;
                                        Socket socket = connection.f5456c;
                                        Intrinsics.checkNotNull(socket);
                                        ej.b.e(socket);
                                        Intrinsics.checkNotNullParameter(this.f5437i, "call");
                                        Intrinsics.checkNotNullParameter(connection2, "connection");
                                        connection = connection2;
                                    } else {
                                        synchronized (connection) {
                                            n nVar = this.f5435g;
                                            nVar.getClass();
                                            Intrinsics.checkNotNullParameter(connection, "connection");
                                            byte[] bArr = ej.b.f4964a;
                                            nVar.f5470d.add(connection);
                                            nVar.f5468b.c(nVar.f5469c, 0L);
                                            this.f5437i.b(connection);
                                            Unit unit2 = Unit.INSTANCE;
                                        }
                                        Intrinsics.checkNotNullParameter(this.f5437i, "call");
                                        Intrinsics.checkNotNullParameter(connection, "connection");
                                    }
                                }
                            }
                            connection.c(i8, i9, i10, z2, this.f5437i);
                            this.f5437i.f5454o = null;
                            aVar2 = this.f5437i.p.B;
                            synchronized (aVar2) {
                                Intrinsics.checkNotNullParameter(route, "route");
                                ((LinkedHashSet) aVar2.f44b).remove(route);
                                if (this.f5435g.a(this.f5436h, this.f5437i, routes, true)) {
                                    m connection3 = this.f5437i.f5447h;
                                    Intrinsics.checkNotNull(connection3);
                                    this.f = route;
                                    Socket socket2 = connection.f5456c;
                                    Intrinsics.checkNotNull(socket2);
                                    ej.b.e(socket2);
                                    Intrinsics.checkNotNullParameter(this.f5437i, "call");
                                    Intrinsics.checkNotNullParameter(connection3, "connection");
                                    connection = connection3;
                                } else {
                                    synchronized (connection) {
                                        n nVar2 = this.f5435g;
                                        nVar2.getClass();
                                        Intrinsics.checkNotNullParameter(connection, "connection");
                                        byte[] bArr2 = ej.b.f4964a;
                                        nVar2.f5470d.add(connection);
                                        nVar2.f5468b.c(nVar2.f5469c, 0L);
                                        this.f5437i.b(connection);
                                        Unit unit3 = Unit.INSTANCE;
                                        Intrinsics.checkNotNullParameter(this.f5437i, "call");
                                        Intrinsics.checkNotNullParameter(connection, "connection");
                                    }
                                }
                            }
                        } catch (Throwable th3) {
                            this.f5437i.f5454o = null;
                            throw th3;
                        }
                        routes = null;
                        connection = new m(this.f5435g, route);
                        this.f5437i.f5454o = connection;
                    }
                } else if (socketJ != null) {
                    throw new IllegalStateException("Check failed.");
                }
            } else {
                this.f5433c = 0;
                this.f5434d = 0;
                this.e = 0;
                if (this.f5435g.a(this.f5436h, this.f5437i, null, false)) {
                    connection = this.f5437i.f5447h;
                    Intrinsics.checkNotNull(connection);
                    Intrinsics.checkNotNullParameter(this.f5437i, "call");
                    Intrinsics.checkNotNullParameter(connection, "connection");
                } else {
                    route = this.f;
                    if (route != null) {
                        Intrinsics.checkNotNull(route);
                        this.f = null;
                    } else {
                        pVar = this.f5431a;
                        if (pVar != null) {
                            Intrinsics.checkNotNull(pVar);
                            if (pVar.a()) {
                                pVar3 = this.f5431a;
                                Intrinsics.checkNotNull(pVar3);
                                if (pVar3.a()) {
                                    throw new NoSuchElementException();
                                }
                                int i14 = pVar3.f5472b;
                                pVar3.f5472b = i14 + 1;
                                route = (n0) pVar3.f5471a.get(i14);
                            }
                        }
                        rVar = this.f5432b;
                        if (rVar == null) {
                            dj.a aVar5 = this.f5436h;
                            i iVar2 = this.f5437i;
                            rVar = new r(aVar5, iVar2.p.B, iVar2);
                            this.f5432b = rVar;
                        }
                        if (rVar.a()) {
                            throw new NoSuchElementException();
                        }
                        routes = new ArrayList();
                        while (rVar.f5474b < rVar.f5473a.size()) {
                            if (rVar.f5474b < rVar.f5473a.size()) {
                                z5 = true;
                            } else {
                                z5 = false;
                            }
                            aVar = rVar.e;
                            if (z5) {
                                throw new SocketException("No route to " + aVar.f4470a.e + "; exhausted proxy configurations: " + rVar.f5473a);
                            }
                            List list2 = rVar.f5473a;
                            int i15 = rVar.f5474b;
                            rVar.f5474b = i15 + 1;
                            proxy = (Proxy) list2.get(i15);
                            ArrayList arrayList2 = new ArrayList();
                            rVar.f5475c = arrayList2;
                            if (proxy.type() != Proxy.Type.DIRECT) {
                                u uVar2 = aVar.f4470a;
                                hostName = uVar2.e;
                                port = uVar2.f;
                            } else {
                                u uVar3 = aVar.f4470a;
                                hostName = uVar3.e;
                                port = uVar3.f;
                            }
                            if (1 <= port) {
                            }
                            throw new SocketException("No route to " + hostName + ':' + port + "; port is out of range");
                        }
                        if (routes.isEmpty()) {
                            CollectionsKt__MutableCollectionsKt.addAll(routes, rVar.f5476d);
                            rVar.f5476d.clear();
                        }
                        Intrinsics.checkNotNullParameter(routes, "routes");
                        pVar2 = new p();
                        pVar2.f5471a = routes;
                        this.f5431a = pVar2;
                        if (!this.f5437i.f5452m) {
                            throw new IOException("Canceled");
                        }
                        if (this.f5435g.a(this.f5436h, this.f5437i, routes, false)) {
                            connection = this.f5437i.f5447h;
                            Intrinsics.checkNotNull(connection);
                            Intrinsics.checkNotNullParameter(this.f5437i, "call");
                            Intrinsics.checkNotNullParameter(connection, "connection");
                        } else {
                            if (pVar2.a()) {
                                throw new NoSuchElementException();
                            }
                            int i16 = pVar2.f5472b;
                            pVar2.f5472b = i16 + 1;
                            route = (n0) routes.get(i16);
                            connection = new m(this.f5435g, route);
                            this.f5437i.f5454o = connection;
                            connection.c(i8, i9, i10, z2, this.f5437i);
                            this.f5437i.f5454o = null;
                            aVar2 = this.f5437i.p.B;
                            synchronized (aVar2) {
                                Intrinsics.checkNotNullParameter(route, "route");
                                ((LinkedHashSet) aVar2.f44b).remove(route);
                                if (this.f5435g.a(this.f5436h, this.f5437i, routes, true)) {
                                    m connection4 = this.f5437i.f5447h;
                                    Intrinsics.checkNotNull(connection4);
                                    this.f = route;
                                    Socket socket3 = connection.f5456c;
                                    Intrinsics.checkNotNull(socket3);
                                    ej.b.e(socket3);
                                    Intrinsics.checkNotNullParameter(this.f5437i, "call");
                                    Intrinsics.checkNotNullParameter(connection4, "connection");
                                    connection = connection4;
                                } else {
                                    synchronized (connection) {
                                        n nVar3 = this.f5435g;
                                        nVar3.getClass();
                                        Intrinsics.checkNotNullParameter(connection, "connection");
                                        byte[] bArr3 = ej.b.f4964a;
                                        nVar3.f5470d.add(connection);
                                        nVar3.f5468b.c(nVar3.f5469c, 0L);
                                        this.f5437i.b(connection);
                                        Unit unit4 = Unit.INSTANCE;
                                        Intrinsics.checkNotNullParameter(this.f5437i, "call");
                                        Intrinsics.checkNotNullParameter(connection, "connection");
                                    }
                                }
                            }
                        }
                    }
                    routes = null;
                    connection = new m(this.f5435g, route);
                    this.f5437i.f5454o = connection;
                    connection.c(i8, i9, i10, z2, this.f5437i);
                    this.f5437i.f5454o = null;
                    aVar2 = this.f5437i.p.B;
                    synchronized (aVar2) {
                        Intrinsics.checkNotNullParameter(route, "route");
                        ((LinkedHashSet) aVar2.f44b).remove(route);
                        if (this.f5435g.a(this.f5436h, this.f5437i, routes, true)) {
                            m connection5 = this.f5437i.f5447h;
                            Intrinsics.checkNotNull(connection5);
                            this.f = route;
                            Socket socket4 = connection.f5456c;
                            Intrinsics.checkNotNull(socket4);
                            ej.b.e(socket4);
                            Intrinsics.checkNotNullParameter(this.f5437i, "call");
                            Intrinsics.checkNotNullParameter(connection5, "connection");
                            connection = connection5;
                        } else {
                            synchronized (connection) {
                                n nVar4 = this.f5435g;
                                nVar4.getClass();
                                Intrinsics.checkNotNullParameter(connection, "connection");
                                byte[] bArr4 = ej.b.f4964a;
                                nVar4.f5470d.add(connection);
                                nVar4.f5468b.c(nVar4.f5469c, 0L);
                                this.f5437i.b(connection);
                                Unit unit5 = Unit.INSTANCE;
                                Intrinsics.checkNotNullParameter(this.f5437i, "call");
                                Intrinsics.checkNotNullParameter(connection, "connection");
                            }
                        }
                    }
                }
            }
            if (connection.i(z3)) {
                return connection;
            }
            connection.k();
            if (this.f == null) {
                p pVar4 = this.f5431a;
                if (pVar4 != null ? pVar4.a() : true) {
                    continue;
                } else {
                    r rVar2 = this.f5432b;
                    if (!(rVar2 != null ? rVar2.a() : true)) {
                        throw new IOException("exhausted all routes");
                    }
                }
            }
        }
        throw new IOException("Canceled");
    }

    public final boolean b(u url) {
        Intrinsics.checkNotNullParameter(url, "url");
        u uVar = this.f5436h.f4470a;
        return url.f == uVar.f && Intrinsics.areEqual(url.e, uVar.e);
    }

    public final void c(IOException e) {
        Intrinsics.checkNotNullParameter(e, "e");
        this.f = null;
        if ((e instanceof f0) && ((f0) e).errorCode == kj.c.REFUSED_STREAM) {
            this.f5433c++;
        } else if (e instanceof kj.a) {
            this.f5434d++;
        } else {
            this.e++;
        }
    }
}
