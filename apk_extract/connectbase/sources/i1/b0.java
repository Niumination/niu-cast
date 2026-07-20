package i1;

import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
@w
public abstract class b0<N, V> extends m<N, V> {
    @Override // i1.m1
    @gm.a
    public V A(x<N> endpoints, @gm.a V defaultValue) {
        return T().A(endpoints, defaultValue);
    }

    @Override // i1.a
    public long N() {
        return T().c().size();
    }

    public abstract m1<N, V> T();

    @Override // i1.m, i1.a, i1.n
    public boolean d(N nodeU, N nodeV) {
        return T().d(nodeU, nodeV);
    }

    @Override // i1.n, i1.m1
    public boolean e() {
        return T().e();
    }

    @Override // i1.m, i1.a, i1.n
    public boolean f(x<N> endpoints) {
        return T().f(endpoints);
    }

    @Override // i1.m, i1.a, i1.n
    public int g(N node) {
        return T().g(node);
    }

    @Override // i1.n, i1.m1
    public v<N> h() {
        return T().h();
    }

    @Override // i1.m, i1.a, i1.n
    public int i(N node) {
        return T().i(node);
    }

    @Override // i1.n, i1.m1
    public boolean j() {
        return T().j();
    }

    @Override // i1.n, i1.m1
    public Set<N> k(N node) {
        return T().k(node);
    }

    @Override // i1.n, i1.m1
    public Set<N> m() {
        return T().m();
    }

    @Override // i1.m, i1.a, i1.n
    public int n(N node) {
        return T().n(node);
    }

    @Override // i1.m, i1.a, i1.n
    public v<N> p() {
        return T().p();
    }

    @Override // i1.m1
    @gm.a
    public V z(N nodeU, N nodeV, @gm.a V defaultValue) {
        return T().z(nodeU, nodeV, defaultValue);
    }

    @Override // i1.n, i1.a1
    public Set<N> a(N node) {
        return T().a((Object) node);
    }

    @Override // i1.n, i1.g1
    public Set<N> b(N node) {
        return T().b((Object) node);
    }
}
