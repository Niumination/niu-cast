package fl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public class g0<From, To> implements Set<To>, ln.h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public final Set<From> f6032a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.l
    public final jn.l<From, To> f6033b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @os.l
    public final jn.l<To, From> f6034c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f6035d;

    public static final class a implements Iterator<To>, ln.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @os.l
        public final Iterator<From> f6036a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ g0<From, To> f6037b;

        public a(g0<From, To> g0Var) {
            this.f6037b = g0Var;
            this.f6036a = g0Var.f6032a.iterator();
        }

        @os.l
        public final Iterator<From> a() {
            return this.f6036a;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f6036a.hasNext();
        }

        @Override // java.util.Iterator
        public To next() {
            return (To) this.f6037b.f6033b.invoke(this.f6036a.next());
        }

        @Override // java.util.Iterator
        public void remove() {
            this.f6036a.remove();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public g0(@os.l Set<From> set, @os.l jn.l<? super From, ? extends To> lVar, @os.l jn.l<? super To, ? extends From> lVar2) {
        kn.l0.p(set, "delegate");
        kn.l0.p(lVar, "convertTo");
        kn.l0.p(lVar2, "convert");
        this.f6032a = set;
        this.f6033b = lVar;
        this.f6034c = lVar2;
        this.f6035d = set.size();
    }

    @Override // java.util.Set, java.util.Collection
    public boolean add(To to2) {
        return this.f6032a.add(this.f6034c.invoke(to2));
    }

    @Override // java.util.Set, java.util.Collection
    public boolean addAll(@os.l Collection<? extends To> collection) {
        kn.l0.p(collection, "elements");
        return this.f6032a.addAll(e(collection));
    }

    @Override // java.util.Set, java.util.Collection
    public void clear() {
        this.f6032a.clear();
    }

    @Override // java.util.Set, java.util.Collection
    public boolean contains(Object obj) {
        return this.f6032a.contains(this.f6034c.invoke(obj));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Set, java.util.Collection
    public boolean containsAll(@os.l Collection<? extends Object> collection) {
        kn.l0.p(collection, "elements");
        return this.f6032a.containsAll(e(collection));
    }

    @os.l
    public Collection<From> e(@os.l Collection<? extends To> collection) {
        kn.l0.p(collection, "<this>");
        Collection<? extends To> collection2 = collection;
        ArrayList arrayList = new ArrayList(nm.z.b0(collection2, 10));
        Iterator<T> it = collection2.iterator();
        while (it.hasNext()) {
            arrayList.add(this.f6034c.invoke((To) it.next()));
        }
        return arrayList;
    }

    @Override // java.util.Set, java.util.Collection
    public boolean equals(@os.m Object obj) {
        if (obj == null || !(obj instanceof Set)) {
            return false;
        }
        Collection<To> collectionF = f(this.f6032a);
        return ((Set) obj).containsAll(collectionF) && collectionF.containsAll((Collection) obj);
    }

    @os.l
    public Collection<To> f(@os.l Collection<? extends From> collection) {
        kn.l0.p(collection, "<this>");
        Collection<? extends From> collection2 = collection;
        ArrayList arrayList = new ArrayList(nm.z.b0(collection2, 10));
        Iterator<T> it = collection2.iterator();
        while (it.hasNext()) {
            arrayList.add(this.f6033b.invoke((From) it.next()));
        }
        return arrayList;
    }

    public int g() {
        return this.f6035d;
    }

    @Override // java.util.Set, java.util.Collection
    public int hashCode() {
        return this.f6032a.hashCode();
    }

    @Override // java.util.Set, java.util.Collection
    public boolean isEmpty() {
        return this.f6032a.isEmpty();
    }

    @Override // java.util.Set, java.util.Collection, java.lang.Iterable
    @os.l
    public Iterator<To> iterator() {
        return new a(this);
    }

    @Override // java.util.Set, java.util.Collection
    public boolean remove(Object obj) {
        return this.f6032a.remove(this.f6034c.invoke(obj));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Set, java.util.Collection
    public boolean removeAll(@os.l Collection<? extends Object> collection) {
        kn.l0.p(collection, "elements");
        return this.f6032a.removeAll(e(collection));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Set, java.util.Collection
    public boolean retainAll(@os.l Collection<? extends Object> collection) {
        kn.l0.p(collection, "elements");
        return this.f6032a.retainAll(e(collection));
    }

    @Override // java.util.Set, java.util.Collection
    public final /* bridge */ int size() {
        return g();
    }

    @Override // java.util.Set, java.util.Collection
    public Object[] toArray() {
        return kn.v.a(this);
    }

    @os.l
    public String toString() {
        return f(this.f6032a).toString();
    }

    @Override // java.util.Set, java.util.Collection
    public <T> T[] toArray(T[] tArr) {
        kn.l0.p(tArr, dc.d.f3685p);
        return (T[]) kn.v.b(this, tArr);
    }
}
