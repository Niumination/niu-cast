package i1;

/* JADX INFO: loaded from: classes.dex */
@w
@b1.a
@t1.f
public final class d0<N> extends g<N> {
    public d0(boolean directed) {
        super(directed);
    }

    public static d0<Object> e() {
        return new d0<>(true);
    }

    public static <N> d0<N> g(c0<N> graph) {
        d0 d0Var = new d0(graph.e());
        d0Var.f7557b = graph.j();
        v<N> vVarH = graph.h();
        vVarH.getClass();
        d0Var.f7558c = vVarH;
        return d0Var.i(graph.p());
    }

    public static d0<Object> k() {
        return new d0<>(false);
    }

    @t1.a
    public d0<N> a(boolean allowsSelfLoops) {
        this.f7557b = allowsSelfLoops;
        return this;
    }

    public <N1 extends N> t0<N1> b() {
        return new b1(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <N1 extends N> d0<N1> c() {
        return this;
    }

    public d0<N> d() {
        d0<N> d0Var = new d0<>(this.f7556a);
        d0Var.f7557b = this.f7557b;
        d0Var.f7558c = this.f7558c;
        d0Var.f7560e = this.f7560e;
        d0Var.f7559d = this.f7559d;
        return d0Var;
    }

    @t1.a
    public d0<N> f(int expectedNodeCount) {
        this.f7560e = c1.c0.of(Integer.valueOf(g0.b(expectedNodeCount)));
        return this;
    }

    public <N1 extends N> i0.a<N1> h() {
        return new i0.a<>(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <N1 extends N> d0<N1> i(v<N1> incidentEdgeOrder) {
        v.b bVar = incidentEdgeOrder.f7654a;
        c1.h0.u(bVar == v.b.UNORDERED || bVar == v.b.STABLE, "The given elementOrder (%s) is unsupported. incidentEdgeOrder() only supports ElementOrder.unordered() and ElementOrder.stable().", incidentEdgeOrder);
        this.f7559d = incidentEdgeOrder;
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <N1 extends N> d0<N1> j(v<N1> nodeOrder) {
        nodeOrder.getClass();
        this.f7558c = nodeOrder;
        return this;
    }
}
