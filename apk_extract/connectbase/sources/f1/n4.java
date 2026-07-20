package f1;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.AbstractSequentialList;
import java.util.Collection;
import java.util.Collections;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
@b1.b(emulated = true, serializable = true)
@x0
public class n4<K, V> extends f1.h<K, V> implements o4<K, V>, Serializable {

    @b1.c
    @b1.d
    private static final long serialVersionUID = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @gm.a
    public transient g<K, V> f5115f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @gm.a
    public transient g<K, V> f5116g;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public transient Map<K, f<K, V>> f5117i;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public transient int f5118n;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public transient int f5119p;

    public class a extends AbstractSequentialList<V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Object f5120a;

        public a(final Object val$key) {
            this.f5120a = val$key;
        }

        @Override // java.util.AbstractSequentialList, java.util.AbstractList, java.util.List
        public ListIterator<V> listIterator(int index) {
            return new i(this.f5120a, index);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            f fVar = (f) n4.this.f5117i.get(this.f5120a);
            if (fVar == null) {
                return 0;
            }
            return fVar.f5133c;
        }
    }

    public class b extends AbstractSequentialList<Map.Entry<K, V>> {
        public b() {
        }

        @Override // java.util.AbstractSequentialList, java.util.AbstractList, java.util.List
        public ListIterator<Map.Entry<K, V>> listIterator(int index) {
            return new h(index);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return n4.this.f5118n;
        }
    }

    public class c extends k6.k<K> {
        public c() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(@gm.a Object key) {
            return n4.this.containsKey(key);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<K> iterator() {
            return new e();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(@gm.a Object o10) {
            return !n4.this.removeAll(o10).isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return n4.this.f5117i.size();
        }
    }

    public class d extends AbstractSequentialList<V> {

        public class a extends p7<Map.Entry<K, V>, V> {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ h f5125b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(final d this$1, ListIterator backingIterator, final h val$nodeItr) {
                super((Iterator) backingIterator);
                this.f5125b = val$nodeItr;
            }

            @Override // f1.o7
            @m5
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public V a(Map.Entry<K, V> entry) {
                return entry.getValue();
            }

            @Override // f1.p7, java.util.ListIterator
            public void set(@m5 V value) {
                this.f5125b.f(value);
            }
        }

        public d() {
        }

        @Override // java.util.AbstractSequentialList, java.util.AbstractList, java.util.List
        public ListIterator<V> listIterator(int index) {
            h hVar = new h(index);
            return new a(this, hVar, hVar);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return n4.this.f5118n;
        }
    }

    public static class f<K, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public g<K, V> f5131a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public g<K, V> f5132b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f5133c;

        public f(g<K, V> firstNode) {
            this.f5131a = firstNode;
            this.f5132b = firstNode;
            firstNode.f5139f = null;
            firstNode.f5138e = null;
            this.f5133c = 1;
        }
    }

    public static final class g<K, V> extends f1.g<K, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @m5
        public final K f5134a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @m5
        public V f5135b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @gm.a
        public g<K, V> f5136c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @gm.a
        public g<K, V> f5137d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        @gm.a
        public g<K, V> f5138e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        @gm.a
        public g<K, V> f5139f;

        public g(@m5 K key, @m5 V value) {
            this.f5134a = key;
            this.f5135b = value;
        }

        @Override // f1.g, java.util.Map.Entry
        @m5
        public K getKey() {
            return this.f5134a;
        }

        @Override // f1.g, java.util.Map.Entry
        @m5
        public V getValue() {
            return this.f5135b;
        }

        @Override // f1.g, java.util.Map.Entry
        @m5
        public V setValue(@m5 V newValue) {
            V v10 = this.f5135b;
            this.f5135b = newValue;
            return v10;
        }
    }

    public class h implements ListIterator<Map.Entry<K, V>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f5140a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @gm.a
        public g<K, V> f5141b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @gm.a
        public g<K, V> f5142c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @gm.a
        public g<K, V> f5143d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f5144e;

        public h(int index) {
            this.f5144e = n4.this.f5119p;
            int size = n4.this.size();
            c1.h0.d0(index, size);
            if (index < size / 2) {
                this.f5141b = n4.this.f5115f;
                while (true) {
                    int i10 = index - 1;
                    if (index <= 0) {
                        break;
                    }
                    next();
                    index = i10;
                }
            } else {
                this.f5143d = n4.this.f5116g;
                this.f5140a = size;
                while (true) {
                    int i11 = index + 1;
                    if (index >= size) {
                        break;
                    }
                    previous();
                    index = i11;
                }
            }
            this.f5142c = null;
        }

        @Override // java.util.ListIterator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void add(Map.Entry<K, V> e10) {
            throw new UnsupportedOperationException();
        }

        public final void b() {
            if (n4.this.f5119p != this.f5144e) {
                throw new ConcurrentModificationException();
            }
        }

        @Override // java.util.ListIterator, java.util.Iterator
        @t1.a
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public g<K, V> next() {
            b();
            g<K, V> gVar = this.f5141b;
            if (gVar == null) {
                throw new NoSuchElementException();
            }
            this.f5142c = gVar;
            this.f5143d = gVar;
            this.f5141b = gVar.f5136c;
            this.f5140a++;
            return gVar;
        }

        @Override // java.util.ListIterator
        @t1.a
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public g<K, V> previous() {
            b();
            g<K, V> gVar = this.f5143d;
            if (gVar == null) {
                throw new NoSuchElementException();
            }
            this.f5142c = gVar;
            this.f5141b = gVar;
            this.f5143d = gVar.f5137d;
            this.f5140a--;
            return gVar;
        }

        @Override // java.util.ListIterator
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public void set(Map.Entry<K, V> e10) {
            throw new UnsupportedOperationException();
        }

        public void f(@m5 V value) {
            c1.h0.g0(this.f5142c != null);
            this.f5142c.f5135b = value;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public boolean hasNext() {
            b();
            return this.f5141b != null;
        }

        @Override // java.util.ListIterator
        public boolean hasPrevious() {
            b();
            return this.f5143d != null;
        }

        @Override // java.util.ListIterator
        public int nextIndex() {
            return this.f5140a;
        }

        @Override // java.util.ListIterator
        public int previousIndex() {
            return this.f5140a - 1;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public void remove() {
            b();
            c1.h0.h0(this.f5142c != null, "no calls to next() since the last call to remove()");
            g<K, V> gVar = this.f5142c;
            if (gVar != this.f5141b) {
                this.f5143d = gVar.f5137d;
                this.f5140a--;
            } else {
                this.f5141b = gVar.f5136c;
            }
            n4.this.e(gVar);
            this.f5142c = null;
            this.f5144e = n4.this.f5119p;
        }
    }

    public n4() {
        this(12);
    }

    public static <K, V> n4<K, V> create() {
        return new n4<>();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @b1.c
    @b1.d
    private void readObject(ObjectInputStream stream) throws ClassNotFoundException, IOException {
        stream.defaultReadObject();
        this.f5117i = g0.create();
        int i10 = stream.readInt();
        for (int i11 = 0; i11 < i10; i11++) {
            put(stream.readObject(), stream.readObject());
        }
    }

    @b1.c
    @b1.d
    private void writeObject(ObjectOutputStream stream) throws IOException {
        stream.defaultWriteObject();
        stream.writeInt(size());
        for (Map.Entry<K, V> entry : entries()) {
            stream.writeObject(entry.getKey());
            stream.writeObject(entry.getValue());
        }
    }

    @Override // f1.h, f1.v4, f1.j6
    public /* bridge */ /* synthetic */ Map asMap() {
        return super.asMap();
    }

    @t1.a
    public final g<K, V> b(@m5 K key, @m5 V value, @gm.a g<K, V> nextSibling) {
        g<K, V> gVar = new g<>(key, value);
        if (this.f5115f == null) {
            this.f5116g = gVar;
            this.f5115f = gVar;
            this.f5117i.put(key, new f<>(gVar));
            this.f5119p++;
        } else if (nextSibling == null) {
            g<K, V> gVar2 = this.f5116g;
            Objects.requireNonNull(gVar2);
            gVar2.f5136c = gVar;
            gVar.f5137d = this.f5116g;
            this.f5116g = gVar;
            f<K, V> fVar = this.f5117i.get(key);
            if (fVar == null) {
                this.f5117i.put(key, new f<>(gVar));
                this.f5119p++;
            } else {
                fVar.f5133c++;
                g<K, V> gVar3 = fVar.f5132b;
                gVar3.f5138e = gVar;
                gVar.f5139f = gVar3;
                fVar.f5132b = gVar;
            }
        } else {
            f<K, V> fVar2 = this.f5117i.get(key);
            Objects.requireNonNull(fVar2);
            fVar2.f5133c++;
            gVar.f5137d = nextSibling.f5137d;
            gVar.f5139f = nextSibling.f5139f;
            gVar.f5136c = nextSibling;
            gVar.f5138e = nextSibling;
            g<K, V> gVar4 = nextSibling.f5139f;
            if (gVar4 == null) {
                fVar2.f5131a = gVar;
            } else {
                gVar4.f5138e = gVar;
            }
            g<K, V> gVar5 = nextSibling.f5137d;
            if (gVar5 == null) {
                this.f5115f = gVar;
            } else {
                gVar5.f5136c = gVar;
            }
            nextSibling.f5137d = gVar;
            nextSibling.f5139f = gVar;
        }
        this.f5118n++;
        return gVar;
    }

    public final List<V> c(@m5 K key) {
        return Collections.unmodifiableList(p4.s(new i(key)));
    }

    @Override // f1.v4
    public void clear() {
        this.f5115f = null;
        this.f5116g = null;
        this.f5117i.clear();
        this.f5118n = 0;
        this.f5119p++;
    }

    @Override // f1.h, f1.v4
    public /* bridge */ /* synthetic */ boolean containsEntry(@gm.a Object key, @gm.a Object value) {
        return super.containsEntry(key, value);
    }

    @Override // f1.v4
    public boolean containsKey(@gm.a Object key) {
        return this.f5117i.containsKey(key);
    }

    @Override // f1.h, f1.v4
    public boolean containsValue(@gm.a Object value) {
        return values().contains(value);
    }

    @Override // f1.h
    public Map<K, Collection<V>> createAsMap() {
        return new y4.a(this);
    }

    @Override // f1.h
    public Set<K> createKeySet() {
        return new c();
    }

    @Override // f1.h
    public b5<K> createKeys() {
        return new y4.g(this);
    }

    public final void d(@m5 K key) {
        h4.h(new i(key));
    }

    public final void e(g<K, V> node) {
        g<K, V> gVar = node.f5137d;
        if (gVar != null) {
            gVar.f5136c = node.f5136c;
        } else {
            this.f5115f = node.f5136c;
        }
        g<K, V> gVar2 = node.f5136c;
        if (gVar2 != null) {
            gVar2.f5137d = gVar;
        } else {
            this.f5116g = gVar;
        }
        if (node.f5139f == null && node.f5138e == null) {
            f<K, V> fVarRemove = this.f5117i.remove(node.f5134a);
            Objects.requireNonNull(fVarRemove);
            fVarRemove.f5133c = 0;
            this.f5119p++;
        } else {
            f<K, V> fVar = this.f5117i.get(node.f5134a);
            Objects.requireNonNull(fVar);
            fVar.f5133c--;
            g<K, V> gVar3 = node.f5139f;
            if (gVar3 == null) {
                g<K, V> gVar4 = node.f5138e;
                Objects.requireNonNull(gVar4);
                fVar.f5131a = gVar4;
            } else {
                gVar3.f5138e = node.f5138e;
            }
            g<K, V> gVar5 = node.f5138e;
            if (gVar5 == null) {
                g<K, V> gVar6 = node.f5139f;
                Objects.requireNonNull(gVar6);
                fVar.f5132b = gVar6;
            } else {
                gVar5.f5139f = node.f5139f;
            }
        }
        this.f5118n--;
    }

    @Override // f1.h
    public Iterator<Map.Entry<K, V>> entryIterator() {
        throw new AssertionError("should never be called");
    }

    @Override // f1.h, f1.v4, f1.o4
    public /* bridge */ /* synthetic */ boolean equals(@gm.a Object object) {
        return super.equals(object);
    }

    @Override // f1.h, f1.v4
    public /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    @Override // f1.h, f1.v4
    public boolean isEmpty() {
        return this.f5115f == null;
    }

    @Override // f1.h, f1.v4
    public /* bridge */ /* synthetic */ Set keySet() {
        return super.keySet();
    }

    @Override // f1.h, f1.v4
    public /* bridge */ /* synthetic */ b5 keys() {
        return super.keys();
    }

    @Override // f1.h, f1.v4
    @t1.a
    public boolean put(@m5 K key, @m5 V value) {
        b(key, value, null);
        return true;
    }

    @Override // f1.h, f1.v4
    @t1.a
    public /* bridge */ /* synthetic */ boolean putAll(v4 multimap) {
        return super.putAll(multimap);
    }

    @Override // f1.h, f1.v4
    @t1.a
    public /* bridge */ /* synthetic */ boolean remove(@gm.a Object key, @gm.a Object value) {
        return super.remove(key, value);
    }

    @Override // f1.v4
    public int size() {
        return this.f5118n;
    }

    @Override // f1.h
    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }

    public n4(int expectedKeys) {
        this.f5117i = d0.createWithExpectedSize(expectedKeys);
    }

    public static <K, V> n4<K, V> create(int expectedKeys) {
        return new n4<>(expectedKeys);
    }

    @Override // f1.h
    public List<Map.Entry<K, V>> createEntries() {
        return new b();
    }

    @Override // f1.h
    public List<V> createValues() {
        return new d();
    }

    @Override // f1.h, f1.v4
    public List<Map.Entry<K, V>> entries() {
        return (List) super.entries();
    }

    @Override // f1.v4, f1.o4
    public List<V> get(@m5 final K key) {
        return new a(key);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // f1.h, f1.v4
    @t1.a
    public /* bridge */ /* synthetic */ boolean putAll(@m5 Object key, Iterable values) {
        return super.putAll(key, values);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // f1.v4, f1.o4
    @t1.a
    public List<V> removeAll(@gm.a Object key) {
        List<V> listC = c(key);
        d(key);
        return listC;
    }

    @Override // f1.h, f1.v4, f1.o4
    @t1.a
    public List<V> replaceValues(@m5 K key, Iterable<? extends V> values) {
        List<V> listC = c(key);
        i iVar = new i(key);
        Iterator<? extends V> it = values.iterator();
        while (iVar.hasNext() && it.hasNext()) {
            iVar.next();
            iVar.set(it.next());
        }
        while (iVar.hasNext()) {
            iVar.next();
            iVar.remove();
        }
        while (it.hasNext()) {
            iVar.add(it.next());
        }
        return listC;
    }

    @Override // f1.h, f1.v4
    public List<V> values() {
        return (List) super.values();
    }

    public static <K, V> n4<K, V> create(v4<? extends K, ? extends V> multimap) {
        return new n4<>(multimap);
    }

    public class e implements Iterator<K> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Set<K> f5126a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @gm.a
        public g<K, V> f5127b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @gm.a
        public g<K, V> f5128c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f5129d;

        public e() {
            this.f5126a = k6.y(n4.this.keySet().size());
            this.f5127b = n4.this.f5115f;
            this.f5129d = n4.this.f5119p;
        }

        public final void a() {
            if (n4.this.f5119p != this.f5129d) {
                throw new ConcurrentModificationException();
            }
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            a();
            return this.f5127b != null;
        }

        @Override // java.util.Iterator
        @m5
        public K next() {
            g<K, V> gVar;
            a();
            g<K, V> gVar2 = this.f5127b;
            if (gVar2 == null) {
                throw new NoSuchElementException();
            }
            this.f5128c = gVar2;
            this.f5126a.add(gVar2.f5134a);
            do {
                gVar = this.f5127b.f5136c;
                this.f5127b = gVar;
                if (gVar == null) {
                    break;
                }
            } while (!this.f5126a.add(gVar.f5134a));
            return this.f5128c.f5134a;
        }

        @Override // java.util.Iterator
        public void remove() {
            a();
            c1.h0.h0(this.f5128c != null, "no calls to next() since the last call to remove()");
            n4.this.d(this.f5128c.f5134a);
            this.f5128c = null;
            this.f5129d = n4.this.f5119p;
        }

        public /* synthetic */ e(n4 n4Var, a aVar) {
            this();
        }
    }

    public class i implements ListIterator<V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @m5
        public final K f5146a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f5147b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @gm.a
        public g<K, V> f5148c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @gm.a
        public g<K, V> f5149d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        @gm.a
        public g<K, V> f5150e;

        public i(K key) {
            this.f5146a = key;
            f fVar = (f) n4.this.f5117i.get(key);
            this.f5148c = fVar == null ? null : fVar.f5131a;
        }

        @Override // java.util.ListIterator
        public void add(@m5 V value) {
            this.f5150e = n4.this.b(this.f5146a, value, this.f5148c);
            this.f5147b++;
            this.f5149d = null;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public boolean hasNext() {
            return this.f5148c != null;
        }

        @Override // java.util.ListIterator
        public boolean hasPrevious() {
            return this.f5150e != null;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        @t1.a
        @m5
        public V next() {
            g<K, V> gVar = this.f5148c;
            if (gVar == null) {
                throw new NoSuchElementException();
            }
            this.f5149d = gVar;
            this.f5150e = gVar;
            this.f5148c = gVar.f5138e;
            this.f5147b++;
            return gVar.f5135b;
        }

        @Override // java.util.ListIterator
        public int nextIndex() {
            return this.f5147b;
        }

        @Override // java.util.ListIterator
        @t1.a
        @m5
        public V previous() {
            g<K, V> gVar = this.f5150e;
            if (gVar == null) {
                throw new NoSuchElementException();
            }
            this.f5149d = gVar;
            this.f5148c = gVar;
            this.f5150e = gVar.f5139f;
            this.f5147b--;
            return gVar.f5135b;
        }

        @Override // java.util.ListIterator
        public int previousIndex() {
            return this.f5147b - 1;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public void remove() {
            c1.h0.h0(this.f5149d != null, "no calls to next() since the last call to remove()");
            g<K, V> gVar = this.f5149d;
            if (gVar != this.f5148c) {
                this.f5150e = gVar.f5139f;
                this.f5147b--;
            } else {
                this.f5148c = gVar.f5138e;
            }
            n4.this.e(gVar);
            this.f5149d = null;
        }

        @Override // java.util.ListIterator
        public void set(@m5 V value) {
            c1.h0.g0(this.f5149d != null);
            this.f5149d.f5135b = value;
        }

        public i(K key, int index) {
            f fVar = (f) n4.this.f5117i.get(key);
            int i10 = fVar == null ? 0 : fVar.f5133c;
            c1.h0.d0(index, i10);
            if (index >= i10 / 2) {
                this.f5150e = fVar == null ? null : fVar.f5132b;
                this.f5147b = i10;
                while (true) {
                    int i11 = index + 1;
                    if (index >= i10) {
                        break;
                    }
                    previous();
                    index = i11;
                }
            } else {
                this.f5148c = fVar == null ? null : fVar.f5131a;
                while (true) {
                    int i12 = index - 1;
                    if (index <= 0) {
                        break;
                    }
                    next();
                    index = i12;
                }
            }
            this.f5146a = key;
            this.f5149d = null;
        }
    }

    public n4(v4<? extends K, ? extends V> multimap) {
        this(multimap.keySet().size());
        putAll(multimap);
    }
}
