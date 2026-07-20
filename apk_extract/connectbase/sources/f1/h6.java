package f1;

import java.util.Map;
import java.util.SortedMap;
import java.util.SortedSet;

/* JADX INFO: loaded from: classes.dex */
@b1.b
@x0
public interface h6<R, C, V> extends z6<R, C, V> {
    @Override // f1.z6
    SortedSet<R> rowKeySet();

    @Override // f1.z6
    SortedMap<R, Map<C, V>> rowMap();
}
