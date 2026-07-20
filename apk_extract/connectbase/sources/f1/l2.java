package f1;

import java.util.Collection;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
@b1.b
@x0
public abstract class l2<E> extends s1<E> implements Set<E> {
    @Override // f1.s1, f1.j2
    public abstract Set<E> delegate();

    @Override // java.util.Collection, java.util.Set
    public boolean equals(@gm.a Object object) {
        return object == this || delegate().equals(object);
    }

    @Override // java.util.Collection, java.util.Set
    public int hashCode() {
        return delegate().hashCode();
    }

    public boolean standardEquals(@gm.a Object object) {
        return k6.g(this, object);
    }

    public int standardHashCode() {
        return k6.k(this);
    }

    @Override // f1.s1
    public boolean standardRemoveAll(Collection<?> collection) {
        collection.getClass();
        return k6.I(this, collection);
    }
}
