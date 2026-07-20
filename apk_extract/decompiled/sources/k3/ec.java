package k3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public abstract class ec {
    public static void a(ArrayList arrayList) {
        HashMap map = new HashMap(arrayList.size());
        Iterator it = arrayList.iterator();
        while (true) {
            int i8 = 0;
            if (!it.hasNext()) {
                Iterator it2 = map.values().iterator();
                while (it2.hasNext()) {
                    for (o4.h hVar : (Set) it2.next()) {
                        for (o4.j jVar : hVar.f8383a.f8371b) {
                            if (jVar.f8390c == 0) {
                                Set<o4.h> set = (Set) map.get(new o4.i(jVar.f8388a, jVar.f8389b == 2));
                                if (set != null) {
                                    for (o4.h hVar2 : set) {
                                        hVar.f8384b.add(hVar2);
                                        hVar2.f8385c.add(hVar);
                                    }
                                }
                            }
                        }
                    }
                }
                HashSet<o4.h> hashSet = new HashSet();
                Iterator it3 = map.values().iterator();
                while (it3.hasNext()) {
                    hashSet.addAll((Set) it3.next());
                }
                HashSet hashSet2 = new HashSet();
                for (o4.h hVar3 : hashSet) {
                    if (hVar3.f8385c.isEmpty()) {
                        hashSet2.add(hVar3);
                    }
                }
                while (!hashSet2.isEmpty()) {
                    o4.h hVar4 = (o4.h) hashSet2.iterator().next();
                    hashSet2.remove(hVar4);
                    i8++;
                    for (o4.h hVar5 : hVar4.f8384b) {
                        hVar5.f8385c.remove(hVar4);
                        if (hVar5.f8385c.isEmpty()) {
                            hashSet2.add(hVar5);
                        }
                    }
                }
                if (i8 == arrayList.size()) {
                    return;
                }
                ArrayList arrayList2 = new ArrayList();
                for (o4.h hVar6 : hashSet) {
                    if (!hVar6.f8385c.isEmpty() && !hVar6.f8384b.isEmpty()) {
                        arrayList2.add(hVar6.f8383a);
                    }
                }
                throw new o4.k(arrayList2);
            }
            o4.b bVar = (o4.b) it.next();
            o4.h hVar7 = new o4.h(bVar);
            for (Class cls : bVar.f8370a) {
                boolean z2 = bVar.f8372c == 0;
                o4.i iVar = new o4.i(cls, !z2);
                if (!map.containsKey(iVar)) {
                    map.put(iVar, new HashSet());
                }
                Set set2 = (Set) map.get(iVar);
                if (!set2.isEmpty() && z2) {
                    throw new IllegalArgumentException("Multiple components provide " + cls + ".");
                }
                set2.add(hVar7);
            }
        }
    }
}
