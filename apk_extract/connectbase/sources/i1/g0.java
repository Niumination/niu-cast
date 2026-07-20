package i1;

import f1.g4;
import f1.h4;
import f1.t3;
import f1.t4;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
@w
@b1.a
public final class g0 {

    public enum a {
        PENDING,
        COMPLETE
    }

    public static class b<N> extends z<N> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final c0<N> f7562a;

        public class a extends p0<N> {
            public a(n graph, Object node) {
                super(graph, node);
            }

            public final x b(x xVar) {
                return x.g(b.this.Q(), xVar.f7659b, xVar.f7658a);
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
            public Iterator<x<N>> iterator() {
                return h4.c0(b.this.Q().l(this.f7613a).iterator(), new c1.t() { // from class: i1.h0
                    @Override // c1.t
                    public final Object apply(Object obj) {
                        return this.f7567a.b((x) obj);
                    }
                });
            }
        }

        public b(c0<N> graph) {
            this.f7562a = graph;
        }

        @Override // i1.z
        /* JADX INFO: renamed from: S, reason: merged with bridge method [inline-methods] */
        public c0<N> Q() {
            return this.f7562a;
        }

        @Override // i1.z, i1.f, i1.a, i1.n
        public boolean d(N nodeU, N nodeV) {
            return Q().d(nodeV, nodeU);
        }

        @Override // i1.z, i1.f, i1.a, i1.n
        public boolean f(x<N> endpoints) {
            return Q().f(g0.q(endpoints));
        }

        @Override // i1.z, i1.f, i1.a, i1.n
        public int i(N node) {
            return Q().n(node);
        }

        @Override // i1.z, i1.f, i1.a, i1.n
        public Set<x<N>> l(N node) {
            return new a(this, node);
        }

        @Override // i1.z, i1.f, i1.a, i1.n
        public int n(N node) {
            return Q().i(node);
        }

        @Override // i1.z, i1.n, i1.a1
        public Set<N> a(N node) {
            return Q().b((Object) node);
        }

        @Override // i1.z, i1.n, i1.g1
        public Set<N> b(N node) {
            return Q().a((Object) node);
        }
    }

    public static class c<N, E> extends a0<N, E> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final w0<N, E> f7564a;

        public c(w0<N, E> network) {
            this.f7564a = network;
        }

        @Override // i1.a0, i1.j, i1.w0
        @gm.a
        public E B(N nodeU, N nodeV) {
            return R().B(nodeV, nodeU);
        }

        @Override // i1.a0, i1.w0
        public x<N> D(E edge) {
            x<N> xVarD = R().D(edge);
            return x.i(this.f7564a, xVarD.f7659b, xVarD.f7658a);
        }

        @Override // i1.a0, i1.j, i1.w0
        @gm.a
        public E E(x<N> endpoints) {
            return R().E(g0.q(endpoints));
        }

        @Override // i1.a0, i1.w0
        public Set<E> J(N node) {
            return R().u(node);
        }

        @Override // i1.a0
        public w0<N, E> R() {
            return this.f7564a;
        }

        @Override // i1.a0, i1.j, i1.w0
        public boolean d(N nodeU, N nodeV) {
            return R().d(nodeV, nodeU);
        }

        @Override // i1.a0, i1.j, i1.w0
        public boolean f(x<N> endpoints) {
            return R().f(g0.q(endpoints));
        }

        @Override // i1.a0, i1.j, i1.w0
        public int i(N node) {
            return R().n(node);
        }

        @Override // i1.a0, i1.j, i1.w0
        public int n(N node) {
            return R().i(node);
        }

        @Override // i1.a0, i1.w0
        public Set<E> u(N node) {
            return R().J(node);
        }

        @Override // i1.a0, i1.j, i1.w0
        public Set<E> w(N nodeU, N nodeV) {
            return R().w(nodeV, nodeU);
        }

        @Override // i1.a0, i1.j, i1.w0
        public Set<E> x(x<N> endpoints) {
            return R().x(g0.q(endpoints));
        }

        @Override // i1.a0, i1.w0, i1.a1
        public Set<N> a(N node) {
            return R().b((Object) node);
        }

