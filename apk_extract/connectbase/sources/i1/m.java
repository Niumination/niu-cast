package i1;

import f1.t4;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
@w
@b1.a
public abstract class m<N, V> extends i1.a<N> implements m1<N, V> {

    public class a extends f<N> {
        public a() {
        }

        @Override // i1.f, i1.a, i1.n
        public Set<x<N>> c() {
            return m.this.c();
        }

        @Override // i1.n, i1.m1
        public boolean e() {
            return m.this.e();
        }

        @Override // i1.f, i1.a, i1.n
        public int g(N node) {
            return m.this.g(node);
        }

        @Override // i1.n, i1.m1
        public v<N> h() {
            return m.this.h();
        }

        @Override // i1.f, i1.a, i1.n
        public int i(N node) {
            return m.this.i(node);
        }

        @Override // i1.n, i1.m1
        public boolean j() {
            return m.this.j();
        }

        @Override // i1.n, i1.m1
        public Set<N> k(N node) {
            return m.this.k(node);
        }

        @Override // i1.n, i1.m1
        public Set<N> m() {
            return m.this.m();
        }

        @Override // i1.f, i1.a, i1.n
        public int n(N node) {
            return m.this.n(node);
        }

        @Override // i1.f, i1.a, i1.n
        public v<N> p() {
            return m.this.p();
        }

        @Override // i1.n, i1.a1
        public Set<N> a(N node) {
            return m.this.a((Object) node);
        }

        @Override // i1.n, i1.g1
        public Set<N> b(N node) {
            return m.this.b((Object) node);
        }
    }

    public static <N, V> Map<x<N>, V> R(final m1<N, V> graph) {
        return new t4.o(graph.c(), new c1.t() { // from class: i1.l
            @Override // c1.t
            public final Object apply(Object obj) {
                return m.S(graph, (x) obj);
            }
        });
    }

    public static Object S(m1 m1Var, x xVar) {
        Object objZ = m1Var.z(xVar.f7658a, xVar.f7659b, null);
        Objects.requireNonNull(objZ);
        return objZ;
    }

    @Override // i1.a, i1.n
    public Set c() {
        return new i1.a.C0206a();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // i1.a, i1.n
    public /* bridge */ /* synthetic */ boolean d(Object nodeU, Object nodeV) {
        return super.d(nodeU, nodeV);
    }

    @Override // i1.m1
    public final boolean equals(@gm.a Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof m1)) {
            return false;
        }
        m1 m1Var = (m1) obj;
        return e() == m1Var.e() && m().equals(m1Var.m()) && R(this).equals(R(m1Var));
    }

    @Override // i1.a, i1.n
    public /* bridge */ /* synthetic */ boolean f(x endpoints) {
        return super.f(endpoints);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // i1.a, i1.n
    public /* bridge */ /* synthetic */ int g(Object node) {
        return super.g(node);
    }

    @Override // i1.m1
    public final int hashCode() {
        return R(this).hashCode();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // i1.a, i1.n
    public /* bridge */ /* synthetic */ int i(Object node) {
        return super.i(node);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // i1.a, i1.n
    public /* bridge */ /* synthetic */ Set l(Object node) {
        return super.l(node);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // i1.a, i1.n
    public /* bridge */ /* synthetic */ int n(Object node) {
        return super.n(node);
    }

    @Override // i1.a, i1.n
    public v p() {
        return v.i();
    }

    @Override // i1.m1
    public c0<N> t() {
        return new a();
    }

    public String toString() {
        return "isDirected: " + e() + ", allowsSelfLoops: " + j() + ", nodes: " + m() + ", edges: " + R(this);
    }
}
