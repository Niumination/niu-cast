package ze;

import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.util.Arrays;
import k3.t8;
import k3.u8;
import k3.v8;

/* JADX INFO: loaded from: classes3.dex */
public final class i0 extends z1 {
    private static final long serialVersionUID = 0;
    private final String password;
    private final SocketAddress proxyAddress;
    private final InetSocketAddress targetAddress;
    private final String username;

    public i0(SocketAddress socketAddress, InetSocketAddress inetSocketAddress, String str, String str2, g0 g0Var) {
        v8.i(socketAddress, "proxyAddress");
        v8.i(inetSocketAddress, "targetAddress");
        if (socketAddress instanceof InetSocketAddress) {
            v8.l("The proxy address %s is not resolved", !((InetSocketAddress) socketAddress).isUnresolved(), socketAddress);
        }
        this.proxyAddress = socketAddress;
        this.targetAddress = inetSocketAddress;
        this.username = str;
        this.password = str2;
    }

    public static h0 newBuilder() {
        return new h0();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof i0)) {
            return false;
        }
        i0 i0Var = (i0) obj;
        return u8.a(this.proxyAddress, i0Var.proxyAddress) && u8.a(this.targetAddress, i0Var.targetAddress) && u8.a(this.username, i0Var.username) && u8.a(this.password, i0Var.password);
    }

    public String getPassword() {
        return this.password;
    }

    public SocketAddress getProxyAddress() {
        return this.proxyAddress;
    }

    public InetSocketAddress getTargetAddress() {
        return this.targetAddress;
    }

    public String getUsername() {
        return this.username;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.proxyAddress, this.targetAddress, this.username, this.password});
    }

    public String toString() {
        o6.a aVarA = t8.a(this);
        aVarA.d(this.proxyAddress, "proxyAddr");
        aVarA.d(this.targetAddress, "targetAddr");
        aVarA.d(this.username, "username");
        aVarA.f("hasPassword", this.password != null);
        return aVarA.toString();
    }
}
