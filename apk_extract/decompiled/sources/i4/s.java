package i4;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import k3.h9;

/* JADX INFO: loaded from: classes.dex */
public final class s extends o4 implements Serializable {
    private static final long serialVersionUID = 0;
    final Comparator<Object>[] comparators;

    public s(Comparator<Object> comparator, Comparator<Object> comparator2) {
        this.comparators = new Comparator[]{comparator, comparator2};
    }

    @Override // java.util.Comparator
    public int compare(Object obj, Object obj2) {
        int i8 = 0;
        while (true) {
            Comparator<Object>[] comparatorArr = this.comparators;
            if (i8 >= comparatorArr.length) {
                return 0;
            }
            int iCompare = comparatorArr[i8].compare(obj, obj2);
            if (iCompare != 0) {
                return iCompare;
            }
            i8++;
        }
    }

    @Override // java.util.Comparator
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof s) {
            return Arrays.equals(this.comparators, ((s) obj).comparators);
        }
        return false;
    }

    public int hashCode() {
        return Arrays.hashCode(this.comparators);
    }

    public String toString() {
        return h0.a.n(new StringBuilder("Ordering.compound("), Arrays.toString(this.comparators), ")");
    }

    public s(Iterable<? extends Comparator<Object>> iterable) {
        Collection collection;
        Comparator[] comparatorArr = new Comparator[0];
        if (iterable instanceof Collection) {
            collection = (Collection) iterable;
        } else {
            Iterator<? extends Comparator<Object>> it = iterable.iterator();
            ArrayList arrayList = new ArrayList();
            h9.a(arrayList, it);
            collection = arrayList;
        }
        this.comparators = (Comparator[]) collection.toArray(comparatorArr);
    }
}
