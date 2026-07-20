package f1;

import java.io.Serializable;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
@b1.b(emulated = true)
@x0
public final class n3<K, V> extends e3<V> {
    private final k3<K, V> map;

    public class a extends x7<V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final x7<Map.Entry<K, V>> f5113a;

        public a() {
            this.f5113a = n3.this.map.entrySet().iterator();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f5113a.hasNext();
        }

        @Override // java.util.Iterator
        public V next() {
            return this.f5113a.next().getValue();
        }
    }

    public class b extends i3<V> {
        final /* synthetic */ i3 val$entryList;

        public b(final n3 this$0, final i3 val$entryList) {
            this.val$entryList = val$entryList;
        }

        @Override // java.util.List
        public V get(int i10) {
            return (V) ((Map.Entry) this.val$entryList.get(i10)).getValue();
        }

        @Override // f1.e3
        public boolean isPartialView() {
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.val$entryList.size();
        }
    }

    @b1.c
    @b1.d
    public static class c<V> implements Serializable {
        private static final long serialVersionUID = 0;
        final k3<?, V> map;

        public c(k3<?, V> map) {
            this.map = map;
        }

        public Object readResolve() {
            return this.map.values();
        }
    }

    public n3(k3<K, V> map) {
        this.map = map;
    }

    @Override // f1.e3
    public i3<V> asList() {
        return new b(this, this.map.entrySet().asList());
    }

    @Override // f1.e3, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(@gm.a Object object) {
        return object != null && h4.q(iterator(), object);
    }

    @Override // f1.e3
    public boolean isPartialView() {
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public int size() {
        return this.map.size();
    }

    @Override // f1.e3
    @b1.c
    public Object writeReplace() {
        return new c(this.map);
    }

    @Override // f1.e3, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet, f1.n6
    public x7<V> iterator() {
        return new a();
    }
}
