package nm;

import java.util.AbstractCollection;
import java.util.Collection;

/* JADX INFO: loaded from: classes3.dex */
@lm.f1(version = "1.1")
public abstract class e<E> extends AbstractCollection<E> implements Collection<E>, ln.b {
    public abstract int a();

    @Override // java.util.AbstractCollection, java.util.Collection
    public abstract boolean add(E e10);

    @Override // java.util.AbstractCollection, java.util.Collection
    public final /* bridge */ int size() {
        return a();
    }
}
