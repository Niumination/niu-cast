package c1;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
@b1.b
@k
public final class v {

    public static class b<E> implements t<Object, E>, Serializable {
        private static final long serialVersionUID = 0;

        @e0
        private final E value;

        public b(@e0 E value) {
            this.value = value;
        }

        @Override // c1.t
        @e0
        public E apply(@gm.a Object from) {
            return this.value;
        }

        @Override // c1.t
        public boolean equals(@gm.a Object obj) {
            if (obj instanceof b) {
                return b0.a(this.value, ((b) obj).value);
            }
            return false;
        }

        public int hashCode() {
            E e10 = this.value;
            if (e10 == null) {
                return 0;
            }
            return e10.hashCode();
        }

        public String toString() {
            return j.e.a(new StringBuilder("Functions.constant("), this.value, ")");
        }
    }

    public static class c<K, V> implements t<K, V>, Serializable {
        private static final long serialVersionUID = 0;

        @e0
        final V defaultValue;
        final Map<K, ? extends V> map;

        public c(Map<K, ? extends V> map, @e0 V defaultValue) {
            map.getClass();
            this.map = map;
            this.defaultValue = defaultValue;
        }

        @Override // c1.t
        @e0
        public V apply(@e0 K key) {
            V v10 = this.map.get(key);
            return (v10 != null || this.map.containsKey(key)) ? v10 : this.defaultValue;
        }

        @Override // c1.t
        public boolean equals(@gm.a Object o10) {
            if (!(o10 instanceof c)) {
                return false;
            }
            c cVar = (c) o10;
            return this.map.equals(cVar.map) && b0.a(this.defaultValue, cVar.defaultValue);
        }

        public int hashCode() {
            return Arrays.hashCode(new Object[]{this.map, this.defaultValue});
        }

        public String toString() {
            StringBuilder sb2 = new StringBuilder("Functions.forMap(");
            sb2.append(this.map);
            sb2.append(", defaultValue=");
            return j.e.a(sb2, this.defaultValue, ")");
        }
    }

    public static class d<A, B, C> implements t<A, C>, Serializable {
        private static final long serialVersionUID = 0;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final t<A, ? extends B> f1250f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final t<B, C> f1251g;

        public d(t<B, C> g10, t<A, ? extends B> f10) {
            g10.getClass();
            this.f1251g = g10;
            f10.getClass();
            this.f1250f = f10;
        }

        @Override // c1.t
        @e0
        public C apply(@e0 A a10) {
            return (C) this.f1251g.apply(this.f1250f.apply(a10));
        }

        @Override // c1.t
        public boolean equals(@gm.a Object obj) {
            if (!(obj instanceof d)) {
                return false;
            }
            d dVar = (d) obj;
            return this.f1250f.equals(dVar.f1250f) && this.f1251g.equals(dVar.f1251g);
        }

        public int hashCode() {
            return this.f1251g.hashCode() ^ this.f1250f.hashCode();
        }

        public String toString() {
            return this.f1251g + "(" + this.f1250f + ")";
        }
    }

    public static class e<K, V> implements t<K, V>, Serializable {
        private static final long serialVersionUID = 0;
        final Map<K, V> map;

        public e(Map<K, V> map) {
            map.getClass();
            this.map = map;
        }

        @Override // c1.t
        @e0
        public V apply(@e0 K key) {
            V v10 = this.map.get(key);
            h0.u(v10 != null || this.map.containsKey(key), "Key '%s' not present in map", key);
            return v10;
        }

        @Override // c1.t
        public boolean equals(@gm.a Object o10) {
            if (o10 instanceof e) {
                return this.map.equals(((e) o10).map);
            }
            return false;
        }

        public int hashCode() {
            return this.map.hashCode();
        }

        public String toString() {
            return "Functions.forMap(" + this.map + ")";
        }
    }

    public enum f implements t<Object, Object> {
        INSTANCE;

        public static /* synthetic */ f[] a() {
            return new f[]{INSTANCE};
        }

        @Override // c1.t
        @gm.a
        public Object apply(@gm.a Object o10) {
            return o10;
        }

        @Override // java.lang.Enum
        public String toString() {
            return "Functions.identity()";
        }
    }

    public static class g<T> implements t<T, Boolean>, Serializable {
        private static final long serialVersionUID = 0;
        private final i0<T> predicate;

        @Override // c1.t
        public boolean equals(@gm.a Object obj) {
            if (obj instanceof g) {
                return this.predicate.equals(((g) obj).predicate);
            }
            return false;
        }

        public int hashCode() {
            return this.predicate.hashCode();
        }

        public String toString() {
            return "Functions.forPredicate(" + this.predicate + ")";
        }

        public g(i0<T> predicate) {
            predicate.getClass();
            this.predicate = predicate;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // c1.t
        public Boolean apply(@e0 T t10) {
            return Boolean.valueOf(this.predicate.apply(t10));
        }
    }

    public static class h<F, T> implements t<F, T>, Serializable {
        private static final long serialVersionUID = 0;
        private final q0<T> supplier;

        @Override // c1.t
        @e0
        public T apply(@e0 F input) {
            return this.supplier.get();
        }

        @Override // c1.t
        public boolean equals(@gm.a Object obj) {
            if (obj instanceof h) {
                return this.supplier.equals(((h) obj).supplier);
            }
            return false;
        }

        public int hashCode() {
            return this.supplier.hashCode();
        }

        public String toString() {
            return "Functions.forSupplier(" + this.supplier + ")";
        }

        public h(q0<T> supplier) {
            supplier.getClass();
            this.supplier = supplier;
        }
    }

    public enum i implements t<Object, String> {
        INSTANCE;

        public static /* synthetic */ i[] a() {
            return new i[]{INSTANCE};
        }

        @Override // java.lang.Enum
        public String toString() {
            return "Functions.toStringFunction()";
        }

        @Override // c1.t
        public String apply(Object o10) {
            o10.getClass();
            return o10.toString();
        }
    }

    public static <A, B, C> t<A, C> a(t<B, C> g10, t<A, ? extends B> f10) {
        return new d(g10, f10);
    }

    public static <E> t<Object, E> b(@e0 E value) {
        return new b(value);
    }

    public static <K, V> t<K, V> c(Map<K, V> map) {
        return new e(map);
    }

    public static <K, V> t<K, V> d(Map<K, ? extends V> map, @e0 V defaultValue) {
        return new c(map, defaultValue);
    }

    public static <T> t<T, Boolean> e(i0<T> predicate) {
        return new g(predicate);
    }

    public static <F, T> t<F, T> f(q0<T> supplier) {
        return new h(supplier);
    }

    public static <E> t<E, E> g() {
        return f.INSTANCE;
    }

    public static t<Object, String> h() {
        return i.INSTANCE;
    }
}
