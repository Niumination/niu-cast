package nm;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
@kn.r1({"SMAP\nAbstractMap.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AbstractMap.kt\nkotlin/collections/AbstractMap\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,153:1\n1747#2,3:154\n1726#2,3:157\n288#2,2:160\n*S KotlinDebug\n*F\n+ 1 AbstractMap.kt\nkotlin/collections/AbstractMap\n*L\n28#1:154,3\n60#1:157,3\n141#1:160,2\n*E\n"})
@lm.f1(version = "1.1")
public abstract class d<K, V> implements Map<K, V>, ln.a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @os.l
    public static final a f11620c = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.m
    public volatile Set<? extends K> f11621a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.m
    public volatile Collection<? extends V> f11622b;

    @kn.r1({"SMAP\nAbstractMap.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AbstractMap.kt\nkotlin/collections/AbstractMap$Companion\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,153:1\n1#2:154\n*E\n"})
    public static final class a {
        public a() {
        }

        public final boolean a(@os.l Map.Entry<?, ?> entry, @os.m Object obj) {
            kn.l0.p(entry, "e");
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry2 = (Map.Entry) obj;
            return kn.l0.g(entry.getKey(), entry2.getKey()) && kn.l0.g(entry.getValue(), entry2.getValue());
        }

        public final int b(@os.l Map.Entry<?, ?> entry) {
            kn.l0.p(entry, "e");
            Object key = entry.getKey();
            int iHashCode = key != null ? key.hashCode() : 0;
            Object value = entry.getValue();
            return iHashCode ^ (value != null ? value.hashCode() : 0);
        }

        @os.l
        public final String c(@os.l Map.Entry<?, ?> entry) {
            kn.l0.p(entry, "e");
            StringBuilder sb2 = new StringBuilder();
            sb2.append(entry.getKey());
            sb2.append(fl.h.f6043c);
            sb2.append(entry.getValue());
            return sb2.toString();
        }

        public a(kn.w wVar) {
        }
    }

    public static final class b extends i<K> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ d<K, V> f11623b;

        public static final class a implements Iterator<K>, ln.a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ Iterator<Map.Entry<K, V>> f11624a;

            /* JADX WARN: Multi-variable type inference failed */
            public a(Iterator<? extends Map.Entry<? extends K, ? extends V>> it) {
                this.f11624a = it;
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.f11624a.hasNext();
            }

            @Override // java.util.Iterator
            public K next() {
                return this.f11624a.next().getKey();
            }

            @Override // java.util.Iterator
            public void remove() {
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public b(d<K, ? extends V> dVar) {
            this.f11623b = dVar;
        }

        @Override // nm.a, java.util.Collection, java.util.List
        public boolean contains(Object obj) {
            return this.f11623b.containsKey(obj);
        }

        @Override // nm.a
        public int getSize() {
            return this.f11623b.g();
        }

        @Override // nm.i, nm.a, java.util.Collection, java.lang.Iterable
        @os.l
        public Iterator<K> iterator() {
            return new a(this.f11623b.e().iterator());
        }
    }

    public static final class c extends kn.n0 implements jn.l<Map.Entry<? extends K, ? extends V>, CharSequence> {
        final /* synthetic */ d<K, V> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public c(d<K, ? extends V> dVar) {
            super(1);
            this.this$0 = dVar;
        }

        @Override // jn.l
        @os.l
        public final CharSequence invoke(@os.l Map.Entry<? extends K, ? extends V> entry) {
            kn.l0.p(entry, "it");
            return this.this$0.l(entry);
        }
    }

    /* JADX INFO: renamed from: nm.d$d, reason: collision with other inner class name */
    public static final class C0299d extends nm.a<V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d<K, V> f11625a;

        /* JADX INFO: renamed from: nm.d$d$a */
        public static final class a implements Iterator<V>, ln.a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ Iterator<Map.Entry<K, V>> f11626a;

            /* JADX WARN: Multi-variable type inference failed */
            public a(Iterator<? extends Map.Entry<? extends K, ? extends V>> it) {
                this.f11626a = it;
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.f11626a.hasNext();
            }

            @Override // java.util.Iterator
            public V next() {
                return this.f11626a.next().getValue();
            }

            @Override // java.util.Iterator
            public void remove() {
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public C0299d(d<K, ? extends V> dVar) {
            this.f11625a = dVar;
        }

        @Override // nm.a, java.util.Collection, java.util.List
        public boolean contains(Object obj) {
            return this.f11625a.containsValue(obj);
        }

        @Override // nm.a
        public int getSize() {
            return this.f11625a.g();
        }

        @Override // nm.a, java.util.Collection, java.lang.Iterable
        @os.l
        public Iterator<V> iterator() {
            return new a(this.f11625a.e().iterator());
        }
    }

    public final boolean c(@os.m Map.Entry<?, ?> entry) {
        if (entry == null) {
            return false;
        }
        Object key = entry.getKey();
        Object value = entry.getValue();
        kn.l0.n(this, "null cannot be cast to non-null type kotlin.collections.Map<K of kotlin.collections.MapsKt__MapsKt.get, V of kotlin.collections.MapsKt__MapsKt.get>");
        V v10 = get(key);
        if (!kn.l0.g(value, v10)) {
            return false;
        }
        if (v10 != null) {
            return true;
        }
        kn.l0.n(this, "null cannot be cast to non-null type kotlin.collections.Map<K of kotlin.collections.MapsKt__MapsKt.containsKey, *>");
        return containsKey(key);
    }

    @Override // java.util.Map
    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Map
    public boolean containsKey(Object obj) {
        return i(obj) != null;
    }

    @Override // java.util.Map
    public boolean containsValue(Object obj) {
        Set setE = e();
        if (setE != null && setE.isEmpty()) {
            return false;
        }
        Iterator it = setE.iterator();
        while (it.hasNext()) {
            if (kn.l0.g(((Map.Entry) it.next()).getValue(), obj)) {
                return true;
            }
        }
        return false;
    }

    public abstract Set e();

    @Override // java.util.Map
    public final /* bridge */ Set<Map.Entry<K, V>> entrySet() {
        return e();
    }

    @Override // java.util.Map
    public boolean equals(@os.m Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Map)) {
            return false;
        }
        Map map = (Map) obj;
        if (g() != map.size()) {
            return false;
        }
        Set<Map.Entry<K, V>> setEntrySet = map.entrySet();
        if (setEntrySet != null && setEntrySet.isEmpty()) {
            return true;
        }
        Iterator<T> it = setEntrySet.iterator();
        while (it.hasNext()) {
            if (!c((Map.Entry) it.next())) {
                return false;
            }
        }
        return true;
    }

    @os.l
    public Set<K> f() {
        if (this.f11621a == null) {
            this.f11621a = new b(this);
        }
        Set<? extends K> set = this.f11621a;
        kn.l0.m(set);
        return set;
    }

    public int g() {
        return e().size();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Map
    @os.m
    public V get(Object obj) {
        Map.Entry<K, V> entryI = i(obj);
        if (entryI != null) {
            return entryI.getValue();
        }
        return null;
    }

    @os.l
    public Collection<V> h() {
        if (this.f11622b == null) {
            this.f11622b = new C0299d(this);
        }
        Collection<? extends V> collection = this.f11622b;
        kn.l0.m(collection);
        return collection;
    }

    @Override // java.util.Map
    public int hashCode() {
        return e().hashCode();
    }

    public final Map.Entry<K, V> i(K k10) {
        Object next;
        Iterator it = e().iterator();
        while (it.hasNext()) {
            next = it.next();
            if (kn.l0.g(((Map.Entry) next).getKey(), k10)) {
                return (Map.Entry) next;
            }
        }
        next = null;
        return (Map.Entry) next;
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        return g() == 0;
    }

    public final String j(Object obj) {
        return obj == this ? "(this Map)" : String.valueOf(obj);
    }

    @Override // java.util.Map
    public final /* bridge */ Set<K> keySet() {
        return f();
    }

    public final String l(Map.Entry<? extends K, ? extends V> entry) {
        return j(entry.getKey()) + fl.h.f6043c + j(entry.getValue());
    }

    @Override // java.util.Map
    public V put(K k10, V v10) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public void putAll(Map<? extends K, ? extends V> map) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public V remove(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public final /* bridge */ int size() {
        return g();
    }

    @os.l
    public String toString() {
        return h0.m3(e(), ", ", "{", "}", 0, null, new c(this), 24, null);
    }

    @Override // java.util.Map
    public final /* bridge */ Collection<V> values() {
        return h();
    }
}
