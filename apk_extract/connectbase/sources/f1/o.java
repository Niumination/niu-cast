package f1;

import java.util.Comparator;
import java.util.Iterator;
import java.util.NavigableSet;

/* JADX INFO: loaded from: classes.dex */
@b1.b(emulated = true)
@x0
public abstract class o<E> extends i<E> implements r6<E> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @u1.b
    @gm.a
    public transient r6<E> f5157c;

    @t2
    final Comparator<? super E> comparator;

    public class a extends v0<E> {
        public a() {
        }

        @Override // f1.v0, f1.s1, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<E> iterator() {
            return o.this.descendingIterator();
        }

        @Override // f1.v0
        public Iterator<b5.a<E>> m() {
            return o.this.descendingEntryIterator();
        }

        @Override // f1.v0
        public r6<E> q() {
            return o.this;
        }
    }

    public o() {
        this(l5.natural());
    }

    @Override // f1.r6, f1.n6
    public Comparator<? super E> comparator() {
        return this.comparator;
    }

    public r6<E> createDescendingMultiset() {
        return new a();
    }

    public abstract Iterator<b5.a<E>> descendingEntryIterator();

    public Iterator<E> descendingIterator() {
        return c5.n(descendingMultiset());
    }

    @Override // f1.r6
    public r6<E> descendingMultiset() {
        r6<E> r6Var = this.f5157c;
        if (r6Var != null) {
            return r6Var;
        }
        r6<E> r6VarCreateDescendingMultiset = createDescendingMultiset();
        this.f5157c = r6VarCreateDescendingMultiset;
        return r6VarCreateDescendingMultiset;
    }

    @Override // f1.r6
    @gm.a
    public b5.a<E> firstEntry() {
        Iterator<b5.a<E>> itEntryIterator = entryIterator();
        if (itEntryIterator.hasNext()) {
            return itEntryIterator.next();
        }
        return null;
    }

    @Override // f1.r6
    @gm.a
    public b5.a<E> lastEntry() {
        Iterator<b5.a<E>> itDescendingEntryIterator = descendingEntryIterator();
        if (itDescendingEntryIterator.hasNext()) {
            return itDescendingEntryIterator.next();
        }
        return null;
    }

    @Override // f1.r6
    @gm.a
    public b5.a<E> pollFirstEntry() {
        Iterator<b5.a<E>> itEntryIterator = entryIterator();
        if (!itEntryIterator.hasNext()) {
            return null;
        }
        b5.a<E> next = itEntryIterator.next();
        c5.k kVar = new c5.k(next.getElement(), next.getCount());
        itEntryIterator.remove();
        return kVar;
    }

    @Override // f1.r6
    @gm.a
    public b5.a<E> pollLastEntry() {
        Iterator<b5.a<E>> itDescendingEntryIterator = descendingEntryIterator();
        if (!itDescendingEntryIterator.hasNext()) {
            return null;
        }
        b5.a<E> next = itDescendingEntryIterator.next();
        c5.k kVar = new c5.k(next.getElement(), next.getCount());
        itDescendingEntryIterator.remove();
        return kVar;
    }

    @Override // f1.r6
    public r6<E> subMultiset(@m5 E fromElement, x fromBoundType, @m5 E toElement, x toBoundType) {
        fromBoundType.getClass();
        toBoundType.getClass();
        return tailMultiset(fromElement, fromBoundType).headMultiset(toElement, toBoundType);
    }

    public o(Comparator<? super E> comparator) {
        comparator.getClass();
        this.comparator = comparator;
    }

    @Override // f1.i
    public NavigableSet<E> createElementSet() {
        return new t6.b(this);
    }

    @Override // f1.i, f1.b5, f1.r6, f1.s6
    public NavigableSet<E> elementSet() {
        return (NavigableSet) super.elementSet();
    }
}
