package f1;

import java.util.Comparator;
import java.util.Iterator;
import java.util.NavigableSet;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
@b1.b(emulated = true)
@x0
public interface r6<E> extends s6<E>, n6<E> {
    Comparator<? super E> comparator();

    r6<E> descendingMultiset();

    @Override // f1.s6, f1.b5, f1.r6, f1.s6
    NavigableSet<E> elementSet();

    @Override // f1.b5
    Set<b5.a<E>> entrySet();

    @gm.a
    b5.a<E> firstEntry();

    r6<E> headMultiset(@m5 E upperBound, x boundType);

    @Override // f1.b5, java.util.Collection, java.lang.Iterable
    Iterator<E> iterator();

    @gm.a
    b5.a<E> lastEntry();

    @gm.a
    b5.a<E> pollFirstEntry();

    @gm.a
    b5.a<E> pollLastEntry();

    r6<E> subMultiset(@m5 E lowerBound, x lowerBoundType, @m5 E upperBound, x upperBoundType);

    r6<E> tailMultiset(@m5 E lowerBound, x boundType);
}
