package i1;

/* JADX INFO: loaded from: classes.dex */
@w
@b1.a
public final class n1<N, V> extends g<N> {
    public n1(boolean directed) {
        super(directed);
    }

    public static n1<Object, Object> e() {
        return new n1<>(true);
    }

    public static <N, V> n1<N, V> g(m1<N, V> graph) {
        n1 n1Var = new n1(graph.e());
        n1Var.f7557b = graph.j();
        v<N> vVarH = graph.h();
        vVarH.getClass();
        n1Var.f7558c = vVarH;
        return n1Var.i(graph.p());
    }

    public static n1<Object, Object> k() {
        return new n1<>(false);
    }

    @t1.a
    public n1<N, V> a(boolean allowsSelfLoops) {
        this.f7557b = allowsSelfLoops;
        return this;
    }

    public <N1 extends N, V1 extends V> v0<N1, V1> b() {
        return new d1(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <N1 extends N, V1 extends V> n1<N1, V1> c() {
        return this;
    }

    public n1<N, V> d() {
        n1<N, V> n1Var = new n1<>(this.f7556a);
        n1Var.f7557b = this.f7557b;
        n1Var.f7558c = this.f7558c;
        n1Var.f7560e = this.f7560e;
        n1Var.f7559d = this.f7559d;
        return n1Var;
    }

    @t1.a
    public n1<N, V> f(int expectedNodeCount) {
        this.f7560e = c1.c0.of(Integer.valueOf(g0.b(expectedNodeCount)));
        return this;
    }

    public <N1 extends N, V1 extends V> o0.a<N1, V1> h() {
        return new o0.a<>(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <N1 extends N> n1<N1, V> i(v<N1> incidentEdgeOrder) {
        v.b bVar = incidentEdgeOrder.f7654a;
        c1.h0.u(bVar == v.b.UNORDERED || bVar == v.b.STABLE, "The given elementOrder (%s) is unsupported. incidentEdgeOrder() only supports ElementOrder.unordered() and ElementOrder.stable().", incidentEdgeOrder);
        this.f7559d = incidentEdgeOrder;
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <N1 extends N> n1<N1, V> j(v<N1> nodeOrder) {
        nodeOrder.getClass();
        this.f7558c = nodeOrder;
        return this;
    }
}
