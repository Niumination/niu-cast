package i1;

import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
@w
@b1.a
public interface m1<N, V> extends n<N> {
    @gm.a
    V A(x<N> endpoints, @gm.a V defaultValue);

    @Override // i1.n, i1.a1
    Set<N> a(N node);

    @Override // i1.n, i1.g1
    Set<N> b(N node);

    @Override // i1.n
    Set<x<N>> c();

    @Override // i1.n
    boolean d(N nodeU, N nodeV);

    boolean e();

    boolean equals(@gm.a Object object);

    @Override // i1.n
    boolean f(x<N> endpoints);

    @Override // i1.n
    int g(N node);

    v<N> h();

    int hashCode();

    @Override // i1.n
    int i(N node);

    boolean j();

    Set<N> k(N node);

    @Override // i1.n
    Set<x<N>> l(N node);

    Set<N> m();

    @Override // i1.n
    int n(N node);

    @Override // i1.n
    v<N> p();

    c0<N> t();

    @gm.a
    V z(N nodeU, N nodeV, @gm.a V defaultValue);
}
