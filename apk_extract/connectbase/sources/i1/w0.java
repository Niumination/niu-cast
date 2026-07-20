package i1;

import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
@w
@b1.a
@t1.f("Use NetworkBuilder to create a real instance")
public interface w0<N, E> extends g1<N>, a1<N> {
    @gm.a
    E B(N nodeU, N nodeV);

    x<N> D(E edge);

    @gm.a
    E E(x<N> endpoints);

    v<E> H();

    Set<E> J(N node);

    @Override // i1.a1
    Set<N> a(N node);

    @Override // i1.g1
    Set<N> b(N node);

    Set<E> c();

    boolean d(N nodeU, N nodeV);

    boolean e();

    boolean equals(@gm.a Object object);

    boolean f(x<N> endpoints);

    int g(N node);

    v<N> h();

    int hashCode();

    int i(N node);

    boolean j();

    Set<N> k(N node);

    Set<E> l(N node);

    Set<N> m();

    int n(N node);

    c0<N> t();

    Set<E> u(N node);

    Set<E> v(E edge);

    Set<E> w(N nodeU, N nodeV);

    Set<E> x(x<N> endpoints);

    boolean y();
}
