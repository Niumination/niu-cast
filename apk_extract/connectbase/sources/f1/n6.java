package f1;

import java.util.Comparator;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
@b1.b
@x0
public interface n6<T> extends Iterable<T> {
    Comparator<? super T> comparator();

    @Override // java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet, f1.n6
    Iterator<T> iterator();
}
