package bi;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public class g implements Set {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Set f857a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Set f858b = new HashSet();

    public g(Set set) {
        this.f857a = set;
    }

    public Set a() {
        return this.f857a;
    }

    @Override // java.util.Set, java.util.Collection
    public boolean add(Object obj) {
        return this.f858b.add(obj);
    }

    @Override // java.util.Set, java.util.Collection
    public boolean addAll(Collection collection) {
        return this.f858b.addAll(collection);
    }

    @Override // java.util.Set, java.util.Collection
    public void clear() {
        this.f858b.clear();
    }

    @Override // java.util.Set, java.util.Collection
    public boolean contains(Object obj) {
        return this.f858b.contains(obj) || this.f857a.contains(obj);
    }

    @Override // java.util.Set, java.util.Collection
    public boolean containsAll(Collection collection) {
        return this.f858b.containsAll(collection) || this.f857a.containsAll(collection);
    }

    @Override // java.util.Set, java.util.Collection
    public boolean isEmpty() {
        return this.f858b.isEmpty() && this.f857a.isEmpty();
    }

    @Override // java.util.Set, java.util.Collection, java.lang.Iterable
    public Iterator iterator() {
        return new f(this.f858b, this.f857a);
    }

    @Override // java.util.Set, java.util.Collection
    public boolean remove(Object obj) {
        return this.f858b.remove(obj);
    }

    @Override // java.util.Set, java.util.Collection
    public boolean removeAll(Collection collection) {
        return this.f858b.removeAll(collection);
    }

    @Override // java.util.Set, java.util.Collection
    public boolean retainAll(Collection collection) {
        return this.f858b.retainAll(collection);
    }

    @Override // java.util.Set, java.util.Collection
    public int size() {
        return this.f857a.size() + this.f858b.size();
    }

    @Override // java.util.Set, java.util.Collection
    public Object[] toArray() {
        Object[] array = this.f858b.toArray();
        Object[] array2 = this.f857a.toArray();
        Object[] objArr = new Object[array.length + array2.length];
        System.arraycopy(array, 0, objArr, 0, array.length);
        System.arraycopy(array2, 0, objArr, array.length, array2.length);
        return objArr;
    }

    @Override // java.util.Set, java.util.Collection
    public Object[] toArray(Object[] objArr) {
        throw new IllegalStateException("Not implemeneted");
    }
}
