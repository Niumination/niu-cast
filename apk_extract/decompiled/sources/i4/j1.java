package i4;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public abstract class j1 extends i implements Serializable {
    private static final long serialVersionUID = 0;
    final transient t0 map;
    final transient int size;

    public j1(t0 t0Var, int i8) {
        this.map = t0Var;
        this.size = i8;
    }

    public static <K, V> d1 builder() {
        return new d1();
    }

    public static <K, V> j1 copyOf(a4 a4Var) {
        if (a4Var instanceof j1) {
            j1 j1Var = (j1) a4Var;
            if (!j1Var.isPartialView()) {
                return j1Var;
            }
        }
        return j0.copyOf(a4Var);
    }

    public static <K, V> j1 of() {
        return j0.of();
    }

    @Deprecated
    public final void clear() {
        throw new UnsupportedOperationException();
    }

    public boolean containsEntry(Object obj, Object obj2) {
        Collection collection = (Collection) asMap().get(obj);
        return collection != null && collection.contains(obj2);
    }

    public boolean containsKey(Object obj) {
        return this.map.containsKey(obj);
    }

    public boolean containsValue(Object obj) {
        if (obj != null) {
            Iterator it = asMap().values().iterator();
            while (it.hasNext()) {
                if (((Collection) it.next()).contains(obj)) {
                    return true;
                }
            }
        }
        return false;
    }

    public Map<Object, Collection<Object>> createAsMap() {
        throw new AssertionError("should never be called");
    }

    public Set<Object> createKeySet() {
        throw new AssertionError("unreachable");
    }

    @Override // i4.i
    public /* bridge */ /* synthetic */ boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override // 
    /* JADX INFO: renamed from: get */
    public abstract a0 mo148get(Object obj);

    @Override // i4.i
    public /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    public abstract j1 inverse();

    public boolean isEmpty() {
        return size() == 0;
    }

    public boolean isPartialView() {
        return this.map.isPartialView();
    }

    @Deprecated
    public final boolean put(Object obj, Object obj2) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final boolean putAll(Object obj, Iterable<Object> iterable) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final boolean remove(Object obj, Object obj2) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    /* JADX INFO: renamed from: replaceValues, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Collection mo152replaceValues(Object obj, Iterable iterable) {
        return replaceValues(obj, (Iterable<Object>) iterable);
    }

    public int size() {
        return this.size;
    }

    @Override // i4.i
    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }

    public static <K, V> j1 of(K k8, V v3) {
        return j0.of((Object) k8, (Object) v3);
    }

    @Override // i4.a4
    public t0 asMap() {
        return this.map;
    }

    /* JADX INFO: renamed from: createEntries, reason: merged with bridge method [inline-methods] */
    public a0 m143createEntries() {
        return new e1(this);
    }

    public o1 createKeys() {
        return new g1(this);
    }

    /* JADX INFO: renamed from: createValues, reason: merged with bridge method [inline-methods] */
    public a0 m145createValues() {
        return new i1(this);
    }

    @Override // 
    /* JADX INFO: renamed from: entries */
    public a0 mo146entries() {
        Collection collectionM143createEntries = this.f5603a;
        if (collectionM143createEntries == null) {
            collectionM143createEntries = m143createEntries();
            this.f5603a = collectionM143createEntries;
        }
        return (a0) collectionM143createEntries;
    }

    /* JADX INFO: renamed from: entryIterator, reason: merged with bridge method [inline-methods] */
    public h5 m147entryIterator() {
        return new b1(this);
    }

    /* JADX INFO: renamed from: keySet, reason: merged with bridge method [inline-methods] */
    public s1 m149keySet() {
        return this.map.keySet();
    }

    public o1 keys() {
        c4 c4VarCreateKeys = this.f5604b;
        if (c4VarCreateKeys == null) {
            c4VarCreateKeys = createKeys();
            this.f5604b = c4VarCreateKeys;
        }
        return (o1) c4VarCreateKeys;
    }

    @Deprecated
    public final boolean putAll(a4 a4Var) {
        throw new UnsupportedOperationException();
    }

    @Override // 
    @Deprecated
    /* JADX INFO: renamed from: removeAll */
    public a0 mo151removeAll(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public a0 replaceValues(Object obj, Iterable<Object> iterable) {
        throw new UnsupportedOperationException();
    }

    /* JADX INFO: renamed from: valueIterator, reason: merged with bridge method [inline-methods] */
    public h5 m153valueIterator() {
        return new c1(this);
    }

    /* JADX INFO: renamed from: values, reason: merged with bridge method [inline-methods] */
    public a0 m154values() {
        Collection collectionM145createValues = this.f5605c;
        if (collectionM145createValues == null) {
            collectionM145createValues = m145createValues();
            this.f5605c = collectionM145createValues;
        }
        return (a0) collectionM145createValues;
    }

    public static <K, V> j1 of(K k8, V v3, K k10, V v8) {
        return j0.of((Object) k8, (Object) v3, (Object) k10, (Object) v8);
    }

    public static <K, V> j1 of(K k8, V v3, K k10, V v8, K k11, V v10) {
        return j0.of((Object) k8, (Object) v3, (Object) k10, (Object) v8, (Object) k11, (Object) v10);
    }

    public static <K, V> j1 copyOf(Iterable<? extends Map.Entry<? extends K, ? extends V>> iterable) {
        return j0.copyOf((Iterable) iterable);
    }

    public static <K, V> j1 of(K k8, V v3, K k10, V v8, K k11, V v10, K k12, V v11) {
        return j0.of((Object) k8, (Object) v3, (Object) k10, (Object) v8, (Object) k11, (Object) v10, (Object) k12, (Object) v11);
    }

    public static <K, V> j1 of(K k8, V v3, K k10, V v8, K k11, V v10, K k12, V v11, K k13, V v12) {
        return j0.of((Object) k8, (Object) v3, (Object) k10, (Object) v8, (Object) k11, (Object) v10, (Object) k12, (Object) v11, (Object) k13, (Object) v12);
    }
}
