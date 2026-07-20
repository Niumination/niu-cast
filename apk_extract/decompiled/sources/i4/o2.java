package i4;

import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class o2 extends r2 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f5667b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ u3 f5668c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ o2(u3 u3Var, int i8) {
        super(0);
        this.f5667b = i8;
        this.f5668c = u3Var;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final void clear() {
        switch (this.f5667b) {
            case 0:
                this.f5668c.clear();
                break;
            default:
                this.f5668c.clear();
                break;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean contains(Object obj) {
        Map.Entry entry;
        Object key;
        u3 u3Var;
        Object obj2;
        switch (this.f5667b) {
            case 0:
                return (obj instanceof Map.Entry) && (key = (entry = (Map.Entry) obj).getKey()) != null && (obj2 = (u3Var = this.f5668c).get(key)) != null && u3Var.valueEquivalence().equivalent(entry.getValue(), obj2);
            default:
                return this.f5668c.containsKey(obj);
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean isEmpty() {
        switch (this.f5667b) {
            case 0:
                break;
        }
        return this.f5668c.isEmpty();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final Iterator iterator() {
        switch (this.f5667b) {
            case 0:
                return new n2(this.f5668c, 0);
            default:
                return new n2(this.f5668c, 1);
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean remove(Object obj) {
        Map.Entry entry;
        Object key;
        switch (this.f5667b) {
            case 0:
                return (obj instanceof Map.Entry) && (key = (entry = (Map.Entry) obj).getKey()) != null && this.f5668c.remove(key, entry.getValue());
            default:
                return this.f5668c.remove(obj) != null;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        switch (this.f5667b) {
            case 0:
                break;
        }
        return this.f5668c.size();
    }
}
