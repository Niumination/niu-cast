package i1;

import f1.k3;
import f1.t4;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
@w
@b1.a
@t1.j(containerOf = {"N", "E"})
public final class m0<N, E> extends e1<N, E> {

    public static class a<N, E> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final u0<N, E> f7607a;

        public a(x0<N, E> networkBuilder) {
            networkBuilder.getClass();
            this.f7607a = new c1(networkBuilder);
        }

        @t1.a
        public a<N, E> a(x<N> endpoints, E edge) {
            this.f7607a.F(endpoints, edge);
            return this;
        }

        @t1.a
        public a<N, E> b(N nodeU, N nodeV, E edge) {
            this.f7607a.M(nodeU, nodeV, edge);
            return this;
        }

        @t1.a
        public a<N, E> c(N node) {
            this.f7607a.q(node);
            return this;
        }

        public m0<N, E> d() {
            return m0.c0(this.f7607a);
        }
    }

    public m0(w0<N, E> network) {
        super(x0.i(network), e0(network), d0(network));
    }

    public static <N, E> c1.t<E, N> Y(w0<N, E> network, N node) {
        return new k0(network, node);
    }

    public static <N, E> y0<N, E> a0(w0<N, E> network, N node) {
        if (!network.e()) {
            t4.o oVar = new t4.o(network.l(node), new k0(network, node));
            return network.y() ? k1.q(oVar) : l1.n(oVar);
        }
        t4.o oVar2 = new t4.o(network.J(node), new j0(network));
        t4.o oVar3 = new t4.o(network.u(node), new l0(network));
        int size = network.w(node, node).size();
        return network.y() ? s.q(oVar2, oVar3, size) : t.o(oVar2, oVar3, size);
    }

    @Deprecated
    public static <N, E> m0<N, E> b0(m0<N, E> network) {
        network.getClass();
        return network;
    }

    public static <N, E> m0<N, E> c0(w0<N, E> network) {
        return network instanceof m0 ? (m0) network : new m0<>(network);
    }

    public static <N, E> Map<E, N> d0(w0<N, E> network) {
        k3.b bVarBuilder = k3.builder();
        for (E e10 : network.c()) {
            bVarBuilder.i(e10, network.D(e10).f7658a);
        }
        return bVarBuilder.d();
    }

    public static <N, E> Map<N, y0<N, E>> e0(w0<N, E> network) {
        k3.b bVarBuilder = k3.builder();
        for (N n10 : network.m()) {
            bVarBuilder.i(n10, a0(network, n10));
        }
        return bVarBuilder.d();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Object f0(w0 w0Var, Object obj, Object obj2) {
        return w0Var.D(obj2).a(obj);
    }

    public static /* synthetic */ Object g0(w0 w0Var, Object obj) {
        return w0Var.D(obj).k();
    }

    public static /* synthetic */ Object h0(w0 w0Var, Object obj) {
        return w0Var.D(obj).l();
    }

    public static <N, E> c1.t<E, N> i0(w0<N, E> network) {
        return new j0(network);
    }

    public static <N, E> c1.t<E, N> j0(w0<N, E> network) {
        return new l0(network);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // i1.e1, i1.w0
    public /* bridge */ /* synthetic */ x D(Object edge) {
        return super.D(edge);
    }

    @Override // i1.e1, i1.w0
    public v H() {
        return this.f7532e;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // i1.e1, i1.w0
    public /* bridge */ /* synthetic */ Set J(Object node) {
        return super.J(node);
    }

    @Override // i1.j, i1.w0
    /* JADX INFO: renamed from: Z, reason: merged with bridge method [inline-methods] */
    public i0<N> t() {
        return new i0<>(new j.a());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // i1.e1, i1.w0, i1.a1
    public /* bridge */ /* synthetic */ Set a(Object node) {
        return super.a(node);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // i1.e1, i1.w0, i1.g1
    public /* bridge */ /* synthetic */ Set b(Object node) {
        return super.b(node);
    }

    @Override // i1.e1, i1.w0
    public /* bridge */ /* synthetic */ Set c() {
        return super.c();
    }

    @Override // i1.e1, i1.w0
    public boolean e() {
        return this.f7528a;
    }

    @Override // i1.e1, i1.w0
    public v h() {
        return this.f7531d;
    }

    @Override // i1.e1, i1.w0
    public boolean j() {
        return this.f7530c;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // i1.e1, i1.w0
    public /* bridge */ /* synthetic */ Set k(Object node) {
        return super.k(node);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // i1.e1, i1.w0
    public /* bridge */ /* synthetic */ Set l(Object node) {
        return super.l(node);
    }

    @Override // i1.e1, i1.w0
    public /* bridge */ /* synthetic */ Set m() {
        return super.m();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // i1.e1, i1.w0
    public /* bridge */ /* synthetic */ Set u(Object node) {
        return super.u(node);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // i1.e1, i1.j, i1.w0
    public /* bridge */ /* synthetic */ Set w(Object nodeU, Object nodeV) {
        return super.w(nodeU, nodeV);
    }

    @Override // i1.e1, i1.w0
    public boolean y() {
        return this.f7529b;
    }
}
