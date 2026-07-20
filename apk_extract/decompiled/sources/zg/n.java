package zg;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMutableMap;

/* JADX INFO: loaded from: classes3.dex */
public final class n implements Map.Entry, KMutableMap.Entry {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f11597a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Object f11598b;

    public n(Object obj, Object obj2) {
        this.f11597a = obj;
        this.f11598b = obj2;
    }

    @Override // java.util.Map.Entry
    public final boolean equals(Object obj) {
        if (obj == null || !(obj instanceof Map.Entry)) {
            return false;
        }
        Map.Entry entry = (Map.Entry) obj;
        return Intrinsics.areEqual(entry.getKey(), this.f11597a) && Intrinsics.areEqual(entry.getValue(), this.f11598b);
    }

    @Override // java.util.Map.Entry
    public final Object getKey() {
        return this.f11597a;
    }

    @Override // java.util.Map.Entry
    public final Object getValue() {
        return this.f11598b;
    }

    @Override // java.util.Map.Entry
    public final int hashCode() {
        Object obj = this.f11597a;
        Intrinsics.checkNotNull(obj);
        int iHashCode = obj.hashCode() + 527;
        Object obj2 = this.f11598b;
        Intrinsics.checkNotNull(obj2);
        return obj2.hashCode() + iHashCode;
    }

    @Override // java.util.Map.Entry
    public final Object setValue(Object obj) {
        this.f11598b = obj;
        return obj;
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(this.f11597a);
        sb2.append('=');
        sb2.append(this.f11598b);
        return sb2.toString();
    }
}
