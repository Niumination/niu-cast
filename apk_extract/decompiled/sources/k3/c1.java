package k3;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public abstract class c1 {
    public static se.e a(List from, Function1 length, Function2 charAt) {
        Object obj;
        Intrinsics.checkNotNullParameter(from, "from");
        Intrinsics.checkNotNullParameter(length, "length");
        Intrinsics.checkNotNullParameter(charAt, "charAt");
        List list = from;
        Iterator it = list.iterator();
        if (it.hasNext()) {
            Object next = it.next();
            if (it.hasNext()) {
                Comparable comparable = (Comparable) length.invoke(next);
                do {
                    Object next2 = it.next();
                    Comparable comparable2 = (Comparable) length.invoke(next2);
                    if (comparable.compareTo(comparable2) < 0) {
                        next = next2;
                        comparable = comparable2;
                    }
                } while (it.hasNext());
            }
            obj = next;
        } else {
            obj = null;
        }
        if (obj == null) {
            throw new NoSuchElementException("Unable to build char tree from an empty list");
        }
        int iIntValue = ((Number) length.invoke(obj)).intValue();
        if (!(list instanceof Collection) || !list.isEmpty()) {
            Iterator it2 = list.iterator();
            while (it2.hasNext()) {
                if (((Number) length.invoke(it2.next())).intValue() == 0) {
                    throw new IllegalArgumentException("There should be no empty entries");
                }
            }
        }
        ArrayList arrayList = new ArrayList();
        b(arrayList, from, iIntValue, 0, length, charAt);
        arrayList.trimToSize();
        return new se.e(new bg.a((char) 0, CollectionsKt.emptyList(), arrayList));
    }

    public static void b(ArrayList arrayList, List list, int i8, int i9, Function1 function1, Function2 function2) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Object obj : list) {
            Character ch2 = (Character) function2.invoke(obj, Integer.valueOf(i9));
            ch2.getClass();
            Object arrayList2 = linkedHashMap.get(ch2);
            if (arrayList2 == null) {
                arrayList2 = new ArrayList();
                linkedHashMap.put(ch2, arrayList2);
            }
            ((List) arrayList2).add(obj);
        }
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            char cCharValue = ((Character) entry.getKey()).charValue();
            List list2 = (List) entry.getValue();
            int i10 = i9 + 1;
            ArrayList arrayList3 = new ArrayList();
            List list3 = list2;
            ArrayList arrayList4 = new ArrayList();
            for (Object obj2 : list3) {
                if (((Number) function1.invoke(obj2)).intValue() > i10) {
                    arrayList4.add(obj2);
                }
            }
            b(arrayList3, arrayList4, i8, i10, function1, function2);
            arrayList3.trimToSize();
            ArrayList arrayList5 = new ArrayList();
            for (Object obj3 : list3) {
                if (((Number) function1.invoke(obj3)).intValue() == i10) {
                    arrayList5.add(obj3);
                }
            }
            arrayList.add(new bg.a(cCharValue, arrayList5, arrayList3));
        }
    }
}
