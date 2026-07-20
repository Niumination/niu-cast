package i1;

import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
@w
public abstract class a0<N, E> extends j<N, E> {
    @Override // i1.j, i1.w0
    @gm.a
    public E B(N nodeU, N nodeV) {
        return R().B(nodeU, nodeV);
    }

    @Override // i1.w0
    public x<N> D(E edge) {
        return R().D(edge);
    }

    @Override // i1.j, i1.w0
    @gm.a
    public E E(x<N> endpoints) {
        return R().E(endpoints);
    }

    @Override // i1.w0
    public v<E> H() {
        return R().H();
    }

    @Override // i1.w0
    public Set<E> J(N node) {
        return R().J(node);
    }

    public abstract w0<N, E> R();

    @Override // i1.w0
    public Set<E> c() {
        return R().c();
    }

    @Override // i1.j, i1.w0
    public boolean d(N nodeU, N nodeV) {
        return R().d(nodeU, nodeV);
    }

    @Override // i1.w0
    public boolean e() {
        return R().e();
    }

    @Override // i1.j, i1.w0
    public boolean f(x<N> endpoints) {
        return R().f(endpoints);
    }

    @Override // i1.j, i1.w0
    public int g(N node) {
        return R().g(node);
    }

    @Override // i1.w0
    public v<N> h() {
        return R().h();
    }

    @Override // i1.j, i1.w0
    public int i(N node) {
        return R().i(node);
    }

    @Override // i1.w0
    public boolean j() {
        return R().j();
    }

    @Override // i1.w0
    public Set<N> k(N node) {
        return R().k(node);
    }

    @Override // i1.w0
    public Set<E> l(N node) {
        return R().l(node);
    }

    @Override // i1.w0
    public Set<N> m() {
        return R().m();
    }

    @Override // i1.j, i1.w0
    public int n(N node) {
        return R().n(node);
    }

    @Override // i1.w0
    public Set<E> u(N node) {
        return R().u(node);
    }

    @Override // i1.j, i1.w0
    public Set<E> v(E edge) {
        return R().v(edge);
    }

    @Override // i1.j, i1.w0
    public Set<E> w(N nodeU, N nodeV) {
        return R().w(nodeU, nodeV);
    }

    @Override // i1.j, i1.w0
    public Set<E> x(x<N> endpoints) {
        return R().x(endpoints);
    }

    @Override // i1.w0
    public boolean y() {
        return R().y();
    }

    @Override // i1.w0, i1.a1
    public Set<N> a(N node) {
        return R().a((Object) node);
    }

    @Override // i1.w0, i1.g1
    public Set<N> b(N node) {
        return R().b((Object) node);
    }
}
