package i4;

import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class u1 extends s1 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final transient w1 f5700c;

    public u1(w1 w1Var) {
        this.f5700c = w1Var;
    }

    @Override // i4.a0, java.util.AbstractCollection, java.util.Collection
    public boolean contains(Object obj) {
        if (!(obj instanceof Map.Entry)) {
            return false;
        }
        Map.Entry entry = (Map.Entry) obj;
        return this.f5700c.containsEntry(entry.getKey(), entry.getValue());
    }

    @Override // i4.a0
    public boolean isPartialView() {
        return false;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public int size() {
        return this.f5700c.size();
    }

    @Override // i4.s1, i4.a0, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public h5 iterator() {
        return this.f5700c.m147entryIterator();
    }
}
