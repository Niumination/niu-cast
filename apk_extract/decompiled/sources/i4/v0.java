package i4;

import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public abstract class v0 extends s1 {
    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Use EntrySetSerializedForm");
    }

    @Override // i4.a0, java.util.AbstractCollection, java.util.Collection
    public boolean contains(Object obj) {
        if (!(obj instanceof Map.Entry)) {
            return false;
        }
        Map.Entry entry = (Map.Entry) obj;
        Object obj2 = map().get(entry.getKey());
        return obj2 != null && obj2.equals(entry.getValue());
    }

    @Override // i4.s1, java.util.Collection, java.util.Set
    public int hashCode() {
        return map().hashCode();
    }

    @Override // i4.s1
    public boolean isHashCodeFast() {
        return map().isHashCodeFast();
    }

    @Override // i4.a0
    public boolean isPartialView() {
        return map().isPartialView();
    }

    public abstract t0 map();

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public int size() {
        return map().size();
    }

    @Override // i4.s1, i4.a0
    public Object writeReplace() {
        return new u0(map());
    }
}
