package f1;

import com.google.j2objc.annotations.RetainedWith;
import com.google.j2objc.annotations.Weak;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
@b1.b(emulated = true, serializable = true)
@x0
public class u3<K, V> extends o3<K, V> implements j6<K, V> {

    @b1.c
    @b1.d
    private static final long serialVersionUID = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final transient t3<V> f5394f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @u1.b
    @RetainedWith
    @gm.a
    public transient u3<V, K> f5395g;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @u1.b
    @RetainedWith
    @gm.a
    public transient t3<Map.Entry<K, V>> f5396i;

    public static final class a<K, V> extends o3.c<K, V> {
        @Override // f1.o3.c
        @t1.a
        public o3.c b(o3.c other) {
            super.b(other);
            return this;
        }

        @Override // f1.o3.c
        public Collection<V> c() {
            return e0.create();
        }

        @Override // f1.o3.c
        @t1.a
        public o3.c d(Comparator keyComparator) {
            super.d(keyComparator);
            return this;
        }

        @Override // f1.o3.c
        @t1.a
        public o3.c e(Comparator valueComparator) {
            super.e(valueComparator);
            return this;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // f1.o3.c
        @t1.a
        public o3.c f(Object key, Object value) {
            super.f(key, value);
            return this;
        }

        @Override // f1.o3.c
        @t1.a
        public o3.c g(Map.Entry entry) {
            super.g(entry);
            return this;
        }

        @Override // f1.o3.c
        @t1.a
        public o3.c i(Iterable entries) {
            super.i(entries);
            return this;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // f1.o3.c
        @t1.a
        public o3.c j(Object key, Iterable values) {
            super.j(key, values);
            return this;
        }

        @Override // f1.o3.c
        /* JADX INFO: renamed from: l, reason: merged with bridge method [inline-methods] */
        public u3<K, V> a() {
            Collection collectionEntrySet = this.f5168a.entrySet();
            Comparator<? super K> comparator = this.f5169b;
            if (comparator != null) {
                collectionEntrySet = l5.from(comparator).onKeys().immutableSortedCopy(collectionEntrySet);
            }
            return u3.fromMapEntries(collectionEntrySet, this.f5170c);
        }

        @t1.a
        public a<K, V> m(o3.c<K, V> other) {
            super.b(other);
            return this;
        }

        @t1.a
        public a<K, V> n(Comparator<? super K> keyComparator) {
            super.d(keyComparator);
            return this;
        }

        @t1.a
        public a<K, V> o(Comparator<? super V> valueComparator) {
            super.e(valueComparator);
            return this;
        }

        @t1.a
        public a<K, V> p(K key, V value) {
            super.f(key, value);
            return this;
        }

        @t1.a
        public a<K, V> q(Map.Entry<? extends K, ? extends V> entry) {
            super.g(entry);
            return this;
        }

        @Override // f1.o3.c
        @t1.a
        /* JADX INFO: renamed from: r, reason: merged with bridge method [inline-methods] */
        public a<K, V> h(v4<? extends K, ? extends V> multimap) {
            for (Map.Entry<? extends K, Collection<? extends V>> entry : multimap.asMap().entrySet()) {
                super.j(entry.getKey(), entry.getValue());
            }
            return this;
        }

        @t1.a
        public a<K, V> s(Iterable<? extends Map.Entry<? extends K, ? extends V>> entries) {
            super.i(entries);
            return this;
        }

        @t1.a
        public a<K, V> t(K key, Iterable<? extends V> values) {
            super.j(key, values);
            return this;
        }

        @Override // f1.o3.c
        @t1.a
        /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
        public a<K, V> k(K key, V... values) {
            super.j(key, Arrays.asList(values));
            return this;
        }
    }

    public static final class b<K, V> extends t3<Map.Entry<K, V>> {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        @Weak
        public final transient u3<K, V> f5397e;

        public b(u3<K, V> multimap) {
            this.f5397e = multimap;
        }

        @Override // f1.e3, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(@gm.a Object object) {
            if (!(object instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) object;
            return this.f5397e.containsEntry(entry.getKey(), entry.getValue());
        }

        @Override // f1.e3
        public boolean isPartialView() {
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return this.f5397e.size();
        }

        @Override // f1.t3, f1.e3, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet, f1.n6
        public x7<Map.Entry<K, V>> iterator() {
            return this.f5397e.entryIterator();
        }
    }

    @b1.c
    @b1.d
    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final i6.b<u3> f5398a = i6.a(u3.class, "emptySet");
    }

