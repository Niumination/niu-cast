package f1;

import java.util.Comparator;
import java.util.Iterator;
import java.util.NavigableSet;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
@b1.b(emulated = true)
@x0
public abstract class v0<E> extends g2<E> implements r6<E> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @u1.b
    @gm.a
    public transient Comparator<? super E> f5446a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @u1.b
    @gm.a
    public transient NavigableSet<E> f5447b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @u1.b
    @gm.a
    public transient Set<b5.a<E>> f5448c;

    public class a extends c5.i<E> {
        public a() {
        }

        @Override // f1.c5.i
        public b5<E> a() {
            return v0.this;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<b5.a<E>> iterator() {
            return v0.this.m();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return v0.this.q().entrySet().size();
        }
    }

    @Override // f1.r6, f1.n6
    public Comparator<? super E> comparator() {
        Comparator<? super E> comparator = this.f5446a;
        if (comparator != null) {
            return comparator;
        }
        l5 l5VarReverse = l5.from(q().comparator()).reverse();
        this.f5446a = l5VarReverse;
        return l5VarReverse;
    }

    @Override // f1.r6
    public r6<E> descendingMultiset() {
        return q();
    }

    @Override // f1.g2, f1.b5
    public Set<b5.a<E>> entrySet() {
        Set<b5.a<E>> set = this.f5448c;
        if (set != null) {
            return set;
        }
        Set<b5.a<E>> setL = l();
        this.f5448c = setL;
        return setL;
    }

    @Override // f1.r6
    @gm.a
    public b5.a<E> firstEntry() {
        return q().lastEntry();
    }

    @Override // f1.r6
    public r6<E> headMultiset(@m5 E toElement, x boundType) {
        return q().tailMultiset(toElement, boundType).descendingMultiset();
    }

    @Override // f1.s1, java.util.Collection, java.lang.Iterable, java.util.Set
    public Iterator<E> iterator() {
        return c5.n(this);
    }

    public Set<b5.a<E>> l() {
        return new a();
    }

    @Override // f1.r6
    @gm.a
    public b5.a<E> lastEntry() {
        return q().firstEntry();
    }

    public abstract Iterator<b5.a<E>> m();

    @Override // f1.r6
    @gm.a
    public b5.a<E> pollFirstEntry() {
        return q().pollLastEntry();
    }

    @Override // f1.r6
    @gm.a
    public b5.a<E> pollLastEntry() {
        return q().pollFirstEntry();
    }

    public abstract r6<E> q();

    @Override // f1.r6
    public r6<E> subMultiset(@m5 E fromElement, x fromBoundType, @m5 E toElement, x toBoundType) {
        return q().subMultiset(toElement, toBoundType, fromElement, fromBoundType).descendingMultiset();
    }

    @Override // f1.r6
    public r6<E> tailMultiset(@m5 E fromElement, x boundType) {
        return q().headMultiset(fromElement, boundType).descendingMultiset();
    }

    @Override // f1.s1, java.util.Collection, java.util.Set
    public Object[] toArray() {
        return standardToArray();
    }

    @Override // f1.j2
    public String toString() {
        return entrySet().toString();
    }

    @Override // f1.s1, java.util.Collection, java.util.Set
    public <T> T[] toArray(T[] tArr) {
        return (T[]) standardToArray(tArr);
    }

    @Override // f1.g2, f1.s1, f1.j2
    public b5<E> delegate() {
        return q();
    }

    @Override // f1.g2, f1.b5, f1.r6, f1.s6
    public NavigableSet<E> elementSet() {
        NavigableSet<E> navigableSet = this.f5447b;
        if (navigableSet != null) {
            return navigableSet;
        }
        t6.b bVar = new t6.b(this);
        this.f5447b = bVar;
        return bVar;
    }
}