        @Override // i1.a0, i1.w0, i1.g1
        public Set<N> b(N node) {
            return R().a((Object) node);
        }
    }

    public static class d<N, V> extends b0<N, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final m1<N, V> f7565a;

        public d(m1<N, V> graph) {
            this.f7565a = graph;
        }

        @Override // i1.b0, i1.m1
        @gm.a
        public V A(x<N> endpoints, @gm.a V defaultValue) {
            return T().A(g0.q(endpoints), defaultValue);
        }

        @Override // i1.b0
        public m1<N, V> T() {
            return this.f7565a;
        }

        @Override // i1.b0, i1.m, i1.a, i1.n
        public boolean d(N nodeU, N nodeV) {
            return T().d(nodeV, nodeU);
        }

        @Override // i1.b0, i1.m, i1.a, i1.n
        public boolean f(x<N> endpoints) {
            return T().f(g0.q(endpoints));
        }

        @Override // i1.b0, i1.m, i1.a, i1.n
        public int i(N node) {
            return T().n(node);
        }

        @Override // i1.b0, i1.m, i1.a, i1.n
        public int n(N node) {
            return T().i(node);
        }

        @Override // i1.b0, i1.m1
        @gm.a
        public V z(N nodeU, N nodeV, @gm.a V defaultValue) {
            return T().z(nodeV, nodeU, defaultValue);
        }

        @Override // i1.b0, i1.n, i1.a1
        public Set<N> a(N node) {
            return T().b((Object) node);
        }

        @Override // i1.b0, i1.n, i1.g1
        public Set<N> b(N node) {
            return T().a((Object) node);
        }
    }

    public static boolean a(c0<?> graph, Object nextNode, @gm.a Object previousNode) {
        return graph.e() || !c1.b0.a(previousNode, nextNode);
    }

    @t1.a
    public static int b(int value) {
        c1.h0.k(value >= 0, "Not true that %s is non-negative.", value);
        return value;
    }

    @t1.a
    public static long c(long value) {
        c1.h0.p(value >= 0, "Not true that %s is non-negative.", value);
        return value;
    }

    @t1.a
    public static int d(int value) {
        c1.h0.k(value > 0, "Not true that %s is positive.", value);
        return value;
    }

    @t1.a
    public static long e(long value) {
        c1.h0.p(value > 0, "Not true that %s is positive.", value);
        return value;
    }

    public static <N> t0<N> f(c0<N> graph) {
        d0<N> d0VarF = d0.g(graph).f(graph.m().size());
        d0VarF.getClass();
        b1 b1Var = new b1(d0VarF);
        Iterator<N> it = graph.m().iterator();
        while (it.hasNext()) {
            b1Var.q(it.next());
        }
        for (x<N> xVar : graph.c()) {
            b1Var.G(xVar.f7658a, xVar.f7659b);
        }
        return b1Var;
    }

    public static <N, E> u0<N, E> g(w0<N, E> network) {
        x0<N, E> x0VarG = x0.i(network).h(network.m().size()).g(network.c().size());
        x0VarG.getClass();
        c1 c1Var = new c1(x0VarG);
        Iterator<N> it = network.m().iterator();
        while (it.hasNext()) {
            c1Var.q(it.next());
        }
        for (E e10 : network.c()) {
            x<N> xVarD = network.D(e10);
            c1Var.M(xVarD.f7658a, xVarD.f7659b, e10);
        }
        return c1Var;
    }

    public static <N, V> v0<N, V> h(m1<N, V> graph) {
        n1<N, V> n1VarF = n1.g(graph).f(graph.m().size());
        n1VarF.getClass();
        d1 d1Var = new d1(n1VarF);
        Iterator<N> it = graph.m().iterator();
        while (it.hasNext()) {
            d1Var.q(it.next());
        }
        for (x<N> xVar : graph.c()) {
            N n10 = xVar.f7658a;
            N n11 = xVar.f7659b;
            V vZ = graph.z(n10, n11, null);
            Objects.requireNonNull(vZ);
            d1Var.K(n10, n11, vZ);
        }
        return d1Var;
    }

    public static <N> boolean i(c0<N> graph) {
        int size = graph.c().size();
        if (size == 0) {
            return false;
        }
        if (!graph.e() && size >= graph.m().size()) {
            return true;
        }
        HashMap mapA0 = t4.a0(graph.m().size());
        Iterator<N> it = graph.m().iterator();
        while (it.hasNext()) {
            if (o(graph, mapA0, it.next(), null)) {
                return true;
            }
        }
        return false;
    }

    public static boolean j(w0<?, ?> network) {
        if (network.e() || !network.y() || network.c().size() <= network.t().c().size()) {
            return i(network.t());
        }
        return true;
    }

    public static <N> t0<N> k(c0<N> c0Var, Iterable<? extends N> iterable) {
        b1 b1Var;
        if (iterable instanceof Collection) {
            d0<N> d0VarF = d0.g(c0Var).f(((Collection) iterable).size());
            d0VarF.getClass();
            b1Var = new b1(d0VarF);
        } else {
            d0 d0VarG = d0.g(c0Var);
            d0VarG.getClass();
            b1Var = new b1(d0VarG);
        }
        Iterator<? extends N> it = iterable.iterator();
        while (it.hasNext()) {
            b1Var.q(it.next());
        }
        for (N n10 : b1Var.m()) {
            for (N n11 : c0Var.b((Object) n10)) {
                if (b1Var.m().contains(n11)) {
                    b1Var.G(n10, n11);
                }
            }
        }
        return b1Var;
    }

    public static <N, E> u0<N, E> l(w0<N, E> w0Var, Iterable<? extends N> iterable) {
        c1 c1Var;
        if (iterable instanceof Collection) {
            x0<N, E> x0VarH = x0.i(w0Var).h(((Collection) iterable).size());
            x0VarH.getClass();
            c1Var = new c1(x0VarH);
        } else {
            x0 x0VarI = x0.i(w0Var);
            x0VarI.getClass();
            c1Var = new c1(x0VarI);
        }
        Iterator<? extends N> it = iterable.iterator();
        while (it.hasNext()) {
            c1Var.q(it.next());
        }
        for (E e10 : c1Var.m()) {
            for (E e11 : w0Var.u(e10)) {
                N nA = w0Var.D(e11).a(e10);
                if (c1Var.m().contains(nA)) {
                    c1Var.M(e10, nA, e11);
                }
            }
        }
        return c1Var;
    }

    public static <N, V> v0<N, V> m(m1<N, V> m1Var, Iterable<? extends N> iterable) {
        d1 d1Var;
        if (iterable instanceof Collection) {
            n1<N, V> n1VarF = n1.g(m1Var).f(((Collection) iterable).size());
            n1VarF.getClass();
            d1Var = new d1(n1VarF);
        } else {
            n1 n1VarG = n1.g(m1Var);
            n1VarG.getClass();
            d1Var = new d1(n1VarG);
        }
        Iterator<? extends N> it = iterable.iterator();
        while (it.hasNext()) {
            d1Var.q(it.next());
        }
        for (N n10 : d1Var.m()) {
            for (N n11 : m1Var.b((Object) n10)) {
                if (d1Var.m().contains(n11)) {
                    V vZ = m1Var.z(n10, n11, null);
                    Objects.requireNonNull(vZ);
                    d1Var.K(n10, n11, vZ);
                }
            }
        }
        return d1Var;
    }

    public static <N> Set<N> n(c0<N> graph, N node) {
        c1.h0.u(graph.m().contains(node), f0.f7540f, node);
        return t3.copyOf(new h1.a(graph, graph).b(node));
    }

    public static <N> boolean o(c0<N> graph, Map<Object, a> visitedNodes, N node, @gm.a N previousNode) {
        a aVar = visitedNodes.get(node);
        if (aVar == a.COMPLETE) {
            return false;
        }
        a aVar2 = a.PENDING;
        if (aVar == aVar2) {
            return true;
        }
        visitedNodes.put(node, aVar2);
        for (N n10 : graph.b((Object) node)) {
            if (a(graph, n10, previousNode) && o(graph, visitedNodes, n10, node)) {
                return true;
            }
        }
        visitedNodes.put(node, a.COMPLETE);
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <N> c0<N> p(c0<N> c0Var) {
        d0 d0VarG = d0.g(c0Var);
        d0VarG.f7557b = true;
        b1 b1Var = new b1(d0VarG);
        if (c0Var.e()) {
            for (N n10 : c0Var.m()) {
                Iterator it = n(c0Var, n10).iterator();
                while (it.hasNext()) {
                    b1Var.G(n10, it.next());
                }
            }
        } else {
            HashSet hashSet = new HashSet();
            for (N n11 : c0Var.m()) {
                if (!hashSet.contains(n11)) {
                    Set setN = n(c0Var, n11);
                    hashSet.addAll(setN);
                    int i10 = 1;
                    for (Object obj : setN) {
                        int i11 = i10 + 1;
                        Iterator it2 = g4.D(setN, i10).iterator();
                        while (it2.hasNext()) {
                            b1Var.G(obj, it2.next());
                        }
                        i10 = i11;
                    }
                }
            }
        }
        return b1Var;
    }

    public static <N> x<N> q(x<N> endpoints) {
        return endpoints.b() ? new x.b(endpoints.l(), endpoints.k()) : endpoints;
    }

    public static <N> c0<N> r(c0<N> graph) {
        if (graph.e()) {
            return graph instanceof b ? ((b) graph).f7562a : new b(graph);
        }
        return graph;
    }

    public static <N, E> w0<N, E> s(w0<N, E> network) {
        if (network.e()) {
            return network instanceof c ? ((c) network).f7564a : new c(network);
        }
        return network;
    }

    public static <N, V> m1<N, V> t(m1<N, V> graph) {
        if (graph.e()) {
            return graph instanceof d ? ((d) graph).f7565a : new d(graph);
        }
        return graph;
    }
}
