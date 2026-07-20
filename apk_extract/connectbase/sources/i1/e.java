package i1;

import f1.h4;
import f1.k6;
import f1.p1;
import f1.x7;
import java.util.AbstractSet;
import java.util.Collections;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
@w
public abstract class e<N, E> implements y0<N, E> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<E, N> f7524a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<E, N> f7525b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f7526c;

    public class a extends AbstractSet<E> {
        public a() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public x7<E> iterator() {
            e eVar = e.this;
            return h4.f0((eVar.f7526c == 0 ? p1.g(eVar.f7524a.keySet(), e.this.f7525b.keySet()) : k6.N(eVar.f7524a.keySet(), e.this.f7525b.keySet())).iterator());
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(@gm.a Object obj) {
            return e.this.f7524a.containsKey(obj) || e.this.f7525b.containsKey(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return m1.f.t(e.this.f7524a.size(), e.this.f7525b.size() - e.this.f7526c);
        }
    }

    public e(Map<E, N> inEdgeMap, Map<E, N> outEdgeMap, int selfLoopCount) {
        inEdgeMap.getClass();
        this.f7524a = inEdgeMap;
        outEdgeMap.getClass();
        this.f7525b = outEdgeMap;
        this.f7526c = g0.b(selfLoopCount);
        c1.h0.g0(selfLoopCount <= inEdgeMap.size() && selfLoopCount <= outEdgeMap.size());
    }

    @Override // i1.y0
    public Set<N> c() {
        return k6.N(b(), a());
    }

    @Override // i1.y0
    public N d(E edge, boolean isSelfLoop) {
        if (isSelfLoop) {
            int i10 = this.f7526c - 1;
            this.f7526c = i10;
            g0.b(i10);
        }
        N nRemove = this.f7524a.remove(edge);
        Objects.requireNonNull(nRemove);
        return nRemove;
    }

    @Override // i1.y0
    public void e(E edge, N node) {
        edge.getClass();
        node.getClass();
        c1.h0.g0(this.f7525b.put(edge, node) == null);
    }

    @Override // i1.y0
    public void f(E edge, N node, boolean isSelfLoop) {
        edge.getClass();
        node.getClass();
        if (isSelfLoop) {
            int i10 = this.f7526c + 1;
            this.f7526c = i10;
            g0.d(i10);
        }
        c1.h0.g0(this.f7524a.put(edge, node) == null);
    }

    @Override // i1.y0
    public Set<E> g() {
        return new a();
    }

    @Override // i1.y0
    public N h(E edge) {
        N n10 = this.f7525b.get(edge);
        Objects.requireNonNull(n10);
        return n10;
    }

    @Override // i1.y0
    public Set<E> i() {
        return Collections.unmodifiableSet(this.f7524a.keySet());
    }

    @Override // i1.y0
    public N j(E edge) {
        N nRemove = this.f7525b.remove(edge);
        Objects.requireNonNull(nRemove);
        return nRemove;
    }

    @Override // i1.y0
    public Set<E> k() {
        return Collections.unmodifiableSet(this.f7525b.keySet());
    }
}
