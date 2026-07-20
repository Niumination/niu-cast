package yj;

import java.net.SocketAddress;
import java.util.Collection;
import vj.s1;
import vj.t1;

/* JADX INFO: loaded from: classes2.dex */
@vj.t0
public final class g0 extends t1 {
    @Override // vj.t1
    public s1 a(String str, int i10) {
        return e0.Y(str, i10);
    }

    @Override // vj.t1
    public s1 b(String str) {
        return e0.c0(str);
    }

    @Override // vj.t1
    public Collection<Class<? extends SocketAddress>> c() {
        return e0.g0();
    }

    @Override // vj.t1
    public boolean d() {
        return true;
    }

    @Override // vj.t1
    public t1.a e(String str, vj.g gVar) {
        z0.g gVarC = z0.c(gVar);
        String str2 = gVarC.f21331c;
        return str2 != null ? t1.a.b(str2) : t1.a.a(new e0(str, gVar, gVarC.f21330b, gVarC.f21329a));
    }

    @Override // vj.t1
    public int f() {
        return 5;
    }

    public e0 h(String str, int i10) {
        return e0.Y(str, i10);
    }

    public e0 i(String str) {
        return e0.c0(str);
    }
}