    public u3(k3<K, t3<V>> map, int size, @gm.a Comparator<? super V> valueComparator) {
        super(map, size);
        this.f5394f = c(valueComparator);
    }

    public static <K, V> u3<K, V> b(v4<? extends K, ? extends V> multimap, @gm.a Comparator<? super V> valueComparator) {
        multimap.getClass();
        if (multimap.isEmpty() && valueComparator == null) {
            return of();
        }
        if (multimap instanceof u3) {
            u3<K, V> u3Var = (u3) multimap;
            if (!u3Var.isPartialView()) {
                return u3Var;
            }
        }
        return fromMapEntries(multimap.asMap().entrySet(), valueComparator);
    }

    public static <K, V> a<K, V> builder() {
        return new a<>();
    }

    public static <V> t3<V> c(@gm.a Comparator<? super V> valueComparator) {
        return valueComparator == null ? t3.of() : a4.emptySet(valueComparator);
    }

    public static <K, V> u3<K, V> copyOf(v4<? extends K, ? extends V> multimap) {
        return b(multimap, null);
    }

    public static <V> t3<V> e(@gm.a Comparator<? super V> valueComparator, Collection<? extends V> values) {
        return valueComparator == null ? t3.copyOf((Collection) values) : a4.copyOf((Comparator) valueComparator, (Collection) values);
    }

    public static <K, V> u3<K, V> fromMapEntries(Collection<? extends Map.Entry<? extends K, ? extends Collection<? extends V>>> mapEntries, @gm.a Comparator<? super V> valueComparator) {
        if (mapEntries.isEmpty()) {
            return of();
        }
        k3.b bVar = new k3.b(mapEntries.size());
        int size = 0;
        for (Map.Entry<? extends K, ? extends Collection<? extends V>> entry : mapEntries) {
            K key = entry.getKey();
            t3 t3VarE = e(valueComparator, entry.getValue());
            if (!t3VarE.isEmpty()) {
                bVar.i(key, t3VarE);
                size = t3VarE.size() + size;
            }
        }
        return new u3<>(bVar.b(true), size, valueComparator);
    }

    public static <V> t3.a<V> g(@gm.a Comparator<? super V> valueComparator) {
        return valueComparator == null ? new t3.a<>(4) : new a4.a(valueComparator);
    }

