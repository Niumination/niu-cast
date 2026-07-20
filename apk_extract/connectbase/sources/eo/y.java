package eo;

import java.util.Collection;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public interface y extends b {

    public interface a<D extends y> {
        @os.l
        a<D> a();

        @os.l
        a<D> b(@os.l e0 e0Var);

        @os.m
        D build();

        @os.l
        a<D> c(@os.l List<h1> list);

        @os.l
        a<D> d();

        @os.l
        a<D> e(@os.m b bVar);

        @os.l
        a<D> f();

        @os.l
        a<D> g(@os.m w0 w0Var);

        @os.l
        <V> a<D> h(@os.l eo.a.InterfaceC0106a<V> interfaceC0106a, V v10);

        @os.l
        a<D> i();

        @os.l
        a<D> j(@os.m w0 w0Var);

        @os.l
        a<D> k(@os.l fo.g gVar);

        @os.l
        a<D> l(@os.l u uVar);

        @os.l
        a<D> m(boolean z10);

        @os.l
        a<D> n(@os.l m mVar);

        @os.l
        a<D> o(@os.l List<e1> list);

        @os.l
        a<D> p(@os.l b.a aVar);

        @os.l
        a<D> q(@os.l vp.f0 f0Var);

        @os.l
        a<D> r(@os.l dp.f fVar);

        @os.l
        a<D> s(@os.l vp.f1 f1Var);

        @os.l
        a<D> t();
    }

    boolean A0();

    boolean D();

    @Override // eo.b, eo.a, eo.m
    @os.l
    y a();

    @Override // eo.n, eo.m
    @os.l
    m b();

    @os.m
    y c(@os.l vp.h1 h1Var);

    @Override // eo.b, eo.a
    @os.l
    Collection<? extends y> d();

    boolean isInfix();

    boolean isInline();

    boolean isOperator();

    boolean isSuspend();

    @os.m
    y q0();

    @os.l
    a<? extends y> w();

    boolean y0();
}
