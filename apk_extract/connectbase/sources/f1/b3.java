package f1;

import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;

/* JADX INFO: loaded from: classes.dex */
@b1.b(emulated = true, serializable = true)
@x0
public abstract class b3<E> extends i3<E> {

    @b1.c
    @b1.d
    public static class a implements Serializable {
        private static final long serialVersionUID = 0;
        final e3<?> collection;

        public a(e3<?> collection) {
            this.collection = collection;
        }

        public Object readResolve() {
            return this.collection.asList();
        }
    }

    @b1.c
    @b1.d
    private void readObject(ObjectInputStream stream) throws InvalidObjectException {
        throw new InvalidObjectException("Use SerializedForm");
    }

    @Override // f1.i3, f1.e3, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(@gm.a Object target) {
        return delegateCollection().contains(target);
    }

    public abstract e3<E> delegateCollection();

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean isEmpty() {
        return delegateCollection().isEmpty();
    }

    @Override // f1.e3
    public boolean isPartialView() {
        return delegateCollection().isPartialView();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return delegateCollection().size();
    }

    @Override // f1.i3, f1.e3
    @b1.c
    @b1.d
    public Object writeReplace() {
        return new a(delegateCollection());
    }
}
