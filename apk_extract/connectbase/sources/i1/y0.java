package i1;

import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
@w
public interface y0<N, E> {
    Set<N> a();

    Set<N> b();

    Set<N> c();

    @gm.a
    @t1.a
    N d(E edge, boolean isSelfLoop);

    void e(E edge, N node);

    void f(E edge, N node, boolean isSelfLoop);

    Set<E> g();

    N h(E edge);

    Set<E> i();

    @t1.a
    N j(E edge);

    Set<E> k();

    Set<E> l(N node);
}
