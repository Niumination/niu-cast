package nm;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
@kn.r1({"SMAP\nMapWithDefault.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MapWithDefault.kt\nkotlin/collections/MutableMapWithDefaultImpl\n+ 2 Maps.kt\nkotlin/collections/MapsKt__MapsKt\n*L\n1#1,104:1\n341#2,6:105\n*S KotlinDebug\n*F\n+ 1 MapWithDefault.kt\nkotlin/collections/MutableMapWithDefaultImpl\n*L\n101#1:105,6\n*E\n"})
public final class i1<K, V> implements h1<K, V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public final Map<K, V> f11634a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.l
    public final jn.l<K, V> f11635b;

    /* JADX WARN: Multi-variable type inference failed */
    public i1(@os.l Map<K, V> map, @os.l jn.l<? super K, ? extends V> lVar) {
        kn.l0.p(map, "map");
        kn.l0.p(lVar, ks.c.f9460f);
        this.f11634a = map;
        this.f11635b = lVar;
    }

    @os.l
    public Set<Map.Entry<K, V>> a() {
        return this.f11634a.entrySet();
    }

    @Override // nm.h1, nm.y0
    @os.l
    public Map<K, V> b() {
        return this.f11634a;
    }

    @os.l
    public Set<K> c() {
        return this.f11634a.keySet();
    }

    @Override // java.util.Map
    public void clear() {
        this.f11634a.clear();
    }

    @Override // java.util.Map
    public boolean containsKey(Object obj) {
        return this.f11634a.containsKey(obj);
    }

    @Override // java.util.Map
    public boolean containsValue(Object obj) {
        return this.f11634a.containsValue(obj);
    }

    public int e() {
        return this.f11634a.size();
    }

    @Override // java.util.Map
    public final Set<Map.Entry<K, V>> entrySet() {
        return this.f11634a.entrySet();
    }

    @Override // java.util.Map
    public boolean equals(@os.m Object obj) {
        return this.f11634a.equals(obj);
    }

    @os.l
    public Collection<V> f() {
        return this.f11634a.values();
    }

    @Override // java.util.Map
    @os.m
    public V get(Object obj) {
        return this.f11634a.get(obj);
    }

    @Override // java.util.Map
    public int hashCode() {
        return this.f11634a.hashCode();
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        return this.f11634a.isEmpty();
    }

    @Override // nm.y0
    public V k(K k10) {
        Map<K, V> map = this.f11634a;
        V v10 = map.get(k10);
        return (v10 != null || map.containsKey(k10)) ? v10 : this.f11635b.invoke(k10);
    }

    @Override // java.util.Map
    public final Set<K> keySet() {
        return this.f11634a.keySet();
    }

    @Override // java.util.Map
    @os.m
    public V put(K k10, V v10) {
        return this.f11634a.put(k10, v10);
    }

    @Override // java.util.Map
    public void putAll(@os.l Map<? extends K, ? extends V> map) {
        kn.l0.p(map, TypedValues.TransitionType.S_FROM);
        this.f11634a.putAll(map);
    }

    @Override // java.util.Map
    @os.m
    public V remove(Object obj) {
        return this.f11634a.remove(obj);
    }

    @Override // java.util.Map
    public final int size() {
        return this.f11634a.size();
    }

    @os.l
    public String toString() {
        return this.f11634a.toString();
    }

    @Override // java.util.Map
    public final Collection<V> values() {
        return this.f11634a.values();
    }
}
