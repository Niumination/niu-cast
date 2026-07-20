package i1;

import f1.k3;
import f1.t4;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
@w
@b1.a
@t1.j(containerOf = {"N"})
public class i0<N> extends z<N> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final n<N> f7587a;

    public static class a<N> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final t0<N> f7588a;

        public a(d0<N> graphBuilder) {
            g gVarI = graphBuilder.d().i(v.g());
            gVarI.getClass();
            this.f7588a = new b1(gVarI);
        }

        @t1.a
        public a<N> a(N node) {
            this.f7588a.q(node);
            return this;
        }

        public i0<N> b() {
            return i0.S(this.f7588a);
        }

        @t1.a
        public a<N> c(x<N> endpoints) {
            this.f7588a.C(endpoints);
            return this;
        }

        @t1.a
        public a<N> d(N nodeU, N nodeV) {
            this.f7588a.G(nodeU, nodeV);
            return this;
        }
    }

    public i0(n<N> backingGraph) {
        this.f7587a = backingGraph;
    }

    public static <N> e0<N, f0.a> R(c0<N> graph, N node) {
        c1.v.b bVar = new c1.v.b(f0.a.EDGE_EXISTS);
        return graph.e() ? r.y(node, graph.l(node), bVar) : j1.m(new t4.o(graph.k(node), bVar));
    }

    public static <N> i0<N> S(c0<N> graph) {
        return graph instanceof i0 ? (i0) graph : new i0<>(new f1(d0.g(graph), U(graph), graph.c().size()));
    }

    @Deprecated
    public static <N> i0<N> T(i0<N> graph) {
        graph.getClass();
        return graph;
    }

    public static <N> k3<N, e0<N, f0.a>> U(c0<N> graph) {
        k3.b bVarBuilder = k3.builder();
        for (N n10 : graph.m()) {
            bVarBuilder.i(n10, R(graph, n10));
        }
        return bVarBuilder.d();
    }

    @Override // i1.z
    public n<N> Q() {
        return this.f7587a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // i1.z, i1.n, i1.a1
    public /* bridge */ /* synthetic */ Set a(Object node) {
        return super.a(node);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // i1.z, i1.n, i1.g1
    public /* bridge */ /* synthetic */ Set b(Object node) {
        return super.b(node);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // i1.z, i1.f, i1.a, i1.n
    public /* bridge */ /* synthetic */ boolean d(Object nodeU, Object nodeV) {
        return super.d(nodeU, nodeV);
    }

    @Override // i1.z, i1.n, i1.m1
    public /* bridge */ /* synthetic */ boolean e() {
        return super.e();
    }

    @Override // i1.z, i1.f, i1.a, i1.n
    public /* bridge */ /* synthetic */ boolean f(x endpoints) {
        return super.f(endpoints);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // i1.z, i1.f, i1.a, i1.n
    public /* bridge */ /* synthetic */ int g(Object node) {
        return super.g(node);
    }

    @Override // i1.z, i1.n, i1.m1
    public /* bridge */ /* synthetic */ v h() {
        return super.h();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // i1.z, i1.f, i1.a, i1.n
    public /* bridge */ /* synthetic */ int i(Object node) {
        return super.i(node);
    }

    @Override // i1.z, i1.n, i1.m1
    public /* bridge */ /* synthetic */ boolean j() {
        return super.j();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // i1.z, i1.n, i1.m1
    public /* bridge */ /* synthetic */ Set k(Object node) {
        return super.k(node);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // i1.z, i1.f, i1.a, i1.n
    public /* bridge */ /* synthetic */ Set l(Object node) {
        return super.l(node);
    }

    @Override // i1.z, i1.n, i1.m1
    public /* bridge */ /* synthetic */ Set m() {
        return super.m();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // i1.z, i1.f, i1.a, i1.n
    public /* bridge */ /* synthetic */ int n(Object node) {
        return super.n(node);
    }

    @Override // i1.z, i1.f, i1.a, i1.n
    public v<N> p() {
        return v.g();
    }
}
