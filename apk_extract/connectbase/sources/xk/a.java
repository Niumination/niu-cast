package xk;

import fl.t0;
import java.net.SocketAddress;
import kn.l0;
import os.l;
import os.m;
import pl.k;
import pl.n;

/* JADX INFO: loaded from: classes2.dex */
@t0
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @l
    public final k f20281a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @l
    public final n f20282b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @m
    public final SocketAddress f20283c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @m
    public final SocketAddress f20284d;

    public a(@l k kVar, @l n nVar, @m SocketAddress socketAddress, @m SocketAddress socketAddress2) {
        l0.p(kVar, "input");
        l0.p(nVar, "output");
        this.f20281a = kVar;
        this.f20282b = nVar;
        this.f20283c = socketAddress;
        this.f20284d = socketAddress2;
    }

    @l
    public final k a() {
        return this.f20281a;
    }

    @m
    public final SocketAddress b() {
        return this.f20284d;
    }

    @l
    public final n c() {
        return this.f20282b;
    }

    @m
    public final SocketAddress d() {
        return this.f20283c;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @lm.k(level = lm.m.HIDDEN, message = "Specify localAddress as well.")
    public /* synthetic */ a(k kVar, n nVar, SocketAddress socketAddress) {
        this(kVar, nVar, socketAddress, null);
        l0.p(kVar, "input");
        l0.p(nVar, "output");
    }
}
