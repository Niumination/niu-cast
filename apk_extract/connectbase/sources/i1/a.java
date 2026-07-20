package i1;

import f1.h4;
import f1.k6;
import f1.t3;
import f1.x7;
import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
@w
public abstract class a<N> implements n<N> {

    /* JADX INFO: renamed from: i1.a$a, reason: collision with other inner class name */
    public class C0206a extends AbstractSet<x<N>> {
        public C0206a() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public x7<x<N>> iterator() {
            return y.e(a.this);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(@gm.a Object obj) {
            if (!(obj instanceof x)) {
                return false;
            }
            x<?> xVar = (x) obj;
            return a.this.O(xVar) && a.this.m().contains(xVar.f7658a) && a.this.b((Object) xVar.f7658a).contains(xVar.f7659b);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(@gm.a Object o10) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return o1.l.z(a.this.N());
        }
    }

    public class b extends p0<N> {
        public b(final a this$0, n graph, Object node) {
            super(graph, node);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public x7<x<N>> iterator() {
            return this.f7614b.e() ? h4.f0(h4.j(h4.c0(this.f7614b.a((Object) this.f7613a).iterator(), new c1.t() { // from class: i1.b
                @Override // c1.t
                public final Object apply(Object obj) {
                    return this.f7519a.f(obj);
                }
            }), h4.c0(k6.f(this.f7614b.b((Object) this.f7613a), t3.of(this.f7613a)).iterator(), new c1.t() { // from class: i1.c
                @Override // c1.t
                public final Object apply(Object obj) {
                    return this.f7521a.g(obj);
                }
            }))) : h4.f0(h4.c0(this.f7614b.k(this.f7613a).iterator(), new c1.t() { // from class: i1.d
                @Override // c1.t
                public final Object apply(Object obj) {
                    return this.f7522a.i(obj);
                }
            }));
        }

        public final x f(Object obj) {
            return new x.b(obj, this.f7613a);
        }

        public final x g(Object obj) {
            return new x.b(this.f7613a, obj);
        }

        public final x i(Object obj) {
            return new x.c(obj, this.f7613a);
        }
    }

    public long N() {
        Iterator<N> it = m().iterator();
        long jG = 0;
        while (it.hasNext()) {
            jG += (long) g(it.next());
        }
        c1.h0.g0((1 & jG) == 0);
        return jG >>> 1;
    }

    public final boolean O(x<?> endpoints) {
        return endpoints.b() == e();
    }

    public final void P(x<?> endpoints) {
        endpoints.getClass();
        c1.h0.e(O(endpoints), f0.f7548n);
    }

    @Override // i1.n
    public Set<x<N>> c() {
        return new C0206a();
    }

    @Override // i1.n
    public boolean d(N nodeU, N nodeV) {
        nodeU.getClass();
        nodeV.getClass();
        return m().contains(nodeU) && b((Object) nodeU).contains(nodeV);
    }

    @Override // i1.n
    public boolean f(x<N> endpoints) {
        endpoints.getClass();
        if (!O(endpoints)) {
            return false;
        }
        N n10 = endpoints.f7658a;
        return m().contains(n10) && b((Object) n10).contains(endpoints.f7659b);
    }

    @Override // i1.n
    public int g(N node) {
        if (e()) {
            return m1.f.t(a((Object) node).size(), b((Object) node).size());
        }
        Set<N> setK = k(node);
        return m1.f.t(setK.size(), (j() && setK.contains(node)) ? 1 : 0);
    }

    @Override // i1.n
    public int i(N node) {
        return e() ? b((Object) node).size() : g(node);
    }

    @Override // i1.n
    public Set<x<N>> l(N node) {
        node.getClass();
        c1.h0.u(m().contains(node), f0.f7540f, node);
        return new b(this, node);
    }

    @Override // i1.n
    public int n(N node) {
        return e() ? a((Object) node).size() : g(node);
    }

    @Override // i1.n
    public v<N> p() {
        return v.i();
    }
}
