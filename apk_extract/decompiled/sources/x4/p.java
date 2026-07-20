package x4;

import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class p implements Map.Entry {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public p f10851a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public p f10852b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public p f10853c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public p f10854d;
    public p e;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Object f10855h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f10856i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Object f10857j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f10858k;

    public p(boolean z2) {
        this.f10855h = null;
        this.f10856i = z2;
        this.e = this;
        this.f10854d = this;
    }

    @Override // java.util.Map.Entry
    public final boolean equals(Object obj) {
        if (!(obj instanceof Map.Entry)) {
            return false;
        }
        Map.Entry entry = (Map.Entry) obj;
        Object obj2 = this.f10855h;
        if (obj2 == null) {
            if (entry.getKey() != null) {
                return false;
            }
        } else if (!obj2.equals(entry.getKey())) {
            return false;
        }
        Object obj3 = this.f10857j;
        if (obj3 == null) {
            if (entry.getValue() != null) {
                return false;
            }
        } else if (!obj3.equals(entry.getValue())) {
            return false;
        }
        return true;
    }

    @Override // java.util.Map.Entry
    public final Object getKey() {
        return this.f10855h;
    }

    @Override // java.util.Map.Entry
    public final Object getValue() {
        return this.f10857j;
    }

    @Override // java.util.Map.Entry
    public final int hashCode() {
        Object obj = this.f10855h;
        int iHashCode = obj == null ? 0 : obj.hashCode();
        Object obj2 = this.f10857j;
        return iHashCode ^ (obj2 != null ? obj2.hashCode() : 0);
    }

    @Override // java.util.Map.Entry
    public final Object setValue(Object obj) {
        if (obj == null && !this.f10856i) {
            throw new NullPointerException("value == null");
        }
        Object obj2 = this.f10857j;
        this.f10857j = obj;
        return obj2;
    }

    public final String toString() {
        return this.f10855h + "=" + this.f10857j;
    }

    public p(boolean z2, p pVar, Object obj, p pVar2, p pVar3) {
        this.f10851a = pVar;
        this.f10855h = obj;
        this.f10856i = z2;
        this.f10858k = 1;
        this.f10854d = pVar2;
        this.e = pVar3;
        pVar3.f10854d = this;
        pVar2.e = this;
    }
}
