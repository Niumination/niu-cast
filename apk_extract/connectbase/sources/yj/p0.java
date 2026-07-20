package yj;

import java.net.InetSocketAddress;
import vj.j2;
import vj.n2;
import vj.r2;

/* JADX INFO: loaded from: classes2.dex */
@vj.t0
public final class p0 extends r2 {
    @Override // vj.r2
    public j2 a(int i10) {
        return m0.O(i10);
    }

    @Override // vj.r2
    public boolean b() {
        return true;
    }

    @Override // vj.r2
    public r2.a c(int i10, n2 n2Var) {
        z0.h hVarD = z0.d(n2Var);
        String str = hVarD.f21333b;
        return str != null ? r2.a.a(str) : r2.a.d(new m0(new InetSocketAddress(i10), hVarD.f21332a));
    }

    @Override // vj.r2
    public int d() {
        return 5;
    }

    public m0 f(int i10) {
        return m0.O(i10);
    }
}
