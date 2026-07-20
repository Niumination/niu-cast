package bh;

import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMutableMap;

/* JADX INFO: loaded from: classes3.dex */
public final class c implements Map, KMutableMap {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConcurrentHashMap f1330a = new ConcurrentHashMap(32);

    @Override // java.util.Map
    public final void clear() {
        this.f1330a.clear();
    }

    @Override // java.util.Map
    public final boolean containsKey(Object obj) {
        return this.f1330a.containsKey(obj);
    }

    @Override // java.util.Map
    public final boolean containsValue(Object obj) {
        return this.f1330a.containsValue(obj);
    }

    @Override // java.util.Map
    public final Set entrySet() {
        Set setEntrySet = this.f1330a.entrySet();
        Intrinsics.checkNotNullExpressionValue(setEntrySet, "<get-entries>(...)");
        return setEntrySet;
    }

    @Override // java.util.Map
    public final boolean equals(Object obj) {
        if (obj instanceof Map) {
            return Intrinsics.areEqual(obj, this.f1330a);
        }
        return false;
    }

    @Override // java.util.Map
    public final Object get(Object obj) {
        return this.f1330a.get(obj);
    }

    @Override // java.util.Map
    public final int hashCode() {
        return this.f1330a.hashCode();
    }

    @Override // java.util.Map
    public final boolean isEmpty() {
        return this.f1330a.isEmpty();
    }

    @Override // java.util.Map
    public final Set keySet() {
        Set setKeySet = this.f1330a.keySet();
        Intrinsics.checkNotNullExpressionValue(setKeySet, "<get-keys>(...)");
        return setKeySet;
    }

    @Override // java.util.Map
    public final Object put(Object obj, Object obj2) {
        return this.f1330a.put(obj, obj2);
    }

    @Override // java.util.Map
    public final void putAll(Map from) {
        Intrinsics.checkNotNullParameter(from, "from");
        this.f1330a.putAll(from);
    }

    @Override // java.util.Map
    public final Object remove(Object obj) {
        return this.f1330a.remove(obj);
    }

    @Override // java.util.Map
    public final int size() {
        return this.f1330a.size();
    }

    public final String toString() {
        return "ConcurrentMapJvm by " + this.f1330a;
    }

    @Override // java.util.Map
    public final Collection values() {
        Collection collectionValues = this.f1330a.values();
        Intrinsics.checkNotNullExpressionValue(collectionValues, "<get-values>(...)");
        return collectionValues;
    }

    @Override // java.util.Map
    public final boolean remove(Object obj, Object obj2) {
        return this.f1330a.remove(obj, obj2);
    }
}
