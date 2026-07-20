package l3;

import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class l2 implements Map.Entry, Comparable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Comparable f7265a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Object f7266b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ h2 f7267c;

    public l2(h2 h2Var, Comparable comparable, Object obj) {
        this.f7267c = h2Var;
        this.f7265a = comparable;
        this.f7266b = obj;
    }

    @Override // java.lang.Comparable
    public final /* bridge */ /* synthetic */ int compareTo(Object obj) {
        return this.f7265a.compareTo(((l2) obj).f7265a);
    }

    @Override // java.util.Map.Entry
    public final boolean equals(Object obj) {
        boolean zEquals;
        boolean zEquals2;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Map.Entry)) {
            return false;
        }
        Map.Entry entry = (Map.Entry) obj;
        Object key = entry.getKey();
        Comparable comparable = this.f7265a;
        if (comparable == null) {
            zEquals = key == null;
        } else {
            zEquals = comparable.equals(key);
        }
        if (zEquals) {
            Object obj2 = this.f7266b;
            Object value = entry.getValue();
            if (obj2 == null) {
                zEquals2 = value == null;
            } else {
                zEquals2 = obj2.equals(value);
            }
            if (zEquals2) {
                return true;
            }
        }
        return false;
    }

    @Override // java.util.Map.Entry
    public final /* synthetic */ Object getKey() {
        return this.f7265a;
    }

    @Override // java.util.Map.Entry
    public final Object getValue() {
        return this.f7266b;
    }

    @Override // java.util.Map.Entry
    public final int hashCode() {
        Comparable comparable = this.f7265a;
        int iHashCode = comparable == null ? 0 : comparable.hashCode();
        Object obj = this.f7266b;
        return iHashCode ^ (obj != null ? obj.hashCode() : 0);
    }

    @Override // java.util.Map.Entry
    public final Object setValue(Object obj) {
        this.f7267c.h();
        Object obj2 = this.f7266b;
        this.f7266b = obj;
        return obj2;
    }

    public final String toString() {
        return o.d.l(String.valueOf(this.f7265a), "=", String.valueOf(this.f7266b));
    }
}
