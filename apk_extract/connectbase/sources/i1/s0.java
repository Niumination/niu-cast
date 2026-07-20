package i1;

import f1.x7;
import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
@w
public abstract class s0<E> extends AbstractSet<E> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<E, ?> f7648a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f7649b;

    public class a extends f1.c<E> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Iterator f7650c;

        public a(final Iterator val$entries) {
            this.f7650c = val$entries;
        }

        @Override // f1.c
        @gm.a
        public E a() {
            while (this.f7650c.hasNext()) {
                Map.Entry entry = (Map.Entry) this.f7650c.next();
                if (s0.this.f7649b.equals(entry.getValue())) {
                    return (E) entry.getKey();
                }
            }
            this.f4711a = f1.c.b.DONE;
            return null;
        }
    }

    public s0(Map<E, ?> outEdgeToNode, Object targetNode) {
        outEdgeToNode.getClass();
        this.f7648a = outEdgeToNode;
        targetNode.getClass();
        this.f7649b = targetNode;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public x7<E> iterator() {
        return new a(this.f7648a.entrySet().iterator());
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(@gm.a Object edge) {
        return this.f7649b.equals(this.f7648a.get(edge));
    }
}
