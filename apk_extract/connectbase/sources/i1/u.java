package i1;

import f1.h4;
import f1.t3;
import f1.x7;
import java.util.AbstractSet;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
@w
public final class u<E> extends AbstractSet<E> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<?, E> f7652a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f7653b;

    public u(Map<?, E> nodeToEdgeMap, Object targetNode) {
        nodeToEdgeMap.getClass();
        this.f7652a = nodeToEdgeMap;
        targetNode.getClass();
        this.f7653b = targetNode;
    }

    @gm.a
    public final E a() {
        return this.f7652a.get(this.f7653b);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public x7<E> iterator() {
        E eA = a();
        return eA == null ? t3.of().iterator() : new h4.k(eA);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(@gm.a Object edge) {
        E eA = a();
        return eA != null && eA.equals(edge);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public int size() {
        return a() == null ? 0 : 1;
    }
}
