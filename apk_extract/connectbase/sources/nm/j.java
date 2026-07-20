package nm;

import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: loaded from: classes3.dex */
@kn.r1({"SMAP\nCollections.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Collections.kt\nkotlin/collections/ArrayAsCollection\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,522:1\n1726#2,3:523\n*S KotlinDebug\n*F\n+ 1 Collections.kt\nkotlin/collections/ArrayAsCollection\n*L\n62#1:523,3\n*E\n"})
public final class j<T> implements Collection<T>, ln.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public final T[] f11636a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f11637b;

    public j(@os.l T[] tArr, boolean z10) {
        kn.l0.p(tArr, "values");
        this.f11636a = tArr;
        this.f11637b = z10;
    }

    public int a() {
        return this.f11636a.length;
    }

    @Override // java.util.Collection
    public boolean add(T t10) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean addAll(Collection<? extends T> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @os.l
    public final T[] c() {
        return this.f11636a;
    }

    @Override // java.util.Collection
    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean contains(Object obj) {
        return r.s8(this.f11636a, obj);
    }

    @Override // java.util.Collection
    public boolean containsAll(@os.l Collection<? extends Object> collection) {
        kn.l0.p(collection, "elements");
        Collection<? extends Object> collection2 = collection;
        if (collection2.isEmpty()) {
            return true;
        }
        Iterator<T> it = collection2.iterator();
        while (it.hasNext()) {
            if (!r.s8(this.f11636a, it.next())) {
                return false;
            }
        }
        return true;
    }

    public final boolean e() {
        return this.f11637b;
    }

    @Override // java.util.Collection
    public boolean isEmpty() {
        return this.f11636a.length == 0;
    }

    @Override // java.util.Collection, java.lang.Iterable
    @os.l
    public Iterator<T> iterator() {
        return kn.i.a(this.f11636a);
    }

    @Override // java.util.Collection
    public boolean remove(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean removeAll(Collection<? extends Object> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean retainAll(Collection<? extends Object> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public final int size() {
        return this.f11636a.length;
    }

    @Override // java.util.Collection
    public <T> T[] toArray(T[] tArr) {
        kn.l0.p(tArr, dc.d.f3685p);
        return (T[]) kn.v.b(this, tArr);
    }

    @Override // java.util.Collection
    @os.l
    public final Object[] toArray() {
        return x.h(this.f11636a, this.f11637b);
    }
}
