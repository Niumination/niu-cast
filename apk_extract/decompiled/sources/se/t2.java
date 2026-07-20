package se;

import android.util.Log;
import com.welink.protocol.nfbd.NearDevice;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.util.LinkedHashMap;
import java.util.concurrent.ConcurrentHashMap;
import k3.lb;
import k3.yd;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class t2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinkedHashMap f9998a = new LinkedHashMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ d3 f9999b;

    public t2(d3 d3Var) {
        this.f9999b = d3Var;
    }

    public final void a(NearDevice device, Socket socket) {
        String hostAddress = socket.getInetAddress().getHostAddress();
        if (hostAddress != null) {
            this.f9998a.put(hostAddress, socket);
            Intrinsics.checkNotNullParameter(device, "device");
            Intrinsics.checkNotNullParameter(socket, "socket");
            d3 d3Var = this.f9999b;
            d3Var.getClass();
            String hostAddress2 = socket.getInetAddress().getHostAddress();
            String str = null;
            if (hostAddress2 != null) {
                d3Var.f9710i.put(hostAddress2, socket);
                yd ydVar = new yd(d3Var, device, socket, str, 2);
                ConcurrentHashMap concurrentHashMap = we.m.f10734a;
                we.m.a(1792, 50L, d3Var.a(), ydVar);
                return;
            }
            Intrinsics.checkNotNullParameter("NearLanTcpClient", "tag");
            Intrinsics.checkNotNullParameter("remoteIp is null, ignore notifyConnected", "mes");
            if (lb.f6529c >= 1) {
                Log.e("NearLanTcpClient", "TransConnect:remoteIp is null, ignore notifyConnected", null);
            }
        }
    }

    public final void b(NearDevice device, Socket socket) {
        String strS;
        InetAddress inetAddress;
        Intrinsics.checkNotNullParameter(device, "device");
        if (socket == null || (inetAddress = socket.getInetAddress()) == null || (strS = inetAddress.getHostAddress()) == null) {
            strS = device.s();
        }
        if (strS == null) {
            Intrinsics.checkNotNullParameter("NearLanTcpClient", "tag");
            Intrinsics.checkNotNullParameter("remoteIp is null, ignore disconnect", "mes");
            if (lb.f6529c >= 1) {
                Log.e("NearLanTcpClient", "TransConnect:remoteIp is null, ignore disconnect", null);
                return;
            }
            return;
        }
        d3 d3Var = this.f9999b;
        if (socket == null) {
            socket = (Socket) d3Var.f9710i.remove(strS);
        }
        if (socket == null) {
            Intrinsics.checkNotNullParameter("NearLanTcpClient", "tag");
            Intrinsics.checkNotNullParameter("socket is null", "mes");
            if (lb.f6529c >= 1) {
                Log.e("NearLanTcpClient", "TransConnect:socket is null", null);
                return;
            }
            return;
        }
        li.p1 p1Var = (li.p1) d3Var.f9714m.get(strS);
        if (p1Var != null) {
            p1Var.h(null);
        }
        d3Var.f9714m.remove(strS);
        try {
            try {
                socket.close();
                we.h.h("NearLanTcpClient", "disconnect success");
            } catch (IOException e) {
                e.printStackTrace();
                Intrinsics.checkNotNullParameter("NearLanTcpClient", "tag");
                Intrinsics.checkNotNullParameter("disconnect io error", "mes");
                if (lb.f6529c >= 1) {
                    Log.e("NearLanTcpClient", "TransConnect:disconnect io error", e);
                }
            } catch (Exception e4) {
                e4.printStackTrace();
                Intrinsics.checkNotNullParameter("NearLanTcpClient", "tag");
                Intrinsics.checkNotNullParameter("disconnect exception failed", "mes");
                if (lb.f6529c >= 1) {
                    Log.e("NearLanTcpClient", "TransConnect:disconnect exception failed", e4);
                }
            }
        } finally {
            e(device, null, 11);
        }
    }

    public final void c(String str, String str2) {
        we.h.h("TcpHskClient", "Received complete data from ".concat(str));
        byte[] bArrF = i.f(str);
        if (bArrF != null) {
            this.f9999b.n(str, str2, bArrF);
        }
    }

    public final void d(NearDevice nearDevice, Socket socket) {
        String hostAddress = socket.getInetAddress().getHostAddress();
        if (hostAddress != null) {
            LinkedHashMap linkedHashMap = this.f9999b.f9714m;
            String string = hostAddress.toString();
            li.v0 v0Var = li.v0.f7498a;
            si.e eVar = si.e.f10118a;
            linkedHashMap.put(string, li.l0.p(li.h0.a(eVar), eVar, null, new r2(socket, this, nearDevice, null), 2));
        }
    }

    public final void e(NearDevice nearDevice, Socket socket, int i8) {
        String strS;
        InetAddress inetAddress;
        if (socket == null || (inetAddress = socket.getInetAddress()) == null || (strS = inetAddress.getHostAddress()) == null) {
            strS = nearDevice.s();
        }
        if (strS == null) {
            Intrinsics.checkNotNullParameter("NearLanTcpClient", "tag");
            Intrinsics.checkNotNullParameter("remoteIp is null, ignore removeDevice", "mes");
            if (lb.f6529c >= 1) {
                Log.e("NearLanTcpClient", "TransConnect:remoteIp is null, ignore removeDevice", null);
                return;
            }
            return;
        }
        LinkedHashMap linkedHashMap = this.f9998a;
        boolean zContainsKey = linkedHashMap.containsKey(strS);
        d3 d3Var = this.f9999b;
        if (zContainsKey && ((Socket) linkedHashMap.remove(strS)) != null) {
            li.p1 p1Var = (li.p1) d3Var.f9714m.get(strS);
            if (p1Var != null) {
                p1Var.h(null);
            }
            d3Var.f9714m.remove(strS);
        }
        d3Var.o(nearDevice, null, Integer.valueOf(i8));
    }
}
