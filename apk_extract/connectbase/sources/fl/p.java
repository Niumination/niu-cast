package fl;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
@t0
public final class p implements Set<String>, ln.h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public final o<Boolean> f6085a;

    public p() {
        this.f6085a = new o<>();
    }

    @Override // java.util.Set, java.util.Collection
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public boolean add(@os.l String str) {
        kn.l0.p(str, "element");
        if (this.f6085a.containsKey(str)) {
            return false;
        }
        this.f6085a.put(str, Boolean.TRUE);
        return true;
    }

    @Override // java.util.Set, java.util.Collection
    public boolean addAll(@os.l Collection<? extends String> collection) {
        kn.l0.p(collection, "elements");
        Iterator<? extends String> it = collection.iterator();
        boolean z10 = false;
        while (it.hasNext()) {
            if (add(it.next())) {
                z10 = true;
            }
        }
        return z10;
    }

    public boolean c(@os.l String str) {
        kn.l0.p(str, "element");
        return this.f6085a.containsKey(str);
    }

    @Override // java.util.Set, java.util.Collection
    public void clear() {
        this.f6085a.clear();
    }

    @Override // java.util.Set, java.util.Collection
    public final /* bridge */ boolean contains(Object obj) {
        if (obj instanceof String) {
            return c((String) obj);
        }
        return false;
    }

    @Override // java.util.Set, java.util.Collection
    public boolean containsAll(@os.l Collection<? extends Object> collection) {
        kn.l0.p(collection, "elements");
        return this.f6085a.f().containsAll(collection);
    }

    public int e() {
        return this.f6085a.f6075a.size();
    }

    public boolean f(@os.l String str) {
        kn.l0.p(str, "element");
        return kn.l0.g(this.f6085a.remove(str), Boolean.TRUE);
    }

    @Override // java.util.Set, java.util.Collection
    public boolean isEmpty() {
        return this.f6085a.f6075a.isEmpty();
    }

    @Override // java.util.Set, java.util.Collection, java.lang.Iterable
    @os.l
    public Iterator<String> iterator() {
        return this.f6085a.f().iterator();
    }

    @Override // java.util.Set, java.util.Collection
    public final /* bridge */ boolean remove(Object obj) {
        if (obj instanceof String) {
            return f((String) obj);
        }
        return false;
    }

    @Override // java.util.Set, java.util.Collection
    public boolean removeAll(@os.l Collection<? extends Object> collection) {
        kn.l0.p(collection, "elements");
        return this.f6085a.f().removeAll(collection);
    }

    @Override // java.util.Set, java.util.Collection
    public boolean retainAll(@os.l Collection<? extends Object> collection) {
        kn.l0.p(collection, "elements");
        return this.f6085a.f().retainAll(collection);
    }

    @Override // java.util.Set, java.util.Collection
    public final /* bridge */ int size() {
        return e();
    }

    @Override // java.util.Set, java.util.Collection
    public Object[] toArray() {
        return kn.v.a(this);
    }

    @Override // java.util.Set, java.util.Collection
    public <T> T[] toArray(T[] tArr) {
        kn.l0.p(tArr, dc.d.f3685p);
        return (T[]) kn.v.b(this, tArr);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public p(@os.l Iterable<String> iterable) {
        this();
        kn.l0.p(iterable, "initial");
        nm.d0.r0(this, iterable);
    }
}
