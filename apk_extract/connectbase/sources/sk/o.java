package sk;

import java.net.SocketAddress;

/* JADX INFO: loaded from: classes2.dex */
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public final tl.v f15147a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.l
    public final SocketAddress f15148b;

    public o(@os.l tl.v vVar, @os.l SocketAddress socketAddress) {
        kn.l0.p(vVar, "packet");
        kn.l0.p(socketAddress, "address");
        this.f15147a = vVar;
        this.f15148b = socketAddress;
        if (vVar.S0() <= 65535) {
            return;
        }
        throw new IllegalArgumentException(("Datagram size limit exceeded: " + vVar.S0() + " of possible 65535").toString());
    }

    @os.l
    public final SocketAddress a() {
        return this.f15148b;
    }

    @os.l
    public final tl.v b() {
        return this.f15147a;
    }
}
