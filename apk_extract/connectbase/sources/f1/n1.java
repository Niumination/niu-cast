package f1;

import com.google.j2objc.annotations.Weak;
import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
@b1.b
@x0
public final class n1<K, V> extends AbstractCollection<V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Weak
    public final m1<K, V> f5112a;

    public n1(m1<K, V> multimap) {
        multimap.getClass();
        this.f5112a = multimap;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public void clear() {
        this.f5112a.clear();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean contains(@gm.a Object o10) {
        return this.f5112a.containsValue(o10);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public Iterator<V> iterator() {
        return new t4.f(this.f5112a.entries().iterator());
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean remove(@gm.a Object o10) {
        c1.i0<? super Map.Entry<K, V>> i0VarF = this.f5112a.f();
        Iterator<Map.Entry<K, V>> it = this.f5112a.a().entries().iterator();
        while (it.hasNext()) {
            Map.Entry<K, V> next = it.next();
            if (i0VarF.apply(next) && c1.b0.a(next.getValue(), o10)) {
                it.remove();
                return true;
            }
        }
        return false;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean removeAll(Collection<?> c10) {
        return g4.J(this.f5112a.a().entries(), c1.j0.d(this.f5112a.f(), c1.j0.h(c1.j0.n(c10), t4.r.VALUE)));
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean retainAll(Collection<?> c10) {
        return g4.J(this.f5112a.a().entries(), c1.j0.d(this.f5112a.f(), c1.j0.h(new c1.j0.i(c1.j0.n(c10)), t4.r.VALUE)));
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public int size() {
        return this.f5112a.size();
    }
}
