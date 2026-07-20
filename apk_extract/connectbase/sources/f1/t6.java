package f1;

import com.google.j2objc.annotations.Weak;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NavigableSet;
import java.util.NoSuchElementException;
import java.util.SortedSet;

/* JADX INFO: loaded from: classes.dex */
@b1.b(emulated = true)
@x0
public final class t6 {

    public static class a<E> extends c5.h<E> implements SortedSet<E> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @Weak
        public final r6<E> f5352a;

        public a(r6<E> multiset) {
            this.f5352a = multiset;
        }

        @Override // f1.c5.h
        public b5 a() {
            return this.f5352a;
        }

        public final r6<E> b() {
            return this.f5352a;
        }

        @Override // java.util.SortedSet
        public Comparator<? super E> comparator() {
            return this.f5352a.comparator();
        }

        @Override // java.util.SortedSet
        @m5
        public E first() {
            return (E) t6.d(this.f5352a.firstEntry());
        }

        @Override // java.util.SortedSet
        public SortedSet<E> headSet(@m5 E toElement) {
            return this.f5352a.headMultiset(toElement, x.OPEN).elementSet();
        }

        @Override // f1.c5.h, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<E> iterator() {
            return new c5.e(this.f5352a.entrySet().iterator());
        }

        @Override // java.util.SortedSet
        @m5
        public E last() {
            return (E) t6.d(this.f5352a.lastEntry());
        }

        @Override // java.util.SortedSet
        public SortedSet<E> subSet(@m5 E fromElement, @m5 E toElement) {
            return this.f5352a.subMultiset(fromElement, x.CLOSED, toElement, x.OPEN).elementSet();
        }

        @Override // java.util.SortedSet
        public SortedSet<E> tailSet(@m5 E fromElement) {
            return this.f5352a.tailMultiset(fromElement, x.CLOSED).elementSet();
        }
    }

    @b1.c
    public static class b<E> extends a<E> implements NavigableSet<E> {
        public b(r6<E> multiset) {
            super(multiset);
        }

        @Override // java.util.NavigableSet
        @gm.a
        public E ceiling(@m5 E e10) {
            return (E) t6.c(this.f5352a.tailMultiset(e10, x.CLOSED).firstEntry());
        }

        @Override // java.util.NavigableSet
        public Iterator<E> descendingIterator() {
            return descendingSet().iterator();
        }

        @Override // java.util.NavigableSet
        public NavigableSet<E> descendingSet() {
            return new b(this.f5352a.descendingMultiset());
        }

        @Override // java.util.NavigableSet
        @gm.a
        public E floor(@m5 E e10) {
            return (E) t6.c(this.f5352a.headMultiset(e10, x.CLOSED).lastEntry());
        }

        @Override // java.util.NavigableSet
        public NavigableSet<E> headSet(@m5 E toElement, boolean inclusive) {
            return new b(this.f5352a.headMultiset(toElement, x.forBoolean(inclusive)));
        }

        @Override // java.util.NavigableSet
        @gm.a
        public E higher(@m5 E e10) {
            return (E) t6.c(this.f5352a.tailMultiset(e10, x.OPEN).firstEntry());
        }

        @Override // java.util.NavigableSet
        @gm.a
        public E lower(@m5 E e10) {
            return (E) t6.c(this.f5352a.headMultiset(e10, x.OPEN).lastEntry());
        }

        @Override // java.util.NavigableSet
        @gm.a
        public E pollFirst() {
            return (E) t6.c(this.f5352a.pollFirstEntry());
        }

        @Override // java.util.NavigableSet
        @gm.a
        public E pollLast() {
            return (E) t6.c(this.f5352a.pollLastEntry());
        }

        @Override // java.util.NavigableSet
        public NavigableSet<E> subSet(@m5 E fromElement, boolean fromInclusive, @m5 E toElement, boolean toInclusive) {
            return new b(this.f5352a.subMultiset(fromElement, x.forBoolean(fromInclusive), toElement, x.forBoolean(toInclusive)));
        }

        @Override // java.util.NavigableSet
        public NavigableSet<E> tailSet(@m5 E fromElement, boolean inclusive) {
            return new b(this.f5352a.tailMultiset(fromElement, x.forBoolean(inclusive)));
        }
    }

    @gm.a
    public static <E> E c(@gm.a b5.a<E> entry) {
        if (entry == null) {
            return null;
        }
        return entry.getElement();
    }

    public static <E> E d(@gm.a b5.a<E> entry) {
        if (entry != null) {
            return entry.getElement();
        }
        throw new NoSuchElementException();
    }
}
