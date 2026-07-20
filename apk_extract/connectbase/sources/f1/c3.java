package f1;

import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
@b1.b(emulated = true, serializable = true)
@x0
public abstract class c3<K, V> extends k3<K, V> implements w<K, V> {

    public static final class a<K, V> extends k3.b<K, V> {
        public a(int size) {
            super(size);
        }

        @Override // f1.k3.b
        public k3 a() {
            return d();
        }

        @Override // f1.k3.b
        @t1.a
        public k3.b e(k3.b builder) {
            super.e(builder);
            return this;
        }

        @Override // f1.k3.b
        @t1.a
        public k3.b h(Comparator valueComparator) {
            super.h(valueComparator);
            return this;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // f1.k3.b
        @t1.a
        public k3.b i(Object key, Object value) {
            super.i(key, value);
            return this;
        }

        @Override // f1.k3.b
        @t1.a
        public k3.b j(Map.Entry entry) {
            super.j(entry);
            return this;
        }

        @Override // f1.k3.b
        @t1.a
        public k3.b k(Iterable entries) {
            super.k(entries);
            return this;
        }

        @Override // f1.k3.b
        @t1.a
        public k3.b l(Map map) {
            super.l(map);
            return this;
        }

        public c3<K, V> n() {
            return d();
        }

        @Override // f1.k3.b
        @t1.e
        @Deprecated
        /* JADX INFO: renamed from: o, reason: merged with bridge method [inline-methods] */
        public c3<K, V> c() {
            throw new UnsupportedOperationException("Not supported for bimaps");
        }

        @Override // f1.k3.b
        /* JADX INFO: renamed from: p, reason: merged with bridge method [inline-methods] */
        public c3<K, V> d() {
            int i10 = this.f5017c;
            if (i10 == 0) {
                return c3.of();
            }
            if (this.f5015a != null) {
                if (this.f5018d) {
                    this.f5016b = Arrays.copyOf(this.f5016b, i10 * 2);
                }
                k3.b.m(this.f5016b, this.f5017c, this.f5015a);
            }
            this.f5018d = true;
            return new w5(this.f5016b, this.f5017c);
        }

        @t1.a
        public a<K, V> q(k3.b<K, V> builder) {
            super.e(builder);
            return this;
        }

        @t1.a
        public a<K, V> r(Comparator<? super V> valueComparator) {
            super.h(valueComparator);
            return this;
        }

        @t1.a
        public a<K, V> s(K key, V value) {
            super.i(key, value);
            return this;
        }

        @t1.a
        public a<K, V> t(Map.Entry<? extends K, ? extends V> entry) {
            super.j(entry);
            return this;
        }

        @t1.a
        public a<K, V> u(Iterable<? extends Map.Entry<? extends K, ? extends V>> entries) {
            super.k(entries);
            return this;
        }

        @t1.a
        public a<K, V> v(Map<? extends K, ? extends V> map) {
            super.l(map);
            return this;
        }

        public a() {
            super(4);
        }
    }

    @b1.d
    public static class b<K, V> extends k3.e<K, V> {
        private static final long serialVersionUID = 0;

        public b(c3<K, V> bimap) {
            super(bimap);
        }

        @Override // f1.k3.e
        public a<K, V> makeBuilder(int size) {
            return new a<>(size);
        }
    }

    public static <K, V> a<K, V> builder() {
        return new a<>(4);
    }

    public static <K, V> a<K, V> builderWithExpectedSize(int expectedSize) {
        b0.b(expectedSize, "expectedSize");
        return new a<>(expectedSize);
    }

    public static <K, V> c3<K, V> copyOf(Map<? extends K, ? extends V> map) {
        if (map instanceof c3) {
            c3<K, V> c3Var = (c3) map;
            if (!c3Var.isPartialView()) {
                return c3Var;
            }
        }
        return copyOf((Iterable) map.entrySet());
    }

    public static <K, V> c3<K, V> of() {
        return w5.EMPTY;
    }

    @SafeVarargs
    public static <K, V> c3<K, V> ofEntries(Map.Entry<? extends K, ? extends V>... entries) {
        return copyOf((Iterable) Arrays.asList(entries));
    }

    @b1.d
    private void readObject(ObjectInputStream stream) throws InvalidObjectException {
        throw new InvalidObjectException("Use SerializedForm");
    }

    @Override // f1.w
    @gm.a
    @t1.a
    @Deprecated
    @t1.e("Always throws UnsupportedOperationException")
    public final V forcePut(K key, V value) {
        throw new UnsupportedOperationException();
    }

    @Override // f1.w
    public abstract c3<V, K> inverse();

    @Override // f1.k3
    @b1.d
    public Object writeReplace() {
        return new b(this);
    }

    public static <K, V> c3<K, V> of(K k10, V v10) {
        b0.a(k10, v10);
        return new w5(new Object[]{k10, v10}, 1);
    }

    @Override // f1.k3
    public final t3<V> createValues() {
        throw new AssertionError("should never be called");
    }

