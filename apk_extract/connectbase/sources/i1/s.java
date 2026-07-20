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
public final class s<N, E> extends e<N, E> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @u1.b
    @gm.a
    public transient Reference<b5<N>> f7644d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @u1.b
    @gm.a
    public transient Reference<b5<N>> f7645e;

    public class a extends s0<E> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Object f7646c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Map outEdgeToNode, Object targetNode, final Object val$node) {
            super(outEdgeToNode, targetNode);
            this.f7646c = val$node;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return s.this.s().count(this.f7646c);
        }
    }

    public s(Map<E, N> inEdges, Map<E, N> outEdges, int selfLoopCount) {
        super(inEdges, outEdges, selfLoopCount);
    }

    @gm.a
    public static <T> T o(@gm.a Reference<T> reference) {
        if (reference == null) {
            return null;
        }
        return reference.get();
    }

    public static <N, E> s<N, E> p() {
        return new s<>(new HashMap(2, 1.0f), new HashMap(2, 1.0f), 0);
    }

    public static <N, E> s<N, E> q(Map<E, N> inEdges, Map<E, N> outEdges, int selfLoopCount) {
        return new s<>(k3.copyOf((Map) inEdges), k3.copyOf((Map) outEdges), selfLoopCount);
    }

    @Override // i1.y0
    public Set<N> a() {
        return Collections.unmodifiableSet(s().elementSet());
    }

    @Override // i1.y0
    public Set<N> b() {
        return Collections.unmodifiableSet(r().elementSet());
    }

    @Override // i1.e, i1.y0
    public N d(E e10, boolean z10) {
        N n10 = (N) super.d(e10, z10);
        b5 b5Var = (b5) o(this.f7644d);
        if (b5Var != null) {
            c1.h0.g0(b5Var.remove(n10));
        }
        return n10;
    }

    @Override // i1.e, i1.y0
    public void e(E edge, N node) {
        super.e(edge, node);
        b5 b5Var = (b5) o(this.f7645e);
        if (b5Var != null) {
            c1.h0.g0(b5Var.add(node));
        }
    }

    @Override // i1.e, i1.y0
    public void f(E edge, N node, boolean isSelfLoop) {
        super.f(edge, node, isSelfLoop);
        b5 b5Var = (b5) o(this.f7644d);
        if (b5Var != null) {
            c1.h0.g0(b5Var.add(node));
        }
    }

    @Override // i1.e, i1.y0
    public N j(E e10) {
        N n10 = (N) super.j(e10);
        b5 b5Var = (b5) o(this.f7645e);
        if (b5Var != null) {
            c1.h0.g0(b5Var.remove(n10));
        }
        return n10;
    }

    @Override // i1.y0
    public Set<E> l(N node) {
        return new a(this.f7525b, node, node);
    }

    public final b5<N> r() {
        b5<N> b5Var = (b5) o(this.f7644d);
        if (b5Var != null) {
            return b5Var;
        }
        y2 y2VarCreate = y2.create(this.f7524a.values());
        this.f7644d = new SoftReference(y2VarCreate);
        return y2VarCreate;
    }

    public final b5<N> s() {
        b5<N> b5Var = (b5) o(this.f7645e);
        if (b5Var != null) {
            return b5Var;
        }
        y2 y2VarCreate = y2.create(this.f7525b.values());
        this.f7645e = new SoftReference(y2VarCreate);
        return y2VarCreate;
    }
}
