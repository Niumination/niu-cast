package i1;

/* JADX INFO: loaded from: classes.dex */
@w
@b1.a
public final class x0<N, E> extends g<N> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f7660f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public v<? super E> f7661g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public c1.c0<Integer> f7662h;

    public x0(boolean directed) {
        super(directed);
        this.f7660f = false;
        this.f7661g = v.d();
        this.f7662h = c1.c0.absent();
    }

    public static x0<Object, Object> e() {
        return new x0<>(true);
    }

    public static <N, E> x0<N, E> i(w0<N, E> w0Var) {
        x0<N, E> x0Var = new x0<>(w0Var.e());
        x0Var.f7660f = w0Var.y();
        x0Var.f7557b = w0Var.j();
        v<N> vVarH = w0Var.h();
        vVarH.getClass();
        x0Var.f7558c = vVarH;
        v<E> vVarH2 = w0Var.H();
        vVarH2.getClass();
        x0Var.f7661g = vVarH2;
        return x0Var;
    }

    public static x0<Object, Object> l() {
        return new x0<>(false);
    }

    @t1.a
    public x0<N, E> a(boolean allowsParallelEdges) {
        this.f7660f = allowsParallelEdges;
        return this;
    }

    @t1.a
    public x0<N, E> b(boolean allowsSelfLoops) {
        this.f7557b = allowsSelfLoops;
        return this;
    }

    public <N1 extends N, E1 extends E> u0<N1, E1> c() {
        return new c1(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <N1 extends N, E1 extends E> x0<N1, E1> d() {
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <E1 extends E> x0<N, E1> f(v<E1> edgeOrder) {
        edgeOrder.getClass();
        this.f7661g = edgeOrder;
        return this;
    }

    @t1.a
    public x0<N, E> g(int expectedEdgeCount) {
        this.f7662h = c1.c0.of(Integer.valueOf(g0.b(expectedEdgeCount)));
        return this;
    }

    @t1.a
    public x0<N, E> h(int expectedNodeCount) {
        this.f7560e = c1.c0.of(Integer.valueOf(g0.b(expectedNodeCount)));
        return this;
    }

    public <N1 extends N, E1 extends E> m0.a<N1, E1> j() {
        return new m0.a<>(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <N1 extends N> x0<N1, E> k(v<N1> nodeOrder) {
        nodeOrder.getClass();
        this.f7558c = nodeOrder;
        return this;
    }
}
