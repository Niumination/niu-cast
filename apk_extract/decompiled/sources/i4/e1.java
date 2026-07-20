package i4;

import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class e1 extends a0 {
    private static final long serialVersionUID = 0;
    final j1 multimap;

    public e1(j1 j1Var) {
        this.multimap = j1Var;
    }

    @Override // i4.a0, java.util.AbstractCollection, java.util.Collection
    public boolean contains(Object obj) {
        if (!(obj instanceof Map.Entry)) {
            return false;
        }
        Map.Entry entry = (Map.Entry) obj;
        return this.multimap.containsEntry(entry.getKey(), entry.getValue());
    }

    @Override // i4.a0
    public boolean isPartialView() {
        return this.multimap.isPartialView();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public int size() {
        return this.multimap.size();
    }

    @Override // i4.a0, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public h5 iterator() {
        return this.multimap.m147entryIterator();
    }
}
