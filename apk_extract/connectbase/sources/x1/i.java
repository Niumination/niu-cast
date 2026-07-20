package x1;

import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.ObjectStreamException;
import java.io.Serializable;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class i<K, V> extends AbstractMap<K, V> implements Serializable {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final Comparator<Comparable> NATURAL_ORDER = new a();
    private final boolean allowNullValues;
    private final Comparator<? super K> comparator;
    private i<K, V>.b entrySet;
    final e<K, V> header;
    private i<K, V>.c keySet;
    int modCount;
    e<K, V> root;
    int size;

    public class a implements Comparator<Comparable> {
        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(Comparable comparable, Comparable comparable2) {
            return comparable.compareTo(comparable2);
        }
    }

    public class b extends AbstractSet<Map.Entry<K, V>> {

        public class a extends i<K, V>.d<Map.Entry<K, V>> {
            public a() {
                super();
            }

            @Override // java.util.Iterator
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public Map.Entry<K, V> next() {
                return a();
            }
        }

        public b() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            i.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return (obj instanceof Map.Entry) && i.this.findByEntry((Map.Entry) obj) != null;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Map.Entry<K, V>> iterator() {
            return new a();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            e<K, V> eVarFindByEntry;
            if (!(obj instanceof Map.Entry) || (eVarFindByEntry = i.this.findByEntry((Map.Entry) obj)) == null) {
                return false;
            }
            i.this.removeInternal(eVarFindByEntry, true);
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return i.this.size;
        }
    }

    public final class c extends AbstractSet<K> {

        public class a extends i<K, V>.d<K> {
            public a() {
                super();
            }

            @Override // java.util.Iterator
            public K next() {
                return a().f19982f;
            }
        }

        public c() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            i.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return i.this.containsKey(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<K> iterator() {
            return new a();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            return i.this.removeInternalByKey(obj) != null;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return i.this.size;
        }
    }

    public abstract class d<T> implements Iterator<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public e<K, V> f19973a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public e<K, V> f19974b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f19975c;

        public d() {
            this.f19973a = i.this.header.f19980d;
            this.f19975c = i.this.modCount;
        }

        public final e<K, V> a() {
            e<K, V> eVar = this.f19973a;
            i iVar = i.this;
            if (eVar == iVar.header) {
                throw new NoSuchElementException();
            }
            if (iVar.modCount != this.f19975c) {
                throw new ConcurrentModificationException();
            }
            this.f19973a = eVar.f19980d;
            this.f19974b = eVar;
            return eVar;
        }

        @Override // java.util.Iterator
        public final boolean hasNext() {
            return this.f19973a != i.this.header;
        }

        @Override // java.util.Iterator
        public final void remove() {
            e<K, V> eVar = this.f19974b;
            if (eVar == null) {
                throw new IllegalStateException();
            }
            i.this.removeInternal(eVar, true);
            this.f19974b = null;
            this.f19975c = i.this.modCount;
        }
    }

    public i() {
        this(NATURAL_ORDER, true);
    }

    private boolean equal(Object obj, Object obj2) {
        return Objects.equals(obj, obj2);
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException {
        throw new InvalidObjectException("Deserialization is unsupported");
    }

    private void rebalance(e<K, V> eVar, boolean z10) {
        while (eVar != null) {
            e<K, V> eVar2 = eVar.f19978b;
            e<K, V> eVar3 = eVar.f19979c;
            int i10 = eVar2 != null ? eVar2.f19985n : 0;
            int i11 = eVar3 != null ? eVar3.f19985n : 0;
            int i12 = i10 - i11;
            if (i12 == -2) {
                e<K, V> eVar4 = eVar3.f19978b;
                e<K, V> eVar5 = eVar3.f19979c;
                int i13 = (eVar4 != null ? eVar4.f19985n : 0) - (eVar5 != null ? eVar5.f19985n : 0);
                if (i13 == -1 || (i13 == 0 && !z10)) {
                    rotateLeft(eVar);
                } else {
                    rotateRight(eVar3);
                    rotateLeft(eVar);
                }
                if (z10) {
                    return;
                }
            } else if (i12 == 2) {
                e<K, V> eVar6 = eVar2.f19978b;
                e<K, V> eVar7 = eVar2.f19979c;
                int i14 = (eVar6 != null ? eVar6.f19985n : 0) - (eVar7 != null ? eVar7.f19985n : 0);
                if (i14 == 1 || (i14 == 0 && !z10)) {
                    rotateRight(eVar);
                } else {
                    rotateLeft(eVar2);
                    rotateRight(eVar);
                }
                if (z10) {
                    return;
                }
            } else if (i12 == 0) {
                eVar.f19985n = i10 + 1;
                if (z10) {
                    return;
                }
            } else {
                eVar.f19985n = Math.max(i10, i11) + 1;
                if (!z10) {
                    return;
                }
            }
            eVar = eVar.f19977a;
        }
    }

    private void replaceInParent(e<K, V> eVar, e<K, V> eVar2) {
        e<K, V> eVar3 = eVar.f19977a;
        eVar.f19977a = null;
        if (eVar2 != null) {
            eVar2.f19977a = eVar3;
        }
        if (eVar3 == null) {
            this.root = eVar2;
        } else if (eVar3.f19978b == eVar) {
            eVar3.f19978b = eVar2;
        } else {
            eVar3.f19979c = eVar2;
        }
    }

    private void rotateLeft(e<K, V> eVar) {
        e<K, V> eVar2 = eVar.f19978b;
        e<K, V> eVar3 = eVar.f19979c;
        e<K, V> eVar4 = eVar3.f19978b;
        e<K, V> eVar5 = eVar3.f19979c;
        eVar.f19979c = eVar4;
        if (eVar4 != null) {
            eVar4.f19977a = eVar;
        }
        replaceInParent(eVar, eVar3);
        eVar3.f19978b = eVar;
        eVar.f19977a = eVar3;
        int iMax = Math.max(eVar2 != null ? eVar2.f19985n : 0, eVar4 != null ? eVar4.f19985n : 0) + 1;
        eVar.f19985n = iMax;
        eVar3.f19985n = Math.max(iMax, eVar5 != null ? eVar5.f19985n : 0) + 1;
    }

    private void rotateRight(e<K, V> eVar) {
        e<K, V> eVar2 = eVar.f19978b;
        e<K, V> eVar3 = eVar.f19979c;
        e<K, V> eVar4 = eVar2.f19978b;
        e<K, V> eVar5 = eVar2.f19979c;
        eVar.f19978b = eVar5;
        if (eVar5 != null) {
            eVar5.f19977a = eVar;
        }
        replaceInParent(eVar, eVar2);
        eVar2.f19979c = eVar;
        eVar.f19977a = eVar2;
        int iMax = Math.max(eVar3 != null ? eVar3.f19985n : 0, eVar5 != null ? eVar5.f19985n : 0) + 1;
        eVar.f19985n = iMax;
        eVar2.f19985n = Math.max(iMax, eVar4 != null ? eVar4.f19985n : 0) + 1;
    }

    private Object writeReplace() throws ObjectStreamException {
        return new LinkedHashMap(this);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        this.root = null;
        this.size = 0;
        this.modCount++;
        e<K, V> eVar = this.header;
        eVar.f19981e = eVar;
        eVar.f19980d = eVar;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object obj) {
        return findByObject(obj) != null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        i<K, V>.b bVar = this.entrySet;
        if (bVar != null) {
            return bVar;
        }
        i<K, V>.b bVar2 = new b();
        this.entrySet = bVar2;
        return bVar2;
    }

    public e<K, V> find(K k10, boolean z10) {
        int iCompareTo;
        e<K, V> eVar;
        Comparator<? super K> comparator = this.comparator;
        e<K, V> eVar2 = this.root;
        if (eVar2 != null) {
            Comparable comparable = comparator == NATURAL_ORDER ? (Comparable) k10 : null;
            while (true) {
                iCompareTo = comparable != null ? comparable.compareTo(eVar2.f19982f) : comparator.compare(k10, eVar2.f19982f);
                if (iCompareTo == 0) {
                    return eVar2;
                }
                e<K, V> eVar3 = iCompareTo < 0 ? eVar2.f19978b : eVar2.f19979c;
                if (eVar3 == null) {
                    break;
                }
                eVar2 = eVar3;
            }
        } else {
            iCompareTo = 0;
        }
        if (!z10) {
            return null;
        }
        e<K, V> eVar4 = this.header;
        if (eVar2 != null) {
            eVar = new e<>(this.allowNullValues, eVar2, k10, eVar4, eVar4.f19981e);
            if (iCompareTo < 0) {
                eVar2.f19978b = eVar;
            } else {
                eVar2.f19979c = eVar;
            }
            rebalance(eVar2, true);
        } else {
            if (comparator == NATURAL_ORDER && !(k10 instanceof Comparable)) {
                throw new ClassCastException(k10.getClass().getName().concat(" is not Comparable"));
            }
            eVar = new e<>(this.allowNullValues, eVar2, k10, eVar4, eVar4.f19981e);
            this.root = eVar;
        }
        this.size++;
        this.modCount++;
        return eVar;
    }

    public e<K, V> findByEntry(Map.Entry<?, ?> entry) {
        e<K, V> eVarFindByObject = findByObject(entry.getKey());
        if (eVarFindByObject == null || !equal(eVarFindByObject.f19984i, entry.getValue())) {
            return null;
        }
        return eVarFindByObject;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public e<K, V> findByObject(Object obj) {
        if (obj == 0) {
            return null;
        }
        try {
            return find(obj, false);
        } catch (ClassCastException unused) {
            return null;
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V get(Object obj) {
        e<K, V> eVarFindByObject = findByObject(obj);
        if (eVarFindByObject != null) {
            return eVarFindByObject.f19984i;
        }
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<K> keySet() {
        i<K, V>.c cVar = this.keySet;
        if (cVar != null) {
            return cVar;
        }
        i<K, V>.c cVar2 = new c();
        this.keySet = cVar2;
        return cVar2;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V put(K k10, V v10) {
        if (k10 == null) {
            throw new NullPointerException("key == null");
        }
        if (v10 == null && !this.allowNullValues) {
            throw new NullPointerException("value == null");
        }
        e<K, V> eVarFind = find(k10, true);
        V v11 = eVarFind.f19984i;
        eVarFind.f19984i = v10;
        return v11;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V remove(Object obj) {
        e<K, V> eVarRemoveInternalByKey = removeInternalByKey(obj);
        if (eVarRemoveInternalByKey != null) {
            return eVarRemoveInternalByKey.f19984i;
        }
        return null;
    }

    public void removeInternal(e<K, V> eVar, boolean z10) {
        int i10;
        if (z10) {
            e<K, V> eVar2 = eVar.f19981e;
            eVar2.f19980d = eVar.f19980d;
            eVar.f19980d.f19981e = eVar2;
        }
        e<K, V> eVar3 = eVar.f19978b;
        e<K, V> eVar4 = eVar.f19979c;
        e<K, V> eVar5 = eVar.f19977a;
        int i11 = 0;
        if (eVar3 == null || eVar4 == null) {
            if (eVar3 != null) {
                replaceInParent(eVar, eVar3);
                eVar.f19978b = null;
            } else if (eVar4 != null) {
                replaceInParent(eVar, eVar4);
                eVar.f19979c = null;
            } else {
                replaceInParent(eVar, null);
            }
            rebalance(eVar5, false);
            this.size--;
            this.modCount++;
            return;
        }
        e<K, V> eVarB = eVar3.f19985n > eVar4.f19985n ? eVar3.b() : eVar4.a();
        removeInternal(eVarB, false);
        e<K, V> eVar6 = eVar.f19978b;
        if (eVar6 != null) {
            i10 = eVar6.f19985n;
            eVarB.f19978b = eVar6;
            eVar6.f19977a = eVarB;
            eVar.f19978b = null;
        } else {
            i10 = 0;
        }
        e<K, V> eVar7 = eVar.f19979c;
        if (eVar7 != null) {
            i11 = eVar7.f19985n;
            eVarB.f19979c = eVar7;
            eVar7.f19977a = eVarB;
            eVar.f19979c = null;
        }
        eVarB.f19985n = Math.max(i10, i11) + 1;
        replaceInParent(eVar, eVarB);
    }

    public e<K, V> removeInternalByKey(Object obj) {
        e<K, V> eVarFindByObject = findByObject(obj);
        if (eVarFindByObject != null) {
            removeInternal(eVarFindByObject, true);
        }
        return eVarFindByObject;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        return this.size;
    }

    public i(boolean z10) {
        this(NATURAL_ORDER, z10);
    }

    public i(Comparator<? super K> comparator, boolean z10) {
        this.size = 0;
        this.modCount = 0;
        this.comparator = comparator == null ? NATURAL_ORDER : comparator;
        this.allowNullValues = z10;
        this.header = new e<>(z10);
    }

    public static final class e<K, V> implements Map.Entry<K, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public e<K, V> f19977a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public e<K, V> f19978b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public e<K, V> f19979c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public e<K, V> f19980d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public e<K, V> f19981e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final K f19982f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final boolean f19983g;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public V f19984i;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public int f19985n;

        public e(boolean z10) {
            this.f19982f = null;
            this.f19983g = z10;
            this.f19981e = this;
            this.f19980d = this;
        }

        public e<K, V> a() {
            e<K, V> eVar = this.f19978b;
            while (true) {
                e<K, V> eVar2 = eVar;
                e<K, V> eVar3 = this;
                this = eVar2;
                if (this == null) {
                    return eVar3;
                }
                eVar = this.f19978b;
            }
        }

        public e<K, V> b() {
            e<K, V> eVar = this.f19979c;
            while (true) {
                e<K, V> eVar2 = eVar;
                e<K, V> eVar3 = this;
                this = eVar2;
                if (this == null) {
                    return eVar3;
                }
                eVar = this.f19979c;
            }
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            K k10 = this.f19982f;
            if (k10 == null) {
                if (entry.getKey() != null) {
                    return false;
                }
            } else if (!k10.equals(entry.getKey())) {
                return false;
            }
            V v10 = this.f19984i;
            if (v10 == null) {
                if (entry.getValue() != null) {
                    return false;
                }
            } else if (!v10.equals(entry.getValue())) {
                return false;
            }
            return true;
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            return this.f19982f;
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            return this.f19984i;
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            K k10 = this.f19982f;
            int iHashCode = k10 == null ? 0 : k10.hashCode();
            V v10 = this.f19984i;
            return iHashCode ^ (v10 != null ? v10.hashCode() : 0);
        }

        @Override // java.util.Map.Entry
        public V setValue(V v10) {
            if (v10 == null && !this.f19983g) {
                throw new NullPointerException("value == null");
            }
            V v11 = this.f19984i;
            this.f19984i = v10;
            return v11;
        }

        public String toString() {
            return this.f19982f + "=" + this.f19984i;
        }

        public e(boolean z10, e<K, V> eVar, K k10, e<K, V> eVar2, e<K, V> eVar3) {
            this.f19977a = eVar;
            this.f19982f = k10;
            this.f19983g = z10;
            this.f19985n = 1;
            this.f19980d = eVar2;
            this.f19981e = eVar3;
            eVar3.f19980d = this;
            eVar2.f19981e = this;
        }
    }
}
