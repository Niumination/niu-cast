package f1;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
@b1.b
@x0
public interface b5<E> extends Collection<E> {

    public interface a<E> {
        boolean equals(@gm.a Object o10);

        int getCount();

        @m5
        E getElement();

        int hashCode();

        String toString();
    }

    @t1.a
    int add(@m5 E element, int occurrences);

    @Override // java.util.Collection
    @t1.a
    boolean add(@m5 E element);

    @Override // java.util.Collection
    boolean contains(@gm.a Object element);

    @Override // java.util.Collection
    boolean containsAll(Collection<?> elements);

    int count(@gm.a @t1.c("E") Object element);

    Set<E> elementSet();

    Set<a<E>> entrySet();

    @Override // java.util.Collection
    boolean equals(@gm.a Object object);

    @Override // java.util.Collection
    int hashCode();

    @Override // java.util.Collection, java.lang.Iterable
    Iterator<E> iterator();

    @t1.a
    int remove(@gm.a @t1.c("E") Object element, int occurrences);

    @Override // java.util.Collection
    @t1.a
    boolean remove(@gm.a Object element);

    @Override // java.util.Collection
    @t1.a
    boolean removeAll(Collection<?> c10);

    @Override // java.util.Collection
    @t1.a
    boolean retainAll(Collection<?> c10);

    @t1.a
    int setCount(@m5 E element, int count);

    @t1.a
    boolean setCount(@m5 E element, int oldCount, int newCount);

    @Override // java.util.Collection
    int size();

    String toString();
}
