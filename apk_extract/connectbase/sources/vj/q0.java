package vj;

import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.util.Arrays;

/* JADX INFO: loaded from: classes2.dex */
public final class q0 extends f2 {
    private static final long serialVersionUID = 0;

    @gm.j
    private final String password;
    private final SocketAddress proxyAddress;
    private final InetSocketAddress targetAddress;

    @gm.j
    private final String username;

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public SocketAddress f17243a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public InetSocketAddress f17244b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @gm.j
        public String f17245c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @gm.j
        public String f17246d;

        public b() {
        }

        public q0 a() {
            return new q0(this.f17243a, this.f17244b, this.f17245c, this.f17246d);
        }

        public b b(@gm.j String str) {
            this.f17246d = str;
            return this;
        }

        public b c(SocketAddress socketAddress) {
            this.f17243a = (SocketAddress) c1.h0.F(socketAddress, "proxyAddress");
            return this;
        }

        public b d(InetSocketAddress inetSocketAddress) {
            this.f17244b = (InetSocketAddress) c1.h0.F(inetSocketAddress, "targetAddress");
            return this;
        }

        public b e(@gm.j String str) {
            this.f17245c = str;
            return this;
        }

        public b(a aVar) {
        }
    }

    public static b newBuilder() {
        return new b();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof q0)) {
            return false;
        }
        q0 q0Var = (q0) obj;
        return c1.b0.a(this.proxyAddress, q0Var.proxyAddress) && c1.b0.a(this.targetAddress, q0Var.targetAddress) && c1.b0.a(this.username, q0Var.username) && c1.b0.a(this.password, q0Var.password);
    }

    @gm.j
    public String getPassword() {
        return this.password;
    }

    public SocketAddress getProxyAddress() {
        return this.proxyAddress;
    }

    public InetSocketAddress getTargetAddress() {
        return this.targetAddress;
    }

    @gm.j
    public String getUsername() {
        return this.username;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.proxyAddress, this.targetAddress, this.username, this.password});
    }

    public String toString() {
        return c1.z.c(this).j("proxyAddr", this.proxyAddress).j("targetAddr", this.targetAddress).j("username", this.username).g("hasPassword", this.password != null).toString();
    }

    public q0(SocketAddress socketAddress, InetSocketAddress inetSocketAddress, @gm.j String str, @gm.j String str2) {
        c1.h0.F(socketAddress, "proxyAddress");
        c1.h0.F(inetSocketAddress, "targetAddress");
        if (socketAddress instanceof InetSocketAddress) {
            c1.h0.x0(!((InetSocketAddress) socketAddress).isUnresolved(), "The proxy address %s is not resolved", socketAddress);
        }
        this.proxyAddress = socketAddress;
        this.targetAddress = inetSocketAddress;
        this.username = str;
        this.password = str2;
    }
}
