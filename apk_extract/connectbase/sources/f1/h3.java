package f1;

import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.lang.Enum;
import java.util.Collection;
import java.util.EnumSet;

/* JADX INFO: loaded from: classes.dex */
@b1.b(emulated = true, serializable = true)
@x0
public final class h3<E extends Enum<E>> extends t3<E> {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final transient EnumSet<E> f4937e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @u1.b
    public transient int f4938f;

    @b1.d
    public static class b<E extends Enum<E>> implements Serializable {
        private static final long serialVersionUID = 0;
        final EnumSet<E> delegate;

        public b(EnumSet<E> delegate) {
            this.delegate = delegate;
        }

        public Object readResolve() {
            return new h3(this.delegate.clone());
        }
    }

    public static <E extends Enum<E>> t3<E> asImmutable(EnumSet<E> set) {
        int size = set.size();
        if (size != 0) {
            return size != 1 ? new h3(set) : t3.of((Enum) g4.z(set));
        }
        return t3.of();
    }

    @b1.d
    private void readObject(ObjectInputStream stream) throws InvalidObjectException {
        throw new InvalidObjectException("Use SerializedForm");
    }

    @Override // f1.e3, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(@gm.a Object object) {
        return this.f4937e.contains(object);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean containsAll(Collection<?> collection) {
        if (collection instanceof h3) {
            collection = ((h3) collection).f4937e;
        }
        return this.f4937e.containsAll(collection);
    }

    @Override // f1.t3, java.util.Collection, java.util.Set
    public boolean equals(@gm.a Object object) {
        if (object == this) {
            return true;
        }
        if (object instanceof h3) {
            object = ((h3) object).f4937e;
        }
        return this.f4937e.equals(object);
    }

    @Override // f1.t3, java.util.Collection, java.util.Set
    public int hashCode() {
        int i10 = this.f4938f;
        if (i10 != 0) {
            return i10;
        }
        int iHashCode = this.f4937e.hashCode();
        this.f4938f = iHashCode;
        return iHashCode;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean isEmpty() {
        return this.f4937e.isEmpty();
    }

    @Override // f1.t3
    public boolean isHashCodeFast() {
        return true;
    }

    @Override // f1.e3
    public boolean isPartialView() {
        return false;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public int size() {
        return this.f4937e.size();
    }

    @Override // java.util.AbstractCollection
    public String toString() {
        return this.f4937e.toString();
    }

    @Override // f1.t3, f1.e3
    @b1.d
    public Object writeReplace() {
        return new b(this.f4937e);
    }

    public h3(EnumSet<E> delegate) {
        this.f4937e = delegate;
    }

    @Override // f1.t3, f1.e3, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet, f1.n6
    public x7<E> iterator() {
        return h4.f0(this.f4937e.iterator());
    }
}
