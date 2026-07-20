package nm;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
@lm.f1(version = "1.1")
public abstract class i<E> extends nm.a<E> implements Set<E>, ln.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public static final a f11633a = new a();

    public static final class a {
        public a() {
        }

        public final boolean a(@os.l Set<?> set, @os.l Set<?> set2) {
            kn.l0.p(set, "c");
            kn.l0.p(set2, "other");
            if (set.size() != set2.size()) {
                return false;
            }
            return set.containsAll(set2);
        }

        public final int b(@os.l Collection<?> collection) {
            kn.l0.p(collection, "c");
            Iterator<?> it = collection.iterator();
            int iHashCode = 0;
            while (it.hasNext()) {
                Object next = it.next();
                iHashCode += next != null ? next.hashCode() : 0;
            }
            return iHashCode;
        }

        public a(kn.w wVar) {
        }
    }

    @Override // java.util.Collection, java.util.Set
    public boolean equals(@os.m Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof Set) {
            return f11633a.a(this, (Set) obj);
        }
        return false;
    }

    @Override // java.util.Collection, java.util.Set
    public int hashCode() {
        return f11633a.b(this);
    }

    @Override // nm.a, java.util.Collection, java.lang.Iterable
    public Iterator<E> iterator() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
