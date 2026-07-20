package i4;

import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public final class f extends r2 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f5582b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ g f5583c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ f(g gVar, int i8) {
        super(1);
        this.f5582b = i8;
        this.f5583c = gVar;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final void clear() {
        switch (this.f5582b) {
            case 0:
                ((d) this.f5583c).clear();
                break;
            default:
                ((d) this.f5583c).clear();
                break;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean contains(Object obj) {
        switch (this.f5582b) {
            case 0:
                return this.f5583c.contains(obj);
            default:
                if (!(obj instanceof b4)) {
                    return false;
                }
                b4 b4Var = (b4) obj;
                if (b4Var.getCount() <= 0) {
                    return false;
                }
                return ((d) this.f5583c).count(b4Var.getElement()) == b4Var.getCount();
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean containsAll(Collection collection) {
        switch (this.f5582b) {
            case 0:
                return this.f5583c.containsAll(collection);
            default:
                return super.containsAll(collection);
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean isEmpty() {
        switch (this.f5582b) {
            case 0:
                return this.f5583c.isEmpty();
            default:
                return super.isEmpty();
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final Iterator iterator() {
        switch (this.f5582b) {
            case 0:
                return this.f5583c.elementIterator();
            default:
                return this.f5583c.entryIterator();
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean remove(Object obj) {
        switch (this.f5582b) {
            case 0:
                return ((d) this.f5583c).remove(obj, Integer.MAX_VALUE) > 0;
            default:
                if (!(obj instanceof b4)) {
                    return false;
                }
                b4 b4Var = (b4) obj;
                Object element = b4Var.getElement();
                int count = b4Var.getCount();
                if (count != 0) {
                    return ((d) this.f5583c).setCount(element, count, 0);
                }
                return false;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        switch (this.f5582b) {
            case 0:
                return this.f5583c.entrySet().size();
            default:
                return this.f5583c.distinctElements();
        }
    }
}
