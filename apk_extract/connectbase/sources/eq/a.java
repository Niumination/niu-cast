package eq;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import kn.l0;
import nm.h0;
import nm.k0;
import nm.x;
import os.l;
import os.m;

/* JADX INFO: loaded from: classes3.dex */
public final class a {
    public static final <T> void a(@l Collection<T> collection, @m T t10) {
        l0.p(collection, "<this>");
        if (t10 != null) {
            collection.add(t10);
        }
    }

    public static final int b(int i10) {
        if (i10 < 3) {
            return 3;
        }
        return (i10 / 3) + i10 + 1;
    }

    @l
    public static final <T> List<T> c(@l ArrayList<T> arrayList) {
        l0.p(arrayList, "<this>");
        int size = arrayList.size();
        if (size == 0) {
            return k0.INSTANCE;
        }
        if (size == 1) {
            return x.k(h0.B2(arrayList));
        }
        arrayList.trimToSize();
        return arrayList;
    }

    @l
    public static final <K> Map<K, Integer> d(@l Iterable<? extends K> iterable) {
        l0.p(iterable, "<this>");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator<? extends K> it = iterable.iterator();
        int i10 = 0;
        while (it.hasNext()) {
            linkedHashMap.put(it.next(), Integer.valueOf(i10));
            i10++;
        }
        return linkedHashMap;
    }

    @l
    public static final <K, V> HashMap<K, V> e(int i10) {
        return new HashMap<>(b(i10));
    }

    @l
    public static final <E> HashSet<E> f(int i10) {
        return new HashSet<>(b(i10));
    }

    @l
    public static final <E> LinkedHashSet<E> g(int i10) {
        return new LinkedHashSet<>(b(i10));
    }
}
