package i1;

import f1.b5;
import f1.k3;
import f1.y2;
import java.lang.ref.Reference;
import java.lang.ref.SoftReference;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
@w
public final class k1<N, E> extends k<N, E> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @u1.b
    @gm.a
    public transient Reference<b5<N>> f7601b;

    public class a extends s0<E> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Object f7602c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Map outEdgeToNode, Object targetNode, final Object val$node) {
            super(outEdgeToNode, targetNode);
            this.f7602c = val$node;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return k1.this.n().count(this.f7602c);
        }
    }

    public k1(Map<E, N> incidentEdges) {
        super(incidentEdges);
    }

    @gm.a
    private static <T> T o(@gm.a Reference<T> reference) {
        if (reference == null) {
            return null;
        }
        return reference.get();
    }

    public static <N, E> k1<N, E> p() {
        return new k1<>(new HashMap(2, 1.0f));
    }

    public static <N, E> k1<N, E> q(Map<E, N> incidentEdges) {
        return new k1<>(k3.copyOf((Map) incidentEdges));
    }

    @Override // i1.y0
    public Set<N> c() {
        return Collections.unmodifiableSet(n().elementSet());
    }

    @Override // i1.k, i1.y0
    @gm.a
    public N d(E edge, boolean isSelfLoop) {
        if (isSelfLoop) {
            return null;
        }
        return j(edge);
    }

    @Override // i1.k, i1.y0
    public void e(E edge, N node) {
        super.e(edge, node);
        b5 b5Var = (b5) o(this.f7601b);
        if (b5Var != null) {
            c1.h0.g0(b5Var.add(node));
        }
    }

    @Override // i1.k, i1.y0
    public void f(E edge, N node, boolean isSelfLoop) {
        if (isSelfLoop) {
            return;
        }
        e(edge, node);
    }

    @Override // i1.k, i1.y0
    public N j(E e10) {
        N n10 = (N) super.j(e10);
        b5 b5Var = (b5) o(this.f7601b);
        if (b5Var != null) {
            c1.h0.g0(b5Var.remove(n10));
        }
        return n10;
    }

    @Override // i1.y0
    public Set<E> l(N node) {
        return new a(this.f7598a, node, node);
    }

    public final b5<N> n() {
        b5<N> b5Var = (b5) o(this.f7601b);
        if (b5Var != null) {
            return b5Var;
        }
        y2 y2VarCreate = y2.create(this.f7598a.values());
        this.f7601b = new SoftReference(y2VarCreate);
        return y2VarCreate;
    }
}
