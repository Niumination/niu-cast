package i1;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/* JADX INFO: loaded from: classes.dex */
@w
public class f1<N, V> extends m<N, V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f7550a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f7551b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final v<N> f7552c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final q0<N, e0<N, V>> f7553d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f7554e;

    public class a extends p0<N> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ e0 f7555c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(final f1 this$0, n graph, Object node, final e0 val$connections) {
            super(graph, node);
            this.f7555c = val$connections;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<x<N>> iterator() {
            return this.f7555c.g(this.f7613a);
        }
    }

    public f1(g<? super N> gVar, Map<N, e0<N, V>> map, long j10) {
        this.f7550a = gVar.f7556a;
        this.f7551b = gVar.f7557b;
        v<? super N> vVar = gVar.f7558c;
        vVar.getClass();
        this.f7552c = vVar;
        this.f7553d = map instanceof TreeMap ? new r0<>(map) : new q0<>(map);
        this.f7554e = g0.c(j10);
    }

    @Override // i1.m1
    @gm.a
    public V A(x<N> endpoints, @gm.a V defaultValue) {
        P(endpoints);
        return V(endpoints.f7658a, endpoints.f7659b, defaultValue);
    }

    @Override // i1.a
    public long N() {
        return this.f7554e;
    }

    public final e0<N, V> T(N node) {
        e0<N, V> e0VarF = this.f7553d.f(node);
        if (e0VarF != null) {
            return e0VarF;
        }
        node.getClass();
        throw new IllegalArgumentException("Node " + node + " is not an element of this graph.");
    }

    public final boolean U(@gm.a N node) {
        return this.f7553d.e(node);
    }

    @gm.a
    public final V V(N nodeU, N nodeV, @gm.a V defaultValue) {
        e0<N, V> e0VarF = this.f7553d.f(nodeU);
        V vD = e0VarF == null ? null : e0VarF.d(nodeV);
        return vD == null ? defaultValue : vD;
    }

    public final boolean W(N nodeU, N nodeV) {
        e0<N, V> e0VarF = this.f7553d.f(nodeU);
        return e0VarF != null && e0VarF.a().contains(nodeV);
    }

    @Override // i1.m, i1.a, i1.n
    public boolean d(N nodeU, N nodeV) {
        nodeU.getClass();
        nodeV.getClass();
        return W(nodeU, nodeV);
    }

    @Override // i1.n, i1.m1
    public boolean e() {
        return this.f7550a;
    }

    @Override // i1.m, i1.a, i1.n
    public boolean f(x<N> endpoints) {
        endpoints.getClass();
        return O(endpoints) && W(endpoints.f7658a, endpoints.f7659b);
    }

    @Override // i1.n, i1.m1
    public v<N> h() {
        return this.f7552c;
    }

    @Override // i1.n, i1.m1
    public boolean j() {
        return this.f7551b;
    }

    @Override // i1.n, i1.m1
    public Set<N> k(N node) {
        return T(node).c();
    }

    @Override // i1.m, i1.a, i1.n
    public Set<x<N>> l(N node) {
        return new a(this, this, node, T(node));
    }

    @Override // i1.n, i1.m1
    public Set<N> m() {
        q0<N, e0<N, V>> q0Var = this.f7553d;
        q0Var.getClass();
        return new q0.a();
    }

    @Override // i1.m1
    @gm.a
    public V z(N nodeU, N nodeV, @gm.a V defaultValue) {
        nodeU.getClass();
        nodeV.getClass();
        return V(nodeU, nodeV, defaultValue);
    }

    @Override // i1.n, i1.a1
    public Set<N> a(N node) {
        return T(node).b();
    }

    @Override // i1.n, i1.g1
    public Set<N> b(N node) {
        return T(node).a();
    }

    public f1(g<? super N> builder) {
        this(builder, builder.f7558c.c(builder.f7560e.or(10).intValue()), 0L);
    }
}
