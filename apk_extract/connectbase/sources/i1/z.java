package i1;

import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
@w
public abstract class z<N> extends f<N> {
    @Override // i1.a
    public long N() {
        return Q().c().size();
    }

    public abstract n<N> Q();

    @Override // i1.f, i1.a, i1.n
    public boolean d(N nodeU, N nodeV) {
        return Q().d(nodeU, nodeV);
    }

    @Override // i1.n, i1.m1
    public boolean e() {
        return Q().e();
    }

    @Override // i1.f, i1.a, i1.n
    public boolean f(x<N> endpoints) {
        return Q().f(endpoints);
    }

    @Override // i1.f, i1.a, i1.n
    public int g(N node) {
        return Q().g(node);
    }

    @Override // i1.n, i1.m1
    public v<N> h() {
        return Q().h();
    }

    @Override // i1.f, i1.a, i1.n
    public int i(N node) {
        return Q().i(node);
    }

    @Override // i1.n, i1.m1
    public boolean j() {
        return Q().j();
    }

    @Override // i1.n, i1.m1
    public Set<N> k(N node) {
        return Q().k(node);
    }

    @Override // i1.f, i1.a, i1.n
    public Set<x<N>> l(N node) {
        return Q().l(node);
    }

    @Override // i1.n, i1.m1
    public Set<N> m() {
        return Q().m();
    }

    @Override // i1.f, i1.a, i1.n
    public int n(N node) {
        return Q().n(node);
    }

    @Override // i1.f, i1.a, i1.n
    public v<N> p() {
        return Q().p();
    }

    @Override // i1.n, i1.a1
    public Set<N> a(N node) {
        return Q().a((Object) node);
    }

    @Override // i1.n, i1.g1
    public Set<N> b(N node) {
        return Q().b((Object) node);
    }
}
