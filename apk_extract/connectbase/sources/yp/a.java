package yp;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes3.dex */
public final class a extends ArrayList<n> implements m {
    public a(int i10) {
        super(i10);
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ boolean contains(Object obj) {
        if (obj instanceof n) {
            return contains((n) obj);
        }
        return false;
    }

    public /* bridge */ int getSize() {
        return super.size();
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
    public final /* bridge */ int indexOf(Object obj) {
        if (obj instanceof n) {
            return indexOf((n) obj);
        }
        return -1;
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
    public final /* bridge */ int lastIndexOf(Object obj) {
        if (obj instanceof n) {
            return lastIndexOf((n) obj);
        }
        return -1;
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ boolean remove(Object obj) {
        if (obj instanceof n) {
            return remove((n) obj);
        }
        return false;
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ int size() {
        return getSize();
    }

    public /* bridge */ boolean contains(n nVar) {
        return super.contains((Object) nVar);
    }

    public /* bridge */ int indexOf(n nVar) {
        return super.indexOf((Object) nVar);
    }

    public /* bridge */ int lastIndexOf(n nVar) {
        return super.lastIndexOf((Object) nVar);
    }

    public /* bridge */ boolean remove(n nVar) {
        return super.remove((Object) nVar);
    }
}
