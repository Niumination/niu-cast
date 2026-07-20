package f1;

import java.util.Comparator;
import java.util.Iterator;
import java.util.NavigableSet;

/* JADX INFO: loaded from: classes.dex */
@b1.b(emulated = true)
@x0
public abstract class o2<E> extends g2<E> implements r6<E> {

    public abstract class a extends v0<E> {
        public a() {
        }

        @Override // f1.v0
        public r6<E> q() {
            return o2.this;
        }
    }

    public class b extends t6.b<E> {
        public b(final o2 this$0) {
            super(this$0);
        }
    }

    @Override // f1.r6, f1.n6
    public Comparator<? super E> comparator() {
        return delegate().comparator();
    }

    @Override // f1.g2, f1.s1, f1.j2
    public abstract r6<E> delegate();

    @Override // f1.r6
    public r6<E> descendingMultiset() {
        return delegate().descendingMultiset();
    }

    @Override // f1.r6
    @gm.a
    public b5.a<E> firstEntry() {
        return delegate().firstEntry();
    }

    @Override // f1.r6
    public r6<E> headMultiset(@m5 E upperBound, x boundType) {
        return delegate().headMultiset(upperBound, boundType);
    }

    @gm.a
    public b5.a<E> l() {
        Iterator<b5.a<E>> it = entrySet().iterator();
        if (!it.hasNext()) {
            return null;
        }
        b5.a<E> next = it.next();
        return new c5.k(next.getElement(), next.getCount());
    }

    @Override // f1.r6
    @gm.a
    public b5.a<E> lastEntry() {
        return delegate().lastEntry();
    }

    @gm.a
    public b5.a<E> m() {
        Iterator<b5.a<E>> it = descendingMultiset().entrySet().iterator();
        if (!it.hasNext()) {
            return null;
        }
        b5.a<E> next = it.next();
        return new c5.k(next.getElement(), next.getCount());
    }

    @Override // f1.r6
    @gm.a
    public b5.a<E> pollFirstEntry() {
        return delegate().pollFirstEntry();
    }

    @Override // f1.r6
    @gm.a
    public b5.a<E> pollLastEntry() {
        return delegate().pollLastEntry();
    }

    @gm.a
    public b5.a<E> q() {
        Iterator<b5.a<E>> it = entrySet().iterator();
        if (!it.hasNext()) {
            return null;
        }
        b5.a<E> next = it.next();
        c5.k kVar = new c5.k(next.getElement(), next.getCount());
        it.remove();
        return kVar;
    }

    @gm.a
    public b5.a<E> r() {
        Iterator<b5.a<E>> it = descendingMultiset().entrySet().iterator();
        if (!it.hasNext()) {
            return null;
        }
        b5.a<E> next = it.next();
        c5.k kVar = new c5.k(next.getElement(), next.getCount());
        it.remove();
        return kVar;
    }

    public r6<E> s(@m5 E lowerBound, x lowerBoundType, @m5 E upperBound, x upperBoundType) {
        return tailMultiset(lowerBound, lowerBoundType).headMultiset(upperBound, upperBoundType);
    }

    @Override // f1.r6
    public r6<E> subMultiset(@m5 E lowerBound, x lowerBoundType, @m5 E upperBound, x upperBoundType) {
        return delegate().subMultiset(lowerBound, lowerBoundType, upperBound, upperBoundType);
    }

    @Override // f1.r6
    public r6<E> tailMultiset(@m5 E lowerBound, x boundType) {
        return delegate().tailMultiset(lowerBound, boundType);
    }

    @Override // f1.g2, f1.b5, f1.r6, f1.s6
    public NavigableSet<E> elementSet() {
        return delegate().elementSet();
    }
}
