package k3;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public abstract class sa {
    public static int a(Set set) {
        Iterator it = set.iterator();
        int iHashCode = 0;
        while (it.hasNext()) {
            Object next = it.next();
            iHashCode += next != null ? next.hashCode() : 0;
        }
        return iHashCode;
    }

    public static boolean b(i4.r2 r2Var, Collection collection) {
        collection.getClass();
        if (collection instanceof k0) {
            collection = ((k0) collection).zza();
        }
        boolean zRemove = false;
        if (!(collection instanceof Set) || collection.size() <= r2Var.size()) {
            Iterator it = collection.iterator();
            while (it.hasNext()) {
                zRemove |= r2Var.remove(it.next());
            }
            return zRemove;
        }
        Iterator<E> it2 = r2Var.iterator();
        collection.getClass();
        while (it2.hasNext()) {
            if (collection.contains(it2.next())) {
                it2.remove();
                zRemove = true;
            }
        }
        return zRemove;
    }
}
