package i1;

import f1.c3;
import f1.v2;
import java.util.Collections;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
@w
public final class l1<N, E> extends k<N, E> {
    public l1(Map<E, N> incidentEdgeMap) {
        super(incidentEdgeMap);
    }

    public static <N, E> l1<N, E> m() {
        return new l1<>(v2.create(2));
    }

    public static <N, E> l1<N, E> n(Map<E, N> incidentEdges) {
        return new l1<>(c3.copyOf((Map) incidentEdges));
    }

    @Override // i1.y0
    public Set<N> c() {
        return Collections.unmodifiableSet(((f1.w) this.f7598a).values());
    }

    @Override // i1.y0
    public Set<E> l(N node) {
        return new u(((f1.w) this.f7598a).inverse(), node);
    }
}
