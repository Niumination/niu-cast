package k3;

import java.util.Collection;
import java.util.List;
import java.util.ListIterator;

/* JADX INFO: loaded from: classes.dex */
public class o extends m implements List {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final /* synthetic */ p f6554h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o(p pVar, Object obj, List list, m mVar) {
        super(pVar, obj, list, mVar);
        this.f6554h = pVar;
    }

    @Override // java.util.List
    public final void add(int i8, Object obj) {
        f();
        boolean zIsEmpty = this.f6531b.isEmpty();
        ((List) this.f6531b).add(i8, obj);
        this.f6554h.e++;
        if (zIsEmpty) {
            e();
        }
    }

    @Override // java.util.List
    public final boolean addAll(int i8, Collection collection) {
        if (collection.isEmpty()) {
            return false;
        }
        int size = size();
        boolean zAddAll = ((List) this.f6531b).addAll(i8, collection);
        if (zAddAll) {
            int size2 = this.f6531b.size();
            p pVar = this.f6554h;
            pVar.e = (size2 - size) + pVar.e;
            if (size == 0) {
                e();
                return true;
            }
        }
        return zAddAll;
    }

    @Override // java.util.List
    public final Object get(int i8) {
        f();
        return ((List) this.f6531b).get(i8);
    }

    @Override // java.util.List
    public final int indexOf(Object obj) {
        f();
        return ((List) this.f6531b).indexOf(obj);
    }

    @Override // java.util.List
    public final int lastIndexOf(Object obj) {
        f();
        return ((List) this.f6531b).lastIndexOf(obj);
    }

    @Override // java.util.List
    public final ListIterator listIterator() {
        f();
        return new n(this);
    }

    @Override // java.util.List
    public final Object remove(int i8) {
        f();
        Object objRemove = ((List) this.f6531b).remove(i8);
        this.f6554h.e--;
        g();
        return objRemove;
    }

    @Override // java.util.List
    public final Object set(int i8, Object obj) {
        f();
        return ((List) this.f6531b).set(i8, obj);
    }

    @Override // java.util.List
    public final List subList(int i8, int i9) {
        f();
        List listSubList = ((List) this.f6531b).subList(i8, i9);
        m mVar = this.f6532c;
        if (mVar == null) {
            mVar = this;
        }
        return this.f6554h.zzm(this.f6530a, listSubList, mVar);
    }

    @Override // java.util.List
    public final ListIterator listIterator(int i8) {
        f();
        return new n(this, i8);
    }
}
