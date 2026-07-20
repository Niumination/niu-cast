package p001if;

import af.v2;
import ze.b1;
import ze.q;
import ze.q2;
import ze.x0;
import ze.y0;

/* JADX INFO: loaded from: classes3.dex */
public final class b extends b1 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ d f5790d;

    public b(d dVar) {
        this.f5790d = dVar;
    }

    @Override // ze.b1
    public final void c(q2 q2Var) {
        this.f5790d.e.m(q.TRANSIENT_FAILURE, new v2(x0.a(q2Var), 1));
    }

    @Override // ze.b1
    public final void d(y0 y0Var) {
        throw new IllegalStateException("GracefulSwitchLoadBalancer must switch to a load balancing policy before handling ResolvedAddresses");
    }

    @Override // ze.b1
    public final void f() {
    }
}
