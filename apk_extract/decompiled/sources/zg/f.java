package zg;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMutableMap;
import m3.r6;
import zf.o0;

/* JADX INFO: loaded from: classes3.dex */
public final class f implements Map, KMutableMap {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinkedHashMap f11585a = new LinkedHashMap();

    @Override // java.util.Map
    public final void clear() {
        this.f11585a.clear();
    }

    @Override // java.util.Map
    public final boolean containsKey(Object obj) {
        if (!(obj instanceof String)) {
            return false;
        }
        String key = (String) obj;
        Intrinsics.checkNotNullParameter(key, "key");
        return this.f11585a.containsKey(new g(key));
    }

    @Override // java.util.Map
    public final boolean containsValue(Object obj) {
        if (obj == null) {
            return false;
        }
        return this.f11585a.containsValue(obj);
    }

    @Override // java.util.Map
    public final Set entrySet() {
        return new m(this.f11585a.entrySet(), new o0(1), new o0(2));
    }

    @Override // java.util.Map
    public final boolean equals(Object obj) {
        if (obj == null || !(obj instanceof f)) {
            return false;
        }
        return Intrinsics.areEqual(((f) obj).f11585a, this.f11585a);
    }

    @Override // java.util.Map
    public final Object get(Object obj) {
        if (!(obj instanceof String)) {
            return null;
        }
        String key = (String) obj;
        Intrinsics.checkNotNullParameter(key, "key");
        return this.f11585a.get(r6.a(key));
    }

    @Override // java.util.Map
    public final int hashCode() {
        return this.f11585a.hashCode();
    }

    @Override // java.util.Map
    public final boolean isEmpty() {
        return this.f11585a.isEmpty();
    }

    @Override // java.util.Map
    public final Set keySet() {
        return new m(this.f11585a.keySet(), new o0(3), new o0(4));
    }

    @Override // java.util.Map
    public final Object put(Object obj, Object value) {
        String key = (String) obj;
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        return this.f11585a.put(r6.a(key), value);
    }

    @Override // java.util.Map
    public final void putAll(Map from) {
        Intrinsics.checkNotNullParameter(from, "from");
        for (Map.Entry entry : from.entrySet()) {
            String key = (String) entry.getKey();
            Object value = entry.getValue();
            Intrinsics.checkNotNullParameter(key, "key");
            Intrinsics.checkNotNullParameter(value, "value");
            this.f11585a.put(r6.a(key), value);
        }
    }

    @Override // java.util.Map
    public final Object remove(Object obj) {
        if (!(obj instanceof String)) {
            return null;
        }
        String key = (String) obj;
        Intrinsics.checkNotNullParameter(key, "key");
        return this.f11585a.remove(r6.a(key));
    }

    @Override // java.util.Map
    public final int size() {
        return this.f11585a.size();
    }

    @Override // java.util.Map
    public final Collection values() {
        return this.f11585a.values();
    }
}
