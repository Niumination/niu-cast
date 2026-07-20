package fp;

import java.lang.Comparable;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

/* JADX INFO: loaded from: classes3.dex */
public class v<K extends Comparable<K>, V> extends AbstractMap<K, V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f6296a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public List<v<K, V>.c> f6297b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Map<K, V> f6298c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f6299d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public volatile v<K, V>.e f6300e;

    /* JADX INFO: Add missing generic type declarations: [FieldDescriptorType] */
    public static class a<FieldDescriptorType> extends v<FieldDescriptorType, Object> {
        public a(int i10) {
            super(i10);
        }

        @Override // fp.v, java.util.AbstractMap, java.util.Map
        public /* bridge */ /* synthetic */ Object put(Object obj, Object obj2) {
            return put((h.b) obj, obj2);
        }

        @Override // fp.v
        public void q() {
            if (!this.f6299d) {
                for (int i10 = 0; i10 < this.f6297b.size(); i10++) {
                    Map.Entry<FieldDescriptorType, Object> entryI = i(i10);
                    if (((h.b) entryI.getKey()).isRepeated()) {
                        entryI.setValue(Collections.unmodifiableList((List) entryI.getValue()));
                    }
                }
                for (Map.Entry<FieldDescriptorType, Object> entry : l()) {
                    if (((h.b) entry.getKey()).isRepeated()) {
                        entry.setValue(Collections.unmodifiableList((List) entry.getValue()));
                    }
                }
            }
            super.q();
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final Iterator<Object> f6301a = new a();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final Iterable<Object> f6302b = new C0149b();

        public static class a implements Iterator<Object> {
            @Override // java.util.Iterator
            public boolean hasNext() {
                return false;
            }

            @Override // java.util.Iterator
            public Object next() {
                throw new NoSuchElementException();
            }

            @Override // java.util.Iterator
            public void remove() {
                throw new UnsupportedOperationException();
            }
        }

        /* JADX INFO: renamed from: fp.v$b$b, reason: collision with other inner class name */
        public static class C0149b implements Iterable<Object> {
            @Override // java.lang.Iterable
            public Iterator<Object> iterator() {
                return b.f6301a;
            }
        }

        public static <T> Iterable<T> b() {
            return (Iterable<T>) f6302b;
        }
    }

    public class c implements Comparable<v<K, V>.c>, Map.Entry<K, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final K f6303a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public V f6304b;

        public c(v vVar, Map.Entry<K, V> entry) {
            this(entry.getKey(), entry.getValue());
        }

        @Override // java.lang.Comparable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compareTo(v<K, V>.c cVar) {
            return getKey().compareTo(cVar.getKey());
        }

        public final boolean b(Object obj, Object obj2) {
            if (obj == null) {
                return obj2 == null;
            }
            return obj.equals(obj2);
        }

        @Override // java.util.Map.Entry
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public K getKey() {
            return this.f6303a;
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            return b(this.f6303a, entry.getKey()) && b(this.f6304b, entry.getValue());
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            return this.f6304b;
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            K k10 = this.f6303a;
            int iHashCode = k10 == null ? 0 : k10.hashCode();
            V v10 = this.f6304b;
            return iHashCode ^ (v10 != null ? v10.hashCode() : 0);
        }

        @Override // java.util.Map.Entry
        public V setValue(V v10) {
            v.this.g();
            V v11 = this.f6304b;
            this.f6304b = v10;
            return v11;
        }

        public String toString() {
            String strValueOf = String.valueOf(this.f6303a);
            String strValueOf2 = String.valueOf(this.f6304b);
            StringBuilder sb2 = new StringBuilder(strValueOf2.length() + strValueOf.length() + 1);
            sb2.append(strValueOf);
            sb2.append("=");
            sb2.append(strValueOf2);
            return sb2.toString();
        }

        public c(K k10, V v10) {
            this.f6303a = k10;
            this.f6304b = v10;
        }
    }

    public class e extends AbstractSet<Map.Entry<K, V>> {
        public e() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public boolean add(Map.Entry<K, V> entry) {
            if (contains(entry)) {
                return false;
            }
            v.this.put(entry.getKey(), entry.getValue());
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            v.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            Map.Entry entry = (Map.Entry) obj;
            Object obj2 = v.this.get(entry.getKey());
            Object value = entry.getValue();
            return obj2 == value || (obj2 != null && obj2.equals(value));
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Map.Entry<K, V>> iterator() {
            return new d();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            Map.Entry entry = (Map.Entry) obj;
            if (!contains(entry)) {
                return false;
            }
            v.this.remove(entry.getKey());
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return v.this.size();
        }

        public /* synthetic */ e(v vVar, a aVar) {
            this();
        }
    }

    public /* synthetic */ v(int i10, a aVar) {
        this(i10);
    }

    public static <FieldDescriptorType extends h.b<FieldDescriptorType>> v<FieldDescriptorType, Object> r(int i10) {
        return new a(i10);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        g();
        if (!this.f6297b.isEmpty()) {
            this.f6297b.clear();
        }
        if (this.f6298c.isEmpty()) {
            return;
        }
        this.f6298c.clear();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object obj) {
        Comparable comparable = (Comparable) obj;
        return f(comparable) >= 0 || this.f6298c.containsKey(comparable);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        if (this.f6300e == null) {
            this.f6300e = new e();
        }
        return this.f6300e;
    }

    /* JADX WARN: Code duplicated, block: B:13:0x0026  */
    /* JADX WARN: Code duplicated, block: B:17:0x0042  */
    /* JADX WARN: Code duplicated, block: B:21:0x0040 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:22:0x0046 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:23:0x003c A[SYNTHETIC] */
    public final int f(K k10) {
        int i10;
        int i11;
        int i12;
        int iCompareTo;
        int size = this.f6297b.size();
        int i13 = size - 1;
        if (i13 < 0) {
            i10 = 0;
            while (i10 <= i13) {
                i12 = (i10 + i13) / 2;
                iCompareTo = k10.compareTo(this.f6297b.get(i12).getKey());
                if (iCompareTo < 0) {
                    i13 = i12 - 1;
                } else {
                    if (iCompareTo > 0) {
                        return i12;
                    }
                    i10 = i12 + 1;
                }
            }
            i11 = i10 + 1;
        } else {
            int iCompareTo2 = k10.compareTo(this.f6297b.get(i13).getKey());
            if (iCompareTo2 > 0) {
                i11 = size + 1;
            } else {
                if (iCompareTo2 == 0) {
                    return i13;
                }
                i10 = 0;
                while (i10 <= i13) {
                    i12 = (i10 + i13) / 2;
                    iCompareTo = k10.compareTo(this.f6297b.get(i12).getKey());
                    if (iCompareTo < 0) {
                        i13 = i12 - 1;
                    } else {
                        if (iCompareTo > 0) {
                            return i12;
                        }
                        i10 = i12 + 1;
                    }
                }
                i11 = i10 + 1;
            }
        }
        return -i11;
    }

    public final void g() {
        if (this.f6299d) {
            throw new UnsupportedOperationException();
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V get(Object obj) {
        Comparable comparable = (Comparable) obj;
        int iF = f(comparable);
        return iF >= 0 ? this.f6297b.get(iF).getValue() : this.f6298c.get(comparable);
    }

    public final void h() {
        g();
        if (!this.f6297b.isEmpty() || (this.f6297b instanceof ArrayList)) {
            return;
        }
        this.f6297b = new ArrayList(this.f6296a);
    }

    public Map.Entry<K, V> i(int i10) {
        return this.f6297b.get(i10);
    }

    public int j() {
        return this.f6297b.size();
    }

    public Iterable<Map.Entry<K, V>> l() {
        return this.f6298c.isEmpty() ? b.b() : this.f6298c.entrySet();
    }

    public final SortedMap<K, V> m() {
        g();
        if (this.f6298c.isEmpty() && !(this.f6298c instanceof TreeMap)) {
            this.f6298c = new TreeMap();
        }
        return (SortedMap) this.f6298c;
    }

    public boolean p() {
        return this.f6299d;
    }

    public void q() {
        if (this.f6299d) {
            return;
        }
        this.f6298c = this.f6298c.isEmpty() ? Collections.emptyMap() : Collections.unmodifiableMap(this.f6298c);
        this.f6299d = true;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V remove(Object obj) {
        g();
        Comparable comparable = (Comparable) obj;
        int iF = f(comparable);
        if (iF >= 0) {
            return t(iF);
        }
        if (this.f6298c.isEmpty()) {
            return null;
        }
        return this.f6298c.remove(comparable);
    }

    @Override // java.util.AbstractMap, java.util.Map
    /* JADX INFO: renamed from: s, reason: merged with bridge method [inline-methods] */
    public V put(K k10, V v10) {
        g();
        int iF = f(k10);
        if (iF >= 0) {
            return this.f6297b.get(iF).setValue(v10);
        }
        h();
        int i10 = -(iF + 1);
        if (i10 >= this.f6296a) {
            return m().put(k10, v10);
        }
        int size = this.f6297b.size();
        int i11 = this.f6296a;
        if (size == i11) {
            v<K, V>.c cVarRemove = this.f6297b.remove(i11 - 1);
            m().put(cVarRemove.getKey(), cVarRemove.getValue());
        }
        this.f6297b.add(i10, new c(k10, v10));
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        return this.f6298c.size() + this.f6297b.size();
    }

    public final V t(int i10) {
        g();
        V value = this.f6297b.remove(i10).getValue();
        if (!this.f6298c.isEmpty()) {
            Iterator<Map.Entry<K, V>> it = m().entrySet().iterator();
            this.f6297b.add(new c(this, it.next()));
            it.remove();
        }
        return value;
    }

    public class d implements Iterator<Map.Entry<K, V>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f6306a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f6307b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Iterator<Map.Entry<K, V>> f6308c;

        public d() {
            this.f6306a = -1;
        }

        public final Iterator<Map.Entry<K, V>> a() {
            if (this.f6308c == null) {
                this.f6308c = v.this.f6298c.entrySet().iterator();
            }
            return this.f6308c;
        }

        @Override // java.util.Iterator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public Map.Entry<K, V> next() {
            this.f6307b = true;
            int i10 = this.f6306a + 1;
            this.f6306a = i10;
            return i10 < v.this.f6297b.size() ? v.this.f6297b.get(this.f6306a) : a().next();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f6306a + 1 < v.this.f6297b.size() || a().hasNext();
        }

        @Override // java.util.Iterator
        public void remove() {
            if (!this.f6307b) {
                throw new IllegalStateException("remove() was called before next()");
            }
            this.f6307b = false;
            v.this.g();
            if (this.f6306a >= v.this.f6297b.size()) {
                a().remove();
                return;
            }
            v vVar = v.this;
            int i10 = this.f6306a;
            this.f6306a = i10 - 1;
            vVar.t(i10);
        }

        public /* synthetic */ d(v vVar, a aVar) {
            this();
        }
    }

    public v(int i10) {
        this.f6296a = i10;
        this.f6297b = Collections.emptyList();
        this.f6298c = Collections.emptyMap();
    }
}
