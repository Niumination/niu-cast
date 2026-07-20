package nm;

import java.io.Serializable;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
public final class l0 implements Map, Serializable, ln.a {

    @os.l
    public static final l0 INSTANCE = new l0();
    private static final long serialVersionUID = 8246714829545688274L;

    private final Object readResolve() {
        return INSTANCE;
    }

    @Override // java.util.Map
    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public boolean containsKey(@os.m Object obj) {
        return false;
    }

    public boolean containsValue(@os.l Void r10) {
        kn.l0.p(r10, "value");
        return false;
    }

    @Override // java.util.Map
    public final /* bridge */ Set<Map.Entry> entrySet() {
        return getEntries();
    }

    @Override // java.util.Map
    public boolean equals(@os.m Object obj) {
        return (obj instanceof Map) && ((Map) obj).isEmpty();
    }

    @os.l
    public Set<Map.Entry> getEntries() {
        return m0.INSTANCE;
    }

    @os.l
    public Set<Object> getKeys() {
        return m0.INSTANCE;
    }

    public int getSize() {
        return 0;
    }

    @os.l
    public Collection getValues() {
        return k0.INSTANCE;
    }

    @Override // java.util.Map
    public int hashCode() {
        return 0;
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        return true;
    }

    @Override // java.util.Map
    public final /* bridge */ Set<Object> keySet() {
        return getKeys();
    }

    @Override // java.util.Map
    public /* bridge */ /* synthetic */ Object put(Object obj, Object obj2) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public void putAll(Map map) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public Void remove(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public final /* bridge */ int size() {
        return getSize();
    }

    @os.l
    public String toString() {
        return "{}";
    }

    @Override // java.util.Map
    public final /* bridge */ Collection values() {
        return getValues();
    }

    @Override // java.util.Map
    public final /* bridge */ boolean containsValue(Object obj) {
        if (obj instanceof Void) {
            return containsValue((Void) obj);
        }
        return false;
    }

    @Override // java.util.Map
    @os.m
    public Void get(@os.m Object obj) {
        return null;
    }

    public Void put(Object obj, Void r10) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
