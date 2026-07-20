package i1;

import f1.k3;
import f1.t4;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
@w
@b1.a
@t1.j(containerOf = {"N", "V"})
public final class o0<N, V> extends f1<N, V> {

    public static class a<N, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final v0<N, V> f7611a;

        public a(n1<N, V> graphBuilder) {
            g gVarI = graphBuilder.d().i(v.g());
            gVarI.getClass();
            this.f7611a = new d1(gVarI);
        }

        @t1.a
        public a<N, V> a(N node) {
            this.f7611a.q(node);
            return this;
        }

        public o0<N, V> b() {
            return o0.b0(this.f7611a);
        }

        @t1.a
        public a<N, V> c(x<N> endpoints, V value) {
            this.f7611a.L(endpoints, value);
            return this;
        }

        @t1.a
        public a<N, V> d(N nodeU, N nodeV, V value) {
            this.f7611a.K(nodeU, nodeV, value);
            return this;
        }
    }

    public o0(m1<N, V> graph) {
        super(n1.g(graph), c0(graph), graph.c().size());
    }

    public static <N, V> e0<N, V> Z(final m1<N, V> graph, final N node) {
        c1.t tVar = new c1.t() { // from class: i1.n0
            @Override // c1.t
            public final Object apply(Object obj) {
                return o0.d0(graph, node, obj);
            }
        };
        return graph.e() ? r.y(node, graph.l(node), tVar) : j1.m(new t4.o(graph.k(node), tVar));
    }

    @Deprecated
    public static <N, V> o0<N, V> a0(o0<N, V> graph) {
        graph.getClass();
        return graph;
    }

    public static <N, V> o0<N, V> b0(m1<N, V> graph) {
        return graph instanceof o0 ? (o0) graph : new o0<>(graph);
    }

    public static <N, V> k3<N, e0<N, V>> c0(m1<N, V> graph) {
        k3.b bVarBuilder = k3.builder();
        for (N n10 : graph.m()) {
            bVarBuilder.i(n10, Z(graph, n10));
        }
        return bVarBuilder.d();
    }

    public static /* synthetic */ Object d0(m1 m1Var, Object obj, Object obj2) {
        Object objZ = m1Var.z(obj, obj2, null);
        Objects.requireNonNull(objZ);
        return objZ;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // i1.f1, i1.m1
    @gm.a
    public /* bridge */ /* synthetic */ Object A(x endpoints, @gm.a Object defaultValue) {
        return super.A(endpoints, defaultValue);
    }

    public i0<N> Y() {
        return new i0<>(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // i1.f1, i1.n, i1.a1
    public /* bridge */ /* synthetic */ Set a(Object node) {
        return super.a(node);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // i1.f1, i1.n, i1.g1
    public /* bridge */ /* synthetic */ Set b(Object node) {
        return super.b(node);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // i1.f1, i1.m, i1.a, i1.n
    public /* bridge */ /* synthetic */ boolean d(Object nodeU, Object nodeV) {
        return super.d(nodeU, nodeV);
    }

    @Override // i1.f1, i1.n, i1.m1
    public boolean e() {
        return this.f7550a;
    }

    @Override // i1.f1, i1.m, i1.a, i1.n
    public /* bridge */ /* synthetic */ boolean f(x endpoints) {
        return super.f(endpoints);
    }

    @Override // i1.f1, i1.n, i1.m1
    public v h() {
        return this.f7552c;
    }

    @Override // i1.f1, i1.n, i1.m1
    public boolean j() {
        return this.f7551b;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // i1.f1, i1.n, i1.m1
    public /* bridge */ /* synthetic */ Set k(Object node) {
        return super.k(node);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // i1.f1, i1.m, i1.a, i1.n
    public /* bridge */ /* synthetic */ Set l(Object node) {
        return super.l(node);
    }

    @Override // i1.f1, i1.n, i1.m1
    public /* bridge */ /* synthetic */ Set m() {
        return super.m();
    }

    @Override // i1.m, i1.a, i1.n
    public v<N> p() {
        return v.g();
    }

    @Override // i1.m, i1.m1
    public c0 t() {
        return new i0(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // i1.f1, i1.m1
    @gm.a
    public /* bridge */ /* synthetic */ Object z(Object nodeU, Object nodeV, @gm.a Object defaultValue) {
        return super.z(nodeU, nodeV, defaultValue);
    }
}