    public static <K, V> u3<K, V> of() {
        return a1.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @b1.c
    @b1.d
    private void readObject(ObjectInputStream stream) throws ClassNotFoundException, IOException {
        stream.defaultReadObject();
        Comparator comparator = (Comparator) stream.readObject();
        int i10 = stream.readInt();
        if (i10 < 0) {
            throw new InvalidObjectException(h.a.a("Invalid key count ", i10));
        }
        k3.b bVarBuilder = k3.builder();
        int i11 = 0;
        for (int i12 = 0; i12 < i10; i12++) {
            Object object = stream.readObject();
            Objects.requireNonNull(object);
            int i13 = stream.readInt();
            if (i13 <= 0) {
                throw new InvalidObjectException(h.a.a("Invalid value count ", i13));
            }
            t3.a aVarG = g(comparator);
            for (int i14 = 0; i14 < i13; i14++) {
                Object object2 = stream.readObject();
                Objects.requireNonNull(object2);
                aVarG.a(object2);
            }
            t3 t3VarE = aVarG.e();
            if (t3VarE.size() != i13) {
                throw new InvalidObjectException(c0.a.a("Duplicate key-value pairs exist for key ", object));
            }
            bVarBuilder.i(object, t3VarE);
            i11 += i13;
        }
        try {
            o3.e.f5171a.b(this, bVarBuilder.d());
            o3.e.f5172b.a(this, i11);
            c.f5398a.b(this, c(comparator));
        } catch (IllegalArgumentException e10) {
            throw ((InvalidObjectException) new InvalidObjectException(e10.getMessage()).initCause(e10));
        }
    }

    @b1.c
    @b1.d
    private void writeObject(ObjectOutputStream stream) throws IOException {
        stream.defaultWriteObject();
        stream.writeObject(valueComparator());
        i6.j(this, stream);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final u3<V, K> d() {
        a aVarBuilder = builder();
        x7 it = entries().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            aVarBuilder.p(entry.getValue(), entry.getKey());
        }
        u3<V, K> u3VarA = aVarBuilder.a();
        u3VarA.f5395g = this;
        return u3VarA;
    }

    @gm.a
    public Comparator<? super V> valueComparator() {
        t3<V> t3Var = this.f5394f;
        if (t3Var instanceof a4) {
            return ((a4) t3Var).comparator();
        }
        return null;
    }

    public static <K, V> u3<K, V> copyOf(Iterable<? extends Map.Entry<? extends K, ? extends V>> entries) {
        return new a().s(entries).a();
    }

    public static <K, V> u3<K, V> of(K k10, V v10) {
        a aVarBuilder = builder();
        aVarBuilder.p(k10, v10);
        return aVarBuilder.a();
    }

    @Override // f1.o3
    public u3<V, K> inverse() {
        u3<V, K> u3Var = this.f5395g;
        if (u3Var != null) {
            return u3Var;
        }
        u3<V, K> u3VarD = d();
        this.f5395g = u3VarD;
        return u3VarD;
    }

    @Override // f1.o3, f1.h, f1.v4
    public t3<Map.Entry<K, V>> entries() {
        t3<Map.Entry<K, V>> t3Var = this.f5396i;
        if (t3Var != null) {
            return t3Var;
        }
        b bVar = new b(this);
        this.f5396i = bVar;
        return bVar;
    }

    @Override // f1.o3, f1.v4, f1.o4
    public t3<V> get(K key) {
        return (t3) c1.z.a((t3) this.map.get(key), this.f5394f);
    }

    @Override // f1.o3, f1.v4, f1.o4
    @t1.a
    @Deprecated
    @t1.e("Always throws UnsupportedOperationException")
    public final t3<V> removeAll(@gm.a Object key) {
        throw new UnsupportedOperationException();
    }

    @Override // f1.o3, f1.h, f1.v4, f1.o4
    @t1.a
    @Deprecated
    @t1.e("Always throws UnsupportedOperationException")
    public final t3<V> replaceValues(K key, Iterable<? extends V> values) {
        throw new UnsupportedOperationException();
    }

    public static <K, V> u3<K, V> of(K k10, V v10, K k11, V v11) {
        a aVarBuilder = builder();
        aVarBuilder.p(k10, v10);
        aVarBuilder.p(k11, v11);
        return aVarBuilder.a();
    }

    public static <K, V> u3<K, V> of(K k10, V v10, K k11, V v11, K k12, V v12) {
        a aVarBuilder = builder();
        aVarBuilder.p(k10, v10);
        aVarBuilder.p(k11, v11);
        aVarBuilder.p(k12, v12);
        return aVarBuilder.a();
    }

    public static <K, V> u3<K, V> of(K k10, V v10, K k11, V v11, K k12, V v12, K k13, V v13) {
        a aVarBuilder = builder();
        aVarBuilder.p(k10, v10);
        aVarBuilder.p(k11, v11);
        aVarBuilder.p(k12, v12);
        aVarBuilder.p(k13, v13);
        return aVarBuilder.a();
    }

    public static <K, V> u3<K, V> of(K k10, V v10, K k11, V v11, K k12, V v12, K k13, V v13, K k14, V v14) {
        a aVarBuilder = builder();
        aVarBuilder.p(k10, v10);
        aVarBuilder.p(k11, v11);
        aVarBuilder.p(k12, v12);
        aVarBuilder.p(k13, v13);
        aVarBuilder.p(k14, v14);
        return aVarBuilder.a();
    }
}
