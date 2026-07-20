package xk;

import java.net.SocketAddress;
import kn.l0;
import nq.s0;
import nq.y;
import os.l;
import os.m;
import pl.k;
import pl.n;
import um.g;

/* JADX INFO: loaded from: classes2.dex */
public final class c implements s0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @l
    public final g f20286a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @l
    public final k f20287b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @l
    public final n f20288c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @m
    public final SocketAddress f20289d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @m
    public final SocketAddress f20290e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @m
    public final y<Boolean> f20291f;

    public c(@l g gVar, @l k kVar, @l n nVar, @m SocketAddress socketAddress, @m SocketAddress socketAddress2, @m y<Boolean> yVar) {
        l0.p(gVar, "coroutineContext");
        l0.p(kVar, "input");
        l0.p(nVar, "output");
        this.f20286a = gVar;
        this.f20287b = kVar;
        this.f20288c = nVar;
        this.f20289d = socketAddress;
        this.f20290e = socketAddress2;
        this.f20291f = yVar;
    }

    @l
    public final k b() {
        return this.f20287b;
    }

    @m
    public final SocketAddress c() {
        return this.f20290e;
    }

    @l
    public final n e() {
        return this.f20288c;
    }

    @m
    public final SocketAddress f() {
        return this.f20289d;
    }

    @m
    public final y<Boolean> g() {
        return this.f20291f;
    }

    @Override // nq.s0
    @l
    public g getCoroutineContext() {
        return this.f20286a;
    }

    @l
    public final c i(@l g gVar) {
        l0.p(gVar, "coroutineContext");
        return new c(this.f20286a.plus(gVar), this.f20287b, this.f20288c, this.f20289d, this.f20290e, this.f20291f);
    }
}
