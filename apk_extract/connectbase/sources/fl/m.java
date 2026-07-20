package fl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class m {
    /* JADX WARN: Code duplicated, block: B:140:0x0059 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:141:0x0034 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:142:? A[LOOP:7: B:21:0x0046->B:142:?, LOOP_END, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:20:0x0042  */
    /* JADX WARN: Code duplicated, block: B:23:0x004c  */
    /* JADX WARN: Multi-variable type inference failed */
    @os.l
    public static final List<ik.d> a(@os.l List<? extends ik.d> list) {
        ik.d.EnumC0216d enumC0216d;
        ik.d.EnumC0216d enumC0216d2;
        Object next;
        Object next2;
        Object next3;
        Object next4;
        boolean z10;
        boolean z11;
        Iterator it;
        ik.d.EnumC0216d enumC0216d3;
        kn.l0.p(list, "<this>");
        if (list.size() < 2) {
            return list;
        }
        List<? extends ik.d> list2 = list;
        boolean z12 = list2 instanceof Collection;
        if (z12 && list2.isEmpty()) {
            if (z12) {
                it = list2.iterator();
                while (true) {
                    if (it.hasNext()) {
                        enumC0216d3 = ((ik.d) it.next()).f7946a;
                        enumC0216d = ik.d.EnumC0216d.Public;
                        if (enumC0216d3 == enumC0216d) {
                            enumC0216d2 = enumC0216d;
                        }
                    }
                }
            } else {
                it = list2.iterator();
                while (true) {
                    if (it.hasNext()) {
                        enumC0216d3 = ((ik.d) it.next()).f7946a;
                        enumC0216d = ik.d.EnumC0216d.Public;
                        if (enumC0216d3 == enumC0216d) {
                            enumC0216d2 = enumC0216d;
                        }
                    }
                }
            }
            enumC0216d2 = null;
        } else {
            Iterator it2 = list2.iterator();
            while (true) {
                if (it2.hasNext()) {
                    ik.d.EnumC0216d enumC0216d4 = ((ik.d) it2.next()).f7946a;
                    enumC0216d = ik.d.EnumC0216d.Private;
                    if (enumC0216d4 == enumC0216d) {
                    }
                } else {
                    if (z12 || !list2.isEmpty()) {
                        it = list2.iterator();
                        while (true) {
                            if (it.hasNext()) {
                                enumC0216d3 = ((ik.d) it.next()).f7946a;
                                enumC0216d = ik.d.EnumC0216d.Public;
                                if (enumC0216d3 == enumC0216d) {
                                }
                            }
                        }
                    }
                    enumC0216d2 = null;
                }
                enumC0216d2 = enumC0216d;
            }
        }
        Iterator it3 = list2.iterator();
        do {
            if (!it3.hasNext()) {
                next = null;
                break;
            }
            next = it3.next();
        } while (!(((ik.d) next) instanceof ik.d.b));
        ik.d.b bVar = (ik.d.b) next;
        Iterator it4 = list2.iterator();
        do {
            if (!it4.hasNext()) {
                next2 = null;
                break;
            }
            next2 = it4.next();
        } while (!(((ik.d) next2) instanceof ik.d.c));
        ik.d.c cVar = (ik.d.c) next2;
        ArrayList arrayList = new ArrayList();
        for (Object obj : list2) {
            if (obj instanceof ik.d.a) {
                arrayList.add(obj);
            }
        }
        Iterator it5 = arrayList.iterator();
        if (it5.hasNext()) {
            next3 = it5.next();
            if (it5.hasNext()) {
                int i10 = ((ik.d.a) next3).f7947b;
                do {
                    Object next5 = it5.next();
                    int i11 = ((ik.d.a) next5).f7947b;
                    if (i10 > i11) {
                        next3 = next5;
                        i10 = i11;
                    }
                } while (it5.hasNext());
            }
        } else {
            next3 = null;
        }
        ik.d.a aVar = (ik.d.a) next3;
        Integer numValueOf = aVar == null ? null : Integer.valueOf(aVar.f7947b);
        Iterator it6 = arrayList.iterator();
        if (it6.hasNext()) {
            next4 = it6.next();
            if (it6.hasNext()) {
                Integer num = ((ik.d.a) next4).f7948c;
                int iIntValue = num == null ? Integer.MAX_VALUE : num.intValue();
                do {
                    Object next6 = it6.next();
                    Integer num2 = ((ik.d.a) next6).f7948c;
                    int iIntValue2 = num2 == null ? Integer.MAX_VALUE : num2.intValue();
                    if (iIntValue > iIntValue2) {
                        next4 = next6;
                        iIntValue = iIntValue2;
                    }
                } while (it6.hasNext());
            }
        } else {
            next4 = null;
        }
        ik.d.a aVar2 = (ik.d.a) next4;
        Integer num3 = aVar2 == null ? null : aVar2.f7948c;
        if (arrayList.isEmpty()) {
            z10 = false;
            break;
        }
        Iterator it7 = arrayList.iterator();
        while (true) {
            if (!it7.hasNext()) {
                z10 = false;
                break;
            }
            if (((ik.d.a) it7.next()).f7949d) {
                z10 = true;
                break;
            }
        }
        if (arrayList.isEmpty()) {
            z11 = false;
            break;
        }
        Iterator it8 = arrayList.iterator();
        while (true) {
            if (!it8.hasNext()) {
                z11 = false;
                break;
            }
            if (((ik.d.a) it8.next()).f7950e) {
                z11 = true;
                break;
            }
        }
        ArrayList arrayList2 = new ArrayList();
        if (bVar != null) {
            arrayList2.add(new ik.d.b(null));
        }
        if (cVar != null) {
            arrayList2.add(new ik.d.c(null));
        }
        if (!arrayList.isEmpty()) {
            kn.l0.m(numValueOf);
            arrayList2.add(new ik.d.a(numValueOf.intValue(), num3, z10, z11, enumC0216d2));
        } else if (bVar != null) {
            arrayList2.set(0, new ik.d.b(enumC0216d2));
        } else if (cVar != null) {
            arrayList2.set(0, new ik.d.c(enumC0216d2));
        }
        return arrayList2;
    }
}
