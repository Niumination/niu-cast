package ml;

import java.net.InetSocketAddress;
import java.net.SocketAddress;
import kn.l0;
import os.l;

/* JADX INFO: loaded from: classes2.dex */
public final class a {
    @l
    public static final SocketAddress a(@l String str, int i10) {
        l0.p(str, "hostname");
        return new InetSocketAddress(str, i10);
    }

    public static /* synthetic */ void b() {
    }

    @l
    public static final String c(@l SocketAddress socketAddress) {
        String hostName;
        l0.p(socketAddress, "<this>");
        InetSocketAddress inetSocketAddress = socketAddress instanceof InetSocketAddress ? (InetSocketAddress) socketAddress : null;
        return (inetSocketAddress == null || (hostName = inetSocketAddress.getHostName()) == null) ? "" : hostName;
    }

    public static final int d(@l SocketAddress socketAddress) {
        l0.p(socketAddress, "<this>");
        InetSocketAddress inetSocketAddress = socketAddress instanceof InetSocketAddress ? (InetSocketAddress) socketAddress : null;
        if (inetSocketAddress == null) {
            return 0;
        }
        return inetSocketAddress.getPort();
    }
}
