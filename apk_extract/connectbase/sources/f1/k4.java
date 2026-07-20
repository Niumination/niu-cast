package f1;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Arrays;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
@b1.b(emulated = true, serializable = true)
@x0
public final class k4<K, V> extends l4<K, V> {

    @b1.e
    static final double VALUE_SET_LOAD_FACTOR = 1.0d;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final int f5026n = 16;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final int f5027p = 2;

    @b1.c
    @b1.d
    private static final long serialVersionUID = 1;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public transient b<K, V> f5028i;

    @b1.e
    transient int valueSetCapacity;

    public class a implements Iterator<Map.Entry<K, V>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public b<K, V> f5029a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @gm.a
        public b<K, V> f5030b;

        public a() {
            this.f5029a = k4.this.f5028i.getSuccessorInMultimap();
        }

        @Override // java.util.Iterator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Map.Entry<K, V> next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            b<K, V> bVar = this.f5029a;
            this.f5030b = bVar;
            this.f5029a = bVar.getSuccessorInMultimap();
            return bVar;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f5029a != k4.this.f5028i;
        }

        @Override // java.util.Iterator
        public void remove() {
            c1.h0.h0(this.f5030b != null, "no calls to next() since the last call to remove()");
            k4.this.remove(this.f5030b.getKey(), this.f5030b.getValue());
            this.f5030b = null;
        }
    }

    @b1.e
    public static final class b<K, V> extends f3<K, V> implements d<K, V> {

        @gm.a
        b<K, V> nextInValueBucket;

        @gm.a
        b<K, V> predecessorInMultimap;

        @gm.a
        d<K, V> predecessorInValueSet;
        final int smearedValueHash;

        @gm.a
        b<K, V> successorInMultimap;

        @gm.a
        d<K, V> successorInValueSet;

        public b(@m5 K key, @m5 V value, int smearedValueHash, @gm.a b<K, V> nextInValueBucket) {
            super(key, value);
            this.smearedValueHash = smearedValueHash;
            this.nextInValueBucket = nextInValueBucket;
        }

        public static <K, V> b<K, V> newHeader() {
            return new b<>(null, null, 0, null);
        }

        public b<K, V> getPredecessorInMultimap() {
            b<K, V> bVar = this.predecessorInMultimap;
            Objects.requireNonNull(bVar);
            return bVar;
        }

        @Override // f1.k4.d
        public d<K, V> getPredecessorInValueSet() {
            d<K, V> dVar = this.predecessorInValueSet;
            Objects.requireNonNull(dVar);
            return dVar;
        }

        public b<K, V> getSuccessorInMultimap() {
            b<K, V> bVar = this.successorInMultimap;
            Objects.requireNonNull(bVar);
            return bVar;
        }

        @Override // f1.k4.d
        public d<K, V> getSuccessorInValueSet() {
            d<K, V> dVar = this.successorInValueSet;
            Objects.requireNonNull(dVar);
            return dVar;
        }

        public boolean matchesValue(@gm.a Object v10, int smearedVHash) {
            return this.smearedValueHash == smearedVHash && c1.b0.a(getValue(), v10);
        }

        public void setPredecessorInMultimap(b<K, V> multimapPredecessor) {
            this.predecessorInMultimap = multimapPredecessor;
        }

        @Override // f1.k4.d
        public void setPredecessorInValueSet(d<K, V> entry) {
            this.predecessorInValueSet = entry;
        }

        public void setSuccessorInMultimap(b<K, V> multimapSuccessor) {
            this.successorInMultimap = multimapSuccessor;
        }

        @Override // f1.k4.d
        public void setSuccessorInValueSet(d<K, V> entry) {
            this.successorInValueSet = entry;
        }
    }

    @b1.e
    public final class c extends k6.k<V> implements d<K, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @m5
        public final K f5032a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @b1.e
        public b<K, V>[] f5033b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f5034c = 0;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f5035d = 0;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public d<K, V> f5036e = this;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public d<K, V> f5037f = this;

        public class a implements Iterator<V> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public d<K, V> f5039a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            @gm.a
            public b<K, V> f5040b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public int f5041c;

            public a() {
                this.f5039a = c.this.f5036e;
                this.f5041c = c.this.f5035d;
            }

            public final void a() {
                if (c.this.f5035d != this.f5041c) {
                    throw new ConcurrentModificationException();
                }
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                a();
                return this.f5039a != c.this;
            }

            @Override // java.util.Iterator
            @m5
            public V next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                b<K, V> bVar = (b) this.f5039a;
                V value = bVar.getValue();
                this.f5040b = bVar;
                this.f5039a = bVar.getSuccessorInValueSet();
                return value;
            }

            @Override // java.util.Iterator
            public void remove() {
                a();
                c1.h0.h0(this.f5040b != null, "no calls to next() since the last call to remove()");
                c.this.remove(this.f5040b.getValue());
                this.f5041c = c.this.f5035d;
                this.f5040b = null;
            }
        }

        public c(K key, int expectedValues) {
            this.f5032a = key;
            this.f5033b = new b[z2.a(expectedValues, 1.0d)];
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean add(@m5 V value) {
            int iD = z2.d(value);
            int iC = c() & iD;
            b<K, V> bVar = this.f5033b[iC];
            for (b<K, V> bVar2 = bVar; bVar2 != null; bVar2 = bVar2.nextInValueBucket) {
                if (bVar2.matchesValue(value, iD)) {
                    return false;
                }
            }
            b<K, V> bVar3 = new b<>(this.f5032a, value, iD, bVar);
            k4.i(this.f5037f, bVar3);
            k4.i(bVar3, this);
            k4.h(k4.this.f5028i.getPredecessorInMultimap(), bVar3);
            k4.h(bVar3, k4.this.f5028i);
            this.f5033b[iC] = bVar3;
            this.f5034c++;
            this.f5035d++;
            e();
            return true;
        }

        public final int c() {
            return this.f5033b.length - 1;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            Arrays.fill(this.f5033b, (Object) null);
            this.f5034c = 0;
            for (d<K, V> successorInValueSet = this.f5036e; successorInValueSet != this; successorInValueSet = successorInValueSet.getSuccessorInValueSet()) {
                k4.e((b) successorInValueSet);
            }
            k4.i(this, this);
            this.f5035d++;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(@gm.a Object o10) {
            int iD = z2.d(o10);
            for (b<K, V> bVar = this.f5033b[c() & iD]; bVar != null; bVar = bVar.nextInValueBucket) {
                if (bVar.matchesValue(o10, iD)) {
                    return true;
                }
            }
            return false;
        }

        public final void e() {
            if (z2.b(this.f5034c, this.f5033b.length, 1.0d)) {
                int length = this.f5033b.length * 2;
                b<K, V>[] bVarArr = new b[length];
                this.f5033b = bVarArr;
                int i10 = length - 1;
                for (d<K, V> successorInValueSet = this.f5036e; successorInValueSet != this; successorInValueSet = successorInValueSet.getSuccessorInValueSet()) {
                    b<K, V> bVar = (b) successorInValueSet;
                    int i11 = bVar.smearedValueHash & i10;
                    bVar.nextInValueBucket = bVarArr[i11];
                    bVarArr[i11] = bVar;
                }
            }
        }

        @Override // f1.k4.d
        public d<K, V> getPredecessorInValueSet() {
            return this.f5037f;
        }

        @Override // f1.k4.d
        public d<K, V> getSuccessorInValueSet() {
            return this.f5036e;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<V> iterator() {
            return new a();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        @t1.a
        public boolean remove(@gm.a Object o10) {
            int iD = z2.d(o10);
            int iC = c() & iD;
            b<K, V> bVar = null;
            for (b<K, V> bVar2 = this.f5033b[iC]; bVar2 != null; bVar2 = bVar2.nextInValueBucket) {
                if (bVar2.matchesValue(o10, iD)) {
                    if (bVar == null) {
                        this.f5033b[iC] = bVar2.nextInValueBucket;
                    } else {
                        bVar.nextInValueBucket = bVar2.nextInValueBucket;
                    }
                    k4.g(bVar2);
                    k4.e(bVar2);
                    this.f5034c--;
                    this.f5035d++;
                    return true;
                }
                bVar = bVar2;
            }
            return false;
        }

        @Override // f1.k4.d
        public void setPredecessorInValueSet(d<K, V> entry) {
            this.f5037f = entry;
        }

        @Override // f1.k4.d
        public void setSuccessorInValueSet(d<K, V> entry) {
            this.f5036e = entry;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return this.f5034c;
        }
    }

    public interface d<K, V> {
        d<K, V> getPredecessorInValueSet();

        d<K, V> getSuccessorInValueSet();

        void setPredecessorInValueSet(d<K, V> entry);

        void setSuccessorInValueSet(d<K, V> entry);
    }

    public k4(int keyCapacity, int valueSetCapacity) {
        super(g0.createWithExpectedSize(keyCapacity));
        this.valueSetCapacity = 2;
        b0.b(valueSetCapacity, "expectedValuesPerKey");
        this.valueSetCapacity = valueSetCapacity;
        b<K, V> bVarNewHeader = b.newHeader();
        this.f5028i = bVarNewHeader;
        h(bVarNewHeader, bVarNewHeader);
    }

    public static <K, V> k4<K, V> create() {
        return new k4<>(16, 2);
    }

    public static <K, V> void e(b<K, V> entry) {
        h(entry.getPredecessorInMultimap(), entry.getSuccessorInMultimap());
    }

    public static <K, V> void g(d<K, V> entry) {
        i(entry.getPredecessorInValueSet(), entry.getSuccessorInValueSet());
    }

    public static <K, V> void h(b<K, V> pred, b<K, V> succ) {
        pred.setSuccessorInMultimap(succ);
        succ.setPredecessorInMultimap(pred);
    }

    public static <K, V> void i(d<K, V> pred, d<K, V> succ) {
        pred.setSuccessorInValueSet(succ);
        succ.setPredecessorInValueSet(pred);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @b1.c
    @b1.d
    private void readObject(ObjectInputStream stream) throws ClassNotFoundException, IOException {
        stream.defaultReadObject();
        b<K, V> bVarNewHeader = b.newHeader();
        this.f5028i = bVarNewHeader;
        h(bVarNewHeader, bVarNewHeader);
        this.valueSetCapacity = 2;
        int i10 = stream.readInt();
        g0 g0VarCreateWithExpectedSize = g0.createWithExpectedSize(12);
        for (int i11 = 0; i11 < i10; i11++) {
            Object object = stream.readObject();
            g0VarCreateWithExpectedSize.put(object, createCollection(object));
        }
        int i12 = stream.readInt();
        for (int i13 = 0; i13 < i12; i13++) {
            Object object2 = stream.readObject();
            Object object3 = stream.readObject();
            Collection collection = (Collection) g0VarCreateWithExpectedSize.get(object2);
            Objects.requireNonNull(collection);
            collection.add(object3);
        }
        setMap(g0VarCreateWithExpectedSize);
    }

    @b1.c
    @b1.d
    private void writeObject(ObjectOutputStream stream) throws IOException {
        stream.defaultWriteObject();
        stream.writeInt(keySet().size());
        Iterator<K> it = keySet().iterator();
        while (it.hasNext()) {
            stream.writeObject(it.next());
        }
        stream.writeInt(size());
        for (Map.Entry<K, V> entry : entries()) {
            stream.writeObject(entry.getKey());
            stream.writeObject(entry.getValue());
        }
    }

    @Override // f1.m, f1.h, f1.v4, f1.j6
    public /* bridge */ /* synthetic */ Map asMap() {
        return super.asMap();
    }

    @Override // f1.e, f1.v4
    public void clear() {
        super.clear();
        b<K, V> bVar = this.f5028i;
        h(bVar, bVar);
    }

    @Override // f1.h, f1.v4
    public /* bridge */ /* synthetic */ boolean containsEntry(@gm.a Object key, @gm.a Object value) {
        return super.containsEntry(key, value);
    }

    @Override // f1.e, f1.v4
    public /* bridge */ /* synthetic */ boolean containsKey(@gm.a Object key) {
        return super.containsKey(key);
    }

    @Override // f1.h, f1.v4
    public /* bridge */ /* synthetic */ boolean containsValue(@gm.a Object value) {
        return super.containsValue(value);
    }

    @Override // f1.e, f1.h
    public Iterator<Map.Entry<K, V>> entryIterator() {
        return new a();
    }

    @Override // f1.m, f1.h, f1.v4, f1.o4
    public /* bridge */ /* synthetic */ boolean equals(@gm.a Object object) {
        return super.equals(object);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // f1.m, f1.e, f1.v4, f1.o4
    public /* bridge */ /* synthetic */ Set get(@m5 Object key) {
        return super.get(key);
    }

    @Override // f1.h, f1.v4
    public /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    @Override // f1.h, f1.v4
    public /* bridge */ /* synthetic */ boolean isEmpty() {
        return super.isEmpty();
    }

    @Override // f1.h, f1.v4
    public Set<K> keySet() {
        return super.keySet();
    }

    @Override // f1.h, f1.v4
    public /* bridge */ /* synthetic */ b5 keys() {
        return super.keys();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // f1.m, f1.e, f1.h, f1.v4
    @t1.a
    public /* bridge */ /* synthetic */ boolean put(@m5 Object key, @m5 Object value) {
        return super.put(key, value);
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

    @Override // f1.m, f1.e, f1.v4, f1.o4
    @t1.a
    public /* bridge */ /* synthetic */ Set removeAll(@gm.a Object key) {
        return super.removeAll(key);
    }

    @Override // f1.e, f1.v4
    public /* bridge */ /* synthetic */ int size() {
        return super.size();
    }

    @Override // f1.h
    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }

    @Override // f1.e, f1.h
    public Iterator<V> valueIterator() {
        return new t4.f(entryIterator());
    }

    @Override // f1.e, f1.h, f1.v4
    public Collection<V> values() {
        return super.values();
    }

    public static <K, V> k4<K, V> create(int expectedKeys, int expectedValuesPerKey) {
        return new k4<>(t4.o(expectedKeys), t4.o(expectedValuesPerKey));
    }

    @Override // f1.m, f1.e
    public Set<V> createCollection() {
        return h0.createWithExpectedSize(this.valueSetCapacity);
    }

    @Override // f1.m, f1.e, f1.h, f1.v4
    public Set<Map.Entry<K, V>> entries() {
        return super.entries();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // f1.h, f1.v4
    @t1.a
    public /* bridge */ /* synthetic */ boolean putAll(@m5 Object key, Iterable values) {
        return super.putAll(key, values);
    }

    @Override // f1.m, f1.e, f1.h, f1.v4, f1.o4
    @t1.a
    public Set<V> replaceValues(@m5 K key, Iterable<? extends V> values) {
        return super.replaceValues((Object) key, (Iterable) values);
    }

    public static <K, V> k4<K, V> create(v4<? extends K, ? extends V> multimap) {
        k4<K, V> k4VarCreate = create(multimap.keySet().size(), 2);
        k4VarCreate.putAll(multimap);
        return k4VarCreate;
    }

    @Override // f1.e
    public Collection<V> createCollection(@m5 K key) {
        return new c(key, this.valueSetCapacity);
    }
}
