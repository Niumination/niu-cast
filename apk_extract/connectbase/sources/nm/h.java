package nm;

import java.util.AbstractSet;
import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
@lm.f1(version = "1.1")
public abstract class h<E> extends AbstractSet<E> implements Set<E>, ln.h {
    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public abstract boolean add(E e10);

    public abstract int getSize();

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final /* bridge */ int size() {
        return getSize();
    }
}
