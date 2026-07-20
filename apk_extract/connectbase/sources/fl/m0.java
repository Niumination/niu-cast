package fl;

import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class m0<Key, Value> implements Map.Entry<Key, Value>, ln.g.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Key f6065a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Value f6066b;

    public m0(Key key, Value value) {
        this.f6065a = key;
        this.f6066b = value;
    }

    public void a(Value value) {
        this.f6066b = value;
    }

    @Override // java.util.Map.Entry
    public boolean equals(@os.m Object obj) {
        if (obj == null || !(obj instanceof Map.Entry)) {
            return false;
        }
        Map.Entry entry = (Map.Entry) obj;
        return kn.l0.g(entry.getKey(), this.f6065a) && kn.l0.g(entry.getValue(), this.f6066b);
    }

    @Override // java.util.Map.Entry
    public Key getKey() {
        return this.f6065a;
    }

    @Override // java.util.Map.Entry
    public Value getValue() {
        return this.f6066b;
    }

    @Override // java.util.Map.Entry
    public int hashCode() {
        Key key = this.f6065a;
        kn.l0.m(key);
        int iHashCode = key.hashCode() + 527;
        Value value = this.f6066b;
        kn.l0.m(value);
        return value.hashCode() + iHashCode;
    }

    @Override // java.util.Map.Entry
    public Value setValue(Value value) {
        this.f6066b = value;
        return value;
    }

    @os.l
    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(this.f6065a);
        sb2.append(h.f6043c);
        sb2.append(this.f6066b);
        return sb2.toString();
    }
}
