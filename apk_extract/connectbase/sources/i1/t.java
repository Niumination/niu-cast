package i1;

import f1.c3;
import f1.v2;
import java.util.Collections;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
@w
public final class t<N, E> extends e<N, E> {
    public t(Map<E, N> inEdgeMap, Map<E, N> outEdgeMap, int selfLoopCount) {
        super(inEdgeMap, outEdgeMap, selfLoopCount);
    }

    public static <N, E> t<N, E> n() {
        return new t<>(v2.create(2), v2.create(2), 0);
    }

    public static <N, E> t<N, E> o(Map<E, N> inEdges, Map<E, N> outEdges, int selfLoopCount) {
        return new t<>(c3.copyOf((Map) inEdges), c3.copyOf((Map) outEdges), selfLoopCount);
    }

    @Override // i1.y0
    public Set<N> a() {
        return Collections.unmodifiableSet(((f1.w) this.f7525b).values());
    }

    @Override // i1.y0
    public Set<N> b() {
        return Collections.unmodifiableSet(((f1.w) this.f7524a).values());
    }

    @Override // i1.y0
    public Set<E> l(N node) {
        return new u(((f1.w) this.f7525b).inverse(), node);
    }
}
