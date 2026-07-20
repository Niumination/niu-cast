package nm;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
@kn.r1({"SMAP\nMapWithDefault.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MapWithDefault.kt\nkotlin/collections/MapWithDefaultImpl\n+ 2 Maps.kt\nkotlin/collections/MapsKt__MapsKt\n*L\n1#1,104:1\n341#2,6:105\n*S KotlinDebug\n*F\n+ 1 MapWithDefault.kt\nkotlin/collections/MapWithDefaultImpl\n*L\n80#1:105,6\n*E\n"})
public final class z0<K, V> implements y0<K, V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public final Map<K, V> f11699a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.l
    public final jn.l<K, V> f11700b;

    /* JADX WARN: Multi-variable type inference failed */
    public z0(@os.l Map<K, ? extends V> map, @os.l jn.l<? super K, ? extends V> lVar) {
        kn.l0.p(map, "map");
        kn.l0.p(lVar, ks.c.f9460f);
        this.f11699a = map;
        this.f11700b = lVar;
    }

    @os.l
    public Set<Map.Entry<K, V>> a() {
        return this.f11699a.entrySet();
    }

    @Override // nm.y0
    @os.l
    public Map<K, V> b() {
        return this.f11699a;
    }

    @os.l
    public Set<K> c() {
        return this.f11699a.keySet();
    }

    @Override // java.util.Map
    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public boolean containsKey(Object obj) {
        return this.f11699a.containsKey(obj);
    }

    @Override // java.util.Map
    public boolean containsValue(Object obj) {
        return this.f11699a.containsValue(obj);
    }

    public int e() {
        return this.f11699a.size();
    }

    @Override // java.util.Map
    public final Set<Map.Entry<K, V>> entrySet() {
        return this.f11699a.entrySet();
    }

    @Override // java.util.Map
    public boolean equals(@os.m Object obj) {
        return this.f11699a.equals(obj);
    }

    @os.l
    public Collection<V> f() {
        return this.f11699a.values();
    }

    @Override // java.util.Map
    @os.m
    public V get(Object obj) {
        return this.f11699a.get(obj);
    }

    @Override // java.util.Map
    public int hashCode() {
        return this.f11699a.hashCode();
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        return this.f11699a.isEmpty();
    }

    @Override // nm.y0
    public V k(K k10) {
        Map<K, V> map = this.f11699a;
        V v10 = map.get(k10);
        return (v10 != null || map.containsKey(k10)) ? v10 : this.f11700b.invoke(k10);
    }

    @Override // java.util.Map
    public final Set<K> keySet() {
        return this.f11699a.keySet();
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
    public final int size() {
        return this.f11699a.size();
    }

    @os.l
    public String toString() {
        return this.f11699a.toString();
    }

    @Override // java.util.Map
    public final Collection<V> values() {
        return this.f11699a.values();
    }
}