    public static <K, V> c3<K, V> of(K k10, V v10, K k11, V v11) {
        b0.a(k10, v10);
        b0.a(k11, v11);
        return new w5(new Object[]{k10, v10, k11, v11}, 2);
    }

    @Override // f1.k3, java.util.Map, f1.w
    public t3<V> values() {
        return inverse().keySet();
    }

    public static <K, V> c3<K, V> copyOf(Iterable<? extends Map.Entry<? extends K, ? extends V>> entries) {
        return new a(entries instanceof Collection ? ((Collection) entries).size() : 4).u(entries).d();
    }

    public static <K, V> c3<K, V> of(K k10, V v10, K k11, V v11, K k12, V v12) {
        b0.a(k10, v10);
        b0.a(k11, v11);
        b0.a(k12, v12);
        return new w5(new Object[]{k10, v10, k11, v11, k12, v12}, 3);
    }

    public static <K, V> c3<K, V> of(K k10, V v10, K k11, V v11, K k12, V v12, K k13, V v13) {
        b0.a(k10, v10);
        b0.a(k11, v11);
        b0.a(k12, v12);
        b0.a(k13, v13);
        return new w5(new Object[]{k10, v10, k11, v11, k12, v12, k13, v13}, 4);
    }

    public static <K, V> c3<K, V> of(K k10, V v10, K k11, V v11, K k12, V v12, K k13, V v13, K k14, V v14) {
        b0.a(k10, v10);
        b0.a(k11, v11);
        b0.a(k12, v12);
        b0.a(k13, v13);
        b0.a(k14, v14);
        return new w5(new Object[]{k10, v10, k11, v11, k12, v12, k13, v13, k14, v14}, 5);
    }

    public static <K, V> c3<K, V> of(K k10, V v10, K k11, V v11, K k12, V v12, K k13, V v13, K k14, V v14, K k15, V v15) {
        b0.a(k10, v10);
        b0.a(k11, v11);
        b0.a(k12, v12);
        b0.a(k13, v13);
        b0.a(k14, v14);
        b0.a(k15, v15);
        return new w5(new Object[]{k10, v10, k11, v11, k12, v12, k13, v13, k14, v14, k15, v15}, 6);
    }

    public static <K, V> c3<K, V> of(K k10, V v10, K k11, V v11, K k12, V v12, K k13, V v13, K k14, V v14, K k15, V v15, K k16, V v16) {
        b0.a(k10, v10);
        b0.a(k11, v11);
        b0.a(k12, v12);
        b0.a(k13, v13);
        b0.a(k14, v14);
        b0.a(k15, v15);
        b0.a(k16, v16);
        return new w5(new Object[]{k10, v10, k11, v11, k12, v12, k13, v13, k14, v14, k15, v15, k16, v16}, 7);
    }

    public static <K, V> c3<K, V> of(K k10, V v10, K k11, V v11, K k12, V v12, K k13, V v13, K k14, V v14, K k15, V v15, K k16, V v16, K k17, V v17) {
        b0.a(k10, v10);
        b0.a(k11, v11);
        b0.a(k12, v12);
        b0.a(k13, v13);
        b0.a(k14, v14);
        b0.a(k15, v15);
        b0.a(k16, v16);
        b0.a(k17, v17);
        return new w5(new Object[]{k10, v10, k11, v11, k12, v12, k13, v13, k14, v14, k15, v15, k16, v16, k17, v17}, 8);
    }

    public static <K, V> c3<K, V> of(K k10, V v10, K k11, V v11, K k12, V v12, K k13, V v13, K k14, V v14, K k15, V v15, K k16, V v16, K k17, V v17, K k18, V v18) {
        b0.a(k10, v10);
        b0.a(k11, v11);
        b0.a(k12, v12);
        b0.a(k13, v13);
        b0.a(k14, v14);
        b0.a(k15, v15);
        b0.a(k16, v16);
        b0.a(k17, v17);
        b0.a(k18, v18);
        return new w5(new Object[]{k10, v10, k11, v11, k12, v12, k13, v13, k14, v14, k15, v15, k16, v16, k17, v17, k18, v18}, 9);
    }

    public static <K, V> c3<K, V> of(K k10, V v10, K k11, V v11, K k12, V v12, K k13, V v13, K k14, V v14, K k15, V v15, K k16, V v16, K k17, V v17, K k18, V v18, K k19, V v19) {
        b0.a(k10, v10);
        b0.a(k11, v11);
        b0.a(k12, v12);
        b0.a(k13, v13);
        b0.a(k14, v14);
        b0.a(k15, v15);
        b0.a(k16, v16);
        b0.a(k17, v17);
        b0.a(k18, v18);
        b0.a(k19, v19);
        return new w5(new Object[]{k10, v10, k11, v11, k12, v12, k13, v13, k14, v14, k15, v15, k16, v16, k17, v17, k18, v18, k19, v19}, 10);
    }
}
