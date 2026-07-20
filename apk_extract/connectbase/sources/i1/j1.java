package i1;

import f1.h4;
import f1.k3;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
@w
public final class j1<N, V> implements e0<N, V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<N, V> f7596a;

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f7597a;

        static {
            int[] iArr = new int[v.b.values().length];
            f7597a = iArr;
            try {
                iArr[v.b.UNORDERED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f7597a[v.b.STABLE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public j1(Map<N, V> adjacentNodeValues) {
        adjacentNodeValues.getClass();
        this.f7596a = adjacentNodeValues;
    }

    public static x j(Object obj, Object obj2) {
        return new x.c(obj2, obj);
    }

    private static x k(Object obj, Object obj2) {
        return new x.c(obj2, obj);
    }

    public static <N, V> j1<N, V> l(v<N> incidentEdgeOrder) {
        int i10 = a.f7597a[incidentEdgeOrder.f7654a.ordinal()];
        if (i10 == 1) {
            return new j1<>(new HashMap(2, 1.0f));
        }
        if (i10 == 2) {
            return new j1<>(new LinkedHashMap(2, 1.0f));
        }
        throw new AssertionError(incidentEdgeOrder.f7654a);
    }

    public static <N, V> j1<N, V> m(Map<N, V> adjacentNodeValues) {
        return new j1<>(k3.copyOf((Map) adjacentNodeValues));
    }

    @Override // i1.e0
    public Set<N> a() {
        return c();
    }

    @Override // i1.e0
    public Set<N> b() {
        return c();
    }

    @Override // i1.e0
    public Set<N> c() {
        return Collections.unmodifiableSet(this.f7596a.keySet());
    }

    @Override // i1.e0
    @gm.a
    public V d(N node) {
        return this.f7596a.get(node);
    }

    @Override // i1.e0
    @gm.a
    public V e(N node) {
        return this.f7596a.remove(node);
    }

    @Override // i1.e0
    public void f(N node) {
        e(node);
    }

    @Override // i1.e0
    public Iterator<x<N>> g(final N thisNode) {
        return h4.c0(this.f7596a.keySet().iterator(), new c1.t() { // from class: i1.i1
            @Override // c1.t
            public final Object apply(Object obj) {
                return new x.c(obj, thisNode);
            }
        });
    }

    @Override // i1.e0
    @gm.a
    public V h(N node, V value) {
        return this.f7596a.put(node, value);
    }

    @Override // i1.e0
    public void i(N node, V value) {
        h(node, value);
    }
}
