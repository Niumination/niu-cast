package i1;

import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
@w
@b1.a
@t1.f("Use GraphBuilder to create a real instance")
public interface c0<N> extends n<N> {
    @Override // i1.n, i1.a1
    Set<N> a(N node);

    @Override // i1.n, i1.g1
    Set<N> b(N node);

    @Override // i1.n
    Set<x<N>> c();

    @Override // i1.n
    boolean d(N nodeU, N nodeV);

    @Override // i1.n, i1.m1
    boolean e();

    boolean equals(@gm.a Object object);

    @Override // i1.n
    boolean f(x<N> endpoints);

    @Override // i1.n
    int g(N node);

    @Override // i1.n, i1.m1
    v<N> h();

    int hashCode();

    @Override // i1.n
    int i(N node);

    @Override // i1.n, i1.m1
    boolean j();

    @Override // i1.n, i1.m1
    Set<N> k(N node);

    @Override // i1.n
    Set<x<N>> l(N node);

    @Override // i1.n, i1.m1
    Set<N> m();

    @Override // i1.n
    int n(N node);

    @Override // i1.n
    v<N> p();
}
