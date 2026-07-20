package se;

import android.os.Message;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.LinkedHashMap;

/* JADX INFO: loaded from: classes3.dex */
public final class i3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f9799a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ServerSocket f9800b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final qi.c f9801c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public li.g2 f9802d;
    public final LinkedHashMap e;
    public volatile boolean f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public volatile int f9803g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public volatile int f9804h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final /* synthetic */ com.welink.protocol.nfbd.p f9805i;

    public i3(com.welink.protocol.nfbd.p pVar, int i8) {
        this.f9805i = pVar;
        this.f9799a = i8;
        li.v0 v0Var = li.v0.f7498a;
        this.f9801c = li.h0.a(si.e.f10118a);
        this.e = new LinkedHashMap();
        this.f9803g = i8;
        this.f9804h = i8;
    }

    public static final void a(i3 i3Var, Socket socket) {
        i3Var.getClass();
        String hostAddress = socket.getInetAddress().getHostAddress();
        if (hostAddress != null) {
            LinkedHashMap linkedHashMap = i3Var.e;
            if (linkedHashMap.get(hostAddress) == null) {
                linkedHashMap.put(hostAddress, socket);
                i3Var.f9805i.n(hostAddress);
                return;
            }
        }
        we.h.j("NearLanTcpServer", "Client address already exists: " + hostAddress);
    }

    public static final void e(i3 i3Var, String str, String str2) {
        while (i.h(str)) {
            byte[] bArrE = i.e(str);
            if (bArrE != null && i.a(str, bArrE)) {
                i3Var.l(str, str2);
            }
        }
    }

    public static final void f(i3 i3Var, Socket socket) {
        li.l0.p(i3Var.f9801c, null, null, new f3(socket, i3Var, null), 3);
    }

    public static final void g(i3 i3Var, int i8, int i9) {
        i3Var.f9805i.r(i8, i9);
    }

    public static final void h(i3 i3Var) {
        i3Var.f9803g = i3Var.f9799a;
        i3Var.e.clear();
        com.welink.protocol.nfbd.p pVar = i3Var.f9805i;
        pVar.getClass();
        we.h.h("NearLanTcpServer", "ServerSocket closed");
        Message messageD = pVar.d();
        messageD.what = 24581;
        pVar.i(messageD);
        com.welink.protocol.nfbd.p pVar2 = i3Var.f9805i;
        pVar2.getClass();
        we.h.h("NearLanTcpServer", "Server stopped");
        Message messageD2 = pVar2.d();
        messageD2.what = 24577;
        pVar2.i(messageD2);
    }

    public final void l(String str, String str2) {
        we.h.h("TcpHskServer", "Received complete data from ".concat(str));
        byte[] bArrF = i.f(str);
        if (bArrF != null) {
            this.f9805i.p(str, str2, bArrF);
        }
    }

    public final void m(String str) {
        LinkedHashMap linkedHashMap = this.e;
        if (!linkedHashMap.containsKey(str)) {
            we.h.j("NearLanTcpServer", "Client address not found: ".concat(str));
        } else {
            linkedHashMap.remove(str);
            this.f9805i.o(str, o2.TCP);
        }
    }

    public final void n() {
        if (this.f) {
            this.f = false;
            li.l0.p(this.f9801c, null, null, new h3(this, null), 3);
        }
    }
}
