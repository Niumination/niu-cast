package i4;

import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class t3 extends e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f5695a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Object f5696b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ u3 f5697c;

    public t3(u3 u3Var, Object obj, Object obj2) {
        this.f5697c = u3Var;
        this.f5695a = obj;
        this.f5696b = obj2;
    }

    @Override // i4.e, java.util.Map.Entry
    public final boolean equals(Object obj) {
        if (!(obj instanceof Map.Entry)) {
            return false;
        }
        Map.Entry entry = (Map.Entry) obj;
        return this.f5695a.equals(entry.getKey()) && this.f5696b.equals(entry.getValue());
    }

    @Override // java.util.Map.Entry
    public final Object getKey() {
        return this.f5695a;
    }

    @Override // java.util.Map.Entry
    public final Object getValue() {
        return this.f5696b;
    }

    @Override // i4.e, java.util.Map.Entry
    public final int hashCode() {
        return this.f5696b.hashCode() ^ this.f5695a.hashCode();
    }

    @Override // i4.e, java.util.Map.Entry
    public final Object setValue(Object obj) {
        Object objPut = this.f5697c.put(this.f5695a, obj);
        this.f5696b = obj;
        return objPut;
    }
}
