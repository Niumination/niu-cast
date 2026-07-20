package i1;

import f1.h4;
import f1.k6;
import f1.t3;
import f1.t4;
import java.util.AbstractSet;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
@w
@b1.a
public abstract class j<N, E> implements w0<N, E> {

    public class a extends f<N> {

        /* JADX INFO: renamed from: i1.j$a$a, reason: collision with other inner class name */
        public class C0207a extends AbstractSet<x<N>> {
            public C0207a() {
            }

            public final /* synthetic */ x b(Object obj) {
                return j.this.D(obj);
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean contains(@gm.a Object obj) {
                if (!(obj instanceof x)) {
                    return false;
                }
                x<?> xVar = (x) obj;
                return a.this.O(xVar) && a.this.m().contains(xVar.f7658a) && a.this.b((Object) xVar.f7658a).contains(xVar.f7659b);
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
            public Iterator<x<N>> iterator() {
                return h4.c0(j.this.c().iterator(), new c1.t() { // from class: i1.i
                    @Override // c1.t
                    public final Object apply(Object obj) {
                        return this.f7586a.b(obj);
                    }
                });
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public int size() {
                return j.this.c().size();
            }
        }

        public a() {
        }

        @Override // i1.f, i1.a, i1.n
        public Set<x<N>> c() {
            return j.this.y() ? new i1.a.C0206a() : new C0207a();
        }

        @Override // i1.n, i1.m1
        public boolean e() {
            return j.this.e();
        }

        @Override // i1.n, i1.m1
        public v<N> h() {
            return j.this.h();
        }

        @Override // i1.n, i1.m1
        public boolean j() {
            return j.this.j();
        }

        @Override // i1.n, i1.m1
        public Set<N> k(N node) {
            return j.this.k(node);
        }

        @Override // i1.n, i1.m1
        public Set<N> m() {
            return j.this.m();
        }

        @Override // i1.f, i1.a, i1.n
        public v<N> p() {
            return v.i();
        }

        @Override // i1.n, i1.a1
        public Set<N> a(N node) {
            return j.this.a((Object) node);
        }

        @Override // i1.n, i1.g1
        public Set<N> b(N node) {
            return j.this.b((Object) node);
        }
    }

    public class b implements c1.i0<E> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Object f7592a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Object f7593b;

        public b(final Object val$nodePresent, final Object val$nodeToCheck) {
            this.f7592a = val$nodePresent;
            this.f7593b = val$nodeToCheck;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // c1.i0
        public boolean apply(E e10) {
            return j.this.D(e10).a(this.f7592a).equals(this.f7593b);
        }
    }

    public static <N, E> Map<E, x<N>> O(final w0<N, E> network) {
        return new t4.o(network.c(), new c1.t() { // from class: i1.h
            @Override // c1.t
            public final Object apply(Object obj) {
                return network.D(obj);
            }
        });
    }

    @Override // i1.w0
    @gm.a
    public E B(N nodeU, N nodeV) {
        Set<E> setW = w(nodeU, nodeV);
        int size = setW.size();
        if (size == 0) {
            return null;
        }
        if (size == 1) {
            return setW.iterator().next();
        }
        throw new IllegalArgumentException(String.format(f0.f7543i, nodeU, nodeV));
    }

    @Override // i1.w0
    @gm.a
    public E E(x<N> endpoints) {
        Q(endpoints);
        return B(endpoints.f7658a, endpoints.f7659b);
    }

    public final c1.i0<E> N(final N nodePresent, final N nodeToCheck) {
        return new b(nodePresent, nodeToCheck);
    }

    public final boolean P(x<?> endpoints) {
        return endpoints.b() == e();
    }

    public final void Q(x<?> endpoints) {
        endpoints.getClass();
        c1.h0.e(P(endpoints), f0.f7548n);
    }

    @Override // i1.w0
    public boolean d(N nodeU, N nodeV) {
        nodeU.getClass();
        nodeV.getClass();
        return m().contains(nodeU) && b((Object) nodeU).contains(nodeV);
    }

    @Override // i1.w0
    public final boolean equals(@gm.a Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof w0)) {
            return false;
        }
        w0 w0Var = (w0) obj;
        return e() == w0Var.e() && m().equals(w0Var.m()) && O(this).equals(O(w0Var));
    }

    @Override // i1.w0
    public boolean f(x<N> endpoints) {
        endpoints.getClass();
        if (P(endpoints)) {
            return d(endpoints.f7658a, endpoints.f7659b);
        }
        return false;
    }

    @Override // i1.w0
    public int g(N node) {
        return e() ? m1.f.t(J(node).size(), u(node).size()) : m1.f.t(l(node).size(), w(node, node).size());
    }

    @Override // i1.w0
    public final int hashCode() {
        return O(this).hashCode();
    }

    @Override // i1.w0
    public int i(N node) {
        return e() ? u(node).size() : g(node);
    }

    @Override // i1.w0
    public int n(N node) {
        return e() ? J(node).size() : g(node);
    }

    @Override // i1.w0
    public c0<N> t() {
        return new a();
    }

    public String toString() {
        return "isDirected: " + e() + ", allowsParallelEdges: " + y() + ", allowsSelfLoops: " + j() + ", nodes: " + m() + ", edges: " + O(this);
    }

    @Override // i1.w0
    public Set<E> v(E edge) {
        x<N> xVarD = D(edge);
        return k6.f(k6.N(l(xVarD.f7658a), l(xVarD.f7659b)), t3.of((Object) edge));
    }

    @Override // i1.w0
    public Set<E> w(N nodeU, N nodeV) {
        Set<E> setU = u(nodeU);
        Set<E> setJ = J(nodeV);
        return setU.size() <= setJ.size() ? Collections.unmodifiableSet(k6.i(setU, new b(nodeU, nodeV))) : Collections.unmodifiableSet(k6.i(setJ, new b(nodeV, nodeU)));
    }

    @Override // i1.w0
    public Set<E> x(x<N> endpoints) {
        Q(endpoints);
        return w(endpoints.f7658a, endpoints.f7659b);
    }
}
