package f1;

import com.google.j2objc.annotations.RetainedWith;
import com.google.j2objc.annotations.Weak;
import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.AbstractMap;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.EnumMap;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.Objects;
import java.util.Properties;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* JADX INFO: loaded from: classes.dex */
@b1.b(emulated = true)
@x0
public final class t4 {

    /* JADX INFO: Add missing generic type declarations: [V1, V2] */
    public class a<V1, V2> implements c1.t<V1, V2> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ t f5295a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Object f5296b;

        public a(final t val$transformer, final Object val$key) {
            this.f5295a = val$transformer;
            this.f5296b = val$key;
        }

        @Override // c1.t
        @m5
        public V2 apply(@m5 V1 v10) {
            return (V2) this.f5295a.a(this.f5296b, v10);
        }
    }

    public static abstract class a0<K, V> extends AbstractMap<K, V> {

        public class a extends s<K, V> {
            public a() {
            }

            @Override // f1.t4.s
            public Map<K, V> a() {
                return a0.this;
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
            public Iterator<Map.Entry<K, V>> iterator() {
                return a0.this.a();
            }
        }

        public abstract Iterator<Map.Entry<K, V>> a();

        @Override // java.util.AbstractMap, java.util.Map
        public void clear() {
            h4.h(a());
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Set<Map.Entry<K, V>> entrySet() {
            return new a();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public abstract int size();
    }

    /* JADX INFO: Add missing generic type declarations: [K, V1, V2] */
    public class b<K, V1, V2> implements c1.t<Map.Entry<K, V1>, V2> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ t f5298a;

        public b(final t val$transformer) {
            this.f5298a = val$transformer;
        }

        @Override // c1.t
        @m5
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public V2 apply(Map.Entry<K, V1> entry) {
            return (V2) this.f5298a.a(entry.getKey(), entry.getValue());
        }
    }

    public static class b0<K, V> extends k6.k<K> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @Weak
        public final Map<K, V> f5299a;

        public b0(Map<K, V> map) {
            map.getClass();
            this.f5299a = map;
        }

        /* JADX INFO: renamed from: a */
        public Map<K, V> b() {
            return this.f5299a;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            b().clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(@gm.a Object o10) {
            return b().containsKey(o10);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            return b().isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<K> iterator() {
            return new e(b().entrySet().iterator());
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(@gm.a Object o10) {
            if (!contains(o10)) {
                return false;
            }
            b().remove(o10);
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return b().size();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [K, V2] */
    public class c<K, V2> extends f1.g<K, V2> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Map.Entry f5300a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ t f5301b;

        public c(final Map.Entry val$entry, final t val$transformer) {
            this.f5300a = val$entry;
            this.f5301b = val$transformer;
        }

        @Override // f1.g, java.util.Map.Entry
        @m5
        public K getKey() {
            return (K) this.f5300a.getKey();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // f1.g, java.util.Map.Entry
        @m5
        public V2 getValue() {
            return (V2) this.f5301b.a(this.f5300a.getKey(), this.f5300a.getValue());
        }
    }

    public static class c0<K, V> implements q4<K, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Map<K, V> f5302a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Map<K, V> f5303b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Map<K, V> f5304c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Map<K, q4.a<V>> f5305d;

        public c0(Map<K, V> onlyOnLeft, Map<K, V> onlyOnRight, Map<K, V> onBoth, Map<K, q4.a<V>> differences) {
            this.f5302a = t4.L0(onlyOnLeft);
            this.f5303b = t4.L0(onlyOnRight);
            this.f5304c = t4.L0(onBoth);
            this.f5305d = t4.L0(differences);
        }

        @Override // f1.q4
        public Map<K, V> a() {
            return this.f5303b;
        }

        @Override // f1.q4
        public Map<K, V> b() {
            return this.f5302a;
        }

        @Override // f1.q4
        public Map<K, q4.a<V>> c() {
            return this.f5305d;
        }

        @Override // f1.q4
        public Map<K, V> d() {
            return this.f5304c;
        }

        @Override // f1.q4
        public boolean e() {
            return this.f5302a.isEmpty() && this.f5303b.isEmpty() && this.f5305d.isEmpty();
        }

        @Override // f1.q4
        public boolean equals(@gm.a Object object) {
            if (object == this) {
                return true;
            }
            if (!(object instanceof q4)) {
                return false;
            }
            q4 q4Var = (q4) object;
            return b().equals(q4Var.b()) && a().equals(q4Var.a()) && d().equals(q4Var.d()) && c().equals(q4Var.c());
        }

        @Override // f1.q4
        public int hashCode() {
            return Arrays.hashCode(new Object[]{b(), a(), d(), c()});
        }

        public String toString() {
            if (e()) {
                return "equal";
            }
            StringBuilder sb2 = new StringBuilder("not equal");
            if (!this.f5302a.isEmpty()) {
                sb2.append(": only on left=");
                sb2.append(this.f5302a);
            }
            if (!this.f5303b.isEmpty()) {
                sb2.append(": only on right=");
                sb2.append(this.f5303b);
            }
            if (!this.f5305d.isEmpty()) {
                sb2.append(": value differences=");
                sb2.append(this.f5305d);
            }
            return sb2.toString();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [K, V1, V2] */
    public class d<K, V1, V2> implements c1.t<Map.Entry<K, V1>, Map.Entry<K, V2>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ t f5306a;

        public d(final t val$transformer) {
            this.f5306a = val$transformer;
        }

        @Override // c1.t
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Map.Entry<K, V2> apply(final Map.Entry<K, V1> entry) {
            return t4.A0(this.f5306a, entry);
        }
    }

    @b1.c
    public static final class d0<K, V> extends f1.j<K, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final NavigableSet<K> f5307a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final c1.t<? super K, V> f5308b;

        public d0(NavigableSet<K> ks2, c1.t<? super K, V> vFunction) {
            ks2.getClass();
            this.f5307a = ks2;
            vFunction.getClass();
            this.f5308b = vFunction;
        }

        @Override // f1.t4.a0
        public Iterator<Map.Entry<K, V>> a() {
            return t4.m(this.f5307a, this.f5308b);
        }

        @Override // f1.j
        public Iterator<Map.Entry<K, V>> c() {
            return descendingMap().entrySet().iterator();
        }

        @Override // f1.t4.a0, java.util.AbstractMap, java.util.Map
        public void clear() {
            this.f5307a.clear();
        }

        @Override // java.util.SortedMap
        @gm.a
        public Comparator<? super K> comparator() {
            return this.f5307a.comparator();
        }

        @Override // f1.j, java.util.NavigableMap
        public NavigableMap<K, V> descendingMap() {
            return new d0(this.f5307a.descendingSet(), this.f5308b);
        }

        @Override // f1.j, java.util.AbstractMap, java.util.Map
        @gm.a
        public V get(@gm.a Object key) {
            if (f1.c0.j(this.f5307a, key)) {
                return this.f5308b.apply(key);
            }
            return null;
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, V> headMap(@m5 K toKey, boolean inclusive) {
            return new d0(this.f5307a.headSet(toKey, inclusive), this.f5308b);
        }

        @Override // f1.j, java.util.NavigableMap
        public NavigableSet<K> navigableKeySet() {
            return new j(this.f5307a);
        }

        @Override // f1.t4.a0, java.util.AbstractMap, java.util.Map
        public int size() {
            return this.f5307a.size();
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, V> subMap(@m5 K fromKey, boolean fromInclusive, @m5 K toKey, boolean toInclusive) {
            return new d0(this.f5307a.subSet(fromKey, fromInclusive, toKey, toInclusive), this.f5308b);
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, V> tailMap(@m5 K fromKey, boolean inclusive) {
            return new d0(this.f5307a.tailSet(fromKey, inclusive), this.f5308b);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [V, K] */
    public class e<K, V> extends o7<Map.Entry<K, V>, K> {
        public e(Iterator backingIterator) {
            super(backingIterator);
        }

        @Override // f1.o7
        @m5
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public K a(Map.Entry<K, V> entry) {
            return entry.getKey();
        }
    }

    @b1.c
    public static class e0<K, V> extends g0<K, V> implements NavigableSet<K> {
        public e0(NavigableMap<K, V> map) {
            super((Map) map);
        }

        @Override // f1.t4.g0
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
        public NavigableMap<K, V> b() {
            return (NavigableMap) this.f5299a;
        }

        @Override // java.util.NavigableSet
        @gm.a
        public K ceiling(@m5 K e10) {
            return a().ceilingKey(e10);
        }

        @Override // java.util.NavigableSet
        public Iterator<K> descendingIterator() {
            return descendingSet().iterator();
        }

        @Override // java.util.NavigableSet
        public NavigableSet<K> descendingSet() {
            return a().descendingKeySet();
        }

        @Override // java.util.NavigableSet
        @gm.a
        public K floor(@m5 K e10) {
            return a().floorKey(e10);
        }

        @Override // java.util.NavigableSet
        public NavigableSet<K> headSet(@m5 K toElement, boolean inclusive) {
            return a().headMap(toElement, inclusive).navigableKeySet();
        }

        @Override // java.util.NavigableSet
        @gm.a
        public K higher(@m5 K e10) {
            return a().higherKey(e10);
        }

        @Override // java.util.NavigableSet
        @gm.a
        public K lower(@m5 K e10) {
            return a().lowerKey(e10);
        }

        @Override // java.util.NavigableSet
        @gm.a
        public K pollFirst() {
            return (K) t4.T(a().pollFirstEntry());
        }

        @Override // java.util.NavigableSet
        @gm.a
        public K pollLast() {
            return (K) t4.T(a().pollLastEntry());
        }

        @Override // java.util.NavigableSet
        public NavigableSet<K> subSet(@m5 K fromElement, boolean fromInclusive, @m5 K toElement, boolean toInclusive) {
            return a().subMap(fromElement, fromInclusive, toElement, toInclusive).navigableKeySet();
        }

        @Override // java.util.NavigableSet
        public NavigableSet<K> tailSet(@m5 K fromElement, boolean inclusive) {
            return a().tailMap(fromElement, inclusive).navigableKeySet();
        }

        @Override // f1.t4.g0, java.util.SortedSet, java.util.NavigableSet
        public SortedSet<K> headSet(@m5 K toElement) {
            return headSet(toElement, false);
        }

        @Override // f1.t4.g0, java.util.SortedSet, java.util.NavigableSet
        public SortedSet<K> subSet(@m5 K fromElement, @m5 K toElement) {
            return subSet(fromElement, true, toElement, false);
        }

        @Override // f1.t4.g0, java.util.SortedSet, java.util.NavigableSet
        public SortedSet<K> tailSet(@m5 K fromElement) {
            return tailSet(fromElement, true);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [V, K] */
    public class f<K, V> extends o7<Map.Entry<K, V>, V> {
        public f(Iterator backingIterator) {
            super(backingIterator);
        }

        @Override // f1.o7
        @m5
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public V a(Map.Entry<K, V> entry) {
            return entry.getValue();
        }
    }

    public static class f0<K, V> extends o<K, V> implements SortedMap<K, V> {
        public f0(SortedSet<K> set, c1.t<? super K, V> function) {
            super(set, function);
        }

        @Override // java.util.SortedMap
        @gm.a
        public Comparator<? super K> comparator() {
            return e().comparator();
        }

        @Override // f1.t4.o
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public SortedSet<K> e() {
            return (SortedSet) this.f5321d;
        }

        @Override // java.util.SortedMap
        @m5
        public K firstKey() {
            return e().first();
        }

        @Override // java.util.SortedMap
        public SortedMap<K, V> headMap(@m5 K toKey) {
            return new f0((Set) e().headSet(toKey), (c1.t) this.f5322e);
        }

        @Override // f1.t4.r0, java.util.AbstractMap, java.util.Map
        /* JADX INFO: renamed from: keySet */
        public Set<K> i() {
            return new i(e());
        }

        @Override // java.util.SortedMap
        @m5
        public K lastKey() {
            return e().last();
        }

        @Override // java.util.SortedMap
        public SortedMap<K, V> subMap(@m5 K fromKey, @m5 K toKey) {
            return new f0((Set) e().subSet(fromKey, toKey), (c1.t) this.f5322e);
        }

        @Override // java.util.SortedMap
        public SortedMap<K, V> tailMap(@m5 K fromKey) {
            return new f0((Set) e().tailSet(fromKey), (c1.t) this.f5322e);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [V, K] */
    public class g<K, V> extends o7<K, Map.Entry<K, V>> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ c1.t f5309b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(Iterator backingIterator, final c1.t val$function) {
            super(backingIterator);
            this.f5309b = val$function;
        }

        @Override // f1.o7
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public Map.Entry<K, V> a(@m5 final K key) {
            return new f3(key, this.f5309b.apply(key));
        }
    }

    public static class g0<K, V> extends b0<K, V> implements SortedSet<K> {
        public g0(SortedMap<K, V> map) {
            super(map);
        }

        @Override // f1.t4.b0
        public SortedMap<K, V> b() {
            return (SortedMap) this.f5299a;
        }

        @Override // java.util.SortedSet
        @gm.a
        public Comparator<? super K> comparator() {
            return b().comparator();
        }

        @Override // java.util.SortedSet
        @m5
        public K first() {
            return b().firstKey();
        }

        public SortedSet<K> headSet(@m5 K toElement) {
            return new g0((Map) b().headMap(toElement));
        }

        @Override // java.util.SortedSet
        @m5
        public K last() {
            return b().lastKey();
        }

        public SortedSet<K> subSet(@m5 K fromElement, @m5 K toElement) {
            return new g0((Map) b().subMap(fromElement, toElement));
        }

        public SortedSet<K> tailSet(@m5 K fromElement) {
            return new g0((Map) b().tailMap(fromElement));
        }
    }

    public static class h0<K, V> extends c0<K, V> implements q6<K, V> {
        public h0(SortedMap<K, V> onlyOnLeft, SortedMap<K, V> onlyOnRight, SortedMap<K, V> onBoth, SortedMap<K, q4.a<V>> differences) {
            super(onlyOnLeft, onlyOnRight, onBoth, differences);
        }

        @Override // f1.t4.c0, f1.q4
        public SortedMap<K, V> a() {
            return (SortedMap) this.f5303b;
        }

        @Override // f1.t4.c0, f1.q4
        public SortedMap<K, V> b() {
            return (SortedMap) this.f5302a;
        }

        @Override // f1.t4.c0, f1.q4
        public SortedMap<K, q4.a<V>> c() {
            return (SortedMap) this.f5305d;
        }

        @Override // f1.t4.c0, f1.q4
        public SortedMap<K, V> d() {
            return (SortedMap) this.f5304c;
        }
    }

    public static class i0<K, V1, V2> extends a0<K, V2> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Map<K, V1> f5312a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final t<? super K, ? super V1, V2> f5313b;

        public i0(Map<K, V1> fromMap, t<? super K, ? super V1, V2> transformer) {
            fromMap.getClass();
            this.f5312a = fromMap;
            transformer.getClass();
            this.f5313b = transformer;
        }

        @Override // f1.t4.a0
        public Iterator<Map.Entry<K, V2>> a() {
            return h4.c0(this.f5312a.entrySet().iterator(), t4.g(this.f5313b));
        }

        @Override // f1.t4.a0, java.util.AbstractMap, java.util.Map
        public void clear() {
            this.f5312a.clear();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(@gm.a Object key) {
            return this.f5312a.containsKey(key);
        }

        @Override // java.util.AbstractMap, java.util.Map
        @gm.a
        public V2 get(@gm.a Object key) {
            V1 v10 = this.f5312a.get(key);
            if (v10 != null || this.f5312a.containsKey(key)) {
                return this.f5313b.a(key, v10);
            }
            return null;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Set<K> keySet() {
            return this.f5312a.keySet();
        }

        @Override // java.util.AbstractMap, java.util.Map
        @gm.a
        public V2 remove(@gm.a Object obj) {
            if (this.f5312a.containsKey(obj)) {
                return this.f5313b.a(obj, this.f5312a.remove(obj));
            }
            return null;
        }

        @Override // f1.t4.a0, java.util.AbstractMap, java.util.Map
        public int size() {
            return this.f5312a.size();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Collection<V2> values() {
            return new q0(this);
        }
    }

    @b1.c
    public static class j0<K, V1, V2> extends k0<K, V1, V2> implements NavigableMap<K, V2> {
        public j0(NavigableMap<K, V1> fromMap, t<? super K, ? super V1, V2> transformer) {
            super((Map) fromMap, (t) transformer);
        }

        @Override // java.util.NavigableMap
        @gm.a
        public Map.Entry<K, V2> ceilingEntry(@m5 K key) {
            return h(c().ceilingEntry(key));
        }

        @Override // java.util.NavigableMap
        @gm.a
        public K ceilingKey(@m5 K key) {
            return c().ceilingKey(key);
        }

        @Override // f1.t4.k0
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public NavigableMap<K, V1> c() {
            return (NavigableMap) ((SortedMap) this.f5312a);
        }

        @Override // java.util.NavigableMap
        public NavigableSet<K> descendingKeySet() {
            return c().descendingKeySet();
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, V2> descendingMap() {
            return new j0((Map) c().descendingMap(), (t) this.f5313b);
        }

        @Override // f1.t4.k0, java.util.SortedMap, java.util.NavigableMap
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public NavigableMap<K, V2> headMap(@m5 K toKey) {
            return headMap(toKey, false);
        }

        @Override // f1.t4.k0, java.util.SortedMap, java.util.NavigableMap
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public NavigableMap<K, V2> subMap(@m5 K fromKey, @m5 K toKey) {
            return subMap(fromKey, true, toKey, false);
        }

        @Override // java.util.NavigableMap
        @gm.a
        public Map.Entry<K, V2> firstEntry() {
            return h(c().firstEntry());
        }

        @Override // java.util.NavigableMap
        @gm.a
        public Map.Entry<K, V2> floorEntry(@m5 K key) {
            return h(c().floorEntry(key));
        }

        @Override // java.util.NavigableMap
        @gm.a
        public K floorKey(@m5 K key) {
            return c().floorKey(key);
        }

        @Override // f1.t4.k0, java.util.SortedMap, java.util.NavigableMap
        /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
        public NavigableMap<K, V2> tailMap(@m5 K fromKey) {
            return tailMap(fromKey, true);
        }

        @gm.a
        public final Map.Entry<K, V2> h(@gm.a Map.Entry<K, V1> entry) {
            if (entry == null) {
                return null;
            }
            return t4.A0(this.f5313b, entry);
        }

        @Override // java.util.NavigableMap
        @gm.a
        public Map.Entry<K, V2> higherEntry(@m5 K key) {
            return h(c().higherEntry(key));
        }

        @Override // java.util.NavigableMap
        @gm.a
        public K higherKey(@m5 K key) {
            return c().higherKey(key);
        }

        @Override // java.util.NavigableMap
        @gm.a
        public Map.Entry<K, V2> lastEntry() {
            return h(c().lastEntry());
        }

        @Override // java.util.NavigableMap
        @gm.a
        public Map.Entry<K, V2> lowerEntry(@m5 K key) {
            return h(c().lowerEntry(key));
        }

        @Override // java.util.NavigableMap
        @gm.a
        public K lowerKey(@m5 K key) {
            return c().lowerKey(key);
        }

        @Override // java.util.NavigableMap
        public NavigableSet<K> navigableKeySet() {
            return c().navigableKeySet();
        }

        @Override // java.util.NavigableMap
        @gm.a
        public Map.Entry<K, V2> pollFirstEntry() {
            return h(c().pollFirstEntry());
        }

        @Override // java.util.NavigableMap
        @gm.a
        public Map.Entry<K, V2> pollLastEntry() {
            return h(c().pollLastEntry());
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, V2> headMap(@m5 K toKey, boolean inclusive) {
            return new j0((Map) c().headMap(toKey, inclusive), (t) this.f5313b);
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, V2> subMap(@m5 K fromKey, boolean fromInclusive, @m5 K toKey, boolean toInclusive) {
            return new j0((Map) c().subMap(fromKey, fromInclusive, toKey, toInclusive), (t) this.f5313b);
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, V2> tailMap(@m5 K fromKey, boolean inclusive) {
            return new j0((Map) c().tailMap(fromKey, inclusive), (t) this.f5313b);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [V, K] */
    public class k<K, V> extends f1.g<K, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Map.Entry f5315a;

        public k(final Map.Entry val$entry) {
            this.f5315a = val$entry;
        }

        @Override // f1.g, java.util.Map.Entry
        @m5
        public K getKey() {
            return (K) this.f5315a.getKey();
        }

        @Override // f1.g, java.util.Map.Entry
        @m5
        public V getValue() {
            return (V) this.f5315a.getValue();
        }
    }

    public static class k0<K, V1, V2> extends i0<K, V1, V2> implements SortedMap<K, V2> {
        public k0(SortedMap<K, V1> fromMap, t<? super K, ? super V1, V2> transformer) {
            super(fromMap, transformer);
        }

        public SortedMap<K, V1> c() {
            return (SortedMap) this.f5312a;
        }

        @Override // java.util.SortedMap
        @gm.a
        public Comparator<? super K> comparator() {
            return c().comparator();
        }

        @Override // java.util.SortedMap
        @m5
        public K firstKey() {
            return c().firstKey();
        }

        public SortedMap<K, V2> headMap(@m5 K toKey) {
            return new k0((Map) c().headMap(toKey), (t) this.f5313b);
        }

        @Override // java.util.SortedMap
        @m5
        public K lastKey() {
            return c().lastKey();
        }

        public SortedMap<K, V2> subMap(@m5 K fromKey, @m5 K toKey) {
            return new k0((Map) c().subMap(fromKey, toKey), (t) this.f5313b);
        }

        public SortedMap<K, V2> tailMap(@m5 K fromKey) {
            return new k0((Map) c().tailMap(fromKey), (t) this.f5313b);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [V, K] */
    public class l<K, V> extends x7<Map.Entry<K, V>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Iterator f5316a;

        public l(final Iterator val$entryIterator) {
            this.f5316a = val$entryIterator;
        }

        @Override // java.util.Iterator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Map.Entry<K, V> next() {
            return t4.I0((Map.Entry) this.f5316a.next());
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f5316a.hasNext();
        }
    }

    public static class l0<K, V> extends d2<K, V> implements f1.w<K, V>, Serializable {
        private static final long serialVersionUID = 0;
        final f1.w<? extends K, ? extends V> delegate;

        @u1.b
        @RetainedWith
        @gm.a
        f1.w<V, K> inverse;
        final Map<K, V> unmodifiableMap;

        @u1.b
        @gm.a
        transient Set<V> values;

        public l0(f1.w<? extends K, ? extends V> delegate, @gm.a f1.w<V, K> inverse) {
            this.unmodifiableMap = Collections.unmodifiableMap(delegate);
            this.delegate = delegate;
            this.inverse = inverse;
        }

        @Override // f1.w
        @gm.a
        public V forcePut(@m5 K key, @m5 V value) {
            throw new UnsupportedOperationException();
        }

        @Override // f1.w
        public f1.w<V, K> inverse() {
            f1.w<V, K> wVar = this.inverse;
            if (wVar != null) {
                return wVar;
            }
            l0 l0Var = new l0(this.delegate.inverse(), this);
            this.inverse = l0Var;
            return l0Var;
        }

        @Override // f1.d2, f1.j2
        public Map<K, V> delegate() {
            return this.unmodifiableMap;
        }

        @Override // f1.d2, java.util.Map, f1.w
        public Set<V> values() {
            Set<V> set = this.values;
            if (set != null) {
                return set;
            }
            Set<V> setUnmodifiableSet = Collections.unmodifiableSet(this.delegate.values());
            this.values = setUnmodifiableSet;
            return setUnmodifiableSet;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [K, V1, V2] */
    public class m<K, V1, V2> implements t<K, V1, V2> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c1.t f5317a;

        public m(final c1.t val$function) {
            this.f5317a = val$function;
        }

        @Override // f1.t4.t
        @m5
        public V2 a(@m5 K k10, @m5 V1 v10) {
            return (V2) this.f5317a.apply(v10);
        }
    }

    public static class m0<K, V> extends s1<Map.Entry<K, V>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Collection<Map.Entry<K, V>> f5318a;

        public m0(Collection<Map.Entry<K, V>> entries) {
            this.f5318a = entries;
        }

        @Override // f1.s1, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Map.Entry<K, V>> iterator() {
            return new l(this.f5318a.iterator());
        }

        @Override // f1.s1, java.util.Collection, java.util.Set
        public Object[] toArray() {
            return standardToArray();
        }

        @Override // f1.s1, f1.j2
        public Collection<Map.Entry<K, V>> delegate() {
            return this.f5318a;
        }

        @Override // f1.s1, java.util.Collection, java.util.Set
        public <T> T[] toArray(T[] tArr) {
            return (T[]) standardToArray(tArr);
        }
    }

    public static abstract class n<K, V> extends r0<K, V> {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Map<K, V> f5319d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final c1.i0<? super Map.Entry<K, V>> f5320e;

        public n(Map<K, V> unfiltered, c1.i0<? super Map.Entry<K, V>> predicate) {
            this.f5319d = unfiltered;
            this.f5320e = predicate;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(@gm.a Object key) {
            return this.f5319d.containsKey(key) && e(key, this.f5319d.get(key));
        }

        @Override // f1.t4.r0
        public Collection<V> d() {
            return new z(this, this.f5319d, this.f5320e);
        }

        public boolean e(@gm.a Object key, @m5 V value) {
            return this.f5320e.apply(new f3(key, value));
        }

        @Override // java.util.AbstractMap, java.util.Map
        @gm.a
        public V get(@gm.a Object key) {
            V v10 = this.f5319d.get(key);
            if (v10 == null || !e(key, v10)) {
                return null;
            }
            return v10;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean isEmpty() {
            return entrySet().isEmpty();
        }

        @Override // java.util.AbstractMap, java.util.Map
        @gm.a
        public V put(@m5 K key, @m5 V value) {
            c1.h0.d(e(key, value));
            return this.f5319d.put(key, value);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public void putAll(Map<? extends K, ? extends V> map) {
            for (Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
                c1.h0.d(e(entry.getKey(), entry.getValue()));
            }
            this.f5319d.putAll(map);
        }

        @Override // java.util.AbstractMap, java.util.Map
        @gm.a
        public V remove(@gm.a Object key) {
            if (containsKey(key)) {
                return this.f5319d.remove(key);
            }
            return null;
        }
    }

    public static class n0<K, V> extends m0<K, V> implements Set<Map.Entry<K, V>> {
        public n0(Set<Map.Entry<K, V>> entries) {
            super(entries);
        }

        @Override // java.util.Collection, java.util.Set
        public boolean equals(@gm.a Object object) {
            return k6.g(this, object);
        }

        @Override // java.util.Collection, java.util.Set
        public int hashCode() {
            return k6.k(this);
        }
    }

    public static class o<K, V> extends r0<K, V> {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Set<K> f5321d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final c1.t<? super K, V> f5322e;

        public class a extends s<K, V> {
            public a() {
            }

            @Override // f1.t4.s
            public Map<K, V> a() {
                return o.this;
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
            public Iterator<Map.Entry<K, V>> iterator() {
                return t4.m(o.this.e(), o.this.f5322e);
            }
        }

        public o(Set<K> set, c1.t<? super K, V> function) {
            set.getClass();
            this.f5321d = set;
            function.getClass();
            this.f5322e = function;
        }

        @Override // f1.t4.r0
        public Set<Map.Entry<K, V>> a() {
            return new a();
        }

        @Override // f1.t4.r0
        /* JADX INFO: renamed from: c */
        public Set<K> h() {
            return new h(e());
        }

        @Override // java.util.AbstractMap, java.util.Map
        public void clear() {
            e().clear();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(@gm.a Object key) {
            return e().contains(key);
        }

        @Override // f1.t4.r0
        public Collection<V> d() {
            return new f1.c0.f(this.f5321d, this.f5322e);
        }

        public Set<K> e() {
            return this.f5321d;
        }

        @Override // java.util.AbstractMap, java.util.Map
        @gm.a
        public V get(@gm.a Object key) {
            if (f1.c0.j(e(), key)) {
                return this.f5322e.apply(key);
            }
            return null;
        }

        @Override // java.util.AbstractMap, java.util.Map
        @gm.a
        public V remove(@gm.a Object key) {
            if (e().remove(key)) {
                return this.f5322e.apply(key);
            }
            return null;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public int size() {
            return e().size();
        }
    }

    @b1.c
    public static class o0<K, V> extends n2<K, V> implements NavigableMap<K, V>, Serializable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @u1.b
        @gm.a
        public transient o0<K, V> f5324a;
        private final NavigableMap<K, ? extends V> delegate;

        public o0(NavigableMap<K, ? extends V> delegate) {
            this.delegate = delegate;
        }

        @Override // java.util.NavigableMap
        @gm.a
        public Map.Entry<K, V> ceilingEntry(@m5 K key) {
            return t4.N0(this.delegate.ceilingEntry(key));
        }

        @Override // java.util.NavigableMap
        @gm.a
        public K ceilingKey(@m5 K key) {
            return this.delegate.ceilingKey(key);
        }

        @Override // java.util.NavigableMap
        public NavigableSet<K> descendingKeySet() {
            return k6.O(this.delegate.descendingKeySet());
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, V> descendingMap() {
            o0<K, V> o0Var = this.f5324a;
            if (o0Var != null) {
                return o0Var;
            }
            o0<K, V> o0Var2 = new o0<>(this.delegate.descendingMap(), this);
            this.f5324a = o0Var2;
            return o0Var2;
        }

        @Override // java.util.NavigableMap
        @gm.a
        public Map.Entry<K, V> firstEntry() {
            return t4.N0(this.delegate.firstEntry());
        }

        @Override // java.util.NavigableMap
        @gm.a
        public Map.Entry<K, V> floorEntry(@m5 K key) {
            return t4.N0(this.delegate.floorEntry(key));
        }

        @Override // java.util.NavigableMap
        @gm.a
        public K floorKey(@m5 K key) {
            return this.delegate.floorKey(key);
        }

        @Override // f1.n2, java.util.SortedMap
        public SortedMap<K, V> headMap(@m5 K toKey) {
            return headMap(toKey, false);
        }

        @Override // java.util.NavigableMap
        @gm.a
        public Map.Entry<K, V> higherEntry(@m5 K key) {
            return t4.N0(this.delegate.higherEntry(key));
        }

        @Override // java.util.NavigableMap
        @gm.a
        public K higherKey(@m5 K key) {
            return this.delegate.higherKey(key);
        }

        @Override // f1.d2, java.util.Map
        public Set<K> keySet() {
            return navigableKeySet();
        }

        @Override // java.util.NavigableMap
        @gm.a
        public Map.Entry<K, V> lastEntry() {
            return t4.N0(this.delegate.lastEntry());
        }

        @Override // java.util.NavigableMap
        @gm.a
        public Map.Entry<K, V> lowerEntry(@m5 K key) {
            return t4.N0(this.delegate.lowerEntry(key));
        }

        @Override // java.util.NavigableMap
        @gm.a
        public K lowerKey(@m5 K key) {
            return this.delegate.lowerKey(key);
        }

        @Override // java.util.NavigableMap
        public NavigableSet<K> navigableKeySet() {
            return k6.O(this.delegate.navigableKeySet());
        }

        @Override // java.util.NavigableMap
        @gm.a
        public final Map.Entry<K, V> pollFirstEntry() {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.NavigableMap
        @gm.a
        public final Map.Entry<K, V> pollLastEntry() {
            throw new UnsupportedOperationException();
        }

        @Override // f1.n2, java.util.SortedMap
        public SortedMap<K, V> subMap(@m5 K fromKey, @m5 K toKey) {
            return subMap(fromKey, true, toKey, false);
        }

        @Override // f1.n2, java.util.SortedMap
        public SortedMap<K, V> tailMap(@m5 K fromKey) {
            return tailMap(fromKey, true);
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, V> headMap(@m5 K toKey, boolean inclusive) {
            return t4.M0(this.delegate.headMap(toKey, inclusive));
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, V> subMap(@m5 K fromKey, boolean fromInclusive, @m5 K toKey, boolean toInclusive) {
            return t4.M0(this.delegate.subMap(fromKey, fromInclusive, toKey, toInclusive));
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, V> tailMap(@m5 K fromKey, boolean inclusive) {
            return t4.M0(this.delegate.tailMap(fromKey, inclusive));
        }

        public o0(NavigableMap<K, ? extends V> delegate, o0<K, V> descendingMap) {
            this.delegate = delegate;
            this.f5324a = descendingMap;
        }

        @Override // f1.n2, f1.d2, f1.j2
        public SortedMap<K, V> delegate() {
            return Collections.unmodifiableSortedMap(this.delegate);
        }
    }

    public static final class p<A, B> extends c1.i<A, B> implements Serializable {
        private static final long serialVersionUID = 0;
        private final f1.w<A, B> bimap;

        public p(f1.w<A, B> bimap) {
            bimap.getClass();
            this.bimap = bimap;
        }

        public static <X, Y> Y c(f1.w<X, Y> bimap, X input) {
            Y y10 = bimap.get(input);
            c1.h0.u(y10 != null, "No non-null mapping present for input: %s", input);
            return y10;
        }

        @Override // c1.i
        public A doBackward(B b10) {
            return (A) c(this.bimap.inverse(), b10);
        }

        @Override // c1.i
        public B doForward(A a10) {
            return (B) c(this.bimap, a10);
        }

        @Override // c1.i, c1.t
        public boolean equals(@gm.a Object object) {
            if (object instanceof p) {
                return this.bimap.equals(((p) object).bimap);
            }
            return false;
        }

        public int hashCode() {
            return this.bimap.hashCode();
        }

        public String toString() {
            return "Maps.asConverter(" + this.bimap + ")";
        }
    }

    public static class p0<V> implements q4.a<V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @m5
        public final V f5325a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @m5
        public final V f5326b;

        public p0(@m5 V left, @m5 V right) {
            this.f5325a = left;
            this.f5326b = right;
        }

        public static <V> q4.a<V> c(@m5 V left, @m5 V right) {
            return new p0(left, right);
        }

        @Override // f1.q4.a
        @m5
        public V a() {
            return this.f5325a;
        }

        @Override // f1.q4.a
        @m5
        public V b() {
            return this.f5326b;
        }

        @Override // f1.q4.a
        public boolean equals(@gm.a Object object) {
            if (!(object instanceof q4.a)) {
                return false;
            }
            q4.a aVar = (q4.a) object;
            return c1.b0.a(this.f5325a, aVar.a()) && c1.b0.a(this.f5326b, aVar.b());
        }

        @Override // f1.q4.a
        public int hashCode() {
            return Arrays.hashCode(new Object[]{this.f5325a, this.f5326b});
        }

        public String toString() {
            StringBuilder sb2 = new StringBuilder("(");
            sb2.append(this.f5325a);
            sb2.append(", ");
            return j.e.a(sb2, this.f5326b, ")");
        }
    }

    @b1.c
    public static abstract class q<K, V> extends d2<K, V> implements NavigableMap<K, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @u1.b
        @gm.a
        public transient Comparator<? super K> f5327a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @u1.b
        @gm.a
        public transient Set<Map.Entry<K, V>> f5328b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @u1.b
        @gm.a
        public transient NavigableSet<K> f5329c;

        public class a extends s<K, V> {
            public a() {
            }

            @Override // f1.t4.s
            public Map<K, V> a() {
                return q.this;
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
            public Iterator<Map.Entry<K, V>> iterator() {
                return q.this.m();
            }
        }

        private static <T> l5<T> r(Comparator<T> forward) {
            return l5.from(forward).reverse();
        }

        @Override // java.util.NavigableMap
        @gm.a
        public Map.Entry<K, V> ceilingEntry(@m5 K key) {
            return q().floorEntry(key);
        }

        @Override // java.util.NavigableMap
        @gm.a
        public K ceilingKey(@m5 K key) {
            return q().floorKey(key);
        }

        @Override // java.util.SortedMap
        public Comparator<? super K> comparator() {
            Comparator<? super K> comparator = this.f5327a;
            if (comparator != null) {
                return comparator;
            }
            Comparator<? super K> comparator2 = q().comparator();
            if (comparator2 == null) {
                comparator2 = l5.natural();
            }
            l5 l5VarR = r(comparator2);
            this.f5327a = l5VarR;
            return l5VarR;
        }

        @Override // f1.d2, f1.j2
        public Object delegate() {
            return q();
        }

        @Override // java.util.NavigableMap
        public NavigableSet<K> descendingKeySet() {
            return q().navigableKeySet();
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, V> descendingMap() {
            return q();
        }

        @Override // f1.d2, java.util.Map
        public Set<Map.Entry<K, V>> entrySet() {
            Set<Map.Entry<K, V>> set = this.f5328b;
            if (set != null) {
                return set;
            }
            Set<Map.Entry<K, V>> setL = l();
            this.f5328b = setL;
            return setL;
        }

        @Override // java.util.NavigableMap
        @gm.a
        public Map.Entry<K, V> firstEntry() {
            return q().lastEntry();
        }

        @Override // java.util.SortedMap
        @m5
        public K firstKey() {
            return q().lastKey();
        }

        @Override // java.util.NavigableMap
        @gm.a
        public Map.Entry<K, V> floorEntry(@m5 K key) {
            return q().ceilingEntry(key);
        }

        @Override // java.util.NavigableMap
        @gm.a
        public K floorKey(@m5 K key) {
            return q().ceilingKey(key);
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, V> headMap(@m5 K toKey, boolean inclusive) {
            return q().tailMap(toKey, inclusive).descendingMap();
        }

        @Override // java.util.NavigableMap
        @gm.a
        public Map.Entry<K, V> higherEntry(@m5 K key) {
            return q().lowerEntry(key);
        }

        @Override // java.util.NavigableMap
        @gm.a
        public K higherKey(@m5 K key) {
            return q().lowerKey(key);
        }

        @Override // f1.d2, java.util.Map
        public Set<K> keySet() {
            return navigableKeySet();
        }

        public Set<Map.Entry<K, V>> l() {
            return new a();
        }

        @Override // java.util.NavigableMap
        @gm.a
        public Map.Entry<K, V> lastEntry() {
            return q().firstEntry();
        }

        @Override // java.util.SortedMap
        @m5
        public K lastKey() {
            return q().firstKey();
        }

        @Override // java.util.NavigableMap
        @gm.a
        public Map.Entry<K, V> lowerEntry(@m5 K key) {
            return q().higherEntry(key);
        }

        @Override // java.util.NavigableMap
        @gm.a
        public K lowerKey(@m5 K key) {
            return q().higherKey(key);
        }

        public abstract Iterator<Map.Entry<K, V>> m();

        @Override // java.util.NavigableMap
        public NavigableSet<K> navigableKeySet() {
            NavigableSet<K> navigableSet = this.f5329c;
            if (navigableSet != null) {
                return navigableSet;
            }
            e0 e0Var = new e0((Map) this);
            this.f5329c = e0Var;
            return e0Var;
        }

        @Override // java.util.NavigableMap
        @gm.a
        public Map.Entry<K, V> pollFirstEntry() {
            return q().pollLastEntry();
        }

        @Override // java.util.NavigableMap
        @gm.a
        public Map.Entry<K, V> pollLastEntry() {
            return q().pollFirstEntry();
        }

        public abstract NavigableMap<K, V> q();

        @Override // java.util.NavigableMap
        public NavigableMap<K, V> subMap(@m5 K fromKey, boolean fromInclusive, @m5 K toKey, boolean toInclusive) {
            return q().subMap(toKey, toInclusive, fromKey, fromInclusive).descendingMap();
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, V> tailMap(@m5 K fromKey, boolean inclusive) {
            return q().headMap(fromKey, inclusive).descendingMap();
        }

        @Override // f1.j2
        public String toString() {
            return standardToString();
        }

        @Override // f1.d2, java.util.Map, f1.w
        public Collection<V> values() {
            return new q0(this);
        }

        @Override // f1.d2, f1.j2
        public final Map<K, V> delegate() {
            return q();
        }

        @Override // java.util.NavigableMap, java.util.SortedMap
        public SortedMap<K, V> headMap(@m5 K toKey) {
            return headMap(toKey, false);
        }

        @Override // java.util.NavigableMap, java.util.SortedMap
        public SortedMap<K, V> subMap(@m5 K fromKey, @m5 K toKey) {
            return subMap(fromKey, true, toKey, false);
        }

        @Override // java.util.NavigableMap, java.util.SortedMap
        public SortedMap<K, V> tailMap(@m5 K fromKey) {
            return tailMap(fromKey, true);
        }
    }

    public static class q0<K, V> extends AbstractCollection<V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @Weak
        public final Map<K, V> f5331a;

        public q0(Map<K, V> map) {
            map.getClass();
            this.f5331a = map;
        }

        public final Map<K, V> a() {
            return this.f5331a;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            this.f5331a.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean contains(@gm.a Object o10) {
            return this.f5331a.containsValue(o10);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean isEmpty() {
            return this.f5331a.isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<V> iterator() {
            return new f(this.f5331a.entrySet().iterator());
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean remove(@gm.a Object o10) {
            try {
                return super.remove(o10);
            } catch (UnsupportedOperationException unused) {
                for (Map.Entry<K, V> entry : this.f5331a.entrySet()) {
                    if (c1.b0.a(o10, entry.getValue())) {
                        this.f5331a.remove(entry.getKey());
                        return true;
                    }
                }
                return false;
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean removeAll(Collection<?> c10) {
            try {
                c10.getClass();
                return super.removeAll(c10);
            } catch (UnsupportedOperationException unused) {
                HashSet hashSet = new HashSet();
                for (Map.Entry<K, V> entry : this.f5331a.entrySet()) {
                    if (c10.contains(entry.getValue())) {
                        hashSet.add(entry.getKey());
                    }
                }
                return this.f5331a.keySet().removeAll(hashSet);
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean retainAll(Collection<?> c10) {
            try {
                c10.getClass();
                return super.retainAll(c10);
            } catch (UnsupportedOperationException unused) {
                HashSet hashSet = new HashSet();
                for (Map.Entry<K, V> entry : this.f5331a.entrySet()) {
                    if (c10.contains(entry.getValue())) {
                        hashSet.add(entry.getKey());
                    }
                }
                return this.f5331a.keySet().retainAll(hashSet);
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return this.f5331a.size();
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    public static abstract class r implements c1.t<Map.Entry<?, ?>, Object> {
        public static final r KEY = new a("KEY", 0);
        public static final r VALUE = new b("VALUE", 1);

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ r[] f5332a = a();

        public final enum a extends r {
            public a(String $enum$name, int $enum$ordinal) {
                super($enum$name, $enum$ordinal, null);
            }

            @Override // c1.t
            @gm.a
            public Object apply(Map.Entry<?, ?> entry) {
                return entry.getKey();
            }
        }

        public final enum b extends r {
            public b(String $enum$name, int $enum$ordinal) {
                super($enum$name, $enum$ordinal, null);
            }

            @Override // c1.t
            @gm.a
            public Object apply(Map.Entry<?, ?> entry) {
                return entry.getValue();
            }
        }

        public r(String $enum$name, int $enum$ordinal) {
            super($enum$name, $enum$ordinal);
        }

        public static /* synthetic */ r[] a() {
            return new r[]{KEY, VALUE};
        }

        public static r valueOf(String name) {
            return (r) Enum.valueOf(r.class, name);
        }

        public static r[] values() {
            return (r[]) f5332a.clone();
        }

        public r(String str, int i10, e eVar) {
            super(str, i10);
        }
    }

    @b1.b
    public static abstract class r0<K, V> extends AbstractMap<K, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @u1.b
        @gm.a
        public transient Set<Map.Entry<K, V>> f5333a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @u1.b
        @gm.a
        public transient Set<K> f5334b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @u1.b
        @gm.a
        public transient Collection<V> f5335c;

        public abstract Set<Map.Entry<K, V>> a();

        /* JADX INFO: renamed from: c */
        public Set<K> h() {
            return new b0(this);
        }

        public Collection<V> d() {
            return new q0(this);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Set<Map.Entry<K, V>> entrySet() {
            Set<Map.Entry<K, V>> set = this.f5333a;
            if (set != null) {
                return set;
            }
            Set<Map.Entry<K, V>> setA = a();
            this.f5333a = setA;
            return setA;
        }

        @Override // java.util.AbstractMap, java.util.Map
        /* JADX INFO: renamed from: keySet */
        public Set<K> i() {
            Set<K> set = this.f5334b;
            if (set != null) {
                return set;
            }
            Set<K> setH = h();
            this.f5334b = setH;
            return setH;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Collection<V> values() {
            Collection<V> collection = this.f5335c;
            if (collection != null) {
                return collection;
            }
            Collection<V> collectionD = d();
            this.f5335c = collectionD;
            return collectionD;
        }
    }

    public static abstract class s<K, V> extends k6.k<Map.Entry<K, V>> {
        public abstract Map<K, V> a();

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            a().clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(@gm.a Object o10) {
            if (!(o10 instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) o10;
            Object key = entry.getKey();
            Object objP0 = t4.p0(a(), key);
            if (c1.b0.a(objP0, entry.getValue())) {
                return objP0 != null || a().containsKey(key);
            }
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            return a().isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(@gm.a Object o10) {
            if (contains(o10) && (o10 instanceof Map.Entry)) {
                return a().keySet().remove(((Map.Entry) o10).getKey());
            }
            return false;
        }

        @Override // f1.k6.k, java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean removeAll(Collection<?> c10) {
            try {
                c10.getClass();
                return k6.I(this, c10);
            } catch (UnsupportedOperationException unused) {
                return k6.J(this, c10.iterator());
            }
        }

        @Override // f1.k6.k, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean retainAll(Collection<?> c10) {
            try {
                c10.getClass();
                return super.retainAll(c10);
            } catch (UnsupportedOperationException unused) {
                HashSet hashSetY = k6.y(c10.size());
                for (Object obj : c10) {
                    if (contains(obj) && (obj instanceof Map.Entry)) {
                        hashSetY.add(((Map.Entry) obj).getKey());
                    }
                }
                return a().keySet().retainAll(hashSetY);
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return a().size();
        }
    }

    public interface t<K, V1, V2> {
        @m5
        V2 a(@m5 K key, @m5 V1 value);
    }

    public static final class u<K, V> extends v<K, V> implements f1.w<K, V> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        @RetainedWith
        public final f1.w<V, K> f5336g;

        public class a implements c1.i0<Map.Entry<V, K>> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ c1.i0 f5337a;

            public a(final c1.i0 val$forwardPredicate) {
                this.f5337a = val$forwardPredicate;
            }

            @Override // c1.i0
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public boolean apply(Map.Entry<V, K> input) {
                return this.f5337a.apply(new f3(input.getValue(), input.getKey()));
            }
        }

        public u(f1.w<K, V> delegate, c1.i0<? super Map.Entry<K, V>> predicate) {
            super(delegate, predicate);
            this.f5336g = new u(delegate.inverse(), new a(predicate), this);
        }

        public static <K, V> c1.i0<Map.Entry<V, K>> h(final c1.i0<? super Map.Entry<K, V>> forwardPredicate) {
            return new a(forwardPredicate);
        }

        @Override // f1.w
        @gm.a
        public V forcePut(@m5 K k10, @m5 V v10) {
            c1.h0.d(e(k10, v10));
            return (V) ((f1.w) this.f5319d).forcePut(k10, v10);
        }

        public f1.w<K, V> i() {
            return (f1.w) this.f5319d;
        }

        @Override // f1.w
        public f1.w<V, K> inverse() {
            return this.f5336g;
        }

        @Override // f1.t4.r0, java.util.AbstractMap, java.util.Map
        public Collection values() {
            return this.f5336g.keySet();
        }

        @Override // f1.t4.r0, java.util.AbstractMap, java.util.Map
        public Set<V> values() {
            return this.f5336g.keySet();
        }

        public u(f1.w<K, V> delegate, c1.i0<? super Map.Entry<K, V>> predicate, f1.w<V, K> inverse) {
            super(delegate, predicate);
            this.f5336g = inverse;
        }
    }

    public static class v<K, V> extends n<K, V> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final Set<Map.Entry<K, V>> f5338f;

        public class a extends l2<Map.Entry<K, V>> {

            /* JADX INFO: renamed from: f1.t4$v$a$a, reason: collision with other inner class name */
            public class C0122a extends o7<Map.Entry<K, V>, Map.Entry<K, V>> {

                /* JADX INFO: renamed from: f1.t4$v$a$a$a, reason: collision with other inner class name */
                public class C0123a extends e2<K, V> {

                    /* JADX INFO: renamed from: a, reason: collision with root package name */
                    public final /* synthetic */ Map.Entry f5341a;

                    public C0123a(final Map.Entry val$entry) {
                        this.f5341a = val$entry;
                    }

                    @Override // f1.e2, f1.j2
                    /* JADX INFO: renamed from: l, reason: merged with bridge method [inline-methods] */
                    public Map.Entry<K, V> delegate() {
                        return this.f5341a;
                    }

                    @Override // f1.e2, java.util.Map.Entry
                    @m5
                    public V setValue(@m5 V v10) {
                        c1.h0.d(v.this.e(getKey(), v10));
                        return (V) super.setValue(v10);
                    }
                }

                public C0122a(Iterator backingIterator) {
                    super(backingIterator);
                }

                @Override // f1.o7
                /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
                public Map.Entry<K, V> a(final Map.Entry<K, V> entry) {
                    return new C0123a(entry);
                }
            }

            public a() {
            }

            @Override // f1.s1, java.util.Collection, java.lang.Iterable, java.util.Set
            public Iterator<Map.Entry<K, V>> iterator() {
                return new C0122a(v.this.f5338f.iterator());
            }

            public /* synthetic */ a(v vVar, e eVar) {
                this();
            }

            @Override // f1.l2, f1.s1, f1.j2
            public Set<Map.Entry<K, V>> delegate() {
                return v.this.f5338f;
            }
        }

        public class b extends b0<K, V> {
            public b() {
                super(v.this);
            }

            @Override // f1.t4.b0, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean remove(@gm.a Object o10) {
                if (!v.this.containsKey(o10)) {
                    return false;
                }
                v.this.f5319d.remove(o10);
                return true;
            }

            @Override // f1.k6.k, java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean removeAll(Collection<?> collection) {
                v vVar = v.this;
                return v.f(vVar.f5319d, vVar.f5320e, collection);
            }

            @Override // f1.k6.k, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean retainAll(Collection<?> collection) {
                v vVar = v.this;
                return v.g(vVar.f5319d, vVar.f5320e, collection);
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public Object[] toArray() {
                return p4.s(iterator()).toArray();
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public <T> T[] toArray(T[] tArr) {
                return (T[]) p4.s(iterator()).toArray(tArr);
            }
        }

        public v(Map<K, V> unfiltered, c1.i0<? super Map.Entry<K, V>> entryPredicate) {
            super(unfiltered, entryPredicate);
            this.f5338f = k6.i(unfiltered.entrySet(), this.f5320e);
        }

        public static <K, V> boolean f(Map<K, V> map, c1.i0<? super Map.Entry<K, V>> entryPredicate, Collection<?> keyCollection) {
            Iterator<Map.Entry<K, V>> it = map.entrySet().iterator();
            boolean z10 = false;
            while (it.hasNext()) {
                Map.Entry<K, V> next = it.next();
                if (entryPredicate.apply(next) && keyCollection.contains(next.getKey())) {
                    it.remove();
                    z10 = true;
                }
            }
            return z10;
        }

        public static <K, V> boolean g(Map<K, V> map, c1.i0<? super Map.Entry<K, V>> entryPredicate, Collection<?> keyCollection) {
            Iterator<Map.Entry<K, V>> it = map.entrySet().iterator();
            boolean z10 = false;
            while (it.hasNext()) {
                Map.Entry<K, V> next = it.next();
                if (entryPredicate.apply(next) && !keyCollection.contains(next.getKey())) {
                    it.remove();
                    z10 = true;
                }
            }
            return z10;
        }

        @Override // f1.t4.r0
        public Set<Map.Entry<K, V>> a() {
            return new a();
        }

        @Override // f1.t4.r0
        /* JADX INFO: renamed from: c */
        public Set<K> h() {
            return new b();
        }
    }

    @b1.c
    public static class w<K, V> extends f1.j<K, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final NavigableMap<K, V> f5344a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final c1.i0<? super Map.Entry<K, V>> f5345b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Map<K, V> f5346c;

        public class a extends e0<K, V> {
            public a(NavigableMap map) {
                super((Map) map);
            }

            @Override // f1.k6.k, java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean removeAll(Collection<?> collection) {
                return v.f(w.this.f5344a, w.this.f5345b, collection);
            }

            @Override // f1.k6.k, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean retainAll(Collection<?> collection) {
                return v.g(w.this.f5344a, w.this.f5345b, collection);
            }
        }

        public w(NavigableMap<K, V> unfiltered, c1.i0<? super Map.Entry<K, V>> entryPredicate) {
            unfiltered.getClass();
            this.f5344a = unfiltered;
            this.f5345b = entryPredicate;
            this.f5346c = new v(unfiltered, entryPredicate);
        }

        @Override // f1.t4.a0
        public Iterator<Map.Entry<K, V>> a() {
            return h4.x(this.f5344a.entrySet().iterator(), this.f5345b);
        }

        @Override // f1.j
        public Iterator<Map.Entry<K, V>> c() {
            return h4.x(this.f5344a.descendingMap().entrySet().iterator(), this.f5345b);
        }

        @Override // f1.t4.a0, java.util.AbstractMap, java.util.Map
        public void clear() {
            this.f5346c.clear();
        }

        @Override // java.util.SortedMap
        @gm.a
        public Comparator<? super K> comparator() {
            return this.f5344a.comparator();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(@gm.a Object key) {
            return this.f5346c.containsKey(key);
        }

        @Override // f1.j, java.util.NavigableMap
        public NavigableMap<K, V> descendingMap() {
            return t4.z(this.f5344a.descendingMap(), this.f5345b);
        }

        @Override // f1.t4.a0, java.util.AbstractMap, java.util.Map
        public Set<Map.Entry<K, V>> entrySet() {
            return this.f5346c.entrySet();
        }

        @Override // f1.j, java.util.AbstractMap, java.util.Map
        @gm.a
        public V get(@gm.a Object key) {
            return this.f5346c.get(key);
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, V> headMap(@m5 K toKey, boolean inclusive) {
            return t4.z(this.f5344a.headMap(toKey, inclusive), this.f5345b);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean isEmpty() {
            return !g4.c(this.f5344a.entrySet(), this.f5345b);
        }

        @Override // f1.j, java.util.NavigableMap
        public NavigableSet<K> navigableKeySet() {
            return new a(this);
        }

        @Override // f1.j, java.util.NavigableMap
        @gm.a
        public Map.Entry<K, V> pollFirstEntry() {
            return (Map.Entry) g4.I(this.f5344a.entrySet(), this.f5345b);
        }

        @Override // f1.j, java.util.NavigableMap
        @gm.a
        public Map.Entry<K, V> pollLastEntry() {
            return (Map.Entry) g4.I(this.f5344a.descendingMap().entrySet(), this.f5345b);
        }

        @Override // java.util.AbstractMap, java.util.Map
        @gm.a
        public V put(@m5 K key, @m5 V value) {
            return this.f5346c.put(key, value);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public void putAll(Map<? extends K, ? extends V> m10) {
            this.f5346c.putAll(m10);
        }

        @Override // java.util.AbstractMap, java.util.Map
        @gm.a
        public V remove(@gm.a Object key) {
            return this.f5346c.remove(key);
        }

        @Override // f1.t4.a0, java.util.AbstractMap, java.util.Map
        public int size() {
            return this.f5346c.size();
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, V> subMap(@m5 K fromKey, boolean fromInclusive, @m5 K toKey, boolean toInclusive) {
            return t4.z(this.f5344a.subMap(fromKey, fromInclusive, toKey, toInclusive), this.f5345b);
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, V> tailMap(@m5 K fromKey, boolean inclusive) {
            return t4.z(this.f5344a.tailMap(fromKey, inclusive), this.f5345b);
        }

        @Override // java.util.AbstractMap, java.util.Map, java.util.SortedMap
        public Collection<V> values() {
            return new z(this, this.f5344a, this.f5345b);
        }
    }

    public static class x<K, V> extends v<K, V> implements SortedMap<K, V> {

        public class a extends v<K, V>.b implements SortedSet<K> {
            public a() {
                super();
            }

            @Override // java.util.SortedSet
            @gm.a
            public Comparator<? super K> comparator() {
                return x.this.j().comparator();
            }

            @Override // java.util.SortedSet
            @m5
            public K first() {
                return (K) x.this.firstKey();
            }

            @Override // java.util.SortedSet
            public SortedSet<K> headSet(@m5 K toElement) {
                return (SortedSet) x.this.headMap(toElement).keySet();
            }

            @Override // java.util.SortedSet
            @m5
            public K last() {
                return (K) x.this.lastKey();
            }

            @Override // java.util.SortedSet
            public SortedSet<K> subSet(@m5 K fromElement, @m5 K toElement) {
                return (SortedSet) x.this.subMap(fromElement, toElement).keySet();
            }

            @Override // java.util.SortedSet
            public SortedSet<K> tailSet(@m5 K fromElement) {
                return (SortedSet) x.this.tailMap(fromElement).keySet();
            }
        }

        public x(SortedMap<K, V> unfiltered, c1.i0<? super Map.Entry<K, V>> entryPredicate) {
            super(unfiltered, entryPredicate);
        }

        @Override // java.util.SortedMap
        @gm.a
        public Comparator<? super K> comparator() {
            return j().comparator();
        }

        @Override // java.util.SortedMap
        @m5
        public K firstKey() {
            return i().iterator().next();
        }

        @Override // f1.t4.v, f1.t4.r0
        public SortedSet<K> h() {
            return new a();
        }

        @Override // java.util.SortedMap
        public SortedMap<K, V> headMap(@m5 K toKey) {
            return new x((Map) j().headMap(toKey), (c1.i0) this.f5320e);
        }

        @Override // f1.t4.r0, java.util.AbstractMap, java.util.Map
        public SortedSet<K> i() {
            return (SortedSet) super.i();
        }

        public SortedMap<K, V> j() {
            return (SortedMap) this.f5319d;
        }

        @Override // java.util.SortedMap
        @m5
        public K lastKey() {
            SortedMap<K, V> sortedMapJ = j();
            while (true) {
                K kLastKey = sortedMapJ.lastKey();
                if (e(kLastKey, this.f5319d.get(kLastKey))) {
                    return kLastKey;
                }
                sortedMapJ = j().headMap(kLastKey);
            }
        }

        @Override // java.util.SortedMap
        public SortedMap<K, V> subMap(@m5 K fromKey, @m5 K toKey) {
            return new x((Map) j().subMap(fromKey, toKey), (c1.i0) this.f5320e);
        }

        @Override // java.util.SortedMap
        public SortedMap<K, V> tailMap(@m5 K fromKey) {
            return new x((Map) j().tailMap(fromKey), (c1.i0) this.f5320e);
        }
    }

    public static class y<K, V> extends n<K, V> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final c1.i0<? super K> f5349f;

        public y(Map<K, V> unfiltered, c1.i0<? super K> keyPredicate, c1.i0<? super Map.Entry<K, V>> entryPredicate) {
            super(unfiltered, entryPredicate);
            this.f5349f = keyPredicate;
        }

        @Override // f1.t4.r0
        public Set<Map.Entry<K, V>> a() {
            return k6.i(this.f5319d.entrySet(), this.f5320e);
        }

        @Override // f1.t4.r0
        /* JADX INFO: renamed from: c */
        public Set<K> h() {
            return k6.i(this.f5319d.keySet(), this.f5349f);
        }

        @Override // f1.t4.n, java.util.AbstractMap, java.util.Map
        public boolean containsKey(@gm.a Object key) {
            return this.f5319d.containsKey(key) && this.f5349f.apply(key);
        }
    }

    public static final class z<K, V> extends q0<K, V> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Map<K, V> f5350b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final c1.i0<? super Map.Entry<K, V>> f5351c;

        public z(Map<K, V> filteredMap, Map<K, V> unfiltered, c1.i0<? super Map.Entry<K, V>> predicate) {
            super(filteredMap);
            this.f5350b = unfiltered;
            this.f5351c = predicate;
        }

        @Override // f1.t4.q0, java.util.AbstractCollection, java.util.Collection
        public boolean remove(@gm.a Object o10) {
            Iterator<Map.Entry<K, V>> it = this.f5350b.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry<K, V> next = it.next();
                if (this.f5351c.apply(next) && c1.b0.a(next.getValue(), o10)) {
                    it.remove();
                    return true;
                }
            }
            return false;
        }

        @Override // f1.t4.q0, java.util.AbstractCollection, java.util.Collection
        public boolean removeAll(Collection<?> collection) {
            Iterator<Map.Entry<K, V>> it = this.f5350b.entrySet().iterator();
            boolean z10 = false;
            while (it.hasNext()) {
                Map.Entry<K, V> next = it.next();
                if (this.f5351c.apply(next) && collection.contains(next.getValue())) {
                    it.remove();
                    z10 = true;
                }
            }
            return z10;
        }

        @Override // f1.t4.q0, java.util.AbstractCollection, java.util.Collection
        public boolean retainAll(Collection<?> collection) {
            Iterator<Map.Entry<K, V>> it = this.f5350b.entrySet().iterator();
            boolean z10 = false;
            while (it.hasNext()) {
                Map.Entry<K, V> next = it.next();
                if (this.f5351c.apply(next) && !collection.contains(next.getValue())) {
                    it.remove();
                    z10 = true;
                }
            }
            return z10;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public Object[] toArray() {
            return p4.s(iterator()).toArray();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public <T> T[] toArray(T[] tArr) {
            return (T[]) p4.s(iterator()).toArray(tArr);
        }
    }

    public static <K, V> SortedMap<K, V> A(SortedMap<K, V> unfiltered, c1.i0<? super Map.Entry<K, V>> entryPredicate) {
        entryPredicate.getClass();
        if (unfiltered instanceof x) {
            return E((x) unfiltered, entryPredicate);
        }
        unfiltered.getClass();
        return new x((Map) unfiltered, (c1.i0) entryPredicate);
    }

    public static <V2, K, V1> Map.Entry<K, V2> A0(final t<? super K, ? super V1, V2> transformer, final Map.Entry<K, V1> entry) {
        transformer.getClass();
        entry.getClass();
        return new c(entry, transformer);
    }

    public static <K, V> f1.w<K, V> B(u<K, V> map, c1.i0<? super Map.Entry<K, V>> entryPredicate) {
        return new u((f1.w) map.f5319d, c1.j0.d(map.f5320e, entryPredicate));
    }

    public static <K, V1, V2> Map<K, V2> B0(Map<K, V1> fromMap, c1.t<? super V1, V2> function) {
        return new i0(fromMap, i(function));
    }

    public static <K, V> Map<K, V> C(n<K, V> map, c1.i0<? super Map.Entry<K, V>> entryPredicate) {
        return new v(map.f5319d, c1.j0.d(map.f5320e, entryPredicate));
    }

    @b1.c
    public static <K, V1, V2> NavigableMap<K, V2> C0(NavigableMap<K, V1> fromMap, c1.t<? super V1, V2> function) {
        return new j0((Map) fromMap, i(function));
    }

    @b1.c
    public static <K, V> NavigableMap<K, V> D(w<K, V> map, c1.i0<? super Map.Entry<K, V>> entryPredicate) {
        return new w(map.f5344a, c1.j0.d(map.f5345b, entryPredicate));
    }

    public static <K, V1, V2> SortedMap<K, V2> D0(SortedMap<K, V1> fromMap, c1.t<? super V1, V2> function) {
        return new k0((Map) fromMap, i(function));
    }

    public static <K, V> SortedMap<K, V> E(x<K, V> map, c1.i0<? super Map.Entry<K, V>> entryPredicate) {
        return new x((Map) map.j(), c1.j0.d(map.f5320e, entryPredicate));
    }

    @t1.a
    public static <K, V> k3<K, V> E0(Iterable<V> values, c1.t<? super V, K> keyFunction) {
        return values instanceof Collection ? G0(values.iterator(), keyFunction, k3.builderWithExpectedSize(((Collection) values).size())) : F0(values.iterator(), keyFunction);
    }

    public static <K, V> f1.w<K, V> F(f1.w<K, V> unfiltered, final c1.i0<? super K> keyPredicate) {
        keyPredicate.getClass();
        return x(unfiltered, c1.j0.h(keyPredicate, r.KEY));
    }

    @t1.a
    public static <K, V> k3<K, V> F0(Iterator<V> values, c1.t<? super V, K> keyFunction) {
        return G0(values, keyFunction, k3.builder());
    }

    public static <K, V> Map<K, V> G(Map<K, V> unfiltered, final c1.i0<? super K> keyPredicate) {
        keyPredicate.getClass();
        c1.i0 i0VarH = c1.j0.h(keyPredicate, r.KEY);
        if (unfiltered instanceof n) {
            return C((n) unfiltered, i0VarH);
        }
        unfiltered.getClass();
        return new y(unfiltered, keyPredicate, i0VarH);
    }

    public static <K, V> k3<K, V> G0(Iterator<V> values, c1.t<? super V, K> keyFunction, k3.b<K, V> builder) {
        keyFunction.getClass();
        while (values.hasNext()) {
            V next = values.next();
            builder.i(keyFunction.apply(next), next);
        }
        try {
            return builder.d();
        } catch (IllegalArgumentException e10) {
            throw new IllegalArgumentException(e10.getMessage() + ". To index multiple values under a key, use Multimaps.index.");
        }
    }

    @b1.c
    public static <K, V> NavigableMap<K, V> H(NavigableMap<K, V> unfiltered, final c1.i0<? super K> keyPredicate) {
        return z(unfiltered, c1.j0.h(keyPredicate, r.KEY));
    }

    public static <K, V> f1.w<K, V> H0(f1.w<? extends K, ? extends V> bimap) {
        return new l0(bimap, null);
    }

    public static <K, V> SortedMap<K, V> I(SortedMap<K, V> unfiltered, final c1.i0<? super K> keyPredicate) {
        return A(unfiltered, c1.j0.h(keyPredicate, r.KEY));
    }

    public static <K, V> Map.Entry<K, V> I0(final Map.Entry<? extends K, ? extends V> entry) {
        entry.getClass();
        return new k(entry);
    }

    public static <K, V> f1.w<K, V> J(f1.w<K, V> unfiltered, final c1.i0<? super V> valuePredicate) {
        return x(unfiltered, c1.j0.h(valuePredicate, r.VALUE));
    }

    public static <K, V> x7<Map.Entry<K, V>> J0(final Iterator<Map.Entry<K, V>> entryIterator) {
        return new l(entryIterator);
    }

    public static <K, V> Map<K, V> K(Map<K, V> unfiltered, final c1.i0<? super V> valuePredicate) {
        return y(unfiltered, c1.j0.h(valuePredicate, r.VALUE));
    }

    public static <K, V> Set<Map.Entry<K, V>> K0(Set<Map.Entry<K, V>> entrySet) {
        return new n0((Collection) Collections.unmodifiableSet(entrySet));
    }

    @b1.c
    public static <K, V> NavigableMap<K, V> L(NavigableMap<K, V> unfiltered, final c1.i0<? super V> valuePredicate) {
        return z(unfiltered, c1.j0.h(valuePredicate, r.VALUE));
    }

    public static <K, V> Map<K, V> L0(Map<K, ? extends V> map) {
        return map instanceof SortedMap ? Collections.unmodifiableSortedMap((SortedMap) map) : Collections.unmodifiableMap(map);
    }

    public static <K, V> SortedMap<K, V> M(SortedMap<K, V> unfiltered, final c1.i0<? super V> valuePredicate) {
        return A(unfiltered, c1.j0.h(valuePredicate, r.VALUE));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @b1.c
    public static <K, V> NavigableMap<K, V> M0(NavigableMap<K, ? extends V> map) {
        map.getClass();
        return map instanceof o0 ? map : new o0(map);
    }

    @b1.c
    @b1.d
    public static k3<String, String> N(Properties properties) {
        k3.b bVarBuilder = k3.builder();
        Enumeration<?> enumerationPropertyNames = properties.propertyNames();
        while (enumerationPropertyNames.hasMoreElements()) {
            Object objNextElement = enumerationPropertyNames.nextElement();
            Objects.requireNonNull(objNextElement);
            String str = (String) objNextElement;
            String property = properties.getProperty(str);
            Objects.requireNonNull(property);
            bVarBuilder.i(str, property);
        }
        return bVarBuilder.d();
    }

    @gm.a
    public static <K, V> Map.Entry<K, V> N0(@gm.a Map.Entry<K, ? extends V> entry) {
        if (entry == null) {
            return null;
        }
        return I0(entry);
    }

    @b1.b(serializable = true)
    public static <K, V> Map.Entry<K, V> O(@m5 K key, @m5 V value) {
        return new f3(key, value);
    }

    public static <V> c1.t<Map.Entry<?, V>, V> O0() {
        return r.VALUE;
    }

    @b1.b(serializable = true)
    @b1.d
    public static <K extends Enum<K>, V> k3<K, V> P(Map<K, ? extends V> map) {
        if (map instanceof g3) {
            return (g3) map;
        }
        Iterator<Map.Entry<K, ? extends V>> it = map.entrySet().iterator();
        if (!it.hasNext()) {
            return k3.of();
        }
        Map.Entry<K, ? extends V> next = it.next();
        K key = next.getKey();
        V value = next.getValue();
        f1.b0.a(key, value);
        EnumMap enumMap = new EnumMap(Collections.singletonMap(key, value));
        while (it.hasNext()) {
            Map.Entry<K, ? extends V> next2 = it.next();
            K key2 = next2.getKey();
            V value2 = next2.getValue();
            f1.b0.a(key2, value2);
            enumMap.put((Enum) key2, (Object) value2);
        }
        return g3.asImmutable(enumMap);
    }

    public static <K, V> Iterator<V> P0(Iterator<Map.Entry<K, V>> entryIterator) {
        return new f(entryIterator);
    }

    public static <E> k3<E, Integer> Q(Collection<E> list) {
        k3.b bVar = new k3.b(list.size());
        Iterator<E> it = list.iterator();
        int i10 = 0;
        while (it.hasNext()) {
            bVar.i(it.next(), Integer.valueOf(i10));
            i10++;
        }
        return bVar.b(true);
    }

    @gm.a
    public static <V> V Q0(@gm.a Map.Entry<?, V> entry) {
        if (entry == null) {
            return null;
        }
        return entry.getValue();
    }

    public static <K> c1.t<Map.Entry<K, ?>, K> R() {
        return r.KEY;
    }

    public static <V> c1.i0<Map.Entry<?, V>> R0(c1.i0<? super V> valuePredicate) {
        return c1.j0.h(valuePredicate, r.VALUE);
    }

    public static <K, V> Iterator<K> S(Iterator<Map.Entry<K, V>> entryIterator) {
        return new e(entryIterator);
    }

    @gm.a
    public static <K> K T(@gm.a Map.Entry<K, ?> entry) {
        if (entry == null) {
            return null;
        }
        return entry.getKey();
    }

    public static <K> c1.i0<Map.Entry<K, ?>> U(c1.i0<? super K> keyPredicate) {
        return c1.j0.h(keyPredicate, r.KEY);
    }

    public static <K, V> ConcurrentMap<K, V> V() {
        return new ConcurrentHashMap();
    }

    public static <K extends Enum<K>, V> EnumMap<K, V> W(Class<K> type) {
        type.getClass();
        return new EnumMap<>(type);
    }

    public static <K extends Enum<K>, V> EnumMap<K, V> X(Map<K, ? extends V> map) {
        return new EnumMap<>(map);
    }

    public static <K, V> HashMap<K, V> Y() {
        return new HashMap<>();
    }

    public static <K, V> HashMap<K, V> Z(Map<? extends K, ? extends V> map) {
        return new HashMap<>(map);
    }

    public static <K, V> HashMap<K, V> a0(int expectedSize) {
        return new HashMap<>(o(expectedSize));
    }

    public static Set b(Set set) {
        return new h(set);
    }

    public static <K, V> IdentityHashMap<K, V> b0() {
        return new IdentityHashMap<>();
    }

    public static SortedSet c(SortedSet sortedSet) {
        return new i(sortedSet);
    }

    public static <K, V> LinkedHashMap<K, V> c0() {
        return new LinkedHashMap<>();
    }

    public static NavigableSet d(NavigableSet navigableSet) {
        return new j(navigableSet);
    }

    public static <K, V> LinkedHashMap<K, V> d0(Map<? extends K, ? extends V> map) {
        return new LinkedHashMap<>(map);
    }

    public static <K, V> LinkedHashMap<K, V> e0(int expectedSize) {
        return new LinkedHashMap<>(o(expectedSize));
    }

    public static <A, B> c1.i<A, B> f(final f1.w<A, B> bimap) {
        return new p(bimap);
    }

    public static <K extends Comparable, V> TreeMap<K, V> f0() {
        return new TreeMap<>();
    }

    public static <K, V1, V2> c1.t<Map.Entry<K, V1>, Map.Entry<K, V2>> g(final t<? super K, ? super V1, V2> transformer) {
        transformer.getClass();
        return new d(transformer);
    }

    public static <C, K extends C, V> TreeMap<K, V> g0(@gm.a Comparator<C> comparator) {
        return new TreeMap<>(comparator);
    }

    public static <K, V1, V2> c1.t<Map.Entry<K, V1>, V2> h(final t<? super K, ? super V1, V2> transformer) {
        transformer.getClass();
        return new b(transformer);
    }

    public static <K, V> TreeMap<K, V> h0(SortedMap<K, ? extends V> map) {
        return new TreeMap<>((SortedMap) map);
    }

    public static <K, V1, V2> t<K, V1, V2> i(final c1.t<? super V1, V2> function) {
        function.getClass();
        return new m(function);
    }

    public static <E> Comparator<? super E> i0(@gm.a Comparator<? super E> comparator) {
        return comparator != null ? comparator : l5.natural();
    }

    public static <K, V> Map<K, V> j(Set<K> set, c1.t<? super K, V> function) {
        return new o(set, function);
    }

    public static <K, V> void j0(Map<K, V> self, Map<? extends K, ? extends V> map) {
        for (Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
            self.put(entry.getKey(), entry.getValue());
        }
    }

    @b1.c
    public static <K, V> NavigableMap<K, V> k(NavigableSet<K> set, c1.t<? super K, V> function) {
        return new d0(set, function);
    }

    public static <K, V> boolean k0(Collection<Map.Entry<K, V>> c10, @gm.a Object o10) {
        if (o10 instanceof Map.Entry) {
            return c10.remove(I0((Map.Entry) o10));
        }
        return false;
    }

    public static <K, V> SortedMap<K, V> l(SortedSet<K> set, c1.t<? super K, V> function) {
        return new f0((Set) set, (c1.t) function);
    }

    @b1.c
    public static <E> NavigableSet<E> l0(final NavigableSet<E> set) {
        return new j(set);
    }

    public static <K, V> Iterator<Map.Entry<K, V>> m(Set<K> set, final c1.t<? super K, V> function) {
        return new g(set.iterator(), function);
    }

    public static <E> Set<E> m0(final Set<E> set) {
        return new h(set);
    }

    public static <K, V1, V2> c1.t<V1, V2> n(final t<? super K, V1, V2> transformer, @m5 final K key) {
        transformer.getClass();
        return new a(transformer, key);
    }

    public static <E> SortedSet<E> n0(final SortedSet<E> set) {
        return new i(set);
    }

    public static int o(int expectedSize) {
        if (expectedSize < 3) {
            f1.b0.b(expectedSize, "expectedSize");
            return expectedSize + 1;
        }
        if (expectedSize < 1073741824) {
            return (int) Math.ceil(((double) expectedSize) / 0.75d);
        }
        return Integer.MAX_VALUE;
    }

    public static boolean o0(Map<?, ?> map, @gm.a Object key) {
        map.getClass();
        try {
            return map.containsKey(key);
        } catch (ClassCastException | NullPointerException unused) {
            return false;
        }
    }

    public static <K, V> boolean p(Collection<Map.Entry<K, V>> c10, @gm.a Object o10) {
        if (o10 instanceof Map.Entry) {
            return c10.contains(I0((Map.Entry) o10));
        }
        return false;
    }

    @gm.a
    public static <V> V p0(Map<?, V> map, @gm.a Object key) {
        map.getClass();
        try {
            return map.get(key);
        } catch (ClassCastException | NullPointerException unused) {
            return null;
        }
    }

    public static boolean q(Map<?, ?> map, @gm.a Object key) {
        return h4.q(new e(map.entrySet().iterator()), key);
    }

    @gm.a
    public static <V> V q0(Map<?, V> map, @gm.a Object key) {
        map.getClass();
        try {
            return map.remove(key);
        } catch (ClassCastException | NullPointerException unused) {
            return null;
        }
    }

    public static boolean r(Map<?, ?> map, @gm.a Object value) {
        return h4.q(new f(map.entrySet().iterator()), value);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @b1.c
    public static <K extends Comparable<? super K>, V> NavigableMap<K, V> r0(NavigableMap<K, V> map, q5<K> range) {
        if (map.comparator() != null && map.comparator() != l5.natural() && range.hasLowerBound() && range.hasUpperBound()) {
            c1.h0.e(map.comparator().compare(range.lowerEndpoint(), range.upperEndpoint()) <= 0, "map is using a custom comparator which is inconsistent with the natural ordering.");
        }
        if (range.hasLowerBound() && range.hasUpperBound()) {
            Comparable comparableLowerEndpoint = range.lowerEndpoint();
            f1.x xVarLowerBoundType = range.lowerBoundType();
            f1.x xVar = f1.x.CLOSED;
            return map.subMap(comparableLowerEndpoint, xVarLowerBoundType == xVar, range.upperEndpoint(), range.upperBoundType() == xVar);
        }
        if (range.hasLowerBound()) {
            return map.tailMap(range.lowerEndpoint(), range.lowerBoundType() == f1.x.CLOSED);
        }
        if (range.hasUpperBound()) {
            return map.headMap(range.upperEndpoint(), range.upperBoundType() == f1.x.CLOSED);
        }
        return map;
    }

    public static <K, V> q4<K, V> s(Map<? extends K, ? extends V> left, Map<? extends K, ? extends V> right) {
        return left instanceof SortedMap ? u((SortedMap) left, right) : t(left, right, c1.m.equals());
    }

    public static <K, V> f1.w<K, V> s0(f1.w<K, V> bimap) {
        return y6.g(bimap, null);
    }

    public static <K, V> q4<K, V> t(Map<? extends K, ? extends V> left, Map<? extends K, ? extends V> right, c1.m<? super V> valueEquivalence) {
        valueEquivalence.getClass();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        LinkedHashMap linkedHashMap2 = new LinkedHashMap(right);
        LinkedHashMap linkedHashMap3 = new LinkedHashMap();
        LinkedHashMap linkedHashMap4 = new LinkedHashMap();
        v(left, right, valueEquivalence, linkedHashMap, linkedHashMap2, linkedHashMap3, linkedHashMap4);
        return new c0(linkedHashMap, linkedHashMap2, linkedHashMap3, linkedHashMap4);
    }

    @b1.c
    public static <K, V> NavigableMap<K, V> t0(NavigableMap<K, V> navigableMap) {
        return y6.o(navigableMap);
    }

    public static <K, V> q6<K, V> u(SortedMap<K, ? extends V> left, Map<? extends K, ? extends V> right) {
        left.getClass();
        right.getClass();
        Comparator<? super K> comparator = left.comparator();
        if (comparator == null) {
            comparator = l5.natural();
        }
        TreeMap treeMap = new TreeMap(comparator);
        TreeMap treeMap2 = new TreeMap(comparator);
        treeMap2.putAll(right);
        TreeMap treeMap3 = new TreeMap(comparator);
        TreeMap treeMap4 = new TreeMap(comparator);
        v(left, right, c1.m.equals(), treeMap, treeMap2, treeMap3, treeMap4);
        return new h0((Map) treeMap, (Map) treeMap2, (Map) treeMap3, (Map) treeMap4);
    }

    public static <K, V> k3<K, V> u0(Iterable<K> keys, c1.t<? super K, V> valueFunction) {
        return v0(keys.iterator(), valueFunction);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <K, V> void v(Map<? extends K, ? extends V> map, Map<? extends K, ? extends V> map2, c1.m<? super V> mVar, Map<K, V> map3, Map<K, V> map4, Map<K, V> map5, Map<K, q4.a<V>> map6) {
        for (Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
            K key = entry.getKey();
            V value = entry.getValue();
            if (map2.containsKey(key)) {
                V vRemove = map4.remove(key);
                if (mVar.equivalent(value, vRemove)) {
                    map5.put(key, value);
                } else {
                    map6.put(key, new p0(value, vRemove));
                }
            } else {
                map3.put(key, value);
            }
        }
    }

    public static <K, V> k3<K, V> v0(Iterator<K> keys, c1.t<? super K, V> valueFunction) {
        valueFunction.getClass();
        k3.b bVarBuilder = k3.builder();
        while (keys.hasNext()) {
            K next = keys.next();
            bVarBuilder.i(next, valueFunction.apply(next));
        }
        return bVarBuilder.c();
    }

    public static boolean w(Map<?, ?> map, @gm.a Object object) {
        if (map == object) {
            return true;
        }
        if (object instanceof Map) {
            return map.entrySet().equals(((Map) object).entrySet());
        }
        return false;
    }

    public static String w0(Map<?, ?> map) {
        StringBuilder sbF = f1.c0.f(map.size());
        sbF.append(rs.f.f14859a);
        boolean z10 = true;
        for (Map.Entry<?, ?> entry : map.entrySet()) {
            if (!z10) {
                sbF.append(", ");
            }
            sbF.append(entry.getKey());
            sbF.append(fl.h.f6043c);
            sbF.append(entry.getValue());
            z10 = false;
        }
        sbF.append(rs.f.f14860b);
        return sbF.toString();
    }

    public static <K, V> f1.w<K, V> x(f1.w<K, V> unfiltered, c1.i0<? super Map.Entry<K, V>> entryPredicate) {
        unfiltered.getClass();
        entryPredicate.getClass();
        return unfiltered instanceof u ? B((u) unfiltered, entryPredicate) : new u(unfiltered, entryPredicate);
    }

    public static <K, V1, V2> Map<K, V2> x0(Map<K, V1> fromMap, t<? super K, ? super V1, V2> transformer) {
        return new i0(fromMap, transformer);
    }

    public static <K, V> Map<K, V> y(Map<K, V> unfiltered, c1.i0<? super Map.Entry<K, V>> entryPredicate) {
        entryPredicate.getClass();
        if (unfiltered instanceof n) {
            return C((n) unfiltered, entryPredicate);
        }
        unfiltered.getClass();
        return new v(unfiltered, entryPredicate);
    }

    @b1.c
    public static <K, V1, V2> NavigableMap<K, V2> y0(NavigableMap<K, V1> fromMap, t<? super K, ? super V1, V2> transformer) {
        return new j0((Map) fromMap, (t) transformer);
    }

    @b1.c
    public static <K, V> NavigableMap<K, V> z(NavigableMap<K, V> unfiltered, c1.i0<? super Map.Entry<K, V>> entryPredicate) {
        entryPredicate.getClass();
        if (unfiltered instanceof w) {
            return D((w) unfiltered, entryPredicate);
        }
        unfiltered.getClass();
        return new w(unfiltered, entryPredicate);
    }

    public static <K, V1, V2> SortedMap<K, V2> z0(SortedMap<K, V1> fromMap, t<? super K, ? super V1, V2> transformer) {
        return new k0((Map) fromMap, (t) transformer);
    }

    /* JADX INFO: Add missing generic type declarations: [E] */
    public class h<E> extends l2<E> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Set f5310a;

        public h(final Set val$set) {
            this.f5310a = val$set;
        }

        @Override // f1.s1, java.util.Collection, f1.b5
        public boolean add(@m5 E element) {
            throw new UnsupportedOperationException();
        }

        @Override // f1.s1, java.util.Collection
        public boolean addAll(Collection<? extends E> es2) {
            throw new UnsupportedOperationException();
        }

        @Override // f1.l2, f1.s1, f1.j2
        public Set<E> delegate() {
            return this.f5310a;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [E] */
    public class j<E> extends i2<E> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ NavigableSet f5314a;

        public j(final NavigableSet val$set) {
            this.f5314a = val$set;
        }

        @Override // f1.s1, java.util.Collection, f1.b5
        public boolean add(@m5 E element) {
            throw new UnsupportedOperationException();
        }

        @Override // f1.s1, java.util.Collection
        public boolean addAll(Collection<? extends E> es2) {
            throw new UnsupportedOperationException();
        }

        @Override // f1.i2, java.util.NavigableSet
        public NavigableSet<E> descendingSet() {
            return new j(super.descendingSet());
        }

        @Override // f1.p2, java.util.SortedSet, java.util.NavigableSet
        public SortedSet<E> headSet(@m5 E toElement) {
            return new i(super.headSet(toElement));
        }

        @Override // f1.i2, f1.p2, f1.l2, f1.s1, f1.j2
        /* JADX INFO: renamed from: l */
        public NavigableSet<E> delegate() {
            return this.f5314a;
        }

        @Override // f1.p2, java.util.SortedSet, java.util.NavigableSet
        public SortedSet<E> subSet(@m5 E fromElement, @m5 E toElement) {
            return new i(super.subSet(fromElement, toElement));
        }

        @Override // f1.p2, java.util.SortedSet, java.util.NavigableSet
        public SortedSet<E> tailSet(@m5 E fromElement) {
            return new i(super.tailSet(fromElement));
        }

        @Override // f1.i2, java.util.NavigableSet
        public NavigableSet<E> headSet(@m5 E toElement, boolean inclusive) {
            return new j(super.headSet(toElement, inclusive));
        }

        @Override // f1.i2, java.util.NavigableSet
        public NavigableSet<E> subSet(@m5 E fromElement, boolean fromInclusive, @m5 E toElement, boolean toInclusive) {
            return new j(super.subSet(fromElement, fromInclusive, toElement, toInclusive));
        }

        @Override // f1.i2, java.util.NavigableSet
        public NavigableSet<E> tailSet(@m5 E fromElement, boolean inclusive) {
            return new j(super.tailSet(fromElement, inclusive));
        }
    }

    /* JADX INFO: Add missing generic type declarations: [E] */
    public class i<E> extends p2<E> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SortedSet f5311a;

        public i(final SortedSet val$set) {
            this.f5311a = val$set;
        }

        @Override // f1.s1, java.util.Collection, f1.b5
        public boolean add(@m5 E element) {
            throw new UnsupportedOperationException();
        }

        @Override // f1.s1, java.util.Collection
        public boolean addAll(Collection<? extends E> es2) {
            throw new UnsupportedOperationException();
        }

        @Override // f1.p2, java.util.SortedSet, java.util.NavigableSet
        public SortedSet<E> headSet(@m5 E toElement) {
            return new i(super.headSet(toElement));
        }

        @Override // f1.p2, java.util.SortedSet, java.util.NavigableSet
        public SortedSet<E> subSet(@m5 E fromElement, @m5 E toElement) {
            return new i(super.subSet(fromElement, toElement));
        }

        @Override // f1.p2, java.util.SortedSet, java.util.NavigableSet
        public SortedSet<E> tailSet(@m5 E fromElement) {
            return new i(super.tailSet(fromElement));
        }

        @Override // f1.p2, f1.l2, f1.s1, f1.j2
        public SortedSet<E> delegate() {
            return this.f5311a;
        }
    }
}
