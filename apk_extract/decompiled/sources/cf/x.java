package cf;

import af.f6;
import af.g6;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.SocketAddress;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.logging.Logger;
import javax.net.ServerSocketFactory;
import k3.v8;

/* JADX INFO: loaded from: classes3.dex */
public final class x {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final Logger f1648l = Logger.getLogger(x.class.getName());

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final InetSocketAddress f1649a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ServerSocketFactory f1650b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final a8.a f1651c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final a8.a f1652d;
    public final d0 e;
    public final ze.o0 f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ServerSocket f1653g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public SocketAddress f1654h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public w f1655i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Executor f1656j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public tj.w f1657k;

    public x(y yVar, List list, ze.o0 o0Var) {
        InetSocketAddress inetSocketAddress = yVar.f1659b;
        v8.i(inetSocketAddress, "listenAddress");
        this.f1649a = inetSocketAddress;
        ServerSocketFactory serverSocketFactory = yVar.f1662g;
        v8.i(serverSocketFactory, "socketFactory");
        this.f1650b = serverSocketFactory;
        a8.a aVar = yVar.e;
        v8.i(aVar, "transportExecutorPool");
        this.f1651c = aVar;
        a8.a aVar2 = yVar.f;
        v8.i(aVar2, "scheduledExecutorServicePool");
        this.f1652d = aVar2;
        this.e = new d0(yVar, list);
        v8.i(o0Var, "channelz");
        this.f = o0Var;
    }

    public final void a(tj.w wVar) throws IOException {
        this.f1657k = wVar;
        ServerSocket serverSocketCreateServerSocket = this.f1650b.createServerSocket();
        try {
            serverSocketCreateServerSocket.bind(this.f1649a);
            this.f1653g = serverSocketCreateServerSocket;
            this.f1654h = serverSocketCreateServerSocket.getLocalSocketAddress();
            this.f1655i = new w(serverSocketCreateServerSocket);
            this.f1656j = (Executor) g6.a((f6) this.f1651c.f44b);
            ze.o0.a(this.f.f11393d, this.f1655i);
            this.f1656j.execute(new a4.c(this, 9));
        } catch (IOException e) {
            serverSocketCreateServerSocket.close();
            throw e;
        }
    }
}
