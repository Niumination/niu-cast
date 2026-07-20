package f1;

import java.util.Comparator;
import java.util.NavigableSet;

/* JADX INFO: loaded from: classes.dex */
@b1.b(emulated = true)
@x0
public final class z7<E> extends c5.m<E> implements r6<E> {
    private static final long serialVersionUID = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @u1.b
    @gm.a
    public transient z7<E> f5648a;

    public z7(r6<E> delegate) {
        super(delegate);
    }

    @Override // f1.r6, f1.n6
    public Comparator<? super E> comparator() {
        return delegate().comparator();
    }

    @Override // f1.r6
    public r6<E> descendingMultiset() {
        z7<E> z7Var = this.f5648a;
        if (z7Var != null) {
            return z7Var;
        }
        z7<E> z7Var2 = new z7<>(delegate().descendingMultiset());
        z7Var2.f5648a = this;
        this.f5648a = z7Var2;
        return z7Var2;
    }

    @Override // f1.r6
    @gm.a
    public b5.a<E> firstEntry() {
        return delegate().firstEntry();
    }

    @Override // f1.r6
    public r6<E> headMultiset(@m5 E upperBound, x boundType) {
        return c5.B(delegate().headMultiset(upperBound, boundType));
    }

    @Override // f1.r6
    @gm.a
    public b5.a<E> lastEntry() {
        return delegate().lastEntry();
    }

    @Override // f1.r6
    @gm.a
    public b5.a<E> pollFirstEntry() {
        throw new UnsupportedOperationException();
    }

    @Override // f1.r6
    @gm.a
    public b5.a<E> pollLastEntry() {
        throw new UnsupportedOperationException();
    }

    @Override // f1.r6
    public r6<E> subMultiset(@m5 E lowerBound, x lowerBoundType, @m5 E upperBound, x upperBoundType) {
        return c5.B(delegate().subMultiset(lowerBound, lowerBoundType, upperBound, upperBoundType));
    }

    @Override // f1.r6
    public r6<E> tailMultiset(@m5 E lowerBound, x boundType) {
        return c5.B(delegate().tailMultiset(lowerBound, boundType));
    }

    @Override // f1.c5.m
    public NavigableSet<E> createElementSet() {
        return k6.O(delegate().elementSet());
    }

    @Override // f1.c5.m, f1.g2, f1.b5, f1.r6, f1.s6
    public NavigableSet<E> elementSet() {
        return (NavigableSet) super.elementSet();
    }

    @Override // f1.c5.m, f1.g2, f1.s1, f1.j2
    public r6<E> delegate() {
        return (r6) super.delegate();
    }
}
