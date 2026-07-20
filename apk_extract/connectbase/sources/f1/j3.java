package f1;

import com.google.j2objc.annotations.RetainedWith;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collection;
import java.util.Comparator;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
@b1.b(emulated = true, serializable = true)
@x0
public class j3<K, V> extends o3<K, V> implements o4<K, V> {

    @b1.c
    @b1.d
    private static final long serialVersionUID = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @u1.b
    @RetainedWith
    @gm.a
    public transient j3<V, K> f4980f;

    public static final class a<K, V> extends o3.c<K, V> {
        @Override // f1.o3.c
        public o3 a() {
            return (j3) super.a();
        }

        @Override // f1.o3.c
        @t1.a
        public o3.c b(o3.c other) {
            super.b(other);
            return this;
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
        public o3.c h(v4 multimap) {
            super.h(multimap);
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

        /* JADX WARN: Multi-variable type inference failed */
        @Override // f1.o3.c
        @t1.a
        public o3.c k(Object key, Object[] values) {
            super.k(key, values);
            return this;
        }

        public j3<K, V> l() {
            return (j3) super.a();
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

        @t1.a
        public a<K, V> r(v4<? extends K, ? extends V> multimap) {
            super.h(multimap);
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

        @t1.a
        public a<K, V> u(K key, V... values) {
            super.k(key, values);
            return this;
        }
    }

    public j3(k3<K, i3<V>> map, int size) {
        super(map, size);
    }

    public static <K, V> a<K, V> builder() {
        return new a<>();
    }

    public static <K, V> j3<K, V> copyOf(v4<? extends K, ? extends V> multimap) {
        if (multimap.isEmpty()) {
            return of();
        }
        if (multimap instanceof j3) {
            j3<K, V> j3Var = (j3) multimap;
            if (!j3Var.isPartialView()) {
                return j3Var;
            }
        }
        return fromMapEntries(multimap.asMap().entrySet(), null);
    }

    public static <K, V> j3<K, V> fromMapEntries(Collection<? extends Map.Entry<? extends K, ? extends Collection<? extends V>>> mapEntries, @gm.a Comparator<? super V> valueComparator) {
        if (mapEntries.isEmpty()) {
            return of();
        }
        k3.b bVar = new k3.b(mapEntries.size());
        int size = 0;
        for (Map.Entry<? extends K, ? extends Collection<? extends V>> entry : mapEntries) {
            K key = entry.getKey();
            Collection<? extends V> value = entry.getValue();
            i3 i3VarCopyOf = valueComparator == null ? i3.copyOf((Collection) value) : i3.sortedCopyOf(valueComparator, value);
            if (!i3VarCopyOf.isEmpty()) {
                bVar.i(key, i3VarCopyOf);
                size = i3VarCopyOf.size() + size;
            }
        }
        return new j3<>(bVar.b(true), size);
    }

    public static <K, V> j3<K, V> of() {
        return z0.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @b1.c
    @b1.d
    private void readObject(ObjectInputStream stream) throws ClassNotFoundException, IOException {
        stream.defaultReadObject();
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
            i3.a aVarBuilder = i3.builder();
            for (int i14 = 0; i14 < i13; i14++) {
                Object object2 = stream.readObject();
                Objects.requireNonNull(object2);
                aVarBuilder.j(object2);
            }
            bVarBuilder.i(object, aVarBuilder.e());
            i11 += i13;
        }
        try {
            o3.e.f5171a.b(this, bVarBuilder.d());
            o3.e.f5172b.a(this, i11);
        } catch (IllegalArgumentException e10) {
            throw ((InvalidObjectException) new InvalidObjectException(e10.getMessage()).initCause(e10));
        }
    }

    @b1.c
    @b1.d
    private void writeObject(ObjectOutputStream stream) throws IOException {
        stream.defaultWriteObject();
        i6.j(this, stream);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final j3<V, K> b() {
        a aVarBuilder = builder();
        x7 it = entries().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            aVarBuilder.p(entry.getValue(), entry.getKey());
        }
        j3<V, K> j3VarL = aVarBuilder.l();
        j3VarL.f4980f = this;
        return j3VarL;
    }

    public static <K, V> j3<K, V> of(K k10, V v10) {
        a aVarBuilder = builder();
        aVarBuilder.p(k10, v10);
        return aVarBuilder.l();
    }

    @Override // f1.o3
    public j3<V, K> inverse() {
        j3<V, K> j3Var = this.f4980f;
        if (j3Var != null) {
            return j3Var;
        }
        j3<V, K> j3VarB = b();
        this.f4980f = j3VarB;
        return j3VarB;
    }

    @Override // f1.o3, f1.v4, f1.o4
    public i3<V> get(K key) {
        i3<V> i3Var = (i3) this.map.get(key);
        return i3Var == null ? i3.of() : i3Var;
    }

    @Override // f1.o3, f1.v4, f1.o4
    @t1.a
    @Deprecated
    @t1.e("Always throws UnsupportedOperationException")
    public final i3<V> removeAll(@gm.a Object key) {
        throw new UnsupportedOperationException();
    }

    @Override // f1.o3, f1.h, f1.v4, f1.o4
    @t1.a
    @Deprecated
    @t1.e("Always throws UnsupportedOperationException")
    public final i3<V> replaceValues(K key, Iterable<? extends V> values) {
        throw new UnsupportedOperationException();
    }

    public static <K, V> j3<K, V> of(K k10, V v10, K k11, V v11) {
        a aVarBuilder = builder();
        aVarBuilder.p(k10, v10);
        aVarBuilder.p(k11, v11);
        return aVarBuilder.l();
    }

    public static <K, V> j3<K, V> copyOf(Iterable<? extends Map.Entry<? extends K, ? extends V>> entries) {
        return new a().s(entries).l();
    }

    public static <K, V> j3<K, V> of(K k10, V v10, K k11, V v11, K k12, V v12) {
        a aVarBuilder = builder();
        aVarBuilder.p(k10, v10);
        aVarBuilder.p(k11, v11);
        aVarBuilder.p(k12, v12);
        return aVarBuilder.l();
    }

    public static <K, V> j3<K, V> of(K k10, V v10, K k11, V v11, K k12, V v12, K k13, V v13) {
        a aVarBuilder = builder();
        aVarBuilder.p(k10, v10);
        aVarBuilder.p(k11, v11);
        aVarBuilder.p(k12, v12);
        aVarBuilder.p(k13, v13);
        return aVarBuilder.l();
    }

    public static <K, V> j3<K, V> of(K k10, V v10, K k11, V v11, K k12, V v12, K k13, V v13, K k14, V v14) {
        a aVarBuilder = builder();
        aVarBuilder.p(k10, v10);
        aVarBuilder.p(k11, v11);
        aVarBuilder.p(k12, v12);
        aVarBuilder.p(k13, v13);
        aVarBuilder.p(k14, v14);
        return aVarBuilder.l();
    }
}
