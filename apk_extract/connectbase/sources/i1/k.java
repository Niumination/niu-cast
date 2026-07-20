package i1;

import java.util.Collections;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
@w
public abstract class k<N, E> implements y0<N, E> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<E, N> f7598a;

    public k(Map<E, N> incidentEdgeMap) {
        incidentEdgeMap.getClass();
        this.f7598a = incidentEdgeMap;
    }

    @Override // i1.y0
    public Set<N> a() {
        return c();
    }

    @Override // i1.y0
    public Set<N> b() {
        return c();
    }

    @Override // i1.y0
    @gm.a
    public N d(E edge, boolean isSelfLoop) {
        if (isSelfLoop) {
            return null;
        }
        return j(edge);
    }

    @Override // i1.y0
    public void e(E edge, N node) {
        c1.h0.g0(this.f7598a.put(edge, node) == null);
    }

    @Override // i1.y0
    public void f(E edge, N node, boolean isSelfLoop) {
        if (isSelfLoop) {
            return;
        }
        e(edge, node);
    }

    @Override // i1.y0
    public Set<E> g() {
        return Collections.unmodifiableSet(this.f7598a.keySet());
    }

    @Override // i1.y0
    public N h(E edge) {
        N n10 = this.f7598a.get(edge);
        Objects.requireNonNull(n10);
        return n10;
    }

    @Override // i1.y0
    public Set<E> i() {
        return g();
    }

    @Override // i1.y0
    public N j(E edge) {
        N nRemove = this.f7598a.remove(edge);
        Objects.requireNonNull(nRemove);
        return nRemove;
    }

    @Override // i1.y0
    public Set<E> k() {
        return g();
    }
}
