package yj;

import io.netty.channel.unix.DomainSocketAddress;
import java.net.SocketAddress;
import java.util.Collection;
import java.util.Collections;
import vj.s1;
import vj.t1;
import wj.g3;

/* JADX INFO: loaded from: classes2.dex */
@vj.t0
public final class g1 extends t1 {
    @Override // vj.t1
    public Collection<Class<? extends SocketAddress>> c() {
        return Collections.singleton(DomainSocketAddress.class);
    }

    @Override // vj.t1
    public boolean d() {
        return i1.f21005r != null;
    }

    @Override // vj.t1
    public t1.a e(String str, vj.g gVar) {
        c1.h0.g0(d());
        t1.a aVarE = new g0().e(str, gVar);
        s1<?> s1Var = aVarE.f17265a;
        if (s1Var != null) {
            ((e0) s1Var).W(new g3(i1.f21002o)).R(i1.f21005r, DomainSocketAddress.class);
        }
        return aVarE;
    }

    @Override // vj.t1
    public int f() {
        return 3;
    }

    @Override // vj.t1
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public e0 a(String str, int i10) {
        throw new AssertionError("NettyChannelProvider shadows this implementation");
    }

    @Override // vj.t1
    /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
    public e0 b(String str) {
        throw new AssertionError("NettyChannelProvider shadows this implementation");
    }
}
